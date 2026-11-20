package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.node.s0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.t;

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
public final class SemanticsNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.f.c f5586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutNode f5588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f5589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SemanticsNode f5591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5592g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends androidx.compose.ui.f.c implements i1 {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Function1<q, Unit> f5593o;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super q, Unit> function1) {
            this.f5593o = function1;
        }

        @Override // androidx.compose.ui.node.i1
        public /* synthetic */ boolean V() {
            return h1.a(this);
        }

        @Override // androidx.compose.ui.node.i1
        public void W0(q qVar) {
            this.f5593o.invoke(qVar);
        }

        @Override // androidx.compose.ui.node.i1
        public /* synthetic */ boolean Z0() {
            return h1.b(this);
        }
    }

    public SemanticsNode(androidx.compose.ui.f.c cVar, boolean z11, LayoutNode layoutNode, l lVar) {
        this.f5586a = cVar;
        this.f5587b = z11;
        this.f5588c = layoutNode;
        this.f5589d = lVar;
        this.f5592g = layoutNode.j0();
    }

    public static /* synthetic */ List D(SemanticsNode semanticsNode, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        return semanticsNode.C(z11, z12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List g(SemanticsNode semanticsNode, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = new ArrayList();
        }
        return semanticsNode.f(list);
    }

    public static /* synthetic */ List m(SemanticsNode semanticsNode, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = !semanticsNode.f5587b;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        if ((i11 & 4) != 0) {
            z13 = false;
        }
        return semanticsNode.l(z11, z12, z13);
    }

    public final boolean A() {
        return !this.f5590e && t().isEmpty() && o.f(this.f5588c, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$isUnmergedLeafNode$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode layoutNode) {
                l lVarF = layoutNode.F();
                boolean z11 = false;
                if (lVarF != null && lVarF.v()) {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }
        }) == null;
    }

    public final void B(l lVar) {
        if (this.f5589d.u()) {
            return;
        }
        List listD = D(this, false, false, 3, null);
        int size = listD.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode = (SemanticsNode) listD.get(i11);
            if (!semanticsNode.y()) {
                lVar.w(semanticsNode.f5589d);
                semanticsNode.B(lVar);
            }
        }
    }

    public final List<SemanticsNode> C(boolean z11, boolean z12) {
        if (this.f5590e) {
            return kotlin.collections.g.l();
        }
        ArrayList arrayList = new ArrayList();
        d(this.f5588c, arrayList, z12);
        if (z11) {
            b(arrayList);
        }
        return arrayList;
    }

    public final SemanticsNode a() {
        return new SemanticsNode(this.f5586a, true, this.f5588c, this.f5589d);
    }

    public final void b(List<SemanticsNode> list) {
        final i iVarH = o.h(this);
        if (iVarH != null && this.f5589d.v() && (!list.isEmpty())) {
            list.add(c(iVarH, new Function1<q, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                    invoke2(qVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(q qVar) {
                    SemanticsPropertiesKt.B(qVar, iVarH.n());
                }
            }));
        }
        l lVar = this.f5589d;
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        if (lVar.f(semanticsProperties.d()) && (!list.isEmpty()) && this.f5589d.v()) {
            List list2 = (List) SemanticsConfigurationKt.a(this.f5589d, semanticsProperties.d());
            final String str = list2 != null ? (String) CollectionsKt___CollectionsKt.g0(list2) : null;
            if (str != null) {
                list.add(0, c(null, new Function1<q, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                        invoke2(qVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(q qVar) {
                        SemanticsPropertiesKt.v(qVar, str);
                    }
                }));
            }
        }
    }

    public final SemanticsNode c(i iVar, Function1<? super q, Unit> function1) {
        l lVar = new l();
        lVar.y(false);
        lVar.x(false);
        function1.invoke(lVar);
        SemanticsNode semanticsNode = new SemanticsNode(new a(function1), false, new LayoutNode(true, iVar != null ? o.i(this) : o.e(this)), lVar);
        semanticsNode.f5590e = true;
        semanticsNode.f5591f = this;
        return semanticsNode;
    }

    public final void d(LayoutNode layoutNode, List<SemanticsNode> list, boolean z11) {
        androidx.compose.runtime.collection.b<LayoutNode> bVarO0 = layoutNode.o0();
        int iR = bVarO0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarO0.q();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArrQ[i11];
                if (layoutNode2.D0() && (z11 || !layoutNode2.E0())) {
                    if (layoutNode2.e0().q(s0.a(8))) {
                        list.add(o.a(layoutNode2, this.f5587b));
                    } else {
                        d(layoutNode2, list, z11);
                    }
                }
                i11++;
            } while (i11 < iR);
        }
    }

    public final NodeCoordinator e() {
        if (this.f5590e) {
            SemanticsNode semanticsNodeR = r();
            if (semanticsNodeR != null) {
                return semanticsNodeR.e();
            }
            return null;
        }
        androidx.compose.ui.node.f fVarG = o.g(this.f5588c);
        if (fVarG == null) {
            fVarG = this.f5586a;
        }
        return androidx.compose.ui.node.g.h(fVarG, s0.a(8));
    }

    public final List<SemanticsNode> f(List<SemanticsNode> list) {
        List listD = D(this, false, false, 3, null);
        int size = listD.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode = (SemanticsNode) listD.get(i11);
            if (semanticsNode.y()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.f5589d.u()) {
                semanticsNode.f(list);
            }
        }
        return list;
    }

    public final y1.i h() {
        androidx.compose.ui.layout.m mVarU0;
        SemanticsNode semanticsNodeR = r();
        if (semanticsNodeR == null) {
            return y1.i.f81075e.a();
        }
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.D()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null && (mVarU0 = nodeCoordinatorE.U0()) != null) {
                return androidx.compose.ui.layout.l.a(androidx.compose.ui.node.g.h(semanticsNodeR.f5586a, s0.a(8)), mVarU0, false, 2, null);
            }
        }
        return y1.i.f81075e.a();
    }

    public final y1.i i() {
        y1.i iVarB;
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.D()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null && (iVarB = androidx.compose.ui.layout.n.b(nodeCoordinatorE)) != null) {
                return iVarB;
            }
        }
        return y1.i.f81075e.a();
    }

    public final y1.i j() {
        y1.i iVarC;
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.D()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null && (iVarC = androidx.compose.ui.layout.n.c(nodeCoordinatorE)) != null) {
                return iVarC;
            }
        }
        return y1.i.f81075e.a();
    }

    public final List<SemanticsNode> k() {
        return m(this, false, false, false, 7, null);
    }

    public final List<SemanticsNode> l(boolean z11, boolean z12, boolean z13) {
        if (z11 || !this.f5589d.u()) {
            return y() ? g(this, null, 1, null) : C(z12, z13);
        }
        return kotlin.collections.g.l();
    }

    public final l n() {
        if (!y()) {
            return this.f5589d;
        }
        l lVarI = this.f5589d.i();
        B(lVarI);
        return lVarI;
    }

    public final int o() {
        return this.f5592g;
    }

    public final androidx.compose.ui.layout.o p() {
        return this.f5588c;
    }

    public final LayoutNode q() {
        return this.f5588c;
    }

    public final SemanticsNode r() {
        SemanticsNode semanticsNode = this.f5591f;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode layoutNodeF = this.f5587b ? o.f(this.f5588c, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode layoutNode) {
                l lVarF = layoutNode.F();
                boolean z11 = false;
                if (lVarF != null && lVarF.v()) {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }
        }) : null;
        if (layoutNodeF == null) {
            layoutNodeF = o.f(this.f5588c, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode) {
                    return Boolean.valueOf(layoutNode.e0().q(s0.a(8)));
                }
            });
        }
        if (layoutNodeF == null) {
            return null;
        }
        return o.a(layoutNodeF, this.f5587b);
    }

    public final long s() {
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.D()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null) {
                return androidx.compose.ui.layout.n.e(nodeCoordinatorE);
            }
        }
        return y1.g.f81070b.c();
    }

    public final List<SemanticsNode> t() {
        return m(this, false, true, false, 4, null);
    }

    public final long u() {
        NodeCoordinator nodeCoordinatorE = e();
        return nodeCoordinatorE != null ? nodeCoordinatorE.p() : t.f74253b.a();
    }

    public final y1.i v() {
        androidx.compose.ui.node.f fVarG;
        if (!this.f5589d.v() || (fVarG = o.g(this.f5588c)) == null) {
            fVarG = this.f5586a;
        }
        return j1.c(fVarG.getNode(), j1.a(this.f5589d));
    }

    public final l w() {
        return this.f5589d;
    }

    public final boolean x() {
        return this.f5590e;
    }

    public final boolean y() {
        return this.f5587b && this.f5589d.v();
    }

    public final boolean z() {
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            return nodeCoordinatorE.k2();
        }
        return false;
    }
}
