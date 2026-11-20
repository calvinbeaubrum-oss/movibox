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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TestAdBannerActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pq.e f50613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kq.a f50614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TestAdBannerActivity$bannerListener$1 f50615c = new jq.a() { // from class: com.transsion.ad.test.TestAdBannerActivity$bannerListener$1
        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            com.transsion.ad.a.x(com.transsion.ad.a.f50276a, "Banner 广告加载失败", false, 2, null);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            kotlinx.coroutines.j.d(v.a(this.f50616a), null, null, new TestAdBannerActivity$bannerListener$1$onBiddingLoad$1(biddingIntermediateMaterialBean, this.f50616a, null), 3, null);
        }
    };

    public static final void S(TestAdBannerActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kotlinx.coroutines.j.d(v.a(this$0), null, null, new TestAdBannerActivity$onCreate$1$1(this$0, null), 3, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.e eVarC = pq.e.c(getLayoutInflater());
        Intrinsics.f(eVarC, "inflate(layoutInflater)");
        this.f50613a = eVarC;
        pq.e eVar = null;
        if (eVarC == null) {
            Intrinsics.y("binding");
            eVarC = null;
        }
        setContentView(eVarC.getRoot());
        pq.e eVar2 = this.f50613a;
        if (eVar2 == null) {
            Intrinsics.y("binding");
        } else {
            eVar = eVar2;
        }
        eVar.f74010b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdBannerActivity.S(this.f50651a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        kq.a aVar = this.f50614b;
        if (aVar != null) {
            aVar.F();
        }
    }
}
