package com.transsnet.downloader.callback;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class DownloadTaskStat implements Serializable {
    private int doneCount;
    private int errorCount;
    private int loadingCount;
    private int waitCount;

    public DownloadTaskStat(int i11, int i12, int i13, int i14) {
        this.waitCount = i11;
        this.loadingCount = i12;
        this.errorCount = i13;
        this.doneCount = i14;
    }

    public static /* synthetic */ DownloadTaskStat copy$default(DownloadTaskStat downloadTaskStat, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = downloadTaskStat.waitCount;
        }
        if ((i15 & 2) != 0) {
            i12 = downloadTaskStat.loadingCount;
        }
        if ((i15 & 4) != 0) {
            i13 = downloadTaskStat.errorCount;
        }
        if ((i15 & 8) != 0) {
            i14 = downloadTaskStat.doneCount;
        }
        return downloadTaskStat.copy(i11, i12, i13, i14);
    }

    public final int component1() {
        return this.waitCount;
    }

    public final int component2() {
        return this.loadingCount;
    }

    public final int component3() {
        return this.errorCount;
    }

    public final int component4() {
        return this.doneCount;
    }

    public final DownloadTaskStat copy(int i11, int i12, int i13, int i14) {
        return new DownloadTaskStat(i11, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadTaskStat)) {
            return false;
        }
        DownloadTaskStat downloadTaskStat = (DownloadTaskStat) obj;
        return this.waitCount == downloadTaskStat.waitCount && this.loadingCount == downloadTaskStat.loadingCount && this.errorCount == downloadTaskStat.errorCount && this.doneCount == downloadTaskStat.doneCount;
    }

    public final int getDoneCount() {
        return this.doneCount;
    }

    public final int getErrorCount() {
        return this.errorCount;
    }

    public final int getLoadingCount() {
        return this.loadingCount;
    }

    public final int getWaitCount() {
        return this.waitCount;
    }

    public int hashCode() {
        return (((((this.waitCount * 31) + this.loadingCount) * 31) + this.errorCount) * 31) + this.doneCount;
    }

    public final void setDoneCount(int i11) {
        this.doneCount = i11;
    }

    public final void setErrorCount(int i11) {
        this.errorCount = i11;
    }

    public final void setLoadingCount(int i11) {
        this.loadingCount = i11;
    }

    public final void setWaitCount(int i11) {
        this.waitCount = i11;
    }

    public String toString() {
        return "DownloadTaskStat(waitCount=" + this.waitCount + ", loadingCount=" + this.loadingCount + ", errorCount=" + this.errorCount + ", doneCount=" + this.doneCount + ")";
    }
}
