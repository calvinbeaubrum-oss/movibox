package com.transsion.player.longvideo.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f54394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f54395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f54396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f54397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f54398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f54399l;

    public b() {
        this(null, null, null, null, null, null, null, null, 0, 0, 0, 0, UnixStat.PERM_MASK, null);
    }

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, int i12, int i13, int i14) {
        this.f54388a = str;
        this.f54389b = str2;
        this.f54390c = str3;
        this.f54391d = str4;
        this.f54392e = str5;
        this.f54393f = str6;
        this.f54394g = str7;
        this.f54395h = str8;
        this.f54396i = i11;
        this.f54397j = i12;
        this.f54398k = i13;
        this.f54399l = i14;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? null : str, (i15 & 2) != 0 ? null : str2, (i15 & 4) != 0 ? null : str3, (i15 & 8) != 0 ? null : str4, (i15 & 16) != 0 ? null : str5, (i15 & 32) != 0 ? null : str6, (i15 & 64) != 0 ? null : str7, (i15 & 128) == 0 ? str8 : null, (i15 & 256) != 0 ? 3 : i11, (i15 & 512) == 0 ? i12 : 3, (i15 & 1024) != 0 ? 24 : i13, (i15 & 2048) != 0 ? 10 : i14);
    }

    public final String a() {
        return this.f54393f;
    }

    public final String b() {
        return this.f54394g;
    }

    public final int c() {
        return this.f54398k;
    }

    public final int d() {
        return this.f54397j;
    }

    public final String e() {
        return this.f54390c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.b(this.f54388a, bVar.f54388a) && Intrinsics.b(this.f54389b, bVar.f54389b) && Intrinsics.b(this.f54390c, bVar.f54390c) && Intrinsics.b(this.f54391d, bVar.f54391d) && Intrinsics.b(this.f54392e, bVar.f54392e) && Intrinsics.b(this.f54393f, bVar.f54393f) && Intrinsics.b(this.f54394g, bVar.f54394g) && Intrinsics.b(this.f54395h, bVar.f54395h) && this.f54396i == bVar.f54396i && this.f54397j == bVar.f54397j && this.f54398k == bVar.f54398k && this.f54399l == bVar.f54399l;
    }

    public final String f() {
        return this.f54389b;
    }

    public final String g() {
        return this.f54388a;
    }

    public final String h() {
        return this.f54395h;
    }

    public int hashCode() {
        String str = this.f54388a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f54389b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f54390c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f54391d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f54392e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f54393f;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f54394g;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f54395h;
        return ((((((((iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.f54396i) * 31) + this.f54397j) * 31) + this.f54398k) * 31) + this.f54399l;
    }

    public final int i() {
        return this.f54396i;
    }

    public final int j() {
        return this.f54399l;
    }

    public final String k() {
        return this.f54392e;
    }

    public final String l() {
        return this.f54391d;
    }

    public String toString() {
        return "DataOperator(layoutTitle=" + this.f54388a + ", layoutTips=" + this.f54389b + ", layoutButton=" + this.f54390c + ", title=" + this.f54391d + ", tips=" + this.f54392e + ", button=" + this.f54393f + ", buttonIcon=" + this.f54394g + ", link=" + this.f54395h + ", normalDelay=" + this.f54396i + ", fullscreenDelay=" + this.f54397j + ", displayInterval=" + this.f54398k + ", showDuration=" + this.f54399l + ")";
    }
}
