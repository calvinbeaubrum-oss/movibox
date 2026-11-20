package com.transsion.subtitle_download.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class SubtitleItem implements Parcelable, Serializable {
    public static final Parcelable.Creator<SubtitleItem> CREATOR = new a();
    private Long delay;
    private Integer downloads;
    private Integer episode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f58351id;

    @SerializedName(alternate = {"shortLanguage"}, value = "lan")
    private String lan;

    @SerializedName(alternate = {"language"}, value = "lanName")
    private String lanName;
    private String name;
    private Integer season;
    private Long size;
    private Integer type;
    private String url;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SubtitleItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubtitleItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SubtitleItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubtitleItem[] newArray(int i11) {
            return new SubtitleItem[i11];
        }
    }

    public SubtitleItem(String str, String str2, String str3, String str4, String str5, Long l11, Long l12, Integer num, Integer num2, Integer num3, Integer num4) {
        this.f58351id = str;
        this.lan = str2;
        this.lanName = str3;
        this.name = str4;
        this.url = str5;
        this.size = l11;
        this.delay = l12;
        this.season = num;
        this.episode = num2;
        this.downloads = num3;
        this.type = num4;
    }

    public final String component1() {
        return this.f58351id;
    }

    public final Integer component10() {
        return this.downloads;
    }

    public final Integer component11() {
        return this.type;
    }

    public final String component2() {
        return this.lan;
    }

    public final String component3() {
        return this.lanName;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.url;
    }

    public final Long component6() {
        return this.size;
    }

    public final Long component7() {
        return this.delay;
    }

    public final Integer component8() {
        return this.season;
    }

    public final Integer component9() {
        return this.episode;
    }

    public final SubtitleItem copy(String str, String str2, String str3, String str4, String str5, Long l11, Long l12, Integer num, Integer num2, Integer num3, Integer num4) {
        return new SubtitleItem(str, str2, str3, str4, str5, l11, l12, num, num2, num3, num4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleItem)) {
            return false;
        }
        SubtitleItem subtitleItem = (SubtitleItem) obj;
        return Intrinsics.b(this.f58351id, subtitleItem.f58351id) && Intrinsics.b(this.lan, subtitleItem.lan) && Intrinsics.b(this.lanName, subtitleItem.lanName) && Intrinsics.b(this.name, subtitleItem.name) && Intrinsics.b(this.url, subtitleItem.url) && Intrinsics.b(this.size, subtitleItem.size) && Intrinsics.b(this.delay, subtitleItem.delay) && Intrinsics.b(this.season, subtitleItem.season) && Intrinsics.b(this.episode, subtitleItem.episode) && Intrinsics.b(this.downloads, subtitleItem.downloads) && Intrinsics.b(this.type, subtitleItem.type);
    }

    public final Long getDelay() {
        return this.delay;
    }

    public final Integer getDownloads() {
        return this.downloads;
    }

    public final Integer getEpisode() {
        return this.episode;
    }

    public final String getId() {
        return this.f58351id;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getLanAbbr() {
        return Intrinsics.b(this.lan, "in_id") ? "in" : this.lan;
    }

    public final String getLanName() {
        return this.lanName;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSeason() {
        return this.season;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.f58351id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lan;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lanName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.url;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l11 = this.size;
        int iHashCode6 = (iHashCode5 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.delay;
        int iHashCode7 = (iHashCode6 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Integer num = this.season;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.episode;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.downloads;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.type;
        return iHashCode10 + (num4 != null ? num4.hashCode() : 0);
    }

    public final void setDelay(Long l11) {
        this.delay = l11;
    }

    public final void setDownloads(Integer num) {
        this.downloads = num;
    }

    public final void setEpisode(Integer num) {
        this.episode = num;
    }

    public final void setId(String str) {
        this.f58351id = str;
    }

    public final void setLan(String str) {
        this.lan = str;
    }

    public final void setLanName(String str) {
        this.lanName = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setSeason(Integer num) {
        this.season = num;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "SubtitleItem(id=" + this.f58351id + ", lan=" + this.lan + ", lanName=" + this.lanName + ", name=" + this.name + ", url=" + this.url + ", size=" + this.size + ", delay=" + this.delay + ", season=" + this.season + ", episode=" + this.episode + ", downloads=" + this.downloads + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f58351id);
        out.writeString(this.lan);
        out.writeString(this.lanName);
        out.writeString(this.name);
        out.writeString(this.url);
        Long l11 = this.size;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        Long l12 = this.delay;
        if (l12 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l12.longValue());
        }
        Integer num = this.season;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.episode;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.downloads;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Integer num4 = this.type;
        if (num4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num4.intValue());
        }
    }
}
