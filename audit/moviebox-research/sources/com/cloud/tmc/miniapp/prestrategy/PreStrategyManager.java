package com.cloud.tmc.miniapp.prestrategy;

import OooOoo0.OooOOO0;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import b0.b;
import b0.f;
import b0.g;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.LauncherPreDataModel;
import com.cloud.tmc.integration.model.LauncherPreStrategyBaseModel;
import com.cloud.tmc.integration.model.LauncherPreStrategyModel;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.integration.utils.c0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.n0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.i;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.ipc.IpcMiniLauncherService;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.e0;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.offline.download.OfflineManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.transsion.push.PushConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class PreStrategyManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f31652b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HashMap<String, Boolean> f31654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f31655e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreStrategyManager f31651a = new PreStrategyManager();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f31653c = s.l(TuplesKt.a("keyZeroRecentData", "zeroRecent"), TuplesKt.a("keyZeroMinicardData", "zeroCard"), TuplesKt.a("keyZeroMinicardUpdate", "zeroCard"), TuplesKt.a("keyFullRecentMiniData", "fullSearchRecent"), TuplesKt.a("keyFullMinicardData", "fullSearchCard"), TuplesKt.a("keyAzRecentData", "azRecent"), TuplesKt.a("keyFullSearchAppData", "fullSearchApp"), TuplesKt.a("keyZeroBannerData", "zeroBanner"), TuplesKt.a("keyMiniAppStart", "miniappStart"), TuplesKt.a("keyMiniAppCenterRecommend", "miniappCenterRecommend"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f31656f = 3600000;

    /* JADX WARN: Code duplicated, block: B:33:0x00a1 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:3:0x0007, B:5:0x000f, B:8:0x0019, B:10:0x0021, B:11:0x0028, B:13:0x004a, B:14:0x0060, B:37:0x00b9, B:23:0x007a, B:31:0x0094, B:33:0x00a1, B:34:0x00a7, B:26:0x0083, B:29:0x008c, B:35:0x00b1, B:38:0x00bd, B:40:0x00ca, B:41:0x00d0), top: B:45:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a7 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:3:0x0007, B:5:0x000f, B:8:0x0019, B:10:0x0021, B:11:0x0028, B:13:0x004a, B:14:0x0060, B:37:0x00b9, B:23:0x007a, B:31:0x0094, B:33:0x00a1, B:34:0x00a7, B:26:0x0083, B:29:0x008c, B:35:0x00b1, B:38:0x00bd, B:40:0x00ca, B:41:0x00d0), top: B:45:0x0007 }] */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        if (r8.equals("keyFullRecentMiniData") != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(PreStrategyManager preStrategyManager, Context context, String key, String str, Function1 function1, int i11) {
        Intrinsics.g(key, "key");
        try {
            if (!ByteAppManager.INSTANCE.checkPreInitConfig(context)) {
                TmcLogger.f("Prefetch:PreStrategyManager", "close pre init subprocess");
                return;
            }
            PreStrategyManager preStrategyManager2 = f31651a;
            if (!preStrategyManager2.m()) {
                TmcLogger.f("Prefetch:PreStrategyManager", "checkEnablePreConfig enable status is false  return");
                return;
            }
            TmcLogger.c("Prefetch:PreStrategyManager", "updateLauncherData " + key + " -> " + str);
            if (!preStrategyManager2.h(key)) {
                TmcLogger.f("Prefetch:PreStrategyManager", key + " is not allow execute");
                return;
            }
            int iHashCode = key.hashCode();
            if (iHashCode != -2066930763) {
                if (iHashCode != -1879995062) {
                    if (iHashCode == -605809219) {
                        if (!key.equals("keyAzRecentData")) {
                        }
                        if (System.currentTimeMillis() - f31652b < 500) {
                            TmcLogger.f("Prefetch:PreStrategyManager", "recent update diff < 500ms");
                            return;
                        } else {
                            f31652b = System.currentTimeMillis();
                            preStrategyManager2.a(context, key, str, null);
                            return;
                        }
                    }
                    if (iHashCode != 936969644 || !key.equals("keyZeroRecentData")) {
                    }
                    if (System.currentTimeMillis() - f31652b < 500) {
                        TmcLogger.f("Prefetch:PreStrategyManager", "recent update diff < 500ms");
                        return;
                    } else {
                        f31652b = System.currentTimeMillis();
                        preStrategyManager2.a(context, key, str, null);
                        return;
                    }
                }
            } else if (key.equals("keyFullSearchAppData")) {
                if (System.currentTimeMillis() - f31652b < 300) {
                    TmcLogger.f("Prefetch:PreStrategyManager", "KEY_FULL_SEARCH_APP_DATA diff < 500ms");
                    return;
                } else {
                    f31652b = System.currentTimeMillis();
                    preStrategyManager2.a(context, key, str, null);
                    return;
                }
            }
            preStrategyManager2.a(context, key, str, null);
        } catch (Throwable th2) {
            TmcLogger.g("Prefetch:PreStrategyManager", "updateLauncherData", th2);
        }
    }

    public static final void k(Context context, String type, String str, Function1 function1) {
        LauncherPreStrategyModel launcherPreStrategyModel;
        JsonObject config;
        Object next;
        Intrinsics.g(type, "$type");
        try {
            ArrayList<LauncherPreDataModel> arrayListJ = f31651a.j(context, type, str);
            if (arrayListJ.isEmpty()) {
                TmcLogger.f("Prefetch:PreStrategyManager", "getLauncherData is empty");
                return;
            }
            f fVar = f.f13872a;
            if (fVar.d()) {
                fVar.a(context, type, arrayListJ);
                return;
            }
            LauncherPreStrategyBaseModel launcherPreStrategyBaseModelB = g.f13878a.b(context);
            if (launcherPreStrategyBaseModelB == null) {
                TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyConfig is null");
                return;
            }
            for (LauncherPreDataModel launcherPreDataModel : arrayListJ) {
                String appId = launcherPreDataModel.getAppId();
                Bundle bundle = new Bundle();
                if (appId == null || appId.length() == 0) {
                    String schemeUrl = launcherPreDataModel.getSchemeUrl();
                    if (schemeUrl == null || schemeUrl.length() == 0) {
                        TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyProcessing schemeUrl is null");
                    } else {
                        boolean zB = MiniAppConfigHelper.f30370a.b("fixEncodeUrl", true);
                        n0 n0Var = n0.f31078a;
                        Uri uri = Uri.parse(n0Var.c(schemeUrl, zB));
                        String queryParameter = uri.getQueryParameter(PushConstants.PROVIDER_FIELD_APP_ID);
                        if (queryParameter == null || queryParameter.length() == 0) {
                            TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyProcessing appId is null");
                        } else {
                            String it = uri.getQueryParameter("query");
                            if (it != null) {
                                Intrinsics.f(it, "it");
                                bundle.putString("query", n0Var.d(it, zB));
                            }
                            String it2 = uri.getQueryParameter("h5Path");
                            if (it2 != null) {
                                Intrinsics.f(it2, "it");
                                bundle.putString("h5Path", n0Var.d(it2, zB));
                            }
                            String queryParameter2 = uri.getQueryParameter("hybridPath");
                            if (queryParameter2 != null) {
                                String strD = r.d(queryParameter2);
                                if (strD == null) {
                                    strD = "";
                                }
                                Intrinsics.f(strD, "UrlUtils.decode(it) ?: \"\"");
                                bundle.putString("hybridPath", n0Var.d(strD, zB));
                            }
                            launcherPreDataModel.setAppId(queryParameter);
                            launcherPreDataModel.setBundle(bundle);
                            appId = queryParameter;
                        }
                    }
                }
                ArrayList<LauncherPreStrategyModel> configList = launcherPreStrategyBaseModelB.getConfigList();
                if (configList != null) {
                    Iterator<T> it3 = configList.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it3.next();
                    } while (!Intrinsics.b(((LauncherPreStrategyModel) next).getAppId(), appId));
                    launcherPreStrategyModel = (LauncherPreStrategyModel) next;
                } else {
                    launcherPreStrategyModel = null;
                }
                if (launcherPreStrategyModel == null) {
                    PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) a.a(PreHtmStrategyProxy.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("failReason", "get configModel is null");
                    bundle2.putString("failAppId", String.valueOf(appId));
                    preHtmStrategyProxy.trackPreStrategyFailPoint(bundle2);
                }
                if (launcherPreStrategyModel == null || (config = launcherPreStrategyModel.getConfig()) == null) {
                    TmcLogger.f("Prefetch:PreStrategyManager", appId + " preStrategyConfig.configList.config is null");
                } else {
                    PreStrategyManager preStrategyManager = f31651a;
                    if (preStrategyManager.f(context, launcherPreStrategyModel)) {
                        try {
                            String str2 = f31653c.get(type);
                            if (str2 == null || str2.length() == 0) {
                                str2 = type;
                            }
                            JsonElement jsonElement = config.get(str2);
                            String string = jsonElement != null ? jsonElement.toString() : null;
                            JsonElement jsonElement2 = config.get("preHtmlWhiteList");
                            String string2 = jsonElement2 != null ? jsonElement2.toString() : null;
                            Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$preStrategyProcessing$1$setType$1
                            }.getType();
                            ArrayList<String> arrayList = (ArrayList) k.e(string, type2);
                            if (arrayList == null) {
                                arrayList = null;
                            }
                            ArrayList<String> arrayList2 = (ArrayList) k.e(string2, type2);
                            ArrayList<String> arrayList3 = arrayList2 != null ? arrayList2 : null;
                            if (arrayList == null || arrayList.isEmpty()) {
                                TmcLogger.f("Prefetch:PreStrategyManager", appId + "-> " + str2 + " config is null ");
                            } else {
                                TmcLogger.f("Prefetch:PreStrategyManager", appId + "-> " + str2 + " start fetch config");
                                try {
                                    preStrategyManager.c(launcherPreDataModel, arrayList, arrayList3, function1);
                                } catch (Throwable th2) {
                                    th = th2;
                                    TmcLogger.h("Prefetch:PreStrategyManager", th);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        TmcLogger.f("Prefetch:PreStrategyManager", appId + " preStrategyConfig config is not suitable.");
                    }
                }
            }
        } catch (Throwable th4) {
            TmcLogger.g("Prefetch:PreStrategyManager", "perStrategyProcessing", th4);
        }
    }

    public final void a(final Context context, final String type, final String str, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(type, "type");
        if (l.e()) {
            try {
                e.a(ExecutorType.IO, new Runnable() { // from class: od.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreStrategyManager.k(context, type, str, function1);
                    }
                });
                return;
            } catch (Throwable th2) {
                TmcLogger.h("Prefetch:PreStrategyManager", th2);
                return;
            }
        }
        Intrinsics.g(type, "type");
        IpcMiniLauncherService.a aVar = IpcMiniLauncherService.f31538a;
        b bVar = new b(type, str, context, function1);
        Intrinsics.g(type, "type");
        try {
            TmcLogger.c(":IpcTaskManagerService", "preLauncherData");
            if (l.e()) {
                TmcLogger.c(":IpcTaskManagerService", "preLauncherData isMiniProcess");
                Context applicationContext = context != null ? context.getApplicationContext() : null;
                e0.c(applicationContext instanceof Application ? (Application) applicationContext : null);
                bVar.c(false);
                return;
            }
            Intent intent = new Intent(context, (Class<?>) IpcMiniLauncherService.class);
            h.f31061a.a(intent, context);
            if (context != null) {
                context.bindService(intent, new com.cloud.tmc.miniapp.ipc.a(type, context, bVar, str), 1);
            }
        } catch (Throwable th3) {
            TmcLogger.h(":IpcTaskManagerService", th3);
            bVar.a(0, th3);
        }
    }

    public final void b(Context context, List<String> list, String scene) {
        LauncherPreStrategyModel launcherPreStrategyModel;
        Object next;
        Intrinsics.g(context, "context");
        Intrinsics.g(scene, "scene");
        if (list.isEmpty()) {
            return;
        }
        f fVar = f.f13872a;
        if (fVar.d()) {
            fVar.b(context, scene, list, null);
            return;
        }
        LauncherPreStrategyBaseModel launcherPreStrategyBaseModelB = g.f13878a.b(context);
        if (launcherPreStrategyBaseModelB == null) {
            TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyConfig is null");
            return;
        }
        for (String str : list) {
            ArrayList<LauncherPreStrategyModel> configList = launcherPreStrategyBaseModelB.getConfigList();
            if (configList != null) {
                Iterator<T> it = configList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(((LauncherPreStrategyModel) next).getAppId(), str));
                launcherPreStrategyModel = (LauncherPreStrategyModel) next;
            } else {
                launcherPreStrategyModel = null;
            }
            JsonObject config = launcherPreStrategyModel != null ? launcherPreStrategyModel.getConfig() : null;
            if (config == null) {
                TmcLogger.f("Prefetch:PreStrategyManager", str + " preStrategyConfig.configList.config is null");
            } else if (f(context, launcherPreStrategyModel)) {
                LauncherPreDataModel launcherPreDataModel = new LauncherPreDataModel(str, null, new Bundle());
                try {
                    String str2 = f31653c.get(scene);
                    if (str2 == null || str2.length() == 0) {
                        str2 = scene;
                    }
                    JsonElement jsonElement = config.get(str2);
                    String string = jsonElement != null ? jsonElement.toString() : null;
                    JsonElement jsonElement2 = config.get("preHtmlWhiteList");
                    String string2 = jsonElement2 != null ? jsonElement2.toString() : null;
                    Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$preStrategy$setType$1
                    }.getType();
                    ArrayList<String> arrayList = (ArrayList) k.e(string, type);
                    if (arrayList == null) {
                        arrayList = null;
                    }
                    ArrayList<String> arrayList2 = (ArrayList) k.e(string2, type);
                    if (arrayList2 == null) {
                        arrayList2 = null;
                    }
                    if (arrayList == null || arrayList.isEmpty()) {
                        TmcLogger.f("Prefetch:PreStrategyManager", str + "-> " + str2 + " config is null ");
                    } else {
                        TmcLogger.f("Prefetch:PreStrategyManager", str + "-> " + str2 + " start fetch config");
                        c(launcherPreDataModel, arrayList, arrayList2, null);
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("Prefetch:PreStrategyManager", th2);
                }
            } else {
                TmcLogger.f("Prefetch:PreStrategyManager", str + " preStrategyConfig config is not suitable.");
            }
        }
    }

    public final void c(LauncherPreDataModel launcherPreDataModel, ArrayList<String> arrayList, ArrayList<String> arrayList2, Function1<? super Boolean, Unit> function1) {
        Unit unit;
        String h5Url;
        ExtendModel extend;
        Application context = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
        if (context == null) {
            TmcLogger.f("Prefetch:PreStrategyManager", "executePrefetchConfig application is null");
            return;
        }
        String appId = launcherPreDataModel.getAppId();
        if (appId == null || appId.length() == 0) {
            TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyProcessing appId is null");
            return;
        }
        TmcLogger.f("Prefetch:PreStrategyManager", appId + " start pre strategy.");
        if (arrayList != null) {
            for (String str : arrayList) {
                if (Intrinsics.b(str, "preHtml")) {
                    if (f31651a.n()) {
                        AppModel appModel = ((TmcAppInfoManager) a.a(TmcAppInfoManager.class)).getAppModel(context, lb.a.f70163b.a(appId));
                        if (appModel == null) {
                            PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) a.a(PreHtmStrategyProxy.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("failReason", "get appModel is null");
                            bundle.putString("failAppId", String.valueOf(appId));
                            preHtmStrategyProxy.trackPreStrategyFailPoint(bundle);
                        }
                        if (appModel == null || (extend = appModel.getExtend()) == null || (h5Url = extend.getH5Url()) == null) {
                            h5Url = "";
                        }
                        if (h5Url.length() == 0) {
                            hd.k.a(appId, " ->h5Url is empty ,return!", "Prefetch:PreStrategyManager");
                        } else {
                            String strB = i.b(h5Url, launcherPreDataModel.getBundle());
                            TmcLogger.c("Prefetch:PreStrategyManager", "CONFIG_PREHTML ->" + appId + "  ->" + strB);
                            if (arrayList2 == null || arrayList2.isEmpty()) {
                                TmcLogger.c("Prefetch:PreStrategyManager", appId + " ->preWhiteList is null or empty");
                                Object objA = a.a(PreHtmStrategyProxy.class);
                                Intrinsics.f(objA, "get(PreHtmStrategyProxy::class.java)");
                                PreHtmStrategyProxy.a.b((PreHtmStrategyProxy) objA, context, strB, null, 4, null);
                            } else if (arrayList2.contains(r.g(strB))) {
                                TmcLogger.c("Prefetch:PreStrategyManager", appId + " ->host is preWhiteList ->" + strB);
                                Object objA2 = a.a(PreHtmStrategyProxy.class);
                                Intrinsics.f(objA2, "get(PreHtmStrategyProxy::class.java)");
                                PreHtmStrategyProxy.a.b((PreHtmStrategyProxy) objA2, context, strB, null, 4, null);
                            } else {
                                TmcLogger.c("Prefetch:PreStrategyManager", appId + " ->host is not preWhiteList ->" + strB + ' ');
                            }
                        }
                    } else {
                        TmcLogger.f("Prefetch:PreStrategyManager", appId + " ->checkEnablePreHtmlConfig enable status is false");
                    }
                } else if (Intrinsics.b(str, "preAppInfo")) {
                    if (f31651a.l()) {
                        TmcLogger.c("Prefetch:PreStrategyManager", "CONFIG_PREAPPINFO ->" + appId + ' ');
                        c0.a aVar = c0.a.f14531a;
                        Intrinsics.g(context, "context");
                        Intrinsics.g(appId, "appId");
                        try {
                            if (c0.a.f14532b.contains(appId)) {
                                TmcLogger.f(c0.a.f14533c, "preAppinfoCdn appId is exist");
                            } else {
                                AppModel appModel2 = ((TmcAppInfoManager) a.a(TmcAppInfoManager.class)).getAppModel(context, lb.a.f70163b.a(appId));
                                if (appModel2 != null) {
                                    TmcLogger.c(c0.a.f14533c, "preAppinfoCdn put " + appId);
                                    c0.a.f14532b.put(appId, appModel2);
                                }
                            }
                        } catch (Throwable th2) {
                            TmcLogger.g(c0.a.f14533c, "preAppinfoCdn", th2);
                        }
                    } else {
                        TmcLogger.f("Prefetch:PreStrategyManager", "CONFIG_PREAPPINFO enable status is false");
                    }
                } else if (Intrinsics.b(str, "rendering")) {
                    hd.k.a("CONFIG_RENDERING ->", appId, "Prefetch:PreStrategyManager");
                } else if (Intrinsics.b(str, "preOfflinePackage")) {
                    if (f31651a.o()) {
                        TmcLogger.c("Prefetch:PreStrategyManager", "CONFIG_OFFLINEPACKAGE ->" + appId + ' ');
                        c0.b bVar = c0.b.f14534a;
                        Intrinsics.g(context, "context");
                        Intrinsics.g(appId, "appId");
                        try {
                            TmcLogger.f("PreOfflinePackageStrategy", "start preOfflinePackage appId = " + appId + ", already exist size = " + ((CopyOnWriteArrayList) c0.b.f14535b).size());
                            if (((CopyOnWriteArrayList) c0.b.f14535b).size() >= c0.b.f14536c) {
                                TmcLogger.f("PreOfflinePackageStrategy", "preOfflinePackage failed, because requestNum >= " + c0.b.f14536c + " return");
                            } else if (((CopyOnWriteArrayList) c0.b.f14535b).contains(appId)) {
                                TmcLogger.f("PreOfflinePackageStrategy", appId + " preOffline task was processing. ");
                            } else {
                                ((CopyOnWriteArrayList) c0.b.f14535b).add(appId);
                                OfflineManager.u(appId, true, new OooOOO0(appId));
                            }
                        } catch (Throwable th3) {
                            TmcLogger.h("PreOfflinePackageStrategy", th3);
                        }
                    } else {
                        TmcLogger.f("Prefetch:PreStrategyManager", "CONFIG_OFFLINEPACKAGE enable status is false");
                    }
                } else if (Intrinsics.b(str, "offScreenRender")) {
                    hd.k.a("CONFIG_OFF_SCREEN_RENDER ->", appId, "Prefetch:PreStrategyManager");
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                }
            }
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            TmcLogger.f("Prefetch:PreStrategyManager", "executePrefetchConfig list is null");
        }
    }

    public final boolean e() {
        try {
            return MiniAppConfigHelper.f30370a.b("enableOpenBrowserConfig", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
    
        if (r2 == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(Context context, LauncherPreStrategyModel launcherPreStrategyModel) {
        String str;
        String str2;
        Object next;
        ArrayList<String> whiteModelList;
        Object next2;
        if (context == null) {
            return false;
        }
        try {
            Long validTime = launcherPreStrategyModel.getValidTime();
            long jLongValue = validTime != null ? validTime.longValue() : -1L;
            if (jLongValue > 0 && System.currentTimeMillis() > jLongValue) {
                TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " config is already expired.");
                return false;
            }
            if (!NetworkUtils.r()) {
                TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " current network is not connected.");
                return false;
            }
            boolean zT = NetworkUtils.t();
            Integer netType = launcherPreStrategyModel.getNetType();
            if (netType == null || netType.intValue() != 1 || zT) {
                Integer netType2 = launcherPreStrategyModel.getNetType();
                if (netType2 != null) {
                    if (netType2.intValue() == 2) {
                    }
                }
                String str3 = Build.MODEL;
                ArrayList<String> blackModelList = launcherPreStrategyModel.getBlackModelList();
                String str4 = null;
                Object obj = null;
                if (blackModelList != null) {
                    Iterator<T> it = blackModelList.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                    } while (!kotlin.text.l.v((String) next2, str3, true));
                    str = (String) next2;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + ' ' + str3 + " in blackModelList. ");
                    return false;
                }
                ArrayList<String> whiteModelList2 = launcherPreStrategyModel.getWhiteModelList();
                if (whiteModelList2 != null && !whiteModelList2.isEmpty() && (whiteModelList = launcherPreStrategyModel.getWhiteModelList()) != null && !whiteModelList.contains(str3)) {
                    TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + ' ' + str3 + " not in whiteModelList. ");
                    return false;
                }
                String strA = c0.a(context);
                ArrayList<String> blackCountryList = launcherPreStrategyModel.getBlackCountryList();
                if (blackCountryList != null) {
                    Iterator<T> it2 = blackCountryList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (!kotlin.text.l.v((String) next, strA, true));
                    str2 = (String) next;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + ' ' + strA + " in blackCountryList. ");
                    return false;
                }
                ArrayList<String> whiteCountryList = launcherPreStrategyModel.getWhiteCountryList();
                if (whiteCountryList != null && !whiteCountryList.isEmpty()) {
                    ArrayList<String> whiteCountryList2 = launcherPreStrategyModel.getWhiteCountryList();
                    if (whiteCountryList2 != null) {
                        for (Object obj2 : whiteCountryList2) {
                            if (kotlin.text.l.v((String) obj2, strA, true)) {
                                obj = obj2;
                                break;
                            }
                        }
                        str4 = (String) obj;
                    }
                    if (str4 == null || str4.length() == 0) {
                        TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + ' ' + strA + " not in whiteCountryList. ");
                        return false;
                    }
                }
                AppModel appModel = ((TmcAppInfoManager) a.a(TmcAppInfoManager.class)).getAppModel(context, new lb.a("100000"));
                if (appModel == null) {
                    return false;
                }
                String deployVersion = appModel.getDeployVersion();
                if (deployVersion == null) {
                    deployVersion = "";
                }
                String lowestFrameworkVersion = launcherPreStrategyModel.getLowestFrameworkVersion();
                String highestFrameworkVersion = launcherPreStrategyModel.getHighestFrameworkVersion();
                if (lowestFrameworkVersion != null && lowestFrameworkVersion.length() != 0 && MiniAppLaunch.f31784a.D(lowestFrameworkVersion, deployVersion)) {
                    TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " cur framework:" + deployVersion + " < " + lowestFrameworkVersion);
                    return false;
                }
                if (highestFrameworkVersion != null && highestFrameworkVersion.length() != 0 && MiniAppLaunch.f31784a.D(deployVersion, highestFrameworkVersion)) {
                    TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " cur framework:" + deployVersion + " > " + highestFrameworkVersion);
                    return false;
                }
                String curSDKVersion = ((IPackageConfig) a.a(IPackageConfig.class)).getDevSDKVersion();
                String lowestSDKVersion = launcherPreStrategyModel.getLowestSDKVersion();
                String highestSDKVersion = launcherPreStrategyModel.getHighestSDKVersion();
                if (lowestSDKVersion != null && lowestSDKVersion.length() != 0) {
                    MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                    Intrinsics.f(curSDKVersion, "curSDKVersion");
                    if (miniAppLaunch.D(lowestSDKVersion, curSDKVersion)) {
                        TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " cur sdk:" + curSDKVersion + " < " + lowestSDKVersion);
                        return false;
                    }
                }
                if (highestSDKVersion != null && highestSDKVersion.length() != 0) {
                    MiniAppLaunch miniAppLaunch2 = MiniAppLaunch.f31784a;
                    Intrinsics.f(curSDKVersion, "curSDKVersion");
                    if (miniAppLaunch2.D(curSDKVersion, highestSDKVersion)) {
                        TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " cur sdk:" + curSDKVersion + " > " + highestSDKVersion);
                        return false;
                    }
                }
                return true;
            }
            TmcLogger.f("Prefetch:PreStrategyManager", launcherPreStrategyModel.getAppId() + " netType disallow, config.netType = " + launcherPreStrategyModel.getNetType());
            return false;
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:PreStrategyManager", th2);
            return false;
        }
    }

    public final boolean g(Context context, String appId, String str) {
        LauncherPreStrategyModel launcherPreStrategyModel;
        JsonArray asJsonArray;
        Object next;
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            if (f.f13872a.d()) {
                TmcLogger.f("Prefetch:PreStrategyManager", "new prefetch config. not open browser.");
                return false;
            }
            if (!e()) {
                TmcLogger.f("Prefetch:PreStrategyManager", "checkEnableOpenBrowserConfig is false");
                return false;
            }
            String strI = i(str);
            if (strI != null && strI.length() != 0) {
                LauncherPreStrategyBaseModel launcherPreStrategyBaseModelB = g.f13878a.b(context);
                if (launcherPreStrategyBaseModelB == null) {
                    TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyConfig is null");
                    return false;
                }
                ArrayList<LauncherPreStrategyModel> configList = launcherPreStrategyBaseModelB.getConfigList();
                JsonElement jsonElement = null;
                if (configList != null) {
                    Iterator<T> it = configList.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(((LauncherPreStrategyModel) next).getAppId(), appId));
                    launcherPreStrategyModel = (LauncherPreStrategyModel) next;
                } else {
                    launcherPreStrategyModel = null;
                }
                JsonObject commonConfig = launcherPreStrategyModel != null ? launcherPreStrategyModel.getCommonConfig() : null;
                if (commonConfig == null) {
                    TmcLogger.f("Prefetch:PreStrategyManager", appId + " preStrategyConfig.commonConfig is null");
                    return false;
                }
                Long openBrowserTime = launcherPreStrategyModel.getOpenBrowserTime();
                long jLongValue = openBrowserTime != null ? openBrowserTime.longValue() : -1L;
                if (jLongValue >= 0 && jLongValue <= System.currentTimeMillis()) {
                    JsonElement jsonElement2 = commonConfig.get(strI);
                    if (jsonElement2 != null && (asJsonArray = jsonElement2.getAsJsonArray()) != null) {
                        for (JsonElement jsonElement3 : asJsonArray) {
                            if (Intrinsics.b(jsonElement3.getAsString(), "allowOpenBrowser")) {
                                jsonElement = jsonElement3;
                                break;
                            }
                        }
                        if (jsonElement != null) {
                            return true;
                        }
                    }
                    return false;
                }
                TmcLogger.f("Prefetch:PreStrategyManager", appId + " preStrategyConfig.openBrowserTime = " + jLongValue + " is not suitable.");
                return false;
            }
            TmcLogger.f("Prefetch:PreStrategyManager", "openScene is null");
            return false;
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:PreStrategyManager", th2);
            return false;
        }
    }

    public final boolean h(String str) {
        try {
            if (f31654d == null || System.currentTimeMillis() - f31655e > f31656f) {
                f31655e = System.currentTimeMillis();
                f31654d = (HashMap) k.e(MiniAppConfigHelper.f30370a.e("enablePreManagerCongig", "{\"keyZeroRecentData\":true,\"keyZeroMinicardData\":true,\"keyZeroBannerData\":true,\"keyFullMinicardData\":true,\"keyFullRecentMiniData\":true,\"keyAzRecentData\":true,\"keyFullSearchAppData\":true,\"keyZeroMinicardUpdate\":true,\"keyMiniAppStart\":true}"), HashMap.class);
            }
            HashMap<String, Boolean> map = f31654d;
            Boolean bool = map != null ? map.get(str) : null;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x0065 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String i(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 1448635040:
                    if (str.equals("100001")) {
                        return "fullSearchApp";
                    }
                    break;
                case 1448635042:
                    if (str.equals("100003")) {
                        return "zeroCard";
                    }
                    break;
                case 1448635048:
                    if (str.equals("100009")) {
                        return "miniappCenterRecommend";
                    }
                    break;
                case 1449558561:
                    if (str.equals("110001")) {
                        return "fullSearchApp";
                    }
                    break;
                case 1449558562:
                    if (str.equals("110002")) {
                        return "fullSearchRecent";
                    }
                    break;
                case 1449558564:
                    if (str.equals("110004")) {
                        return "azRecent";
                    }
                    break;
                case 1449558565:
                    if (str.equals("110005")) {
                        return "zeroRecent";
                    }
                    break;
                case 1449558594:
                    if (str.equals("110013")) {
                        return "fullSearchCard";
                    }
                    break;
            }
        }
        return null;
    }

    public final ArrayList<LauncherPreDataModel> j(Context context, String key, String str) {
        ArrayList<LauncherPreDataModel> arrayList;
        Intrinsics.g(key, "key");
        if (context == null || str == null) {
            arrayList = null;
        } else {
            try {
                TmcLogger.c("Prefetch:PreStrategyManager", "preStrategyProcessing -> " + key + " -> " + str);
                arrayList = (ArrayList) k.e(str, new TypeToken<List<LauncherPreDataModel>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$getLauncherData$1$1$1
                }.getType());
            } catch (Throwable th2) {
                TmcLogger.g("Prefetch:PreStrategyManager", "getLauncherData", th2);
                return new ArrayList<>();
            }
        }
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final boolean l() {
        try {
            return MiniAppConfigHelper.f30370a.b("enableAppinfoPreConfig", true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean m() {
        try {
            return MiniAppConfigHelper.f30370a.b("enablePreConfig", true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean n() {
        try {
            return MiniAppConfigHelper.f30370a.b("enablePreHtmlPreConfig", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean o() {
        try {
            return MiniAppConfigHelper.f30370a.b("enableOfflinePackageConfig", true);
        } catch (Throwable unused) {
            return false;
        }
    }
}
