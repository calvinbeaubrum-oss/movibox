package com.transsion.moviedetailapi.bean;

import com.google.gson.annotations.SerializedName;
import com.transsion.baselib.db.download.SubtitleBean;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SubtitleItem implements Serializable {
    public static final a Companion = new a(null);
    private Long delay;
    private Integer downloads;
    private Integer episode;
    private String fileId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f53888id;
    private boolean isOpenSubNewApi;

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
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleBean a(SubtitleItem item, String postId, String str, int i11, int i12) {
            int iIntValue;
            String lanName;
            Intrinsics.g(item, "item");
            Intrinsics.g(postId, "postId");
            Integer type = item.getType();
            if (type != null) {
                iIntValue = type.intValue();
            } else {
                String lan = item.getLan();
                iIntValue = (lan == null || lan.length() <= 0 || (lanName = item.getLanName()) == null || lanName.length() <= 0) ? 2 : 1;
            }
            String id2 = item.getId();
            String str2 = (id2 == null && (id2 = item.getUrl()) == null) ? "" : id2;
            String url = item.getUrl();
            String str3 = "";
            String lan2 = item.getLan();
            String lanName2 = item.getLanName();
            return new SubtitleBean(str2, postId, url, str3, lan2, lanName2 == null ? "" : lanName2, item.getName(), item.getSize(), item.getDelay(), 0, iIntValue, null, str, i11, i12, 0, 35328, null);
        }
    }

    public SubtitleItem(String str, String str2, String str3, String str4, String str5, Long l11, Long l12, Integer num, Integer num2, Integer num3, Integer num4) {
        this.f53888id = str;
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
        return this.f53888id;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleItem)) {
            return false;
        }
        SubtitleItem subtitleItem = (SubtitleItem) obj;
        return Intrinsics.b(this.f53888id, subtitleItem.f53888id) && Intrinsics.b(this.lan, subtitleItem.lan) && Intrinsics.b(this.lanName, subtitleItem.lanName) && Intrinsics.b(this.name, subtitleItem.name) && Intrinsics.b(this.url, subtitleItem.url) && Intrinsics.b(this.size, subtitleItem.size) && Intrinsics.b(this.delay, subtitleItem.delay) && Intrinsics.b(this.season, subtitleItem.season) && Intrinsics.b(this.episode, subtitleItem.episode) && Intrinsics.b(this.downloads, subtitleItem.downloads) && Intrinsics.b(this.type, subtitleItem.type);
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

    public final String getFileId() {
        return this.fileId;
    }

    public final String getId() {
        return this.f53888id;
    }

    public final String getLan() {
        return this.lan;
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
        String str = this.f53888id;
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

    public final boolean isOpenSubNewApi() {
        return this.isOpenSubNewApi;
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

    public final void setFileId(String str) {
        this.fileId = str;
    }

    public final void setId(String str) {
        this.f53888id = str;
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

    public final void setOpenSubNewApi(boolean z11) {
        this.isOpenSubNewApi = z11;
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
        return "SubtitleItem(id=" + this.f53888id + ", lan=" + this.lan + ", lanName=" + this.lanName + ", name=" + this.name + ", url=" + this.url + ", size=" + this.size + ", delay=" + this.delay + ", season=" + this.season + ", episode=" + this.episode + ", downloads=" + this.downloads + ", type=" + this.type + ")";
    }
}
