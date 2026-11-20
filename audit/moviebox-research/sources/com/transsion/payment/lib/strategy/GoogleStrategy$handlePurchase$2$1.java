package com.transsion.payment.lib.strategy;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$handlePurchase$2$1", f = "GoogleStrategy.kt", l = {285}, m = "invokeSuspend")
public final class GoogleStrategy$handlePurchase$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $gpOrderId;
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $productId;
    final /* synthetic */ String $purchaseToken;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleStrategy$handlePurchase$2$1(GoogleStrategy googleStrategy, String str, String str2, String str3, String str4, Continuation<? super GoogleStrategy$handlePurchase$2$1> continuation) {
        super(1, continuation);
        this.this$0 = googleStrategy;
        this.$productId = str;
        this.$purchaseToken = str2;
        this.$orderId = str3;
        this.$gpOrderId = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new GoogleStrategy$handlePurchase$2$1(this.this$0, this.$productId, this.$purchaseToken, this.$orderId, this.$gpOrderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((GoogleStrategy$handlePurchase$2$1) create(continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        String balanceCoin;
        String addCoin;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PaymentService paymentServiceW = this.this$0.w();
            String str = this.$productId;
            String str2 = this.$purchaseToken;
            String str3 = this.$orderId;
            String str4 = this.$gpOrderId;
            this.label = 1;
            obj = paymentServiceW.e(str, str2, str3, str4, this);
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
        if (!Intrinsics.b(baseDto != null ? baseDto.getCode() : null, "0")) {
            throw new Exception(baseDto != null ? baseDto.getMsg() : null);
        }
        com.transsion.payment.lib.b bVar = this.this$0.f54063k;
        int i12 = 0;
        if (bVar != null) {
            bVar.b(false);
        }
        com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.f54044a;
        dVar.a("Will callback success");
        com.transsion.payment.lib.b bVar2 = this.this$0.f54063k;
        if (bVar2 != null) {
            CheckPaymentBean checkPaymentBean = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean != null && (addCoin = checkPaymentBean.getAddCoin()) != null) {
                i12 = Integer.parseInt(addCoin);
            }
            CheckPaymentBean checkPaymentBean2 = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean2 == null || (balanceCoin = checkPaymentBean2.getBalanceCoin()) == null) {
                balanceCoin = "";
            }
            bVar2.c(i12, balanceCoin, this.$orderId);
        }
        dVar.a("Has callback " + this.this$0.f54063k);
        this.this$0.f54063k = null;
        dVar.a("handlePurchase 发货成功");
        return Unit.f68710a;
    }
}
