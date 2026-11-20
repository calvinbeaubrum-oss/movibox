package com.cloud.tmc.integration.structure;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.kernel.node.DataNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.functions.Function1;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface Page extends DataNode, com.cloud.tmc.kernel.node.d, com.cloud.tmc.kernel.node.e, com.cloud.tmc.kernel.node.a {
    public static final String SOURCE_NAVIGATE_BACK = "navigateBack";
    public static final String SOURCE_RELAUNCH = "reLaunch";

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f30917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f30918b;

        public a() {
            this.f30917a = false;
            this.f30918b = false;
        }

        public a(boolean z11, boolean z12) {
            this.f30917a = z11;
            this.f30918b = z12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void success();
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Page f30920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f30921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f30922d;

        public e(int i11, Page page, String str, String str2) {
            this.f30921c = Page.SOURCE_NAVIGATE_BACK;
            this.f30922d = Page.SOURCE_NAVIGATE_BACK;
            this.f30919a = i11;
            this.f30920b = page;
            if (!TextUtils.isEmpty(str)) {
                this.f30921c = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f30922d = str2;
        }
    }

    @Override // com.cloud.tmc.kernel.node.a
    /* synthetic */ void addOnKeyboardListener(nc.a aVar);

    void addRenderReadyListener(d dVar);

    boolean backPressed();

    void bindContext(tb.d dVar, Boolean bool, b bVar);

    /* synthetic */ void changeNavigationBarProgress(int i11, int i12, long j11);

    String createPageRandomIdByGAID();

    void destroy();

    void enter();

    void exit(boolean z11);

    void exit(boolean z11, e eVar);

    /* synthetic */ boolean getAddScreenVisibleStatus();

    @Nullable
    App getApp();

    @Nullable
    AppLoadResult getAppLoadResult();

    /* synthetic */ boolean getBooleanValue(String str);

    com.cloud.tmc.kernel.extension.e getExtensionManager();

    @Override // com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    /* synthetic */ dd.d getGroup();

    /* synthetic */ int getIntValue(String str);

    /* synthetic */ JsonArray getJsonArrayValue(String str);

    /* synthetic */ JsonObject getJsonValue(String str);

    /* synthetic */ long getLongValue(String str);

    String getOriginalURI();

    PageChainContext getPageChainContext();

    @Nullable
    tb.d getPageContext();

    String getPageId();

    String getPagePath();

    @Nullable
    String getPageRandomIdByGAId();

    String getPageURI();

    i getRender();

    Bundle getSceneParams();

    @Override // com.cloud.tmc.kernel.node.d
    /* synthetic */ Class getScopeType();

    Bundle getStartParams();

    /* synthetic */ String getStringValue(String str);

    @Nullable
    MiniAppConfigModel.TabBarBean getTabBarConfig();

    MiniAppConfigModel.WindowBean getWindow();

    void hide();

    /* synthetic */ void hideAddScreenButton();

    /* synthetic */ void hideHomeButton();

    /* synthetic */ void hideNavigationBarLoading();

    /* synthetic */ boolean hideTabBar(boolean z11);

    /* synthetic */ boolean hideTabBarRedDot(int i11);

    /* synthetic */ boolean hideTabBarUnreadIcon(int i11);

    @Override // com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    /* synthetic */ void inquiry(List list, dd.c.a aVar);

    boolean isDestroyed();

    boolean isExited();

    boolean isHide();

    boolean isHomePage();

    boolean isPageLoaded();

    boolean isRenderReady();

    boolean isShow();

    boolean isTabPage();

    /* synthetic */ boolean isTransparent();

    boolean isUseForEmbed();

    boolean loadTabBar(MiniAppConfigModel.TabBarBean tabBarBean);

    void pause();

    /* synthetic */ void putBooleanValue(String str, boolean z11);

    /* synthetic */ void putIntValue(String str, int i11);

    /* synthetic */ void putJsonArrayValue(String str, JsonArray jsonArray);

    /* synthetic */ void putJsonValue(String str, JsonObject jsonObject);

    /* synthetic */ void putLongValue(String str, long j11);

    /* synthetic */ void putStringValue(String str, String str2);

    void refreshApp();

    void reload();

    @Override // com.cloud.tmc.kernel.node.a
    /* synthetic */ void removeOnKeyboardListener(nc.a aVar);

    /* synthetic */ boolean removeTabBarBadge(int i11);

    String resetPageRandomIdByGAID();

    void resume();

    /* synthetic */ void setCapsuleStyle(boolean z11);

    void setExitListener(c cVar);

    /* synthetic */ void setHomeAction(int i11, boolean z11);

    /* synthetic */ void setNavigationBarBackgroundColor(String str);

    /* synthetic */ void setNavigationBarIconStyle(boolean z11);

    /* synthetic */ void setNavigationBarTitle(String str);

    /* synthetic */ void setNavigationBarTitleColor(boolean z11);

    /* synthetic */ void setNavigationBarTitleVisible(boolean z11);

    /* synthetic */ void setNavigationBarTransparent(boolean z11);

    void setPageChainContext(PageChainContext pageChainContext);

    void setPageLoaded();

    /* synthetic */ void setStatusBar(boolean z11);

    /* synthetic */ boolean setTabBarBadge(int i11, String str);

    /* synthetic */ boolean setTabBarItem(int i11, String str, String str2, String str3);

    /* synthetic */ boolean setTabBarItems(JsonArray jsonArray);

    /* synthetic */ boolean setTabBarStyle(String str, String str2, String str3, String str4);

    void setTabPage(boolean z11);

    /* synthetic */ void setTitleBarVisible(boolean z11);

    void show();

    /* synthetic */ void showAddScreenButton();

    /* synthetic */ void showHomeButton();

    /* synthetic */ void showNavigationBarLoading();

    /* synthetic */ boolean showTabBar(boolean z11);

    /* synthetic */ boolean showTabBarRedDot(int i11);

    @Override // com.cloud.tmc.kernel.node.e
    /* synthetic */ void showTabBarUnreadIcon(int i11, String str, Function1 function1);

    @Override // com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    /* synthetic */ List usePermissions();
}
