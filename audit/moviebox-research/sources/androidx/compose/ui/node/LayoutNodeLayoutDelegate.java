package androidx.compose.ui.node;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class LayoutNodeLayoutDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutNode f4961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4962b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4972l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4973m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4974n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4975o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4976p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4977q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LookaheadPassDelegate f4979s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutNode.LayoutState f4963c = LayoutNode.LayoutState.Idle;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MeasurePassDelegate f4978r = new MeasurePassDelegate();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f4980t = q2.c.b(0, 0, 0, 0, 15, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function0<Unit> f4981u = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1
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
            this.this$0.K().L(this.this$0.f4980t);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class LookaheadPassDelegate extends androidx.compose.ui.layout.k0 implements androidx.compose.ui.layout.t, androidx.compose.ui.node.a, m0 {
        public boolean A;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4982g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f4986k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f4987l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4988m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public q2.b f4989n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f4991p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Function1<? super e4, Unit> f4992q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public GraphicsLayer f4993r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f4994s;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f4998w;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f5001z;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4983h = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4984i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public LayoutNode.UsageByParent f4985j = LayoutNode.UsageByParent.NotUsed;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f4990o = q2.p.f74244b.a();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final AlignmentLines f4995t = new i0(this);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final androidx.compose.runtime.collection.b<LookaheadPassDelegate> f4996u = new androidx.compose.runtime.collection.b<>(new LookaheadPassDelegate[16], 0);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f4997v = true;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f4999x = true;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Object f5000y = U0().F();

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5002a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f5003b;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f5002a = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                f5003b = iArr2;
            }
        }

        public LookaheadPassDelegate() {
        }

        private final void i1(final long j11, float f11, Function1<? super e4, Unit> function1, GraphicsLayer graphicsLayer) {
            if (!(!LayoutNodeLayoutDelegate.this.f4961a.E0())) {
                h2.a.a("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.this.f4963c = LayoutNode.LayoutState.LookaheadLayingOut;
            this.f4987l = true;
            this.A = false;
            if (!q2.p.g(j11, this.f4990o)) {
                if (LayoutNodeLayoutDelegate.this.D() || LayoutNodeLayoutDelegate.this.E()) {
                    LayoutNodeLayoutDelegate.this.f4968h = true;
                }
                e1();
            }
            final y0 y0VarB = f0.b(LayoutNodeLayoutDelegate.this.f4961a);
            if (LayoutNodeLayoutDelegate.this.F() || !k()) {
                LayoutNodeLayoutDelegate.this.a0(false);
                l().r(false);
                OwnerSnapshotObserver snapshotObserver = y0VarB.getSnapshotObserver();
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                OwnerSnapshotObserver.d(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeSelf$2
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
                        j0 j0VarT1;
                        androidx.compose.ui.layout.k0.a aVarB1 = null;
                        if (g0.a(layoutNodeLayoutDelegate.f4961a)) {
                            NodeCoordinator nodeCoordinatorZ1 = layoutNodeLayoutDelegate.K().Z1();
                            if (nodeCoordinatorZ1 != null) {
                                aVarB1 = nodeCoordinatorZ1.b1();
                            }
                        } else {
                            NodeCoordinator nodeCoordinatorZ2 = layoutNodeLayoutDelegate.K().Z1();
                            if (nodeCoordinatorZ2 != null && (j0VarT1 = nodeCoordinatorZ2.T1()) != null) {
                                aVarB1 = j0VarT1.b1();
                            }
                        }
                        if (aVarB1 == null) {
                            aVarB1 = y0VarB.getPlacementScope();
                        }
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNodeLayoutDelegate;
                        long j12 = j11;
                        j0 j0VarT2 = layoutNodeLayoutDelegate2.K().T1();
                        Intrinsics.d(j0VarT2);
                        androidx.compose.ui.layout.k0.a.j(aVarB1, j0VarT2, j12, 0.0f, 2, null);
                    }
                }, 2, null);
            } else {
                j0 j0VarT1 = LayoutNodeLayoutDelegate.this.K().T1();
                Intrinsics.d(j0VarT1);
                j0VarT1.z1(j11);
                h1();
            }
            this.f4990o = j11;
            this.f4991p = f11;
            this.f4992q = function1;
            this.f4993r = graphicsLayer;
            LayoutNodeLayoutDelegate.this.f4963c = LayoutNode.LayoutState.Idle;
        }

        @Override // androidx.compose.ui.node.a
        public androidx.compose.ui.node.a C() {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateP;
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            if (layoutNodeH0 == null || (layoutNodeLayoutDelegateP = layoutNodeH0.P()) == null) {
                return null;
            }
            return layoutNodeLayoutDelegateP.C();
        }

        @Override // androidx.compose.ui.layout.k0, androidx.compose.ui.layout.j
        public Object F() {
            return this.f5000y;
        }

        public final void F0() {
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LookaheadPassDelegate lookaheadPassDelegateH = layoutNodeArrQ[i11].P().H();
                    Intrinsics.d(lookaheadPassDelegateH);
                    int i12 = lookaheadPassDelegateH.f4983h;
                    int i13 = lookaheadPassDelegateH.f4984i;
                    if (i12 != i13 && i13 == Integer.MAX_VALUE) {
                        lookaheadPassDelegateH.d1();
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        @Override // androidx.compose.ui.node.a
        public void G() {
            this.f4998w = true;
            l().o();
            if (LayoutNodeLayoutDelegate.this.F()) {
                f1();
            }
            final j0 j0VarT1 = I().T1();
            Intrinsics.d(j0VarT1);
            if (LayoutNodeLayoutDelegate.this.f4969i || (!this.f4986k && !j0VarT1.i1() && LayoutNodeLayoutDelegate.this.F())) {
                LayoutNodeLayoutDelegate.this.f4968h = false;
                LayoutNode.LayoutState layoutStateB = LayoutNodeLayoutDelegate.this.B();
                LayoutNodeLayoutDelegate.this.f4963c = LayoutNode.LayoutState.LookaheadLayingOut;
                y0 y0VarB = f0.b(LayoutNodeLayoutDelegate.this.f4961a);
                LayoutNodeLayoutDelegate.this.b0(false);
                OwnerSnapshotObserver snapshotObserver = y0VarB.getSnapshotObserver();
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                OwnerSnapshotObserver.f(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1
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
                        this.this$0.J0();
                        this.this$0.S(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                                invoke2(aVar);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a aVar) {
                                aVar.l().t(false);
                            }
                        });
                        j0 j0VarT2 = this.this$0.I().T1();
                        if (j0VarT2 != null) {
                            boolean zI1 = j0VarT2.i1();
                            List<LayoutNode> listE = layoutNodeLayoutDelegate.f4961a.E();
                            int size = listE.size();
                            for (int i11 = 0; i11 < size; i11++) {
                                j0 j0VarT3 = listE.get(i11).f0().T1();
                                if (j0VarT3 != null) {
                                    j0VarT3.m1(zI1);
                                }
                            }
                        }
                        j0VarT1.Y0().m();
                        j0 j0VarT4 = this.this$0.I().T1();
                        if (j0VarT4 != null) {
                            j0VarT4.i1();
                            List<LayoutNode> listE2 = layoutNodeLayoutDelegate.f4961a.E();
                            int size2 = listE2.size();
                            for (int i12 = 0; i12 < size2; i12++) {
                                j0 j0VarT5 = listE2.get(i12).f0().T1();
                                if (j0VarT5 != null) {
                                    j0VarT5.m1(false);
                                }
                            }
                        }
                        this.this$0.F0();
                        this.this$0.S(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                                invoke2(aVar);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a aVar) {
                                aVar.l().q(aVar.l().l());
                            }
                        });
                    }
                }, 2, null);
                LayoutNodeLayoutDelegate.this.f4963c = layoutStateB;
                if (LayoutNodeLayoutDelegate.this.E() && j0VarT1.i1()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.f4969i = false;
            }
            if (l().l()) {
                l().q(true);
            }
            if (l().g() && l().k()) {
                l().n();
            }
            this.f4998w = false;
        }

        @Override // androidx.compose.ui.node.a
        public NodeCoordinator I() {
            return LayoutNodeLayoutDelegate.this.f4961a.M();
        }

        public final void J0() {
            int i11 = 0;
            LayoutNodeLayoutDelegate.this.f4970j = 0;
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                do {
                    LookaheadPassDelegate lookaheadPassDelegateH = layoutNodeArrQ[i11].P().H();
                    Intrinsics.d(lookaheadPassDelegateH);
                    lookaheadPassDelegateH.f4983h = lookaheadPassDelegateH.f4984i;
                    lookaheadPassDelegateH.f4984i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    if (lookaheadPassDelegateH.f4985j == LayoutNode.UsageByParent.InLayoutBlock) {
                        lookaheadPassDelegateH.f4985j = LayoutNode.UsageByParent.NotUsed;
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x002b  */
        @Override // androidx.compose.ui.layout.t
        public androidx.compose.ui.layout.k0 L(long j11) {
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            if ((layoutNodeH0 != null ? layoutNodeH0.R() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
                LayoutNodeLayoutDelegate.this.f4962b = false;
            } else {
                LayoutNode layoutNodeH1 = LayoutNodeLayoutDelegate.this.f4961a.h0();
                if ((layoutNodeH1 != null ? layoutNodeH1.R() : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                    LayoutNodeLayoutDelegate.this.f4962b = false;
                }
            }
            p1(LayoutNodeLayoutDelegate.this.f4961a);
            if (LayoutNodeLayoutDelegate.this.f4961a.O() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.this.f4961a.s();
            }
            j1(j11);
            return this;
        }

        public final List<LookaheadPassDelegate> L0() {
            LayoutNodeLayoutDelegate.this.f4961a.E();
            if (!this.f4997v) {
                return this.f4996u.h();
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
            androidx.compose.runtime.collection.b<LookaheadPassDelegate> bVar = this.f4996u;
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                    if (bVar.r() <= i11) {
                        LookaheadPassDelegate lookaheadPassDelegateH = layoutNode2.P().H();
                        Intrinsics.d(lookaheadPassDelegateH);
                        bVar.b(lookaheadPassDelegateH);
                    } else {
                        LookaheadPassDelegate lookaheadPassDelegateH2 = layoutNode2.P().H();
                        Intrinsics.d(lookaheadPassDelegateH2);
                        bVar.C(i11, lookaheadPassDelegateH2);
                    }
                    i11++;
                } while (i11 < iR);
            }
            bVar.A(layoutNode.E().size(), bVar.r());
            this.f4997v = false;
            return this.f4996u.h();
        }

        public final q2.b O0() {
            return this.f4989n;
        }

        public final boolean R0() {
            return this.f4998w;
        }

        @Override // androidx.compose.ui.node.a
        public void S(Function1<? super androidx.compose.ui.node.a, Unit> function1) {
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    androidx.compose.ui.node.a aVarC = layoutNodeArrQ[i11].P().C();
                    Intrinsics.d(aVarC);
                    function1.invoke(aVarC);
                    i11++;
                } while (i11 < iR);
            }
        }

        @Override // androidx.compose.ui.node.m0
        public void T(boolean z11) {
            j0 j0VarT1;
            j0 j0VarT2 = LayoutNodeLayoutDelegate.this.K().T1();
            if (!Intrinsics.b(Boolean.valueOf(z11), j0VarT2 != null ? Boolean.valueOf(j0VarT2.h1()) : null) && (j0VarT1 = LayoutNodeLayoutDelegate.this.K().T1()) != null) {
                j0VarT1.T(z11);
            }
            this.f5001z = z11;
        }

        public final MeasurePassDelegate U0() {
            return LayoutNodeLayoutDelegate.this.I();
        }

        @Override // androidx.compose.ui.node.a
        public void W() {
            LayoutNode.d1(LayoutNodeLayoutDelegate.this.f4961a, false, false, false, 7, null);
        }

        public final LayoutNode.UsageByParent W0() {
            return this.f4985j;
        }

        public final boolean X0() {
            return this.f4987l;
        }

        public final void Y0(boolean z11) {
            LayoutNode layoutNode;
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            LayoutNode.UsageByParent usageByParentO = LayoutNodeLayoutDelegate.this.f4961a.O();
            if (layoutNodeH0 == null || usageByParentO == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            do {
                layoutNode = layoutNodeH0;
                if (layoutNode.O() != usageByParentO) {
                    break;
                } else {
                    layoutNodeH0 = layoutNode.h0();
                }
            } while (layoutNodeH0 != null);
            int i11 = a.f5003b[usageByParentO.ordinal()];
            if (i11 == 1) {
                if (layoutNode.V() != null) {
                    LayoutNode.d1(layoutNode, z11, false, false, 6, null);
                    return;
                } else {
                    LayoutNode.h1(layoutNode, z11, false, false, 6, null);
                    return;
                }
            }
            if (i11 != 2) {
                throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
            }
            if (layoutNode.V() != null) {
                layoutNode.a1(z11);
            } else {
                layoutNode.e1(z11);
            }
        }

        public final void Z0() {
            this.f4999x = true;
        }

        public final void b1() {
            boolean zK = k();
            o1(true);
            if (!zK && LayoutNodeLayoutDelegate.this.G()) {
                LayoutNode.d1(LayoutNodeLayoutDelegate.this.f4961a, true, false, false, 6, null);
            }
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNode layoutNode = layoutNodeArrQ[i11];
                    LookaheadPassDelegate lookaheadPassDelegateU = layoutNode.U();
                    if (lookaheadPassDelegateU == null) {
                        throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.".toString());
                    }
                    if (lookaheadPassDelegateU.f4984i != Integer.MAX_VALUE) {
                        lookaheadPassDelegateU.b1();
                        layoutNode.i1(layoutNode);
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        public final void d1() {
            if (k()) {
                int i11 = 0;
                o1(false);
                androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
                int iR = bVarP0.r();
                if (iR > 0) {
                    LayoutNode[] layoutNodeArrQ = bVarP0.q();
                    do {
                        LookaheadPassDelegate lookaheadPassDelegateH = layoutNodeArrQ[i11].P().H();
                        Intrinsics.d(lookaheadPassDelegateH);
                        lookaheadPassDelegateH.d1();
                        i11++;
                    } while (i11 < iR);
                }
            }
        }

        public final void e1() {
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0;
            int iR;
            if (LayoutNodeLayoutDelegate.this.t() <= 0 || (iR = (bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0()).r()) <= 0) {
                return;
            }
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArrQ[i11];
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegateP = layoutNode.P();
                if ((layoutNodeLayoutDelegateP.E() || layoutNodeLayoutDelegateP.D()) && !layoutNodeLayoutDelegateP.F()) {
                    LayoutNode.b1(layoutNode, false, 1, null);
                }
                LookaheadPassDelegate lookaheadPassDelegateH = layoutNodeLayoutDelegateP.H();
                if (lookaheadPassDelegateH != null) {
                    lookaheadPassDelegateH.e1();
                }
                i11++;
            } while (i11 < iR);
        }

        public final void f1() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                    if (layoutNode2.T() && layoutNode2.b0() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegateH = layoutNode2.P().H();
                        Intrinsics.d(lookaheadPassDelegateH);
                        q2.b bVarZ = layoutNode2.P().z();
                        Intrinsics.d(bVarZ);
                        if (lookaheadPassDelegateH.j1(bVarZ.r())) {
                            LayoutNode.d1(layoutNodeLayoutDelegate.f4961a, false, false, false, 7, null);
                        }
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        public final void g1() {
            this.f4984i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f4983h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            o1(false);
        }

        public final void h1() {
            this.A = true;
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            if (!k()) {
                b1();
                if (this.f4982g && layoutNodeH0 != null) {
                    LayoutNode.b1(layoutNodeH0, false, 1, null);
                }
            }
            if (layoutNodeH0 == null) {
                this.f4984i = 0;
            } else if (!this.f4982g && (layoutNodeH0.R() == LayoutNode.LayoutState.LayingOut || layoutNodeH0.R() == LayoutNode.LayoutState.LookaheadLayingOut)) {
                if (!(this.f4984i == Integer.MAX_VALUE)) {
                    h2.a.b("Place was called on a node which was placed already");
                }
                this.f4984i = layoutNodeH0.P().f4970j;
                layoutNodeH0.P().f4970j++;
            }
            G();
        }

        public final boolean j1(long j11) {
            q2.b bVar;
            if (!(!LayoutNodeLayoutDelegate.this.f4961a.E0())) {
                h2.a.a("measure is called on a deactivated node");
            }
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            LayoutNodeLayoutDelegate.this.f4961a.l1(LayoutNodeLayoutDelegate.this.f4961a.B() || (layoutNodeH0 != null && layoutNodeH0.B()));
            if (!LayoutNodeLayoutDelegate.this.f4961a.T() && (bVar = this.f4989n) != null && q2.b.f(bVar.r(), j11)) {
                y0 y0VarG0 = LayoutNodeLayoutDelegate.this.f4961a.g0();
                if (y0VarG0 != null) {
                    y0VarG0.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.f4961a, true);
                }
                LayoutNodeLayoutDelegate.this.f4961a.k1();
                return false;
            }
            this.f4989n = q2.b.a(j11);
            B0(j11);
            l().s(false);
            S(new Function1<androidx.compose.ui.node.a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(a aVar) {
                    aVar.l().u(false);
                }
            });
            long jO0 = this.f4988m ? o0() : q2.u.a(Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.f4988m = true;
            j0 j0VarT1 = LayoutNodeLayoutDelegate.this.K().T1();
            if (!(j0VarT1 != null)) {
                h2.a.b("Lookahead result from lookaheadRemeasure cannot be null");
            }
            LayoutNodeLayoutDelegate.this.T(j11);
            A0(q2.u.a(j0VarT1.s0(), j0VarT1.g0()));
            return (q2.t.g(jO0) == j0VarT1.s0() && q2.t.f(jO0) == j0VarT1.g0()) ? false : true;
        }

        @Override // androidx.compose.ui.node.a
        public boolean k() {
            return this.f4994s;
        }

        public final void k1() {
            LayoutNode layoutNodeH0;
            try {
                this.f4982g = true;
                if (!this.f4987l) {
                    h2.a.b("replace() called on item that was not placed");
                }
                this.A = false;
                boolean zK = k();
                i1(this.f4990o, 0.0f, this.f4992q, this.f4993r);
                if (zK && !this.A && (layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0()) != null) {
                    LayoutNode.b1(layoutNodeH0, false, 1, null);
                }
            } finally {
                this.f4982g = false;
            }
        }

        @Override // androidx.compose.ui.node.a
        public AlignmentLines l() {
            return this.f4995t;
        }

        public final void l1(boolean z11) {
            this.f4997v = z11;
        }

        @Override // androidx.compose.ui.node.a
        public Map<androidx.compose.ui.layout.a, Integer> m() {
            if (!this.f4986k) {
                if (LayoutNodeLayoutDelegate.this.B() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    l().s(true);
                    if (l().g()) {
                        LayoutNodeLayoutDelegate.this.P();
                    }
                } else {
                    l().r(true);
                }
            }
            j0 j0VarT1 = I().T1();
            if (j0VarT1 != null) {
                j0VarT1.m1(true);
            }
            G();
            j0 j0VarT2 = I().T1();
            if (j0VarT2 != null) {
                j0VarT2.m1(false);
            }
            return l().h();
        }

        public final void m1(LayoutNode.UsageByParent usageByParent) {
            this.f4985j = usageByParent;
        }

        public final void n1(int i11) {
            this.f4984i = i11;
        }

        public void o1(boolean z11) {
            this.f4994s = z11;
        }

        public final void p1(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode layoutNodeH0 = layoutNode.h0();
            if (layoutNodeH0 == null) {
                this.f4985j = LayoutNode.UsageByParent.NotUsed;
                return;
            }
            if (!(this.f4985j == LayoutNode.UsageByParent.NotUsed || layoutNode.B())) {
                h2.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int i11 = a.f5002a[layoutNodeH0.R().ordinal()];
            if (i11 == 1 || i11 == 2) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i11 != 3 && i11 != 4) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + layoutNodeH0.R());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.f4985j = usageByParent;
        }

        public final boolean q1() {
            if (F() == null) {
                j0 j0VarT1 = LayoutNodeLayoutDelegate.this.K().T1();
                Intrinsics.d(j0VarT1);
                if (j0VarT1.F() == null) {
                    return false;
                }
            }
            if (!this.f4999x) {
                return false;
            }
            this.f4999x = false;
            j0 j0VarT2 = LayoutNodeLayoutDelegate.this.K().T1();
            Intrinsics.d(j0VarT2);
            this.f5000y = j0VarT2.F();
            return true;
        }

        @Override // androidx.compose.ui.node.a
        public void requestLayout() {
            LayoutNode.b1(LayoutNodeLayoutDelegate.this.f4961a, false, 1, null);
        }

        @Override // androidx.compose.ui.layout.k0
        public void u0(long j11, float f11, GraphicsLayer graphicsLayer) {
            i1(j11, f11, null, graphicsLayer);
        }

        @Override // androidx.compose.ui.layout.k0
        public void x0(long j11, float f11, Function1<? super e4, Unit> function1) {
            i1(j11, f11, function1, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class MeasurePassDelegate extends androidx.compose.ui.layout.k0 implements androidx.compose.ui.layout.t, androidx.compose.ui.node.a, m0 {
        public float A;
        public boolean B;
        public Function1<? super e4, Unit> C;
        public GraphicsLayer D;
        public long E;
        public float F;
        public final Function0<Unit> G;
        public boolean H;
        public boolean I;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f5004g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f5007j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f5008k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f5010m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f5011n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Function1<? super e4, Unit> f5012o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public GraphicsLayer f5013p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f5014q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f5015r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Object f5016s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f5017t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f5018u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final AlignmentLines f5019v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final androidx.compose.runtime.collection.b<MeasurePassDelegate> f5020w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f5021x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f5022y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final Function0<Unit> f5023z;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5005h = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f5006i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public LayoutNode.UsageByParent f5009l = LayoutNode.UsageByParent.NotUsed;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5024a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f5025b;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f5024a = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                f5025b = iArr2;
            }
        }

        public MeasurePassDelegate() {
            q2.p.a aVar = q2.p.f74244b;
            this.f5011n = aVar.a();
            this.f5015r = true;
            this.f5019v = new c0(this);
            this.f5020w = new androidx.compose.runtime.collection.b<>(new MeasurePassDelegate[16], 0);
            this.f5021x = true;
            this.f5023z = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1
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
                    this.this$0.U0();
                    this.this$0.S(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(a aVar2) {
                            invoke2(aVar2);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(a aVar2) {
                            aVar2.l().t(false);
                        }
                    });
                    this.this$0.I().Y0().m();
                    this.this$0.R0();
                    this.this$0.S(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(a aVar2) {
                            invoke2(aVar2);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(a aVar2) {
                            aVar2.l().q(aVar2.l().l());
                        }
                    });
                }
            };
            this.E = aVar.a();
            this.G = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1
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
                    androidx.compose.ui.layout.k0.a placementScope;
                    NodeCoordinator nodeCoordinatorZ1 = layoutNodeLayoutDelegate.K().Z1();
                    if (nodeCoordinatorZ1 == null || (placementScope = nodeCoordinatorZ1.b1()) == null) {
                        placementScope = f0.b(layoutNodeLayoutDelegate.f4961a).getPlacementScope();
                    }
                    androidx.compose.ui.layout.k0.a aVar2 = placementScope;
                    LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
                    Function1<? super e4, Unit> function1 = measurePassDelegate.C;
                    GraphicsLayer graphicsLayer = measurePassDelegate.D;
                    if (graphicsLayer != null) {
                        aVar2.v(layoutNodeLayoutDelegate.K(), measurePassDelegate.E, graphicsLayer, measurePassDelegate.F);
                    } else if (function1 == null) {
                        aVar2.i(layoutNodeLayoutDelegate.K(), measurePassDelegate.E, measurePassDelegate.F);
                    } else {
                        aVar2.u(layoutNodeLayoutDelegate.K(), measurePassDelegate.E, measurePassDelegate.F, function1);
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void R0() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                    if (layoutNode2.X().f5005h != layoutNode2.i0()) {
                        layoutNode.S0();
                        layoutNode.w0();
                        if (layoutNode2.i0() == Integer.MAX_VALUE) {
                            layoutNode2.X().j1();
                        }
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void U0() {
            LayoutNodeLayoutDelegate.this.f4971k = 0;
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    MeasurePassDelegate measurePassDelegateX = layoutNodeArrQ[i11].X();
                    measurePassDelegateX.f5005h = measurePassDelegateX.f5006i;
                    measurePassDelegateX.f5006i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    measurePassDelegateX.f5018u = false;
                    if (measurePassDelegateX.f5009l == LayoutNode.UsageByParent.InLayoutBlock) {
                        measurePassDelegateX.f5009l = LayoutNode.UsageByParent.NotUsed;
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        private final void i1() {
            boolean zK = k();
            u1(true);
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
            if (!zK) {
                if (layoutNode.Y()) {
                    LayoutNode.h1(layoutNode, true, false, false, 6, null);
                } else if (layoutNode.T()) {
                    LayoutNode.d1(layoutNode, true, false, false, 6, null);
                }
            }
            NodeCoordinator nodeCoordinatorY1 = layoutNode.M().Y1();
            for (NodeCoordinator nodeCoordinatorF0 = layoutNode.f0(); !Intrinsics.b(nodeCoordinatorF0, nodeCoordinatorY1) && nodeCoordinatorF0 != null; nodeCoordinatorF0 = nodeCoordinatorF0.Y1()) {
                if (nodeCoordinatorF0.Q1()) {
                    nodeCoordinatorF0.i2();
                }
            }
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                    if (layoutNode2.i0() != Integer.MAX_VALUE) {
                        layoutNode2.X().i1();
                        layoutNode.i1(layoutNode2);
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        private final void j1() {
            if (k()) {
                int i11 = 0;
                u1(false);
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
                NodeCoordinator nodeCoordinatorY1 = layoutNode.M().Y1();
                for (NodeCoordinator nodeCoordinatorF0 = layoutNode.f0(); !Intrinsics.b(nodeCoordinatorF0, nodeCoordinatorY1) && nodeCoordinatorF0 != null; nodeCoordinatorF0 = nodeCoordinatorF0.Y1()) {
                    nodeCoordinatorF0.y2();
                }
                androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
                int iR = bVarP0.r();
                if (iR > 0) {
                    LayoutNode[] layoutNodeArrQ = bVarP0.q();
                    do {
                        layoutNodeArrQ[i11].X().j1();
                        i11++;
                    } while (i11 < iR);
                }
            }
        }

        private final void l1() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                    if (layoutNode2.Y() && layoutNode2.a0() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.W0(layoutNode2, null, 1, null)) {
                        LayoutNode.h1(layoutNodeLayoutDelegate.f4961a, false, false, false, 7, null);
                    }
                    i11++;
                } while (i11 < iR);
            }
        }

        private final void p1(long j11, float f11, Function1<? super e4, Unit> function1, GraphicsLayer graphicsLayer) {
            androidx.compose.ui.layout.k0.a placementScope;
            this.f5018u = true;
            boolean z11 = false;
            if (!q2.p.g(j11, this.f5011n) || this.H) {
                if (LayoutNodeLayoutDelegate.this.u() || LayoutNodeLayoutDelegate.this.v() || this.H) {
                    LayoutNodeLayoutDelegate.this.f4965e = true;
                    this.H = false;
                }
                k1();
            }
            if (g0.a(LayoutNodeLayoutDelegate.this.f4961a)) {
                NodeCoordinator nodeCoordinatorZ1 = LayoutNodeLayoutDelegate.this.K().Z1();
                if (nodeCoordinatorZ1 == null || (placementScope = nodeCoordinatorZ1.b1()) == null) {
                    placementScope = f0.b(LayoutNodeLayoutDelegate.this.f4961a).getPlacementScope();
                }
                androidx.compose.ui.layout.k0.a aVar = placementScope;
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                LookaheadPassDelegate lookaheadPassDelegateH = layoutNodeLayoutDelegate.H();
                Intrinsics.d(lookaheadPassDelegateH);
                LayoutNode layoutNodeH0 = layoutNodeLayoutDelegate.f4961a.h0();
                if (layoutNodeH0 != null) {
                    layoutNodeH0.P().f4970j = 0;
                }
                lookaheadPassDelegateH.n1(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                androidx.compose.ui.layout.k0.a.h(aVar, lookaheadPassDelegateH, q2.p.h(j11), q2.p.i(j11), 0.0f, 4, null);
            }
            LookaheadPassDelegate lookaheadPassDelegateH2 = LayoutNodeLayoutDelegate.this.H();
            if (lookaheadPassDelegateH2 != null && !lookaheadPassDelegateH2.X0()) {
                z11 = true;
            }
            if (!(true ^ z11)) {
                h2.a.b("Error: Placement happened before lookahead.");
            }
            o1(j11, f11, function1, graphicsLayer);
        }

        @Override // androidx.compose.ui.node.a
        public androidx.compose.ui.node.a C() {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateP;
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            if (layoutNodeH0 == null || (layoutNodeLayoutDelegateP = layoutNodeH0.P()) == null) {
                return null;
            }
            return layoutNodeLayoutDelegateP.r();
        }

        @Override // androidx.compose.ui.layout.k0, androidx.compose.ui.layout.j
        public Object F() {
            return this.f5016s;
        }

        @Override // androidx.compose.ui.node.a
        public void G() {
            this.f5022y = true;
            l().o();
            if (LayoutNodeLayoutDelegate.this.A()) {
                l1();
            }
            if (LayoutNodeLayoutDelegate.this.f4966f || (!this.f5010m && !I().i1() && LayoutNodeLayoutDelegate.this.A())) {
                LayoutNodeLayoutDelegate.this.f4965e = false;
                LayoutNode.LayoutState layoutStateB = LayoutNodeLayoutDelegate.this.B();
                LayoutNodeLayoutDelegate.this.f4963c = LayoutNode.LayoutState.LayingOut;
                LayoutNodeLayoutDelegate.this.Z(false);
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
                f0.b(layoutNode).getSnapshotObserver().e(layoutNode, false, this.f5023z);
                LayoutNodeLayoutDelegate.this.f4963c = layoutStateB;
                if (I().i1() && LayoutNodeLayoutDelegate.this.v()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.f4966f = false;
            }
            if (l().l()) {
                l().q(true);
            }
            if (l().g() && l().k()) {
                l().n();
            }
            this.f5022y = false;
        }

        @Override // androidx.compose.ui.node.a
        public NodeCoordinator I() {
            return LayoutNodeLayoutDelegate.this.f4961a.M();
        }

        @Override // androidx.compose.ui.layout.t
        public androidx.compose.ui.layout.k0 L(long j11) {
            LayoutNode.UsageByParent usageByParentO = LayoutNodeLayoutDelegate.this.f4961a.O();
            LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
            if (usageByParentO == usageByParent) {
                LayoutNodeLayoutDelegate.this.f4961a.s();
            }
            if (g0.a(LayoutNodeLayoutDelegate.this.f4961a)) {
                LookaheadPassDelegate lookaheadPassDelegateH = LayoutNodeLayoutDelegate.this.H();
                Intrinsics.d(lookaheadPassDelegateH);
                lookaheadPassDelegateH.m1(usageByParent);
                lookaheadPassDelegateH.L(j11);
            }
            v1(LayoutNodeLayoutDelegate.this.f4961a);
            q1(j11);
            return this;
        }

        @Override // androidx.compose.ui.node.a
        public void S(Function1<? super androidx.compose.ui.node.a, Unit> function1) {
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    function1.invoke(layoutNodeArrQ[i11].P().r());
                    i11++;
                } while (i11 < iR);
            }
        }

        @Override // androidx.compose.ui.node.m0
        public void T(boolean z11) {
            boolean zH1 = LayoutNodeLayoutDelegate.this.K().h1();
            if (z11 != zH1) {
                LayoutNodeLayoutDelegate.this.K().T(zH1);
                this.H = true;
            }
            this.I = z11;
        }

        @Override // androidx.compose.ui.node.a
        public void W() {
            LayoutNode.h1(LayoutNodeLayoutDelegate.this.f4961a, false, false, false, 7, null);
        }

        public final List<MeasurePassDelegate> W0() {
            LayoutNodeLayoutDelegate.this.f4961a.u1();
            if (!this.f5021x) {
                return this.f5020w.h();
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
            androidx.compose.runtime.collection.b<MeasurePassDelegate> bVar = this.f5020w;
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                    if (bVar.r() <= i11) {
                        bVar.b(layoutNode2.P().I());
                    } else {
                        bVar.C(i11, layoutNode2.P().I());
                    }
                    i11++;
                } while (i11 < iR);
            }
            bVar.A(layoutNode.E().size(), bVar.r());
            this.f5021x = false;
            return this.f5020w.h();
        }

        public final q2.b X0() {
            if (this.f5007j) {
                return q2.b.a(r0());
            }
            return null;
        }

        public final boolean Y0() {
            return this.f5022y;
        }

        public final LayoutNode.UsageByParent Z0() {
            return this.f5009l;
        }

        public final int b1() {
            return this.f5006i;
        }

        public final float d1() {
            return this.A;
        }

        public final void e1(boolean z11) {
            LayoutNode layoutNode;
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            LayoutNode.UsageByParent usageByParentO = LayoutNodeLayoutDelegate.this.f4961a.O();
            if (layoutNodeH0 == null || usageByParentO == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            do {
                layoutNode = layoutNodeH0;
                if (layoutNode.O() != usageByParentO) {
                    break;
                } else {
                    layoutNodeH0 = layoutNode.h0();
                }
            } while (layoutNodeH0 != null);
            int i11 = a.f5025b[usageByParentO.ordinal()];
            if (i11 == 1) {
                LayoutNode.h1(layoutNode, z11, false, false, 6, null);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
                layoutNode.e1(z11);
            }
        }

        public final void f1() {
            this.f5015r = true;
        }

        public final boolean g1() {
            return this.f5018u;
        }

        public final void h1() {
            LayoutNodeLayoutDelegate.this.f4962b = true;
        }

        @Override // androidx.compose.ui.node.a
        public boolean k() {
            return this.f5017t;
        }

        public final void k1() {
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0;
            int iR;
            if (LayoutNodeLayoutDelegate.this.s() <= 0 || (iR = (bVarP0 = LayoutNodeLayoutDelegate.this.f4961a.p0()).r()) <= 0) {
                return;
            }
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArrQ[i11];
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegateP = layoutNode.P();
                if ((layoutNodeLayoutDelegateP.v() || layoutNodeLayoutDelegateP.u()) && !layoutNodeLayoutDelegateP.A()) {
                    LayoutNode.f1(layoutNode, false, 1, null);
                }
                layoutNodeLayoutDelegateP.I().k1();
                i11++;
            } while (i11 < iR);
        }

        @Override // androidx.compose.ui.node.a
        public AlignmentLines l() {
            return this.f5019v;
        }

        @Override // androidx.compose.ui.node.a
        public Map<androidx.compose.ui.layout.a, Integer> m() {
            if (!this.f5010m) {
                if (LayoutNodeLayoutDelegate.this.B() == LayoutNode.LayoutState.Measuring) {
                    l().s(true);
                    if (l().g()) {
                        LayoutNodeLayoutDelegate.this.O();
                    }
                } else {
                    l().r(true);
                }
            }
            I().m1(true);
            G();
            I().m1(false);
            return l().h();
        }

        public final void m1() {
            this.f5006i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f5005h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            u1(false);
        }

        public final void n1() {
            this.B = true;
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            float fA2 = I().a2();
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f4961a;
            NodeCoordinator nodeCoordinatorF0 = layoutNode.f0();
            NodeCoordinator nodeCoordinatorM = layoutNode.M();
            while (nodeCoordinatorF0 != nodeCoordinatorM) {
                Intrinsics.e(nodeCoordinatorF0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                y yVar = (y) nodeCoordinatorF0;
                fA2 += yVar.a2();
                nodeCoordinatorF0 = yVar.Y1();
            }
            if (fA2 != this.A) {
                this.A = fA2;
                if (layoutNodeH0 != null) {
                    layoutNodeH0.S0();
                }
                if (layoutNodeH0 != null) {
                    layoutNodeH0.w0();
                }
            }
            if (!k()) {
                if (layoutNodeH0 != null) {
                    layoutNodeH0.w0();
                }
                i1();
                if (this.f5004g && layoutNodeH0 != null) {
                    LayoutNode.f1(layoutNodeH0, false, 1, null);
                }
            }
            if (layoutNodeH0 == null) {
                this.f5006i = 0;
            } else if (!this.f5004g && layoutNodeH0.R() == LayoutNode.LayoutState.LayingOut) {
                if (!(this.f5006i == Integer.MAX_VALUE)) {
                    h2.a.b("Place was called on a node which was placed already");
                }
                this.f5006i = layoutNodeH0.P().f4971k;
                layoutNodeH0.P().f4971k++;
            }
            G();
        }

        public final void o1(long j11, float f11, Function1<? super e4, Unit> function1, GraphicsLayer graphicsLayer) {
            if (!(!LayoutNodeLayoutDelegate.this.f4961a.E0())) {
                h2.a.a("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.this.f4963c = LayoutNode.LayoutState.LayingOut;
            this.f5011n = j11;
            this.f5014q = f11;
            this.f5012o = function1;
            this.f5013p = graphicsLayer;
            this.f5008k = true;
            this.B = false;
            y0 y0VarB = f0.b(LayoutNodeLayoutDelegate.this.f4961a);
            if (LayoutNodeLayoutDelegate.this.A() || !k()) {
                l().r(false);
                LayoutNodeLayoutDelegate.this.Y(false);
                this.C = function1;
                this.E = j11;
                this.F = f11;
                this.D = graphicsLayer;
                y0VarB.getSnapshotObserver().c(LayoutNodeLayoutDelegate.this.f4961a, false, this.G);
            } else {
                LayoutNodeLayoutDelegate.this.K().v2(j11, f11, function1, graphicsLayer);
                n1();
            }
            LayoutNodeLayoutDelegate.this.f4963c = LayoutNode.LayoutState.Idle;
        }

        public final boolean q1(long j11) {
            boolean z11 = true;
            if (!(!LayoutNodeLayoutDelegate.this.f4961a.E0())) {
                h2.a.a("measure is called on a deactivated node");
            }
            y0 y0VarB = f0.b(LayoutNodeLayoutDelegate.this.f4961a);
            LayoutNode layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0();
            LayoutNodeLayoutDelegate.this.f4961a.l1(LayoutNodeLayoutDelegate.this.f4961a.B() || (layoutNodeH0 != null && layoutNodeH0.B()));
            if (!LayoutNodeLayoutDelegate.this.f4961a.Y() && q2.b.f(r0(), j11)) {
                x0.b(y0VarB, LayoutNodeLayoutDelegate.this.f4961a, false, 2, null);
                LayoutNodeLayoutDelegate.this.f4961a.k1();
                return false;
            }
            l().s(false);
            S(new Function1<androidx.compose.ui.node.a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(a aVar) {
                    aVar.l().u(false);
                }
            });
            this.f5007j = true;
            long jP = LayoutNodeLayoutDelegate.this.K().p();
            B0(j11);
            LayoutNodeLayoutDelegate.this.U(j11);
            if (q2.t.e(LayoutNodeLayoutDelegate.this.K().p(), jP) && LayoutNodeLayoutDelegate.this.K().s0() == s0() && LayoutNodeLayoutDelegate.this.K().g0() == g0()) {
                z11 = false;
            }
            A0(q2.u.a(LayoutNodeLayoutDelegate.this.K().s0(), LayoutNodeLayoutDelegate.this.K().g0()));
            return z11;
        }

        public final void r1() {
            LayoutNode layoutNodeH0;
            try {
                this.f5004g = true;
                if (!this.f5008k) {
                    h2.a.b("replace called on unplaced item");
                }
                boolean zK = k();
                o1(this.f5011n, this.f5014q, this.f5012o, this.f5013p);
                if (zK && !this.B && (layoutNodeH0 = LayoutNodeLayoutDelegate.this.f4961a.h0()) != null) {
                    LayoutNode.f1(layoutNodeH0, false, 1, null);
                }
            } finally {
                this.f5004g = false;
            }
        }

        @Override // androidx.compose.ui.node.a
        public void requestLayout() {
            LayoutNode.f1(LayoutNodeLayoutDelegate.this.f4961a, false, 1, null);
        }

        public final void s1(boolean z11) {
            this.f5021x = z11;
        }

        public final void t1(LayoutNode.UsageByParent usageByParent) {
            this.f5009l = usageByParent;
        }

        @Override // androidx.compose.ui.layout.k0
        public void u0(long j11, float f11, GraphicsLayer graphicsLayer) {
            p1(j11, f11, null, graphicsLayer);
        }

        public void u1(boolean z11) {
            this.f5017t = z11;
        }

        public final void v1(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode layoutNodeH0 = layoutNode.h0();
            if (layoutNodeH0 == null) {
                this.f5009l = LayoutNode.UsageByParent.NotUsed;
                return;
            }
            if (!(this.f5009l == LayoutNode.UsageByParent.NotUsed || layoutNode.B())) {
                h2.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int i11 = a.f5024a[layoutNodeH0.R().ordinal()];
            if (i11 == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + layoutNodeH0.R());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.f5009l = usageByParent;
        }

        public final boolean w1() {
            if ((F() == null && LayoutNodeLayoutDelegate.this.K().F() == null) || !this.f5015r) {
                return false;
            }
            this.f5015r = false;
            this.f5016s = LayoutNodeLayoutDelegate.this.K().F();
            return true;
        }

        @Override // androidx.compose.ui.layout.k0
        public void x0(long j11, float f11, Function1<? super e4, Unit> function1) {
            p1(j11, f11, function1, null);
        }
    }

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode) {
        this.f4961a = layoutNode;
    }

    public final boolean A() {
        return this.f4965e;
    }

    public final LayoutNode.LayoutState B() {
        return this.f4963c;
    }

    public final a C() {
        return this.f4979s;
    }

    public final boolean D() {
        return this.f4976p;
    }

    public final boolean E() {
        return this.f4975o;
    }

    public final boolean F() {
        return this.f4968h;
    }

    public final boolean G() {
        return this.f4967g;
    }

    public final LookaheadPassDelegate H() {
        return this.f4979s;
    }

    public final MeasurePassDelegate I() {
        return this.f4978r;
    }

    public final boolean J() {
        return this.f4964d;
    }

    public final NodeCoordinator K() {
        return this.f4961a.e0().n();
    }

    public final int L() {
        return this.f4978r.s0();
    }

    public final void M() {
        this.f4978r.f1();
        LookaheadPassDelegate lookaheadPassDelegate = this.f4979s;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.Z0();
        }
    }

    public final void N() {
        this.f4978r.s1(true);
        LookaheadPassDelegate lookaheadPassDelegate = this.f4979s;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.l1(true);
        }
    }

    public final void O() {
        this.f4965e = true;
        this.f4966f = true;
    }

    public final void P() {
        this.f4968h = true;
        this.f4969i = true;
    }

    public final void Q() {
        this.f4967g = true;
    }

    public final void R() {
        this.f4964d = true;
    }

    public final void S() {
        LayoutNode.LayoutState layoutStateR = this.f4961a.R();
        if (layoutStateR == LayoutNode.LayoutState.LayingOut || layoutStateR == LayoutNode.LayoutState.LookaheadLayingOut) {
            if (this.f4978r.Y0()) {
                Z(true);
            } else {
                Y(true);
            }
        }
        if (layoutStateR == LayoutNode.LayoutState.LookaheadLayingOut) {
            LookaheadPassDelegate lookaheadPassDelegate = this.f4979s;
            if (lookaheadPassDelegate == null || !lookaheadPassDelegate.R0()) {
                a0(true);
            } else {
                b0(true);
            }
        }
    }

    public final void T(final long j11) {
        this.f4963c = LayoutNode.LayoutState.LookaheadMeasuring;
        this.f4967g = false;
        OwnerSnapshotObserver.h(f0.b(this.f4961a).getSnapshotObserver(), this.f4961a, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performLookaheadMeasure$1
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
                j0 j0VarT1 = this.this$0.K().T1();
                Intrinsics.d(j0VarT1);
                j0VarT1.L(j11);
            }
        }, 2, null);
        P();
        if (g0.a(this.f4961a)) {
            O();
        } else {
            R();
        }
        this.f4963c = LayoutNode.LayoutState.Idle;
    }

    public final void U(long j11) {
        LayoutNode.LayoutState layoutState = this.f4963c;
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Idle;
        if (!(layoutState == layoutState2)) {
            h2.a.b("layout state is not idle before measure starts");
        }
        LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
        this.f4963c = layoutState3;
        this.f4964d = false;
        this.f4980t = j11;
        f0.b(this.f4961a).getSnapshotObserver().g(this.f4961a, false, this.f4981u);
        if (this.f4963c == layoutState3) {
            O();
            this.f4963c = layoutState2;
        }
    }

    public final void V() {
        AlignmentLines alignmentLinesL;
        this.f4978r.l().p();
        LookaheadPassDelegate lookaheadPassDelegate = this.f4979s;
        if (lookaheadPassDelegate == null || (alignmentLinesL = lookaheadPassDelegate.l()) == null) {
            return;
        }
        alignmentLinesL.p();
    }

    public final void W(int i11) {
        int i12 = this.f4974n;
        this.f4974n = i11;
        if ((i12 == 0) != (i11 == 0)) {
            LayoutNode layoutNodeH0 = this.f4961a.h0();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateP = layoutNodeH0 != null ? layoutNodeH0.P() : null;
            if (layoutNodeLayoutDelegateP != null) {
                if (i11 == 0) {
                    layoutNodeLayoutDelegateP.W(layoutNodeLayoutDelegateP.f4974n - 1);
                } else {
                    layoutNodeLayoutDelegateP.W(layoutNodeLayoutDelegateP.f4974n + 1);
                }
            }
        }
    }

    public final void X(int i11) {
        int i12 = this.f4977q;
        this.f4977q = i11;
        if ((i12 == 0) != (i11 == 0)) {
            LayoutNode layoutNodeH0 = this.f4961a.h0();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegateP = layoutNodeH0 != null ? layoutNodeH0.P() : null;
            if (layoutNodeLayoutDelegateP != null) {
                if (i11 == 0) {
                    layoutNodeLayoutDelegateP.X(layoutNodeLayoutDelegateP.f4977q - 1);
                } else {
                    layoutNodeLayoutDelegateP.X(layoutNodeLayoutDelegateP.f4977q + 1);
                }
            }
        }
    }

    public final void Y(boolean z11) {
        if (this.f4973m != z11) {
            this.f4973m = z11;
            if (z11 && !this.f4972l) {
                W(this.f4974n + 1);
            } else {
                if (z11 || this.f4972l) {
                    return;
                }
                W(this.f4974n - 1);
            }
        }
    }

    public final void Z(boolean z11) {
        if (this.f4972l != z11) {
            this.f4972l = z11;
            if (z11 && !this.f4973m) {
                W(this.f4974n + 1);
            } else {
                if (z11 || this.f4973m) {
                    return;
                }
                W(this.f4974n - 1);
            }
        }
    }

    public final void a0(boolean z11) {
        if (this.f4976p != z11) {
            this.f4976p = z11;
            if (z11 && !this.f4975o) {
                X(this.f4977q + 1);
            } else {
                if (z11 || this.f4975o) {
                    return;
                }
                X(this.f4977q - 1);
            }
        }
    }

    public final void b0(boolean z11) {
        if (this.f4975o != z11) {
            this.f4975o = z11;
            if (z11 && !this.f4976p) {
                X(this.f4977q + 1);
            } else {
                if (z11 || this.f4976p) {
                    return;
                }
                X(this.f4977q - 1);
            }
        }
    }

    public final void c0() {
        LayoutNode layoutNodeH0;
        if (this.f4978r.w1() && (layoutNodeH0 = this.f4961a.h0()) != null) {
            LayoutNode.h1(layoutNodeH0, false, false, false, 7, null);
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.f4979s;
        if (lookaheadPassDelegate == null || !lookaheadPassDelegate.q1()) {
            return;
        }
        if (g0.a(this.f4961a)) {
            LayoutNode layoutNodeH1 = this.f4961a.h0();
            if (layoutNodeH1 != null) {
                LayoutNode.h1(layoutNodeH1, false, false, false, 7, null);
                return;
            }
            return;
        }
        LayoutNode layoutNodeH2 = this.f4961a.h0();
        if (layoutNodeH2 != null) {
            LayoutNode.d1(layoutNodeH2, false, false, false, 7, null);
        }
    }

    public final void q() {
        if (this.f4979s == null) {
            this.f4979s = new LookaheadPassDelegate();
        }
    }

    public final a r() {
        return this.f4978r;
    }

    public final int s() {
        return this.f4974n;
    }

    public final int t() {
        return this.f4977q;
    }

    public final boolean u() {
        return this.f4973m;
    }

    public final boolean v() {
        return this.f4972l;
    }

    public final boolean w() {
        return this.f4962b;
    }

    public final int x() {
        return this.f4978r.g0();
    }

    public final q2.b y() {
        return this.f4978r.X0();
    }

    public final q2.b z() {
        LookaheadPassDelegate lookaheadPassDelegate = this.f4979s;
        if (lookaheadPassDelegate != null) {
            return lookaheadPassDelegate.O0();
        }
        return null;
    }
}
