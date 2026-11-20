package com.transsion.room.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
public final class CheckInEntity implements Parcelable {
    public static final Parcelable.Creator<CheckInEntity> CREATOR = new a();
    private String groupId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CheckInEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CheckInEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CheckInEntity(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CheckInEntity[] newArray(int i11) {
            return new CheckInEntity[i11];
        }
    }

    public CheckInEntity(String groupId) {
        Intrinsics.g(groupId, "groupId");
        this.groupId = groupId;
    }

    public static /* synthetic */ CheckInEntity copy$default(CheckInEntity checkInEntity, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = checkInEntity.groupId;
        }
        return checkInEntity.copy(str);
    }

    public final String component1() {
        return this.groupId;
    }

    public final CheckInEntity copy(String groupId) {
        Intrinsics.g(groupId, "groupId");
        return new CheckInEntity(groupId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CheckInEntity) && Intrinsics.b(this.groupId, ((CheckInEntity) obj).groupId);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public int hashCode() {
        return this.groupId.hashCode();
    }

    public final void setGroupId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.groupId = str;
    }

    public String toString() {
        return "CheckInEntity(groupId=" + this.groupId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.groupId);
    }
}
