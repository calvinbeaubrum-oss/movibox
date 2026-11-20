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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MemberTaskInviteRewards implements Serializable {
    private final int lastId;
    private final List<MemberTaskItemInvite> list;

    /* JADX WARN: Multi-variable type inference failed */
    public MemberTaskInviteRewards() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public MemberTaskInviteRewards(int i11, List<MemberTaskItemInvite> list) {
        this.lastId = i11;
        this.list = list;
    }

    public /* synthetic */ MemberTaskInviteRewards(int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemberTaskInviteRewards copy$default(MemberTaskInviteRewards memberTaskInviteRewards, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = memberTaskInviteRewards.lastId;
        }
        if ((i12 & 2) != 0) {
            list = memberTaskInviteRewards.list;
        }
        return memberTaskInviteRewards.copy(i11, list);
    }

    public final int component1() {
        return this.lastId;
    }

    public final List<MemberTaskItemInvite> component2() {
        return this.list;
    }

    public final MemberTaskInviteRewards copy(int i11, List<MemberTaskItemInvite> list) {
        return new MemberTaskInviteRewards(i11, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberTaskInviteRewards)) {
            return false;
        }
        MemberTaskInviteRewards memberTaskInviteRewards = (MemberTaskInviteRewards) obj;
        return this.lastId == memberTaskInviteRewards.lastId && Intrinsics.b(this.list, memberTaskInviteRewards.list);
    }

    public final int getLastId() {
        return this.lastId;
    }

    public final List<MemberTaskItemInvite> getList() {
        return this.list;
    }

    public int hashCode() {
        int i11 = this.lastId * 31;
        List<MemberTaskItemInvite> list = this.list;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "MemberTaskInviteRewards(lastId=" + this.lastId + ", list=" + this.list + ")";
    }
}
