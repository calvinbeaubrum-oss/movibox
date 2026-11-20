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
public final class VastTracking implements Parcelable {
    public static final Parcelable.Creator<VastTracking> CREATOR = new Creator();
    private String complete;
    private String midpoint;
    private String quarter;
    private String startTrack;
    private String thirdQuarter;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VastTracking> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastTracking createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VastTracking(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastTracking[] newArray(int i11) {
            return new VastTracking[i11];
        }
    }

    public VastTracking() {
        this(null, null, null, null, null, 31, null);
    }

    public VastTracking(String str, String str2, String str3, String str4, String str5) {
        this.startTrack = str;
        this.quarter = str2;
        this.midpoint = str3;
        this.thirdQuarter = str4;
        this.complete = str5;
    }

    public /* synthetic */ VastTracking(String str, String str2, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5);
    }

    public static /* synthetic */ VastTracking copy$default(VastTracking vastTracking, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vastTracking.startTrack;
        }
        if ((i11 & 2) != 0) {
            str2 = vastTracking.quarter;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = vastTracking.midpoint;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = vastTracking.thirdQuarter;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = vastTracking.complete;
        }
        return vastTracking.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.startTrack;
    }

    public final String component2() {
        return this.quarter;
    }

    public final String component3() {
        return this.midpoint;
    }

    public final String component4() {
        return this.thirdQuarter;
    }

    public final String component5() {
        return this.complete;
    }

    public final VastTracking copy(String str, String str2, String str3, String str4, String str5) {
        return new VastTracking(str, str2, str3, str4, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastTracking)) {
            return false;
        }
        VastTracking vastTracking = (VastTracking) obj;
        return Intrinsics.b(this.startTrack, vastTracking.startTrack) && Intrinsics.b(this.quarter, vastTracking.quarter) && Intrinsics.b(this.midpoint, vastTracking.midpoint) && Intrinsics.b(this.thirdQuarter, vastTracking.thirdQuarter) && Intrinsics.b(this.complete, vastTracking.complete);
    }

    public final String getComplete() {
        return this.complete;
    }

    public final String getMidpoint() {
        return this.midpoint;
    }

    public final String getQuarter() {
        return this.quarter;
    }

    public final String getStartTrack() {
        return this.startTrack;
    }

    public final String getThirdQuarter() {
        return this.thirdQuarter;
    }

    public int hashCode() {
        String str = this.startTrack;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.quarter;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.midpoint;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.thirdQuarter;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.complete;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setComplete(String str) {
        this.complete = str;
    }

    public final void setMidpoint(String str) {
        this.midpoint = str;
    }

    public final void setQuarter(String str) {
        this.quarter = str;
    }

    public final void setStartTrack(String str) {
        this.startTrack = str;
    }

    public final void setThirdQuarter(String str) {
        this.thirdQuarter = str;
    }

    public String toString() {
        return "VastTracking(startTrack=" + this.startTrack + ", quarter=" + this.quarter + ", midpoint=" + this.midpoint + ", thirdQuarter=" + this.thirdQuarter + ", complete=" + this.complete + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.startTrack);
        out.writeString(this.quarter);
        out.writeString(this.midpoint);
        out.writeString(this.thirdQuarter);
        out.writeString(this.complete);
    }
}
