package com.transsion.home.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class FollowInfo implements Serializable, e9.a {
    public static final int FOLLOWING_EMPTY = 0;
    public static final int FOLLOWING_TYPE = 1;
    public static final int FOLLOW_TITLE = 2;
    public static final int FOLLOW_TYPE = 3;

    @SerializedName("avatar_url")
    private final String avatarUrl;

    @SerializedName("follow_time")
    private final Long followTime;

    @SerializedName("followed")
    private Boolean followed;

    @SerializedName("follower_num")
    private Long followers;

    @SerializedName("name")
    private final String name;
    private int position;

    @SerializedName("recommended")
    private final Boolean recommended;
    private int type;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("video_list")
    private final List<VideoInfo> videoList;

    @SerializedName("video_num")
    private final Long views;
    public static final a Companion = new a(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FollowInfo() {
    }

    public FollowInfo(int i11) {
        this();
        this.type = i11;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final Long getFollowTime() {
        return this.followTime;
    }

    public final Boolean getFollowed() {
        return this.followed;
    }

    public final Long getFollowers() {
        return this.followers;
    }

    @Override // e9.a
    public int getItemType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPosition() {
        return this.position;
    }

    public final Boolean getRecommended() {
        return this.recommended;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final List<VideoInfo> getVideoList() {
        return this.videoList;
    }

    public final Long getViews() {
        return this.views;
    }

    public final void setFollowed(Boolean bool) {
        this.followed = bool;
    }

    public final void setFollowers(Long l11) {
        this.followers = l11;
    }

    public final void setPosition(int i11) {
        this.position = i11;
    }

    public final void setType(int i11) {
        this.type = i11;
    }
}
