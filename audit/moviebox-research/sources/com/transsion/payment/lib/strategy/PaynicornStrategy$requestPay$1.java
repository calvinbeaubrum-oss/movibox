package com.transsion.payment.lib.strategy;

import androidx.appcompat.app.AppCompatActivity;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.transsion.payment.lib.strategy.PaynicornStrategy$requestPay$1", f = "PaynicornStrategy.kt", l = {95}, m = "invokeSuspend")
public final class PaynicornStrategy$requestPay$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ CreateOrderReq $orderRequest;
    final /* synthetic */ com.transsion.payment.lib.b $payCallback;
    int label;
    final /* synthetic */ PaynicornStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaynicornStrategy$requestPay$1(PaynicornStrategy paynicornStrategy, CreateOrderReq createOrderReq, AppCompatActivity appCompatActivity, com.transsion.payment.lib.b bVar, Continuation<? super PaynicornStrategy$requestPay$1> continuation) {
        super(2, continuation);
        this.this$0 = paynicornStrategy;
        this.$orderRequest = createOrderReq;
        this.$activity = appCompatActivity;
        this.$payCallback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaynicornStrategy$requestPay$1(this.this$0, this.$orderRequest, this.$activity, this.$payCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PaynicornStrategy$requestPay$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String code;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PaymentService paymentServiceH = this.this$0.h();
            String productId = this.$orderRequest.getProductId();
            String cpFrontPage = this.$orderRequest.getCpFrontPage();
            this.label = 1;
            obj = paymentServiceH.g(productId, cpFrontPage, this);
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
            com.transsion.payment.lib.b.a.a(this.$payCallback, (baseDto == null || (code = baseDto.getCode()) == null) ? null : Boxing.d(Integer.parseInt(code)), String.valueOf(baseDto != null ? baseDto.getMsg() : null), false, null, 8, null);
        } else {
            PaynicornStrategy paynicornStrategy = this.this$0;
            AppCompatActivity appCompatActivity = this.$activity;
            Object data = baseDto.getData();
            Intrinsics.d(data);
            paynicornStrategy.i(appCompatActivity, (CreateOrderRes) data, this.$payCallback);
        }
        return Unit.f68710a;
    }
}
