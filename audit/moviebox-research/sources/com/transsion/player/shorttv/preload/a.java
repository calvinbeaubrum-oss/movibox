package com.transsion.player.shorttv.preload;

import androidx.media3.exoplayer.offline.DownloadRequest;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadRequest f54793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f54794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f54795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f54796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f54797g;

    public a(String id2, String url, DownloadRequest request, long j11, long j12, long j13, boolean z11) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(url, "url");
        Intrinsics.g(request, "request");
        this.f54791a = id2;
        this.f54792b = url;
        this.f54793c = request;
        this.f54794d = j11;
        this.f54795e = j12;
        this.f54796f = j13;
        this.f54797g = z11;
    }

    public final long a() {
        return this.f54794d;
    }

    public final long b() {
        return this.f54795e;
    }

    public final String c() {
        return this.f54791a;
    }

    public final long d() {
        return this.f54796f;
    }

    public final DownloadRequest e() {
        return this.f54793c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f54791a, aVar.f54791a) && Intrinsics.b(this.f54792b, aVar.f54792b) && Intrinsics.b(this.f54793c, aVar.f54793c) && this.f54794d == aVar.f54794d && this.f54795e == aVar.f54795e && this.f54796f == aVar.f54796f && this.f54797g == aVar.f54797g;
    }

    public final boolean f() {
        return this.f54797g;
    }

    public final void g(long j11) {
        this.f54794d = j11;
    }

    public final void h(long j11) {
        this.f54795e = j11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iHashCode = ((((((((((this.f54791a.hashCode() * 31) + this.f54792b.hashCode()) * 31) + this.f54793c.hashCode()) * 31) + p.a(this.f54794d)) * 31) + p.a(this.f54795e)) * 31) + p.a(this.f54796f)) * 31;
        boolean z11 = this.f54797g;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode + r11;
    }

    public final void i(long j11) {
        this.f54796f = j11;
    }

    public String toString() {
        return "VideoDownloadBean(id=" + this.f54791a + ", url=" + this.f54792b + ", request=" + this.f54793c + ", contentLength=" + this.f54794d + ", downloadLength=" + this.f54795e + ", maxLength=" + this.f54796f + ", isAdd=" + this.f54797g + ")";
    }
}
