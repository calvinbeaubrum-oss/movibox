package com.hisavana.common.bean;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.c;
import com.google.android.gms.common.api.Api;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.utils.AdLogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdCache<T extends ICacheAd> {
    private static final int CODE_SEAT_LIMIT_30 = 30;
    private static final int CODE_SEAT_LIMIT_FIVE = 5;
    private static final int CODE_SEAT_LIMIT_TEN = 10;
    private static final String TAG = "AdCache";
    private static final AdCacheComp mComparator = new AdCacheComp();
    final ConcurrentHashMap<String, CopyOnWriteArrayList<T>> map = new ConcurrentHashMap<>();
    private AdCacheExpiredWatcher watcher;

    /* JADX INFO: compiled from: source.java */
    public static class AdCacheComp implements Comparator<ICacheAd> {
        @Override // java.util.Comparator
        public int compare(ICacheAd iCacheAd, ICacheAd iCacheAd2) {
            try {
                if (iCacheAd.isExpired() && !iCacheAd2.isExpired()) {
                    return 1;
                }
                if (!iCacheAd.isExpired() && iCacheAd2.isExpired()) {
                    return -1;
                }
                if (iCacheAd.getEcpmPrice() != iCacheAd2.getEcpmPrice()) {
                    return iCacheAd.getEcpmPrice() > iCacheAd2.getEcpmPrice() ? -1 : 1;
                }
                if (iCacheAd.getValidTimeLimit() - iCacheAd2.getValidTimeLimit() < 0) {
                    return -1;
                }
                return iCacheAd.getValidTimeLimit() - iCacheAd2.getValidTimeLimit() > 0 ? 1 : 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface AdCacheExpiredWatcher {
        void onExpired(ICacheAd iCacheAd);
    }

    private int getCodeSeatLimit(T t11) {
        return (t11 != null && t11.isIconAd()) ? 30 : 5;
    }

    private double getMaxPrice(String str, T t11, boolean z11) {
        if (str == null) {
            return 0.0d;
        }
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0.0d;
            }
            for (T t12 : copyOnWriteArrayList) {
                if (t12.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(t12);
                    }
                } else if (!z11 || !t12.isMatchVulgarBrand()) {
                    if (t11 == null || t11 != t12) {
                        AdLogUtil.Log().d(TAG, "*----> max ad in pool is :" + t12.getPlacementId() + ",EcpmPrice is :" + t12.getEcpmPrice() + ",AdSource is :" + t12.getAdSource() + ",ValidTimeLimit :" + t12.getValidTimeLimit());
                        return t12.getEcpmPrice();
                    }
                    AdLogUtil.Log().d(c.SECOND_PRICE_TAG, "*----> getMaxPrice updateSecondPrice()，excludeAd == iteratorAd");
                }
                t12.destroyAd();
                copyOnWriteArrayList.remove(t12);
            }
            return 0.0d;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0.0d;
        }
    }

    private CopyOnWriteArrayList<T> getOrCreateList(String str) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList;
        }
        CopyOnWriteArrayList<T> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        this.map.put(str, copyOnWriteArrayList2);
        return copyOnWriteArrayList2;
    }

    private T getSupportAd(String str, int i11, boolean z11) {
        AdLogUtil.Log().d(TAG, "getSupportAd " + str + " hisavanaAdSupportFlag " + i11);
        ArrayList<T> caches = getCaches(str, Api.BaseClientBuilder.API_PRIORITY_OTHER, false, z11);
        if (caches == null) {
            return null;
        }
        for (T t11 : caches) {
            if (t11 != null && isAdConformSupportFlag(t11, i11)) {
                return t11;
            }
        }
        return null;
    }

    private boolean isAdConformSupportFlag(T t11, int i11) {
        if (t11.isOfflineAd()) {
            return false;
        }
        if (i11 == 1) {
            return t11.isAdxAd();
        }
        if (i11 == 2) {
            return t11.isEwAd();
        }
        if (i11 != 3) {
            return false;
        }
        return t11.isAdxAd() || t11.isEwAd();
    }

    private boolean removeAd(CopyOnWriteArrayList<T> copyOnWriteArrayList, T t11, boolean z11) {
        if (z11) {
            AdLogUtil.Log().d(TAG, "---> Remove ad:" + t11.getPlacementId() + " from cache");
            copyOnWriteArrayList.remove(t11);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
            }
        }
        if (!t11.isExpired()) {
            return false;
        }
        if (!z11) {
            copyOnWriteArrayList.remove(t11);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
            }
        }
        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
        if (adCacheExpiredWatcher != null) {
            adCacheExpiredWatcher.onExpired(t11);
        }
        t11.destroyAd();
        return true;
    }

    public void addCache(String str, @NonNull T t11) {
        String str2;
        if (t11 != null) {
            if (LogSwitch.isDebug) {
                str2 = "add Cache list,AdSource is :" + t11.getAdSource();
            } else {
                str2 = null;
            }
            RecordTestInfo.record(str2);
            t11.detachContext();
        }
        CopyOnWriteArrayList<T> orCreateList = getOrCreateList(str);
        if (orCreateList.size() > getCodeSeatLimit(t11)) {
            orCreateList.remove(orCreateList.size() - 1);
        }
        try {
            ArrayList arrayList = new ArrayList(orCreateList);
            int iBinarySearch = Collections.binarySearch(arrayList, t11, mComparator);
            if (iBinarySearch < 0) {
                iBinarySearch = -(iBinarySearch + 1);
            }
            arrayList.add(iBinarySearch, t11);
            orCreateList.clear();
            orCreateList.addAll(arrayList);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("add cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
                RecordTestInfo.record("add Cache list is :" + arrayList.size());
            }
            AdLogUtil.Log().d(TAG, "*----> add Caches list is :" + arrayList.size());
        } catch (Exception e11) {
            AdLogUtil.Log().d(TAG, Log.getStackTraceString(e11));
        }
    }

    public void addCaches(String str, List<T> list) {
        for (T t11 : list) {
            if (t11 != null) {
                if (LogSwitch.isDebug) {
                    RecordTestInfo.record("add Caches list,EcpmPrice is :" + t11.getEcpmPrice());
                }
                t11.detachContext();
            }
        }
        CopyOnWriteArrayList<T> orCreateList = getOrCreateList(str);
        if (list.size() == 0 || orCreateList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(orCreateList);
        int size = (list.size() + arrayList.size()) - getCodeSeatLimit(list.get(0));
        arrayList.addAll(list);
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                int size2 = arrayList.size();
                if (size2 > 0) {
                    arrayList.remove(size2 - 1);
                } else {
                    AdLogUtil.Log().e(TAG, "addCaches,index out of bounds");
                }
            }
        }
        try {
            Collections.sort(arrayList, mComparator);
            orCreateList.clear();
            orCreateList.addAll(arrayList);
            AdLogUtil.Log().d(TAG, "*----> add Caches list is :" + arrayList.size());
            if (LogSwitch.isDebug) {
                RecordTestInfo.record("add Caches list is :" + arrayList.size());
                RecordTestInfo.LogMsg("add caches:" + RecordTestInfo.getLogMsg(list), RecordTestInfo.LOG_CODE10);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public int getAdNum(String str) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0;
            }
            int i11 = 0;
            for (T t11 : copyOnWriteArrayList) {
                if (t11.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(t11);
                    }
                    t11.destroyAd();
                    copyOnWriteArrayList.remove(t11);
                } else {
                    i11++;
                    AdLogUtil.Log().d(TAG, "*----> ad in pool is :" + t11.getPlacementId() + ",EcpmPrice is :" + t11.getEcpmPrice() + ",AdSource is :" + t11.getAdSource() + ",ValidTimeLimit :" + t11.getValidTimeLimit());
                }
            }
            return i11;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0;
        }
    }

    public int getAdNum(String str, int i11, String str2, boolean z11) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0;
            }
            int i12 = 0;
            for (T t11 : copyOnWriteArrayList) {
                if (t11.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(t11);
                    }
                } else if (!z11 || !t11.isMatchVulgarBrand()) {
                    if (t11.getAdSource() == i11 && TextUtils.equals(t11.getPlacementId(), str2)) {
                        i12++;
                    }
                }
                t11.destroyAd();
                copyOnWriteArrayList.remove(t11);
            }
            return i12;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0;
        }
    }

    public T getCache(String str, boolean z11, int i11, boolean z12) {
        ArrayList<T> caches;
        T t11 = (T) getSupportAd(str, i11, z12);
        return (t11 != null || (caches = getCaches(str, 1, z11, z12)) == null || caches.isEmpty()) ? t11 : caches.get(0);
    }

    public ArrayList<T> getCaches(@NonNull String str, int i11, boolean z11, int i12, boolean z12) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            ArrayList<T> arrayList = new ArrayList<>();
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                if (LogSwitch.isDebug) {
                    Iterator<T> it = copyOnWriteArrayList.iterator();
                    AdLogUtil adLogUtilLog = AdLogUtil.Log();
                    String str2 = "current ad pool size is :" + copyOnWriteArrayList.size();
                    while (true) {
                        adLogUtilLog.d(TAG, str2);
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        AdLogUtil adLogUtilLog2 = AdLogUtil.Log();
                        str2 = "ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice() + " isAdx " + next.isAdxAd() + " isEw " + next.isEwAd();
                        adLogUtilLog = adLogUtilLog2;
                    }
                }
                for (T t11 : copyOnWriteArrayList) {
                    if (t11 != null) {
                        if (z12 && t11.isMatchVulgarBrand()) {
                            copyOnWriteArrayList.remove(t11);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
                            }
                            t11.destroyAd();
                        } else {
                            if (isAdConformSupportFlag(t11, i12) && !removeAd(copyOnWriteArrayList, t11, z11)) {
                                arrayList.add(t11);
                            }
                            if (arrayList.size() >= i11) {
                                return arrayList;
                            }
                        }
                    }
                }
                if (arrayList.size() < i11) {
                    arrayList.addAll(getCaches(str, i11 - arrayList.size(), z11, z12));
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return null;
        }
    }

    public ArrayList<T> getCaches(@NonNull String str, int i11, boolean z11, boolean z12) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return new ArrayList<>();
            }
            if (LogSwitch.isDebug) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                AdLogUtil adLogUtilLog = AdLogUtil.Log();
                String str2 = "*----> current ad pool size is :" + copyOnWriteArrayList.size();
                while (true) {
                    adLogUtilLog.d(TAG, str2);
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    AdLogUtil adLogUtilLog2 = AdLogUtil.Log();
                    str2 = "---> ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice() + " source " + next.getAdSource();
                    adLogUtilLog = adLogUtilLog2;
                }
            }
            ArrayList<T> arrayList = null;
            for (T t11 : copyOnWriteArrayList) {
                if (t11 != null) {
                    if (z11) {
                        copyOnWriteArrayList.remove(t11);
                        if (LogSwitch.isDebug) {
                            RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
                        }
                    }
                    if (t11.isExpired()) {
                        if (!z11) {
                            copyOnWriteArrayList.remove(t11);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
                            }
                        }
                        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                        if (adCacheExpiredWatcher != null) {
                            adCacheExpiredWatcher.onExpired(t11);
                        }
                    } else if (!z12 || !t11.isMatchVulgarBrand()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(t11);
                        if (arrayList.size() >= i11) {
                            break;
                        }
                    } else if (!z11) {
                        copyOnWriteArrayList.remove(t11);
                        if (LogSwitch.isDebug) {
                            RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
                        }
                    }
                    t11.destroyAd();
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return null;
        }
    }

    public ArrayList<T> getCaches(@NonNull String str, int i11, boolean z11, boolean z12, int i12, boolean z13) {
        try {
            if (!z12) {
                return getCaches(str, i11, z11, i12, z13);
            }
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return null;
            }
            int adSource = i12 > 0 ? 0 : -1;
            if (LogSwitch.isDebug) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                AdLogUtil adLogUtilLog = AdLogUtil.Log();
                String str2 = "*----> current ad pool size is :" + copyOnWriteArrayList.size();
                while (true) {
                    adLogUtilLog.d(TAG, str2);
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    AdLogUtil adLogUtilLog2 = AdLogUtil.Log();
                    str2 = "---> ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice();
                    adLogUtilLog = adLogUtilLog2;
                }
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<T> arrayList2 = null;
            for (T t11 : copyOnWriteArrayList) {
                if (t11 != null) {
                    if (t11.isExpired()) {
                        copyOnWriteArrayList.remove(t11);
                        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                        if (adCacheExpiredWatcher != null) {
                            adCacheExpiredWatcher.onExpired(t11);
                        }
                        t11.destroyAd();
                    } else if (z13 && t11.isMatchVulgarBrand()) {
                        copyOnWriteArrayList.remove(t11);
                        t11.destroyAd();
                        AdLogUtil.Log().d(TAG, "current ad filter by vulgar content");
                    } else if (adSource == -1 || adSource == t11.getAdSource()) {
                        if (adSource == -1) {
                            adSource = t11.getAdSource();
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        if (!TextUtils.isEmpty(t11.getFilterSource())) {
                            AdLogUtil.Log().d(TAG, "current filter ------->" + t11.getFilterSource());
                            if (!arrayList.contains(t11.getFilterSource())) {
                                arrayList.add(t11.getFilterSource());
                            }
                        }
                        if (z11) {
                            AdLogUtil.Log().d(TAG, "---> Remove ad:" + t11.getPlacementId() + " from cache");
                            copyOnWriteArrayList.remove(t11);
                        }
                        arrayList2.add(t11);
                        if (arrayList2.size() >= i11) {
                            break;
                        }
                    }
                }
            }
            return arrayList2;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return null;
        }
    }

    public double getMaxPrice(String str, boolean z11) {
        return getMaxPrice(str, null, z11);
    }

    public double getNetworkPrice(String str, int i11, String str2) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0.0d;
            }
            for (T t11 : copyOnWriteArrayList) {
                if (t11.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(t11);
                    }
                    t11.destroyAd();
                    copyOnWriteArrayList.remove(t11);
                } else if (t11.getAdSource() == i11 && TextUtils.equals(t11.getPlacementId(), str2)) {
                    return t11.getEcpmPrice();
                }
            }
            return 0.0d;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0.0d;
        }
    }

    public int[] getValidAndInvalidAdNum(String str) {
        int[] iArr = {0, 0};
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null) {
            return iArr;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            if (it.next().isExpired()) {
                i12++;
            } else {
                i11++;
            }
        }
        iArr[0] = i11;
        iArr[1] = i12;
        return iArr;
    }

    public boolean hasAd(String str, T t11) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        return copyOnWriteArrayList.contains(t11);
    }

    public boolean hasAds(String str, boolean z11) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return false;
            }
            for (T t11 : copyOnWriteArrayList) {
                if (t11.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(t11);
                    }
                    t11.destroyAd();
                    copyOnWriteArrayList.remove(t11);
                } else if (!z11 || !t11.isMatchVulgarBrand()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return false;
        }
    }

    public void registerWatcher(AdCacheExpiredWatcher adCacheExpiredWatcher) {
        this.watcher = adCacheExpiredWatcher;
    }

    public void removeAll() {
        this.map.clear();
    }

    public void removeCache(String str, T t11) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        copyOnWriteArrayList.remove(t11);
        AdLogUtil.Log().d(TAG, "---> Remove ad:" + t11.getPlacementId() + " from cache");
        if (LogSwitch.isDebug) {
            RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
        }
    }

    public void removeCodeSeatCache(String str) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            AdLogUtil.Log().d(TAG, "---> clear codeSeat cache : " + str);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("clear codeSeat cache:" + RecordTestInfo.getLogMsg(copyOnWriteArrayList), RecordTestInfo.LOG_CODE10);
            }
        }
    }

    public void unRegisterWatcher() {
        this.watcher = null;
    }
}
