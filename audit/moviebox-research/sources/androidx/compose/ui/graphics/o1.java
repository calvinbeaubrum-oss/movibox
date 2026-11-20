package androidx.compose.ui.graphics;

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
public interface o1 {
    void a(float f11, float f12, float f13, float f14, int i11);

    void b(Path path, int i11);

    void c(float f11, float f12);

    void d();

    void e(float f11, float f12);

    void f(float f11, float f12, float f13, float f14, o4 o4Var);

    void g(int i11, List<y1.g> list, o4 o4Var);

    void h(g4 g4Var, long j11, long j12, long j13, long j14, o4 o4Var);

    void i(y1.i iVar, int i11);

    void j(y1.i iVar, o4 o4Var);

    void k();

    void l();

    void m(long j11, long j12, o4 o4Var);

    void n();

    void o(float[] fArr);

    void p(Path path, o4 o4Var);

    void q(long j11, float f11, o4 o4Var);

    void r(y1.i iVar, o4 o4Var);

    void s(float f11, float f12, float f13, float f14, float f15, float f16, o4 o4Var);
}
