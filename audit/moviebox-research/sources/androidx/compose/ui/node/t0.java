package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusTargetNode;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.collection.i0<Object> f5141a = androidx.collection.o0.b();

    public static final void a(androidx.compose.ui.f.c cVar) {
        if (!cVar.o1()) {
            h2.a.b("autoInvalidateInsertedNode called on unattached node");
        }
        b(cVar, -1, 1);
    }

    public static final void b(androidx.compose.ui.f.c cVar, int i11, int i12) {
        if (!(cVar instanceof i)) {
            c(cVar, i11 & cVar.j1(), i12);
            return;
        }
        i iVar = (i) cVar;
        c(cVar, iVar.J1() & i11, i12);
        int i13 = (~iVar.J1()) & i11;
        for (androidx.compose.ui.f.c cVarI1 = iVar.I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            b(cVarI1, i13, i12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(androidx.compose.ui.f.c cVar, int i11, int i12) {
        if (i12 != 0 || cVar.m1()) {
            if ((s0.a(2) & i11) != 0 && (cVar instanceof x)) {
                a0.b((x) cVar);
                if (i12 == 2) {
                    g.h(cVar, s0.a(2)).s2();
                }
            }
            if ((s0.a(128) & i11) != 0 && (cVar instanceof w) && i12 != 2) {
                g.m(cVar).y0();
            }
            if ((s0.a(256) & i11) != 0 && (cVar instanceof p) && i12 != 2) {
                g.m(cVar).z0();
            }
            if ((s0.a(4) & i11) != 0 && (cVar instanceof n)) {
                o.a((n) cVar);
            }
            if ((s0.a(8) & i11) != 0 && (cVar instanceof i1)) {
                j1.b((i1) cVar);
            }
            if ((s0.a(64) & i11) != 0 && (cVar instanceof a1)) {
                b1.a((a1) cVar);
            }
            if ((s0.a(1024) & i11) != 0 && (cVar instanceof FocusTargetNode) && i12 != 2) {
                androidx.compose.ui.focus.x.c((FocusTargetNode) cVar);
            }
            if ((s0.a(2048) & i11) != 0 && (cVar instanceof androidx.compose.ui.focus.o)) {
                androidx.compose.ui.focus.o oVar = (androidx.compose.ui.focus.o) cVar;
                if (k(oVar)) {
                    if (i12 == 2) {
                        j(oVar);
                    } else {
                        androidx.compose.ui.focus.p.a(oVar);
                    }
                }
            }
            if ((i11 & s0.a(4096)) == 0 || !(cVar instanceof androidx.compose.ui.focus.d)) {
                return;
            }
            androidx.compose.ui.focus.e.b((androidx.compose.ui.focus.d) cVar);
        }
    }

    public static final void d(androidx.compose.ui.f.c cVar) {
        if (!cVar.o1()) {
            h2.a.b("autoInvalidateRemovedNode called on unattached node");
        }
        b(cVar, -1, 2);
    }

    public static final void e(androidx.compose.ui.f.c cVar) {
        if (!cVar.o1()) {
            h2.a.b("autoInvalidateUpdatedNode called on unattached node");
        }
        b(cVar, -1, 0);
    }

    public static final int f(androidx.compose.ui.f.b bVar) {
        int iA = s0.a(1);
        if (bVar instanceof androidx.compose.ui.layout.p) {
            iA |= s0.a(2);
        }
        if (bVar instanceof androidx.compose.ui.draw.g) {
            iA |= s0.a(4);
        }
        if (bVar instanceof androidx.compose.ui.semantics.m) {
            iA |= s0.a(8);
        }
        if (bVar instanceof androidx.compose.ui.input.pointer.g0) {
            iA |= s0.a(16);
        }
        if ((bVar instanceof androidx.compose.ui.modifier.d) || (bVar instanceof androidx.compose.ui.modifier.j)) {
            iA |= s0.a(32);
        }
        if (bVar instanceof androidx.compose.ui.focus.c) {
            iA |= s0.a(4096);
        }
        if (bVar instanceof androidx.compose.ui.focus.j) {
            iA |= s0.a(2048);
        }
        if (bVar instanceof androidx.compose.ui.layout.c0) {
            iA |= s0.a(256);
        }
        if (bVar instanceof androidx.compose.ui.layout.i0) {
            iA |= s0.a(64);
        }
        return ((bVar instanceof androidx.compose.ui.layout.f0) || (bVar instanceof androidx.compose.ui.layout.g0)) ? iA | s0.a(128) : iA;
    }

    public static final int g(androidx.compose.ui.f.c cVar) {
        if (cVar.j1() != 0) {
            return cVar.j1();
        }
        androidx.collection.i0<Object> i0Var = f5141a;
        Object objB = androidx.compose.ui.a.b(cVar);
        int iB = i0Var.b(objB);
        if (iB >= 0) {
            return i0Var.f1958c[iB];
        }
        int iA = s0.a(1);
        if (cVar instanceof x) {
            iA |= s0.a(2);
        }
        if (cVar instanceof n) {
            iA |= s0.a(4);
        }
        if (cVar instanceof i1) {
            iA |= s0.a(8);
        }
        if (cVar instanceof e1) {
            iA |= s0.a(16);
        }
        if (cVar instanceof androidx.compose.ui.modifier.h) {
            iA |= s0.a(32);
        }
        if (cVar instanceof a1) {
            iA |= s0.a(64);
        }
        if (cVar instanceof w) {
            iA |= s0.a(128);
        }
        if (cVar instanceof p) {
            iA |= s0.a(256);
        }
        if (cVar instanceof androidx.compose.ui.layout.b) {
            iA |= s0.a(512);
        }
        if (cVar instanceof FocusTargetNode) {
            iA |= s0.a(1024);
        }
        if (cVar instanceof androidx.compose.ui.focus.o) {
            iA |= s0.a(2048);
        }
        if (cVar instanceof androidx.compose.ui.focus.d) {
            iA |= s0.a(4096);
        }
        if (cVar instanceof e2.e) {
            iA |= s0.a(8192);
        }
        if (cVar instanceof g2.a) {
            iA |= s0.a(16384);
        }
        if (cVar instanceof d) {
            iA |= s0.a(32768);
        }
        if (cVar instanceof e2.h) {
            iA |= s0.a(131072);
        }
        int iA2 = cVar instanceof m1 ? s0.a(262144) | iA : iA;
        i0Var.s(objB, iA2);
        return iA2;
    }

    public static final int h(androidx.compose.ui.f.c cVar) {
        if (!(cVar instanceof i)) {
            return g(cVar);
        }
        i iVar = (i) cVar;
        int iJ1 = iVar.J1();
        for (androidx.compose.ui.f.c cVarI1 = iVar.I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            iJ1 |= h(cVarI1);
        }
        return iJ1;
    }

    public static final boolean i(int i11) {
        return (i11 & s0.a(128)) != 0;
    }

    public static final void j(androidx.compose.ui.focus.o oVar) {
        int iA = s0.a(1024);
        if (!oVar.getNode().o1()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
        androidx.compose.ui.f.c cVarF1 = oVar.getNode().f1();
        if (cVarF1 == null) {
            g.c(bVar, oVar.getNode());
        } else {
            bVar.b(cVarF1);
        }
        while (bVar.u()) {
            androidx.compose.ui.f.c cVarG = (androidx.compose.ui.f.c) bVar.z(bVar.r() - 1);
            if ((cVarG.e1() & iA) == 0) {
                g.c(bVar, cVarG);
            } else {
                while (cVarG != null) {
                    if ((cVarG.j1() & iA) != 0) {
                        androidx.compose.runtime.collection.b bVar2 = null;
                        while (cVarG != null) {
                            if (cVarG instanceof FocusTargetNode) {
                                androidx.compose.ui.focus.x.c((FocusTargetNode) cVarG);
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof i)) {
                                int i11 = 0;
                                for (androidx.compose.ui.f.c cVarI1 = ((i) cVarG).I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
                                }
                            }
                            cVarG = g.g(bVar2);
                        }
                        break;
                    }
                    cVarG = cVarG.f1();
                }
            }
        }
    }

    public static final boolean k(androidx.compose.ui.focus.o oVar) {
        b bVar = b.f5071a;
        bVar.b();
        oVar.A0(bVar);
        return bVar.a();
    }
}
