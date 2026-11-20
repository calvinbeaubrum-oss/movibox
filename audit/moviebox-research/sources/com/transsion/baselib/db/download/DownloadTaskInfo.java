package com.transsion.baselib.db.download;

import androidx.annotation.Keep;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class DownloadTaskInfo {
    private String downloadInfoId;
    private List<DownloadRange> downloadRanges;
    private long end;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f51070id;
    private volatile long progress;
    private long start;
    private int threadId;
    private String uri;

    public DownloadTaskInfo(int i11, String downloadInfoId, String str, long j11, long j12) {
        Intrinsics.g(downloadInfoId, "downloadInfoId");
        this.downloadRanges = new CopyOnWriteArrayList();
        this.f51070id = downloadInfoId.hashCode() + i11;
        this.threadId = i11;
        this.downloadInfoId = downloadInfoId;
        this.uri = str;
        this.start = j11;
        this.end = j12;
    }

    public final String getDownloadInfoId() {
        return this.downloadInfoId;
    }

    public final List<DownloadRange> getDownloadRanges() {
        return this.downloadRanges;
    }

    public final long getEnd() {
        return this.end;
    }

    public final int getId() {
        return this.f51070id;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final long getStart() {
        return this.start;
    }

    public final int getThreadId() {
        return this.threadId;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setDownloadInfoId(String str) {
        this.downloadInfoId = str;
    }

    public final void setDownloadRanges(List<DownloadRange> list) {
        Intrinsics.g(list, "<set-?>");
        this.downloadRanges = list;
    }

    public final void setEnd(long j11) {
        this.end = j11;
    }

    public final void setId(int i11) {
        this.f51070id = i11;
    }

    public final void setProgress(long j11) {
        this.progress = j11;
    }

    public final void setStart(long j11) {
        this.start = j11;
    }

    public final void setThreadId(int i11) {
        this.threadId = i11;
    }

    public final void setUri(String str) {
        this.uri = str;
    }
}
