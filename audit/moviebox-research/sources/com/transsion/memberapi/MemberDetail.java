package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.util.List;
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
public final class MemberDetail implements Serializable {
    private MemberInfo memberInfo;
    private List<MemberRight> memberRights;
    private PointInfo pointInfo;
    private RewardInfo rewardInfo;
    private UserInfo userInfo;

    public MemberDetail(MemberInfo memberInfo, List<MemberRight> list, RewardInfo rewardInfo, UserInfo userInfo, PointInfo pointInfo) {
        Intrinsics.g(rewardInfo, "rewardInfo");
        this.memberInfo = memberInfo;
        this.memberRights = list;
        this.rewardInfo = rewardInfo;
        this.userInfo = userInfo;
        this.pointInfo = pointInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemberDetail copy$default(MemberDetail memberDetail, MemberInfo memberInfo, List list, RewardInfo rewardInfo, UserInfo userInfo, PointInfo pointInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            memberInfo = memberDetail.memberInfo;
        }
        if ((i11 & 2) != 0) {
            list = memberDetail.memberRights;
        }
        List list2 = list;
        if ((i11 & 4) != 0) {
            rewardInfo = memberDetail.rewardInfo;
        }
        RewardInfo rewardInfo2 = rewardInfo;
        if ((i11 & 8) != 0) {
            userInfo = memberDetail.userInfo;
        }
        UserInfo userInfo2 = userInfo;
        if ((i11 & 16) != 0) {
            pointInfo = memberDetail.pointInfo;
        }
        return memberDetail.copy(memberInfo, list2, rewardInfo2, userInfo2, pointInfo);
    }

    public final MemberInfo component1() {
        return this.memberInfo;
    }

    public final List<MemberRight> component2() {
        return this.memberRights;
    }

    public final RewardInfo component3() {
        return this.rewardInfo;
    }

    public final UserInfo component4() {
        return this.userInfo;
    }

    public final PointInfo component5() {
        return this.pointInfo;
    }

    public final MemberDetail copy(MemberInfo memberInfo, List<MemberRight> list, RewardInfo rewardInfo, UserInfo userInfo, PointInfo pointInfo) {
        Intrinsics.g(rewardInfo, "rewardInfo");
        return new MemberDetail(memberInfo, list, rewardInfo, userInfo, pointInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberDetail)) {
            return false;
        }
        MemberDetail memberDetail = (MemberDetail) obj;
        return Intrinsics.b(this.memberInfo, memberDetail.memberInfo) && Intrinsics.b(this.memberRights, memberDetail.memberRights) && Intrinsics.b(this.rewardInfo, memberDetail.rewardInfo) && Intrinsics.b(this.userInfo, memberDetail.userInfo) && Intrinsics.b(this.pointInfo, memberDetail.pointInfo);
    }

    public final MemberInfo getMemberInfo() {
        return this.memberInfo;
    }

    public final List<MemberRight> getMemberRights() {
        return this.memberRights;
    }

    public final PointInfo getPointInfo() {
        return this.pointInfo;
    }

    public final RewardInfo getRewardInfo() {
        return this.rewardInfo;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        MemberInfo memberInfo = this.memberInfo;
        int iHashCode = (memberInfo == null ? 0 : memberInfo.hashCode()) * 31;
        List<MemberRight> list = this.memberRights;
        int iHashCode2 = (((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.rewardInfo.hashCode()) * 31;
        UserInfo userInfo = this.userInfo;
        int iHashCode3 = (iHashCode2 + (userInfo == null ? 0 : userInfo.hashCode())) * 31;
        PointInfo pointInfo = this.pointInfo;
        return iHashCode3 + (pointInfo != null ? pointInfo.hashCode() : 0);
    }

    public final void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public final void setMemberRights(List<MemberRight> list) {
        this.memberRights = list;
    }

    public final void setPointInfo(PointInfo pointInfo) {
        this.pointInfo = pointInfo;
    }

    public final void setRewardInfo(RewardInfo rewardInfo) {
        Intrinsics.g(rewardInfo, "<set-?>");
        this.rewardInfo = rewardInfo;
    }

    public final void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString() {
        return "MemberDetail(memberInfo=" + this.memberInfo + ", memberRights=" + this.memberRights + ", rewardInfo=" + this.rewardInfo + ", userInfo=" + this.userInfo + ", pointInfo=" + this.pointInfo + ")";
    }
}
