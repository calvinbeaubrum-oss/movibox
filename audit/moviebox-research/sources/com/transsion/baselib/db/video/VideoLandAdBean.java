package com.transsion.baselib.db.video;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class VideoLandAdBean {
    private int endAdDayKey;
    private String resourceId;
    private int startAdDayKey;

    public VideoLandAdBean(String resourceId, int i11, int i12) {
        Intrinsics.g(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.startAdDayKey = i11;
        this.endAdDayKey = i12;
    }

    public /* synthetic */ VideoLandAdBean(String str, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
    }

    public static /* synthetic */ VideoLandAdBean copy$default(VideoLandAdBean videoLandAdBean, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = videoLandAdBean.resourceId;
        }
        if ((i13 & 2) != 0) {
            i11 = videoLandAdBean.startAdDayKey;
        }
        if ((i13 & 4) != 0) {
            i12 = videoLandAdBean.endAdDayKey;
        }
        return videoLandAdBean.copy(str, i11, i12);
    }

    public final String component1() {
        return this.resourceId;
    }

    public final int component2() {
        return this.startAdDayKey;
    }

    public final int component3() {
        return this.endAdDayKey;
    }

    public final VideoLandAdBean copy(String resourceId, int i11, int i12) {
        Intrinsics.g(resourceId, "resourceId");
        return new VideoLandAdBean(resourceId, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoLandAdBean)) {
            return false;
        }
        VideoLandAdBean videoLandAdBean = (VideoLandAdBean) obj;
        return Intrinsics.b(this.resourceId, videoLandAdBean.resourceId) && this.startAdDayKey == videoLandAdBean.startAdDayKey && this.endAdDayKey == videoLandAdBean.endAdDayKey;
    }

    public final int getEndAdDayKey() {
        return this.endAdDayKey;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getStartAdDayKey() {
        return this.startAdDayKey;
    }

    public int hashCode() {
        return (((this.resourceId.hashCode() * 31) + this.startAdDayKey) * 31) + this.endAdDayKey;
    }

    public final void setEndAdDayKey(int i11) {
        this.endAdDayKey = i11;
    }

    public final void setResourceId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.resourceId = str;
    }

    public final void setStartAdDayKey(int i11) {
        this.startAdDayKey = i11;
    }

    public String toString() {
        return "VideoLandAdBean(resourceId=" + this.resourceId + ", startAdDayKey=" + this.startAdDayKey + ", endAdDayKey=" + this.endAdDayKey + ")";
    }
}
