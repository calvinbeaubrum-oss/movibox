package com.transsion.usercenter.profile.see.bean;

import com.google.gson.annotations.SerializedName;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProfileSeeItem implements Serializable {

    @SerializedName("staff")
    private final ProfileSeeStaffItem staff;

    @SerializedName("subject")
    private final ProfileSeeSubjectItem subject;

    @SerializedName("type")
    private final Integer type;

    public ProfileSeeItem(Integer num, ProfileSeeSubjectItem profileSeeSubjectItem, ProfileSeeStaffItem profileSeeStaffItem) {
        this.type = num;
        this.subject = profileSeeSubjectItem;
        this.staff = profileSeeStaffItem;
    }

    public /* synthetic */ ProfileSeeItem(Integer num, ProfileSeeSubjectItem profileSeeSubjectItem, ProfileSeeStaffItem profileSeeStaffItem, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i11 & 2) != 0 ? null : profileSeeSubjectItem, (i11 & 4) != 0 ? null : profileSeeStaffItem);
    }

    public static /* synthetic */ ProfileSeeItem copy$default(ProfileSeeItem profileSeeItem, Integer num, ProfileSeeSubjectItem profileSeeSubjectItem, ProfileSeeStaffItem profileSeeStaffItem, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = profileSeeItem.type;
        }
        if ((i11 & 2) != 0) {
            profileSeeSubjectItem = profileSeeItem.subject;
        }
        if ((i11 & 4) != 0) {
            profileSeeStaffItem = profileSeeItem.staff;
        }
        return profileSeeItem.copy(num, profileSeeSubjectItem, profileSeeStaffItem);
    }

    public final Integer component1() {
        return this.type;
    }

    public final ProfileSeeSubjectItem component2() {
        return this.subject;
    }

    public final ProfileSeeStaffItem component3() {
        return this.staff;
    }

    public final ProfileSeeItem copy(Integer num, ProfileSeeSubjectItem profileSeeSubjectItem, ProfileSeeStaffItem profileSeeStaffItem) {
        return new ProfileSeeItem(num, profileSeeSubjectItem, profileSeeStaffItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileSeeItem)) {
            return false;
        }
        ProfileSeeItem profileSeeItem = (ProfileSeeItem) obj;
        return Intrinsics.b(this.type, profileSeeItem.type) && Intrinsics.b(this.subject, profileSeeItem.subject) && Intrinsics.b(this.staff, profileSeeItem.staff);
    }

    public final ProfileSeeStaffItem getStaff() {
        return this.staff;
    }

    public final ProfileSeeSubjectItem getSubject() {
        return this.subject;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        ProfileSeeSubjectItem profileSeeSubjectItem = this.subject;
        int iHashCode2 = (iHashCode + (profileSeeSubjectItem == null ? 0 : profileSeeSubjectItem.hashCode())) * 31;
        ProfileSeeStaffItem profileSeeStaffItem = this.staff;
        return iHashCode2 + (profileSeeStaffItem != null ? profileSeeStaffItem.hashCode() : 0);
    }

    public String toString() {
        return "ProfileSeeItem(type=" + this.type + ", subject=" + this.subject + ", staff=" + this.staff + ")";
    }
}
