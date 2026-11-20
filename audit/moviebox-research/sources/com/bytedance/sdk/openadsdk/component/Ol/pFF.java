package com.bytedance.sdk.openadsdk.component.Ol;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.bytedance.sdk.component.adexpress.pFF.SR;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.Qj.JPJ;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.kX;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends Sfl {
    private com.bytedance.sdk.openadsdk.component.Qj.zY ExN;
    private c.InterfaceC0849c HJN;
    private com.bytedance.sdk.openadsdk.component.TRI.sc TRI;
    private final com.bytedance.sdk.openadsdk.component.Qj.sc We;
    private final com.bytedance.sdk.openadsdk.component.sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private FrameLayout f27742qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    boolean f27743sc;
    private final com.bytedance.sdk.openadsdk.component.TRI.pFF zY;

    public pFF(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot, String str, com.bytedance.sdk.openadsdk.component.sc scVar, com.bytedance.sdk.openadsdk.component.TRI.pFF pff, com.bytedance.sdk.openadsdk.component.Qj.sc scVar2) {
        super(context, sfl, adSlot, str, true, true);
        this.f27743sc = true;
        this.pFF = scVar;
        this.zY = pff;
        this.We = scVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(SR sr2) {
        if (sr2 == null) {
            return;
        }
        if (sr2.sc() != null) {
            if (this.f27743sc) {
                sr2.sc().setTag(com.bytedance.sdk.component.adexpress.dynamic.sc.TRI, 1);
                ((FrameLayout) sr2.sc()).removeAllViews();
                FrameLayout frameLayout = (FrameLayout) sr2.sc();
                this.f27742qr = frameLayout;
                ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).gravity = 17;
                this.f27743sc = false;
                return;
            }
            return;
        }
        double dTRI = sr2.TRI();
        double dQr = sr2.qr();
        double dQj = sr2.Qj();
        double dOl = sr2.Ol();
        int iZY = kX.zY(this.Qj, (float) dTRI);
        int iZY2 = kX.zY(this.Qj, (float) dQr);
        int iZY3 = kX.zY(this.Qj, (float) dQj);
        int iZY4 = kX.zY(this.Qj, (float) dOl);
        if ((dOl != 0.0d && dQj != 0.0d) || this.McK.zY() == 7 || this.McK.zY() == 10) {
            if ((this.McK.zY() == 7 || this.McK.zY() == 10) && (sr2 instanceof com.bytedance.sdk.openadsdk.core.UFX.We.pFF)) {
                FrameLayout frameLayoutDE = ((com.bytedance.sdk.openadsdk.core.UFX.We.pFF) sr2).dE();
                if (frameLayoutDE != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    frameLayoutDE.addView(this.f27742qr, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f27742qr.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(iZY3, iZY4);
            }
            layoutParams2.width = iZY3;
            layoutParams2.height = iZY4;
            layoutParams2.topMargin = iZY2;
            layoutParams2.leftMargin = iZY;
            layoutParams2.setMarginStart(iZY);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.f27742qr.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void ExN() {
        com.bytedance.sdk.openadsdk.component.TRI.sc scVar = this.TRI;
        if (scVar != null) {
            scVar.pFF(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public void TRI() {
        this.SR = true;
        this.f27742qr = new FrameLayout(this.Qj);
        if (!com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.UFX) && !com.bytedance.sdk.openadsdk.core.UFX.zY.pFF(this.UFX)) {
            addView(this.f27742qr, new FrameLayout.LayoutParams(-1, -1));
        }
        super.TRI();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public int We() {
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar = this.ExN;
        if (zYVar != null && zYVar.TRI()) {
            return 1;
        }
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar2 = this.ExN;
        if (zYVar2 != null && zYVar2.ExN()) {
            return 3;
        }
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar3 = this.ExN;
        if (zYVar3 != null && zYVar3.We()) {
            return 2;
        }
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar4 = this.ExN;
        if (zYVar4 != null && zYVar4.pFF()) {
            return 4;
        }
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar5 = this.ExN;
        return (zYVar5 == null || !zYVar5.zY()) ? 3 : 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public int getDynamicShowType() {
        if (this.McK == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.component.qr.sc.sc(this.UFX, Xc.We().qr(String.valueOf(this.UFX.QT())));
    }

    public FrameLayout getVideoFrameLayout() {
        return this.f27742qr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void pFF() {
        super.pFF();
    }

    public void pFF(final SR sr2) {
        if (sr2 == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.Ol.pFF.1
            @Override // java.lang.Runnable
            public void run() {
                pFF.this.zY(sr2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc() {
        com.bytedance.sdk.openadsdk.component.TRI.sc scVar = this.TRI;
        if (scVar != null) {
            scVar.sc(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(int i11) {
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar = this.ExN;
        if (zYVar == null) {
            return;
        }
        if (i11 != 1) {
            if (i11 == 2) {
                zYVar.qr();
                this.zY.We();
                return;
            } else if (i11 == 3) {
                zYVar.Qj();
                this.zY.zY();
                return;
            } else if (i11 == 4) {
                zYVar.Ol();
                return;
            } else if (i11 != 5) {
                return;
            }
        }
        if (zYVar.We() || this.ExN.ExN()) {
            return;
        }
        this.ExN.sc(getVideoFrameLayout(), this.pFF, this.UFX);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(int i11, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.component.adexpress.pFF.Qj
    public void sc(View view, int i11, com.bytedance.sdk.component.adexpress.zY zYVar) {
        if (i11 == -1 || zYVar == null || i11 != 3) {
            super.sc(view, i11, zYVar);
        } else {
            ExN();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public void sc(Ql.sc scVar) {
        scVar.ExN(com.bytedance.sdk.openadsdk.component.qr.sc.pFF());
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.component.adexpress.pFF.BT
    public void sc(com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2, SR sr2) {
        this.McK = we2;
        if (we2 instanceof JPJ) {
            JPJ jpj = (JPJ) we2;
            if (jpj.dE() != null) {
                jpj.dE().sc((com.bytedance.sdk.openadsdk.core.Qj.SR) this);
            }
        }
        if (sr2 != null && sr2.zY()) {
            pFF(sr2);
        }
        super.sc(we2, sr2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public void sc(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
        boolean z11 = sfl != null && sfl.cvk() == 0;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.UFX;
        com.bytedance.sdk.openadsdk.component.qr.sc.sc(jSONObject, sfl2 != null ? sfl2.QT() : 0, z11);
    }

    public void setExpressVideoListenerProxy(c.InterfaceC0849c interfaceC0849c) {
        this.HJN = interfaceC0849c;
    }

    public void setTopListener(com.bytedance.sdk.openadsdk.component.TRI.sc scVar) {
        this.TRI = scVar;
    }

    public void setVideoManager(com.bytedance.sdk.openadsdk.component.Qj.zY zYVar) {
        this.ExN = zYVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public long zY() {
        return this.We.pFF();
    }
}
