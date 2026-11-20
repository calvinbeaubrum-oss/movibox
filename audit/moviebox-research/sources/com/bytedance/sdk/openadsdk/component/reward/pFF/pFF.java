package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.Ql;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.UFX;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.Tf;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;
import com.google.logging.type.LogSeverity;
import java.util.List;
import java.util.Objects;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pFF extends com.bytedance.sdk.openadsdk.component.reward.pFF.sc {
    private com.bytedance.sdk.openadsdk.Tf.ExN BT;
    public com.bytedance.sdk.openadsdk.core.widget.pFF Ql;
    public LinearLayout SR;
    protected com.bytedance.sdk.openadsdk.core.pFF.ExN Tf;
    protected String UFX;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(boolean z11);
    }

    public pFF(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
    }

    public static FrameLayout sc(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar.setId(SR.UFX);
        zYVar.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        zYVar.setLayoutParams(layoutParams);
        return zYVar;
    }

    private void sc(long j11, long j12) {
        long j13 = j12 - j11;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        Activity activity = scVar.CYO;
        if (activity instanceof TTRewardVideoActivity) {
            ((TTRewardVideoActivity) activity).sc(j13, j12);
            return;
        }
        com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff = scVar.qKn;
        if (pff instanceof com.bytedance.sdk.openadsdk.activity.ExN) {
            ((com.bytedance.sdk.openadsdk.activity.ExN) pff).sc(j13, j12);
        }
    }

    public static void sc(FrameLayout frameLayout, final com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        final com.bytedance.sdk.openadsdk.core.ExN.We we2;
        Context context = frameLayout.getContext();
        if (scVar.DNB) {
            com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
            zYVar.setId(SR.WH);
            frameLayout.addView(zYVar, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayoutSc = sc(context);
            String strSc = "";
            if (Sfl.ExN(scVar.pFF)) {
                a aVarGI = scVar.pFF.GI();
                if (aVarGI != null) {
                    strSc = aVarGI.r();
                }
            } else {
                List<BT> listHt = scVar.pFF.ht();
                if (listHt != null && !listHt.isEmpty()) {
                    strSc = listHt.get(0).sc();
                }
            }
            if (TextUtils.isEmpty(strSc)) {
                we2 = null;
            } else {
                we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
                int i11 = SR.NT;
                we2.setId(i11);
                we2.setTag(i11, strSc);
                we2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                frameLayoutSc.addView(we2);
            }
            zYVar.addView(frameLayoutSc);
            View zYVar2 = new com.bytedance.sdk.openadsdk.component.reward.view.zY(context);
            zYVar2.setId(SR.Tf);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            frameLayout.addView(zYVar2, layoutParams);
            zYVar2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pFF.pFF.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                    int height = view.getHeight();
                    if (height <= 0) {
                        return;
                    }
                    View viewFindViewById = scVar.JoC.findViewById(520093757);
                    if (viewFindViewById != null) {
                        ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).bottomMargin = height;
                        }
                    }
                    View viewFindViewById2 = scVar.JoC.findViewById(SR.ofL);
                    if (viewFindViewById2 != null) {
                        ViewGroup.LayoutParams layoutParams3 = viewFindViewById2.getLayoutParams();
                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = height;
                        }
                    }
                    View viewFindViewById3 = scVar.JoC.findViewById(SR.JK);
                    if (viewFindViewById3 != null) {
                        ViewGroup.LayoutParams layoutParams4 = viewFindViewById3.getLayoutParams();
                        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams4).bottomMargin = height;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.ExN.We we3 = we2;
                    if (we3 != null) {
                        ViewGroup.LayoutParams layoutParams5 = we3.getLayoutParams();
                        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = height;
                            we2.setLayoutParams(layoutParams5);
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
            exN.setId(SR.Ql);
            exN.setOrientation(1);
            exN.setVisibility(8);
            frameLayout.addView(exN, new FrameLayout.LayoutParams(-1, -1));
        }
        if (scVar.MxZ) {
            View we3 = new com.bytedance.sdk.component.Ol.We(context, true);
            we3.setId(SR.SR);
            we3.setLayerType(2, null);
            we3.setVisibility(4);
            frameLayout.addView(we3, new FrameLayout.LayoutParams(-1, -1));
            View frameLayout2 = new FrameLayout(context);
            frameLayout2.setId(SR.BT);
            frameLayout2.setVisibility(4);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            if (JPJ.pFF(scVar.pFF)) {
                View zYVar3 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
                zYVar3.setId(SR.Ay);
                zYVar3.setVisibility(4);
                frameLayout.addView(zYVar3, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        View we4 = new com.bytedance.sdk.component.Ol.We(context, true);
        we4.setId(SR.dE);
        we4.setVisibility(8);
        frameLayout.addView(we4, new FrameLayout.LayoutParams(-1, -1));
    }

    public void BT() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        if (scVar.f27912qr) {
            return;
        }
        scVar.cJ.TRI();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
        if (scVar2.otH && (scVar2.dix instanceof com.bytedance.sdk.openadsdk.activity.sc)) {
            return;
        }
        scVar2.BR.ExN(0);
    }

    public void Dl() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        if (scVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.WH wh2 = scVar.BR;
        if (wh2 != null) {
            wh2.dE();
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
        boolean z11 = scVar2.f27908eo;
        scVar2.cD.sc();
        DeviceUtils.qr();
        this.f27845sc.Cb.YIK();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27845sc;
        if (scVar3.f27908eo) {
            scVar3.CYO.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pFF.pFF.2
                @Override // java.lang.Runnable
                public void run() {
                    if (pFF.this.f27845sc.cD.sc() > 0) {
                        pFF.this.f27845sc.cD.sc(false);
                    }
                }
            });
        }
    }

    public abstract boolean ExN();

    public void FI() {
        this.f27845sc.cJ.zY();
        this.f27845sc.cJ.ExN(true);
    }

    public final void II() {
        if (this.f27845sc.CYO.isFinishing()) {
            return;
        }
        this.f27845sc.Cb.BT();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        String str = scVar.We ? "reward_endcard" : "fullscreen_endcard";
        scVar.Cb.sc(this.BT, str, scVar.qKn);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
        scVar2.WP.sc(this.BT, scVar2.f27908eo);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27845sc;
        scVar3.Cb.sc(str, scVar3.qKn);
        this.f27845sc.Cb.ExN();
    }

    public void JPJ() {
        int iSc;
        com.bytedance.sdk.openadsdk.component.reward.sc.Qj qj2;
        com.bytedance.sdk.openadsdk.component.reward.sc.SR sr2;
        if (Xc.We().Dl(String.valueOf(this.f27845sc.TRI)) == 1) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            if (scVar.We) {
                iSc = JPJ.zY(scVar.pFF) ? Xc.We().sc(String.valueOf(this.f27845sc.TRI), true) : Xc.We().WH(String.valueOf(this.f27845sc.TRI));
            } else {
                iSc = JPJ.zY(scVar.pFF) ? Xc.We().sc(String.valueOf(this.f27845sc.TRI), false) : Xc.We().Sfl(String.valueOf(this.f27845sc.TRI));
            }
            com.bytedance.sdk.openadsdk.component.reward.view.WH wh2 = this.f27845sc.BR;
            if (wh2 != null && wh2.Ol()) {
                com.bytedance.sdk.openadsdk.component.reward.view.WH wh3 = this.f27845sc.BR;
                if (wh3 != null) {
                    wh3.WH().performClick();
                    return;
                }
                return;
            }
            if ((!this.f27845sc.WH.get() || JPJ.zY(this.f27845sc.pFF)) && iSc != -1) {
                com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc2 = this.f27845sc.JPJ;
                if (((xc2 == null || xc2.Qj() < ((long) iSc) * 1000) && ((qj2 = this.f27845sc.WP) == null || !qj2.We(iSc))) || (sr2 = this.f27845sc.cJ) == null) {
                    return;
                }
                sr2.We();
            }
        }
    }

    public boolean McK() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x00fd  */
    public View Ol() {
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(this.f27845sc.CYO);
        zYVar.setId(SR.Cwg);
        View viewPFF = com.bytedance.sdk.openadsdk.core.widget.qr.pFF(this.f27845sc.CYO);
        viewPFF.setId(520093708);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams.topMargin = kX.zY(this.f27845sc.CYO, 20.0f);
        layoutParams.rightMargin = kX.zY(this.f27845sc.CYO, 16.0f);
        viewPFF.setLayoutParams(layoutParams);
        viewPFF.setContentDescription(com.bytedance.sdk.component.utils.Sfl.sc(this.f27845sc.CYO, "tt_ad_close_text"));
        viewPFF.setVisibility(8);
        View pAGLogoView = new PAGLogoView(this.f27845sc.CYO);
        pAGLogoView.setId(520093757);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, kX.zY(this.f27845sc.CYO, 14.0f));
        layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        pAGLogoView.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(this.f27845sc.CYO);
        we2.setId(SR.ofL);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(kX.zY(this.f27845sc.CYO, 32.0f), kX.zY(this.f27845sc.CYO, 14.0f));
        layoutParams3.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
        we2.setLayoutParams(layoutParams3);
        we2.setPadding(kX.zY(this.f27845sc.CYO, 9.0f), 0, kX.zY(this.f27845sc.CYO, 9.0f), 0);
        we2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        View ufx = new UFX(this.f27845sc.CYO);
        ufx.setId(SR.ixT);
        ufx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ufx.setClickable(true);
        ufx.setFocusable(true);
        zYVar.addView(pAGLogoView);
        zYVar.addView(we2);
        zYVar.addView(ufx);
        if (this.f27845sc.pFF.hP()) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            if (!scVar.otH || scVar.f27913sc != 1) {
                View zYVar2 = new com.bytedance.sdk.openadsdk.component.reward.top.zY(this.f27845sc.CYO);
                zYVar2.setId(SR.Vb);
                zYVar2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                zYVar.addView(zYVar2);
            }
        } else {
            View zYVar3 = new com.bytedance.sdk.openadsdk.component.reward.top.zY(this.f27845sc.CYO);
            zYVar3.setId(SR.Vb);
            zYVar3.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            zYVar.addView(zYVar3);
        }
        zYVar.addView(viewPFF);
        return zYVar;
    }

    public RFEndCardBackUpLayout Qj() {
        return new RFEndCardBackUpLayout(this.f27845sc.f27911pc);
    }

    public void Ql() {
    }

    public void SR() {
        com.bytedance.sdk.openadsdk.core.widget.pFF pff = this.Ql;
        if (pff == null || !pff.isShowing()) {
            return;
        }
        this.Ql.dismiss();
    }

    public void Sfl() {
    }

    public abstract boolean TRI();

    public void Tf() {
        LinearLayout linearLayout = (LinearLayout) this.f27845sc.JoC.findViewById(SR.Ql);
        this.SR = linearLayout;
        kX.sc((View) linearLayout, 8);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        scVar.bSP = new Ql(scVar.CYO, scVar.pFF, "landingpage_endcard");
        this.f27845sc.bSP.zY().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pFF.pFF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pFF.this.f27845sc.BR.WH().performClick();
            }
        });
        this.SR.addView(this.f27845sc.bSP.ExN(), new LinearLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
        scVar2.Cb.sc(scVar2.bSP);
    }

    public void UFX() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        scVar.II.sc(scVar.We);
        this.f27845sc.BR.pFF();
        this.f27845sc.kX.sc();
        if (!this.f27845sc.pFF.ymG()) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
            if (scVar2.f27912qr && TextUtils.isEmpty(Sfl.sc(scVar2.f27911pc, this.pFF))) {
                Tf();
            }
            this.f27845sc.Cb.sc();
            this.f27845sc.OXF.sc();
        }
        this.f27845sc.WP.BT();
        this.f27845sc.cJ.sc();
        if (JPJ.qr(this.f27845sc.pFF)) {
            com.bytedance.sdk.component.Ol.We weWH = this.f27845sc.Cb.WH();
            if (weWH != null) {
                weWH.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f27845sc.Cb.UFX().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.f27845sc.cJ.zY(true);
            if (JPJ.wjp(this.f27845sc.pFF)) {
                this.f27845sc.BR.We();
                kX.sc((View) weWH, 4);
                kX.sc((View) this.f27845sc.Cb.UFX(), 0);
            }
        }
        if (JPJ.TRI(this.f27845sc.pFF)) {
            this.f27845sc.BR.We();
            kX.sc((View) this.f27845sc.Cb.WH(), 4);
        }
        if (com.bytedance.sdk.openadsdk.core.model.Xc.We(this.f27845sc.pFF) || com.bytedance.sdk.openadsdk.core.model.Xc.pFF(this.f27845sc.pFF) || com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.f27845sc.pFF)) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27845sc;
        com.bytedance.sdk.openadsdk.component.reward.view.WH wh2 = scVar3.BR;
        int iZY = kX.zY(scVar3.f27911pc, scVar3.f27909ht);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = this.f27845sc;
        wh2.sc(iZY, kX.zY(scVar4.f27911pc, scVar4.ZM));
        this.f27845sc.FI.sc();
        if (JPJ.wjp(this.f27845sc.pFF)) {
            this.f27845sc.Cb.sc(true);
            this.f27845sc.Cb.ExN();
            sc(false, false, false, com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.zY);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = this.f27845sc;
            if (scVar5.NQ) {
                scVar5.BR.sc(0);
            }
        }
    }

    public View WH() {
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar;
        if (this.pFF.Gb() != 5) {
            qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(this.f27845sc.CYO);
            qrVar.setId(SR.BU);
        } else {
            qrVar = null;
        }
        Objects.toString(qrVar);
        return qrVar;
    }

    public void WP() {
        this.Tf = this.f27845sc.McK.zY();
    }

    public sc We() {
        return null;
    }

    public void Xc() {
        if (!JPJ.WH(this.pFF) || this.f27845sc.Cb.JoC()) {
            wjp();
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        if (scVar == null) {
            return;
        }
        Tf tf2 = scVar.NP;
        if (tf2 != null) {
            tf2.sc();
        }
        this.f27845sc.sc();
    }

    public void YIK() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        if (scVar == null) {
            return;
        }
        scVar.yL = false;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
        boolean z11 = scVar2.yL;
        boolean z12 = scVar2.f27908eo;
        if (!scVar2.UFX.get()) {
            this.f27845sc.JPJ.WH();
        }
        dE();
        this.f27845sc.Cb.Dl();
        this.f27845sc.WP.dE();
        this.f27845sc.uEA.set(true);
        if (this.f27845sc.WH.get()) {
            this.f27845sc.Dl.set(true);
        }
        Tf tf2 = this.f27845sc.NP;
        if (tf2 != null) {
            tf2.pFF();
        }
        this.f27845sc.pFF();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    public void cvk() {
        Sfl sfl;
        if (!TRI() && ((this instanceof Qj) || (this instanceof Ol))) {
            this.f27845sc.McK.pFF();
            return;
        }
        if (!this.Ol.sc(this.ExN.Ol(), false)) {
            this.WH.removeMessages(LogSeverity.NOTICE_VALUE);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            if (scVar.otH) {
                com.bytedance.sdk.openadsdk.activity.TRI tri = scVar.dix;
                if (tri instanceof com.bytedance.sdk.openadsdk.activity.sc) {
                    ((com.bytedance.sdk.openadsdk.activity.sc) tri).Dl();
                } else {
                    sc(com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.f27373sc);
                    com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc2 = this.ExN;
                    xc2.sc(!xc2.II() ? 1 : 0, 4);
                }
            } else {
                sc(com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.f27373sc);
                com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc3 = this.ExN;
                xc3.sc(!xc3.II() ? 1 : 0, 4);
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
        if (scVar2 == null || (sfl = scVar2.pFF) == null || scVar2.NP == null || !sfl.ixT()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27845sc;
        scVar3.NP.sc(scVar3.JPJ.YIK());
    }

    public void dE() {
        this.WH.removeMessages(LogSeverity.NOTICE_VALUE);
    }

    public abstract void qr();

    public void sc(int i11) {
        this.ExN.Ql();
        sc(false, true, false, i11);
        if (this.f27845sc.We) {
            this.Ol.sc(10000);
        }
    }

    /* JADX WARN: Code duplicated, block: B:93:0x020f  */
    public void sc(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            FI();
            return;
        }
        if (i11 == 300) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            if (scVar.otH) {
                com.bytedance.sdk.openadsdk.activity.TRI tri = scVar.dix;
                if (tri instanceof com.bytedance.sdk.openadsdk.activity.sc) {
                    ((com.bytedance.sdk.openadsdk.activity.sc) tri).Dl();
                } else {
                    sc(com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.pFF);
                    com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc2 = this.f27845sc.JPJ;
                    xc2.sc(!xc2.II() ? 1 : 0, 1 ^ (this.f27845sc.JPJ.II() ? 1 : 0));
                }
            } else {
                sc(com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.pFF);
                com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc3 = this.f27845sc.JPJ;
                xc3.sc(!xc3.II() ? 1 : 0, 1 ^ (this.f27845sc.JPJ.II() ? 1 : 0));
            }
            if (this.f27845sc.pFF.GOt() == null || this.f27845sc.pFF.GOt().sc() == null) {
                return;
            }
            this.f27845sc.pFF.GOt().sc().sc(com.bytedance.sdk.openadsdk.core.Tf.sc.sc.GENERAL_LINEAR_AD_ERROR);
            return;
        }
        if (i11 == 400) {
            this.f27845sc.JPJ.Ql();
            sc(false, true, false, 3);
            return;
        }
        if (i11 == 500) {
            if (!JPJ.qr(this.f27845sc.pFF)) {
                this.f27845sc.cJ.zY(false);
            }
            com.bytedance.sdk.component.Ol.We weWH = this.f27845sc.Cb.WH();
            if (weWH != null && weWH.getWebView() != null) {
                weWH.Ol();
                weWH.getWebView().resumeTimers();
            }
            if (this.f27845sc.Cb.WH() != null) {
                this.f27845sc.Cb.sc(1.0f);
                this.f27845sc.BR.sc(1.0f);
            }
            if (!this.f27845sc.pFF.xP() && this.f27845sc.JPJ.pFF() && this.f27845sc.wjp.get()) {
                this.f27845sc.JPJ.Ql();
                return;
            }
            return;
        }
        if (i11 == 600) {
            BT();
            return;
        }
        if (i11 == 700) {
            int i12 = message.arg1;
            if (this.f27845sc.Dl.get()) {
                return;
            }
            if (i12 <= 0) {
                this.WH.removeMessages(LogSeverity.ALERT_VALUE);
                if (!JPJ.Ol(this.pFF)) {
                    BT();
                    return;
                } else if (this.f27845sc.WP.qr() || !this.f27845sc.Cb.wjp()) {
                    BT();
                    return;
                } else {
                    FI();
                    return;
                }
            }
            this.f27845sc.cJ.pFF();
            this.f27845sc.cJ.sc((i12 / 1000) + "s");
            this.f27845sc.cJ.ExN(false);
            Message messageObtain = Message.obtain();
            messageObtain.what = LogSeverity.ALERT_VALUE;
            messageObtain.arg1 = i12 - 1000;
            this.f27845sc.Qj -= 1000;
            this.WH.sendMessageDelayed(messageObtain, 1000L);
            return;
        }
        if (i11 == 800) {
            if (!JPJ.qr(this.f27845sc.pFF)) {
                this.f27845sc.cJ.zY(false);
            }
            this.f27845sc.BR.sc(1.0f);
            if (!this.f27845sc.pFF.xP() && this.f27845sc.JPJ.pFF() && this.f27845sc.wjp.get()) {
                this.f27845sc.JPJ.Ql();
                return;
            }
            return;
        }
        if (i11 == 900 && !this.f27845sc.uEA.get()) {
            int i13 = message.arg1;
            double dMcK = this.f27845sc.JPJ.McK();
            sc(i13, (long) (1000.0d * dMcK));
            if (i13 <= 0) {
                this.WH.removeMessages(900);
                BT();
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
                com.bytedance.sdk.openadsdk.activity.TRI tri2 = scVar2.dix;
                if (scVar2.otH && (tri2 instanceof com.bytedance.sdk.openadsdk.activity.sc)) {
                    tri2.FI().sc(tri2, new com.bytedance.sdk.openadsdk.activity.pFF.ExN(5, this.f27845sc));
                    return;
                }
                return;
            }
            this.f27845sc.cJ.pFF();
            this.f27845sc.cJ.sc((i13 / 1000) + "s");
            this.f27845sc.cJ.ExN(false);
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 900;
            int i14 = i13 - 1000;
            messageObtain2.arg1 = i14;
            this.f27845sc.Ol = i14;
            this.WH.sendMessageDelayed(messageObtain2, 1000L);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27845sc;
            if (scVar3.otH) {
                com.bytedance.sdk.openadsdk.activity.TRI tri3 = scVar3.dix;
                if (!(tri3 instanceof com.bytedance.sdk.openadsdk.activity.sc) || dMcK <= 0.0d) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.activity.sc) tri3).sc((float) (1.0d - (((double) (i13 / 1000.0f)) / dMcK)));
            }
        }
    }

    public abstract void sc(FrameLayout frameLayout);

    public void sc(com.bytedance.sdk.openadsdk.Tf.ExN exN) {
        this.BT = exN;
        zY();
        if (!this.f27845sc.pFF.ymG() && McK()) {
            II();
        }
        if (McK()) {
            this.f27845sc.kX.pFF();
        }
        if (com.bytedance.sdk.openadsdk.core.model.Xc.We(this.f27845sc.pFF) || com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.f27845sc.pFF)) {
            this.WH.sendEmptyMessageDelayed(500, 100L);
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        scVar.BR.sc(scVar.f27910ko == 100.0f);
        WP();
        qr();
    }

    public void sc(com.bytedance.sdk.openadsdk.component.reward.view.qr qrVar) {
        sc(qrVar, this.f27845sc);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.sc
    public void sc(com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff, FI fi2) {
        super.sc(pff, fi2);
        if (this.f27845sc.pFF.sc()) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            if (scVar.DNB) {
                scVar.Cb.sc(false);
            }
        }
        if (JPJ.wjp(this.f27845sc.pFF)) {
            this.f27845sc.WP.Tf();
        }
    }

    public void sc(boolean z11, boolean z12, boolean z13, int i11) {
        this.f27845sc.kX.sc(z11, z12, z13, this, i11);
    }

    public void uEA() {
        com.bytedance.sdk.openadsdk.component.reward.view.Qj qj2 = this.f27845sc.cvk;
        if (qj2 != null) {
            qj2.TRI();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.WH wh2 = this.f27845sc.BR;
        if (wh2 != null) {
            wh2.SR();
        }
        this.f27845sc.JPJ.WP();
        if (!ExN()) {
            this.f27845sc.WH.get();
        }
        this.f27845sc.Cb.dE();
        this.f27845sc.WP.qr(com.bytedance.sdk.openadsdk.component.reward.sc.Qj.f27866sc);
        this.f27845sc.BR.Tf();
        this.f27845sc.kX.zY();
        this.f27845sc.II.pFF();
        Tf tf2 = this.f27845sc.NP;
        if (tf2 != null) {
            tf2.zY();
        }
    }

    public void wjp() {
        int i11;
        if (this.f27845sc.WH.get()) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            if (!scVar.f27912qr && scVar.Dl.getAndSet(false) && ((i11 = this.f27845sc.Qj) >= 0 || i11 == -1)) {
                Message messageObtain = Message.obtain();
                messageObtain.what = LogSeverity.ALERT_VALUE;
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
                messageObtain.arg1 = scVar2.Qj;
                scVar2.GI.sendMessage(messageObtain);
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27845sc;
        if (scVar3.Ol <= 0 || !scVar3.uEA.getAndSet(false)) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        messageObtain2.what = 900;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = this.f27845sc;
        messageObtain2.arg1 = scVar4.Ol;
        scVar4.GI.sendMessage(messageObtain2);
    }
}
