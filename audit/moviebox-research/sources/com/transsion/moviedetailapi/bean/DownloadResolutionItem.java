package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class DownloadResolutionItem implements Parcelable {
    public static final Parcelable.Creator<DownloadResolutionItem> CREATOR = new a();
    private long averageSize;
    private transient boolean isSelected;
    private int requireMemberType;
    private int resolution;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<DownloadResolutionItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadResolutionItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new DownloadResolutionItem(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DownloadResolutionItem[] newArray(int i11) {
            return new DownloadResolutionItem[i11];
        }
    }

    public DownloadResolutionItem(int i11, long j11, boolean z11, int i12) {
        this.resolution = i11;
        this.averageSize = j11;
        this.isSelected = z11;
        this.requireMemberType = i12;
    }

    public /* synthetic */ DownloadResolutionItem(int i11, long j11, boolean z11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, j11, (i13 & 4) != 0 ? false : z11, i12);
    }

    public static /* synthetic */ DownloadResolutionItem copy$default(DownloadResolutionItem downloadResolutionItem, int i11, long j11, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = downloadResolutionItem.resolution;
        }
        if ((i13 & 2) != 0) {
            j11 = downloadResolutionItem.averageSize;
        }
        long j12 = j11;
        if ((i13 & 4) != 0) {
            z11 = downloadResolutionItem.isSelected;
        }
        boolean z12 = z11;
        if ((i13 & 8) != 0) {
            i12 = downloadResolutionItem.requireMemberType;
        }
        return downloadResolutionItem.copy(i11, j12, z12, i12);
    }

    public final int component1() {
        return this.resolution;
    }

    public final long component2() {
        return this.averageSize;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    public final int component4() {
        return this.requireMemberType;
    }

    public final DownloadResolutionItem copy(int i11, long j11, boolean z11, int i12) {
        return new DownloadResolutionItem(i11, j11, z11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadResolutionItem)) {
            return false;
        }
        DownloadResolutionItem downloadResolutionItem = (DownloadResolutionItem) obj;
        return this.resolution == downloadResolutionItem.resolution && this.averageSize == downloadResolutionItem.averageSize && this.isSelected == downloadResolutionItem.isSelected && this.requireMemberType == downloadResolutionItem.requireMemberType;
    }

    public final long getAverageSize() {
        return this.averageSize;
    }

    public final int getRequireMemberType() {
        return this.requireMemberType;
    }

    public final int getResolution() {
        return this.resolution;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        int iA = ((this.resolution * 31) + p.a(this.averageSize)) * 31;
        boolean z11 = this.isSelected;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return ((iA + r11) * 31) + this.requireMemberType;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setAverageSize(long j11) {
        this.averageSize = j11;
    }

    public final void setRequireMemberType(int i11) {
        this.requireMemberType = i11;
    }

    public final void setResolution(int i11) {
        this.resolution = i11;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public String toString() {
        return "DownloadResolutionItem(resolution=" + this.resolution + ", averageSize=" + this.averageSize + ", isSelected=" + this.isSelected + ", requireMemberType=" + this.requireMemberType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.resolution);
        out.writeLong(this.averageSize);
        out.writeInt(this.isSelected ? 1 : 0);
        out.writeInt(this.requireMemberType);
    }
}
