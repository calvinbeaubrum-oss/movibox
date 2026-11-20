package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.node.v0;
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
public final class FocusTransactionsKt {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3919b;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3918a = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f3919b = iArr2;
        }
    }

    public static final boolean a(FocusTargetNode focusTargetNode, boolean z11, boolean z12) {
        FocusTargetNode focusTargetNodeF = z.f(focusTargetNode);
        if (focusTargetNodeF != null) {
            return c(focusTargetNodeF, z11, z12);
        }
        return true;
    }

    public static /* synthetic */ boolean b(FocusTargetNode focusTargetNode, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        return a(focusTargetNode, z11, z12);
    }

    public static final boolean c(FocusTargetNode focusTargetNode, boolean z11, boolean z12) {
        int i11 = a.f3919b[focusTargetNode.O1().ordinal()];
        if (i11 == 1) {
            focusTargetNode.U1(FocusStateImpl.Inactive);
            if (z12) {
                e.c(focusTargetNode);
            }
        } else {
            if (i11 == 2) {
                if (!z11) {
                    return z11;
                }
                focusTargetNode.U1(FocusStateImpl.Inactive);
                if (!z12) {
                    return z11;
                }
                e.c(focusTargetNode);
                return z11;
            }
            if (i11 != 3) {
                if (i11 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (!a(focusTargetNode, z11, z12)) {
                    return false;
                }
                focusTargetNode.U1(FocusStateImpl.Inactive);
                if (z12) {
                    e.c(focusTargetNode);
                }
            }
        }
        return true;
    }

    public static final boolean d(final FocusTargetNode focusTargetNode) {
        v0.a(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
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
                focusTargetNode.M1();
            }
        });
        int i11 = a.f3919b[focusTargetNode.O1().ordinal()];
        if (i11 != 3 && i11 != 4) {
            return true;
        }
        focusTargetNode.U1(FocusStateImpl.Active);
        return true;
    }

    public static final CustomDestinationResult e(FocusTargetNode focusTargetNode, int i11) {
        int i12 = a.f3919b[focusTargetNode.O1().ordinal()];
        if (i12 != 1) {
            if (i12 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i12 == 3) {
                CustomDestinationResult customDestinationResultE = e(n(focusTargetNode), i11);
                if (customDestinationResultE == CustomDestinationResult.None) {
                    customDestinationResultE = null;
                }
                return customDestinationResultE == null ? g(focusTargetNode, i11) : customDestinationResultE;
            }
            if (i12 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    public static final CustomDestinationResult f(FocusTargetNode focusTargetNode, int i11) {
        if (!focusTargetNode.f3914p) {
            focusTargetNode.f3914p = true;
            try {
                FocusRequester focusRequesterInvoke = focusTargetNode.M1().s().invoke(b.i(i11));
                FocusRequester.a aVar = FocusRequester.f3908b;
                if (focusRequesterInvoke != aVar.b()) {
                    if (focusRequesterInvoke == aVar.a()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequesterInvoke.d() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.f3914p = false;
            }
        }
        return CustomDestinationResult.None;
    }

    public static final CustomDestinationResult g(FocusTargetNode focusTargetNode, int i11) {
        if (!focusTargetNode.f3913o) {
            focusTargetNode.f3913o = true;
            try {
                FocusRequester focusRequesterInvoke = focusTargetNode.M1().o().invoke(b.i(i11));
                FocusRequester.a aVar = FocusRequester.f3908b;
                if (focusRequesterInvoke != aVar.b()) {
                    if (focusRequesterInvoke == aVar.a()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequesterInvoke.d() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.f3913o = false;
            }
        }
        return CustomDestinationResult.None;
    }

    public static final CustomDestinationResult h(FocusTargetNode focusTargetNode, int i11) {
        androidx.compose.ui.f.c cVarG;
        q0 q0VarE0;
        int i12 = a.f3919b[focusTargetNode.O1().ordinal()];
        if (i12 == 1 || i12 == 2) {
            return CustomDestinationResult.None;
        }
        if (i12 == 3) {
            return e(n(focusTargetNode), i11);
        }
        if (i12 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        int iA = s0.a(1024);
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = focusTargetNode.getNode().l1();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(focusTargetNode);
        loop0: while (true) {
            if (layoutNodeM == null) {
                cVarG = null;
                break;
            }
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i13 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i13++;
                                        if (i13 == 1) {
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
                                if (i13 == 1) {
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarG;
        if (focusTargetNode2 == null) {
            return CustomDestinationResult.None;
        }
        int i14 = a.f3919b[focusTargetNode2.O1().ordinal()];
        if (i14 == 1) {
            return f(focusTargetNode2, i11);
        }
        if (i14 == 2) {
            return CustomDestinationResult.Cancelled;
        }
        if (i14 == 3) {
            return h(focusTargetNode2, i11);
        }
        if (i14 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        CustomDestinationResult customDestinationResultH = h(focusTargetNode2, i11);
        CustomDestinationResult customDestinationResult = customDestinationResultH != CustomDestinationResult.None ? customDestinationResultH : null;
        return customDestinationResult == null ? f(focusTargetNode2, i11) : customDestinationResult;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00da  */
    public static final boolean i(FocusTargetNode focusTargetNode) {
        q0 q0VarE0;
        int i11 = a.f3919b[focusTargetNode.O1().ordinal()];
        boolean zL = true;
        if (i11 != 1 && i11 != 2) {
            androidx.compose.ui.f.c cVar = null;
            if (i11 != 3) {
                if (i11 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int iA = s0.a(1024);
                if (!focusTargetNode.getNode().o1()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                androidx.compose.ui.f.c cVarL1 = focusTargetNode.getNode().l1();
                LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(focusTargetNode);
                loop0: while (layoutNodeM != null) {
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
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVar;
                if (focusTargetNode2 != null) {
                    FocusStateImpl focusStateImplO1 = focusTargetNode2.O1();
                    zL = l(focusTargetNode2, focusTargetNode);
                    if (zL && focusStateImplO1 != focusTargetNode2.O1()) {
                        e.c(focusTargetNode2);
                    }
                } else if (!m(focusTargetNode) || !d(focusTargetNode)) {
                    zL = false;
                }
            } else if (!b(focusTargetNode, false, false, 3, null) || !d(focusTargetNode)) {
                zL = false;
            }
        }
        if (zL) {
            e.c(focusTargetNode);
        }
        return zL;
    }

    public static final boolean j(FocusTargetNode focusTargetNode) {
        Boolean boolK = k(focusTargetNode, b.f3922b.b());
        if (boolK != null) {
            return boolK.booleanValue();
        }
        return false;
    }

    public static final Boolean k(final FocusTargetNode focusTargetNode, int i11) {
        Boolean boolValueOf;
        y yVarD = x.d(focusTargetNode);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$requestFocus$1
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
                if (focusTargetNode.getNode().o1()) {
                    e.c(focusTargetNode);
                }
            }
        };
        try {
            if (yVarD.f3940c) {
                yVarD.g();
            }
            yVarD.f();
            yVarD.f3939b.b(function0);
            int i12 = a.f3918a[h(focusTargetNode, i11).ordinal()];
            if (i12 == 1) {
                boolValueOf = Boolean.valueOf(i(focusTargetNode));
            } else if (i12 != 2) {
                if (i12 != 3 && i12 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.TRUE;
            }
            yVarD.h();
            return boolValueOf;
        } catch (Throwable th2) {
            yVarD.h();
            throw th2;
        }
    }

    public static final boolean l(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        androidx.compose.ui.f.c cVar;
        androidx.compose.ui.f.c cVarG;
        q0 q0VarE0;
        q0 q0VarE1;
        int iA = s0.a(1024);
        if (!focusTargetNode2.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = focusTargetNode2.getNode().l1();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(focusTargetNode2);
        loop0: while (true) {
            cVar = null;
            if (layoutNodeM == null) {
                cVarG = null;
                break;
            }
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
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
            cVarL1 = (layoutNodeM == null || (q0VarE1 = layoutNodeM.e0()) == null) ? null : q0VarE1.o();
        }
        if (!Intrinsics.b(cVarG, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        int i12 = a.f3919b[focusTargetNode.O1().ordinal()];
        if (i12 == 1) {
            boolean zD = d(focusTargetNode2);
            if (!zD) {
                return zD;
            }
            focusTargetNode.U1(FocusStateImpl.ActiveParent);
            return zD;
        }
        if (i12 != 2) {
            if (i12 == 3) {
                n(focusTargetNode);
                if (b(focusTargetNode, false, false, 3, null) && d(focusTargetNode2)) {
                    return true;
                }
            } else {
                if (i12 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int iA2 = s0.a(1024);
                if (!focusTargetNode.getNode().o1()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                androidx.compose.ui.f.c cVarL2 = focusTargetNode.getNode().l1();
                LayoutNode layoutNodeM2 = androidx.compose.ui.node.g.m(focusTargetNode);
                loop4: while (layoutNodeM2 != null) {
                    if ((layoutNodeM2.e0().k().e1() & iA2) != 0) {
                        while (cVarL2 != null) {
                            if ((cVarL2.j1() & iA2) != 0) {
                                androidx.compose.ui.f.c cVarG2 = cVarL2;
                                androidx.compose.runtime.collection.b bVar2 = null;
                                while (cVarG2 != null) {
                                    if (cVarG2 instanceof FocusTargetNode) {
                                        cVar = cVarG2;
                                        break loop4;
                                    }
                                    if ((cVarG2.j1() & iA2) != 0 && (cVarG2 instanceof androidx.compose.ui.node.i)) {
                                        int i13 = 0;
                                        for (androidx.compose.ui.f.c cVarI2 = ((androidx.compose.ui.node.i) cVarG2).I1(); cVarI2 != null; cVarI2 = cVarI2.f1()) {
                                            if ((cVarI2.j1() & iA2) != 0) {
                                                i13++;
                                                if (i13 == 1) {
                                                    cVarG2 = cVarI2;
                                                } else {
                                                    if (bVar2 == null) {
                                                        bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                                    }
                                                    if (cVarG2 != null) {
                                                        bVar2.b(cVarG2);
                                                        cVarG2 = null;
                                                    }
                                                    bVar2.b(cVarI2);
                                                }
                                            }
                                        }
                                        if (i13 == 1) {
                                        }
                                    }
                                    cVarG2 = androidx.compose.ui.node.g.g(bVar2);
                                }
                            }
                            cVarL2 = cVarL2.l1();
                        }
                    }
                    layoutNodeM2 = layoutNodeM2.h0();
                    cVarL2 = (layoutNodeM2 == null || (q0VarE0 = layoutNodeM2.e0()) == null) ? null : q0VarE0.o();
                }
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) cVar;
                if (focusTargetNode3 == null && m(focusTargetNode)) {
                    boolean zD2 = d(focusTargetNode2);
                    if (!zD2) {
                        return zD2;
                    }
                    focusTargetNode.U1(FocusStateImpl.ActiveParent);
                    return zD2;
                }
                if (focusTargetNode3 != null && l(focusTargetNode3, focusTargetNode)) {
                    boolean zL = l(focusTargetNode, focusTargetNode2);
                    if (focusTargetNode.O1() != FocusStateImpl.ActiveParent) {
                        throw new IllegalStateException("Deactivated node is focused".toString());
                    }
                    if (!zL) {
                        return zL;
                    }
                    e.c(focusTargetNode3);
                    return zL;
                }
            }
        }
        return false;
    }

    public static final boolean m(FocusTargetNode focusTargetNode) {
        return androidx.compose.ui.node.g.n(focusTargetNode).getFocusOwner().m(null, null);
    }

    public static final FocusTargetNode n(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNodeF = z.f(focusTargetNode);
        if (focusTargetNodeF != null) {
            return focusTargetNodeF;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }
}
