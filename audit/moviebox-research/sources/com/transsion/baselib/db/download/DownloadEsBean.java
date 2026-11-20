package com.transsion.baselib.db.download;

import androidx.annotation.Keep;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class DownloadEsBean implements Serializable {
    public static final a Companion = new a(null);
    private String cover;
    private long createAt;
    private Long duration;
    private String groupId;
    private int isRead;
    private String name;
    private String path;
    private String postId;
    private long progress;
    private long readProgress;
    private String resourceId;
    private Long size;
    private String sizeFormat;
    private int status;
    private String subjectId;
    private int supportRanges;
    private int type;
    private Long updateTimeStamp;
    private String url;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadEsBean a(DownloadBean esBean) {
            Intrinsics.g(esBean, "esBean");
            String url = esBean.getUrl();
            String resourceId = esBean.getResourceId();
            if (resourceId == null) {
                resourceId = esBean.getUrl();
            }
            return new DownloadEsBean(url, resourceId, esBean.getName(), esBean.getCover(), esBean.getSize(), esBean.getPostId(), esBean.getSizeFormat(), esBean.getPath(), esBean.getDuration(), esBean.getUpdateTimeStamp(), esBean.getProgress(), esBean.getSupportRanges(), esBean.getStatus(), esBean.getType(), esBean.getReadProgress(), esBean.getCreateAt(), esBean.isRead(), esBean.getSubjectId(), esBean.getGroupId());
        }

        public final DownloadBean b(DownloadEsBean esBean) {
            Intrinsics.g(esBean, "esBean");
            DownloadBean downloadBean = new DownloadBean(esBean.getUrl(), esBean.getResourceId(), esBean.getName(), esBean.getCover(), esBean.getSize(), esBean.getPostId(), esBean.getSizeFormat(), esBean.getPath(), esBean.getDuration(), esBean.getUpdateTimeStamp(), esBean.getProgress(), esBean.getSupportRanges(), esBean.getStatus(), esBean.getType(), esBean.getReadProgress(), esBean.getCreateAt(), esBean.isRead(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -131072, 1073741823, null);
            downloadBean.setSubjectId(esBean.getSubjectId());
            downloadBean.setGroupId(esBean.getGroupId());
            return downloadBean;
        }
    }

    public DownloadEsBean(String url, String resourceId, String str, String str2, Long l11, String str3, String str4, String str5, Long l12, Long l13, long j11, int i11, int i12, int i13, long j12, long j13, int i14, String str6, String str7) {
        Intrinsics.g(url, "url");
        Intrinsics.g(resourceId, "resourceId");
        this.url = url;
        this.resourceId = resourceId;
        this.name = str;
        this.cover = str2;
        this.size = l11;
        this.postId = str3;
        this.sizeFormat = str4;
        this.path = str5;
        this.duration = l12;
        this.updateTimeStamp = l13;
        this.progress = j11;
        this.supportRanges = i11;
        this.status = i12;
        this.type = i13;
        this.readProgress = j12;
        this.createAt = j13;
        this.isRead = i14;
        this.subjectId = str6;
        this.groupId = str7;
    }

    public /* synthetic */ DownloadEsBean(String str, String str2, String str3, String str4, Long l11, String str5, String str6, String str7, Long l12, Long l13, long j11, int i11, int i12, int i13, long j12, long j13, int i14, String str8, String str9, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, l11, (i15 & 32) != 0 ? "" : str5, (i15 & 64) != 0 ? "" : str6, (i15 & 128) != 0 ? "" : str7, (i15 & 256) != 0 ? 0L : l12, (i15 & 512) != 0 ? Long.valueOf(System.currentTimeMillis()) : l13, (i15 & 1024) != 0 ? 0L : j11, (i15 & 2048) != 0 ? 0 : i11, (i15 & 4096) != 0 ? 0 : i12, (i15 & 8192) != 0 ? 2 : i13, (i15 & 16384) != 0 ? 0L : j12, (32768 & i15) != 0 ? System.currentTimeMillis() : j13, (i15 & 65536) != 0 ? 1 : i14, str8, str9);
    }

    public final String component1() {
        return this.url;
    }

    public final Long component10() {
        return this.updateTimeStamp;
    }

    public final long component11() {
        return this.progress;
    }

    public final int component12() {
        return this.supportRanges;
    }

    public final int component13() {
        return this.status;
    }

    public final int component14() {
        return this.type;
    }

    public final long component15() {
        return this.readProgress;
    }

    public final long component16() {
        return this.createAt;
    }

    public final int component17() {
        return this.isRead;
    }

    public final String component18() {
        return this.subjectId;
    }

    public final String component19() {
        return this.groupId;
    }

    public final String component2() {
        return this.resourceId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.cover;
    }

    public final Long component5() {
        return this.size;
    }

    public final String component6() {
        return this.postId;
    }

    public final String component7() {
        return this.sizeFormat;
    }

    public final String component8() {
        return this.path;
    }

    public final Long component9() {
        return this.duration;
    }

    public final DownloadEsBean copy(String url, String resourceId, String str, String str2, Long l11, String str3, String str4, String str5, Long l12, Long l13, long j11, int i11, int i12, int i13, long j12, long j13, int i14, String str6, String str7) {
        Intrinsics.g(url, "url");
        Intrinsics.g(resourceId, "resourceId");
        return new DownloadEsBean(url, resourceId, str, str2, l11, str3, str4, str5, l12, l13, j11, i11, i12, i13, j12, j13, i14, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadEsBean)) {
            return false;
        }
        DownloadEsBean downloadEsBean = (DownloadEsBean) obj;
        return Intrinsics.b(this.url, downloadEsBean.url) && Intrinsics.b(this.resourceId, downloadEsBean.resourceId) && Intrinsics.b(this.name, downloadEsBean.name) && Intrinsics.b(this.cover, downloadEsBean.cover) && Intrinsics.b(this.size, downloadEsBean.size) && Intrinsics.b(this.postId, downloadEsBean.postId) && Intrinsics.b(this.sizeFormat, downloadEsBean.sizeFormat) && Intrinsics.b(this.path, downloadEsBean.path) && Intrinsics.b(this.duration, downloadEsBean.duration) && Intrinsics.b(this.updateTimeStamp, downloadEsBean.updateTimeStamp) && this.progress == downloadEsBean.progress && this.supportRanges == downloadEsBean.supportRanges && this.status == downloadEsBean.status && this.type == downloadEsBean.type && this.readProgress == downloadEsBean.readProgress && this.createAt == downloadEsBean.createAt && this.isRead == downloadEsBean.isRead && Intrinsics.b(this.subjectId, downloadEsBean.subjectId) && Intrinsics.b(this.groupId, downloadEsBean.groupId);
    }

    public final String getCover() {
        return this.cover;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final long getReadProgress() {
        return this.readProgress;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSizeFormat() {
        return this.sizeFormat;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final int getSupportRanges() {
        return this.supportRanges;
    }

    public final int getType() {
        return this.type;
    }

    public final Long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.resourceId.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cover;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l11 = this.size;
        int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str3 = this.postId;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sizeFormat;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.path;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l12 = this.duration;
        int iHashCode8 = (iHashCode7 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.updateTimeStamp;
        int iHashCode9 = (((((((((((((((iHashCode8 + (l13 == null ? 0 : l13.hashCode())) * 31) + p.a(this.progress)) * 31) + this.supportRanges) * 31) + this.status) * 31) + this.type) * 31) + p.a(this.readProgress)) * 31) + p.a(this.createAt)) * 31) + this.isRead) * 31;
        String str6 = this.subjectId;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.groupId;
        return iHashCode10 + (str7 != null ? str7.hashCode() : 0);
    }

    public final int isRead() {
        return this.isRead;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final void setCreateAt(long j11) {
        this.createAt = j11;
    }

    public final void setDuration(Long l11) {
        this.duration = l11;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setProgress(long j11) {
        this.progress = j11;
    }

    public final void setRead(int i11) {
        this.isRead = i11;
    }

    public final void setReadProgress(long j11) {
        this.readProgress = j11;
    }

    public final void setResourceId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.resourceId = str;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setSizeFormat(String str) {
        this.sizeFormat = str;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSupportRanges(int i11) {
        this.supportRanges = i11;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUpdateTimeStamp(Long l11) {
        this.updateTimeStamp = l11;
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "DownloadEsBean(url=" + this.url + ", resourceId=" + this.resourceId + ", name=" + this.name + ", cover=" + this.cover + ", size=" + this.size + ", postId=" + this.postId + ", sizeFormat=" + this.sizeFormat + ", path=" + this.path + ", duration=" + this.duration + ", updateTimeStamp=" + this.updateTimeStamp + ", progress=" + this.progress + ", supportRanges=" + this.supportRanges + ", status=" + this.status + ", type=" + this.type + ", readProgress=" + this.readProgress + ", createAt=" + this.createAt + ", isRead=" + this.isRead + ", subjectId=" + this.subjectId + ", groupId=" + this.groupId + ")";
    }
}
