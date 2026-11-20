package com.transsion.fission.activity.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.bean.HomePopupInfo;
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
public final class PalmPayTaskResult implements Parcelable {
    public static final Parcelable.Creator<PalmPayTaskResult> CREATOR = new a();
    private HomePopupInfo popup;
    private PalmPayTaskInfo taskInfo;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PalmPayTaskResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PalmPayTaskResult createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PalmPayTaskResult(parcel.readInt() == 0 ? null : PalmPayTaskInfo.CREATOR.createFromParcel(parcel), (HomePopupInfo) parcel.readParcelable(PalmPayTaskResult.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PalmPayTaskResult[] newArray(int i11) {
            return new PalmPayTaskResult[i11];
        }
    }

    public PalmPayTaskResult(PalmPayTaskInfo palmPayTaskInfo, HomePopupInfo homePopupInfo) {
        this.taskInfo = palmPayTaskInfo;
        this.popup = homePopupInfo;
    }

    public static /* synthetic */ PalmPayTaskResult copy$default(PalmPayTaskResult palmPayTaskResult, PalmPayTaskInfo palmPayTaskInfo, HomePopupInfo homePopupInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            palmPayTaskInfo = palmPayTaskResult.taskInfo;
        }
        if ((i11 & 2) != 0) {
            homePopupInfo = palmPayTaskResult.popup;
        }
        return palmPayTaskResult.copy(palmPayTaskInfo, homePopupInfo);
    }

    public final PalmPayTaskInfo component1() {
        return this.taskInfo;
    }

    public final HomePopupInfo component2() {
        return this.popup;
    }

    public final PalmPayTaskResult copy(PalmPayTaskInfo palmPayTaskInfo, HomePopupInfo homePopupInfo) {
        return new PalmPayTaskResult(palmPayTaskInfo, homePopupInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PalmPayTaskResult)) {
            return false;
        }
        PalmPayTaskResult palmPayTaskResult = (PalmPayTaskResult) obj;
        return Intrinsics.b(this.taskInfo, palmPayTaskResult.taskInfo) && Intrinsics.b(this.popup, palmPayTaskResult.popup);
    }

    public final HomePopupInfo getPopup() {
        return this.popup;
    }

    public final PalmPayTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public int hashCode() {
        PalmPayTaskInfo palmPayTaskInfo = this.taskInfo;
        int iHashCode = (palmPayTaskInfo == null ? 0 : palmPayTaskInfo.hashCode()) * 31;
        HomePopupInfo homePopupInfo = this.popup;
        return iHashCode + (homePopupInfo != null ? homePopupInfo.hashCode() : 0);
    }

    public final void setPopup(HomePopupInfo homePopupInfo) {
        this.popup = homePopupInfo;
    }

    public final void setTaskInfo(PalmPayTaskInfo palmPayTaskInfo) {
        this.taskInfo = palmPayTaskInfo;
    }

    public String toString() {
        return "PalmPayTaskResult(taskInfo=" + this.taskInfo + ", popup=" + this.popup + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        PalmPayTaskInfo palmPayTaskInfo = this.taskInfo;
        if (palmPayTaskInfo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            palmPayTaskInfo.writeToParcel(out, i11);
        }
        out.writeParcelable(this.popup, i11);
    }
}
