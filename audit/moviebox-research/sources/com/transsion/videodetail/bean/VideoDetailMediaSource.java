package com.transsion.videodetail.bean;

import androidx.annotation.Keep;
import com.transsion.baselib.db.download.DownloadBean;
import java.io.Serializable;
import java.util.List;
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
public final class VideoDetailMediaSource implements Serializable {
    private DownloadBean downloadBean;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private final int f59896ep;
    private String name;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private final int f59897se;
    private List<VideoDetailStream> streams;
    private final String subjectId;

    public VideoDetailMediaSource(String subjectId, int i11, int i12, List<VideoDetailStream> list) {
        Intrinsics.g(subjectId, "subjectId");
        this.subjectId = subjectId;
        this.f59897se = i11;
        this.f59896ep = i12;
        this.streams = list;
    }

    public /* synthetic */ VideoDetailMediaSource(String str, int i11, int i12, List list, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, i12, (i13 & 8) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoDetailMediaSource copy$default(VideoDetailMediaSource videoDetailMediaSource, String str, int i11, int i12, List list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = videoDetailMediaSource.subjectId;
        }
        if ((i13 & 2) != 0) {
            i11 = videoDetailMediaSource.f59897se;
        }
        if ((i13 & 4) != 0) {
            i12 = videoDetailMediaSource.f59896ep;
        }
        if ((i13 & 8) != 0) {
            list = videoDetailMediaSource.streams;
        }
        return videoDetailMediaSource.copy(str, i11, i12, list);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final int component2() {
        return this.f59897se;
    }

    public final int component3() {
        return this.f59896ep;
    }

    public final List<VideoDetailStream> component4() {
        return this.streams;
    }

    public final VideoDetailMediaSource copy(String subjectId, int i11, int i12, List<VideoDetailStream> list) {
        Intrinsics.g(subjectId, "subjectId");
        return new VideoDetailMediaSource(subjectId, i11, i12, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(VideoDetailMediaSource.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.videodetail.bean.VideoDetailMediaSource");
        VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) obj;
        return Intrinsics.b(this.subjectId, videoDetailMediaSource.subjectId) && this.f59897se == videoDetailMediaSource.f59897se && this.f59896ep == videoDetailMediaSource.f59896ep;
    }

    public final DownloadBean getDownloadBean() {
        return this.downloadBean;
    }

    public final int getEp() {
        return this.f59896ep;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSe() {
        return this.f59897se;
    }

    public final List<VideoDetailStream> getStreams() {
        return this.streams;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public int hashCode() {
        return (((this.subjectId.hashCode() * 31) + this.f59897se) * 31) + this.f59896ep;
    }

    public final void setDownloadBean(DownloadBean downloadBean) {
        this.downloadBean = downloadBean;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setStreams(List<VideoDetailStream> list) {
        this.streams = list;
    }

    public String toString() {
        return "VideoDetailMediaSource(subjectId=" + this.subjectId + ", se=" + this.f59897se + ", ep=" + this.f59896ep + ", streams=" + this.streams + ")";
    }
}
