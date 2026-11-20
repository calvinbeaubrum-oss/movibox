package com.transsion.postdetail.layer.local;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "com.transsion.postdetail.layer.local.LocalVideoMiddleLayer$showInterstitialAd$1", f = "LocalVideoMiddleLayer.kt", l = {765}, m = "invokeSuspend")
public final class LocalVideoMiddleLayer$showInterstitialAd$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LocalVideoMiddleLayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleLayer$showInterstitialAd$1(LocalVideoMiddleLayer localVideoMiddleLayer, Continuation<? super LocalVideoMiddleLayer$showInterstitialAd$1> continuation) {
        super(2, continuation);
        this.this$0 = localVideoMiddleLayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoMiddleLayer$showInterstitialAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoMiddleLayer$showInterstitialAd$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.bidding.interstitial.a aVar = this.this$0.f55223k0;
            if (aVar != null) {
                aVar.F();
            }
            this.this$0.f55223k0 = new com.transsion.ad.bidding.interstitial.a();
            com.transsion.ad.bidding.interstitial.a aVar2 = this.this$0.f55223k0;
            if (aVar2 != null) {
                aVar2.m0("LocalVideoBackInterstitialV2Scene");
            }
            com.transsion.ad.bidding.interstitial.a aVar3 = this.this$0.f55223k0;
            if (aVar3 != null) {
                aVar3.l0(this.this$0.f55224l0);
            }
            com.transsion.ad.bidding.interstitial.a aVar4 = this.this$0.f55223k0;
            if (aVar4 != null) {
                com.transsion.ad.strategy.b bVar = com.transsion.ad.strategy.b.f50584a;
                DownloadBean downloadBeanC0 = this.this$0.C0();
                aVar4.k0(bVar.a(downloadBeanC0 != null ? downloadBeanC0.getGenre() : null));
            }
            com.transsion.ad.bidding.interstitial.a aVar5 = this.this$0.f55223k0;
            if (aVar5 != null) {
                this.label = 1;
                if (aVar5.T(this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
