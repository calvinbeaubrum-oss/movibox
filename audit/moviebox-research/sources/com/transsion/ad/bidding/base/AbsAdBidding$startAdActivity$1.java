package com.transsion.ad.bidding.base;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
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
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsAdBidding$startAdActivity$1", f = "AbsAdBidding.kt", l = {}, m = "invokeSuspend")
public final class AbsAdBidding$startAdActivity$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ AbsAdBidding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsAdBidding$startAdActivity$1(AbsAdBidding absAdBidding, Activity activity, Continuation<? super AbsAdBidding$startAdActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = absAdBidding;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsAdBidding$startAdActivity$1(this.this$0, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AbsAdBidding$startAdActivity$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbsBiddingBuyOutGemini absBiddingBuyOutGeminiO;
        AbsBiddingBuyOutGemini absBiddingBuyOutGeminiN;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = this.this$0.P();
        AbsBiddingInterceptHiSavanaAdManager hiSavanaInterceptProvider = biddingIntermediateMaterialBeanP != null ? biddingIntermediateMaterialBeanP.getHiSavanaInterceptProvider() : null;
        if (hiSavanaInterceptProvider == null) {
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP2 = this.this$0.P();
            if ((biddingIntermediateMaterialBeanP2 != null ? biddingIntermediateMaterialBeanP2.getPlans() : null) != null) {
                Activity activity = this.$activity;
                AbsAdBidding absAdBidding = this.this$0;
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                AbsBiddingBuyOutGemini absBiddingBuyOutGeminiM = absAdBidding.M();
                if (absBiddingBuyOutGeminiM != null && (absBiddingBuyOutGeminiO = absBiddingBuyOutGeminiM.o(absAdBidding)) != null && (absBiddingBuyOutGeminiN = absBiddingBuyOutGeminiO.n()) != null) {
                    String strQ = absAdBidding.Q();
                    BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP3 = absAdBidding.P();
                    absBiddingBuyOutGeminiN.p(appCompatActivity, strQ, biddingIntermediateMaterialBeanP3 != null ? biddingIntermediateMaterialBeanP3.getPlans() : null);
                }
            } else {
                this.this$0.m(102);
            }
        } else {
            hiSavanaInterceptProvider.h(this.this$0);
            hiSavanaInterceptProvider.k(this.$activity, this.this$0.Q());
        }
        return Unit.f68710a;
    }
}
