package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mmkv.MMKV;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LongVodMiddleForwardViewControl implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f55227b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<MMKV> f55228c = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.postdetail.layer.local.LongVodMiddleForwardViewControl$Companion$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("kv_video_double");
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mv.a f55229a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void g(View view, final Function0 delayRunnable, View view2) {
            Intrinsics.g(view, "$view");
            Intrinsics.g(delayRunnable, "$delayRunnable");
            LongVodMiddleForwardViewControl.f55227b.k(view);
            view.removeCallbacks(new Runnable() { // from class: com.transsion.postdetail.layer.local.i0
                @Override // java.lang.Runnable
                public final void run() {
                    LongVodMiddleForwardViewControl.Companion.h(delayRunnable);
                }
            });
        }

        public static final void h(Function0 tmp0) {
            Intrinsics.g(tmp0, "$tmp0");
            tmp0.invoke();
        }

        public static final void i(Function0 tmp0) {
            Intrinsics.g(tmp0, "$tmp0");
            tmp0.invoke();
        }

        public static final void l(View view) {
            Intrinsics.g(view, "$view");
            so.c.g(view);
        }

        public final void f(mv.i iVar) {
            final View viewInflate;
            mv.k kVar;
            ViewStub viewStub;
            if (j().getBoolean("video_show_guide", false)) {
                return;
            }
            if (((iVar == null || (kVar = iVar.f71243p) == null || (viewStub = kVar.f71292o) == null) ? null : viewStub.getParent()) == null || (viewInflate = iVar.f71243p.f71292o.inflate()) == null) {
                return;
            }
            LongVodMiddleForwardViewControl.f55227b.j().putBoolean("video_show_guide", true);
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.transsion.postdetail.layer.local.LongVodMiddleForwardViewControl$Companion$cheToShowDoubleTapGuideView$1$delayRunnable$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LongVodMiddleForwardViewControl.f55227b.k(viewInflate);
                }
            };
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodMiddleForwardViewControl.Companion.g(viewInflate, function0, view);
                }
            });
            viewInflate.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.h0
                @Override // java.lang.Runnable
                public final void run() {
                    LongVodMiddleForwardViewControl.Companion.i(function0);
                }
            }, 3000L);
        }

        public final MMKV j() {
            Object value = LongVodMiddleForwardViewControl.f55228c.getValue();
            Intrinsics.f(value, "<get-mmkv>(...)");
            return (MMKV) value;
        }

        public final void k(final View view) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            viewPropertyAnimatorAnimate.setDuration(300L);
            viewPropertyAnimatorAnimate.alpha(0.0f);
            viewPropertyAnimatorAnimate.withEndAction(new Runnable() { // from class: com.transsion.postdetail.layer.local.j0
                @Override // java.lang.Runnable
                public final void run() {
                    LongVodMiddleForwardViewControl.Companion.l(view);
                }
            }).start();
        }
    }

    public LongVodMiddleForwardViewControl(mv.a bind) {
        Intrinsics.g(bind, "bind");
        this.f55229a = bind;
        bind.f71181b.addAnimatorListener(this);
        bind.f71182c.addAnimatorListener(this);
    }

    public final void b() {
        mv.a aVar = this.f55229a;
        VideoDoubleClickBackgroundView vDoubleClick = aVar.f71185g;
        Intrinsics.f(vDoubleClick, "vDoubleClick");
        so.c.g(vDoubleClick);
        AppCompatTextView tvDoubleClickLeft = aVar.f71183d;
        Intrinsics.f(tvDoubleClickLeft, "tvDoubleClickLeft");
        so.c.g(tvDoubleClickLeft);
        AppCompatTextView tvDoubleClickRight = aVar.f71184f;
        Intrinsics.f(tvDoubleClickRight, "tvDoubleClickRight");
        so.c.g(tvDoubleClickRight);
        LottieAnimationView lottieDoubleClickLeft = aVar.f71181b;
        Intrinsics.f(lottieDoubleClickLeft, "lottieDoubleClickLeft");
        so.c.g(lottieDoubleClickLeft);
        LottieAnimationView lottieDoubleClickRight = aVar.f71182c;
        Intrinsics.f(lottieDoubleClickRight, "lottieDoubleClickRight");
        so.c.g(lottieDoubleClickRight);
        aVar.f71181b.pauseAnimation();
        aVar.f71182c.pauseAnimation();
        ConstraintLayout root = aVar.getRoot();
        Intrinsics.f(root, "root");
        so.c.g(root);
    }

    public final void c(boolean z11) {
        boolean z12;
        mv.a aVar = this.f55229a;
        VideoDoubleClickBackgroundView vDoubleClick = aVar.f71185g;
        Intrinsics.f(vDoubleClick, "vDoubleClick");
        so.c.k(vDoubleClick);
        boolean zF = so.c.f();
        if (zF) {
            z12 = z11;
        } else {
            z12 = !z11;
        }
        aVar.f71185g.setLeftStyle(z12);
        if (z11) {
            if (zF) {
                aVar.f71182c.setScaleX(-1.0f);
            }
            AppCompatTextView tvDoubleClickRight = aVar.f71184f;
            Intrinsics.f(tvDoubleClickRight, "tvDoubleClickRight");
            so.c.k(tvDoubleClickRight);
            LottieAnimationView lottieDoubleClickRight = aVar.f71182c;
            Intrinsics.f(lottieDoubleClickRight, "lottieDoubleClickRight");
            so.c.k(lottieDoubleClickRight);
            aVar.f71182c.playAnimation();
        } else {
            if (zF) {
                aVar.f71181b.setScaleX(-1.0f);
            }
            AppCompatTextView tvDoubleClickLeft = aVar.f71183d;
            Intrinsics.f(tvDoubleClickLeft, "tvDoubleClickLeft");
            so.c.k(tvDoubleClickLeft);
            LottieAnimationView lottieDoubleClickLeft = aVar.f71181b;
            Intrinsics.f(lottieDoubleClickLeft, "lottieDoubleClickLeft");
            so.c.k(lottieDoubleClickLeft);
            aVar.f71181b.playAnimation();
        }
        ConstraintLayout root = aVar.getRoot();
        Intrinsics.f(root, "root");
        so.c.k(root);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.g(animation, "animation");
        b();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.g(animation, "animation");
        b();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.g(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.g(animation, "animation");
    }
}
