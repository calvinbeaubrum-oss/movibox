package com.transsion.memberapi;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;
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
public final class MemberTaskItem implements Serializable {
    public static final a Companion = new a(null);
    public static final int TASK_GROUP_TYPE_DAILY = 1;
    public static final int TASK_GROUP_TYPE_DURATION = 2;
    public static final int TASK_GROUP_TYPE_RESIDENT = 0;
    public static final int TASK_STATUS_END = 3;
    public static final int TASK_SUB_TYPE_CHECK_IN = 8;
    public static final int TASK_SUB_TYPE_INVITE_USER = 2;
    private final String buttonName;
    private List<MemberTaskItemCheckInInfo> checkInList;
    private final Integer durationCondition;
    private final Object groupInfo;
    private final String groupName;
    private final String groupUrl;
    private final String icon;
    private List<MemberTaskItemInvite> inviteList;
    private final Integer jumpType;
    private final String jumpUrl;
    private Integer lastId;
    private Integer progress;
    private final Integer rewardAmount;
    private MemberTaskRewardInfo rewardInfo;
    private final Integer rewardType;
    private Integer status;
    private final String subTitle;
    private final String taskId;
    private final Integer taskSubType;
    private final Integer taskType;
    private final Integer timeInterval;
    private final Integer timesCondition;
    private final String title;
    private Integer totalProgress;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MemberTaskItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    public MemberTaskItem(String str, Integer num, Integer num2, Integer num3, Integer num4, String str2, String str3, Integer num5, String str4, Integer num6, Integer num7, Integer num8, List<MemberTaskItemInvite> list, List<MemberTaskItemCheckInInfo> list2, MemberTaskRewardInfo memberTaskRewardInfo, Integer num9, Integer num10, String str5, String str6, Integer num11, Integer num12, String str7, String str8, Object obj) {
        this.taskId = str;
        this.taskType = num;
        this.taskSubType = num2;
        this.durationCondition = num3;
        this.timesCondition = num4;
        this.title = str2;
        this.subTitle = str3;
        this.jumpType = num5;
        this.jumpUrl = str4;
        this.progress = num6;
        this.totalProgress = num7;
        this.status = num8;
        this.inviteList = list;
        this.checkInList = list2;
        this.rewardInfo = memberTaskRewardInfo;
        this.rewardType = num9;
        this.rewardAmount = num10;
        this.buttonName = str5;
        this.icon = str6;
        this.timeInterval = num11;
        this.lastId = num12;
        this.groupName = str7;
        this.groupUrl = str8;
        this.groupInfo = obj;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MemberTaskItem(String str, Integer num, Integer num2, Integer num3, Integer num4, String str2, String str3, Integer num5, String str4, Integer num6, Integer num7, Integer num8, List list, List list2, MemberTaskRewardInfo memberTaskRewardInfo, Integer num9, Integer num10, String str5, String str6, Integer num11, Integer num12, String str7, String str8, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        int i12;
        Integer num13;
        String str9 = (i11 & 1) != 0 ? null : str;
        Integer num14 = (i11 & 2) != 0 ? 0 : num;
        Integer num15 = (i11 & 4) != 0 ? 0 : num2;
        Integer num16 = (i11 & 8) != 0 ? 0 : num3;
        Integer num17 = (i11 & 16) != 0 ? 0 : num4;
        String str10 = (i11 & 32) != 0 ? null : str2;
        String str11 = (i11 & 64) != 0 ? null : str3;
        Integer num18 = (i11 & 128) != 0 ? 0 : num5;
        String str12 = (i11 & 256) != 0 ? "" : str4;
        Integer num19 = (i11 & 512) != 0 ? 0 : num6;
        Integer num20 = (i11 & 1024) != 0 ? 0 : num7;
        Integer num21 = (i11 & 2048) != 0 ? 0 : num8;
        List list3 = (i11 & 4096) != 0 ? null : list;
        List list4 = (i11 & 8192) != 0 ? null : list2;
        MemberTaskRewardInfo memberTaskRewardInfo2 = (i11 & 16384) != 0 ? null : memberTaskRewardInfo;
        if ((i11 & 32768) != 0) {
            i12 = 0;
            num13 = 0;
        } else {
            i12 = 0;
            num13 = num9;
        }
        this(str9, num14, num15, num16, num17, str10, str11, num18, str12, num19, num20, num21, list3, list4, memberTaskRewardInfo2, num13, (i11 & 65536) != 0 ? Integer.valueOf(i12) : num10, (i11 & 131072) != 0 ? null : str5, (i11 & 262144) != 0 ? null : str6, (i11 & 524288) != 0 ? 0 : num11, (i11 & 1048576) != 0 ? null : num12, (i11 & 2097152) != 0 ? null : str7, (i11 & 4194304) != 0 ? null : str8, (i11 & 8388608) != 0 ? null : obj);
    }

    public final String component1() {
        return this.taskId;
    }

    public final Integer component10() {
        return this.progress;
    }

    public final Integer component11() {
        return this.totalProgress;
    }

    public final Integer component12() {
        return this.status;
    }

    public final List<MemberTaskItemInvite> component13() {
        return this.inviteList;
    }

    public final List<MemberTaskItemCheckInInfo> component14() {
        return this.checkInList;
    }

    public final MemberTaskRewardInfo component15() {
        return this.rewardInfo;
    }

    public final Integer component16() {
        return this.rewardType;
    }

    public final Integer component17() {
        return this.rewardAmount;
    }

    public final String component18() {
        return this.buttonName;
    }

    public final String component19() {
        return this.icon;
    }

    public final Integer component2() {
        return this.taskType;
    }

    public final Integer component20() {
        return this.timeInterval;
    }

    public final Integer component21() {
        return this.lastId;
    }

    public final String component22() {
        return this.groupName;
    }

    public final String component23() {
        return this.groupUrl;
    }

    public final Object component24() {
        return this.groupInfo;
    }

    public final Integer component3() {
        return this.taskSubType;
    }

    public final Integer component4() {
        return this.durationCondition;
    }

    public final Integer component5() {
        return this.timesCondition;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.subTitle;
    }

    public final Integer component8() {
        return this.jumpType;
    }

    public final String component9() {
        return this.jumpUrl;
    }

    public final MemberTaskItem copy(String str, Integer num, Integer num2, Integer num3, Integer num4, String str2, String str3, Integer num5, String str4, Integer num6, Integer num7, Integer num8, List<MemberTaskItemInvite> list, List<MemberTaskItemCheckInInfo> list2, MemberTaskRewardInfo memberTaskRewardInfo, Integer num9, Integer num10, String str5, String str6, Integer num11, Integer num12, String str7, String str8, Object obj) {
        return new MemberTaskItem(str, num, num2, num3, num4, str2, str3, num5, str4, num6, num7, num8, list, list2, memberTaskRewardInfo, num9, num10, str5, str6, num11, num12, str7, str8, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberTaskItem)) {
            return false;
        }
        MemberTaskItem memberTaskItem = (MemberTaskItem) obj;
        return Intrinsics.b(this.taskId, memberTaskItem.taskId) && Intrinsics.b(this.taskType, memberTaskItem.taskType) && Intrinsics.b(this.taskSubType, memberTaskItem.taskSubType) && Intrinsics.b(this.durationCondition, memberTaskItem.durationCondition) && Intrinsics.b(this.timesCondition, memberTaskItem.timesCondition) && Intrinsics.b(this.title, memberTaskItem.title) && Intrinsics.b(this.subTitle, memberTaskItem.subTitle) && Intrinsics.b(this.jumpType, memberTaskItem.jumpType) && Intrinsics.b(this.jumpUrl, memberTaskItem.jumpUrl) && Intrinsics.b(this.progress, memberTaskItem.progress) && Intrinsics.b(this.totalProgress, memberTaskItem.totalProgress) && Intrinsics.b(this.status, memberTaskItem.status) && Intrinsics.b(this.inviteList, memberTaskItem.inviteList) && Intrinsics.b(this.checkInList, memberTaskItem.checkInList) && Intrinsics.b(this.rewardInfo, memberTaskItem.rewardInfo) && Intrinsics.b(this.rewardType, memberTaskItem.rewardType) && Intrinsics.b(this.rewardAmount, memberTaskItem.rewardAmount) && Intrinsics.b(this.buttonName, memberTaskItem.buttonName) && Intrinsics.b(this.icon, memberTaskItem.icon) && Intrinsics.b(this.timeInterval, memberTaskItem.timeInterval) && Intrinsics.b(this.lastId, memberTaskItem.lastId) && Intrinsics.b(this.groupName, memberTaskItem.groupName) && Intrinsics.b(this.groupUrl, memberTaskItem.groupUrl) && Intrinsics.b(this.groupInfo, memberTaskItem.groupInfo);
    }

    public final String getButtonName() {
        return this.buttonName;
    }

    public final List<MemberTaskItemCheckInInfo> getCheckInList() {
        return this.checkInList;
    }

    public final Integer getDurationCondition() {
        return this.durationCondition;
    }

    public final Object getGroupInfo() {
        return this.groupInfo;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final String getGroupUrl() {
        return this.groupUrl;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<MemberTaskItemInvite> getInviteList() {
        return this.inviteList;
    }

    public final Integer getJumpType() {
        return this.jumpType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Integer getLastId() {
        return this.lastId;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final Integer getRewardAmount() {
        return this.rewardAmount;
    }

    public final MemberTaskRewardInfo getRewardInfo() {
        return this.rewardInfo;
    }

    public final Integer getRewardType() {
        return this.rewardType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final Integer getTaskSubType() {
        return this.taskSubType;
    }

    public final Integer getTaskType() {
        return this.taskType;
    }

    public final Integer getTimeInterval() {
        return this.timeInterval;
    }

    public final Integer getTimesCondition() {
        return this.timesCondition;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTotalProgress() {
        return this.totalProgress;
    }

    public int hashCode() {
        String str = this.taskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.taskType;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.taskSubType;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.durationCondition;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.timesCondition;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subTitle;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num5 = this.jumpType;
        int iHashCode8 = (iHashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str4 = this.jumpUrl;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num6 = this.progress;
        int iHashCode10 = (iHashCode9 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.totalProgress;
        int iHashCode11 = (iHashCode10 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.status;
        int iHashCode12 = (iHashCode11 + (num8 == null ? 0 : num8.hashCode())) * 31;
        List<MemberTaskItemInvite> list = this.inviteList;
        int iHashCode13 = (iHashCode12 + (list == null ? 0 : list.hashCode())) * 31;
        List<MemberTaskItemCheckInInfo> list2 = this.checkInList;
        int iHashCode14 = (iHashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        MemberTaskRewardInfo memberTaskRewardInfo = this.rewardInfo;
        int iHashCode15 = (iHashCode14 + (memberTaskRewardInfo == null ? 0 : memberTaskRewardInfo.hashCode())) * 31;
        Integer num9 = this.rewardType;
        int iHashCode16 = (iHashCode15 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.rewardAmount;
        int iHashCode17 = (iHashCode16 + (num10 == null ? 0 : num10.hashCode())) * 31;
        String str5 = this.buttonName;
        int iHashCode18 = (iHashCode17 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.icon;
        int iHashCode19 = (iHashCode18 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num11 = this.timeInterval;
        int iHashCode20 = (iHashCode19 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.lastId;
        int iHashCode21 = (iHashCode20 + (num12 == null ? 0 : num12.hashCode())) * 31;
        String str7 = this.groupName;
        int iHashCode22 = (iHashCode21 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.groupUrl;
        int iHashCode23 = (iHashCode22 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Object obj = this.groupInfo;
        return iHashCode23 + (obj != null ? obj.hashCode() : 0);
    }

    public final boolean isClaimCompleted() {
        Integer num = this.status;
        return num != null && num.intValue() == 3;
    }

    public final void setCheckInList(List<MemberTaskItemCheckInInfo> list) {
        this.checkInList = list;
    }

    public final void setInviteList(List<MemberTaskItemInvite> list) {
        this.inviteList = list;
    }

    public final void setLastId(Integer num) {
        this.lastId = num;
    }

    public final void setProgress(Integer num) {
        this.progress = num;
    }

    public final void setRewardInfo(MemberTaskRewardInfo memberTaskRewardInfo) {
        this.rewardInfo = memberTaskRewardInfo;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final void setTotalProgress(Integer num) {
        this.totalProgress = num;
    }

    public String toString() {
        return "MemberTaskItem(taskId=" + this.taskId + ", taskType=" + this.taskType + ", taskSubType=" + this.taskSubType + ", durationCondition=" + this.durationCondition + ", timesCondition=" + this.timesCondition + ", title=" + this.title + ", subTitle=" + this.subTitle + ", jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ", progress=" + this.progress + ", totalProgress=" + this.totalProgress + ", status=" + this.status + ", inviteList=" + this.inviteList + ", checkInList=" + this.checkInList + ", rewardInfo=" + this.rewardInfo + ", rewardType=" + this.rewardType + ", rewardAmount=" + this.rewardAmount + ", buttonName=" + this.buttonName + ", icon=" + this.icon + ", timeInterval=" + this.timeInterval + ", lastId=" + this.lastId + ", groupName=" + this.groupName + ", groupUrl=" + this.groupUrl + ", groupInfo=" + this.groupInfo + ")";
    }
}
