package androidx.compose.animation.core;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
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
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1.i f2084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<s0<?, ?>, Float> f2085b;

    static {
        Float fValueOf = Float.valueOf(0.5f);
        f2084a = new y1.i(0.5f, 0.5f, 0.5f, 0.5f);
        s0<Integer, k> s0VarC = VectorConvertersKt.c(IntCompanionObject.f68905a);
        Float fValueOf2 = Float.valueOf(1.0f);
        s0<q2.i, k> s0VarD = VectorConvertersKt.d(q2.i.f74232b);
        Float fValueOf3 = Float.valueOf(0.1f);
        f2085b = kotlin.collections.s.k(TuplesKt.a(s0VarC, fValueOf2), TuplesKt.a(VectorConvertersKt.g(q2.t.f74253b), fValueOf2), TuplesKt.a(VectorConvertersKt.f(q2.p.f74244b), fValueOf2), TuplesKt.a(VectorConvertersKt.b(FloatCompanionObject.f68904a), Float.valueOf(0.01f)), TuplesKt.a(VectorConvertersKt.i(y1.i.f81075e), fValueOf), TuplesKt.a(VectorConvertersKt.j(y1.m.f81091b), fValueOf), TuplesKt.a(VectorConvertersKt.h(y1.g.f81070b), fValueOf), TuplesKt.a(s0VarD, fValueOf3), TuplesKt.a(VectorConvertersKt.e(q2.k.f74237b), fValueOf3));
    }

    public static final float a(q2.i.a aVar) {
        return q2.i.h(0.1f);
    }

    public static final long b(q2.p.a aVar) {
        return q2.q.a(1, 1);
    }

    public static final long c(y1.g.a aVar) {
        return y1.h.a(0.5f, 0.5f);
    }

    public static final long d(y1.m.a aVar) {
        return y1.n.a(0.5f, 0.5f);
    }

    public static final y1.i e(y1.i.a aVar) {
        return f2084a;
    }
}
