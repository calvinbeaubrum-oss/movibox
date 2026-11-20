package com.transsion.push.bean;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class PermanentItemBean implements Parcelable {
    public static final Parcelable.Creator<PermanentItemBean> CREATOR = new Creator();
    private String deeplink;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f56834id;
    private String image;
    private String subjectId;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PermanentItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentItemBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PermanentItemBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentItemBean[] newArray(int i11) {
            return new PermanentItemBean[i11];
        }
    }

    public PermanentItemBean(int i11, String str, String str2, String str3, String str4) {
        this.f56834id = i11;
        this.deeplink = str;
        this.subjectId = str2;
        this.image = str3;
        this.title = str4;
    }

    public /* synthetic */ PermanentItemBean(int i11, String str, String str2, String str3, String str4, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, str, str2, str3, str4);
    }

    public static /* synthetic */ PermanentItemBean copy$default(PermanentItemBean permanentItemBean, int i11, String str, String str2, String str3, String str4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = permanentItemBean.f56834id;
        }
        if ((i12 & 2) != 0) {
            str = permanentItemBean.deeplink;
        }
        String str5 = str;
        if ((i12 & 4) != 0) {
            str2 = permanentItemBean.subjectId;
        }
        String str6 = str2;
        if ((i12 & 8) != 0) {
            str3 = permanentItemBean.image;
        }
        String str7 = str3;
        if ((i12 & 16) != 0) {
            str4 = permanentItemBean.title;
        }
        return permanentItemBean.copy(i11, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.f56834id;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final String component3() {
        return this.subjectId;
    }

    public final String component4() {
        return this.image;
    }

    public final String component5() {
        return this.title;
    }

    public final PermanentItemBean copy(int i11, String str, String str2, String str3, String str4) {
        return new PermanentItemBean(i11, str, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermanentItemBean)) {
            return false;
        }
        PermanentItemBean permanentItemBean = (PermanentItemBean) obj;
        return this.f56834id == permanentItemBean.f56834id && Intrinsics.b(this.deeplink, permanentItemBean.deeplink) && Intrinsics.b(this.subjectId, permanentItemBean.subjectId) && Intrinsics.b(this.image, permanentItemBean.image) && Intrinsics.b(this.title, permanentItemBean.title);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final int getId() {
        return this.f56834id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i11 = this.f56834id * 31;
        String str = this.deeplink;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subjectId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.image;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setId(int i11) {
        this.f56834id = i11;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PermanentItemBean(id=" + this.f56834id + ", deeplink=" + this.deeplink + ", subjectId=" + this.subjectId + ", image=" + this.image + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.f56834id);
        out.writeString(this.deeplink);
        out.writeString(this.subjectId);
        out.writeString(this.image);
        out.writeString(this.title);
    }
}
