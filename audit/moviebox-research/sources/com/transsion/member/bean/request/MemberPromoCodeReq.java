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
public final class MemberPromoCodeReq implements Serializable {
    public static final int $stable = 0;
    private final String code;

    public MemberPromoCodeReq(String code) {
        Intrinsics.g(code, "code");
        this.code = code;
    }

    public static /* synthetic */ MemberPromoCodeReq copy$default(MemberPromoCodeReq memberPromoCodeReq, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = memberPromoCodeReq.code;
        }
        return memberPromoCodeReq.copy(str);
    }

    public final String component1() {
        return this.code;
    }

    public final MemberPromoCodeReq copy(String code) {
        Intrinsics.g(code, "code");
        return new MemberPromoCodeReq(code);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MemberPromoCodeReq) && Intrinsics.b(this.code, ((MemberPromoCodeReq) obj).code);
    }

    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public String toString() {
        return "MemberPromoCodeReq(code=" + this.code + ")";
    }
}
