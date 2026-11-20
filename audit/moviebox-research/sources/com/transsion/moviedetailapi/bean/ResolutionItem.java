package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class ResolutionItem implements Parcelable {
    public static final Parcelable.Creator<ResolutionItem> CREATOR = new a();
    private final int epNum;
    private final int resolution;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ResolutionItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ResolutionItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ResolutionItem(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ResolutionItem[] newArray(int i11) {
            return new ResolutionItem[i11];
        }
    }

    public ResolutionItem(int i11, int i12) {
        this.resolution = i11;
        this.epNum = i12;
    }

    public static /* synthetic */ ResolutionItem copy$default(ResolutionItem resolutionItem, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = resolutionItem.resolution;
        }
        if ((i13 & 2) != 0) {
            i12 = resolutionItem.epNum;
        }
        return resolutionItem.copy(i11, i12);
    }

    public final int component1() {
        return this.resolution;
    }

    public final int component2() {
        return this.epNum;
    }

    public final ResolutionItem copy(int i11, int i12) {
        return new ResolutionItem(i11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolutionItem)) {
            return false;
        }
        ResolutionItem resolutionItem = (ResolutionItem) obj;
        return this.resolution == resolutionItem.resolution && this.epNum == resolutionItem.epNum;
    }

    public final int getEpNum() {
        return this.epNum;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        return (this.resolution * 31) + this.epNum;
    }

    public String toString() {
        return "ResolutionItem(resolution=" + this.resolution + ", epNum=" + this.epNum + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.resolution);
        out.writeInt(this.epNum);
    }
}
