package com.transsion.memberapi;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MemberTaskItemCheckInInfo implements Serializable {
    private final String date;
    private boolean hasCheckIn;
    private final boolean isToday;
    private final int rewardAmount;
    private final int rewardType;

    public MemberTaskItemCheckInInfo(String date, boolean z11, boolean z12, int i11, int i12) {
        Intrinsics.g(date, "date");
        this.date = date;
        this.isToday = z11;
        this.hasCheckIn = z12;
        this.rewardType = i11;
        this.rewardAmount = i12;
    }

    public static /* synthetic */ MemberTaskItemCheckInInfo copy$default(MemberTaskItemCheckInInfo memberTaskItemCheckInInfo, String str, boolean z11, boolean z12, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = memberTaskItemCheckInInfo.date;
        }
        if ((i13 & 2) != 0) {
            z11 = memberTaskItemCheckInInfo.isToday;
        }
        boolean z13 = z11;
        if ((i13 & 4) != 0) {
            z12 = memberTaskItemCheckInInfo.hasCheckIn;
        }
        boolean z14 = z12;
        if ((i13 & 8) != 0) {
            i11 = memberTaskItemCheckInInfo.rewardType;
        }
        int i14 = i11;
        if ((i13 & 16) != 0) {
            i12 = memberTaskItemCheckInInfo.rewardAmount;
        }
        return memberTaskItemCheckInInfo.copy(str, z13, z14, i14, i12);
    }

    public final String component1() {
        return this.date;
    }

    public final boolean component2() {
        return this.isToday;
    }

    public final boolean component3() {
        return this.hasCheckIn;
    }

    public final int component4() {
        return this.rewardType;
    }

    public final int component5() {
        return this.rewardAmount;
    }

    public final MemberTaskItemCheckInInfo copy(String date, boolean z11, boolean z12, int i11, int i12) {
        Intrinsics.g(date, "date");
        return new MemberTaskItemCheckInInfo(date, z11, z12, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberTaskItemCheckInInfo)) {
            return false;
        }
        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj;
        return Intrinsics.b(this.date, memberTaskItemCheckInInfo.date) && this.isToday == memberTaskItemCheckInInfo.isToday && this.hasCheckIn == memberTaskItemCheckInInfo.hasCheckIn && this.rewardType == memberTaskItemCheckInInfo.rewardType && this.rewardAmount == memberTaskItemCheckInInfo.rewardAmount;
    }

    public final String getDate() {
        return this.date;
    }

    public final boolean getHasCheckIn() {
        return this.hasCheckIn;
    }

    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    public final int getRewardType() {
        return this.rewardType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.date.hashCode() * 31;
        boolean z11 = this.isToday;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode + r11) * 31;
        boolean z12 = this.hasCheckIn;
        return ((((i11 + (z12 ? 1 : z12)) * 31) + this.rewardType) * 31) + this.rewardAmount;
    }

    public final boolean isToday() {
        return this.isToday;
    }

    public final void setHasCheckIn(boolean z11) {
        this.hasCheckIn = z11;
    }

    public String toString() {
        return "MemberTaskItemCheckInInfo(date=" + this.date + ", isToday=" + this.isToday + ", hasCheckIn=" + this.hasCheckIn + ", rewardType=" + this.rewardType + ", rewardAmount=" + this.rewardAmount + ")";
    }
}
