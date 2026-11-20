package androidx.compose.ui.node;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.p4;
import androidx.compose.ui.graphics.w1;
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
public final class s extends NodeCoordinator {
    public static final a W = new a(null);
    public static final o4 X;
    public final l1 U;
    public j0 V;

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
            super(s.this);
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int E0(androidx.compose.ui.layout.a aVar) {
            Integer num = q1().m().get(aVar);
            int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            s1().put(aVar, Integer.valueOf(iIntValue));
            return iIntValue;
        }

        @Override // androidx.compose.ui.layout.t
        public androidx.compose.ui.layout.k0 L(long j11) {
            B0(j11);
            androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = X0().p0();
            int iR = bVarP0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarP0.q();
                int i11 = 0;
                do {
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = layoutNodeArrQ[i11].U();
                    Intrinsics.d(lookaheadPassDelegateU);
                    lookaheadPassDelegateU.m1(LayoutNode.UsageByParent.NotUsed);
                    i11++;
                } while (i11 < iR);
            }
            C1(X0().Z().c(this, X0().C(), j11));
            return this;
        }

        @Override // androidx.compose.ui.node.j0
        public void x1() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = X0().U();
            Intrinsics.d(lookaheadPassDelegateU);
            lookaheadPassDelegateU.h1();
        }
    }

    static {
        o4 o4VarA = androidx.compose.ui.graphics.t0.a();
        o4VarA.t(w1.f4564b.c());
        o4VarA.setStrokeWidth(1.0f);
        o4VarA.D(p4.f4317a.b());
        X = o4VarA;
    }

    public s(LayoutNode layoutNode) {
        super(layoutNode);
        this.U = new l1();
        X1().G1(this);
        this.V = layoutNode.V() != null ? new b() : null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int E0(androidx.compose.ui.layout.a aVar) {
        j0 j0VarT1 = T1();
        if (j0VarT1 != null) {
            return j0VarT1.E0(aVar);
        }
        Integer num = O1().m().get(aVar);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void J1() {
        if (T1() == null) {
            S2(new b());
        }
    }

    @Override // androidx.compose.ui.layout.t
    public androidx.compose.ui.layout.k0 L(long j11) {
        if (P1()) {
            j0 j0VarT1 = T1();
            Intrinsics.d(j0VarT1);
            j11 = j0VarT1.t1();
        }
        B0(j11);
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = X0().p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                layoutNodeArrQ[i11].X().t1(LayoutNode.UsageByParent.NotUsed);
                i11++;
            } while (i11 < iR);
        }
        B2(X0().Z().c(this, X0().D(), j11));
        q2();
        return this;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    /* JADX INFO: renamed from: Q2, reason: merged with bridge method [inline-methods] */
    public l1 X1() {
        return this.U;
    }

    public final void R2() {
        if (j1()) {
            return;
        }
        r2();
        X0().X().n1();
    }

    public void S2(j0 j0Var) {
        this.V = j0Var;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public j0 T1() {
        return this.V;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    @Override // androidx.compose.ui.node.NodeCoordinator
    public void h2(NodeCoordinator.d dVar, long j11, q qVar, boolean z11, boolean z12) {
        boolean z13;
        boolean z14 = false;
        if (!dVar.d(X0())) {
            z13 = z12;
        } else if (P2(j11)) {
            z13 = z12;
            z14 = true;
        } else if (z11) {
            float fF1 = F1(j11, U1());
            if (Float.isInfinite(fF1) || Float.isNaN(fF1)) {
                z13 = z12;
            } else {
                z14 = true;
                z13 = false;
            }
        } else {
            z13 = z12;
        }
        if (z14) {
            int i11 = qVar.f5114c;
            androidx.compose.runtime.collection.b<LayoutNode> bVarO0 = X0().o0();
            int iR = bVarO0.r();
            if (iR > 0) {
                LayoutNode[] layoutNodeArrQ = bVarO0.q();
                int i12 = iR - 1;
                do {
                    LayoutNode layoutNode = layoutNodeArrQ[i12];
                    if (layoutNode.k()) {
                        dVar.c(layoutNode, j11, qVar, z11, z13);
                        if (!qVar.w()) {
                            i12--;
                        } else {
                            if (!qVar.u()) {
                                break;
                            }
                            qVar.a();
                            i12--;
                        }
                    } else {
                        i12--;
                    }
                } while (i12 >= 0);
            }
            qVar.f5114c = i11;
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void t2(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        y0 y0VarB = f0.b(X0());
        androidx.compose.runtime.collection.b<LayoutNode> bVarO0 = X0().o0();
        int iR = bVarO0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarO0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArrQ[i11];
                if (layoutNode.k()) {
                    layoutNode.y(o1Var, graphicsLayer);
                }
                i11++;
            } while (i11 < iR);
        }
        if (y0VarB.getShowLayoutBounds()) {
            H1(o1Var, X);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.k0
    public void u0(long j11, float f11, GraphicsLayer graphicsLayer) {
        super.u0(j11, f11, graphicsLayer);
        R2();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.k0
    public void x0(long j11, float f11, Function1<? super e4, Unit> function1) {
        super.x0(j11, f11, function1);
        R2();
    }
}
