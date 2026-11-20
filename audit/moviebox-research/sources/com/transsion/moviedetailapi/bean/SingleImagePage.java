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
public final class SingleImagePage implements Parcelable {
    public static final Parcelable.Creator<SingleImagePage> CREATOR = new a();
    private String content;
    private String deepLink;
    private Image image;
    private String opItemId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SingleImagePage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SingleImagePage createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SingleImagePage((Image) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SingleImagePage[] newArray(int i11) {
            return new SingleImagePage[i11];
        }
    }

    public SingleImagePage() {
        this(null, null, null, null, 15, null);
    }

    public SingleImagePage(Image image, String str, String str2, String str3) {
        this.image = image;
        this.content = str;
        this.opItemId = str2;
        this.deepLink = str3;
    }

    public /* synthetic */ SingleImagePage(Image image, String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : image, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ SingleImagePage copy$default(SingleImagePage singleImagePage, Image image, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            image = singleImagePage.image;
        }
        if ((i11 & 2) != 0) {
            str = singleImagePage.content;
        }
        if ((i11 & 4) != 0) {
            str2 = singleImagePage.opItemId;
        }
        if ((i11 & 8) != 0) {
            str3 = singleImagePage.deepLink;
        }
        return singleImagePage.copy(image, str, str2, str3);
    }

    public final Image component1() {
        return this.image;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.opItemId;
    }

    public final String component4() {
        return this.deepLink;
    }

    public final SingleImagePage copy(Image image, String str, String str2, String str3) {
        return new SingleImagePage(image, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SingleImagePage)) {
            return false;
        }
        SingleImagePage singleImagePage = (SingleImagePage) obj;
        return Intrinsics.b(this.image, singleImagePage.image) && Intrinsics.b(this.content, singleImagePage.content) && Intrinsics.b(this.opItemId, singleImagePage.opItemId) && Intrinsics.b(this.deepLink, singleImagePage.deepLink);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final Image getImage() {
        return this.image;
    }

    public final String getOpItemId() {
        return this.opItemId;
    }

    public int hashCode() {
        Image image = this.image;
        int iHashCode = (image == null ? 0 : image.hashCode()) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.opItemId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deepLink;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setImage(Image image) {
        this.image = image;
    }

    public final void setOpItemId(String str) {
        this.opItemId = str;
    }

    public String toString() {
        return "SingleImagePage(image=" + this.image + ", content=" + this.content + ", opItemId=" + this.opItemId + ", deepLink=" + this.deepLink + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeSerializable(this.image);
        out.writeString(this.content);
        out.writeString(this.opItemId);
        out.writeString(this.deepLink);
    }
}
