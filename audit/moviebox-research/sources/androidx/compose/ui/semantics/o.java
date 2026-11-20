package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.http2.Http2Connection;

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
public final class o {
    /* JADX WARN: Code duplicated, block: B:36:0x0075 A[LOOP:0: B:5:0x0016->B:36:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x007a A[EDGE_INSN: B:41:0x007a->B:37:0x007a BREAK  A[LOOP:0: B:5:0x0016->B:36:0x0075], SYNTHETIC] */
    public static final SemanticsNode a(LayoutNode layoutNode, boolean z11) {
        q0 q0VarE0 = layoutNode.e0();
        int iA = s0.a(8);
        Object obj = null;
        if ((q0VarE0.i() & iA) != 0) {
            loop0: for (androidx.compose.ui.f.c cVarK = q0VarE0.k(); cVarK != null; cVarK = cVarK.f1()) {
                if ((cVarK.j1() & iA) == 0) {
                    if ((cVarK.e1() & iA) != 0) {
                        break;
                        break;
                    }
                } else {
                    androidx.compose.ui.f.c cVarG = cVarK;
                    androidx.compose.runtime.collection.b bVar = null;
                    while (cVarG != null) {
                        if (cVarG instanceof i1) {
                            obj = cVarG;
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
                    if ((cVarK.e1() & iA) != 0) {
                        break;
                    }
                }
            }
        }
        Intrinsics.d(obj);
        androidx.compose.ui.f.c node = ((i1) obj).getNode();
        l lVarF = layoutNode.F();
        Intrinsics.d(lVarF);
        return new SemanticsNode(node, z11, layoutNode, lVarF);
    }

    public static final int e(SemanticsNode semanticsNode) {
        return semanticsNode.o() + 2000000000;
    }

    public static final LayoutNode f(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode layoutNodeH0 = layoutNode.h0(); layoutNodeH0 != null; layoutNodeH0 = layoutNodeH0.h0()) {
            if (function1.invoke(layoutNodeH0).booleanValue()) {
                return layoutNodeH0;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x007e A[LOOP:0: B:5:0x0016->B:38:0x007e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0083 A[EDGE_INSN: B:43:0x0083->B:39:0x0083 BREAK  A[LOOP:0: B:5:0x0016->B:38:0x007e], SYNTHETIC] */
    public static final i1 g(LayoutNode layoutNode) {
        q0 q0VarE0 = layoutNode.e0();
        int iA = s0.a(8);
        Object obj = null;
        if ((q0VarE0.i() & iA) != 0) {
            loop0: for (androidx.compose.ui.f.c cVarK = q0VarE0.k(); cVarK != null; cVarK = cVarK.f1()) {
                if ((cVarK.j1() & iA) == 0) {
                    if ((cVarK.e1() & iA) != 0) {
                        break;
                        break;
                    }
                } else {
                    androidx.compose.ui.f.c cVarG = cVarK;
                    androidx.compose.runtime.collection.b bVar = null;
                    while (cVarG != null) {
                        if (cVarG instanceof i1) {
                            if (((i1) cVarG).Z0()) {
                                obj = cVarG;
                                break loop0;
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
                    if ((cVarK.e1() & iA) != 0) {
                        break;
                    }
                }
            }
        }
        return (i1) obj;
    }

    public static final i h(SemanticsNode semanticsNode) {
        return (i) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5594a.x());
    }

    public static final int i(SemanticsNode semanticsNode) {
        return semanticsNode.o() + Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
    }
}
