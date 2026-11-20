package androidx.compose.ui.node;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public abstract class j0 extends LookaheadCapablePlaceable implements androidx.compose.ui.layout.t {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final NodeCoordinator f5085q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<androidx.compose.ui.layout.a, Integer> f5087s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.compose.ui.layout.w f5089u;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f5086r = q2.p.f74244b.a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.compose.ui.layout.r f5088t = new androidx.compose.ui.layout.r(this);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<androidx.compose.ui.layout.a, Integer> f5090v = new LinkedHashMap();

    public j0(NodeCoordinator nodeCoordinator) {
        this.f5085q = nodeCoordinator;
    }

    public final long A1(j0 j0Var, boolean z11) {
        long jA = q2.p.f74244b.a();
        j0 j0VarT1 = this;
        while (!Intrinsics.b(j0VarT1, j0Var)) {
            if (!j0VarT1.h1() || !z11) {
                jA = q2.p.l(jA, j0VarT1.d1());
            }
            NodeCoordinator nodeCoordinatorZ1 = j0VarT1.f5085q.Z1();
            Intrinsics.d(nodeCoordinatorZ1);
            j0VarT1 = nodeCoordinatorZ1.T1();
            Intrinsics.d(j0VarT1);
        }
        return jA;
    }

    public void B1(long j11) {
        this.f5086r = j11;
    }

    public final void C1(androidx.compose.ui.layout.w wVar) {
        Unit unit;
        Map<androidx.compose.ui.layout.a, Integer> map;
        if (wVar != null) {
            A0(q2.u.a(wVar.getWidth(), wVar.getHeight()));
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            A0(q2.t.f74253b.a());
        }
        if (!Intrinsics.b(this.f5089u, wVar) && wVar != null && ((((map = this.f5087s) != null && !map.isEmpty()) || (!wVar.l().isEmpty())) && !Intrinsics.b(wVar.l(), this.f5087s))) {
            q1().l().m();
            Map linkedHashMap = this.f5087s;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.f5087s = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(wVar.l());
        }
        this.f5089u = wVar;
    }

    @Override // androidx.compose.ui.layout.k0, androidx.compose.ui.layout.j
    public Object F() {
        return this.f5085q.F();
    }

    @Override // q2.n
    public float M0() {
        return this.f5085q.M0();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable R0() {
        NodeCoordinator nodeCoordinatorY1 = this.f5085q.Y1();
        if (nodeCoordinatorY1 != null) {
            return nodeCoordinatorY1.T1();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.m U0() {
        return this.f5088t;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean W0() {
        return this.f5089u != null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutNode X0() {
        return this.f5085q.X0();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.w Y0() {
        androidx.compose.ui.layout.w wVar = this.f5089u;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable Z0() {
        NodeCoordinator nodeCoordinatorZ1 = this.f5085q.Z1();
        if (nodeCoordinatorZ1 != null) {
            return nodeCoordinatorZ1.T1();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.layout.k
    public boolean d0() {
        return true;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long d1() {
        return this.f5086r;
    }

    @Override // q2.e
    public float getDensity() {
        return this.f5085q.getDensity();
    }

    @Override // androidx.compose.ui.layout.k
    public LayoutDirection getLayoutDirection() {
        return this.f5085q.getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void l1() {
        x0(d1(), 0.0f, null);
    }

    public a q1() {
        a aVarC = this.f5085q.X0().P().C();
        Intrinsics.d(aVarC);
        return aVarC;
    }

    public final int r1(androidx.compose.ui.layout.a aVar) {
        Integer num = this.f5090v.get(aVar);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public final Map<androidx.compose.ui.layout.a, Integer> s1() {
        return this.f5090v;
    }

    public final long t1() {
        return r0();
    }

    public final NodeCoordinator u1() {
        return this.f5085q;
    }

    public final androidx.compose.ui.layout.r v1() {
        return this.f5088t;
    }

    public final long w1() {
        return q2.u.a(s0(), g0());
    }

    @Override // androidx.compose.ui.layout.k0
    public final void x0(long j11, float f11, Function1<? super e4, Unit> function1) {
        y1(j11);
        if (j1()) {
            return;
        }
        x1();
    }

    public void x1() {
        Y0().m();
    }

    public final void y1(long j11) {
        if (!q2.p.g(d1(), j11)) {
            B1(j11);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateH = X0().P().H();
            if (lookaheadPassDelegateH != null) {
                lookaheadPassDelegateH.e1();
            }
            f1(this.f5085q);
        }
        if (i1()) {
            return;
        }
        J0(Y0());
    }

    public final void z1(long j11) {
        y1(q2.p.l(j11, e0()));
    }
}
