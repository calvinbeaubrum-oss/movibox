package com.transsion.player.longvideo.ui.dialog;

import android.content.Context;
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
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$loadRewardedAd$1$1", f = "LongVodPlayerViewAdHelper.kt", l = {1442}, m = "invokeSuspend")
public final class LongVodPlayerViewAdHelper$loadRewardedAd$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $it;
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerViewAdHelper$loadRewardedAd$1$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Context context, Continuation<? super LongVodPlayerViewAdHelper$loadRewardedAd$1$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
        this.$it = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$loadRewardedAd$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LongVodPlayerViewAdHelper$loadRewardedAd$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            com.transsion.ad.bidding.video.f fVar = this.this$0.E;
            if (fVar != null) {
                fVar.F();
            }
            this.this$0.E = new com.transsion.ad.bidding.video.f();
            com.transsion.ad.bidding.video.f fVar2 = this.this$0.E;
            if (fVar2 != null) {
                fVar2.m0(this.this$0.R);
            }
            com.transsion.ad.bidding.video.f fVar3 = this.this$0.E;
            if (fVar3 != null) {
                fVar3.k0(com.transsion.ad.strategy.b.f50584a.a(this.this$0.f54537i));
            }
            com.transsion.ad.bidding.video.f fVar4 = this.this$0.E;
            if (fVar4 != null) {
                fVar4.j0(this.$it);
            }
            com.transsion.ad.bidding.video.f fVar5 = this.this$0.E;
            if (fVar5 != null) {
                fVar5.l0(this.this$0.f54529a0);
            }
            com.transsion.ad.bidding.video.f fVar6 = this.this$0.E;
            if (fVar6 != null) {
                this.label = 1;
                if (fVar6.T(this) == objE) {
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
