package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.u0;
import androidx.compose.ui.node.s0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class FocusInvalidationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Function0<Unit>, Unit> f3878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f3879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableScatterSet<FocusTargetNode> f3880c = u0.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableScatterSet<d> f3881d = u0.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableScatterSet<o> f3882e = u0.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableScatterSet<FocusTargetNode> f3883f = u0.a();

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0) {
        this.f3878a = function1;
        this.f3879b = function0;
    }

    public final boolean b() {
        return this.f3880c.e() || this.f3882e.e() || this.f3881d.e();
    }

    /* JADX WARN: Code duplicated, block: B:86:0x017e  */
    public final void c() {
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        u uVarO1;
        int i11;
        int i12;
        long[] jArr3;
        Object[] objArr3;
        boolean z11;
        Object[] objArr4;
        long[] jArr4;
        long[] jArr5;
        long[] jArr6;
        MutableScatterSet<o> mutableScatterSet = this.f3882e;
        Object[] objArr5 = mutableScatterSet.f1898b;
        long[] jArr7 = mutableScatterSet.f1897a;
        int length = jArr7.length - 2;
        char c11 = 7;
        long j11 = -9187201950435737472L;
        int i13 = 1;
        if (length >= 0) {
            int i14 = 0;
            while (true) {
                long j12 = jArr7[i14];
                if ((((~j12) << c11) & j12 & j11) != j11) {
                    int i15 = 8 - ((~(i14 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((j12 & 255) < 128) {
                            o oVar = (o) objArr5[(i14 << 3) + i16];
                            if (oVar.getNode().o1()) {
                                int iA = s0.a(1024);
                                androidx.compose.ui.f.c node = oVar.getNode();
                                androidx.compose.runtime.collection.b bVar = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        this.f3880c.h((FocusTargetNode) node);
                                    } else {
                                        if ((node.j1() & iA) != 0 && (node instanceof androidx.compose.ui.node.i)) {
                                            androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) node).I1();
                                            int i17 = 0;
                                            while (cVarI1 != null) {
                                                if ((cVarI1.j1() & iA) != 0) {
                                                    i17++;
                                                    if (i17 == i13) {
                                                        jArr7 = jArr7;
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
                                                } else {
                                                    jArr7 = jArr7;
                                                }
                                                cVarI1 = cVarI1.f1();
                                                jArr7 = jArr7;
                                                i13 = 1;
                                            }
                                            jArr6 = jArr7;
                                            if (i17 == 1) {
                                            }
                                            jArr7 = jArr6;
                                            i13 = 1;
                                        }
                                        node = androidx.compose.ui.node.g.g(bVar);
                                        jArr7 = jArr6;
                                        i13 = 1;
                                    }
                                    jArr6 = jArr7;
                                    node = androidx.compose.ui.node.g.g(bVar);
                                    jArr7 = jArr6;
                                    i13 = 1;
                                }
                                jArr5 = jArr7;
                                if (!oVar.getNode().o1()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                androidx.compose.ui.f.c cVarF1 = oVar.getNode().f1();
                                if (cVarF1 == null) {
                                    androidx.compose.ui.node.g.c(bVar2, oVar.getNode());
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
                                                        this.f3880c.h((FocusTargetNode) cVarG);
                                                    } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                                        int i18 = 0;
                                                        for (androidx.compose.ui.f.c cVarI2 = ((androidx.compose.ui.node.i) cVarG).I1(); cVarI2 != null; cVarI2 = cVarI2.f1()) {
                                                            if ((cVarI2.j1() & iA) != 0) {
                                                                i18++;
                                                                if (i18 == 1) {
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
                                                        if (i18 == 1) {
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
                            } else {
                                jArr5 = jArr7;
                            }
                        } else {
                            jArr5 = jArr7;
                        }
                        j12 >>= 8;
                        i16++;
                        jArr7 = jArr5;
                        i13 = 1;
                    }
                    jArr4 = jArr7;
                    if (i15 != 8) {
                        break;
                    }
                } else {
                    jArr4 = jArr7;
                }
                if (i14 == length) {
                    break;
                }
                i14++;
                jArr7 = jArr4;
                c11 = 7;
                j11 = -9187201950435737472L;
                i13 = 1;
            }
        }
        this.f3882e.m();
        MutableScatterSet<d> mutableScatterSet2 = this.f3881d;
        Object[] objArr6 = mutableScatterSet2.f1898b;
        long[] jArr8 = mutableScatterSet2.f1897a;
        int length2 = jArr8.length - 2;
        if (length2 >= 0) {
            int i19 = 0;
            while (true) {
                long j13 = jArr8[i19];
                if ((((~j13) << 7) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i21 = 8 - ((~(i19 - length2)) >>> 31);
                    int i22 = 0;
                    while (i22 < i21) {
                        if ((j13 & 255) < 128) {
                            d dVar = (d) objArr6[(i19 << 3) + i22];
                            if (dVar.getNode().o1()) {
                                int iA2 = s0.a(1024);
                                androidx.compose.ui.f.c node2 = dVar.getNode();
                                boolean z12 = false;
                                boolean z13 = true;
                                FocusTargetNode focusTargetNode = null;
                                androidx.compose.runtime.collection.b bVar4 = null;
                                while (node2 != null) {
                                    if (node2 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                        if (focusTargetNode != null) {
                                            z12 = true;
                                        }
                                        if (this.f3880c.a(focusTargetNode2)) {
                                            this.f3883f.h(focusTargetNode2);
                                            z13 = false;
                                        }
                                        jArr3 = jArr8;
                                        objArr3 = objArr6;
                                        focusTargetNode = focusTargetNode2;
                                    } else {
                                        if ((node2.j1() & iA2) == 0 || !(node2 instanceof androidx.compose.ui.node.i)) {
                                            jArr3 = jArr8;
                                            objArr3 = objArr6;
                                            z11 = z12;
                                        } else {
                                            androidx.compose.ui.f.c cVarI3 = ((androidx.compose.ui.node.i) node2).I1();
                                            jArr3 = jArr8;
                                            int i23 = 0;
                                            while (cVarI3 != null) {
                                                if ((cVarI3.j1() & iA2) != 0) {
                                                    i23++;
                                                    objArr4 = objArr6;
                                                    if (i23 == 1) {
                                                        node2 = cVarI3;
                                                    } else {
                                                        androidx.compose.runtime.collection.b bVar5 = bVar4 == null ? new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0) : bVar4;
                                                        if (node2 != null) {
                                                            bVar5.b(node2);
                                                            node2 = null;
                                                        }
                                                        bVar5.b(cVarI3);
                                                        bVar4 = bVar5;
                                                        i23 = i23;
                                                    }
                                                    cVarI3 = cVarI3.f1();
                                                    objArr6 = objArr4;
                                                    z12 = z12;
                                                } else {
                                                    objArr4 = objArr6;
                                                }
                                                z12 = z12;
                                                cVarI3 = cVarI3.f1();
                                                objArr6 = objArr4;
                                                z12 = z12;
                                            }
                                            objArr3 = objArr6;
                                            z11 = z12;
                                            if (i23 == 1) {
                                                jArr8 = jArr3;
                                                objArr6 = objArr3;
                                                z12 = z11;
                                            }
                                        }
                                        z12 = z11;
                                    }
                                    node2 = androidx.compose.ui.node.g.g(bVar4);
                                    jArr8 = jArr3;
                                    objArr6 = objArr3;
                                }
                                jArr2 = jArr8;
                                objArr2 = objArr6;
                                boolean z14 = z12;
                                if (!dVar.getNode().o1()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                androidx.compose.runtime.collection.b bVar6 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                androidx.compose.ui.f.c cVarF2 = dVar.getNode().f1();
                                if (cVarF2 == null) {
                                    androidx.compose.ui.node.g.c(bVar6, dVar.getNode());
                                } else {
                                    bVar6.b(cVarF2);
                                }
                                boolean z15 = z14;
                                while (bVar6.u()) {
                                    androidx.compose.ui.f.c cVarG2 = (androidx.compose.ui.f.c) bVar6.z(bVar6.r() - 1);
                                    if ((cVarG2.e1() & iA2) == 0) {
                                        androidx.compose.ui.node.g.c(bVar6, cVarG2);
                                    } else {
                                        while (true) {
                                            if (cVarG2 != null) {
                                                if ((cVarG2.j1() & iA2) != 0) {
                                                    androidx.compose.runtime.collection.b bVar7 = null;
                                                    while (cVarG2 != null) {
                                                        if (cVarG2 instanceof FocusTargetNode) {
                                                            FocusTargetNode focusTargetNode3 = (FocusTargetNode) cVarG2;
                                                            if (focusTargetNode != null) {
                                                                z15 = true;
                                                            }
                                                            if (this.f3880c.a(focusTargetNode3)) {
                                                                this.f3883f.h(focusTargetNode3);
                                                                z13 = false;
                                                            }
                                                            focusTargetNode = focusTargetNode3;
                                                        } else {
                                                            if ((cVarG2.j1() & iA2) != 0 && (cVarG2 instanceof androidx.compose.ui.node.i)) {
                                                                androidx.compose.ui.f.c cVarI4 = ((androidx.compose.ui.node.i) cVarG2).I1();
                                                                bVar6 = bVar6;
                                                                int i24 = 0;
                                                                while (cVarI4 != null) {
                                                                    if ((cVarI4.j1() & iA2) != 0) {
                                                                        i24++;
                                                                        i12 = iA2;
                                                                        if (i24 == 1) {
                                                                            cVarG2 = cVarI4;
                                                                        } else {
                                                                            if (bVar7 == null) {
                                                                                bVar7 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                                                            }
                                                                            if (cVarG2 != null) {
                                                                                bVar7.b(cVarG2);
                                                                                cVarG2 = null;
                                                                            }
                                                                            bVar7.b(cVarI4);
                                                                            i24 = i24;
                                                                        }
                                                                        cVarI4 = cVarI4.f1();
                                                                        iA2 = i12;
                                                                    } else {
                                                                        i12 = iA2;
                                                                    }
                                                                    cVarI4 = cVarI4.f1();
                                                                    iA2 = i12;
                                                                }
                                                                i11 = iA2;
                                                                if (i24 != 1) {
                                                                    cVarG2 = androidx.compose.ui.node.g.g(bVar7);
                                                                }
                                                            }
                                                            bVar6 = bVar6;
                                                            iA2 = i11;
                                                        }
                                                        i11 = iA2;
                                                        cVarG2 = androidx.compose.ui.node.g.g(bVar7);
                                                        bVar6 = bVar6;
                                                        iA2 = i11;
                                                    }
                                                } else {
                                                    cVarG2 = cVarG2.f1();
                                                    iA2 = iA2;
                                                }
                                            }
                                        }
                                    }
                                    bVar6 = bVar6;
                                    iA2 = iA2;
                                }
                                if (z13) {
                                    if (z15) {
                                        uVarO1 = e.a(dVar);
                                    } else if (focusTargetNode == null || (uVarO1 = focusTargetNode.O1()) == null) {
                                        uVarO1 = FocusStateImpl.Inactive;
                                    }
                                    dVar.D(uVarO1);
                                }
                            } else {
                                dVar.D(FocusStateImpl.Inactive);
                                jArr2 = jArr8;
                                objArr2 = objArr6;
                            }
                        } else {
                            jArr2 = jArr8;
                            objArr2 = objArr6;
                        }
                        j13 >>= 8;
                        i22++;
                        jArr8 = jArr2;
                        objArr6 = objArr2;
                    }
                    jArr = jArr8;
                    objArr = objArr6;
                    if (i21 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr8;
                    objArr = objArr6;
                }
                if (i19 == length2) {
                    break;
                }
                i19++;
                jArr8 = jArr;
                objArr6 = objArr;
            }
        }
        this.f3881d.m();
        MutableScatterSet<FocusTargetNode> mutableScatterSet3 = this.f3880c;
        Object[] objArr7 = mutableScatterSet3.f1898b;
        long[] jArr9 = mutableScatterSet3.f1897a;
        int length3 = jArr9.length - 2;
        if (length3 >= 0) {
            int i25 = 0;
            while (true) {
                long j14 = jArr9[i25];
                if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i26 = 8 - ((~(i25 - length3)) >>> 31);
                    for (int i27 = 0; i27 < i26; i27++) {
                        if ((j14 & 255) < 128) {
                            FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr7[(i25 << 3) + i27];
                            if (focusTargetNode4.o1()) {
                                FocusStateImpl focusStateImplO1 = focusTargetNode4.O1();
                                focusTargetNode4.T1();
                                if (focusStateImplO1 != focusTargetNode4.O1() || this.f3883f.a(focusTargetNode4)) {
                                    e.c(focusTargetNode4);
                                }
                            }
                        }
                        j14 >>= 8;
                    }
                    if (i26 != 8) {
                        break;
                    }
                }
                if (i25 == length3) {
                    break;
                } else {
                    i25++;
                }
            }
        }
        this.f3880c.m();
        this.f3883f.m();
        this.f3879b.invoke();
        if (!this.f3882e.d()) {
            h2.a.b("Unprocessed FocusProperties nodes");
        }
        if (!this.f3881d.d()) {
            h2.a.b("Unprocessed FocusEvent nodes");
        }
        if (this.f3880c.d()) {
            return;
        }
        h2.a.b("Unprocessed FocusTarget nodes");
    }

    public final <T> void d(MutableScatterSet<T> mutableScatterSet, T t11) {
        if (mutableScatterSet.h(t11) && this.f3880c.c() + this.f3881d.c() + this.f3882e.c() == 1) {
            this.f3878a.invoke(new FocusInvalidationManager$scheduleInvalidation$1(this));
        }
    }

    public final void e(d dVar) {
        d(this.f3881d, dVar);
    }

    public final void f(o oVar) {
        d(this.f3882e, oVar);
    }

    public final void g(FocusTargetNode focusTargetNode) {
        d(this.f3880c, focusTargetNode);
    }
}
