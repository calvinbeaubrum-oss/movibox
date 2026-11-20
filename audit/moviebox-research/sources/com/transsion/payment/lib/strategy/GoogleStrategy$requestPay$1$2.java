package com.transsion.payment.lib.strategy;

import android.text.TextUtils;
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
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$requestPay$1$2", f = "GoogleStrategy.kt", l = {95}, m = "invokeSuspend")
public final class GoogleStrategy$requestPay$1$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ CreateOrderReq $createOrderReq;
    final /* synthetic */ com.transsion.payment.lib.b $payCallback;
    final /* synthetic */ boolean $subscriptOrder;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleStrategy$requestPay$1$2(GoogleStrategy googleStrategy, CreateOrderReq createOrderReq, AppCompatActivity appCompatActivity, boolean z11, com.transsion.payment.lib.b bVar, Continuation<? super GoogleStrategy$requestPay$1$2> continuation) {
        super(2, continuation);
        this.this$0 = googleStrategy;
        this.$createOrderReq = createOrderReq;
        this.$activity = appCompatActivity;
        this.$subscriptOrder = z11;
        this.$payCallback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$requestPay$1$2(this.this$0, this.$createOrderReq, this.$activity, this.$subscriptOrder, this.$payCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((GoogleStrategy$requestPay$1$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:36:0x0096  */
    /* JADX WARN: Code duplicated, block: B:38:0x0099  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Integer numD;
        String code;
        String tradingOrderId;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PaymentService paymentServiceW = this.this$0.w();
            String productId = this.$createOrderReq.getProductId();
            String cpFrontPage = this.$createOrderReq.getCpFrontPage();
            this.label = 1;
            obj = paymentServiceW.f(productId, cpFrontPage, this);
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
        if (Intrinsics.b(baseDto != null ? baseDto.getCode() : null, "0")) {
            CreateOrderRes createOrderRes = (CreateOrderRes) baseDto.getData();
            if (TextUtils.isEmpty(createOrderRes != null ? createOrderRes.getTradingOrderId() : null)) {
                com.transsion.payment.lib.b bVar = this.$payCallback;
                if (baseDto != null) {
                    numD = null;
                } else {
                    numD = null;
                }
                com.transsion.payment.lib.b.a.a(bVar, numD, String.valueOf(baseDto != null ? baseDto.getMsg() : null), false, null, 8, null);
            } else {
                CreateOrderRes createOrderRes2 = (CreateOrderRes) baseDto.getData();
                if (createOrderRes2 == null || (tradingOrderId = createOrderRes2.getTradingOrderId()) == null) {
                    tradingOrderId = "";
                }
                this.this$0.C(this.$activity, this.$createOrderReq.getProductId(), tradingOrderId, this.$subscriptOrder, this.$payCallback);
            }
        } else {
            com.transsion.payment.lib.b bVar2 = this.$payCallback;
            if (baseDto != null || (code = baseDto.getCode()) == null) {
                numD = null;
            } else {
                numD = Boxing.d(Integer.parseInt(code));
            }
            com.transsion.payment.lib.b.a.a(bVar2, numD, String.valueOf(baseDto != null ? baseDto.getMsg() : null), false, null, 8, null);
        }
        return Unit.f68710a;
    }
}
