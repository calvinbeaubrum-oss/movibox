package com.cloud.tmc.miniapp.bridge;

import cc.c;
import cc.f;
import cc.g;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.TabBarManualConfigStore;
import com.cloud.tmc.integration.model.TabReSelectedStore;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.p000native.NativeTabView;
import com.cloud.tmc.integration.utils.d0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import hd.k;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class TabBarBridge implements BridgeExtension {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ bc.a OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(bc.a aVar) {
            super(1);
            this.OooO00o = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                bc.a aVar = this.OooO00o;
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "ok");
                    aVar.d(jsonObject);
                }
            } else {
                bc.a aVar2 = this.OooO00o;
                if (aVar2 != null) {
                    f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar2);
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void hideTabBar(@f(App.class) App app, @g({"animation"}) boolean z11, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.hideTabBar(z11)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else {
            activePage.putStringValue("isApiShowTabBarEnabled", "hideTabBar");
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "ok");
                aVar.d(jsonObject);
            }
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void hideTabBarRedDot(@f(App.class) App app, @g(intDefault = -1, value = {"index"}) int i11, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.hideTabBarRedDot(i11)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void hideTabBarUnreadIcon(@f(App.class) App app, @g(intDefault = -1, value = {"index"}) int i11, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
                return;
            }
            return;
        }
        try {
            if (activePage.hideTabBarUnreadIcon(i11)) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "ok");
                    aVar.d(jsonObject);
                }
            } else if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "set tab item failed,please check the config: T10003");
                aVar.e(jsonObject2);
            }
        } catch (Throwable th2) {
            TmcLogger.h("TabBarBridge", th2);
            if (aVar != null) {
                f.a.a("errMsg", "load tab bar fail, please check the config: T10005", aVar);
            }
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void loadTabBar(@f(App.class) App app, @g({"tabBarConfig"}) String tabBarConfig, @c bc.a callback) {
        MiniAppConfigModel miniAppConfigModel;
        Intrinsics.g(tabBarConfig, "tabBarConfig");
        Intrinsics.g(callback, "callback");
        MiniAppConfigModel.TabBarBean tabBarBean = null;
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || tabBarConfig.length() == 0) {
            f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, callback);
            return;
        }
        AppLoadResult appLoadResult = activePage.getAppLoadResult();
        if (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null || !miniAppConfigModel.tabBarManual()) {
            f.a.a("errMsg", "load tab bar fail, app.json is not config handleTabBarLoad as manual: T10004", callback);
            return;
        }
        k.a("load tab config: ", tabBarConfig, "TabBarBridge");
        try {
            Type type = new TypeToken<MiniAppConfigModel.TabBarBean>() { // from class: com.cloud.tmc.miniapp.bridge.TabBarBridge$loadTabBar$tabBar$1
            }.getType();
            Intrinsics.f(type, "object :\n               …del.TabBarBean>() {}.type");
            tabBarBean = (MiniAppConfigModel.TabBarBean) TmcGsonUtils.e(tabBarConfig, type);
        } catch (Throwable th2) {
            TmcLogger.g("TabBarBridge", "tabBarConfig json parse error", th2);
        }
        if (tabBarBean == null) {
            f.a.a("errMsg", "load tab bar fail, please check the config: T10005", callback);
            return;
        }
        List<MiniAppConfigModel.TabBarBean.ListBean> list = tabBarBean.list;
        if (list != null) {
            int size = list.size();
            if (2 <= size && size < 6) {
                MiniAppConfigModel.TabBarBean tabBarBeanC = d0.c(tabBarBean);
                app.setData(TabBarManualConfigStore.class, new TabBarManualConfigStore(tabBarBeanC));
                List<MiniAppConfigModel.TabBarBean.ListBean> list2 = tabBarBean.list;
                if (list2 != null) {
                    Iterator<MiniAppConfigModel.TabBarBean.ListBean> it = list2.iterator();
                    int i11 = 0;
                    while (it.hasNext()) {
                        if (Intrinsics.b(it.next().pagePath, activePage.getPagePath())) {
                            if (i11 == -1) {
                                break;
                            }
                            activePage.setTabPage(true);
                            boolean zLoadTabBar = activePage.loadTabBar(tabBarBeanC);
                            TmcLogger.c("TabBarBridge", "load tab bar result: " + zLoadTabBar);
                            if (!zLoadTabBar) {
                                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, callback);
                                return;
                            }
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("errMsg", "ok");
                            callback.d(jsonObject);
                            return;
                        }
                        i11++;
                    }
                }
                TmcLogger.c("TabBarBridge", "lazy load tab bar");
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "lazy load tab bar: T10007");
                callback.d(jsonObject2);
                return;
            }
            TmcLogger.c("TabBarBridge", "The number of tabBarConfig list is not between 2 and 5");
        }
        f.a.a("errMsg", "load tab bar fail, The number of dynamic configurations is not between 2 and 5: T10006", callback);
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public final void offTabReselected(@f(App.class) App app, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
            }
        } else {
            if (!activePage.isTabPage()) {
                if (aVar != null) {
                    f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
                    return;
                }
                return;
            }
            TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class, true);
            bc.a aVarRemove = (tabReSelectedStore == null ? new WeakHashMap<>() : tabReSelectedStore.getPageCache()).remove(activePage.getPageId());
            if (aVarRemove != null) {
                aVarRemove.close();
            }
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("TabBarBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("TabBarBridge", "onInitialized");
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public final void onTabReselected(@f(App.class) App app, @c(isSticky = true) bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
            }
            if (aVar != null) {
                aVar.close();
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
            if (aVar != null) {
                aVar.close();
                return;
            }
            return;
        }
        TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class, true);
        WeakHashMap<String, bc.a> weakHashMap = tabReSelectedStore == null ? new WeakHashMap<>() : tabReSelectedStore.getPageCache();
        bc.a aVarRemove = weakHashMap.remove(activePage.getPageId());
        if (aVarRemove != null) {
            aVarRemove.close();
        }
        weakHashMap.put(activePage.getPageId(), aVar);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void removeTabBarBadge(@f(App.class) App app, @g(intDefault = -1, value = {"index"}) int i11, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.removeTabBarBadge(i11)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void setTabBarBadge(@f(App.class) App app, @g(intDefault = -1, value = {"index"}) int i11, @g({MimeTypes.BASE_TYPE_TEXT}) String text, @c bc.a aVar) {
        Intrinsics.g(text, "text");
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0 || text.length() == 0) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.setTabBarBadge(i11, text)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void setTabBarItem(@f(App.class) App app, @g({"index"}) int i11, @g({MimeTypes.BASE_TYPE_TEXT}) String str, @g({"iconPath"}) String str2, @g({"selectedIconPath"}) String str3, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.setTabBarItem(i11, str, str2, str3)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void setTabBarItems(@f(App.class) App app, @g({"tabs"}) JsonArray jsonArray, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || jsonArray == null) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.setTabBarItems(jsonArray)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void setTabBarStyle(@f(App.class) App app, @g({TtmlNode.ATTR_TTS_COLOR}) String color, @g({"selectedColor"}) String selectedColor, @g({TtmlNode.ATTR_TTS_BACKGROUND_COLOR}) String backgroundColor, @g({"borderStyle"}) String borderStyle, @c bc.a aVar) {
        Intrinsics.g(color, "color");
        Intrinsics.g(selectedColor, "selectedColor");
        Intrinsics.g(backgroundColor, "backgroundColor");
        Intrinsics.g(borderStyle, "borderStyle");
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.setTabBarStyle(xb.e.c(color), xb.e.c(selectedColor), xb.e.c(backgroundColor), xb.e.c(borderStyle))) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showTabBar(@f(App.class) App app, @g({"animation"}) boolean z11, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.showTabBar(z11)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else {
            activePage.putStringValue("isApiShowTabBarEnabled", "showTabBar");
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "ok");
                aVar.d(jsonObject);
            }
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showTabBarRedDot(@f(App.class) App app, @g(intDefault = -1, value = {"index"}) int i11, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else if (!activePage.showTabBarRedDot(i11)) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,please check the config: T10003", aVar);
            }
        } else if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "ok");
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @e(ExecutorType.UI)
    public final void showTabBarUnreadIcon(@f(App.class) App app, @g(intDefault = -1, value = {"index"}) int i11, @g({"iconPath"}) String str, @c bc.a aVar) {
        Page activePage = app != null ? app.getActivePage() : null;
        if (activePage == null || i11 < 0) {
            if (aVar != null) {
                f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                return;
            }
            return;
        }
        if (!activePage.isTabPage()) {
            if (aVar != null) {
                f.a.a("errMsg", "set tab item failed,it's not tab page: T10002", aVar);
            }
        } else {
            if (str == null || str.length() == 0) {
                if (aVar != null) {
                    f.a.a("errMsg", NativeTabView.ERROR_MSG_T10001, aVar);
                    return;
                }
                return;
            }
            try {
                activePage.showTabBarUnreadIcon(i11, str, new OooO0O0(aVar));
            } catch (Throwable th2) {
                TmcLogger.h("TabBarBridge", th2);
                if (aVar != null) {
                    f.a.a("errMsg", "load tab bar fail, please check the config: T10005", aVar);
                }
            }
        }
    }
}
