package com.transsion.videodetail.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.moviedetailapi.bean.Cover;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MusicLikedRemoteItemBean implements Parcelable {
    public static final Parcelable.Creator<MusicLikedRemoteItemBean> CREATOR = new a();
    private LikeListActionEnum actionEnum;
    private String countryName;
    private Cover cover;
    private Integer durationSeconds;
    private String genre;
    private Long likeTime;
    private String releaseDate;
    private String singerAvatar;
    private String singerName;
    private String subjectId;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MusicLikedRemoteItemBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MusicLikedRemoteItemBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MusicLikedRemoteItemBean(parcel.readString(), parcel.readString(), (Cover) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : LikeListActionEnum.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MusicLikedRemoteItemBean[] newArray(int i11) {
            return new MusicLikedRemoteItemBean[i11];
        }
    }

    public MusicLikedRemoteItemBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public MusicLikedRemoteItemBean(String str, String str2, Cover cover, String str3, String str4, String str5, Integer num, String str6, String str7, Long l11, LikeListActionEnum likeListActionEnum) {
        this.subjectId = str;
        this.title = str2;
        this.cover = cover;
        this.countryName = str3;
        this.genre = str4;
        this.releaseDate = str5;
        this.durationSeconds = num;
        this.singerName = str6;
        this.singerAvatar = str7;
        this.likeTime = l11;
        this.actionEnum = likeListActionEnum;
    }

    public /* synthetic */ MusicLikedRemoteItemBean(String str, String str2, Cover cover, String str3, String str4, String str5, Integer num, String str6, String str7, Long l11, LikeListActionEnum likeListActionEnum, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : cover, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : num, (i11 & 128) != 0 ? null : str6, (i11 & 256) != 0 ? null : str7, (i11 & 512) != 0 ? null : l11, (i11 & 1024) == 0 ? likeListActionEnum : null);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final Long component10() {
        return this.likeTime;
    }

    public final LikeListActionEnum component11() {
        return this.actionEnum;
    }

    public final String component2() {
        return this.title;
    }

    public final Cover component3() {
        return this.cover;
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

    public final Integer component7() {
        return this.durationSeconds;
    }

    public final String component8() {
        return this.singerName;
    }

    public final String component9() {
        return this.singerAvatar;
    }

    public final MusicLikedRemoteItemBean copy(String str, String str2, Cover cover, String str3, String str4, String str5, Integer num, String str6, String str7, Long l11, LikeListActionEnum likeListActionEnum) {
        return new MusicLikedRemoteItemBean(str, str2, cover, str3, str4, str5, num, str6, str7, l11, likeListActionEnum);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicLikedRemoteItemBean)) {
            return false;
        }
        MusicLikedRemoteItemBean musicLikedRemoteItemBean = (MusicLikedRemoteItemBean) obj;
        return Intrinsics.b(this.subjectId, musicLikedRemoteItemBean.subjectId) && Intrinsics.b(this.title, musicLikedRemoteItemBean.title) && Intrinsics.b(this.cover, musicLikedRemoteItemBean.cover) && Intrinsics.b(this.countryName, musicLikedRemoteItemBean.countryName) && Intrinsics.b(this.genre, musicLikedRemoteItemBean.genre) && Intrinsics.b(this.releaseDate, musicLikedRemoteItemBean.releaseDate) && Intrinsics.b(this.durationSeconds, musicLikedRemoteItemBean.durationSeconds) && Intrinsics.b(this.singerName, musicLikedRemoteItemBean.singerName) && Intrinsics.b(this.singerAvatar, musicLikedRemoteItemBean.singerAvatar) && Intrinsics.b(this.likeTime, musicLikedRemoteItemBean.likeTime) && this.actionEnum == musicLikedRemoteItemBean.actionEnum;
    }

    public final LikeListActionEnum getActionEnum() {
        return this.actionEnum;
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

    public final Long getLikeTime() {
        return this.likeTime;
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

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Cover cover = this.cover;
        int iHashCode3 = (iHashCode2 + (cover == null ? 0 : cover.hashCode())) * 31;
        String str3 = this.countryName;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.genre;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.releaseDate;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.durationSeconds;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.singerName;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.singerAvatar;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l11 = this.likeTime;
        int iHashCode10 = (iHashCode9 + (l11 == null ? 0 : l11.hashCode())) * 31;
        LikeListActionEnum likeListActionEnum = this.actionEnum;
        return iHashCode10 + (likeListActionEnum != null ? likeListActionEnum.hashCode() : 0);
    }

    public final void setActionEnum(LikeListActionEnum likeListActionEnum) {
        this.actionEnum = likeListActionEnum;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setLikeTime(Long l11) {
        this.likeTime = l11;
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
        this.subjectId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MusicLikedRemoteItemBean(subjectId=" + this.subjectId + ", title=" + this.title + ", cover=" + this.cover + ", countryName=" + this.countryName + ", genre=" + this.genre + ", releaseDate=" + this.releaseDate + ", durationSeconds=" + this.durationSeconds + ", singerName=" + this.singerName + ", singerAvatar=" + this.singerAvatar + ", likeTime=" + this.likeTime + ", actionEnum=" + this.actionEnum + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.subjectId);
        out.writeString(this.title);
        out.writeSerializable(this.cover);
        out.writeString(this.countryName);
        out.writeString(this.genre);
        out.writeString(this.releaseDate);
        Integer num = this.durationSeconds;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.singerName);
        out.writeString(this.singerAvatar);
        Long l11 = this.likeTime;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        LikeListActionEnum likeListActionEnum = this.actionEnum;
        if (likeListActionEnum == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(likeListActionEnum.name());
        }
    }
}
