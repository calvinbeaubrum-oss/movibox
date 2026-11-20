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
public final class TestAdVideoActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.transsion.ad.bidding.video.f f50638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public pq.n f50639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f50640c = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends jq.a {
        public a() {
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            com.transsion.ad.a.x(com.transsion.ad.a.f50276a, TestAdVideoActivity.this.getClassTag() + " --> onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 2, null);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            com.transsion.ad.bidding.video.f fVar = TestAdVideoActivity.this.f50638a;
            if (fVar == null) {
                Intrinsics.y("videoManager");
                fVar = null;
            }
            fVar.n0(TestAdVideoActivity.this);
        }
    }

    public static final void R(TestAdVideoActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kotlinx.coroutines.j.d(v.a(this$0), null, null, new TestAdVideoActivity$onCreate$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = TestAdVideoActivity.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.n nVarC = pq.n.c(getLayoutInflater());
        Intrinsics.f(nVarC, "inflate(layoutInflater)");
        this.f50639b = nVarC;
        pq.n nVar = null;
        if (nVarC == null) {
            Intrinsics.y("binding");
            nVarC = null;
        }
        setContentView(nVarC.getRoot());
        this.f50638a = new com.transsion.ad.bidding.video.f();
        pq.n nVar2 = this.f50639b;
        if (nVar2 == null) {
            Intrinsics.y("binding");
        } else {
            nVar = nVar2;
        }
        nVar.f74039b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdVideoActivity.R(this.f50656a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ad.bidding.video.f fVar = this.f50638a;
        if (fVar == null) {
            Intrinsics.y("videoManager");
            fVar = null;
        }
        fVar.F();
    }
}
