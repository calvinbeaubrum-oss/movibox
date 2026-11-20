package com.transsion.room.bean;

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
public final class CreateRoomRequestEntity implements Parcelable {
    public static final Parcelable.Creator<CreateRoomRequestEntity> CREATOR = new a();
    private String avatar;
    private String description;
    private String groupId;
    private String name;
    private String tempBucket;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CreateRoomRequestEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CreateRoomRequestEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CreateRoomRequestEntity(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CreateRoomRequestEntity[] newArray(int i11) {
            return new CreateRoomRequestEntity[i11];
        }
    }

    public CreateRoomRequestEntity(String groupId, String name, String avatar, String description, String str) {
        Intrinsics.g(groupId, "groupId");
        Intrinsics.g(name, "name");
        Intrinsics.g(avatar, "avatar");
        Intrinsics.g(description, "description");
        this.groupId = groupId;
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.tempBucket = str;
    }

    public /* synthetic */ CreateRoomRequestEntity(String str, String str2, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i11 & 16) != 0 ? null : str5);
    }

    public static /* synthetic */ CreateRoomRequestEntity copy$default(CreateRoomRequestEntity createRoomRequestEntity, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = createRoomRequestEntity.groupId;
        }
        if ((i11 & 2) != 0) {
            str2 = createRoomRequestEntity.name;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = createRoomRequestEntity.avatar;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = createRoomRequestEntity.description;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = createRoomRequestEntity.tempBucket;
        }
        return createRoomRequestEntity.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.tempBucket;
    }

    public final CreateRoomRequestEntity copy(String groupId, String name, String avatar, String description, String str) {
        Intrinsics.g(groupId, "groupId");
        Intrinsics.g(name, "name");
        Intrinsics.g(avatar, "avatar");
        Intrinsics.g(description, "description");
        return new CreateRoomRequestEntity(groupId, name, avatar, description, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateRoomRequestEntity)) {
            return false;
        }
        CreateRoomRequestEntity createRoomRequestEntity = (CreateRoomRequestEntity) obj;
        return Intrinsics.b(this.groupId, createRoomRequestEntity.groupId) && Intrinsics.b(this.name, createRoomRequestEntity.name) && Intrinsics.b(this.avatar, createRoomRequestEntity.avatar) && Intrinsics.b(this.description, createRoomRequestEntity.description) && Intrinsics.b(this.tempBucket, createRoomRequestEntity.tempBucket);
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

    public final String getName() {
        return this.name;
    }

    public final String getTempBucket() {
        return this.tempBucket;
    }

    public int hashCode() {
        int iHashCode = ((((((this.groupId.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.tempBucket;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setAvatar(String str) {
        Intrinsics.g(str, "<set-?>");
        this.avatar = str;
    }

    public final void setDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.description = str;
    }

    public final void setGroupId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.groupId = str;
    }

    public final void setName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.name = str;
    }

    public final void setTempBucket(String str) {
        this.tempBucket = str;
    }

    public String toString() {
        return "CreateRoomRequestEntity(groupId=" + this.groupId + ", name=" + this.name + ", avatar=" + this.avatar + ", description=" + this.description + ", tempBucket=" + this.tempBucket + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.groupId);
        out.writeString(this.name);
        out.writeString(this.avatar);
        out.writeString(this.description);
        out.writeString(this.tempBucket);
    }
}
