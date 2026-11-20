package com.transsion.publish.api.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;
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
public final class RequestPostMediaEntity implements Serializable {
    private List<MediaAudioEntity> audio;
    private MediaCoverEntity cover;
    private List<MediaImageEntity> image;
    private int mediaType;
    private String tempBucket;
    private List<MediaVideoEntity> video;

    public final List<MediaAudioEntity> getAudio() {
        return this.audio;
    }

    public final MediaCoverEntity getCover() {
        return this.cover;
    }

    public final List<MediaImageEntity> getImage() {
        return this.image;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final String getTempBucket() {
        return this.tempBucket;
    }

    public final List<MediaVideoEntity> getVideo() {
        return this.video;
    }

    public final void setAudio(List<MediaAudioEntity> list) {
        this.audio = list;
    }

    public final void setCover(MediaCoverEntity mediaCoverEntity) {
        this.cover = mediaCoverEntity;
    }

    public final void setImage(List<MediaImageEntity> list) {
        this.image = list;
    }

    public final void setMediaType(int i11) {
        this.mediaType = i11;
    }

    public final void setTempBucket(String str) {
        this.tempBucket = str;
    }

    public final void setVideo(List<MediaVideoEntity> list) {
        this.video = list;
    }

    public String toString() {
        return "RequestPostMediaEntity(mediaType=" + this.mediaType + ", cover=" + this.cover + ", video=" + this.video + ", audio=" + this.audio + ", image=" + this.image + ")";
    }
}
