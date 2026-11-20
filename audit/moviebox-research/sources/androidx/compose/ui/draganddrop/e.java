package androidx.compose.ui.draganddrop;

import androidx.compose.ui.layout.m;
import androidx.compose.ui.layout.n;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.t;

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
public final class e {
    public static final boolean d(d dVar, long j11) {
        if (!dVar.getNode().o1()) {
            return false;
        }
        m mVarL = androidx.compose.ui.node.g.m(dVar).l();
        if (!mVarL.D()) {
            return false;
        }
        long jP = mVarL.p();
        int iG = t.g(jP);
        int iF = t.f(jP);
        long jE = n.e(mVarL);
        float fM = y1.g.m(jE);
        float fN = y1.g.n(jE);
        float f11 = iG + fM;
        float f12 = iF + fN;
        float fM2 = y1.g.m(j11);
        if (fM > fM2 || fM2 > f11) {
            return false;
        }
        float fN2 = y1.g.n(j11);
        return fN <= fN2 && fN2 <= f12;
    }

    public static final void e(f fVar, b bVar) {
        fVar.h0(bVar);
        fVar.H(bVar);
    }

    public static final <T extends m1> void f(T t11, Function1<? super T, ? extends TraversableNode$Companion$TraverseDescendantsAction> function1) {
        if (function1.invoke(t11) != TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal) {
            return;
        }
        n1.f(t11, function1);
    }
}
