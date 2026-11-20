package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutNode f5091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f5092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OnPositionedDispatcher f5095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<y0.b> f5096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<a> f5098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q2.b f5099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h0 f5100j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LayoutNode f5101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f5102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f5103c;

        public a(LayoutNode layoutNode, boolean z11, boolean z12) {
            this.f5101a = layoutNode;
            this.f5102b = z11;
            this.f5103c = z12;
        }

        public final LayoutNode a() {
            return this.f5101a;
        }

        public final boolean b() {
            return this.f5103c;
        }

        public final boolean c() {
            return this.f5102b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5104a;

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
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f5104a = iArr;
        }
    }

    public k0(LayoutNode layoutNode) {
        this.f5091a = layoutNode;
        y0.a aVar = y0.f5155b8;
        j jVar = new j(aVar.a());
        this.f5092b = jVar;
        this.f5095e = new OnPositionedDispatcher();
        this.f5096f = new androidx.compose.runtime.collection.b<>(new y0.b[16], 0);
        this.f5097g = 1L;
        androidx.compose.runtime.collection.b<a> bVar = new androidx.compose.runtime.collection.b<>(new a[16], 0);
        this.f5098h = bVar;
        this.f5100j = aVar.a() ? new h0(layoutNode, jVar, bVar.h()) : null;
    }

    public static /* synthetic */ boolean H(k0 k0Var, LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return k0Var.G(layoutNode, z11);
    }

    public static /* synthetic */ void d(k0 k0Var, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        k0Var.c(z11);
    }

    public static /* synthetic */ boolean z(k0 k0Var, LayoutNode layoutNode, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            z12 = true;
        }
        return k0Var.y(layoutNode, z11, z12);
    }

    public final void A(LayoutNode layoutNode) {
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                if (o(layoutNode2)) {
                    if (g0.a(layoutNode2)) {
                        B(layoutNode2, true);
                    } else {
                        A(layoutNode2);
                    }
                }
                i11++;
            } while (i11 < iR);
        }
    }

    public final void B(LayoutNode layoutNode, boolean z11) {
        q2.b bVar;
        if (layoutNode.E0()) {
            return;
        }
        if (layoutNode == this.f5091a) {
            bVar = this.f5099i;
            Intrinsics.d(bVar);
        } else {
            bVar = null;
        }
        if (z11) {
            e(layoutNode, bVar);
        } else {
            f(layoutNode, bVar);
        }
    }

    public final boolean C(LayoutNode layoutNode, boolean z11) {
        int i11 = b.f5104a[layoutNode.R().ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4 && i11 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((layoutNode.T() || layoutNode.S()) && !z11) {
                h0 h0Var = this.f5100j;
                if (h0Var == null) {
                    return false;
                }
                h0Var.a();
                return false;
            }
            layoutNode.M0();
            layoutNode.L0();
            if (layoutNode.E0()) {
                return false;
            }
            LayoutNode layoutNodeH0 = layoutNode.h0();
            if (Intrinsics.b(layoutNode.G0(), Boolean.TRUE) && ((layoutNodeH0 == null || !layoutNodeH0.T()) && (layoutNodeH0 == null || !layoutNodeH0.S()))) {
                this.f5092b.c(layoutNode, true);
            } else if (layoutNode.k() && ((layoutNodeH0 == null || !layoutNodeH0.Q()) && (layoutNodeH0 == null || !layoutNodeH0.Y()))) {
                this.f5092b.c(layoutNode, false);
            }
            return !this.f5094d;
        }
        h0 h0Var2 = this.f5100j;
        if (h0Var2 == null) {
            return false;
        }
        h0Var2.a();
        return false;
    }

    public final boolean D(LayoutNode layoutNode, boolean z11) {
        LayoutNode layoutNodeH0;
        LayoutNode layoutNodeH1;
        if (!(layoutNode.V() != null)) {
            h2.a.b("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int i11 = b.f5104a[layoutNode.R().ordinal()];
        if (i11 == 1) {
            return false;
        }
        if (i11 == 2 || i11 == 3 || i11 == 4) {
            this.f5098h.b(new a(layoutNode, true, z11));
            h0 h0Var = this.f5100j;
            if (h0Var == null) {
                return false;
            }
            h0Var.a();
            return false;
        }
        if (i11 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (layoutNode.T() && !z11) {
            return false;
        }
        layoutNode.N0();
        layoutNode.O0();
        if (layoutNode.E0()) {
            return false;
        }
        if ((Intrinsics.b(layoutNode.G0(), Boolean.TRUE) || l(layoutNode)) && ((layoutNodeH0 = layoutNode.h0()) == null || !layoutNodeH0.T())) {
            this.f5092b.c(layoutNode, true);
        } else if ((layoutNode.k() || k(layoutNode)) && ((layoutNodeH1 = layoutNode.h0()) == null || !layoutNodeH1.Y())) {
            this.f5092b.c(layoutNode, false);
        }
        return !this.f5094d;
    }

    public final void E(LayoutNode layoutNode) {
        this.f5095e.d(layoutNode);
    }

    public final boolean F(LayoutNode layoutNode, boolean z11) {
        int i11 = b.f5104a[layoutNode.R().ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            h0 h0Var = this.f5100j;
            if (h0Var != null) {
                h0Var.a();
            }
        } else {
            if (i11 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            if (!z11 && layoutNode.k() == layoutNode.F0() && (layoutNode.Y() || layoutNode.Q())) {
                h0 h0Var2 = this.f5100j;
                if (h0Var2 != null) {
                    h0Var2.a();
                }
            } else {
                layoutNode.L0();
                if (!layoutNode.E0() && layoutNode.F0()) {
                    LayoutNode layoutNodeH0 = layoutNode.h0();
                    if ((layoutNodeH0 == null || !layoutNodeH0.Q()) && (layoutNodeH0 == null || !layoutNodeH0.Y())) {
                        this.f5092b.c(layoutNode, false);
                    }
                    if (!this.f5094d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean G(LayoutNode layoutNode, boolean z11) {
        int i11 = b.f5104a[layoutNode.R().ordinal()];
        if (i11 != 1 && i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                this.f5098h.b(new a(layoutNode, false, z11));
                h0 h0Var = this.f5100j;
                if (h0Var != null) {
                    h0Var.a();
                }
            } else {
                if (i11 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!layoutNode.Y() || z11) {
                    layoutNode.O0();
                    if (!layoutNode.E0() && (layoutNode.k() || k(layoutNode))) {
                        LayoutNode layoutNodeH0 = layoutNode.h0();
                        if (layoutNodeH0 == null || !layoutNodeH0.Y()) {
                            this.f5092b.c(layoutNode, false);
                        }
                        if (!this.f5094d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void I(long j11) {
        q2.b bVar = this.f5099i;
        if (bVar != null && q2.b.f(bVar.r(), j11)) {
            return;
        }
        if (!(!this.f5093c)) {
            h2.a.a("updateRootConstraints called while measuring");
        }
        this.f5099i = q2.b.a(j11);
        if (this.f5091a.V() != null) {
            this.f5091a.N0();
        }
        this.f5091a.O0();
        j jVar = this.f5092b;
        LayoutNode layoutNode = this.f5091a;
        jVar.c(layoutNode, layoutNode.V() != null);
    }

    public final void b() {
        androidx.compose.runtime.collection.b<y0.b> bVar = this.f5096f;
        int iR = bVar.r();
        if (iR > 0) {
            y0.b[] bVarArrQ = bVar.q();
            int i11 = 0;
            do {
                bVarArrQ[i11].f();
                i11++;
            } while (i11 < iR);
        }
        this.f5096f.i();
    }

    public final void c(boolean z11) {
        if (z11) {
            this.f5095e.e(this.f5091a);
        }
        this.f5095e.a();
    }

    public final boolean e(LayoutNode layoutNode, q2.b bVar) {
        if (layoutNode.V() == null) {
            return false;
        }
        boolean zI0 = bVar != null ? layoutNode.I0(bVar) : LayoutNode.J0(layoutNode, null, 1, null);
        LayoutNode layoutNodeH0 = layoutNode.h0();
        if (zI0 && layoutNodeH0 != null) {
            if (layoutNodeH0.V() == null) {
                LayoutNode.h1(layoutNodeH0, false, false, false, 3, null);
            } else if (layoutNode.b0() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.d1(layoutNodeH0, false, false, false, 3, null);
            } else if (layoutNode.b0() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.b1(layoutNodeH0, false, 1, null);
            }
        }
        return zI0;
    }

    public final boolean f(LayoutNode layoutNode, q2.b bVar) {
        boolean zV0 = bVar != null ? layoutNode.V0(bVar) : LayoutNode.W0(layoutNode, null, 1, null);
        LayoutNode layoutNodeH0 = layoutNode.h0();
        if (zV0 && layoutNodeH0 != null) {
            if (layoutNode.a0() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.h1(layoutNodeH0, false, false, false, 3, null);
            } else if (layoutNode.a0() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.f1(layoutNodeH0, false, 1, null);
            }
        }
        return zV0;
    }

    public final void g() {
        if (this.f5098h.u()) {
            androidx.compose.runtime.collection.b<a> bVar = this.f5098h;
            int iR = bVar.r();
            if (iR > 0) {
                a[] aVarArrQ = bVar.q();
                int i11 = 0;
                do {
                    a aVar = aVarArrQ[i11];
                    if (aVar.a().D0()) {
                        if (aVar.c()) {
                            LayoutNode.d1(aVar.a(), aVar.b(), false, false, 2, null);
                        } else {
                            LayoutNode.h1(aVar.a(), aVar.b(), false, false, 2, null);
                        }
                    }
                    i11++;
                } while (i11 < iR);
            }
            this.f5098h.i();
        }
    }

    public final void h(LayoutNode layoutNode) {
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                if (Intrinsics.b(layoutNode2.G0(), Boolean.TRUE) && !layoutNode2.E0()) {
                    if (this.f5092b.e(layoutNode2, true)) {
                        layoutNode2.K0();
                    }
                    h(layoutNode2);
                }
                i11++;
            } while (i11 < iR);
        }
    }

    public final void i(LayoutNode layoutNode, boolean z11) {
        if (this.f5092b.g(z11)) {
            return;
        }
        if (!this.f5093c) {
            h2.a.b("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (!(!u(layoutNode, z11))) {
            h2.a.a("node not yet measured");
        }
        j(layoutNode, z11);
    }

    public final void j(LayoutNode layoutNode, boolean z11) {
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                if ((!z11 && o(layoutNode2)) || (z11 && p(layoutNode2))) {
                    if (g0.a(layoutNode2) && !z11) {
                        if (layoutNode2.T() && this.f5092b.e(layoutNode2, true)) {
                            y(layoutNode2, true, false);
                        } else {
                            i(layoutNode2, true);
                        }
                    }
                    w(layoutNode2, z11);
                    if (!u(layoutNode2, z11)) {
                        j(layoutNode2, z11);
                    }
                }
                i11++;
            } while (i11 < iR);
        }
        w(layoutNode, z11);
    }

    public final boolean k(LayoutNode layoutNode) {
        return layoutNode.Y() && o(layoutNode);
    }

    public final boolean l(LayoutNode layoutNode) {
        return layoutNode.T() && p(layoutNode);
    }

    public final boolean m() {
        return this.f5092b.h();
    }

    public final boolean n() {
        return this.f5095e.c();
    }

    public final boolean o(LayoutNode layoutNode) {
        return layoutNode.a0() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.P().r().l().k();
    }

    public final boolean p(LayoutNode layoutNode) {
        AlignmentLines alignmentLinesL;
        if (layoutNode.b0() == LayoutNode.UsageByParent.InMeasureBlock) {
            return true;
        }
        androidx.compose.ui.node.a aVarC = layoutNode.P().C();
        return (aVarC == null || (alignmentLinesL = aVarC.l()) == null || !alignmentLinesL.k()) ? false : true;
    }

    public final long q() {
        if (!this.f5093c) {
            h2.a.a("measureIteration should be only used during the measure/layout pass");
        }
        return this.f5097g;
    }

    public final boolean r(Function0<Unit> function0) {
        boolean z11;
        if (!this.f5091a.D0()) {
            h2.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!this.f5091a.k()) {
            h2.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (!(!this.f5093c)) {
            h2.a.a("performMeasureAndLayout called during measure layout");
        }
        boolean z12 = false;
        if (this.f5099i != null) {
            this.f5093c = true;
            this.f5094d = true;
            try {
                if (this.f5092b.h()) {
                    j jVar = this.f5092b;
                    z11 = false;
                    while (jVar.h()) {
                        boolean z13 = !jVar.f5083a.d();
                        LayoutNode layoutNodeE = (z13 ? jVar.f5083a : jVar.f5084b).e();
                        boolean z14 = z(this, layoutNodeE, z13, false, 4, null);
                        if (layoutNodeE == this.f5091a && z14) {
                            z11 = true;
                        }
                    }
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    z11 = false;
                }
                this.f5093c = false;
                this.f5094d = false;
                h0 h0Var = this.f5100j;
                if (h0Var != null) {
                    h0Var.a();
                }
                z12 = z11;
            } catch (Throwable th2) {
                this.f5093c = false;
                this.f5094d = false;
                throw th2;
            }
        }
        b();
        return z12;
    }

    public final void s(LayoutNode layoutNode, long j11) {
        if (layoutNode.E0()) {
            return;
        }
        if (!(!Intrinsics.b(layoutNode, this.f5091a))) {
            h2.a.a("measureAndLayout called on root");
        }
        if (!this.f5091a.D0()) {
            h2.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!this.f5091a.k()) {
            h2.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (!(!this.f5093c)) {
            h2.a.a("performMeasureAndLayout called during measure layout");
        }
        if (this.f5099i != null) {
            this.f5093c = true;
            this.f5094d = false;
            try {
                this.f5092b.i(layoutNode);
                if (e(layoutNode, q2.b.a(j11)) || layoutNode.S()) {
                    if (Intrinsics.b(layoutNode.G0(), Boolean.TRUE)) {
                        layoutNode.K0();
                    }
                }
                h(layoutNode);
                f(layoutNode, q2.b.a(j11));
                if (layoutNode.Q() && layoutNode.k()) {
                    layoutNode.Z0();
                    this.f5095e.d(layoutNode);
                }
                g();
                this.f5093c = false;
                this.f5094d = false;
                h0 h0Var = this.f5100j;
                if (h0Var != null) {
                    h0Var.a();
                }
            } catch (Throwable th2) {
                this.f5093c = false;
                this.f5094d = false;
                throw th2;
            }
        }
        b();
    }

    public final void t() {
        if (this.f5092b.h()) {
            if (!this.f5091a.D0()) {
                h2.a.a("performMeasureAndLayout called with unattached root");
            }
            if (!this.f5091a.k()) {
                h2.a.a("performMeasureAndLayout called with unplaced root");
            }
            if (!(!this.f5093c)) {
                h2.a.a("performMeasureAndLayout called during measure layout");
            }
            if (this.f5099i != null) {
                this.f5093c = true;
                this.f5094d = false;
                try {
                    if (!this.f5092b.g(true)) {
                        if (this.f5091a.V() != null) {
                            B(this.f5091a, true);
                        } else {
                            A(this.f5091a);
                        }
                    }
                    B(this.f5091a, false);
                    this.f5093c = false;
                    this.f5094d = false;
                    h0 h0Var = this.f5100j;
                    if (h0Var != null) {
                        h0Var.a();
                    }
                } catch (Throwable th2) {
                    this.f5093c = false;
                    this.f5094d = false;
                    throw th2;
                }
            }
        }
    }

    public final boolean u(LayoutNode layoutNode, boolean z11) {
        return z11 ? layoutNode.T() : layoutNode.Y();
    }

    public final void v(LayoutNode layoutNode) {
        this.f5092b.i(layoutNode);
        this.f5095e.f(layoutNode);
    }

    public final void w(LayoutNode layoutNode, boolean z11) {
        if (u(layoutNode, z11) && this.f5092b.e(layoutNode, z11)) {
            y(layoutNode, z11, false);
        }
    }

    public final void x(y0.b bVar) {
        this.f5096f.b(bVar);
    }

    public final boolean y(LayoutNode layoutNode, boolean z11, boolean z12) {
        q2.b bVar;
        LayoutNode layoutNodeH0;
        boolean zE = false;
        if (layoutNode.E0()) {
            return false;
        }
        if (layoutNode.k() || layoutNode.F0() || k(layoutNode) || Intrinsics.b(layoutNode.G0(), Boolean.TRUE) || l(layoutNode) || layoutNode.z()) {
            if (layoutNode == this.f5091a) {
                bVar = this.f5099i;
                Intrinsics.d(bVar);
            } else {
                bVar = null;
            }
            if (z11) {
                zE = layoutNode.T() ? e(layoutNode, bVar) : false;
                if (z12 && ((zE || layoutNode.S()) && Intrinsics.b(layoutNode.G0(), Boolean.TRUE))) {
                    layoutNode.K0();
                }
            } else {
                boolean zF = layoutNode.Y() ? f(layoutNode, bVar) : false;
                if (z12 && layoutNode.Q() && (layoutNode == this.f5091a || ((layoutNodeH0 = layoutNode.h0()) != null && layoutNodeH0.k() && layoutNode.F0()))) {
                    if (layoutNode == this.f5091a) {
                        layoutNode.T0(0, 0);
                    } else {
                        layoutNode.Z0();
                    }
                    this.f5095e.d(layoutNode);
                    h0 h0Var = this.f5100j;
                    if (h0Var != null) {
                        h0Var.a();
                    }
                }
                zE = zF;
            }
            g();
        }
        return zE;
    }
}
