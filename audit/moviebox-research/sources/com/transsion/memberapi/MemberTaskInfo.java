package com.transsion.memberapi;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class MemberTaskInfo implements Serializable {
    private final List<MemberTaskGroup> list;

    public MemberTaskInfo(List<MemberTaskGroup> list) {
        Intrinsics.g(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemberTaskInfo copy$default(MemberTaskInfo memberTaskInfo, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = memberTaskInfo.list;
        }
        return memberTaskInfo.copy(list);
    }

    public final List<MemberTaskGroup> component1() {
        return this.list;
    }

    public final MemberTaskInfo copy(List<MemberTaskGroup> list) {
        Intrinsics.g(list, "list");
        return new MemberTaskInfo(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MemberTaskInfo) && Intrinsics.b(this.list, ((MemberTaskInfo) obj).list);
    }

    public final List<MemberTaskItemCheckInInfo> findCheckInTaskList() {
        Object next;
        List<MemberTaskItem> taskItems;
        MemberTaskItem memberTaskItem;
        Object next2;
        List<MemberTaskItemCheckInInfo> checkInList;
        Iterator<T> it = this.list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Iterator<T> it2 = ((MemberTaskGroup) next).getTaskItems().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                MemberTaskItem memberTaskItem2 = (MemberTaskItem) next2;
                Integer taskSubType = memberTaskItem2.getTaskSubType();
                if (taskSubType != null && taskSubType.intValue() == 8 && (checkInList = memberTaskItem2.getCheckInList()) != null && !checkInList.isEmpty()) {
                    break;
                }
            }
        } while (next2 == null);
        MemberTaskGroup memberTaskGroup = (MemberTaskGroup) next;
        if (memberTaskGroup == null || (taskItems = memberTaskGroup.getTaskItems()) == null || (memberTaskItem = taskItems.get(0)) == null) {
            return null;
        }
        return memberTaskItem.getCheckInList();
    }

    public final List<MemberTaskItemInvite> findInviteTaskList() {
        Object next;
        List<MemberTaskItem> taskItems;
        MemberTaskItem memberTaskItem;
        Object next2;
        List<MemberTaskItemInvite> inviteList;
        Iterator<T> it = this.list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Iterator<T> it2 = ((MemberTaskGroup) next).getTaskItems().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                MemberTaskItem memberTaskItem2 = (MemberTaskItem) next2;
                Integer taskSubType = memberTaskItem2.getTaskSubType();
                if (taskSubType != null && taskSubType.intValue() == 2 && (inviteList = memberTaskItem2.getInviteList()) != null && !inviteList.isEmpty()) {
                    break;
                }
            }
        } while (next2 == null);
        MemberTaskGroup memberTaskGroup = (MemberTaskGroup) next;
        if (memberTaskGroup == null || (taskItems = memberTaskGroup.getTaskItems()) == null || (memberTaskItem = taskItems.get(0)) == null) {
            return null;
        }
        return memberTaskItem.getInviteList();
    }

    public final List<MemberTaskGroup> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return "MemberTaskInfo(list=" + this.list + ")";
    }
}
