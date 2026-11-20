package com.cloud.h5update.bean;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DownloadEntity implements Serializable {
    private long completedSize;
    private String fileName;
    private String filePath;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f28880id;
    private String taskId;
    private int taskStatus;
    private String title;
    private long totalSize;
    private String url;

    public DownloadEntity() {
    }

    public DownloadEntity(String str, String str2) {
        this();
        this.url = str2;
        this.title = str;
    }

    public final long getCompletedSize() {
        return this.completedSize;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCompletedSize(long j11) {
        this.completedSize = j11;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }

    public final void setFilePath(String str) {
        this.filePath = str;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final void setTaskStatus(int i11) {
        this.taskStatus = i11;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTotalSize(long j11) {
        this.totalSize = j11;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
