package com.transsion.search.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SeasonInfoResolution implements Serializable {

    @SerializedName("epNum")
    private final Integer epNum;

    @SerializedName("resolution")
    private final Integer resolution;

    public SeasonInfoResolution(Integer num, Integer num2) {
        this.resolution = num;
        this.epNum = num2;
    }

    public static /* synthetic */ SeasonInfoResolution copy$default(SeasonInfoResolution seasonInfoResolution, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = seasonInfoResolution.resolution;
        }
        if ((i11 & 2) != 0) {
            num2 = seasonInfoResolution.epNum;
        }
        return seasonInfoResolution.copy(num, num2);
    }

    public final Integer component1() {
        return this.resolution;
    }

    public final Integer component2() {
        return this.epNum;
    }

    public final SeasonInfoResolution copy(Integer num, Integer num2) {
        return new SeasonInfoResolution(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeasonInfoResolution)) {
            return false;
        }
        SeasonInfoResolution seasonInfoResolution = (SeasonInfoResolution) obj;
        return Intrinsics.b(this.resolution, seasonInfoResolution.resolution) && Intrinsics.b(this.epNum, seasonInfoResolution.epNum);
    }

    public final Integer getEpNum() {
        return this.epNum;
    }

    public final Integer getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        Integer num = this.resolution;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.epNum;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "SeasonInfoResolution(resolution=" + this.resolution + ", epNum=" + this.epNum + ")";
    }
}
