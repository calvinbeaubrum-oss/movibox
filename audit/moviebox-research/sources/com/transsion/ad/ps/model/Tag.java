package com.transsion.ad.ps.model;

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
public final class Tag implements Parcelable {
    public static final Parcelable.Creator<Tag> CREATOR = new a();
    private String category;
    private String categoryID;
    private String isHot;
    private String name;
    private String tagID;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<Tag> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Tag createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new Tag(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Tag[] newArray(int i11) {
            return new Tag[i11];
        }
    }

    public Tag(String str, String str2, String str3, String str4, String str5) {
        this.tagID = str;
        this.name = str2;
        this.category = str3;
        this.isHot = str4;
        this.categoryID = str5;
    }

    public static /* synthetic */ Tag copy$default(Tag tag, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tag.tagID;
        }
        if ((i11 & 2) != 0) {
            str2 = tag.name;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = tag.category;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = tag.isHot;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = tag.categoryID;
        }
        return tag.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.tagID;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.category;
    }

    public final String component4() {
        return this.isHot;
    }

    public final String component5() {
        return this.categoryID;
    }

    public final Tag copy(String str, String str2, String str3, String str4, String str5) {
        return new Tag(str, str2, str3, str4, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return Intrinsics.b(this.tagID, tag.tagID) && Intrinsics.b(this.name, tag.name) && Intrinsics.b(this.category, tag.category) && Intrinsics.b(this.isHot, tag.isHot) && Intrinsics.b(this.categoryID, tag.categoryID);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getCategoryID() {
        return this.categoryID;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTagID() {
        return this.tagID;
    }

    public int hashCode() {
        String str = this.tagID;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.category;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.isHot;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.categoryID;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String isHot() {
        return this.isHot;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setCategoryID(String str) {
        this.categoryID = str;
    }

    public final void setHot(String str) {
        this.isHot = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setTagID(String str) {
        this.tagID = str;
    }

    public String toString() {
        return "Tag(tagID=" + this.tagID + ", name=" + this.name + ", category=" + this.category + ", isHot=" + this.isHot + ", categoryID=" + this.categoryID + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.tagID);
        out.writeString(this.name);
        out.writeString(this.category);
        out.writeString(this.isHot);
        out.writeString(this.categoryID);
    }
}
