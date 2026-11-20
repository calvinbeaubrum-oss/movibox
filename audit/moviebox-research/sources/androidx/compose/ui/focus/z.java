package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class z {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3942b;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f3941a = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            f3942b = iArr2;
        }
    }

    public static final FocusRequester a(FocusTargetNode focusTargetNode, int i11, LayoutDirection layoutDirection) {
        FocusRequester focusRequesterP;
        m mVarM1 = focusTargetNode.M1();
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.e())) {
            return mVarM1.getNext();
        }
        if (b.l(i11, aVar.f())) {
            return mVarM1.u();
        }
        if (b.l(i11, aVar.h())) {
            return mVarM1.n();
        }
        if (b.l(i11, aVar.a())) {
            return mVarM1.q();
        }
        if (b.l(i11, aVar.d())) {
            int i12 = a.f3941a[layoutDirection.ordinal()];
            if (i12 == 1) {
                focusRequesterP = mVarM1.j();
            } else {
                if (i12 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                focusRequesterP = mVarM1.p();
            }
            if (focusRequesterP == FocusRequester.f3908b.b()) {
                focusRequesterP = null;
            }
            if (focusRequesterP == null) {
                return mVarM1.i();
            }
        } else {
            if (!b.l(i11, aVar.g())) {
                if (b.l(i11, aVar.b())) {
                    return mVarM1.s().invoke(b.i(i11));
                }
                if (b.l(i11, aVar.c())) {
                    return mVarM1.o().invoke(b.i(i11));
                }
                throw new IllegalStateException("invalid FocusDirection".toString());
            }
            int i13 = a.f3941a[layoutDirection.ordinal()];
            if (i13 == 1) {
                focusRequesterP = mVarM1.p();
            } else {
                if (i13 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                focusRequesterP = mVarM1.j();
            }
            if (focusRequesterP == FocusRequester.f3908b.b()) {
                focusRequesterP = null;
            }
            if (focusRequesterP == null) {
                return mVarM1.m();
            }
        }
        return focusRequesterP;
    }

    public static final FocusTargetNode b(FocusTargetNode focusTargetNode) {
        int i11 = a.f3942b[focusTargetNode.O1().ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                int iA = s0.a(1024);
                if (!focusTargetNode.getNode().o1()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                androidx.compose.ui.f.c cVarF1 = focusTargetNode.getNode().f1();
                if (cVarF1 == null) {
                    androidx.compose.ui.node.g.c(bVar, focusTargetNode.getNode());
                } else {
                    bVar.b(cVarF1);
                }
                while (bVar.u()) {
                    androidx.compose.ui.f.c cVarG = (androidx.compose.ui.f.c) bVar.z(bVar.r() - 1);
                    if ((cVarG.e1() & iA) == 0) {
                        androidx.compose.ui.node.g.c(bVar, cVarG);
                    } else {
                        while (cVarG != null) {
                            if ((cVarG.j1() & iA) != 0) {
                                androidx.compose.runtime.collection.b bVar2 = null;
                                while (cVarG != null) {
                                    if (cVarG instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNodeB = b((FocusTargetNode) cVarG);
                                        if (focusTargetNodeB != null) {
                                            return focusTargetNodeB;
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
                                break;
                            }
                            cVarG = cVarG.f1();
                        }
                    }
                }
                return null;
            }
            if (i11 != 3) {
                if (i11 == 4) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return focusTargetNode;
    }

    public static final FocusTargetNode c(FocusTargetNode focusTargetNode) {
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
                                if (focusTargetNode2.M1().t()) {
                                    return focusTargetNode2;
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i11 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
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
        return null;
    }

    public static final y1.i d(FocusTargetNode focusTargetNode) {
        y1.i iVarK;
        NodeCoordinator nodeCoordinatorG1 = focusTargetNode.g1();
        return (nodeCoordinatorG1 == null || (iVarK = androidx.compose.ui.layout.n.d(nodeCoordinatorG1).K(nodeCoordinatorG1, false)) == null) ? y1.i.f81075e.a() : iVarK;
    }

    public static final Boolean e(FocusTargetNode focusTargetNode, int i11, LayoutDirection layoutDirection, y1.i iVar, Function1<? super FocusTargetNode, Boolean> function1) {
        int iG;
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.e()) || b.l(i11, aVar.f())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.f(focusTargetNode, i11, function1));
        }
        if (b.l(i11, aVar.d()) || b.l(i11, aVar.g()) || b.l(i11, aVar.h()) || b.l(i11, aVar.a())) {
            return TwoDimensionalFocusSearchKt.t(focusTargetNode, i11, iVar, function1);
        }
        if (!b.l(i11, aVar.b())) {
            if (b.l(i11, aVar.c())) {
                FocusTargetNode focusTargetNodeB = b(focusTargetNode);
                FocusTargetNode focusTargetNodeC = focusTargetNodeB != null ? c(focusTargetNodeB) : null;
                return Boolean.valueOf((focusTargetNodeC == null || Intrinsics.b(focusTargetNodeC, focusTargetNode)) ? false : function1.invoke(focusTargetNodeC).booleanValue());
            }
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) b.n(i11))).toString());
        }
        int i12 = a.f3941a[layoutDirection.ordinal()];
        if (i12 == 1) {
            iG = aVar.g();
        } else {
            if (i12 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iG = aVar.d();
        }
        FocusTargetNode focusTargetNodeB2 = b(focusTargetNode);
        if (focusTargetNodeB2 != null) {
            return TwoDimensionalFocusSearchKt.t(focusTargetNodeB2, iG, iVar, function1);
        }
        return null;
    }

    public static final FocusTargetNode f(FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.getNode().o1()) {
            return null;
        }
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = focusTargetNode.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar, focusTargetNode.getNode());
        } else {
            bVar.b(cVarF1);
        }
        while (bVar.u()) {
            androidx.compose.ui.f.c cVarG = (androidx.compose.ui.f.c) bVar.z(bVar.r() - 1);
            if ((cVarG.e1() & iA) == 0) {
                androidx.compose.ui.node.g.c(bVar, cVarG);
            } else {
                while (cVarG != null) {
                    if ((cVarG.j1() & iA) != 0) {
                        androidx.compose.runtime.collection.b bVar2 = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarG;
                                if (focusTargetNode2.getNode().o1()) {
                                    int i11 = a.f3942b[focusTargetNode2.O1().ordinal()];
                                    if (i11 == 1 || i11 == 2 || i11 == 3) {
                                        return focusTargetNode2;
                                    }
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
                        break;
                    }
                    cVarG = cVarG.f1();
                }
            }
        }
        return null;
    }

    public static final boolean g(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNodeX0;
        NodeCoordinator nodeCoordinatorG1;
        LayoutNode layoutNodeX1;
        NodeCoordinator nodeCoordinatorG2 = focusTargetNode.g1();
        return (nodeCoordinatorG2 == null || (layoutNodeX0 = nodeCoordinatorG2.X0()) == null || !layoutNodeX0.k() || (nodeCoordinatorG1 = focusTargetNode.g1()) == null || (layoutNodeX1 = nodeCoordinatorG1.X0()) == null || !layoutNodeX1.D0()) ? false : true;
    }
}
