package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ai;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBSplashShakeView extends MBLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f43393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f43394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f43395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f43396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f43397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f43398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f43399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Animation f43400h;

    public MBSplashShakeView(Context context) {
        super(context);
        this.f43393a = "浏览第三方应用";
        this.f43394b = "View";
        this.f43395c = "打开第三方应用";
        this.f43396d = "Open";
        this.f43397e = "下载第三方应用";
        this.f43398f = "Install";
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43393a = "浏览第三方应用";
        this.f43394b = "View";
        this.f43395c = "打开第三方应用";
        this.f43396d = "Open";
        this.f43397e = "下载第三方应用";
        this.f43398f = "Install";
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43393a = "浏览第三方应用";
        this.f43394b = "View";
        this.f43395c = "打开第三方应用";
        this.f43396d = "Open";
        this.f43397e = "下载第三方应用";
        this.f43398f = "Install";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0121  */
    /* JADX WARN: Code duplicated, block: B:33:0x013b  */
    /* JADX WARN: Code duplicated, block: B:34:0x013d  */
    /* JADX WARN: Code duplicated, block: B:6:0x00e1  */
    public void initView(String str) {
        byte b11 = 1;
        setOrientation(1);
        setGravity(1);
        View imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ai.a(getContext(), 80.0f), ai.a(getContext(), 80.0f)));
        int color = Color.parseColor("#60000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(200);
        imageView.setBackground(gradientDrawable);
        this.f43399g = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ai.a(getContext(), 40.0f), ai.a(getContext(), 40.0f));
        layoutParams.gravity = 17;
        this.f43399g.setLayoutParams(layoutParams);
        this.f43399g.setImageResource(getResources().getIdentifier("mbridge_cm_btn_shake", "drawable", c.m().g()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.f43399g);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ai.a(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setText("Shake your phone");
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str.hashCode()) {
                case -672744069:
                    if (!str.equals("Install")) {
                        b11 = -1;
                    } else {
                        b11 = 0;
                    }
                    break;
                case 2464362:
                    if (!str.equals("Open")) {
                        b11 = -1;
                    }
                    break;
                case 2666181:
                    if (!str.equals("View")) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                case 855294846:
                    if (!str.equals("下载第三方应用")) {
                        b11 = -1;
                    } else {
                        b11 = 3;
                    }
                    break;
                case 1383132195:
                    if (!str.equals("打开第三方应用")) {
                        b11 = -1;
                    } else {
                        b11 = 4;
                    }
                    break;
                case 1681333335:
                    if (!str.equals("浏览第三方应用")) {
                        b11 = -1;
                    } else {
                        b11 = 5;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    break;
                default:
                    if (!getContext().getResources().getConfiguration().locale.getLanguage().contains("zh")) {
                        str = "View";
                    } else {
                        str = "浏览第三方应用";
                    }
                    break;
            }
        } else if (!getContext().getResources().getConfiguration().locale.getLanguage().contains("zh")) {
            str = "浏览第三方应用";
        } else {
            str = "View";
        }
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = ai.a(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(str);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f43399g != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
            this.f43400h = rotateAnimation;
            rotateAnimation.setDuration(100L);
            this.f43400h.setRepeatMode(2);
            this.f43400h.setRepeatCount(-1);
            this.f43399g.startAnimation(this.f43400h);
        }
    }
}
