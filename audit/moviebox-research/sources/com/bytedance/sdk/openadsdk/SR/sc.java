package com.bytedance.sdk.openadsdk.SR;

import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.openadsdk.SR.sc.ExN;
import com.bytedance.sdk.openadsdk.We.sc.TRI;
import com.bytedance.sdk.openadsdk.core.uEA;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public static void sc() {
        if (Cb.ExN()) {
            Cb.sc(new Qj("DailyTaskHelper") { // from class: com.bytedance.sdk.openadsdk.SR.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    sc.zY();
                }
            });
        } else {
            zY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY() {
        com.bytedance.sdk.openadsdk.We.sc.sc.pFF();
        ExN.zY();
        TRI.sc();
        uEA.sc();
    }
}
