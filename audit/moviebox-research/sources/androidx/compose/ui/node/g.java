package androidx.compose.ui.node;

import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
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
public final class g {
    public static final void c(androidx.compose.runtime.collection.b<androidx.compose.ui.f.c> bVar, androidx.compose.ui.f.c cVar) {
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = m(cVar).p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            int i11 = iR - 1;
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            do {
                bVar.b(layoutNodeArrQ[i11].e0().k());
                i11--;
            } while (i11 >= 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final x d(androidx.compose.ui.f.c cVar) {
        if ((s0.a(2) & cVar.j1()) != 0) {
            if (cVar instanceof x) {
                return (x) cVar;
            }
            if (cVar instanceof i) {
                androidx.compose.ui.f.c cVarI1 = ((i) cVar).I1();
                while (cVarI1 != 0) {
                    if (cVarI1 instanceof x) {
                        return (x) cVarI1;
                    }
                    cVarI1 = (!(cVarI1 instanceof i) || (s0.a(2) & cVarI1.j1()) == 0) ? cVarI1.f1() : ((i) cVarI1).I1();
                }
            }
        }
        return null;
    }

    public static final boolean e(f fVar, int i11) {
        return (fVar.getNode().e1() & i11) != 0;
    }

    public static final boolean f(f fVar) {
        return fVar.getNode() == fVar;
    }

    public static final androidx.compose.ui.f.c g(androidx.compose.runtime.collection.b<androidx.compose.ui.f.c> bVar) {
        if (bVar == null || bVar.t()) {
            return null;
        }
        return bVar.z(bVar.r() - 1);
    }

    public static final NodeCoordinator h(f fVar, int i11) {
        NodeCoordinator nodeCoordinatorG1 = fVar.getNode().g1();
        Intrinsics.d(nodeCoordinatorG1);
        if (nodeCoordinatorG1.X1() != fVar || !t0.i(i11)) {
            return nodeCoordinatorG1;
        }
        NodeCoordinator nodeCoordinatorY1 = nodeCoordinatorG1.Y1();
        Intrinsics.d(nodeCoordinatorY1);
        return nodeCoordinatorY1;
    }

    public static final q2.e i(f fVar) {
        return m(fVar).H();
    }

    public static final c4 j(f fVar) {
        return n(fVar).getGraphicsContext();
    }

    public static final androidx.compose.ui.layout.m k(f fVar) {
        if (!fVar.getNode().o1()) {
            h2.a.b("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        androidx.compose.ui.layout.m mVarU0 = h(fVar, s0.a(2)).U0();
        if (!mVarU0.D()) {
            h2.a.b("LayoutCoordinates is not attached.");
        }
        return mVarU0;
    }

    public static final LayoutDirection l(f fVar) {
        return m(fVar).getLayoutDirection();
    }

    public static final LayoutNode m(f fVar) {
        NodeCoordinator nodeCoordinatorG1 = fVar.getNode().g1();
        if (nodeCoordinatorG1 != null) {
            return nodeCoordinatorG1.X0();
        }
        h2.a.c("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    }

    public static final y0 n(f fVar) {
        y0 y0VarG0 = m(fVar).g0();
        if (y0VarG0 != null) {
            return y0VarG0;
        }
        h2.a.c("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }
}
