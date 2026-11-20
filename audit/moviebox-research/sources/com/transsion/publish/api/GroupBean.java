package com.transsion.publish.api;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xu.a;

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
public final class GroupBean extends a implements Serializable {
    private String avatar;
    private String creatorId;
    private String des;
    private String description;
    private String groupId;
    private boolean hasJoin;
    private String lastPostTime;
    private String name;
    private String newPostCount;
    private String num = "0";
    private String ops;
    private String postCount;
    private boolean select;
    private String userCount;

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getDes() {
        return this.des;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final boolean getHasJoin() {
        return this.hasJoin;
    }

    public final String getLastPostTime() {
        return this.lastPostTime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNewPostCount() {
        return this.newPostCount;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getPostCount() {
        return this.postCount;
    }

    public final boolean getSelect() {
        return this.select;
    }

    public final String getUserCount() {
        return this.userCount;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setCreatorId(String str) {
        this.creatorId = str;
    }

    public final void setDes(String str) {
        this.des = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setHasJoin(boolean z11) {
        this.hasJoin = z11;
    }

    public final void setLastPostTime(String str) {
        this.lastPostTime = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNewPostCount(String str) {
        this.newPostCount = str;
    }

    public final void setNum(String str) {
        Intrinsics.g(str, "<set-?>");
        this.num = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPostCount(String str) {
        this.postCount = str;
    }

    public final void setSelect(boolean z11) {
        this.select = z11;
    }

    public final void setUserCount(String str) {
        this.userCount = str;
    }
}
