package com.tn.tranpay.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
@Keep
@Metadata
public final class InputInfoBean implements Parcelable {
    public static final Parcelable.Creator<InputInfoBean> CREATOR = new a();
    private final String hint;
    private final String name;
    private String realHint;
    private String realTips;
    private final String reg;
    private final String tips;
    private final String type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<InputInfoBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InputInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new InputInfoBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final InputInfoBean[] newArray(int i11) {
            return new InputInfoBean[i11];
        }
    }

    public InputInfoBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public InputInfoBean(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.hint = str;
        this.name = str2;
        this.reg = str3;
        this.tips = str4;
        this.type = str5;
        this.realHint = str6;
        this.realTips = str7;
    }

    public /* synthetic */ InputInfoBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7);
    }

    public static /* synthetic */ InputInfoBean copy$default(InputInfoBean inputInfoBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = inputInfoBean.hint;
        }
        if ((i11 & 2) != 0) {
            str2 = inputInfoBean.name;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = inputInfoBean.reg;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = inputInfoBean.tips;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = inputInfoBean.type;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = inputInfoBean.realHint;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = inputInfoBean.realTips;
        }
        return inputInfoBean.copy(str, str8, str9, str10, str11, str12, str7);
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

    public final String component6() {
        return this.realHint;
    }

    public final String component7() {
        return this.realTips;
    }

    public final InputInfoBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new InputInfoBean(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputInfoBean)) {
            return false;
        }
        InputInfoBean inputInfoBean = (InputInfoBean) obj;
        return Intrinsics.b(this.hint, inputInfoBean.hint) && Intrinsics.b(this.name, inputInfoBean.name) && Intrinsics.b(this.reg, inputInfoBean.reg) && Intrinsics.b(this.tips, inputInfoBean.tips) && Intrinsics.b(this.type, inputInfoBean.type) && Intrinsics.b(this.realHint, inputInfoBean.realHint) && Intrinsics.b(this.realTips, inputInfoBean.realTips);
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRealHint() {
        return this.realHint;
    }

    public final String getRealTips() {
        return this.realTips;
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
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.realHint;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.realTips;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setRealHint(String str) {
        this.realHint = str;
    }

    public final void setRealTips(String str) {
        this.realTips = str;
    }

    public String toString() {
        return "InputInfoBean(hint=" + this.hint + ", name=" + this.name + ", reg=" + this.reg + ", tips=" + this.tips + ", type=" + this.type + ", realHint=" + this.realHint + ", realTips=" + this.realTips + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.hint);
        out.writeString(this.name);
        out.writeString(this.reg);
        out.writeString(this.tips);
        out.writeString(this.type);
        out.writeString(this.realHint);
        out.writeString(this.realTips);
    }
}
