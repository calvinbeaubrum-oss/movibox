package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class OpenSubtitleDataFile {

    @SerializedName("cd_number")
    private final int cdNumber;

    @SerializedName("file_id")
    private final String fileId;

    @SerializedName(DownloadModel.FILE_NAME)
    private final String fileName;

    public OpenSubtitleDataFile(int i11, String fileId, String fileName) {
        Intrinsics.g(fileId, "fileId");
        Intrinsics.g(fileName, "fileName");
        this.cdNumber = i11;
        this.fileId = fileId;
        this.fileName = fileName;
    }

    public static /* synthetic */ OpenSubtitleDataFile copy$default(OpenSubtitleDataFile openSubtitleDataFile, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = openSubtitleDataFile.cdNumber;
        }
        if ((i12 & 2) != 0) {
            str = openSubtitleDataFile.fileId;
        }
        if ((i12 & 4) != 0) {
            str2 = openSubtitleDataFile.fileName;
        }
        return openSubtitleDataFile.copy(i11, str, str2);
    }

    public final int component1() {
        return this.cdNumber;
    }

    public final String component2() {
        return this.fileId;
    }

    public final String component3() {
        return this.fileName;
    }

    public final OpenSubtitleDataFile copy(int i11, String fileId, String fileName) {
        Intrinsics.g(fileId, "fileId");
        Intrinsics.g(fileName, "fileName");
        return new OpenSubtitleDataFile(i11, fileId, fileName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenSubtitleDataFile)) {
            return false;
        }
        OpenSubtitleDataFile openSubtitleDataFile = (OpenSubtitleDataFile) obj;
        return this.cdNumber == openSubtitleDataFile.cdNumber && Intrinsics.b(this.fileId, openSubtitleDataFile.fileId) && Intrinsics.b(this.fileName, openSubtitleDataFile.fileName);
    }

    public final int getCdNumber() {
        return this.cdNumber;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public int hashCode() {
        return (((this.cdNumber * 31) + this.fileId.hashCode()) * 31) + this.fileName.hashCode();
    }

    public String toString() {
        return "OpenSubtitleDataFile(cdNumber=" + this.cdNumber + ", fileId=" + this.fileId + ", fileName=" + this.fileName + ")";
    }
}
