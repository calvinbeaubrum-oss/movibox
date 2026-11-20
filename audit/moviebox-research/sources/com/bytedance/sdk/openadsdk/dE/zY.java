package com.bytedance.sdk.openadsdk.dE;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private static volatile Handler We;
    private static Boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile sc f28611sc;
    private static volatile HandlerThread zY;

    static {
        HandlerThread handlerThread = new HandlerThread("pag__bus_monitor", 0);
        zY = handlerThread;
        handlerThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler ExN() {
        if (zY == null || !zY.isAlive()) {
            synchronized (SR.class) {
                try {
                    if (zY == null || !zY.isAlive()) {
                        HandlerThread handlerThread = new HandlerThread("csj_init_handle", -1);
                        zY = handlerThread;
                        handlerThread.start();
                        We = new Handler(zY.getLooper());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else if (We == null) {
            synchronized (SR.class) {
                try {
                    if (We == null) {
                        We = new Handler(zY.getLooper());
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return We;
    }

    public static void pFF() {
        sc().sc(true);
    }

    public static void pFF(We we2) {
        sc().sc(new ExN(we2, 0, 1, 0));
    }

    public static sc sc() {
        if (f28611sc == null) {
            synchronized (zY.class) {
                try {
                    if (f28611sc == null) {
                        f28611sc = sc.sc(new pFF() { // from class: com.bytedance.sdk.openadsdk.dE.zY.1
                            @Override // com.bytedance.sdk.openadsdk.dE.pFF
                            public Context getContext() {
                                return Xc.sc();
                            }

                            @Override // com.bytedance.sdk.openadsdk.dE.pFF
                            public Handler getHandler() {
                                return zY.ExN();
                            }

                            @Override // com.bytedance.sdk.openadsdk.dE.pFF
                            public int getOnceLogCount() {
                                int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("bus_monitor_config", "once_count", 10);
                                if (iSc > 100 || iSc < 5) {
                                    return 10;
                                }
                                return iSc;
                            }

                            @Override // com.bytedance.sdk.openadsdk.dE.pFF
                            public int getOnceLogInterval() {
                                int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("bus_monitor_config", "once_interval", 10000);
                                if (iSc < 10000) {
                                    return 10000;
                                }
                                return iSc;
                            }

                            @Override // com.bytedance.sdk.openadsdk.dE.pFF
                            public int getUploadIntervalTime() {
                                int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("bus_monitor_config", "interval", 43200000);
                                if (iSc < 3600000) {
                                    return 86400000;
                                }
                                return iSc;
                            }

                            @Override // com.bytedance.sdk.openadsdk.dE.pFF
                            public boolean isMonitorOpen() {
                                if (zY.pFF != null) {
                                    return zY.pFF.booleanValue();
                                }
                                Boolean unused = zY.pFF = Boolean.valueOf(com.bytedance.sdk.openadsdk.YIK.sc.sc("bus_monitor_config", "enable", 0) == 1);
                                return zY.pFF.booleanValue();
                            }

                            @Override // com.bytedance.sdk.openadsdk.dE.pFF
                            public void onMonitorUpload(List<com.bytedance.sdk.openadsdk.dE.pFF.sc> list) {
                                if (list == null || list.isEmpty()) {
                                    return;
                                }
                                for (final com.bytedance.sdk.openadsdk.dE.pFF.sc scVar : list) {
                                    com.bytedance.sdk.openadsdk.SR.zY.sc();
                                    com.bytedance.sdk.openadsdk.SR.zY.sc("bus_monitor", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.dE.zY.1.1
                                        @Override // com.bytedance.sdk.openadsdk.SR.pFF
                                        public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                                            JSONObject jSONObject = new JSONObject();
                                            try {
                                                jSONObject.put("sdk_version", scVar.pFF());
                                                jSONObject.put("scene", scVar.zY());
                                                jSONObject.put("start_count", scVar.We());
                                                jSONObject.put("success_count", scVar.ExN());
                                                jSONObject.put("fail_count", scVar.TRI());
                                                jSONObject.put("rit", scVar.qr());
                                                jSONObject.put("tag", scVar.Qj());
                                                jSONObject.put("label", scVar.Ol());
                                                jSONObject.put("mediation", scVar.UFX());
                                                jSONObject.put("is_init", scVar.Tf());
                                                jSONObject.put("extra", scVar.Ql());
                                                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("bus_monitor").pFF(jSONObject.toString());
                                            } catch (Exception e11) {
                                                Tf.sc("BusMonitorUtils", "onMonitorUpload: ", e11);
                                                return null;
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28611sc;
    }

    public static void sc(We we2) {
        sc().sc(new ExN(we2, 1, 0, 0));
    }

    public static void zY(We we2) {
        sc().sc(new ExN(we2, 0, 0, 1));
    }
}
