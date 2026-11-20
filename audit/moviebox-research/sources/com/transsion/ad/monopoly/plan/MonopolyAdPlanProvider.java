package com.transsion.ad.monopoly.plan;

import android.text.TextUtils;
import com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.Intrinsics;
import vq.b;

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
public final class MonopolyAdPlanProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MonopolyAdPlanProvider f50544a = new MonopolyAdPlanProvider();

    public final String a(AdPlans adPlans) {
        String id2;
        List<AdMaterialList> adMaterialList = adPlans.getAdMaterialList();
        return (adMaterialList == null || !(adMaterialList.isEmpty() ^ true) || (id2 = adMaterialList.get(0).getId()) == null) ? "null" : id2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(String str, Map<String, ? extends Object> map, Continuation<? super AdPlans> continuation) throws Throwable {
        MonopolyAdPlanProvider$getAdPlan$1 monopolyAdPlanProvider$getAdPlan$1;
        if (continuation instanceof MonopolyAdPlanProvider$getAdPlan$1) {
            monopolyAdPlanProvider$getAdPlan$1 = (MonopolyAdPlanProvider$getAdPlan$1) continuation;
            int i11 = monopolyAdPlanProvider$getAdPlan$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                monopolyAdPlanProvider$getAdPlan$1.label = i11 - Integer.MIN_VALUE;
            } else {
                monopolyAdPlanProvider$getAdPlan$1 = new MonopolyAdPlanProvider$getAdPlan$1(this, continuation);
            }
        } else {
            monopolyAdPlanProvider$getAdPlan$1 = new MonopolyAdPlanProvider$getAdPlan$1(this, continuation);
        }
        Object objB = monopolyAdPlanProvider$getAdPlan$1.result;
        Object objE = a.e();
        int i12 = monopolyAdPlanProvider$getAdPlan$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
            AdPlanSourceManager.AdPlanEnum[] adPlanEnumArr = {AdPlanSourceManager.AdPlanEnum.AD_PLAN_DEFAULT_AD_SRC};
            monopolyAdPlanProvider$getAdPlan$1.label = 1;
            objB = adPlansStorageManager.b(str, map, adPlanEnumArr, monopolyAdPlanProvider$getAdPlan$1);
            if (objB == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objB);
        }
        return AdPlanUtil.f50541a.b((List) objB);
    }

    public final MbAdImage c(AdPlans plan) {
        Intrinsics.g(plan, "plan");
        return plan.getExtImage();
    }

    public final MbAdImage d(AdPlans plan) {
        Intrinsics.g(plan, "plan");
        AdMaterialList adMaterialListF = f(plan);
        if (adMaterialListF != null) {
            return adMaterialListF.getImage();
        }
        return null;
    }

    public final String e(AdPlans plan) {
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        Intrinsics.g(plan, "plan");
        AdMaterialList adMaterialListF = f(plan);
        AdMaterialList adMaterialListF2 = f(plan);
        if (TextUtils.isEmpty((adMaterialListF2 == null || (image3 = adMaterialListF2.getImage()) == null) ? null : image3.getPath())) {
            if (adMaterialListF == null || (image2 = adMaterialListF.getImage()) == null) {
                return null;
            }
            return image2.getUrl();
        }
        if (adMaterialListF == null || (image = adMaterialListF.getImage()) == null) {
            return null;
        }
        return image.getPath();
    }

    public final AdMaterialList f(AdPlans plan) {
        Intrinsics.g(plan, "plan");
        List<AdMaterialList> adMaterialList = plan.getAdMaterialList();
        if (adMaterialList == null || !(!adMaterialList.isEmpty())) {
            return null;
        }
        return adMaterialList.get(0);
    }

    public final String g(AdPlans plan) {
        MbAdVideo video;
        MbAdVideo video2;
        MbAdVideo video3;
        Intrinsics.g(plan, "plan");
        AdMaterialList adMaterialListF = f(plan);
        AdMaterialList adMaterialListF2 = f(plan);
        if (TextUtils.isEmpty((adMaterialListF2 == null || (video3 = adMaterialListF2.getVideo()) == null) ? null : video3.getPath())) {
            if (adMaterialListF == null || (video2 = adMaterialListF.getVideo()) == null) {
                return null;
            }
            return video2.getUrl();
        }
        if (adMaterialListF == null || (video = adMaterialListF.getVideo()) == null) {
            return null;
        }
        return video.getPath();
    }

    public final boolean h(AdPlans plan) {
        Intrinsics.g(plan, "plan");
        AdMaterialList adMaterialListF = f(plan);
        return Intrinsics.b(adMaterialListF != null ? adMaterialListF.getType() : null, AdMaterialList.NON_AD_TYPE_VIDEO);
    }

    public final void i(String sceneId, int i11, AdPlans adPlans, String triggerId) {
        Intrinsics.g(sceneId, "sceneId");
        Intrinsics.g(triggerId, "triggerId");
        if (adPlans == null) {
            return;
        }
        b.f79053a.a(triggerId, sceneId, adPlans.getId(), 102, a(adPlans), i11, uq.b.f78633a.a(adPlans), s.h(), AdPlanUtil.f50541a.c(adPlans), adPlans.getBidEcpmCent(), adPlans.getEcpmCent());
    }

    public final void j(String sceneId, int i11, AdPlans adPlans, String triggerId) {
        Intrinsics.g(sceneId, "sceneId");
        Intrinsics.g(triggerId, "triggerId");
        if (adPlans == null) {
            return;
        }
        NonAdShowedTimesManager.f50524a.c(adPlans);
        b.f79053a.f(triggerId, sceneId, adPlans.getId(), 102, a(adPlans), i11, uq.b.f78633a.a(adPlans), s.h(), AdPlanUtil.f50541a.c(adPlans), adPlans.getBidEcpmCent(), adPlans.getEcpmCent());
    }

    public final void k(String sceneId, int i11, long j11, AdPlans adPlans, String triggerId) {
        Intrinsics.g(sceneId, "sceneId");
        Intrinsics.g(triggerId, "triggerId");
        if (adPlans == null) {
            return;
        }
        b.f79053a.c(triggerId, sceneId, adPlans.getId(), j11, a(adPlans), i11, uq.b.f78633a.a(adPlans));
    }

    public final void l(String sceneId, String str, String triggerId) {
        Intrinsics.g(sceneId, "sceneId");
        Intrinsics.g(triggerId, "triggerId");
        b.f79053a.l(triggerId, sceneId, 1, 105, str);
    }
}
