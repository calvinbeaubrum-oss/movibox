package com.transsion.edcation.bean;

import com.transsion.moviedetailapi.bean.Cover;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class CourseBean implements Serializable {
    private final String category;
    private final String contentRating;
    private final String countryName;
    private final Cover cover;
    private final Integer durationSeconds;
    private final String genre;
    private int seenStatus;
    private final String subjectId;
    private final Integer subjectType;
    private final String title;
    private final long viewers;

    public CourseBean(String str, Integer num, int i11, String str2, Cover cover, String str3, String str4, String str5, Integer num2, long j11, String str6) {
        this.subjectId = str;
        this.subjectType = num;
        this.seenStatus = i11;
        this.title = str2;
        this.cover = cover;
        this.category = str3;
        this.contentRating = str4;
        this.genre = str5;
        this.durationSeconds = num2;
        this.viewers = j11;
        this.countryName = str6;
    }

    public /* synthetic */ CourseBean(String str, Integer num, int i11, String str2, Cover cover, String str3, String str4, String str5, Integer num2, long j11, String str6, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i12 & 2) != 0 ? null : num, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? null : cover, (i12 & 32) != 0 ? null : str3, (i12 & 64) != 0 ? null : str4, (i12 & 128) != 0 ? null : str5, (i12 & 256) != 0 ? 0 : num2, (i12 & 512) != 0 ? 0L : j11, (i12 & 1024) == 0 ? str6 : null);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final long component10() {
        return this.viewers;
    }

    public final String component11() {
        return this.countryName;
    }

    public final Integer component2() {
        return this.subjectType;
    }

    public final int component3() {
        return this.seenStatus;
    }

    public final String component4() {
        return this.title;
    }

    public final Cover component5() {
        return this.cover;
    }

    public final String component6() {
        return this.category;
    }

    public final String component7() {
        return this.contentRating;
    }

    public final String component8() {
        return this.genre;
    }

    public final Integer component9() {
        return this.durationSeconds;
    }

    public final CourseBean copy(String str, Integer num, int i11, String str2, Cover cover, String str3, String str4, String str5, Integer num2, long j11, String str6) {
        return new CourseBean(str, num, i11, str2, cover, str3, str4, str5, num2, j11, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseBean)) {
            return false;
        }
        CourseBean courseBean = (CourseBean) obj;
        return Intrinsics.b(this.subjectId, courseBean.subjectId) && Intrinsics.b(this.subjectType, courseBean.subjectType) && this.seenStatus == courseBean.seenStatus && Intrinsics.b(this.title, courseBean.title) && Intrinsics.b(this.cover, courseBean.cover) && Intrinsics.b(this.category, courseBean.category) && Intrinsics.b(this.contentRating, courseBean.contentRating) && Intrinsics.b(this.genre, courseBean.genre) && Intrinsics.b(this.durationSeconds, courseBean.durationSeconds) && this.viewers == courseBean.viewers && Intrinsics.b(this.countryName, courseBean.countryName);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getContentRating() {
        return this.contentRating;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final int getSeenStatus() {
        return this.seenStatus;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getViewers() {
        return this.viewers;
    }

    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.subjectType;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.seenStatus) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Cover cover = this.cover;
        int iHashCode4 = (iHashCode3 + (cover == null ? 0 : cover.hashCode())) * 31;
        String str3 = this.category;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.contentRating;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.genre;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.durationSeconds;
        int iHashCode8 = (((iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31) + p.a(this.viewers)) * 31;
        String str6 = this.countryName;
        return iHashCode8 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setSeenStatus(int i11) {
        this.seenStatus = i11;
    }

    public String toString() {
        return "CourseBean(subjectId=" + this.subjectId + ", subjectType=" + this.subjectType + ", seenStatus=" + this.seenStatus + ", title=" + this.title + ", cover=" + this.cover + ", category=" + this.category + ", contentRating=" + this.contentRating + ", genre=" + this.genre + ", durationSeconds=" + this.durationSeconds + ", viewers=" + this.viewers + ", countryName=" + this.countryName + ")";
    }
}
