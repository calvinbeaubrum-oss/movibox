package com.transsion.search.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
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
public final class Season implements Serializable {

    @SerializedName("allEp")
    private final String allEp;

    @SerializedName("maxEp")
    private final Integer maxEp;

    @SerializedName("resolutions")
    private final List<SeasonInfoResolution> resolutions;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    @SerializedName("se")
    private final Integer f57438se;

    public Season(Integer num, Integer num2, String str, List<SeasonInfoResolution> list) {
        this.f57438se = num;
        this.maxEp = num2;
        this.allEp = str;
        this.resolutions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Season copy$default(Season season, Integer num, Integer num2, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = season.f57438se;
        }
        if ((i11 & 2) != 0) {
            num2 = season.maxEp;
        }
        if ((i11 & 4) != 0) {
            str = season.allEp;
        }
        if ((i11 & 8) != 0) {
            list = season.resolutions;
        }
        return season.copy(num, num2, str, list);
    }

    public final Integer component1() {
        return this.f57438se;
    }

    public final Integer component2() {
        return this.maxEp;
    }

    public final String component3() {
        return this.allEp;
    }

    public final List<SeasonInfoResolution> component4() {
        return this.resolutions;
    }

    public final Season copy(Integer num, Integer num2, String str, List<SeasonInfoResolution> list) {
        return new Season(num, num2, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Season)) {
            return false;
        }
        Season season = (Season) obj;
        return Intrinsics.b(this.f57438se, season.f57438se) && Intrinsics.b(this.maxEp, season.maxEp) && Intrinsics.b(this.allEp, season.allEp) && Intrinsics.b(this.resolutions, season.resolutions);
    }

    public final String getAllEp() {
        return this.allEp;
    }

    public final Integer getMaxEp() {
        return this.maxEp;
    }

    public final List<SeasonInfoResolution> getResolutions() {
        return this.resolutions;
    }

    public final Integer getSe() {
        return this.f57438se;
    }

    public int hashCode() {
        Integer num = this.f57438se;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.maxEp;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.allEp;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<SeasonInfoResolution> list = this.resolutions;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Season(se=" + this.f57438se + ", maxEp=" + this.maxEp + ", allEp=" + this.allEp + ", resolutions=" + this.resolutions + ")";
    }
}
