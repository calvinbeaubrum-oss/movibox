package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.widget.TextView;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f55242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f55243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f55244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55245d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f55246e = new Runnable() { // from class: com.transsion.postdetail.layer.local.d0
        @Override // java.lang.Runnable
        public final void run() {
            f0.e(this.f55238a);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f55247f = new Runnable() { // from class: com.transsion.postdetail.layer.local.e0
        @Override // java.lang.Runnable
        public final void run() {
            f0.f(this.f55240a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f55249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f55250c;

        public a(TextView textView, String str) {
            this.f55249b = textView;
            this.f55250c = str;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.g(animation, "animation");
            f0.this.f55244c = System.currentTimeMillis();
            TextView textView = this.f55249b;
            if (textView != null) {
                so.c.k(textView);
            }
            TextView textView2 = this.f55249b;
            if (textView2 == null) {
                return;
            }
            textView2.setText(this.f55250c);
        }
    }

    public f0(TextView textView, TextView textView2) {
        this.f55242a = textView;
        this.f55243b = textView2;
    }

    public static final void e(f0 this$0) {
        Intrinsics.g(this$0, "this$0");
        TextView textView = this$0.f55242a;
        if (textView != null) {
            so.c.g(textView);
        }
    }

    public static final void f(f0 this$0) {
        Intrinsics.g(this$0, "this$0");
        TextView textView = this$0.f55243b;
        if (textView != null) {
            so.c.g(textView);
        }
    }

    public static /* synthetic */ void i(f0 f0Var, String str, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 3000;
        }
        f0Var.h(str, j11);
    }

    public final void d() {
        TextView textView = this.f55242a;
        if (textView != null) {
            so.c.g(textView);
        }
        TextView textView2 = this.f55243b;
        if (textView2 != null) {
            so.c.g(textView2);
        }
    }

    public final void g(String str, long j11, TextView textView, long j12, Runnable runnable) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        if (textView != null) {
            so.c.g(textView);
        }
        objectAnimatorOfFloat.addListener(new a(textView, str));
        objectAnimatorOfFloat.setStartDelay(j11);
        objectAnimatorOfFloat.start();
        if (j12 <= 0 || textView == null) {
            return;
        }
        textView.postDelayed(runnable, j12);
    }

    public final void h(String content, long j11) {
        TextView textView;
        Intrinsics.g(content, "content");
        TextView textView2 = this.f55242a;
        if (textView2 != null && so.c.i(textView2) && (textView = this.f55243b) != null && so.c.i(textView)) {
            int i11 = this.f55245d;
            TextView textView3 = i11 == 1 ? this.f55243b : this.f55242a;
            Runnable runnable = i11 == 1 ? this.f55247f : this.f55246e;
            textView3.removeCallbacks(runnable);
            g(content, 0L, textView3, j11, runnable);
            this.f55245d = this.f55245d != 1 ? 1 : 2;
            return;
        }
        TextView textView4 = this.f55242a;
        if (textView4 == null || !so.c.i(textView4)) {
            this.f55245d = 1;
            g(content, 0L, this.f55242a, j11, this.f55246e);
        } else {
            long j12 = System.currentTimeMillis() - this.f55244c < 500 ? 500L : 0L;
            this.f55245d = 2;
            g(content, j12, this.f55243b, j11, this.f55247f);
        }
    }
}
