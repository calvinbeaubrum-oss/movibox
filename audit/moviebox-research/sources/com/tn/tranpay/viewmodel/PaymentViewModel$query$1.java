package com.tn.tranpay.viewmodel;

import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
import com.tn.tranpay.helper.PayUtils;
import dq.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel$query$1", f = "PaymentViewModel.kt", l = {390}, m = "invokeSuspend")
public final class PaymentViewModel$query$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $maxTotalTimeMills;
    final /* synthetic */ long $retryIntervalMills;
    final /* synthetic */ String $txnId;
    int label;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX INFO: renamed from: com.tn.tranpay.viewmodel.PaymentViewModel$query$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel$query$1$1", f = "PaymentViewModel.kt", l = {391}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $txnId;
        int label;
        final /* synthetic */ PaymentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PaymentViewModel paymentViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = paymentViewModel;
            this.$txnId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$txnId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
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
            fq.a.g(aVar, "QueryOrder result = " + queryOrderResultContent, null, 2, null);
            if (queryOrderResultContent == null) {
                this.this$0.z().n(new b(null, QueryStatus.ERROR));
                return Unit.f68710a;
            }
            fq.a.g(aVar, "QueryOrder.content =  " + queryOrderResultContent.getStatus() + ", " + queryOrderResultContent.getCode() + ", " + queryOrderResultContent.getMessage(), null, 2, null);
            String status = queryOrderResultContent.getStatus();
            if (status != null) {
                int iHashCode = status.hashCode();
                if (iHashCode != 48) {
                    if (iHashCode != 49) {
                        if (iHashCode == 1444 && status.equals("-1")) {
                            throw new Exception("Order still processing");
                        }
                    } else if (status.equals("1")) {
                        fq.a.g(aVar, "QueryOrder.content success", null, 2, null);
                        this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.SUCCESS));
                        return Unit.f68710a;
                    }
                } else if (status.equals("0")) {
                    fq.a.e(aVar, "QueryOrder.content fail", null, 2, null);
                    this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.FAILURE));
                    return Unit.f68710a;
                }
            }
            fq.a.k(aVar, "Unknown status", null, 2, null);
            this.this$0.z().n(new b(queryOrderResultContent, QueryStatus.FAILURE));
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentViewModel$query$1(long j11, long j12, PaymentViewModel paymentViewModel, String str, Continuation<? super PaymentViewModel$query$1> continuation) {
        super(2, continuation);
        this.$retryIntervalMills = j11;
        this.$maxTotalTimeMills = j12;
        this.this$0 = paymentViewModel;
        this.$txnId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentViewModel$query$1(this.$retryIntervalMills, this.$maxTotalTimeMills, this.this$0, this.$txnId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PaymentViewModel$query$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                PayUtils payUtils = PayUtils.f50173a;
                long j11 = this.$retryIntervalMills;
                long j12 = this.$maxTotalTimeMills;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$txnId, null);
                this.label = 1;
                if (payUtils.h(j11, j12, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (CancellationException unused) {
            fq.a.g(fq.a.f65215a, "Query operation was cancelled", null, 2, null);
            this.this$0.z().n(new b(null, QueryStatus.CANCELLED));
        } catch (TimeoutException e11) {
            fq.a.g(fq.a.f65215a, "QueryOrder timed out: " + e11.getMessage(), null, 2, null);
            this.this$0.z().n(new b(null, QueryStatus.PROCESSING));
        } catch (Exception e12) {
            fq.a.e(fq.a.f65215a, "QueryOrder failed: " + e12.getMessage(), null, 2, null);
            this.this$0.z().n(new b(null, QueryStatus.ERROR));
        }
        return Unit.f68710a;
    }
}
