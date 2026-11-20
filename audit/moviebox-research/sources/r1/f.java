package r1;

import androidx.compose.runtime.InvalidationResult;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.j2;
import androidx.compose.runtime.k;
import androidx.compose.runtime.m;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.w1;
import androidx.compose.runtime.x0;
import androidx.compose.runtime.y;
import androidx.compose.runtime.y0;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class f {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements w1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f75073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0 f75074b;

        public a(y yVar, y0 y0Var) {
            this.f75073a = yVar;
            this.f75074b = y0Var;
        }

        @Override // androidx.compose.runtime.w1
        public void a(Object obj) {
        }

        @Override // androidx.compose.runtime.w1
        public void h(RecomposeScopeImpl recomposeScopeImpl) {
        }

        @Override // androidx.compose.runtime.w1
        public InvalidationResult k(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
            InvalidationResult invalidationResultK;
            y yVar = this.f75073a;
            w1 w1Var = yVar instanceof w1 ? (w1) yVar : null;
            if (w1Var == null || (invalidationResultK = w1Var.k(recomposeScopeImpl, obj)) == null) {
                invalidationResultK = InvalidationResult.IGNORED;
            }
            if (invalidationResultK != InvalidationResult.IGNORED) {
                return invalidationResultK;
            }
            y0 y0Var = this.f75074b;
            y0Var.h(CollectionsKt___CollectionsKt.y0(y0Var.d(), TuplesKt.a(recomposeScopeImpl, obj)));
            return InvalidationResult.SCHEDULED;
        }
    }

    public static final int d(m2 m2Var) {
        int iC0 = m2Var.c0();
        int iE0 = m2Var.e0();
        while (iE0 >= 0 && !m2Var.t0(iE0)) {
            iE0 = m2Var.H0(iE0);
        }
        int iM0 = iE0 + 1;
        int iF0 = 0;
        while (iM0 < iC0) {
            if (m2Var.o0(iC0, iM0)) {
                if (m2Var.t0(iM0)) {
                    iF0 = 0;
                }
                iM0++;
            } else {
                iF0 += m2Var.t0(iM0) ? 1 : m2Var.F0(iM0);
                iM0 += m2Var.m0(iM0);
            }
        }
        return iF0;
    }

    public static final int e(m2 m2Var, androidx.compose.runtime.c cVar, androidx.compose.runtime.f<Object> fVar) {
        int iF = m2Var.F(cVar);
        k.Q(m2Var.c0() < iF);
        f(m2Var, fVar, iF);
        int iD = d(m2Var);
        while (m2Var.c0() < iF) {
            if (m2Var.n0(iF)) {
                if (m2Var.s0()) {
                    fVar.g(m2Var.D0(m2Var.c0()));
                    iD = 0;
                }
                m2Var.j1();
            } else {
                iD += m2Var.Y0();
            }
        }
        k.Q(m2Var.c0() == iF);
        return iD;
    }

    public static final void f(m2 m2Var, androidx.compose.runtime.f<Object> fVar, int i11) {
        while (!m2Var.p0(i11)) {
            m2Var.Z0();
            if (m2Var.t0(m2Var.e0())) {
                fVar.i();
            }
            m2Var.T();
        }
    }

    public static final void g(y yVar, m mVar, y0 y0Var, m2 m2Var) {
        j2 j2Var = new j2();
        if (m2Var.b0()) {
            j2Var.j();
        }
        if (m2Var.a0()) {
            j2Var.i();
        }
        m2 m2VarE = j2Var.E();
        try {
            m2VarE.I();
            m2VarE.k1(126665345, y0Var.c());
            m2.v0(m2VarE, 0, 1, null);
            m2VarE.p1(y0Var.f());
            List<androidx.compose.runtime.c> listC0 = m2Var.C0(y0Var.a(), 1, m2VarE);
            m2VarE.Y0();
            m2VarE.T();
            m2VarE.U();
            m2VarE.L(true);
            x0 x0Var = new x0(j2Var);
            RecomposeScopeImpl.a aVar = RecomposeScopeImpl.f3302h;
            if (aVar.b(j2Var, listC0)) {
                a aVar2 = new a(yVar, y0Var);
                m2 m2VarE2 = j2Var.E();
                try {
                    aVar.a(m2VarE2, listC0, aVar2);
                    Unit unit = Unit.f68710a;
                    m2VarE2.L(true);
                } catch (Throwable th2) {
                    m2VarE2.L(false);
                    throw th2;
                }
            }
            mVar.m(y0Var, x0Var);
        } catch (Throwable th3) {
            m2VarE.L(false);
            throw th3;
        }
    }
}
