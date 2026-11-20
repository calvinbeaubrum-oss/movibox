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
public final class OpenSubtitleDownloadInfo {

    @SerializedName(DownloadModel.FILE_NAME)
    private final String fileName;
    private final String link;
    private final int remaining;

    @SerializedName("reset_time_utc")
    private final String resetTimeUtc;

    public OpenSubtitleDownloadInfo(String link, String fileName, int i11, String resetTimeUtc) {
        Intrinsics.g(link, "link");
        Intrinsics.g(fileName, "fileName");
        Intrinsics.g(resetTimeUtc, "resetTimeUtc");
        this.link = link;
        this.fileName = fileName;
        this.remaining = i11;
        this.resetTimeUtc = resetTimeUtc;
    }

    public static /* synthetic */ OpenSubtitleDownloadInfo copy$default(OpenSubtitleDownloadInfo openSubtitleDownloadInfo, String str, String str2, int i11, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = openSubtitleDownloadInfo.link;
        }
        if ((i12 & 2) != 0) {
            str2 = openSubtitleDownloadInfo.fileName;
        }
        if ((i12 & 4) != 0) {
            i11 = openSubtitleDownloadInfo.remaining;
        }
        if ((i12 & 8) != 0) {
            str3 = openSubtitleDownloadInfo.resetTimeUtc;
        }
        return openSubtitleDownloadInfo.copy(str, str2, i11, str3);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.fileName;
    }

    public final int component3() {
        return this.remaining;
    }

    public final String component4() {
        return this.resetTimeUtc;
    }

    public final OpenSubtitleDownloadInfo copy(String link, String fileName, int i11, String resetTimeUtc) {
        Intrinsics.g(link, "link");
        Intrinsics.g(fileName, "fileName");
        Intrinsics.g(resetTimeUtc, "resetTimeUtc");
        return new OpenSubtitleDownloadInfo(link, fileName, i11, resetTimeUtc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenSubtitleDownloadInfo)) {
            return false;
        }
        OpenSubtitleDownloadInfo openSubtitleDownloadInfo = (OpenSubtitleDownloadInfo) obj;
        return Intrinsics.b(this.link, openSubtitleDownloadInfo.link) && Intrinsics.b(this.fileName, openSubtitleDownloadInfo.fileName) && this.remaining == openSubtitleDownloadInfo.remaining && Intrinsics.b(this.resetTimeUtc, openSubtitleDownloadInfo.resetTimeUtc);
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getRemaining() {
        return this.remaining;
    }

    public final String getResetTimeUtc() {
        return this.resetTimeUtc;
    }

    public int hashCode() {
        return (((((this.link.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.remaining) * 31) + this.resetTimeUtc.hashCode();
    }

    public String toString() {
        return "OpenSubtitleDownloadInfo(link=" + this.link + ", fileName=" + this.fileName + ", remaining=" + this.remaining + ", resetTimeUtc=" + this.resetTimeUtc + ")";
    }
}
