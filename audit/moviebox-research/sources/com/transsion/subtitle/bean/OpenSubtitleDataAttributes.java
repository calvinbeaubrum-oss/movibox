package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
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
@Keep
@Metadata
public final class OpenSubtitleDataAttributes {

    @SerializedName("download_count")
    private final int downloadCount;

    @SerializedName("feature_details")
    private final OpenSubtitleFeatureDetails featureDetails;
    private final List<OpenSubtitleDataFile> files;
    private final String language;

    @SerializedName("subtitle_id")
    private final String subtitleId;

    @SerializedName("upload_date")
    private final String uploadDate;

    public OpenSubtitleDataAttributes(List<OpenSubtitleDataFile> list, String subtitleId, String language, String uploadDate, OpenSubtitleFeatureDetails openSubtitleFeatureDetails, int i11) {
        Intrinsics.g(subtitleId, "subtitleId");
        Intrinsics.g(language, "language");
        Intrinsics.g(uploadDate, "uploadDate");
        this.files = list;
        this.subtitleId = subtitleId;
        this.language = language;
        this.uploadDate = uploadDate;
        this.featureDetails = openSubtitleFeatureDetails;
        this.downloadCount = i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenSubtitleDataAttributes copy$default(OpenSubtitleDataAttributes openSubtitleDataAttributes, List list, String str, String str2, String str3, OpenSubtitleFeatureDetails openSubtitleFeatureDetails, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = openSubtitleDataAttributes.files;
        }
        if ((i12 & 2) != 0) {
            str = openSubtitleDataAttributes.subtitleId;
        }
        String str4 = str;
        if ((i12 & 4) != 0) {
            str2 = openSubtitleDataAttributes.language;
        }
        String str5 = str2;
        if ((i12 & 8) != 0) {
            str3 = openSubtitleDataAttributes.uploadDate;
        }
        String str6 = str3;
        if ((i12 & 16) != 0) {
            openSubtitleFeatureDetails = openSubtitleDataAttributes.featureDetails;
        }
        OpenSubtitleFeatureDetails openSubtitleFeatureDetails2 = openSubtitleFeatureDetails;
        if ((i12 & 32) != 0) {
            i11 = openSubtitleDataAttributes.downloadCount;
        }
        return openSubtitleDataAttributes.copy(list, str4, str5, str6, openSubtitleFeatureDetails2, i11);
    }

    public final List<OpenSubtitleDataFile> component1() {
        return this.files;
    }

    public final String component2() {
        return this.subtitleId;
    }

    public final String component3() {
        return this.language;
    }

    public final String component4() {
        return this.uploadDate;
    }

    public final OpenSubtitleFeatureDetails component5() {
        return this.featureDetails;
    }

    public final int component6() {
        return this.downloadCount;
    }

    public final OpenSubtitleDataAttributes copy(List<OpenSubtitleDataFile> list, String subtitleId, String language, String uploadDate, OpenSubtitleFeatureDetails openSubtitleFeatureDetails, int i11) {
        Intrinsics.g(subtitleId, "subtitleId");
        Intrinsics.g(language, "language");
        Intrinsics.g(uploadDate, "uploadDate");
        return new OpenSubtitleDataAttributes(list, subtitleId, language, uploadDate, openSubtitleFeatureDetails, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenSubtitleDataAttributes)) {
            return false;
        }
        OpenSubtitleDataAttributes openSubtitleDataAttributes = (OpenSubtitleDataAttributes) obj;
        return Intrinsics.b(this.files, openSubtitleDataAttributes.files) && Intrinsics.b(this.subtitleId, openSubtitleDataAttributes.subtitleId) && Intrinsics.b(this.language, openSubtitleDataAttributes.language) && Intrinsics.b(this.uploadDate, openSubtitleDataAttributes.uploadDate) && Intrinsics.b(this.featureDetails, openSubtitleDataAttributes.featureDetails) && this.downloadCount == openSubtitleDataAttributes.downloadCount;
    }

    public final int getDownloadCount() {
        return this.downloadCount;
    }

    public final OpenSubtitleFeatureDetails getFeatureDetails() {
        return this.featureDetails;
    }

    public final List<OpenSubtitleDataFile> getFiles() {
        return this.files;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getSubtitleId() {
        return this.subtitleId;
    }

    public final String getUploadDate() {
        return this.uploadDate;
    }

    public int hashCode() {
        List<OpenSubtitleDataFile> list = this.files;
        int iHashCode = (((((((list == null ? 0 : list.hashCode()) * 31) + this.subtitleId.hashCode()) * 31) + this.language.hashCode()) * 31) + this.uploadDate.hashCode()) * 31;
        OpenSubtitleFeatureDetails openSubtitleFeatureDetails = this.featureDetails;
        return ((iHashCode + (openSubtitleFeatureDetails != null ? openSubtitleFeatureDetails.hashCode() : 0)) * 31) + this.downloadCount;
    }

    public String toString() {
        return "OpenSubtitleDataAttributes(files=" + this.files + ", subtitleId=" + this.subtitleId + ", language=" + this.language + ", uploadDate=" + this.uploadDate + ", featureDetails=" + this.featureDetails + ", downloadCount=" + this.downloadCount + ")";
    }
}
