package com.tn.tranpay.viewmodel;

import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
import dq.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
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
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel$queryOnce$1", f = "PaymentViewModel.kt", l = {324}, m = "invokeSuspend")
public final class PaymentViewModel$queryOnce$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $txnId;
    int label;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentViewModel$queryOnce$1(PaymentViewModel paymentViewModel, String str, Continuation<? super PaymentViewModel$queryOnce$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentViewModel;
        this.$txnId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentViewModel$queryOnce$1(this.this$0, this.$txnId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PaymentViewModel$queryOnce$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x011d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PaymentViewModel paymentViewModel = this.this$0;
            String str = this.$txnId;
            this.label = 1;
            obj = paymentViewModel.D(str, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        QueryOrderResultContent queryOrderResultContent = (QueryOrderResultContent) obj;
        fq.a aVar = fq.a.f65215a;
        fq.a.g(aVar, "CancelOrder result = " + queryOrderResultContent, null, 2, null);
        if (queryOrderResultContent != null) {
            fq.a.g(aVar, "CancelOrder.content =  " + queryOrderResultContent.getStatus() + ", " + queryOrderResultContent.getMessage(), null, 2, null);
        }
        fq.a.g(aVar, "QueryOrder result = " + queryOrderResultContent, null, 2, null);
        if (queryOrderResultContent != null) {
            fq.a.g(aVar, "QueryOrder.content =  " + queryOrderResultContent.getStatus() + ", " + queryOrderResultContent.getCode() + ", " + queryOrderResultContent.getMessage(), null, 2, null);
            String status = queryOrderResultContent.getStatus();
            if (status == null) {
                fq.a.k(aVar, "Unknown status", null, 2, null);
                this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.FAILURE));
            } else {
                int iHashCode = status.hashCode();
                if (iHashCode != 48) {
                    if (iHashCode != 49) {
                        if (iHashCode == 1444 && status.equals("-1")) {
                            fq.a.k(aVar, "Order still processing", null, 2, null);
                            this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.PROCESSING));
                        } else {
                            fq.a.k(aVar, "Unknown status", null, 2, null);
                            this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.FAILURE));
                        }
                    } else if (status.equals("1")) {
                        fq.a.g(aVar, "QueryOrder.content success", null, 2, null);
                        this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.SUCCESS));
                    } else {
                        fq.a.k(aVar, "Unknown status", null, 2, null);
                        this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.FAILURE));
                    }
                } else if (status.equals("0")) {
                    fq.a.e(aVar, "QueryOrder.content fail", null, 2, null);
                    this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.FAILURE));
                } else {
                    fq.a.k(aVar, "Unknown status", null, 2, null);
                    this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.FAILURE));
                }
            }
        } else {
            this.this$0.z().n(new b(null, QueryStatus.ERROR));
        }
        return Unit.f68710a;
    }
}
