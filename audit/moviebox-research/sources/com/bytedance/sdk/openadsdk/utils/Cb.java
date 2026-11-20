package com.bytedance.sdk.openadsdk.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Cb {
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI ExN;
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI Ol;
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI Qj;
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI TRI;
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI WH;
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI We;
    private static volatile boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI f28710qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f28711sc;
    private static volatile com.bytedance.sdk.component.Qj.zY.TRI zY;

    static {
        com.bytedance.sdk.component.Qj.zY.zY.sc(new com.bytedance.sdk.component.Qj.zY.sc() { // from class: com.bytedance.sdk.openadsdk.utils.Cb.1
            @Override // com.bytedance.sdk.component.Qj.zY.sc
            public void sc(com.bytedance.sdk.component.Qj.zY.TRI tri, com.bytedance.sdk.component.Qj.zY.pFF pff) {
                pff.pFF();
                new RuntimeException();
            }
        });
        com.bytedance.sdk.component.Qj.zY.zY.sc(new com.bytedance.sdk.component.Qj.zY.ExN() { // from class: com.bytedance.sdk.openadsdk.utils.Cb.3
            @Override // com.bytedance.sdk.component.Qj.zY.ExN
            public void sc(final com.bytedance.sdk.component.Qj.zY.TRI tri) {
                if (HJN.f28732sc || tri == null) {
                    return;
                }
                try {
                    LinkedHashMap<String, com.bytedance.sdk.component.Qj.zY.sc.sc> linkedHashMapSc = tri.sc();
                    if (linkedHashMapSc == null || linkedHashMapSc.size() <= 0) {
                        return;
                    }
                    Iterator<Map.Entry<String, com.bytedance.sdk.component.Qj.zY.sc.sc>> it = linkedHashMapSc.entrySet().iterator();
                    while (it.hasNext()) {
                        final com.bytedance.sdk.component.Qj.zY.sc.sc value = it.next().getValue();
                        if (value != null) {
                            com.bytedance.sdk.openadsdk.SR.zY.sc();
                            com.bytedance.sdk.openadsdk.SR.zY.sc("pag_thread_pool_state", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.utils.Cb.3.1
                                @Override // com.bytedance.sdk.openadsdk.SR.pFF
                                public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("name", value.sc());
                                        jSONObject.put("times", value.pFF());
                                        jSONObject.put("runMaxTime", value.TRI());
                                        jSONObject.put("waitMaxTime", value.ExN());
                                        long jPFF = value.pFF() == 0 ? 1 : value.pFF();
                                        jSONObject.put("avgRunTime", value.We() / jPFF);
                                        jSONObject.put("avgWaitTime", value.zY() / jPFF);
                                        jSONObject.put("poolType", tri.pFF());
                                    } catch (Exception e11) {
                                        com.bytedance.sdk.component.utils.Tf.sc("ThreadUtils", "run: ", e11);
                                    }
                                    return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("pag_thread_pool_state").pFF(jSONObject.toString());
                                }
                            });
                        }
                    }
                } catch (Throwable th2) {
                    th2.getMessage();
                }
            }
        });
        f28711sc = null;
        pFF = false;
    }

    private static com.bytedance.sdk.component.Qj.zY.TRI BT() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = ExN;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(ExN)) {
                    try {
                        ExN = sc("aidl", ExN);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = ExN;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    public static void ExN(final com.bytedance.sdk.component.Qj.Qj qj2) {
        if (HJN.f28732sc) {
            return;
        }
        if (UFX()) {
            Ql().execute(new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName(), qj2) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.2
                @Override // java.lang.Runnable
                public void run() {
                    qj2.run();
                }
            });
            return;
        }
        ThreadPoolExecutor threadPoolExecutorTf = Tf();
        threadPoolExecutorTf.execute(qj2);
        if (pFF || !com.bytedance.sdk.openadsdk.core.settings.dE.ag()) {
            return;
        }
        pFF = true;
        threadPoolExecutorTf.setCorePoolSize(com.bytedance.sdk.openadsdk.core.settings.dE.ef().IEI());
    }

    public static boolean ExN() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static com.bytedance.sdk.component.Qj.zY.TRI Ol() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = Ol;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(Ol)) {
                    try {
                        Ol = sc("express", Ol);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = Ol;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    public static com.bytedance.sdk.component.Qj.zY.TRI Qj() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = TRI;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(TRI)) {
                    try {
                        TRI = sc("cache", TRI);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = TRI;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    private static ThreadPoolExecutor Ql() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = zY;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(zY)) {
                    try {
                        zY = sc("ad", zY);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = zY;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    private static com.bytedance.sdk.component.Qj.zY.TRI SR() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = We;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(We)) {
                    try {
                        We = sc("log", We);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = We;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    public static boolean TRI() {
        String str = UFX() ? "pag_log" : "csj_log";
        String name = Thread.currentThread().getName();
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        return name.startsWith(str);
    }

    private static ThreadPoolExecutor Tf() {
        int i11;
        if (f28711sc == null) {
            synchronized (Cb.class) {
                try {
                    if (f28711sc == null) {
                        if (com.bytedance.sdk.openadsdk.core.settings.dE.ag()) {
                            int iIEI = com.bytedance.sdk.openadsdk.core.settings.dE.ef().IEI();
                            pFF = true;
                            i11 = iIEI;
                        } else {
                            i11 = 4;
                        }
                        f28711sc = new ThreadPoolExecutor(i11, Api.BaseClientBuilder.API_PRIORITY_OTHER, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28711sc;
    }

    public static boolean UFX() {
        if (com.bytedance.sdk.openadsdk.core.settings.dE.ag()) {
            return com.bytedance.sdk.openadsdk.core.settings.dE.ef().QST();
        }
        return true;
    }

    public static com.bytedance.sdk.component.Qj.zY.TRI WH() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = WH;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(WH)) {
                    try {
                        WH = sc("net", WH);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = WH;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    public static ExecutorService We() {
        return UFX() ? Qj() : com.bytedance.sdk.component.Qj.TRI.pFF();
    }

    public static void We(final com.bytedance.sdk.component.Qj.Qj qj2) {
        if (qj2 == null || HJN.f28732sc) {
            return;
        }
        if (UFX()) {
            Ql().execute(new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.9
                @Override // java.lang.Runnable
                public void run() {
                    qj2.run();
                }
            });
        } else {
            com.bytedance.sdk.component.Qj.TRI.ExN(qj2);
        }
    }

    private static com.bytedance.sdk.component.Qj.zY.TRI Xc() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = f28710qr;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(f28710qr)) {
                    try {
                        f28710qr = sc("io", f28710qr);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = f28710qr;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    private static com.bytedance.sdk.component.Qj.zY.TRI dE() {
        com.bytedance.sdk.component.Qj.zY.TRI tri;
        com.bytedance.sdk.component.Qj.zY.TRI tri2 = Qj;
        if (!sc(tri2)) {
            return tri2;
        }
        synchronized (Cb.class) {
            try {
                if (sc(Qj)) {
                    try {
                        Qj = sc("image", Qj);
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
                tri = Qj;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return tri;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    private static com.bytedance.sdk.component.Qj.zY.TRI.sc pFF(String str) {
        if (TextUtils.isEmpty(str)) {
            str = AppLovinMediationProvider.UNKNOWN;
        }
        com.bytedance.sdk.component.Qj.zY.TRI.sc scVar = new com.bytedance.sdk.component.Qj.zY.TRI.sc();
        str.hashCode();
        switch (str) {
            case "express":
                return scVar.sc(str).sc(2).pFF(4).zY(0).sc(10000L).sc(true).ExN(-1).We(10).pFF(false);
            case "ad":
                return scVar.sc(str).sc(4).pFF(4).zY(0).sc(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).sc(true).ExN(-1).We(10).pFF(false);
            case "io":
                return scVar.sc(str).sc(4).pFF(10).zY(0).sc(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).sc(true).ExN(-1).We(10).pFF(false);
            case "log":
                return scVar.sc(str).sc(4).pFF(6).zY(2).sc(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).sc(true).ExN(-1).We(10).pFF(false);
            case "net":
                return scVar.sc(str).sc(10).pFF(10).zY(0).sc(10000L).sc(true).ExN(-1).We(10).pFF(false);
            case "aidl":
                return scVar.sc(str).sc(2).pFF(4).zY(0).sc(10000L).sc(true).ExN(-1).We(10).pFF(false);
            case "cache":
                return scVar.sc(str).sc(0).pFF(0).zY(0).sc(5000L).sc(true).ExN(-1).We(20).pFF(false);
            case "image":
                return scVar.sc(str).sc(3).pFF(3).zY(0).sc(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).sc(true).ExN(-1).We(10).pFF(false);
            case "monitor":
                return scVar.sc(str).sc(2).pFF(2).zY(0).sc(10000L).sc(true).ExN(-1).We(10).pFF(false);
            default:
                return scVar.sc(str).sc(8).pFF(16).zY(2).sc(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).sc(true).ExN(-1).We(10).pFF(false);
        }
    }

    public static ExecutorService pFF() {
        return UFX() ? dE() : com.bytedance.sdk.component.Qj.TRI.WH();
    }

    public static void pFF(final com.bytedance.sdk.component.Qj.Qj qj2) {
        if (HJN.f28732sc) {
            return;
        }
        if (UFX()) {
            Xc().execute(new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.5
                @Override // java.lang.Runnable
                public void run() {
                    qj2.run();
                }
            });
        } else {
            com.bytedance.sdk.component.Qj.TRI.pFF(qj2);
        }
    }

    public static void pFF(final com.bytedance.sdk.component.Qj.Qj qj2, int i11) {
        if (qj2 == null || HJN.f28732sc) {
            return;
        }
        if (!UFX()) {
            com.bytedance.sdk.component.Qj.TRI.pFF(qj2, i11);
            return;
        }
        com.bytedance.sdk.component.Qj.zY.pFF pff = new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.8
            @Override // java.lang.Runnable
            public void run() {
                qj2.run();
            }
        };
        pff.sc(i11);
        SR().execute(pff);
    }

    public static void pFF(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.SR.zY().removeCallbacks(runnable);
    }

    public static ExecutorService qr() {
        return UFX() ? Xc() : com.bytedance.sdk.component.Qj.TRI.zY();
    }

    private static com.bytedance.sdk.component.Qj.zY.TRI.sc sc(String str) {
        com.bytedance.sdk.component.Qj.zY.TRI.sc scVarPFF = pFF(str);
        try {
            if (com.bytedance.sdk.openadsdk.core.settings.dE.ag()) {
                scVarPFF.pFF(true);
                JSONObject jSONObjectMbO = com.bytedance.sdk.openadsdk.core.settings.dE.ef().mbO();
                JSONObject jSONObjectOptJSONObject = jSONObjectMbO != null ? jSONObjectMbO.optJSONObject(str) : null;
                if (jSONObjectOptJSONObject != null) {
                    scVarPFF.pFF(true);
                    if (jSONObjectOptJSONObject.has("coreSize")) {
                        scVarPFF.sc(jSONObjectOptJSONObject.optInt("coreSize"));
                    }
                    if (jSONObjectOptJSONObject.has("maxSize")) {
                        scVarPFF.pFF(jSONObjectOptJSONObject.optInt("maxSize"));
                    }
                    if (jSONObjectOptJSONObject.has("createSize")) {
                        scVarPFF.zY(jSONObjectOptJSONObject.optInt("createSize"));
                    }
                    if (jSONObjectOptJSONObject.has("keepAlive")) {
                        scVarPFF.sc(jSONObjectOptJSONObject.optInt("keepAlive"));
                    }
                    if (jSONObjectOptJSONObject.has("allowCoreTimeOut")) {
                        scVarPFF.sc(jSONObjectOptJSONObject.optBoolean("allowCoreTimeOut"));
                    }
                    if (jSONObjectOptJSONObject.has("reportLogThreshold")) {
                        scVarPFF.ExN(jSONObjectOptJSONObject.optInt("reportLogThreshold"));
                    }
                    if (jSONObjectOptJSONObject.has("logTaskCount")) {
                        scVarPFF.We(jSONObjectOptJSONObject.optInt("logTaskCount"));
                    }
                }
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
        return scVarPFF;
    }

    private static com.bytedance.sdk.component.Qj.zY.TRI sc(String str, com.bytedance.sdk.component.Qj.zY.TRI tri) {
        com.bytedance.sdk.component.Qj.zY.TRI.sc scVarSc = sc(str);
        if (tri == null) {
            return scVarSc.sc();
        }
        tri.sc(scVarSc);
        return tri;
    }

    public static ScheduledExecutorService sc() {
        return com.bytedance.sdk.component.Qj.TRI.TRI();
    }

    public static void sc(final com.bytedance.sdk.component.Qj.Qj qj2) {
        if (HJN.f28732sc) {
            return;
        }
        if (UFX()) {
            Qj().execute(new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.4
                @Override // java.lang.Runnable
                public void run() {
                    qj2.run();
                }
            });
        } else {
            com.bytedance.sdk.component.Qj.TRI.sc(qj2);
        }
    }

    public static void sc(final com.bytedance.sdk.component.Qj.Qj qj2, int i11) {
        if (qj2 == null || HJN.f28732sc) {
            return;
        }
        if (!UFX()) {
            com.bytedance.sdk.component.Qj.TRI.sc(qj2, 5, i11);
            return;
        }
        com.bytedance.sdk.component.Qj.zY.pFF pff = new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.6
            @Override // java.lang.Runnable
            public void run() {
                qj2.run();
            }
        };
        pff.sc(i11);
        Xc().execute(pff);
    }

    public static void sc(com.bytedance.sdk.component.Qj.zY.pFF pff) {
        WH().execute(pff);
    }

    public static void sc(Runnable runnable) {
        if (runnable == null || HJN.f28732sc) {
            return;
        }
        if (ExN()) {
            runnable.run();
        } else {
            com.bytedance.sdk.openadsdk.core.SR.zY().post(runnable);
        }
    }

    private static boolean sc(com.bytedance.sdk.component.Qj.zY.TRI tri) {
        if (tri != null) {
            return !tri.zY() && com.bytedance.sdk.openadsdk.core.settings.dE.ag();
        }
        return true;
    }

    public static ExecutorService zY() {
        return UFX() ? SR() : com.bytedance.sdk.component.Qj.TRI.We();
    }

    public static void zY(final com.bytedance.sdk.component.Qj.Qj qj2) {
        if (qj2 == null || HJN.f28732sc) {
            return;
        }
        if (UFX()) {
            SR().execute(new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.7
                @Override // java.lang.Runnable
                public void run() {
                    qj2.run();
                }
            });
        } else {
            com.bytedance.sdk.component.Qj.TRI.zY(qj2);
        }
    }

    public static void zY(final com.bytedance.sdk.component.Qj.Qj qj2, int i11) {
        if (qj2 == null || HJN.f28732sc) {
            return;
        }
        if (UFX()) {
            BT().execute(new com.bytedance.sdk.component.Qj.zY.pFF(qj2.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.Cb.10
                @Override // java.lang.Runnable
                public void run() {
                    qj2.run();
                }
            });
        } else {
            com.bytedance.sdk.component.Qj.TRI.zY(qj2, i11);
        }
    }
}
