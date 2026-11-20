package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends com.bytedance.sdk.component.adexpress.dynamic.sc.sc {
    private final Runnable We;
    private com.bytedance.sdk.component.adexpress.pFF.qr pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.adexpress.pFF.Ql f28073sc;
    private final com.bytedance.sdk.component.Qj.Qj zY;

    public TRI(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z11, com.bytedance.sdk.component.adexpress.dynamic.ExN.Qj qj2, com.bytedance.sdk.component.adexpress.pFF.Ql ql2, com.bytedance.sdk.component.adexpress.dynamic.TRI.sc scVar) {
        super(context, themeStatusBroadcastReceiver, z11, qj2, ql2, scVar);
        this.zY = new com.bytedance.sdk.component.Qj.Qj("dynamic_render_template") { // from class: com.bytedance.sdk.openadsdk.core.Qj.TRI.1
            @Override // java.lang.Runnable
            public void run() {
                TRI.this.f28073sc.zY();
                com.bytedance.sdk.openadsdk.core.SR.zY().post(TRI.this.We);
            }
        };
        this.We = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.TRI.2
            @Override // java.lang.Runnable
            public void run() {
                if (TRI.this.pFF != null) {
                    TRI tri = TRI.this;
                    TRI.super.sc(tri.pFF);
                }
            }
        };
        this.f28073sc = ql2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sc.sc
    public void pFF() {
        super.pFF();
        com.bytedance.sdk.openadsdk.core.SR.zY().removeCallbacks(this.We);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sc.sc, com.bytedance.sdk.component.adexpress.pFF.We
    public void sc(com.bytedance.sdk.component.adexpress.pFF.qr qrVar) {
        this.pFF = qrVar;
        Cb.pFF(this.zY);
    }
}
