package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
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
@Keep
@Metadata
public final class OpenSubtitleFeatureDetails {

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    @SerializedName("episode_number")
    private final int f58122ep;

    @SerializedName("feature_id")
    private final int featureId;

    @SerializedName("imdb_id")
    private final Integer imdbId;

    @SerializedName("movie_name")
    private final String movieName;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    @SerializedName("season_number")
    private final int f58123se;
    private final int year;

    public OpenSubtitleFeatureDetails(int i11, int i12, int i13, int i14, String str, Integer num) {
        this.featureId = i11;
        this.year = i12;
        this.f58123se = i13;
        this.f58122ep = i14;
        this.movieName = str;
        this.imdbId = num;
    }

    public static /* synthetic */ OpenSubtitleFeatureDetails copy$default(OpenSubtitleFeatureDetails openSubtitleFeatureDetails, int i11, int i12, int i13, int i14, String str, Integer num, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = openSubtitleFeatureDetails.featureId;
        }
        if ((i15 & 2) != 0) {
            i12 = openSubtitleFeatureDetails.year;
        }
        int i16 = i12;
        if ((i15 & 4) != 0) {
            i13 = openSubtitleFeatureDetails.f58123se;
        }
        int i17 = i13;
        if ((i15 & 8) != 0) {
            i14 = openSubtitleFeatureDetails.f58122ep;
        }
        int i18 = i14;
        if ((i15 & 16) != 0) {
            str = openSubtitleFeatureDetails.movieName;
        }
        String str2 = str;
        if ((i15 & 32) != 0) {
            num = openSubtitleFeatureDetails.imdbId;
        }
        return openSubtitleFeatureDetails.copy(i11, i16, i17, i18, str2, num);
    }

    public final int component1() {
        return this.featureId;
    }

    public final int component2() {
        return this.year;
    }

    public final int component3() {
        return this.f58123se;
    }

    public final int component4() {
        return this.f58122ep;
    }

    public final String component5() {
        return this.movieName;
    }

    public final Integer component6() {
        return this.imdbId;
    }

    public final OpenSubtitleFeatureDetails copy(int i11, int i12, int i13, int i14, String str, Integer num) {
        return new OpenSubtitleFeatureDetails(i11, i12, i13, i14, str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenSubtitleFeatureDetails)) {
            return false;
        }
        OpenSubtitleFeatureDetails openSubtitleFeatureDetails = (OpenSubtitleFeatureDetails) obj;
        return this.featureId == openSubtitleFeatureDetails.featureId && this.year == openSubtitleFeatureDetails.year && this.f58123se == openSubtitleFeatureDetails.f58123se && this.f58122ep == openSubtitleFeatureDetails.f58122ep && Intrinsics.b(this.movieName, openSubtitleFeatureDetails.movieName) && Intrinsics.b(this.imdbId, openSubtitleFeatureDetails.imdbId);
    }

    public final int getEp() {
        return this.f58122ep;
    }

    public final int getFeatureId() {
        return this.featureId;
    }

    public final Integer getImdbId() {
        return this.imdbId;
    }

    public final String getMovieName() {
        return this.movieName;
    }

    public final int getSe() {
        return this.f58123se;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        int i11 = ((((((this.featureId * 31) + this.year) * 31) + this.f58123se) * 31) + this.f58122ep) * 31;
        String str = this.movieName;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.imdbId;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "OpenSubtitleFeatureDetails(featureId=" + this.featureId + ", year=" + this.year + ", se=" + this.f58123se + ", ep=" + this.f58122ep + ", movieName=" + this.movieName + ", imdbId=" + this.imdbId + ")";
    }
}
