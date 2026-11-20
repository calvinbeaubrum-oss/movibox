package com.transsion.subtitle_download.db;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public class SubtitleDownloadTable implements Parcelable, Serializable {
    public static final Parcelable.Creator<SubtitleDownloadTable> CREATOR = new a();
    private Long delay;
    private Integer downloads;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private int f58357ep;
    private int failCount;
    private String fileCharsetName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f58358id;
    private boolean isSetImmediately;
    private String lan;
    private String lanName;
    private String path;
    private String postId;
    private int resolution;
    private final String resourceId;
    private int resourceStreamType;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private int f58359se;
    private Long size;
    private int status;
    private String subjectId;
    private String subjectName;
    private String subtitleName;
    private String taskId;
    private int type;
    private String url;
    private String zipPath;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SubtitleDownloadTable> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubtitleDownloadTable createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SubtitleDownloadTable(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubtitleDownloadTable[] newArray(int i11) {
            return new SubtitleDownloadTable[i11];
        }
    }

    public SubtitleDownloadTable(String id2, int i11, String resourceId, String str, String str2, String str3, Long l11, Long l12, Integer num, int i12, String str4, String str5, String str6, int i13, int i14, int i15, String str7, int i16, String str8, String str9, String zipPath, String str10, int i17) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(zipPath, "zipPath");
        this.f58358id = id2;
        this.resourceStreamType = i11;
        this.resourceId = resourceId;
        this.lan = str;
        this.lanName = str2;
        this.url = str3;
        this.size = l11;
        this.delay = l12;
        this.downloads = num;
        this.type = i12;
        this.postId = str4;
        this.subtitleName = str5;
        this.subjectId = str6;
        this.f58357ep = i13;
        this.f58359se = i14;
        this.resolution = i15;
        this.subjectName = str7;
        this.status = i16;
        this.fileCharsetName = str8;
        this.path = str9;
        this.zipPath = zipPath;
        this.taskId = str10;
        this.failCount = i17;
    }

    public /* synthetic */ SubtitleDownloadTable(String str, int i11, String str2, String str3, String str4, String str5, Long l11, Long l12, Integer num, int i12, String str6, String str7, String str8, int i13, int i14, int i15, String str9, int i16, String str10, String str11, String str12, String str13, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i18 & 2) != 0 ? 1 : i11, str2, (i18 & 8) != 0 ? null : str3, (i18 & 16) != 0 ? null : str4, (i18 & 32) != 0 ? null : str5, (i18 & 64) != 0 ? null : l11, (i18 & 128) != 0 ? null : l12, (i18 & 256) != 0 ? null : num, (i18 & 512) != 0 ? 1 : i12, (i18 & 1024) != 0 ? null : str6, (i18 & 2048) != 0 ? null : str7, (i18 & 4096) != 0 ? null : str8, (i18 & 8192) != 0 ? 0 : i13, (i18 & 16384) != 0 ? 0 : i14, (32768 & i18) != 0 ? 0 : i15, (65536 & i18) != 0 ? null : str9, (131072 & i18) != 0 ? 0 : i16, (262144 & i18) != 0 ? Charsets.f69091b.name() : str10, (524288 & i18) != 0 ? "" : str11, (1048576 & i18) != 0 ? "" : str12, (2097152 & i18) != 0 ? "" : str13, (i18 & 4194304) != 0 ? 0 : i17);
    }

    public static /* synthetic */ void isSetImmediately$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Long getDelay() {
        return this.delay;
    }

    public final Integer getDownloads() {
        return this.downloads;
    }

    public final int getEp() {
        return this.f58357ep;
    }

    public final int getFailCount() {
        return this.failCount;
    }

    public final String getFileCharsetName() {
        return this.fileCharsetName;
    }

    public final String getId() {
        return this.f58358id;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getLanAbbr() {
        return Intrinsics.b(this.lan, "in_id") ? "in" : this.lan;
    }

    public final String getLanName() {
        return this.lanName;
    }

    public final String getName() {
        String str;
        if (this.type == 1) {
            str = this.lanName;
            if (str == null) {
                return "";
            }
        } else {
            str = this.subtitleName;
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getResourceStreamType() {
        return this.resourceStreamType;
    }

    public final int getSe() {
        return this.f58359se;
    }

    public final Long getSize() {
        return this.size;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSubjectFileName() {
        String strReplace;
        String str = this.subjectName;
        if (str == null || (strReplace = new Regex("[\\\\!/:#*?\"<>|&,]").replace(str, "")) == null) {
            strReplace = this.resourceId;
        }
        return l.F(strReplace, " ", "_", false, 4, null);
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final String getSubtitleInfo() {
        String strV0;
        String str = this.url;
        String strR0 = null;
        if (str != null && (strV0 = StringsKt__StringsKt.V0(str, "?", null, 2, null)) != null) {
            strR0 = StringsKt__StringsKt.R0(strV0, InstructionFileId.DOT, null, 2, null);
        }
        String strValueOf = String.valueOf(strR0);
        if (this.f58357ep <= 0) {
            return getSubjectFileName() + "_" + this.lanName + InstructionFileId.DOT + strValueOf;
        }
        return getSubjectFileName() + "_S" + this.f58359se + "_E" + this.f58357ep + "_" + this.lanName + InstructionFileId.DOT + strValueOf;
    }

    public final String getSubtitleName() {
        return this.subtitleName;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getZipPath() {
        return this.zipPath;
    }

    public final boolean isDownloaded() {
        return this.status == 5;
    }

    public final boolean isInner() {
        return this.type == 1;
    }

    public final boolean isOpenSbNewApi() {
        return this.type == 5;
    }

    public final boolean isSearch() {
        int i11 = this.type;
        return i11 == 2 || i11 == 4 || i11 == 5;
    }

    public final boolean isSetImmediately() {
        return this.isSetImmediately;
    }

    public final void setDelay(Long l11) {
        this.delay = l11;
    }

    public final void setDownloads(Integer num) {
        this.downloads = num;
    }

    public final void setEp(int i11) {
        this.f58357ep = i11;
    }

    public final void setFailCount(int i11) {
        this.failCount = i11;
    }

    public final void setFileCharsetName(String str) {
        this.fileCharsetName = str;
    }

    public final void setId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f58358id = str;
    }

    public final void setLan(String str) {
        this.lan = str;
    }

    public final void setLanName(String str) {
        this.lanName = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setResolution(int i11) {
        this.resolution = i11;
    }

    public final void setResourceStreamType(int i11) {
        this.resourceStreamType = i11;
    }

    public final void setSe(int i11) {
        this.f58359se = i11;
    }

    public final void setSetImmediately(boolean z11) {
        this.isSetImmediately = z11;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectName(String str) {
        this.subjectName = str;
    }

    public final void setSubtitleName(String str) {
        this.subtitleName = str;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setZipPath(String str) {
        Intrinsics.g(str, "<set-?>");
        this.zipPath = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f58358id);
        out.writeInt(this.resourceStreamType);
        out.writeString(this.resourceId);
        out.writeString(this.lan);
        out.writeString(this.lanName);
        out.writeString(this.url);
        Long l11 = this.size;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        Long l12 = this.delay;
        if (l12 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l12.longValue());
        }
        Integer num = this.downloads;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeInt(this.type);
        out.writeString(this.postId);
        out.writeString(this.subtitleName);
        out.writeString(this.subjectId);
        out.writeInt(this.f58357ep);
        out.writeInt(this.f58359se);
        out.writeInt(this.resolution);
        out.writeString(this.subjectName);
        out.writeInt(this.status);
        out.writeString(this.fileCharsetName);
        out.writeString(this.path);
        out.writeString(this.zipPath);
        out.writeString(this.taskId);
        out.writeInt(this.failCount);
    }
}
