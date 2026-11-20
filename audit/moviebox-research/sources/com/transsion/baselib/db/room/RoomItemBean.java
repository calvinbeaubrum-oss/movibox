package com.transsion.baselib.db.room;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class RoomItemBean implements Serializable {
    private String avatar;
    private String description;
    private String groupId;
    private Boolean hasJoin;
    private String level;
    private String name;
    private Long newPostCount;
    private Long postCount;
    private long updateTimeStamp;
    private Long userCount;

    public RoomItemBean(String groupId, String str, String str2, Boolean bool, Long l11, String str3, Long l12, Long l13, String str4, long j11) {
        Intrinsics.g(groupId, "groupId");
        this.groupId = groupId;
        this.name = str;
        this.avatar = str2;
        this.hasJoin = bool;
        this.newPostCount = l11;
        this.description = str3;
        this.postCount = l12;
        this.userCount = l13;
        this.level = str4;
        this.updateTimeStamp = j11;
    }

    public /* synthetic */ RoomItemBean(String str, String str2, String str3, Boolean bool, Long l11, String str4, Long l12, Long l13, String str5, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, bool, l11, str4, l12, l13, str5, (i11 & 512) != 0 ? System.currentTimeMillis() : j11);
    }

    public final String component1() {
        return this.groupId;
    }

    public final long component10() {
        return this.updateTimeStamp;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatar;
    }

    public final Boolean component4() {
        return this.hasJoin;
    }

    public final Long component5() {
        return this.newPostCount;
    }

    public final String component6() {
        return this.description;
    }

    public final Long component7() {
        return this.postCount;
    }

    public final Long component8() {
        return this.userCount;
    }

    public final String component9() {
        return this.level;
    }

    public final RoomItemBean copy(String groupId, String str, String str2, Boolean bool, Long l11, String str3, Long l12, Long l13, String str4, long j11) {
        Intrinsics.g(groupId, "groupId");
        return new RoomItemBean(groupId, str, str2, bool, l11, str3, l12, l13, str4, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomItemBean)) {
            return false;
        }
        RoomItemBean roomItemBean = (RoomItemBean) obj;
        return Intrinsics.b(this.groupId, roomItemBean.groupId) && Intrinsics.b(this.name, roomItemBean.name) && Intrinsics.b(this.avatar, roomItemBean.avatar) && Intrinsics.b(this.hasJoin, roomItemBean.hasJoin) && Intrinsics.b(this.newPostCount, roomItemBean.newPostCount) && Intrinsics.b(this.description, roomItemBean.description) && Intrinsics.b(this.postCount, roomItemBean.postCount) && Intrinsics.b(this.userCount, roomItemBean.userCount) && Intrinsics.b(this.level, roomItemBean.level) && this.updateTimeStamp == roomItemBean.updateTimeStamp;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final Boolean getHasJoin() {
        return this.hasJoin;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getNewPostCount() {
        return this.newPostCount;
    }

    public final Long getPostCount() {
        return this.postCount;
    }

    public final long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final Long getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        int iHashCode = this.groupId.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.hasJoin;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l11 = this.newPostCount;
        int iHashCode5 = (iHashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l12 = this.postCount;
        int iHashCode7 = (iHashCode6 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.userCount;
        int iHashCode8 = (iHashCode7 + (l13 == null ? 0 : l13.hashCode())) * 31;
        String str4 = this.level;
        return ((iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31) + p.a(this.updateTimeStamp);
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setGroupId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.groupId = str;
    }

    public final void setHasJoin(Boolean bool) {
        this.hasJoin = bool;
    }

    public final void setLevel(String str) {
        this.level = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNewPostCount(Long l11) {
        this.newPostCount = l11;
    }

    public final void setPostCount(Long l11) {
        this.postCount = l11;
    }

    public final void setUpdateTimeStamp(long j11) {
        this.updateTimeStamp = j11;
    }

    public final void setUserCount(Long l11) {
        this.userCount = l11;
    }

    public String toString() {
        return "RoomItemBean(groupId=" + this.groupId + ", name=" + this.name + ", avatar=" + this.avatar + ", hasJoin=" + this.hasJoin + ", newPostCount=" + this.newPostCount + ", description=" + this.description + ", postCount=" + this.postCount + ", userCount=" + this.userCount + ", level=" + this.level + ", updateTimeStamp=" + this.updateTimeStamp + ")";
    }
}
