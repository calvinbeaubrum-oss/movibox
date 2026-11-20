package com.transsion.fission.activity.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PalmPayTaskInfo implements Parcelable {
    public static final Parcelable.Creator<PalmPayTaskInfo> CREATOR = new a();
    private int progress;
    private int status;
    private String taskId;
    private int totalProgress;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PalmPayTaskInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PalmPayTaskInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PalmPayTaskInfo(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PalmPayTaskInfo[] newArray(int i11) {
            return new PalmPayTaskInfo[i11];
        }
    }

    public PalmPayTaskInfo(String taskId, int i11, int i12, int i13) {
        Intrinsics.g(taskId, "taskId");
        this.taskId = taskId;
        this.progress = i11;
        this.totalProgress = i12;
        this.status = i13;
    }

    public static /* synthetic */ PalmPayTaskInfo copy$default(PalmPayTaskInfo palmPayTaskInfo, String str, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            str = palmPayTaskInfo.taskId;
        }
        if ((i14 & 2) != 0) {
            i11 = palmPayTaskInfo.progress;
        }
        if ((i14 & 4) != 0) {
            i12 = palmPayTaskInfo.totalProgress;
        }
        if ((i14 & 8) != 0) {
            i13 = palmPayTaskInfo.status;
        }
        return palmPayTaskInfo.copy(str, i11, i12, i13);
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.progress;
    }

    public final int component3() {
        return this.totalProgress;
    }

    public final int component4() {
        return this.status;
    }

    public final PalmPayTaskInfo copy(String taskId, int i11, int i12, int i13) {
        Intrinsics.g(taskId, "taskId");
        return new PalmPayTaskInfo(taskId, i11, i12, i13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PalmPayTaskInfo)) {
            return false;
        }
        PalmPayTaskInfo palmPayTaskInfo = (PalmPayTaskInfo) obj;
        return Intrinsics.b(this.taskId, palmPayTaskInfo.taskId) && this.progress == palmPayTaskInfo.progress && this.totalProgress == palmPayTaskInfo.totalProgress && this.status == palmPayTaskInfo.status;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTotalProgress() {
        return this.totalProgress;
    }

    public int hashCode() {
        return (((((this.taskId.hashCode() * 31) + this.progress) * 31) + this.totalProgress) * 31) + this.status;
    }

    public final void setProgress(int i11) {
        this.progress = i11;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public final void setTaskId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.taskId = str;
    }

    public final void setTotalProgress(int i11) {
        this.totalProgress = i11;
    }

    public String toString() {
        return "PalmPayTaskInfo(taskId=" + this.taskId + ", progress=" + this.progress + ", totalProgress=" + this.totalProgress + ", status=" + this.status + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.taskId);
        out.writeInt(this.progress);
        out.writeInt(this.totalProgress);
        out.writeInt(this.status);
    }
}
