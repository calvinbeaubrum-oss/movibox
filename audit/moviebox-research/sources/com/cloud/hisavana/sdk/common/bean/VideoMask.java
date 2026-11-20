package com.cloud.hisavana.sdk.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class VideoMask implements Parcelable {
    public static final Parcelable.Creator<VideoMask> CREATOR = new Creator();
    private String resource;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VideoMask> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoMask createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VideoMask(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoMask[] newArray(int i11) {
            return new VideoMask[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoMask() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VideoMask(String str) {
        this.resource = str;
    }

    public /* synthetic */ VideoMask(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }

    public static /* synthetic */ VideoMask copy$default(VideoMask videoMask, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = videoMask.resource;
        }
        return videoMask.copy(str);
    }

    public final String component1() {
        return this.resource;
    }

    public final VideoMask copy(String str) {
        return new VideoMask(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoMask) && Intrinsics.b(this.resource, ((VideoMask) obj).resource);
    }

    public final String getResource() {
        return this.resource;
    }

    public int hashCode() {
        String str = this.resource;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setResource(String str) {
        this.resource = str;
    }

    public String toString() {
        return "VideoMask(resource=" + this.resource + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.resource);
    }
}
