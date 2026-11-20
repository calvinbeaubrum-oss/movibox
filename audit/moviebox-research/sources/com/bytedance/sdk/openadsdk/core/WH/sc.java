package com.bytedance.sdk.openadsdk.core.WH;

import android.content.Context;
import com.bytedance.sdk.component.qr.zY.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.Xc.pFF;
import com.bytedance.sdk.openadsdk.Xc.zY;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.TRI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static boolean f28317sc = false;
    private static final int pFF = Integer.parseInt("1371");
    private static long zY = System.currentTimeMillis();

    public static void pFF() {
        if (f28317sc) {
            TRI triWe = Xc.We();
            if (triWe.Ol()) {
                long jDix = triWe.dix();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - zY >= jDix) {
                    zY = jCurrentTimeMillis;
                    Context contextSc = Xc.sc();
                    if (contextSc == null) {
                        return;
                    }
                    Qj.sc().sc(pFF, contextSc).zY();
                }
            }
        }
    }

    public static void sc() {
        Context contextSc;
        if (!Xc.We().Ol() || f28317sc || (contextSc = Xc.sc()) == null) {
            return;
        }
        try {
            zY.sc().pFF().sc(contextSc, true, new pFF(contextSc));
            zY.sc().pFF().sc(contextSc, com.bytedance.sdk.openadsdk.multipro.pFF.zY());
            zY = System.currentTimeMillis();
            f28317sc = true;
        } catch (Exception e11) {
            Tf.sc("TncHelper", "initTTAdNet: ", e11.getMessage());
        }
    }
}
