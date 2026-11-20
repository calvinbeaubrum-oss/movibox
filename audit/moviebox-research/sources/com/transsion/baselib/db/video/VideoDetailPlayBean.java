package com.transsion.baselib.db.video;

import androidx.annotation.Keep;
import com.transsion.baselib.utils.PlayMode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;
import org.mvel2.ast.ASTNode;

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
@Keep
@Metadata
public final class VideoDetailPlayBean {
    private String averageHueLight;
    private final String coverUrl;
    private String downloadFilePath;
    private long downloadSize;
    private String downloadUrl;
    private ArrayList<String> dubs;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private final int f51092ep;
    private boolean hasDelete;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f51093id;
    private Long lastAdEndTimeStamp;
    private Long lastAdStartTimeStamp;
    private String playMode;
    private long progress;
    private boolean rewardFree;
    private boolean rewardPlayed;
    private boolean rewardUnlock;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private final int f51094se;
    private Long subjectDurationSeconds;
    private final String subjectId;
    private Integer subjectType;
    private String subtitleSelectId;
    private final String thumbnail;
    private long timeStamp;
    private final String title;
    private Long totalDuration;
    private final String videoUrl;

    public VideoDetailPlayBean(String subjectId, String id2, int i11, int i12, long j11, String str, String str2, String str3, String str4, long j12, String str5, Long l11, Long l12, String str6, Integer num, boolean z11, String playMode, String str7, String str8, long j13, ArrayList<String> arrayList, Long l13, Long l14, boolean z12, boolean z13, boolean z14) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(id2, "id");
        Intrinsics.g(playMode, "playMode");
        this.subjectId = subjectId;
        this.f51093id = id2;
        this.f51092ep = i11;
        this.f51094se = i12;
        this.progress = j11;
        this.title = str;
        this.coverUrl = str2;
        this.thumbnail = str3;
        this.videoUrl = str4;
        this.timeStamp = j12;
        this.subtitleSelectId = str5;
        this.totalDuration = l11;
        this.subjectDurationSeconds = l12;
        this.averageHueLight = str6;
        this.subjectType = num;
        this.hasDelete = z11;
        this.playMode = playMode;
        this.downloadUrl = str7;
        this.downloadFilePath = str8;
        this.downloadSize = j13;
        this.dubs = arrayList;
        this.lastAdStartTimeStamp = l13;
        this.lastAdEndTimeStamp = l14;
        this.rewardPlayed = z12;
        this.rewardUnlock = z13;
        this.rewardFree = z14;
    }

    public /* synthetic */ VideoDetailPlayBean(String str, String str2, int i11, int i12, long j11, String str3, String str4, String str5, String str6, long j12, String str7, Long l11, Long l12, String str8, Integer num, boolean z11, String str9, String str10, String str11, long j13, ArrayList arrayList, Long l13, Long l14, boolean z12, boolean z13, boolean z14, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12, (i13 & 16) != 0 ? 0L : j11, (i13 & 32) != 0 ? null : str3, (i13 & 64) != 0 ? null : str4, (i13 & 128) != 0 ? null : str5, (i13 & 256) != 0 ? null : str6, (i13 & 512) != 0 ? 0L : j12, (i13 & 1024) != 0 ? null : str7, (i13 & 2048) != 0 ? 0L : l11, (i13 & 4096) != 0 ? 0L : l12, (i13 & 8192) != 0 ? null : str8, (i13 & 16384) != 0 ? 1 : num, (32768 & i13) != 0 ? false : z11, (65536 & i13) != 0 ? PlayMode.STREAM.getValue() : str9, (131072 & i13) != 0 ? null : str10, (262144 & i13) != 0 ? null : str11, (524288 & i13) != 0 ? 0L : j13, (1048576 & i13) != 0 ? null : arrayList, (2097152 & i13) != 0 ? null : l13, (4194304 & i13) != 0 ? null : l14, (8388608 & i13) != 0 ? false : z12, (16777216 & i13) != 0 ? false : z13, (i13 & ASTNode.PCTX_STORED) != 0 ? false : z14);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final long component10() {
        return this.timeStamp;
    }

    public final String component11() {
        return this.subtitleSelectId;
    }

    public final Long component12() {
        return this.totalDuration;
    }

    public final Long component13() {
        return this.subjectDurationSeconds;
    }

    public final String component14() {
        return this.averageHueLight;
    }

    public final Integer component15() {
        return this.subjectType;
    }

    public final boolean component16() {
        return this.hasDelete;
    }

    public final String component17() {
        return this.playMode;
    }

    public final String component18() {
        return this.downloadUrl;
    }

    public final String component19() {
        return this.downloadFilePath;
    }

    public final String component2() {
        return this.f51093id;
    }

    public final long component20() {
        return this.downloadSize;
    }

    public final ArrayList<String> component21() {
        return this.dubs;
    }

    public final Long component22() {
        return this.lastAdStartTimeStamp;
    }

    public final Long component23() {
        return this.lastAdEndTimeStamp;
    }

    public final boolean component24() {
        return this.rewardPlayed;
    }

    public final boolean component25() {
        return this.rewardUnlock;
    }

    public final boolean component26() {
        return this.rewardFree;
    }

    public final int component3() {
        return this.f51092ep;
    }

    public final int component4() {
        return this.f51094se;
    }

    public final long component5() {
        return this.progress;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.coverUrl;
    }

    public final String component8() {
        return this.thumbnail;
    }

    public final String component9() {
        return this.videoUrl;
    }

    public final VideoDetailPlayBean copy(String subjectId, String id2, int i11, int i12, long j11, String str, String str2, String str3, String str4, long j12, String str5, Long l11, Long l12, String str6, Integer num, boolean z11, String playMode, String str7, String str8, long j13, ArrayList<String> arrayList, Long l13, Long l14, boolean z12, boolean z13, boolean z14) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(id2, "id");
        Intrinsics.g(playMode, "playMode");
        return new VideoDetailPlayBean(subjectId, id2, i11, i12, j11, str, str2, str3, str4, j12, str5, l11, l12, str6, num, z11, playMode, str7, str8, j13, arrayList, l13, l14, z12, z13, z14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoDetailPlayBean)) {
            return false;
        }
        VideoDetailPlayBean videoDetailPlayBean = (VideoDetailPlayBean) obj;
        return Intrinsics.b(this.subjectId, videoDetailPlayBean.subjectId) && Intrinsics.b(this.f51093id, videoDetailPlayBean.f51093id) && this.f51092ep == videoDetailPlayBean.f51092ep && this.f51094se == videoDetailPlayBean.f51094se && this.progress == videoDetailPlayBean.progress && Intrinsics.b(this.title, videoDetailPlayBean.title) && Intrinsics.b(this.coverUrl, videoDetailPlayBean.coverUrl) && Intrinsics.b(this.thumbnail, videoDetailPlayBean.thumbnail) && Intrinsics.b(this.videoUrl, videoDetailPlayBean.videoUrl) && this.timeStamp == videoDetailPlayBean.timeStamp && Intrinsics.b(this.subtitleSelectId, videoDetailPlayBean.subtitleSelectId) && Intrinsics.b(this.totalDuration, videoDetailPlayBean.totalDuration) && Intrinsics.b(this.subjectDurationSeconds, videoDetailPlayBean.subjectDurationSeconds) && Intrinsics.b(this.averageHueLight, videoDetailPlayBean.averageHueLight) && Intrinsics.b(this.subjectType, videoDetailPlayBean.subjectType) && this.hasDelete == videoDetailPlayBean.hasDelete && Intrinsics.b(this.playMode, videoDetailPlayBean.playMode) && Intrinsics.b(this.downloadUrl, videoDetailPlayBean.downloadUrl) && Intrinsics.b(this.downloadFilePath, videoDetailPlayBean.downloadFilePath) && this.downloadSize == videoDetailPlayBean.downloadSize && Intrinsics.b(this.dubs, videoDetailPlayBean.dubs) && Intrinsics.b(this.lastAdStartTimeStamp, videoDetailPlayBean.lastAdStartTimeStamp) && Intrinsics.b(this.lastAdEndTimeStamp, videoDetailPlayBean.lastAdEndTimeStamp) && this.rewardPlayed == videoDetailPlayBean.rewardPlayed && this.rewardUnlock == videoDetailPlayBean.rewardUnlock && this.rewardFree == videoDetailPlayBean.rewardFree;
    }

    public final String getAverageHueLight() {
        return this.averageHueLight;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDownloadFilePath() {
        return this.downloadFilePath;
    }

    public final long getDownloadSize() {
        return this.downloadSize;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final ArrayList<String> getDubs() {
        return this.dubs;
    }

    public final int getEp() {
        return this.f51092ep;
    }

    public final boolean getHasDelete() {
        return this.hasDelete;
    }

    public final String getId() {
        return this.f51093id;
    }

    public final Long getLastAdEndTimeStamp() {
        return this.lastAdEndTimeStamp;
    }

    public final Long getLastAdStartTimeStamp() {
        return this.lastAdStartTimeStamp;
    }

    public final String getPlayMode() {
        return this.playMode;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final boolean getRewardFree() {
        return this.rewardFree;
    }

    public final boolean getRewardPlayed() {
        return this.rewardPlayed;
    }

    public final boolean getRewardUnlock() {
        return this.rewardUnlock;
    }

    public final int getSe() {
        return this.f51094se;
    }

    public final Long getSubjectDurationSeconds() {
        return this.subjectDurationSeconds;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final String getSubtitleSelectId() {
        return this.subtitleSelectId;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getTotalDuration() {
        return this.totalDuration;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v47, types: [int] */
    /* JADX WARN: Type inference failed for: r0v49, types: [int] */
    /* JADX WARN: Type inference failed for: r0v51, types: [int] */
    /* JADX WARN: Type inference failed for: r1v35, types: [int] */
    /* JADX WARN: Type inference failed for: r1v53, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55, types: [int] */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        int iHashCode = ((((((((this.subjectId.hashCode() * 31) + this.f51093id.hashCode()) * 31) + this.f51092ep) * 31) + this.f51094se) * 31) + p.a(this.progress)) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.coverUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnail;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.videoUrl;
        int iHashCode5 = (((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + p.a(this.timeStamp)) * 31;
        String str5 = this.subtitleSelectId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l11 = this.totalDuration;
        int iHashCode7 = (iHashCode6 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.subjectDurationSeconds;
        int iHashCode8 = (iHashCode7 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str6 = this.averageHueLight;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.subjectType;
        int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z11 = this.hasDelete;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int iHashCode11 = (((iHashCode10 + r11) * 31) + this.playMode.hashCode()) * 31;
        String str7 = this.downloadUrl;
        int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.downloadFilePath;
        int iHashCode13 = (((iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31) + p.a(this.downloadSize)) * 31;
        ArrayList<String> arrayList = this.dubs;
        int iHashCode14 = (iHashCode13 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Long l13 = this.lastAdStartTimeStamp;
        int iHashCode15 = (iHashCode14 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.lastAdEndTimeStamp;
        int iHashCode16 = (iHashCode15 + (l14 != null ? l14.hashCode() : 0)) * 31;
        boolean z12 = this.rewardPlayed;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i11 = (iHashCode16 + r12) * 31;
        boolean z13 = this.rewardUnlock;
        ?? r13 = z13;
        if (z13) {
            r13 = 1;
        }
        int i12 = (i11 + r13) * 31;
        boolean z14 = this.rewardFree;
        return i12 + (z14 ? 1 : z14);
    }

    public final void setAverageHueLight(String str) {
        this.averageHueLight = str;
    }

    public final void setDownloadFilePath(String str) {
        this.downloadFilePath = str;
    }

    public final void setDownloadSize(long j11) {
        this.downloadSize = j11;
    }

    public final void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public final void setDubs(ArrayList<String> arrayList) {
        this.dubs = arrayList;
    }

    public final void setHasDelete(boolean z11) {
        this.hasDelete = z11;
    }

    public final void setLastAdEndTimeStamp(Long l11) {
        this.lastAdEndTimeStamp = l11;
    }

    public final void setLastAdStartTimeStamp(Long l11) {
        this.lastAdStartTimeStamp = l11;
    }

    public final void setPlayMode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.playMode = str;
    }

    public final void setProgress(long j11) {
        this.progress = j11;
    }

    public final void setRewardFree(boolean z11) {
        this.rewardFree = z11;
    }

    public final void setRewardPlayed(boolean z11) {
        this.rewardPlayed = z11;
    }

    public final void setRewardUnlock(boolean z11) {
        this.rewardUnlock = z11;
    }

    public final void setSubjectDurationSeconds(Long l11) {
        this.subjectDurationSeconds = l11;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public final void setSubtitleSelectId(String str) {
        this.subtitleSelectId = str;
    }

    public final void setTimeStamp(long j11) {
        this.timeStamp = j11;
    }

    public final void setTotalDuration(Long l11) {
        this.totalDuration = l11;
    }

    public String toString() {
        return "VideoDetailPlayBean(subjectId=" + this.subjectId + ", id=" + this.f51093id + ", ep=" + this.f51092ep + ", se=" + this.f51094se + ", progress=" + this.progress + ", title=" + this.title + ", coverUrl=" + this.coverUrl + ", thumbnail=" + this.thumbnail + ", videoUrl=" + this.videoUrl + ", timeStamp=" + this.timeStamp + ", subtitleSelectId=" + this.subtitleSelectId + ", totalDuration=" + this.totalDuration + ", subjectDurationSeconds=" + this.subjectDurationSeconds + ", averageHueLight=" + this.averageHueLight + ", subjectType=" + this.subjectType + ", hasDelete=" + this.hasDelete + ", playMode=" + this.playMode + ", downloadUrl=" + this.downloadUrl + ", downloadFilePath=" + this.downloadFilePath + ", downloadSize=" + this.downloadSize + ", dubs=" + this.dubs + ", lastAdStartTimeStamp=" + this.lastAdStartTimeStamp + ", lastAdEndTimeStamp=" + this.lastAdEndTimeStamp + ", rewardPlayed=" + this.rewardPlayed + ", rewardUnlock=" + this.rewardUnlock + ", rewardFree=" + this.rewardFree + ")";
    }
}
