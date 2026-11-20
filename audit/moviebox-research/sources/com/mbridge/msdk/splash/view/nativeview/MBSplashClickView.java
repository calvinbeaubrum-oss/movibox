package com.mbridge.msdk.splash.view.nativeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBSplashClickView extends RelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f47303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f47304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f47305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f47306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f47307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f47308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f47309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f47310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f47311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f47312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f47313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f47314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47315m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageView f47316n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView f47317o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final RectF f47318p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Paint f47319q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Paint f47320r;

    public MBSplashClickView(Context context) {
        super(context);
        this.f47303a = "浏览第三方应用";
        this.f47304b = "View";
        this.f47305c = "打开第三方应用";
        this.f47306d = "Open";
        this.f47307e = "下载第三方应用";
        this.f47308f = "Install";
        this.f47309g = "mbridge_splash_btn_arrow_right";
        this.f47310h = "mbridge_splash_btn_circle";
        this.f47311i = "mbridge_splash_btn_finger";
        this.f47312j = "mbridge_splash_btn_go";
        this.f47313k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f47318p = new RectF();
        this.f47319q = new Paint();
        this.f47320r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47303a = "浏览第三方应用";
        this.f47304b = "View";
        this.f47305c = "打开第三方应用";
        this.f47306d = "Open";
        this.f47307e = "下载第三方应用";
        this.f47308f = "Install";
        this.f47309g = "mbridge_splash_btn_arrow_right";
        this.f47310h = "mbridge_splash_btn_circle";
        this.f47311i = "mbridge_splash_btn_finger";
        this.f47312j = "mbridge_splash_btn_go";
        this.f47313k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f47318p = new RectF();
        this.f47319q = new Paint();
        this.f47320r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f47303a = "浏览第三方应用";
        this.f47304b = "View";
        this.f47305c = "打开第三方应用";
        this.f47306d = "Open";
        this.f47307e = "下载第三方应用";
        this.f47308f = "Install";
        this.f47309g = "mbridge_splash_btn_arrow_right";
        this.f47310h = "mbridge_splash_btn_circle";
        this.f47311i = "mbridge_splash_btn_finger";
        this.f47312j = "mbridge_splash_btn_go";
        this.f47313k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f47318p = new RectF();
        this.f47319q = new Paint();
        this.f47320r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f47303a = "浏览第三方应用";
        this.f47304b = "View";
        this.f47305c = "打开第三方应用";
        this.f47306d = "Open";
        this.f47307e = "下载第三方应用";
        this.f47308f = "Install";
        this.f47309g = "mbridge_splash_btn_arrow_right";
        this.f47310h = "mbridge_splash_btn_circle";
        this.f47311i = "mbridge_splash_btn_finger";
        this.f47312j = "mbridge_splash_btn_go";
        this.f47313k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f47318p = new RectF();
        this.f47319q = new Paint();
        this.f47320r = new Paint();
    }

    private void a() {
        this.f47319q.setAntiAlias(true);
        this.f47319q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f47320r.setAntiAlias(true);
        this.f47320r.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f47318p, this.f47320r, 31);
        canvas.drawRoundRect(this.f47318p, 200.0f, 200.0f, this.f47320r);
        canvas.saveLayer(this.f47318p, this.f47319q, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0015  */
    public void initView(String str) {
        RelativeLayout.LayoutParams layoutParams;
        this.f47314l = str;
        str.hashCode();
        int identifier = 0;
        switch (str) {
            case "Install":
            case "下载第三方应用":
                this.f47315m = 3;
                break;
            case "Open":
            case "打开第三方应用":
                this.f47315m = 1;
                break;
            case "View":
            case "浏览第三方应用":
                this.f47315m = 2;
                break;
            default:
                boolean zContains = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
                if (TextUtils.isEmpty(this.f47314l)) {
                    this.f47314l = zContains ? "浏览第三方应用" : "View";
                }
                this.f47315m = 2;
                break;
        }
        int i11 = this.f47315m;
        int color = Color.parseColor("#666666");
        int color2 = Color.parseColor("#8FC31F");
        int color3 = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i11 == 2) {
            gradientDrawable.setColor(color2);
        } else {
            gradientDrawable.setColor(color3);
            gradientDrawable.setStroke(2, color);
        }
        gradientDrawable.setCornerRadius(200);
        setBackground(gradientDrawable);
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setText(this.f47314l);
        this.f47316n = new ImageView(getContext());
        int i12 = this.f47315m;
        if (i12 == 2) {
            identifier = getResources().getIdentifier("mbridge_splash_btn_go", "drawable", c.m().g());
            layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 35.0f), ai.a(getContext(), 35.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = ai.a(getContext(), 10.0f);
        } else if (i12 == 1) {
            identifier = getResources().getIdentifier("mbridge_splash_btn_light", "drawable", c.m().g());
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin = 20;
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            layoutParams3.rightMargin = ai.a(getContext(), 50.0f);
            imageView.setImageResource(getResources().getIdentifier("mbridge_splash_btn_arrow_right", "drawable", c.m().g()));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(layoutParams3);
            addView(imageView);
        } else if (i12 == 3) {
            identifier = getResources().getIdentifier("mbridge_splash_btn_finger", "drawable", c.m().g());
            layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 25.0f), ai.a(getContext(), 25.0f));
            layoutParams.addRule(11);
            layoutParams.rightMargin = ai.a(getContext(), 50.0f);
            layoutParams.topMargin = ai.a(getContext(), 18.0f);
            this.f47317o = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ai.a(getContext(), 30.0f), ai.a(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = ai.a(getContext(), 50.0f);
            layoutParams4.topMargin = ai.a(getContext(), 5.0f);
            this.f47317o.setLayoutParams(layoutParams4);
            this.f47317o.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", c.m().g()));
            addView(this.f47317o);
        } else {
            layoutParams = null;
        }
        this.f47316n.setLayoutParams(layoutParams);
        this.f47316n.setImageResource(identifier);
        addView(textView);
        addView(this.f47316n);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i11 = this.f47315m;
        if (i11 == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.f47316n.startAnimation(scaleAnimation);
            return;
        }
        if (i11 == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.f47316n.setVisibility(4);
                    MBSplashClickView.this.f47316n.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.f47316n.startAnimation(animation);
                        }
                    }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f47316n.setVisibility(0);
                }
            });
            this.f47316n.startAnimation(translateAnimation);
            return;
        }
        if (i11 == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(400L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(200L);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.f47317o.setVisibility(4);
                    MBSplashClickView.this.f47317o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.f47317o.startAnimation(scaleAnimation3);
                        }
                    }, 700L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f47317o.setVisibility(0);
                }
            });
            this.f47317o.setVisibility(4);
            this.f47316n.startAnimation(scaleAnimation2);
            this.f47317o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MBSplashClickView.this.f47317o.startAnimation(scaleAnimation3);
                }
            }, 500L);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f47318p.set(0.0f, 0.0f, getWidth(), getHeight());
    }
}
