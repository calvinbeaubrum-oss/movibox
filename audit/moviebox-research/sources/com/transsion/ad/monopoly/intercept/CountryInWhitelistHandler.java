package com.transsion.ad.monopoly.intercept;

import com.blankj.utilcode.util.n;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class CountryInWhitelistHandler extends a {
    /* JADX WARN: Code duplicated, block: B:32:0x0091  */
    /* JADX WARN: Code duplicated, block: B:34:0x0097  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        CountryInWhitelistHandler$doHandle$1 countryInWhitelistHandler$doHandle$1;
        Map<String, ? extends Object> map2;
        MbAdDbPlans mbAdDbPlans2;
        String str2;
        CountryInWhitelistHandler countryInWhitelistHandler;
        CountryInWhitelistHandler countryInWhitelistHandler2;
        a aVarC;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof CountryInWhitelistHandler$doHandle$1) {
            countryInWhitelistHandler$doHandle$1 = (CountryInWhitelistHandler$doHandle$1) continuation;
            int i11 = countryInWhitelistHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                countryInWhitelistHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                countryInWhitelistHandler$doHandle$1 = new CountryInWhitelistHandler$doHandle$1(this, continuation);
            }
        } else {
            countryInWhitelistHandler$doHandle$1 = new CountryInWhitelistHandler$doHandle$1(this, continuation);
        }
        Object objH = countryInWhitelistHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = countryInWhitelistHandler$doHandle$1.label;
        boolean zBooleanValue = true;
        if (i12 != 0) {
            if (i12 == 1) {
                map = (Map) countryInWhitelistHandler$doHandle$1.L$3;
                mbAdDbPlans = (MbAdDbPlans) countryInWhitelistHandler$doHandle$1.L$2;
                str = (String) countryInWhitelistHandler$doHandle$1.L$1;
                countryInWhitelistHandler2 = (CountryInWhitelistHandler) countryInWhitelistHandler$doHandle$1.L$0;
                ResultKt.b(objH);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                countryInWhitelistHandler = (CountryInWhitelistHandler) countryInWhitelistHandler$doHandle$1.L$0;
                ResultKt.b(objH);
            }
            adPlansHitResponse = (AdPlansHitResponse) objH;
            if (adPlansHitResponse != null) {
                return adPlansHitResponse;
            }
            return countryInWhitelistHandler.e();
        }
        ResultKt.b(objH);
        String country = mbAdDbPlans != null ? mbAdDbPlans.getCountry() : null;
        String[] countryFromJson = (String[]) n.d(country, String[].class);
        if (countryFromJson == null || countryFromJson.length == 0) {
            map2 = map;
            mbAdDbPlans2 = mbAdDbPlans;
            str2 = str;
            countryInWhitelistHandler = this;
        } else {
            Intrinsics.f(countryFromJson, "countryFromJson");
            countryInWhitelistHandler$doHandle$1.L$0 = this;
            countryInWhitelistHandler$doHandle$1.L$1 = str;
            countryInWhitelistHandler$doHandle$1.L$2 = mbAdDbPlans;
            countryInWhitelistHandler$doHandle$1.L$3 = map;
            countryInWhitelistHandler$doHandle$1.label = 1;
            objH = h(countryFromJson, country, countryInWhitelistHandler$doHandle$1);
            if (objH == objE) {
                return objE;
            }
            countryInWhitelistHandler2 = this;
        }
        if (zBooleanValue) {
            return new AdPlansHitResponse(false, "当前国家不在白名单中");
        }
        aVarC = countryInWhitelistHandler.c();
        if (aVarC != null) {
            countryInWhitelistHandler$doHandle$1.L$0 = countryInWhitelistHandler;
            countryInWhitelistHandler$doHandle$1.L$1 = null;
            countryInWhitelistHandler$doHandle$1.L$2 = null;
            countryInWhitelistHandler$doHandle$1.L$3 = null;
            countryInWhitelistHandler$doHandle$1.label = 2;
            objH = aVarC.b(str2, mbAdDbPlans2, map2, countryInWhitelistHandler$doHandle$1);
            if (objH == objE) {
                return objE;
            }
            adPlansHitResponse = (AdPlansHitResponse) objH;
            if (adPlansHitResponse != null) {
                return adPlansHitResponse;
            }
        }
        return countryInWhitelistHandler.e();
        zBooleanValue = ((Boolean) objH).booleanValue();
        map2 = map;
        mbAdDbPlans2 = mbAdDbPlans;
        str2 = str;
        countryInWhitelistHandler = countryInWhitelistHandler2;
        if (zBooleanValue) {
            return new AdPlansHitResponse(false, "当前国家不在白名单中");
        }
        aVarC = countryInWhitelistHandler.c();
        if (aVarC != null) {
            countryInWhitelistHandler$doHandle$1.L$0 = countryInWhitelistHandler;
            countryInWhitelistHandler$doHandle$1.L$1 = null;
            countryInWhitelistHandler$doHandle$1.L$2 = null;
            countryInWhitelistHandler$doHandle$1.L$3 = null;
            countryInWhitelistHandler$doHandle$1.label = 2;
            objH = aVarC.b(str2, mbAdDbPlans2, map2, countryInWhitelistHandler$doHandle$1);
            if (objH == objE) {
                return objE;
            }
            adPlansHitResponse = (AdPlansHitResponse) objH;
            if (adPlansHitResponse != null) {
                return adPlansHitResponse;
            }
        }
        return countryInWhitelistHandler.e();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0053  */
    /* JADX WARN: Code duplicated, block: B:19:0x0072 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0073  */
    /* JADX WARN: Code duplicated, block: B:23:0x007b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0073 -> B:12:0x0038). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object h(java.lang.String[] r10, java.lang.String r11, kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r11 = r12 instanceof com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$isCountryInWhitelist$1
            if (r11 == 0) goto L13
            r11 = r12
            com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$isCountryInWhitelist$1 r11 = (com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$isCountryInWhitelist$1) r11
            int r0 = r11.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r11.label = r0
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$isCountryInWhitelist$1 r11 = new com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$isCountryInWhitelist$1
            r11.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r11.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r11.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L43
            if (r1 != r3) goto L3b
            int r10 = r11.I$1
            int r1 = r11.I$0
            java.lang.Object r4 = r11.L$1
            java.lang.String[] r4 = (java.lang.String[]) r4
            java.lang.Object r5 = r11.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.b(r12)
            r8 = r0
            r0 = r11
            r11 = r4
        L38:
            r4 = r1
            r1 = r8
            goto L77
        L3b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            kotlin.ResultKt.b(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            int r1 = r10.length
            r5 = r12
            r12 = r11
            r11 = r10
            r10 = r1
            r1 = 0
        L51:
            if (r1 >= r10) goto L85
            r4 = r11[r1]
            com.transsion.ad.strategy.NationalInformationManager r6 = com.transsion.ad.strategy.NationalInformationManager.f50580a
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r7)
            java.lang.String r7 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.f(r4, r7)
            r12.L$0 = r5
            r12.L$1 = r11
            r12.I$0 = r1
            r12.I$1 = r10
            r12.label = r3
            java.lang.Object r4 = r6.e(r4, r12)
            if (r4 != r0) goto L73
            return r0
        L73:
            r8 = r0
            r0 = r12
            r12 = r4
            goto L38
        L77:
            com.transsion.ad.db.mcc.LocalMcc r12 = (com.transsion.ad.db.mcc.LocalMcc) r12
            if (r12 == 0) goto L7e
            r5.add(r12)
        L7e:
            int r12 = r4 + 1
            r8 = r1
            r1 = r12
            r12 = r0
            r0 = r8
            goto L51
        L85:
            com.transsion.ad.strategy.NationalInformationManager r10 = com.transsion.ad.strategy.NationalInformationManager.f50580a
            java.lang.String r10 = r10.d()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r11 = r5.iterator()
        L91:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto Lac
            java.lang.Object r12 = r11.next()
            com.transsion.ad.db.mcc.LocalMcc r12 = (com.transsion.ad.db.mcc.LocalMcc) r12
            java.lang.String r12 = r12.getMcc()
            boolean r12 = android.text.TextUtils.equals(r12, r10)
            if (r12 == 0) goto L91
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r10
        Lac:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler.h(java.lang.String[], java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
