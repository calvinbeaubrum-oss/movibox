package com.transsion.ad.bidding.interstitial;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.ad.R$id;
import com.transsion.ad.bidding.base.AbsBiddingActivity;
import com.transsion.ad.bidding.interstitial.BiddingBuyOutBuyOutInterstitialHalfScreenActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pq.b;

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
public final class BiddingBuyOutBuyOutInterstitialHalfScreenActivity extends AbsBiddingActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f50338m;

    public static final void A0(BiddingBuyOutBuyOutInterstitialHalfScreenActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.V();
    }

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_i";
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View W() {
        return findViewById(R$id.adIcon);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public int a0() {
        return wq.b.f79582a.b();
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout c0() {
        b bVar = this.f50338m;
        if (bVar != null) {
            return bVar.f73976c;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View g0() {
        b bVarC = b.c(getLayoutInflater());
        this.f50338m = bVarC;
        if (bVarC != null) {
            return bVarC.getRoot();
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout h0() {
        b bVar = this.f50338m;
        if (bVar != null) {
            return bVar.f73978f;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void j0() {
        b bVar = this.f50338m;
        FrameLayout frameLayout = bVar != null ? bVar.f73977d : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        b bVar2 = this.f50338m;
        AppCompatTextView appCompatTextView = bVar2 != null ? bVar2.f73981i : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setVisibility(8);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    @SuppressLint({"StringFormatMatches"})
    public void o0(int i11) {
        AppCompatTextView appCompatTextView;
        b bVar = this.f50338m;
        if (bVar == null || (appCompatTextView = bVar.f73981i) == null) {
            return;
        }
        appCompatTextView.setVisibility(0);
        appCompatTextView.setText(String.valueOf(i11));
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void s0() {
        FrameLayout frameLayout;
        b bVar = this.f50338m;
        if (bVar == null || (frameLayout = bVar.f73977d) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: mq.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingBuyOutBuyOutInterstitialHalfScreenActivity.A0(this.f71173a, view);
            }
        });
    }
}
