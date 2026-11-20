package com.transsion.ad.ps;

import android.text.TextUtils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.transsion.ad.ps.PsAdPlanRetryManager$retry$1", f = "PsAdPlanRetryManager.kt", l = {41}, m = "invokeSuspend")
public final class PsAdPlanRetryManager$retry$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ MbAdDbPlans $plan;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PsAdPlanRetryManager$retry$1(MbAdDbPlans mbAdDbPlans, Continuation<? super PsAdPlanRetryManager$retry$1> continuation) {
        super(2, continuation);
        this.$plan = mbAdDbPlans;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PsAdPlanRetryManager$retry$1(this.$plan, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PsAdPlanRetryManager$retry$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String id2;
        MbAdDbPlans mbAdDbPlans;
        String extAdSlot;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            MbAdDbPlans mbAdDbPlans2 = this.$plan;
            int i12 = 14;
            if (!TextUtils.isEmpty(mbAdDbPlans2 != null ? mbAdDbPlans2.getExtAdSlot() : null) && (mbAdDbPlans = this.$plan) != null && (extAdSlot = mbAdDbPlans.getExtAdSlot()) != null) {
                i12 = Integer.parseInt(extAdSlot);
            }
            PSAdPlanRequestManager pSAdPlanRequestManager = PSAdPlanRequestManager.f50545a;
            Integer numD = Boxing.d(i12);
            MbAdDbPlans mbAdDbPlans3 = this.$plan;
            if (mbAdDbPlans3 == null || (id2 = mbAdDbPlans3.getId()) == null) {
                id2 = "";
            }
            String str = id2;
            this.label = 1;
            if (pSAdPlanRequestManager.l(0, false, 10, numD, str, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
