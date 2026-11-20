package com.transsion.moviedetail.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.u;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.transsion.moviedetail.R$mipmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class MovieDetailShareView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f53813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f53814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f53815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f53816d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f53817f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f53818a;

        public a() {
        }

        public static final void c(Function0 tmp0) {
            Intrinsics.g(tmp0, "$tmp0");
            tmp0.invoke();
        }

        public static final void d(Function0 tmp0) {
            Intrinsics.g(tmp0, "$tmp0");
            tmp0.invoke();
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onDestroy(u uVar) {
            androidx.lifecycle.e.b(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onPause(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.c(this, owner);
            MovieDetailShareView.this.f53813a += SystemClock.elapsedRealtime() - this.f53818a;
            MovieDetailShareView movieDetailShareView = MovieDetailShareView.this;
            final Function0 function0 = movieDetailShareView.f53817f;
            movieDetailShareView.removeCallbacks(new Runnable() { // from class: com.transsion.moviedetail.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    MovieDetailShareView.a.c(function0);
                }
            });
        }

        @Override // androidx.lifecycle.f
        public void onResume(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.d(this, owner);
            this.f53818a = SystemClock.elapsedRealtime();
            if (MovieDetailShareView.this.f53813a < MovieDetailShareView.this.f53814b) {
                MovieDetailShareView movieDetailShareView = MovieDetailShareView.this;
                final Function0 function0 = movieDetailShareView.f53817f;
                movieDetailShareView.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.view.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieDetailShareView.a.d(function0);
                    }
                }, MovieDetailShareView.this.f53814b - MovieDetailShareView.this.f53813a);
            }
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStop(u uVar) {
            androidx.lifecycle.e.f(this, uVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieDetailShareView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieDetailShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailShareView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, 0);
        Intrinsics.g(context, "context");
        this.f53814b = DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        this.f53815c = new ImageView(getContext());
        this.f53817f = new MovieDetailShareView$showWhatAppIconRunnable$1(this);
    }

    public static final void b(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void init(u lifecycleOwner) {
        Intrinsics.g(lifecycleOwner, "lifecycleOwner");
        if (com.transsion.baselib.utils.o.f51321a.a()) {
            this.f53815c.setImageResource(R$mipmap.movie_share_night);
        } else {
            this.f53815c.setImageResource(R$mipmap.movie_share_light);
        }
        addView(this.f53815c, new FrameLayout.LayoutParams(-1, -1));
        lifecycleOwner.getLifecycle().a(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        super.onDetachedFromWindow();
        this.f53815c.animate().cancel();
        ImageView imageView = this.f53816d;
        if (imageView != null && (viewPropertyAnimatorAnimate = imageView.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        final Function0<Unit> function0 = this.f53817f;
        removeCallbacks(new Runnable() { // from class: com.transsion.moviedetail.view.k
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailShareView.b(function0);
            }
        });
    }

    public final void setImageResource(int i11) {
        this.f53815c.setImageResource(i11);
    }
}
