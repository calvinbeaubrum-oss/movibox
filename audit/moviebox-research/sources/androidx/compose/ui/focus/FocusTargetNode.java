package androidx.compose.ui.focus;

import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class FocusTargetNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.d, v, u0, androidx.compose.ui.modifier.h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3913o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FocusStateImpl f3915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f3916r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3917a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3917a = iArr;
        }
    }

    public static final boolean Q1(FocusTargetNode focusTargetNode) {
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            h2.a.b("visitSubtreeIf called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = focusTargetNode.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar, focusTargetNode.getNode());
        } else {
            bVar.b(cVarF1);
        }
        while (bVar.u()) {
            androidx.compose.ui.f.c cVar = (androidx.compose.ui.f.c) bVar.z(bVar.r() - 1);
            if ((cVar.e1() & iA) != 0) {
                for (androidx.compose.ui.f.c cVarF2 = cVar; cVarF2 != null; cVarF2 = cVarF2.f1()) {
                    if ((cVarF2.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarF2;
                        androidx.compose.runtime.collection.b bVar2 = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarG;
                                if (S1(focusTargetNode2)) {
                                    int i11 = a.f3917a[focusTargetNode2.O1().ordinal()];
                                    if (i11 == 1 || i11 == 2 || i11 == 3) {
                                        return true;
                                    }
                                    if (i11 == 4) {
                                        return false;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i12 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i12++;
                                        if (i12 == 1) {
                                            cVarG = cVarI1;
                                        } else {
                                            if (bVar2 == null) {
                                                bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != null) {
                                                bVar2.b(cVarG);
                                                cVarG = null;
                                            }
                                            bVar2.b(cVarI1);
                                        }
                                    }
                                }
                                if (i12 == 1) {
                                }
                            }
                            cVarG = androidx.compose.ui.node.g.g(bVar2);
                        }
                    }
                }
            }
            androidx.compose.ui.node.g.c(bVar, cVar);
        }
        return false;
    }

    public static final boolean R1(FocusTargetNode focusTargetNode) {
        q0 q0VarE0;
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = focusTargetNode.getNode().l1();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(focusTargetNode);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarG;
                                if (S1(focusTargetNode2)) {
                                    int i11 = a.f3917a[focusTargetNode2.O1().ordinal()];
                                    if (i11 == 1 || i11 == 2) {
                                        return false;
                                    }
                                    if (i11 == 3) {
                                        return true;
                                    }
                                    if (i11 == 4) {
                                        return false;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i12 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i12++;
                                        if (i12 == 1) {
                                            cVarG = cVarI1;
                                        } else {
                                            if (bVar == null) {
                                                bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != null) {
                                                bVar.b(cVarG);
                                                cVarG = null;
                                            }
                                            bVar.b(cVarI1);
                                        }
                                    }
                                }
                                if (i12 == 1) {
                                }
                            }
                            cVarG = androidx.compose.ui.node.g.g(bVar);
                        }
                    }
                    cVarL1 = cVarL1.l1();
                }
            }
            layoutNodeM = layoutNodeM.h0();
            cVarL1 = (layoutNodeM == null || (q0VarE0 = layoutNodeM.e0()) == null) ? null : q0VarE0.o();
        }
        return false;
    }

    public static final boolean S1(FocusTargetNode focusTargetNode) {
        return focusTargetNode.f3915q != null;
    }

    public final void L1() {
        FocusStateImpl focusStateImplI = x.d(this).i(this);
        if (focusStateImplI != null) {
            this.f3915q = focusStateImplI;
        } else {
            h2.a.c("committing a node that was not updated in the current transaction");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14 */
    public final m M1() {
        q0 q0VarE0;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        int iA = s0.a(2048);
        int iA2 = s0.a(1024);
        androidx.compose.ui.f.c node = getNode();
        int i11 = iA | iA2;
        if (!getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c node2 = getNode();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(this);
        loop0: while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & i11) != 0) {
                while (node2 != null) {
                    if ((node2.j1() & i11) != 0) {
                        if (node2 != node && (node2.j1() & iA2) != 0) {
                            break loop0;
                        }
                        if ((node2.j1() & iA) != 0) {
                            androidx.compose.ui.f.c cVarG = node2;
                            androidx.compose.runtime.collection.b bVar = null;
                            while (cVarG != 0) {
                                if (cVarG instanceof o) {
                                    ((o) cVarG).A0(focusPropertiesImpl);
                                } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                    androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1();
                                    int i12 = 0;
                                    cVarG = cVarG;
                                    while (cVarI1 != null) {
                                        if ((cVarI1.j1() & iA) != 0) {
                                            i12++;
                                            if (i12 == 1) {
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
                                    if (i12 == 1) {
                                    }
                                }
                                cVarG = androidx.compose.ui.node.g.g(bVar);
                            }
                        }
                    }
                    node2 = node2.l1();
                }
            }
            layoutNodeM = layoutNodeM.h0();
            node2 = (layoutNodeM == null || (q0VarE0 = layoutNodeM.e0()) == null) ? null : q0VarE0.o();
        }
        return focusPropertiesImpl;
    }

    public final androidx.compose.ui.layout.e N1() {
        return (androidx.compose.ui.layout.e) W(BeyondBoundsLayoutKt.a());
    }

    public FocusStateImpl O1() {
        FocusStateImpl focusStateImplI;
        y yVarB = x.b(this);
        if (yVarB != null && (focusStateImplI = yVarB.i(this)) != null) {
            return focusStateImplI;
        }
        FocusStateImpl focusStateImpl = this.f3915q;
        return focusStateImpl == null ? FocusStateImpl.Inactive : focusStateImpl;
    }

    public final void P1() {
        if (!(!S1(this))) {
            throw new IllegalStateException("Re-initializing focus target node.".toString());
        }
        y yVarD = x.d(this);
        try {
            if (yVarD.f3940c) {
                yVarD.g();
            }
            yVarD.f();
            U1((R1(this) && Q1(this)) ? FocusStateImpl.ActiveParent : FocusStateImpl.Inactive);
            Unit unit = Unit.f68710a;
        } finally {
            yVarD.h();
        }
    }

    public final void T1() {
        m mVar;
        if (this.f3915q == null) {
            P1();
        }
        int i11 = a.f3917a[O1().ordinal()];
        if (i11 == 1 || i11 == 2) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            v0.a(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [T, androidx.compose.ui.focus.m] */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    objectRef.element = this.M1();
                }
            });
            T t11 = objectRef.element;
            if (t11 == 0) {
                Intrinsics.y("focusProperties");
                mVar = null;
            } else {
                mVar = (m) t11;
            }
            if (mVar.t()) {
                return;
            }
            androidx.compose.ui.node.g.n(this).getFocusOwner().o(true);
        }
    }

    public void U1(FocusStateImpl focusStateImpl) {
        x.d(this).j(this, focusStateImpl);
    }

    @Override // androidx.compose.ui.modifier.k
    public /* synthetic */ Object W(androidx.compose.ui.modifier.c cVar) {
        return androidx.compose.ui.modifier.g.a(this, cVar);
    }

    @Override // androidx.compose.ui.modifier.h
    public /* synthetic */ androidx.compose.ui.modifier.f b0() {
        return androidx.compose.ui.modifier.g.b(this);
    }

    @Override // androidx.compose.ui.node.u0
    public void g0() {
        FocusStateImpl focusStateImplO1 = O1();
        T1();
        if (focusStateImplO1 != O1()) {
            e.c(this);
        }
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f3916r;
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        int i11 = a.f3917a[O1().ordinal()];
        if (i11 == 1 || i11 == 2) {
            androidx.compose.ui.node.g.n(this).getFocusOwner().i(true, true, false, b.f3922b.c());
            x.c(this);
        } else if (i11 == 3) {
            y yVarD = x.d(this);
            try {
                if (yVarD.f3940c) {
                    yVarD.g();
                }
                yVarD.f();
                U1(FocusStateImpl.Inactive);
                Unit unit = Unit.f68710a;
                yVarD.h();
            } catch (Throwable th2) {
                yVarD.h();
                throw th2;
            }
        }
        this.f3915q = null;
    }
}
