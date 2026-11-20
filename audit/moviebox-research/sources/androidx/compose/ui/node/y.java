package androidx.compose.ui.node;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.p4;
import androidx.compose.ui.graphics.w1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class y extends NodeCoordinator {
    public static final a Y = new a(null);
    public static final o4 Z;
    public x U;
    public q2.b V;
    public j0 W;
    public androidx.compose.ui.layout.d X;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class b extends j0 {
        public b() {
            super(y.this);
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int E0(androidx.compose.ui.layout.a aVar) {
            int iB = z.b(this, aVar);
            s1().put(aVar, Integer.valueOf(iB));
            return iB;
        }

        @Override // androidx.compose.ui.layout.t
        public androidx.compose.ui.layout.k0 L(long j11) {
            y yVar = y.this;
            B0(j11);
            yVar.W2(q2.b.a(j11));
            x xVarR2 = yVar.R2();
            j0 j0VarT1 = yVar.T2().T1();
            Intrinsics.d(j0VarT1);
            C1(xVarR2.C(this, j0VarT1, j11));
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.compose.ui.layout.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.compose.ui.layout.w f5152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5154c;

        public c(androidx.compose.ui.layout.w wVar, y yVar) {
            this.f5152a = wVar;
            j0 j0VarT1 = yVar.T1();
            Intrinsics.d(j0VarT1);
            this.f5153b = j0VarT1.s0();
            j0 j0VarT2 = yVar.T1();
            Intrinsics.d(j0VarT2);
            this.f5154c = j0VarT2.g0();
        }

        @Override // androidx.compose.ui.layout.w
        public int getHeight() {
            return this.f5154c;
        }

        @Override // androidx.compose.ui.layout.w
        public int getWidth() {
            return this.f5153b;
        }

        @Override // androidx.compose.ui.layout.w
        public Map<androidx.compose.ui.layout.a, Integer> l() {
            return this.f5152a.l();
        }

        @Override // androidx.compose.ui.layout.w
        public void m() {
            this.f5152a.m();
        }

        @Override // androidx.compose.ui.layout.w
        public Function1<androidx.compose.ui.layout.o0, Unit> n() {
            return this.f5152a.n();
        }
    }

    static {
        o4 o4VarA = androidx.compose.ui.graphics.t0.a();
        o4VarA.t(w1.f4564b.b());
        o4VarA.setStrokeWidth(1.0f);
        o4VarA.D(p4.f4317a.b());
        Z = o4VarA;
    }

    public y(LayoutNode layoutNode, x xVar) {
        super(layoutNode);
        this.U = xVar;
        androidx.compose.ui.layout.d dVar = null;
        this.W = layoutNode.V() != null ? new b() : null;
        if ((xVar.getNode().j1() & s0.a(512)) != 0) {
            Intrinsics.e(xVar, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            dVar = new androidx.compose.ui.layout.d(this, (androidx.compose.ui.layout.b) xVar);
        }
        this.X = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    private final void U2() {
        boolean z11;
        if (j1()) {
            return;
        }
        r2();
        androidx.compose.ui.layout.d dVar = this.X;
        if (dVar != null) {
            androidx.compose.ui.layout.b bVarL = dVar.l();
            androidx.compose.ui.layout.k0.a aVarB1 = b1();
            j0 j0VarT1 = T1();
            Intrinsics.d(j0VarT1);
            if (bVarL.d1(aVarB1, j0VarT1.v1()) || dVar.k()) {
                z11 = false;
            } else {
                long jP = p();
                j0 j0VarT2 = T1();
                if (q2.t.d(jP, j0VarT2 != null ? q2.t.b(j0VarT2.w1()) : null)) {
                    long jP2 = T2().p();
                    j0 j0VarT3 = T2().T1();
                    if (q2.t.d(jP2, j0VarT3 != null ? q2.t.b(j0VarT3.w1()) : null)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = false;
                }
            }
            T2().A2(z11);
        }
        Y0().m();
        T2().A2(false);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int E0(androidx.compose.ui.layout.a aVar) {
        j0 j0VarT1 = T1();
        return j0VarT1 != null ? j0VarT1.r1(aVar) : z.b(this, aVar);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void J1() {
        if (T1() == null) {
            X2(new b());
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    @Override // androidx.compose.ui.layout.t
    public androidx.compose.ui.layout.k0 L(long j11) {
        androidx.compose.ui.layout.w wVarC;
        boolean z11;
        if (P1()) {
            q2.b bVar = this.V;
            if (bVar == null) {
                throw new IllegalArgumentException("Lookahead constraints cannot be null in approach pass.".toString());
            }
            j11 = bVar.r();
        }
        B0(j11);
        androidx.compose.ui.layout.d dVar = this.X;
        if (dVar != null) {
            androidx.compose.ui.layout.b bVarL = dVar.l();
            dVar.A(bVarL.u0(dVar.x()) || !q2.b.e(j11, S2()));
            if (!dVar.k()) {
                T2().z2(true);
            }
            wVarC = bVarL.q0(dVar, T2(), j11);
            T2().z2(false);
            int width = wVarC.getWidth();
            j0 j0VarT1 = T1();
            Intrinsics.d(j0VarT1);
            if (width == j0VarT1.s0()) {
                int height = wVarC.getHeight();
                j0 j0VarT2 = T1();
                Intrinsics.d(j0VarT2);
                z11 = height == j0VarT2.g0();
            }
            if (!dVar.k()) {
                long jP = T2().p();
                j0 j0VarT3 = T2().T1();
                if (q2.t.d(jP, j0VarT3 != null ? q2.t.b(j0VarT3.w1()) : null) && !z11) {
                    wVarC = new c(wVarC, this);
                }
            }
        } else {
            wVarC = R2().C(this, T2(), j11);
        }
        B2(wVarC);
        q2();
        return this;
    }

    public final x R2() {
        return this.U;
    }

    public final q2.b S2() {
        return this.V;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public j0 T1() {
        return this.W;
    }

    public final NodeCoordinator T2() {
        NodeCoordinator nodeCoordinatorY1 = Y1();
        Intrinsics.d(nodeCoordinatorY1);
        return nodeCoordinatorY1;
    }

    public final void V2(x xVar) {
        if (!Intrinsics.b(xVar, this.U)) {
            androidx.compose.ui.f.c node = xVar.getNode();
            if ((node.j1() & s0.a(512)) != 0) {
                Intrinsics.e(xVar, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                androidx.compose.ui.layout.b bVar = (androidx.compose.ui.layout.b) xVar;
                androidx.compose.ui.layout.d dVar = this.X;
                if (dVar != null) {
                    dVar.C(bVar);
                } else {
                    dVar = new androidx.compose.ui.layout.d(this, bVar);
                }
                this.X = dVar;
            } else {
                this.X = null;
            }
        }
        this.U = xVar;
    }

    public final void W2(q2.b bVar) {
        this.V = bVar;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public androidx.compose.ui.f.c X1() {
        return this.U.getNode();
    }

    public void X2(j0 j0Var) {
        this.W = j0Var;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void t2(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        T2().G1(o1Var, graphicsLayer);
        if (f0.b(X0()).getShowLayoutBounds()) {
            H1(o1Var, Z);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.k0
    public void u0(long j11, float f11, GraphicsLayer graphicsLayer) {
        super.u0(j11, f11, graphicsLayer);
        U2();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.k0
    public void x0(long j11, float f11, Function1<? super e4, Unit> function1) {
        super.x0(j11, f11, function1);
        U2();
    }
}
