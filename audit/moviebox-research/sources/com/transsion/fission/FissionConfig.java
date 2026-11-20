package com.transsion.fission;

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
public final class FissionConfig extends WebViewCacheConfigData {
    public static final Parcelable.Creator<FissionConfig> CREATOR = new a();
    private int intervalDays;
    private boolean inviteCodeReg;
    private int inviteNum;
    private int moneyNum;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<FissionConfig> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FissionConfig createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new FissionConfig(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FissionConfig[] newArray(int i11) {
            return new FissionConfig[i11];
        }
    }

    public FissionConfig(int i11, int i12, int i13, boolean z11) {
        super(null, null, null, 7, null);
        this.inviteNum = i11;
        this.moneyNum = i12;
        this.intervalDays = i13;
        this.inviteCodeReg = z11;
    }

    public static /* synthetic */ FissionConfig copy$default(FissionConfig fissionConfig, int i11, int i12, int i13, boolean z11, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = fissionConfig.inviteNum;
        }
        if ((i14 & 2) != 0) {
            i12 = fissionConfig.moneyNum;
        }
        if ((i14 & 4) != 0) {
            i13 = fissionConfig.intervalDays;
        }
        if ((i14 & 8) != 0) {
            z11 = fissionConfig.inviteCodeReg;
        }
        return fissionConfig.copy(i11, i12, i13, z11);
    }

    public final int component1() {
        return this.inviteNum;
    }

    public final int component2() {
        return this.moneyNum;
    }

    public final int component3() {
        return this.intervalDays;
    }

    public final boolean component4() {
        return this.inviteCodeReg;
    }

    public final FissionConfig copy(int i11, int i12, int i13, boolean z11) {
        return new FissionConfig(i11, i12, i13, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FissionConfig)) {
            return false;
        }
        FissionConfig fissionConfig = (FissionConfig) obj;
        return this.inviteNum == fissionConfig.inviteNum && this.moneyNum == fissionConfig.moneyNum && this.intervalDays == fissionConfig.intervalDays && this.inviteCodeReg == fissionConfig.inviteCodeReg;
    }

    public final int getIntervalDays() {
        return this.intervalDays;
    }

    public final boolean getInviteCodeReg() {
        return this.inviteCodeReg;
    }

    public final int getInviteNum() {
        return this.inviteNum;
    }

    public final int getMoneyNum() {
        return this.moneyNum;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int i11 = ((((this.inviteNum * 31) + this.moneyNum) * 31) + this.intervalDays) * 31;
        boolean z11 = this.inviteCodeReg;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return i11 + r11;
    }

    public final void setIntervalDays(int i11) {
        this.intervalDays = i11;
    }

    public final void setInviteCodeReg(boolean z11) {
        this.inviteCodeReg = z11;
    }

    public final void setInviteNum(int i11) {
        this.inviteNum = i11;
    }

    public final void setMoneyNum(int i11) {
        this.moneyNum = i11;
    }

    public String toString() {
        return "FissionConfig(inviteNum=" + this.inviteNum + ", moneyNum=" + this.moneyNum + ", intervalDays=" + this.intervalDays + ", inviteCodeReg=" + this.inviteCodeReg + ")";
    }

    @Override // com.transsion.fission.WebViewCacheConfigData, android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.inviteNum);
        out.writeInt(this.moneyNum);
        out.writeInt(this.intervalDays);
        out.writeInt(this.inviteCodeReg ? 1 : 0);
    }
}
