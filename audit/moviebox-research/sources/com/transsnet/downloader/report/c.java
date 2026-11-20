package com.transsnet.downloader.report;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f61118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f61119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f61121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f61122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f61123f;

    public c(String str, String str2, int i11) {
        this.f61118a = str;
        this.f61119b = str2;
        this.f61120c = i11;
    }

    public final int a() {
        return this.f61123f;
    }

    public final int b() {
        return this.f61122e;
    }

    public final long c() {
        return this.f61121d;
    }

    public final void d(int i11) {
        this.f61123f = i11;
    }

    public final void e(int i11) {
        this.f61122e = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f61118a, cVar.f61118a) && Intrinsics.b(this.f61119b, cVar.f61119b) && this.f61120c == cVar.f61120c;
    }

    public final void f(long j11) {
        this.f61121d = j11;
    }

    public int hashCode() {
        String str = this.f61118a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f61119b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f61120c;
    }

    public String toString() {
        return "DownloadStat(url=" + this.f61118a + ", taskId=" + this.f61119b + ", status=" + this.f61120c + ")";
    }
}
