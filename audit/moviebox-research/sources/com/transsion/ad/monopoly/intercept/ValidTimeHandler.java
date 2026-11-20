package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import xq.k;

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
public final class ValidTimeHandler extends a {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        ValidTimeHandler$doHandle$1 validTimeHandler$doHandle$1;
        ValidTimeHandler validTimeHandler;
        String endTime;
        String startTime;
        if (continuation instanceof ValidTimeHandler$doHandle$1) {
            validTimeHandler$doHandle$1 = (ValidTimeHandler$doHandle$1) continuation;
            int i11 = validTimeHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                validTimeHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                validTimeHandler$doHandle$1 = new ValidTimeHandler$doHandle$1(this, continuation);
            }
        } else {
            validTimeHandler$doHandle$1 = new ValidTimeHandler$doHandle$1(this, continuation);
        }
        Object objB = validTimeHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = validTimeHandler$doHandle$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            long jD = k.f80682a.d();
            long j11 = 0;
            long j12 = (mbAdDbPlans == null || (startTime = mbAdDbPlans.getStartTime()) == null) ? 0L : Long.parseLong(startTime);
            if (mbAdDbPlans != null && (endTime = mbAdDbPlans.getEndTime()) != null) {
                j11 = Long.parseLong(endTime);
            }
            if (j12 > jD || jD > j11) {
                return new AdPlansHitResponse(false, "当前不在展示时间内--有效期");
            }
            a aVarC = c();
            if (aVarC != null) {
                validTimeHandler$doHandle$1.L$0 = this;
                validTimeHandler$doHandle$1.label = 1;
                objB = aVarC.b(str, mbAdDbPlans, map, validTimeHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                validTimeHandler = this;
            } else {
                validTimeHandler = this;
            }
            return validTimeHandler.e();
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        validTimeHandler = (ValidTimeHandler) validTimeHandler$doHandle$1.L$0;
        ResultKt.b(objB);
        AdPlansHitResponse adPlansHitResponse = (AdPlansHitResponse) objB;
        if (adPlansHitResponse != null) {
            return adPlansHitResponse;
        }
        return validTimeHandler.e();
    }
}
