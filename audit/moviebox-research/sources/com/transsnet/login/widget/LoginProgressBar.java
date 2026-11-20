package com.transsnet.login.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.transsnet.login.widget.LoginProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LoginProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f61679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f61680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f61681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f61682d;

    public LoginProgressBar(Context context) {
        super(context);
        this.f61682d = 400L;
    }

    public LoginProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61682d = 400L;
    }

    public LoginProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f61682d = 400L;
    }

    public LoginProgressBar(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f61682d = 400L;
    }

    public static final void c(LoginProgressBar this$0, ValueAnimator it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.setProgress(((Integer) animatedValue).intValue());
    }

    public static final void d(LoginProgressBar this$0, ValueAnimator it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.setProgress(((Integer) animatedValue).intValue());
    }

    public final int getEndProgress() {
        return this.f61680b;
    }

    public final int getStartProgress() {
        return this.f61679a;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f61681c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void setEndProgress(int i11) {
        this.f61680b = i11;
    }

    public final void setProgress(int i11, int i12) {
        this.f61679a = i11;
        this.f61680b = i12;
        setProgress(i11);
    }

    public final void setStartProgress(int i11) {
        this.f61679a = i11;
    }

    public final void startProgressIncrease() {
        ValueAnimator valueAnimator = this.f61681c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        setProgress(this.f61679a);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f61679a, this.f61680b);
        valueAnimatorOfInt.setDuration(this.f61682d);
        valueAnimatorOfInt.setStartDelay(this.f61682d);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: q00.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                LoginProgressBar.c(this.f74119a, valueAnimator2);
            }
        });
        this.f61681c = valueAnimatorOfInt;
        valueAnimatorOfInt.start();
    }

    public final void startProgressReduce() {
        ValueAnimator valueAnimator = this.f61681c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        setProgress(this.f61680b);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f61680b, this.f61679a);
        valueAnimatorOfInt.setDuration(this.f61682d);
        valueAnimatorOfInt.setStartDelay(this.f61682d);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: q00.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                LoginProgressBar.d(this.f74120a, valueAnimator2);
            }
        });
        this.f61681c = valueAnimatorOfInt;
        valueAnimatorOfInt.start();
    }
}
