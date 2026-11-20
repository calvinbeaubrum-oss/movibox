package com.tn.tranpay.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public final class MediumInputBean implements Parcelable {
    public static final Parcelable.Creator<MediumInputBean> CREATOR = new a();
    private final String code;
    private final String endSecondH5;
    private final List<InputInfoBean> inputs;
    private final Boolean isNeedLogin;
    private final String logo;
    private final String methodType;
    private final String name;
    private final Integer sortId;
    private final String speedSecondH5;
    private final String startSecondH5;
    private final String tradeMark;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MediumInputBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediumInputBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(InputInfoBean.CREATOR.createFromParcel(parcel));
                }
            }
            return new MediumInputBean(string, string2, arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MediumInputBean[] newArray(int i11) {
            return new MediumInputBean[i11];
        }
    }

    public MediumInputBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public MediumInputBean(String str, String str2, List<InputInfoBean> list, Boolean bool, String str3, String str4, String str5, Integer num, String str6, String str7, String str8) {
        this.code = str;
        this.endSecondH5 = str2;
        this.inputs = list;
        this.isNeedLogin = bool;
        this.logo = str3;
        this.methodType = str4;
        this.name = str5;
        this.sortId = num;
        this.speedSecondH5 = str6;
        this.startSecondH5 = str7;
        this.tradeMark = str8;
    }

    public /* synthetic */ MediumInputBean(String str, String str2, List list, Boolean bool, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : bool, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : num, (i11 & 256) != 0 ? null : str6, (i11 & 512) != 0 ? null : str7, (i11 & 1024) == 0 ? str8 : null);
    }

    public final String component1() {
        return this.code;
    }

    public final String component10() {
        return this.startSecondH5;
    }

    public final String component11() {
        return this.tradeMark;
    }

    public final String component2() {
        return this.endSecondH5;
    }

    public final List<InputInfoBean> component3() {
        return this.inputs;
    }

    public final Boolean component4() {
        return this.isNeedLogin;
    }

    public final String component5() {
        return this.logo;
    }

    public final String component6() {
        return this.methodType;
    }

    public final String component7() {
        return this.name;
    }

    public final Integer component8() {
        return this.sortId;
    }

    public final String component9() {
        return this.speedSecondH5;
    }

    public final MediumInputBean copy(String str, String str2, List<InputInfoBean> list, Boolean bool, String str3, String str4, String str5, Integer num, String str6, String str7, String str8) {
        return new MediumInputBean(str, str2, list, bool, str3, str4, str5, num, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediumInputBean)) {
            return false;
        }
        MediumInputBean mediumInputBean = (MediumInputBean) obj;
        return Intrinsics.b(this.code, mediumInputBean.code) && Intrinsics.b(this.endSecondH5, mediumInputBean.endSecondH5) && Intrinsics.b(this.inputs, mediumInputBean.inputs) && Intrinsics.b(this.isNeedLogin, mediumInputBean.isNeedLogin) && Intrinsics.b(this.logo, mediumInputBean.logo) && Intrinsics.b(this.methodType, mediumInputBean.methodType) && Intrinsics.b(this.name, mediumInputBean.name) && Intrinsics.b(this.sortId, mediumInputBean.sortId) && Intrinsics.b(this.speedSecondH5, mediumInputBean.speedSecondH5) && Intrinsics.b(this.startSecondH5, mediumInputBean.startSecondH5) && Intrinsics.b(this.tradeMark, mediumInputBean.tradeMark);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEndSecondH5() {
        return this.endSecondH5;
    }

    public final List<InputInfoBean> getInputs() {
        return this.inputs;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getMethodType() {
        return this.methodType;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSortId() {
        return this.sortId;
    }

    public final String getSpeedSecondH5() {
        return this.speedSecondH5;
    }

    public final String getStartSecondH5() {
        return this.startSecondH5;
    }

    public final String getTradeMark() {
        return this.tradeMark;
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.endSecondH5;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<InputInfoBean> list = this.inputs;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.isNeedLogin;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.logo;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.methodType;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.sortId;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.speedSecondH5;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.startSecondH5;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.tradeMark;
        return iHashCode10 + (str8 != null ? str8.hashCode() : 0);
    }

    public final Boolean isNeedLogin() {
        return this.isNeedLogin;
    }

    public String toString() {
        return "MediumInputBean(code=" + this.code + ", endSecondH5=" + this.endSecondH5 + ", inputs=" + this.inputs + ", isNeedLogin=" + this.isNeedLogin + ", logo=" + this.logo + ", methodType=" + this.methodType + ", name=" + this.name + ", sortId=" + this.sortId + ", speedSecondH5=" + this.speedSecondH5 + ", startSecondH5=" + this.startSecondH5 + ", tradeMark=" + this.tradeMark + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.code);
        out.writeString(this.endSecondH5);
        List<InputInfoBean> list = this.inputs;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<InputInfoBean> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        Boolean bool = this.isNeedLogin;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeString(this.logo);
        out.writeString(this.methodType);
        out.writeString(this.name);
        Integer num = this.sortId;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.speedSecondH5);
        out.writeString(this.startSecondH5);
        out.writeString(this.tradeMark);
    }
}
