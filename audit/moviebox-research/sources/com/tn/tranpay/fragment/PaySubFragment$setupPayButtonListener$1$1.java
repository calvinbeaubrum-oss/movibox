package com.tn.tranpay.fragment;

import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.viewmodel.PaymentViewModel;
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
@DebugMetadata(c = "com.tn.tranpay.fragment.PaySubFragment$setupPayButtonListener$1$1", f = "PaySubFragment.kt", l = {}, m = "invokeSuspend")
public final class PaySubFragment$setupPayButtonListener$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PaySubFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaySubFragment$setupPayButtonListener$1$1(PaySubFragment paySubFragment, Continuation<? super PaySubFragment$setupPayButtonListener$1$1> continuation) {
        super(2, continuation);
        this.this$0 = paySubFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaySubFragment$setupPayButtonListener$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PaySubFragment$setupPayButtonListener$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!this.this$0.f50140n) {
            return Unit.f68710a;
        }
        this.this$0.f50140n = false;
        np.b bVar = this.this$0.f50137k;
        np.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        String strValueOf = String.valueOf(bVar.f72106f.getText());
        np.b bVar3 = this.this$0.f50137k;
        if (bVar3 == null) {
            Intrinsics.y("viewBinding");
        } else {
            bVar2 = bVar3;
        }
        String strValueOf2 = String.valueOf(bVar2.f72105d.getText());
        PaymentMMKV paymentMMKV = PaymentMMKV.f50174a;
        paymentMMKV.a().putString("k_phone_number", strValueOf);
        paymentMMKV.a().putString("k_cnic_number", strValueOf2);
        PaymentViewModel.k(this.this$0.t0(), this.this$0.s0(), strValueOf, strValueOf2, false, 8, null);
        return Unit.f68710a;
    }
}
