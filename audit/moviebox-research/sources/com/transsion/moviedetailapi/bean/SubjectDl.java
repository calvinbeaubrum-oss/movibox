package com.transsion.moviedetailapi.bean;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SubjectDl implements Serializable {

    @SerializedName("extCaptions")
    private List<SubtitleItem> extSubtitle;

    @SerializedName("postId")
    private String postId;

    @SerializedName("id")
    private String resourceId;

    @SerializedName("size")
    private Long size;

    @SerializedName("sourceUrl")
    private String sourceUrl;

    @SerializedName("url")
    private String url;

    public SubjectDl(String str, String str2, Long l11, String str3, String str4, List<SubtitleItem> list) {
        this.resourceId = str;
        this.url = str2;
        this.size = l11;
        this.sourceUrl = str3;
        this.postId = str4;
        this.extSubtitle = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubjectDl copy$default(SubjectDl subjectDl, String str, String str2, Long l11, String str3, String str4, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subjectDl.resourceId;
        }
        if ((i11 & 2) != 0) {
            str2 = subjectDl.url;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            l11 = subjectDl.size;
        }
        Long l12 = l11;
        if ((i11 & 8) != 0) {
            str3 = subjectDl.sourceUrl;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = subjectDl.postId;
        }
        String str7 = str4;
        if ((i11 & 32) != 0) {
            list = subjectDl.extSubtitle;
        }
        return subjectDl.copy(str, str5, l12, str6, str7, list);
    }

    public final String component1() {
        return this.resourceId;
    }

    public final String component2() {
        return this.url;
    }

    public final Long component3() {
        return this.size;
    }

    public final String component4() {
        return this.sourceUrl;
    }

    public final String component5() {
        return this.postId;
    }

    public final List<SubtitleItem> component6() {
        return this.extSubtitle;
    }

    public final SubjectDl copy(String str, String str2, Long l11, String str3, String str4, List<SubtitleItem> list) {
        return new SubjectDl(str, str2, l11, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubjectDl)) {
            return false;
        }
        SubjectDl subjectDl = (SubjectDl) obj;
        return Intrinsics.b(this.resourceId, subjectDl.resourceId) && Intrinsics.b(this.url, subjectDl.url) && Intrinsics.b(this.size, subjectDl.size) && Intrinsics.b(this.sourceUrl, subjectDl.sourceUrl) && Intrinsics.b(this.postId, subjectDl.postId) && Intrinsics.b(this.extSubtitle, subjectDl.extSubtitle);
    }

    public final List<SubtitleItem> getExtSubtitle() {
        return this.extSubtitle;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.resourceId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l11 = this.size;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str3 = this.sourceUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.postId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<SubtitleItem> list = this.extSubtitle;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public final void setExtSubtitle(List<SubtitleItem> list) {
        this.extSubtitle = list;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setSourceUrl(String str) {
        this.sourceUrl = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "SubjectDl(resourceId=" + this.resourceId + ", url=" + this.url + ", size=" + this.size + ", sourceUrl=" + this.sourceUrl + ", postId=" + this.postId + ", extSubtitle=" + this.extSubtitle + ")";
    }
}
