package androidx.compose.ui.modifier;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    public static Object a(h hVar, c cVar) {
        q0 q0VarE0;
        if (!hVar.getNode().o1()) {
            h2.a.a("ModifierLocal accessed from an unattached node");
        }
        int iA = s0.a(32);
        if (!hVar.getNode().o1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        androidx.compose.ui.f.c cVarL1 = hVar.getNode().l1();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(hVar);
        while (layoutNodeM != null) {
            if ((layoutNodeM.e0().k().e1() & iA) != 0) {
                while (cVarL1 != null) {
                    if ((cVarL1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarL1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != 0) {
                            if (cVarG instanceof h) {
                                h hVar2 = (h) cVarG;
                                if (hVar2.b0().a(cVar)) {
                                    return hVar2.b0().b(cVar);
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1();
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
                            cVarG = androidx.compose.ui.node.g.g(bVar);
                        }
                    }
                    cVarL1 = cVarL1.l1();
                }
            }
            layoutNodeM = layoutNodeM.h0();
            cVarL1 = (layoutNodeM == null || (q0VarE0 = layoutNodeM.e0()) == null) ? null : q0VarE0.o();
        }
        return cVar.a().invoke();
    }

    public static f b(h hVar) {
        return b.f4899a;
    }
}
