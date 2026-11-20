package com.transsion.ad.middle.intercept.interstitial;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.a;
import com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity;
import com.transsion.ad.middle.intercept.interstitial.NonInterstitialAdActivity;
import com.transsion.ad.strategy.e;
import com.transsion.ad.view.AdTagView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wq.b;
import xq.l;

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
@Deprecated
@Metadata
public final class NonInterstitialAdActivity extends BaseInterceptMbAdActivity {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AppCompatTextView f50452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ConstraintLayout f50453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayoutCompat f50454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ConstraintLayout f50455r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AppCompatImageView f50456s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f50457t = true;

    public static final void x0(NonInterstitialAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.getOnBackPressedDispatcher().l();
    }

    public static final void y0(NonInterstitialAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a.N(a.f50276a, this$0.getClass().getSimpleName() + " --> playVideo() --> 点击了音频按钮", false, 2, null);
        this$0.f50457t = this$0.o0();
        this$0.A0();
    }

    public static final void z0(NonInterstitialAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S();
    }

    public final void A0() {
        if (this.f50457t) {
            AppCompatImageView appCompatImageView = this.f50456s;
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R$mipmap.ad_volumeoff);
                return;
            }
            return;
        }
        AppCompatImageView appCompatImageView2 = this.f50456s;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void T(boolean z11) {
        ConstraintLayout constraintLayout = this.f50455r;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(z11 ? 0 : 8);
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public Intent W() {
        return new Intent("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onDestroy.Interstitial");
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public ImageView X() {
        return (ImageView) findViewById(R$id.ivAd);
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public Intent Y() {
        return new Intent("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onShow.Interstitial");
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public TextureView Z() {
        return (TextureView) findViewById(R$id.textureView);
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public int a0() {
        return 4;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public int b0() {
        return b.f79582a.b();
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void e0() {
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return (ConstraintLayout) findViewById(R$id.rlRoot);
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void k0(int i11) {
        if (i11 == b0()) {
            ConstraintLayout constraintLayout = this.f50453p;
            if (constraintLayout != null) {
                constraintLayout.setClickable(false);
            }
            ConstraintLayout constraintLayout2 = this.f50453p;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            LinearLayoutCompat linearLayoutCompat = this.f50454q;
            if (linearLayoutCompat != null) {
                linearLayoutCompat.setVisibility(0);
            }
        }
        a.F(a.f50276a, NonInterstitialAdActivity.class.getSimpleName() + " --> refreshCountDownView() --> i = " + i11 + " -- getCountDownTimes() = " + b0(), false, 2, null);
        String strValueOf = String.valueOf(i11);
        AppCompatTextView appCompatTextView = this.f50452o;
        if (appCompatTextView != null) {
            appCompatTextView.setText(strValueOf);
        }
        if (i11 == 0) {
            ConstraintLayout constraintLayout3 = this.f50453p;
            if (constraintLayout3 != null) {
                constraintLayout3.setClickable(true);
            }
            ConstraintLayout constraintLayout4 = this.f50453p;
            if (constraintLayout4 != null) {
                constraintLayout4.setVisibility(0);
            }
            AppCompatTextView appCompatTextView2 = this.f50452o;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            AppCompatTextView appCompatTextView3 = this.f50452o;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextColor(Color.parseColor("#92969E"));
            }
        }
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void m0() {
        l.f80683a.a(new View[]{findViewById(R$id.view)}, new View.OnClickListener() { // from class: tq.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NonInterstitialAdActivity.z0(this.f77261a, view);
            }
        });
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public int n0() {
        return R$layout.activity_non_interstitial_ad;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f50452o = (AppCompatTextView) findViewById(R$id.tvCd);
        this.f50454q = (LinearLayoutCompat) findViewById(R$id.viewCd);
        this.f50456s = (AppCompatImageView) findViewById(R$id.tvAudio);
        this.f50455r = (ConstraintLayout) findViewById(R$id.tvAudioContainer);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.tvClose);
        this.f50453p = constraintLayout;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: tq.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NonInterstitialAdActivity.x0(this.f77262a, view);
                }
            });
        }
        ConstraintLayout constraintLayout2 = this.f50455r;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: tq.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NonInterstitialAdActivity.y0(this.f77263a, view);
                }
            });
        }
        AdTagView adTagView = (AdTagView) findViewById(R$id.adIcon);
        if (adTagView != null) {
            e.f50608a.a(adTagView);
        }
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void r0() {
    }
}
