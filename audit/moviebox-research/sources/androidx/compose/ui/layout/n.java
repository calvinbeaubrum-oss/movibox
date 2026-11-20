package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeCoordinator;
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
public final class n {
    public static final y1.i a(m mVar) {
        y1.i iVarA;
        m mVarR = mVar.R();
        return (mVarR == null || (iVarA = l.a(mVarR, mVar, false, 2, null)) == null) ? new y1.i(0.0f, 0.0f, q2.t.g(mVar.p()), q2.t.f(mVar.p())) : iVarA;
    }

    public static final y1.i b(m mVar) {
        return l.a(d(mVar), mVar, false, 2, null);
    }

    public static final y1.i c(m mVar) {
        m mVarD = d(mVar);
        float fG = q2.t.g(mVarD.p());
        float f11 = q2.t.f(mVarD.p());
        y1.i iVarB = b(mVar);
        float f12 = iVarB.f();
        if (f12 < 0.0f) {
            f12 = 0.0f;
        }
        if (f12 > fG) {
            f12 = fG;
        }
        float fI = iVarB.i();
        if (fI < 0.0f) {
            fI = 0.0f;
        }
        if (fI > f11) {
            fI = f11;
        }
        float fG2 = iVarB.g();
        if (fG2 < 0.0f) {
            fG2 = 0.0f;
        }
        if (fG2 <= fG) {
            fG = fG2;
        }
        float fC = iVarB.c();
        float f13 = fC >= 0.0f ? fC : 0.0f;
        if (f13 <= f11) {
            f11 = f13;
        }
        if (f12 == fG || fI == f11) {
            return y1.i.f81075e.a();
        }
        long jH = mVarD.H(y1.h.a(f12, fI));
        long jH2 = mVarD.H(y1.h.a(fG, fI));
        long jH3 = mVarD.H(y1.h.a(fG, f11));
        long jH4 = mVarD.H(y1.h.a(f12, f11));
        float fM = y1.g.m(jH);
        float fM2 = y1.g.m(jH2);
        float fM3 = y1.g.m(jH4);
        float fM4 = y1.g.m(jH3);
        float fMin = Math.min(fM, Math.min(fM2, Math.min(fM3, fM4)));
        float fMax = Math.max(fM, Math.max(fM2, Math.max(fM3, fM4)));
        float fN = y1.g.n(jH);
        float fN2 = y1.g.n(jH2);
        float fN3 = y1.g.n(jH4);
        float fN4 = y1.g.n(jH3);
        return new y1.i(fMin, Math.min(fN, Math.min(fN2, Math.min(fN3, fN4))), fMax, Math.max(fN, Math.max(fN2, Math.max(fN3, fN4))));
    }

    public static final m d(m mVar) {
        m mVar2;
        m mVarR = mVar.R();
        while (true) {
            m mVar3 = mVarR;
            mVar2 = mVar;
            mVar = mVar3;
            if (mVar == null) {
                break;
            }
            mVarR = mVar.R();
        }
        NodeCoordinator nodeCoordinator = mVar2 instanceof NodeCoordinator ? (NodeCoordinator) mVar2 : null;
        if (nodeCoordinator == null) {
            return mVar2;
        }
        NodeCoordinator nodeCoordinatorZ1 = nodeCoordinator.Z1();
        while (true) {
            NodeCoordinator nodeCoordinator2 = nodeCoordinatorZ1;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            nodeCoordinatorZ1 = nodeCoordinator.Z1();
        }
    }

    public static final long e(m mVar) {
        return mVar.V(y1.g.f81070b.c());
    }

    public static final long f(m mVar) {
        return mVar.H(y1.g.f81070b.c());
    }
}
