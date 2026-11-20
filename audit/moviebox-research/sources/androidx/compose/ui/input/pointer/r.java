package androidx.compose.ui.input.pointer;

import kotlin.Deprecated;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class r {
    public static final boolean a(z zVar) {
        return (zVar.p() || zVar.l() || !zVar.i()) ? false : true;
    }

    public static final boolean b(z zVar) {
        return !zVar.l() && zVar.i();
    }

    public static final boolean c(z zVar) {
        return (zVar.p() || !zVar.l() || zVar.i()) ? false : true;
    }

    public static final boolean d(z zVar) {
        return zVar.l() && !zVar.i();
    }

    @Deprecated
    public static final boolean e(z zVar, long j11) {
        long jH = zVar.h();
        float fM = y1.g.m(jH);
        float fN = y1.g.n(jH);
        return fM < 0.0f || fM > ((float) q2.t.g(j11)) || fN < 0.0f || fN > ((float) q2.t.f(j11));
    }

    public static final boolean f(z zVar, long j11, long j12) {
        if (!k0.g(zVar.n(), k0.f4712a.d())) {
            return e(zVar, j11);
        }
        long jH = zVar.h();
        float fM = y1.g.m(jH);
        float fN = y1.g.n(jH);
        return fM < (-y1.m.i(j12)) || fM > ((float) q2.t.g(j11)) + y1.m.i(j12) || fN < (-y1.m.g(j12)) || fN > ((float) q2.t.f(j11)) + y1.m.g(j12);
    }

    public static final long g(z zVar) {
        return i(zVar, false);
    }

    public static final long h(z zVar) {
        return i(zVar, true);
    }

    public static final long i(z zVar, boolean z11) {
        long jQ = y1.g.q(zVar.h(), zVar.k());
        return (z11 || !zVar.p()) ? jQ : y1.g.f81070b.c();
    }

    public static final boolean j(z zVar) {
        return !y1.g.j(i(zVar, true), y1.g.f81070b.c());
    }
}
