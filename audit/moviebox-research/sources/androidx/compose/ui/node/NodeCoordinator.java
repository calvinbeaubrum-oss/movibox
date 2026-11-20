package androidx.compose.ui.node;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements androidx.compose.ui.layout.t, androidx.compose.ui.layout.m, z0 {
    public static final c M = new c(null);
    public static final Function1<NodeCoordinator, Unit> N = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.isValidOwnerScope()) {
                u uVar = nodeCoordinator.G;
                if (uVar == null) {
                    NodeCoordinator.O2(nodeCoordinator, false, 1, null);
                    return;
                }
                NodeCoordinator.Q.b(uVar);
                NodeCoordinator.O2(nodeCoordinator, false, 1, null);
                if (NodeCoordinator.Q.c(uVar)) {
                    return;
                }
                LayoutNode layoutNodeX0 = nodeCoordinator.X0();
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegateP = layoutNodeX0.P();
                if (layoutNodeLayoutDelegateP.s() > 0) {
                    if (layoutNodeLayoutDelegateP.u() || layoutNodeLayoutDelegateP.v()) {
                        LayoutNode.f1(layoutNodeX0, false, 1, null);
                    }
                    layoutNodeLayoutDelegateP.I().k1();
                }
                y0 y0VarG0 = layoutNodeX0.g0();
                if (y0VarG0 != null) {
                    y0VarG0.requestOnPositionedCallback(layoutNodeX0);
                }
            }
        }
    };
    public static final Function1<NodeCoordinator, Unit> O = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            w0 w0VarS1 = nodeCoordinator.S1();
            if (w0VarS1 != null) {
                w0VarS1.invalidate();
            }
        }
    };
    public static final z4 P = new z4();
    public static final u Q = new u();
    public static final float[] R = k4.c(null, 1, null);
    public static final d S = new a();
    public static final d T = new b();
    public androidx.compose.ui.layout.w B;
    public Map<androidx.compose.ui.layout.a, Integer> C;
    public float E;
    public y1.e F;
    public u G;
    public boolean J;
    public w0 K;
    public GraphicsLayer L;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LayoutNode f5044q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f5045r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f5046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public NodeCoordinator f5047t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public NodeCoordinator f5048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5049v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f5050w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function1<? super e4, Unit> f5051x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q2.e f5052y = X0().H();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LayoutDirection f5053z = X0().getLayoutDirection();
    public float A = 0.8f;
    public long D = q2.p.f74244b.a();
    public final Function2<androidx.compose.ui.graphics.o1, GraphicsLayer, Unit> H = new Function2<androidx.compose.ui.graphics.o1, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
            invoke2(o1Var, graphicsLayer);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final androidx.compose.ui.graphics.o1 o1Var, final GraphicsLayer graphicsLayer) {
            if (!this.this$0.X0().k()) {
                this.this$0.J = true;
                return;
            }
            OwnerSnapshotObserver ownerSnapshotObserverW1 = this.this$0.W1();
            NodeCoordinator nodeCoordinator = this.this$0;
            Function1 function1 = NodeCoordinator.O;
            final NodeCoordinator nodeCoordinator2 = this.this$0;
            ownerSnapshotObserverW1.i(nodeCoordinator, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1.1
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
                    nodeCoordinator2.I1(o1Var, graphicsLayer);
                }
            });
            this.this$0.J = false;
        }
    };
    public final Function0<Unit> I = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
            NodeCoordinator nodeCoordinatorZ1 = this.this$0.Z1();
            if (nodeCoordinatorZ1 != null) {
                nodeCoordinatorZ1.i2();
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements d {
        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public int a() {
            return s0.a(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v7 */
        /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
            	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
            	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
            */
        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean b(androidx.compose.ui.f.c r10) {
            /*
                r9 = this;
                r0 = 16
                int r1 = androidx.compose.ui.node.s0.a(r0)
                r2 = 0
                r3 = r2
            L8:
                r4 = 0
                if (r10 == 0) goto L5a
                boolean r5 = r10 instanceof androidx.compose.ui.node.e1
                r6 = 1
                if (r5 == 0) goto L19
                androidx.compose.ui.node.e1 r10 = (androidx.compose.ui.node.e1) r10
                boolean r10 = r10.Y()
                if (r10 == 0) goto L55
                return r6
            L19:
                int r5 = r10.j1()
                r5 = r5 & r1
                if (r5 == 0) goto L55
                boolean r5 = r10 instanceof androidx.compose.ui.node.i
                if (r5 == 0) goto L55
                r5 = r10
                androidx.compose.ui.node.i r5 = (androidx.compose.ui.node.i) r5
                androidx.compose.ui.f$c r5 = r5.I1()
                r7 = 0
            L2c:
                if (r5 == 0) goto L52
                int r8 = r5.j1()
                r8 = r8 & r1
                if (r8 == 0) goto L4d
                int r7 = r7 + 1
                if (r7 != r6) goto L3b
                r10 = r5
                goto L4d
            L3b:
                if (r3 != 0) goto L44
                androidx.compose.runtime.collection.b r3 = new androidx.compose.runtime.collection.b
                androidx.compose.ui.f$c[] r8 = new androidx.compose.ui.f.c[r0]
                r3.<init>(r8, r4)
            L44:
                if (r10 == 0) goto L4a
                r3.b(r10)
                r10 = r2
            L4a:
                r3.b(r5)
            L4d:
                androidx.compose.ui.f$c r5 = r5.f1()
                goto L2c
            L52:
                if (r7 != r6) goto L55
                goto L8
            L55:
                androidx.compose.ui.f$c r10 = androidx.compose.ui.node.g.b(r3)
                goto L8
            L5a:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.a.b(androidx.compose.ui.f$c):boolean");
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public void c(LayoutNode layoutNode, long j11, q qVar, boolean z11, boolean z12) {
            layoutNode.q0(j11, qVar, z11, z12);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean d(LayoutNode layoutNode) {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements d {
        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public int a() {
            return s0.a(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean b(androidx.compose.ui.f.c cVar) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public void c(LayoutNode layoutNode, long j11, q qVar, boolean z11, boolean z12) {
            layoutNode.s0(j11, qVar, z11, z12);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean d(LayoutNode layoutNode) {
            androidx.compose.ui.semantics.l lVarF = layoutNode.F();
            boolean z11 = false;
            if (lVarF != null && lVarF.u()) {
                z11 = true;
            }
            return !z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return NodeCoordinator.S;
        }

        public final d b() {
            return NodeCoordinator.T;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface d {
        int a();

        boolean b(androidx.compose.ui.f.c cVar);

        void c(LayoutNode layoutNode, long j11, q qVar, boolean z11, boolean z12);

        boolean d(LayoutNode layoutNode);
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.f5044q = layoutNode;
    }

    public static /* synthetic */ long J2(NodeCoordinator nodeCoordinator, long j11, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return nodeCoordinator.I2(j11, z11);
    }

    public static /* synthetic */ long M1(NodeCoordinator nodeCoordinator, long j11, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return nodeCoordinator.L1(j11, z11);
    }

    public static /* synthetic */ void M2(NodeCoordinator nodeCoordinator, Function1 function1, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        nodeCoordinator.L2(function1, z11);
    }

    public static /* synthetic */ void O2(NodeCoordinator nodeCoordinator, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        nodeCoordinator.N2(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver W1() {
        return f0.b(X0()).getSnapshotObserver();
    }

    public static /* synthetic */ void x2(NodeCoordinator nodeCoordinator, y1.e eVar, boolean z11, boolean z12, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i11 & 4) != 0) {
            z12 = false;
        }
        nodeCoordinator.w2(eVar, z11, z12);
    }

    @Override // androidx.compose.ui.layout.m
    public long A(androidx.compose.ui.layout.m mVar, long j11) {
        return x(mVar, j11, true);
    }

    public final void A2(boolean z11) {
        this.f5045r = z11;
    }

    public void B2(androidx.compose.ui.layout.w wVar) {
        androidx.compose.ui.layout.w wVar2 = this.B;
        if (wVar != wVar2) {
            this.B = wVar;
            if (wVar2 == null || wVar.getWidth() != wVar2.getWidth() || wVar.getHeight() != wVar2.getHeight()) {
                p2(wVar.getWidth(), wVar.getHeight());
            }
            Map<androidx.compose.ui.layout.a, Integer> map = this.C;
            if (((map == null || map.isEmpty()) && !(!wVar.l().isEmpty())) || Intrinsics.b(wVar.l(), this.C)) {
                return;
            }
            O1().l().m();
            Map linkedHashMap = this.C;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.C = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(wVar.l());
        }
    }

    public final void C1(NodeCoordinator nodeCoordinator, y1.e eVar, boolean z11) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.f5048u;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.C1(nodeCoordinator, eVar, z11);
        }
        N1(eVar, z11);
    }

    public void C2(long j11) {
        this.D = j11;
    }

    @Override // androidx.compose.ui.layout.m
    public boolean D() {
        return X1().o1();
    }

    public final long D1(NodeCoordinator nodeCoordinator, long j11, boolean z11) {
        if (nodeCoordinator == this) {
            return j11;
        }
        NodeCoordinator nodeCoordinator2 = this.f5048u;
        return (nodeCoordinator2 == null || Intrinsics.b(nodeCoordinator, nodeCoordinator2)) ? L1(j11, z11) : L1(nodeCoordinator2.D1(nodeCoordinator, j11, z11), z11);
    }

    public final void D2(NodeCoordinator nodeCoordinator) {
        this.f5047t = nodeCoordinator;
    }

    public final long E1(long j11) {
        return y1.n.a(Math.max(0.0f, (y1.m.i(j11) - q0()) / 2.0f), Math.max(0.0f, (y1.m.g(j11) - h0()) / 2.0f));
    }

    public final void E2(NodeCoordinator nodeCoordinator) {
        this.f5048u = nodeCoordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // androidx.compose.ui.layout.k0, androidx.compose.ui.layout.j
    public Object F() {
        if (!X0().e0().q(s0.a(64))) {
            return null;
        }
        X1();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (androidx.compose.ui.f.c cVarO = X0().e0().o(); cVarO != null; cVarO = cVarO.l1()) {
            if ((s0.a(64) & cVarO.j1()) != 0) {
                int iA = s0.a(64);
                androidx.compose.runtime.collection.b bVar = null;
                androidx.compose.ui.f.c cVarG = cVarO;
                while (cVarG != 0) {
                    if (cVarG instanceof a1) {
                        objectRef.element = ((a1) cVarG).k(X0().H(), objectRef.element);
                    } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                        androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                        int i11 = 0;
                        cVarG = cVarG;
                        while (cVarI1 != null) {
                            if ((cVarI1.j1() & iA) != 0) {
                                i11++;
                                if (i11 == 1) {
                                    cVarG = cVarI1;
                                } else {
                                    if (bVar == null) {
                                        bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                    }
                                    if (cVarG != 0) {
                                        bVar.b(cVarG);
                                        cVarG = 0;
                                    }
                                    bVar.b(cVarI1);
                                }
                            }
                            cVarI1 = cVarI1.f1();
                            cVarG = cVarG;
                        }
                        if (i11 == 1) {
                        }
                    }
                    cVarG = g.g(bVar);
                }
            }
        }
        return objectRef.element;
    }

    public final float F1(long j11, long j12) {
        if (q0() >= y1.m.i(j12) && h0() >= y1.m.g(j12)) {
            return Float.POSITIVE_INFINITY;
        }
        long jE1 = E1(j12);
        float fI = y1.m.i(jE1);
        float fG = y1.m.g(jE1);
        long jL2 = l2(j11);
        if ((fI > 0.0f || fG > 0.0f) && y1.g.m(jL2) <= fI && y1.g.n(jL2) <= fG) {
            return y1.g.l(jL2);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    public final boolean F2() {
        /*
            r11 = this;
            r0 = 16
            int r1 = androidx.compose.ui.node.s0.a(r0)
            boolean r1 = androidx.compose.ui.node.t0.i(r1)
            androidx.compose.ui.f$c r1 = r11.d2(r1)
            r2 = 0
            if (r1 != 0) goto L12
            return r2
        L12:
            boolean r3 = r1.o1()
            if (r3 == 0) goto L98
            int r3 = androidx.compose.ui.node.s0.a(r0)
            androidx.compose.ui.f$c r4 = r1.getNode()
            boolean r4 = r4.o1()
            if (r4 != 0) goto L2b
            java.lang.String r4 = "visitLocalDescendants called on an unattached node"
            h2.a.b(r4)
        L2b:
            androidx.compose.ui.f$c r1 = r1.getNode()
            int r4 = r1.e1()
            r4 = r4 & r3
            if (r4 == 0) goto L98
        L36:
            if (r1 == 0) goto L98
            int r4 = r1.j1()
            r4 = r4 & r3
            if (r4 == 0) goto L93
            r4 = 0
            r5 = r1
            r6 = r4
        L42:
            if (r5 == 0) goto L93
            boolean r7 = r5 instanceof androidx.compose.ui.node.e1
            r8 = 1
            if (r7 == 0) goto L52
            androidx.compose.ui.node.e1 r5 = (androidx.compose.ui.node.e1) r5
            boolean r5 = r5.U0()
            if (r5 == 0) goto L8e
            return r8
        L52:
            int r7 = r5.j1()
            r7 = r7 & r3
            if (r7 == 0) goto L8e
            boolean r7 = r5 instanceof androidx.compose.ui.node.i
            if (r7 == 0) goto L8e
            r7 = r5
            androidx.compose.ui.node.i r7 = (androidx.compose.ui.node.i) r7
            androidx.compose.ui.f$c r7 = r7.I1()
            r9 = 0
        L65:
            if (r7 == 0) goto L8b
            int r10 = r7.j1()
            r10 = r10 & r3
            if (r10 == 0) goto L86
            int r9 = r9 + 1
            if (r9 != r8) goto L74
            r5 = r7
            goto L86
        L74:
            if (r6 != 0) goto L7d
            androidx.compose.runtime.collection.b r6 = new androidx.compose.runtime.collection.b
            androidx.compose.ui.f$c[] r10 = new androidx.compose.ui.f.c[r0]
            r6.<init>(r10, r2)
        L7d:
            if (r5 == 0) goto L83
            r6.b(r5)
            r5 = r4
        L83:
            r6.b(r7)
        L86:
            androidx.compose.ui.f$c r7 = r7.f1()
            goto L65
        L8b:
            if (r9 != r8) goto L8e
            goto L42
        L8e:
            androidx.compose.ui.f$c r5 = androidx.compose.ui.node.g.b(r6)
            goto L42
        L93:
            androidx.compose.ui.f$c r1 = r1.f1()
            goto L36
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.F2():boolean");
    }

    public final void G1(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        w0 w0Var = this.K;
        if (w0Var != null) {
            w0Var.drawLayer(o1Var, graphicsLayer);
            return;
        }
        float fH = q2.p.h(d1());
        float fI = q2.p.i(d1());
        o1Var.c(fH, fI);
        I1(o1Var, graphicsLayer);
        o1Var.c(-fH, -fI);
    }

    public final void G2(final androidx.compose.ui.f.c cVar, final d dVar, final long j11, final q qVar, final boolean z11, final boolean z12, final float f11) {
        if (cVar == null) {
            h2(dVar, j11, qVar, z11, z12);
        } else if (dVar.b(cVar)) {
            qVar.D(cVar, f11, z12, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
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
                    this.this$0.G2(r0.b(cVar, dVar.a(), s0.a(2)), dVar, j11, qVar, z11, z12, f11);
                }
            });
        } else {
            G2(r0.b(cVar, dVar.a(), s0.a(2)), dVar, j11, qVar, z11, z12, f11);
        }
    }

    @Override // androidx.compose.ui.layout.m
    public long H(long j11) {
        return f0.b(X0()).mo61calculatePositionInWindowMKHz9U(V(j11));
    }

    public final void H1(androidx.compose.ui.graphics.o1 o1Var, o4 o4Var) {
        o1Var.r(new y1.i(0.5f, 0.5f, q2.t.g(o0()) - 0.5f, q2.t.f(o0()) - 0.5f), o4Var);
    }

    public final NodeCoordinator H2(androidx.compose.ui.layout.m mVar) {
        NodeCoordinator nodeCoordinatorA;
        androidx.compose.ui.layout.r rVar = mVar instanceof androidx.compose.ui.layout.r ? (androidx.compose.ui.layout.r) mVar : null;
        if (rVar != null && (nodeCoordinatorA = rVar.a()) != null) {
            return nodeCoordinatorA;
        }
        Intrinsics.e(mVar, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) mVar;
    }

    public final void I1(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        androidx.compose.ui.f.c cVarC2 = c2(s0.a(4));
        if (cVarC2 == null) {
            t2(o1Var, graphicsLayer);
        } else {
            X0().W().k(o1Var, q2.u.d(p()), this, cVarC2, graphicsLayer);
        }
    }

    public long I2(long j11, boolean z11) {
        w0 w0Var = this.K;
        if (w0Var != null) {
            j11 = w0Var.mo58mapOffset8S9VItk(j11, false);
        }
        return (z11 || !h1()) ? q2.q.c(j11, d1()) : j11;
    }

    public abstract void J1();

    @Override // androidx.compose.ui.layout.m
    public y1.i K(androidx.compose.ui.layout.m mVar, boolean z11) {
        if (!D()) {
            h2.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!mVar.D()) {
            h2.a.b("LayoutCoordinates " + mVar + " is not attached!");
        }
        NodeCoordinator nodeCoordinatorH2 = H2(mVar);
        nodeCoordinatorH2.m2();
        NodeCoordinator nodeCoordinatorK1 = K1(nodeCoordinatorH2);
        y1.e eVarV1 = V1();
        eVarV1.i(0.0f);
        eVarV1.k(0.0f);
        eVarV1.j(q2.t.g(mVar.p()));
        eVarV1.h(q2.t.f(mVar.p()));
        while (nodeCoordinatorH2 != nodeCoordinatorK1) {
            x2(nodeCoordinatorH2, eVarV1, z11, false, 4, null);
            if (eVarV1.f()) {
                return y1.i.f81075e.a();
            }
            nodeCoordinatorH2 = nodeCoordinatorH2.f5048u;
            Intrinsics.d(nodeCoordinatorH2);
        }
        C1(nodeCoordinatorK1, eVarV1, z11);
        return y1.f.a(eVarV1);
    }

    public final NodeCoordinator K1(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNodeX0 = nodeCoordinator.X0();
        LayoutNode layoutNodeX1 = X0();
        if (layoutNodeX0 == layoutNodeX1) {
            androidx.compose.ui.f.c cVarX1 = nodeCoordinator.X1();
            androidx.compose.ui.f.c cVarX2 = X1();
            int iA = s0.a(2);
            if (!cVarX2.getNode().o1()) {
                h2.a.b("visitLocalAncestors called on an unattached node");
            }
            for (androidx.compose.ui.f.c cVarL1 = cVarX2.getNode().l1(); cVarL1 != null; cVarL1 = cVarL1.l1()) {
                if ((cVarL1.j1() & iA) != 0 && cVarL1 == cVarX1) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (layoutNodeX0.I() > layoutNodeX1.I()) {
            layoutNodeX0 = layoutNodeX0.h0();
            Intrinsics.d(layoutNodeX0);
        }
        while (layoutNodeX1.I() > layoutNodeX0.I()) {
            layoutNodeX1 = layoutNodeX1.h0();
            Intrinsics.d(layoutNodeX1);
        }
        while (layoutNodeX0 != layoutNodeX1) {
            layoutNodeX0 = layoutNodeX0.h0();
            layoutNodeX1 = layoutNodeX1.h0();
            if (layoutNodeX0 == null || layoutNodeX1 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNodeX1 == X0()) {
            return this;
        }
        return layoutNodeX0 == nodeCoordinator.X0() ? nodeCoordinator : layoutNodeX0.M();
    }

    public final y1.i K2() {
        if (!D()) {
            return y1.i.f81075e.a();
        }
        androidx.compose.ui.layout.m mVarD = androidx.compose.ui.layout.n.d(this);
        y1.e eVarV1 = V1();
        long jE1 = E1(U1());
        eVarV1.i(-y1.m.i(jE1));
        eVarV1.k(-y1.m.g(jE1));
        eVarV1.j(q0() + y1.m.i(jE1));
        eVarV1.h(h0() + y1.m.g(jE1));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != mVarD) {
            nodeCoordinator.w2(eVarV1, false, true);
            if (eVarV1.f()) {
                return y1.i.f81075e.a();
            }
            nodeCoordinator = nodeCoordinator.f5048u;
            Intrinsics.d(nodeCoordinator);
        }
        return y1.f.a(eVarV1);
    }

    public long L1(long j11, boolean z11) {
        if (z11 || !h1()) {
            j11 = q2.q.b(j11, d1());
        }
        w0 w0Var = this.K;
        return w0Var != null ? w0Var.mo58mapOffset8S9VItk(j11, true) : j11;
    }

    public final void L2(Function1<? super e4, Unit> function1, boolean z11) {
        y0 y0VarG0;
        if (!(function1 == null || this.L == null)) {
            h2.a.a("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNodeX0 = X0();
        boolean z12 = (!z11 && this.f5051x == function1 && Intrinsics.b(this.f5052y, layoutNodeX0.H()) && this.f5053z == layoutNodeX0.getLayoutDirection()) ? false : true;
        this.f5052y = layoutNodeX0.H();
        this.f5053z = layoutNodeX0.getLayoutDirection();
        if (!layoutNodeX0.D0() || function1 == null) {
            this.f5051x = null;
            w0 w0Var = this.K;
            if (w0Var != null) {
                w0Var.destroy();
                layoutNodeX0.m1(true);
                this.I.invoke();
                if (D() && (y0VarG0 = layoutNodeX0.g0()) != null) {
                    y0VarG0.onLayoutChange(layoutNodeX0);
                }
            }
            this.K = null;
            this.J = false;
            return;
        }
        this.f5051x = function1;
        if (this.K != null) {
            if (z12) {
                O2(this, false, 1, null);
                return;
            }
            return;
        }
        w0 w0VarA = x0.a(f0.b(layoutNodeX0), this.H, this.I, null, 4, null);
        w0VarA.mo60resizeozmzZPI(o0());
        w0VarA.mo59movegyyYBs(d1());
        this.K = w0VarA;
        O2(this, false, 1, null);
        layoutNodeX0.m1(true);
        this.I.invoke();
    }

    @Override // q2.n
    public float M0() {
        return X0().H().M0();
    }

    public final void N1(y1.e eVar, boolean z11) {
        float fH = q2.p.h(d1());
        eVar.i(eVar.b() - fH);
        eVar.j(eVar.c() - fH);
        float fI = q2.p.i(d1());
        eVar.k(eVar.d() - fI);
        eVar.h(eVar.a() - fI);
        w0 w0Var = this.K;
        if (w0Var != null) {
            w0Var.mapBounds(eVar, true);
            if (this.f5050w && z11) {
                eVar.e(0.0f, 0.0f, q2.t.g(p()), q2.t.f(p()));
                eVar.f();
            }
        }
    }

    public final void N2(boolean z11) {
        y0 y0VarG0;
        if (this.L != null) {
            return;
        }
        w0 w0Var = this.K;
        if (w0Var == null) {
            if (this.f5051x == null) {
                return;
            }
            h2.a.b("null layer with a non-null layerBlock");
            return;
        }
        final Function1<? super e4, Unit> function1 = this.f5051x;
        if (function1 == null) {
            h2.a.c("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
        z4 z4Var = P;
        z4Var.L();
        z4Var.R(X0().H());
        z4Var.S(X0().getLayoutDirection());
        z4Var.T(q2.u.d(p()));
        W1().i(this, N, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                function1.invoke(NodeCoordinator.P);
                NodeCoordinator.P.V();
            }
        });
        u uVar = this.G;
        if (uVar == null) {
            uVar = new u();
            this.G = uVar;
        }
        uVar.a(z4Var);
        w0Var.updateLayerProperties(z4Var);
        this.f5050w = z4Var.m();
        this.A = z4Var.k();
        if (!z11 || (y0VarG0 = X0().g0()) == null) {
            return;
        }
        y0VarG0.onLayoutChange(X0());
    }

    public androidx.compose.ui.node.a O1() {
        return X0().P().r();
    }

    public final boolean P1() {
        return this.f5046s;
    }

    public final boolean P2(long j11) {
        if (!y1.h.b(j11)) {
            return false;
        }
        w0 w0Var = this.K;
        return w0Var == null || !this.f5050w || w0Var.mo57isInLayerk4lQ0M(j11);
    }

    public final boolean Q1() {
        return this.J;
    }

    @Override // androidx.compose.ui.layout.m
    public final androidx.compose.ui.layout.m R() {
        if (!D()) {
            h2.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        m2();
        return X0().f0().f5048u;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable R0() {
        return this.f5047t;
    }

    public final long R1() {
        return r0();
    }

    public final w0 S1() {
        return this.K;
    }

    public abstract j0 T1();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.m U0() {
        return this;
    }

    public final long U1() {
        return this.f5052y.V0(X0().l0().d());
    }

    @Override // androidx.compose.ui.layout.m
    public long V(long j11) {
        if (!D()) {
            h2.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        m2();
        long jJ2 = j11;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.f5048u) {
            jJ2 = J2(nodeCoordinator, jJ2, false, 2, null);
        }
        return jJ2;
    }

    public final y1.e V1() {
        y1.e eVar = this.F;
        if (eVar != null) {
            return eVar;
        }
        y1.e eVar2 = new y1.e(0.0f, 0.0f, 0.0f, 0.0f);
        this.F = eVar2;
        return eVar2;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean W0() {
        return this.B != null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutNode X0() {
        return this.f5044q;
    }

    public abstract androidx.compose.ui.f.c X1();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.w Y0() {
        androidx.compose.ui.layout.w wVar = this.B;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier".toString());
    }

    public final NodeCoordinator Y1() {
        return this.f5047t;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable Z0() {
        return this.f5048u;
    }

    public final NodeCoordinator Z1() {
        return this.f5048u;
    }

    public final float a2() {
        return this.E;
    }

    public final boolean b2(int i11) {
        androidx.compose.ui.f.c cVarD2 = d2(t0.i(i11));
        return cVarD2 != null && g.e(cVarD2, i11);
    }

    public final androidx.compose.ui.f.c c2(int i11) {
        boolean zI = t0.i(i11);
        androidx.compose.ui.f.c cVarX1 = X1();
        if (!zI && (cVarX1 = cVarX1.l1()) == null) {
            return null;
        }
        for (androidx.compose.ui.f.c cVarD2 = d2(zI); cVarD2 != null && (cVarD2.e1() & i11) != 0; cVarD2 = cVarD2.f1()) {
            if ((cVarD2.j1() & i11) != 0) {
                return cVarD2;
            }
            if (cVarD2 == cVarX1) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long d1() {
        return this.D;
    }

    public final androidx.compose.ui.f.c d2(boolean z11) {
        androidx.compose.ui.f.c cVarX1;
        if (X0().f0() == this) {
            return X0().e0().k();
        }
        if (z11) {
            NodeCoordinator nodeCoordinator = this.f5048u;
            if (nodeCoordinator != null && (cVarX1 = nodeCoordinator.X1()) != null) {
                return cVarX1.f1();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.f5048u;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.X1();
            }
        }
        return null;
    }

    public final void e2(final androidx.compose.ui.f.c cVar, final d dVar, final long j11, final q qVar, final boolean z11, final boolean z12) {
        if (cVar == null) {
            h2(dVar, j11, qVar, z11, z12);
        } else {
            qVar.x(cVar, z12, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
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
                    this.this$0.e2(r0.b(cVar, dVar.a(), s0.a(2)), dVar, j11, qVar, z11, z12);
                }
            });
        }
    }

    public final void f2(final androidx.compose.ui.f.c cVar, final d dVar, final long j11, final q qVar, final boolean z11, final boolean z12, final float f11) {
        if (cVar == null) {
            h2(dVar, j11, qVar, z11, z12);
        } else {
            qVar.y(cVar, f11, z12, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
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
                    this.this$0.f2(r0.b(cVar, dVar.a(), s0.a(2)), dVar, j11, qVar, z11, z12, f11);
                }
            });
        }
    }

    public final void g2(d dVar, long j11, q qVar, boolean z11, boolean z12) {
        androidx.compose.ui.f.c cVarC2 = c2(dVar.a());
        if (!P2(j11)) {
            if (z11) {
                float fF1 = F1(j11, U1());
                if (Float.isInfinite(fF1) || Float.isNaN(fF1) || !qVar.A(fF1, false)) {
                    return;
                }
                f2(cVarC2, dVar, j11, qVar, z11, false, fF1);
                return;
            }
            return;
        }
        if (cVarC2 == null) {
            h2(dVar, j11, qVar, z11, z12);
            return;
        }
        if (j2(j11)) {
            e2(cVarC2, dVar, j11, qVar, z11, z12);
            return;
        }
        float fF2 = !z11 ? Float.POSITIVE_INFINITY : F1(j11, U1());
        if (!Float.isInfinite(fF2) && !Float.isNaN(fF2)) {
            if (qVar.A(fF2, z12)) {
                f2(cVarC2, dVar, j11, qVar, z11, z12, fF2);
                return;
            }
        }
        G2(cVarC2, dVar, j11, qVar, z11, z12, fF2);
    }

    @Override // q2.e
    public float getDensity() {
        return X0().H().getDensity();
    }

    @Override // androidx.compose.ui.layout.k
    public LayoutDirection getLayoutDirection() {
        return X0().getLayoutDirection();
    }

    public void h2(d dVar, long j11, q qVar, boolean z11, boolean z12) {
        NodeCoordinator nodeCoordinator = this.f5047t;
        if (nodeCoordinator != null) {
            nodeCoordinator.g2(dVar, M1(nodeCoordinator, j11, false, 2, null), qVar, z11, z12);
        }
    }

    public void i2() {
        w0 w0Var = this.K;
        if (w0Var != null) {
            w0Var.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.f5048u;
        if (nodeCoordinator != null) {
            nodeCoordinator.i2();
        }
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return (this.K == null || this.f5049v || !X0().D0()) ? false : true;
    }

    public final boolean j2(long j11) {
        float fM = y1.g.m(j11);
        float fN = y1.g.n(j11);
        return fM >= 0.0f && fN >= 0.0f && fM < ((float) q0()) && fN < ((float) h0());
    }

    public final boolean k2() {
        if (this.K != null && this.A <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.f5048u;
        if (nodeCoordinator != null) {
            return nodeCoordinator.k2();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void l1() {
        GraphicsLayer graphicsLayer = this.L;
        if (graphicsLayer != null) {
            u0(d1(), this.E, graphicsLayer);
        } else {
            x0(d1(), this.E, this.f5051x);
        }
    }

    public final long l2(long j11) {
        float fM = y1.g.m(j11);
        float fMax = Math.max(0.0f, fM < 0.0f ? -fM : fM - q0());
        float fN = y1.g.n(j11);
        return y1.h.a(fMax, Math.max(0.0f, fN < 0.0f ? -fN : fN - h0()));
    }

    public final void m2() {
        X0().P().S();
    }

    public void n2() {
        w0 w0Var = this.K;
        if (w0Var != null) {
            w0Var.invalidate();
        }
    }

    public final void o2() {
        L2(this.f5051x, true);
        w0 w0Var = this.K;
        if (w0Var != null) {
            w0Var.invalidate();
        }
    }

    @Override // androidx.compose.ui.layout.m
    public final long p() {
        return o0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    public void p2(int i11, int i12) {
        NodeCoordinator nodeCoordinator;
        w0 w0Var = this.K;
        if (w0Var != null) {
            w0Var.mo60resizeozmzZPI(q2.u.a(i11, i12));
        } else if (X0().k() && (nodeCoordinator = this.f5048u) != null) {
            nodeCoordinator.i2();
        }
        A0(q2.u.a(i11, i12));
        if (this.f5051x != null) {
            N2(false);
        }
        int iA = s0.a(4);
        boolean zI = t0.i(iA);
        androidx.compose.ui.f.c cVarX1 = X1();
        if (zI || (cVarX1 = cVarX1.l1()) != null) {
            for (androidx.compose.ui.f.c cVarD2 = d2(zI); cVarD2 != null && (cVarD2.e1() & iA) != 0; cVarD2 = cVarD2.f1()) {
                if ((cVarD2.j1() & iA) != 0) {
                    androidx.compose.ui.f.c cVarG = cVarD2;
                    androidx.compose.runtime.collection.b bVar = null;
                    while (cVarG != 0) {
                        if (cVarG instanceof n) {
                            ((n) cVarG).F0();
                        } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                            androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                            int i13 = 0;
                            cVarG = cVarG;
                            while (cVarI1 != null) {
                                if ((cVarI1.j1() & iA) != 0) {
                                    i13++;
                                    if (i13 == 1) {
                                        cVarG = cVarI1;
                                    } else {
                                        if (bVar == null) {
                                            bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                        }
                                        if (cVarG != 0) {
                                            bVar.b(cVarG);
                                            cVarG = 0;
                                        }
                                        bVar.b(cVarI1);
                                    }
                                }
                                cVarI1 = cVarI1.f1();
                                cVarG = cVarG;
                            }
                            if (i13 == 1) {
                            }
                        }
                        cVarG = g.g(bVar);
                    }
                }
                if (cVarD2 == cVarX1) {
                    break;
                }
            }
        }
        y0 y0VarG0 = X0().g0();
        if (y0VarG0 != null) {
            y0VarG0.onLayoutChange(X0());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    public final void q2() {
        androidx.compose.ui.f.c cVarL1;
        if (b2(s0.a(128))) {
            androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
            androidx.compose.runtime.snapshots.j jVarD = aVar.d();
            Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
            androidx.compose.runtime.snapshots.j jVarF = aVar.f(jVarD);
            try {
                int iA = s0.a(128);
                boolean zI = t0.i(iA);
                if (!zI) {
                    cVarL1 = X1().l1();
                    if (cVarL1 == null) {
                    }
                    Unit unit = Unit.f68710a;
                }
                cVarL1 = X1();
                for (androidx.compose.ui.f.c cVarD2 = d2(zI); cVarD2 != null && (cVarD2.e1() & iA) != 0; cVarD2 = cVarD2.f1()) {
                    if ((cVarD2.j1() & iA) != 0) {
                        androidx.compose.runtime.collection.b bVar = null;
                        androidx.compose.ui.f.c cVarG = cVarD2;
                        while (cVarG != 0) {
                            if (cVarG instanceof w) {
                                ((w) cVarG).l(o0());
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                                androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                                int i11 = 0;
                                cVarG = cVarG;
                                while (cVarI1 != null) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVarG = cVarI1;
                                        } else {
                                            if (bVar == null) {
                                                bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != 0) {
                                                bVar.b(cVarG);
                                                cVarG = 0;
                                            }
                                            bVar.b(cVarI1);
                                        }
                                    }
                                    cVarI1 = cVarI1.f1();
                                    cVarG = cVarG;
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVarG = g.g(bVar);
                        }
                    }
                    if (cVarD2 == cVarL1) {
                        break;
                    }
                }
                Unit unit2 = Unit.f68710a;
            } finally {
                aVar.m(jVarD, jVarF, function1H);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void r2() {
        int iA = s0.a(128);
        boolean zI = t0.i(iA);
        androidx.compose.ui.f.c cVarX1 = X1();
        if (!zI && (cVarX1 = cVarX1.l1()) == null) {
            return;
        }
        for (androidx.compose.ui.f.c cVarD2 = d2(zI); cVarD2 != null && (cVarD2.e1() & iA) != 0; cVarD2 = cVarD2.f1()) {
            if ((cVarD2.j1() & iA) != 0) {
                androidx.compose.ui.f.c cVarG = cVarD2;
                androidx.compose.runtime.collection.b bVar = null;
                while (cVarG != 0) {
                    if (cVarG instanceof w) {
                        ((w) cVarG).m(this);
                    } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                        androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                        int i11 = 0;
                        cVarG = cVarG;
                        while (cVarI1 != null) {
                            if ((cVarI1.j1() & iA) != 0) {
                                i11++;
                                if (i11 == 1) {
                                    cVarG = cVarI1;
                                } else {
                                    if (bVar == null) {
                                        bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                    }
                                    if (cVarG != 0) {
                                        bVar.b(cVarG);
                                        cVarG = 0;
                                    }
                                    bVar.b(cVarI1);
                                }
                            }
                            cVarI1 = cVarI1.f1();
                            cVarG = cVarG;
                        }
                        if (i11 == 1) {
                        }
                    }
                    cVarG = g.g(bVar);
                }
            }
            if (cVarD2 == cVarX1) {
                return;
            }
        }
    }

    public final void s2() {
        this.f5049v = true;
        this.I.invoke();
        y2();
    }

    public void t2(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.f5047t;
        if (nodeCoordinator != null) {
            nodeCoordinator.G1(o1Var, graphicsLayer);
        }
    }

    @Override // androidx.compose.ui.layout.k0
    public void u0(long j11, float f11, GraphicsLayer graphicsLayer) {
        if (!this.f5045r) {
            u2(j11, f11, null, graphicsLayer);
            return;
        }
        j0 j0VarT1 = T1();
        Intrinsics.d(j0VarT1);
        u2(j0VarT1.d1(), f11, null, graphicsLayer);
    }

    public final void u2(long j11, float f11, Function1<? super e4, Unit> function1, GraphicsLayer graphicsLayer) {
        if (graphicsLayer != null) {
            if (!(function1 == null)) {
                h2.a.a("both ways to create layers shouldn't be used together");
            }
            if (this.L != graphicsLayer) {
                this.L = null;
                M2(this, null, false, 2, null);
                this.L = graphicsLayer;
            }
            if (this.K == null) {
                w0 w0VarCreateLayer = f0.b(X0()).createLayer(this.H, this.I, graphicsLayer);
                w0VarCreateLayer.mo60resizeozmzZPI(o0());
                w0VarCreateLayer.mo59movegyyYBs(j11);
                this.K = w0VarCreateLayer;
                X0().m1(true);
                this.I.invoke();
            }
        } else {
            if (this.L != null) {
                this.L = null;
                M2(this, null, false, 2, null);
            }
            M2(this, function1, false, 2, null);
        }
        if (!q2.p.g(d1(), j11)) {
            C2(j11);
            X0().P().I().k1();
            w0 w0Var = this.K;
            if (w0Var != null) {
                w0Var.mo59movegyyYBs(j11);
            } else {
                NodeCoordinator nodeCoordinator = this.f5048u;
                if (nodeCoordinator != null) {
                    nodeCoordinator.i2();
                }
            }
            f1(this);
            y0 y0VarG0 = X0().g0();
            if (y0VarG0 != null) {
                y0VarG0.onLayoutChange(X0());
            }
        }
        this.E = f11;
        if (i1()) {
            return;
        }
        J0(Y0());
    }

    public final void v2(long j11, float f11, Function1<? super e4, Unit> function1, GraphicsLayer graphicsLayer) {
        u2(q2.p.l(j11, e0()), f11, function1, graphicsLayer);
    }

    public final void w2(y1.e eVar, boolean z11, boolean z12) {
        w0 w0Var = this.K;
        if (w0Var != null) {
            if (this.f5050w) {
                if (z12) {
                    long jU1 = U1();
                    float fI = y1.m.i(jU1) / 2.0f;
                    float fG = y1.m.g(jU1) / 2.0f;
                    eVar.e(-fI, -fG, q2.t.g(p()) + fI, q2.t.f(p()) + fG);
                } else if (z11) {
                    eVar.e(0.0f, 0.0f, q2.t.g(p()), q2.t.f(p()));
                }
                if (eVar.f()) {
                    return;
                }
            }
            w0Var.mapBounds(eVar, false);
        }
        float fH = q2.p.h(d1());
        eVar.i(eVar.b() + fH);
        eVar.j(eVar.c() + fH);
        float fI2 = q2.p.i(d1());
        eVar.k(eVar.d() + fI2);
        eVar.h(eVar.a() + fI2);
    }

    @Override // androidx.compose.ui.layout.m
    public long x(androidx.compose.ui.layout.m mVar, long j11, boolean z11) {
        if (mVar instanceof androidx.compose.ui.layout.r) {
            ((androidx.compose.ui.layout.r) mVar).a().m2();
            return y1.g.u(mVar.x(this, y1.g.u(j11), z11));
        }
        NodeCoordinator nodeCoordinatorH2 = H2(mVar);
        nodeCoordinatorH2.m2();
        NodeCoordinator nodeCoordinatorK1 = K1(nodeCoordinatorH2);
        while (nodeCoordinatorH2 != nodeCoordinatorK1) {
            j11 = nodeCoordinatorH2.I2(j11, z11);
            nodeCoordinatorH2 = nodeCoordinatorH2.f5048u;
            Intrinsics.d(nodeCoordinatorH2);
        }
        return D1(nodeCoordinatorK1, j11, z11);
    }

    @Override // androidx.compose.ui.layout.k0
    public void x0(long j11, float f11, Function1<? super e4, Unit> function1) {
        if (!this.f5045r) {
            u2(j11, f11, function1, null);
            return;
        }
        j0 j0VarT1 = T1();
        Intrinsics.d(j0VarT1);
        u2(j0VarT1.d1(), f11, function1, null);
    }

    public final void y2() {
        if (this.K != null) {
            if (this.L != null) {
                this.L = null;
            }
            M2(this, null, false, 2, null);
            LayoutNode.f1(X0(), false, 1, null);
        }
    }

    public final void z2(boolean z11) {
        this.f5046s = z11;
    }
}
