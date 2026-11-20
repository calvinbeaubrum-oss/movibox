package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class m {
    public static final VectorPainter a(VectorPainter vectorPainter, long j11, long j12, String str, x1 x1Var, boolean z11) {
        vectorPainter.u(j11);
        vectorPainter.q(z11);
        vectorPainter.r(x1Var);
        vectorPainter.v(j12);
        vectorPainter.t(str);
        return vectorPainter;
    }

    public static final x1 b(long j11, int i11) {
        if (j11 != 16) {
            return x1.f4581b.a(j11, i11);
        }
        return null;
    }

    public static final GroupComponent c(GroupComponent groupComponent, j jVar) {
        int iV = jVar.v();
        for (int i11 = 0; i11 < iV; i11++) {
            l lVarE = jVar.e(i11);
            if (lVarE instanceof n) {
                PathComponent pathComponent = new PathComponent();
                n nVar = (n) lVarE;
                pathComponent.k(nVar.g());
                pathComponent.l(nVar.i());
                pathComponent.j(nVar.f());
                pathComponent.h(nVar.a());
                pathComponent.i(nVar.e());
                pathComponent.m(nVar.j());
                pathComponent.n(nVar.r());
                pathComponent.r(nVar.w());
                pathComponent.o(nVar.s());
                pathComponent.p(nVar.u());
                pathComponent.q(nVar.v());
                pathComponent.u(nVar.z());
                pathComponent.s(nVar.x());
                pathComponent.t(nVar.y());
                groupComponent.i(i11, pathComponent);
            } else if (lVarE instanceof j) {
                GroupComponent groupComponent2 = new GroupComponent();
                j jVar2 = (j) lVarE;
                groupComponent2.p(jVar2.g());
                groupComponent2.s(jVar2.r());
                groupComponent2.t(jVar2.s());
                groupComponent2.u(jVar2.u());
                groupComponent2.v(jVar2.w());
                groupComponent2.w(jVar2.x());
                groupComponent2.q(jVar2.i());
                groupComponent2.r(jVar2.j());
                groupComponent2.o(jVar2.f());
                c(groupComponent2, jVar2);
                groupComponent.i(i11, groupComponent2);
            }
        }
        return groupComponent;
    }

    public static final VectorPainter d(q2.e eVar, c cVar, GroupComponent groupComponent) {
        long jE = e(eVar, cVar.e(), cVar.d());
        return a(new VectorPainter(groupComponent), jE, f(jE, cVar.l(), cVar.k()), cVar.g(), b(cVar.j(), cVar.i()), cVar.c());
    }

    public static final long e(q2.e eVar, float f11, float f12) {
        return y1.n.a(eVar.N0(f11), eVar.N0(f12));
    }

    public static final long f(long j11, float f11, float f12) {
        if (Float.isNaN(f11)) {
            f11 = y1.m.i(j11);
        }
        if (Float.isNaN(f12)) {
            f12 = y1.m.g(j11);
        }
        return y1.n.a(f11, f12);
    }

    public static final VectorPainter g(c cVar, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1413834416, i11, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:171)");
        }
        q2.e eVar = (q2.e) iVar.l(CompositionLocalsKt.c());
        float f11 = cVar.f();
        boolean zD = iVar.d((((long) Float.floatToRawIntBits(eVar.getDensity())) & 4294967295L) | (Float.floatToRawIntBits(f11) << 32));
        Object objY = iVar.y();
        if (zD || objY == androidx.compose.runtime.i.f3413a.a()) {
            GroupComponent groupComponent = new GroupComponent();
            c(groupComponent, cVar.h());
            Unit unit = Unit.f68710a;
            objY = d(eVar, cVar, groupComponent);
            iVar.p(objY);
        }
        VectorPainter vectorPainter = (VectorPainter) objY;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return vectorPainter;
    }
}
