package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
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
public final class j {
    public static final i<Float, k> a(float f11, float f12, long j11, long j12, boolean z11) {
        return new i<>(VectorConvertersKt.b(FloatCompanionObject.f68904a), Float.valueOf(f11), p.a(f12), j11, j12, z11);
    }

    public static final <T, V extends o> i<T, V> b(s0<T, V> s0Var, T t11, T t12, long j11, long j12, boolean z11) {
        return new i<>(s0Var, t11, s0Var.a().invoke(t12), j11, j12, z11);
    }

    public static /* synthetic */ i c(float f11, float f12, long j11, long j12, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        return a(f11, f12, (i11 & 4) != 0 ? Long.MIN_VALUE : j11, (i11 & 8) == 0 ? j12 : Long.MIN_VALUE, (i11 & 16) != 0 ? false : z11);
    }

    public static final i<Float, k> e(i<Float, k> iVar, float f11, float f12, long j11, long j12, boolean z11) {
        return new i<>(iVar.e(), Float.valueOf(f11), p.a(f12), j11, j12, z11);
    }

    public static final <T, V extends o> i<T, V> f(i<T, V> iVar, T t11, V v11, long j11, long j12, boolean z11) {
        return new i<>(iVar.e(), t11, v11, j11, j12, z11);
    }

    public static /* synthetic */ i g(i iVar, float f11, float f12, long j11, long j12, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = ((Number) iVar.getValue()).floatValue();
        }
        if ((i11 & 2) != 0) {
            f12 = ((k) iVar.g()).f();
        }
        float f13 = f12;
        if ((i11 & 4) != 0) {
            j11 = iVar.b();
        }
        long j13 = j11;
        if ((i11 & 8) != 0) {
            j12 = iVar.a();
        }
        long j14 = j12;
        if ((i11 & 16) != 0) {
            z11 = iVar.h();
        }
        return e(iVar, f11, f13, j13, j14, z11);
    }

    public static /* synthetic */ i h(i iVar, Object obj, o oVar, long j11, long j12, boolean z11, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = iVar.getValue();
        }
        if ((i11 & 2) != 0) {
            oVar = p.e(iVar.g());
        }
        o oVar2 = oVar;
        if ((i11 & 4) != 0) {
            j11 = iVar.b();
        }
        long j13 = j11;
        if ((i11 & 8) != 0) {
            j12 = iVar.a();
        }
        long j14 = j12;
        if ((i11 & 16) != 0) {
            z11 = iVar.h();
        }
        return f(iVar, obj, oVar2, j13, j14, z11);
    }

    public static final <T, V extends o> V i(s0<T, V> s0Var, T t11) {
        V vInvoke = s0Var.a().invoke(t11);
        vInvoke.d();
        return vInvoke;
    }
}
