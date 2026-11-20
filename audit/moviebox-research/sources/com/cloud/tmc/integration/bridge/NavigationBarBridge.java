package com.cloud.tmc.integration.bridge;

import android.text.TextUtils;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.AbilitiesUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.d0;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NavigationBarBridge implements BridgeExtension {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f30554a;

        public a(String str) {
            this.f30554a = str;
        }

        public String a() {
            return this.f30554a;
        }
    }

    public final boolean a(Page page) {
        if (page == null || page.getData(a.class) == null) {
            return false;
        }
        return "custom".equals(((a) page.getData(a.class)).a());
    }

    public final boolean b(Page page) {
        if (page == null || page.getData(a.class) == null) {
            return false;
        }
        return "hide".equals(((a) page.getData(a.class)).a());
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void changeNavigationBarProgress(@cc.f(App.class) App app, @cc.g(name = {"startProgress"}) Integer num, @cc.g(name = {"endProgress"}) Integer num2, @cc.g(longDefault = 200, name = {"duration"}) Long l11, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (num.intValue() > 100 || num.intValue() < 0) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "The number of startProgress should be between 1 and 100!").e());
                return;
            }
            return;
        }
        if (num2.intValue() > 100 || num2.intValue() < 0 || num.intValue() >= num2.intValue()) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "The number of endProgress should be between 1 and 100,with startProgress must be less than with endProgress!").e());
            }
        } else if (l11.longValue() > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS || l11.longValue() < 0) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "The duration must be in the range 0 to 60000 milliseconds!").e());
            }
        } else {
            activePage.changeNavigationBarProgress(num.intValue(), num2.intValue(), l11.longValue() / ((long) (num2.intValue() - num.intValue())));
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void getStatusBarHeight(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (app.getActivePage() == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            int iA = e0.a();
            if (aVar != null) {
                aVar.d(z.a().c("statusBarHeight", Integer.valueOf(iA)).e());
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void hideAddScreenButton(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        String appId = app.getAppId();
        if (activePage == null || TextUtils.isEmpty(appId)) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (!AbilitiesUtils.f30983a.b(appId, "title_bar_add_home")) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed, ability has no support: N10001").e());
            }
        } else {
            activePage.putStringValue("isApiAddScreenEnabled", "hideAddScreenButton");
            activePage.hideAddScreenButton();
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void hideHomeButton(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            activePage.putStringValue("isApiShowHomeEnabled", "hideHomeButton");
            activePage.hideHomeButton();
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void hideNavigationBarLoading(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            activePage.hideNavigationBarLoading();
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("NavigationBarBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("NavigationBarBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void setNavigationBarBackgroundColor(@cc.f(App.class) App app, @cc.g(name = {TtmlNode.ATTR_TTS_COLOR}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        MiniAppConfigModel.WindowBean windowBeanF = d0.f((AppLoadResult) com.cloud.tmc.kernel.utils.a.d(activePage.getSceneParams(), "appLoadResult"), activePage.getPagePath());
        if (windowBeanF != null && (windowBeanF.navigationStyleIsCustom() || a(activePage))) {
            activePage.setNavigationBarBackgroundColor(str);
            if (aVar != null) {
                aVar.g();
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void setNavigationBarIconStyle(@cc.f(App.class) App app, @cc.g(name = {TtmlNode.ATTR_TTS_COLOR}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        MiniAppConfigModel.WindowBean windowBeanF = d0.f((AppLoadResult) com.cloud.tmc.kernel.utils.a.d(activePage.getSceneParams(), "appLoadResult"), activePage.getPagePath());
        if (windowBeanF != null && (windowBeanF.navigationStyleIsCustom() || windowBeanF.navigationStyleIsHide())) {
            activePage.setNavigationBarIconStyle("white".equals(str));
            if (aVar != null) {
                aVar.g();
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void setNavigationBarTitle(@cc.f(App.class) App app, @cc.g(name = {CampaignEx.JSON_KEY_TITLE}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            activePage.setNavigationBarTitle(str);
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void setNavigationBarTitleColor(@cc.f(App.class) App app, @cc.g(name = {TtmlNode.ATTR_TTS_COLOR}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        MiniAppConfigModel.WindowBean windowBeanF = d0.f((AppLoadResult) com.cloud.tmc.kernel.utils.a.d(activePage.getSceneParams(), "appLoadResult"), activePage.getPagePath());
        if (windowBeanF != null && (windowBeanF.navigationStyleIsCustom() || windowBeanF.navigationStyleIsHide() || a(activePage) || b(activePage))) {
            activePage.setNavigationBarTitleColor("white".equals(str));
            if (aVar != null) {
                aVar.g();
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void setNavigationBarTransparent(@cc.f(App.class) App app, @cc.g(name = {"enable"}) Boolean bool, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        MiniAppConfigModel.WindowBean windowBeanF = d0.f((AppLoadResult) com.cloud.tmc.kernel.utils.a.d(activePage.getSceneParams(), "appLoadResult"), activePage.getPagePath());
        if (windowBeanF != null && (windowBeanF.navigationStyleIsCustom() || a(activePage))) {
            activePage.setNavigationBarTransparent(bool.booleanValue());
            if (aVar != null) {
                aVar.g();
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void setNavigationStyle(@cc.f(App.class) App app, @cc.g(name = {TtmlNode.TAG_STYLE}) String str, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        if (TextUtils.isEmpty(str) || app == null || page == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else if ("custom".equals(str) || TmcEngineFactory.ENGINE_TYPE_DEFAULT.equals(str) || "hide".equals(str)) {
            page.setData(a.class, new a(str));
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void showAddScreenButton(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        String appId = app.getAppId();
        if (activePage == null || TextUtils.isEmpty(appId)) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (!AbilitiesUtils.f30983a.b(appId, "title_bar_add_home")) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed, ability has no support: N10001").e());
            }
        } else {
            activePage.putStringValue("isApiAddScreenEnabled", "showAddScreenButton");
            activePage.showAddScreenButton();
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void showHomeButton(@cc.f(App.class) App app, @cc.g(name = {"action"}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (AppUtils.r(activePage, activePage.getAppLoadResult())) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                activePage.setHomeAction(d0.g(str), true);
            }
            activePage.putStringValue("isApiShowHomeEnabled", "showHomeButton");
            activePage.showHomeButton();
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void showNavigationBarLoading(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Page activePage = app.getActivePage();
        if (activePage == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            activePage.showNavigationBarLoading();
            if (aVar != null) {
                aVar.g();
            }
        }
    }
}
