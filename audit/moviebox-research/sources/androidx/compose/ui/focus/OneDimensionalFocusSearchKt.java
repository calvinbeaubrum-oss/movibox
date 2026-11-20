package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public final class OneDimensionalFocusSearchKt {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3920a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3920a = iArr;
        }
    }

    public static final boolean b(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusStateImpl focusStateImplO1 = focusTargetNode.O1();
        int[] iArr = a.f3920a;
        int i11 = iArr[focusStateImplO1.ordinal()];
        if (i11 == 1) {
            FocusTargetNode focusTargetNodeF = z.f(focusTargetNode);
            if (focusTargetNodeF == null) {
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
            int i12 = iArr[focusTargetNodeF.O1().ordinal()];
            if (i12 != 1) {
                if (i12 == 2 || i12 == 3) {
                    return d(focusTargetNode, focusTargetNodeF, b.f3922b.f(), function1);
                }
                if (i12 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
            if (!b(focusTargetNodeF, function1) && !d(focusTargetNode, focusTargetNodeF, b.f3922b.f(), function1) && (!focusTargetNodeF.M1().t() || !function1.invoke(focusTargetNodeF).booleanValue())) {
                return false;
            }
        } else {
            if (i11 == 2 || i11 == 3) {
                return g(focusTargetNode, function1);
            }
            if (i11 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!g(focusTargetNode, function1) && (!focusTargetNode.M1().t() || !function1.invoke(focusTargetNode).booleanValue())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean c(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        int i11 = a.f3920a[focusTargetNode.O1().ordinal()];
        if (i11 == 1) {
            FocusTargetNode focusTargetNodeF = z.f(focusTargetNode);
            if (focusTargetNodeF != null) {
                return c(focusTargetNodeF, function1) || d(focusTargetNode, focusTargetNodeF, b.f3922b.e(), function1);
            }
            throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
        }
        if (i11 == 2 || i11 == 3) {
            return h(focusTargetNode, function1);
        }
        if (i11 == 4) {
            return focusTargetNode.M1().t() ? function1.invoke(focusTargetNode).booleanValue() : h(focusTargetNode, function1);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean d(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i11, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (i(focusTargetNode, focusTargetNode2, i11, function1)) {
            return true;
        }
        Boolean bool = (Boolean) androidx.compose.ui.focus.a.a(focusTargetNode, i11, new Function1<androidx.compose.ui.layout.e.a, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(androidx.compose.ui.layout.e.a aVar) {
                Boolean boolValueOf = Boolean.valueOf(OneDimensionalFocusSearchKt.i(focusTargetNode, focusTargetNode2, i11, function1));
                if (boolValueOf.booleanValue() || !aVar.a()) {
                    return boolValueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean e(FocusTargetNode focusTargetNode) {
        androidx.compose.ui.f.c cVar;
        q0 q0VarE0;
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = focusTargetNode.getNode().l1();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(focusTargetNode);
        loop0: while (true) {
            cVar = null;
            if (layoutNodeM == null) {
                break;
            }
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                cVar = cVarG;
                                break loop0;
                            }
                            if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
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
        return cVar == null;
    }

    public static final boolean f(FocusTargetNode focusTargetNode, int i11, Function1<? super FocusTargetNode, Boolean> function1) {
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.e())) {
            return c(focusTargetNode, function1);
        }
        if (b.l(i11, aVar.f())) {
            return b(focusTargetNode, function1);
        }
        throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
    }

    public static final boolean g(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = focusTargetNode.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar2, focusTargetNode.getNode());
        } else {
            bVar2.b(cVarF1);
        }
        while (bVar2.u()) {
            androidx.compose.ui.f.c cVarG = (androidx.compose.ui.f.c) bVar2.z(bVar2.r() - 1);
            if ((cVarG.e1() & iA) == 0) {
                androidx.compose.ui.node.g.c(bVar2, cVarG);
            } else {
                while (cVarG != null) {
                    if ((cVarG.j1() & iA) != 0) {
                        androidx.compose.runtime.collection.b bVar3 = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                bVar.b((FocusTargetNode) cVarG);
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i11 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVarG = cVarI1;
                                        } else {
                                            if (bVar3 == null) {
                                                bVar3 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != null) {
                                                bVar3.b(cVarG);
                                                cVarG = null;
                                            }
                                            bVar3.b(cVarI1);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVarG = androidx.compose.ui.node.g.g(bVar3);
                        }
                        break;
                    }
                    cVarG = cVarG.f1();
                }
            }
        }
        bVar.E(FocusableChildrenComparator.INSTANCE);
        int iR = bVar.r();
        if (iR > 0) {
            int i12 = iR - 1;
            Object[] objArrQ = bVar.q();
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArrQ[i12];
                if (z.g(focusTargetNode2) && b(focusTargetNode2, function1)) {
                    return true;
                }
                i12--;
            } while (i12 >= 0);
        }
        return false;
    }

    public static final boolean h(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = focusTargetNode.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar2, focusTargetNode.getNode());
        } else {
            bVar2.b(cVarF1);
        }
        while (bVar2.u()) {
            androidx.compose.ui.f.c cVarG = (androidx.compose.ui.f.c) bVar2.z(bVar2.r() - 1);
            if ((cVarG.e1() & iA) == 0) {
                androidx.compose.ui.node.g.c(bVar2, cVarG);
            } else {
                while (cVarG != null) {
                    if ((cVarG.j1() & iA) != 0) {
                        androidx.compose.runtime.collection.b bVar3 = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                bVar.b((FocusTargetNode) cVarG);
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i11 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVarG = cVarI1;
                                        } else {
                                            if (bVar3 == null) {
                                                bVar3 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != null) {
                                                bVar3.b(cVarG);
                                                cVarG = null;
                                            }
                                            bVar3.b(cVarI1);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVarG = androidx.compose.ui.node.g.g(bVar3);
                        }
                        break;
                    }
                    cVarG = cVarG.f1();
                }
            }
        }
        bVar.E(FocusableChildrenComparator.INSTANCE);
        int iR = bVar.r();
        if (iR <= 0) {
            return false;
        }
        Object[] objArrQ = bVar.q();
        int i12 = 0;
        do {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArrQ[i12];
            if (z.g(focusTargetNode2) && c(focusTargetNode2, function1)) {
                return true;
            }
            i12++;
        } while (i12 < iR);
        return false;
    }

    public static final boolean i(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i11, Function1<? super FocusTargetNode, Boolean> function1) {
        if (focusTargetNode.O1() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = focusTargetNode.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar2, focusTargetNode.getNode());
        } else {
            bVar2.b(cVarF1);
        }
        while (bVar2.u()) {
            androidx.compose.ui.f.c cVarG = (androidx.compose.ui.f.c) bVar2.z(bVar2.r() - 1);
            if ((cVarG.e1() & iA) == 0) {
                androidx.compose.ui.node.g.c(bVar2, cVarG);
            } else {
                while (cVarG != null) {
                    if ((cVarG.j1() & iA) != 0) {
                        androidx.compose.runtime.collection.b bVar3 = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                bVar.b((FocusTargetNode) cVarG);
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i12 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i12++;
                                        if (i12 == 1) {
                                            cVarG = cVarI1;
                                        } else {
                                            if (bVar3 == null) {
                                                bVar3 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != null) {
                                                bVar3.b(cVarG);
                                                cVarG = null;
                                            }
                                            bVar3.b(cVarI1);
                                        }
                                    }
                                }
                                if (i12 == 1) {
                                }
                            }
                            cVarG = androidx.compose.ui.node.g.g(bVar3);
                        }
                        break;
                    }
                    cVarG = cVarG.f1();
                }
            }
        }
        bVar.E(FocusableChildrenComparator.INSTANCE);
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.e())) {
            IntRange intRange = new IntRange(0, bVar.r() - 1);
            int iG = intRange.g();
            int i13 = intRange.i();
            if (iG <= i13) {
                boolean z11 = false;
                while (true) {
                    if (z11) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) bVar.q()[iG];
                        if (z.g(focusTargetNode3) && c(focusTargetNode3, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.b(bVar.q()[iG], focusTargetNode2)) {
                        z11 = true;
                    }
                    if (iG == i13) {
                        break;
                    }
                    iG++;
                }
            }
        } else {
            if (!b.l(i11, aVar.f())) {
                throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
            }
            IntRange intRange2 = new IntRange(0, bVar.r() - 1);
            int iG2 = intRange2.g();
            int i14 = intRange2.i();
            if (iG2 <= i14) {
                boolean z12 = false;
                while (true) {
                    if (z12) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) bVar.q()[i14];
                        if (z.g(focusTargetNode4) && b(focusTargetNode4, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.b(bVar.q()[i14], focusTargetNode2)) {
                        z12 = true;
                    }
                    if (i14 == iG2) {
                        break;
                    }
                    i14--;
                }
            }
        }
        if (b.l(i11, b.f3922b.e()) || !focusTargetNode.M1().t() || e(focusTargetNode)) {
            return false;
        }
        return function1.invoke(focusTargetNode).booleanValue();
    }
}
