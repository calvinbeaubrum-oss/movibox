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
public final class RequestPostEntity implements Serializable {
    private double lat;
    private MediaLinkEntity link;
    private double lon;
    private RequestPostMediaEntity media;
    private int publishType;
    private String title = "";
    private String content = "";
    private String groupId = "";
    private String subjectId = "0";
    private String score = "0";
    private String poiName = "";

    public final String getContent() {
        return this.content;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final double getLat() {
        return this.lat;
    }

    public final MediaLinkEntity getLink() {
        return this.link;
    }

    public final double getLon() {
        return this.lon;
    }

    public final RequestPostMediaEntity getMedia() {
        return this.media;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final int getPublishType() {
        return this.publishType;
    }

    public final String getScore() {
        return this.score;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setContent(String str) {
        Intrinsics.g(str, "<set-?>");
        this.content = str;
    }

    public final void setGroupId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.groupId = str;
    }

    public final void setLat(double d11) {
        this.lat = d11;
    }

    public final void setLink(MediaLinkEntity mediaLinkEntity) {
        this.link = mediaLinkEntity;
    }

    public final void setLon(double d11) {
        this.lon = d11;
    }

    public final void setMedia(RequestPostMediaEntity requestPostMediaEntity) {
        this.media = requestPostMediaEntity;
    }

    public final void setPoiName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.poiName = str;
    }

    public final void setPublishType(int i11) {
        this.publishType = i11;
    }

    public final void setScore(String str) {
        Intrinsics.g(str, "<set-?>");
        this.score = str;
    }

    public final void setSubjectId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.subjectId = str;
    }

    public final void setTitle(String str) {
        Intrinsics.g(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "RequestPostEntity(title='" + this.title + "', content='" + this.content + "', groupId='" + this.groupId + "', subjectId='" + this.subjectId + "', score='" + this.score + "', link=" + this.link + ", media=" + this.media + ", publishType=" + this.publishType + ",lon=" + this.lon + ",lat=" + this.lat + ",poiName=" + this.poiName + ")";
    }
}
