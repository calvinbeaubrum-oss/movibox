package com.transsion.baselib.report.recent_event;

import java.io.Serializable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ActionEvent implements Serializable {
    public static final a Companion = new a(null);
    public static final int GroupList = 2;
    public static final int PostDetail = 4;
    public static final int SubjectList = 3;
    public static final int TrendingList = 1;
    public static final int UnknownSource = 0;
    public static final int checkin = 10;
    public static final int checkout = 11;
    public static final int comment = 13;
    public static final int coverclick = 1;
    public static final int create_post = 9;
    public static final int delete_comment = 14;
    public static final int dislike = 4;
    public static final int download = 12;
    public static final int download_subject = 21;
    public static final int i_have_seen = 6;
    public static final int like = 3;
    public static final int pageview = 15;
    public static final int rankscore = 7;
    public static final int search_cover_click = 20;
    public static final int search_cover_expose = 19;
    public static final int share = 8;
    public static final int unknow = 0;
    public static final int view = 2;
    public static final int want_to_see = 5;
    public static final int want_to_see_cancel = 17;
    private String groupId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f51291id;
    private int playCount;
    private int playDuration;
    private String postId;
    private int source;
    private String subjectId;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ActionEvent(int i11, int i12, String postId, String subjectId, String groupId, int i13, int i14) {
        Intrinsics.g(postId, "postId");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(groupId, "groupId");
        this.f51291id = i11;
        this.source = i12;
        this.postId = postId;
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.playDuration = i13;
        this.playCount = i14;
    }

    public /* synthetic */ ActionEvent(int i11, int i12, String str, String str2, String str3, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i15 & 2) != 0 ? 0 : i12, (i15 & 4) != 0 ? "0" : str, (i15 & 8) != 0 ? "0" : str2, (i15 & 16) == 0 ? str3 : "0", (i15 & 32) != 0 ? 0 : i13, (i15 & 64) == 0 ? i14 : 0);
    }

    public static /* synthetic */ ActionEvent copy$default(ActionEvent actionEvent, int i11, int i12, String str, String str2, String str3, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = actionEvent.f51291id;
        }
        if ((i15 & 2) != 0) {
            i12 = actionEvent.source;
        }
        int i16 = i12;
        if ((i15 & 4) != 0) {
            str = actionEvent.postId;
        }
        String str4 = str;
        if ((i15 & 8) != 0) {
            str2 = actionEvent.subjectId;
        }
        String str5 = str2;
        if ((i15 & 16) != 0) {
            str3 = actionEvent.groupId;
        }
        String str6 = str3;
        if ((i15 & 32) != 0) {
            i13 = actionEvent.playDuration;
        }
        int i17 = i13;
        if ((i15 & 64) != 0) {
            i14 = actionEvent.playCount;
        }
        return actionEvent.copy(i11, i16, str4, str5, str6, i17, i14);
    }

    public final int component1() {
        return this.f51291id;
    }

    public final int component2() {
        return this.source;
    }

    public final String component3() {
        return this.postId;
    }

    public final String component4() {
        return this.subjectId;
    }

    public final String component5() {
        return this.groupId;
    }

    public final int component6() {
        return this.playDuration;
    }

    public final int component7() {
        return this.playCount;
    }

    public final ActionEvent copy(int i11, int i12, String postId, String subjectId, String groupId, int i13, int i14) {
        Intrinsics.g(postId, "postId");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(groupId, "groupId");
        return new ActionEvent(i11, i12, postId, subjectId, groupId, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionEvent)) {
            return false;
        }
        ActionEvent actionEvent = (ActionEvent) obj;
        return this.f51291id == actionEvent.f51291id && this.source == actionEvent.source && Intrinsics.b(this.postId, actionEvent.postId) && Intrinsics.b(this.subjectId, actionEvent.subjectId) && Intrinsics.b(this.groupId, actionEvent.groupId) && this.playDuration == actionEvent.playDuration && this.playCount == actionEvent.playCount;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.f51291id;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final int getPlayDuration() {
        return this.playDuration;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public int hashCode() {
        return (((((((((((this.f51291id * 31) + this.source) * 31) + this.postId.hashCode()) * 31) + this.subjectId.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.playDuration) * 31) + this.playCount;
    }

    public final void setGroupId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.groupId = str;
    }

    public final void setId(int i11) {
        this.f51291id = i11;
    }

    public final void setPlayCount(int i11) {
        this.playCount = i11;
    }

    public final void setPlayDuration(int i11) {
        this.playDuration = i11;
    }

    public final void setPostId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.postId = str;
    }

    public final void setSource(int i11) {
        this.source = i11;
    }

    public final void setSubjectId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.subjectId = str;
    }

    public String toString() {
        return "ActionEvent(id=" + this.f51291id + ", source=" + this.source + ", postId=" + this.postId + ", subjectId=" + this.subjectId + ", groupId=" + this.groupId + ", playDuration=" + this.playDuration + ", playCount=" + this.playCount + ")";
    }
}
