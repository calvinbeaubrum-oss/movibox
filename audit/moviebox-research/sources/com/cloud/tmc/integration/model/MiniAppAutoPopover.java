package com.cloud.tmc.integration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class MiniAppAutoPopover extends b {
    private final String buttonBackgroundColor;
    private final String buttonTextColor;
    private final MiniAppMultiLanguageConfig configs;
    private final Long delayDuration;
    private final Integer displayFrequency;
    private final Integer perXDay;
    private final Boolean status;

    public MiniAppAutoPopover(Boolean bool, Long l11, Integer num, Integer num2, String str, String str2, MiniAppMultiLanguageConfig miniAppMultiLanguageConfig) {
        this.status = bool;
        this.delayDuration = l11;
        this.displayFrequency = num;
        this.perXDay = num2;
        this.buttonTextColor = str;
        this.buttonBackgroundColor = str2;
        this.configs = miniAppMultiLanguageConfig;
    }

    public static /* synthetic */ MiniAppAutoPopover copy$default(MiniAppAutoPopover miniAppAutoPopover, Boolean bool, Long l11, Integer num, Integer num2, String str, String str2, MiniAppMultiLanguageConfig miniAppMultiLanguageConfig, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = miniAppAutoPopover.status;
        }
        if ((i11 & 2) != 0) {
            l11 = miniAppAutoPopover.delayDuration;
        }
        Long l12 = l11;
        if ((i11 & 4) != 0) {
            num = miniAppAutoPopover.displayFrequency;
        }
        Integer num3 = num;
        if ((i11 & 8) != 0) {
            num2 = miniAppAutoPopover.perXDay;
        }
        Integer num4 = num2;
        if ((i11 & 16) != 0) {
            str = miniAppAutoPopover.buttonTextColor;
        }
        String str3 = str;
        if ((i11 & 32) != 0) {
            str2 = miniAppAutoPopover.buttonBackgroundColor;
        }
        String str4 = str2;
        if ((i11 & 64) != 0) {
            miniAppMultiLanguageConfig = miniAppAutoPopover.configs;
        }
        return miniAppAutoPopover.copy(bool, l12, num3, num4, str3, str4, miniAppMultiLanguageConfig);
    }

    public final Boolean component1() {
        return this.status;
    }

    public final Long component2() {
        return this.delayDuration;
    }

    public final Integer component3() {
        return this.displayFrequency;
    }

    public final Integer component4() {
        return this.perXDay;
    }

    public final String component5() {
        return this.buttonTextColor;
    }

    public final String component6() {
        return this.buttonBackgroundColor;
    }

    public final MiniAppMultiLanguageConfig component7() {
        return this.configs;
    }

    public final MiniAppAutoPopover copy(Boolean bool, Long l11, Integer num, Integer num2, String str, String str2, MiniAppMultiLanguageConfig miniAppMultiLanguageConfig) {
        return new MiniAppAutoPopover(bool, l11, num, num2, str, str2, miniAppMultiLanguageConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAppAutoPopover)) {
            return false;
        }
        MiniAppAutoPopover miniAppAutoPopover = (MiniAppAutoPopover) obj;
        return Intrinsics.b(this.status, miniAppAutoPopover.status) && Intrinsics.b(this.delayDuration, miniAppAutoPopover.delayDuration) && Intrinsics.b(this.displayFrequency, miniAppAutoPopover.displayFrequency) && Intrinsics.b(this.perXDay, miniAppAutoPopover.perXDay) && Intrinsics.b(this.buttonTextColor, miniAppAutoPopover.buttonTextColor) && Intrinsics.b(this.buttonBackgroundColor, miniAppAutoPopover.buttonBackgroundColor) && Intrinsics.b(this.configs, miniAppAutoPopover.configs);
    }

    public final String getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }

    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    public final MiniAppMultiLanguageConfig getConfigs() {
        return this.configs;
    }

    public final Long getDelayDuration() {
        return this.delayDuration;
    }

    public final Integer getDisplayFrequency() {
        return this.displayFrequency;
    }

    public final Integer getPerXDay() {
        return this.perXDay;
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        Boolean bool = this.status;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l11 = this.delayDuration;
        int iHashCode2 = (iHashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num = this.displayFrequency;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.perXDay;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.buttonTextColor;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.buttonBackgroundColor;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MiniAppMultiLanguageConfig miniAppMultiLanguageConfig = this.configs;
        return iHashCode6 + (miniAppMultiLanguageConfig != null ? miniAppMultiLanguageConfig.hashCode() : 0);
    }

    public String toString() {
        return "MiniAppAutoPopover(status=" + this.status + ", delayDuration=" + this.delayDuration + ", displayFrequency=" + this.displayFrequency + ", perXDay=" + this.perXDay + ", buttonTextColor=" + this.buttonTextColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ", configs=" + this.configs + ')';
    }
}
