package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.layout.m;
import androidx.compose.ui.layout.n;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.r;
import q2.s;

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
public final class k {
    public static final boolean a(SemanticsNode semanticsNode) {
        Function2<y1.g, Continuation<? super y1.g>, Object> function2C = c(semanticsNode);
        androidx.compose.ui.semantics.j jVar = (androidx.compose.ui.semantics.j) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5594a.H());
        return (function2C == null || jVar == null || jVar.a().invoke().floatValue() <= 0.0f) ? false : true;
    }

    public static final List<SemanticsNode> b(SemanticsNode semanticsNode) {
        return semanticsNode.l(false, false, false);
    }

    public static final Function2<y1.g, Continuation<? super y1.g>, Object> c(SemanticsNode semanticsNode) {
        return (Function2) SemanticsConfigurationKt.a(semanticsNode.w(), androidx.compose.ui.semantics.k.f5661a.t());
    }

    public static final boolean d(SemanticsNode semanticsNode) {
        return (semanticsNode.z() || semanticsNode.w().f(SemanticsProperties.f5594a.n())) ? false : true;
    }

    public static final void e(SemanticsNode semanticsNode, int i11, Function1<? super j, Unit> function1) {
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new SemanticsNode[16], 0);
        List<SemanticsNode> listB = b(semanticsNode);
        while (true) {
            bVar.f(bVar.r(), listB);
            while (bVar.u()) {
                SemanticsNode semanticsNode2 = (SemanticsNode) bVar.z(bVar.r() - 1);
                if (d(semanticsNode2) && !semanticsNode2.w().f(SemanticsProperties.f5594a.f())) {
                    NodeCoordinator nodeCoordinatorE = semanticsNode2.e();
                    if (nodeCoordinatorE == null) {
                        h2.a.c("Expected semantics node to have a coordinator.");
                        throw new KotlinNothingValueException();
                    }
                    m mVarU0 = nodeCoordinatorE.U0();
                    r rVarB = s.b(n.c(mVarU0));
                    if (rVarB.k()) {
                        continue;
                    } else if (a(semanticsNode2)) {
                        int i12 = i11 + 1;
                        function1.invoke(new j(semanticsNode2, i12, rVarB, mVarU0));
                        e(semanticsNode2, i12, function1);
                    } else {
                        listB = b(semanticsNode2);
                    }
                }
            }
            return;
        }
    }

    public static /* synthetic */ void f(SemanticsNode semanticsNode, int i11, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        e(semanticsNode, i11, function1);
    }
}
