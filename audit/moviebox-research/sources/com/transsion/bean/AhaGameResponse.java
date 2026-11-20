package com.transsion.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata
public final class AhaGameResponse implements Parcelable {
    public static final Parcelable.Creator<AhaGameResponse> CREATOR = new a();
    private Integer code;
    private AhaGameData data;
    private String message;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AhaGameResponse> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AhaGameResponse createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AhaGameResponse(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0 ? AhaGameData.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AhaGameResponse[] newArray(int i11) {
            return new AhaGameResponse[i11];
        }
    }

    public AhaGameResponse(Integer num, String str, AhaGameData ahaGameData) {
        this.code = num;
        this.message = str;
        this.data = ahaGameData;
    }

    public static /* synthetic */ AhaGameResponse copy$default(AhaGameResponse ahaGameResponse, Integer num, String str, AhaGameData ahaGameData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = ahaGameResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = ahaGameResponse.message;
        }
        if ((i11 & 4) != 0) {
            ahaGameData = ahaGameResponse.data;
        }
        return ahaGameResponse.copy(num, str, ahaGameData);
    }

    public final Integer component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final AhaGameData component3() {
        return this.data;
    }

    public final AhaGameResponse copy(Integer num, String str, AhaGameData ahaGameData) {
        return new AhaGameResponse(num, str, ahaGameData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AhaGameResponse)) {
            return false;
        }
        AhaGameResponse ahaGameResponse = (AhaGameResponse) obj;
        return Intrinsics.b(this.code, ahaGameResponse.code) && Intrinsics.b(this.message, ahaGameResponse.message) && Intrinsics.b(this.data, ahaGameResponse.data);
    }

    public final Integer getCode() {
        return this.code;
    }

    public final AhaGameData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        AhaGameData ahaGameData = this.data;
        return iHashCode2 + (ahaGameData != null ? ahaGameData.hashCode() : 0);
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final void setData(AhaGameData ahaGameData) {
        this.data = ahaGameData;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "AhaGameResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Integer num = this.code;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.message);
        AhaGameData ahaGameData = this.data;
        if (ahaGameData == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            ahaGameData.writeToParcel(out, i11);
        }
    }
}
