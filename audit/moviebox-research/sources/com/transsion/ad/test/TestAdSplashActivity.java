package com.transsion.ad.test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.monopoly.model.AdPlans;
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
@SuppressLint({"CustomSplashScreen"})
public final class TestAdSplashActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nq.b f50634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public pq.m f50635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f50636c = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {
        public a() {
        }

        @Override // jq.a
        public void b(AdPlans adPlans) {
            super.b(adPlans);
            com.transsion.ad.a.N(com.transsion.ad.a.f50276a, TestAdSplashActivity.this.getClassTag() + " --> onBiddingBuyOutClose()", false, 2, null);
            TestAdSplashActivity.this.finish();
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            com.transsion.ad.a.P(com.transsion.ad.a.f50276a, TestAdSplashActivity.this.getClassTag() + " --> onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 2, null);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            nq.b bVar = TestAdSplashActivity.this.f50634a;
            if (bVar == null) {
                Intrinsics.y("splashManager");
                bVar = null;
            }
            bVar.o0(null, TestAdSplashActivity.this);
        }
    }

    public static final void R(TestAdSplashActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kotlinx.coroutines.j.d(v.a(this$0), null, null, new TestAdSplashActivity$onCreate$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = TestAdSplashActivity.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.m mVarC = pq.m.c(getLayoutInflater());
        Intrinsics.f(mVarC, "inflate(layoutInflater)");
        this.f50635b = mVarC;
        pq.m mVar = null;
        if (mVarC == null) {
            Intrinsics.y("binding");
            mVarC = null;
        }
        setContentView(mVarC.getRoot());
        this.f50634a = new nq.b();
        pq.m mVar2 = this.f50635b;
        if (mVar2 == null) {
            Intrinsics.y("binding");
        } else {
            mVar = mVar2;
        }
        mVar.f74037b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdSplashActivity.R(this.f50655a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        nq.b bVar = this.f50634a;
        if (bVar == null) {
            Intrinsics.y("splashManager");
            bVar = null;
        }
        bVar.F();
    }
}
