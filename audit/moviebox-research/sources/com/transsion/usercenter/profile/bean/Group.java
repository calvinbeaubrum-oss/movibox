package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class Group implements Serializable {
    private final Integer count;
    private final List<GroupAvatar> groups;

    /* JADX WARN: Multi-variable type inference failed */
    public Group() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Group(Integer num, List<GroupAvatar> groups) {
        Intrinsics.g(groups, "groups");
        this.count = num;
        this.groups = groups;
    }

    public /* synthetic */ Group(Integer num, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : num, (i11 & 2) != 0 ? new ArrayList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Group copy$default(Group group, Integer num, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = group.count;
        }
        if ((i11 & 2) != 0) {
            list = group.groups;
        }
        return group.copy(num, list);
    }

    public final Integer component1() {
        return this.count;
    }

    public final List<GroupAvatar> component2() {
        return this.groups;
    }

    public final Group copy(Integer num, List<GroupAvatar> groups) {
        Intrinsics.g(groups, "groups");
        return new Group(num, groups);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Group)) {
            return false;
        }
        Group group = (Group) obj;
        return Intrinsics.b(this.count, group.count) && Intrinsics.b(this.groups, group.groups);
    }

    public final Integer getCount() {
        return this.count;
    }

    public final List<GroupAvatar> getGroups() {
        return this.groups;
    }

    public int hashCode() {
        Integer num = this.count;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.groups.hashCode();
    }

    public String toString() {
        return "Group(count=" + this.count + ", groups=" + this.groups + ")";
    }
}
