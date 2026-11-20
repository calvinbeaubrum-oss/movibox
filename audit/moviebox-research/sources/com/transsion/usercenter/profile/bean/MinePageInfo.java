package com.transsion.usercenter.profile.bean;

import com.transsion.memberapi.MemberInfo;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
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
@Metadata
public final class MinePageInfo implements Serializable {
    private final BlockInfo blockInfo;
    private final CountInfo myComment;
    private final MyGroup myGroup;
    private final CountInfo myLike;
    private final CountInfo myPost;
    private final MySubject mySubject;
    private final MineNovel novelEntry;
    private final UserInfo userInfo;
    private final MemberInfo vipInfo;

    public MinePageInfo(UserInfo userInfo, MyGroup myGroup, MineNovel mineNovel, MySubject mySubject, BlockInfo blockInfo, MemberInfo memberInfo, CountInfo countInfo, CountInfo countInfo2, CountInfo countInfo3) {
        this.userInfo = userInfo;
        this.myGroup = myGroup;
        this.novelEntry = mineNovel;
        this.mySubject = mySubject;
        this.blockInfo = blockInfo;
        this.vipInfo = memberInfo;
        this.myPost = countInfo;
        this.myLike = countInfo2;
        this.myComment = countInfo3;
    }

    public final UserInfo component1() {
        return this.userInfo;
    }

    public final MyGroup component2() {
        return this.myGroup;
    }

    public final MineNovel component3() {
        return this.novelEntry;
    }

    public final MySubject component4() {
        return this.mySubject;
    }

    public final BlockInfo component5() {
        return this.blockInfo;
    }

    public final MemberInfo component6() {
        return this.vipInfo;
    }

    public final CountInfo component7() {
        return this.myPost;
    }

    public final CountInfo component8() {
        return this.myLike;
    }

    public final CountInfo component9() {
        return this.myComment;
    }

    public final MinePageInfo copy(UserInfo userInfo, MyGroup myGroup, MineNovel mineNovel, MySubject mySubject, BlockInfo blockInfo, MemberInfo memberInfo, CountInfo countInfo, CountInfo countInfo2, CountInfo countInfo3) {
        return new MinePageInfo(userInfo, myGroup, mineNovel, mySubject, blockInfo, memberInfo, countInfo, countInfo2, countInfo3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MinePageInfo)) {
            return false;
        }
        MinePageInfo minePageInfo = (MinePageInfo) obj;
        return Intrinsics.b(this.userInfo, minePageInfo.userInfo) && Intrinsics.b(this.myGroup, minePageInfo.myGroup) && Intrinsics.b(this.novelEntry, minePageInfo.novelEntry) && Intrinsics.b(this.mySubject, minePageInfo.mySubject) && Intrinsics.b(this.blockInfo, minePageInfo.blockInfo) && Intrinsics.b(this.vipInfo, minePageInfo.vipInfo) && Intrinsics.b(this.myPost, minePageInfo.myPost) && Intrinsics.b(this.myLike, minePageInfo.myLike) && Intrinsics.b(this.myComment, minePageInfo.myComment);
    }

    public final BlockInfo getBlockInfo() {
        return this.blockInfo;
    }

    public final CountInfo getMyComment() {
        return this.myComment;
    }

    public final MyGroup getMyGroup() {
        return this.myGroup;
    }

    public final CountInfo getMyLike() {
        return this.myLike;
    }

    public final CountInfo getMyPost() {
        return this.myPost;
    }

    public final MySubject getMySubject() {
        return this.mySubject;
    }

    public final MineNovel getNovelEntry() {
        return this.novelEntry;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final MemberInfo getVipInfo() {
        return this.vipInfo;
    }

    public int hashCode() {
        UserInfo userInfo = this.userInfo;
        int iHashCode = (userInfo == null ? 0 : userInfo.hashCode()) * 31;
        MyGroup myGroup = this.myGroup;
        int iHashCode2 = (iHashCode + (myGroup == null ? 0 : myGroup.hashCode())) * 31;
        MineNovel mineNovel = this.novelEntry;
        int iHashCode3 = (iHashCode2 + (mineNovel == null ? 0 : mineNovel.hashCode())) * 31;
        MySubject mySubject = this.mySubject;
        int iHashCode4 = (iHashCode3 + (mySubject == null ? 0 : mySubject.hashCode())) * 31;
        BlockInfo blockInfo = this.blockInfo;
        int iHashCode5 = (iHashCode4 + (blockInfo == null ? 0 : blockInfo.hashCode())) * 31;
        MemberInfo memberInfo = this.vipInfo;
        int iHashCode6 = (iHashCode5 + (memberInfo == null ? 0 : memberInfo.hashCode())) * 31;
        CountInfo countInfo = this.myPost;
        int iHashCode7 = (iHashCode6 + (countInfo == null ? 0 : countInfo.hashCode())) * 31;
        CountInfo countInfo2 = this.myLike;
        int iHashCode8 = (iHashCode7 + (countInfo2 == null ? 0 : countInfo2.hashCode())) * 31;
        CountInfo countInfo3 = this.myComment;
        return iHashCode8 + (countInfo3 != null ? countInfo3.hashCode() : 0);
    }

    public String toString() {
        return "MinePageInfo(userInfo=" + this.userInfo + ", myGroup=" + this.myGroup + ", novelEntry=" + this.novelEntry + ", mySubject=" + this.mySubject + ", blockInfo=" + this.blockInfo + ", vipInfo=" + this.vipInfo + ", myPost=" + this.myPost + ", myLike=" + this.myLike + ", myComment=" + this.myComment + ")";
    }
}
