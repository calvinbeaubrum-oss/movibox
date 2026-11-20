package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.text.MultiParagraph;
import java.util.List;
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
public final class b {
    public static final void a(MultiParagraph multiParagraph, o1 o1Var, l1 l1Var, float f11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11) {
        o1Var.d();
        if (multiParagraph.u().size() <= 1 || (l1Var instanceof d5)) {
            b(multiParagraph, o1Var, l1Var, f11, b5Var, iVar, hVar, i11);
        } else if (l1Var instanceof a5) {
            List<androidx.compose.ui.text.m> listU = multiParagraph.u();
            int size = listU.size();
            float fMax = 0.0f;
            float height = 0.0f;
            for (int i12 = 0; i12 < size; i12++) {
                androidx.compose.ui.text.m mVar = listU.get(i12);
                height += mVar.e().getHeight();
                fMax = Math.max(fMax, mVar.e().getWidth());
            }
            Shader shaderB = ((a5) l1Var).b(y1.n.a(fMax, height));
            Matrix matrix = new Matrix();
            shaderB.getLocalMatrix(matrix);
            List<androidx.compose.ui.text.m> listU2 = multiParagraph.u();
            int size2 = listU2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                androidx.compose.ui.text.m mVar2 = listU2.get(i13);
                mVar2.e().u(o1Var, m1.a(shaderB), f11, b5Var, iVar, hVar, i11);
                o1Var.c(0.0f, mVar2.e().getHeight());
                matrix.setTranslate(0.0f, -mVar2.e().getHeight());
                shaderB.setLocalMatrix(matrix);
            }
        }
        o1Var.k();
    }

    public static final void b(MultiParagraph multiParagraph, o1 o1Var, l1 l1Var, float f11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11) {
        List<androidx.compose.ui.text.m> listU = multiParagraph.u();
        int size = listU.size();
        for (int i12 = 0; i12 < size; i12++) {
            androidx.compose.ui.text.m mVar = listU.get(i12);
            mVar.e().u(o1Var, l1Var, f11, b5Var, iVar, hVar, i11);
            o1Var.c(0.0f, mVar.e().getHeight());
        }
    }
}
