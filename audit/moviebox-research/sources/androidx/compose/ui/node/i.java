package androidx.compose.ui.node;

import kotlin.Metadata;
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
public abstract class i extends androidx.compose.ui.f.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f5081o = t0.g(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.compose.ui.f.c f5082p;

    @Override // androidx.compose.ui.f.c
    public void G1(NodeCoordinator nodeCoordinator) {
        super.G1(nodeCoordinator);
        for (androidx.compose.ui.f.c cVarI1 = I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            cVarI1.G1(nodeCoordinator);
        }
    }

    public final <T extends f> T H1(T t11) {
        androidx.compose.ui.f.c node = t11.getNode();
        if (node != t11) {
            androidx.compose.ui.f.c cVar = t11 instanceof androidx.compose.ui.f.c ? (androidx.compose.ui.f.c) t11 : null;
            androidx.compose.ui.f.c cVarL1 = cVar != null ? cVar.l1() : null;
            if (node == getNode() && Intrinsics.b(cVarL1, this)) {
                return t11;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        }
        if (!(!node.o1())) {
            h2.a.b("Cannot delegate to an already attached node");
        }
        node.y1(getNode());
        int iJ1 = j1();
        int iH = t0.h(node);
        node.B1(iH);
        M1(iH, node);
        node.z1(this.f5082p);
        this.f5082p = node;
        node.D1(this);
        L1(j1() | iH, false);
        if (o1()) {
            if ((iH & s0.a(2)) == 0 || (iJ1 & s0.a(2)) != 0) {
                G1(g1());
            } else {
                q0 q0VarE0 = g.m(this).e0();
                getNode().G1(null);
                q0VarE0.C();
            }
            node.p1();
            node.v1();
            t0.a(node);
        }
        return t11;
    }

    public final androidx.compose.ui.f.c I1() {
        return this.f5082p;
    }

    public final int J1() {
        return this.f5081o;
    }

    public final void K1(f fVar) {
        androidx.compose.ui.f.c cVar = null;
        for (androidx.compose.ui.f.c cVarF1 = this.f5082p; cVarF1 != null; cVarF1 = cVarF1.f1()) {
            if (cVarF1 == fVar) {
                if (cVarF1.o1()) {
                    t0.d(cVarF1);
                    cVarF1.w1();
                    cVarF1.q1();
                }
                cVarF1.y1(cVarF1);
                cVarF1.x1(0);
                if (cVar == null) {
                    this.f5082p = cVarF1.f1();
                } else {
                    cVar.z1(cVarF1.f1());
                }
                cVarF1.z1(null);
                cVarF1.D1(null);
                int iJ1 = j1();
                int iH = t0.h(this);
                L1(iH, true);
                if (o1() && (iJ1 & s0.a(2)) != 0 && (s0.a(2) & iH) == 0) {
                    q0 q0VarE0 = g.m(this).e0();
                    getNode().G1(null);
                    q0VarE0.C();
                    return;
                }
                return;
            }
            cVar = cVarF1;
        }
        throw new IllegalStateException(("Could not find delegate: " + fVar).toString());
    }

    public final void L1(int i11, boolean z11) {
        androidx.compose.ui.f.c cVarF1;
        int iJ1 = j1();
        B1(i11);
        if (iJ1 != i11) {
            if (g.f(this)) {
                x1(i11);
            }
            if (o1()) {
                androidx.compose.ui.f.c node = getNode();
                androidx.compose.ui.f.c cVarL1 = this;
                while (cVarL1 != null) {
                    i11 |= cVarL1.j1();
                    cVarL1.B1(i11);
                    if (cVarL1 == node) {
                        break;
                    } else {
                        cVarL1 = cVarL1.l1();
                    }
                }
                if (z11 && cVarL1 == node) {
                    i11 = t0.h(node);
                    node.B1(i11);
                }
                int iE1 = i11 | ((cVarL1 == null || (cVarF1 = cVarL1.f1()) == null) ? 0 : cVarF1.e1());
                while (cVarL1 != null) {
                    iE1 |= cVarL1.j1();
                    cVarL1.x1(iE1);
                    cVarL1 = cVarL1.l1();
                }
            }
        }
    }

    public final void M1(int i11, androidx.compose.ui.f.c cVar) {
        int iJ1 = j1();
        if ((i11 & s0.a(2)) == 0 || (s0.a(2) & iJ1) == 0 || (this instanceof x)) {
            return;
        }
        h2.a.b("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + cVar);
    }

    @Override // androidx.compose.ui.f.c
    public void p1() {
        super.p1();
        for (androidx.compose.ui.f.c cVarI1 = I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            cVarI1.G1(g1());
            if (!cVarI1.o1()) {
                cVarI1.p1();
            }
        }
    }

    @Override // androidx.compose.ui.f.c
    public void q1() {
        for (androidx.compose.ui.f.c cVarI1 = I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            cVarI1.q1();
        }
        super.q1();
    }

    @Override // androidx.compose.ui.f.c
    public void u1() {
        super.u1();
        for (androidx.compose.ui.f.c cVarI1 = I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            cVarI1.u1();
        }
    }

    @Override // androidx.compose.ui.f.c
    public void v1() {
        for (androidx.compose.ui.f.c cVarI1 = I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            cVarI1.v1();
        }
        super.v1();
    }

    @Override // androidx.compose.ui.f.c
    public void w1() {
        super.w1();
        for (androidx.compose.ui.f.c cVarI1 = I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            cVarI1.w1();
        }
    }

    @Override // androidx.compose.ui.f.c
    public void y1(androidx.compose.ui.f.c cVar) {
        super.y1(cVar);
        for (androidx.compose.ui.f.c cVarI1 = I1(); cVarI1 != null; cVarI1 = cVarI1.f1()) {
            cVarI1.y1(cVar);
        }
    }
}
