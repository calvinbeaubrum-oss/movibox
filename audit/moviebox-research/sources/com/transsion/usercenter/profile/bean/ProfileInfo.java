package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class ProfileInfo implements Serializable {
    private final BlockInfo blockInfo;
    private FissionState fissionState;
    private final Group myGroup;
    private final Subject mySubject;
    private final UserInfo userInfo;

    public ProfileInfo(UserInfo userInfo, Group group, Subject mySubject, BlockInfo blockInfo) {
        Intrinsics.g(userInfo, "userInfo");
        Intrinsics.g(mySubject, "mySubject");
        Intrinsics.g(blockInfo, "blockInfo");
        this.userInfo = userInfo;
        this.myGroup = group;
        this.mySubject = mySubject;
        this.blockInfo = blockInfo;
    }

    public static /* synthetic */ ProfileInfo copy$default(ProfileInfo profileInfo, UserInfo userInfo, Group group, Subject subject, BlockInfo blockInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            userInfo = profileInfo.userInfo;
        }
        if ((i11 & 2) != 0) {
            group = profileInfo.myGroup;
        }
        if ((i11 & 4) != 0) {
            subject = profileInfo.mySubject;
        }
        if ((i11 & 8) != 0) {
            blockInfo = profileInfo.blockInfo;
        }
        return profileInfo.copy(userInfo, group, subject, blockInfo);
    }

    public final UserInfo component1() {
        return this.userInfo;
    }

    public final Group component2() {
        return this.myGroup;
    }

    public final Subject component3() {
        return this.mySubject;
    }

    public final BlockInfo component4() {
        return this.blockInfo;
    }

    public final ProfileInfo copy(UserInfo userInfo, Group group, Subject mySubject, BlockInfo blockInfo) {
        Intrinsics.g(userInfo, "userInfo");
        Intrinsics.g(mySubject, "mySubject");
        Intrinsics.g(blockInfo, "blockInfo");
        return new ProfileInfo(userInfo, group, mySubject, blockInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileInfo)) {
            return false;
        }
        ProfileInfo profileInfo = (ProfileInfo) obj;
        return Intrinsics.b(this.userInfo, profileInfo.userInfo) && Intrinsics.b(this.myGroup, profileInfo.myGroup) && Intrinsics.b(this.mySubject, profileInfo.mySubject) && Intrinsics.b(this.blockInfo, profileInfo.blockInfo);
    }

    public final BlockInfo getBlockInfo() {
        return this.blockInfo;
    }

    public final FissionState getFissionState() {
        return this.fissionState;
    }

    public final Group getMyGroup() {
        return this.myGroup;
    }

    public final String getMyGroupIconByIndex(int i11) {
        Group group;
        List<GroupAvatar> groups;
        GroupAvatar groupAvatar;
        List<GroupAvatar> groups2;
        Group group2 = this.myGroup;
        if (i11 >= ((group2 == null || (groups2 = group2.getGroups()) == null) ? 0 : groups2.size()) || (group = this.myGroup) == null || (groups = group.getGroups()) == null || (groupAvatar = groups.get(i11)) == null) {
            return null;
        }
        return groupAvatar.getAvatar();
    }

    public final Subject getMySubject() {
        return this.mySubject;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        int iHashCode = this.userInfo.hashCode() * 31;
        Group group = this.myGroup;
        return ((((iHashCode + (group == null ? 0 : group.hashCode())) * 31) + this.mySubject.hashCode()) * 31) + this.blockInfo.hashCode();
    }

    public final boolean isVisitor() {
        return this.userInfo.getUserType() == 0;
    }

    public final void setFissionState(FissionState fissionState) {
        this.fissionState = fissionState;
    }

    public String toString() {
        return "ProfileInfo(userInfo=" + this.userInfo + ", myGroup=" + this.myGroup + ", mySubject=" + this.mySubject + ", blockInfo=" + this.blockInfo + ")";
    }
}
