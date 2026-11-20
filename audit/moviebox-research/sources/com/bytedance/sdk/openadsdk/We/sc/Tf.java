package com.bytedance.sdk.openadsdk.We.sc;

import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.JPJ;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class Tf implements com.bytedance.sdk.openadsdk.SR.zY.pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Tf f27390sc = new Tf();

    private Tf() {
    }

    private void sc(com.bytedance.sdk.component.Qj.Qj qj2) {
        if (qj2 == null) {
            return;
        }
        if (Cb.TRI()) {
            qj2.run();
        } else {
            Cb.pFF(qj2, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.SR.zY.pFF
    public void sc(com.bytedance.sdk.openadsdk.SR.pFF pff) {
        sc(pff, false);
    }

    @Override // com.bytedance.sdk.openadsdk.SR.zY.pFF
    public void sc(final com.bytedance.sdk.openadsdk.SR.pFF pff, final boolean z11) {
        sc(new com.bytedance.sdk.component.Qj.Qj("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.We.sc.Tf.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.SR.sc.zY logStats = pff.getLogStats();
                    if (logStats == null) {
                        return;
                    }
                    com.bytedance.sdk.component.TRI.sc.We.sc.sc scVar = new com.bytedance.sdk.component.TRI.sc.We.sc.sc(JPJ.sc(), logStats.sc());
                    scVar.zY((byte) 0);
                    scVar.pFF(z11 ? (byte) 2 : (byte) 3);
                    scVar.sc((byte) 1);
                    if (com.bytedance.sdk.component.TRI.sc.pFF.pFF()) {
                        We.sc(Xc.sc(), com.bytedance.sdk.openadsdk.multipro.pFF.zY());
                    }
                    com.bytedance.sdk.component.TRI.sc.pFF.sc(scVar);
                } catch (Throwable unused) {
                }
            }
        });
    }
}
