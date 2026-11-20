package com.mbridge.msdk.dycreator.baseview.cusview;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBridgeSegmentsProgressBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f43489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<ProgressBar> f43497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f43498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f43499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f43500l;

    public MBridgeSegmentsProgressBar(Context context) {
        super(context);
        this.f43489a = "MBridgeSegmentsProgressBar";
        this.f43491c = 1;
        this.f43492d = 20;
        this.f43493e = 10;
        this.f43494f = 1;
        this.f43495g = -1711276033;
        this.f43496h = -1;
        this.f43497i = new ArrayList();
        this.f43500l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43489a = "MBridgeSegmentsProgressBar";
        this.f43491c = 1;
        this.f43492d = 20;
        this.f43493e = 10;
        this.f43494f = 1;
        this.f43495g = -1711276033;
        this.f43496h = -1;
        this.f43497i = new ArrayList();
        this.f43500l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43489a = "MBridgeSegmentsProgressBar";
        this.f43491c = 1;
        this.f43492d = 20;
        this.f43493e = 10;
        this.f43494f = 1;
        this.f43495g = -1711276033;
        this.f43496h = -1;
        this.f43497i = new ArrayList();
        this.f43500l = false;
    }

    public MBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f43489a = "MBridgeSegmentsProgressBar";
        this.f43491c = 1;
        this.f43492d = 20;
        this.f43493e = 10;
        this.f43494f = 1;
        this.f43495g = -1711276033;
        this.f43496h = -1;
        this.f43497i = new ArrayList();
        this.f43500l = false;
    }

    private StringBuilder a(int i11) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(String.format(this.f43499k, Integer.valueOf(i11), Integer.valueOf(this.f43490b)));
        } catch (Throwable th2) {
            sb2.append(this.f43490b);
            sb2.append("videos, the");
            sb2.append(i11);
            sb2.append(" is playing.");
            ad.b("MBridgeSegmentsProgressBar", th2.getMessage());
        }
        return sb2;
    }

    private void a() {
        Drawable drawable;
        try {
            this.f43500l = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th2) {
            ad.b("MBridgeSegmentsProgressBar", th2.getMessage());
        }
        try {
            if (this.f43491c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.f43499k)) {
                    this.f43499k = this.f43500l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.f43491c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.f43499k)) {
                    this.f43499k = this.f43500l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.f43497i.clear();
            removeAllViews();
            setBackground(c());
            TextView textView = new TextView(getContext());
            this.f43498j = textView;
            textView.setTextColor(-1);
            this.f43498j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f43498j.setLayoutParams(layoutParams);
            if (this.f43491c == 1) {
                layoutParams.gravity = 5;
                TextView textView2 = this.f43498j;
                int i11 = this.f43492d;
                textView2.setPadding(i11 / 2, 15, i11 / 2, 5);
            }
            if (this.f43491c == 2) {
                this.f43498j.setGravity(16);
                TextView textView3 = this.f43498j;
                int i12 = this.f43492d;
                textView3.setPadding(i12 / 2, 0, i12 / 2, 0);
            }
            try {
                int iA = v.a(getContext(), "mbridge_reward_video_icon", "drawable");
                if (iA != 0 && (drawable = getContext().getResources().getDrawable(iA)) != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f43498j.setCompoundDrawables(drawable, null, null, null);
                    this.f43498j.setCompoundDrawablePadding(5);
                }
            } catch (Throwable th3) {
                ad.b("MBridgeSegmentsProgressBar", th3.getMessage());
            }
            this.f43498j.setText(a(this.f43494f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
            linearLayout.setLayoutParams(layoutParams2);
            for (int i13 = 0; i13 < this.f43490b; i13++) {
                ProgressBar progressBar = new ProgressBar(getContext(), null, R.attr.progressBarStyleHorizontal);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                progressBar.setProgressDrawable(b());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
                int i14 = this.f43492d;
                layoutParams3.leftMargin = i14 / 2;
                layoutParams3.rightMargin = i14 / 2;
                progressBar.setLayoutParams(layoutParams3);
                linearLayout.addView(progressBar);
                this.f43497i.add(progressBar);
            }
            int i15 = this.f43491c;
            if (i15 == 1) {
                setPadding(15, 10, 15, 25);
                addView(this.f43498j);
                addView(linearLayout);
            } else {
                if (i15 != 2) {
                    addView(linearLayout);
                    return;
                }
                setPadding(15, 0, 15, 25);
                layoutParams2.gravity = 16;
                layoutParams2.weight = 1.0f;
                addView(linearLayout);
                addView(this.f43498j);
            }
        } catch (Throwable th4) {
            ad.b("MBridgeSegmentsProgressBar", th4.getMessage());
        }
    }

    private LayerDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.f43493e);
        gradientDrawable.setColor(this.f43495g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(this.f43493e);
        gradientDrawable2.setColor(this.f43496h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }

    private GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setDither(true);
        gradientDrawable.setColors(new int[]{0, 1291845632});
        return gradientDrawable;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeSegmentsProgressBar.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public void init(int i11, int i12) {
        this.f43490b = i11;
        this.f43491c = i12;
        a();
    }

    public void init(int i11, int i12, int i13, int i14) {
        this.f43490b = i11;
        this.f43491c = i12;
        this.f43496h = i13;
        this.f43495g = i14;
        a();
    }

    public void init(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f43490b = i11;
        this.f43491c = i12;
        this.f43496h = i13;
        this.f43495g = i14;
        this.f43492d = i15;
        this.f43493e = i16;
        a();
    }

    public void setIndicatorText(String str) {
        this.f43499k = str;
    }

    public void setProgress(int i11, int i12) {
        try {
            if (this.f43497i.size() == 0) {
                return;
            }
            if (i12 < this.f43497i.size()) {
                this.f43497i.get(i12).setProgress(i11);
            }
            int i13 = i12 + 1;
            if (i13 > this.f43494f) {
                this.f43494f = i13;
                TextView textView = this.f43498j;
                if (textView != null) {
                    textView.setText(a(i13));
                }
            }
        } catch (Throwable th2) {
            ad.b("MBridgeSegmentsProgressBar", th2.getMessage());
        }
    }
}
