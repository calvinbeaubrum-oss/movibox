package com.cloud.tmc.miniapp.performanceanalyse.screen;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.p;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
import t.c;
import t.d;
import t.e;
import uc.b;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenInspectHelper implements IScreenInspectProxy {
    public b OooO00o;
    public final ConcurrentHashMap<Object, t.a> OooO0O0 = new ConcurrentHashMap<>();
    public List<Integer> OooO0OO = new ArrayList();

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public long f31555OooO0Oo = 1000;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public float f31556OooO0o0;

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.performanceanalyse.screen.ScreenInspectHelper$checkNow$1", f = "ScreenInspectHelper.kt", l = {321}, m = "invokeSuspend")
    public static final class OooO0O0 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public int OooO00o;
        public final /* synthetic */ App OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ String f31557OooO0Oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(App app, String str, Continuation<? super OooO0O0> continuation) {
            super(2, continuation);
            this.OooO0OO = app;
            this.f31557OooO0Oo = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScreenInspectHelper.this.new OooO0O0(this.OooO0OO, this.f31557OooO0Oo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ScreenInspectHelper.this.new OooO0O0(this.OooO0OO, this.f31557OooO0Oo, continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ConcurrentHashMap<String, e> concurrentHashMap;
            e eVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.OooO00o;
            if (i11 == 0) {
                ResultKt.b(obj);
                long j11 = ScreenInspectHelper.this.f31555OooO0Oo > 0 ? ScreenInspectHelper.this.f31555OooO0Oo : 0L;
                this.OooO00o = 1;
                if (r0.a(j11, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            t.a aVar = (t.a) ScreenInspectHelper.this.OooO0O0.get(this.OooO0OO.getAppId());
            if (aVar != null && (concurrentHashMap = aVar.f76645b) != null && (eVar = concurrentHashMap.get(this.f31557OooO0Oo)) != null) {
                ScreenInspectHelper screenInspectHelper = ScreenInspectHelper.this;
                if (eVar.f76664g) {
                    return Unit.f68710a;
                }
                ScreenInspectHelper.access$checkWhiteScreen(screenInspectHelper, eVar);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class a implements com.cloud.tmc.miniapp.performanceanalyse.screen.a.InterfaceC0344a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t.a f31558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f31559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScreenInspectHelper f31560c;

        public a(ScreenInspectHelper screenInspectHelper, t.a appData, e pageData) {
            Intrinsics.g(appData, "appData");
            Intrinsics.g(pageData, "pageData");
            this.f31560c = screenInspectHelper;
            this.f31558a = appData;
            this.f31559b = pageData;
        }

        @Override // com.cloud.tmc.miniapp.performanceanalyse.screen.a.InterfaceC0344a
        public void OooO00o() {
            e eVar = this.f31559b;
            if (eVar.f76662e == 2) {
                eVar.f76664g = true;
                ScreenInspectHelper screenInspectHelper = this.f31560c;
                String str = this.f31558a.f76644a;
                boolean z11 = eVar.f76665h;
                com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar = eVar.f76663f;
                screenInspectHelper.OooO00o(str, 2, z11, aVar != null ? Long.valueOf(aVar.a()) : null);
            }
        }

        @Override // com.cloud.tmc.miniapp.performanceanalyse.screen.a.InterfaceC0344a
        public void b() {
            com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar;
            e eVar = this.f31559b;
            if (eVar.f76662e != 3 || (aVar = eVar.f76663f) == null) {
                return;
            }
            aVar.cancel();
        }

        @Override // com.cloud.tmc.miniapp.performanceanalyse.screen.a.InterfaceC0344a
        public void c() {
            e eVar = this.f31559b;
            ScreenInspectHelper screenInspectHelper = this.f31560c;
            if (eVar.f76662e == 3) {
                com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar = eVar.f76663f;
                if (aVar != null) {
                    aVar.cancel();
                    return;
                }
                return;
            }
            if (eVar.f76658a != null) {
                int i11 = eVar.f76659b;
                if (i11 == 0) {
                    eVar.f76659b = 1;
                    ScreenInspectHelper.access$connectRender(screenInspectHelper, this.f31558a, eVar);
                } else if (i11 == 1) {
                    b bVar = screenInspectHelper.OooO00o;
                    if (bVar != null) {
                        bVar.c("connectionRender", eVar.f76660c);
                    }
                    ScreenInspectHelper.access$connectRender(screenInspectHelper, this.f31558a, this.f31559b);
                }
            }
            t.a aVar2 = this.f31558a;
            ScreenInspectHelper screenInspectHelper2 = this.f31560c;
            if (aVar2.f76646c != null) {
                int i12 = aVar2.f76647d;
                if (i12 == 0) {
                    aVar2.f76647d = 1;
                    ScreenInspectHelper.access$connectWorker(screenInspectHelper2, aVar2, this.f31559b);
                } else if (i12 == 1) {
                    b bVar2 = screenInspectHelper2.OooO00o;
                    if (bVar2 != null) {
                        bVar2.c("connectionRender", aVar2.f76648e);
                    }
                    ScreenInspectHelper.access$connectWorker(screenInspectHelper2, this.f31558a, this.f31559b);
                }
            }
            e eVar2 = this.f31559b;
            if (eVar2.f76659b == 2 && this.f31558a.f76647d == 2) {
                ScreenInspectHelper.access$checkWhiteScreen(this.f31560c, eVar2);
            }
        }
    }

    public static final void access$checkWhiteScreen(ScreenInspectHelper screenInspectHelper, e eVar) {
        b bVar;
        screenInspectHelper.getClass();
        int i11 = eVar.f76662e;
        if (i11 == 3) {
            return;
        }
        if (i11 == 0 || i11 == 2) {
            eVar.f76662e = 1;
        } else if (i11 == 1 && (bVar = screenInspectHelper.OooO00o) != null) {
            bVar.c("renderStatus", eVar.f76661d);
        }
        i iVar = eVar.f76658a;
        t.b bVar2 = new t.b(screenInspectHelper, eVar, iVar != null ? iVar.getAppId() : null);
        eVar.f76661d = bVar2;
        b bVar3 = screenInspectHelper.OooO00o;
        if (bVar3 != null) {
            bVar3.b("renderStatus", bVar2);
        }
        i iVar2 = eVar.f76658a;
        if (iVar2 != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject.addProperty("abilityName", "DispatchEvent");
            jsonObject.addProperty("callbackId", Long.valueOf(System.currentTimeMillis()));
            jsonObject2.addProperty("eventName", "checkWhiteScreen");
            jsonObject2.addProperty("dataJson", "{}");
            jsonObject.add("dataJson", jsonObject2);
            ac.b.a aVarI = ac.b.b(iVar2).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObject);
            ac.a renderBridge = iVar2.getRenderBridge();
            if (renderBridge != null) {
                renderBridge.a(aVarI.h(), null);
            }
        }
    }

    public static final void access$connectRender(ScreenInspectHelper screenInspectHelper, t.a aVar, e eVar) {
        screenInspectHelper.getClass();
        c cVar = new c(eVar, screenInspectHelper, aVar);
        eVar.f76660c = cVar;
        b bVar = screenInspectHelper.OooO00o;
        if (bVar != null) {
            bVar.b("connectionRender", cVar);
        }
        i iVar = eVar.f76658a;
        if (iVar != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject.addProperty("abilityName", "DispatchEvent");
            jsonObject.addProperty("callbackId", Long.valueOf(System.currentTimeMillis()));
            jsonObject2.addProperty("eventName", "connection");
            jsonObject2.addProperty("dataJson", "{}");
            jsonObject.add("dataJson", jsonObject2);
            ac.b.a aVarI = ac.b.b(iVar).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObject);
            ac.a renderBridge = iVar.getRenderBridge();
            if (renderBridge != null) {
                renderBridge.a(aVarI.h(), null);
            }
        }
    }

    public static final void access$connectWorker(ScreenInspectHelper screenInspectHelper, t.a aVar, e eVar) {
        screenInspectHelper.getClass();
        d dVar = new d(aVar, screenInspectHelper, eVar);
        aVar.f76648e = dVar;
        b bVar = screenInspectHelper.OooO00o;
        if (bVar != null) {
            bVar.b("connectionWorker", dVar);
        }
        gd.b bVar2 = aVar.f76646c;
        if (bVar2 != null) {
            HashMap<String, Object> map = new HashMap<>();
            HashMap map2 = new HashMap();
            JsonObject jsonObject = new JsonObject();
            map2.put("eventName", "connection");
            jsonObject.addProperty("eventName", "connection");
            map2.put("dataJson", "{}");
            jsonObject.addProperty("dataJson", "{}");
            map.put("abilityName", "DispatchEvent");
            map.put("target", "worker");
            map.put("source", "native");
            map.put("time", Long.valueOf(System.currentTimeMillis()));
            map.put("callbackId", "");
            map.put("dataJson", map2);
            JsonObject asJsonObject = JsonParser.parseString(new Gson().toJson(new ProtocolData("DispatchEvent", "worker", "native", System.currentTimeMillis(), "", jsonObject))).getAsJsonObject();
            if (bVar2.workerType() == 1) {
                bVar2.j(map, null);
            } else if (bVar2.workerType() == 3) {
                bVar2.k(asJsonObject, null);
            }
        }
    }

    public final void OooO00o(String str, int i11, boolean z11, Long l11) {
        Bundle bundle = new Bundle();
        bundle.putString("white_screen_onPageReady", String.valueOf(z11));
        bundle.putString("white_screen", String.valueOf(i11));
        bundle.putString("white_screen_stepMillis", String.valueOf(l11));
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(str, PointAnalyseType.POINT_CHECK_WHITESCREEN, "", bundle);
    }

    public final void OooO00o(e eVar) {
        b bVar;
        b bVar2;
        if (eVar != null) {
            eVar.f76658a = null;
            uc.c cVar = eVar.f76660c;
            if (cVar != null && (bVar2 = this.OooO00o) != null) {
                bVar2.c("connectionRender", cVar);
            }
            eVar.f76660c = null;
            uc.c cVar2 = eVar.f76661d;
            if (cVar2 != null && (bVar = this.OooO00o) != null) {
                bVar.c("renderStatus", cVar2);
            }
            eVar.f76661d = null;
            com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar = eVar.f76663f;
            if (aVar != null) {
                aVar.cancel();
            }
            eVar.f76663f = null;
        }
    }

    @Override // com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy
    public void appDestroy(App app) {
        String appId = app != null ? app.getAppId() : null;
        if (appId == null || appId.length() == 0) {
            return;
        }
        t.a aVar = this.OooO0O0.get(appId);
        if (aVar != null) {
            aVar.f76646c = null;
            b bVar = this.OooO00o;
            if (bVar != null) {
                bVar.c("connectionWorker", aVar.f76648e);
            }
            aVar.f76648e = null;
            Enumeration<String> enumerationKeys = aVar.f76645b.keys();
            Intrinsics.f(enumerationKeys, "pages.keys()");
            Iterator itX = CollectionsKt__IteratorsJVMKt.x(enumerationKeys);
            while (itX.hasNext()) {
                destroy(app, (String) itX.next());
            }
            aVar.f76645b.clear();
        }
        this.OooO0O0.remove(appId);
    }

    @Override // com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy
    public void checkNow(App app, String pageUrl) {
        ConcurrentHashMap<String, e> concurrentHashMap;
        Intrinsics.g(app, "app");
        Intrinsics.g(pageUrl, "pageUrl");
        t.a aVar = this.OooO0O0.get(app.getAppId());
        e eVar = (aVar == null || (concurrentHashMap = aVar.f76645b) == null) ? null : concurrentHashMap.get(pageUrl);
        if (eVar != null) {
            eVar.f76665h = true;
        }
        j.d(l0.a(w0.a()), null, null, new OooO0O0(app, pageUrl, null), 3, null);
    }

    @Override // com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy
    public void destroy(App app, String str) {
        t.a aVar;
        ConcurrentHashMap<String, e> concurrentHashMap;
        e eVar;
        String appId = app != null ? app.getAppId() : null;
        if (appId == null || appId.length() == 0 || str == null || str.length() == 0 || (aVar = this.OooO0O0.get(appId)) == null || (concurrentHashMap = aVar.f76645b) == null || (eVar = concurrentHashMap.get(str)) == null) {
            return;
        }
        if (!eVar.f76664g) {
            eVar.f76664g = true;
            boolean z11 = eVar.f76665h;
            com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar2 = eVar.f76663f;
            OooO00o(appId, 1, z11, aVar2 != null ? Long.valueOf(aVar2.a()) : null);
        }
        OooO00o(eVar);
    }

    @Override // com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy
    public void initConfig(float f11, Long l11, int[] iArr) {
        if (iArr != null) {
            this.OooO0OO.clear();
            this.OooO0OO.addAll(ArraysKt___ArraysJvmKt.f(iArr));
        }
        if (l11 != null) {
            this.f31555OooO0Oo = l11.longValue();
        }
        this.f31556OooO0o0 = f11;
    }

    @Override // com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy
    public void registerRender(i render) {
        ConcurrentHashMap<String, e> concurrentHashMap;
        Intrinsics.g(render, "render");
        if (!this.OooO0O0.containsKey(render.getAppId())) {
            StringBuilder sbA = hd.j.a("注册页面:");
            sbA.append(render.v());
            sbA.append("的应用(");
            sbA.append(render.getAppId());
            sbA.append(")不存在");
            p.e("miniapp", sbA.toString());
            return;
        }
        t.a aVar = this.OooO0O0.get(render.getAppId());
        if (aVar == null || (concurrentHashMap = aVar.f76645b) == null) {
            return;
        }
        Node nodeI = render.i();
        PageNode pageNode = nodeI instanceof PageNode ? (PageNode) nodeI : null;
        e eVar = concurrentHashMap.get(pageNode != null ? pageNode.getPagePath() : null);
        if (eVar != null) {
            eVar.f76658a = render;
            eVar.f76659b = 0;
            eVar.f76662e = 0;
        }
    }

    @Override // com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy
    public void registerWorker(App app, gd.b worker) {
        Intrinsics.g(worker, "worker");
        String appId = app != null ? app.getAppId() : null;
        if (appId != null && appId.length() > 0 && this.OooO0O0.containsKey(appId)) {
            t.a aVar = this.OooO0O0.get(appId);
            if (aVar != null) {
                aVar.f76646c = worker;
                aVar.f76647d = 0;
                return;
            }
            return;
        }
        StringBuilder sbA = hd.j.a("注册worker id:");
        sbA.append(worker.getWorkerId());
        sbA.append("的应用(");
        sbA.append(appId);
        sbA.append(")不存在");
        p.e("miniapp", sbA.toString());
    }

    @Override // com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy
    public void start(App app, String str) {
        long jLongValue;
        ConcurrentHashMap<String, e> concurrentHashMap;
        e eVar = null;
        String appId = app != null ? app.getAppId() : null;
        double dNextDouble = new SecureRandom().nextDouble();
        float f11 = this.f31556OooO0o0;
        boolean z11 = f11 != 0.0f && dNextDouble <= ((double) f11);
        if (appId == null || appId.length() == 0 || str == null || str.length() == 0 || !z11) {
            return;
        }
        this.OooO00o = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app);
        if (this.OooO0O0.containsKey(appId)) {
            t.a aVar = this.OooO0O0.get(appId);
            if (aVar != null && (concurrentHashMap = aVar.f76645b) != null) {
                eVar = concurrentHashMap.get(str);
            }
            OooO00o(eVar);
        } else {
            this.OooO0O0.put(appId, new t.a(appId, new ConcurrentHashMap(), null, 0, null));
        }
        if (this.OooO0OO.size() > 0) {
            List<Integer> list = this.OooO0OO;
            jLongValue = list.get(list.size() - 1).longValue() * 1000;
        } else {
            jLongValue = 0;
        }
        long j11 = (jLongValue >= 0 ? jLongValue : 0L) + ((long) 1000);
        t.a aVar2 = this.OooO0O0.get(appId);
        if (aVar2 != null) {
            ConcurrentHashMap<String, e> concurrentHashMap2 = aVar2.f76645b;
            e eVar2 = new e(null, 0, null, null, 0, null, false, false, 255);
            com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar3 = new com.cloud.tmc.miniapp.performanceanalyse.screen.a(j11, 1000L, this.OooO0OO, new a(this, aVar2, eVar2));
            aVar3.start();
            eVar2.f76663f = aVar3;
            Unit unit = Unit.f68710a;
            concurrentHashMap2.put(str, eVar2);
        }
    }
}
