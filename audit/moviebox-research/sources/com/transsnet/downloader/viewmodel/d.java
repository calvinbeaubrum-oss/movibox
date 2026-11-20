package com.transsnet.downloader.viewmodel;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f61280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f61281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f61282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f61283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f61284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f61285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f61286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f61287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f61288i;

    public d(int i11, String str, String str2, String str3, Long l11, Long l12, Long l13, int i12, int i13) {
        this.f61280a = i11;
        this.f61281b = str;
        this.f61282c = str2;
        this.f61283d = str3;
        this.f61284e = l11;
        this.f61285f = l12;
        this.f61286g = l13;
        this.f61287h = i12;
        this.f61288i = i13;
    }

    public final Long a() {
        return this.f61286g;
    }

    public final int b() {
        return this.f61288i;
    }

    public final int c() {
        return this.f61280a;
    }

    public final String d() {
        return this.f61282c;
    }

    public final String e() {
        return this.f61281b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f61280a == dVar.f61280a && Intrinsics.b(this.f61281b, dVar.f61281b) && Intrinsics.b(this.f61282c, dVar.f61282c) && Intrinsics.b(this.f61283d, dVar.f61283d) && Intrinsics.b(this.f61284e, dVar.f61284e) && Intrinsics.b(this.f61285f, dVar.f61285f) && Intrinsics.b(this.f61286g, dVar.f61286g) && this.f61287h == dVar.f61287h && this.f61288i == dVar.f61288i;
    }

    public final int f() {
        return this.f61287h;
    }

    public int hashCode() {
        int i11 = this.f61280a * 31;
        String str = this.f61281b;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f61282c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f61283d;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l11 = this.f61284e;
        int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.f61285f;
        int iHashCode5 = (iHashCode4 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.f61286g;
        return ((((iHashCode5 + (l13 != null ? l13.hashCode() : 0)) * 31) + this.f61287h) * 31) + this.f61288i;
    }

    public String toString() {
        return "Video(id=" + this.f61280a + ", path=" + this.f61281b + ", name=" + this.f61282c + ", resolution=" + this.f61283d + ", size=" + this.f61284e + ", date=" + this.f61285f + ", duration=" + this.f61286g + ", width=" + this.f61287h + ", height=" + this.f61288i + ")";
    }
}
