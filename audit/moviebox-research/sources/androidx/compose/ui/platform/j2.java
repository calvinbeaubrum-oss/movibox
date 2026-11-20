package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.q4;
import androidx.compose.ui.graphics.u4;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
public final class j2 {
    public static final boolean a(y1.k kVar) {
        return y1.a.d(kVar.h()) + y1.a.d(kVar.i()) <= kVar.j() && y1.a.d(kVar.b()) + y1.a.d(kVar.c()) <= kVar.j() && y1.a.e(kVar.h()) + y1.a.e(kVar.b()) <= kVar.d() && y1.a.e(kVar.i()) + y1.a.e(kVar.c()) <= kVar.d();
    }

    public static final boolean b(m4 m4Var, float f11, float f12, Path path, Path path2) {
        if (m4Var instanceof m4.b) {
            return e(((m4.b) m4Var).b(), f11, f12);
        }
        if (m4Var instanceof m4.c) {
            return f((m4.c) m4Var, f11, f12, path, path2);
        }
        if (m4Var instanceof m4.a) {
            return d(((m4.a) m4Var).b(), f11, f12, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean c(m4 m4Var, float f11, float f12, Path path, Path path2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            path = null;
        }
        if ((i11 & 16) != 0) {
            path2 = null;
        }
        return b(m4Var, f11, f12, path, path2);
    }

    public static final boolean d(Path path, float f11, float f12, Path path2, Path path3) {
        y1.i iVar = new y1.i(f11 - 0.005f, f12 - 0.005f, f11 + 0.005f, f12 + 0.005f);
        if (path2 == null) {
            path2 = androidx.compose.ui.graphics.z0.a();
        }
        q4.a(path2, iVar, null, 2, null);
        if (path3 == null) {
            path3 = androidx.compose.ui.graphics.z0.a();
        }
        path3.l(path, path2, u4.f4354a.b());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }

    public static final boolean e(y1.i iVar, float f11, float f12) {
        return iVar.f() <= f11 && f11 < iVar.g() && iVar.i() <= f12 && f12 < iVar.c();
    }

    public static final boolean f(m4.c cVar, float f11, float f12, Path path, Path path2) {
        y1.k kVarB = cVar.b();
        if (f11 < kVarB.e() || f11 >= kVarB.f() || f12 < kVarB.g() || f12 >= kVarB.a()) {
            return false;
        }
        if (!a(kVarB)) {
            Path pathA = path2 == null ? androidx.compose.ui.graphics.z0.a() : path2;
            q4.b(pathA, kVarB, null, 2, null);
            return d(pathA, f11, f12, path, path2);
        }
        float fD = y1.a.d(kVarB.h()) + kVarB.e();
        float fE = y1.a.e(kVarB.h()) + kVarB.g();
        float f13 = kVarB.f() - y1.a.d(kVarB.i());
        float fE2 = y1.a.e(kVarB.i()) + kVarB.g();
        float f14 = kVarB.f() - y1.a.d(kVarB.c());
        float fA = kVarB.a() - y1.a.e(kVarB.c());
        float fA2 = kVarB.a() - y1.a.e(kVarB.b());
        float fD2 = y1.a.d(kVarB.b()) + kVarB.e();
        if (f11 < fD && f12 < fE) {
            return g(f11, f12, kVarB.h(), fD, fE);
        }
        if (f11 < fD2 && f12 > fA2) {
            return g(f11, f12, kVarB.b(), fD2, fA2);
        }
        if (f11 > f13 && f12 < fE2) {
            return g(f11, f12, kVarB.i(), f13, fE2);
        }
        if (f11 <= f14 || f12 <= fA) {
            return true;
        }
        return g(f11, f12, kVarB.c(), f14, fA);
    }

    public static final boolean g(float f11, float f12, long j11, float f13, float f14) {
        float f15 = f11 - f13;
        float f16 = f12 - f14;
        float fD = y1.a.d(j11);
        float fE = y1.a.e(j11);
        return ((f15 * f15) / (fD * fD)) + ((f16 * f16) / (fE * fE)) <= 1.0f;
    }
}
