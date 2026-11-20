package androidx.compose.ui.text;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f6052a = q2.w.f74257b.a();

    public static final r a(r rVar, int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, v vVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar) {
        long j12;
        int iH = i11;
        androidx.compose.ui.text.style.n nVarJ = nVar;
        androidx.compose.ui.text.style.h.a aVar = androidx.compose.ui.text.style.h.f6101b;
        if (androidx.compose.ui.text.style.h.k(iH, aVar.g()) || androidx.compose.ui.text.style.h.k(iH, rVar.h())) {
            if (!q2.x.d(j11)) {
                j12 = j11;
                if (q2.w.e(j12, rVar.e())) {
                }
            } else {
                j12 = j11;
            }
            if ((nVarJ == null || Intrinsics.b(nVarJ, rVar.j())) && ((androidx.compose.ui.text.style.j.j(i12, androidx.compose.ui.text.style.j.f6115b.f()) || androidx.compose.ui.text.style.j.j(i12, rVar.i())) && ((vVar == null || Intrinsics.b(vVar, rVar.g())) && ((gVar == null || Intrinsics.b(gVar, rVar.f())) && ((androidx.compose.ui.text.style.e.f(i13, androidx.compose.ui.text.style.e.f6066b.b()) || androidx.compose.ui.text.style.e.f(i13, rVar.d())) && ((androidx.compose.ui.text.style.d.g(i14, androidx.compose.ui.text.style.d.f6061b.c()) || androidx.compose.ui.text.style.d.g(i14, rVar.c())) && (oVar == null || Intrinsics.b(oVar, rVar.k())))))))) {
                return rVar;
            }
        } else {
            j12 = j11;
        }
        long jE = q2.x.d(j11) ? rVar.e() : j12;
        if (nVarJ == null) {
            nVarJ = rVar.j();
        }
        androidx.compose.ui.text.style.n nVar2 = nVarJ;
        if (androidx.compose.ui.text.style.h.k(iH, aVar.g())) {
            iH = rVar.h();
        }
        return new r(iH, !androidx.compose.ui.text.style.j.j(i12, androidx.compose.ui.text.style.j.f6115b.f()) ? i12 : rVar.i(), jE, nVar2, b(rVar, vVar), gVar == null ? rVar.f() : gVar, !androidx.compose.ui.text.style.e.f(i13, androidx.compose.ui.text.style.e.f6066b.b()) ? i13 : rVar.d(), !androidx.compose.ui.text.style.d.g(i14, androidx.compose.ui.text.style.d.f6061b.c()) ? i14 : rVar.c(), oVar == null ? rVar.k() : oVar, null);
    }

    public static final v b(r rVar, v vVar) {
        if (rVar.g() == null) {
            return vVar;
        }
        return vVar == null ? rVar.g() : rVar.g().c(vVar);
    }

    public static final r c(r rVar, LayoutDirection layoutDirection) {
        int iH = rVar.h();
        androidx.compose.ui.text.style.h.a aVar = androidx.compose.ui.text.style.h.f6101b;
        int iF = androidx.compose.ui.text.style.h.k(iH, aVar.g()) ? aVar.f() : rVar.h();
        int iD = f0.d(layoutDirection, rVar.i());
        long jE = q2.x.d(rVar.e()) ? f6052a : rVar.e();
        androidx.compose.ui.text.style.n nVarJ = rVar.j();
        if (nVarJ == null) {
            nVarJ = androidx.compose.ui.text.style.n.f6130c.a();
        }
        androidx.compose.ui.text.style.n nVar = nVarJ;
        v vVarG = rVar.g();
        androidx.compose.ui.text.style.g gVarF = rVar.f();
        int iD2 = rVar.d();
        androidx.compose.ui.text.style.e.a aVar2 = androidx.compose.ui.text.style.e.f6066b;
        int iA = androidx.compose.ui.text.style.e.f(iD2, aVar2.b()) ? aVar2.a() : rVar.d();
        int iC = rVar.c();
        androidx.compose.ui.text.style.d.a aVar3 = androidx.compose.ui.text.style.d.f6061b;
        int iB = androidx.compose.ui.text.style.d.g(iC, aVar3.c()) ? aVar3.b() : rVar.c();
        androidx.compose.ui.text.style.o oVarK = rVar.k();
        if (oVarK == null) {
            oVarK = androidx.compose.ui.text.style.o.f6134c.a();
        }
        return new r(iF, iD, jE, nVar, vVarG, gVarF, iA, iB, oVarK, null);
    }
}
