package com.transsion.gslb;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class DomainManager {
    public static final String BLANK_DOMAIN = "blank";
    public static volatile DomainManager INSTANCE;
    public String filePath;
    public long lastSyncTime;
    public String sp_name = "gslb_";
    public String lastGaid = "";
    public String countryCode = "";
    public long firstSyncTryTime = 0;
    public long syncTimes = 0;
    public final long SYNC_TRY_TIMES = 4;
    public final String SEPARATOR = "&";
    public Map<String, String> domainMap = new ConcurrentHashMap();
    public List<ListenerBean> listenerBeans = new ArrayList();
    public long syncInterval = ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;

    public DomainManager() {
        this.sp_name += Utils.getCurProcessName(GslbSdk.getContext());
        this.filePath = GslbSdk.getContext().getFilesDir().getPath() + File.separator + this.sp_name;
        read();
        if (this.domainMap.size() == 0) {
            this.domainMap.put("dsu.shalltry.com", BLANK_DOMAIN);
            this.domainMap.put("dsc.shalltry.com", BLANK_DOMAIN);
            this.domainMap.put("api.twibida.com", BLANK_DOMAIN);
        }
        checkSync();
    }

    private void checkSync() {
        Worker worker;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(this.firstSyncTryTime - jCurrentTimeMillis) > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            this.syncTimes = 0L;
        }
        long j11 = this.lastSyncTime;
        if (j11 <= 0 || Math.abs(jCurrentTimeMillis - j11) <= this.syncInterval) {
            return;
        }
        long j12 = this.syncTimes;
        if (j12 == 0) {
            this.firstSyncTryTime = jCurrentTimeMillis;
        }
        if (j12 < 4 && (worker = GslbSdk.getWorker()) != null) {
            worker.syncData();
        }
        this.syncTimes++;
    }

    public static DomainManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DomainManager.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new DomainManager();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return INSTANCE;
    }

    private boolean isDomain(String str) {
        return (TextUtils.isEmpty(str) || str.equals(BLANK_DOMAIN)) ? false : true;
    }

    private void read() {
        String[] strArrSplit = Utils.bufferRead(new File(this.filePath)).split("&");
        if (strArrSplit.length < 4) {
            return;
        }
        try {
            this.domainMap = Utils.stringToMap(strArrSplit[0]);
            this.lastGaid = strArrSplit[1];
            this.syncInterval = Long.parseLong(strArrSplit[2]);
            this.lastSyncTime = Long.parseLong(strArrSplit[3]);
            this.countryCode = strArrSplit[4];
        } catch (Throwable unused) {
        }
    }

    private void write() {
        Utils.bufferSave(this.filePath, Utils.mapToString(this.domainMap) + "&" + this.lastGaid + "&" + this.syncInterval + "&" + this.lastSyncTime + "&" + this.countryCode);
    }

    public void addListener(ListenerBean listenerBean) {
        GslbSdk.ResultListener resultListener;
        GslbSdk.GetDomainListener getDomainListener;
        GslbSdk.InitListener initListener;
        GslbSdk.GslbInitListener gslbInitListener;
        GslbSdk.InitListener initListener2;
        GslbSdk.GslbInitListener gslbInitListener2;
        if (listenerBean.domains == null) {
            String str = listenerBean.url;
            if (str == null || listenerBean.resultListener == null) {
                return;
            }
            String domain = Utils.getDomain(str);
            String str2 = this.domainMap.get(domain);
            if (!isDomain(str2)) {
                this.listenerBeans.add(listenerBean);
                return;
            }
            boolean z11 = listenerBean.isNewDomainListener;
            if (z11 && (getDomainListener = listenerBean.gslbDomainListener) != null) {
                getDomainListener.onGslbSuccess(listenerBean.url.replace(domain, str2));
                return;
            } else {
                if (z11 || (resultListener = listenerBean.resultListener) == null) {
                    return;
                }
                resultListener.onGslbSuccess(listenerBean.url.replace(domain, str2));
                return;
            }
        }
        int i11 = 0;
        boolean z12 = true;
        boolean z13 = false;
        boolean z14 = false;
        while (true) {
            String[] strArr = listenerBean.domains;
            if (i11 >= strArr.length) {
                break;
            }
            strArr[i11] = Utils.getDomain(strArr[i11]);
            if (!TextUtils.isEmpty(listenerBean.domains[i11])) {
                String str3 = this.domainMap.get(listenerBean.domains[i11]);
                if (str3 == null) {
                    this.domainMap.put(listenerBean.domains[i11], BLANK_DOMAIN);
                    z12 = false;
                    z13 = true;
                } else if (isDomain(str3)) {
                    z12 = false;
                } else {
                    z12 = false;
                    z14 = true;
                }
            }
            i11++;
        }
        if (z12) {
            boolean z15 = listenerBean.isNewInitListener;
            if (z15 && (gslbInitListener2 = listenerBean.gslbInitListener) != null) {
                gslbInitListener2.onInitFail("all domains are empty");
            } else if (!z15 && (initListener2 = listenerBean.initListener) != null) {
                initListener2.onInitFail();
            }
        } else if (z13) {
            write();
        } else if (!z14 && !TextUtils.isEmpty(getCountry())) {
            boolean z16 = listenerBean.isNewInitListener;
            if (z16 && (gslbInitListener = listenerBean.gslbInitListener) != null) {
                gslbInitListener.onInitSuccess(new HashMap(this.domainMap));
                return;
            } else {
                if (z16 || (initListener = listenerBean.initListener) == null) {
                    return;
                }
                initListener.onInitSuccess(new HashMap(this.domainMap));
                return;
            }
        }
        this.listenerBeans.add(listenerBean);
    }

    public void checkAllListener() {
        for (ListenerBean listenerBean : this.listenerBeans) {
            if (listenerBean.domains != null) {
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    String[] strArr = listenerBean.domains;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    if (this.domainMap.containsKey(strArr[i11]) && !isDomain(this.domainMap.get(listenerBean.domains[i11]))) {
                        z11 = true;
                        break;
                    }
                    i11++;
                }
                GslbSdk.InitListener initListener = listenerBean.initListener;
                if (initListener != null) {
                    if (z11) {
                        initListener.onInitFail();
                    } else {
                        initListener.onInitSuccess(new HashMap(this.domainMap));
                    }
                }
            } else {
                String str = listenerBean.url;
                if (str != null && listenerBean.resultListener != null) {
                    String domain = Utils.getDomain(str);
                    String str2 = this.domainMap.get(domain);
                    if (isDomain(str2)) {
                        listenerBean.resultListener.onGslbSuccess(listenerBean.url.replace(domain, str2));
                    } else {
                        listenerBean.resultListener.onGslbFail();
                    }
                }
            }
        }
        this.listenerBeans.clear();
    }

    public List<String> getAllDomains() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = this.domainMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public List<String> getBlankDomains() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.domainMap.entrySet()) {
            if (!isDomain(entry.getValue())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public String getCountry() {
        return this.countryCode;
    }

    public String getDomain(String str) {
        String str2 = this.domainMap.get(str);
        checkSync();
        return str2;
    }

    public String getLastGaid() {
        return this.lastGaid;
    }

    public void mergeResult(Map<String, String> map, boolean z11) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!isDomain(this.domainMap.get(entry.getKey())) || z11) {
                this.domainMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void notifyListener() {
        GslbSdk.GetDomainListener getDomainListener;
        GslbSdk.ResultListener resultListener;
        GslbSdk.GslbInitListener gslbInitListener;
        GslbSdk.InitListener initListener;
        try {
            for (ListenerBean listenerBean : this.listenerBeans) {
                boolean z11 = listenerBean.isNewInitListener;
                int i11 = 0;
                if (!z11 && listenerBean.initListener != null) {
                    String[] strArr = listenerBean.domains;
                    int length = strArr.length;
                    boolean z12 = false;
                    while (i11 < length) {
                        String str = strArr[i11];
                        if (!TextUtils.isEmpty(str) && !isDomain(this.domainMap.get(str))) {
                            z12 = true;
                        }
                        i11++;
                    }
                    if (z12) {
                        listenerBean.initListener.onInitFail();
                    } else if (!TextUtils.isEmpty(getCountry())) {
                        listenerBean.initListener.onInitSuccess(new HashMap(this.domainMap));
                    }
                } else if (!z11 || listenerBean.gslbInitListener == null) {
                    String str2 = listenerBean.url;
                    if (str2 != null && !listenerBean.isNewDomainListener && listenerBean.resultListener != null) {
                        String domain = Utils.getDomain(str2);
                        String str3 = this.domainMap.get(domain);
                        if (isDomain(str3)) {
                            listenerBean.resultListener.onGslbSuccess(listenerBean.url.replace(domain, str3));
                        } else {
                            listenerBean.resultListener.onGslbFail();
                        }
                    } else if (str2 != null && listenerBean.isNewDomainListener && listenerBean.gslbDomainListener != null) {
                        String domain2 = Utils.getDomain(str2);
                        String str4 = this.domainMap.get(domain2);
                        if (isDomain(str4)) {
                            listenerBean.gslbDomainListener.onGslbSuccess(listenerBean.url.replace(domain2, str4));
                        } else {
                            listenerBean.gslbDomainListener.onGslbFail("the mapping result is empty for " + domain2);
                        }
                    }
                } else {
                    String[] strArr2 = listenerBean.domains;
                    int length2 = strArr2.length;
                    String str5 = "";
                    boolean z13 = false;
                    while (i11 < length2) {
                        String str6 = strArr2[i11];
                        if (!TextUtils.isEmpty(str6) && !isDomain(this.domainMap.get(str6))) {
                            str5 = str6;
                            z13 = true;
                        }
                        i11++;
                    }
                    if (z13) {
                        listenerBean.gslbInitListener.onInitFail("domain map not found for " + str5);
                    } else if (!TextUtils.isEmpty(getCountry())) {
                        listenerBean.gslbInitListener.onInitSuccess(new HashMap(this.domainMap));
                    }
                }
            }
            this.listenerBeans.clear();
        } catch (Exception e11) {
            e11.printStackTrace();
            for (ListenerBean listenerBean2 : this.listenerBeans) {
                boolean z14 = listenerBean2.isNewInitListener;
                if (!z14 && (initListener = listenerBean2.initListener) != null) {
                    initListener.onInitFail();
                } else if (!z14 || (gslbInitListener = listenerBean2.gslbInitListener) == null) {
                    String str7 = listenerBean2.url;
                    if (str7 != null && !listenerBean2.isNewDomainListener && (resultListener = listenerBean2.resultListener) != null) {
                        resultListener.onGslbFail();
                    } else if (str7 != null && listenerBean2.isNewDomainListener && (getDomainListener = listenerBean2.gslbDomainListener) != null) {
                        getDomainListener.onGslbFail("get domain exception " + e11.toString());
                    }
                } else {
                    gslbInitListener.onInitFail("get domain exception " + e11.toString());
                }
            }
            this.listenerBeans.clear();
        }
    }

    public void notifyNoNetwork() {
        GslbSdk.GetDomainListener getDomainListener;
        GslbSdk.ResultListener resultListener;
        GslbSdk.GslbInitListener gslbInitListener;
        GslbSdk.InitListener initListener;
        GslbSdk.GetDomainListener getDomainListener2;
        GslbSdk.ResultListener resultListener2;
        try {
            ArrayList arrayList = new ArrayList();
            for (ListenerBean listenerBean : this.listenerBeans) {
                boolean z11 = listenerBean.isNewInitListener;
                if (!z11 && listenerBean.initListener != null) {
                    arrayList.add(listenerBean);
                } else if (!z11 || listenerBean.gslbInitListener == null) {
                    String str = listenerBean.url;
                    if (str != null && !listenerBean.isNewDomainListener && (resultListener2 = listenerBean.resultListener) != null) {
                        resultListener2.onGslbFail();
                    } else if (str != null && listenerBean.isNewDomainListener && (getDomainListener2 = listenerBean.gslbDomainListener) != null) {
                        getDomainListener2.onGslbFail("no network");
                    }
                } else {
                    arrayList.add(listenerBean);
                }
            }
            this.listenerBeans.clear();
            this.listenerBeans.addAll(arrayList);
        } catch (Exception e11) {
            e11.printStackTrace();
            for (ListenerBean listenerBean2 : this.listenerBeans) {
                boolean z12 = listenerBean2.isNewInitListener;
                if (!z12 && (initListener = listenerBean2.initListener) != null) {
                    initListener.onInitFail();
                } else if (!z12 || (gslbInitListener = listenerBean2.gslbInitListener) == null) {
                    String str2 = listenerBean2.url;
                    if (str2 != null && !listenerBean2.isNewDomainListener && (resultListener = listenerBean2.resultListener) != null) {
                        resultListener.onGslbFail();
                    } else if (str2 != null && listenerBean2.isNewDomainListener && (getDomainListener = listenerBean2.gslbDomainListener) != null) {
                        getDomainListener.onGslbFail("get domain exception " + e11.toString());
                    }
                } else {
                    gslbInitListener.onInitFail("get domain exception " + e11.toString());
                }
            }
            this.listenerBeans.clear();
        }
    }

    public void reset() {
        this.domainMap.clear();
        this.domainMap.put("dsu.shalltry.com", BLANK_DOMAIN);
        this.domainMap.put("dsc.shalltry.com", BLANK_DOMAIN);
        this.domainMap.put("api.twibida.com", BLANK_DOMAIN);
    }

    public boolean reset(String str) {
        try {
            this.domainMap.remove(str);
            return true;
        } catch (Exception e11) {
            Utils.LOG.i("reset exception" + e11.toString());
            return false;
        }
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setLastGaid(String str) {
        this.lastGaid = str;
    }

    public void setSyncInterval(long j11) {
        this.syncInterval = j11;
        if (j11 < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            this.syncInterval = ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
        }
        this.lastSyncTime = System.currentTimeMillis();
    }

    public boolean updateNetData(String str, String str2) {
        boolean z11;
        String string;
        setLastGaid(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i11 = jSONObject.getInt(TrackingKey.CODE);
            String string2 = jSONObject.getString("message");
            if (i11 != 200) {
                Utils.LOG.i("error message is " + string2);
                return false;
            }
            HashMap map = new HashMap(4);
            long j11 = ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                JSONObject jSONObject3 = jSONObject2.getJSONObject("domainPairs");
                z11 = jSONObject2.getBoolean("overrideFlag");
                try {
                    j11 = jSONObject2.getInt("expireTime");
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String strValueOf = String.valueOf(itKeys.next());
                        map.put(strValueOf, jSONObject3.getString(strValueOf));
                    }
                    string = jSONObject2.getString(PlaceTypes.COUNTRY);
                } catch (Exception e11) {
                    e = e11;
                    Utils.LOG.i(Log.getStackTraceString(e));
                    string = "";
                }
            } catch (Exception e12) {
                e = e12;
                z11 = false;
            }
            mergeResult(map, z11);
            setSyncInterval(j11);
            setCountryCode(string);
            write();
            return true;
        } catch (JSONException e13) {
            e13.printStackTrace();
            return false;
        }
    }
}
