package com.transsion.ad.test;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
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
public final class TestAdInterstitialActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pq.f f50617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.ad.bidding.interstitial.a f50618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f50619c = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {
        public a() {
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            com.transsion.ad.a.x(com.transsion.ad.a.f50276a, TestAdInterstitialActivity.this.getClassTag() + " --> onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 2, null);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            com.transsion.ad.bidding.interstitial.a aVar = TestAdInterstitialActivity.this.f50618b;
            if (aVar == null) {
                Intrinsics.y("interstitialManager");
                aVar = null;
            }
            aVar.n0(TestAdInterstitialActivity.this);
        }
    }

    public static final void R(TestAdInterstitialActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kotlinx.coroutines.j.d(v.a(this$0), null, null, new TestAdInterstitialActivity$onCreate$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = TestAdInterstitialActivity.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.f fVarC = pq.f.c(getLayoutInflater());
        Intrinsics.f(fVarC, "inflate(layoutInflater)");
        this.f50617a = fVarC;
        pq.f fVar = null;
        if (fVarC == null) {
            Intrinsics.y("binding");
            fVarC = null;
        }
        setContentView(fVarC.getRoot());
        this.f50618b = new com.transsion.ad.bidding.interstitial.a();
        pq.f fVar2 = this.f50617a;
        if (fVar2 == null) {
            Intrinsics.y("binding");
        } else {
            fVar = fVar2;
        }
        fVar.f74013b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdInterstitialActivity.R(this.f50652a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ad.bidding.interstitial.a aVar = this.f50618b;
        if (aVar == null) {
            Intrinsics.y("interstitialManager");
            aVar = null;
        }
        aVar.F();
    }
}
