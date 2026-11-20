package com.cloud.tmc.integration.structure;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppAutoPopover;
import com.cloud.tmc.integration.processor.IBackPressedProcessor;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.node.DataNode;
import com.cloud.tmc.kernel.node.d;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dd.c;
import java.util.LinkedHashMap;
import java.util.List;
import tb.b;
import ua.e;
import ua.f;
import ua.g;
import ua.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface App extends DataNode, d {

    /* JADX INFO: compiled from: source.java */
    @Keep
    public static class PopParams {
        public JsonObject data;

        public PopParams(JsonObject jsonObject) {
            this.data = jsonObject;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Keep
    public static class ResumeParams {
        public JsonObject data;

        public ResumeParams(JsonObject jsonObject) {
            this.data = jsonObject;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Page page);
    }

    void addPageReadyListener(a aVar);

    boolean backPressed();

    void backToHeaderPage();

    void bindContext(@NonNull b bVar);

    void exit();

    void exitAllThenPushPage(String str, Bundle bundle, Bundle bundle2);

    void exitToHomePage();

    @Nullable
    Page getActivePage();

    int getActivePageIndex();

    boolean getAddHomeShowStatus(int i11);

    int getAlivePageCount();

    wa.a getAppChainContext();

    @Nullable
    b getAppContext();

    String getAppId();

    f getAppLifecycleCallback();

    AppManager getAppManager();

    AppModel getAppModel();

    String getAppType();

    String getAppVersion();

    e getAsyncStartLoadingCallback();

    IBackPressedProcessor getBackPressedProcessor();

    /* synthetic */ boolean getBooleanValue(String str);

    IEngine getEngineProxy();

    com.cloud.tmc.kernel.extension.e getExtensionManager();

    @Nullable
    Page getFirstPage();

    @Override // com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    /* synthetic */ dd.d getGroup();

    boolean getHideMiniAppLoadingStatus();

    String getHomePagePath();

    IFileResourceManager getIFileResourceManager();

    IImageResourceManager getImageResourceManagerProxy();

    /* synthetic */ int getIntValue(String str);

    String getInterectCallbackId();

    /* synthetic */ JsonArray getJsonArrayValue(String str);

    /* synthetic */ JsonObject getJsonValue(String str);

    g getLoadHtmlDataCallback();

    /* synthetic */ long getLongValue(String str);

    boolean getMFAHStatus();

    MiniAppAutoPopover getMiniAppAutoPopover();

    boolean getMiniAppLoadStatus();

    Page getPageByIndex(int i11);

    Page getPageByNodeId(long j11);

    int getPageType(@NonNull String str);

    LinkedHashMap<String, Runnable> getPermissionInterectMap();

    Page getPrePage();

    @NonNull
    String getRouteType(@NonNull String str);

    @NonNull
    String getRouteType(@NonNull String str, boolean z11);

    Bundle getSceneParams();

    @Override // com.cloud.tmc.kernel.node.d
    /* synthetic */ Class getScopeType();

    Bundle getStartParams();

    long getStartTime();

    long getStartToken();

    String getStartUrl();

    /* synthetic */ String getStringValue(String str);

    boolean hasHomePage();

    void hideMiniAppAddHomeBar();

    void init(String str, Bundle bundle, Bundle bundle2);

    @Override // com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    /* synthetic */ void inquiry(List list, c.a aVar);

    boolean isDestroyed();

    boolean isExited();

    boolean isFirstPage();

    boolean isTinyApp();

    void notifyAddHomeShow(int i11);

    void pause();

    void performBack();

    void popPage(@Nullable JsonObject jsonObject);

    void popTo(int i11, boolean z11, @Nullable JsonObject jsonObject);

    void pushPage(String str, Bundle bundle, Bundle bundle2);

    void pushWebViewPage(String str, Bundle bundle, Bundle bundle2);

    /* synthetic */ void putBooleanValue(String str, boolean z11);

    /* synthetic */ void putIntValue(String str, int i11);

    /* synthetic */ void putJsonArrayValue(String str, JsonArray jsonArray);

    /* synthetic */ void putJsonValue(String str, JsonObject jsonObject);

    /* synthetic */ void putLongValue(String str, long j11);

    void putPageType(@NonNull String str, int i11);

    void putRouteType(@NonNull String str, @NonNull String str2);

    /* synthetic */ void putStringValue(String str, String str2);

    void redirectTo(String str, Bundle bundle, Bundle bundle2);

    void relaunchToUrl(String str, Bundle bundle, Bundle bundle2);

    void removePage(@NonNull Page page, boolean z11, @Nullable Page.e eVar);

    void restart(Bundle bundle, Bundle bundle2);

    void resume();

    void setAddhomeShowCallback(i iVar);

    void setAppCallback(ua.d dVar);

    void setAppChainContext(wa.a aVar);

    void setAppStartTime(long j11);

    void setAppType(String str);

    void setAsyncStartLoadingCallback(e eVar);

    void setLoadHtmlDataCallback(g gVar);

    void setMiniAppAutoPopover(MiniAppAutoPopover miniAppAutoPopover);

    void setMiniAppLoadStatus(boolean z11);

    void setMiniappLifecycleCallback(f fVar);

    void start();

    void stop();

    void switchTab(String str, Bundle bundle, Bundle bundle2);

    void updateAddHomeShowStatus(int i11);

    void updateAppModel(AppModel appModel);

    void updateHideMiniappLoadingStatus(boolean z11);

    void updateInterectCallbackId(String str);

    void updateMFAHStatus(boolean z11);

    @Override // com.cloud.tmc.kernel.node.DataNode, com.cloud.tmc.kernel.node.Node
    /* synthetic */ List usePermissions();
}
