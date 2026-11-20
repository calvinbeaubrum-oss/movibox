package androidx.compose.ui.node;

import androidx.compose.ui.semantics.SemanticsConfigurationKt;
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
public final class j1 {
    public static final boolean a(androidx.compose.ui.semantics.l lVar) {
        return SemanticsConfigurationKt.a(lVar, androidx.compose.ui.semantics.k.f5661a.j()) != null;
    }

    public static final void b(i1 i1Var) {
        g.m(i1Var).B0();
    }

    public static final y1.i c(androidx.compose.ui.f.c cVar, boolean z11) {
        if (cVar.getNode().o1()) {
            return !z11 ? androidx.compose.ui.layout.n.b(g.h(cVar, s0.a(8))) : g.h(cVar, s0.a(8)).K2();
        }
        return y1.i.f81075e.a();
    }
}
