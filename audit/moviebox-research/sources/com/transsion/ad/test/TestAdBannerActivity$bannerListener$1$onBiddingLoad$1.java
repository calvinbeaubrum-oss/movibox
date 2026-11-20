package com.transsion.ad.test;

import android.view.View;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.ad.test.TestAdBannerActivity$bannerListener$1$onBiddingLoad$1", f = "TestAdBannerActivity.kt", l = {}, m = "invokeSuspend")
public final class TestAdBannerActivity$bannerListener$1$onBiddingLoad$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
    int label;
    final /* synthetic */ TestAdBannerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdBannerActivity$bannerListener$1$onBiddingLoad$1(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, TestAdBannerActivity testAdBannerActivity, Continuation<? super TestAdBannerActivity$bannerListener$1$onBiddingLoad$1> continuation) {
        super(2, continuation);
        this.$maxEcpmObject = biddingIntermediateMaterialBean;
        this.this$0 = testAdBannerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdBannerActivity$bannerListener$1$onBiddingLoad$1(this.$maxEcpmObject, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TestAdBannerActivity$bannerListener$1$onBiddingLoad$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        View bannerView;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = this.$maxEcpmObject;
        if (biddingIntermediateMaterialBean != null && (bannerView = biddingIntermediateMaterialBean.getBannerView()) != null) {
            TestAdBannerActivity testAdBannerActivity = this.this$0;
            kq.a aVar = testAdBannerActivity.f50614b;
            if (aVar != null) {
                aVar.o0();
            }
            pq.e eVar = testAdBannerActivity.f50613a;
            if (eVar == null) {
                Intrinsics.y("binding");
                eVar = null;
            }
            eVar.f74011c.addView(bannerView);
        }
        return Unit.f68710a;
    }
}
