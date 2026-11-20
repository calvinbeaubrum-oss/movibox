package com.cloud.tmc.offline.download.model;

import java.util.List;
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
public final class OfflinePkgCachePath extends b {
    private final String group;
    private final String version;
    private final List<ZipFileInfo> zipFileInfo;

    public OfflinePkgCachePath(String str, String str2, List<ZipFileInfo> list) {
        this.group = str;
        this.version = str2;
        this.zipFileInfo = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflinePkgCachePath copy$default(OfflinePkgCachePath offlinePkgCachePath, String str, String str2, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = offlinePkgCachePath.group;
        }
        if ((i11 & 2) != 0) {
            str2 = offlinePkgCachePath.version;
        }
        if ((i11 & 4) != 0) {
            list = offlinePkgCachePath.zipFileInfo;
        }
        return offlinePkgCachePath.copy(str, str2, list);
    }

    public final String component1() {
        return this.group;
    }

    public final String component2() {
        return this.version;
    }

    public final List<ZipFileInfo> component3() {
        return this.zipFileInfo;
    }

    public final OfflinePkgCachePath copy(String str, String str2, List<ZipFileInfo> list) {
        return new OfflinePkgCachePath(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflinePkgCachePath)) {
            return false;
        }
        OfflinePkgCachePath offlinePkgCachePath = (OfflinePkgCachePath) obj;
        return Intrinsics.b(this.group, offlinePkgCachePath.group) && Intrinsics.b(this.version, offlinePkgCachePath.version) && Intrinsics.b(this.zipFileInfo, offlinePkgCachePath.zipFileInfo);
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getVersion() {
        return this.version;
    }

    public final List<ZipFileInfo> getZipFileInfo() {
        return this.zipFileInfo;
    }

    public int hashCode() {
        String str = this.group;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ZipFileInfo> list = this.zipFileInfo;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "OfflinePkgCachePath(group=" + this.group + ", version=" + this.version + ", zipFileInfo=" + this.zipFileInfo + ')';
    }
}
