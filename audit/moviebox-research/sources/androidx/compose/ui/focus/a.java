package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
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
public final class a {
    public static final <T> T a(FocusTargetNode focusTargetNode, int i11, Function1<? super androidx.compose.ui.layout.e.a, ? extends T> function1) {
        androidx.compose.ui.f.c cVarG;
        androidx.compose.ui.layout.e eVarN1;
        int iC;
        q0 q0VarE0;
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarG;
        if ((focusTargetNode2 != null && Intrinsics.b(focusTargetNode2.N1(), focusTargetNode.N1())) || (eVarN1 = focusTargetNode.N1()) == null) {
            return null;
        }
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.h())) {
            iC = androidx.compose.ui.layout.e.b.f4862a.a();
        } else if (b.l(i11, aVar.a())) {
            iC = androidx.compose.ui.layout.e.b.f4862a.d();
        } else if (b.l(i11, aVar.d())) {
            iC = androidx.compose.ui.layout.e.b.f4862a.e();
        } else if (b.l(i11, aVar.g())) {
            iC = androidx.compose.ui.layout.e.b.f4862a.f();
        } else if (b.l(i11, aVar.e())) {
            iC = androidx.compose.ui.layout.e.b.f4862a.b();
        } else {
            if (!b.l(i11, aVar.f())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            iC = androidx.compose.ui.layout.e.b.f4862a.c();
        }
        return (T) eVarN1.a(iC, function1);
    }
}
