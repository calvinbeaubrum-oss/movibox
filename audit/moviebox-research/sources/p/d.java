package p;

import android.app.Application;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.integration.model.ClassificationInfo;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppBean;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppType;
import com.cloud.tmc.miniapp.offlineapps.OfflineDownloadAppBean;
import com.cloud.tmc.miniapp.offlineapps.ScanScene;
import com.cloud.tmc.miniapp.offlineapps.ScanType;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.OffPkgConfig;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.google.gson.reflect.TypeToken;
import hd.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f73468b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f73474h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f73467a = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, p.a> f73469c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, OfflineAppBean> f73470d = new LinkedHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f73471e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f73472f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f73473g = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ThreadPoolExecutor f73475i = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new f(), new e());

    /* JADX INFO: compiled from: source.java */
    public static final class a implements n.a {
        @Override // n.a
        public void a(String appId, String logoUrl, String path) {
            Intrinsics.g(appId, "appId");
            Intrinsics.g(logoUrl, "logoUrl");
            Intrinsics.g(path, "path");
            try {
                Map<String, OfflineAppBean> map = d.f73470d;
                OfflineAppBean offlineAppBean = (OfflineAppBean) ((LinkedHashMap) map).get(appId);
                if (Intrinsics.b(offlineAppBean != null ? offlineAppBean.getLogoUrl() : null, logoUrl)) {
                    OfflineAppBean offlineAppBean2 = (OfflineAppBean) ((LinkedHashMap) map).get(appId);
                    if (Intrinsics.b(offlineAppBean2 != null ? offlineAppBean2.getLogoPath() : null, path)) {
                        return;
                    }
                    OfflineAppBean offlineAppBean3 = (OfflineAppBean) ((LinkedHashMap) map).get(appId);
                    if (offlineAppBean3 != null) {
                        offlineAppBean3.setLogoPath(path);
                    }
                    d.f73467a.k();
                }
            } catch (Throwable th2) {
                d dVar = d.f73467a;
                TmcLogger.g("OooO0O0", "[IconDownloadManager] download icon fail", th2);
            }
        }
    }

    public static final void c() {
        Map<? extends String, ? extends OfflineAppBean> linkedHashMap;
        Map<String, OfflineAppBean> map = f73470d;
        ((LinkedHashMap) map).clear();
        try {
            Application application = f73468b;
            if (application != null) {
                linkedHashMap = (Map) k.e(((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(application, "offlineScan", "offlineScanApps"), new TypeToken<Map<String, OfflineAppBean>>() { // from class: com.cloud.tmc.miniapp.offlineapps.scan.ScanManager$getOfflineAppsFromMMKV$1$1
                }.getType());
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                }
            } else {
                linkedHashMap = new LinkedHashMap<>();
            }
        } catch (Throwable th2) {
            TmcLogger.g("OooO0O0", "[getOfflineAppsFromMMKV] error", th2);
        }
        map.putAll(linkedHashMap);
    }

    public static final void m() {
        try {
            d dVar = f73467a;
            dVar.i();
            dVar.n();
        } catch (Throwable th2) {
            TmcLogger.g("OooO0O0", "[scan] fail", th2);
        }
    }

    public final OfflineAppBean a(OfflineDownloadAppBean offlineDownloadAppBean) {
        List<ZipFileInfo> zipFileInfo;
        ZipFileInfo zipFileInfo2;
        String version;
        String logo;
        AppInfoModel appInfo;
        AppInfoModel appInfo2;
        AppInfoModel appInfo3;
        AppInfoModel appInfo4;
        AppInfoModel appInfo5;
        AppInfoModel appInfo6;
        AppInfoModel appInfo7;
        OfflinePkgCachePath offlinePkgCachePathJ = OfflineManager.J(offlineDownloadAppBean.getAppId());
        List<ClassificationInfo> classification = null;
        if (offlinePkgCachePathJ == null || (zipFileInfo = offlinePkgCachePathJ.getZipFileInfo()) == null || (zipFileInfo2 = (ZipFileInfo) CollectionsKt___CollectionsKt.e0(zipFileInfo)) == null) {
            return null;
        }
        String str = zipFileInfo2.getZipUnCompressPath() + '/' + offlineDownloadAppBean.getAppId() + ".zip";
        OffPkgConfig manifest = zipFileInfo2.getManifest();
        if (manifest == null || (version = manifest.getVersion()) == null) {
            return null;
        }
        boolean zB = Intrinsics.b(str, offlineDownloadAppBean.getZipPath());
        TmcLogger.c("OooO0O0", "[checkOfflineDownloadAppIsValid]->validOfflineDownloadZipPath:" + str + ", offlineDownloadAppBean.zipPath:" + offlineDownloadAppBean.getZipPath() + ", appId:" + offlineDownloadAppBean.getAppId() + ", valid:" + zB);
        if (!zB) {
            return null;
        }
        String appId = offlineDownloadAppBean.getAppId();
        OffPkgConfig manifest2 = zipFileInfo2.getManifest();
        String name = (manifest2 == null || (appInfo7 = manifest2.getAppInfo()) == null) ? null : appInfo7.getName();
        OfflineAppType offlineAppType = OfflineAppType.OFFLINE_DOWNLOAD;
        OffPkgConfig manifest3 = zipFileInfo2.getManifest();
        String logo2 = (manifest3 == null || (appInfo6 = manifest3.getAppInfo()) == null) ? null : appInfo6.getLogo();
        OffPkgConfig manifest4 = zipFileInfo2.getManifest();
        Integer numValueOf = (manifest4 == null || (appInfo5 = manifest4.getAppInfo()) == null) ? null : Integer.valueOf(appInfo5.getAppinfoCategoryType());
        OffPkgConfig manifest5 = zipFileInfo2.getManifest();
        String desc = (manifest5 == null || (appInfo4 = manifest5.getAppInfo()) == null) ? null : appInfo4.getDesc();
        n.c cVar = n.c.f71307a;
        String appId2 = offlineDownloadAppBean.getAppId();
        OffPkgConfig manifest6 = zipFileInfo2.getManifest();
        if (manifest6 == null || (appInfo3 = manifest6.getAppInfo()) == null || (logo = appInfo3.getLogo()) == null) {
            logo = "";
        }
        String strE = cVar.e(appId2, logo);
        OffPkgConfig manifest7 = zipFileInfo2.getManifest();
        List<String> classificationNames = (manifest7 == null || (appInfo2 = manifest7.getAppInfo()) == null) ? null : appInfo2.getClassificationNames();
        OffPkgConfig manifest8 = zipFileInfo2.getManifest();
        if (manifest8 != null && (appInfo = manifest8.getAppInfo()) != null) {
            classification = appInfo.getClassification();
        }
        return new OfflineAppBean(appId, version, name, offlineAppType, logo2, strE, numValueOf, desc, 0L, classificationNames, classification, 256, null);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    public final OfflineDownloadAppBean b(String str) {
        File[] fileArrListFiles;
        String strF;
        String absolutePath;
        String name;
        TmcLogger.c("OooO0O0", "[getOfflineDownloadAppPath]->scanPath:" + str);
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        boolean z11 = false;
        for (File file2 : fileArrListFiles) {
            if (file2 != null && (name = file2.getName()) != null && l.u(name, ".zip", false, 2, null)) {
                String name2 = file2.getName();
                Intrinsics.f(name2, "i.name");
                if (!Intrinsics.b("100000", l.F(name2, ".zip", "", false, 4, null))) {
                    String name3 = file2.getName();
                    Intrinsics.f(name3, "i.name");
                    strF = l.F(name3, ".zip", "", false, 4, null);
                    absolutePath = file2.getAbsolutePath();
                    Intrinsics.f(absolutePath, "i.absolutePath");
                    z11 = true;
                    if (z11) {
                        return new OfflineDownloadAppBean(strF, absolutePath);
                    }
                    return null;
                }
            }
        }
        strF = "";
        absolutePath = "";
        if (z11) {
            return new OfflineDownloadAppBean(strF, absolutePath);
        }
        return null;
    }

    public final void d(Application application) {
        Intrinsics.g(application, "application");
        TmcLogger.c("OooO0O0", "[ScanManager] init");
        f73468b = application;
        f73474h = ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("offlineAppsScanLevel", 0);
        f73475i.submit(new Runnable() { // from class: p.c
            @Override // java.lang.Runnable
            public final void run() {
                d.c();
            }
        });
        String rootFilePath = ((PathProxy) tc.a.a(PathProxy.class)).getRootFilePath();
        Intrinsics.f(rootFilePath, "get(PathProxy::class.java).rootFilePath");
        f73471e = rootFilePath;
        String rootDownloadPath = ((PathProxy) tc.a.a(PathProxy.class)).getRootDownloadPath();
        Intrinsics.f(rootDownloadPath, "get(PathProxy::class.java).rootDownloadPath");
        f73472f = rootDownloadPath;
        String rootMiniAppPath = ((PathProxy) tc.a.a(PathProxy.class)).getRootMiniAppPath();
        Intrinsics.f(rootMiniAppPath, "get(PathProxy::class.java).rootMiniAppPath");
        f73473g = rootMiniAppPath;
        n.c cVar = n.c.f71307a;
        a listener = new a();
        Intrinsics.g(listener, "listener");
        n.c.f71309c = listener;
    }

    public final void e(OfflineAppBean offlineAppBean) {
        StringBuilder sbA = j.a("[checkLogoPath] appId:");
        sbA.append(offlineAppBean.getAppId());
        sbA.append(", logoUrl:");
        sbA.append(offlineAppBean.getLogoUrl());
        sbA.append(", logoPath:");
        sbA.append(offlineAppBean.getLogoPath());
        TmcLogger.c("OooO0O0", sbA.toString());
        String logoPath = offlineAppBean.getLogoPath();
        if (logoPath == null || logoPath.length() == 0) {
            n.c cVar = n.c.f71307a;
            String appId = offlineAppBean.getAppId();
            String logoUrl = offlineAppBean.getLogoUrl();
            if (logoUrl == null) {
                logoUrl = "";
            }
            cVar.a(appId, logoUrl);
        }
    }

    public final void f(Map<String, OfflineAppBean> map, Map<String, OfflineAppBean> map2) {
        String version;
        for (Map.Entry<String, OfflineAppBean> entry : map2.entrySet()) {
            if (map.containsKey(entry.getKey())) {
                String version2 = entry.getValue().getVersion();
                String str = "";
                if (version2 == null) {
                    version2 = "";
                }
                OfflineAppBean offlineAppBean = map.get(entry.getKey());
                if (offlineAppBean != null && (version = offlineAppBean.getVersion()) != null) {
                    str = version;
                }
                if (MiniAppLaunch.f31784a.D(version2, str)) {
                    map.put(entry.getKey(), entry.getValue());
                }
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public final void g(boolean z11, ScanScene scanScene, p.a aVar) {
        p.a aVar2;
        Intrinsics.g(scanScene, "scanScene");
        boolean z12 = true;
        if (!((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("offlineAppsAbilitySwitch", true)) {
            TmcLogger.c("OooO0O0", "[scan] offlineAppsAbilitySwitch is close");
            if (aVar != null) {
                aVar.a(g.l());
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z11) {
            arrayList.addAll(((LinkedHashMap) f73470d).values());
            TmcLogger.c("OooO0O0", "[sendResult] fromCache scene:" + scanScene + " result:" + k.j(arrayList));
            if (aVar != null) {
                aVar.a(arrayList);
            }
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        Map<String, p.a> map = f73469c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(scanScene);
        sb2.append('_');
        sb2.append(aVar != null ? aVar.hashCode() : 0);
        map.put(sb2.toString(), aVar2);
        int i11 = f73474h;
        boolean z13 = i11 == ScanType.LEVEL_0.getType() || i11 != ScanType.LEVEL_1.getType() || scanScene.getType() >= ScanScene.SCAN_PINFORLATER.getType();
        if (z11 && !z13) {
            z12 = false;
        }
        TmcLogger.c("OooO0O0", "[scan] needScan:" + z12 + ", isCache:" + z11 + ", scanScene:" + scanScene);
        if (z12) {
            f73475i.submit(new Runnable() { // from class: p.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.m();
                }
            });
        }
    }

    public final Map<String, OfflineAppBean> h(String str) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File file;
        File[] fileArrListFiles3;
        OfflineAppBean offlineAppBeanA;
        TmcLogger.c("OooO0O0", "[scanOfflineDownloadAppsModeDownload]->scanPath:" + str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory() || (fileArrListFiles = file2.listFiles()) == null) {
            return linkedHashMap;
        }
        for (File file3 : fileArrListFiles) {
            if (file3 != null && file3.isDirectory() && (fileArrListFiles2 = file3.listFiles()) != null && fileArrListFiles2.length != 0 && (file = (File) kotlin.collections.d.O(fileArrListFiles2)) != null && file.exists() && file.isDirectory() && (fileArrListFiles3 = file.listFiles()) != null) {
                for (File file4 : fileArrListFiles3) {
                    String absolutePath = file4.getAbsolutePath();
                    Intrinsics.f(absolutePath, "j.absolutePath");
                    OfflineDownloadAppBean offlineDownloadAppBeanB = b(absolutePath);
                    if (offlineDownloadAppBeanB != null && (offlineAppBeanA = a(offlineDownloadAppBeanB)) != null) {
                        linkedHashMap.put(offlineAppBeanA.getAppId(), offlineAppBeanA);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final void i() {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (f73471e.length() != 0) {
                f(linkedHashMap, j(f73471e));
            }
            if (f73472f.length() != 0) {
                f(linkedHashMap, h(f73472f));
            }
            if (f73473g.length() != 0) {
                f(linkedHashMap, l(f73473g));
            }
            TmcLogger.c("OooO0O0", "[realScan] result:" + k.j(linkedHashMap));
            Map<String, OfflineAppBean> map = f73470d;
            ((LinkedHashMap) map).clear();
            map.putAll(linkedHashMap);
        } catch (Throwable th2) {
            TmcLogger.g("OooO0O0", "[realScan] fail", th2);
        }
    }

    public final Map<String, OfflineAppBean> j(String str) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File file;
        File[] fileArrListFiles3;
        OfflineAppBean offlineAppBeanA;
        TmcLogger.c("OooO0O0", "[scanOfflineDownloadAppsModeFiles]->scanPath:" + str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory() || (fileArrListFiles = file2.listFiles()) == null) {
            return linkedHashMap;
        }
        for (File file3 : fileArrListFiles) {
            if (file3 != null && file3.isDirectory()) {
                File file4 = new File(file3.getAbsolutePath() + "/temp_data");
                if (file4.exists() && file4.isDirectory() && (fileArrListFiles2 = file4.listFiles()) != null && fileArrListFiles2.length != 0 && (file = (File) kotlin.collections.d.O(fileArrListFiles2)) != null && file.exists() && file.isDirectory() && (fileArrListFiles3 = file.listFiles()) != null) {
                    for (File file5 : fileArrListFiles3) {
                        String absolutePath = file5.getAbsolutePath();
                        Intrinsics.f(absolutePath, "j.absolutePath");
                        OfflineDownloadAppBean offlineDownloadAppBeanB = b(absolutePath);
                        if (offlineDownloadAppBeanB != null && (offlineAppBeanA = a(offlineDownloadAppBeanB)) != null) {
                            linkedHashMap.put(offlineAppBeanA.getAppId(), offlineAppBeanA);
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final void k() {
        try {
            Application application = f73468b;
            if (application != null) {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(application, "offlineScan", "offlineScanApps", k.j(f73470d));
            }
        } catch (Throwable th2) {
            TmcLogger.g("OooO0O0", "[saveOfflineAppsToMMKV] error", th2);
        }
    }

    public final Map<String, OfflineAppBean> l(String str) {
        File[] fileArrListFiles;
        AppModel appModelFromUsed;
        File[] fileArrListFiles2;
        File[] fileArrListFiles3;
        TmcLogger.c("OooO0O0", "[scanUsedApps]->scanPath:" + str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return linkedHashMap;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null && file2.isDirectory() && !Intrinsics.b("100000", file2.getName())) {
                String appId = file2.getName();
                Application application = f73468b;
                if (application != null && (appModelFromUsed = ((TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class)).getAppModelFromUsed(application, appId)) != null && (fileArrListFiles2 = file2.listFiles()) != null) {
                    for (File file3 : fileArrListFiles2) {
                        if (file3 != null && file3.isDirectory() && (fileArrListFiles3 = file3.listFiles()) != null && fileArrListFiles3.length != 0) {
                            String name = file3.getName();
                            boolean zB = Intrinsics.b(appModelFromUsed.getPackageUrl_MD5(), name);
                            TmcLogger.c("OooO0O0", "[scanUsedApps]->versionFilePath:" + name + ", packageUrl_MD5:" + appModelFromUsed.getPackageUrl_MD5() + ", appId:" + appId + ", valid:" + zB);
                            if (zB) {
                                Intrinsics.f(appId, "appId");
                                String deployVersion = appModelFromUsed.getDeployVersion();
                                String name2 = appModelFromUsed.getName();
                                OfflineAppType offlineAppType = OfflineAppType.USED;
                                String logo = appModelFromUsed.getLogo();
                                int appinfoCategoryType = appModelFromUsed.getAppinfoCategoryType();
                                String desc = appModelFromUsed.getDesc();
                                n.c cVar = n.c.f71307a;
                                String logo2 = appModelFromUsed.getLogo();
                                if (logo2 == null) {
                                    logo2 = "";
                                }
                                linkedHashMap.put(appId, new OfflineAppBean(appId, deployVersion, name2, offlineAppType, logo, cVar.e(appId, logo2), Integer.valueOf(appinfoCategoryType), desc, 0L, appModelFromUsed.getClassificationNames(), appModelFromUsed.getClassification(), 256, null));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final void n() {
        OfflineAppBean offlineAppBean;
        try {
            if (f73475i.getQueue().isEmpty()) {
                k();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.putAll(f73470d);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Map<String, p.a> map = f73469c;
                linkedHashMap2.putAll(map);
                ((LinkedHashMap) map).clear();
                ArrayList arrayList = new ArrayList();
                List<AppStoreInfo> listD = LatestUseUtils.d();
                if (listD == null) {
                    listD = g.l();
                }
                for (AppStoreInfo appStoreInfo : listD) {
                    String appId = appStoreInfo.getAppId();
                    if (appId != null && (offlineAppBean = (OfflineAppBean) linkedHashMap.get(appId)) != null) {
                        offlineAppBean.setOpenTimestamp(appStoreInfo.getSaveTime());
                        arrayList.add(offlineAppBean);
                        linkedHashMap.remove(appId);
                        e(offlineAppBean);
                    }
                }
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    f73467a.e((OfflineAppBean) ((Map.Entry) it.next()).getValue());
                }
                arrayList.addAll(linkedHashMap.values());
                ArrayList arrayList2 = new ArrayList();
                Object objD = k.d(MiniAppConfigHelper.f30370a.e("offlineAppsList", "[\"1000827142865809408\",\"1000263325676503040\",\"1000938677585735680\",\"1000091930789543936\",\"1000176126598975488\",\"1000589204414427136\",\"1000779965791449088\",\"1000434393060675584\",\"1000928659483803648\",\"1000262595995639808\",\"1000296789383352320\",\"1000222344028467200\",\"1000622920416403456\"]"), List.class);
                List arrayList3 = objD instanceof List ? (List) objD : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (arrayList3.contains(((OfflineAppBean) arrayList.get(i11)).getAppId())) {
                        arrayList2.add(arrayList.get(i11));
                    }
                }
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    String str = (String) entry.getKey();
                    p.a aVar = (p.a) entry.getValue();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[sendResult] fromSync scene:");
                    sb2.append(str);
                    sb2.append(" needScanResult:");
                    sb2.append(aVar != null);
                    TmcLogger.c("OooO0O0", sb2.toString());
                    if (aVar != null) {
                        aVar.a(arrayList2);
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("OooO0O0", "[sendResult] fail", th2);
        }
    }
}
