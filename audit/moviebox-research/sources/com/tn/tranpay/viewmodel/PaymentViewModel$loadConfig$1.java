package com.tn.tranpay.viewmodel;

import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel$loadConfig$1", f = "PaymentViewModel.kt", l = {116}, m = "invokeSuspend")
@SourceDebugExtension
public final class PaymentViewModel$loadConfig$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingParams $params;
    int label;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentViewModel$loadConfig$1(PaymentViewModel paymentViewModel, BillingParams billingParams, Continuation<? super PaymentViewModel$loadConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentViewModel;
        this.$params = billingParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentViewModel$loadConfig$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PaymentViewModel$loadConfig$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Map<String, String> mapH;
        List<MediumInputBean> medium;
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PaymentViewModel paymentViewModel = this.this$0;
            String txnId = this.$params.getTxnId();
            String language = this.$params.getLanguage();
            this.label = 1;
            obj = paymentViewModel.F(txnId, language, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        LoadConfigContent loadConfigContent = (LoadConfigContent) obj;
        fq.a.g(fq.a.f65215a, "GetPaymentMethods result = " + this.this$0.f50204m.toJson(loadConfigContent), null, 2, null);
        if (loadConfigContent == null || (mapH = loadConfigContent.getLanguagePackage()) == null) {
            mapH = s.h();
        }
        if (loadConfigContent != null && (medium = loadConfigContent.getMedium()) != null) {
            for (MediumInputBean mediumInputBean : medium) {
                fq.a.c(fq.a.f65215a, "The medium.name: " + mediumInputBean.getName() + ", " + mediumInputBean.getCode(), null, 2, null);
                List<InputInfoBean> inputs = mediumInputBean.getInputs();
                if (inputs != null) {
                    for (InputInfoBean inputInfoBean : inputs) {
                        String tips = mapH.get(inputInfoBean.getTips());
                        String hint = mapH.get(inputInfoBean.getHint());
                        fq.a.c(fq.a.f65215a, "InputTip: " + tips + ", hint: " + hint, null, 2, null);
                        String realHint = inputInfoBean.getRealHint();
                        if (realHint != null) {
                            hint = realHint;
                        } else if (hint == null) {
                            hint = inputInfoBean.getHint();
                        }
                        inputInfoBean.setRealHint(hint);
                        String realTips = inputInfoBean.getRealTips();
                        if (realTips != null) {
                            tips = realTips;
                        } else if (tips == null) {
                            tips = inputInfoBean.getTips();
                        }
                        inputInfoBean.setRealTips(tips);
                    }
                }
            }
        }
        if (loadConfigContent != null) {
            this.this$0.q().n(loadConfigContent);
        } else {
            this.this$0.q().n(null);
        }
        return Unit.f68710a;
    }
}
