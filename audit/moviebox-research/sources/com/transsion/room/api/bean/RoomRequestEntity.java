package com.transsion.room.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class RoomRequestEntity implements Parcelable {
    public static final Parcelable.Creator<RoomRequestEntity> CREATOR = new a();
    private Integer cid;
    private RoomGeo geo;
    private String page;
    private int perPage;
    private String subjectId;
    private int userAvatarNum;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RoomRequestEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RoomRequestEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new RoomRequestEntity(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? RoomGeo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RoomRequestEntity[] newArray(int i11) {
            return new RoomRequestEntity[i11];
        }
    }

    public RoomRequestEntity(String str, int i11, int i12, Integer num, RoomGeo roomGeo, String str2) {
        this.page = str;
        this.perPage = i11;
        this.userAvatarNum = i12;
        this.cid = num;
        this.geo = roomGeo;
        this.subjectId = str2;
    }

    public /* synthetic */ RoomRequestEntity(String str, int i11, int i12, Integer num, RoomGeo roomGeo, String str2, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? null : str, i11, i12, (i13 & 8) != 0 ? null : num, (i13 & 16) != 0 ? null : roomGeo, (i13 & 32) != 0 ? null : str2);
    }

    public static /* synthetic */ RoomRequestEntity copy$default(RoomRequestEntity roomRequestEntity, String str, int i11, int i12, Integer num, RoomGeo roomGeo, String str2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = roomRequestEntity.page;
        }
        if ((i13 & 2) != 0) {
            i11 = roomRequestEntity.perPage;
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            i12 = roomRequestEntity.userAvatarNum;
        }
        int i15 = i12;
        if ((i13 & 8) != 0) {
            num = roomRequestEntity.cid;
        }
        Integer num2 = num;
        if ((i13 & 16) != 0) {
            roomGeo = roomRequestEntity.geo;
        }
        RoomGeo roomGeo2 = roomGeo;
        if ((i13 & 32) != 0) {
            str2 = roomRequestEntity.subjectId;
        }
        return roomRequestEntity.copy(str, i14, i15, num2, roomGeo2, str2);
    }

    public final String component1() {
        return this.page;
    }

    public final int component2() {
        return this.perPage;
    }

    public final int component3() {
        return this.userAvatarNum;
    }

    public final Integer component4() {
        return this.cid;
    }

    public final RoomGeo component5() {
        return this.geo;
    }

    public final String component6() {
        return this.subjectId;
    }

    public final RoomRequestEntity copy(String str, int i11, int i12, Integer num, RoomGeo roomGeo, String str2) {
        return new RoomRequestEntity(str, i11, i12, num, roomGeo, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomRequestEntity)) {
            return false;
        }
        RoomRequestEntity roomRequestEntity = (RoomRequestEntity) obj;
        return Intrinsics.b(this.page, roomRequestEntity.page) && this.perPage == roomRequestEntity.perPage && this.userAvatarNum == roomRequestEntity.userAvatarNum && Intrinsics.b(this.cid, roomRequestEntity.cid) && Intrinsics.b(this.geo, roomRequestEntity.geo) && Intrinsics.b(this.subjectId, roomRequestEntity.subjectId);
    }

    public final Integer getCid() {
        return this.cid;
    }

    public final RoomGeo getGeo() {
        return this.geo;
    }

    public final String getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final int getUserAvatarNum() {
        return this.userAvatarNum;
    }

    public int hashCode() {
        String str = this.page;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.perPage) * 31) + this.userAvatarNum) * 31;
        Integer num = this.cid;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        RoomGeo roomGeo = this.geo;
        int iHashCode3 = (iHashCode2 + (roomGeo == null ? 0 : roomGeo.hashCode())) * 31;
        String str2 = this.subjectId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCid(Integer num) {
        this.cid = num;
    }

    public final void setGeo(RoomGeo roomGeo) {
        this.geo = roomGeo;
    }

    public final void setPage(String str) {
        this.page = str;
    }

    public final void setPerPage(int i11) {
        this.perPage = i11;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setUserAvatarNum(int i11) {
        this.userAvatarNum = i11;
    }

    public String toString() {
        return "RoomRequestEntity(page=" + this.page + ", perPage=" + this.perPage + ", userAvatarNum=" + this.userAvatarNum + ", cid=" + this.cid + ", geo=" + this.geo + ", subjectId=" + this.subjectId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.page);
        out.writeInt(this.perPage);
        out.writeInt(this.userAvatarNum);
        Integer num = this.cid;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        RoomGeo roomGeo = this.geo;
        if (roomGeo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            roomGeo.writeToParcel(out, i11);
        }
        out.writeString(this.subjectId);
    }
}
