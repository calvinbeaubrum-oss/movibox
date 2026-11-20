package com.transsion.memberapi;

import androidx.annotation.Keep;
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
public final class MemberTaskGroup implements Serializable {
    private final Object groupInfo;
    private final String groupName;
    private final String groupUrl;
    private final List<MemberTaskItem> taskItems;

    public MemberTaskGroup(String groupName, String groupUrl, Object groupInfo, List<MemberTaskItem> taskItems) {
        Intrinsics.g(groupName, "groupName");
        Intrinsics.g(groupUrl, "groupUrl");
        Intrinsics.g(groupInfo, "groupInfo");
        Intrinsics.g(taskItems, "taskItems");
        this.groupName = groupName;
        this.groupUrl = groupUrl;
        this.groupInfo = groupInfo;
        this.taskItems = taskItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemberTaskGroup copy$default(MemberTaskGroup memberTaskGroup, String str, String str2, Object obj, List list, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            str = memberTaskGroup.groupName;
        }
        if ((i11 & 2) != 0) {
            str2 = memberTaskGroup.groupUrl;
        }
        if ((i11 & 4) != 0) {
            obj = memberTaskGroup.groupInfo;
        }
        if ((i11 & 8) != 0) {
            list = memberTaskGroup.taskItems;
        }
        return memberTaskGroup.copy(str, str2, obj, list);
    }

    public final String component1() {
        return this.groupName;
    }

    public final String component2() {
        return this.groupUrl;
    }

    public final Object component3() {
        return this.groupInfo;
    }

    public final List<MemberTaskItem> component4() {
        return this.taskItems;
    }

    public final MemberTaskGroup copy(String groupName, String groupUrl, Object groupInfo, List<MemberTaskItem> taskItems) {
        Intrinsics.g(groupName, "groupName");
        Intrinsics.g(groupUrl, "groupUrl");
        Intrinsics.g(groupInfo, "groupInfo");
        Intrinsics.g(taskItems, "taskItems");
        return new MemberTaskGroup(groupName, groupUrl, groupInfo, taskItems);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberTaskGroup)) {
            return false;
        }
        MemberTaskGroup memberTaskGroup = (MemberTaskGroup) obj;
        return Intrinsics.b(this.groupName, memberTaskGroup.groupName) && Intrinsics.b(this.groupUrl, memberTaskGroup.groupUrl) && Intrinsics.b(this.groupInfo, memberTaskGroup.groupInfo) && Intrinsics.b(this.taskItems, memberTaskGroup.taskItems);
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

    public final List<MemberTaskItem> getTaskItems() {
        return this.taskItems;
    }

    public int hashCode() {
        return (((((this.groupName.hashCode() * 31) + this.groupUrl.hashCode()) * 31) + this.groupInfo.hashCode()) * 31) + this.taskItems.hashCode();
    }

    public String toString() {
        return "MemberTaskGroup(groupName=" + this.groupName + ", groupUrl=" + this.groupUrl + ", groupInfo=" + this.groupInfo + ", taskItems=" + this.taskItems + ")";
    }
}
