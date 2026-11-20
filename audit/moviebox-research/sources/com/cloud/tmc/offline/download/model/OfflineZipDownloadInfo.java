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
public final class OfflineZipDownloadInfo extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private OffPkgConfig manifest;
    private int status;
    private String url;
    private String zipUnCompressPath;

    /* JADX INFO: compiled from: source.java */
    @kotlin.Metadata
    public static final class a implements Parcelable.Creator<OfflineZipDownloadInfo> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OfflineZipDownloadInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new OfflineZipDownloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public OfflineZipDownloadInfo[] newArray(int i11) {
            return new OfflineZipDownloadInfo[i11];
        }
    }

    public OfflineZipDownloadInfo() {
        this(null, null, 0, null, 15, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineZipDownloadInfo(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readInt(), (OffPkgConfig) parcel.readParcelable(OffPkgConfig.class.getClassLoader()));
        Intrinsics.g(parcel, "parcel");
    }

    public OfflineZipDownloadInfo(String str, String str2, int i11, OffPkgConfig offPkgConfig) {
        this.url = str;
        this.zipUnCompressPath = str2;
        this.status = i11;
        this.manifest = offPkgConfig;
    }

    public /* synthetic */ OfflineZipDownloadInfo(String str, String str2, int i11, OffPkgConfig offPkgConfig, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : offPkgConfig);
    }

    public static /* synthetic */ OfflineZipDownloadInfo copy$default(OfflineZipDownloadInfo offlineZipDownloadInfo, String str, String str2, int i11, OffPkgConfig offPkgConfig, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = offlineZipDownloadInfo.url;
        }
        if ((i12 & 2) != 0) {
            str2 = offlineZipDownloadInfo.zipUnCompressPath;
        }
        if ((i12 & 4) != 0) {
            i11 = offlineZipDownloadInfo.status;
        }
        if ((i12 & 8) != 0) {
            offPkgConfig = offlineZipDownloadInfo.manifest;
        }
        return offlineZipDownloadInfo.copy(str, str2, i11, offPkgConfig);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.zipUnCompressPath;
    }

    public final int component3() {
        return this.status;
    }

    public final OffPkgConfig component4() {
        return this.manifest;
    }

    public final OfflineZipDownloadInfo copy(String str, String str2, int i11, OffPkgConfig offPkgConfig) {
        return new OfflineZipDownloadInfo(str, str2, i11, offPkgConfig);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflineZipDownloadInfo)) {
            return false;
        }
        OfflineZipDownloadInfo offlineZipDownloadInfo = (OfflineZipDownloadInfo) obj;
        return Intrinsics.b(this.url, offlineZipDownloadInfo.url) && Intrinsics.b(this.zipUnCompressPath, offlineZipDownloadInfo.zipUnCompressPath) && this.status == offlineZipDownloadInfo.status && Intrinsics.b(this.manifest, offlineZipDownloadInfo.manifest);
    }

    public final OffPkgConfig getManifest() {
        return this.manifest;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getZipUnCompressPath() {
        return this.zipUnCompressPath;
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.zipUnCompressPath;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.status) * 31;
        OffPkgConfig offPkgConfig = this.manifest;
        return iHashCode2 + (offPkgConfig != null ? offPkgConfig.hashCode() : 0);
    }

    public final void setManifest(OffPkgConfig offPkgConfig) {
        this.manifest = offPkgConfig;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setZipUnCompressPath(String str) {
        this.zipUnCompressPath = str;
    }

    public String toString() {
        return "OfflineZipDownloadInfo(url=" + this.url + ", zipUnCompressPath=" + this.zipUnCompressPath + ", status=" + this.status + ", manifest=" + this.manifest + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.zipUnCompressPath);
        parcel.writeInt(this.status);
        parcel.writeParcelable(this.manifest, i11);
    }
}
