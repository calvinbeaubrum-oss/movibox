package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.player.MediaSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

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
@Keep
@Metadata
public final class ShortTVItem implements Serializable {
    private int coin;
    private String description;
    private transient int downloadStatus;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    @SerializedName("ep")
    private int f53884ep;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("miniId")
    private String f53885id;
    private Link link;
    private int lockStatus;
    private transient long playProgress;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    @SerializedName("se")
    private int f53886se;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName("video")
    private Media video;

    @SerializedName("videoId")
    private String videoId;

    public ShortTVItem() {
        this(null, null, 0, 0, null, null, null, 0, 0, null, 0L, 0, UnixStat.PERM_MASK, null);
    }

    public ShortTVItem(String str, String str2, int i11, int i12, String str3, Media media, Link link, int i13, int i14, String str4, long j11, int i15) {
        this.f53885id = str;
        this.subjectId = str2;
        this.f53886se = i11;
        this.f53884ep = i12;
        this.videoId = str3;
        this.video = media;
        this.link = link;
        this.lockStatus = i13;
        this.coin = i14;
        this.description = str4;
        this.playProgress = j11;
        this.downloadStatus = i15;
    }

    public /* synthetic */ ShortTVItem(String str, String str2, int i11, int i12, String str3, Media media, Link link, int i13, int i14, String str4, long j11, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? 0 : i11, (i16 & 8) != 0 ? 0 : i12, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? null : media, (i16 & 64) != 0 ? null : link, (i16 & 128) != 0 ? 0 : i13, (i16 & 256) != 0 ? 0 : i14, (i16 & 512) == 0 ? str4 : null, (i16 & 1024) != 0 ? 0L : j11, (i16 & 2048) == 0 ? i15 : 0);
    }

    public final String component1() {
        return this.f53885id;
    }

    public final String component10() {
        return this.description;
    }

    public final long component11() {
        return this.playProgress;
    }

    public final int component12() {
        return this.downloadStatus;
    }

    public final String component2() {
        return this.subjectId;
    }

    public final int component3() {
        return this.f53886se;
    }

    public final int component4() {
        return this.f53884ep;
    }

    public final String component5() {
        return this.videoId;
    }

    public final Media component6() {
        return this.video;
    }

    public final Link component7() {
        return this.link;
    }

    public final int component8() {
        return this.lockStatus;
    }

    public final int component9() {
        return this.coin;
    }

    public final ShortTVItem copy(String str, String str2, int i11, int i12, String str3, Media media, Link link, int i13, int i14, String str4, long j11, int i15) {
        return new ShortTVItem(str, str2, i11, i12, str3, media, link, i13, i14, str4, j11, i15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(ShortTVItem.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.ShortTVItem");
        ShortTVItem shortTVItem = (ShortTVItem) obj;
        return Intrinsics.b(this.subjectId, shortTVItem.subjectId) && this.f53886se == shortTVItem.f53886se && this.f53884ep == shortTVItem.f53884ep;
    }

    public final int getCoin() {
        return this.coin;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    public final int getEp() {
        return this.f53884ep;
    }

    public final String getId() {
        return this.f53885id;
    }

    public final Link getLink() {
        return this.link;
    }

    public final int getLockStatus() {
        return this.lockStatus;
    }

    public final long getPlayProgress() {
        return this.playProgress;
    }

    public final int getSe() {
        return this.f53886se;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Media getVideo() {
        return this.video;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public int hashCode() {
        String str = this.subjectId;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.f53886se) * 31) + this.f53884ep;
    }

    public final void setCoin(int i11) {
        this.coin = i11;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDownloadStatus(int i11) {
        this.downloadStatus = i11;
    }

    public final void setEp(int i11) {
        this.f53884ep = i11;
    }

    public final void setId(String str) {
        this.f53885id = str;
    }

    public final void setLink(Link link) {
        this.link = link;
    }

    public final void setLockStatus(int i11) {
        this.lockStatus = i11;
    }

    public final void setPlayProgress(long j11) {
        this.playProgress = j11;
    }

    public final void setSe(int i11) {
        this.f53886se = i11;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setVideo(Media media) {
        this.video = media;
    }

    public final void setVideoId(String str) {
        this.videoId = str;
    }

    public final MediaSource toMediaSource() {
        Video videoAddress;
        Media media = this.video;
        MediaSource mediaSource = null;
        String url = (media == null || (videoAddress = media.getVideoAddress()) == null) ? null : videoAddress.getUrl();
        if (url != null && url.length() != 0) {
            String str = this.f53885id;
            mediaSource = new MediaSource(str == null ? url : str, url, this.f53884ep, null, null, 24, null);
        }
        return mediaSource;
    }

    public String toString() {
        return "ShortTVItem(id=" + this.f53885id + ", subjectId=" + this.subjectId + ", se=" + this.f53886se + ", ep=" + this.f53884ep + ", videoId=" + this.videoId + ", video=" + this.video + ", link=" + this.link + ", lockStatus=" + this.lockStatus + ", coin=" + this.coin + ", description=" + this.description + ", playProgress=" + this.playProgress + ", downloadStatus=" + this.downloadStatus + ")";
    }
}
