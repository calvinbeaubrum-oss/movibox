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
public final class CheckNameBean implements Parcelable {
    public static final Parcelable.Creator<CheckNameBean> CREATOR = new a();
    private String groupId;
    private boolean isExist;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CheckNameBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CheckNameBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CheckNameBean(parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CheckNameBean[] newArray(int i11) {
            return new CheckNameBean[i11];
        }
    }

    public CheckNameBean(String groupId, boolean z11) {
        Intrinsics.g(groupId, "groupId");
        this.groupId = groupId;
        this.isExist = z11;
    }

    public static /* synthetic */ CheckNameBean copy$default(CheckNameBean checkNameBean, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = checkNameBean.groupId;
        }
        if ((i11 & 2) != 0) {
            z11 = checkNameBean.isExist;
        }
        return checkNameBean.copy(str, z11);
    }

    public final String component1() {
        return this.groupId;
    }

    public final boolean component2() {
        return this.isExist;
    }

    public final CheckNameBean copy(String groupId, boolean z11) {
        Intrinsics.g(groupId, "groupId");
        return new CheckNameBean(groupId, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckNameBean)) {
            return false;
        }
        CheckNameBean checkNameBean = (CheckNameBean) obj;
        return Intrinsics.b(this.groupId, checkNameBean.groupId) && this.isExist == checkNameBean.isExist;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.groupId.hashCode() * 31;
        boolean z11 = this.isExist;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode + r11;
    }

    public final boolean isExist() {
        return this.isExist;
    }

    public final void setExist(boolean z11) {
        this.isExist = z11;
    }

    public final void setGroupId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.groupId = str;
    }

    public String toString() {
        return "CheckNameBean(groupId=" + this.groupId + ", isExist=" + this.isExist + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.groupId);
        out.writeInt(this.isExist ? 1 : 0);
    }
}
