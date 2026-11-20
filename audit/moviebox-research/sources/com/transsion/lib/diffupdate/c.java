package com.transsion.lib.diffupdate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f53028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f53030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f53031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f53032h;

    public c(boolean z11, String patchUrl, String patchMd5, long j11, String installPkgUrl, long j12, String installPkgMd5, long j13) {
        Intrinsics.g(patchUrl, "patchUrl");
        Intrinsics.g(patchMd5, "patchMd5");
        Intrinsics.g(installPkgUrl, "installPkgUrl");
        Intrinsics.g(installPkgMd5, "installPkgMd5");
        this.f53025a = z11;
        this.f53026b = patchUrl;
        this.f53027c = patchMd5;
        this.f53028d = j11;
        this.f53029e = installPkgUrl;
        this.f53030f = j12;
        this.f53031g = installPkgMd5;
        this.f53032h = j13;
    }

    public final boolean a() {
        return this.f53025a;
    }

    public final String b() {
        return this.f53031g;
    }

    public final long c() {
        return this.f53032h;
    }

    public final String d() {
        return this.f53029e;
    }

    public final String e() {
        return this.f53027c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f53025a == cVar.f53025a && Intrinsics.b(this.f53026b, cVar.f53026b) && Intrinsics.b(this.f53027c, cVar.f53027c) && this.f53028d == cVar.f53028d && Intrinsics.b(this.f53029e, cVar.f53029e) && this.f53030f == cVar.f53030f && Intrinsics.b(this.f53031g, cVar.f53031g) && this.f53032h == cVar.f53032h;
    }

    public final long f() {
        return this.f53028d;
    }

    public final String g() {
        return this.f53026b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean z11 = this.f53025a;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (((((((((((((r11 * 31) + this.f53026b.hashCode()) * 31) + this.f53027c.hashCode()) * 31) + p.a(this.f53028d)) * 31) + this.f53029e.hashCode()) * 31) + p.a(this.f53030f)) * 31) + this.f53031g.hashCode()) * 31) + p.a(this.f53032h);
    }

    public String toString() {
        return "RemoteVersionInfo(hasUpdate=" + this.f53025a + ", patchUrl=" + this.f53026b + ", patchMd5=" + this.f53027c + ", patchSize=" + this.f53028d + ", installPkgUrl=" + this.f53029e + ", installPkgVersionCode=" + this.f53030f + ", installPkgMd5=" + this.f53031g + ", installPkgSize=" + this.f53032h + ')';
    }
}
