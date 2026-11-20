package com.transsion.postdetail.layer.local;

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
public final class LocalVideoMiddleForwardViewControl implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f55211b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<MMKV> f55212c = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.postdetail.layer.local.LocalVideoMiddleForwardViewControl$Companion$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("kv_video_double");
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tv.x f55213a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LocalVideoMiddleForwardViewControl(tv.x bind) {
        Intrinsics.g(bind, "bind");
        this.f55213a = bind;
        bind.f78007b.addAnimatorListener(this);
        bind.f78008c.addAnimatorListener(this);
    }

    public final void a() {
        tv.x xVar = this.f55213a;
        VideoDoubleClickBackgroundView vDoubleClick = xVar.f78011g;
        Intrinsics.f(vDoubleClick, "vDoubleClick");
        so.c.g(vDoubleClick);
        AppCompatTextView tvDoubleClickLeft = xVar.f78009d;
        Intrinsics.f(tvDoubleClickLeft, "tvDoubleClickLeft");
        so.c.g(tvDoubleClickLeft);
        AppCompatTextView tvDoubleClickRight = xVar.f78010f;
        Intrinsics.f(tvDoubleClickRight, "tvDoubleClickRight");
        so.c.g(tvDoubleClickRight);
        LottieAnimationView lottieDoubleClickLeft = xVar.f78007b;
        Intrinsics.f(lottieDoubleClickLeft, "lottieDoubleClickLeft");
        so.c.g(lottieDoubleClickLeft);
        LottieAnimationView lottieDoubleClickRight = xVar.f78008c;
        Intrinsics.f(lottieDoubleClickRight, "lottieDoubleClickRight");
        so.c.g(lottieDoubleClickRight);
        xVar.f78007b.pauseAnimation();
        xVar.f78008c.pauseAnimation();
        ConstraintLayout root = xVar.getRoot();
        Intrinsics.f(root, "root");
        so.c.g(root);
    }

    public final void b(boolean z11) {
        tv.x xVar = this.f55213a;
        VideoDoubleClickBackgroundView vDoubleClick = xVar.f78011g;
        Intrinsics.f(vDoubleClick, "vDoubleClick");
        so.c.k(vDoubleClick);
        xVar.f78011g.setLeftStyle(!z11);
        if (z11) {
            AppCompatTextView tvDoubleClickRight = xVar.f78010f;
            Intrinsics.f(tvDoubleClickRight, "tvDoubleClickRight");
            so.c.k(tvDoubleClickRight);
            LottieAnimationView lottieDoubleClickRight = xVar.f78008c;
            Intrinsics.f(lottieDoubleClickRight, "lottieDoubleClickRight");
            so.c.k(lottieDoubleClickRight);
            xVar.f78008c.playAnimation();
        } else {
            AppCompatTextView tvDoubleClickLeft = xVar.f78009d;
            Intrinsics.f(tvDoubleClickLeft, "tvDoubleClickLeft");
            so.c.k(tvDoubleClickLeft);
            LottieAnimationView lottieDoubleClickLeft = xVar.f78007b;
            Intrinsics.f(lottieDoubleClickLeft, "lottieDoubleClickLeft");
            so.c.k(lottieDoubleClickLeft);
            xVar.f78007b.playAnimation();
        }
        ConstraintLayout root = xVar.getRoot();
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
