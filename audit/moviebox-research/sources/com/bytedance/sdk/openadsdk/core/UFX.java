package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final AtomicInteger f28249sc = new AtomicInteger(0);
    private static final AtomicBoolean pFF = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.utils.uEA.sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final AtomicBoolean f28252sc = new AtomicBoolean(false);
        private static volatile long pFF = -1;

        private sc() {
        }

        public static void sc() {
            if (f28252sc.compareAndSet(false, true)) {
                pFF = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.uEA.sc(new sc(), Xc.sc());
            }
        }

        public void pFF() {
            com.bytedance.sdk.component.utils.uEA.sc(this);
        }

        @Override // com.bytedance.sdk.component.utils.uEA.sc
        public void sc(Context context, Intent intent, boolean z11, int i11) {
            if (System.currentTimeMillis() - pFF >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS && i11 != 0) {
                UFX.zY();
                UFX.zY(Tf.sc(Xc.sc()));
                pFF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void We() {
        if (f28249sc.getAndIncrement() <= 0) {
            com.bytedance.sdk.openadsdk.utils.Cb.sc().schedule(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.UFX.2
                @Override // java.lang.Runnable
                public void run() {
                    UFX.zY(Tf.sc(Xc.sc()));
                }
            }, 10000L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean pFF(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    public static void sc(String str) {
        AtomicBoolean atomicBoolean = pFF;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (!com.bytedance.sdk.component.utils.BT.Qj(Xc.sc())) {
                atomicBoolean.set(false);
            } else {
                sc.sc();
                zY(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY() {
        f28249sc.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY(final String str) {
        com.bytedance.sdk.openadsdk.utils.Cb.zY(new com.bytedance.sdk.component.Qj.Qj("ipv6") { // from class: com.bytedance.sdk.openadsdk.core.UFX.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectSc;
                final String strEoh = com.bytedance.sdk.openadsdk.core.settings.dE.ef().eoh();
                com.bytedance.sdk.openadsdk.SR.zY.sc(0, strEoh);
                if (TextUtils.isEmpty(strEoh)) {
                    com.bytedance.sdk.openadsdk.SR.zY.sc(-1, strEoh, -1, "url is null");
                    return;
                }
                com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
                try {
                    wePFF.pFF(strEoh);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("connect_type", com.bytedance.sdk.component.utils.uEA.sc(Xc.sc(), 0L));
                    jSONObject.put("device_id", Long.parseLong(str));
                    jSONObject.put("header", com.bytedance.sdk.openadsdk.We.sc.zY.sc().pFF());
                    if (com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(PangleEncryptConstant.CryptDataScene.APP_LOG)) {
                        jSONObjectSc = PangleEncryptManager.encryptType4(jSONObject, new Dl(PangleEncryptConstant.CryptDataScene.DUAL_EVENT));
                        if (jSONObjectSc == null || jSONObjectSc.optInt("cypher") != 4) {
                            uEA.pFF(false);
                        } else {
                            uEA.pFF(true);
                            wePFF.pFF("x-pgli18n", "4");
                            wePFF.pFF(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                        }
                    } else {
                        jSONObjectSc = com.bytedance.sdk.component.utils.sc.sc(jSONObject);
                        if (UFX.pFF(jSONObjectSc)) {
                            wePFF.pFF(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                        }
                    }
                    if (UFX.pFF(jSONObjectSc)) {
                        jSONObject = jSONObjectSc;
                    }
                    wePFF.pFF(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                    wePFF.pFF("User-Agent", cJ.zY());
                    wePFF.sc(jSONObject);
                    wePFF.sc(6);
                    wePFF.sc("send_i_p_v6");
                    wePFF.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.UFX.1.1
                        @Override // com.bytedance.sdk.component.qr.sc.sc
                        public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                            if (pff.TRI()) {
                                com.bytedance.sdk.openadsdk.SR.zY.sc(1, strEoh);
                            } else {
                                com.bytedance.sdk.openadsdk.SR.zY.sc(-1, strEoh, pff.sc(), pff.pFF());
                                UFX.We();
                            }
                        }

                        @Override // com.bytedance.sdk.component.qr.sc.sc
                        public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                            if (iOException != null) {
                                com.bytedance.sdk.openadsdk.SR.zY.sc(-1, strEoh, 1, iOException.getMessage());
                            }
                            UFX.We();
                        }
                    });
                } catch (Exception e11) {
                    com.bytedance.sdk.openadsdk.SR.zY.sc(-1, strEoh, -2, e11.getMessage());
                    com.bytedance.sdk.component.utils.Tf.pFF("build ipv6 request failed:" + e11.getMessage());
                }
            }
        });
    }
}
