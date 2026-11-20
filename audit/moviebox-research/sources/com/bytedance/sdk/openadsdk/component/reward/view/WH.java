package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.sc.dE;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Ql;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH {
    public Xc BT;
    private boolean Dl;
    ImageView ExN;
    PAGLogoView Ol;
    View Qj;
    private final String Sfl;
    FrameLayout TRI;
    dE Tf;
    RelativeLayout UFX;
    ImageView WH;
    final Sfl We;
    private int YIK;
    com.bytedance.sdk.openadsdk.core.ExN.TRI dE;
    final Activity pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    View f27959qr;
    private zY uEA;
    private final boolean wjp;
    protected final com.bytedance.sdk.openadsdk.component.reward.sc.sc zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    int f27960sc = 3;
    protected int Ql = 0;
    protected final AtomicBoolean SR = new AtomicBoolean(false);
    Runnable Xc = new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.WH.2
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            try {
                Sfl sfl = WH.this.We;
                if ((sfl == null || !sfl.ixT()) && (imageView = WH.this.ExN) != null) {
                    int[] iArr = new int[2];
                    imageView.getLocationOnScreen(iArr);
                    WH.this.zY.cJ.sc(iArr[0]);
                }
            } catch (Exception unused) {
            }
        }
    };

    public WH(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.zY = scVar;
        this.pFF = scVar.CYO;
        this.We = scVar.pFF;
        this.Sfl = scVar.ExN;
        this.wjp = scVar.We;
    }

    private int sc(String str) {
        Resources resources = this.pFF.getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier(str, "dimen", "android"));
        }
        return 0;
    }

    private void sc(com.bytedance.sdk.openadsdk.core.pFF.zY zYVar) {
        kX.sc((View) this.TRI, (View.OnTouchListener) zYVar, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    private void wjp() {
        RelativeLayout relativeLayout;
        zY zYVar = (zY) this.zY.JoC.findViewById(SR.Tf);
        this.uEA = zYVar;
        zYVar.sc(this.zY);
        this.Ol = (PAGLogoView) this.zY.JoC.findViewById(520093757);
        this.WH = (ImageView) this.zY.JoC.findViewById(SR.ofL);
        this.ExN = (ImageView) this.zY.JoC.findViewById(520093708);
        this.TRI = (FrameLayout) this.zY.JoC.findViewById(SR.UFX);
        this.f27959qr = this.zY.JoC.findViewById(SR.Xc);
        this.Qj = this.zY.JoC.findViewById(SR.AZJ);
        this.UFX = (RelativeLayout) this.zY.JoC.findViewById(SR.BU);
        dE dEVar = this.Tf;
        if (dEVar == null || dEVar.We() == null || (relativeLayout = this.UFX) == null) {
            return;
        }
        relativeLayout.addView(this.Tf.We(), new LinearLayout.LayoutParams(-1, -1));
        this.Tf.pFF();
    }

    public void BT() {
        Xc xc2 = this.BT;
        if (xc2 != null) {
            xc2.qr();
        }
    }

    public void ExN() {
        int iOXF = this.We.OXF();
        this.f27960sc = iOXF;
        if (iOXF == -200) {
            this.f27960sc = com.bytedance.sdk.openadsdk.core.Xc.We().BT(String.valueOf(this.We.QT()));
        }
        if (this.f27960sc != -1 || sc()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY.kDg;
        if ((pff instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.We) || (pff instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.zY)) {
            return;
        }
        pFF(0);
    }

    public void ExN(int i11) {
        kX.sc((View) this.ExN, i11);
        if (i11 == 0 && !this.zY.WH.get() && JPJ.qr(this.zY.pFF)) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
            com.bytedance.sdk.openadsdk.We.zY.sc(scVar.pFF, scVar.ExN, "show_close_button", (JSONObject) null, System.currentTimeMillis() - this.zY.YdT);
        }
    }

    public boolean Ol() {
        ImageView imageView = this.ExN;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void Qj() {
        zY zYVar = this.uEA;
        if (zYVar == null) {
            return;
        }
        zYVar.sc();
    }

    public void Ql() {
        try {
            Activity activity = this.zY.CYO;
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(activity, com.bytedance.sdk.component.utils.Sfl.Ol(activity, "tt_fade_out"));
            if (animationLoadAnimation == null) {
                this.zY.BR.Tf();
            } else {
                animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.WH.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        WH.this.zY.BR.Tf();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                this.zY.BR.sc(animationLoadAnimation);
            }
        } catch (Throwable unused) {
            this.zY.BR.Tf();
        }
    }

    public void SR() {
        Xc xc2 = this.BT;
        if (xc2 != null) {
            xc2.TRI();
        }
        ImageView imageView = this.ExN;
        if (imageView != null) {
            imageView.removeCallbacks(this.Xc);
        }
    }

    public FrameLayout TRI() {
        return this.TRI;
    }

    public void Tf() {
        try {
            dE dEVar = this.Tf;
            if (dEVar != null) {
                dEVar.zY();
            }
            RelativeLayout relativeLayout = this.UFX;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable unused) {
            RelativeLayout relativeLayout2 = this.UFX;
            if (relativeLayout2 != null) {
                relativeLayout2.setAlpha(0.0f);
            }
        }
    }

    public View UFX() {
        return this.uEA;
    }

    public View WH() {
        return this.ExN;
    }

    public void We() {
        kX.sc((View) this.TRI, 8);
        kX.sc(this.f27959qr, 8);
        kX.sc(this.Qj, 8);
        pFF(8);
        kX.sc((View) this.ExN, 8);
        kX.sc((View) this.Ol, 8);
        kX.sc((View) this.UFX, 8);
        kX.sc((View) this.WH, 8);
    }

    public void We(int i11) {
        int i12 = this.f27960sc;
        if (i12 == -1 || i11 != i12 || this.SR.get()) {
            return;
        }
        pFF(0);
        this.SR.set(true);
        Qj();
    }

    public void Xc() {
        com.bytedance.sdk.openadsdk.core.pFF.ExN ExN = this.zY.McK.ExN();
        View view = this.uEA;
        if (view == null) {
            view = this.zY.JoC;
        }
        ExN.onClick(view);
    }

    public void dE() {
        Xc xc2 = this.BT;
        if (xc2 != null) {
            xc2.Qj();
        }
    }

    public void pFF() {
        if (this.Dl) {
            return;
        }
        this.Dl = true;
        this.YIK = this.zY.OKY;
        if (sc()) {
            dE dEVar = new dE(this.zY);
            this.Tf = dEVar;
            dEVar.sc();
        }
        wjp();
        Activity activity = this.pFF;
        Sfl sfl = this.We;
        String str = this.Sfl;
        FrameLayout frameLayout = this.TRI;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        Xc xc2 = new Xc(activity, sfl, str, frameLayout, scVar.qKn, scVar.JoC);
        this.BT = xc2;
        xc2.sc();
    }

    public void pFF(int i11) {
        Sfl sfl = this.We;
        if (sfl != null && sfl.ymG() && Ql.sc(this.We)) {
            kX.sc((View) this.uEA, 8);
        } else {
            kX.sc((View) this.uEA, i11);
        }
    }

    public void pFF(boolean z11) {
        ImageView imageView;
        int iSc;
        if (this.YIK != 1 && (imageView = this.ExN) != null && z11) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (iSc = sc("navigation_bar_height")) > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (iSc > marginLayoutParams.rightMargin) {
                    marginLayoutParams.rightMargin = iSc;
                }
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY.kDg;
        if ((pff instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.We) || (pff instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.zY)) {
            return;
        }
        pFF(0);
    }

    public void qr() {
        if (this.WH.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.WH.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 11, 16);
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(11);
            this.WH.setLayoutParams(marginLayoutParams);
        }
    }

    public void sc(float f11) {
        kX.sc(this.ExN, f11);
    }

    public void sc(int i11) {
        if (this.dE == null) {
            this.dE = new com.bytedance.sdk.openadsdk.core.ExN.TRI(this.zY.CYO);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.dE.setLayoutParams(layoutParams);
            this.dE.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(this.zY.CYO, "tt_video_loading_progress_bar"));
            this.zY.BR.TRI().addView(this.dE);
        }
        this.dE.setVisibility(i11);
    }

    public void sc(int i11, int i12) {
        FrameLayout frameLayout;
        if (this.We.Gb() == 1 && (frameLayout = this.TRI) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int iZY = kX.zY((Context) this.pFF);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.TRI.getLayoutParams();
            layoutParams.width = iZY;
            int i13 = (iZY * 9) / 16;
            layoutParams.height = i13;
            this.TRI.setLayoutParams(layoutParams);
            this.Ql = (kX.We((Context) this.pFF) - i13) / 2;
            Tf.sc("TTAD.RFullVideoLayout", "NonContentAreaHeight:" + this.Ql);
        }
    }

    public void sc(int i11, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        Xc xc2 = this.BT;
        if (xc2 != null) {
            xc2.sc(i11, sr2);
        }
    }

    public void sc(View.OnClickListener onClickListener) {
        kX.sc(this.TRI, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    public void sc(Animation animation) {
        RelativeLayout relativeLayout = this.UFX;
        if (relativeLayout != null) {
            relativeLayout.startAnimation(animation);
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.zY zYVar, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        View view;
        View view2;
        Sfl sfl;
        if (this.TRI != null && (sfl = this.We) != null && sfl.cD() != null) {
            if (!this.We.cD().TRI || Xc.pFF(this.We)) {
                sc(onClickListener);
            } else {
                sc((View.OnClickListener) zYVar);
                sc(zYVar);
            }
        }
        Sfl sfl2 = this.We;
        if (sfl2 != null && sfl2.Gb() == 1) {
            if (this.We.cD() != null && (view2 = this.f27959qr) != null) {
                kX.sc(view2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f27959qr.getLayoutParams();
                layoutParams.height = this.Ql;
                this.f27959qr.setLayoutParams(layoutParams);
                if (this.We.cD().pFF) {
                    this.f27959qr.setOnClickListener(zYVar);
                    this.f27959qr.setOnTouchListener(onTouchListener);
                } else {
                    this.f27959qr.setOnClickListener(onClickListener);
                }
            }
            if (this.We.cD() != null && (view = this.Qj) != null) {
                kX.sc(view, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Qj.getLayoutParams();
                layoutParams2.height = this.Ql;
                this.Qj.setLayoutParams(layoutParams2);
                if (this.We.cD().We) {
                    this.Qj.setOnClickListener(zYVar);
                    this.Qj.setOnTouchListener(onTouchListener);
                } else {
                    this.Qj.setOnClickListener(onClickListener);
                }
            }
        }
        PAGLogoView pAGLogoView = this.Ol;
        if (pAGLogoView != null) {
            pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.WH.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    try {
                        WH wh2 = WH.this;
                        TTWebsiteActivity.sc(wh2.pFF, wh2.We, wh2.Sfl);
                    } catch (Throwable th2) {
                        Tf.sc("TTAD.RFullVideoLayout", th2.getMessage());
                    }
                }
            });
        }
        ImageView imageView = this.WH;
        if (imageView != null) {
            imageView.setClickable(true);
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc((int) kX.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), 14.0f, true), this.WH, this.zY.pFF);
        }
    }

    public void sc(boolean z11) {
        kX.sc((View) this.Ol, JPJ.zY(this.We) ? 8 : 0);
        kX.sc((View) this.WH, (this.We.ymG() && this.We.Qj()) ? 0 : 8);
        pFF(z11);
        if (this.wjp) {
            ExN();
        }
    }

    public boolean sc() {
        return true;
    }

    public void zY() {
        this.TRI.removeAllViews();
    }

    public void zY(int i11) {
        kX.sc((View) this.Ol, i11);
    }
}
