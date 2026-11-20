package com.transsion.commercialization.task;

import androidx.lifecycle.v;
import com.hisavana.common.bean.TAdErrorCode;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.commercialization.task.AdInterceptDialog$loadNativeAd$1", f = "AdInterceptDialog.kt", l = {214}, m = "invokeSuspend")
public final class AdInterceptDialog$loadNativeAd$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdInterceptDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInterceptDialog$loadNativeAd$1(AdInterceptDialog adInterceptDialog, Continuation<? super AdInterceptDialog$loadNativeAd$1> continuation) {
        super(2, continuation);
        this.this$0 = adInterceptDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdInterceptDialog$loadNativeAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AdInterceptDialog$loadNativeAd$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.bidding.nativead.c cVar = this.this$0.f51731g;
            if (cVar != null) {
                cVar.F();
            }
            this.this$0.f51731g = new com.transsion.ad.bidding.nativead.c();
            com.transsion.ad.bidding.nativead.c cVar2 = this.this$0.f51731g;
            if (cVar2 != null) {
                cVar2.m0("AdInterceptDialogNativeScene");
            }
            com.transsion.ad.bidding.nativead.c cVar3 = this.this$0.f51731g;
            if (cVar3 != null) {
                cVar3.k0(com.transsion.ad.strategy.b.f50584a.a(this.this$0.f51728c));
            }
            com.transsion.ad.bidding.nativead.c cVar4 = this.this$0.f51731g;
            if (cVar4 != null) {
                final AdInterceptDialog adInterceptDialog = this.this$0;
                cVar4.l0(new jq.a() { // from class: com.transsion.commercialization.task.AdInterceptDialog$loadNativeAd$1.1
                    @Override // jq.a
                    public void g(TAdErrorCode tAdErrorCode) {
                        super.g(tAdErrorCode);
                        adInterceptDialog.f51732h = true;
                        adInterceptDialog.dismissAllowingStateLoss();
                    }

                    @Override // jq.a
                    public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                        super.h(biddingIntermediateMaterialBean);
                        kotlinx.coroutines.j.d(v.a(adInterceptDialog), null, null, new AdInterceptDialog$loadNativeAd$1$1$onBiddingLoad$1(adInterceptDialog, null), 3, null);
                    }

                    @Override // jq.a
                    public void i(int i12) {
                        super.i(i12);
                        adInterceptDialog.f51732h = true;
                    }
                });
            }
            com.transsion.ad.bidding.nativead.c cVar5 = this.this$0.f51731g;
            if (cVar5 != null) {
                this.label = 1;
                if (cVar5.T(this) == objE) {
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
