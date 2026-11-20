package com.transsion.moviedetailapi.bean;

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
public final class FilterItem implements Parcelable {
    public static final Parcelable.Creator<FilterItem> CREATOR = new a();
    private boolean builtIn;
    private String deepLink;
    private Cover image;
    private boolean isAll;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<FilterItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FilterItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new FilterItem(parcel.readString(), parcel.readString(), (Cover) parcel.readSerializable(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FilterItem[] newArray(int i11) {
            return new FilterItem[i11];
        }
    }

    public FilterItem(String str, String str2, Cover cover, boolean z11, boolean z12) {
        this.title = str;
        this.deepLink = str2;
        this.image = cover;
        this.isAll = z11;
        this.builtIn = z12;
    }

    public /* synthetic */ FilterItem(String str, String str2, Cover cover, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, cover, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12);
    }

    public static /* synthetic */ FilterItem copy$default(FilterItem filterItem, String str, String str2, Cover cover, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = filterItem.title;
        }
        if ((i11 & 2) != 0) {
            str2 = filterItem.deepLink;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            cover = filterItem.image;
        }
        Cover cover2 = cover;
        if ((i11 & 8) != 0) {
            z11 = filterItem.isAll;
        }
        boolean z13 = z11;
        if ((i11 & 16) != 0) {
            z12 = filterItem.builtIn;
        }
        return filterItem.copy(str, str3, cover2, z13, z12);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.deepLink;
    }

    public final Cover component3() {
        return this.image;
    }

    public final boolean component4() {
        return this.isAll;
    }

    public final boolean component5() {
        return this.builtIn;
    }

    public final FilterItem copy(String str, String str2, Cover cover, boolean z11, boolean z12) {
        return new FilterItem(str, str2, cover, z11, z12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterItem)) {
            return false;
        }
        FilterItem filterItem = (FilterItem) obj;
        return Intrinsics.b(this.title, filterItem.title) && Intrinsics.b(this.deepLink, filterItem.deepLink) && Intrinsics.b(this.image, filterItem.image) && this.isAll == filterItem.isAll && this.builtIn == filterItem.builtIn;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final Cover getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deepLink;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Cover cover = this.image;
        int iHashCode3 = (iHashCode2 + (cover != null ? cover.hashCode() : 0)) * 31;
        boolean z11 = this.isAll;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode3 + r11) * 31;
        boolean z12 = this.builtIn;
        return i11 + (z12 ? 1 : z12);
    }

    public final boolean isAll() {
        return this.isAll;
    }

    public final void setAll(boolean z11) {
        this.isAll = z11;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setImage(Cover cover) {
        this.image = cover;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "FilterItem(title=" + this.title + ", deepLink=" + this.deepLink + ", image=" + this.image + ", isAll=" + this.isAll + ", builtIn=" + this.builtIn + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.title);
        out.writeString(this.deepLink);
        out.writeSerializable(this.image);
        out.writeInt(this.isAll ? 1 : 0);
        out.writeInt(this.builtIn ? 1 : 0);
    }
}
