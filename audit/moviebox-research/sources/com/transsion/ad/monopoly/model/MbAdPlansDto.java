package com.transsion.ad.monopoly.model;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MbAdPlansDto implements Parcelable {
    public static final Parcelable.Creator<MbAdPlansDto> CREATOR = new a();
    private final String code;
    private final MbAdPlansBean data;
    private final String message;
    private final String reason;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MbAdPlansDto> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MbAdPlansDto createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MbAdPlansDto(parcel.readString(), parcel.readInt() == 0 ? null : MbAdPlansBean.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MbAdPlansDto[] newArray(int i11) {
            return new MbAdPlansDto[i11];
        }
    }

    public MbAdPlansDto() {
        this(null, null, null, null, 15, null);
    }

    public MbAdPlansDto(String str, MbAdPlansBean mbAdPlansBean, String str2, String str3) {
        this.code = str;
        this.data = mbAdPlansBean;
        this.message = str2;
        this.reason = str3;
    }

    public /* synthetic */ MbAdPlansDto(String str, MbAdPlansBean mbAdPlansBean, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : mbAdPlansBean, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ MbAdPlansDto copy$default(MbAdPlansDto mbAdPlansDto, String str, MbAdPlansBean mbAdPlansBean, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = mbAdPlansDto.code;
        }
        if ((i11 & 2) != 0) {
            mbAdPlansBean = mbAdPlansDto.data;
        }
        if ((i11 & 4) != 0) {
            str2 = mbAdPlansDto.message;
        }
        if ((i11 & 8) != 0) {
            str3 = mbAdPlansDto.reason;
        }
        return mbAdPlansDto.copy(str, mbAdPlansBean, str2, str3);
    }

    public final String component1() {
        return this.code;
    }

    public final MbAdPlansBean component2() {
        return this.data;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.reason;
    }

    public final MbAdPlansDto copy(String str, MbAdPlansBean mbAdPlansBean, String str2, String str3) {
        return new MbAdPlansDto(str, mbAdPlansBean, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MbAdPlansDto)) {
            return false;
        }
        MbAdPlansDto mbAdPlansDto = (MbAdPlansDto) obj;
        return Intrinsics.b(this.code, mbAdPlansDto.code) && Intrinsics.b(this.data, mbAdPlansDto.data) && Intrinsics.b(this.message, mbAdPlansDto.message) && Intrinsics.b(this.reason, mbAdPlansDto.reason);
    }

    public final String getCode() {
        return this.code;
    }

    public final MbAdPlansBean getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        MbAdPlansBean mbAdPlansBean = this.data;
        int iHashCode2 = (iHashCode + (mbAdPlansBean == null ? 0 : mbAdPlansBean.hashCode())) * 31;
        String str2 = this.message;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reason;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "MbAdPlansDto(code=" + this.code + ", data=" + this.data + ", message=" + this.message + ", reason=" + this.reason + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.code);
        MbAdPlansBean mbAdPlansBean = this.data;
        if (mbAdPlansBean == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            mbAdPlansBean.writeToParcel(out, i11);
        }
        out.writeString(this.message);
        out.writeString(this.reason);
    }
}
