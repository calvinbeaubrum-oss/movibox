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
public final class Badge implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<Badge> CREATOR = new a();
    private final String bgHue;
    private final String text;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<Badge> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Badge createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new Badge(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Badge[] newArray(int i11) {
            return new Badge[i11];
        }
    }

    public Badge(String text, String bgHue) {
        Intrinsics.g(text, "text");
        Intrinsics.g(bgHue, "bgHue");
        this.text = text;
        this.bgHue = bgHue;
    }

    public static /* synthetic */ Badge copy$default(Badge badge, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = badge.text;
        }
        if ((i11 & 2) != 0) {
            str2 = badge.bgHue;
        }
        return badge.copy(str, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.bgHue;
    }

    public final Badge copy(String text, String bgHue) {
        Intrinsics.g(text, "text");
        Intrinsics.g(bgHue, "bgHue");
        return new Badge(text, bgHue);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) obj;
        return Intrinsics.b(this.text, badge.text) && Intrinsics.b(this.bgHue, badge.bgHue);
    }

    public final String getBgHue() {
        return this.bgHue;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.bgHue.hashCode();
    }

    public String toString() {
        return "Badge(text=" + this.text + ", bgHue=" + this.bgHue + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.text);
        out.writeString(this.bgHue);
    }
}
