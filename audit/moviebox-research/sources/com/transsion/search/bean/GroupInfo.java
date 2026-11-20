package com.transsion.search.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Cover;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class GroupInfo implements Parcelable {
    public static final Parcelable.Creator<GroupInfo> CREATOR = new a();
    private Cover cover;
    private String groupId;
    private String name;
    private String ops;
    private List<String> tags;
    private Long userCount;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<GroupInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GroupInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new GroupInfo(parcel.readString(), parcel.readString(), (Cover) parcel.readSerializable(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GroupInfo[] newArray(int i11) {
            return new GroupInfo[i11];
        }
    }

    public GroupInfo(String groupId, String name, Cover cover, Long l11, String ops, List<String> list) {
        Intrinsics.g(groupId, "groupId");
        Intrinsics.g(name, "name");
        Intrinsics.g(cover, "cover");
        Intrinsics.g(ops, "ops");
        this.groupId = groupId;
        this.name = name;
        this.cover = cover;
        this.userCount = l11;
        this.ops = ops;
        this.tags = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupInfo copy$default(GroupInfo groupInfo, String str, String str2, Cover cover, Long l11, String str3, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = groupInfo.groupId;
        }
        if ((i11 & 2) != 0) {
            str2 = groupInfo.name;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            cover = groupInfo.cover;
        }
        Cover cover2 = cover;
        if ((i11 & 8) != 0) {
            l11 = groupInfo.userCount;
        }
        Long l12 = l11;
        if ((i11 & 16) != 0) {
            str3 = groupInfo.ops;
        }
        String str5 = str3;
        if ((i11 & 32) != 0) {
            list = groupInfo.tags;
        }
        return groupInfo.copy(str, str4, cover2, l12, str5, list);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.name;
    }

    public final Cover component3() {
        return this.cover;
    }

    public final Long component4() {
        return this.userCount;
    }

    public final String component5() {
        return this.ops;
    }

    public final List<String> component6() {
        return this.tags;
    }

    public final GroupInfo copy(String groupId, String name, Cover cover, Long l11, String ops, List<String> list) {
        Intrinsics.g(groupId, "groupId");
        Intrinsics.g(name, "name");
        Intrinsics.g(cover, "cover");
        Intrinsics.g(ops, "ops");
        return new GroupInfo(groupId, name, cover, l11, ops, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupInfo)) {
            return false;
        }
        GroupInfo groupInfo = (GroupInfo) obj;
        return Intrinsics.b(this.groupId, groupInfo.groupId) && Intrinsics.b(this.name, groupInfo.name) && Intrinsics.b(this.cover, groupInfo.cover) && Intrinsics.b(this.userCount, groupInfo.userCount) && Intrinsics.b(this.ops, groupInfo.ops) && Intrinsics.b(this.tags, groupInfo.tags);
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOps() {
        return this.ops;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final Long getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        int iHashCode = ((((this.groupId.hashCode() * 31) + this.name.hashCode()) * 31) + this.cover.hashCode()) * 31;
        Long l11 = this.userCount;
        int iHashCode2 = (((iHashCode + (l11 == null ? 0 : l11.hashCode())) * 31) + this.ops.hashCode()) * 31;
        List<String> list = this.tags;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setCover(Cover cover) {
        Intrinsics.g(cover, "<set-?>");
        this.cover = cover;
    }

    public final void setGroupId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.groupId = str;
    }

    public final void setName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.name = str;
    }

    public final void setOps(String str) {
        Intrinsics.g(str, "<set-?>");
        this.ops = str;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setUserCount(Long l11) {
        this.userCount = l11;
    }

    public String toString() {
        return "GroupInfo(groupId=" + this.groupId + ", name=" + this.name + ", cover=" + this.cover + ", userCount=" + this.userCount + ", ops=" + this.ops + ", tags=" + this.tags + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.groupId);
        out.writeString(this.name);
        out.writeSerializable(this.cover);
        Long l11 = this.userCount;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        out.writeString(this.ops);
        out.writeStringList(this.tags);
    }
}
