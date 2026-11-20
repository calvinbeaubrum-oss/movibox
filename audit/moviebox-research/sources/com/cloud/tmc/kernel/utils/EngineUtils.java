package com.cloud.tmc.kernel.utils;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class EngineUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f31268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f31269b;

    /* JADX INFO: compiled from: source.java */
    public class a implements gd.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ac.d f31272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f31273b;

        public a(ac.d dVar, boolean z11) {
            this.f31272a = dVar;
            this.f31273b = z11;
        }

        @Override // gd.c
        public void a(JsonObject jsonObject) {
            ac.d dVar = this.f31272a;
            if (dVar == null || !this.f31273b) {
                return;
            }
            dVar.a(jsonObject);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f31268a = hashSet;
        HashSet hashSet2 = new HashSet();
        f31269b = hashSet2;
        hashSet.add("postMessage");
        hashSet.add("message");
        hashSet2.add("firePullToRefresh");
        hashSet2.add("pullIntercept");
        hashSet2.add("onShare");
    }

    public static String b(zc.i iVar) {
        return "";
    }

    public static void c(gd.b bVar, Runnable runnable) {
        if (Looper.myLooper() == bVar.m().getLooper()) {
            runnable.run();
        } else {
            bVar.m().post(runnable);
        }
    }

    public static void d(String str, String str2, gd.c cVar) {
        if (cVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(PushConstants.PROVIDER_FIELD_APP_ID, str);
            jsonObject.addProperty("result", "2");
            jsonObject.addProperty("messageId", str2);
            cVar.a(jsonObject);
        }
    }

    public static void e(final zc.i iVar, final gd.b bVar, String str, JsonObject jsonObject, final gd.c cVar) {
        if (iVar == null || iVar.i() == null) {
            TmcLogger.f("TmcEngine:EngineUtils", "sendPushWorkMessage but render or render.getPage() == null");
            return;
        }
        final String str2 = System.currentTimeMillis() + "";
        if (bVar == null) {
            bVar = iVar.t().getEngineRouter().getWorkerById(b(iVar));
        }
        if (bVar == null) {
            TmcLogger.o("TmcEngine:EngineUtils", "sendPushWorkerMessage but worker == null!");
            d(null, str2, cVar);
        } else {
            iVar.v();
            iVar.b();
            c(bVar, new Runnable() { // from class: com.cloud.tmc.kernel.utils.EngineUtils.2

                /* JADX INFO: renamed from: com.cloud.tmc.kernel.utils.EngineUtils$2$a */
                /* JADX INFO: compiled from: source.java */
                public class a implements gd.b.a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ JsonObject f31270a;

                    public a(JsonObject jsonObject) {
                        this.f31270a = jsonObject;
                    }

                    @Override // gd.b.a
                    public void a() {
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(iVar.getAppId(), PointAnalyseType.POINT_CHAIN_END, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31225n);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        bVar.k(this.f31270a, cVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.isDestroyed()) {
                        TmcLogger.o("TmcEngine:EngineUtils", "sendPushWorkerMessage but worker destroyed!");
                        EngineUtils.d(null, str2, cVar);
                        return;
                    }
                    JsonObject jsonObject2 = new JsonObject();
                    TmcLogger.c("TmcEngine:EngineUtils", " workerReady: " + bVar.i());
                    if (bVar.i()) {
                        bVar.k(jsonObject2, cVar);
                    } else {
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(iVar.getAppId(), PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31225n);
                        bVar.l(new a(jsonObject2));
                    }
                }
            });
        }
    }

    public static void f(zc.i iVar, gd.b bVar, String str, @Nullable JsonObject jsonObject, @Nullable ac.d dVar) {
        boolean z11;
        if (iVar == null) {
            TmcLogger.o("TmcEngine:EngineUtils", "sendToRender but render == null!!");
            return;
        }
        if (bVar == null) {
            bVar = iVar.t().getEngineRouter().getWorkerById(b(iVar));
        }
        if (bVar == null || f31268a.contains(str)) {
            z11 = false;
        } else {
            z11 = !f31269b.contains(str);
            e(iVar, bVar, str, jsonObject, new a(dVar, z11));
        }
        if (iVar.getRenderBridge() == null) {
            TmcLogger.o("TmcEngine:EngineUtils", "sendToRender but render.getRenderBridge == null!!");
            return;
        }
        ac.b.a aVarI = ac.b.b(iVar).j(NotificationCompat.CATEGORY_CALL).g(str).i(jsonObject);
        ac.a renderBridge = iVar.getRenderBridge();
        ac.b bVarH = aVarI.h();
        if (z11) {
            dVar = null;
        }
        renderBridge.a(bVarH, dVar);
    }

    public static void g(zc.i iVar, String str, @Nullable JsonObject jsonObject, @Nullable ac.d dVar) {
        f(iVar, null, str, jsonObject, dVar);
    }
}
