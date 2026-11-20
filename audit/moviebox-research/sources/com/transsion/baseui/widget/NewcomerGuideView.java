package com.transsion.baseui.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.d;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$bool;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import com.transsion.baseui.widget.NewcomerGuideView;
import fs.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import uo.b;
import z2.a;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NewcomerGuideView extends ConstraintLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f51504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f51505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51506d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f51508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f51509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f51510i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewcomerGuideView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewcomerGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewcomerGuideView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51503a = "NewcomerGuide";
        this.f51506d = d0.e();
        this.f51507f = d0.c() - d.c();
        this.f51508g = f0.a(16.0f);
        this.f51509h = f0.a(40.0f);
        this.f51510i = f0.a(200.0f);
        View.inflate(context, R$layout.layout_newcomer_guide, this);
        setBackgroundResource(R$color.cl31_70_p);
        c cVarA = c.a(this);
        Intrinsics.f(cVarA, "bind(this)");
        this.f51504b = cVarA;
    }

    public static final void e(GradientDrawable shapeDrawable, int i11, int i12, ViewGroup.LayoutParams layoutParams, int i13, int i14, int i15, int i16, NewcomerGuideView this$0, ValueAnimator animation) {
        Intrinsics.g(shapeDrawable, "$shapeDrawable");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        shapeDrawable.setColor(iIntValue);
        float f11 = ((i11 - iIntValue) * 1.0f) / (i11 - i12);
        layoutParams.width = i13 + ((int) ((i14 - i13) * f11));
        layoutParams.height = i15 + ((int) ((i16 - i15) * f11));
        this$0.f51504b.f65261g.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void setTargetView$default(NewcomerGuideView newcomerGuideView, View view, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        newcomerGuideView.setTargetView(view, i11, i12, i13);
    }

    public final Bitmap b(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.f(bitmapCreateBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.draw(canvas);
        canvas.save();
        return bitmapCreateBitmap;
    }

    public final void c(final int i11, final int i12, final int i13, final int i14) {
        final int color = a.getColor(getContext(), R$color.cl38_50_p);
        final int i15 = 0;
        Drawable background = this.f51504b.f65261g.getBackground();
        Intrinsics.e(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        final GradientDrawable gradientDrawable = (GradientDrawable) background;
        final ViewGroup.LayoutParams layoutParams = this.f51504b.f65261g.getLayoutParams();
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(color), 0);
        this.f51505c = valueAnimatorOfObject;
        if (valueAnimatorOfObject != null) {
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: is.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NewcomerGuideView.e(gradientDrawable, color, i15, layoutParams, i11, i13, i12, i14, this, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.f51505c;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator2 = this.f51505c;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
        ValueAnimator valueAnimator3 = this.f51505c;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ValueAnimator valueAnimator;
        super.onAttachedToWindow();
        ValueAnimator valueAnimator2 = this.f51505c;
        if (valueAnimator2 == null || valueAnimator2.isStarted() || (valueAnimator = this.f51505c) == null) {
            return;
        }
        valueAnimator.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f51505c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void setSetBgColor(int i11) {
        Drawable background = this.f51504b.f65262h.getBackground();
        Intrinsics.e(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(i11);
    }

    public final void setTargetView(View targetView, int i11, int i12, int i13) {
        String str;
        Intrinsics.g(targetView, "targetView");
        int[] iArr = new int[2];
        targetView.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = this.f51504b.f65258c.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = targetView.getMeasuredHeight();
        ((ViewGroup.MarginLayoutParams) bVar).width = targetView.getMeasuredWidth();
        bVar.f7293i = 0;
        Bitmap bitmapB = b(targetView);
        if (bitmapB != null) {
            b.a.f(b.f78622a, this.f51503a, "setImageBitmap  step = " + i11, false, 4, null);
            this.f51504b.f65258c.setImageBitmap(bitmapB);
        }
        ViewGroup.LayoutParams layoutParams2 = this.f51504b.f65260f.getLayoutParams();
        Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        ViewGroup.LayoutParams layoutParams3 = this.f51504b.f65257b.getLayoutParams();
        Intrinsics.e(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams3;
        ViewGroup.LayoutParams layoutParams4 = this.f51504b.f65259d.getLayoutParams();
        Intrinsics.e(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams4;
        boolean z11 = !getContext().getResources().getBoolean(R$bool.is_rtl);
        boolean z12 = this.f51506d / 2 > iArr[0] + (targetView.getMeasuredWidth() / 2);
        if (z11 && z12) {
            b.a.f(b.f78622a, this.f51503a, "location start", false, 4, null);
            bVar.f7315t = 0;
            bVar2.f7315t = 0;
            bVar.setMarginStart(iArr[0]);
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = iArr[1];
        } else {
            b.a.f(b.f78622a, this.f51503a, "location end", false, 4, null);
            bVar.f7319v = 0;
            bVar2.f7319v = 0;
            bVar.setMarginEnd(z11 ? (this.f51506d - iArr[0]) - targetView.getMeasuredWidth() : iArr[0]);
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = iArr[1];
        }
        if (this.f51507f - iArr[1] < this.f51510i) {
            this.f51504b.f65257b.setScaleY(-1.0f);
            bVar3.f7297k = R$id.v_guide_bg;
            bVar2.f7297k = R$id.iv_guide_line;
            bVar4.f7297k = R$id.tv_guide_tips;
        } else {
            bVar3.f7295j = R$id.v_guide_bg;
            bVar2.f7295j = R$id.iv_guide_line;
            bVar4.f7295j = R$id.tv_guide_tips;
        }
        this.f51504b.f65259d.setLayoutParams(bVar4);
        this.f51504b.f65257b.setLayoutParams(bVar3);
        this.f51504b.f65258c.setLayoutParams(bVar);
        this.f51504b.f65260f.setLayoutParams(bVar2);
        ViewGroup.LayoutParams layoutParams5 = this.f51504b.f65262h.getLayoutParams();
        Intrinsics.e(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar5 = (ConstraintLayout.b) layoutParams5;
        ((ViewGroup.MarginLayoutParams) bVar5).height = targetView.getMeasuredHeight() + (i13 > 0 ? i13 : this.f51508g);
        ((ViewGroup.MarginLayoutParams) bVar5).width = targetView.getMeasuredWidth() + (i13 > 0 ? i13 : this.f51508g);
        this.f51504b.f65262h.setLayoutParams(bVar5);
        AppCompatImageView appCompatImageView = this.f51504b.f65258c;
        Intrinsics.f(appCompatImageView, "viewBinding.ivGuideTarget");
        so.c.k(appCompatImageView);
        AppCompatImageView appCompatImageView2 = this.f51504b.f65257b;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivGuideLine");
        so.c.k(appCompatImageView2);
        AppCompatTextView appCompatTextView = this.f51504b.f65260f;
        Intrinsics.f(appCompatTextView, "viewBinding.tvGuideTips");
        so.c.k(appCompatTextView);
        AppCompatTextView appCompatTextView2 = this.f51504b.f65259d;
        Intrinsics.f(appCompatTextView2, "viewBinding.tvGuideButton");
        so.c.k(appCompatTextView2);
        if (i11 < i12) {
            str = "Next " + i11 + "/" + i12;
        } else if (i12 == 1) {
            str = "Done";
        } else {
            str = "Done " + i11 + "/" + i12;
        }
        String str2 = str;
        if (i12 > 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, StringsKt__StringsKt.d0(str2, "/", 0, false, 6, null), 17);
            this.f51504b.f65259d.setText(spannableStringBuilder);
        } else {
            this.f51504b.f65259d.setText(str2);
        }
        int i14 = ((ViewGroup.MarginLayoutParams) bVar5).width;
        int i15 = ((ViewGroup.MarginLayoutParams) bVar5).height;
        int i16 = this.f51509h;
        c(i14, i15, i14 + i16, i16 + i15);
        b.a.f(b.f78622a, this.f51503a, "screenWidth = " + this.f51506d + ", X = " + iArr[0] + ", screenHeight = " + this.f51507f + ", Y = " + iArr[1] + ", width = " + targetView.getWidth() + ", isLeft = " + z12 + ", ltr = " + z11, false, 4, null);
    }

    public final void setTipsText(int i11) {
        this.f51504b.f65260f.setText(getContext().getString(i11));
    }
}
