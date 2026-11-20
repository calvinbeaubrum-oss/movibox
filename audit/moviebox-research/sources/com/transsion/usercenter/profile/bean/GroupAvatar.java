package com.transsion.usercenter.profile.bean;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class GroupAvatar implements Serializable {
    private final String avatar;
    private final int count;

    public GroupAvatar(int i11, String avatar) {
        Intrinsics.g(avatar, "avatar");
        this.count = i11;
        this.avatar = avatar;
    }

    public static /* synthetic */ GroupAvatar copy$default(GroupAvatar groupAvatar, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = groupAvatar.count;
        }
        if ((i12 & 2) != 0) {
            str = groupAvatar.avatar;
        }
        return groupAvatar.copy(i11, str);
    }

    public final int component1() {
        return this.count;
    }

    public final String component2() {
        return this.avatar;
    }

    public final GroupAvatar copy(int i11, String avatar) {
        Intrinsics.g(avatar, "avatar");
        return new GroupAvatar(i11, avatar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupAvatar)) {
            return false;
        }
        GroupAvatar groupAvatar = (GroupAvatar) obj;
        return this.count == groupAvatar.count && Intrinsics.b(this.avatar, groupAvatar.avatar);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getCount() {
        return this.count;
    }

    public int hashCode() {
        return (this.count * 31) + this.avatar.hashCode();
    }

    public String toString() {
        return "GroupAvatar(count=" + this.count + ", avatar=" + this.avatar + ")";
    }
}
