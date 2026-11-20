package com.transsion.member.bean.request;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MemberPromoCodeRes implements Serializable {
    public static final int $stable = 0;
    private final String code;
    private final String userId;
    private final int vipDurationDays;

    public MemberPromoCodeRes(String userId, String code, int i11) {
        Intrinsics.g(userId, "userId");
        Intrinsics.g(code, "code");
        this.userId = userId;
        this.code = code;
        this.vipDurationDays = i11;
    }

    public static /* synthetic */ MemberPromoCodeRes copy$default(MemberPromoCodeRes memberPromoCodeRes, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = memberPromoCodeRes.userId;
        }
        if ((i12 & 2) != 0) {
            str2 = memberPromoCodeRes.code;
        }
        if ((i12 & 4) != 0) {
            i11 = memberPromoCodeRes.vipDurationDays;
        }
        return memberPromoCodeRes.copy(str, str2, i11);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.code;
    }

    public final int component3() {
        return this.vipDurationDays;
    }

    public final MemberPromoCodeRes copy(String userId, String code, int i11) {
        Intrinsics.g(userId, "userId");
        Intrinsics.g(code, "code");
        return new MemberPromoCodeRes(userId, code, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberPromoCodeRes)) {
            return false;
        }
        MemberPromoCodeRes memberPromoCodeRes = (MemberPromoCodeRes) obj;
        return Intrinsics.b(this.userId, memberPromoCodeRes.userId) && Intrinsics.b(this.code, memberPromoCodeRes.code) && this.vipDurationDays == memberPromoCodeRes.vipDurationDays;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getVipDurationDays() {
        return this.vipDurationDays;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.code.hashCode()) * 31) + this.vipDurationDays;
    }

    public String toString() {
        return "MemberPromoCodeRes(userId=" + this.userId + ", code=" + this.code + ", vipDurationDays=" + this.vipDurationDays + ")";
    }
}
