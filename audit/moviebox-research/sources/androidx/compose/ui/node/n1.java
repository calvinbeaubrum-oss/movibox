package androidx.compose.ui.node;

import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class n1 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    public static final m1 a(f fVar, Object obj) {
        q0 q0VarE0;
        int iA = s0.a(262144);
        if (!fVar.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = fVar.getNode().l1();
        LayoutNode layoutNodeM = g.m(fVar);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != 0) {
                            if (cVarG instanceof m1) {
                                m1 m1Var = (m1) cVarG;
                                if (Intrinsics.b(obj, m1Var.I())) {
                                    return m1Var;
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                                androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                                int i11 = 0;
                                cVarG = cVarG;
                                while (cVarI1 != null) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
                                }
                            }
                            cVarG = g.g(bVar);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    public static final <T extends m1> T b(T t11) {
        q0 q0VarE0;
        int iA = s0.a(262144);
        if (!t11.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = t11.getNode().l1();
        LayoutNode layoutNodeM = g.m(t11);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != 0) {
                            if (cVarG instanceof m1) {
                                T t12 = (T) cVarG;
                                if (Intrinsics.b(t11.I(), t12.I()) && androidx.compose.ui.a.a(t11, t12)) {
                                    return t12;
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                                androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                                int i11 = 0;
                                cVarG = cVarG;
                                while (cVarI1 != null) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
                                }
                            }
                            cVarG = g.g(bVar);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    public static final void c(f fVar, Object obj, Function1<? super m1, Boolean> function1) {
        q0 q0VarE0;
        int iA = s0.a(262144);
        if (!fVar.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = fVar.getNode().l1();
        LayoutNode layoutNodeM = g.m(fVar);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != 0) {
                            if (cVarG instanceof m1) {
                                m1 m1Var = (m1) cVarG;
                                if (Intrinsics.b(obj, m1Var.I()) && !function1.invoke(m1Var).booleanValue()) {
                                    return;
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                                androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                                int i11 = 0;
                                cVarG = cVarG;
                                while (cVarI1 != null) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
                                }
                            }
                            cVarG = g.g(bVar);
                        }
                    }
                    cVarL1 = cVarL1.l1();
                }
            }
            layoutNodeM = layoutNodeM.h0();
            cVarL1 = (layoutNodeM == null || (q0VarE0 = layoutNodeM.e0()) == null) ? null : q0VarE0.o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15 */
    public static final <T extends m1> void d(T t11, Function1<? super T, Boolean> function1) {
        q0 q0VarE0;
        int iA = s0.a(262144);
        if (!t11.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = t11.getNode().l1();
        LayoutNode layoutNodeM = g.m(t11);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != 0) {
                            if (cVarG instanceof m1) {
                                m1 m1Var = (m1) cVarG;
                                if (Intrinsics.b(t11.I(), m1Var.I()) && androidx.compose.ui.a.a(t11, m1Var) && !function1.invoke(m1Var).booleanValue()) {
                                    return;
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                                androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1();
                                int i11 = 0;
                                cVarG = cVarG;
                                while (cVarI1 != null) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
                                }
                            }
                            cVarG = g.g(bVar);
                        }
                    }
                    cVarL1 = cVarL1.l1();
                }
            }
            layoutNodeM = layoutNodeM.h0();
            cVarL1 = (layoutNodeM == null || (q0VarE0 = layoutNodeM.e0()) == null) ? null : q0VarE0.o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    public static final void e(androidx.compose.ui.node.f r12, java.lang.Object r13, kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.m1, ? extends androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction> r14) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.n1.e(androidx.compose.ui.node.f, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    public static final <T extends androidx.compose.ui.node.m1> void f(T r13, kotlin.jvm.functions.Function1<? super T, ? extends androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction> r14) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.n1.f(androidx.compose.ui.node.m1, kotlin.jvm.functions.Function1):void");
    }
}
