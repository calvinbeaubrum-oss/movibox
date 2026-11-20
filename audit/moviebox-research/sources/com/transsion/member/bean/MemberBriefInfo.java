package com.transsion.member.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MemberBriefInfo implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<MemberBriefInfo> CREATOR = new a();
    private String expiryDate;
    private boolean isActive;
    private int memberType;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MemberBriefInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MemberBriefInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MemberBriefInfo(parcel.readInt() != 0, parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MemberBriefInfo[] newArray(int i11) {
            return new MemberBriefInfo[i11];
        }
    }

    public MemberBriefInfo(boolean z11, int i11, String expiryDate) {
        Intrinsics.g(expiryDate, "expiryDate");
        this.isActive = z11;
        this.memberType = i11;
        this.expiryDate = expiryDate;
    }

    public static /* synthetic */ MemberBriefInfo copy$default(MemberBriefInfo memberBriefInfo, boolean z11, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = memberBriefInfo.isActive;
        }
        if ((i12 & 2) != 0) {
            i11 = memberBriefInfo.memberType;
        }
        if ((i12 & 4) != 0) {
            str = memberBriefInfo.expiryDate;
        }
        return memberBriefInfo.copy(z11, i11, str);
    }

    public final boolean component1() {
        return this.isActive;
    }

    public final int component2() {
        return this.memberType;
    }

    public final String component3() {
        return this.expiryDate;
    }

    public final MemberBriefInfo copy(boolean z11, int i11, String expiryDate) {
        Intrinsics.g(expiryDate, "expiryDate");
        return new MemberBriefInfo(z11, i11, expiryDate);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberBriefInfo)) {
            return false;
        }
        MemberBriefInfo memberBriefInfo = (MemberBriefInfo) obj;
        return this.isActive == memberBriefInfo.isActive && this.memberType == memberBriefInfo.memberType && Intrinsics.b(this.expiryDate, memberBriefInfo.expiryDate);
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final int getMemberType() {
        return this.memberType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z11 = this.isActive;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (((r11 * 31) + this.memberType) * 31) + this.expiryDate.hashCode();
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z11) {
        this.isActive = z11;
    }

    public final void setExpiryDate(String str) {
        Intrinsics.g(str, "<set-?>");
        this.expiryDate = str;
    }

    public final void setMemberType(int i11) {
        this.memberType = i11;
    }

    public String toString() {
        return "MemberBriefInfo(isActive=" + this.isActive + ", memberType=" + this.memberType + ", expiryDate=" + this.expiryDate + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.isActive ? 1 : 0);
        out.writeInt(this.memberType);
        out.writeString(this.expiryDate);
    }
}
