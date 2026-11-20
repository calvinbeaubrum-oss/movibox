package y1;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f81066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f81067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f81068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f81069d;

    public e(float f11, float f12, float f13, float f14) {
        this.f81066a = f11;
        this.f81067b = f12;
        this.f81068c = f13;
        this.f81069d = f14;
    }

    public final float a() {
        return this.f81069d;
    }

    public final float b() {
        return this.f81066a;
    }

    public final float c() {
        return this.f81068c;
    }

    public final float d() {
        return this.f81067b;
    }

    public final void e(float f11, float f12, float f13, float f14) {
        this.f81066a = Math.max(f11, this.f81066a);
        this.f81067b = Math.max(f12, this.f81067b);
        this.f81068c = Math.min(f13, this.f81068c);
        this.f81069d = Math.min(f14, this.f81069d);
    }

    public final boolean f() {
        return this.f81066a >= this.f81068c || this.f81067b >= this.f81069d;
    }

    public final void g(float f11, float f12, float f13, float f14) {
        this.f81066a = f11;
        this.f81067b = f12;
        this.f81068c = f13;
        this.f81069d = f14;
    }

    public final void h(float f11) {
        this.f81069d = f11;
    }

    public final void i(float f11) {
        this.f81066a = f11;
    }

    public final void j(float f11) {
        this.f81068c = f11;
    }

    public final void k(float f11) {
        this.f81067b = f11;
    }

    public String toString() {
        return "MutableRect(" + c.a(this.f81066a, 1) + ", " + c.a(this.f81067b, 1) + ", " + c.a(this.f81068c, 1) + ", " + c.a(this.f81069d, 1) + ')';
    }
}
