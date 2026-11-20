package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RoomItem implements Parcelable {
    public static final Parcelable.Creator<RoomItem> CREATOR = new a();
    private String avatar;
    private boolean builtIn;
    private Cover cover;
    private String creatorId;
    private String description;
    private String groupId;
    private Boolean hasJoin;
    private transient boolean isSelected;
    private String lastPostTime;
    private List<PostSubjectItem> latestPosts;
    private String level;
    private List<String> memberAvatars;
    private String name;
    private Long newPostCount;
    private String ops;
    private Long postCount;
    private List<String> tags;
    private Long userCount;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RoomItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RoomItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long lValueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long lValueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(parcel.readSerializable());
                }
                arrayList = arrayList2;
            }
            return new RoomItem(string, string2, string3, string4, boolValueOf, string5, string6, lValueOf, lValueOf2, lValueOf3, arrayListCreateStringArrayList, string7, string8, arrayListCreateStringArrayList2, arrayList, (Cover) parcel.readSerializable(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RoomItem[] newArray(int i11) {
            return new RoomItem[i11];
        }
    }

    public RoomItem(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, Long l11, Long l12, Long l13, List<String> list, String str7, String str8, List<String> list2, List<PostSubjectItem> list3, Cover cover, boolean z11) {
        this.avatar = str;
        this.creatorId = str2;
        this.description = str3;
        this.groupId = str4;
        this.hasJoin = bool;
        this.lastPostTime = str5;
        this.name = str6;
        this.newPostCount = l11;
        this.postCount = l12;
        this.userCount = l13;
        this.memberAvatars = list;
        this.level = str7;
        this.ops = str8;
        this.tags = list2;
        this.latestPosts = list3;
        this.cover = cover;
        this.builtIn = z11;
    }

    public /* synthetic */ RoomItem(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, Long l11, Long l12, Long l13, List list, String str7, String str8, List list2, List list3, Cover cover, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, bool, str5, str6, l11, l12, l13, list, str7, str8, list2, list3, cover, (i11 & 65536) != 0 ? false : z11);
    }

    public static /* synthetic */ void isSelected$annotations() {
    }

    public final String component1() {
        return this.avatar;
    }

    public final Long component10() {
        return this.userCount;
    }

    public final List<String> component11() {
        return this.memberAvatars;
    }

    public final String component12() {
        return this.level;
    }

    public final String component13() {
        return this.ops;
    }

    public final List<String> component14() {
        return this.tags;
    }

    public final List<PostSubjectItem> component15() {
        return this.latestPosts;
    }

    public final Cover component16() {
        return this.cover;
    }

    public final boolean component17() {
        return this.builtIn;
    }

    public final String component2() {
        return this.creatorId;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.groupId;
    }

    public final Boolean component5() {
        return this.hasJoin;
    }

    public final String component6() {
        return this.lastPostTime;
    }

    public final String component7() {
        return this.name;
    }

    public final Long component8() {
        return this.newPostCount;
    }

    public final Long component9() {
        return this.postCount;
    }

    public final RoomItem copy(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, Long l11, Long l12, Long l13, List<String> list, String str7, String str8, List<String> list2, List<PostSubjectItem> list3, Cover cover, boolean z11) {
        return new RoomItem(str, str2, str3, str4, bool, str5, str6, l11, l12, l13, list, str7, str8, list2, list3, cover, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomItem)) {
            return false;
        }
        RoomItem roomItem = (RoomItem) obj;
        return Intrinsics.b(this.avatar, roomItem.avatar) && Intrinsics.b(this.creatorId, roomItem.creatorId) && Intrinsics.b(this.description, roomItem.description) && Intrinsics.b(this.groupId, roomItem.groupId) && Intrinsics.b(this.hasJoin, roomItem.hasJoin) && Intrinsics.b(this.lastPostTime, roomItem.lastPostTime) && Intrinsics.b(this.name, roomItem.name) && Intrinsics.b(this.newPostCount, roomItem.newPostCount) && Intrinsics.b(this.postCount, roomItem.postCount) && Intrinsics.b(this.userCount, roomItem.userCount) && Intrinsics.b(this.memberAvatars, roomItem.memberAvatars) && Intrinsics.b(this.level, roomItem.level) && Intrinsics.b(this.ops, roomItem.ops) && Intrinsics.b(this.tags, roomItem.tags) && Intrinsics.b(this.latestPosts, roomItem.latestPosts) && Intrinsics.b(this.cover, roomItem.cover) && this.builtIn == roomItem.builtIn;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final String getCreatorId() {
        return this.creatorId;
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

    public final String getLastPostTime() {
        return this.lastPostTime;
    }

    public final List<PostSubjectItem> getLatestPosts() {
        return this.latestPosts;
    }

    public final String getLevel() {
        return this.level;
    }

    public final List<String> getMemberAvatars() {
        return this.memberAvatars;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getNewPostCount() {
        return this.newPostCount;
    }

    public final String getOps() {
        return this.ops;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.creatorId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.groupId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.hasJoin;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.lastPostTime;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.name;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l11 = this.newPostCount;
        int iHashCode8 = (iHashCode7 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.postCount;
        int iHashCode9 = (iHashCode8 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.userCount;
        int iHashCode10 = (iHashCode9 + (l13 == null ? 0 : l13.hashCode())) * 31;
        List<String> list = this.memberAvatars;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.level;
        int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.ops;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<String> list2 = this.tags;
        int iHashCode14 = (iHashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<PostSubjectItem> list3 = this.latestPosts;
        int iHashCode15 = (iHashCode14 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Cover cover = this.cover;
        int iHashCode16 = (iHashCode15 + (cover != null ? cover.hashCode() : 0)) * 31;
        boolean z11 = this.builtIn;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode16 + r11;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setCreatorId(String str) {
        this.creatorId = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setHasJoin(Boolean bool) {
        this.hasJoin = bool;
    }

    public final void setLastPostTime(String str) {
        this.lastPostTime = str;
    }

    public final void setLatestPosts(List<PostSubjectItem> list) {
        this.latestPosts = list;
    }

    public final void setLevel(String str) {
        this.level = str;
    }

    public final void setMemberAvatars(List<String> list) {
        this.memberAvatars = list;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNewPostCount(Long l11) {
        this.newPostCount = l11;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPostCount(Long l11) {
        this.postCount = l11;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setUserCount(Long l11) {
        this.userCount = l11;
    }

    public String toString() {
        return "RoomItem(avatar=" + this.avatar + ", creatorId=" + this.creatorId + ", description=" + this.description + ", groupId=" + this.groupId + ", hasJoin=" + this.hasJoin + ", lastPostTime=" + this.lastPostTime + ", name=" + this.name + ", newPostCount=" + this.newPostCount + ", postCount=" + this.postCount + ", userCount=" + this.userCount + ", memberAvatars=" + this.memberAvatars + ", level=" + this.level + ", ops=" + this.ops + ", tags=" + this.tags + ", latestPosts=" + this.latestPosts + ", cover=" + this.cover + ", builtIn=" + this.builtIn + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.avatar);
        out.writeString(this.creatorId);
        out.writeString(this.description);
        out.writeString(this.groupId);
        Boolean bool = this.hasJoin;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeString(this.lastPostTime);
        out.writeString(this.name);
        Long l11 = this.newPostCount;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        Long l12 = this.postCount;
        if (l12 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l12.longValue());
        }
        Long l13 = this.userCount;
        if (l13 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l13.longValue());
        }
        out.writeStringList(this.memberAvatars);
        out.writeString(this.level);
        out.writeString(this.ops);
        out.writeStringList(this.tags);
        List<PostSubjectItem> list = this.latestPosts;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<PostSubjectItem> it = list.iterator();
            while (it.hasNext()) {
                out.writeSerializable(it.next());
            }
        }
        out.writeSerializable(this.cover);
        out.writeInt(this.builtIn ? 1 : 0);
    }
}
