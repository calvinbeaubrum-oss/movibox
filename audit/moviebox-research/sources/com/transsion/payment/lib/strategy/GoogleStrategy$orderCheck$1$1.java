package com.transsion.payment.lib.strategy;

import com.android.billingclient.api.Purchase;
import com.transsion.payment.lib.PaymentService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$orderCheck$1$1", f = "GoogleStrategy.kt", l = {186}, m = "invokeSuspend")
@SourceDebugExtension
public final class GoogleStrategy$orderCheck$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Purchase> $purchaseList;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleStrategy$orderCheck$1$1(List<Purchase> list, GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$orderCheck$1$1> continuation) {
        super(2, continuation);
        this.$purchaseList = list;
        this.this$0 = googleStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$orderCheck$1$1(this.$purchaseList, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((GoogleStrategy$orderCheck$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        GoogleStrategy googleStrategy;
        Iterator it;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            List<Purchase> purchaseList = this.$purchaseList;
            Intrinsics.f(purchaseList, "purchaseList");
            googleStrategy = this.this$0;
            it = purchaseList.iterator();
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$1;
            googleStrategy = (GoogleStrategy) this.L$0;
            ResultKt.b(obj);
        }
        while (it.hasNext()) {
            Purchase purchase = (Purchase) it.next();
            com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.f54044a;
            dVar.a("fetch purchase result: state " + purchase.e() + " " + purchase.g() + " result size: " + purchase.f());
            if (purchase.e() != 1) {
                dVar.c("遇到未发货订单 fetch purchase result: state " + purchase.e() + " " + purchase.g() + " result size: " + purchase.f());
                com.android.billingclient.api.a aVarA = purchase.a();
                String strA = aVarA != null ? aVarA.a() : null;
                String strG = purchase.g();
                Intrinsics.f(strG, "it.purchaseToken");
                String strB = purchase.b();
                List<String> listD = purchase.d();
                String str = listD != null ? listD.get(0) : null;
                PaymentService paymentServiceW = googleStrategy.w();
                this.L$0 = googleStrategy;
                this.L$1 = it;
                this.label = 1;
                if (paymentServiceW.e(str, strG, strA, strB, this) == objE) {
                    return objE;
                }
            }
        }
        return Unit.f68710a;
    }
}
