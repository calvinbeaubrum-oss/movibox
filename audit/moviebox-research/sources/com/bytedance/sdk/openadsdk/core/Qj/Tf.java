package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf {
    private static String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f28076sc;

    @NonNull
    public static String pFF() {
        String strZY;
        if (f28076sc == null) {
            f28076sc = com.bytedance.sdk.openadsdk.multipro.We.We.pFF("tt_sp", "js_render_ver", "");
        }
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarPFF = com.bytedance.sdk.component.adexpress.sc.pFF.Qj.pFF();
        if (scVarPFF != null && (strZY = scVarPFF.zY()) != null && !strZY.equals(f28076sc)) {
            f28076sc = strZY;
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_sp", "js_render_ver", strZY);
        }
        return f28076sc;
    }

    public static void sc() {
        com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().sc(new com.bytedance.sdk.component.adexpress.sc.sc.pFF() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.1
            @Override // com.bytedance.sdk.component.adexpress.sc.sc.pFF
            public int sc(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), str, contentValues, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.pFF
            public int sc(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.pFF
            public Cursor sc(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return new com.bytedance.sdk.openadsdk.multipro.aidl.zY(com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), str, strArr, str2, strArr2, str3, str4, str5));
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.pFF
            public void sc(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), str, contentValues);
            }
        });
        com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().sc(new com.bytedance.sdk.component.adexpress.sc.sc.zY() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.2
            /* JADX INFO: Access modifiers changed from: private */
            public void pFF(final MessageQueue messageQueue, final int i11) {
                if (messageQueue == null || i11 <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.2.4
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.sc.pFF(i11, false, messageQueue).pFF();
                        return false;
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void sc(final MessageQueue messageQueue, final int i11) {
                if (messageQueue == null || i11 <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.2.3
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.sc.pFF(i11, true, messageQueue).pFF();
                        return false;
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void sc(final MessageQueue messageQueue, final int i11, final int i12) {
                if (messageQueue != null) {
                    final int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("ad_load_and_render_opt", "w_p_delay", 500);
                    Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            pFF(messageQueue, i11);
                            sc(messageQueue, i12);
                        }
                    };
                    if (iSc > 0) {
                        com.bytedance.sdk.openadsdk.core.SR.zY().postDelayed(runnable, iSc);
                    } else {
                        runnable.run();
                    }
                }
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public int BT() {
                return kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc());
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public com.bytedance.sdk.component.adexpress.sc.zY.sc ExN() {
                return com.bytedance.sdk.openadsdk.core.Xc.zY().sc();
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public int Ol() {
                return 1;
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public String Qj() {
                return com.bytedance.sdk.openadsdk.core.Ol.pFF().We();
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public ExecutorService Ql() {
                if (Cb.UFX()) {
                    return Cb.We();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public ExecutorService SR() {
                if (Cb.UFX()) {
                    return Cb.Ol();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public com.bytedance.sdk.component.qr.pFF.sc TRI() {
                com.bytedance.sdk.component.qr.pFF.sc scVarWe = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().We();
                scVarWe.sc(8);
                scVarWe.sc("express_down");
                return scVarWe;
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public int Tf() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public int UFX() {
                return com.bytedance.sdk.openadsdk.core.Xc.We().ht();
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public int WH() {
                return com.bytedance.sdk.openadsdk.core.Xc.We().ko();
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public void We() {
                int iKo = com.bytedance.sdk.openadsdk.core.Xc.We().ko();
                int iHt = com.bytedance.sdk.openadsdk.core.Xc.We().ht();
                if (iKo == 0 && iHt == 0) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.ExN.ExN.sc().sc(iKo);
                com.bytedance.sdk.component.adexpress.ExN.ExN.sc().pFF(iHt);
                final int iTRI = com.bytedance.sdk.openadsdk.YIK.sc.TRI();
                final int iExN = com.bytedance.sdk.openadsdk.YIK.sc.ExN();
                if (iTRI == 0 && iExN == 0) {
                    return;
                }
                final MessageQueue[] messageQueueArr = new MessageQueue[1];
                if (Build.VERSION.SDK_INT >= 23) {
                    MessageQueue queue = com.bytedance.sdk.openadsdk.core.SR.zY().getLooper().getQueue();
                    messageQueueArr[0] = queue;
                    sc(queue, iExN, iTRI);
                } else {
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                messageQueueArr[0] = Looper.myQueue();
                                sc(messageQueueArr[0], iExN, iTRI);
                            }
                        });
                        return;
                    }
                    MessageQueue messageQueueMyQueue = Looper.myQueue();
                    messageQueueArr[0] = messageQueueMyQueue;
                    sc(messageQueueMyQueue, iExN, iTRI);
                }
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public boolean Xc() {
                return com.bytedance.sdk.openadsdk.YIK.sc.sc("destroy_render_script", false);
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public int dE() {
                return kX.We(com.bytedance.sdk.openadsdk.core.Xc.sc());
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public Context pFF() {
                return com.bytedance.sdk.openadsdk.core.Xc.sc();
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public com.bytedance.sdk.component.qr.pFF.pFF qr() {
                com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
                pffZY.sc(8);
                pffZY.sc("express_get");
                return pffZY;
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public int sc() {
                if (com.bytedance.sdk.openadsdk.core.Xc.We() == null) {
                    return 0;
                }
                return com.bytedance.sdk.openadsdk.core.Xc.We().We();
            }

            @Override // com.bytedance.sdk.component.adexpress.sc.sc.zY
            public Handler zY() {
                return com.bytedance.sdk.openadsdk.core.SR.zY();
            }
        });
        com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().sc(new com.bytedance.sdk.component.adexpress.sc.sc.We() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.3
            @Override // com.bytedance.sdk.component.adexpress.sc.sc.We
            public void sc(int i11) {
                com.bytedance.sdk.openadsdk.SR.zY.sc().sc(com.bytedance.sdk.openadsdk.SR.sc.We.pFF().pFF(i11).TRI(com.bytedance.sdk.openadsdk.core.Qj.sc(i11)));
            }
        });
        com.bytedance.sdk.component.Ol.sc.sc.sc().sc(new com.bytedance.sdk.component.Ol.sc.pFF() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Tf.4
            @Override // com.bytedance.sdk.component.Ol.sc.pFF
            public void sc(com.bytedance.sdk.component.Ol.pFF.sc scVar, String str, String str2, JSONObject jSONObject, long j11) {
                com.bytedance.sdk.openadsdk.core.model.Sfl sflZY = com.bytedance.sdk.openadsdk.core.model.Sfl.zY();
                sflZY.Xc(scVar.sc());
                sflZY.YIK(scVar.pFF());
                sflZY.wjp(scVar.zY());
                com.bytedance.sdk.openadsdk.We.zY.pFF(sflZY, str, str2, jSONObject, j11);
            }

            @Override // com.bytedance.sdk.component.Ol.sc.pFF
            public void sc(String str, String str2, JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.We.zY.zY(com.bytedance.sdk.openadsdk.utils.pFF.sc(), str, str2, jSONObject);
            }
        });
    }

    public static String zY() {
        Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc;
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVar;
        String strZY;
        if (pFF == null) {
            pFF = com.bytedance.sdk.openadsdk.multipro.We.We.pFF("tt_sp", "js_render_v3_ver", "");
        }
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarPFF = com.bytedance.sdk.component.adexpress.sc.pFF.Qj.pFF();
        if (scVarPFF != null && (mapSc = scVarPFF.sc()) != null && (scVar = mapSc.get("v3")) != null && (strZY = scVar.zY()) != null && !strZY.equals(pFF)) {
            pFF = strZY;
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_sp", "js_render_v3_ver", strZY);
        }
        return pFF;
    }
}
