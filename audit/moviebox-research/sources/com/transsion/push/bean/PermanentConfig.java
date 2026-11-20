package com.transsion.push.bean;

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
public final class PermanentConfig implements Parcelable {
    public static final Parcelable.Creator<PermanentConfig> CREATOR = new Creator();
    private boolean enable;
    private int interval;
    private String startTime;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PermanentConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentConfig createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PermanentConfig(parcel.readInt() != 0, parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentConfig[] newArray(int i11) {
            return new PermanentConfig[i11];
        }
    }

    public PermanentConfig(boolean z11, String str, int i11) {
        this.enable = z11;
        this.startTime = str;
        this.interval = i11;
    }

    public /* synthetic */ PermanentConfig(boolean z11, String str, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? true : z11, str, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ PermanentConfig copy$default(PermanentConfig permanentConfig, boolean z11, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = permanentConfig.enable;
        }
        if ((i12 & 2) != 0) {
            str = permanentConfig.startTime;
        }
        if ((i12 & 4) != 0) {
            i11 = permanentConfig.interval;
        }
        return permanentConfig.copy(z11, str, i11);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.startTime;
    }

    public final int component3() {
        return this.interval;
    }

    public final PermanentConfig copy(boolean z11, String str, int i11) {
        return new PermanentConfig(z11, str, i11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermanentConfig)) {
            return false;
        }
        PermanentConfig permanentConfig = (PermanentConfig) obj;
        return this.enable == permanentConfig.enable && Intrinsics.b(this.startTime, permanentConfig.startTime) && this.interval == permanentConfig.interval;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z11 = this.enable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.startTime;
        return ((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.interval;
    }

    public final void setEnable(boolean z11) {
        this.enable = z11;
    }

    public final void setInterval(int i11) {
        this.interval = i11;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public String toString() {
        return "PermanentConfig(enable=" + this.enable + ", startTime=" + this.startTime + ", interval=" + this.interval + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.enable ? 1 : 0);
        out.writeString(this.startTime);
        out.writeInt(this.interval);
    }
}
