package com.transsion.videodetail.bean;

import androidx.annotation.Keep;
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
public final class VideoDetailStreamList implements Serializable {

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private int f59899ep;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private int f59900se;
    private final List<VideoDetailStream> streams;
    private String title;

    public VideoDetailStreamList(List<VideoDetailStream> streams, int i11, int i12, String str) {
        Intrinsics.g(streams, "streams");
        this.streams = streams;
        this.f59900se = i11;
        this.f59899ep = i12;
        this.title = str;
    }

    public /* synthetic */ VideoDetailStreamList(List list, int i11, int i12, String str, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12, (i13 & 8) != 0 ? null : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoDetailStreamList copy$default(VideoDetailStreamList videoDetailStreamList, List list, int i11, int i12, String str, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            list = videoDetailStreamList.streams;
        }
        if ((i13 & 2) != 0) {
            i11 = videoDetailStreamList.f59900se;
        }
        if ((i13 & 4) != 0) {
            i12 = videoDetailStreamList.f59899ep;
        }
        if ((i13 & 8) != 0) {
            str = videoDetailStreamList.title;
        }
        return videoDetailStreamList.copy(list, i11, i12, str);
    }

    public final List<VideoDetailStream> component1() {
        return this.streams;
    }

    public final int component2() {
        return this.f59900se;
    }

    public final int component3() {
        return this.f59899ep;
    }

    public final String component4() {
        return this.title;
    }

    public final VideoDetailStreamList copy(List<VideoDetailStream> streams, int i11, int i12, String str) {
        Intrinsics.g(streams, "streams");
        return new VideoDetailStreamList(streams, i11, i12, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoDetailStreamList)) {
            return false;
        }
        VideoDetailStreamList videoDetailStreamList = (VideoDetailStreamList) obj;
        return Intrinsics.b(this.streams, videoDetailStreamList.streams) && this.f59900se == videoDetailStreamList.f59900se && this.f59899ep == videoDetailStreamList.f59899ep && Intrinsics.b(this.title, videoDetailStreamList.title);
    }

    public final int getEp() {
        return this.f59899ep;
    }

    public final int getSe() {
        return this.f59900se;
    }

    public final List<VideoDetailStream> getStreams() {
        return this.streams;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((this.streams.hashCode() * 31) + this.f59900se) * 31) + this.f59899ep) * 31;
        String str = this.title;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setEp(int i11) {
        this.f59899ep = i11;
    }

    public final void setSe(int i11) {
        this.f59900se = i11;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "VideoDetailStreamList(streams=" + this.streams + ", se=" + this.f59900se + ", ep=" + this.f59899ep + ", title=" + this.title + ")";
    }
}
