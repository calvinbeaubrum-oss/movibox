package com.transsion.baselib.db.audio;

import androidx.annotation.Keep;
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
@Keep
@Metadata
public final class AudioBean implements Serializable {
    public static final a Companion = new a(null);
    public static final int STATUS_ERROR = 7;
    public static final int STATUS_FINISHED = 6;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_NO_OPEN = 1;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PLAYING = 3;
    private String audioUrl;
    private Integer bitrate;
    private String cover;
    private String desc;
    private Long duration;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private int f51065ep;
    private String groupId;
    private boolean isChangeToLocalPath;
    private String localPath;
    private String ops;
    private String postId;
    private Long readProcess;
    private String resourceId;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private int f51066se;
    private Long size;
    private int status;
    private String subjectId;
    private String subjectTitle;
    private String title;
    private Long updateTimeStamp;
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
    }

    public AudioBean(String audioUrl, String str, Long l11, Long l12, String str2, String str3, String str4, Integer num, Long l13, Long l14, String str5, String str6, String str7, String str8, String str9, String str10, int i11, String str11, int i12, int i13) {
        Intrinsics.g(audioUrl, "audioUrl");
        this.audioUrl = audioUrl;
        this.cover = str;
        this.duration = l11;
        this.size = l12;
        this.url = str2;
        this.title = str3;
        this.desc = str4;
        this.bitrate = num;
        this.updateTimeStamp = l13;
        this.readProcess = l14;
        this.localPath = str5;
        this.ops = str6;
        this.resourceId = str7;
        this.postId = str8;
        this.subjectId = str9;
        this.groupId = str10;
        this.status = i11;
        this.subjectTitle = str11;
        this.f51066se = i12;
        this.f51065ep = i13;
    }

    public /* synthetic */ AudioBean(String str, String str2, Long l11, Long l12, String str3, String str4, String str5, Integer num, Long l13, Long l14, String str6, String str7, String str8, String str9, String str10, String str11, int i11, String str12, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, l11, l12, str3, str4, (i14 & 64) != 0 ? "" : str5, (i14 & 128) != 0 ? 0 : num, (i14 & 256) != 0 ? 0L : l13, (i14 & 512) != 0 ? 0L : l14, (i14 & 1024) != 0 ? "" : str6, (i14 & 2048) != 0 ? "" : str7, (i14 & 4096) != 0 ? "" : str8, (i14 & 8192) != 0 ? "" : str9, (i14 & 16384) != 0 ? "" : str10, (32768 & i14) != 0 ? "" : str11, (65536 & i14) != 0 ? 1 : i11, (131072 & i14) != 0 ? "" : str12, (262144 & i14) != 0 ? 0 : i12, (i14 & 524288) != 0 ? 0 : i13);
    }

    public final String component1() {
        return this.audioUrl;
    }

    public final Long component10() {
        return this.readProcess;
    }

    public final String component11() {
        return this.localPath;
    }

    public final String component12() {
        return this.ops;
    }

    public final String component13() {
        return this.resourceId;
    }

    public final String component14() {
        return this.postId;
    }

    public final String component15() {
        return this.subjectId;
    }

    public final String component16() {
        return this.groupId;
    }

    public final int component17() {
        return this.status;
    }

    public final String component18() {
        return this.subjectTitle;
    }

    public final int component19() {
        return this.f51066se;
    }

    public final String component2() {
        return this.cover;
    }

    public final int component20() {
        return this.f51065ep;
    }

    public final Long component3() {
        return this.duration;
    }

    public final Long component4() {
        return this.size;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.desc;
    }

    public final Integer component8() {
        return this.bitrate;
    }

    public final Long component9() {
        return this.updateTimeStamp;
    }

    public final AudioBean copy(String audioUrl, String str, Long l11, Long l12, String str2, String str3, String str4, Integer num, Long l13, Long l14, String str5, String str6, String str7, String str8, String str9, String str10, int i11, String str11, int i12, int i13) {
        Intrinsics.g(audioUrl, "audioUrl");
        return new AudioBean(audioUrl, str, l11, l12, str2, str3, str4, num, l13, l14, str5, str6, str7, str8, str9, str10, i11, str11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioBean)) {
            return false;
        }
        AudioBean audioBean = (AudioBean) obj;
        return Intrinsics.b(this.audioUrl, audioBean.audioUrl) && Intrinsics.b(this.cover, audioBean.cover) && Intrinsics.b(this.duration, audioBean.duration) && Intrinsics.b(this.size, audioBean.size) && Intrinsics.b(this.url, audioBean.url) && Intrinsics.b(this.title, audioBean.title) && Intrinsics.b(this.desc, audioBean.desc) && Intrinsics.b(this.bitrate, audioBean.bitrate) && Intrinsics.b(this.updateTimeStamp, audioBean.updateTimeStamp) && Intrinsics.b(this.readProcess, audioBean.readProcess) && Intrinsics.b(this.localPath, audioBean.localPath) && Intrinsics.b(this.ops, audioBean.ops) && Intrinsics.b(this.resourceId, audioBean.resourceId) && Intrinsics.b(this.postId, audioBean.postId) && Intrinsics.b(this.subjectId, audioBean.subjectId) && Intrinsics.b(this.groupId, audioBean.groupId) && this.status == audioBean.status && Intrinsics.b(this.subjectTitle, audioBean.subjectTitle) && this.f51066se == audioBean.f51066se && this.f51065ep == audioBean.f51065ep;
    }

    public final String getAudioUrl() {
        return this.audioUrl;
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final int getEp() {
        return this.f51065ep;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final Long getReadProcess() {
        return this.readProcess;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getSe() {
        return this.f51066se;
    }

    public final Long getSize() {
        return this.size;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectTitle() {
        return this.subjectTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = this.audioUrl.hashCode() * 31;
        String str = this.cover;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l11 = this.duration;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.size;
        int iHashCode4 = (iHashCode3 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.desc;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.bitrate;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Long l13 = this.updateTimeStamp;
        int iHashCode9 = (iHashCode8 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.readProcess;
        int iHashCode10 = (iHashCode9 + (l14 == null ? 0 : l14.hashCode())) * 31;
        String str5 = this.localPath;
        int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ops;
        int iHashCode12 = (iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.resourceId;
        int iHashCode13 = (iHashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.postId;
        int iHashCode14 = (iHashCode13 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.subjectId;
        int iHashCode15 = (iHashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.groupId;
        int iHashCode16 = (((iHashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31) + this.status) * 31;
        String str11 = this.subjectTitle;
        return ((((iHashCode16 + (str11 != null ? str11.hashCode() : 0)) * 31) + this.f51066se) * 31) + this.f51065ep;
    }

    public final boolean isChangeToLocalPath() {
        return this.isChangeToLocalPath;
    }

    public final void setAudioUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.audioUrl = str;
    }

    public final void setBitrate(Integer num) {
        this.bitrate = num;
    }

    public final void setChangeToLocalPath(boolean z11) {
        this.isChangeToLocalPath = z11;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setDuration(Long l11) {
        this.duration = l11;
    }

    public final void setEp(int i11) {
        this.f51065ep = i11;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setLocalPath(String str) {
        this.localPath = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setReadProcess(Long l11) {
        this.readProcess = l11;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setSe(int i11) {
        this.f51066se = i11;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectTitle(String str) {
        this.subjectTitle = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUpdateTimeStamp(Long l11) {
        this.updateTimeStamp = l11;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "AudioBean(audioUrl=" + this.audioUrl + ", cover=" + this.cover + ", duration=" + this.duration + ", size=" + this.size + ", url=" + this.url + ", title=" + this.title + ", desc=" + this.desc + ", bitrate=" + this.bitrate + ", updateTimeStamp=" + this.updateTimeStamp + ", readProcess=" + this.readProcess + ", localPath=" + this.localPath + ", ops=" + this.ops + ", resourceId=" + this.resourceId + ", postId=" + this.postId + ", subjectId=" + this.subjectId + ", groupId=" + this.groupId + ", status=" + this.status + ", subjectTitle=" + this.subjectTitle + ", se=" + this.f51066se + ", ep=" + this.f51065ep + ")";
    }
}
