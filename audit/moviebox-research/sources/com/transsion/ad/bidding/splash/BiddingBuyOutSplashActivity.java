package com.transsion.ad.bidding.splash;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$string;
import com.transsion.ad.bidding.base.AbsBiddingActivity;
import com.transsion.ad.bidding.splash.BiddingBuyOutSplashActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import pq.c;
import wq.a;

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
@SuppressLint({"CustomSplashScreen"})
public final class BiddingBuyOutSplashActivity extends AbsBiddingActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f50370m;

    public static final void A0(BiddingBuyOutSplashActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.V();
    }

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_s";
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View W() {
        return findViewById(R$id.adIcon);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public int a0() {
        return a.f79581a.i(f0());
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout c0() {
        c cVar = this.f50370m;
        if (cVar != null) {
            return cVar.f73986c;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View g0() {
        c cVarC = c.c(getLayoutInflater());
        this.f50370m = cVarC;
        if (cVarC != null) {
            return cVarC.getRoot();
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout h0() {
        c cVar = this.f50370m;
        if (cVar != null) {
            return cVar.f73987d;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void j0() {
        V();
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    @SuppressLint({"StringFormatMatches"})
    public void o0(int i11) {
        AppCompatTextView appCompatTextView;
        c cVar = this.f50370m;
        if (cVar == null || (appCompatTextView = cVar.f73989g) == null) {
            return;
        }
        appCompatTextView.setVisibility(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String string = getString(R$string.skip_ad, Integer.valueOf(i11));
        Intrinsics.f(string, "getString(R.string.skip_ad, i)");
        String str = String.format(string, Arrays.copyOf(new Object[0], 0));
        Intrinsics.f(str, "format(...)");
        appCompatTextView.setText(str);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void s0() {
        AppCompatTextView appCompatTextView;
        try {
            Result.Companion companion = Result.Companion;
            FrameLayout frameLayout = (FrameLayout) findViewById(R$id.movieBoxLayout);
            if (frameLayout != null) {
                Intrinsics.f(frameLayout, "findViewById<FrameLayout>(R.id.movieBoxLayout)");
                frameLayout.removeAllViews();
                frameLayout.addView(LayoutInflater.from(this).inflate(Z(), (ViewGroup) frameLayout, false));
            } else {
                frameLayout = null;
            }
            Result.m163constructorimpl(frameLayout);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        c cVar = this.f50370m;
        if (cVar == null || (appCompatTextView = cVar.f73989g) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: nq.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingBuyOutSplashActivity.A0(this.f72140a, view);
            }
        });
    }
}
