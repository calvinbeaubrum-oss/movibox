package com.transsion.subroom.activity;

import androidx.lifecycle.v;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.subroom.activity.SplashActivity$onCreate$2$1", f = "SplashActivity.kt", l = {137}, m = "invokeSuspend")
public final class SplashActivity$onCreate$2$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$onCreate$2$1(SplashActivity splashActivity, Continuation<? super SplashActivity$onCreate$2$1> continuation) {
        super(2, continuation);
        this.this$0 = splashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashActivity$onCreate$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SplashActivity$onCreate$2$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbsAdBidding absAdBiddingM0;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.this$0.f58022a = new nq.b();
            nq.b bVar = this.this$0.f58022a;
            if (bVar != null && (absAdBiddingM0 = bVar.m0("ColdStartScene")) != null) {
                final SplashActivity splashActivity = this.this$0;
                AbsAdBidding absAdBiddingL0 = absAdBiddingM0.l0(new jq.a() { // from class: com.transsion.subroom.activity.SplashActivity$onCreate$2$1.1
                    @Override // jq.a
                    public void g(TAdErrorCode tAdErrorCode) {
                        super.g(tAdErrorCode);
                        kotlinx.coroutines.j.d(v.a(splashActivity), null, null, new SplashActivity$onCreate$2$1$1$onBiddingError$1(splashActivity, null), 3, null);
                    }

                    @Override // jq.a
                    public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                        super.h(biddingIntermediateMaterialBean);
                        kotlinx.coroutines.j.d(v.a(splashActivity), null, null, new SplashActivity$onCreate$2$1$1$onBiddingLoad$1(splashActivity, null), 3, null);
                    }
                });
                if (absAdBiddingL0 != null) {
                    this.label = 1;
                    if (absAdBiddingL0.T(this) == objE) {
                        return objE;
                    }
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
