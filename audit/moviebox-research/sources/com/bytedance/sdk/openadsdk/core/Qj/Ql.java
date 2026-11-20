package com.bytedance.sdk.openadsdk.core.Qj;

import com.bytedance.sdk.openadsdk.utils.Cb;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql implements com.bytedance.adsdk.ugeno.core.BT, com.bytedance.sdk.component.adexpress.pFF.Ol {
    private long ExN;
    private final String We;
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.We.We.ExN f28058sc;
    private final com.bytedance.sdk.openadsdk.core.model.Sfl zY;

    public Ql(com.bytedance.sdk.openadsdk.We.We.ExN exN, String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str2) {
        this.f28058sc = exN;
        this.pFF = str;
        this.We = str2;
        this.zY = sfl;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void ExN() {
        this.f28058sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void ExN(int i11) {
        if (i11 == 3) {
            this.f28058sc.We("dynamic_sub_render2_end");
        } else {
            this.f28058sc.We("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void Ol() {
        this.f28058sc.BT();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void Qj() {
        this.f28058sc.SR();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void TRI() {
        this.f28058sc.zY();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void TRI(int i11) {
        final String str;
        System.currentTimeMillis();
        if (i11 == 3) {
            this.f28058sc.qr("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.f28058sc.qr("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.f28058sc.sc(true);
        Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.Qj.Ql.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.We.zY.pFF(Ql.this.zY, Ql.this.pFF, str, (JSONObject) null);
            }
        }, 10);
    }

    public void UFX() {
        this.f28058sc.UFX();
        this.f28058sc.Tf();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void WH() {
        this.f28058sc.pFF();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void We() {
        this.f28058sc.sc();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void We(int i11) {
        if (i11 == 3) {
            this.f28058sc.We("dynamic_sub_render2_start");
        } else {
            this.f28058sc.We("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.BT
    public void pFF() {
        this.f28058sc.ExN("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void pFF(int i11) {
        if (i11 == 3) {
            this.f28058sc.We("dynamic_sub_analysis2_start");
        } else {
            this.f28058sc.We("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void qr() {
        this.f28058sc.sc(true);
        this.f28058sc.Ql();
        Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("native_success") { // from class: com.bytedance.sdk.openadsdk.core.Qj.Ql.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.We.zY.pFF(Ql.this.zY, Ql.this.pFF, "dynamic_backup_render", (JSONObject) null);
            }
        }, 10);
    }

    @Override // com.bytedance.adsdk.ugeno.core.BT
    public void sc() {
        this.f28058sc.ExN("ugen_render_start");
        this.f28058sc.ExN("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void sc(int i11) {
        this.ExN = System.currentTimeMillis();
        if (i11 == 3) {
            this.f28058sc.zY("dynamic_render2_start");
        } else {
            this.f28058sc.zY("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void sc(int i11, int i12, String str, boolean z11) {
        if (!z11) {
            this.f28058sc.sc(true);
        }
        if (i11 == 3) {
            this.f28058sc.pFF(i12, "dynamic_render2_error");
        } else {
            this.f28058sc.pFF(i12, "dynamic_render_error");
        }
        UFX.sc("NDR", i12, str, this.pFF, this.We, this.zY);
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void sc(int i11, String str) {
        this.f28058sc.sc(i11, str);
        UFX.sc("Web", i11, str, this.pFF, this.We, this.zY);
    }

    @Override // com.bytedance.adsdk.ugeno.core.BT
    public void sc(com.bytedance.adsdk.ugeno.core.SR sr2) {
        if (sr2.sc() == 0) {
            this.f28058sc.ExN("ugen_sub_render_end");
            this.f28058sc.TRI("ugen_render_success");
        } else {
            this.f28058sc.zY(sr2.sc(), "ugen_render_error");
            UFX.sc("UGen", sr2.sc(), sr2.pFF(), this.pFF, this.We, this.zY);
        }
        this.f28058sc.sc(true);
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void sc(boolean z11) {
        this.f28058sc.sc(z11 ? 1 : 0);
    }

    @Override // com.bytedance.adsdk.ugeno.core.BT
    public void zY() {
        this.f28058sc.ExN("ugen_sub_render_start");
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.Ol
    public void zY(int i11) {
        if (i11 == 3) {
            this.f28058sc.We("dynamic_sub_analysis2_end");
        } else {
            this.f28058sc.We("dynamic_sub_analysis_end");
        }
    }
}
