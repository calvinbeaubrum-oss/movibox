package dw;

import kotlin.Metadata;

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
    public String f63542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f63543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f63544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f63545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f63546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f63547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63548g;

    public final long a() {
        return this.f63545d;
    }

    public final int b() {
        return this.f63548g;
    }

    public final String c() {
        return this.f63542a;
    }

    public final long d() {
        return this.f63546e;
    }

    public final String e() {
        return this.f63543b;
    }

    public final int f() {
        return this.f63547f;
    }

    public final void g(String str) {
        this.f63544c = str;
    }

    public final void h(long j11) {
        this.f63545d = j11;
    }

    public final void i(int i11) {
        this.f63548g = i11;
    }

    public final void j(String str) {
        this.f63542a = str;
    }

    public final void k(long j11) {
        this.f63546e = j11;
    }

    public final void l(String str) {
        this.f63543b = str;
    }

    public final void m(int i11) {
        this.f63547f = i11;
    }
}
