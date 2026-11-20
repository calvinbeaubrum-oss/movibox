package com.transsion.memberapi;

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
@Metadata
public final class GlobalTaskInfo implements Serializable {
    private final List<MemberTaskItem> globalTaskConf;
    private final MemberTaskItem taskInfo;

    public GlobalTaskInfo(List<MemberTaskItem> list, MemberTaskItem memberTaskItem) {
        this.globalTaskConf = list;
        this.taskInfo = memberTaskItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalTaskInfo copy$default(GlobalTaskInfo globalTaskInfo, List list, MemberTaskItem memberTaskItem, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = globalTaskInfo.globalTaskConf;
        }
        if ((i11 & 2) != 0) {
            memberTaskItem = globalTaskInfo.taskInfo;
        }
        return globalTaskInfo.copy(list, memberTaskItem);
    }

    public final List<MemberTaskItem> component1() {
        return this.globalTaskConf;
    }

    public final MemberTaskItem component2() {
        return this.taskInfo;
    }

    public final GlobalTaskInfo copy(List<MemberTaskItem> list, MemberTaskItem memberTaskItem) {
        return new GlobalTaskInfo(list, memberTaskItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlobalTaskInfo)) {
            return false;
        }
        GlobalTaskInfo globalTaskInfo = (GlobalTaskInfo) obj;
        return Intrinsics.b(this.globalTaskConf, globalTaskInfo.globalTaskConf) && Intrinsics.b(this.taskInfo, globalTaskInfo.taskInfo);
    }

    public final List<MemberTaskItem> getGlobalTaskConf() {
        return this.globalTaskConf;
    }

    public final MemberTaskItem getTaskInfo() {
        return this.taskInfo;
    }

    public int hashCode() {
        List<MemberTaskItem> list = this.globalTaskConf;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        MemberTaskItem memberTaskItem = this.taskInfo;
        return iHashCode + (memberTaskItem != null ? memberTaskItem.hashCode() : 0);
    }

    public String toString() {
        return "GlobalTaskInfo(globalTaskConf=" + this.globalTaskConf + ", taskInfo=" + this.taskInfo + ")";
    }
}
