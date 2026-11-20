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
public final class TestAdNativeActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f50621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public pq.h f50622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TestAdNativeActivity$nativeListener$1 f50623c = new jq.a() { // from class: com.transsion.ad.test.TestAdNativeActivity$nativeListener$1
        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            com.transsion.ad.a.L(com.transsion.ad.a.f50276a, this.f50624a.getClassTag() + " --> onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 2, null);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            kotlinx.coroutines.j.d(v.a(this.f50624a), null, null, new TestAdNativeActivity$nativeListener$1$onBiddingLoad$1(this.f50624a, null), 3, null);
        }
    };

    public static final void S(TestAdNativeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kotlinx.coroutines.j.d(v.a(this$0), null, null, new TestAdNativeActivity$onCreate$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = TestAdNativeActivity.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.h hVarC = pq.h.c(getLayoutInflater());
        Intrinsics.f(hVarC, "inflate(layoutInflater)");
        this.f50622b = hVarC;
        pq.h hVar = null;
        if (hVarC == null) {
            Intrinsics.y("binding");
            hVarC = null;
        }
        setContentView(hVarC.getRoot());
        this.f50621a = new com.transsion.ad.bidding.nativead.c();
        pq.h hVar2 = this.f50622b;
        if (hVar2 == null) {
            Intrinsics.y("binding");
        } else {
            hVar = hVar2;
        }
        hVar.f74025b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdNativeActivity.S(this.f50653a, view);
            }
        });
    }
}
