package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBGradientAndShadowTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f43573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinearGradient f43577e;
    public float mShadowDx;
    public float mShadowDy;
    public float mShadowRadius;

    /* JADX INFO: compiled from: source.java */
    public static class GradientAndShadowParameters {
        public int gradientEndColor;
        public int gradientStartColor;
        public int shadowColor;
        public int textSize = 40;
        public float shadowRadius = 3.0f;
        public float shadowDx = 1.5f;
        public float shadowDy = 1.8f;
    }

    public MBGradientAndShadowTextView(Context context) {
        super(context);
        this.f43573a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f43574b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f43575c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f43576d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
        a();
    }

    public MBGradientAndShadowTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43573a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f43574b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f43575c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f43576d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
    }

    public MBGradientAndShadowTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43573a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f43574b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f43575c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f43576d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
    }

    public MBGradientAndShadowTextView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f43573a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f43574b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f43575c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f43576d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
    }

    public MBGradientAndShadowTextView(Context context, GradientAndShadowParameters gradientAndShadowParameters) {
        super(context);
        this.f43573a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
        this.f43574b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
        this.f43575c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
        this.f43576d = 40;
        this.mShadowRadius = 3.0f;
        this.mShadowDx = 1.5f;
        this.mShadowDy = 1.8f;
        if (gradientAndShadowParameters != null) {
            this.f43573a = gradientAndShadowParameters.gradientStartColor;
            this.f43574b = gradientAndShadowParameters.gradientEndColor;
            this.f43575c = gradientAndShadowParameters.shadowColor;
            this.f43576d = gradientAndShadowParameters.textSize;
            this.mShadowRadius = gradientAndShadowParameters.shadowRadius;
            this.mShadowDx = gradientAndShadowParameters.shadowDx;
            this.mShadowDy = gradientAndShadowParameters.shadowDy;
        }
        a();
    }

    private void a() {
        setTextSize(this.f43576d);
        setTypeface(Typeface.defaultFromStyle(3));
        this.f43577e = new LinearGradient(0.0f, 0.0f, 0.0f, getTextSize(), this.f43573a, this.f43574b, Shader.TileMode.CLAMP);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getPaint().setShader(null);
        getPaint().setShadowLayer(3.0f, 1.5f, 1.8f, this.f43575c);
        super.onDraw(canvas);
        getPaint().clearShadowLayer();
        getPaint().setShader(this.f43577e);
        super.onDraw(canvas);
    }
}
