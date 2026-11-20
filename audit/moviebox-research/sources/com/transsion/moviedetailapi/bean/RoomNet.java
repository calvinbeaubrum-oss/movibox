package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RoomNet implements Parcelable {
    public static final Parcelable.Creator<RoomNet> CREATOR = new a();
    private String groupId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RoomNet> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RoomNet createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new RoomNet(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RoomNet[] newArray(int i11) {
            return new RoomNet[i11];
        }
    }

    public RoomNet(String str) {
        this.groupId = str;
    }

    public static /* synthetic */ RoomNet copy$default(RoomNet roomNet, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = roomNet.groupId;
        }
        return roomNet.copy(str);
    }

    public final String component1() {
        return this.groupId;
    }

    public final RoomNet copy(String str) {
        return new RoomNet(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RoomNet) && Intrinsics.b(this.groupId, ((RoomNet) obj).groupId);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public int hashCode() {
        String str = this.groupId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public String toString() {
        return "RoomNet(groupId=" + this.groupId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.groupId);
    }
}
