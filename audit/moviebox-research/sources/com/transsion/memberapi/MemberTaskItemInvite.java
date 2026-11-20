package com.transsion.memberapi;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MemberTaskItemInvite implements Serializable {
    public static final a Companion = new a(null);
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_DONE = 2;
    public static final int STATUS_UNACTIVE = 0;
    private final int friendSeq;
    private final int rewardAmount;
    private final String rewardId;
    private final int rewardType;
    private int status;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MemberTaskItemInvite(String rewardId, int i11, int i12, int i13, int i14) {
        Intrinsics.g(rewardId, "rewardId");
        this.rewardId = rewardId;
        this.rewardType = i11;
        this.rewardAmount = i12;
        this.friendSeq = i13;
        this.status = i14;
    }

    public static /* synthetic */ MemberTaskItemInvite copy$default(MemberTaskItemInvite memberTaskItemInvite, String str, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            str = memberTaskItemInvite.rewardId;
        }
        if ((i15 & 2) != 0) {
            i11 = memberTaskItemInvite.rewardType;
        }
        int i16 = i11;
        if ((i15 & 4) != 0) {
            i12 = memberTaskItemInvite.rewardAmount;
        }
        int i17 = i12;
        if ((i15 & 8) != 0) {
            i13 = memberTaskItemInvite.friendSeq;
        }
        int i18 = i13;
        if ((i15 & 16) != 0) {
            i14 = memberTaskItemInvite.status;
        }
        return memberTaskItemInvite.copy(str, i16, i17, i18, i14);
    }

    public final String component1() {
        return this.rewardId;
    }

    public final int component2() {
        return this.rewardType;
    }

    public final int component3() {
        return this.rewardAmount;
    }

    public final int component4() {
        return this.friendSeq;
    }

    public final int component5() {
        return this.status;
    }

    public final MemberTaskItemInvite copy(String rewardId, int i11, int i12, int i13, int i14) {
        Intrinsics.g(rewardId, "rewardId");
        return new MemberTaskItemInvite(rewardId, i11, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberTaskItemInvite)) {
            return false;
        }
        MemberTaskItemInvite memberTaskItemInvite = (MemberTaskItemInvite) obj;
        return Intrinsics.b(this.rewardId, memberTaskItemInvite.rewardId) && this.rewardType == memberTaskItemInvite.rewardType && this.rewardAmount == memberTaskItemInvite.rewardAmount && this.friendSeq == memberTaskItemInvite.friendSeq && this.status == memberTaskItemInvite.status;
    }

    public final int getFriendSeq() {
        return this.friendSeq;
    }

    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    public final String getRewardId() {
        return this.rewardId;
    }

    public final int getRewardType() {
        return this.rewardType;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((this.rewardId.hashCode() * 31) + this.rewardType) * 31) + this.rewardAmount) * 31) + this.friendSeq) * 31) + this.status;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "MemberTaskItemInvite(rewardId=" + this.rewardId + ", rewardType=" + this.rewardType + ", rewardAmount=" + this.rewardAmount + ", friendSeq=" + this.friendSeq + ", status=" + this.status + ")";
    }
}
