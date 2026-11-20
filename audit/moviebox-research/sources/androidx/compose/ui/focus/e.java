package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import kotlin.Metadata;
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
public final class e {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3932a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
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
            f3932a = iArr;
        }
    }

    public static final u a(d dVar) {
        int iA = s0.a(1024);
        androidx.compose.ui.f.c node = dVar.getNode();
        androidx.compose.runtime.collection.b bVar = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                FocusStateImpl focusStateImplO1 = ((FocusTargetNode) node).O1();
                int i11 = a.f3932a[focusStateImplO1.ordinal()];
                if (i11 == 1 || i11 == 2 || i11 == 3) {
                    return focusStateImplO1;
                }
            } else if ((node.j1() & iA) != 0 && (node instanceof androidx.compose.ui.node.i)) {
                int i12 = 0;
                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) node).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                    if ((cVarI1.j1() & iA) != 0) {
                        i12++;
                        if (i12 == 1) {
                            node = cVarI1;
                        } else {
                            if (bVar == null) {
                                bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                            }
                            if (node != null) {
                                bVar.b(node);
                                node = null;
                            }
                            bVar.b(cVarI1);
                        }
                    }
                }
                if (i12 == 1) {
                }
            }
            node = androidx.compose.ui.node.g.g(bVar);
        }
        if (!dVar.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = dVar.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar2, dVar.getNode());
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
                                FocusStateImpl focusStateImplO2 = ((FocusTargetNode) cVarG).O1();
                                int i13 = a.f3932a[focusStateImplO2.ordinal()];
                                if (i13 == 1 || i13 == 2 || i13 == 3) {
                                    return focusStateImplO2;
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i14 = 0;
                                for (androidx.compose.ui.f.c cVarI2 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI2 != null; cVarI2 = cVarI2.f1()) {
                                    if ((cVarI2.j1() & iA) != 0) {
                                        i14++;
                                        if (i14 == 1) {
                                            cVarG = cVarI2;
                                        } else {
                                            if (bVar3 == null) {
                                                bVar3 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != null) {
                                                bVar3.b(cVarG);
                                                cVarG = null;
                                            }
                                            bVar3.b(cVarI2);
                                        }
                                    }
                                }
                                if (i14 == 1) {
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
        return FocusStateImpl.Inactive;
    }

    public static final void b(d dVar) {
        androidx.compose.ui.node.g.n(dVar).getFocusOwner().b(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v14 */
    public static final void c(FocusTargetNode focusTargetNode) {
        q0 q0VarE0;
        int iA = s0.a(4096);
        int iA2 = s0.a(1024);
        androidx.compose.ui.f.c node = focusTargetNode.getNode();
        int i11 = iA | iA2;
        if (!focusTargetNode.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c node2 = focusTargetNode.getNode();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(focusTargetNode);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & i11) != 0) {
                while (node2 != null) {
                    if ((node2.j1() & i11) != 0) {
                        if (node2 != node && (node2.j1() & iA2) != 0) {
                            return;
                        }
                        if ((node2.j1() & iA) != 0) {
                            androidx.compose.ui.f.c cVarG = node2;
                            androidx.compose.runtime.collection.b bVar = null;
                            while (cVarG != 0) {
                                if (cVarG instanceof d) {
                                    d dVar = (d) cVarG;
                                    dVar.D(a(dVar));
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
    }
}
