package com.cloud.tmc.offline.download.model;

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
public final class OfflineZipFileInfo extends b {
    private final String zipCacheAbsolutePath;
    private final String zipDirPath;

    public OfflineZipFileInfo(String zipDirPath, String zipCacheAbsolutePath) {
        Intrinsics.g(zipDirPath, "zipDirPath");
        Intrinsics.g(zipCacheAbsolutePath, "zipCacheAbsolutePath");
        this.zipDirPath = zipDirPath;
        this.zipCacheAbsolutePath = zipCacheAbsolutePath;
    }

    public static /* synthetic */ OfflineZipFileInfo copy$default(OfflineZipFileInfo offlineZipFileInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = offlineZipFileInfo.zipDirPath;
        }
        if ((i11 & 2) != 0) {
            str2 = offlineZipFileInfo.zipCacheAbsolutePath;
        }
        return offlineZipFileInfo.copy(str, str2);
    }

    public final String component1() {
        return this.zipDirPath;
    }

    public final String component2() {
        return this.zipCacheAbsolutePath;
    }

    public final OfflineZipFileInfo copy(String zipDirPath, String zipCacheAbsolutePath) {
        Intrinsics.g(zipDirPath, "zipDirPath");
        Intrinsics.g(zipCacheAbsolutePath, "zipCacheAbsolutePath");
        return new OfflineZipFileInfo(zipDirPath, zipCacheAbsolutePath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflineZipFileInfo)) {
            return false;
        }
        OfflineZipFileInfo offlineZipFileInfo = (OfflineZipFileInfo) obj;
        return Intrinsics.b(this.zipDirPath, offlineZipFileInfo.zipDirPath) && Intrinsics.b(this.zipCacheAbsolutePath, offlineZipFileInfo.zipCacheAbsolutePath);
    }

    public final String getZipCacheAbsolutePath() {
        return this.zipCacheAbsolutePath;
    }

    public final String getZipDirPath() {
        return this.zipDirPath;
    }

    public int hashCode() {
        return (this.zipDirPath.hashCode() * 31) + this.zipCacheAbsolutePath.hashCode();
    }

    public String toString() {
        return "OfflineZipFileInfo(zipDirPath=" + this.zipDirPath + ", zipCacheAbsolutePath=" + this.zipCacheAbsolutePath + ')';
    }
}
