package com.transsion.videodetail.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class VideoDetailStream implements Serializable {
    private final String duration;
    private final List<ExtCaption> extCaptions;
    private final String format;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f59898id;
    private final String resolutions;
    private final String signCookie;
    private final String size;
    private String url;

    public VideoDetailStream(String format, String id2, String url, String resolutions, String size, String duration, String signCookie, List<ExtCaption> extCaptions) {
        Intrinsics.g(format, "format");
        Intrinsics.g(id2, "id");
        Intrinsics.g(url, "url");
        Intrinsics.g(resolutions, "resolutions");
        Intrinsics.g(size, "size");
        Intrinsics.g(duration, "duration");
        Intrinsics.g(signCookie, "signCookie");
        Intrinsics.g(extCaptions, "extCaptions");
        this.format = format;
        this.f59898id = id2;
        this.url = url;
        this.resolutions = resolutions;
        this.size = size;
        this.duration = duration;
        this.signCookie = signCookie;
        this.extCaptions = extCaptions;
    }

    public final String component1() {
        return this.format;
    }

    public final String component2() {
        return this.f59898id;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.resolutions;
    }

    public final String component5() {
        return this.size;
    }

    public final String component6() {
        return this.duration;
    }

    public final String component7() {
        return this.signCookie;
    }

    public final List<ExtCaption> component8() {
        return this.extCaptions;
    }

    public final VideoDetailStream copy(String format, String id2, String url, String resolutions, String size, String duration, String signCookie, List<ExtCaption> extCaptions) {
        Intrinsics.g(format, "format");
        Intrinsics.g(id2, "id");
        Intrinsics.g(url, "url");
        Intrinsics.g(resolutions, "resolutions");
        Intrinsics.g(size, "size");
        Intrinsics.g(duration, "duration");
        Intrinsics.g(signCookie, "signCookie");
        Intrinsics.g(extCaptions, "extCaptions");
        return new VideoDetailStream(format, id2, url, resolutions, size, duration, signCookie, extCaptions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoDetailStream)) {
            return false;
        }
        VideoDetailStream videoDetailStream = (VideoDetailStream) obj;
        return Intrinsics.b(this.format, videoDetailStream.format) && Intrinsics.b(this.f59898id, videoDetailStream.f59898id) && Intrinsics.b(this.url, videoDetailStream.url) && Intrinsics.b(this.resolutions, videoDetailStream.resolutions) && Intrinsics.b(this.size, videoDetailStream.size) && Intrinsics.b(this.duration, videoDetailStream.duration) && Intrinsics.b(this.signCookie, videoDetailStream.signCookie) && Intrinsics.b(this.extCaptions, videoDetailStream.extCaptions);
    }

    public final String getDuration() {
        return this.duration;
    }

    public final List<ExtCaption> getExtCaptions() {
        return this.extCaptions;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getId() {
        return this.f59898id;
    }

    public final String getResolutions() {
        return this.resolutions;
    }

    public final String getSignCookie() {
        return this.signCookie;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((((((((this.format.hashCode() * 31) + this.f59898id.hashCode()) * 31) + this.url.hashCode()) * 31) + this.resolutions.hashCode()) * 31) + this.size.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.signCookie.hashCode()) * 31) + this.extCaptions.hashCode();
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "VideoDetailStream(format=" + this.format + ", id=" + this.f59898id + ", url=" + this.url + ", resolutions=" + this.resolutions + ", size=" + this.size + ", duration=" + this.duration + ", signCookie=" + this.signCookie + ", extCaptions=" + this.extCaptions + ")";
    }
}
