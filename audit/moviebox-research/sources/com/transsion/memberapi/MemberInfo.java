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
public final class MemberInfo implements Serializable {
    private Integer daysLeft;
    private int durationType;
    private String expiryDate;
    private boolean isActive;
    private boolean isAutoRenew;
    private int memberType;
    private String nextRenewDate;
    private int point;

    public MemberInfo(boolean z11, int i11, int i12, boolean z12, String expiryDate, String nextRenewDate, Integer num, int i13) {
        Intrinsics.g(expiryDate, "expiryDate");
        Intrinsics.g(nextRenewDate, "nextRenewDate");
        this.isActive = z11;
        this.memberType = i11;
        this.durationType = i12;
        this.isAutoRenew = z12;
        this.expiryDate = expiryDate;
        this.nextRenewDate = nextRenewDate;
        this.daysLeft = num;
        this.point = i13;
    }

    public final boolean component1() {
        return this.isActive;
    }

    public final int component2() {
        return this.memberType;
    }

    public final int component3() {
        return this.durationType;
    }

    public final boolean component4() {
        return this.isAutoRenew;
    }

    public final String component5() {
        return this.expiryDate;
    }

    public final String component6() {
        return this.nextRenewDate;
    }

    public final Integer component7() {
        return this.daysLeft;
    }

    public final int component8() {
        return this.point;
    }

    public final MemberInfo copy(boolean z11, int i11, int i12, boolean z12, String expiryDate, String nextRenewDate, Integer num, int i13) {
        Intrinsics.g(expiryDate, "expiryDate");
        Intrinsics.g(nextRenewDate, "nextRenewDate");
        return new MemberInfo(z11, i11, i12, z12, expiryDate, nextRenewDate, num, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberInfo)) {
            return false;
        }
        MemberInfo memberInfo = (MemberInfo) obj;
        return this.isActive == memberInfo.isActive && this.memberType == memberInfo.memberType && this.durationType == memberInfo.durationType && this.isAutoRenew == memberInfo.isAutoRenew && Intrinsics.b(this.expiryDate, memberInfo.expiryDate) && Intrinsics.b(this.nextRenewDate, memberInfo.nextRenewDate) && Intrinsics.b(this.daysLeft, memberInfo.daysLeft) && this.point == memberInfo.point;
    }

    public final Integer getDaysLeft() {
        return this.daysLeft;
    }

    public final int getDurationType() {
        return this.durationType;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final int getMemberType() {
        return this.memberType;
    }

    public final String getNextRenewDate() {
        return this.nextRenewDate;
    }

    public final int getPoint() {
        return this.point;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public int hashCode() {
        boolean z11 = this.isActive;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = ((((r11 * 31) + this.memberType) * 31) + this.durationType) * 31;
        boolean z12 = this.isAutoRenew;
        int iHashCode = (((((i11 + (z12 ? 1 : z12)) * 31) + this.expiryDate.hashCode()) * 31) + this.nextRenewDate.hashCode()) * 31;
        Integer num = this.daysLeft;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.point;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isAutoRenew() {
        return this.isAutoRenew;
    }

    public final void setActive(boolean z11) {
        this.isActive = z11;
    }

    public final void setAutoRenew(boolean z11) {
        this.isAutoRenew = z11;
    }

    public final void setDaysLeft(Integer num) {
        this.daysLeft = num;
    }

    public final void setDurationType(int i11) {
        this.durationType = i11;
    }

    public final void setExpiryDate(String str) {
        Intrinsics.g(str, "<set-?>");
        this.expiryDate = str;
    }

    public final void setMemberType(int i11) {
        this.memberType = i11;
    }

    public final void setNextRenewDate(String str) {
        Intrinsics.g(str, "<set-?>");
        this.nextRenewDate = str;
    }

    public final void setPoint(int i11) {
        this.point = i11;
    }

    public String toString() {
        return "MemberInfo(isActive=" + this.isActive + ", memberType=" + this.memberType + ", durationType=" + this.durationType + ", isAutoRenew=" + this.isAutoRenew + ", expiryDate=" + this.expiryDate + ", nextRenewDate=" + this.nextRenewDate + ", daysLeft=" + this.daysLeft + ", point=" + this.point + ")";
    }
}
