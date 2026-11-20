package com.transsion.player.longvideo.helper;

import android.animation.Animator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mmkv.MMKV;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
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
public final class LongVodLandForwardViewControl implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f54365b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<MMKV> f54366c = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.player.longvideo.helper.LongVodLandForwardViewControl$Companion$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("kv_video_double");
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mv.a f54367a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongVodLandForwardViewControl(mv.a bind) {
        Intrinsics.g(bind, "bind");
        this.f54367a = bind;
        bind.f71181b.addAnimatorListener(this);
        bind.f71182c.addAnimatorListener(this);
    }

    public final void a() {
        mv.a aVar = this.f54367a;
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

    public final void b(boolean z11) {
        boolean z12;
        mv.a aVar = this.f54367a;
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
        a();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.g(animation, "animation");
        a();
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
