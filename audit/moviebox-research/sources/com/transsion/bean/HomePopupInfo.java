package com.transsion.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class HomePopupInfo implements Parcelable {
    public static final Parcelable.Creator<HomePopupInfo> CREATOR = new a();
    private final int closeDelay;
    private String externalUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f51596id;
    private String img;
    private String innerUrl;
    private final String name;
    private int type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HomePopupInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HomePopupInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HomePopupInfo(parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HomePopupInfo[] newArray(int i11) {
            return new HomePopupInfo[i11];
        }
    }

    public HomePopupInfo(long j11, String name, int i11, String img, int i12, String innerUrl, String externalUrl) {
        Intrinsics.g(name, "name");
        Intrinsics.g(img, "img");
        Intrinsics.g(innerUrl, "innerUrl");
        Intrinsics.g(externalUrl, "externalUrl");
        this.f51596id = j11;
        this.name = name;
        this.type = i11;
        this.img = img;
        this.closeDelay = i12;
        this.innerUrl = innerUrl;
        this.externalUrl = externalUrl;
    }

    public final long component1() {
        return this.f51596id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.type;
    }

    public final String component4() {
        return this.img;
    }

    public final int component5() {
        return this.closeDelay;
    }

    public final String component6() {
        return this.innerUrl;
    }

    public final String component7() {
        return this.externalUrl;
    }

    public final HomePopupInfo copy(long j11, String name, int i11, String img, int i12, String innerUrl, String externalUrl) {
        Intrinsics.g(name, "name");
        Intrinsics.g(img, "img");
        Intrinsics.g(innerUrl, "innerUrl");
        Intrinsics.g(externalUrl, "externalUrl");
        return new HomePopupInfo(j11, name, i11, img, i12, innerUrl, externalUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomePopupInfo)) {
            return false;
        }
        HomePopupInfo homePopupInfo = (HomePopupInfo) obj;
        return this.f51596id == homePopupInfo.f51596id && Intrinsics.b(this.name, homePopupInfo.name) && this.type == homePopupInfo.type && Intrinsics.b(this.img, homePopupInfo.img) && this.closeDelay == homePopupInfo.closeDelay && Intrinsics.b(this.innerUrl, homePopupInfo.innerUrl) && Intrinsics.b(this.externalUrl, homePopupInfo.externalUrl);
    }

    public final int getCloseDelay() {
        return this.closeDelay;
    }

    public final String getExternalUrl() {
        return this.externalUrl;
    }

    public final long getId() {
        return this.f51596id;
    }

    public final String getImg() {
        return this.img;
    }

    public final String getInnerUrl() {
        return this.innerUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((p.a(this.f51596id) * 31) + this.name.hashCode()) * 31) + this.type) * 31) + this.img.hashCode()) * 31) + this.closeDelay) * 31) + this.innerUrl.hashCode()) * 31) + this.externalUrl.hashCode();
    }

    public final void setExternalUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.externalUrl = str;
    }

    public final void setImg(String str) {
        Intrinsics.g(str, "<set-?>");
        this.img = str;
    }

    public final void setInnerUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.innerUrl = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "HomePopupInfo(id=" + this.f51596id + ", name=" + this.name + ", type=" + this.type + ", img=" + this.img + ", closeDelay=" + this.closeDelay + ", innerUrl=" + this.innerUrl + ", externalUrl=" + this.externalUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeLong(this.f51596id);
        out.writeString(this.name);
        out.writeInt(this.type);
        out.writeString(this.img);
        out.writeInt(this.closeDelay);
        out.writeString(this.innerUrl);
        out.writeString(this.externalUrl);
    }
}
