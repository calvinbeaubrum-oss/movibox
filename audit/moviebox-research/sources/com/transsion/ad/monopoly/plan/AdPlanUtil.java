package com.transsion.ad.monopoly.plan;

import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.b;

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
public final class AdPlanUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlanUtil f50541a = new AdPlanUtil();

    public final AdMaterialList a(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        List<AdMaterialList> adMaterialList2;
        if (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null || !(!adMaterialList.isEmpty()) || (adMaterialList2 = adPlans.getAdMaterialList()) == null) {
            return null;
        }
        return adMaterialList2.get(0);
    }

    public final AdPlans b(List<AdPlans> list) {
        List<AdPlans> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.ad.monopoly.plan.AdPlanUtil$getHighestEcpmAdPlan$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return b.d(((AdPlans) t12).getEcpmCent(), ((AdPlans) t11).getEcpmCent());
            }
        };
        return (AdPlans) CollectionsKt___CollectionsKt.t0(list, new Comparator() { // from class: com.transsion.ad.monopoly.plan.AdPlanUtil$getHighestEcpmAdPlan$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int iCompare = comparator.compare(t11, t12);
                return iCompare != 0 ? iCompare : b.d(((AdPlans) t11).getSort(), ((AdPlans) t12).getSort());
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0037  */
    public final Long c(AdPlans adPlans) {
        Object objM163constructorimpl;
        Long lValueOf;
        RecommendInfo psRecommendInfo;
        try {
            Result.Companion companion = Result.Companion;
            if (AdPlanSourceManager.f50540a.g(adPlans)) {
                List<AdMaterialList> adMaterialList = adPlans != null ? adPlans.getAdMaterialList() : null;
                List<AdMaterialList> list = adMaterialList;
                if (list == null || list.isEmpty() || (psRecommendInfo = adMaterialList.get(0).getPsRecommendInfo()) == null) {
                    lValueOf = null;
                } else {
                    lValueOf = Long.valueOf(psRecommendInfo.getId());
                }
            } else {
                lValueOf = null;
            }
            objM163constructorimpl = Result.m163constructorimpl(lValueOf);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        return (Long) (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null ? objM163constructorimpl : null);
    }
}
