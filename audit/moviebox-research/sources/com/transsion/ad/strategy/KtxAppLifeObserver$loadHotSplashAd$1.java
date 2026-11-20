package com.transsion.ad.strategy;

import com.transsion.ad.bidding.base.AbsAdBidding;
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
@DebugMetadata(c = "com.transsion.ad.strategy.KtxAppLifeObserver$loadHotSplashAd$1", f = "KtxAppLifeObserver.kt", l = {132}, m = "invokeSuspend")
public final class KtxAppLifeObserver$loadHotSplashAd$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KtxAppLifeObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtxAppLifeObserver$loadHotSplashAd$1(KtxAppLifeObserver ktxAppLifeObserver, Continuation<? super KtxAppLifeObserver$loadHotSplashAd$1> continuation) {
        super(2, continuation);
        this.this$0 = ktxAppLifeObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KtxAppLifeObserver$loadHotSplashAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((KtxAppLifeObserver$loadHotSplashAd$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbsAdBidding absAdBiddingM0;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.a.t(com.transsion.ad.a.f50276a, KtxAppLifeObserver.f50569a.getClassTag() + " --> loadHotSplashAd() --> App 进入前台符合条件 --> 准备展示开屏广告", false, 2, null);
            if (KtxAppLifeObserver.f50572d == null) {
                KtxAppLifeObserver.f50572d = new com.transsion.ad.bidding.interstitial.a();
                com.transsion.ad.bidding.interstitial.a aVar = KtxAppLifeObserver.f50572d;
                if (aVar != null && (absAdBiddingM0 = aVar.m0(oq.d.f72515a.a())) != null) {
                    absAdBiddingM0.l0(this.this$0);
                }
            }
            com.transsion.ad.bidding.interstitial.a aVar2 = KtxAppLifeObserver.f50572d;
            if (aVar2 != null) {
                this.label = 1;
                if (aVar2.T(this) == objE) {
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
