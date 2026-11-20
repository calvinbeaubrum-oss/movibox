package com.bytedance.sdk.openadsdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SR {
    public static long ExN = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static volatile HandlerThread f28192qr = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static volatile boolean f28193sc = false;
    public static AtomicBoolean pFF = new AtomicBoolean(false);
    public static long zY = 0;
    private static volatile int TRI = 0;
    public static float We = 1.0f;
    private static volatile Handler Qj = null;

    static {
        HandlerThread handlerThread = new HandlerThread("csj_init_handle", 10);
        f28192qr = handlerThread;
        handlerThread.start();
        ExN = System.currentTimeMillis();
    }

    public static boolean ExN() {
        return We() == 1;
    }

    public static void Qj() {
        pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.SR.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.SR.3.1
                        @Override // com.bytedance.sdk.openadsdk.dE.We
                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            scVar.pFF("init");
                            return scVar;
                        }
                    });
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("InitHelper", th2.getMessage());
                }
            }
        });
    }

    public static void TRI() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - zY <= 10000) {
            return;
        }
        zY = jElapsedRealtime;
        com.bytedance.sdk.openadsdk.utils.Cb.sc(new com.bytedance.sdk.component.Qj.Qj("onSharedPreferenceChanged") { // from class: com.bytedance.sdk.openadsdk.core.SR.1
            @Override // java.lang.Runnable
            public void run() {
                String strZY = com.bytedance.sdk.openadsdk.core.settings.dE.zY(Xc.sc());
                if (TextUtils.equals(strZY, com.bytedance.sdk.openadsdk.core.settings.dE.We)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(6, true);
                com.bytedance.sdk.openadsdk.core.settings.dE.We = strZY;
            }
        });
    }

    public static int We() {
        return TRI;
    }

    public static Handler pFF() {
        if (f28192qr == null || !f28192qr.isAlive()) {
            synchronized (SR.class) {
                try {
                    if (f28192qr == null || !f28192qr.isAlive()) {
                        HandlerThread handlerThread = new HandlerThread("csj_init_handle", -1);
                        f28192qr = handlerThread;
                        handlerThread.start();
                        Qj = new Handler(f28192qr.getLooper());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else if (Qj == null) {
            synchronized (SR.class) {
                try {
                    if (Qj == null) {
                        Qj = new Handler(f28192qr.getLooper());
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return Qj;
    }

    public static void qr() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - zY <= 10000) {
            return;
        }
        synchronized (SR.class) {
            try {
                if (jElapsedRealtime - zY <= 10000) {
                    return;
                }
                zY = jElapsedRealtime;
                com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.SR.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String strZY = com.bytedance.sdk.openadsdk.core.settings.dE.zY(Xc.sc());
                        if (TextUtils.equals(strZY, com.bytedance.sdk.openadsdk.core.settings.dE.We)) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(6, true);
                        com.bytedance.sdk.openadsdk.core.settings.dE.We = strZY;
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static long sc() {
        return ExN;
    }

    public static void sc(int i11) {
        TRI = i11;
    }

    public static void sc(long j11) {
        ExN = j11;
    }

    public static void sc(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                if ("mediation".equals(jSONObject.optString("name", ""))) {
                    Ol.pFF().pFF(jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, ""));
                    return;
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("InitHelper", th2.getMessage());
        }
    }

    public static Handler zY() {
        return new Handler(Looper.getMainLooper());
    }
}
