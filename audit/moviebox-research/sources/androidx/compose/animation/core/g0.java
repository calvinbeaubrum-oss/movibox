package androidx.compose.animation.core;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class g0 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f2083d;

    public g0() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public g0(float f11, float f12, float f13) {
        this.f2080a = f11;
        this.f2081b = f12;
        this.f2082c = f13;
        m0 m0Var = new m0(1.0f);
        m0Var.d(f11);
        m0Var.f(f12);
        this.f2083d = m0Var;
    }

    public /* synthetic */ g0(float f11, float f12, float f13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 1500.0f : f12, (i11 & 4) != 0 ? 0.01f : f13);
    }

    @Override // androidx.compose.animation.core.e0, androidx.compose.animation.core.g
    public /* synthetic */ c1 a(s0 s0Var) {
        return d0.c(this, s0Var);
    }

    @Override // androidx.compose.animation.core.g
    public /* bridge */ /* synthetic */ v0 a(s0 s0Var) {
        return a(s0Var);
    }

    @Override // androidx.compose.animation.core.e0
    public float b(float f11, float f12, float f13) {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.e0
    public float c(long j11, float f11, float f12, float f13) {
        this.f2083d.e(f12);
        return i0.b(this.f2083d.g(f11, f13, j11 / 1000000));
    }

    @Override // androidx.compose.animation.core.e0
    public float d(long j11, float f11, float f12, float f13) {
        this.f2083d.e(f12);
        return i0.c(this.f2083d.g(f11, f13, j11 / 1000000));
    }

    @Override // androidx.compose.animation.core.e0
    public long e(float f11, float f12, float f13) {
        float fB = this.f2083d.b();
        float fA = this.f2083d.a();
        float f14 = f11 - f12;
        float f15 = this.f2082c;
        return l0.b(fB, fA, f13 / f15, f14 / f15, 1.0f) * 1000000;
    }
}
