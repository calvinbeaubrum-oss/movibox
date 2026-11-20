package com.cloud.tmc.offline.download.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
@kotlin.Metadata
public final class DeliveryDimensionData extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private String appId;
    private List<String> mcc;
    private String networkType;

    /* JADX INFO: compiled from: source.java */
    @kotlin.Metadata
    public static final class a implements Parcelable.Creator<DeliveryDimensionData> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeliveryDimensionData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new DeliveryDimensionData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeliveryDimensionData[] newArray(int i11) {
            return new DeliveryDimensionData[i11];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeliveryDimensionData(Parcel parcel) {
        this(parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        Intrinsics.g(parcel, "parcel");
    }

    public DeliveryDimensionData(String str, List<String> list, String str2) {
        this.appId = str;
        this.mcc = list;
        this.networkType = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeliveryDimensionData copy$default(DeliveryDimensionData deliveryDimensionData, String str, List list, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = deliveryDimensionData.appId;
        }
        if ((i11 & 2) != 0) {
            list = deliveryDimensionData.mcc;
        }
        if ((i11 & 4) != 0) {
            str2 = deliveryDimensionData.networkType;
        }
        return deliveryDimensionData.copy(str, list, str2);
    }

    public final String component1() {
        return this.appId;
    }

    public final List<String> component2() {
        return this.mcc;
    }

    public final String component3() {
        return this.networkType;
    }

    public final DeliveryDimensionData copy(String str, List<String> list, String str2) {
        return new DeliveryDimensionData(str, list, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryDimensionData)) {
            return false;
        }
        DeliveryDimensionData deliveryDimensionData = (DeliveryDimensionData) obj;
        return Intrinsics.b(this.appId, deliveryDimensionData.appId) && Intrinsics.b(this.mcc, deliveryDimensionData.mcc) && Intrinsics.b(this.networkType, deliveryDimensionData.networkType);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final List<String> getMcc() {
        return this.mcc;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.mcc;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.networkType;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setMcc(List<String> list) {
        this.mcc = list;
    }

    public final void setNetworkType(String str) {
        this.networkType = str;
    }

    public String toString() {
        return "DeliveryDimensionData(appId=" + this.appId + ", mcc=" + this.mcc + ", networkType=" + this.networkType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeStringList(this.mcc);
        parcel.writeString(this.networkType);
    }
}
