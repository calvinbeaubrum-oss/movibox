package com.cloud.tmc.integration.bridge;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.proxy.IAdActivityGetProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.PushConstants;
import com.transsion.web.api.WebConstants;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NavigateBridge implements BridgeExtension {

    /* JADX INFO: compiled from: source.java */
    public class a implements uc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uc.b f30545b;

        public a(bc.a aVar, uc.b bVar) {
            this.f30544a = aVar;
            this.f30545b = bVar;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            Map<String, Object> data = aVar.getData();
            if (data != null && data.containsKey("ad_click")) {
                List list = (List) data.get("ad_click");
                if (this.f30544a != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("ad_click", com.cloud.tmc.miniutils.util.k.j(list));
                    this.f30544a.d(jsonObject);
                }
            }
            if (data == null || data.get("finish") != "true") {
                return true;
            }
            this.f30545b.a("adLandingPage");
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements uc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uc.b f30548b;

        public b(bc.a aVar, uc.b bVar) {
            this.f30547a = aVar;
            this.f30548b = bVar;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            Map<String, Object> data = aVar.getData();
            if (data != null && data.containsKey("ad_click")) {
                List list = (List) data.get("ad_click");
                if (this.f30547a != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("ad_click", com.cloud.tmc.miniutils.util.k.j(list));
                    this.f30547a.d(jsonObject);
                }
            }
            if (data == null || data.get("finish") != "true") {
                return true;
            }
            this.f30548b.a("adFromPage");
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements uc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uc.b f30550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30552c;

        public c(uc.b bVar, bc.a aVar, String str) {
            this.f30550a = bVar;
            this.f30551b = aVar;
            this.f30552c = str;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            this.f30550a.a("adPersonalizationPage");
            if (this.f30551b == null || !this.f30552c.equals(aVar.getName())) {
                return true;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, Boolean.TRUE);
            jsonObject.addProperty(TrackingKey.TRIGGER_ID, this.f30552c);
            this.f30551b.d(jsonObject);
            return true;
        }
    }

    public static /* synthetic */ Unit c(App app, int i11, boolean z11, JsonObject jsonObject) {
        app.popTo(i11, z11, jsonObject);
        return null;
    }

    public final boolean b(Bundle bundle, String str) {
        MiniAppConfigModel miniAppConfigModel;
        MiniAppConfigModel.TabBarBean tabBarBean;
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        AppLoadResult appLoadResult = (AppLoadResult) com.cloud.tmc.kernel.utils.a.d(bundle, "appLoadResult");
        if (appLoadResult != null && (miniAppConfigModel = appLoadResult.appConfigModel) != null && (tabBarBean = miniAppConfigModel.tabBar) != null && (list = tabBarBean.list) != null) {
            Iterator<MiniAppConfigModel.TabBarBean.ListBean> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().pagePath, Uri.parse(str).getPath())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void exit(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            app.exit();
            if (aVar != null) {
                aVar.d(new JsonObject());
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void exitMiniProgram(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        exit(app, aVar);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateBack(@cc.g(name = {"delta"}) final int i11, @cc.g(name = {"autoExit"}) final boolean z11, @cc.g(name = {"params"}) String str, @cc.f(App.class) final App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        final JsonObject jsonObject = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                jsonObject = JsonParser.parseString(str).getAsJsonObject();
            }
        } catch (Exception e11) {
            com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "parse Json fail : " + e11);
        }
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        if (!xb.c.a(page, new Function0() { // from class: com.cloud.tmc.integration.bridge.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavigateBridge.c(app, i11, z11, jsonObject);
            }
        })) {
            app.popTo(i11, z11, jsonObject);
        }
        if (aVar != null) {
            aVar.d(new JsonObject());
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateBackToHeaderPage(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            app.backToHeaderPage();
            if (aVar != null) {
                aVar.d(new JsonObject());
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateBackToHomePage(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_NAV_HOME_PRESSED, "");
            app.exitToHomePage();
        } catch (Throwable th2) {
            TmcLogger.g("NavigateBridge", th2.getMessage(), th2);
        }
        if (aVar != null) {
            aVar.d(new JsonObject());
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateTo(@cc.g(name = {"url"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "navigateTo url is empty!!!");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
        app.putPageType(str, 1);
        app.putRouteType(str, "navigateTo");
        Bundle sceneParams = app.getSceneParams();
        sceneParams.putString("navigationType", "navigateTo");
        app.pushPage(str, app.getStartParams(), sceneParams);
        if (aVar != null) {
            aVar.d(new JsonObject());
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToAdLandingPage(@cc.g(name = {"url"}) String str, @cc.g({"adInfo"}) String str2, @cc.g(name = {"adsDTO"}) String str3, @cc.g(name = {"pointData"}) String str4, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                Context context = app.getAppContext().getContext();
                Intent intent = new Intent(context, ((IAdActivityGetProxy) tc.a.a(IAdActivityGetProxy.class)).getAdLandingPageActivity());
                intent.setFlags(65536);
                intent.putExtra("ad_landingPage_url", str);
                intent.putExtra("adInfo", str2);
                intent.putExtra("adsDTO", str3);
                intent.putExtra("pointData", str4);
                intent.putExtra(PushConstants.PROVIDER_FIELD_APP_ID, app.getAppId());
                com.cloud.tmc.integration.utils.h.f31061a.a(intent, context);
                uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app);
                eventCenterInstance.b("adLandingPage", new a(aVar, eventCenterInstance));
                context.startActivity(intent);
                return;
            }
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.h("NavigateBridge", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToApp(@cc.f(App.class) App app, @cc.g({"packageName"}) String str, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0) {
                ResolveInfo next = listQueryIntentActivities.iterator().next();
                intent.addFlags(ASTNode.DEOP);
                ActivityInfo activityInfo = next.activityInfo;
                intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                context.startActivity(intent);
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.h("NavigateBridge", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToDeeplink(@cc.f(App.class) App app, @cc.g({WebConstants.FIELD_DEEPLINK}) String str, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "context is null:DP002").e());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "deeplink is empty:DP003").e());
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        try {
            Intent intent = new Intent();
            if (str.startsWith("smsto") && str.split(":").length > 2) {
                String strSubstring = str.substring(0, str.indexOf(":") + 1);
                String strSubstring2 = str.substring(str.indexOf(":") + 1);
                int iIndexOf = strSubstring2.indexOf(":");
                String strSubstring3 = strSubstring2.substring(0, iIndexOf);
                str = strSubstring + strSubstring3;
                intent.putExtra("sms_body", URLDecoder.decode(strSubstring2.substring(iIndexOf + 1), "UTF-8"));
            }
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h("NavigateBridge", th2);
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "deeplink error:DP001," + str).e());
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToDeeplinkInternal(@cc.f(App.class) App app, @cc.g({WebConstants.FIELD_DEEPLINK}) String str, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "context is null:DP002").e());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "deeplink is empty:DP003").e());
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        try {
            Intent intent = new Intent();
            if (str.startsWith("smsto") && str.split(":").length > 2) {
                String strSubstring = str.substring(0, str.indexOf(":") + 1);
                String strSubstring2 = str.substring(str.indexOf(":") + 1);
                int iIndexOf = strSubstring2.indexOf(":");
                String strSubstring3 = strSubstring2.substring(0, iIndexOf);
                str = strSubstring + strSubstring3;
                intent.putExtra("sms_body", URLDecoder.decode(strSubstring2.substring(iIndexOf + 1), "UTF-8"));
            }
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h("NavigateBridge", th2);
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "deeplink error:DP001," + str).e());
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToFormWeb(@cc.f(App.class) App app, @cc.g(name = {"url"}) String str, @cc.g({"adInfo"}) String str2, @cc.g(name = {"adsDTO"}) String str3, @cc.g(name = {"pointData"}) String str4, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                Context context = app.getAppContext().getContext();
                Intent intent = new Intent(context, ((IAdActivityGetProxy) tc.a.a(IAdActivityGetProxy.class)).getAdFormActivity());
                intent.setFlags(65536);
                intent.putExtra("ad_web_form_url", str);
                intent.putExtra("ad_web_ad_info", str2);
                intent.putExtra("adsDTO", str3);
                intent.putExtra("pointData", str4);
                intent.putExtra(PushConstants.PROVIDER_FIELD_APP_ID, app.getAppId());
                com.cloud.tmc.integration.utils.h.f31061a.a(intent, context);
                uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app);
                eventCenterInstance.b("adFromPage", new b(aVar, eventCenterInstance));
                context.startActivity(intent);
                return;
            }
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.h("NavigateBridge", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToOutside(@cc.g(name = {"url"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "navigateToOutside url is empty!!!");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("https") || str.startsWith("miniapp://")) {
            app.pushWebViewPage(str, app.getStartParams(), app.getSceneParams());
            if (aVar != null) {
                aVar.d(new JsonObject());
                return;
            }
            return;
        }
        com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "navigateToOutside url should startwith http or https!!!");
        if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToOutsideBrowser(@cc.g(name = {"url"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            TmcLogger.f("Tmcintegration", "navigateToOutsideBrowser url is empty");
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "navigateToOutsideBrowser url is empty: N001").e());
                return;
            }
            return;
        }
        if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && !str.startsWith("https")) {
            TmcLogger.f("Tmcintegration", "navigateToOutsideBrowser url should startWith http or https");
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "navigateToOutsideBrowser url should startWith http or https: N002").e());
                return;
            }
            return;
        }
        boolean zA = com.cloud.tmc.integration.utils.t.a(app.getAppContext().getContext(), str);
        if (aVar != null) {
            if (zA) {
                aVar.g();
            } else {
                aVar.e(z.a().d("errMsg", "navigateToOutsideBrowser open browser failed: N003").e());
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void navigateToPersonalization(@cc.f(App.class) App app, @cc.g(name = {TrackingKey.TRIGGER_ID}) String str, @cc.g(name = {"url"}) String str2, @cc.g(name = {"adsDTO"}) String str3, @cc.g(name = {"app_id_external"}) String str4, @cc.g(name = {"code_seat_id_external"}) String str5, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                Context context = app.getAppContext().getContext();
                Intent intent = new Intent(context, ((IAdActivityGetProxy) tc.a.a(IAdActivityGetProxy.class)).getAdPersonalizationActivity());
                intent.setFlags(65536);
                intent.putExtra("ad_personalization_url", str2);
                intent.putExtra("adsDTO", str3);
                intent.putExtra(TrackingKey.TRIGGER_ID, str);
                intent.putExtra(PushConstants.PROVIDER_FIELD_APP_ID, app.getAppId());
                intent.putExtra("appIdExternal", str4);
                intent.putExtra("codeSeatIdExternal", str5);
                uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app);
                eventCenterInstance.b("adPersonalizationPage", new c(eventCenterInstance, aVar, str));
                context.startActivity(intent);
                return;
            }
            if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.h("NavigateBridge", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void openExternalApp(@cc.f(App.class) App app, @cc.g({"linkUrl"}) String str, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            if (com.cloud.tmc.kernel.utils.q.a(app.getAppContext().getContext(), str)) {
                aVar.g();
            } else if (aVar != null) {
                aVar.b();
            }
        } catch (Throwable th2) {
            TmcLogger.h("NavigateBridge", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void openHybridH5Page(@cc.g(name = {"url"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "openH5 url is empty!!!");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
        app.putPageType(str, 2);
        app.putRouteType(str, "navigateTo");
        Bundle sceneParams = app.getSceneParams();
        sceneParams.putString("navigationType", "openHybridH5Page");
        app.pushPage(str, app.getStartParams(), sceneParams);
        if (aVar != null) {
            aVar.d(new JsonObject());
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void reLaunch(@cc.g(name = {"url"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (str.isEmpty()) {
                com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "navigateTo url is empty!!!");
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
            app.putRouteType(str, Page.SOURCE_RELAUNCH);
            Bundle sceneParams = app.getSceneParams();
            sceneParams.putString("navigationType", Page.SOURCE_RELAUNCH);
            app.relaunchToUrl(str, app.getStartParams(), sceneParams);
            if (aVar != null) {
                aVar.d(new JsonObject());
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void redirectTo(@cc.g(name = {"url"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            TmcLogger.c("Tmcintegration", "redirectTo url is empty!!!");
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (b(app.getSceneParams(), str)) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
            app.putRouteType(str, "redirectTo");
            app.redirectTo(str, app.getStartParams(), app.getSceneParams());
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void switchTab(@cc.g(name = {"url"}) String str, @cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        String path;
        MiniAppConfigModel.TabBarBean tabBarConfig;
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            TmcLogger.f("Tmcintegration", "switchTab url is empty!!!");
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "switchTab url is empty: N004").e());
                return;
            }
            return;
        }
        try {
            path = Uri.parse(str).getPath();
        } catch (Exception e11) {
            TmcLogger.h("NavigateBridge", e11);
            path = "";
        }
        if (page != null && (tabBarConfig = page.getTabBarConfig()) != null && (list = tabBarConfig.list) != null) {
            Iterator<MiniAppConfigModel.TabBarBean.ListBean> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().pagePath, path)) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
                    app.putRouteType(str, "switchTab");
                    app.putStringValue("switcherTabFromScene", "fromTabSelected");
                    app.switchTab(str, app.getStartParams(), app.getSceneParams());
                    if (aVar != null) {
                        aVar.g();
                        return;
                    }
                    return;
                }
            }
        }
        TmcLogger.f("Tmcintegration", "switchTab url is not supported!!!");
        if (aVar != null) {
            aVar.e(z.a().d("errMsg", "switchTab url is not supported: N005").e());
        }
    }
}
