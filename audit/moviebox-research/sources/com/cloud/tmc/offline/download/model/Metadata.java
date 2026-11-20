package com.cloud.tmc.offline.download.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@kotlin.Metadata
public final class Metadata extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private final String eTag;
    private final String lastModified;
    private final String url;

    /* JADX INFO: compiled from: source.java */
    @kotlin.Metadata
    public static final class a implements Parcelable.Creator<Metadata> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Metadata createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Metadata[] newArray(int i11) {
            return new Metadata[i11];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Metadata(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.g(parcel, "parcel");
    }

    public Metadata(String str, String str2, String str3) {
        this.eTag = str;
        this.lastModified = str2;
        this.url = str3;
    }

    public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = metadata.eTag;
        }
        if ((i11 & 2) != 0) {
            str2 = metadata.lastModified;
        }
        if ((i11 & 4) != 0) {
            str3 = metadata.url;
        }
        return metadata.copy(str, str2, str3);
    }

    public final String component1() {
        return this.eTag;
    }

    public final String component2() {
        return this.lastModified;
    }

    public final String component3() {
        return this.url;
    }

    public final Metadata copy(String str, String str2, String str3) {
        return new Metadata(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Metadata)) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        return Intrinsics.b(this.eTag, metadata.eTag) && Intrinsics.b(this.lastModified, metadata.lastModified) && Intrinsics.b(this.url, metadata.url);
    }

    public final String getETag() {
        return this.eTag;
    }

    public final String getLastModified() {
        return this.lastModified;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.eTag;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lastModified;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Metadata(eTag=" + this.eTag + ", lastModified=" + this.lastModified + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.eTag);
        parcel.writeString(this.lastModified);
        parcel.writeString(this.url);
    }
}
