package com.transsion.member;

import com.transsion.member.bean.request.MemberPromoCodeRes;
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
@Metadata
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MemberPromoCodeRes f53347d;

    public i(boolean z11, String str, String str2, MemberPromoCodeRes memberPromoCodeRes) {
        this.f53344a = z11;
        this.f53345b = str;
        this.f53346c = str2;
        this.f53347d = memberPromoCodeRes;
    }

    public final String a() {
        return this.f53345b;
    }

    public final MemberPromoCodeRes b() {
        return this.f53347d;
    }

    public final boolean c() {
        return this.f53344a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f53344a == iVar.f53344a && Intrinsics.b(this.f53345b, iVar.f53345b) && Intrinsics.b(this.f53346c, iVar.f53346c) && Intrinsics.b(this.f53347d, iVar.f53347d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z11 = this.f53344a;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.f53345b;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f53346c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        MemberPromoCodeRes memberPromoCodeRes = this.f53347d;
        return iHashCode2 + (memberPromoCodeRes != null ? memberPromoCodeRes.hashCode() : 0);
    }

    public String toString() {
        return "PromoCodeRes(res=" + this.f53344a + ", code=" + this.f53345b + ", message=" + this.f53346c + ", data=" + this.f53347d + ")";
    }
}
