package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBSplashClickView extends MBRelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f43363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f43364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f43365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f43366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f43367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f43368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f43369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f43370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f43371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f43372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f43373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f43374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f43375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f43376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView f43377o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f43378p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final RectF f43379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Paint f43380r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Paint f43381s;

    public MBSplashClickView(Context context) {
        super(context);
        this.f43363a = "浏览第三方应用";
        this.f43364b = "View";
        this.f43365c = "打开第三方应用";
        this.f43366d = "Open";
        this.f43367e = "下载第三方应用";
        this.f43368f = "Install";
        this.f43369g = "mbridge_splash_btn_arrow_right";
        this.f43370h = "mbridge_splash_btn_circle";
        this.f43371i = "mbridge_splash_btn_finger";
        this.f43372j = "mbridge_splash_btn_go";
        this.f43373k = "mbridge_splash_btn_light";
        this.f43374l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f43379q = new RectF();
        this.f43380r = new Paint();
        this.f43381s = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43363a = "浏览第三方应用";
        this.f43364b = "View";
        this.f43365c = "打开第三方应用";
        this.f43366d = "Open";
        this.f43367e = "下载第三方应用";
        this.f43368f = "Install";
        this.f43369g = "mbridge_splash_btn_arrow_right";
        this.f43370h = "mbridge_splash_btn_circle";
        this.f43371i = "mbridge_splash_btn_finger";
        this.f43372j = "mbridge_splash_btn_go";
        this.f43373k = "mbridge_splash_btn_light";
        this.f43374l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f43379q = new RectF();
        this.f43380r = new Paint();
        this.f43381s = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43363a = "浏览第三方应用";
        this.f43364b = "View";
        this.f43365c = "打开第三方应用";
        this.f43366d = "Open";
        this.f43367e = "下载第三方应用";
        this.f43368f = "Install";
        this.f43369g = "mbridge_splash_btn_arrow_right";
        this.f43370h = "mbridge_splash_btn_circle";
        this.f43371i = "mbridge_splash_btn_finger";
        this.f43372j = "mbridge_splash_btn_go";
        this.f43373k = "mbridge_splash_btn_light";
        this.f43374l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.f43379q = new RectF();
        this.f43380r = new Paint();
        this.f43381s = new Paint();
        a();
    }

    private View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (viewGroup.getId() == str.hashCode()) {
                        return viewGroup;
                    }
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt.getId() == str.hashCode()) {
                            return childAt;
                        }
                        if (childAt instanceof ViewGroup) {
                            a((ViewGroup) childAt, str);
                        }
                    }
                    return null;
                }
            } catch (Exception e11) {
                ad.b("MBSplashClickView", e11.getMessage());
            }
        }
        return null;
    }

    private void a() {
        this.f43380r.setAntiAlias(true);
        this.f43380r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f43381s.setAntiAlias(true);
        this.f43381s.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f43379q, this.f43381s, 31);
        canvas.drawRoundRect(this.f43379q, 200.0f, 200.0f, this.f43381s);
        canvas.saveLayer(this.f43379q, this.f43380r, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0015  */
    public void initView(String str) {
        RelativeLayout.LayoutParams layoutParams;
        View viewA;
        this.f43375m = str;
        str.hashCode();
        final int identifier = 0;
        switch (str) {
            case "Install":
            case "下载第三方应用":
                this.f43376n = 3;
                break;
            case "Open":
            case "打开第三方应用":
                this.f43376n = 1;
                break;
            case "View":
            case "浏览第三方应用":
                this.f43376n = 2;
                break;
            default:
                boolean zContains = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
                if (TextUtils.isEmpty(this.f43375m)) {
                    this.f43375m = zContains ? "浏览第三方应用" : "View";
                }
                this.f43376n = 2;
                break;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        String string = (viewGroup == null || (viewA = a(viewGroup, "mbridge_expand_data")) == null || !(viewA instanceof TextView)) ? "" : ((TextView) viewA).getText().toString();
        int i11 = this.f43376n;
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
        textView.setText(this.f43375m);
        this.f43377o = new ImageView(getContext());
        int i12 = this.f43376n;
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
            this.f43378p = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ai.a(getContext(), 30.0f), ai.a(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = ai.a(getContext(), 50.0f);
            layoutParams4.topMargin = ai.a(getContext(), 5.0f);
            this.f43378p.setLayoutParams(layoutParams4);
            this.f43378p.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", c.m().g()));
            addView(this.f43378p);
        } else {
            layoutParams = null;
        }
        this.f43377o.setLayoutParams(layoutParams);
        if (TextUtils.isEmpty(string)) {
            this.f43377o.setImageResource(identifier);
        } else {
            final ImageView imageView2 = this.f43377o;
            if (imageView2 != null) {
                try {
                    if (TextUtils.isEmpty(string)) {
                        imageView2.setBackgroundResource(identifier);
                    }
                    b.a(c.m().c()).a(string, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.4
                        @Override // com.mbridge.msdk.foundation.same.c.c
                        public void onFailedLoad(String str2, String str3) {
                            ImageView imageView3 = imageView2;
                            if (imageView3 != null) {
                                imageView3.setBackgroundResource(identifier);
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.same.c.c
                        public void onSuccessLoad(Bitmap bitmap, String str2) {
                            if (imageView2 != null) {
                                if (bitmap == null || bitmap.isRecycled()) {
                                    imageView2.setBackgroundResource(identifier);
                                    return;
                                }
                                if (MBSplashClickView.this.f43378p != null) {
                                    MBSplashClickView mBSplashClickView = MBSplashClickView.this;
                                    mBSplashClickView.removeView(mBSplashClickView.f43378p);
                                }
                                imageView2.setImageBitmap(bitmap);
                            }
                        }
                    });
                } catch (Exception e11) {
                    ad.a("MBSplashClickView", e11.getMessage());
                    imageView2.setBackgroundResource(identifier);
                }
            }
        }
        addView(textView);
        addView(this.f43377o);
        invalidate();
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i11 = this.f43376n;
        if (i11 == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.f43377o.startAnimation(scaleAnimation);
            return;
        }
        if (i11 == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.f43377o.setVisibility(4);
                    MBSplashClickView.this.f43377o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MBSplashClickView.this.f43377o.startAnimation(animation);
                        }
                    }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f43377o.setVisibility(0);
                }
            });
            this.f43377o.startAnimation(translateAnimation);
            return;
        }
        if (i11 == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(1000L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(400L);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.f43378p.setVisibility(4);
                    MBSplashClickView.this.f43378p.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MBSplashClickView.this.f43378p.startAnimation(scaleAnimation3);
                        }
                    }, 1600L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.f43378p.setVisibility(0);
                }
            });
            this.f43378p.setVisibility(4);
            this.f43377o.startAnimation(scaleAnimation2);
            this.f43378p.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.2
                @Override // java.lang.Runnable
                public void run() {
                    MBSplashClickView.this.f43378p.startAnimation(scaleAnimation3);
                }
            }, 800L);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f43379q.set(0.0f, 0.0f, getWidth(), getHeight());
    }
}
