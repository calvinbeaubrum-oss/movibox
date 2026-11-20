package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.text.l;
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
public final class ValidDispatchTimeHandler extends a {
    /* JADX WARN: Code duplicated, block: B:54:0x0127  */
    /* JADX WARN: Code duplicated, block: B:64:0x0142  */
    /* JADX WARN: Code duplicated, block: B:66:0x0154 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x0155  */
    /* JADX WARN: Code duplicated, block: B:70:0x015a  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        ValidDispatchTimeHandler$doHandle$1 validDispatchTimeHandler$doHandle$1;
        ValidDispatchTimeHandler validDispatchTimeHandler;
        ValidDispatchTimeHandler validDispatchTimeHandler2;
        AdPlansHitResponse adPlansHitResponse;
        a aVarC;
        ValidDispatchTimeHandler validDispatchTimeHandler3;
        AdPlansHitResponse adPlansHitResponse2;
        AdPlansHitResponse adPlansHitResponse3;
        String str2 = str;
        MbAdDbPlans mbAdDbPlans2 = mbAdDbPlans;
        Map<String, ? extends Object> map2 = map;
        if (continuation instanceof ValidDispatchTimeHandler$doHandle$1) {
            validDispatchTimeHandler$doHandle$1 = (ValidDispatchTimeHandler$doHandle$1) continuation;
            int i11 = validDispatchTimeHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                validDispatchTimeHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                validDispatchTimeHandler$doHandle$1 = new ValidDispatchTimeHandler$doHandle$1(this, continuation);
            }
        } else {
            validDispatchTimeHandler$doHandle$1 = new ValidDispatchTimeHandler$doHandle$1(this, continuation);
        }
        Object objB = validDispatchTimeHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = validDispatchTimeHandler$doHandle$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            long jD = k.f80682a.d();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            String dispatchTimeStart = mbAdDbPlans2 != null ? mbAdDbPlans.getDispatchTimeStart() : null;
            String dispatchTimeEnd = mbAdDbPlans2 != null ? mbAdDbPlans.getDispatchTimeEnd() : null;
            if (dispatchTimeStart == null || l.y(dispatchTimeStart) || dispatchTimeEnd == null || l.y(dispatchTimeEnd)) {
                a aVarC2 = c();
                if (aVarC2 != null) {
                    validDispatchTimeHandler$doHandle$1.L$0 = this;
                    validDispatchTimeHandler$doHandle$1.label = 1;
                    objB = aVarC2.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                    if (objB == objE) {
                        return objE;
                    }
                    validDispatchTimeHandler = this;
                    adPlansHitResponse = (AdPlansHitResponse) objB;
                    if (adPlansHitResponse != null) {
                        return adPlansHitResponse;
                    }
                } else {
                    validDispatchTimeHandler = this;
                }
                return validDispatchTimeHandler.e();
            }
            try {
                Calendar calendar = Calendar.getInstance();
                Date time = calendar.getTime();
                Calendar calendar2 = Calendar.getInstance();
                Date date = simpleDateFormat.parse(dispatchTimeStart);
                if (date == null) {
                    date = time;
                }
                calendar2.setTime(date);
                calendar2.set(1, calendar.get(1));
                calendar2.set(2, calendar.get(2));
                calendar2.set(5, calendar.get(5));
                long timeInMillis = calendar2.getTimeInMillis();
                Calendar calendar3 = Calendar.getInstance();
                Date date2 = simpleDateFormat.parse(dispatchTimeEnd);
                if (date2 == null) {
                    date2 = time;
                }
                calendar3.setTime(date2);
                calendar3.set(1, calendar.get(1));
                calendar3.set(2, calendar.get(2));
                calendar3.set(5, calendar.get(5));
                long timeInMillis2 = calendar3.getTimeInMillis();
                if (timeInMillis > jD || jD > timeInMillis2) {
                    return new AdPlansHitResponse(false, "当前不在展示时间内--时间段");
                }
                a aVarC3 = c();
                if (aVarC3 != null) {
                    validDispatchTimeHandler$doHandle$1.L$0 = this;
                    validDispatchTimeHandler$doHandle$1.L$1 = str2;
                    validDispatchTimeHandler$doHandle$1.L$2 = mbAdDbPlans2;
                    validDispatchTimeHandler$doHandle$1.L$3 = map2;
                    validDispatchTimeHandler$doHandle$1.label = 2;
                    objB = aVarC3.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                    if (objB == objE) {
                        return objE;
                    }
                    validDispatchTimeHandler2 = this;
                    adPlansHitResponse2 = (AdPlansHitResponse) objB;
                    if (adPlansHitResponse2 != null) {
                        return adPlansHitResponse2;
                    }
                } else {
                    validDispatchTimeHandler2 = this;
                }
                return validDispatchTimeHandler2.e();
            } catch (ParseException unused) {
                validDispatchTimeHandler2 = this;
                aVarC = validDispatchTimeHandler2.c();
                if (aVarC != null) {
                    validDispatchTimeHandler$doHandle$1.L$0 = validDispatchTimeHandler2;
                    validDispatchTimeHandler$doHandle$1.L$1 = null;
                    validDispatchTimeHandler$doHandle$1.L$2 = null;
                    validDispatchTimeHandler$doHandle$1.L$3 = null;
                    validDispatchTimeHandler$doHandle$1.label = 3;
                    objB = aVarC.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                    if (objB == objE) {
                        return objE;
                    }
                    validDispatchTimeHandler3 = validDispatchTimeHandler2;
                    adPlansHitResponse3 = (AdPlansHitResponse) objB;
                    if (adPlansHitResponse3 == null) {
                        return adPlansHitResponse3;
                    }
                    validDispatchTimeHandler2 = validDispatchTimeHandler3;
                }
                return validDispatchTimeHandler2.e();
            }
        }
        if (i12 == 1) {
            validDispatchTimeHandler = (ValidDispatchTimeHandler) validDispatchTimeHandler$doHandle$1.L$0;
            ResultKt.b(objB);
            adPlansHitResponse = (AdPlansHitResponse) objB;
            if (adPlansHitResponse != null) {
                return adPlansHitResponse;
            }
            return validDispatchTimeHandler.e();
        }
        if (i12 == 2) {
            Map<String, ? extends Object> map3 = (Map) validDispatchTimeHandler$doHandle$1.L$3;
            mbAdDbPlans2 = (MbAdDbPlans) validDispatchTimeHandler$doHandle$1.L$2;
            String str3 = (String) validDispatchTimeHandler$doHandle$1.L$1;
            validDispatchTimeHandler2 = (ValidDispatchTimeHandler) validDispatchTimeHandler$doHandle$1.L$0;
            try {
                ResultKt.b(objB);
                map2 = map3;
                str2 = str3;
                try {
                    adPlansHitResponse2 = (AdPlansHitResponse) objB;
                    if (adPlansHitResponse2 != null) {
                        return validDispatchTimeHandler2.e();
                    }
                    return adPlansHitResponse2;
                } catch (ParseException unused2) {
                    aVarC = validDispatchTimeHandler2.c();
                    if (aVarC != null) {
                        validDispatchTimeHandler$doHandle$1.L$0 = validDispatchTimeHandler2;
                        validDispatchTimeHandler$doHandle$1.L$1 = null;
                        validDispatchTimeHandler$doHandle$1.L$2 = null;
                        validDispatchTimeHandler$doHandle$1.L$3 = null;
                        validDispatchTimeHandler$doHandle$1.label = 3;
                        objB = aVarC.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                        if (objB == objE) {
                            return objE;
                        }
                        validDispatchTimeHandler3 = validDispatchTimeHandler2;
                        adPlansHitResponse3 = (AdPlansHitResponse) objB;
                        if (adPlansHitResponse3 == null) {
                            return adPlansHitResponse3;
                        }
                        validDispatchTimeHandler2 = validDispatchTimeHandler3;
                    }
                    return validDispatchTimeHandler2.e();
                }
            } catch (ParseException unused3) {
                map2 = map3;
                str2 = str3;
                aVarC = validDispatchTimeHandler2.c();
                if (aVarC != null) {
                    validDispatchTimeHandler$doHandle$1.L$0 = validDispatchTimeHandler2;
                    validDispatchTimeHandler$doHandle$1.L$1 = null;
                    validDispatchTimeHandler$doHandle$1.L$2 = null;
                    validDispatchTimeHandler$doHandle$1.L$3 = null;
                    validDispatchTimeHandler$doHandle$1.label = 3;
                    objB = aVarC.b(str2, mbAdDbPlans2, map2, validDispatchTimeHandler$doHandle$1);
                    if (objB == objE) {
                        return objE;
                    }
                    validDispatchTimeHandler3 = validDispatchTimeHandler2;
                    adPlansHitResponse3 = (AdPlansHitResponse) objB;
                    if (adPlansHitResponse3 == null) {
                        return adPlansHitResponse3;
                    }
                    validDispatchTimeHandler2 = validDispatchTimeHandler3;
                }
                return validDispatchTimeHandler2.e();
            }
        }
        if (i12 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        validDispatchTimeHandler3 = (ValidDispatchTimeHandler) validDispatchTimeHandler$doHandle$1.L$0;
        ResultKt.b(objB);
        adPlansHitResponse3 = (AdPlansHitResponse) objB;
        if (adPlansHitResponse3 == null) {
            return adPlansHitResponse3;
        }
        validDispatchTimeHandler2 = validDispatchTimeHandler3;
        return validDispatchTimeHandler2.e();
    }
}
