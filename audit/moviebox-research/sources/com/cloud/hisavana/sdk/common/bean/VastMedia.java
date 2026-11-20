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
public final class VastMedia implements Parcelable {
    public static final Parcelable.Creator<VastMedia> CREATOR = new Creator();
    private String delivery;
    private int height;
    private String mediaResource;
    private String type;
    private int width;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VastMedia> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastMedia createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VastMedia(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastMedia[] newArray(int i11) {
            return new VastMedia[i11];
        }
    }

    public VastMedia() {
        this(null, null, null, 0, 0, 31, null);
    }

    public VastMedia(String str, String str2, String str3, int i11, int i12) {
        this.mediaResource = str;
        this.delivery = str2;
        this.type = str3;
        this.width = i11;
        this.height = i12;
    }

    public /* synthetic */ VastMedia(String str, String str2, String str3, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? null : str2, (i13 & 4) == 0 ? str3 : null, (i13 & 8) != 0 ? -1 : i11, (i13 & 16) != 0 ? -1 : i12);
    }

    public static /* synthetic */ VastMedia copy$default(VastMedia vastMedia, String str, String str2, String str3, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = vastMedia.mediaResource;
        }
        if ((i13 & 2) != 0) {
            str2 = vastMedia.delivery;
        }
        String str4 = str2;
        if ((i13 & 4) != 0) {
            str3 = vastMedia.type;
        }
        String str5 = str3;
        if ((i13 & 8) != 0) {
            i11 = vastMedia.width;
        }
        int i14 = i11;
        if ((i13 & 16) != 0) {
            i12 = vastMedia.height;
        }
        return vastMedia.copy(str, str4, str5, i14, i12);
    }

    public final String component1() {
        return this.mediaResource;
    }

    public final String component2() {
        return this.delivery;
    }

    public final String component3() {
        return this.type;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final VastMedia copy(String str, String str2, String str3, int i11, int i12) {
        return new VastMedia(str, str2, str3, i11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastMedia)) {
            return false;
        }
        VastMedia vastMedia = (VastMedia) obj;
        return Intrinsics.b(this.mediaResource, vastMedia.mediaResource) && Intrinsics.b(this.delivery, vastMedia.delivery) && Intrinsics.b(this.type, vastMedia.type) && this.width == vastMedia.width && this.height == vastMedia.height;
    }

    public final String getDelivery() {
        return this.delivery;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getMediaResource() {
        return this.mediaResource;
    }

    public final String getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.mediaResource;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.delivery;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.width) * 31) + this.height;
    }

    public final void setDelivery(String str) {
        this.delivery = str;
    }

    public final void setHeight(int i11) {
        this.height = i11;
    }

    public final void setMediaResource(String str) {
        this.mediaResource = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setWidth(int i11) {
        this.width = i11;
    }

    public String toString() {
        return "VastMedia(mediaResource=" + this.mediaResource + ", delivery=" + this.delivery + ", type=" + this.type + ", width=" + this.width + ", height=" + this.height + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.mediaResource);
        out.writeString(this.delivery);
        out.writeString(this.type);
        out.writeInt(this.width);
        out.writeInt(this.height);
    }
}
