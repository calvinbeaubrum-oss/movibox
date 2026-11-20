package com.transsion.ad.monopoly.plan;

import android.text.TextUtils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AdPlanSourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlanSourceManager f50540a = new AdPlanSourceManager();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum AdPlanEnum {
        AD_PLAN_DEFAULT_AD_SRC("_DefaultAdSrc"),
        AD_PLAN_AD_SOURCE_PS("AdSourcePS"),
        AD_PLAN_AD_SOURCE_MB_PS("AdSourceMBPS"),
        AD_PLAN_AD_SOURCE_HI("AdSourceHI");

        private final String value;

        AdPlanEnum(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public final boolean a(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_DEFAULT_AD_SRC.getValue());
    }

    public final boolean b(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_DEFAULT_AD_SRC.getValue());
    }

    public final boolean c(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue());
    }

    public final boolean d(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue());
    }

    public final boolean e(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_MB_PS.getValue());
    }

    public final boolean f(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_PS.getValue());
    }

    public final boolean g(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_PS.getValue());
    }
}
