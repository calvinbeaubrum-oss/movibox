package com.transsion.member;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.member.bean.RedeemResult;
import com.transsion.memberapi.SkuItem;
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
@DebugMetadata(c = "com.transsion.member.MemberViewModel$redeemProduct$1", f = "MemberViewModel.kt", l = {290}, m = "invokeSuspend")
public final class MemberViewModel$redeemProduct$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SkuItem $skuItem;
    int label;
    final /* synthetic */ MemberViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberViewModel$redeemProduct$1(MemberViewModel memberViewModel, SkuItem skuItem, Continuation<? super MemberViewModel$redeemProduct$1> continuation) {
        super(2, continuation);
        this.this$0 = memberViewModel;
        this.$skuItem = skuItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberViewModel$redeemProduct$1(this.this$0, this.$skuItem, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MemberViewModel$redeemProduct$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            MemberViewModel memberViewModel = this.this$0;
            SkuItem skuItem = this.$skuItem;
            this.label = 1;
            obj = memberViewModel.E(skuItem, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        BaseDto baseDto = (BaseDto) obj;
        if (!Intrinsics.b(baseDto != null ? baseDto.getCode() : null, "0") || baseDto.getData() == null) {
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.j(aVar, "MemberViewModel", "RedeemProduct fail: " + (baseDto != null ? baseDto.getReason() : null) + " " + (baseDto != null ? baseDto.getCode() : null) + " " + (baseDto != null ? baseDto.getMsg() : null), false, 4, null);
            if (Intrinsics.b(baseDto != null ? baseDto.getReason() : null, "EXCHANGE_FAIL")) {
                this.this$0.f53194m.remove(this.$skuItem.getSkuId());
                uo.b.a.f(aVar, "MemberViewModel", "Should remove the orderId for " + this.$skuItem.getSkuId(), false, 4, null);
            }
            this.this$0.f53188g.q(null);
        } else {
            Object data = baseDto.getData();
            Intrinsics.d(data);
            RedeemResult redeemResult = (RedeemResult) data;
            if (Intrinsics.b(redeemResult.getOrderId(), this.this$0.f53194m.get(this.$skuItem.getSkuId()))) {
                uo.b.a.f(uo.b.f78622a, "MemberViewModel", "RedeemProductSucceed: " + redeemResult.getOrderId() + "}", false, 4, null);
                this.this$0.f53194m.remove(this.$skuItem.getSkuId());
            } else {
                uo.b.a.f(uo.b.f78622a, "MemberViewModel", "RedeemProductSucceed but orderId not match: " + redeemResult.getOrderId() + "}", false, 4, null);
            }
            this.this$0.f53188g.q(redeemResult);
        }
        return Unit.f68710a;
    }
}
