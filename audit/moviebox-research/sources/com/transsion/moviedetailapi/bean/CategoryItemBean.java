package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
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
public final class CategoryItemBean implements Parcelable {
    public static final Parcelable.Creator<CategoryItemBean> CREATOR = new a();

    @SerializedName("stationSource")
    private String itemType;

    @SerializedName("number")
    private Integer number;

    @SerializedName("info")
    private Subject subject;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CategoryItemBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CategoryItemBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CategoryItemBean(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), (Subject) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CategoryItemBean[] newArray(int i11) {
            return new CategoryItemBean[i11];
        }
    }

    public CategoryItemBean() {
        this(null, null, null, 7, null);
    }

    public CategoryItemBean(Integer num, String str, Subject subject) {
        this.number = num;
        this.itemType = str;
        this.subject = subject;
    }

    public /* synthetic */ CategoryItemBean(Integer num, String str, Subject subject, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : subject);
    }

    public static /* synthetic */ CategoryItemBean copy$default(CategoryItemBean categoryItemBean, Integer num, String str, Subject subject, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = categoryItemBean.number;
        }
        if ((i11 & 2) != 0) {
            str = categoryItemBean.itemType;
        }
        if ((i11 & 4) != 0) {
            subject = categoryItemBean.subject;
        }
        return categoryItemBean.copy(num, str, subject);
    }

    public final Integer component1() {
        return this.number;
    }

    public final String component2() {
        return this.itemType;
    }

    public final Subject component3() {
        return this.subject;
    }

    public final CategoryItemBean copy(Integer num, String str, Subject subject) {
        return new CategoryItemBean(num, str, subject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryItemBean)) {
            return false;
        }
        CategoryItemBean categoryItemBean = (CategoryItemBean) obj;
        return Intrinsics.b(this.number, categoryItemBean.number) && Intrinsics.b(this.itemType, categoryItemBean.itemType) && Intrinsics.b(this.subject, categoryItemBean.subject);
    }

    public final String getItemType() {
        return this.itemType;
    }

    public final Integer getNumber() {
        return this.number;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public int hashCode() {
        Integer num = this.number;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.itemType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Subject subject = this.subject;
        return iHashCode2 + (subject != null ? subject.hashCode() : 0);
    }

    public final void setItemType(String str) {
        this.itemType = str;
    }

    public final void setNumber(Integer num) {
        this.number = num;
    }

    public final void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String toString() {
        return "CategoryItemBean(number=" + this.number + ", itemType=" + this.itemType + ", subject=" + this.subject + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        Integer num = this.number;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        out.writeString(this.itemType);
        out.writeSerializable(this.subject);
    }
}
