package androidx.compose.ui.text;

import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
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
public interface l {
    float a();

    void b(o1 o1Var, long j11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11);

    ResolvedTextDirection c(int i11);

    float d(int i11);

    y1.i e(int i11);

    float f();

    int g(int i11);

    float getHeight();

    float getWidth();

    int h(int i11, boolean z11);

    int i();

    float j(int i11);

    boolean k();

    int l(float f11);

    float m(int i11);

    void n(long j11, float[] fArr, int i11);

    float o();

    int p(int i11);

    ResolvedTextDirection q(int i11);

    float r(int i11);

    y1.i s(int i11);

    List<y1.i> t();

    void u(o1 o1Var, l1 l1Var, float f11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11);
}
