package androidx.compose.animation.core;

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
public final class h0 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f2088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f2090e;

    public h0(int i11, int i12, z zVar) {
        this.f2086a = i11;
        this.f2087b = i12;
        this.f2088c = zVar;
        this.f2089d = ((long) i11) * 1000000;
        this.f2090e = ((long) i12) * 1000000;
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
    public /* synthetic */ float b(float f11, float f12, float f13) {
        return d0.a(this, f11, f12, f13);
    }

    @Override // androidx.compose.animation.core.e0
    public float c(long j11, float f11, float f12, float f13) {
        float f14 = this.f2086a == 0 ? 1.0f : f(j11) / this.f2089d;
        z zVar = this.f2088c;
        if (f14 < 0.0f) {
            f14 = 0.0f;
        }
        return VectorConvertersKt.k(f11, f12, zVar.a(f14 <= 1.0f ? f14 : 1.0f));
    }

    @Override // androidx.compose.animation.core.e0
    public float d(long j11, float f11, float f12, float f13) {
        long jF = f(j11);
        if (jF < 0) {
            return 0.0f;
        }
        if (jF == 0) {
            return f13;
        }
        return (c(jF, f11, f12, f13) - c(jF - 1000000, f11, f12, f13)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.e0
    public long e(float f11, float f12, float f13) {
        return ((long) (this.f2087b + this.f2086a)) * 1000000;
    }

    public final long f(long j11) {
        return kotlin.ranges.a.l(j11 - this.f2090e, 0L, this.f2089d);
    }
}
