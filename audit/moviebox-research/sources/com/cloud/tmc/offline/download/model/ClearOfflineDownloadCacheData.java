package com.cloud.tmc.offline.download.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import l.p;
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
public final class ClearOfflineDownloadCacheData extends b {
    private final boolean clear;
    private final long intervalTime;

    public ClearOfflineDownloadCacheData() {
        this(false, 0L, 3, null);
    }

    public ClearOfflineDownloadCacheData(boolean z11, long j11) {
        this.clear = z11;
        this.intervalTime = j11;
    }

    public /* synthetic */ ClearOfflineDownloadCacheData(boolean z11, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? 0L : j11);
    }

    public static /* synthetic */ ClearOfflineDownloadCacheData copy$default(ClearOfflineDownloadCacheData clearOfflineDownloadCacheData, boolean z11, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = clearOfflineDownloadCacheData.clear;
        }
        if ((i11 & 2) != 0) {
            j11 = clearOfflineDownloadCacheData.intervalTime;
        }
        return clearOfflineDownloadCacheData.copy(z11, j11);
    }

    public final boolean component1() {
        return this.clear;
    }

    public final long component2() {
        return this.intervalTime;
    }

    public final ClearOfflineDownloadCacheData copy(boolean z11, long j11) {
        return new ClearOfflineDownloadCacheData(z11, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClearOfflineDownloadCacheData)) {
            return false;
        }
        ClearOfflineDownloadCacheData clearOfflineDownloadCacheData = (ClearOfflineDownloadCacheData) obj;
        return this.clear == clearOfflineDownloadCacheData.clear && this.intervalTime == clearOfflineDownloadCacheData.intervalTime;
    }

    public final boolean getClear() {
        return this.clear;
    }

    public final long getIntervalTime() {
        return this.intervalTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.clear;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (r11 * 31) + p.a(this.intervalTime);
    }

    public String toString() {
        return "ClearOfflineDownloadCacheData(clear=" + this.clear + ", intervalTime=" + this.intervalTime + ')';
    }
}
