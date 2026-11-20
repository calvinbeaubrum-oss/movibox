package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.cloud.hisavana.sdk.a3;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.model.Subpackage;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.HttpUrl;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class AppUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppUtils f31011a = new AppUtils();

    @JvmStatic
    @JvmOverloads
    public static final void A(App app, String str, Map<String, String> map) {
        Intrinsics.g(app, "app");
        Page activePage = app.getActivePage();
        if (activePage == null) {
            return;
        }
        y(activePage, str, true, map);
    }

    public static /* synthetic */ void B(App app, String str, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = null;
        }
        A(app, str, map);
    }

    @JvmStatic
    public static final boolean C() {
        return MiniAppConfigHelper.f30370a.b("enableMiniSubPackage", true);
    }

    @JvmStatic
    public static final void a(Bundle bundle, Bundle bundle2) {
        String string;
        if (bundle != null) {
            try {
                string = bundle.getString("page");
            } catch (Throwable th2) {
                TmcLogger.g("AppUtils", th2.getMessage(), th2);
                return;
            }
        } else {
            string = null;
        }
        String str = "";
        if (string != null && string.length() != 0) {
            if (t(bundle2, string)) {
                bundle.putString("usedPage", string);
            }
            String string2 = bundle.getString("page");
            if (string2 == null) {
                string2 = "";
            }
            bundle.putString("pageCopy", string2);
            bundle.remove("page");
        }
        String string3 = bundle2 != null ? bundle2.getString("page") : null;
        if (string3 != null && string3.length() != 0) {
            if (t(bundle2, string3)) {
                bundle2.putString("usedPage", string3);
            }
            String string4 = bundle2.getString("page");
            if (string4 != null) {
                str = string4;
            }
            bundle2.putString("pageCopy", str);
            bundle2.remove("page");
        }
    }

    public static /* synthetic */ boolean f(AppUtils appUtils, Context context, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return appUtils.e(context, z11);
    }

    @JvmStatic
    public static final boolean h() {
        try {
            boolean zIsLoggable = Log.isLoggable("miniapp.webviewdebug", 3);
            TmcLogger.c("AppUtils", "enableWebViewDebugger -> " + zIsLoggable);
            return zIsLoggable;
        } catch (Throwable th2) {
            TmcLogger.g("AppUtils", "enableWebViewDebugger", th2);
            return false;
        }
    }

    public static /* synthetic */ String k(AppUtils appUtils, AppModel appModel, SubPackageInfo subPackageInfo, Boolean bool, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        return appUtils.j(appModel, subPackageInfo, bool);
    }

    public static /* synthetic */ String m(AppUtils appUtils, AppModel appModel, SubPackageInfo subPackageInfo, Boolean bool, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        return appUtils.l(appModel, subPackageInfo, bool);
    }

    public static /* synthetic */ String p(AppUtils appUtils, AppModel appModel, SubPackageInfo subPackageInfo, Boolean bool, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        return appUtils.o(appModel, subPackageInfo, bool);
    }

    @JvmStatic
    public static final boolean q(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("extraExitPageData")) {
            return false;
        }
        boolean z11 = bundle.getBoolean("extraExitPageData", false);
        bundle.remove("extraExitPageData");
        return z11;
    }

    @JvmStatic
    public static final boolean r(Page page, AppLoadResult appLoadResult) {
        MiniAppConfigModel miniAppConfigModel;
        List<String> list;
        List<String> list2;
        if (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null || (list = miniAppConfigModel.pages) == null || !(!list.isEmpty())) {
            return false;
        }
        MiniAppConfigModel miniAppConfigModel2 = appLoadResult.appConfigModel;
        return kotlin.text.l.w(page != null ? page.getPagePath() : null, (miniAppConfigModel2 == null || (list2 = miniAppConfigModel2.pages) == null) ? null : list2.get(0), false, 2, null) || (page != null && page.isTabPage());
    }

    @JvmStatic
    public static final boolean t(Bundle bundle, String str) {
        MiniAppConfigModel miniAppConfigModel;
        List<String> list;
        MiniAppConfigModel miniAppConfigModel2;
        List<String> list2;
        MiniAppConfigModel miniAppConfigModel3;
        List<Subpackage> list3;
        List<String> pages;
        AppLoadResult appLoadResult = (AppLoadResult) com.cloud.tmc.kernel.utils.a.d(bundle, "appLoadResult");
        if (C()) {
            if (appLoadResult != null && (miniAppConfigModel3 = appLoadResult.appConfigModel) != null && (list3 = miniAppConfigModel3.subPackages) != null) {
                for (Subpackage subpackage : list3) {
                    List<String> pages2 = subpackage.getPages();
                    if (pages2 != null && !pages2.isEmpty() && (pages = subpackage.getPages()) != null) {
                        Iterator<T> it = pages.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.b(subpackage.getRoot() + '/' + ((String) it.next()), str)) {
                                return true;
                            }
                        }
                    }
                }
            }
            if (appLoadResult != null && (miniAppConfigModel2 = appLoadResult.appConfigModel) != null && (list2 = miniAppConfigModel2.pages) != null) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.b((String) it2.next(), str)) {
                        return true;
                    }
                }
            }
        } else if (appLoadResult != null && (miniAppConfigModel = appLoadResult.appConfigModel) != null && (list = miniAppConfigModel.pages) != null) {
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                if (Intrinsics.b((String) it3.next(), str)) {
                    return true;
                }
            }
        }
        return (str != null && kotlin.text.l.L(str, "http://", false, 2, null)) || (str != null && kotlin.text.l.L(str, AgentPageJsBridge.HTTPS, false, 2, null));
    }

    @JvmStatic
    @JvmOverloads
    public static final void x(Page page, String eventName, Map<String, String> map) {
        AppLoadResult appLoadResult;
        String strA;
        String str;
        AppModel appModel;
        AppModel appModel2;
        List<String> list;
        List<String> list2;
        Intrinsics.g(eventName, "eventName");
        TmcLogger.c("subPkg", "sendAppOrPageReadyToRender");
        String templateMiniappId = null;
        zc.i render = page != null ? page.getRender() : null;
        if (render == null) {
            return;
        }
        TmcLogger.c("subPkg", "sendAppOrPageReadyToRender 01");
        App app = page.getApp();
        if (app == null || (appLoadResult = (AppLoadResult) app.getData(AppLoadResult.class)) == null) {
            return;
        }
        TmcLogger.c("subPkg", "sendAppOrPageReadyToRender 02");
        MiniAppConfigModel miniAppConfigModel = appLoadResult.appConfigModel;
        if (miniAppConfigModel == null || (strA = com.cloud.tmc.kernel.utils.o.a(miniAppConfigModel)) == null) {
            return;
        }
        TmcLogger.c("subPkg", "sendAppOrPageReadyToRender 03");
        JsonElement string = JsonParser.parseString(strA);
        JsonObject asJsonObject = string != null ? string.getAsJsonObject() : null;
        MiniAppConfigModel miniAppConfigModel2 = appLoadResult.appConfigModel;
        if (miniAppConfigModel2 == null || (list = miniAppConfigModel2.pages) == null || !(!list.isEmpty())) {
            str = "";
        } else {
            MiniAppConfigModel miniAppConfigModel3 = appLoadResult.appConfigModel;
            str = (miniAppConfigModel3 == null || (list2 = miniAppConfigModel3.pages) == null) ? null : list2.get(0);
        }
        TmcLogger.c("subPkg", "sendAppOrPageReadyToRender firstPage:" + str);
        z.a aVarA = z.a().d("url", str).d("renderId", render.b()).d("appPath", "").d("pagePath", page.getPagePath()).a("appJson", asJsonObject);
        Intrinsics.f(aVarA, "create()\n            .ad…EY_APP_JSON, appConfigJo)");
        try {
            App app2 = page.getApp();
            aVarA.d("miniappId", app2 != null ? app2.getAppId() : null);
            AppUtils appUtils = f31011a;
            App app3 = page.getApp();
            if (appUtils.g((app3 == null || (appModel2 = app3.getAppModel()) == null) ? null : appModel2.getMiniappSubtype())) {
                App app4 = page.getApp();
                if (app4 != null && (appModel = app4.getAppModel()) != null) {
                    templateMiniappId = appModel.getTemplateMiniappId();
                }
                aVarA.d("commonresId", templateMiniappId);
            }
        } catch (Throwable th2) {
            TmcLogger.g("AppUtils", "", th2);
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVarA.d(entry.getKey(), entry.getValue());
            }
        }
        ac.a renderBridge = render.getRenderBridge();
        if (renderBridge != null) {
            renderBridge.c("__appReady", aVarA.e());
        }
        TmcLogger.c("subPkg", "sendAppOrPageReadyToRender dispatchEventToRender eventName:" + eventName);
        hb.a.a(render, eventName, aVarA.e());
    }

    @JvmStatic
    @JvmOverloads
    public static final void y(Page page, String str, boolean z11, Map<String, ? extends Object> map) {
        lb.j jVar;
        App app;
        IEngine engineProxy;
        EngineRouter engineRouter;
        gd.b workerById;
        String strA;
        if (page == null || (jVar = (lb.j) page.getData(lb.j.class)) == null || (app = page.getApp()) == null || (engineProxy = app.getEngineProxy()) == null || (engineRouter = engineProxy.getEngineRouter()) == null || (workerById = engineRouter.getWorkerById(jVar.f70208a)) == null) {
            return;
        }
        JsonObject asJsonObject = null;
        if (map != null) {
            try {
                strA = com.cloud.tmc.kernel.utils.o.a(map);
            } catch (Throwable unused) {
            }
        } else {
            strA = null;
        }
        JsonElement string = JsonParser.parseString(strA);
        if (string != null) {
            asJsonObject = string.getAsJsonObject();
        }
        z.a aVarD = z.b(asJsonObject).d("url", page.getPagePath()).d("renderId", page.getPageId());
        Intrinsics.f(aVarD, "create(extParams)\n      …Y_RENDER_ID, page.pageId)");
        if (z11) {
            hb.a.c(workerById, str, aVarD.e());
        } else {
            hb.a.b(workerById, str, aVarD.e());
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void z(App app, String str) {
        Intrinsics.g(app, "app");
        B(app, str, null, 4, null);
    }

    public final boolean b() {
        int iC = 35;
        try {
            iC = MiniAppConfigHelper.f30370a.c("showAddHomeCustomDialog", 35);
        } catch (Throwable unused) {
        }
        return Build.VERSION.SDK_INT < iC;
    }

    public final boolean c(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            Object objD = com.cloud.tmc.miniutils.util.k.d(MiniAppConfigHelper.f30370a.e("miniGoHomeAllowId", "[\"1000616124851466240\"]"), List.class);
            List arrayList = objD instanceof List ? (List) objD : null;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            return arrayList.contains(appId);
        } catch (Throwable th2) {
            TmcLogger.h("AppUtils", th2);
            return false;
        }
    }

    public final boolean d(String str) {
        String privacyAgreementDialogWhiteListStr;
        ArrayList arrayList;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            privacyAgreementDialogWhiteListStr = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("privacyAgreementDialogWhiteListV4", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } catch (Throwable th2) {
            TmcLogger.h("AppUtils", th2);
            privacyAgreementDialogWhiteListStr = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        try {
            Intrinsics.f(privacyAgreementDialogWhiteListStr, "privacyAgreementDialogWhiteListStr");
            Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.integration.utils.AppUtils$checkMiniAppPrivacyAgreementDialogWhiteList$whiteList$1
            }.getType();
            Intrinsics.f(type, "object :\n               …ayList<String>>() {}.type");
            arrayList = (ArrayList) TmcGsonUtils.e(privacyAgreementDialogWhiteListStr, type);
        } catch (Throwable th3) {
            TmcLogger.h("AppUtils", th3);
            try {
                Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.integration.utils.AppUtils$checkMiniAppPrivacyAgreementDialogWhiteList$whiteList$2
                }.getType();
                Intrinsics.f(type2, "object : TypeToken<ArrayList<String>>() {}.type");
                arrayList = (ArrayList) TmcGsonUtils.e(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, type2);
            } catch (Throwable th4) {
                TmcLogger.h("AppUtils", th4);
                arrayList = new ArrayList();
            }
        }
        return arrayList.contains(str);
    }

    public final boolean e(Context context, boolean z11) {
        Intrinsics.g(context, "context");
        if (z11) {
            try {
                if (MiniAppConfigHelper.f30370a.b("showAddHomeCustomDialog", true) && s(context) && b()) {
                    return true;
                }
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }

    public final boolean g(Integer num) {
        return num != null && num.intValue() == 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String i(Context context) {
        Context applicationContext;
        String packageName = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getPackageName();
        if (packageName == null) {
            return "";
        }
        switch (packageName.hashCode()) {
            case -2118895220:
                if (!packageName.equals("com.community.mbox.afen")) {
                    return packageName;
                }
                break;
            case -2118895185:
                if (!packageName.equals("com.community.mbox.affr")) {
                    return packageName;
                }
                break;
            case -1517286993:
                if (!packageName.equals("com.community.mbox.ar")) {
                    return packageName;
                }
                break;
            case -1517286759:
                if (!packageName.equals("com.community.mbox.id")) {
                    return packageName;
                }
                break;
            case -1517286749:
                if (!packageName.equals("com.community.mbox.in")) {
                    return packageName;
                }
                break;
            case -1517286696:
                if (!packageName.equals("com.community.mbox.ke")) {
                    return packageName;
                }
                break;
            case -1517286637:
                if (!packageName.equals("com.community.mbox.mb")) {
                    return packageName;
                }
                break;
            case -1517286601:
                if (!packageName.equals("com.community.mbox.ng")) {
                    return packageName;
                }
                break;
            case -1517286538:
                if (!packageName.equals("com.community.mbox.ph")) {
                    return packageName;
                }
                break;
            case -1517286463:
                if (!packageName.equals("com.community.mbox.ru")) {
                    return packageName;
                }
                break;
            case -1517286452:
                if (!packageName.equals("com.community.mbox.sa")) {
                    return packageName;
                }
                break;
            case -950419827:
                if (!packageName.equals("com.community.moviebox")) {
                    return packageName;
                }
                break;
            case -434014960:
                if (!packageName.equals("com.vskit.lite")) {
                    return packageName;
                }
                break;
            case 591919119:
                if (!packageName.equals("com.community.oneroom")) {
                    return packageName;
                }
                break;
            case 1760738547:
                if (!packageName.equals("com.yomobigroup.chat")) {
                    return packageName;
                }
                break;
            default:
                return packageName;
        }
        return "com.community.oneroom";
    }

    public final String j(AppModel appModel, SubPackageInfo subPackageInfo, Boolean bool) {
        Intrinsics.g(appModel, "appModel");
        if (Intrinsics.b(Boolean.TRUE, bool)) {
            return appModel.getPackageUrl_MD5();
        }
        return subPackageInfo != null ? subPackageInfo.getSubPackageUrlMD5() : appModel.getMainPackageUrlEncryption();
    }

    public final String l(AppModel appModel, SubPackageInfo subPackageInfo, Boolean bool) {
        Intrinsics.g(appModel, "appModel");
        if (Intrinsics.b(Boolean.TRUE, bool)) {
            return appModel.getAppId();
        }
        return subPackageInfo != null ? subPackageInfo.getRoot() : "mainPkg";
    }

    public final String n(AppModel appModel) {
        String packageUrl;
        if (appModel != null) {
            if (f31011a.g(appModel.getMiniappSubtype())) {
                TmcLogger.c("AppUtils", "getPackageDownloadUrl: commonPackageUrl = " + appModel.getCompatiblePackageUrl());
                packageUrl = appModel.getCompatiblePackageUrl();
            } else {
                TmcLogger.c("AppUtils", "getPackageDownloadUrl: packageUrl = " + appModel.getPackageUrl());
                packageUrl = appModel.getPackageUrl();
            }
            if (packageUrl != null) {
                return packageUrl;
            }
        }
        return "";
    }

    public final String o(AppModel appModel, SubPackageInfo subPackageInfo, Boolean bool) {
        String appId;
        Intrinsics.g(appModel, "appModel");
        try {
            if (Intrinsics.b(Boolean.TRUE, bool)) {
                appId = appModel.getAppId();
            } else if (subPackageInfo != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                Object[] objArr = new Object[2];
                String appId2 = appModel.getAppId();
                if (appId2 == null) {
                    appId2 = "";
                }
                objArr[0] = appId2;
                String root = subPackageInfo.getRoot();
                if (root == null) {
                    root = "";
                }
                objArr[1] = root;
                appId = String.format("%s|%s", Arrays.copyOf(objArr, 2));
                Intrinsics.f(appId, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
                Object[] objArr2 = new Object[2];
                String appId3 = appModel.getAppId();
                if (appId3 == null) {
                    appId3 = "";
                }
                objArr2[0] = appId3;
                objArr2[1] = "mainPkg";
                appId = String.format("%s|%s", Arrays.copyOf(objArr2, 2));
                Intrinsics.f(appId, "format(format, *args)");
            }
            return appId;
        } catch (Throwable th2) {
            TmcLogger.h("", th2);
            return "";
        }
    }

    public final boolean s(Context context) {
        return true;
    }

    public final boolean u(Context context) {
        Context applicationContext;
        String packageName = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getPackageName();
        return kotlin.text.l.v(packageName, "com.community.oneroom", true) || kotlin.text.l.v(packageName, "com.community.moviebox", true) || kotlin.text.l.v(packageName, "com.community.mbox.afen", true) || kotlin.text.l.w(packageName, "com.community.mbox.affr", false, 2, null) || kotlin.text.l.v(packageName, "com.community.mbox.ar", true) || kotlin.text.l.v(packageName, "com.community.mbox.id", true) || kotlin.text.l.v(packageName, "com.community.mbox.in", true) || kotlin.text.l.v(packageName, "com.community.mbox.ke", true) || kotlin.text.l.v(packageName, "com.community.mbox.mb", true) || kotlin.text.l.v(packageName, "com.community.mbox.ng", true) || kotlin.text.l.v(packageName, "com.community.mbox.ph", true) || kotlin.text.l.v(packageName, "com.community.mbox.ru", true) || kotlin.text.l.v(packageName, "com.community.mbox.sa", true) || kotlin.text.l.v(packageName, "com.yomobigroup.chat", true) || kotlin.text.l.v(packageName, "com.vskit.lite", true);
    }

    public final boolean v(Context context, String str) {
        boolean zW = false;
        if (context != null && str != null && str.length() != 0) {
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    return false;
                }
                if (s(context)) {
                    zW = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(com.cloud.tmc.miniutils.util.e0.a(), "miniKeyStorageAddHome", "addHomeStatus_" + str, false);
                } else {
                    zW = w(context, str);
                }
            } catch (Throwable th2) {
                TmcLogger.h("apputils", th2);
            }
        }
        return zW;
    }

    public final boolean w(Context context, String str) {
        ShortcutManager shortcutManagerA;
        Intrinsics.g(context, "context");
        if (Build.VERSION.SDK_INT < 26 || (shortcutManagerA = com.bytedance.sdk.openadsdk.api.init.b.a(context.getSystemService(com.bytedance.sdk.openadsdk.api.init.a.a()))) == null || !shortcutManagerA.isRequestPinShortcutSupported()) {
            return false;
        }
        List pinnedShortcuts = shortcutManagerA.getPinnedShortcuts();
        Intrinsics.f(pinnedShortcuts, "sm.pinnedShortcuts");
        boolean zB = false;
        for (int i11 = 0; i11 < pinnedShortcuts.size() && !zB; i11++) {
            zB = Intrinsics.b(a3.a(pinnedShortcuts.get(i11)).getId(), str);
        }
        return zB;
    }
}
