package androidx.compose.ui.node;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.platform.q2;
import androidx.compose.ui.platform.r2;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class LayoutNode implements androidx.compose.runtime.h, androidx.compose.ui.layout.l0, z0, androidx.compose.ui.layout.o, ComposeUiNode, y0.b {
    public static final c L = new c(null);
    public static final int M = 8;
    public static final d N = new b();
    public static final Function0<LayoutNode> O = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };
    public static final r2 P = new a();
    public static final Comparator<LayoutNode> Q = new Comparator() { // from class: androidx.compose.ui.node.b0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return LayoutNode.m((LayoutNode) obj, (LayoutNode) obj2);
        }
    };
    public final q0 A;
    public final LayoutNodeLayoutDelegate B;
    public LayoutNodeSubcompositionsState C;
    public NodeCoordinator D;
    public boolean E;
    public androidx.compose.ui.f F;
    public androidx.compose.ui.f G;
    public Function1<? super y0, Unit> H;
    public Function1<? super y0, Unit> I;
    public boolean J;
    public boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4937d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LayoutNode f4938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n0<LayoutNode> f4940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public androidx.compose.runtime.collection.b<LayoutNode> f4941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LayoutNode f4943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y0 f4944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AndroidViewHolder f4945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4946n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4947o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.compose.ui.semantics.l f4948p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<LayoutNode> f4949q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4950r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public androidx.compose.ui.layout.u f4951s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q2.e f4952t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LayoutDirection f4953u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public r2 f4954v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.compose.runtime.s f4955w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public UsageByParent f4956x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public UsageByParent f4957y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4958z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements r2 {
        @Override // androidx.compose.ui.platform.r2
        public long a() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.r2
        public long b() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.r2
        public long c() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.r2
        public long d() {
            return q2.l.f74241a.a();
        }

        @Override // androidx.compose.ui.platform.r2
        public /* synthetic */ float e() {
            return q2.a(this);
        }

        @Override // androidx.compose.ui.platform.r2
        public float f() {
            return 16.0f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends d {
        public b() {
            super("Undefined intrinsics block and it is required");
        }

        public Void a(androidx.compose.ui.layout.y yVar, List<? extends androidx.compose.ui.layout.t> list, long j11) {
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }

        @Override // androidx.compose.ui.layout.u
        public /* bridge */ /* synthetic */ androidx.compose.ui.layout.w c(androidx.compose.ui.layout.y yVar, List list, long j11) {
            return (androidx.compose.ui.layout.w) a(yVar, list, j11);
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

        public final Function0<LayoutNode> a() {
            return LayoutNode.O;
        }

        public final Comparator<LayoutNode> b() {
            return LayoutNode.Q;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class d implements androidx.compose.ui.layout.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4959a;

        public d(String str) {
            this.f4959a = str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4960a;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f4960a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNode() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public LayoutNode(boolean z11, int i11) {
        this.f4934a = z11;
        this.f4935b = i11;
        this.f4940h = new n0<>(new androidx.compose.runtime.collection.b(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
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
                this.this$0.P().N();
            }
        });
        this.f4949q = new androidx.compose.runtime.collection.b<>(new LayoutNode[16], 0);
        this.f4950r = true;
        this.f4951s = N;
        this.f4952t = f0.f5077a;
        this.f4953u = LayoutDirection.Ltr;
        this.f4954v = P;
        this.f4955w = androidx.compose.runtime.s.W7.a();
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.f4956x = usageByParent;
        this.f4957y = usageByParent;
        this.A = new q0(this);
        this.B = new LayoutNodeLayoutDelegate(this);
        this.E = true;
        this.F = androidx.compose.ui.f.f3863a;
    }

    public /* synthetic */ LayoutNode(boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z11, (i12 & 2) != 0 ? androidx.compose.ui.semantics.n.a() : i11);
    }

    public static /* synthetic */ boolean J0(LayoutNode layoutNode, q2.b bVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bVar = layoutNode.B.z();
        }
        return layoutNode.I0(bVar);
    }

    public static /* synthetic */ boolean W0(LayoutNode layoutNode, q2.b bVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bVar = layoutNode.B.y();
        }
        return layoutNode.V0(bVar);
    }

    public static /* synthetic */ void b1(LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        layoutNode.a1(z11);
    }

    public static /* synthetic */ void d1(LayoutNode layoutNode, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        if ((i11 & 4) != 0) {
            z13 = true;
        }
        layoutNode.c1(z11, z12, z13);
    }

    public static /* synthetic */ void f1(LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        layoutNode.e1(z11);
    }

    public static /* synthetic */ void h1(LayoutNode layoutNode, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        if ((i11 & 4) != 0) {
            z13 = true;
        }
        layoutNode.g1(z11, z12, z13);
    }

    public static final int m(LayoutNode layoutNode, LayoutNode layoutNode2) {
        return layoutNode.n0() == layoutNode2.n0() ? Intrinsics.i(layoutNode.i0(), layoutNode2.i0()) : Float.compare(layoutNode.n0(), layoutNode2.n0());
    }

    private final float n0() {
        return X().d1();
    }

    public static /* synthetic */ String v(LayoutNode layoutNode, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return layoutNode.u(i11);
    }

    public final boolean A() {
        return this.G != null;
    }

    public final void A0() {
        this.B.M();
    }

    public final boolean B() {
        return this.f4958z;
    }

    public final void B0() {
        this.f4948p = null;
        f0.b(this).onSemanticsChange();
    }

    public final List<androidx.compose.ui.layout.t> C() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
        Intrinsics.d(lookaheadPassDelegateU);
        return lookaheadPassDelegateU.L0();
    }

    public final void C0() {
        LayoutNode layoutNode;
        if (this.f4939g > 0) {
            this.f4942j = true;
        }
        if (!this.f4934a || (layoutNode = this.f4943k) == null) {
            return;
        }
        layoutNode.C0();
    }

    public final List<androidx.compose.ui.layout.t> D() {
        return X().W0();
    }

    public boolean D0() {
        return this.f4944l != null;
    }

    public final List<LayoutNode> E() {
        return p0().h();
    }

    public boolean E0() {
        return this.K;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.compose.ui.semantics.l] */
    public final androidx.compose.ui.semantics.l F() {
        if (!D0() || E0()) {
            return null;
        }
        if (!this.A.q(s0.a(8)) || this.f4948p != null) {
            return this.f4948p;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new androidx.compose.ui.semantics.l();
        f0.b(this).getSnapshotObserver().j(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v6 */
            /* JADX WARN: Type inference failed for: r6v7, types: [T, androidx.compose.ui.semantics.l] */
            /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
                java.lang.NullPointerException
                */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                /*
                    r11 = this;
                    androidx.compose.ui.node.LayoutNode r0 = r11.this$0
                    androidx.compose.ui.node.q0 r0 = r0.e0()
                    r1 = 8
                    int r1 = androidx.compose.ui.node.s0.a(r1)
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.semantics.l> r2 = r2
                    int r3 = androidx.compose.ui.node.q0.c(r0)
                    r3 = r3 & r1
                    if (r3 == 0) goto L9d
                    androidx.compose.ui.f$c r0 = r0.o()
                L19:
                    if (r0 == 0) goto L9d
                    int r3 = r0.j1()
                    r3 = r3 & r1
                    if (r3 == 0) goto L97
                    r3 = 0
                    r4 = r0
                    r5 = r3
                L25:
                    if (r4 == 0) goto L97
                    boolean r6 = r4 instanceof androidx.compose.ui.node.i1
                    r7 = 1
                    if (r6 == 0) goto L53
                    androidx.compose.ui.node.i1 r4 = (androidx.compose.ui.node.i1) r4
                    boolean r6 = r4.V()
                    if (r6 == 0) goto L3e
                    androidx.compose.ui.semantics.l r6 = new androidx.compose.ui.semantics.l
                    r6.<init>()
                    r2.element = r6
                    r6.x(r7)
                L3e:
                    boolean r6 = r4.Z0()
                    if (r6 == 0) goto L4b
                    T r6 = r2.element
                    androidx.compose.ui.semantics.l r6 = (androidx.compose.ui.semantics.l) r6
                    r6.y(r7)
                L4b:
                    T r6 = r2.element
                    androidx.compose.ui.semantics.l r6 = (androidx.compose.ui.semantics.l) r6
                    r4.W0(r6)
                    goto L92
                L53:
                    int r6 = r4.j1()
                    r6 = r6 & r1
                    if (r6 == 0) goto L92
                    boolean r6 = r4 instanceof androidx.compose.ui.node.i
                    if (r6 == 0) goto L92
                    r6 = r4
                    androidx.compose.ui.node.i r6 = (androidx.compose.ui.node.i) r6
                    androidx.compose.ui.f$c r6 = r6.I1()
                    r8 = 0
                    r9 = 0
                L67:
                    if (r6 == 0) goto L8f
                    int r10 = r6.j1()
                    r10 = r10 & r1
                    if (r10 == 0) goto L8a
                    int r9 = r9 + 1
                    if (r9 != r7) goto L76
                    r4 = r6
                    goto L8a
                L76:
                    if (r5 != 0) goto L81
                    androidx.compose.runtime.collection.b r5 = new androidx.compose.runtime.collection.b
                    r10 = 16
                    androidx.compose.ui.f$c[] r10 = new androidx.compose.ui.f.c[r10]
                    r5.<init>(r10, r8)
                L81:
                    if (r4 == 0) goto L87
                    r5.b(r4)
                    r4 = r3
                L87:
                    r5.b(r6)
                L8a:
                    androidx.compose.ui.f$c r6 = r6.f1()
                    goto L67
                L8f:
                    if (r9 != r7) goto L92
                    goto L25
                L92:
                    androidx.compose.ui.f$c r4 = androidx.compose.ui.node.g.b(r5)
                    goto L25
                L97:
                    androidx.compose.ui.f$c r0 = r0.l1()
                    goto L19
                L9d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1.invoke2():void");
            }
        });
        T t11 = objectRef.element;
        this.f4948p = (androidx.compose.ui.semantics.l) t11;
        return (androidx.compose.ui.semantics.l) t11;
    }

    public final boolean F0() {
        return X().g1();
    }

    public androidx.compose.runtime.s G() {
        return this.f4955w;
    }

    public final Boolean G0() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
        if (lookaheadPassDelegateU != null) {
            return Boolean.valueOf(lookaheadPassDelegateU.k());
        }
        return null;
    }

    public q2.e H() {
        return this.f4952t;
    }

    public final boolean H0() {
        return this.f4937d;
    }

    public final int I() {
        return this.f4946n;
    }

    public final boolean I0(q2.b bVar) {
        if (bVar == null || this.f4938f == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
        Intrinsics.d(lookaheadPassDelegateU);
        return lookaheadPassDelegateU.j1(bVar.r());
    }

    public final List<LayoutNode> J() {
        return this.f4940h.b();
    }

    public final boolean K() {
        long jR1 = M().R1();
        return q2.b.j(jR1) && q2.b.i(jR1);
    }

    public final void K0() {
        if (this.f4956x == UsageByParent.NotUsed) {
            t();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
        Intrinsics.d(lookaheadPassDelegateU);
        lookaheadPassDelegateU.k1();
    }

    public int L() {
        return this.B.x();
    }

    public final void L0() {
        this.B.O();
    }

    public final NodeCoordinator M() {
        return this.A.l();
    }

    public final void M0() {
        this.B.P();
    }

    public final NodeCoordinator N() {
        if (this.E) {
            NodeCoordinator nodeCoordinatorM = M();
            NodeCoordinator nodeCoordinatorZ1 = f0().Z1();
            this.D = null;
            while (!Intrinsics.b(nodeCoordinatorM, nodeCoordinatorZ1)) {
                if ((nodeCoordinatorM != null ? nodeCoordinatorM.S1() : null) != null) {
                    this.D = nodeCoordinatorM;
                    break;
                }
                nodeCoordinatorM = nodeCoordinatorM != null ? nodeCoordinatorM.Z1() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this.D;
        if (nodeCoordinator == null || nodeCoordinator.S1() != null) {
            return nodeCoordinator;
        }
        h2.a.c("layer was not set");
        throw new KotlinNothingValueException();
    }

    public final void N0() {
        this.B.Q();
    }

    public final UsageByParent O() {
        return this.f4956x;
    }

    public final void O0() {
        this.B.R();
    }

    public final LayoutNodeLayoutDelegate P() {
        return this.B;
    }

    public final void P0(int i11, int i12, int i13) {
        if (i11 == i12) {
            return;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            this.f4940h.a(i11 > i12 ? i12 + i14 : (i12 + i13) - 2, this.f4940h.g(i11 > i12 ? i11 + i14 : i11));
        }
        S0();
        C0();
        y0();
    }

    public final boolean Q() {
        return this.B.A();
    }

    public final void Q0(LayoutNode layoutNode) {
        if (layoutNode.B.s() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.B;
            layoutNodeLayoutDelegate.W(layoutNodeLayoutDelegate.s() - 1);
        }
        if (this.f4944l != null) {
            layoutNode.w();
        }
        layoutNode.f4943k = null;
        layoutNode.f0().E2(null);
        if (layoutNode.f4934a) {
            this.f4939g--;
            androidx.compose.runtime.collection.b<LayoutNode> bVarF = layoutNode.f4940h.f();
            int iR = bVarF.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarF.q();
                int i11 = 0;
                do {
                    layoutNodeArrQ[i11].f0().E2(null);
                    i11++;
                } while (i11 < iR);
            }
        }
        C0();
        S0();
    }

    public final LayoutState R() {
        return this.B.B();
    }

    public final void R0() {
        y0();
        LayoutNode layoutNodeH0 = h0();
        if (layoutNodeH0 != null) {
            layoutNodeH0.w0();
        }
        x0();
    }

    public final boolean S() {
        return this.B.F();
    }

    public final void S0() {
        if (!this.f4934a) {
            this.f4950r = true;
            return;
        }
        LayoutNode layoutNodeH0 = h0();
        if (layoutNodeH0 != null) {
            layoutNodeH0.S0();
        }
    }

    public final boolean T() {
        return this.B.G();
    }

    public final void T0(int i11, int i12) {
        androidx.compose.ui.layout.k0.a placementScope;
        NodeCoordinator nodeCoordinatorM;
        if (this.f4956x == UsageByParent.NotUsed) {
            t();
        }
        LayoutNode layoutNodeH0 = h0();
        if (layoutNodeH0 == null || (nodeCoordinatorM = layoutNodeH0.M()) == null || (placementScope = nodeCoordinatorM.b1()) == null) {
            placementScope = f0.b(this).getPlacementScope();
        }
        androidx.compose.ui.layout.k0.a.l(placementScope, X(), i11, i12, 0.0f, 4, null);
    }

    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate U() {
        return this.B.H();
    }

    public final void U0() {
        if (this.f4942j) {
            int i11 = 0;
            this.f4942j = false;
            androidx.compose.runtime.collection.b<LayoutNode> bVar = this.f4941i;
            if (bVar == null) {
                bVar = new androidx.compose.runtime.collection.b<>(new LayoutNode[16], 0);
                this.f4941i = bVar;
            }
            bVar.i();
            androidx.compose.runtime.collection.b<LayoutNode> bVarF = this.f4940h.f();
            int iR = bVarF.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarF.q();
                do {
                    LayoutNode layoutNode = layoutNodeArrQ[i11];
                    if (layoutNode.f4934a) {
                        bVar.d(bVar.r(), layoutNode.p0());
                    } else {
                        bVar.b(layoutNode);
                    }
                    i11++;
                } while (i11 < iR);
            }
            this.B.N();
        }
    }

    public final LayoutNode V() {
        return this.f4938f;
    }

    public final boolean V0(q2.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this.f4956x == UsageByParent.NotUsed) {
            s();
        }
        return X().q1(bVar.r());
    }

    public final d0 W() {
        return f0.b(this).getSharedDrawScope();
    }

    public final LayoutNodeLayoutDelegate.MeasurePassDelegate X() {
        return this.B.I();
    }

    public final void X0() {
        int iE = this.f4940h.e();
        while (true) {
            iE--;
            if (-1 >= iE) {
                this.f4940h.c();
                return;
            }
            Q0(this.f4940h.d(iE));
        }
    }

    public final boolean Y() {
        return this.B.J();
    }

    public final void Y0(int i11, int i12) {
        if (!(i12 >= 0)) {
            h2.a.a("count (" + i12 + ") must be greater than 0");
        }
        int i13 = (i12 + i11) - 1;
        if (i11 > i13) {
            return;
        }
        while (true) {
            Q0(this.f4940h.d(i13));
            this.f4940h.g(i13);
            if (i13 == i11) {
                return;
            } else {
                i13--;
            }
        }
    }

    public androidx.compose.ui.layout.u Z() {
        return this.f4951s;
    }

    public final void Z0() {
        if (this.f4956x == UsageByParent.NotUsed) {
            t();
        }
        X().r1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void a(LayoutDirection layoutDirection) {
        if (this.f4953u != layoutDirection) {
            this.f4953u = layoutDirection;
            R0();
            q0 q0Var = this.A;
            int iA = s0.a(4);
            if ((q0Var.i() & iA) != 0) {
                for (androidx.compose.ui.f.c cVarK = q0Var.k(); cVarK != null; cVarK = cVarK.f1()) {
                    if ((cVarK.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarK;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != 0) {
                            if (cVarG instanceof n) {
                                n nVar = (n) cVarG;
                                if (nVar instanceof androidx.compose.ui.draw.b) {
                                    ((androidx.compose.ui.draw.b) nVar).x0();
                                }
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
                    if ((cVarK.e1() & iA) == 0) {
                        return;
                    }
                }
            }
        }
    }

    public final UsageByParent a0() {
        return X().Z0();
    }

    public final void a1(boolean z11) {
        y0 y0Var;
        if (this.f4934a || (y0Var = this.f4944l) == null) {
            return;
        }
        y0Var.onRequestRelayout(this, true, z11);
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void b(q2.e eVar) {
        if (Intrinsics.b(this.f4952t, eVar)) {
            return;
        }
        this.f4952t = eVar;
        R0();
        for (androidx.compose.ui.f.c cVarK = this.A.k(); cVarK != null; cVarK = cVarK.f1()) {
            if ((s0.a(16) & cVarK.j1()) != 0) {
                ((e1) cVarK).J0();
            } else if (cVarK instanceof androidx.compose.ui.draw.b) {
                ((androidx.compose.ui.draw.b) cVarK).x0();
            }
        }
    }

    public final UsageByParent b0() {
        UsageByParent usageByParentW0;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
        return (lookaheadPassDelegateU == null || (usageByParentW0 = lookaheadPassDelegateU.W0()) == null) ? UsageByParent.NotUsed : usageByParentW0;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void c(int i11) {
        this.f4936c = i11;
    }

    public androidx.compose.ui.f c0() {
        return this.F;
    }

    public final void c1(boolean z11, boolean z12, boolean z13) {
        if (!(this.f4938f != null)) {
            h2.a.b("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope");
        }
        y0 y0Var = this.f4944l;
        if (y0Var == null || this.f4947o || this.f4934a) {
            return;
        }
        y0Var.onRequestMeasure(this, true, z11, z12);
        if (z13) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
            Intrinsics.d(lookaheadPassDelegateU);
            lookaheadPassDelegateU.Y0(z11);
        }
    }

    @Override // androidx.compose.ui.layout.l0
    public void d() {
        if (this.f4938f != null) {
            d1(this, false, false, false, 5, null);
        } else {
            h1(this, false, false, false, 5, null);
        }
        q2.b bVarY = this.B.y();
        if (bVarY != null) {
            y0 y0Var = this.f4944l;
            if (y0Var != null) {
                y0Var.mo62measureAndLayout0kLqBqw(this, bVarY.r());
                return;
            }
            return;
        }
        y0 y0Var2 = this.f4944l;
        if (y0Var2 != null) {
            x0.c(y0Var2, false, 1, null);
        }
    }

    public final boolean d0() {
        return this.J;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void e(r2 r2Var) {
        if (Intrinsics.b(this.f4954v, r2Var)) {
            return;
        }
        this.f4954v = r2Var;
        q0 q0Var = this.A;
        int iA = s0.a(16);
        if ((q0Var.i() & iA) != 0) {
            for (androidx.compose.ui.f.c cVarK = q0Var.k(); cVarK != null; cVarK = cVarK.f1()) {
                if ((cVarK.j1() & iA) != 0) {
                    androidx.compose.ui.f.c cVarG = cVarK;
                    androidx.compose.runtime.collection.b bVar = null;
                    while (cVarG != 0) {
                        if (cVarG instanceof e1) {
                            ((e1) cVarG).X0();
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
                if ((cVarK.e1() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final q0 e0() {
        return this.A;
    }

    public final void e1(boolean z11) {
        y0 y0Var;
        if (this.f4934a || (y0Var = this.f4944l) == null) {
            return;
        }
        x0.e(y0Var, this, false, z11, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // androidx.compose.ui.node.y0.b
    public void f() {
        NodeCoordinator nodeCoordinatorM = M();
        int iA = s0.a(128);
        boolean zI = t0.i(iA);
        androidx.compose.ui.f.c cVarX1 = nodeCoordinatorM.X1();
        if (!zI && (cVarX1 = cVarX1.l1()) == null) {
            return;
        }
        for (androidx.compose.ui.f.c cVarD2 = nodeCoordinatorM.d2(zI); cVarD2 != null && (cVarD2.e1() & iA) != 0; cVarD2 = cVarD2.f1()) {
            if ((cVarD2.j1() & iA) != 0) {
                androidx.compose.ui.f.c cVarG = cVarD2;
                androidx.compose.runtime.collection.b bVar = null;
                while (cVarG != 0) {
                    if (cVarG instanceof w) {
                        ((w) cVarG).m(M());
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

    public final NodeCoordinator f0() {
        return this.A.n();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void g(androidx.compose.ui.layout.u uVar) {
        if (Intrinsics.b(this.f4951s, uVar)) {
            return;
        }
        this.f4951s = uVar;
        y0();
    }

    public final y0 g0() {
        return this.f4944l;
    }

    public final void g1(boolean z11, boolean z12, boolean z13) {
        y0 y0Var;
        if (this.f4947o || this.f4934a || (y0Var = this.f4944l) == null) {
            return;
        }
        x0.d(y0Var, this, false, z11, z12, 2, null);
        if (z13) {
            X().e1(z11);
        }
    }

    @Override // androidx.compose.ui.layout.o
    public LayoutDirection getLayoutDirection() {
        return this.f4953u;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void h(androidx.compose.ui.f fVar) {
        if (!(!this.f4934a || c0() == androidx.compose.ui.f.f3863a)) {
            h2.a.a("Modifiers are not supported on virtual LayoutNodes");
        }
        if (!(!E0())) {
            h2.a.a("modifier is updated when deactivated");
        }
        if (D0()) {
            q(fVar);
        } else {
            this.G = fVar;
        }
    }

    public final LayoutNode h0() {
        LayoutNode layoutNode = this.f4943k;
        while (layoutNode != null && layoutNode.f4934a) {
            layoutNode = layoutNode.f4943k;
        }
        return layoutNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void i(androidx.compose.runtime.s r10) {
        /*
            r9 = this;
            r9.f4955w = r10
            androidx.compose.runtime.s1 r0 = androidx.compose.ui.platform.CompositionLocalsKt.c()
            java.lang.Object r0 = r10.a(r0)
            q2.e r0 = (q2.e) r0
            r9.b(r0)
            androidx.compose.runtime.s1 r0 = androidx.compose.ui.platform.CompositionLocalsKt.g()
            java.lang.Object r0 = r10.a(r0)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r9.a(r0)
            androidx.compose.runtime.s1 r0 = androidx.compose.ui.platform.CompositionLocalsKt.k()
            java.lang.Object r10 = r10.a(r0)
            androidx.compose.ui.platform.r2 r10 = (androidx.compose.ui.platform.r2) r10
            r9.e(r10)
            androidx.compose.ui.node.q0 r10 = r9.A
            r0 = 32768(0x8000, float:4.5918E-41)
            int r0 = androidx.compose.ui.node.s0.a(r0)
            int r1 = androidx.compose.ui.node.q0.c(r10)
            r1 = r1 & r0
            if (r1 == 0) goto Lb4
            androidx.compose.ui.f$c r10 = r10.k()
        L3d:
            if (r10 == 0) goto Lb4
            int r1 = r10.j1()
            r1 = r1 & r0
            if (r1 == 0) goto La8
            r1 = 0
            r2 = r10
            r3 = r1
        L49:
            if (r2 == 0) goto La8
            boolean r4 = r2 instanceof androidx.compose.ui.node.d
            r5 = 1
            if (r4 == 0) goto L64
            androidx.compose.ui.node.d r2 = (androidx.compose.ui.node.d) r2
            androidx.compose.ui.f$c r2 = r2.getNode()
            boolean r4 = r2.o1()
            if (r4 == 0) goto L60
            androidx.compose.ui.node.t0.e(r2)
            goto La3
        L60:
            r2.E1(r5)
            goto La3
        L64:
            int r4 = r2.j1()
            r4 = r4 & r0
            if (r4 == 0) goto La3
            boolean r4 = r2 instanceof androidx.compose.ui.node.i
            if (r4 == 0) goto La3
            r4 = r2
            androidx.compose.ui.node.i r4 = (androidx.compose.ui.node.i) r4
            androidx.compose.ui.f$c r4 = r4.I1()
            r6 = 0
            r7 = 0
        L78:
            if (r4 == 0) goto La0
            int r8 = r4.j1()
            r8 = r8 & r0
            if (r8 == 0) goto L9b
            int r7 = r7 + 1
            if (r7 != r5) goto L87
            r2 = r4
            goto L9b
        L87:
            if (r3 != 0) goto L92
            androidx.compose.runtime.collection.b r3 = new androidx.compose.runtime.collection.b
            r8 = 16
            androidx.compose.ui.f$c[] r8 = new androidx.compose.ui.f.c[r8]
            r3.<init>(r8, r6)
        L92:
            if (r2 == 0) goto L98
            r3.b(r2)
            r2 = r1
        L98:
            r3.b(r4)
        L9b:
            androidx.compose.ui.f$c r4 = r4.f1()
            goto L78
        La0:
            if (r7 != r5) goto La3
            goto L49
        La3:
            androidx.compose.ui.f$c r2 = androidx.compose.ui.node.g.b(r3)
            goto L49
        La8:
            int r1 = r10.e1()
            r1 = r1 & r0
            if (r1 == 0) goto Lb4
            androidx.compose.ui.f$c r10 = r10.f1()
            goto L3d
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.i(androidx.compose.runtime.s):void");
    }

    public final int i0() {
        return X().b1();
    }

    public final void i1(LayoutNode layoutNode) {
        if (e.f4960a[layoutNode.R().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + layoutNode.R());
        }
        if (layoutNode.T()) {
            d1(layoutNode, true, false, false, 6, null);
            return;
        }
        if (layoutNode.S()) {
            layoutNode.a1(true);
        }
        if (layoutNode.Y()) {
            h1(layoutNode, true, false, false, 6, null);
        } else if (layoutNode.Q()) {
            layoutNode.e1(true);
        }
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return D0();
    }

    public int j0() {
        return this.f4935b;
    }

    public final void j1() {
        this.A.x();
    }

    @Override // androidx.compose.ui.layout.o
    public boolean k() {
        return X().k();
    }

    public final LayoutNodeSubcompositionsState k0() {
        return this.C;
    }

    public final void k1() {
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArrQ[i11];
                UsageByParent usageByParent = layoutNode.f4957y;
                layoutNode.f4956x = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.k1();
                }
                i11++;
            } while (i11 < iR);
        }
    }

    @Override // androidx.compose.ui.layout.o
    public androidx.compose.ui.layout.m l() {
        return M();
    }

    public r2 l0() {
        return this.f4954v;
    }

    public final void l1(boolean z11) {
        this.f4958z = z11;
    }

    public int m0() {
        return this.B.L();
    }

    public final void m1(boolean z11) {
        this.E = z11;
    }

    public final void n1(AndroidViewHolder androidViewHolder) {
        this.f4945m = androidViewHolder;
    }

    public final androidx.compose.runtime.collection.b<LayoutNode> o0() {
        if (this.f4950r) {
            this.f4949q.i();
            androidx.compose.runtime.collection.b<LayoutNode> bVar = this.f4949q;
            bVar.d(bVar.r(), p0());
            this.f4949q.E(Q);
            this.f4950r = false;
        }
        return this.f4949q;
    }

    public final void o1(LayoutNode layoutNode) {
        if (Intrinsics.b(layoutNode, this.f4938f)) {
            return;
        }
        this.f4938f = layoutNode;
        if (layoutNode != null) {
            this.B.q();
            NodeCoordinator nodeCoordinatorY1 = M().Y1();
            for (NodeCoordinator nodeCoordinatorF0 = f0(); !Intrinsics.b(nodeCoordinatorF0, nodeCoordinatorY1) && nodeCoordinatorF0 != null; nodeCoordinatorF0 = nodeCoordinatorF0.Y1()) {
                nodeCoordinatorF0.J1();
            }
        }
        y0();
    }

    @Override // androidx.compose.runtime.h
    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.f4945m;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.C;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onDeactivate();
        }
        this.K = true;
        j1();
        if (D0()) {
            B0();
        }
    }

    @Override // androidx.compose.runtime.h
    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.f4945m;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.C;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeCoordinator nodeCoordinatorY1 = M().Y1();
        for (NodeCoordinator nodeCoordinatorF0 = f0(); !Intrinsics.b(nodeCoordinatorF0, nodeCoordinatorY1) && nodeCoordinatorF0 != null; nodeCoordinatorF0 = nodeCoordinatorF0.Y1()) {
            nodeCoordinatorF0.s2();
        }
    }

    @Override // androidx.compose.runtime.h
    public void onReuse() {
        if (!D0()) {
            h2.a.a("onReuse is only expected on attached node");
        }
        AndroidViewHolder androidViewHolder = this.f4945m;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.C;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onReuse();
        }
        if (E0()) {
            this.K = false;
            B0();
        } else {
            j1();
        }
        s1(androidx.compose.ui.semantics.n.a());
        this.A.s();
        this.A.y();
        i1(this);
    }

    public final androidx.compose.runtime.collection.b<LayoutNode> p0() {
        u1();
        if (this.f4939g == 0) {
            return this.f4940h.f();
        }
        androidx.compose.runtime.collection.b<LayoutNode> bVar = this.f4941i;
        Intrinsics.d(bVar);
        return bVar;
    }

    public final void p1(boolean z11) {
        this.J = z11;
    }

    public final void q(androidx.compose.ui.f fVar) {
        this.F = fVar;
        this.A.E(fVar);
        this.B.c0();
        if (this.f4938f == null && this.A.q(s0.a(512))) {
            o1(this);
        }
    }

    public final void q0(long j11, q qVar, boolean z11, boolean z12) {
        f0().g2(NodeCoordinator.M.a(), NodeCoordinator.M1(f0(), j11, false, 2, null), qVar, z11, z12);
    }

    public final void q1(Function1<? super y0, Unit> function1) {
        this.H = function1;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    public final void r(y0 y0Var) {
        boolean z11;
        LayoutNode layoutNode;
        int i11 = 0;
        if (!(this.f4944l == null)) {
            h2.a.b("Cannot attach " + this + " as it already is attached.  Tree: " + v(this, 0, 1, null));
        }
        LayoutNode layoutNode2 = this.f4943k;
        if (layoutNode2 == null) {
            z11 = true;
        } else if (Intrinsics.b(layoutNode2 != null ? layoutNode2.f4944l : null, y0Var)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Attaching to a different owner(");
            sb2.append(y0Var);
            sb2.append(") than the parent's owner(");
            LayoutNode layoutNodeH0 = h0();
            sb2.append(layoutNodeH0 != null ? layoutNodeH0.f4944l : null);
            sb2.append("). This tree: ");
            sb2.append(v(this, 0, 1, null));
            sb2.append(" Parent tree: ");
            LayoutNode layoutNode3 = this.f4943k;
            sb2.append(layoutNode3 != null ? v(layoutNode3, 0, 1, null) : null);
            h2.a.b(sb2.toString());
        }
        LayoutNode layoutNodeH1 = h0();
        if (layoutNodeH1 == null) {
            X().u1(true);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
            if (lookaheadPassDelegateU != null) {
                lookaheadPassDelegateU.o1(true);
            }
        }
        f0().E2(layoutNodeH1 != null ? layoutNodeH1.M() : null);
        this.f4944l = y0Var;
        this.f4946n = (layoutNodeH1 != null ? layoutNodeH1.f4946n : -1) + 1;
        androidx.compose.ui.f fVar = this.G;
        if (fVar != null) {
            q(fVar);
        }
        this.G = null;
        if (this.A.q(s0.a(8))) {
            B0();
        }
        y0Var.onAttach(this);
        if (this.f4937d) {
            o1(this);
        } else {
            LayoutNode layoutNode4 = this.f4943k;
            if (layoutNode4 == null || (layoutNode = layoutNode4.f4938f) == null) {
                layoutNode = this.f4938f;
            }
            o1(layoutNode);
            if (this.f4938f == null && this.A.q(s0.a(512))) {
                o1(this);
            }
        }
        if (!E0()) {
            this.A.s();
        }
        androidx.compose.runtime.collection.b<LayoutNode> bVarF = this.f4940h.f();
        int iR = bVarF.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarF.q();
            do {
                layoutNodeArrQ[i11].r(y0Var);
                i11++;
            } while (i11 < iR);
        }
        if (!E0()) {
            this.A.y();
        }
        y0();
        if (layoutNodeH1 != null) {
            layoutNodeH1.y0();
        }
        NodeCoordinator nodeCoordinatorY1 = M().Y1();
        for (NodeCoordinator nodeCoordinatorF0 = f0(); !Intrinsics.b(nodeCoordinatorF0, nodeCoordinatorY1) && nodeCoordinatorF0 != null; nodeCoordinatorF0 = nodeCoordinatorF0.Y1()) {
            nodeCoordinatorF0.o2();
        }
        Function1<? super y0, Unit> function1 = this.H;
        if (function1 != null) {
            function1.invoke(y0Var);
        }
        this.B.c0();
        if (E0()) {
            return;
        }
        v0();
    }

    public final void r1(Function1<? super y0, Unit> function1) {
        this.I = function1;
    }

    public final void s() {
        this.f4957y = this.f4956x;
        this.f4956x = UsageByParent.NotUsed;
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArrQ[i11];
                if (layoutNode.f4956x != UsageByParent.NotUsed) {
                    layoutNode.s();
                }
                i11++;
            } while (i11 < iR);
        }
    }

    public final void s0(long j11, q qVar, boolean z11, boolean z12) {
        f0().g2(NodeCoordinator.M.b(), NodeCoordinator.M1(f0(), j11, false, 2, null), qVar, true, z12);
    }

    public void s1(int i11) {
        this.f4935b = i11;
    }

    public final void t() {
        this.f4957y = this.f4956x;
        this.f4956x = UsageByParent.NotUsed;
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArrQ[i11];
                if (layoutNode.f4956x == UsageByParent.InLayoutBlock) {
                    layoutNode.t();
                }
                i11++;
            } while (i11 < iR);
        }
    }

    public final void t1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.C = layoutNodeSubcompositionsState;
    }

    public String toString() {
        return androidx.compose.ui.platform.h1.a(this, null) + " children: " + E().size() + " measurePolicy: " + Z();
    }

    public final String u(int i11) {
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("  ");
        }
        sb2.append("|-");
        sb2.append(toString());
        sb2.append('\n');
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i13 = 0;
            do {
                sb2.append(layoutNodeArrQ[i13].u(i11 + 1));
                i13++;
            } while (i13 < iR);
        }
        String string = sb2.toString();
        if (i11 != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final void u0(int i11, LayoutNode layoutNode) {
        if (!(layoutNode.f4943k == null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot insert ");
            sb2.append(layoutNode);
            sb2.append(" because it already has a parent. This tree: ");
            sb2.append(v(this, 0, 1, null));
            sb2.append(" Other tree: ");
            LayoutNode layoutNode2 = layoutNode.f4943k;
            sb2.append(layoutNode2 != null ? v(layoutNode2, 0, 1, null) : null);
            h2.a.b(sb2.toString());
        }
        if (!(layoutNode.f4944l == null)) {
            h2.a.b("Cannot insert " + layoutNode + " because it already has an owner. This tree: " + v(this, 0, 1, null) + " Other tree: " + v(layoutNode, 0, 1, null));
        }
        layoutNode.f4943k = this;
        this.f4940h.a(i11, layoutNode);
        S0();
        if (layoutNode.f4934a) {
            this.f4939g++;
        }
        C0();
        y0 y0Var = this.f4944l;
        if (y0Var != null) {
            layoutNode.r(y0Var);
        }
        if (layoutNode.B.s() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.B;
            layoutNodeLayoutDelegate.W(layoutNodeLayoutDelegate.s() + 1);
        }
    }

    public final void u1() {
        if (this.f4939g > 0) {
            U0();
        }
    }

    public final void v0() {
        if (this.A.p(s0.a(1024) | s0.a(2048) | s0.a(4096))) {
            for (androidx.compose.ui.f.c cVarK = this.A.k(); cVarK != null; cVarK = cVarK.f1()) {
                if (((s0.a(1024) & cVarK.j1()) != 0) | ((s0.a(2048) & cVarK.j1()) != 0) | ((s0.a(4096) & cVarK.j1()) != 0)) {
                    t0.a(cVarK);
                }
            }
        }
    }

    public final void w() {
        y0 y0Var = this.f4944l;
        if (y0Var == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode layoutNodeH0 = h0();
            sb2.append(layoutNodeH0 != null ? v(layoutNodeH0, 0, 1, null) : null);
            h2.a.c(sb2.toString());
            throw new KotlinNothingValueException();
        }
        LayoutNode layoutNodeH1 = h0();
        if (layoutNodeH1 != null) {
            layoutNodeH1.w0();
            layoutNodeH1.y0();
            LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegateX = X();
            UsageByParent usageByParent = UsageByParent.NotUsed;
            measurePassDelegateX.t1(usageByParent);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = U();
            if (lookaheadPassDelegateU != null) {
                lookaheadPassDelegateU.m1(usageByParent);
            }
        }
        this.B.V();
        Function1<? super y0, Unit> function1 = this.I;
        if (function1 != null) {
            function1.invoke(y0Var);
        }
        if (this.A.q(s0.a(8))) {
            B0();
        }
        this.A.z();
        this.f4947o = true;
        androidx.compose.runtime.collection.b<LayoutNode> bVarF = this.f4940h.f();
        int iR = bVarF.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarF.q();
            int i11 = 0;
            do {
                layoutNodeArrQ[i11].w();
                i11++;
            } while (i11 < iR);
        }
        this.f4947o = false;
        this.A.t();
        y0Var.onDetach(this);
        this.f4944l = null;
        o1(null);
        this.f4946n = 0;
        X().m1();
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU2 = U();
        if (lookaheadPassDelegateU2 != null) {
            lookaheadPassDelegateU2.g1();
        }
    }

    public final void w0() {
        NodeCoordinator nodeCoordinatorN = N();
        if (nodeCoordinatorN != null) {
            nodeCoordinatorN.i2();
            return;
        }
        LayoutNode layoutNodeH0 = h0();
        if (layoutNodeH0 != null) {
            layoutNodeH0.w0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void x() {
        if (R() != LayoutState.Idle || Q() || Y() || E0() || !k()) {
            return;
        }
        q0 q0Var = this.A;
        int iA = s0.a(256);
        if ((q0Var.i() & iA) != 0) {
            for (androidx.compose.ui.f.c cVarK = q0Var.k(); cVarK != null; cVarK = cVarK.f1()) {
                if ((cVarK.j1() & iA) != 0) {
                    androidx.compose.ui.f.c cVarG = cVarK;
                    androidx.compose.runtime.collection.b bVar = null;
                    while (cVarG != 0) {
                        if (cVarG instanceof p) {
                            p pVar = (p) cVarG;
                            pVar.x(g.h(pVar, s0.a(256)));
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
                if ((cVarK.e1() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final void x0() {
        NodeCoordinator nodeCoordinatorF0 = f0();
        NodeCoordinator nodeCoordinatorM = M();
        while (nodeCoordinatorF0 != nodeCoordinatorM) {
            Intrinsics.e(nodeCoordinatorF0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            y yVar = (y) nodeCoordinatorF0;
            w0 w0VarS1 = yVar.S1();
            if (w0VarS1 != null) {
                w0VarS1.invalidate();
            }
            nodeCoordinatorF0 = yVar.Y1();
        }
        w0 w0VarS2 = M().S1();
        if (w0VarS2 != null) {
            w0VarS2.invalidate();
        }
    }

    public final void y(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        f0().G1(o1Var, graphicsLayer);
    }

    public final void y0() {
        if (this.f4938f != null) {
            d1(this, false, false, false, 7, null);
        } else {
            h1(this, false, false, false, 7, null);
        }
    }

    public final boolean z() {
        AlignmentLines alignmentLinesL;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.B;
        if (layoutNodeLayoutDelegate.r().l().k()) {
            return true;
        }
        androidx.compose.ui.node.a aVarC = layoutNodeLayoutDelegate.C();
        return (aVarC == null || (alignmentLinesL = aVarC.l()) == null || !alignmentLinesL.k()) ? false : true;
    }

    public final void z0() {
        if (Q() || Y() || this.J) {
            return;
        }
        f0.b(this).requestOnPositionedCallback(this);
    }
}
