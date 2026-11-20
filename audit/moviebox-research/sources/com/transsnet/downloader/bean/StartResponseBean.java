package com.transsnet.downloader.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class StartResponseBean implements Parcelable {
    public static final Parcelable.Creator<StartResponseBean> CREATOR = new a();
    private Integer nextDlType;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<StartResponseBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StartResponseBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new StartResponseBean(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StartResponseBean[] newArray(int i11) {
            return new StartResponseBean[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StartResponseBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public StartResponseBean(Integer num) {
        this.nextDlType = num;
    }

    public /* synthetic */ StartResponseBean(Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : num);
    }

    public static /* synthetic */ StartResponseBean copy$default(StartResponseBean startResponseBean, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = startResponseBean.nextDlType;
        }
        return startResponseBean.copy(num);
    }

    public final Integer component1() {
        return this.nextDlType;
    }

    public final StartResponseBean copy(Integer num) {
        return new StartResponseBean(num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StartResponseBean) && Intrinsics.b(this.nextDlType, ((StartResponseBean) obj).nextDlType);
    }

    public final Integer getNextDlType() {
        return this.nextDlType;
    }

    public int hashCode() {
        Integer num = this.nextDlType;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final void setNextDlType(Integer num) {
        this.nextDlType = num;
    }

    public String toString() {
        return "StartResponseBean(nextDlType=" + this.nextDlType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        Integer num = this.nextDlType;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
    }
}
