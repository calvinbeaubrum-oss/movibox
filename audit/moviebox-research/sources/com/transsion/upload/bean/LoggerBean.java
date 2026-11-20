package com.transsion.upload.bean;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class LoggerBean implements Parcelable {
    public static final Parcelable.Creator<LoggerBean> CREATOR = new a();
    private String logId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<LoggerBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LoggerBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new LoggerBean(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LoggerBean[] newArray(int i11) {
            return new LoggerBean[i11];
        }
    }

    public LoggerBean(String str) {
        this.logId = str;
    }

    public static /* synthetic */ LoggerBean copy$default(LoggerBean loggerBean, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = loggerBean.logId;
        }
        return loggerBean.copy(str);
    }

    public final String component1() {
        return this.logId;
    }

    public final LoggerBean copy(String str) {
        return new LoggerBean(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LoggerBean) && Intrinsics.b(this.logId, ((LoggerBean) obj).logId);
    }

    public final String getLogId() {
        return this.logId;
    }

    public int hashCode() {
        String str = this.logId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    public String toString() {
        return "LoggerBean(logId=" + this.logId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.logId);
    }
}
