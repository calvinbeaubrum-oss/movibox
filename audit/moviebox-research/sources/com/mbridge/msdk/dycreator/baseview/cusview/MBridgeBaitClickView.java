package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBridgeBaitClickView extends RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MBridgeDyImageView f43447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MBridgeDyImageView f43448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f43449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f43450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f43451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f43452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Animation f43455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Animation f43456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Animation f43457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Animation f43458l;

    public MBridgeBaitClickView(Context context) {
        super(context);
        this.f43450d = "";
        this.f43451e = "";
        this.f43452f = "Click now for details";
        this.f43453g = 1;
        this.f43454h = 1342177280;
    }

    public MBridgeBaitClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43450d = "";
        this.f43451e = "";
        this.f43452f = "Click now for details";
        this.f43453g = 1;
        this.f43454h = 1342177280;
    }

    public MBridgeBaitClickView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43450d = "";
        this.f43451e = "";
        this.f43452f = "Click now for details";
        this.f43453g = 1;
        this.f43454h = 1342177280;
    }

    public MBridgeBaitClickView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f43450d = "";
        this.f43451e = "";
        this.f43452f = "Click now for details";
        this.f43453g = 1;
        this.f43454h = 1342177280;
    }

    public void init() {
        try {
            setBackgroundColor(this.f43454h);
            try {
                this.f43452f = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "点击查看详情" : "Click now for details";
            } catch (Throwable th2) {
                ad.b("MBridgeAnimationClickView", th2.getMessage());
            }
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            int iA = ai.a(getContext(), 55.0f);
            int iA2 = ai.a(getContext(), 33.0f);
            this.f43448b = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
            layoutParams.setMargins(iA2, iA2, 0, 0);
            this.f43448b.setLayoutParams(layoutParams);
            final int iA3 = v.a(getContext(), "mbridge_icon_click_circle", "drawable");
            if (TextUtils.isEmpty(this.f43451e)) {
                this.f43448b.setImageResource(iA3);
            } else {
                b.a(c.m().c()).a(this.f43450d, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.1
                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.f43448b.setImageResource(iA3);
                    }

                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.f43448b.setImageBitmap(bitmap);
                    }
                });
            }
            int iA4 = ai.a(getContext(), 108.0f);
            int iA5 = ai.a(getContext(), 35.0f);
            int iA6 = ai.a(getContext(), 43.0f);
            this.f43447a = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA4, iA4);
            layoutParams2.setMargins(iA5, iA6, 0, 0);
            this.f43447a.setLayoutParams(layoutParams2);
            final int iA7 = v.a(getContext(), "mbridge_icon_click_hand", "drawable");
            if (TextUtils.isEmpty(this.f43450d)) {
                this.f43447a.setImageResource(iA7);
            } else {
                b.a(c.m().c()).a(this.f43450d, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.2
                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.f43447a.setImageResource(iA7);
                    }

                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.f43447a.setImageBitmap(bitmap);
                    }
                });
            }
            relativeLayout.addView(this.f43448b);
            relativeLayout.addView(this.f43447a);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(relativeLayout);
            this.f43449c = new TextView(getContext());
            this.f43449c.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f43449c.setText(this.f43452f);
            this.f43449c.setTextColor(-1);
            this.f43449c.setGravity(14);
            linearLayout.addView(this.f43449c);
            addView(linearLayout);
        } catch (Throwable th3) {
            ad.b("MBridgeAnimationClickView", th3.getMessage());
        }
    }

    public void init(int i11) {
        this.f43453g = i11;
        init();
    }

    public void init(int i11, int i12) {
        this.f43454h = i11;
        this.f43453g = i12;
        init();
    }

    public void init(int i11, int i12, String str, String str2, String str3) {
        this.f43454h = i11;
        this.f43453g = i12;
        this.f43450d = str;
        this.f43451e = str2;
        this.f43452f = str3;
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        Animation animation = this.f43455i;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f43456j;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f43457k;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.f43458l;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i11 = this.f43453g;
        if (i11 == 2) {
            this.f43448b.setVisibility(4);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f43455i = scaleAnimation;
            scaleAnimation.setDuration(500L);
            this.f43455i.setRepeatCount(-1);
            this.f43455i.setRepeatMode(2);
            MBridgeDyImageView mBridgeDyImageView = this.f43447a;
            if (mBridgeDyImageView != null) {
                mBridgeDyImageView.startAnimation(this.f43455i);
                return;
            }
            return;
        }
        if (i11 == 3) {
            MBridgeDyImageView mBridgeDyImageView2 = this.f43448b;
            if (mBridgeDyImageView2 != null) {
                mBridgeDyImageView2.setVisibility(4);
            }
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f43455i = scaleAnimation2;
            scaleAnimation2.setDuration(500L);
            this.f43455i.setRepeatCount(1);
            this.f43455i.setRepeatMode(2);
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.f43456j = scaleAnimation3;
            scaleAnimation3.setDuration(1000L);
            this.f43456j.setRepeatCount(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.f43457k = alphaAnimation;
            alphaAnimation.setDuration(1000L);
            this.f43457k.setRepeatCount(0);
            final AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(this.f43456j);
            animationSet.addAnimation(this.f43457k);
            this.f43456j.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (MBridgeBaitClickView.this.f43448b != null) {
                        MBridgeBaitClickView.this.f43448b.setVisibility(4);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (MBridgeBaitClickView.this.f43448b != null) {
                        MBridgeBaitClickView.this.f43448b.setVisibility(0);
                    }
                }
            });
            this.f43455i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MBridgeBaitClickView.this.f43447a != null) {
                                MBridgeBaitClickView.this.f43447a.startAnimation(MBridgeBaitClickView.this.f43455i);
                            }
                        }
                    }, 1000L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MBridgeBaitClickView.this.f43448b != null) {
                                MBridgeBaitClickView.this.f43448b.startAnimation(animationSet);
                            }
                        }
                    }, 550L);
                }
            });
            MBridgeDyImageView mBridgeDyImageView3 = this.f43447a;
            if (mBridgeDyImageView3 != null) {
                mBridgeDyImageView3.startAnimation(this.f43455i);
                return;
            }
            return;
        }
        if (i11 == 4) {
            this.f43448b.setVisibility(4);
            ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.f43455i = scaleAnimation4;
            scaleAnimation4.setDuration(200L);
            this.f43455i.setRepeatCount(1);
            this.f43455i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MBridgeBaitClickView.this.f43447a != null) {
                                MBridgeBaitClickView.this.f43447a.startAnimation(MBridgeBaitClickView.this.f43455i);
                            }
                        }
                    }, 1000L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            MBridgeDyImageView mBridgeDyImageView4 = this.f43447a;
            if (mBridgeDyImageView4 != null) {
                mBridgeDyImageView4.startAnimation(this.f43455i);
                return;
            }
            return;
        }
        if (i11 != 5) {
            ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f43455i = scaleAnimation5;
            scaleAnimation5.setDuration(200L);
            this.f43455i.setRepeatCount(-1);
            this.f43455i.setRepeatMode(2);
            MBridgeDyImageView mBridgeDyImageView5 = this.f43447a;
            if (mBridgeDyImageView5 != null) {
                mBridgeDyImageView5.startAnimation(this.f43455i);
            }
            ScaleAnimation scaleAnimation6 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.f43456j = scaleAnimation6;
            scaleAnimation6.setDuration(400L);
            this.f43456j.setRepeatCount(-1);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.3f);
            this.f43457k = alphaAnimation2;
            alphaAnimation2.setDuration(400L);
            this.f43457k.setRepeatCount(-1);
            AnimationSet animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(this.f43456j);
            animationSet2.addAnimation(this.f43457k);
            MBridgeDyImageView mBridgeDyImageView6 = this.f43448b;
            if (mBridgeDyImageView6 != null) {
                mBridgeDyImageView6.startAnimation(animationSet2);
                return;
            }
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.f43458l = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.f43458l.setRepeatMode(2);
        this.f43458l.setRepeatCount(-1);
        ScaleAnimation scaleAnimation7 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.f43456j = scaleAnimation7;
        scaleAnimation7.setDuration(600L);
        this.f43456j.setRepeatCount(-1);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        this.f43457k = alphaAnimation3;
        alphaAnimation3.setDuration(600L);
        this.f43457k.setRepeatCount(-1);
        AnimationSet animationSet3 = new AnimationSet(true);
        animationSet3.addAnimation(this.f43456j);
        animationSet3.addAnimation(this.f43457k);
        MBridgeDyImageView mBridgeDyImageView7 = this.f43447a;
        if (mBridgeDyImageView7 != null) {
            mBridgeDyImageView7.startAnimation(this.f43458l);
        }
        MBridgeDyImageView mBridgeDyImageView8 = this.f43448b;
        if (mBridgeDyImageView8 != null) {
            mBridgeDyImageView8.startAnimation(animationSet3);
        }
    }
}
