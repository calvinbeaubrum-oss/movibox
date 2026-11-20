package com.transsion.moviedetailapi.bean;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class PlayListIcon implements Parcelable {
    public static final Parcelable.Creator<PlayListIcon> CREATOR = new a();
    private String color;
    private String iconUrl;
    private Boolean isPic;
    private String name;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<PlayListIcon> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PlayListIcon createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PlayListIcon(string, string2, boolValueOf, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PlayListIcon[] newArray(int i11) {
            return new PlayListIcon[i11];
        }
    }

    public PlayListIcon(String str, String str2, Boolean bool, String str3) {
        this.color = str;
        this.iconUrl = str2;
        this.isPic = bool;
        this.name = str3;
    }

    public static /* synthetic */ PlayListIcon copy$default(PlayListIcon playListIcon, String str, String str2, Boolean bool, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = playListIcon.color;
        }
        if ((i11 & 2) != 0) {
            str2 = playListIcon.iconUrl;
        }
        if ((i11 & 4) != 0) {
            bool = playListIcon.isPic;
        }
        if ((i11 & 8) != 0) {
            str3 = playListIcon.name;
        }
        return playListIcon.copy(str, str2, bool, str3);
    }

    public final String component1() {
        return this.color;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final Boolean component3() {
        return this.isPic;
    }

    public final String component4() {
        return this.name;
    }

    public final PlayListIcon copy(String str, String str2, Boolean bool, String str3) {
        return new PlayListIcon(str, str2, bool, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayListIcon)) {
            return false;
        }
        PlayListIcon playListIcon = (PlayListIcon) obj;
        return Intrinsics.b(this.color, playListIcon.color) && Intrinsics.b(this.iconUrl, playListIcon.iconUrl) && Intrinsics.b(this.isPic, playListIcon.isPic) && Intrinsics.b(this.name, playListIcon.name);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.color;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iconUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isPic;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.name;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final Boolean isPic() {
        return this.isPic;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPic(Boolean bool) {
        this.isPic = bool;
    }

    public String toString() {
        return "PlayListIcon(color=" + this.color + ", iconUrl=" + this.iconUrl + ", isPic=" + this.isPic + ", name=" + this.name + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        ?? BooleanValue;
        Intrinsics.g(out, "out");
        out.writeString(this.color);
        out.writeString(this.iconUrl);
        Boolean bool = this.isPic;
        if (bool == null) {
            BooleanValue = 0;
        } else {
            out.writeInt(1);
            BooleanValue = bool.booleanValue();
        }
        out.writeInt(BooleanValue);
        out.writeString(this.name);
    }
}
