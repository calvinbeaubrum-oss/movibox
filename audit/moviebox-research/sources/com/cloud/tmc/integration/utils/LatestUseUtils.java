package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class LatestUseUtils {
    public static synchronized boolean a(String str, String str2, String str3, String str4, List<String> list, String str5, int i11) {
        TmcLogger.c("LatestUseUtils", "addAppUse -> appId -> " + str + "appName " + str2);
        try {
            if (!AbilitiesUtils.f30983a.b(str, "latest_use")) {
                TmcLogger.f("LatestUseUtils", "config not add latest use.");
                return false;
            }
            HashMap<String, AppStoreInfo> mapC = c();
            AppStoreInfo appStoreInfo = new AppStoreInfo(str, str2, str3, str4, list, str5, i11);
            if (mapC == null || mapC.size() == 0) {
                mapC = new HashMap<>();
            }
            Collections.sort(new ArrayList(mapC.values()), new Comparator<AppStoreInfo>() { // from class: com.cloud.tmc.integration.utils.LatestUseUtils.1
                @Override // java.util.Comparator
                public int compare(AppStoreInfo appStoreInfo2, AppStoreInfo appStoreInfo3) {
                    return appStoreInfo2.getSaveTime() > appStoreInfo3.getSaveTime() ? -1 : 1;
                }
            });
            mapC.put(str, appStoreInfo);
            f(mapC);
            return true;
        } catch (Throwable th2) {
            TmcLogger.h("LatestUseUtils", th2);
            return false;
        }
    }

    public static synchronized boolean b(String str) {
        try {
            HashMap<String, AppStoreInfo> mapC = c();
            if (mapC != null && mapC.size() != 0) {
                if (mapC.get(str) != null) {
                    mapC.remove(str);
                    f(mapC);
                }
                return true;
            }
            return true;
        } catch (Throwable th2) {
            TmcLogger.h("LatestUseUtils", th2);
            return false;
        }
    }

    public static HashMap<String, AppStoreInfo> c() {
        try {
            Type type = new TypeToken<HashMap<String, AppStoreInfo>>() { // from class: com.cloud.tmc.integration.utils.LatestUseUtils.3
            }.getType();
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(com.cloud.tmc.miniutils.util.e0.a(), "miniLatestUseApps", "latest_use_app");
            if (string != null && !string.isEmpty()) {
                return (HashMap) com.cloud.tmc.miniutils.util.k.e(string, type);
            }
            MMKV mmkvJ = MiniAppConfigHelper.j();
            if (mmkvJ == null) {
                return null;
            }
            String string2 = mmkvJ.getString("latest_use_app", "{}");
            TmcLogger.c("LatestUseUtils", "getLatestUseApp->" + string2);
            HashMap<String, AppStoreInfo> map = (HashMap) com.cloud.tmc.miniutils.util.k.e(string2, type);
            f(map);
            return map;
        } catch (Throwable th2) {
            TmcLogger.h("LatestUseUtils", th2);
            return null;
        }
    }

    public static synchronized List<AppStoreInfo> d() {
        ArrayList arrayList;
        Throwable th2;
        try {
            HashMap<String, AppStoreInfo> mapC = c();
            if (mapC != null && mapC.size() != 0) {
                arrayList = new ArrayList(mapC.values());
                try {
                    Collections.sort(arrayList, new Comparator<AppStoreInfo>() { // from class: com.cloud.tmc.integration.utils.LatestUseUtils.2
                        @Override // java.util.Comparator
                        public int compare(AppStoreInfo appStoreInfo, AppStoreInfo appStoreInfo2) {
                            return appStoreInfo.getSaveTime() > appStoreInfo2.getSaveTime() ? -1 : 1;
                        }
                    });
                } catch (Throwable th3) {
                    th2 = th3;
                    TmcLogger.h("LatestUseUtils", th2);
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                return arrayList;
            }
            return null;
        } catch (Throwable th4) {
            arrayList = null;
            th2 = th4;
        }
    }

    public static synchronized void e(List<String> list) {
        try {
            HashMap<String, AppStoreInfo> mapC = c();
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && mapC != null) {
                    mapC.remove(str);
                }
            }
            f(mapC);
        } catch (Throwable th2) {
            TmcLogger.h("LatestUseUtils", th2);
        }
    }

    public static void f(HashMap<String, AppStoreInfo> map) {
        if (map == null) {
            return;
        }
        try {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(com.cloud.tmc.miniutils.util.e0.a(), "miniLatestUseApps", "latest_use_app", com.cloud.tmc.miniutils.util.k.j(map));
        } catch (Throwable th2) {
            TmcLogger.h("LatestUseUtils", th2);
        }
    }
}
