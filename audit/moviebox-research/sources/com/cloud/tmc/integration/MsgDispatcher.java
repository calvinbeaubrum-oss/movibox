package com.cloud.tmc.integration;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.h0;
import com.cloud.tmc.integration.utils.m0;
import com.cloud.tmc.integration.utils.o0;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.bridge.IMsgDispatcher;
import com.cloud.tmc.kernel.bridge.NativeBridge;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.EngineUtils;
import com.cloud.tmc.kernel.utils.p;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import xa.g;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class MsgDispatcher implements IMsgDispatcher {

    /* JADX INFO: compiled from: source.java */
    public class a implements ac.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f30382c;

        public a(String str, String str2, i iVar) {
            this.f30380a = str;
            this.f30381b = str2;
            this.f30382c = iVar;
        }

        @Override // ac.c
        public void a(HashMap<String, Object> map, boolean z11, boolean z12) {
            TmcLogger.c("MsgDispatcher", "handleMsgFromJs: " + this.f30380a + ", return " + map);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("abilityName", "callback");
            JsonObject jsonObject2 = new JsonObject();
            jsonObject.addProperty("callbackId", this.f30381b);
            jsonObject.add("dataJson", jsonObject2);
            jsonObject2.addProperty("dataJson", String.valueOf(map));
            jsonObject2.addProperty("callbackId", this.f30381b);
            i iVar = this.f30382c;
            if (iVar != null) {
                ac.b.a aVarI = ac.b.b(iVar).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObject2);
                if (this.f30382c.getRenderBridge() != null) {
                    this.f30382c.getRenderBridge().a(aVarI.h(), null);
                }
            }
        }

        @Override // ac.c
        public void b(JsonObject jsonObject, boolean z11, boolean z12) {
            TmcLogger.c("MsgDispatcher", "handleMsgFromJs: " + this.f30380a + ", return " + jsonObject);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("abilityName", "callback");
            JsonObject jsonObject3 = new JsonObject();
            jsonObject2.addProperty("callbackId", this.f30381b);
            jsonObject2.add("dataJson", jsonObject3);
            jsonObject3.addProperty("dataJson", String.valueOf(jsonObject));
            jsonObject3.addProperty("callbackId", this.f30381b);
            i iVar = this.f30382c;
            if (iVar != null) {
                ac.b.a aVarI = ac.b.b(iVar).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObject3);
                if (this.f30382c.getRenderBridge() != null) {
                    this.f30382c.getRenderBridge().a(aVarI.h(), null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ac.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ gd.b f30386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ App f30387d;

        public b(String str, String str2, gd.b bVar, App app) {
            this.f30384a = str;
            this.f30385b = str2;
            this.f30386c = bVar;
            this.f30387d = app;
        }

        @Override // ac.c
        public void a(HashMap<String, Object> map, boolean z11, boolean z12) {
            TmcLogger.c("MsgDispatcher", "handleMsgFromJs: " + this.f30384a + ", return " + map);
            HashMap<String, Object> map2 = new HashMap<>();
            JsonObject jsonObject = new JsonObject();
            map2.put("abilityName", "callback");
            jsonObject.addProperty("abilityName", "callback");
            JsonObject jsonObject2 = new JsonObject();
            HashMap map3 = new HashMap();
            if (z11) {
                map2.put("action", "keepalive_active");
                jsonObject.addProperty("action", "keepalive_active");
            } else if (z12) {
                map2.put("action", "keepalive_close");
                jsonObject.addProperty("action", "keepalive_close");
            }
            map2.put("callbackId", this.f30385b);
            jsonObject.addProperty("callbackId", this.f30385b);
            map2.put("dataJson", map3);
            jsonObject.add("dataJson", jsonObject2);
            map3.put("dataJson", map);
            jsonObject2.addProperty("dataJson", String.valueOf(map));
            map3.put("callbackId", this.f30385b);
            jsonObject2.addProperty("callbackId", this.f30385b);
            if (this.f30386c.workerType() == 1) {
                this.f30386c.j(map2, null);
            } else if (this.f30386c.workerType() == 3) {
                this.f30386c.k(jsonObject, null);
            }
            MsgDispatcher.b(this.f30387d, this.f30385b);
        }

        @Override // ac.c
        public void b(JsonObject jsonObject, boolean z11, boolean z12) {
            TmcLogger.c("MsgDispatcher", "handleMsgFromJs: " + this.f30384a + ", return " + jsonObject);
            HashMap<String, Object> map = new HashMap<>();
            JsonObject jsonObject2 = new JsonObject();
            map.put("abilityName", "callback");
            jsonObject2.addProperty("abilityName", "callback");
            JsonObject jsonObject3 = new JsonObject();
            HashMap map2 = new HashMap();
            if (z11) {
                map.put("action", "keepalive_active");
                jsonObject2.addProperty("action", "keepalive_active");
            } else if (z12) {
                map.put("action", "keepalive_close");
                jsonObject2.addProperty("action", "keepalive_close");
            }
            map.put("callbackId", this.f30385b);
            jsonObject2.addProperty("callbackId", this.f30385b);
            map.put("dataJson", map2);
            jsonObject2.add("dataJson", jsonObject3);
            map2.put("dataJson", String.valueOf(jsonObject));
            jsonObject3.addProperty("dataJson", String.valueOf(jsonObject));
            map2.put("callbackId", this.f30385b);
            jsonObject3.addProperty("callbackId", this.f30385b);
            if (this.f30386c.workerType() == 1) {
                this.f30386c.j(map, null);
            } else if (this.f30386c.workerType() == 3) {
                this.f30386c.k(jsonObject2, null);
            }
            MsgDispatcher.b(this.f30387d, this.f30385b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ac.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ gd.b f30391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ App f30392d;

        public c(String str, String str2, gd.b bVar, App app) {
            this.f30389a = str;
            this.f30390b = str2;
            this.f30391c = bVar;
            this.f30392d = app;
        }

        @Override // ac.c
        public void a(HashMap<String, Object> map, boolean z11, boolean z12) {
            TmcLogger.c("MsgDispatcher", "handleMsgFromJs: " + this.f30389a + ", return " + map);
            HashMap<String, Object> map2 = new HashMap<>();
            JsonObject jsonObject = new JsonObject();
            map2.put("abilityName", "callback");
            jsonObject.addProperty("abilityName", "callback");
            JsonObject jsonObject2 = new JsonObject();
            HashMap map3 = new HashMap();
            if (z11) {
                map2.put("action", "keepalive_active");
                jsonObject.addProperty("action", "keepalive_active");
            } else if (z12) {
                map2.put("action", "keepalive_close");
                jsonObject.addProperty("action", "keepalive_close");
            }
            map2.put("callbackId", this.f30390b);
            jsonObject.addProperty("callbackId", this.f30390b);
            map2.put("dataJson", map3);
            jsonObject.add("dataJson", jsonObject2);
            map3.put("dataJson", map);
            jsonObject2.addProperty("dataJson", String.valueOf(map));
            map3.put("callbackId", this.f30390b);
            jsonObject2.addProperty("callbackId", this.f30390b);
            if (this.f30391c.workerType() == 1) {
                this.f30391c.j(map2, null);
            } else if (this.f30391c.workerType() == 3) {
                this.f30391c.k(jsonObject, null);
            }
            MsgDispatcher.b(this.f30392d, this.f30390b);
        }

        @Override // ac.c
        public void b(JsonObject jsonObject, boolean z11, boolean z12) {
            TmcLogger.c("MsgDispatcher", "handleMsgFromJs: " + this.f30389a + ", return " + jsonObject);
            HashMap<String, Object> map = new HashMap<>();
            JsonObject jsonObject2 = new JsonObject();
            map.put("abilityName", "callback");
            jsonObject2.addProperty("abilityName", "callback");
            JsonObject jsonObject3 = new JsonObject();
            HashMap map2 = new HashMap();
            if (z11) {
                map.put("action", "keepalive_active");
                jsonObject2.addProperty("action", "keepalive_active");
            } else if (z12) {
                map.put("action", "keepalive_close");
                jsonObject2.addProperty("action", "keepalive_close");
            }
            map.put("callbackId", this.f30390b);
            jsonObject2.addProperty("callbackId", this.f30390b);
            map.put("dataJson", map2);
            jsonObject2.add("dataJson", jsonObject3);
            map2.put("dataJson", String.valueOf(jsonObject));
            jsonObject3.addProperty("dataJson", String.valueOf(jsonObject));
            map2.put("callbackId", this.f30390b);
            jsonObject3.addProperty("callbackId", this.f30390b);
            if (this.f30391c.workerType() == 1) {
                this.f30391c.j(map, null);
            } else if (this.f30391c.workerType() == 3) {
                this.f30391c.k(jsonObject2, null);
            }
            MsgDispatcher.b(this.f30392d, this.f30390b);
        }
    }

    public static void b(final App app, String str) {
        String interectCallbackId = app.getInterectCallbackId();
        if (interectCallbackId == null || !interectCallbackId.equals(str)) {
            return;
        }
        app.updateInterectCallbackId(null);
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: com.cloud.tmc.integration.d
            @Override // java.lang.Runnable
            public final void run() {
                MsgDispatcher.f(app);
            }
        });
    }

    public static /* synthetic */ void f(App app) {
        ((PermissionDialogPoint) ib.a.b(PermissionDialogPoint.class).d()).privacyDialogDismiss(app.getAppId(), app.getStartToken());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(T t11, i iVar) {
        try {
            App app = (App) iVar.i().bubbleFindNode(App.class);
            ProtocolData.ConsumeTimeDataJson consumeTimeDataJson = ProtocolData.ConsumeTimeDataJson.parse((LinkedTreeMap) t11);
            IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
            uc.a aVarCreateEvent = iEventCenterFactory.createEvent(((Page) iVar.i()).getPageId() + "");
            HashMap map = new HashMap();
            map.put("eventData", consumeTimeDataJson.getDataJson().get("time"));
            aVarCreateEvent.c(map);
            uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(app);
            if (eventCenterInstance != null) {
                eventCenterInstance.d("consumeTime", aVarCreateEvent);
            }
        } catch (Exception unused) {
            p.e("miniapp", "parse consumeTime from dataJson fail");
        }
    }

    @NonNull
    public final String d(@NonNull EngineRouter engineRouter) {
        App app;
        Page activePage;
        i topRender = engineRouter.getTopRender();
        return (topRender == null || (app = (App) topRender.i().bubbleFindNode(App.class)) == null || (activePage = app.getActivePage()) == null || activePage.getRender() == null) ? "" : activePage.getRender().b();
    }

    public final boolean e(gd.b bVar, JsonObject jsonObject) {
        Node node;
        NativeBridge bridge;
        TmcLogger.c("MsgDispatcher", "handleJSMsgFroworker msg = " + jsonObject);
        if (bVar == null) {
            TmcLogger.e("handleAsyncMsgFromWorker error !!! (worker is null)");
            return false;
        }
        EngineRouter byWorkerId = ((EngineRouterManager) tc.a.a(EngineRouterManager.class)).getByWorkerId(bVar.getWorkerId());
        if (byWorkerId == null) {
            TmcLogger.e("handleAsyncMsgFromWorker error !!! (engineRouter is null)");
            return false;
        }
        ProtocolData protocolData = (ProtocolData) a0.f31025a.a(jsonObject.toString(), ProtocolData.class);
        if (bVar.getWorkerId() != null && bVar.getWorkerId().startsWith("warmup_worker_id_") && "DispatchEvent".equals(protocolData.getAbilityName()) && "native".equals(protocolData.getTarget())) {
            TmcLogger.f("MsgDispatcher", "handleAsyncMsgFromWorker 预热模式");
            ProtocolData.DispatchEventDataJson dispatchEventDataJson = ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData.getDataJson());
            String eventName = dispatchEventDataJson.getEventName();
            IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
            uc.a aVarCreateEvent = iEventCenterFactory.createEvent(eventName);
            HashMap map = new HashMap();
            map.put("eventData", dispatchEventDataJson.getDataJson());
            aVarCreateEvent.c(map);
            Node node2 = ((WarmupNode) tc.a.a(WarmupNode.class)).getNode(bVar.getWorkerId());
            if (node2 == null) {
                return false;
            }
            uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(node2);
            if (eventCenterInstance != null) {
                eventCenterInstance.d(eventName, aVarCreateEvent);
            }
            return true;
        }
        i renderById = byWorkerId.getRenderById(!TextUtils.isEmpty(protocolData.getRenderId()) ? protocolData.getRenderId() : d(byWorkerId));
        if (renderById == null) {
            TmcLogger.c("MsgDispatcher", "handleMsgFromJs: 找不到 render，使用 worker 兜底分发");
            App app = bVar.getNode() instanceof App ? (App) bVar.getNode() : null;
            if (app == null) {
                TmcLogger.c("MsgDispatcher", "handleMsgFromJs: render is null, app is null, jsapi 无法调用");
                return false;
            }
            if (!"Api".equals(protocolData.getAbilityName())) {
                return false;
            }
            ProtocolData.ApiDataJson apiDataJson = ProtocolData.ApiDataJson.parse((LinkedTreeMap) protocolData.getDataJson());
            String methodName = apiDataJson.getMethodName();
            String args = apiDataJson.getArgs();
            JsonObject asJsonObject = !TextUtils.isEmpty(args) ? JsonParser.parseString(args).getAsJsonObject() : null;
            String callbackId = protocolData.getCallbackId();
            NativeCallContext nativeCallContextA = new NativeCallContext.b().d(methodName).f(asJsonObject).e(app).b(callbackId).c("" + System.currentTimeMillis()).a();
            IEngine engineProxy = app.getEngineProxy();
            if (engineProxy == null || (bridge = engineProxy.getBridge()) == null) {
                return false;
            }
            bridge.sendToNative(nativeCallContextA, new b(methodName, callbackId, bVar, app));
            return true;
        }
        App app2 = (App) renderById.i().bubbleFindNode(App.class);
        c(protocolData.getDataJson(), renderById);
        if ("Api".equals(protocolData.getAbilityName())) {
            ProtocolData.ApiDataJson apiDataJson2 = ProtocolData.ApiDataJson.parse((LinkedTreeMap) protocolData.getDataJson());
            String methodName2 = apiDataJson2.getMethodName();
            String args2 = apiDataJson2.getArgs();
            JsonObject asJsonObject2 = !TextUtils.isEmpty(args2) ? JsonParser.parseString(args2).getAsJsonObject() : null;
            String callbackId2 = protocolData.getCallbackId();
            renderById.t().getBridge().sendToNative(new NativeCallContext.b().d(methodName2).f(asJsonObject2).e(renderById.i()).g(renderById).b(callbackId2).c("" + System.currentTimeMillis()).a(), new c(methodName2, callbackId2, bVar, app2));
            return true;
        }
        if ("DispatchEvent".equals(protocolData.getAbilityName()) && "native".equals(protocolData.getTarget())) {
            ProtocolData.DispatchEventDataJson dispatchEventDataJson2 = ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData.getDataJson());
            String eventName2 = dispatchEventDataJson2.getEventName();
            IEventCenterFactory iEventCenterFactory2 = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
            uc.a aVarCreateEvent2 = iEventCenterFactory2.createEvent(eventName2);
            HashMap map2 = new HashMap();
            map2.put("eventData", dispatchEventDataJson2.getDataJson());
            aVarCreateEvent2.c(map2);
            if (bVar.getNode() instanceof AppManager) {
                node = app2;
                node = bVar.getNode();
            }
            node = app2;
            uc.b eventCenterInstance2 = iEventCenterFactory2.getEventCenterInstance(node);
            if (eventCenterInstance2 != null) {
                eventCenterInstance2.d(eventName2, aVarCreateEvent2);
            }
        } else if ("render".equals(protocolData.getTarget())) {
            if ("onPageReady".equals(ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData.getDataJson()).getEventName())) {
                ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).checkNow(app2, ((Page) renderById.i()).getPagePath());
                if (app2 != null) {
                    app2.setMiniAppLoadStatus(true);
                    if (app2.getAppContext() != null && app2.getAppContext().getContext() != null) {
                        h0.f31062a.b(app2.getAppContext().getContext(), app2.getAppId());
                    }
                }
                uc.b eventCenterInstance3 = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance((Page) renderById.i());
                if (eventCenterInstance3 != null) {
                    eventCenterInstance3.d("onPageReady", new fc.a("onPageReady"));
                }
                Bundle bundle = new Bundle();
                bundle.putString("workerFromWarmup", bVar.c() + "");
                bundle.putString("workerFromWarmupChannel", bVar.e() + "");
                bundle.putString("renderFromWarmup", renderById.c() + "");
                bundle.putString("renderFromWarmupChannel", renderById.e() + "");
                bundle.putString("pageRandomId", ((Page) renderById.i()).getPageRandomIdByGAId());
                Bundle bundle2 = new Bundle();
                bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, "page");
                bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, ((Page) renderById.i()).getApp().getStartParams().getString("uniqueChainID", "-1"));
                bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, ((Page) renderById.i()).getPagePath());
                bundle2.putAll(bundle);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app2 == null ? null : app2.getAppId(), PointAnalyseType.POINT_RENDER_T1, "页面打开", bundle);
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                String appId = app2 == null ? null : app2.getAppId();
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_END;
                performanceAnalyseProxy.record(appId, pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31228p, bundle2);
                ((IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class)).notifyUpdateLoadingStep(((Page) renderById.i()).getApp().getAppId(), LoadStepAction.STEP_FINISH_MINIAPP_LOAD);
                m0.b((Page) renderById.i());
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app2 == null ? null : app2.getAppId(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31229q, bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, ((Page) renderById.i()).getApp().getStartParams().getString("uniqueChainID", "-1"));
                bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, ((Page) renderById.i()).getPagePath());
                bundle3.putAll(bundle);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app2 == null ? null : app2.getAppId(), pointAnalyseType, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31230r, bundle3);
                Bundle bundle4 = new Bundle();
                bundle4.putString("workerFromWarmup", bVar.c() + "");
                bundle4.putString("workerFromWarmupChannel", bVar.e() + "");
                bundle4.putString("renderFromWarmup", renderById.c() + "");
                bundle4.putString("renderFromWarmupChannel", renderById.e() + "");
                bundle4.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, ((Page) renderById.i()).getPagePath());
                bundle4.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, ((Page) renderById.i()).getPageId());
                bundle4.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.U, "1");
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app2 == null ? null : app2.getAppId(), PointAnalyseType.POINT_APP_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle4);
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(app2 == null ? null : app2.getAppId(), PointAnalyseType.POINT_PAGE_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K, bundle4);
                if (renderById.i() != null && (renderById.i() instanceof Page)) {
                    bundle4.putString("pageRandomId", ((Page) renderById.i()).getPageRandomIdByGAId());
                    bundle4.putString("pageUniqueId", q.d() + "_" + ((Page) renderById.i()).getPageId());
                    new g(bundle4).f(((Page) renderById.i()).getPageChainContext());
                }
            } else {
                protocolData = protocolData;
            }
            if (TextUtils.isEmpty(protocolData.getRenderId())) {
                return false;
            }
            ac.b.a aVarI = ac.b.b(renderById).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObject);
            if (renderById.getRenderBridge() != null) {
                renderById.getRenderBridge().a(aVarI.h(), null);
            }
            return true;
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.bridge.IMsgDispatcher
    public boolean handleMsgFromRender(EngineRouter engineRouter, String str, String str2, String str3) {
        uc.b eventCenterInstance;
        final JsonObject asJsonObject = JsonParser.parseString(str3).getAsJsonObject();
        ProtocolData protocolData = (ProtocolData) a0.f31025a.a(str3, ProtocolData.class);
        String abilityName = protocolData.getAbilityName();
        final gd.b workerById = engineRouter.getWorkerById(str);
        i renderById = engineRouter.getRenderById(!TextUtils.isEmpty(protocolData.getRenderId()) ? protocolData.getRenderId() : d(engineRouter));
        c(protocolData.getDataJson(), renderById);
        Node nodeBubbleFindNode = null;
        if ("Api".equals(protocolData.getAbilityName())) {
            ProtocolData.ApiDataJson apiDataJson = ProtocolData.ApiDataJson.parse((LinkedTreeMap) protocolData.getDataJson());
            String methodName = apiDataJson.getMethodName();
            String args = apiDataJson.getArgs();
            JsonObject asJsonObject2 = TextUtils.isEmpty(args) ? null : JsonParser.parseString(args).getAsJsonObject();
            String callbackId = protocolData.getCallbackId();
            renderById.t().getBridge().sendToNative(new NativeCallContext.b().d(methodName).f(asJsonObject2).e(renderById.i()).g(renderById).b(callbackId).c("" + System.currentTimeMillis()).a(), new a(methodName, callbackId, renderById));
            return false;
        }
        if (!"DispatchEvent".equals(abilityName)) {
            if ("LifeCycle".equals(abilityName)) {
                EngineUtils.c(workerById, new Runnable() { // from class: com.cloud.tmc.integration.MsgDispatcher.3
                    @Override // java.lang.Runnable
                    public void run() {
                        workerById.k(asJsonObject, null);
                    }
                });
                return true;
            }
            if ("setData".equals(abilityName)) {
                EngineUtils.c(workerById, new Runnable() { // from class: com.cloud.tmc.integration.MsgDispatcher.4
                    @Override // java.lang.Runnable
                    public void run() {
                        workerById.k(asJsonObject, null);
                    }
                });
                return false;
            }
            if ("DispatchNativeComponent".equals(abilityName)) {
                if (!"native".equals(protocolData.getTarget())) {
                    return false;
                }
                oc.a.f72395a.a(renderById, ProtocolData.NativeComponentDataJson.parse((LinkedTreeMap) protocolData.getDataJson()));
                return false;
            }
            if (!"DispatchNativeEvent".equals(abilityName) || !"native".equals(protocolData.getTarget())) {
                return false;
            }
            oc.a.f72395a.b(renderById, ProtocolData.NativeComponentDataJson.parse((LinkedTreeMap) protocolData.getDataJson()));
            return false;
        }
        if ("native".equals(protocolData.getTarget())) {
            ProtocolData.DispatchEventDataJson dispatchEventDataJson = ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData.getDataJson());
            String eventName = dispatchEventDataJson.getEventName();
            IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
            uc.a aVarCreateEvent = iEventCenterFactory.createEvent(eventName);
            HashMap map = new HashMap();
            map.put("eventData", dispatchEventDataJson.getDataJson());
            aVarCreateEvent.c(map);
            aVarCreateEvent.d(str2);
            if (!TextUtils.isEmpty(str2) && str2.startsWith("warmup_render_id_")) {
                nodeBubbleFindNode = ((WarmupNode) tc.a.a(WarmupNode.class)).getNode(str2);
            } else if (renderById != null) {
                nodeBubbleFindNode = renderById.i().bubbleFindNode(App.class);
            }
            if (nodeBubbleFindNode != null && (eventCenterInstance = iEventCenterFactory.getEventCenterInstance(nodeBubbleFindNode)) != null) {
                eventCenterInstance.d(eventName, aVarCreateEvent);
            }
        } else {
            try {
                if ("render".equals(protocolData.getTarget()) && renderById != null) {
                    String eventName2 = ProtocolData.DispatchEventDataJson.parse((LinkedTreeMap) protocolData.getDataJson()).getEventName();
                    if ("slaveLoaded".equals(eventName2) || "slaveAttached".equals(eventName2)) {
                        IEventCenterFactory iEventCenterFactory2 = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
                        uc.a aVarCreateEvent2 = iEventCenterFactory2.createEvent(eventName2);
                        uc.b eventCenterInstance2 = iEventCenterFactory2.getEventCenterInstance(renderById.i());
                        if (eventCenterInstance2 != null) {
                            eventCenterInstance2.d(eventName2, aVarCreateEvent2);
                        }
                    }
                    if ("slaveLoaded".equals(eventName2) && renderById.i() != null && (renderById.i() instanceof Page)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("workerFromWarmup", workerById.c() + "");
                        bundle.putString("workerFromWarmupChannel", workerById.e() + "");
                        bundle.putString("renderFromWarmup", renderById.c() + "");
                        bundle.putString("renderFromWarmupChannel", renderById.e() + "");
                        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, ((Page) renderById.i()).getPagePath());
                        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, ((Page) renderById.i()).getPageId());
                        bundle.putString("pageRandomId", ((Page) renderById.i()).getPageRandomIdByGAId());
                        bundle.putString("pageUniqueId", q.d() + "_" + ((Page) renderById.i()).getPageId());
                        new xa.a(bundle).f(((Page) renderById.i()).getPageChainContext());
                        new db.g(bundle).f(((Page) renderById.i()).getPageChainContext());
                    }
                    if ("slaveAttached".equals(eventName2)) {
                        Boolean boolValueOf = Boolean.valueOf(o0.f31090a.b("5.1.1", ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion()));
                        TmcLogger.c("pom", "ret:" + boolValueOf);
                        if (boolValueOf.booleanValue() && renderById.i() != null && (renderById.i() instanceof Page) && ((Page) renderById.i()).getApp() != null) {
                            IEventCenterFactory iEventCenterFactory3 = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
                            uc.a aVarCreateEvent3 = iEventCenterFactory3.createEvent("resendH5PageStack");
                            uc.b eventCenterInstance3 = iEventCenterFactory3.getEventCenterInstance(((Page) renderById.i()).getApp());
                            if (eventCenterInstance3 != null) {
                                eventCenterInstance3.d("resendH5PageStack_" + ((Page) renderById.i()).getApp().getAppId(), aVarCreateEvent3);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.g("MsgDispatcher", "", th2);
            }
            EngineUtils.c(workerById, new Runnable() { // from class: com.cloud.tmc.integration.MsgDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    workerById.k(asJsonObject, null);
                }
            });
        }
        return true;
    }

    @Override // com.cloud.tmc.kernel.bridge.IMsgDispatcher
    public boolean handleMsgFromWorker(gd.b bVar, JsonObject jsonObject) {
        TmcLogger.c("MsgDispatcher", "handleMsgFroworker msg = " + jsonObject);
        if (jsonObject == null) {
            return false;
        }
        return e(bVar, jsonObject);
    }
}
