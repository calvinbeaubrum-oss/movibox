package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class wjp {
    private final RelativeLayout ExN;
    private TextView Ol;
    private ImageView Qj;
    private final Sfl TRI;
    private boolean Tf;
    private com.bytedance.sdk.openadsdk.core.ExN.TRI WH;
    TTAdDislikeToast pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Context f27725qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    BT f27726sc;
    final AtomicBoolean zY = new AtomicBoolean(false);
    final AtomicBoolean We = new AtomicBoolean(false);
    private final int UFX = kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc(), 44.0f);

    public wjp(Context context, RelativeLayout relativeLayout, Sfl sfl) {
        this.f27725qr = context;
        this.ExN = relativeLayout;
        this.TRI = sfl;
        ExN();
    }

    private void ExN() {
        this.Qj = (ImageView) this.ExN.findViewById(com.bytedance.sdk.openadsdk.utils.SR.kDg);
        this.Ol = (TextView) this.ExN.findViewById(com.bytedance.sdk.openadsdk.utils.SR.DNB);
        ImageView imageView = (ImageView) this.ExN.findViewById(com.bytedance.sdk.openadsdk.utils.SR.NP);
        this.WH = (com.bytedance.sdk.openadsdk.core.ExN.TRI) this.ExN.findViewById(com.bytedance.sdk.openadsdk.utils.SR.otH);
        Sfl sfl = this.TRI;
        if (sfl != null) {
            this.Ol.setText(TextUtils.isEmpty(sfl.YdT()) ? com.bytedance.sdk.component.utils.Sfl.sc(this.f27725qr, "tt_web_title_default") : this.TRI.YdT());
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.wjp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wjp.this.We();
            }
        });
    }

    private void TRI() {
        try {
            if (this.f27726sc == null) {
                BT bt2 = new BT(this.f27725qr, this.TRI);
                this.f27726sc = bt2;
                bt2.setDislikeSource("landing_page");
                this.f27726sc.setCallback(new BT.sc() { // from class: com.bytedance.sdk.openadsdk.common.wjp.6
                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void pFF(View view) {
                        wjp.this.zY.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void sc(View view) {
                        wjp.this.zY.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void sc(FilterWord filterWord) {
                        if (wjp.this.We.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        wjp.this.We.set(true);
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) this.ExN.getRootView().findViewById(R.id.content);
            frameLayout.addView(this.f27726sc);
            if (this.pFF == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.f27725qr);
                this.pFF = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th2) {
            ApmHelper.reportCustomError("initDislike error", "TTTitleNewStyleManager", th2);
        }
    }

    private void qr() {
        this.pFF.show(TTAdDislikeToast.getDislikeTip());
    }

    public void We() {
        if (this.We.get()) {
            qr();
            return;
        }
        if (this.f27726sc == null) {
            TRI();
        }
        BT bt2 = this.f27726sc;
        if (bt2 != null) {
            bt2.sc();
        }
    }

    public void pFF() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ExN.getLayoutParams();
            if (this.Tf || marginLayoutParams.topMargin != 0) {
                return;
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, -this.UFX);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.wjp.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    wjp.this.ExN.setLayoutParams(marginLayoutParams);
                }
            });
            valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.wjp.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    wjp.this.Tf = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    wjp.this.Tf = true;
                }
            });
            valueAnimatorOfInt.start();
        } catch (Throwable unused) {
        }
    }

    public void sc() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ExN.getLayoutParams();
            if (this.Tf) {
                return;
            }
            int i11 = marginLayoutParams.topMargin;
            int i12 = this.UFX;
            if (i11 == (-i12)) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(-i12, 0);
                valueAnimatorOfInt.setDuration(300L);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.wjp.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        wjp.this.ExN.setLayoutParams(marginLayoutParams);
                    }
                });
                valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.wjp.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        wjp.this.Tf = false;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        wjp.this.Tf = true;
                    }
                });
                valueAnimatorOfInt.start();
            }
        } catch (Throwable unused) {
        }
    }

    public void sc(int i11) {
        if (i11 == 100) {
            this.WH.setVisibility(8);
        } else {
            this.WH.setVisibility(0);
            this.WH.setProgress(i11);
        }
    }

    public ImageView zY() {
        return this.Qj;
    }
}
