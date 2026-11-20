package com.transsion.payment.lib;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import com.transsion.payment.lib.bean.CreateOrderRes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.internal.ws.WebSocketProtocol;

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
@DebugMetadata(c = "com.transsion.payment.lib.PaymentClientHelper$realPay$1$onPurchasesUpdated$1", f = "PaymentClientHelper.kt", l = {WebSocketProtocol.PAYLOAD_SHORT}, m = "invokeSuspend")
public final class PaymentClientHelper$realPay$1$onPurchasesUpdated$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreateOrderRes $orderRequest;
    final /* synthetic */ b $payCallback;
    final /* synthetic */ PaymentService $paymentService;
    int label;

    /* JADX INFO: renamed from: com.transsion.payment.lib.PaymentClientHelper$realPay$1$onPurchasesUpdated$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.payment.lib.PaymentClientHelper$realPay$1$onPurchasesUpdated$1$1", f = "PaymentClientHelper.kt", l = {128}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ CreateOrderRes $orderRequest;
        final /* synthetic */ b $payCallback;
        final /* synthetic */ PaymentService $paymentService;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PaymentService paymentService, CreateOrderRes createOrderRes, b bVar, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$paymentService = paymentService;
            this.$orderRequest = createOrderRes;
            this.$payCallback = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$paymentService, this.$orderRequest, this.$payCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            String balanceCoin;
            String addCoin;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                PaymentService paymentService = this.$paymentService;
                String tradingOrderId = this.$orderRequest.getTradingOrderId();
                this.label = 1;
                obj = paymentService.d(tradingOrderId, this);
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
                d.f54044a.b(PaymentClientHelper.f54031a.b() + " --> realPay() --> orderCheckResult?.code = " + (baseDto != null ? baseDto.getCode() : null) + " -- orderCheckResult?.msg = " + (baseDto != null ? baseDto.getMsg() : null) + " -- 接口请求失败");
                throw new Exception(baseDto != null ? baseDto.getMsg() : null);
            }
            d.f54044a.a(PaymentClientHelper.f54031a.b() + " --> realPay() --> paynicorn 发货成功");
            int i12 = 0;
            this.$payCallback.b(false);
            b bVar = this.$payCallback;
            CheckPaymentBean checkPaymentBean = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean != null && (addCoin = checkPaymentBean.getAddCoin()) != null) {
                i12 = Integer.parseInt(addCoin);
            }
            CheckPaymentBean checkPaymentBean2 = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean2 == null || (balanceCoin = checkPaymentBean2.getBalanceCoin()) == null) {
                balanceCoin = "";
            }
            bVar.c(i12, balanceCoin, this.$orderRequest.getTradingOrderId());
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentClientHelper$realPay$1$onPurchasesUpdated$1(b bVar, CreateOrderRes createOrderRes, PaymentService paymentService, Continuation<? super PaymentClientHelper$realPay$1$onPurchasesUpdated$1> continuation) {
        super(2, continuation);
        this.$payCallback = bVar;
        this.$orderRequest = createOrderRes;
        this.$paymentService = paymentService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentClientHelper$realPay$1$onPurchasesUpdated$1(this.$payCallback, this.$orderRequest, this.$paymentService, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PaymentClientHelper$realPay$1$onPurchasesUpdated$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                PayUtils payUtils = PayUtils.f54030a;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$paymentService, this.$orderRequest, this.$payCallback, null);
                this.label = 1;
                if (PayUtils.b(payUtils, 0L, 0, anonymousClass1, this, 3, null) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e11) {
            d.f54044a.b(PaymentClientHelper.f54031a.b() + " --> realPay() --> handlePurchase 发货进行中ing --> e = " + e11.getMessage());
            this.$payCallback.b(false);
            this.$payCallback.a(Boxing.d(-30), e11.getMessage(), false, this.$orderRequest.getTradingOrderId());
        }
        return Unit.f68710a;
    }
}
