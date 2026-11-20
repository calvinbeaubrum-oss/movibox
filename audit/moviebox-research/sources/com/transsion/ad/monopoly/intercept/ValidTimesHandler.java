package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

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
public final class ValidTimesHandler extends a {
    /* JADX WARN: Code duplicated, block: B:36:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        ValidTimesHandler$doHandle$1 validTimesHandler$doHandle$1;
        ValidTimesHandler validTimesHandler;
        String str2;
        int i11;
        Integer displayTimes;
        ValidTimesHandler validTimesHandler2;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof ValidTimesHandler$doHandle$1) {
            validTimesHandler$doHandle$1 = (ValidTimesHandler$doHandle$1) continuation;
            int i12 = validTimesHandler$doHandle$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                validTimesHandler$doHandle$1.label = i12 - Integer.MIN_VALUE;
            } else {
                validTimesHandler$doHandle$1 = new ValidTimesHandler$doHandle$1(this, continuation);
            }
        } else {
            validTimesHandler$doHandle$1 = new ValidTimesHandler$doHandle$1(this, continuation);
        }
        Object objB = validTimesHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = validTimesHandler$doHandle$1.label;
        if (i13 != 0) {
            if (i13 == 1) {
                i11 = validTimesHandler$doHandle$1.I$0;
                map = (Map) validTimesHandler$doHandle$1.L$3;
                mbAdDbPlans = (MbAdDbPlans) validTimesHandler$doHandle$1.L$2;
                str2 = (String) validTimesHandler$doHandle$1.L$1;
                validTimesHandler = (ValidTimesHandler) validTimesHandler$doHandle$1.L$0;
                ResultKt.b(objB);
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                validTimesHandler2 = (ValidTimesHandler) validTimesHandler$doHandle$1.L$0;
                ResultKt.b(objB);
            }
            adPlansHitResponse = (AdPlansHitResponse) objB;
            if (adPlansHitResponse == null) {
                return adPlansHitResponse;
            }
            validTimesHandler = validTimesHandler2;
            return validTimesHandler.e();
        }
        ResultKt.b(objB);
        int iIntValue = (mbAdDbPlans == null || (displayTimes = mbAdDbPlans.getDisplayTimes()) == null) ? 0 : displayTimes.intValue();
        NonAdShowedTimesManager nonAdShowedTimesManager = NonAdShowedTimesManager.f50524a;
        validTimesHandler$doHandle$1.L$0 = this;
        validTimesHandler$doHandle$1.L$1 = str;
        validTimesHandler$doHandle$1.L$2 = mbAdDbPlans;
        validTimesHandler$doHandle$1.L$3 = map;
        validTimesHandler$doHandle$1.I$0 = iIntValue;
        validTimesHandler$doHandle$1.label = 1;
        Object objB2 = nonAdShowedTimesManager.b(mbAdDbPlans, validTimesHandler$doHandle$1);
        if (objB2 == objE) {
            return objE;
        }
        validTimesHandler = this;
        str2 = str;
        i11 = iIntValue;
        objB = objB2;
        if (((Number) objB).intValue() >= i11) {
            return new AdPlansHitResponse(false, "展示次数已经达到上限");
        }
        a aVarC = validTimesHandler.c();
        if (aVarC != null) {
            validTimesHandler$doHandle$1.L$0 = validTimesHandler;
            validTimesHandler$doHandle$1.L$1 = null;
            validTimesHandler$doHandle$1.L$2 = null;
            validTimesHandler$doHandle$1.L$3 = null;
            validTimesHandler$doHandle$1.label = 2;
            objB = aVarC.b(str2, mbAdDbPlans, map, validTimesHandler$doHandle$1);
            if (objB == objE) {
                return objE;
            }
            validTimesHandler2 = validTimesHandler;
            adPlansHitResponse = (AdPlansHitResponse) objB;
            if (adPlansHitResponse == null) {
                return adPlansHitResponse;
            }
            validTimesHandler = validTimesHandler2;
        }
        return validTimesHandler.e();
    }
}
