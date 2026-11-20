package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.x1;
import kotlin.Metadata;

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
public final class k {
    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, Painter painter, boolean z11, androidx.compose.ui.b bVar, androidx.compose.ui.layout.f fVar2, float f11, x1 x1Var) {
        return fVar.f(new PainterElement(painter, z11, bVar, fVar2, f11, x1Var));
    }

    public static /* synthetic */ androidx.compose.ui.f b(androidx.compose.ui.f fVar, Painter painter, boolean z11, androidx.compose.ui.b bVar, androidx.compose.ui.layout.f fVar2, float f11, x1 x1Var, int i11, Object obj) {
        boolean z12 = (i11 & 2) != 0 ? true : z11;
        if ((i11 & 4) != 0) {
            bVar = androidx.compose.ui.b.f3770a.d();
        }
        androidx.compose.ui.b bVar2 = bVar;
        if ((i11 & 8) != 0) {
            fVar2 = androidx.compose.ui.layout.f.f4870a.b();
        }
        androidx.compose.ui.layout.f fVar3 = fVar2;
        float f12 = (i11 & 16) != 0 ? 1.0f : f11;
        if ((i11 & 32) != 0) {
            x1Var = null;
        }
        return a(fVar, painter, z12, bVar2, fVar3, f12, x1Var);
    }
}
