package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class wjp extends Sfl implements c.a, c.d {
    private long Cb;
    boolean ExN;
    private com.bytedance.sdk.openadsdk.multipro.pFF.sc Gb;
    private BT HJN;
    private com.bytedance.sdk.openadsdk.sc.pFF.zY OXF;
    boolean TRI;
    int We;
    private long cD;
    boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    int f28099qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    int f28100sc;
    boolean zY;

    public wjp(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot, String str) {
        super(context, sfl, adSlot, str, false, true);
        this.f28100sc = 1;
        this.pFF = false;
        this.zY = true;
        this.ExN = true;
        this.TRI = true;
        this.f28099qr = -1;
        qr();
    }

    private void dE() {
        try {
            this.Gb = new com.bytedance.sdk.openadsdk.multipro.pFF.sc();
            BT bt2 = new BT(this.Qj, this.UFX, this.Ol, this.WP);
            this.HJN = bt2;
            bt2.setShouldCheckNetChange(false);
            this.HJN.setControllerStatusCallBack(new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.pFF() { // from class: com.bytedance.sdk.openadsdk.core.Qj.wjp.1
                @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.pFF
                public void sc(boolean z11, long j11, long j12, long j13, boolean z12) {
                    wjp.this.Gb.f28652sc = z11;
                    wjp.this.Gb.ExN = j11;
                    wjp.this.Gb.TRI = j12;
                    wjp.this.Gb.f28651qr = j13;
                    wjp.this.Gb.We = z12;
                }
            });
            this.HJN.setVideoAdLoadListener(this);
            this.HJN.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.Ol)) {
                this.HJN.setIsAutoPlay(this.pFF ? this.WH.isAutoPlay() : this.zY);
            } else if ("open_ad".equals(this.Ol)) {
                this.HJN.setIsAutoPlay(true);
            } else {
                this.HJN.setIsAutoPlay(this.zY);
            }
            if ("open_ad".equals(this.Ol)) {
                this.HJN.setIsQuiet(true);
            } else {
                boolean zZY = com.bytedance.sdk.openadsdk.core.Xc.We().zY(String.valueOf(this.We));
                this.uEA = zZY;
                this.HJN.setIsQuiet(zZY);
            }
            this.HJN.We();
        } catch (Exception unused) {
            this.HJN = null;
        }
    }

    private void pFF(long j11, long j12) {
        int iAbs = (int) Math.abs(((long) this.wjp) - j11);
        int i11 = this.wjp;
        if (i11 < 0 || iAbs > 500 || i11 > j12 || iAbs >= 500 || this.YIK.contains(this.Sfl)) {
            return;
        }
        if (this.wjp > j11) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.wjp.3
                @Override // java.lang.Runnable
                public void run() {
                    wjp.this.HJN.setCanInterruptVideoPlay(true);
                    wjp.this.HJN.performClick();
                    wjp wjpVar = wjp.this;
                    wjpVar.pFF(wjpVar.wjp, wjpVar.Sfl);
                }
            }, iAbs);
        } else {
            this.HJN.setCanInterruptVideoPlay(true);
            this.HJN.performClick();
            pFF(this.wjp, this.Sfl);
        }
        this.YIK.add(this.Sfl);
    }

    private void pFF(final com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        if (sr2 == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.wjp.2
            @Override // java.lang.Runnable
            public void run() {
                wjp.this.zY(sr2);
            }
        });
    }

    private void setShowAdInteractionView(boolean z11) {
        BT bt2 = this.HJN;
        if (bt2 != null) {
            bt2.setShowAdInteractionView(z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(@NonNull com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        int i11;
        double dTRI = sr2.TRI();
        double dQr = sr2.qr();
        double dQj = sr2.Qj();
        double dOl = sr2.Ol();
        if ((dQj != 0.0d && dOl != 0.0d) || (i11 = this.f28099qr) == 7 || i11 == 10) {
            int iZY = kX.zY(this.Qj, (float) dTRI);
            int iZY2 = kX.zY(this.Qj, (float) dQr);
            int iZY3 = kX.zY(this.Qj, (float) dQj);
            int iZY4 = kX.zY(this.Qj, (float) dOl);
            float fMin = Math.min(Math.min(kX.zY(this.Qj, sr2.Tf()), kX.zY(this.Qj, sr2.Ql())), Math.min(kX.zY(this.Qj, sr2.SR()), kX.zY(this.Qj, sr2.BT())));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Tf.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iZY3, iZY4);
            }
            layoutParams.width = iZY3;
            layoutParams.height = iZY4;
            layoutParams.topMargin = iZY2;
            layoutParams.leftMargin = iZY;
            layoutParams.setMarginStart(iZY);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            this.Tf.setLayoutParams(layoutParams);
            this.Tf.removeAllViews();
            if (this.HJN != null) {
                int i12 = this.f28099qr;
                if ((i12 == 7 || i12 == 10) && (sr2 instanceof com.bytedance.sdk.openadsdk.core.UFX.We.pFF)) {
                    FrameLayout frameLayoutDE = ((com.bytedance.sdk.openadsdk.core.UFX.We.pFF) sr2).dE();
                    if (frameLayoutDE != null) {
                        frameLayoutDE.removeAllViews();
                        frameLayoutDE.addView(this.HJN, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else if (sr2.sc() == null) {
                    this.Tf.addView(this.HJN);
                } else if (this.TRI) {
                    sr2.sc().setTag(com.bytedance.sdk.component.adexpress.dynamic.sc.TRI, 1);
                    ((FrameLayout) sr2.sc()).removeAllViews();
                    ((FrameLayout) sr2.sc()).addView(this.HJN, new FrameLayout.LayoutParams(-1, -1));
                    this.TRI = false;
                }
                kX.pFF(this.Tf, fMin);
                this.HJN.sc(0L, true, false);
                We(this.We);
                if (!com.bytedance.sdk.component.utils.BT.We(this.Qj) && !this.zY && this.ExN) {
                    this.HJN.ExN();
                }
                if (TextUtils.equals("embeded_ad", this.Ol)) {
                    return;
                }
                setShowAdInteractionView(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void ExN() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public int We() {
        BT bt2;
        if (this.f28100sc == 3 && (bt2 = this.HJN) != null) {
            bt2.We();
        }
        BT bt3 = this.HJN;
        if (bt3 == null || !bt3.getNativeVideoController().dE()) {
            return this.f28100sc;
        }
        return 1;
    }

    public void We(int i11) {
        int iPFF = com.bytedance.sdk.openadsdk.core.Xc.We().pFF(i11);
        if (3 == iPFF) {
            this.pFF = false;
            this.zY = false;
        } else if (4 == iPFF) {
            this.pFF = true;
        } else {
            int iZY = com.bytedance.sdk.component.utils.BT.zY(com.bytedance.sdk.openadsdk.core.Xc.sc());
            if (1 == iPFF) {
                this.pFF = false;
                this.zY = cJ.We(iZY);
            } else if (2 == iPFF) {
                if (cJ.ExN(iZY) || cJ.We(iZY) || cJ.TRI(iZY)) {
                    this.pFF = false;
                    this.zY = true;
                }
            } else if (5 == iPFF && (cJ.We(iZY) || cJ.TRI(iZY))) {
                this.pFF = false;
                this.zY = true;
            }
        }
        if (this.zY) {
            return;
        }
        this.f28100sc = 3;
    }

    @Override // t8.c.d
    public void d_() {
        this.ExN = false;
        this.f28100sc = 2;
        com.bytedance.sdk.openadsdk.sc.pFF.zY zYVar = this.OXF;
        if (zYVar != null) {
            zYVar.sc(null);
        }
    }

    @Override // t8.c.d
    public void g_() {
        this.ExN = false;
        this.Ql = true;
        this.f28100sc = 3;
        com.bytedance.sdk.openadsdk.sc.pFF.zY zYVar = this.OXF;
        if (zYVar != null) {
            zYVar.pFF(null);
        }
    }

    public BT getExpressVideoView() {
        return this.HJN;
    }

    public com.bytedance.sdk.openadsdk.sc.pFF.zY getVideoAdListener() {
        return this.OXF;
    }

    @Nullable
    public c getVideoController() {
        BT bt2 = this.HJN;
        if (bt2 != null) {
            return bt2.getNativeVideoController();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.multipro.pFF.sc getVideoModel() {
        return this.Gb;
    }

    @Override // t8.c.d
    public void h_() {
        this.ExN = false;
        this.Ql = false;
        this.f28100sc = 2;
    }

    @Override // t8.c.d
    public void i_() {
        this.ExN = false;
        this.f28100sc = 5;
        com.bytedance.sdk.component.adexpress.pFF.pFF pff = this.II;
        if (pff != null && pff.pFF() != null) {
            this.II.pFF().onvideoComplate();
        }
        com.bytedance.sdk.openadsdk.sc.pFF.zY zYVar = this.OXF;
        if (zYVar != null) {
            zYVar.zY(null);
        }
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 instanceof com.bytedance.sdk.openadsdk.core.UFX.We.zY) {
            ((com.bytedance.sdk.openadsdk.core.UFX.We.zY) we2).onvideoComplate();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void pFF() {
    }

    public void qr() {
        this.Tf = new FrameLayout(this.Qj);
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
        int iQT = sfl != null ? sfl.QT() : 0;
        this.We = iQT;
        We(iQT);
        dE();
        addView(this.Tf, new FrameLayout.LayoutParams(-1, -1));
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(int i11) {
        BT bt2 = this.HJN;
        if (bt2 == null) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i11 == 1) {
            bt2.sc(0L, true, false);
            return;
        }
        if (i11 == 2 || i11 == 3) {
            bt2.setCanInterruptVideoPlay(true);
            this.HJN.performClick();
        } else if (i11 == 4) {
            bt2.getNativeVideoController().We();
        } else {
            if (i11 != 5) {
                return;
            }
            bt2.sc(0L, true, false);
        }
    }

    @Override // t8.c.a
    public void sc(int i11, int i12) {
        this.cD = this.Cb;
        this.f28100sc = 4;
        com.bytedance.sdk.openadsdk.sc.pFF.zY zYVar = this.OXF;
        if (zYVar != null) {
            zYVar.sc(i11, i12);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(int i11, String str) {
        this.wjp = i11;
        this.Sfl = str;
    }

    @Override // t8.c.d
    public void sc(long j11, long j12) {
        this.ExN = false;
        int i11 = this.f28100sc;
        if (i11 != 5 && i11 != 3 && j11 > this.cD) {
            this.f28100sc = 2;
        }
        this.cD = j11;
        this.Cb = j12;
        com.bytedance.sdk.component.adexpress.pFF.pFF pff = this.II;
        if (pff != null && pff.pFF() != null) {
            this.II.pFF().setTimeUpdate(((int) (j12 - j11)) / 1000);
        }
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 instanceof com.bytedance.sdk.openadsdk.core.UFX.We.zY) {
            ((com.bytedance.sdk.openadsdk.core.UFX.We.zY) we2).setTimeUpdate(((int) (j12 - j11)) / 1000);
        }
        pFF(j11, j12);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.component.adexpress.pFF.Qj
    public void sc(View view, int i11, com.bytedance.sdk.component.adexpress.zY zYVar) {
        if (i11 == -1 || zYVar == null) {
            return;
        }
        if (i11 != 11) {
            super.sc(view, i11, zYVar);
            return;
        }
        try {
            BT bt2 = this.HJN;
            if (bt2 != null) {
                bt2.setCanInterruptVideoPlay(true);
                this.HJN.performClick();
                if (this.Ql) {
                    this.HJN.findViewById(com.bytedance.sdk.openadsdk.utils.SR.WgX).setVisibility(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.component.adexpress.pFF.BT
    public void sc(com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        this.McK = we2;
        this.f28099qr = we2.zY();
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we3 = this.McK;
        if ((we3 instanceof JPJ) && ((JPJ) we3).dE() != null) {
            ((JPJ) this.McK).dE().sc((SR) this);
        }
        if (sr2 != null && sr2.zY()) {
            pFF(sr2);
        }
        super.sc(we2, sr2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public void sc(boolean z11) {
        BT bt2 = this.HJN;
        if (bt2 != null) {
            bt2.setIsQuiet(z11);
            setSoundMute(z11);
        }
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.sc.pFF.zY zYVar) {
        this.OXF = zYVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.Sfl, com.bytedance.sdk.openadsdk.core.Qj.SR
    public long zY() {
        return this.cD;
    }
}
