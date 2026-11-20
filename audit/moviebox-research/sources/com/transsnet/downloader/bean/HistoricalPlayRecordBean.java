package com.transsnet.downloader.bean;

import androidx.annotation.Keep;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class HistoricalPlayRecordBean implements Serializable {
    private AudioBean audio;
    private String formatTime;
    private Boolean isLocalFileDelete;
    private String originalFormatTime;
    private VideoDetailPlayBean streamVideo;
    private int type;
    private Long updateTimeStamp;
    private DownloadBean video;

    public HistoricalPlayRecordBean(int i11, Long l11, String str, String str2, AudioBean audioBean, DownloadBean downloadBean, Boolean bool, VideoDetailPlayBean videoDetailPlayBean) {
        this.type = i11;
        this.updateTimeStamp = l11;
        this.originalFormatTime = str;
        this.formatTime = str2;
        this.audio = audioBean;
        this.video = downloadBean;
        this.isLocalFileDelete = bool;
        this.streamVideo = videoDetailPlayBean;
    }

    public /* synthetic */ HistoricalPlayRecordBean(int i11, Long l11, String str, String str2, AudioBean audioBean, DownloadBean downloadBean, Boolean bool, VideoDetailPlayBean videoDetailPlayBean, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, l11, str, str2, audioBean, downloadBean, (i12 & 64) != 0 ? Boolean.FALSE : bool, (i12 & 128) != 0 ? null : videoDetailPlayBean);
    }

    public final int component1() {
        return this.type;
    }

    public final Long component2() {
        return this.updateTimeStamp;
    }

    public final String component3() {
        return this.originalFormatTime;
    }

    public final String component4() {
        return this.formatTime;
    }

    public final AudioBean component5() {
        return this.audio;
    }

    public final DownloadBean component6() {
        return this.video;
    }

    public final Boolean component7() {
        return this.isLocalFileDelete;
    }

    public final VideoDetailPlayBean component8() {
        return this.streamVideo;
    }

    public final HistoricalPlayRecordBean copy(int i11, Long l11, String str, String str2, AudioBean audioBean, DownloadBean downloadBean, Boolean bool, VideoDetailPlayBean videoDetailPlayBean) {
        return new HistoricalPlayRecordBean(i11, l11, str, str2, audioBean, downloadBean, bool, videoDetailPlayBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoricalPlayRecordBean)) {
            return false;
        }
        HistoricalPlayRecordBean historicalPlayRecordBean = (HistoricalPlayRecordBean) obj;
        return this.type == historicalPlayRecordBean.type && Intrinsics.b(this.updateTimeStamp, historicalPlayRecordBean.updateTimeStamp) && Intrinsics.b(this.originalFormatTime, historicalPlayRecordBean.originalFormatTime) && Intrinsics.b(this.formatTime, historicalPlayRecordBean.formatTime) && Intrinsics.b(this.audio, historicalPlayRecordBean.audio) && Intrinsics.b(this.video, historicalPlayRecordBean.video) && Intrinsics.b(this.isLocalFileDelete, historicalPlayRecordBean.isLocalFileDelete) && Intrinsics.b(this.streamVideo, historicalPlayRecordBean.streamVideo);
    }

    public final AudioBean getAudio() {
        return this.audio;
    }

    public final String getFormatTime() {
        return this.formatTime;
    }

    public final String getOriginalFormatTime() {
        return this.originalFormatTime;
    }

    public final VideoDetailPlayBean getStreamVideo() {
        return this.streamVideo;
    }

    public final int getType() {
        return this.type;
    }

    public final Long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final DownloadBean getVideo() {
        return this.video;
    }

    public int hashCode() {
        int i11 = this.type * 31;
        Long l11 = this.updateTimeStamp;
        int iHashCode = (i11 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.originalFormatTime;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.formatTime;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        AudioBean audioBean = this.audio;
        int iHashCode4 = (iHashCode3 + (audioBean == null ? 0 : audioBean.hashCode())) * 31;
        DownloadBean downloadBean = this.video;
        int iHashCode5 = (iHashCode4 + (downloadBean == null ? 0 : downloadBean.hashCode())) * 31;
        Boolean bool = this.isLocalFileDelete;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        VideoDetailPlayBean videoDetailPlayBean = this.streamVideo;
        return iHashCode6 + (videoDetailPlayBean != null ? videoDetailPlayBean.hashCode() : 0);
    }

    public final Boolean isLocalFileDelete() {
        return this.isLocalFileDelete;
    }

    public final void setAudio(AudioBean audioBean) {
        this.audio = audioBean;
    }

    public final void setFormatTime(String str) {
        this.formatTime = str;
    }

    public final void setLocalFileDelete(Boolean bool) {
        this.isLocalFileDelete = bool;
    }

    public final void setOriginalFormatTime(String str) {
        this.originalFormatTime = str;
    }

    public final void setStreamVideo(VideoDetailPlayBean videoDetailPlayBean) {
        this.streamVideo = videoDetailPlayBean;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUpdateTimeStamp(Long l11) {
        this.updateTimeStamp = l11;
    }

    public final void setVideo(DownloadBean downloadBean) {
        this.video = downloadBean;
    }

    public String toString() {
        return "HistoricalPlayRecordBean(type=" + this.type + ", updateTimeStamp=" + this.updateTimeStamp + ", originalFormatTime=" + this.originalFormatTime + ", formatTime=" + this.formatTime + ", audio=" + this.audio + ", video=" + this.video + ", isLocalFileDelete=" + this.isLocalFileDelete + ", streamVideo=" + this.streamVideo + ")";
    }
}
