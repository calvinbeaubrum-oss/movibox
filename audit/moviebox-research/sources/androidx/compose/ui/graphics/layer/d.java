package androidx.compose.ui.graphics.layer;

import androidx.compose.ui.graphics.m4;
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
public final class d {
    public static final void a(z1.g gVar, GraphicsLayer graphicsLayer) {
        graphicsLayer.h(gVar.Q0().e(), gVar.Q0().g());
    }

    public static final void b(GraphicsLayer graphicsLayer, m4 m4Var) {
        if (m4Var instanceof m4.b) {
            m4.b bVar = (m4.b) m4Var;
            graphicsLayer.R(y1.h.a(bVar.b().f(), bVar.b().i()), y1.n.a(bVar.b().k(), bVar.b().e()));
            return;
        }
        if (m4Var instanceof m4.a) {
            graphicsLayer.O(((m4.a) m4Var).b());
            return;
        }
        if (m4Var instanceof m4.c) {
            m4.c cVar = (m4.c) m4Var;
            if (cVar.c() != null) {
                graphicsLayer.O(cVar.c());
            } else {
                y1.k kVarB = cVar.b();
                graphicsLayer.W(y1.h.a(kVarB.e(), kVarB.g()), y1.n.a(kVarB.j(), kVarB.d()), y1.a.d(kVarB.b()));
            }
        }
    }
}
