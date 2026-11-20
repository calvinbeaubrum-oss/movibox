package com.transsion.baseui.music;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f51438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f51439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f51440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f51441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f51442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f51443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f51444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f51445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f51446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f51447j;

    public k() {
        this(null, null, null, 0L, 0L, 0L, 0L, 0L, 0, 0, 1023, null);
    }

    public k(String str, String str2, String str3, long j11, long j12, long j13, long j14, long j15, int i11, int i12) {
        this.f51438a = str;
        this.f51439b = str2;
        this.f51440c = str3;
        this.f51441d = j11;
        this.f51442e = j12;
        this.f51443f = j13;
        this.f51444g = j14;
        this.f51445h = j15;
        this.f51446i = i11;
        this.f51447j = i12;
    }

    public /* synthetic */ k(String str, String str2, String str3, long j11, long j12, long j13, long j14, long j15, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? null : str2, (i13 & 4) == 0 ? str3 : null, (i13 & 8) != 0 ? 0L : j11, (i13 & 16) != 0 ? 0L : j12, (i13 & 32) != 0 ? 0L : j13, (i13 & 64) != 0 ? 0L : j14, (i13 & 128) == 0 ? j15 : 0L, (i13 & 256) != 0 ? 0 : i11, (i13 & 512) == 0 ? i12 : 0);
    }

    public final int a() {
        return this.f51447j;
    }

    public final long b() {
        return this.f51444g;
    }

    public final long c() {
        return this.f51445h;
    }

    public final String d() {
        return this.f51438a;
    }

    public final String e() {
        return this.f51439b;
    }

    public final long f() {
        return this.f51442e;
    }

    public final long g() {
        return this.f51441d;
    }

    public final String h() {
        return this.f51440c;
    }

    public final long i() {
        return this.f51443f;
    }

    public final int j() {
        return this.f51446i;
    }

    public final void k(int i11) {
        this.f51447j = i11;
    }

    public final void l(long j11) {
        this.f51444g = j11;
    }

    public final void m(long j11) {
        this.f51445h = j11;
    }

    public final void n(String str) {
        this.f51439b = str;
    }

    public final void o(long j11) {
        this.f51442e = j11;
    }

    public final void p(long j11) {
        this.f51441d = j11;
    }

    public final void q(String str) {
        this.f51440c = str;
    }

    public final void r(long j11) {
        this.f51443f = j11;
    }

    public final void s(int i11) {
        this.f51446i = i11;
    }
}
