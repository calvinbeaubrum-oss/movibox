package com.transsion.memberapi;

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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class TaskRewards {
    private final Integer currentPoint;
    private final MemberTaskItem taskInfo;
    private final String tips;

    public TaskRewards() {
        this(null, null, null, 7, null);
    }

    public TaskRewards(MemberTaskItem memberTaskItem, Integer num, String str) {
        this.taskInfo = memberTaskItem;
        this.currentPoint = num;
        this.tips = str;
    }

    public /* synthetic */ TaskRewards(MemberTaskItem memberTaskItem, Integer num, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : memberTaskItem, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : str);
    }

    public static /* synthetic */ TaskRewards copy$default(TaskRewards taskRewards, MemberTaskItem memberTaskItem, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            memberTaskItem = taskRewards.taskInfo;
        }
        if ((i11 & 2) != 0) {
            num = taskRewards.currentPoint;
        }
        if ((i11 & 4) != 0) {
            str = taskRewards.tips;
        }
        return taskRewards.copy(memberTaskItem, num, str);
    }

    public final MemberTaskItem component1() {
        return this.taskInfo;
    }

    public final Integer component2() {
        return this.currentPoint;
    }

    public final String component3() {
        return this.tips;
    }

    public final TaskRewards copy(MemberTaskItem memberTaskItem, Integer num, String str) {
        return new TaskRewards(memberTaskItem, num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskRewards)) {
            return false;
        }
        TaskRewards taskRewards = (TaskRewards) obj;
        return Intrinsics.b(this.taskInfo, taskRewards.taskInfo) && Intrinsics.b(this.currentPoint, taskRewards.currentPoint) && Intrinsics.b(this.tips, taskRewards.tips);
    }

    public final Integer getCurrentPoint() {
        return this.currentPoint;
    }

    public final MemberTaskItem getTaskInfo() {
        return this.taskInfo;
    }

    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        MemberTaskItem memberTaskItem = this.taskInfo;
        int iHashCode = (memberTaskItem == null ? 0 : memberTaskItem.hashCode()) * 31;
        Integer num = this.currentPoint;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.tips;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TaskRewards(taskInfo=" + this.taskInfo + ", currentPoint=" + this.currentPoint + ", tips=" + this.tips + ")";
    }
}
