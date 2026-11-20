package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.j0;
import com.cloud.tmc.miniutils.util.x;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MiniappLaunchLoadingView extends ConstraintLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public TranslateAnimation f31838OooO;
    public AppCompatImageView OooO00o;
    public LinearLayoutCompat OooO0O0;
    public Integer OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final String f31839OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public boolean f31840OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public int f31841OooO0o0;
    public boolean OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public AnimationSet f31842OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final Runnable f31843OooOO0;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (MiniappLaunchLoadingView.this.getRepeatCount() >= 4) {
                MiniappLaunchLoadingView.this.setRepeatCount(1);
            } else {
                MiniappLaunchLoadingView miniappLaunchLoadingView = MiniappLaunchLoadingView.this;
                miniappLaunchLoadingView.setRepeatCount(miniappLaunchLoadingView.getRepeatCount() + 1);
            }
            if (MiniappLaunchLoadingView.this.getRepeatAnimation()) {
                com.cloud.tmc.kernel.utils.e.g(MiniappLaunchLoadingView.this.getAnimationRunnable(), 300L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (MiniappLaunchLoadingView.this.getRepeatCount() != 0) {
                float f11 = j0.a() ? -90.0f : 90.0f;
                AppCompatImageView appCompatImageView = MiniappLaunchLoadingView.this.OooO00o;
                if (appCompatImageView == null) {
                    Intrinsics.y("mLoadingImg");
                    appCompatImageView = null;
                }
                appCompatImageView.setRotation(MiniappLaunchLoadingView.this.getRepeatCount() * f11);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.OooO0OO = 1;
        this.f31839OooO0Oo = "MiniappLaunchLoadingView";
        this.OooO0oO = true;
        this.f31843OooOO0 = new Runnable() { // from class: com.cloud.tmc.miniapp.widget.j
            @Override // java.lang.Runnable
            public final void run() {
                MiniappLaunchLoadingView.OooO00o(this.f31899a);
            }
        };
    }

    public /* synthetic */ MiniappLaunchLoadingView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public static final void OooO00o(MiniappLaunchLoadingView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.OooO00o();
    }

    public static final void OooO0O0(MiniappLaunchLoadingView this$0) {
        float fA;
        Intrinsics.g(this$0, "this$0");
        LinearLayoutCompat linearLayoutCompat = null;
        if (this$0.f31841OooO0o0 == 0) {
            AppCompatImageView appCompatImageView = this$0.OooO00o;
            if (appCompatImageView == null) {
                Intrinsics.y("mLoadingImg");
                appCompatImageView = null;
            }
            appCompatImageView.setRotation(0.0f);
            this$0.OooO0oO = true;
        }
        this$0.f31840OooO0o = true;
        if (this$0.f31842OooO0oo == null) {
            this$0.f31842OooO0oo = new AnimationSet(false);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, j0.a() ? -90.0f : 90.0f, 1, j0.a() ? 0.0f : 1.0f, 1, 1.0f);
            AppCompatImageView appCompatImageView2 = this$0.OooO00o;
            if (appCompatImageView2 == null) {
                Intrinsics.y("mLoadingImg");
                appCompatImageView2 = null;
            }
            float width = appCompatImageView2.getWidth();
            if (width == 0.0f) {
                try {
                    fA = x.a(72.0f);
                } catch (Throwable unused) {
                    fA = 0.0f;
                }
            } else {
                fA = width;
            }
            TmcLogger.c(this$0.f31839OooO0Oo, "img width " + width + " is " + fA);
            if (!j0.a()) {
                fA = -fA;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, fA, 0.0f, 0.0f);
            AnimationSet animationSet = this$0.f31842OooO0oo;
            if (animationSet != null) {
                animationSet.setFillAfter(true);
            }
            AnimationSet animationSet2 = this$0.f31842OooO0oo;
            if (animationSet2 != null) {
                animationSet2.setDuration(500L);
            }
            AnimationSet animationSet3 = this$0.f31842OooO0oo;
            if (animationSet3 != null) {
                animationSet3.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            AnimationSet animationSet4 = this$0.f31842OooO0oo;
            if (animationSet4 != null) {
                animationSet4.addAnimation(rotateAnimation);
            }
            AnimationSet animationSet5 = this$0.f31842OooO0oo;
            if (animationSet5 != null) {
                animationSet5.addAnimation(translateAnimation);
            }
            AnimationSet animationSet6 = this$0.f31842OooO0oo;
            if (animationSet6 != null) {
                animationSet6.setAnimationListener(this$0.new a());
            }
        }
        AppCompatImageView appCompatImageView3 = this$0.OooO00o;
        if (appCompatImageView3 == null) {
            Intrinsics.y("mLoadingImg");
            appCompatImageView3 = null;
        }
        appCompatImageView3.startAnimation(this$0.f31842OooO0oo);
        float fA2 = xb.a.a(68.0f);
        if (this$0.f31838OooO == null) {
            if (!j0.a()) {
                fA2 = -fA2;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, fA2, 0.0f, 0.0f);
            this$0.f31838OooO = translateAnimation2;
            translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
            TranslateAnimation translateAnimation3 = this$0.f31838OooO;
            if (translateAnimation3 != null) {
                translateAnimation3.setDuration(500L);
            }
            TranslateAnimation translateAnimation4 = this$0.f31838OooO;
            if (translateAnimation4 != null) {
                translateAnimation4.setFillAfter(true);
            }
        }
        TranslateAnimation translateAnimation5 = this$0.f31838OooO;
        if (translateAnimation5 != null) {
            translateAnimation5.start();
        }
        LinearLayoutCompat linearLayoutCompat2 = this$0.OooO0O0;
        if (linearLayoutCompat2 == null) {
            Intrinsics.y("llBottom");
        } else {
            linearLayoutCompat = linearLayoutCompat2;
        }
        linearLayoutCompat.startAnimation(this$0.f31838OooO);
    }

    public final void OooO00o() {
        try {
            AppCompatImageView appCompatImageView = this.OooO00o;
            if (appCompatImageView == null) {
                Intrinsics.y("mLoadingImg");
                appCompatImageView = null;
            }
            appCompatImageView.post(new Runnable() { // from class: com.cloud.tmc.miniapp.widget.k
                @Override // java.lang.Runnable
                public final void run() {
                    MiniappLaunchLoadingView.OooO0O0(this.f31900a);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.h(this.f31839OooO0Oo, th2);
        }
    }

    public final Runnable getAnimationRunnable() {
        return this.f31843OooOO0;
    }

    public final boolean getAnimationRunning() {
        return this.f31840OooO0o;
    }

    public final AnimationSet getAnimationSet() {
        return this.f31842OooO0oo;
    }

    public final boolean getRepeatAnimation() {
        return this.OooO0oO;
    }

    public final int getRepeatCount() {
        return this.f31841OooO0o0;
    }

    public final TranslateAnimation getSquareTranslate() {
        return this.f31838OooO;
    }

    public final void setAnimationRunning(boolean z11) {
        this.f31840OooO0o = z11;
    }

    public final void setAnimationSet(AnimationSet animationSet) {
        this.f31842OooO0oo = animationSet;
    }

    public final void setRepeatAnimation(boolean z11) {
        this.OooO0oO = z11;
    }

    public final void setRepeatCount(int i11) {
        this.f31841OooO0o0 = i11;
    }

    public final void setSquareTranslate(TranslateAnimation translateAnimation) {
        this.f31838OooO = translateAnimation;
    }
}
