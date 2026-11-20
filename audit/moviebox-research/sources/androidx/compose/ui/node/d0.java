package androidx.compose.ui.node;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.r4;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class d0 implements z1.g, z1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z1.a f5075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f5076b;

    public d0(z1.a aVar) {
        this.f5075a = aVar;
    }

    public /* synthetic */ d0(z1.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new z1.a() : aVar);
    }

    @Override // z1.g
    public void C0(long j11, long j12, long j13, float f11, z1.h hVar, x1 x1Var, int i11) {
        this.f5075a.C0(j11, j12, j13, f11, hVar, x1Var, i11);
    }

    @Override // z1.g
    public void G0(androidx.compose.ui.graphics.l1 l1Var, long j11, long j12, float f11, z1.h hVar, x1 x1Var, int i11) {
        this.f5075a.G0(l1Var, j11, j12, f11, hVar, x1Var, i11);
    }

    @Override // q2.e
    public float H0(float f11) {
        return this.f5075a.H0(f11);
    }

    @Override // z1.g
    public void I0(long j11, float f11, long j12, float f12, z1.h hVar, x1 x1Var, int i11) {
        this.f5075a.I0(j11, f11, j12, f12, hVar, x1Var, i11);
    }

    @Override // q2.n
    public long M(float f11) {
        return this.f5075a.M(f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f5075a.M0();
    }

    @Override // z1.g
    public void N(Path path, androidx.compose.ui.graphics.l1 l1Var, float f11, z1.h hVar, x1 x1Var, int i11) {
        this.f5075a.N(path, l1Var, f11, hVar, x1Var, i11);
    }

    @Override // q2.e
    public float N0(float f11) {
        return this.f5075a.N0(f11);
    }

    @Override // q2.n
    public float O(long j11) {
        return this.f5075a.O(j11);
    }

    @Override // z1.g
    public void P(androidx.compose.ui.graphics.l1 l1Var, long j11, long j12, long j13, float f11, z1.h hVar, x1 x1Var, int i11) {
        this.f5075a.P(l1Var, j11, j12, j13, f11, hVar, x1Var, i11);
    }

    @Override // z1.g
    public void P0(List<y1.g> list, int i11, long j11, float f11, int i12, r4 r4Var, float f12, x1 x1Var, int i13) {
        this.f5075a.P0(list, i11, j11, f11, i12, r4Var, f12, x1Var, i13);
    }

    @Override // z1.g
    public z1.d Q0() {
        return this.f5075a.Q0();
    }

    @Override // z1.g
    public long T0() {
        return this.f5075a.T0();
    }

    @Override // q2.e
    public long V0(long j11) {
        return this.f5075a.V0(j11);
    }

    @Override // q2.e
    public long X(float f11) {
        return this.f5075a.X(f11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    @Override // z1.c
    public void a1() {
        androidx.compose.ui.graphics.o1 o1VarE = Q0().e();
        n nVar = this.f5076b;
        Intrinsics.d(nVar);
        androidx.compose.ui.f.c cVarB = e0.b(nVar);
        if (cVarB == 0) {
            NodeCoordinator nodeCoordinatorH = g.h(nVar, s0.a(4));
            if (nodeCoordinatorH.X1() == nVar.getNode()) {
                nodeCoordinatorH = nodeCoordinatorH.Y1();
                Intrinsics.d(nodeCoordinatorH);
            }
            nodeCoordinatorH.t2(o1VarE, Q0().g());
            return;
        }
        int iA = s0.a(4);
        androidx.compose.runtime.collection.b bVar = null;
        while (cVarB != 0) {
            if (cVarB instanceof n) {
                m((n) cVarB, o1VarE, Q0().g());
            } else if ((cVarB.j1() & iA) != 0 && (cVarB instanceof i)) {
                androidx.compose.ui.f.c cVarI1 = ((i) cVarB).I1();
                int i11 = 0;
                cVarB = cVarB;
                while (cVarI1 != null) {
                    if ((cVarI1.j1() & iA) != 0) {
                        i11++;
                        if (i11 == 1) {
                            cVarB = cVarI1;
                        } else {
                            if (bVar == null) {
                                bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                            }
                            if (cVarB != 0) {
                                bVar.b(cVarB);
                                cVarB = 0;
                            }
                            bVar.b(cVarI1);
                        }
                    }
                    cVarI1 = cVarI1.f1();
                    cVarB = cVarB;
                }
                if (i11 == 1) {
                }
            }
            cVarB = g.g(bVar);
        }
    }

    @Override // z1.g
    public void c0(long j11, long j12, long j13, long j14, z1.h hVar, float f11, x1 x1Var, int i11) {
        this.f5075a.c0(j11, j12, j13, j14, hVar, f11, x1Var, i11);
    }

    @Override // z1.g
    public void c1(g4 g4Var, long j11, long j12, long j13, long j14, float f11, z1.h hVar, x1 x1Var, int i11, int i12) {
        this.f5075a.c1(g4Var, j11, j12, j13, j14, f11, hVar, x1Var, i11, i12);
    }

    @Override // q2.e
    public float getDensity() {
        return this.f5075a.getDensity();
    }

    @Override // z1.g
    public LayoutDirection getLayoutDirection() {
        return this.f5075a.getLayoutDirection();
    }

    @Override // z1.g
    public long i() {
        return this.f5075a.i();
    }

    @Override // z1.g
    public void j0(Path path, long j11, float f11, z1.h hVar, x1 x1Var, int i11) {
        this.f5075a.j0(path, j11, f11, hVar, x1Var, i11);
    }

    public final void k(androidx.compose.ui.graphics.o1 o1Var, long j11, NodeCoordinator nodeCoordinator, androidx.compose.ui.f.c cVar, GraphicsLayer graphicsLayer) {
        int iA = s0.a(4);
        androidx.compose.ui.f.c cVarG = cVar;
        androidx.compose.runtime.collection.b bVar = null;
        while (cVarG != null) {
            if (cVarG instanceof n) {
                l(o1Var, j11, nodeCoordinator, (n) cVarG, graphicsLayer);
            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                int i11 = 0;
                for (androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                    if ((cVarI1.j1() & iA) != 0) {
                        i11++;
                        if (i11 == 1) {
                            cVarG = cVarI1;
                        } else {
                            if (bVar == null) {
                                bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                            }
                            if (cVarG != null) {
                                bVar.b(cVarG);
                                cVarG = null;
                            }
                            bVar.b(cVarI1);
                        }
                    }
                }
                if (i11 == 1) {
                }
            }
            cVarG = g.g(bVar);
        }
    }

    @Override // q2.e
    public int k0(float f11) {
        return this.f5075a.k0(f11);
    }

    public final void l(androidx.compose.ui.graphics.o1 o1Var, long j11, NodeCoordinator nodeCoordinator, n nVar, GraphicsLayer graphicsLayer) {
        n nVar2 = this.f5076b;
        this.f5076b = nVar;
        z1.a aVar = this.f5075a;
        LayoutDirection layoutDirection = nodeCoordinator.getLayoutDirection();
        q2.e density = aVar.Q0().getDensity();
        LayoutDirection layoutDirection2 = aVar.Q0().getLayoutDirection();
        androidx.compose.ui.graphics.o1 o1VarE = aVar.Q0().e();
        long jI = aVar.Q0().i();
        GraphicsLayer graphicsLayerG = aVar.Q0().g();
        z1.d dVarQ0 = aVar.Q0();
        dVarQ0.b(nodeCoordinator);
        dVarQ0.a(layoutDirection);
        dVarQ0.h(o1Var);
        dVarQ0.f(j11);
        dVarQ0.d(graphicsLayer);
        o1Var.d();
        try {
            nVar.A(this);
            o1Var.k();
            z1.d dVarQ1 = aVar.Q0();
            dVarQ1.b(density);
            dVarQ1.a(layoutDirection2);
            dVarQ1.h(o1VarE);
            dVarQ1.f(jI);
            dVarQ1.d(graphicsLayerG);
            this.f5076b = nVar2;
        } catch (Throwable th2) {
            o1Var.k();
            z1.d dVarQ2 = aVar.Q0();
            dVarQ2.b(density);
            dVarQ2.a(layoutDirection2);
            dVarQ2.h(o1VarE);
            dVarQ2.f(jI);
            dVarQ2.d(graphicsLayerG);
            throw th2;
        }
    }

    public final void m(n nVar, androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinatorH = g.h(nVar, s0.a(4));
        nodeCoordinatorH.X0().W().l(o1Var, q2.u.d(nodeCoordinatorH.p()), nodeCoordinatorH, nVar, graphicsLayer);
    }

    @Override // q2.e
    public float p0(long j11) {
        return this.f5075a.p0(j11);
    }

    @Override // z1.g
    public void z0(long j11, long j12, long j13, float f11, int i11, r4 r4Var, float f12, x1 x1Var, int i12) {
        this.f5075a.z0(j11, j12, j13, f11, i11, r4Var, f12, x1Var, i12);
    }
}
