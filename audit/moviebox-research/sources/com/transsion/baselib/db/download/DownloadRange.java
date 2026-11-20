package com.transsion.baselib.db.download;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class DownloadRange {
    private long end;
    private volatile boolean isDownloading;
    private volatile long progress;
    private int rangeId;
    private boolean reDownload;
    private String resourceId;
    private long start;
    private int threadId;
    private int threadIndex;

    public final boolean contains(long j11) {
        return j11 <= this.end && this.start <= j11;
    }

    public final long getEnd() {
        return this.end;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final int getRangeId() {
        return this.rangeId;
    }

    public final long getRangeSize() {
        return (this.end - this.start) + 1;
    }

    public final boolean getReDownload() {
        return this.reDownload;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final long getStart() {
        return this.start;
    }

    public final int getThreadId() {
        return this.threadId;
    }

    public final int getThreadIndex() {
        return this.threadIndex;
    }

    public final boolean isDownloading() {
        return this.isDownloading;
    }

    public final boolean isRangeDownloadSuccess() {
        return this.progress > this.end - this.start;
    }

    public final void setDownloading(boolean z11) {
        this.isDownloading = z11;
    }

    public final void setEnd(long j11) {
        this.end = j11;
    }

    public final void setProgress(long j11) {
        this.progress = j11;
    }

    public final void setRangeId(int i11) {
        this.rangeId = i11;
    }

    public final void setReDownload(boolean z11) {
        this.reDownload = z11;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setStart(long j11) {
        this.start = j11;
    }

    public final void setThreadId(int i11) {
        this.threadId = i11;
    }

    public final void setThreadIndex(int i11) {
        this.threadIndex = i11;
    }

    public String toString() {
        return "DownloadRange {threadId=" + this.threadId + ", rangeId=" + this.rangeId + ", resourceId=" + this.resourceId + ", start=" + this.start + ", end=" + this.end + ", progress=" + this.progress + "}";
    }

    public final long totalProgress() {
        return this.start + this.progress;
    }
}
