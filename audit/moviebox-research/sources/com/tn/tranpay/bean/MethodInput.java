package com.tn.tranpay.bean;

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
public final class MethodInput implements Parcelable {
    public static final Parcelable.Creator<MethodInput> CREATOR = new a();
    private final String hint;
    private final String name;
    private final String reg;
    private final String tips;
    private final String type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MethodInput> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MethodInput createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MethodInput(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MethodInput[] newArray(int i11) {
            return new MethodInput[i11];
        }
    }

    public MethodInput(String str, String str2, String str3, String str4, String str5) {
        this.hint = str;
        this.name = str2;
        this.reg = str3;
        this.tips = str4;
        this.type = str5;
    }

    public static /* synthetic */ MethodInput copy$default(MethodInput methodInput, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = methodInput.hint;
        }
        if ((i11 & 2) != 0) {
            str2 = methodInput.name;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = methodInput.reg;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = methodInput.tips;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = methodInput.type;
        }
        return methodInput.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.hint;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.reg;
    }

    public final String component4() {
        return this.tips;
    }

    public final String component5() {
        return this.type;
    }

    public final MethodInput copy(String str, String str2, String str3, String str4, String str5) {
        return new MethodInput(str, str2, str3, str4, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MethodInput)) {
            return false;
        }
        MethodInput methodInput = (MethodInput) obj;
        return Intrinsics.b(this.hint, methodInput.hint) && Intrinsics.b(this.name, methodInput.name) && Intrinsics.b(this.reg, methodInput.reg) && Intrinsics.b(this.tips, methodInput.tips) && Intrinsics.b(this.type, methodInput.type);
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReg() {
        return this.reg;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.hint;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reg;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tips;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.type;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "MethodInput(hint=" + this.hint + ", name=" + this.name + ", reg=" + this.reg + ", tips=" + this.tips + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.hint);
        out.writeString(this.name);
        out.writeString(this.reg);
        out.writeString(this.tips);
        out.writeString(this.type);
    }
}
