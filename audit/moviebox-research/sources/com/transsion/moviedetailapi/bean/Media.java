package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class Media implements Serializable {

    @SerializedName(MimeTypes.BASE_TYPE_AUDIO)
    private List<Audio> audio;

    @SerializedName("cover")
    private Cover cover;

    @SerializedName("firstFrame")
    private FirstFrame firstFrame;

    @SerializedName("image")
    private List<Image> image;

    @SerializedName("mediaType")
    private String mediaType;

    @SerializedName("video")
    private List<Video> video;

    @SerializedName("videoAddress")
    private Video videoAddress;

    public Media(List<Audio> list, Cover cover, FirstFrame firstFrame, List<Image> list2, String str, List<Video> list3, Video video) {
        this.audio = list;
        this.cover = cover;
        this.firstFrame = firstFrame;
        this.image = list2;
        this.mediaType = str;
        this.video = list3;
        this.videoAddress = video;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Media copy$default(Media media, List list, Cover cover, FirstFrame firstFrame, List list2, String str, List list3, Video video, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = media.audio;
        }
        if ((i11 & 2) != 0) {
            cover = media.cover;
        }
        Cover cover2 = cover;
        if ((i11 & 4) != 0) {
            firstFrame = media.firstFrame;
        }
        FirstFrame firstFrame2 = firstFrame;
        if ((i11 & 8) != 0) {
            list2 = media.image;
        }
        List list4 = list2;
        if ((i11 & 16) != 0) {
            str = media.mediaType;
        }
        String str2 = str;
        if ((i11 & 32) != 0) {
            list3 = media.video;
        }
        List list5 = list3;
        if ((i11 & 64) != 0) {
            video = media.videoAddress;
        }
        return media.copy(list, cover2, firstFrame2, list4, str2, list5, video);
    }

    public final List<Audio> component1() {
        return this.audio;
    }

    public final Cover component2() {
        return this.cover;
    }

    public final FirstFrame component3() {
        return this.firstFrame;
    }

    public final List<Image> component4() {
        return this.image;
    }

    public final String component5() {
        return this.mediaType;
    }

    public final List<Video> component6() {
        return this.video;
    }

    public final Video component7() {
        return this.videoAddress;
    }

    public final Media copy(List<Audio> list, Cover cover, FirstFrame firstFrame, List<Image> list2, String str, List<Video> list3, Video video) {
        return new Media(list, cover, firstFrame, list2, str, list3, video);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        Media media = (Media) obj;
        return Intrinsics.b(this.audio, media.audio) && Intrinsics.b(this.cover, media.cover) && Intrinsics.b(this.firstFrame, media.firstFrame) && Intrinsics.b(this.image, media.image) && Intrinsics.b(this.mediaType, media.mediaType) && Intrinsics.b(this.video, media.video) && Intrinsics.b(this.videoAddress, media.videoAddress);
    }

    public final List<Audio> getAudio() {
        return this.audio;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final FirstFrame getFirstFrame() {
        return this.firstFrame;
    }

    public final List<Image> getImage() {
        return this.image;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final List<Video> getVideo() {
        return this.video;
    }

    public final Video getVideoAddress() {
        return this.videoAddress;
    }

    public int hashCode() {
        List<Audio> list = this.audio;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Cover cover = this.cover;
        int iHashCode2 = (iHashCode + (cover == null ? 0 : cover.hashCode())) * 31;
        FirstFrame firstFrame = this.firstFrame;
        int iHashCode3 = (iHashCode2 + (firstFrame == null ? 0 : firstFrame.hashCode())) * 31;
        List<Image> list2 = this.image;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.mediaType;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        List<Video> list3 = this.video;
        int iHashCode6 = (iHashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Video video = this.videoAddress;
        return iHashCode6 + (video != null ? video.hashCode() : 0);
    }

    public final void setAudio(List<Audio> list) {
        this.audio = list;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setFirstFrame(FirstFrame firstFrame) {
        this.firstFrame = firstFrame;
    }

    public final void setImage(List<Image> list) {
        this.image = list;
    }

    public final void setMediaType(String str) {
        this.mediaType = str;
    }

    public final void setVideo(List<Video> list) {
        this.video = list;
    }

    public final void setVideoAddress(Video video) {
        this.videoAddress = video;
    }

    public String toString() {
        return "Media(audio=" + this.audio + ", cover=" + this.cover + ", firstFrame=" + this.firstFrame + ", image=" + this.image + ", mediaType=" + this.mediaType + ", video=" + this.video + ", videoAddress=" + this.videoAddress + ")";
    }
}
