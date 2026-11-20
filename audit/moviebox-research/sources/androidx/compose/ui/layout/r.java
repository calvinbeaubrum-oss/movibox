package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeCoordinator;
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
public final class r implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.node.j0 f4890a;

    public r(androidx.compose.ui.node.j0 j0Var) {
        this.f4890a = j0Var;
    }

    @Override // androidx.compose.ui.layout.m
    public long A(m mVar, long j11) {
        return x(mVar, j11, true);
    }

    @Override // androidx.compose.ui.layout.m
    public boolean D() {
        return a().D();
    }

    @Override // androidx.compose.ui.layout.m
    public long H(long j11) {
        return a().H(y1.g.r(j11, b()));
    }

    @Override // androidx.compose.ui.layout.m
    public y1.i K(m mVar, boolean z11) {
        return a().K(mVar, z11);
    }

    @Override // androidx.compose.ui.layout.m
    public m R() {
        androidx.compose.ui.node.j0 j0VarT1;
        if (!D()) {
            h2.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator nodeCoordinatorZ1 = a().X0().f0().Z1();
        if (nodeCoordinatorZ1 == null || (j0VarT1 = nodeCoordinatorZ1.T1()) == null) {
            return null;
        }
        return j0VarT1.U0();
    }

    @Override // androidx.compose.ui.layout.m
    public long V(long j11) {
        return a().V(y1.g.r(j11, b()));
    }

    public final NodeCoordinator a() {
        return this.f4890a.u1();
    }

    public final long b() {
        androidx.compose.ui.node.j0 j0VarA = s.a(this.f4890a);
        m mVarU0 = j0VarA.U0();
        y1.g.a aVar = y1.g.f81070b;
        return y1.g.q(A(mVarU0, aVar.c()), a().A(j0VarA.u1(), aVar.c()));
    }

    @Override // androidx.compose.ui.layout.m
    public long p() {
        androidx.compose.ui.node.j0 j0Var = this.f4890a;
        return q2.u.a(j0Var.s0(), j0Var.g0());
    }

    @Override // androidx.compose.ui.layout.m
    public long x(m mVar, long j11, boolean z11) {
        if (!(mVar instanceof r)) {
            androidx.compose.ui.node.j0 j0VarA = s.a(this.f4890a);
            return y1.g.r(x(j0VarA.v1(), j11, z11), j0VarA.u1().U0().x(mVar, y1.g.f81070b.c(), z11));
        }
        androidx.compose.ui.node.j0 j0Var = ((r) mVar).f4890a;
        j0Var.u1().m2();
        androidx.compose.ui.node.j0 j0VarT1 = a().K1(j0Var.u1()).T1();
        if (j0VarT1 != null) {
            long jK = q2.p.k(q2.p.l(j0Var.A1(j0VarT1, !z11), q2.q.d(j11)), this.f4890a.A1(j0VarT1, !z11));
            return y1.h.a(q2.p.h(jK), q2.p.i(jK));
        }
        androidx.compose.ui.node.j0 j0VarA2 = s.a(j0Var);
        long jL = q2.p.l(q2.p.l(j0Var.A1(j0VarA2, !z11), j0VarA2.d1()), q2.q.d(j11));
        androidx.compose.ui.node.j0 j0VarA3 = s.a(this.f4890a);
        long jK2 = q2.p.k(jL, q2.p.l(this.f4890a.A1(j0VarA3, !z11), j0VarA3.d1()));
        long jA = y1.h.a(q2.p.h(jK2), q2.p.i(jK2));
        NodeCoordinator nodeCoordinatorZ1 = j0VarA3.u1().Z1();
        Intrinsics.d(nodeCoordinatorZ1);
        NodeCoordinator nodeCoordinatorZ2 = j0VarA2.u1().Z1();
        Intrinsics.d(nodeCoordinatorZ2);
        return nodeCoordinatorZ1.x(nodeCoordinatorZ2, jA, z11);
    }
}
