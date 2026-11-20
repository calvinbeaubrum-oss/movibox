package com.transsion.publish.api.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MediaVideoEntity implements Serializable {
    private int bitrate;
    private int definition;
    private long duration;
    private int fps;
    private int height;
    private String imagePath;
    private long size;
    private String url = "";
    private int width;

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getDefinition() {
        return this.definition;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setBitrate(int i11) {
        this.bitrate = i11;
    }

    public final void setDefinition(int i11) {
        this.definition = i11;
    }

    public final void setDuration(long j11) {
        this.duration = j11;
    }

    public final void setFps(int i11) {
        this.fps = i11;
    }

    public final void setHeight(int i11) {
        this.height = i11;
    }

    public final void setImagePath(String str) {
        this.imagePath = str;
    }

    public final void setSize(long j11) {
        this.size = j11;
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }

    public final void setWidth(int i11) {
        this.width = i11;
    }

    public String toString() {
        return "MediaVideoEntity(url='" + this.url + "', size=" + this.size + ", duration=" + this.duration + ", height=" + this.height + ", width=" + this.width + ", fps=" + this.fps + ", bitrate=" + this.bitrate + ", imagePath=" + this.imagePath + ", definition=" + this.definition + ")";
    }
}
