package androidx.compose.ui.focus;

import androidx.compose.ui.node.s0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class FocusRequesterModifierNodeKt {
    public static final boolean a(t tVar) {
        int iA = s0.a(1024);
        androidx.compose.ui.f.c node = tVar.getNode();
        androidx.compose.runtime.collection.b bVar = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                return focusTargetNode.M1().t() ? FocusTransactionsKt.j(focusTargetNode) : TwoDimensionalFocusSearchKt.k(focusTargetNode, b.f3922b.b(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode2) {
                        return Boolean.valueOf(FocusTransactionsKt.j(focusTargetNode2));
                    }
                });
            }
            if ((node.j1() & iA) != 0 && (node instanceof androidx.compose.ui.node.i)) {
                int i11 = 0;
                for (androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) node).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                    if ((cVarI1.j1() & iA) != 0) {
                        i11++;
                        if (i11 == 1) {
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
                if (i11 == 1) {
                }
            }
            node = androidx.compose.ui.node.g.g(bVar);
        }
        if (!tVar.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = tVar.getNode().f1();
        if (cVarF1 == null) {
            androidx.compose.ui.node.g.c(bVar2, tVar.getNode());
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
                                return focusTargetNode2.M1().t() ? FocusTransactionsKt.j(focusTargetNode2) : TwoDimensionalFocusSearchKt.k(focusTargetNode2, b.f3922b.b(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(FocusTargetNode focusTargetNode3) {
                                        return Boolean.valueOf(FocusTransactionsKt.j(focusTargetNode3));
                                    }
                                });
                            }
                            if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                int i12 = 0;
                                for (androidx.compose.ui.f.c cVarI2 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI2 != null; cVarI2 = cVarI2.f1()) {
                                    if ((cVarI2.j1() & iA) != 0) {
                                        i12++;
                                        if (i12 == 1) {
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
        return false;
    }
}
