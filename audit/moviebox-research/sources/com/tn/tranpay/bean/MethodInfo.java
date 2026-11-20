package com.tn.tranpay.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public final class MethodInfo implements Parcelable {
    public static final Parcelable.Creator<MethodInfo> CREATOR = new a();
    private final String code;
    private final Double discount;
    private final String icon;
    private final List<MethodInput> inputs;
    private final Double maxAmount;
    private final String methodType;
    private final Double minAmount;
    private final String name;
    private final List<Double> supportAmount;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MethodInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MethodInfo createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(Double.valueOf(parcel.readDouble()));
                }
            }
            Double dValueOf = parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble());
            Double dValueOf2 = parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble());
            Double dValueOf3 = parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble());
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(MethodInput.CREATOR.createFromParcel(parcel));
                }
            }
            return new MethodInfo(string, string2, string3, string4, arrayList, dValueOf, dValueOf2, dValueOf3, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MethodInfo[] newArray(int i11) {
            return new MethodInfo[i11];
        }
    }

    public MethodInfo(String code, String name, String icon, String methodType, List<Double> list, Double d11, Double d12, Double d13, List<MethodInput> list2) {
        Intrinsics.g(code, "code");
        Intrinsics.g(name, "name");
        Intrinsics.g(icon, "icon");
        Intrinsics.g(methodType, "methodType");
        this.code = code;
        this.name = name;
        this.icon = icon;
        this.methodType = methodType;
        this.supportAmount = list;
        this.minAmount = d11;
        this.maxAmount = d12;
        this.discount = d13;
        this.inputs = list2;
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.methodType;
    }

    public final List<Double> component5() {
        return this.supportAmount;
    }

    public final Double component6() {
        return this.minAmount;
    }

    public final Double component7() {
        return this.maxAmount;
    }

    public final Double component8() {
        return this.discount;
    }

    public final List<MethodInput> component9() {
        return this.inputs;
    }

    public final MethodInfo copy(String code, String name, String icon, String methodType, List<Double> list, Double d11, Double d12, Double d13, List<MethodInput> list2) {
        Intrinsics.g(code, "code");
        Intrinsics.g(name, "name");
        Intrinsics.g(icon, "icon");
        Intrinsics.g(methodType, "methodType");
        return new MethodInfo(code, name, icon, methodType, list, d11, d12, d13, list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MethodInfo)) {
            return false;
        }
        MethodInfo methodInfo = (MethodInfo) obj;
        return Intrinsics.b(this.code, methodInfo.code) && Intrinsics.b(this.name, methodInfo.name) && Intrinsics.b(this.icon, methodInfo.icon) && Intrinsics.b(this.methodType, methodInfo.methodType) && Intrinsics.b(this.supportAmount, methodInfo.supportAmount) && Intrinsics.b(this.minAmount, methodInfo.minAmount) && Intrinsics.b(this.maxAmount, methodInfo.maxAmount) && Intrinsics.b(this.discount, methodInfo.discount) && Intrinsics.b(this.inputs, methodInfo.inputs);
    }

    public final String getCode() {
        return this.code;
    }

    public final Double getDiscount() {
        return this.discount;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<MethodInput> getInputs() {
        return this.inputs;
    }

    public final Double getMaxAmount() {
        return this.maxAmount;
    }

    public final String getMethodType() {
        return this.methodType;
    }

    public final Double getMinAmount() {
        return this.minAmount;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Double> getSupportAmount() {
        return this.supportAmount;
    }

    public int hashCode() {
        int iHashCode = ((((((this.code.hashCode() * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.methodType.hashCode()) * 31;
        List<Double> list = this.supportAmount;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Double d11 = this.minAmount;
        int iHashCode3 = (iHashCode2 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.maxAmount;
        int iHashCode4 = (iHashCode3 + (d12 == null ? 0 : d12.hashCode())) * 31;
        Double d13 = this.discount;
        int iHashCode5 = (iHashCode4 + (d13 == null ? 0 : d13.hashCode())) * 31;
        List<MethodInput> list2 = this.inputs;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "MethodInfo(code=" + this.code + ", name=" + this.name + ", icon=" + this.icon + ", methodType=" + this.methodType + ", supportAmount=" + this.supportAmount + ", minAmount=" + this.minAmount + ", maxAmount=" + this.maxAmount + ", discount=" + this.discount + ", inputs=" + this.inputs + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.code);
        out.writeString(this.name);
        out.writeString(this.icon);
        out.writeString(this.methodType);
        List<Double> list = this.supportAmount;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<Double> it = list.iterator();
            while (it.hasNext()) {
                out.writeDouble(it.next().doubleValue());
            }
        }
        Double d11 = this.minAmount;
        if (d11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d11.doubleValue());
        }
        Double d12 = this.maxAmount;
        if (d12 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d12.doubleValue());
        }
        Double d13 = this.discount;
        if (d13 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeDouble(d13.doubleValue());
        }
        List<MethodInput> list2 = this.inputs;
        if (list2 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list2.size());
        Iterator<MethodInput> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i11);
        }
    }
}
