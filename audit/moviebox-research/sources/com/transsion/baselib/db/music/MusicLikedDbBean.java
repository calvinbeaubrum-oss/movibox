package com.transsion.baselib.db.music;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MusicLikedDbBean implements Parcelable {
    public static final Parcelable.Creator<MusicLikedDbBean> CREATOR = new a();
    private String countryName;
    private String coverUrl;
    private int durationSeconds;
    private String genre;
    private String path;
    private String releaseDate;
    private String singerAvatar;
    private String singerName;
    private String subjectId;
    private long timeStamp;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MusicLikedDbBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MusicLikedDbBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MusicLikedDbBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MusicLikedDbBean[] newArray(int i11) {
            return new MusicLikedDbBean[i11];
        }
    }

    public MusicLikedDbBean(String subjectId, String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7, String str8, long j11) {
        Intrinsics.g(subjectId, "subjectId");
        this.subjectId = subjectId;
        this.title = str;
        this.coverUrl = str2;
        this.countryName = str3;
        this.genre = str4;
        this.releaseDate = str5;
        this.durationSeconds = i11;
        this.singerName = str6;
        this.singerAvatar = str7;
        this.path = str8;
        this.timeStamp = j11;
    }

    public /* synthetic */ MusicLikedDbBean(String str, String str2, String str3, String str4, String str5, String str6, int i11, String str7, String str8, String str9, long j11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? null : str3, (i12 & 8) != 0 ? null : str4, (i12 & 16) != 0 ? null : str5, (i12 & 32) != 0 ? null : str6, (i12 & 64) != 0 ? 0 : i11, (i12 & 128) != 0 ? null : str7, (i12 & 256) != 0 ? null : str8, (i12 & 512) == 0 ? str9 : null, (i12 & 1024) != 0 ? 0L : j11);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final String component10() {
        return this.path;
    }

    public final long component11() {
        return this.timeStamp;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final String component4() {
        return this.countryName;
    }

    public final String component5() {
        return this.genre;
    }

    public final String component6() {
        return this.releaseDate;
    }

    public final int component7() {
        return this.durationSeconds;
    }

    public final String component8() {
        return this.singerName;
    }

    public final String component9() {
        return this.singerAvatar;
    }

    public final MusicLikedDbBean copy(String subjectId, String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7, String str8, long j11) {
        Intrinsics.g(subjectId, "subjectId");
        return new MusicLikedDbBean(subjectId, str, str2, str3, str4, str5, i11, str6, str7, str8, j11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicLikedDbBean)) {
            return false;
        }
        MusicLikedDbBean musicLikedDbBean = (MusicLikedDbBean) obj;
        return Intrinsics.b(this.subjectId, musicLikedDbBean.subjectId) && Intrinsics.b(this.title, musicLikedDbBean.title) && Intrinsics.b(this.coverUrl, musicLikedDbBean.coverUrl) && Intrinsics.b(this.countryName, musicLikedDbBean.countryName) && Intrinsics.b(this.genre, musicLikedDbBean.genre) && Intrinsics.b(this.releaseDate, musicLikedDbBean.releaseDate) && this.durationSeconds == musicLikedDbBean.durationSeconds && Intrinsics.b(this.singerName, musicLikedDbBean.singerName) && Intrinsics.b(this.singerAvatar, musicLikedDbBean.singerAvatar) && Intrinsics.b(this.path, musicLikedDbBean.path) && this.timeStamp == musicLikedDbBean.timeStamp;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final String getSingerAvatar() {
        return this.singerAvatar;
    }

    public final String getSingerName() {
        return this.singerName;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = this.subjectId.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.coverUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.countryName;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.genre;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.releaseDate;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.durationSeconds) * 31;
        String str6 = this.singerName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.singerAvatar;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.path;
        return ((iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + p.a(this.timeStamp);
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public final void setDurationSeconds(int i11) {
        this.durationSeconds = i11;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setSingerAvatar(String str) {
        this.singerAvatar = str;
    }

    public final void setSingerName(String str) {
        this.singerName = str;
    }

    public final void setSubjectId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.subjectId = str;
    }

    public final void setTimeStamp(long j11) {
        this.timeStamp = j11;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MusicLikedDbBean(subjectId=" + this.subjectId + ", title=" + this.title + ", coverUrl=" + this.coverUrl + ", countryName=" + this.countryName + ", genre=" + this.genre + ", releaseDate=" + this.releaseDate + ", durationSeconds=" + this.durationSeconds + ", singerName=" + this.singerName + ", singerAvatar=" + this.singerAvatar + ", path=" + this.path + ", timeStamp=" + this.timeStamp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.subjectId);
        out.writeString(this.title);
        out.writeString(this.coverUrl);
        out.writeString(this.countryName);
        out.writeString(this.genre);
        out.writeString(this.releaseDate);
        out.writeInt(this.durationSeconds);
        out.writeString(this.singerName);
        out.writeString(this.singerAvatar);
        out.writeString(this.path);
        out.writeLong(this.timeStamp);
    }
}
