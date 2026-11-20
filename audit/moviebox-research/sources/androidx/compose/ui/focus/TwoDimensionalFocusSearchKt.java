package androidx.compose.ui.focus;

import androidx.compose.ui.node.s0;
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
public final class TwoDimensionalFocusSearchKt {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3921a;

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
            f3921a = iArr;
        }
    }

    public static final FocusTargetNode b(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.O1() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("Searching for active node in inactive hierarchy".toString());
        }
        FocusTargetNode focusTargetNodeB = z.b(focusTargetNode);
        if (focusTargetNodeB != null) {
            return focusTargetNodeB;
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }

    public static final boolean c(y1.i iVar, y1.i iVar2, y1.i iVar3, int i11) {
        if (d(iVar3, i11, iVar) || !d(iVar2, i11, iVar)) {
            return false;
        }
        if (e(iVar3, i11, iVar)) {
            b.a aVar = b.f3922b;
            if (!b.l(i11, aVar.d()) && !b.l(i11, aVar.g()) && f(iVar2, i11, iVar) >= g(iVar3, i11, iVar)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean d(y1.i iVar, int i11, y1.i iVar2) {
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.d()) || b.l(i11, aVar.g())) {
            if (iVar.c() <= iVar2.i() || iVar.i() >= iVar2.c()) {
                return false;
            }
        } else {
            if (!b.l(i11, aVar.h()) && !b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            if (iVar.g() <= iVar2.f() || iVar.f() >= iVar2.g()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean e(y1.i iVar, int i11, y1.i iVar2) {
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.d())) {
            if (iVar2.f() < iVar.g()) {
                return false;
            }
        } else if (b.l(i11, aVar.g())) {
            if (iVar2.g() > iVar.f()) {
                return false;
            }
        } else if (b.l(i11, aVar.h())) {
            if (iVar2.i() < iVar.c()) {
                return false;
            }
        } else {
            if (!b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            if (iVar2.c() > iVar.i()) {
                return false;
            }
        }
        return true;
    }

    public static final float f(y1.i iVar, int i11, y1.i iVar2) {
        float fI;
        float fC;
        float fI2;
        float fC2;
        float f11;
        b.a aVar = b.f3922b;
        if (!b.l(i11, aVar.d())) {
            if (b.l(i11, aVar.g())) {
                fI = iVar.f();
                fC = iVar2.g();
            } else if (b.l(i11, aVar.h())) {
                fI2 = iVar2.i();
                fC2 = iVar.c();
            } else {
                if (!b.l(i11, aVar.a())) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                }
                fI = iVar.i();
                fC = iVar2.c();
            }
            f11 = fI - fC;
            return Math.max(0.0f, f11);
        }
        fI2 = iVar2.f();
        fC2 = iVar.g();
        f11 = fI2 - fC2;
        return Math.max(0.0f, f11);
    }

    public static final float g(y1.i iVar, int i11, y1.i iVar2) {
        float fC;
        float fC2;
        float fI;
        float fI2;
        float f11;
        b.a aVar = b.f3922b;
        if (!b.l(i11, aVar.d())) {
            if (b.l(i11, aVar.g())) {
                fC = iVar.g();
                fC2 = iVar2.g();
            } else if (b.l(i11, aVar.h())) {
                fI = iVar2.i();
                fI2 = iVar.i();
            } else {
                if (!b.l(i11, aVar.a())) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                }
                fC = iVar.c();
                fC2 = iVar2.c();
            }
            f11 = fC - fC2;
            return Math.max(1.0f, f11);
        }
        fI = iVar2.f();
        fI2 = iVar.f();
        f11 = fI - fI2;
        return Math.max(1.0f, f11);
    }

    public static final y1.i h(y1.i iVar) {
        return new y1.i(iVar.g(), iVar.c(), iVar.g(), iVar.c());
    }

    public static final void i(androidx.compose.ui.node.f fVar, androidx.compose.runtime.collection.b<FocusTargetNode> bVar) {
        int iA = s0.a(1024);
        if (!fVar.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = fVar.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar2, fVar.getNode());
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
                                FocusTargetNode focusTargetNode = (FocusTargetNode) cVarG;
                                if (focusTargetNode.o1() && !androidx.compose.ui.node.g.m(focusTargetNode).E0()) {
                                    if (focusTargetNode.M1().t()) {
                                        bVar.b(focusTargetNode);
                                    } else {
                                        i(focusTargetNode, bVar);
                                    }
                                }
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
    }

    public static final FocusTargetNode j(androidx.compose.runtime.collection.b<FocusTargetNode> bVar, y1.i iVar, int i11) {
        y1.i iVarP;
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.d())) {
            iVarP = iVar.p(iVar.k() + 1, 0.0f);
        } else if (b.l(i11, aVar.g())) {
            iVarP = iVar.p(-(iVar.k() + 1), 0.0f);
        } else if (b.l(i11, aVar.h())) {
            iVarP = iVar.p(0.0f, iVar.e() + 1);
        } else {
            if (!b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            iVarP = iVar.p(0.0f, -(iVar.e() + 1));
        }
        int iR = bVar.r();
        FocusTargetNode focusTargetNode = null;
        if (iR > 0) {
            FocusTargetNode[] focusTargetNodeArrQ = bVar.q();
            int i12 = 0;
            do {
                FocusTargetNode focusTargetNode2 = focusTargetNodeArrQ[i12];
                if (z.g(focusTargetNode2)) {
                    y1.i iVarD = z.d(focusTargetNode2);
                    if (m(iVarD, iVarP, iVar, i11)) {
                        focusTargetNode = focusTargetNode2;
                        iVarP = iVarD;
                    }
                }
                i12++;
            } while (i12 < iR);
        }
        return focusTargetNode;
    }

    public static final boolean k(FocusTargetNode focusTargetNode, int i11, Function1<? super FocusTargetNode, Boolean> function1) {
        y1.i iVarS;
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        i(focusTargetNode, bVar);
        if (bVar.r() <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (bVar.t() ? null : bVar.q()[0]);
            if (focusTargetNode2 != null) {
                return function1.invoke(focusTargetNode2).booleanValue();
            }
            return false;
        }
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.b())) {
            i11 = aVar.g();
        }
        if (b.l(i11, aVar.g()) || b.l(i11, aVar.a())) {
            iVarS = s(z.d(focusTargetNode));
        } else {
            if (!b.l(i11, aVar.d()) && !b.l(i11, aVar.h())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            iVarS = h(z.d(focusTargetNode));
        }
        FocusTargetNode focusTargetNodeJ = j(bVar, iVarS, i11);
        if (focusTargetNodeJ != null) {
            return function1.invoke(focusTargetNodeJ).booleanValue();
        }
        return false;
    }

    public static final boolean l(final FocusTargetNode focusTargetNode, final y1.i iVar, final int i11, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (r(focusTargetNode, iVar, i11, function1)) {
            return true;
        }
        Boolean bool = (Boolean) androidx.compose.ui.focus.a.a(focusTargetNode, i11, new Function1<androidx.compose.ui.layout.e.a, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(androidx.compose.ui.layout.e.a aVar) {
                Boolean boolValueOf = Boolean.valueOf(TwoDimensionalFocusSearchKt.r(focusTargetNode, iVar, i11, function1));
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

    public static final boolean m(y1.i iVar, y1.i iVar2, y1.i iVar3, int i11) {
        if (n(iVar, i11, iVar3)) {
            return !n(iVar2, i11, iVar3) || c(iVar3, iVar, iVar2, i11) || (!c(iVar3, iVar2, iVar, i11) && q(i11, iVar3, iVar) < q(i11, iVar3, iVar2));
        }
        return false;
    }

    public static final boolean n(y1.i iVar, int i11, y1.i iVar2) {
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.d())) {
            if ((iVar2.g() <= iVar.g() && iVar2.f() < iVar.g()) || iVar2.f() <= iVar.f()) {
                return false;
            }
        } else if (b.l(i11, aVar.g())) {
            if ((iVar2.f() >= iVar.f() && iVar2.g() > iVar.f()) || iVar2.g() >= iVar.g()) {
                return false;
            }
        } else if (b.l(i11, aVar.h())) {
            if ((iVar2.c() <= iVar.c() && iVar2.i() < iVar.c()) || iVar2.i() <= iVar.i()) {
                return false;
            }
        } else {
            if (!b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            if ((iVar2.i() >= iVar.i() && iVar2.c() > iVar.i()) || iVar2.c() >= iVar.c()) {
                return false;
            }
        }
        return true;
    }

    public static final float o(y1.i iVar, int i11, y1.i iVar2) {
        float fI;
        float fC;
        float fI2;
        float fC2;
        float f11;
        b.a aVar = b.f3922b;
        if (!b.l(i11, aVar.d())) {
            if (b.l(i11, aVar.g())) {
                fI = iVar.f();
                fC = iVar2.g();
            } else if (b.l(i11, aVar.h())) {
                fI2 = iVar2.i();
                fC2 = iVar.c();
            } else {
                if (!b.l(i11, aVar.a())) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                }
                fI = iVar.i();
                fC = iVar2.c();
            }
            f11 = fI - fC;
            return Math.max(0.0f, f11);
        }
        fI2 = iVar2.f();
        fC2 = iVar.g();
        f11 = fI2 - fC2;
        return Math.max(0.0f, f11);
    }

    public static final float p(y1.i iVar, int i11, y1.i iVar2) {
        float f11;
        float fI;
        float fI2;
        float fE;
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.d()) || b.l(i11, aVar.g())) {
            f11 = 2;
            fI = iVar2.i() + (iVar2.e() / f11);
            fI2 = iVar.i();
            fE = iVar.e();
        } else {
            if (!b.l(i11, aVar.h()) && !b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            }
            f11 = 2;
            fI = iVar2.f() + (iVar2.k() / f11);
            fI2 = iVar.f();
            fE = iVar.k();
        }
        return fI - (fI2 + (fE / f11));
    }

    public static final long q(int i11, y1.i iVar, y1.i iVar2) {
        long jAbs = (long) Math.abs(o(iVar2, i11, iVar));
        long jAbs2 = (long) Math.abs(p(iVar2, i11, iVar));
        return (((long) 13) * jAbs * jAbs) + (jAbs2 * jAbs2);
    }

    public static final boolean r(FocusTargetNode focusTargetNode, y1.i iVar, int i11, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusTargetNode focusTargetNodeJ;
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarG;
                                if (focusTargetNode2.o1()) {
                                    bVar.b(focusTargetNode2);
                                }
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
        while (bVar.u() && (focusTargetNodeJ = j(bVar, iVar, i11)) != null) {
            if (focusTargetNodeJ.M1().t()) {
                return function1.invoke(focusTargetNodeJ).booleanValue();
            }
            if (l(focusTargetNodeJ, iVar, i11, function1)) {
                return true;
            }
            bVar.x(focusTargetNodeJ);
        }
        return false;
    }

    public static final y1.i s(y1.i iVar) {
        return new y1.i(iVar.f(), iVar.i(), iVar.f(), iVar.i());
    }

    public static final Boolean t(FocusTargetNode focusTargetNode, int i11, y1.i iVar, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusStateImpl focusStateImplO1 = focusTargetNode.O1();
        int[] iArr = a.f3921a;
        int i12 = iArr[focusStateImplO1.ordinal()];
        if (i12 != 1) {
            if (i12 == 2 || i12 == 3) {
                return Boolean.valueOf(k(focusTargetNode, i11, function1));
            }
            if (i12 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (focusTargetNode.M1().t()) {
                return function1.invoke(focusTargetNode);
            }
            return iVar == null ? Boolean.valueOf(k(focusTargetNode, i11, function1)) : Boolean.valueOf(r(focusTargetNode, iVar, i11, function1));
        }
        FocusTargetNode focusTargetNodeF = z.f(focusTargetNode);
        if (focusTargetNodeF == null) {
            throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
        }
        int i13 = iArr[focusTargetNodeF.O1().ordinal()];
        if (i13 == 1) {
            Boolean boolT = t(focusTargetNodeF, i11, iVar, function1);
            if (!Intrinsics.b(boolT, Boolean.FALSE)) {
                return boolT;
            }
            if (iVar == null) {
                iVar = z.d(b(focusTargetNodeF));
            }
            return Boolean.valueOf(l(focusTargetNode, iVar, i11, function1));
        }
        if (i13 == 2 || i13 == 3) {
            if (iVar == null) {
                iVar = z.d(focusTargetNodeF);
            }
            return Boolean.valueOf(l(focusTargetNode, iVar, i11, function1));
        }
        if (i13 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }
}
