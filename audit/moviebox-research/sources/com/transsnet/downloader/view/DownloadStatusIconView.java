package com.transsnet.downloader.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.f0;
import com.transsion.baselib.utils.o;
import com.transsnet.downloader.R$layout;
import h00.a1;
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
public final class DownloadStatusIconView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f61167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f61168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f61169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LottieAnimationView f61170d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f61171f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(getContext(), R$layout.view_download_status_icon, this);
        a1 a1VarA = a1.a(this);
        Intrinsics.f(a1VarA, "bind(this)");
        this.f61167a = a1VarA;
        d();
        new AsyncLayoutInflater(context).a(R$layout.view_download_status_icon_lav, null, new AsyncLayoutInflater.d() { // from class: com.transsnet.downloader.view.a
            @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.d
            public final void a(View view, int i12, ViewGroup viewGroup) {
                DownloadStatusIconView.b(this.f61182a, view, i12, viewGroup);
            }
        });
    }

    public static final void b(DownloadStatusIconView this$0, View view, int i11, ViewGroup viewGroup) {
        LottieAnimationView lottieAnimationView;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(view, "view");
        if (view instanceof LottieAnimationView) {
            this$0.f61170d = (LottieAnimationView) view;
            int iA = f0.a(24.0f);
            this$0.addView(this$0.f61170d, 0, new FrameLayout.LayoutParams(iA, iA));
            String str = this$0.f61169c;
            if (str != null && (lottieAnimationView = this$0.f61170d) != null) {
                lottieAnimationView.setAnimation(str);
            }
            if (this$0.f61168b) {
                this$0.c();
            } else {
                this$0.h();
            }
        }
    }

    private final void setAnima(boolean z11) {
        this.f61168b = z11;
        if (z11) {
            c();
        } else {
            h();
        }
    }

    public final void c() {
        LottieAnimationView lottieAnimationView = this.f61170d;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
        }
        if (isAttachedToWindow()) {
            LottieAnimationView lottieAnimationView2 = this.f61170d;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.playAnimation();
            }
        } else {
            LottieAnimationView lottieAnimationView3 = this.f61170d;
            if (lottieAnimationView3 != null) {
                lottieAnimationView3.pauseAnimation();
            }
        }
        LottieAnimationView lottieAnimationView4 = this.f61170d;
        if (lottieAnimationView4 != null) {
            so.c.k(lottieAnimationView4);
        }
        ImageView imageView = this.f61167a.f65717c;
        Intrinsics.f(imageView, "viewBinding.ivDownloadIcon");
        so.c.g(imageView);
    }

    public final void d() {
        View view = this.f61167a.f65719f;
        Intrinsics.f(view, "viewBinding.vDownloadTips");
        so.c.g(view);
        AppCompatImageView appCompatImageView = this.f61167a.f65716b;
        Intrinsics.f(appCompatImageView, "viewBinding.ivDownloadFail");
        so.c.g(appCompatImageView);
        AppCompatTextView appCompatTextView = this.f61167a.f65718d;
        Intrinsics.f(appCompatTextView, "viewBinding.tvDownloadStatus");
        so.c.g(appCompatTextView);
    }

    public final void e() {
        View view = this.f61167a.f65719f;
        Intrinsics.f(view, "viewBinding.vDownloadTips");
        so.c.g(view);
        AppCompatImageView appCompatImageView = this.f61167a.f65716b;
        Intrinsics.f(appCompatImageView, "viewBinding.ivDownloadFail");
        so.c.k(appCompatImageView);
        AppCompatTextView appCompatTextView = this.f61167a.f65718d;
        Intrinsics.f(appCompatTextView, "viewBinding.tvDownloadStatus");
        so.c.g(appCompatTextView);
    }

    public final void f(int i11) {
        View view = this.f61167a.f65719f;
        Intrinsics.f(view, "viewBinding.vDownloadTips");
        so.c.g(view);
        AppCompatImageView appCompatImageView = this.f61167a.f65716b;
        Intrinsics.f(appCompatImageView, "viewBinding.ivDownloadFail");
        so.c.g(appCompatImageView);
        if (i11 <= 0) {
            AppCompatTextView appCompatTextView = this.f61167a.f65718d;
            Intrinsics.f(appCompatTextView, "viewBinding.tvDownloadStatus");
            so.c.g(appCompatTextView);
        } else {
            String strValueOf = i11 > 99 ? "99+" : String.valueOf(i11);
            AppCompatTextView appCompatTextView2 = this.f61167a.f65718d;
            Intrinsics.f(appCompatTextView2, "viewBinding.tvDownloadStatus");
            so.c.k(appCompatTextView2);
            this.f61167a.f65718d.setText(strValueOf);
        }
    }

    public final void g() {
        View view = this.f61167a.f65719f;
        Intrinsics.f(view, "viewBinding.vDownloadTips");
        so.c.k(view);
        AppCompatImageView appCompatImageView = this.f61167a.f65716b;
        Intrinsics.f(appCompatImageView, "viewBinding.ivDownloadFail");
        so.c.g(appCompatImageView);
        AppCompatTextView appCompatTextView = this.f61167a.f65718d;
        Intrinsics.f(appCompatTextView, "viewBinding.tvDownloadStatus");
        so.c.g(appCompatTextView);
    }

    public final void h() {
        LottieAnimationView lottieAnimationView = this.f61170d;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.f61170d;
        if (lottieAnimationView2 != null) {
            so.c.g(lottieAnimationView2);
        }
        ImageView imageView = this.f61167a.f65717c;
        Intrinsics.f(imageView, "viewBinding.ivDownloadIcon");
        so.c.k(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        LottieAnimationView lottieAnimationView;
        super.onAttachedToWindow();
        if (!this.f61168b || (lottieAnimationView = this.f61170d) == null) {
            return;
        }
        lottieAnimationView.resumeAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        LottieAnimationView lottieAnimationView;
        super.onDetachedFromWindow();
        if (!this.f61168b || (lottieAnimationView = this.f61170d) == null) {
            return;
        }
        lottieAnimationView.pauseAnimation();
    }

    public final void onDownloadStatusChange(int i11, int i12) {
        if (i11 == 0) {
            uo.b.a.f(uo.b.f78622a, "DownloadStatus", "View onDownloadStatusChange, showDefault", false, 4, null);
            setAnima(false);
            d();
            return;
        }
        if (i11 == 1) {
            uo.b.a.f(uo.b.f78622a, "DownloadStatus", "View onDownloadStatusChange, showTips", false, 4, null);
            setAnima(false);
            g();
            return;
        }
        if (i11 == 2) {
            uo.b.a.f(uo.b.f78622a, "DownloadStatus", "View onDownloadStatusChange, showFail", false, 4, null);
            setAnima(false);
            e();
            return;
        }
        if (i11 == 3) {
            uo.b.a.f(uo.b.f78622a, "DownloadStatus", "View onDownloadStatusChange, showFail anima", false, 4, null);
            setAnima(true);
            e();
        } else if (i11 == 4) {
            uo.b.a.f(uo.b.f78622a, "DownloadStatus", "View onDownloadStatusChange, showStatus", false, 4, null);
            setAnima(false);
            f(i12);
        } else {
            if (i11 != 5) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, "DownloadStatus", "View onDownloadStatusChange, showStatus anima", false, 4, null);
            setAnima(true);
            f(i12);
        }
    }

    public final void setDownloadIcon(int i11, boolean z11) {
        String str;
        int iA = androidx.compose.foundation.e.a(z11) + i11;
        if (iA == this.f61171f) {
            return;
        }
        this.f61171f = iA;
        this.f61167a.f65717c.setImageResource(i11);
        if (z11) {
            str = "download_icon_status_anima_home.json";
        } else {
            str = o.f51321a.a() ? "download_icon_status_anima_home_fit_night.json" : "download_icon_status_anima_home_fit.json";
        }
        this.f61169c = str;
        LottieAnimationView lottieAnimationView = this.f61170d;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(str);
        }
        if (this.f61168b) {
            c();
        } else {
            h();
        }
    }
}
