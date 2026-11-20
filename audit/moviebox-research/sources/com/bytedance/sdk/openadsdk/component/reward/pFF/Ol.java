package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends pFF {
    private com.bytedance.sdk.openadsdk.component.reward.view.sc BT;

    public Ol(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
    }

    private boolean Gb() {
        return Sfl.ExN(this.pFF);
    }

    public static boolean sc(Sfl sfl) {
        return (sfl.xP() || sfl.AZJ() == 100.0f) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean ExN() {
        return Gb();
    }

    public FrameLayout HJN() {
        com.bytedance.sdk.openadsdk.component.reward.view.sc scVar = this.BT;
        if (scVar != null) {
            return scVar.getVideoContainer();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean TRI() {
        return Gb();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public pFF.sc We() {
        return new pFF.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.pFF.Ol.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF.sc
            public void sc(boolean z11) {
                if (Ol.this.BT != null) {
                    Ol.this.BT.setIsMute(z11);
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void qr() {
        this.TRI.zY(8);
        this.TRI.pFF(8);
        if (this.pFF.JPJ() == 2) {
            this.Qj.sc(false);
            this.Qj.zY(false);
            this.Qj.We(false);
            this.TRI.ExN(8);
            return;
        }
        this.Qj.sc(this.pFF.vYl());
        this.Qj.zY(Gb());
        this.Qj.We(Gb());
        if (Gb()) {
            this.TRI.ExN(8);
        } else {
            this.Qj.TRI();
            this.TRI.ExN(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.reward.view.sc scVar = new com.bytedance.sdk.openadsdk.component.reward.view.sc(this.f27845sc.CYO, this.UFX);
        this.BT = scVar;
        scVar.setDownloadListener(this.Tf);
        com.bytedance.sdk.openadsdk.component.reward.view.sc scVar2 = this.BT;
        Sfl sfl = this.pFF;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27845sc;
        scVar2.sc(sfl, scVar3.f27910ko, scVar3.OKY, this.zY, this.We);
        frameLayout.addView(this.BT.getInteractionStyleRootView());
    }
}
