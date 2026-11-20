package com.transsion.transfer.impl.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.util.StringExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class FileData implements Parcelable {
    public static final int STATE_CONNECTING = 0;
    public static final int STATE_DISCONNECT = 5;
    public static final int STATE_FAIL = 3;
    public static final int STATE_FINISH = 4;
    public static final int STATE_NO_FILE = 6;
    public static final int STATE_SPACE_LIMIT = 7;
    public static final int STATE_TRANSFERRING = 2;
    private final String coverUrl;
    private DownloadBean downloadBean;
    private long downloadSize;
    private final String fileName;
    private String fileReceiveCachePath;
    private final String fileRemotePath;
    private long fileSize;
    private final String remoteUrl;
    private int state;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<FileData> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: com.transsion.transfer.impl.entity.FileData$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class C0605a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f59043a;

            static {
                int[] iArr = new int[TaskState.values().length];
                try {
                    iArr[TaskState.CONNECTING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TaskState.TRANSFERRING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TaskState.ERROR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TaskState.FINISH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[TaskState.CANCEL.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[TaskState.DISCONNECT.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[TaskState.NO_FILE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[TaskState.SPACE_LIMIT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                f59043a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(TaskState state) {
            Intrinsics.g(state, "state");
            switch (C0605a.f59043a[state.ordinal()]) {
                case 1:
                    return 0;
                case 2:
                    return 2;
                case 3:
                case 5:
                    return 3;
                case 4:
                    return 4;
                case 6:
                    return 5;
                case 7:
                    return 6;
                case 8:
                    return 7;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final TaskState b(int i11) {
            if (i11 == 0) {
                return TaskState.CONNECTING;
            }
            switch (i11) {
                case 2:
                    return TaskState.TRANSFERRING;
                case 3:
                    return TaskState.ERROR;
                case 4:
                    return TaskState.FINISH;
                case 5:
                    return TaskState.DISCONNECT;
                case 6:
                    return TaskState.NO_FILE;
                case 7:
                    return TaskState.SPACE_LIMIT;
                default:
                    return TaskState.CANCEL;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<FileData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FileData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new FileData(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FileData[] newArray(int i11) {
            return new FileData[i11];
        }
    }

    public FileData(String fileRemotePath, String fileName, long j11, String coverUrl, String fileReceiveCachePath, String remoteUrl, int i11, long j12) {
        Intrinsics.g(fileRemotePath, "fileRemotePath");
        Intrinsics.g(fileName, "fileName");
        Intrinsics.g(coverUrl, "coverUrl");
        Intrinsics.g(fileReceiveCachePath, "fileReceiveCachePath");
        Intrinsics.g(remoteUrl, "remoteUrl");
        this.fileRemotePath = fileRemotePath;
        this.fileName = fileName;
        this.fileSize = j11;
        this.coverUrl = coverUrl;
        this.fileReceiveCachePath = fileReceiveCachePath;
        this.remoteUrl = remoteUrl;
        this.state = i11;
        this.downloadSize = j12;
    }

    public /* synthetic */ FileData(String str, String str2, long j11, String str3, String str4, String str5, int i11, long j12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j11, str3, (i12 & 16) != 0 ? "" : str4, (i12 & 32) != 0 ? "" : str5, (i12 & 64) != 0 ? 0 : i11, (i12 & 128) != 0 ? 0L : j12);
    }

    public final void clearFile() {
        File tempFile = getTempFile();
        File tempBackFile = getTempBackFile();
        File file = new File(this.fileReceiveCachePath);
        if (tempFile.exists()) {
            tempFile.delete();
        }
        if (tempBackFile.exists()) {
            tempBackFile.delete();
        }
        if (file.exists()) {
            file.delete();
        }
    }

    public final String component1() {
        return this.fileRemotePath;
    }

    public final String component2() {
        return this.fileName;
    }

    public final long component3() {
        return this.fileSize;
    }

    public final String component4() {
        return this.coverUrl;
    }

    public final String component5() {
        return this.fileReceiveCachePath;
    }

    public final String component6() {
        return this.remoteUrl;
    }

    public final int component7() {
        return this.state;
    }

    public final long component8() {
        return this.downloadSize;
    }

    public final FileData copy(String fileRemotePath, String fileName, long j11, String coverUrl, String fileReceiveCachePath, String remoteUrl, int i11, long j12) {
        Intrinsics.g(fileRemotePath, "fileRemotePath");
        Intrinsics.g(fileName, "fileName");
        Intrinsics.g(coverUrl, "coverUrl");
        Intrinsics.g(fileReceiveCachePath, "fileReceiveCachePath");
        Intrinsics.g(remoteUrl, "remoteUrl");
        return new FileData(fileRemotePath, fileName, j11, coverUrl, fileReceiveCachePath, remoteUrl, i11, j12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(FileData.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.b(this.fileRemotePath, ((FileData) obj).fileRemotePath);
    }

    public final void filePrepare() {
        File tempFile = getTempFile();
        File tempBackFile = getTempBackFile();
        if (tempFile.exists() && tempBackFile.exists() && tempBackFile.length() > 0) {
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile, true);
            try {
                FileInputStream fileInputStream = new FileInputStream(tempBackFile);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i11 = fileInputStream.read(bArr);
                        if (i11 == -1) {
                            Unit unit = Unit.f68710a;
                            CloseableKt.a(fileInputStream, null);
                            CloseableKt.a(fileOutputStream, null);
                            tempBackFile.delete();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i11);
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.a(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.a(fileInputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public final File getCoverFile() {
        File file = new File(new File(this.fileReceiveCachePath).getParentFile(), ".image");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, StringExtKt.a(this.fileName));
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final DownloadBean getDownloadBean() {
        return this.downloadBean;
    }

    public final long getDownloadSize() {
        return this.downloadSize;
    }

    public final long getDownloadedSize() {
        File tempFile = getTempFile();
        File tempBackFile = getTempBackFile();
        File file = new File(this.fileReceiveCachePath);
        if (file.exists()) {
            long length = file.length();
            long j11 = this.fileSize;
            if (length == j11) {
                return j11;
            }
        }
        if (tempFile.exists()) {
            return (tempBackFile.exists() ? tempBackFile.length() : 0L) + tempFile.length();
        }
        return 0L;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFileReceiveCachePath() {
        return this.fileReceiveCachePath;
    }

    public final String getFileRemotePath() {
        return this.fileRemotePath;
    }

    public final String getFileShowName() {
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean == null) {
            return this.fileName;
        }
        Intrinsics.d(downloadBean);
        return downloadBean.getTotalTitleName();
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final File getFinalFile() {
        File tempFile = getTempFile();
        File tempBackFile = getTempBackFile();
        File file = new File(this.fileReceiveCachePath);
        if (file.exists() && file.length() == this.fileSize) {
            return file;
        }
        if (tempFile.exists() && tempBackFile.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                for (File file2 : g.o(tempFile, tempBackFile)) {
                    if (file2.exists() && file2.length() > 0) {
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i11 = fileInputStream.read(bArr);
                                if (i11 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i11);
                            }
                            Unit unit = Unit.f68710a;
                            CloseableKt.a(fileInputStream, null);
                            file2.delete();
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                CloseableKt.a(fileInputStream, th2);
                                throw th3;
                            }
                        }
                    }
                }
                Unit unit2 = Unit.f68710a;
                CloseableKt.a(fileOutputStream, null);
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.a(fileOutputStream, th4);
                    throw th5;
                }
            }
        } else if (tempFile.exists() && !tempBackFile.exists()) {
            tempFile.renameTo(file);
        }
        return file;
    }

    public final String getRemoteUrl() {
        return this.remoteUrl;
    }

    public final File getRootFile() {
        return new File(this.fileReceiveCachePath).getParentFile();
    }

    public final int getState() {
        return this.state;
    }

    public final File getTempBackFile() {
        return new File(new File(this.fileReceiveCachePath).getParentFile(), StringExtKt.a(this.fileName) + ".backtemp");
    }

    public final File getTempCoverFile() {
        File file = new File(new File(this.fileReceiveCachePath).getParentFile(), ".image");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, StringExtKt.a(this.fileName) + ".temp");
    }

    public final File getTempFile() {
        return new File(new File(this.fileReceiveCachePath).getParentFile(), StringExtKt.a(this.fileName) + ".temp");
    }

    public int hashCode() {
        return this.fileRemotePath.hashCode();
    }

    public final void setDownloadBean(DownloadBean downloadBean) {
        this.downloadBean = downloadBean;
    }

    public final void setDownloadSize(long j11) {
        this.downloadSize = j11;
    }

    public final void setFileReceiveCachePath(String str) {
        Intrinsics.g(str, "<set-?>");
        this.fileReceiveCachePath = str;
    }

    public final void setFileSize(long j11) {
        this.fileSize = j11;
    }

    public final void setState(int i11) {
        this.state = i11;
    }

    public String toString() {
        return "FileData(fileRemotePath='" + this.fileRemotePath + "', fileName='" + this.fileName + "', fileSize=" + this.fileSize + ", coverUrl='" + this.coverUrl + "', fileReceiveCachePath='" + this.fileReceiveCachePath + "', remoteUrl='" + this.remoteUrl + "', state=" + this.state + ", downloadSize=" + this.downloadSize + ", fileShowName='" + getFileShowName() + "')";
    }

    public final boolean verifyFile() {
        File file = new File(this.fileReceiveCachePath);
        return file.exists() && file.length() == this.fileSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.fileRemotePath);
        out.writeString(this.fileName);
        out.writeLong(this.fileSize);
        out.writeString(this.coverUrl);
        out.writeString(this.fileReceiveCachePath);
        out.writeString(this.remoteUrl);
        out.writeInt(this.state);
        out.writeLong(this.downloadSize);
    }
}
