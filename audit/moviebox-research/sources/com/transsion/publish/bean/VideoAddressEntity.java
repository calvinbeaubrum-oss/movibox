package com.transsion.publish.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;

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
public final class VideoAddressEntity implements Serializable {
    private String bitrate;
    private String definition;
    private String duration;
    private String fps;
    private String height;
    private String size;
    private String url;
    private String videoId;
    private String width;

    public final String getBitrate() {
        return this.bitrate;
    }

    public final String getDefinition() {
        return this.definition;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getFps() {
        return this.fps;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getWidth() {
        return this.width;
    }

    public final void setBitrate(String str) {
        this.bitrate = str;
    }

    public final void setDefinition(String str) {
        this.definition = str;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final void setFps(String str) {
        this.fps = str;
    }

    public final void setHeight(String str) {
        this.height = str;
    }

    public final void setSize(String str) {
        this.size = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setVideoId(String str) {
        this.videoId = str;
    }

    public final void setWidth(String str) {
        this.width = str;
    }
}
