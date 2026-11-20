package com.bytedance.sdk.openadsdk.We.sc;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.Xc;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static AtomicInteger f27406sc = new AtomicInteger(0);
    public static final AtomicBoolean pFF = new AtomicBoolean(false);

    public static void pFF() {
        com.bytedance.sdk.component.TRI.sc.pFF.zY();
    }

    public static com.bytedance.sdk.openadsdk.SR.zY.pFF sc() {
        return Tf.f27390sc;
    }

    public static void sc(Context context, boolean z11) {
        if (pFF.compareAndSet(false, true)) {
            com.bytedance.sdk.component.TRI.sc.pFF.sc(new com.bytedance.sdk.component.TRI.sc.sc.C0249sc().sc(new WH()).pFF(com.bytedance.sdk.component.TRI.sc.We.pFF.sc.zY()).zY(com.bytedance.sdk.component.TRI.sc.We.pFF.sc.ExN()).sc(com.bytedance.sdk.component.TRI.sc.We.pFF.sc.We()).sc(z11).sc(new UFX()).sc(Qj.f27384sc).pFF(Xc.We().SR()).sc(Xc.We().BT()).sc(Xc.We().NP()).sc(), context);
            pFF();
        }
    }

    public static void sc(com.bytedance.sdk.openadsdk.We.sc scVar) {
        com.bytedance.sdk.component.TRI.sc.We.sc.sc scVar2 = new com.bytedance.sdk.component.TRI.sc.We.sc.sc(scVar.We(), scVar);
        scVar2.pFF(scVar.ExN() ? (byte) 1 : (byte) 2);
        scVar2.sc((byte) 0);
        if (com.bytedance.sdk.component.TRI.sc.pFF.pFF()) {
            sc(Xc.sc(), com.bytedance.sdk.openadsdk.multipro.pFF.zY());
        }
        com.bytedance.sdk.component.TRI.sc.pFF.sc(scVar2);
    }

    public static void sc(String str) {
        sc(str, false);
    }

    public static void sc(String str, boolean z11) {
        if (com.bytedance.sdk.component.TRI.sc.pFF.pFF()) {
            sc(Xc.sc(), com.bytedance.sdk.openadsdk.multipro.pFF.zY());
        }
        com.bytedance.sdk.component.TRI.sc.pFF.sc(str, z11);
    }

    public static void sc(final List<String> list, final int i11, final String str) {
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(new com.bytedance.sdk.component.Qj.Qj("track") { // from class: com.bytedance.sdk.openadsdk.We.sc.We.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.component.TRI.sc.pFF.pFF()) {
                    We.sc(Xc.sc(), com.bytedance.sdk.openadsdk.multipro.pFF.zY());
                }
                com.bytedance.sdk.component.TRI.sc.pFF.sc(com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc()), list, true, i11, str);
            }
        });
    }

    public static void zY() {
        try {
            com.bytedance.sdk.component.TRI.sc.pFF.We();
            com.bytedance.sdk.component.TRI.sc.pFF.ExN();
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("AdLogSwitchUtils", th2.getMessage());
        }
    }
}
