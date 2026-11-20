package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class n4 {
    public static final void a(z1.g gVar, m4 m4Var, l1 l1Var, float f11, z1.h hVar, x1 x1Var, int i11) {
        Path pathB;
        if (m4Var instanceof m4.b) {
            y1.i iVarB = ((m4.b) m4Var).b();
            gVar.G0(l1Var, g(iVarB), e(iVarB), f11, hVar, x1Var, i11);
            return;
        }
        if (m4Var instanceof m4.c) {
            m4.c cVar = (m4.c) m4Var;
            pathB = cVar.c();
            if (pathB == null) {
                y1.k kVarB = cVar.b();
                gVar.P(l1Var, h(kVarB), f(kVarB), y1.b.b(y1.a.d(kVarB.b()), 0.0f, 2, null), f11, hVar, x1Var, i11);
                return;
            }
        } else {
            if (!(m4Var instanceof m4.a)) {
                throw new NoWhenBranchMatchedException();
            }
            pathB = ((m4.a) m4Var).b();
        }
        gVar.N(pathB, l1Var, f11, hVar, x1Var, i11);
    }

    public static /* synthetic */ void b(z1.g gVar, m4 m4Var, l1 l1Var, float f11, z1.h hVar, x1 x1Var, int i11, int i12, Object obj) {
        float f12 = (i12 & 4) != 0 ? 1.0f : f11;
        if ((i12 & 8) != 0) {
            hVar = z1.l.f81716a;
        }
        z1.h hVar2 = hVar;
        if ((i12 & 16) != 0) {
            x1Var = null;
        }
        x1 x1Var2 = x1Var;
        if ((i12 & 32) != 0) {
            i11 = z1.g.f81712v8.a();
        }
        a(gVar, m4Var, l1Var, f12, hVar2, x1Var2, i11);
    }

    public static final void c(z1.g gVar, m4 m4Var, long j11, float f11, z1.h hVar, x1 x1Var, int i11) {
        Path pathB;
        if (m4Var instanceof m4.b) {
            y1.i iVarB = ((m4.b) m4Var).b();
            gVar.C0(j11, g(iVarB), e(iVarB), f11, hVar, x1Var, i11);
            return;
        }
        if (m4Var instanceof m4.c) {
            m4.c cVar = (m4.c) m4Var;
            pathB = cVar.c();
            if (pathB == null) {
                y1.k kVarB = cVar.b();
                gVar.c0(j11, h(kVarB), f(kVarB), y1.b.b(y1.a.d(kVarB.b()), 0.0f, 2, null), hVar, f11, x1Var, i11);
                return;
            }
        } else {
            if (!(m4Var instanceof m4.a)) {
                throw new NoWhenBranchMatchedException();
            }
            pathB = ((m4.a) m4Var).b();
        }
        gVar.j0(pathB, j11, f11, hVar, x1Var, i11);
    }

    public static final long e(y1.i iVar) {
        return y1.n.a(iVar.k(), iVar.e());
    }

    public static final long f(y1.k kVar) {
        return y1.n.a(kVar.j(), kVar.d());
    }

    public static final long g(y1.i iVar) {
        return y1.h.a(iVar.f(), iVar.i());
    }

    public static final long h(y1.k kVar) {
        return y1.h.a(kVar.e(), kVar.g());
    }
}
