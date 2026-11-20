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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class LoggerSwitchBean implements Parcelable {
    public static final Parcelable.Creator<LoggerSwitchBean> CREATOR = new a();
    private Boolean retrieve;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<LoggerSwitchBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LoggerSwitchBean createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new LoggerSwitchBean(boolValueOf);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LoggerSwitchBean[] newArray(int i11) {
            return new LoggerSwitchBean[i11];
        }
    }

    public LoggerSwitchBean(Boolean bool) {
        this.retrieve = bool;
    }

    public static /* synthetic */ LoggerSwitchBean copy$default(LoggerSwitchBean loggerSwitchBean, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = loggerSwitchBean.retrieve;
        }
        return loggerSwitchBean.copy(bool);
    }

    public final Boolean component1() {
        return this.retrieve;
    }

    public final LoggerSwitchBean copy(Boolean bool) {
        return new LoggerSwitchBean(bool);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LoggerSwitchBean) && Intrinsics.b(this.retrieve, ((LoggerSwitchBean) obj).retrieve);
    }

    public final Boolean getRetrieve() {
        return this.retrieve;
    }

    public int hashCode() {
        Boolean bool = this.retrieve;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final void setRetrieve(Boolean bool) {
        this.retrieve = bool;
    }

    public String toString() {
        return "LoggerSwitchBean(retrieve=" + this.retrieve + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        ?? BooleanValue;
        Intrinsics.g(out, "out");
        Boolean bool = this.retrieve;
        if (bool == null) {
            BooleanValue = 0;
        } else {
            out.writeInt(1);
            BooleanValue = bool.booleanValue();
        }
        out.writeInt(BooleanValue);
    }
}
