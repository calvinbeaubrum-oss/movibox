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
public final class Text implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<Text> CREATOR = new a();
    private final String defaultColor;
    private final String selectColor;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<Text> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Text createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new Text(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Text[] newArray(int i11) {
            return new Text[i11];
        }
    }

    public Text(String selectColor, String defaultColor) {
        Intrinsics.g(selectColor, "selectColor");
        Intrinsics.g(defaultColor, "defaultColor");
        this.selectColor = selectColor;
        this.defaultColor = defaultColor;
    }

    public static /* synthetic */ Text copy$default(Text text, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = text.selectColor;
        }
        if ((i11 & 2) != 0) {
            str2 = text.defaultColor;
        }
        return text.copy(str, str2);
    }

    public final String component1() {
        return this.selectColor;
    }

    public final String component2() {
        return this.defaultColor;
    }

    public final Text copy(String selectColor, String defaultColor) {
        Intrinsics.g(selectColor, "selectColor");
        Intrinsics.g(defaultColor, "defaultColor");
        return new Text(selectColor, defaultColor);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Text)) {
            return false;
        }
        Text text = (Text) obj;
        return Intrinsics.b(this.selectColor, text.selectColor) && Intrinsics.b(this.defaultColor, text.defaultColor);
    }

    public final String getDefaultColor() {
        return this.defaultColor;
    }

    public final String getSelectColor() {
        return this.selectColor;
    }

    public int hashCode() {
        return (this.selectColor.hashCode() * 31) + this.defaultColor.hashCode();
    }

    public String toString() {
        return "Text(selectColor=" + this.selectColor + ", defaultColor=" + this.defaultColor + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.selectColor);
        out.writeString(this.defaultColor);
    }
}
