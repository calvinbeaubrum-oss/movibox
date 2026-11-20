package androidx.compose.ui.node;

import kotlin.KotlinNothingValueException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutNode f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f5125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NodeCoordinator f5126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.f.c f5127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.compose.ui.f.c f5128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> f5129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> f5130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f5131h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.compose.ui.f.c f5132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> f5134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> f5135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5136e;

        public a(androidx.compose.ui.f.c cVar, int i11, androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar, androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar2, boolean z11) {
            this.f5132a = cVar;
            this.f5133b = i11;
            this.f5134c = bVar;
            this.f5135d = bVar2;
            this.f5136e = z11;
        }

        @Override // androidx.compose.ui.node.k
        public boolean a(int i11, int i12) {
            return NodeChainKt.d(this.f5134c.q()[this.f5133b + i11], this.f5135d.q()[this.f5133b + i12]) != 0;
        }

        @Override // androidx.compose.ui.node.k
        public void b(int i11, int i12) {
            androidx.compose.ui.f.c cVarF1 = this.f5132a.f1();
            Intrinsics.d(cVarF1);
            q0.d(q0.this);
            if ((s0.a(2) & cVarF1.j1()) != 0) {
                NodeCoordinator nodeCoordinatorG1 = cVarF1.g1();
                Intrinsics.d(nodeCoordinatorG1);
                NodeCoordinator nodeCoordinatorZ1 = nodeCoordinatorG1.Z1();
                NodeCoordinator nodeCoordinatorY1 = nodeCoordinatorG1.Y1();
                Intrinsics.d(nodeCoordinatorY1);
                if (nodeCoordinatorZ1 != null) {
                    nodeCoordinatorZ1.D2(nodeCoordinatorY1);
                }
                nodeCoordinatorY1.E2(nodeCoordinatorZ1);
                q0.this.v(this.f5132a, nodeCoordinatorY1);
            }
            this.f5132a = q0.this.h(cVarF1);
        }

        @Override // androidx.compose.ui.node.k
        public void c(int i11) {
            int i12 = this.f5133b + i11;
            this.f5132a = q0.this.g(this.f5135d.q()[i12], this.f5132a);
            q0.d(q0.this);
            if (!this.f5136e) {
                this.f5132a.A1(true);
                return;
            }
            androidx.compose.ui.f.c cVarF1 = this.f5132a.f1();
            Intrinsics.d(cVarF1);
            NodeCoordinator nodeCoordinatorG1 = cVarF1.g1();
            Intrinsics.d(nodeCoordinatorG1);
            x xVarD = g.d(this.f5132a);
            if (xVarD != null) {
                y yVar = new y(q0.this.m(), xVarD);
                this.f5132a.G1(yVar);
                q0.this.v(this.f5132a, yVar);
                yVar.E2(nodeCoordinatorG1.Z1());
                yVar.D2(nodeCoordinatorG1);
                nodeCoordinatorG1.E2(yVar);
            } else {
                this.f5132a.G1(nodeCoordinatorG1);
            }
            this.f5132a.p1();
            this.f5132a.v1();
            t0.a(this.f5132a);
        }

        @Override // androidx.compose.ui.node.k
        public void d(int i11, int i12) {
            androidx.compose.ui.f.c cVarF1 = this.f5132a.f1();
            Intrinsics.d(cVarF1);
            this.f5132a = cVarF1;
            androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar = this.f5134c;
            androidx.compose.ui.f.b bVar2 = bVar.q()[this.f5133b + i11];
            androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar3 = this.f5135d;
            androidx.compose.ui.f.b bVar4 = bVar3.q()[this.f5133b + i12];
            if (Intrinsics.b(bVar2, bVar4)) {
                q0.d(q0.this);
            } else {
                q0.this.F(bVar2, bVar4, this.f5132a);
                q0.d(q0.this);
            }
        }

        public final void e(androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar) {
            this.f5135d = bVar;
        }

        public final void f(androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar) {
            this.f5134c = bVar;
        }

        public final void g(androidx.compose.ui.f.c cVar) {
            this.f5132a = cVar;
        }

        public final void h(int i11) {
            this.f5133b = i11;
        }

        public final void i(boolean z11) {
            this.f5136e = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
    }

    public q0(LayoutNode layoutNode) {
        this.f5124a = layoutNode;
        s sVar = new s(layoutNode);
        this.f5125b = sVar;
        this.f5126c = sVar;
        l1 l1VarQ2 = sVar.X1();
        this.f5127d = l1VarQ2;
        this.f5128e = l1VarQ2;
    }

    public static final /* synthetic */ b d(q0 q0Var) {
        q0Var.getClass();
        return null;
    }

    public final void A(int i11, androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar, androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar2, androidx.compose.ui.f.c cVar, boolean z11) {
        o0.e(bVar.r() - i11, bVar2.r() - i11, j(cVar, i11, bVar, bVar2, z11));
        B();
    }

    public final void B() {
        int iJ1 = 0;
        for (androidx.compose.ui.f.c cVarL1 = this.f5127d.l1(); cVarL1 != null && cVarL1 != NodeChainKt.f5043a; cVarL1 = cVarL1.l1()) {
            iJ1 |= cVarL1.j1();
            cVarL1.x1(iJ1);
        }
    }

    public final void C() {
        NodeCoordinator yVar;
        NodeCoordinator nodeCoordinator = this.f5125b;
        for (androidx.compose.ui.f.c cVarL1 = this.f5127d.l1(); cVarL1 != null; cVarL1 = cVarL1.l1()) {
            x xVarD = g.d(cVarL1);
            if (xVarD != null) {
                if (cVarL1.g1() != null) {
                    NodeCoordinator nodeCoordinatorG1 = cVarL1.g1();
                    Intrinsics.e(nodeCoordinatorG1, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    yVar = (y) nodeCoordinatorG1;
                    x xVarR2 = yVar.R2();
                    yVar.V2(xVarD);
                    if (xVarR2 != cVarL1) {
                        yVar.n2();
                    }
                } else {
                    yVar = new y(this.f5124a, xVarD);
                    cVarL1.G1(yVar);
                }
                nodeCoordinator.E2(yVar);
                yVar.D2(nodeCoordinator);
                nodeCoordinator = yVar;
            } else {
                cVarL1.G1(nodeCoordinator);
            }
        }
        LayoutNode layoutNodeH0 = this.f5124a.h0();
        nodeCoordinator.E2(layoutNodeH0 != null ? layoutNodeH0.M() : null);
        this.f5126c = nodeCoordinator;
    }

    public final androidx.compose.ui.f.c D(androidx.compose.ui.f.c cVar) {
        if (!(cVar == NodeChainKt.f5043a)) {
            h2.a.b("trimChain called on already trimmed chain");
        }
        androidx.compose.ui.f.c cVarF1 = NodeChainKt.f5043a.f1();
        if (cVarF1 == null) {
            cVarF1 = this.f5127d;
        }
        cVarF1.D1(null);
        NodeChainKt.f5043a.z1(null);
        NodeChainKt.f5043a.x1(-1);
        NodeChainKt.f5043a.G1(null);
        if (!(cVarF1 != NodeChainKt.f5043a)) {
            h2.a.b("trimChain did not update the head");
        }
        return cVarF1;
    }

    public final void E(androidx.compose.ui.f fVar) {
        androidx.compose.ui.f.c cVarU = u();
        androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar = this.f5129f;
        int i11 = 0;
        int iR = bVar != null ? bVar.r() : 0;
        androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar2 = this.f5130g;
        if (bVar2 == null) {
            bVar2 = new androidx.compose.runtime.collection.b<>(new androidx.compose.ui.f.b[16], 0);
        }
        androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVarE = NodeChainKt.e(fVar, bVar2);
        androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar3 = null;
        if (bVarE.r() == iR) {
            androidx.compose.ui.f.c cVarF1 = cVarU.f1();
            int i12 = 0;
            while (cVarF1 != null && i12 < iR) {
                if (bVar == null) {
                    h2.a.c("expected prior modifier list to be non-empty");
                    throw new KotlinNothingValueException();
                }
                androidx.compose.ui.f.b bVar4 = bVar.q()[i12];
                androidx.compose.ui.f.b bVar5 = bVarE.q()[i12];
                int iD = NodeChainKt.d(bVar4, bVar5);
                if (iD == 0) {
                    cVarF1 = cVarF1.l1();
                    break;
                }
                if (iD == 1) {
                    F(bVar4, bVar5, cVarF1);
                }
                cVarF1 = cVarF1.f1();
                i12++;
            }
            androidx.compose.ui.f.c cVar = cVarF1;
            if (i12 < iR) {
                if (bVar == null) {
                    h2.a.c("expected prior modifier list to be non-empty");
                    throw new KotlinNothingValueException();
                }
                if (cVar == null) {
                    h2.a.c("structuralUpdate requires a non-null tail");
                    throw new KotlinNothingValueException();
                }
                A(i12, bVar, bVarE, cVar, !this.f5124a.A());
                i11 = 1;
            }
        } else {
            if (this.f5124a.A() && iR == 0) {
                androidx.compose.ui.f.c cVarG = cVarU;
                while (i11 < bVarE.r()) {
                    cVarG = g(bVarE.q()[i11], cVarG);
                    i11++;
                }
                B();
            } else if (bVarE.r() != 0) {
                if (bVar == null) {
                    bVar = new androidx.compose.runtime.collection.b<>(new androidx.compose.ui.f.b[16], 0);
                }
                A(0, bVar, bVarE, cVarU, !this.f5124a.A());
            } else {
                if (bVar == null) {
                    h2.a.c("expected prior modifier list to be non-empty");
                    throw new KotlinNothingValueException();
                }
                androidx.compose.ui.f.c cVarF2 = cVarU.f1();
                for (int i13 = 0; cVarF2 != null && i13 < bVar.r(); i13++) {
                    cVarF2 = h(cVarF2).f1();
                }
                s sVar = this.f5125b;
                LayoutNode layoutNodeH0 = this.f5124a.h0();
                sVar.E2(layoutNodeH0 != null ? layoutNodeH0.M() : null);
                this.f5126c = this.f5125b;
            }
            i11 = 1;
        }
        this.f5129f = bVarE;
        if (bVar != null) {
            bVar.i();
            bVar3 = bVar;
        }
        this.f5130g = bVar3;
        this.f5128e = D(cVarU);
        if (i11 != 0) {
            C();
        }
    }

    public final void F(androidx.compose.ui.f.b bVar, androidx.compose.ui.f.b bVar2, androidx.compose.ui.f.c cVar) {
        if ((bVar instanceof l0) && (bVar2 instanceof l0)) {
            NodeChainKt.f((l0) bVar2, cVar);
            if (cVar.o1()) {
                t0.e(cVar);
                return;
            } else {
                cVar.E1(true);
                return;
            }
        }
        if (!(cVar instanceof BackwardsCompatNode)) {
            throw new IllegalStateException("Unknown Modifier.Node type".toString());
        }
        ((BackwardsCompatNode) cVar).M1(bVar2);
        if (cVar.o1()) {
            t0.e(cVar);
        } else {
            cVar.E1(true);
        }
    }

    public final androidx.compose.ui.f.c g(androidx.compose.ui.f.b bVar, androidx.compose.ui.f.c cVar) {
        androidx.compose.ui.f.c backwardsCompatNode;
        if (bVar instanceof l0) {
            backwardsCompatNode = ((l0) bVar).a();
            backwardsCompatNode.B1(t0.h(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(bVar);
        }
        if (!(!backwardsCompatNode.o1())) {
            h2.a.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.A1(true);
        return r(backwardsCompatNode, cVar);
    }

    public final androidx.compose.ui.f.c h(androidx.compose.ui.f.c cVar) {
        if (cVar.o1()) {
            t0.d(cVar);
            cVar.w1();
            cVar.q1();
        }
        return w(cVar);
    }

    public final int i() {
        return this.f5128e.e1();
    }

    public final a j(androidx.compose.ui.f.c cVar, int i11, androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar, androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar2, boolean z11) {
        a aVar = this.f5131h;
        if (aVar == null) {
            a aVar2 = new a(cVar, i11, bVar, bVar2, z11);
            this.f5131h = aVar2;
            return aVar2;
        }
        aVar.g(cVar);
        aVar.h(i11);
        aVar.f(bVar);
        aVar.e(bVar2);
        aVar.i(z11);
        return aVar;
    }

    public final androidx.compose.ui.f.c k() {
        return this.f5128e;
    }

    public final s l() {
        return this.f5125b;
    }

    public final LayoutNode m() {
        return this.f5124a;
    }

    public final NodeCoordinator n() {
        return this.f5126c;
    }

    public final androidx.compose.ui.f.c o() {
        return this.f5127d;
    }

    public final boolean p(int i11) {
        return (i11 & i()) != 0;
    }

    public final boolean q(int i11) {
        return (i11 & i()) != 0;
    }

    public final androidx.compose.ui.f.c r(androidx.compose.ui.f.c cVar, androidx.compose.ui.f.c cVar2) {
        androidx.compose.ui.f.c cVarF1 = cVar2.f1();
        if (cVarF1 != null) {
            cVarF1.D1(cVar);
            cVar.z1(cVarF1);
        }
        cVar2.z1(cVar);
        cVar.D1(cVar2);
        return cVar;
    }

    public final void s() {
        for (androidx.compose.ui.f.c cVarK = k(); cVarK != null; cVarK = cVarK.f1()) {
            cVarK.p1();
        }
    }

    public final void t() {
        for (androidx.compose.ui.f.c cVarO = o(); cVarO != null; cVarO = cVarO.l1()) {
            if (cVarO.o1()) {
                cVarO.q1();
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        if (this.f5128e == this.f5127d) {
            sb2.append("]");
        } else {
            for (androidx.compose.ui.f.c cVarK = k(); cVarK != null && cVarK != o(); cVarK = cVarK.f1()) {
                sb2.append(String.valueOf(cVarK));
                if (cVarK.f1() == this.f5127d) {
                    sb2.append("]");
                    break;
                }
                sb2.append(",");
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final androidx.compose.ui.f.c u() {
        if (!(this.f5128e != NodeChainKt.f5043a)) {
            h2.a.b("padChain called on already padded chain");
        }
        androidx.compose.ui.f.c cVar = this.f5128e;
        cVar.D1(NodeChainKt.f5043a);
        NodeChainKt.f5043a.z1(cVar);
        return NodeChainKt.f5043a;
    }

    public final void v(androidx.compose.ui.f.c cVar, NodeCoordinator nodeCoordinator) {
        for (androidx.compose.ui.f.c cVarL1 = cVar.l1(); cVarL1 != null; cVarL1 = cVarL1.l1()) {
            if (cVarL1 == NodeChainKt.f5043a) {
                LayoutNode layoutNodeH0 = this.f5124a.h0();
                nodeCoordinator.E2(layoutNodeH0 != null ? layoutNodeH0.M() : null);
                this.f5126c = nodeCoordinator;
                return;
            } else {
                if ((s0.a(2) & cVarL1.j1()) != 0) {
                    return;
                }
                cVarL1.G1(nodeCoordinator);
            }
        }
    }

    public final androidx.compose.ui.f.c w(androidx.compose.ui.f.c cVar) {
        androidx.compose.ui.f.c cVarF1 = cVar.f1();
        androidx.compose.ui.f.c cVarL1 = cVar.l1();
        if (cVarF1 != null) {
            cVarF1.D1(cVarL1);
            cVar.z1(null);
        }
        if (cVarL1 != null) {
            cVarL1.z1(cVarF1);
            cVar.D1(null);
        }
        Intrinsics.d(cVarL1);
        return cVarL1;
    }

    public final void x() {
        for (androidx.compose.ui.f.c cVarO = o(); cVarO != null; cVarO = cVarO.l1()) {
            if (cVarO.o1()) {
                cVarO.u1();
            }
        }
        z();
        t();
    }

    public final void y() {
        for (androidx.compose.ui.f.c cVarK = k(); cVarK != null; cVarK = cVarK.f1()) {
            cVarK.v1();
            if (cVarK.i1()) {
                t0.a(cVarK);
            }
            if (cVarK.n1()) {
                t0.e(cVarK);
            }
            cVarK.A1(false);
            cVarK.E1(false);
        }
    }

    public final void z() {
        for (androidx.compose.ui.f.c cVarO = o(); cVarO != null; cVarO = cVarO.l1()) {
            if (cVarO.o1()) {
                cVarO.w1();
            }
        }
    }
}
