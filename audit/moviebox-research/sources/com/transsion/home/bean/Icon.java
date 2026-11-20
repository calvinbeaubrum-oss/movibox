package com.transsion.home.bean;

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
public final class Icon implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Icon> CREATOR = new a();
    private String defaultBigIcon;
    private final String defaultIcon;
    private String selectBigIcon;
    private final String selectIcon;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<Icon> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Icon createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new Icon(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Icon[] newArray(int i11) {
            return new Icon[i11];
        }
    }

    public Icon(String str, String str2, String str3, String str4) {
        this.selectIcon = str;
        this.defaultIcon = str2;
        this.defaultBigIcon = str3;
        this.selectBigIcon = str4;
    }

    public static /* synthetic */ Icon copy$default(Icon icon, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = icon.selectIcon;
        }
        if ((i11 & 2) != 0) {
            str2 = icon.defaultIcon;
        }
        if ((i11 & 4) != 0) {
            str3 = icon.defaultBigIcon;
        }
        if ((i11 & 8) != 0) {
            str4 = icon.selectBigIcon;
        }
        return icon.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.selectIcon;
    }

    public final String component2() {
        return this.defaultIcon;
    }

    public final String component3() {
        return this.defaultBigIcon;
    }

    public final String component4() {
        return this.selectBigIcon;
    }

    public final Icon copy(String str, String str2, String str3, String str4) {
        return new Icon(str, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Icon)) {
            return false;
        }
        Icon icon = (Icon) obj;
        return Intrinsics.b(this.selectIcon, icon.selectIcon) && Intrinsics.b(this.defaultIcon, icon.defaultIcon) && Intrinsics.b(this.defaultBigIcon, icon.defaultBigIcon) && Intrinsics.b(this.selectBigIcon, icon.selectBigIcon);
    }

    public final String getDefaultBigIcon() {
        return this.defaultBigIcon;
    }

    public final String getDefaultIcon() {
        return this.defaultIcon;
    }

    public final String getSelectBigIcon() {
        return this.selectBigIcon;
    }

    public final String getSelectIcon() {
        return this.selectIcon;
    }

    public int hashCode() {
        String str = this.selectIcon;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.defaultIcon;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.defaultBigIcon;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.selectBigIcon;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setDefaultBigIcon(String str) {
        this.defaultBigIcon = str;
    }

    public final void setSelectBigIcon(String str) {
        this.selectBigIcon = str;
    }

    public String toString() {
        return "Icon(selectIcon=" + this.selectIcon + ", defaultIcon=" + this.defaultIcon + ", defaultBigIcon=" + this.defaultBigIcon + ", selectBigIcon=" + this.selectBigIcon + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.selectIcon);
        out.writeString(this.defaultIcon);
        out.writeString(this.defaultBigIcon);
        out.writeString(this.selectBigIcon);
    }
}
