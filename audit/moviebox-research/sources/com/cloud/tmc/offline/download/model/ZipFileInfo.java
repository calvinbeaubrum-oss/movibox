package com.cloud.tmc.offline.download.model;

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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@kotlin.Metadata
public final class ZipFileInfo extends b {
    private OffPkgConfig manifest;
    private String url;
    private String zipUnCompressPath;

    public ZipFileInfo() {
        this(null, null, null, 7, null);
    }

    public ZipFileInfo(String str, String str2, OffPkgConfig offPkgConfig) {
        this.zipUnCompressPath = str;
        this.url = str2;
        this.manifest = offPkgConfig;
    }

    public /* synthetic */ ZipFileInfo(String str, String str2, OffPkgConfig offPkgConfig, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : offPkgConfig);
    }

    public static /* synthetic */ ZipFileInfo copy$default(ZipFileInfo zipFileInfo, String str, String str2, OffPkgConfig offPkgConfig, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = zipFileInfo.zipUnCompressPath;
        }
        if ((i11 & 2) != 0) {
            str2 = zipFileInfo.url;
        }
        if ((i11 & 4) != 0) {
            offPkgConfig = zipFileInfo.manifest;
        }
        return zipFileInfo.copy(str, str2, offPkgConfig);
    }

    public final String component1() {
        return this.zipUnCompressPath;
    }

    public final String component2() {
        return this.url;
    }

    public final OffPkgConfig component3() {
        return this.manifest;
    }

    public final ZipFileInfo copy(String str, String str2, OffPkgConfig offPkgConfig) {
        return new ZipFileInfo(str, str2, offPkgConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZipFileInfo)) {
            return false;
        }
        ZipFileInfo zipFileInfo = (ZipFileInfo) obj;
        return Intrinsics.b(this.zipUnCompressPath, zipFileInfo.zipUnCompressPath) && Intrinsics.b(this.url, zipFileInfo.url) && Intrinsics.b(this.manifest, zipFileInfo.manifest);
    }

    public final OffPkgConfig getManifest() {
        return this.manifest;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getZipUnCompressPath() {
        return this.zipUnCompressPath;
    }

    public int hashCode() {
        String str = this.zipUnCompressPath;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        OffPkgConfig offPkgConfig = this.manifest;
        return iHashCode2 + (offPkgConfig != null ? offPkgConfig.hashCode() : 0);
    }

    public final void setManifest(OffPkgConfig offPkgConfig) {
        this.manifest = offPkgConfig;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setZipUnCompressPath(String str) {
        this.zipUnCompressPath = str;
    }

    public String toString() {
        return "ZipFileInfo(zipUnCompressPath=" + this.zipUnCompressPath + ", url=" + this.url + ", manifest=" + this.manifest + ')';
    }
}
