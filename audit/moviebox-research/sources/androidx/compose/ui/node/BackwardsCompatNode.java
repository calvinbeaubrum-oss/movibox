package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class BackwardsCompatNode extends androidx.compose.ui.f.c implements x, n, i1, e1, androidx.compose.ui.modifier.h, androidx.compose.ui.modifier.k, a1, w, p, androidx.compose.ui.focus.d, androidx.compose.ui.focus.o, androidx.compose.ui.focus.t, z0, androidx.compose.ui.draw.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.compose.ui.f.b f4910o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4911p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.compose.ui.modifier.a f4912q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashSet<androidx.compose.ui.modifier.c<?>> f4913r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public androidx.compose.ui.layout.m f4914s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements y0.b {
        public a() {
        }

        @Override // androidx.compose.ui.node.y0.b
        public void f() {
            if (BackwardsCompatNode.this.f4914s == null) {
                BackwardsCompatNode backwardsCompatNode = BackwardsCompatNode.this;
                backwardsCompatNode.m(g.h(backwardsCompatNode, s0.a(128)));
            }
        }
    }

    public BackwardsCompatNode(androidx.compose.ui.f.b bVar) {
        B1(t0.f(bVar));
        this.f4910o = bVar;
        this.f4911p = true;
        this.f4913r = new HashSet<>();
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        androidx.compose.ui.draw.g gVar = (androidx.compose.ui.draw.g) bVar;
        if (this.f4911p && (bVar instanceof androidx.compose.ui.draw.f)) {
            O1();
        }
        gVar.A(cVar);
    }

    @Override // androidx.compose.ui.focus.o
    public void A0(androidx.compose.ui.focus.m mVar) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        if (!(bVar instanceof androidx.compose.ui.focus.j)) {
            h2.a.b("applyFocusProperties called on wrong node");
        }
        ((androidx.compose.ui.focus.j) bVar).i(new androidx.compose.ui.focus.i(mVar));
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.w C(androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((androidx.compose.ui.layout.p) bVar).C(yVar, tVar, j11);
    }

    @Override // androidx.compose.ui.focus.d
    public void D(androidx.compose.ui.focus.u uVar) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        if (!(bVar instanceof androidx.compose.ui.focus.c)) {
            h2.a.b("onFocusEvent called on wrong node");
        }
        ((androidx.compose.ui.focus.c) bVar).D(uVar);
    }

    @Override // androidx.compose.ui.node.e1
    public void D0() {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((androidx.compose.ui.input.pointer.g0) bVar).j().d();
    }

    @Override // androidx.compose.ui.node.n
    public void F0() {
        this.f4911p = true;
        o.a(this);
    }

    public final androidx.compose.ui.f.b I1() {
        return this.f4910o;
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void J0() {
        d1.b(this);
    }

    public final HashSet<androidx.compose.ui.modifier.c<?>> J1() {
        return this.f4913r;
    }

    public final void K1(boolean z11) {
        if (!o1()) {
            h2.a.b("initializeModifier called on unattached node");
        }
        androidx.compose.ui.f.b bVar = this.f4910o;
        if ((s0.a(32) & j1()) != 0) {
            if (bVar instanceof androidx.compose.ui.modifier.d) {
                F1(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        this.this$0.P1();
                    }
                });
            }
            if (bVar instanceof androidx.compose.ui.modifier.j) {
                Q1((androidx.compose.ui.modifier.j) bVar);
            }
        }
        if ((s0.a(4) & j1()) != 0) {
            if (bVar instanceof androidx.compose.ui.draw.f) {
                this.f4911p = true;
            }
            if (!z11) {
                a0.a(this);
            }
        }
        if ((s0.a(2) & j1()) != 0) {
            if (BackwardsCompatNodeKt.e(this)) {
                NodeCoordinator nodeCoordinatorG1 = g1();
                Intrinsics.d(nodeCoordinatorG1);
                ((y) nodeCoordinatorG1).V2(this);
                nodeCoordinatorG1.n2();
            }
            if (!z11) {
                a0.a(this);
                g.m(this).y0();
            }
        }
        if (bVar instanceof androidx.compose.ui.layout.m0) {
            ((androidx.compose.ui.layout.m0) bVar).e(g.m(this));
        }
        if ((s0.a(128) & j1()) != 0) {
            if ((bVar instanceof androidx.compose.ui.layout.g0) && BackwardsCompatNodeKt.e(this)) {
                g.m(this).y0();
            }
            if (bVar instanceof androidx.compose.ui.layout.f0) {
                this.f4914s = null;
                if (BackwardsCompatNodeKt.e(this)) {
                    g.n(this).registerOnLayoutCompletedListener(new a());
                }
            }
        }
        if ((s0.a(256) & j1()) != 0 && (bVar instanceof androidx.compose.ui.layout.c0) && BackwardsCompatNodeKt.e(this)) {
            g.m(this).y0();
        }
        if (bVar instanceof androidx.compose.ui.focus.s) {
            ((androidx.compose.ui.focus.s) bVar).b().e().b(this);
        }
        if ((s0.a(16) & j1()) != 0 && (bVar instanceof androidx.compose.ui.input.pointer.g0)) {
            ((androidx.compose.ui.input.pointer.g0) bVar).j().f(g1());
        }
        if ((s0.a(8) & j1()) != 0) {
            g.n(this).onSemanticsChange();
        }
    }

    public final void L1() {
        this.f4911p = true;
        o.a(this);
    }

    public final void M1(androidx.compose.ui.f.b bVar) {
        if (o1()) {
            N1();
        }
        this.f4910o = bVar;
        B1(t0.f(bVar));
        if (o1()) {
            K1(false);
        }
    }

    public final void N1() {
        if (!o1()) {
            h2.a.b("unInitializeModifier called on unattached node");
        }
        androidx.compose.ui.f.b bVar = this.f4910o;
        if ((s0.a(32) & j1()) != 0) {
            if (bVar instanceof androidx.compose.ui.modifier.j) {
                g.n(this).getModifierLocalManager().d(this, ((androidx.compose.ui.modifier.j) bVar).getKey());
            }
            if (bVar instanceof androidx.compose.ui.modifier.d) {
                ((androidx.compose.ui.modifier.d) bVar).g(BackwardsCompatNodeKt.f4916a);
            }
        }
        if ((s0.a(8) & j1()) != 0) {
            g.n(this).onSemanticsChange();
        }
        if (bVar instanceof androidx.compose.ui.focus.s) {
            ((androidx.compose.ui.focus.s) bVar).b().e().x(this);
        }
    }

    public final void O1() {
        final androidx.compose.ui.f.b bVar = this.f4910o;
        if (bVar instanceof androidx.compose.ui.draw.f) {
            g.n(this).getSnapshotObserver().i(this, BackwardsCompatNodeKt.f4917b, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateDrawCache$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((androidx.compose.ui.draw.f) bVar).h(this);
                }
            });
        }
        this.f4911p = false;
    }

    public final void P1() {
        if (o1()) {
            this.f4913r.clear();
            g.n(this).getSnapshotObserver().i(this, BackwardsCompatNodeKt.f4918c, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateModifierLocalConsumer$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    androidx.compose.ui.f.b bVarI1 = this.this$0.I1();
                    Intrinsics.e(bVarI1, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    ((androidx.compose.ui.modifier.d) bVarI1).g(this.this$0);
                }
            });
        }
    }

    public final void Q1(androidx.compose.ui.modifier.j<?> jVar) {
        androidx.compose.ui.modifier.a aVar = this.f4912q;
        if (aVar != null && aVar.a(jVar.getKey())) {
            aVar.c(jVar);
            g.n(this).getModifierLocalManager().f(this, jVar.getKey());
        } else {
            this.f4912q = new androidx.compose.ui.modifier.a(jVar);
            if (BackwardsCompatNodeKt.e(this)) {
                g.n(this).getModifierLocalManager().a(this, jVar.getKey());
            }
        }
    }

    @Override // androidx.compose.ui.node.e1
    public void T(androidx.compose.ui.input.pointer.q qVar, PointerEventPass pointerEventPass, long j11) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((androidx.compose.ui.input.pointer.g0) bVar).j().e(qVar, pointerEventPass, j11);
    }

    @Override // androidx.compose.ui.node.e1
    public boolean U0() {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((androidx.compose.ui.input.pointer.g0) bVar).j().c();
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean V() {
        return h1.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.compose.ui.modifier.k
    public <T> T W(androidx.compose.ui.modifier.c<T> cVar) {
        q0 q0VarE0;
        this.f4913r.add(cVar);
        int iA = s0.a(32);
        if (!getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = getNode().l1();
        LayoutNode layoutNodeM = g.m(this);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        ?? G = cVarL1;
                        ?? bVar = 0;
                        while (G != 0) {
                            if (G instanceof androidx.compose.ui.modifier.h) {
                                androidx.compose.ui.modifier.h hVar = (androidx.compose.ui.modifier.h) G;
                                if (hVar.b0().a(cVar)) {
                                    return (T) hVar.b0().b(cVar);
                                }
                            } else if ((G.j1() & iA) != 0 && (G instanceof i)) {
                                androidx.compose.ui.f.c cVarI1 = ((i) G).I1();
                                int i11 = 0;
                                G = G;
                                bVar = bVar;
                                while (cVarI1 != null) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            bVar = bVar;
                                            G = cVarI1;
                                        } else {
                                            if (bVar == 0) {
                                                bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (G != 0) {
                                                bVar.b(G);
                                                G = 0;
                                            }
                                            bVar.b(cVarI1);
                                        }
                                    }
                                    cVarI1 = cVarI1.f1();
                                    G = G;
                                    bVar = bVar;
                                }
                                if (i11 == 1) {
                                }
                            }
                            G = g.g(bVar);
                        }
                    }
                    cVarL1 = cVarL1.l1();
                }
            }
            layoutNodeM = layoutNodeM.h0();
            cVarL1 = (layoutNodeM == null || (q0VarE0 = layoutNodeM.e0()) == null) ? null : q0VarE0.o();
        }
        return cVar.a().invoke();
    }

    @Override // androidx.compose.ui.node.i1
    public void W0(androidx.compose.ui.semantics.q qVar) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        androidx.compose.ui.semantics.l lVarN = ((androidx.compose.ui.semantics.m) bVar).n();
        Intrinsics.e(qVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        ((androidx.compose.ui.semantics.l) qVar).e(lVarN);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void X0() {
        d1.c(this);
    }

    @Override // androidx.compose.ui.node.e1
    public boolean Y() {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((androidx.compose.ui.input.pointer.g0) bVar).j().a();
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean Z0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.modifier.h
    public androidx.compose.ui.modifier.f b0() {
        androidx.compose.ui.modifier.a aVar = this.f4912q;
        return aVar != null ? aVar : androidx.compose.ui.modifier.i.a();
    }

    @Override // androidx.compose.ui.draw.a
    public q2.e getDensity() {
        return g.m(this).H();
    }

    @Override // androidx.compose.ui.draw.a
    public LayoutDirection getLayoutDirection() {
        return g.m(this).getLayoutDirection();
    }

    @Override // androidx.compose.ui.draw.a
    public long i() {
        return q2.u.d(g.h(this, s0.a(128)).p());
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return o1();
    }

    @Override // androidx.compose.ui.node.a1
    public Object k(q2.e eVar, Object obj) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((androidx.compose.ui.layout.i0) bVar).k(eVar, obj);
    }

    @Override // androidx.compose.ui.node.w
    public void l(long j11) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        if (bVar instanceof androidx.compose.ui.layout.g0) {
            ((androidx.compose.ui.layout.g0) bVar).l(j11);
        }
    }

    @Override // androidx.compose.ui.node.w
    public void m(androidx.compose.ui.layout.m mVar) {
        this.f4914s = mVar;
        androidx.compose.ui.f.b bVar = this.f4910o;
        if (bVar instanceof androidx.compose.ui.layout.f0) {
            ((androidx.compose.ui.layout.f0) bVar).m(mVar);
        }
    }

    @Override // androidx.compose.ui.f.c
    public void r1() {
        K1(true);
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        N1();
    }

    public String toString() {
        return this.f4910o.toString();
    }

    @Override // androidx.compose.ui.node.p
    public void x(androidx.compose.ui.layout.m mVar) {
        androidx.compose.ui.f.b bVar = this.f4910o;
        Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((androidx.compose.ui.layout.c0) bVar).x(mVar);
    }
}
