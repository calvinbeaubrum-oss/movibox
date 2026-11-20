package com.transsion.moviedetailapi.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class Group implements Serializable {

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("avatarAverageHueDark")
    private String avatarAverageHueDark;

    @SerializedName("avatarAverageHueLight")
    private String avatarAverageHueLight;

    @SerializedName("cover")
    private Cover cover;

    @SerializedName(TrackingKey.DESCRIPTION)
    private String desc;

    @SerializedName("groupId")
    private String groupId;

    @SerializedName("hasJoin")
    private Boolean hasJoin;

    @SerializedName("level")
    private String level;

    @SerializedName("name")
    private String name;

    @SerializedName("newPostCount")
    private String newPostCount;

    @SerializedName("postCount")
    private Long postCount;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("userCount")
    private Long userCount;

    public Group(String str, String str2, String str3, Long l11, Long l12, String str4, Boolean bool, String str5, String str6, String str7, String str8, Cover cover, List<String> list) {
        this.avatar = str;
        this.groupId = str2;
        this.name = str3;
        this.userCount = l11;
        this.postCount = l12;
        this.level = str4;
        this.hasJoin = bool;
        this.desc = str5;
        this.avatarAverageHueLight = str6;
        this.avatarAverageHueDark = str7;
        this.newPostCount = str8;
        this.cover = cover;
        this.tags = list;
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component10() {
        return this.avatarAverageHueDark;
    }

    public final String component11() {
        return this.newPostCount;
    }

    public final Cover component12() {
        return this.cover;
    }

    public final List<String> component13() {
        return this.tags;
    }

    public final String component2() {
        return this.groupId;
    }

    public final String component3() {
        return this.name;
    }

    public final Long component4() {
        return this.userCount;
    }

    public final Long component5() {
        return this.postCount;
    }

    public final String component6() {
        return this.level;
    }

    public final Boolean component7() {
        return this.hasJoin;
    }

    public final String component8() {
        return this.desc;
    }

    public final String component9() {
        return this.avatarAverageHueLight;
    }

    public final Group copy(String str, String str2, String str3, Long l11, Long l12, String str4, Boolean bool, String str5, String str6, String str7, String str8, Cover cover, List<String> list) {
        return new Group(str, str2, str3, l11, l12, str4, bool, str5, str6, str7, str8, cover, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Group)) {
            return false;
        }
        Group group = (Group) obj;
        return Intrinsics.b(this.avatar, group.avatar) && Intrinsics.b(this.groupId, group.groupId) && Intrinsics.b(this.name, group.name) && Intrinsics.b(this.userCount, group.userCount) && Intrinsics.b(this.postCount, group.postCount) && Intrinsics.b(this.level, group.level) && Intrinsics.b(this.hasJoin, group.hasJoin) && Intrinsics.b(this.desc, group.desc) && Intrinsics.b(this.avatarAverageHueLight, group.avatarAverageHueLight) && Intrinsics.b(this.avatarAverageHueDark, group.avatarAverageHueDark) && Intrinsics.b(this.newPostCount, group.newPostCount) && Intrinsics.b(this.cover, group.cover) && Intrinsics.b(this.tags, group.tags);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatarAverageHueDark() {
        return this.avatarAverageHueDark;
    }

    public final String getAvatarAverageHueLight() {
        return this.avatarAverageHueLight;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final String getDesc() {
        return this.desc;
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

    public final String getNewPostCount() {
        return this.newPostCount;
    }

    public final Long getPostCount() {
        return this.postCount;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final Long getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.groupId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l11 = this.userCount;
        int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.postCount;
        int iHashCode5 = (iHashCode4 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str4 = this.level;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.hasJoin;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.desc;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.avatarAverageHueLight;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.avatarAverageHueDark;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.newPostCount;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Cover cover = this.cover;
        int iHashCode12 = (iHashCode11 + (cover == null ? 0 : cover.hashCode())) * 31;
        List<String> list = this.tags;
        return iHashCode12 + (list != null ? list.hashCode() : 0);
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setAvatarAverageHueDark(String str) {
        this.avatarAverageHueDark = str;
    }

    public final void setAvatarAverageHueLight(String str) {
        this.avatarAverageHueLight = str;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setGroupId(String str) {
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

    public final void setNewPostCount(String str) {
        this.newPostCount = str;
    }

    public final void setPostCount(Long l11) {
        this.postCount = l11;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setUserCount(Long l11) {
        this.userCount = l11;
    }

    public final boolean showAdultRestricted() {
        return TextUtils.equals(this.level, "LIMIT");
    }

    public String toString() {
        return "Group(avatar=" + this.avatar + ", groupId=" + this.groupId + ", name=" + this.name + ", userCount=" + this.userCount + ", postCount=" + this.postCount + ", level=" + this.level + ", hasJoin=" + this.hasJoin + ", desc=" + this.desc + ", avatarAverageHueLight=" + this.avatarAverageHueLight + ", avatarAverageHueDark=" + this.avatarAverageHueDark + ", newPostCount=" + this.newPostCount + ", cover=" + this.cover + ", tags=" + this.tags + ")";
    }
}
