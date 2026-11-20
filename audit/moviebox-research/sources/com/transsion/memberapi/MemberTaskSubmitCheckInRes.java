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
public final class MemberTaskSubmitCheckInRes implements Serializable {
    private final String date;
    private final int rewardAmount;
    private final int rewardType;

    public MemberTaskSubmitCheckInRes(String date, int i11, int i12) {
        Intrinsics.g(date, "date");
        this.date = date;
        this.rewardType = i11;
        this.rewardAmount = i12;
    }

    public static /* synthetic */ MemberTaskSubmitCheckInRes copy$default(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = memberTaskSubmitCheckInRes.date;
        }
        if ((i13 & 2) != 0) {
            i11 = memberTaskSubmitCheckInRes.rewardType;
        }
        if ((i13 & 4) != 0) {
            i12 = memberTaskSubmitCheckInRes.rewardAmount;
        }
        return memberTaskSubmitCheckInRes.copy(str, i11, i12);
    }

    public final String component1() {
        return this.date;
    }

    public final int component2() {
        return this.rewardType;
    }

    public final int component3() {
        return this.rewardAmount;
    }

    public final MemberTaskSubmitCheckInRes copy(String date, int i11, int i12) {
        Intrinsics.g(date, "date");
        return new MemberTaskSubmitCheckInRes(date, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberTaskSubmitCheckInRes)) {
            return false;
        }
        MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes = (MemberTaskSubmitCheckInRes) obj;
        return Intrinsics.b(this.date, memberTaskSubmitCheckInRes.date) && this.rewardType == memberTaskSubmitCheckInRes.rewardType && this.rewardAmount == memberTaskSubmitCheckInRes.rewardAmount;
    }

    public final String getDate() {
        return this.date;
    }

    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    public final int getRewardType() {
        return this.rewardType;
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + this.rewardType) * 31) + this.rewardAmount;
    }

    public String toString() {
        return "MemberTaskSubmitCheckInRes(date=" + this.date + ", rewardType=" + this.rewardType + ", rewardAmount=" + this.rewardAmount + ")";
    }
}
