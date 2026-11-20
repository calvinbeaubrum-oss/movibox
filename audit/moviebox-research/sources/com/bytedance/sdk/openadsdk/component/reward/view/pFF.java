package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.Qj.JPJ;
import com.bytedance.sdk.openadsdk.core.Qj.SR;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Qj.dE;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.core.model.YIK;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.kX;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends Sfl {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static float f27964sc = 100.0f;
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc ExN;
    private float TRI;
    public int We;
    SR pFF;
    dE zY;

    public pFF(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar, AdSlot adSlot, String str) {
        super(scVar.CYO, scVar.pFF, adSlot, str, scVar.f27908eo, !scVar.otH);
        this.We = 1;
        this.TRI = -1.0f;
        this.ExN = scVar;
    }

    private void qr() {
        setBackupListener(new com.bytedance.sdk.component.adexpress.pFF.zY() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.pFF.1
            @Override // com.bytedance.sdk.component.adexpress.pFF.zY
            public boolean sc(ViewGroup viewGroup, int i11) {
                try {
                    ((Sfl) viewGroup).Tf();
                    pFF.this.zY = new dE(viewGroup.getContext());
                    pFF pff = pFF.this;
                    pff.zY.sc(((Sfl) pff).UFX, (Sfl) viewGroup, pFF.this.ExN.JoC);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        if (sr2 == null) {
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
                    frameLayoutDE.addView(this.Tf, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.Tf.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(iZY3, iZY4);
            }
            layoutParams2.width = iZY3;
            layoutParams2.height = iZY4;
            layoutParams2.topMargin = iZY2;
            layoutParams2.leftMargin = iZY;
            layoutParams2.setMarginStart(iZY);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.Tf.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void ExN() {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.ExN();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public void TRI() {
        this.SR = true;
        this.Tf = new FrameLayout(this.Qj);
        if (!com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.UFX) && !com.bytedance.sdk.openadsdk.core.UFX.zY.pFF(this.UFX)) {
            addView(this.Tf, new FrameLayout.LayoutParams(-1, -1));
        }
        super.TRI();
        com.bytedance.sdk.component.Ol.We webView = getWebView();
        if (webView != null) {
            webView.setBackgroundColor(0);
        }
        qr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public int We() {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            return sr2.We();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Xc xc2;
        WH wh2 = this.ExN.BR;
        if (wh2 != null && (xc2 = wh2.BT) != null && xc2.Ol()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.TRI = motionEvent.getY();
            } else if (action == 1) {
            }
            if (kX.sc(this.TRI, motionEvent.getY(), this.Qj)) {
                xc2.sc(5);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public View getBackupContainerBackgroundView() {
        if (Ql()) {
            return this.zY.getBackupContainerBackgroundView();
        }
        return null;
    }

    public FrameLayout getVideoFrameLayout() {
        return Ql() ? this.zY.getVideoContainer() : this.Tf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void pFF() {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.pFF();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void pFF(int i11) {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.pFF(i11);
        }
    }

    public void pFF(final com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        if (sr2 == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.pFF.2
            @Override // java.lang.Runnable
            public void run() {
                pFF.this.zY(sr2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc() {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.sc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(int i11) {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.sc(i11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(int i11, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        SR sr3 = this.pFF;
        if (sr3 != null) {
            sr3.sc(i11, sr2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(int i11, String str) {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.sc(i11, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.component.adexpress.pFF.Qj
    public void sc(View view, int i11, com.bytedance.sdk.component.adexpress.zY zYVar) {
        if (i11 == -1 || zYVar == null || i11 != 3) {
            super.sc(view, i11, zYVar);
        } else {
            ExN();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.component.adexpress.pFF.BT
    public void sc(com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        this.McK = we2;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
        if (sfl != null && sfl.ixT()) {
            super.sc(we2, sr2);
            return;
        }
        if (we2 instanceof JPJ) {
            JPJ jpj = (JPJ) we2;
            if (jpj.dE() != null) {
                jpj.dE().sc((SR) this);
            }
        }
        if (sr2 != null && sr2.zY()) {
            pFF(sr2);
            this.We = we2.zY();
        }
        super.sc(we2, sr2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(String str, JSONObject jSONObject) {
        super.sc(str, jSONObject);
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.sc(str, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(boolean z11) {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            sr2.sc(z11);
        }
        setSoundMute(z11);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public boolean sc(com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
        if ((sfl instanceof YIK) && ((YIK) sfl).Kv() && sr2.zY() && sr2.pFF() == 1) {
            return false;
        }
        return super.sc(sr2);
    }

    public void setExpressVideoListenerProxy(SR sr2) {
        this.pFF = sr2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public long zY() {
        SR sr2 = this.pFF;
        if (sr2 != null) {
            return sr2.zY();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl
    public com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc zY(int i11) {
        com.bytedance.sdk.openadsdk.activity.TRI tri;
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc scVarZY = super.zY(i11);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.ExN;
        if (scVar.otH && (tri = scVar.dix) != null) {
            scVarZY.pFF = tri.Ol;
        }
        return scVarZY;
    }
}
