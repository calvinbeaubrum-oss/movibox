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
public final class ProgressData implements Parcelable {
    public static final Parcelable.Creator<ProgressData> CREATOR = new Creator();
    private Integer duration;
    private boolean isOverQuarter;
    private Integer progress;
    private Integer videoPlayTimeType;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<ProgressData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProgressData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ProgressData(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProgressData[] newArray(int i11) {
            return new ProgressData[i11];
        }
    }

    public ProgressData() {
        this(null, null, null, false, 15, null);
    }

    public ProgressData(Integer num, Integer num2, Integer num3, boolean z11) {
        this.videoPlayTimeType = num;
        this.progress = num2;
        this.duration = num3;
        this.isOverQuarter = z11;
    }

    public /* synthetic */ ProgressData(Integer num, Integer num2, Integer num3, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1 : num, (i11 & 2) != 0 ? 0 : num2, (i11 & 4) != 0 ? 0 : num3, (i11 & 8) != 0 ? false : z11);
    }

    public static /* synthetic */ ProgressData copy$default(ProgressData progressData, Integer num, Integer num2, Integer num3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = progressData.videoPlayTimeType;
        }
        if ((i11 & 2) != 0) {
            num2 = progressData.progress;
        }
        if ((i11 & 4) != 0) {
            num3 = progressData.duration;
        }
        if ((i11 & 8) != 0) {
            z11 = progressData.isOverQuarter;
        }
        return progressData.copy(num, num2, num3, z11);
    }

    public final Integer component1() {
        return this.videoPlayTimeType;
    }

    public final Integer component2() {
        return this.progress;
    }

    public final Integer component3() {
        return this.duration;
    }

    public final boolean component4() {
        return this.isOverQuarter;
    }

    public final ProgressData copy(Integer num, Integer num2, Integer num3, boolean z11) {
        return new ProgressData(num, num2, num3, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressData)) {
            return false;
        }
        ProgressData progressData = (ProgressData) obj;
        return Intrinsics.b(this.videoPlayTimeType, progressData.videoPlayTimeType) && Intrinsics.b(this.progress, progressData.progress) && Intrinsics.b(this.duration, progressData.duration) && this.isOverQuarter == progressData.isOverQuarter;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final Integer getVideoPlayTimeType() {
        return this.videoPlayTimeType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Integer num = this.videoPlayTimeType;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.progress;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.duration;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        boolean z11 = this.isOverQuarter;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode3 + r11;
    }

    public final boolean isOverQuarter() {
        return this.isOverQuarter;
    }

    public final void setDuration(Integer num) {
        this.duration = num;
    }

    public final void setOverQuarter(boolean z11) {
        this.isOverQuarter = z11;
    }

    public final void setProgress(Integer num) {
        this.progress = num;
    }

    public final void setVideoPlayTimeType(Integer num) {
        this.videoPlayTimeType = num;
    }

    public String toString() {
        return "ProgressData(videoPlayTimeType=" + this.videoPlayTimeType + ", progress=" + this.progress + ", duration=" + this.duration + ", isOverQuarter=" + this.isOverQuarter + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Integer num = this.videoPlayTimeType;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.progress;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.duration;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        out.writeInt(this.isOverQuarter ? 1 : 0);
    }
}
