package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.y4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public interface y0 {
    void A(float f11);

    void B(float f11);

    void C(Outline outline);

    void D(int i11);

    void E(boolean z11);

    void F(androidx.compose.ui.graphics.p1 p1Var, Path path, Function1<? super androidx.compose.ui.graphics.o1, Unit> function1);

    void G(int i11);

    float H();

    void a(float f11);

    void b(float f11);

    void c(y4 y4Var);

    void d(float f11);

    void e(float f11);

    void f(float f11);

    void g(float f11);

    float getAlpha();

    int getHeight();

    int getWidth();

    void h(float f11);

    int i();

    void j(float f11);

    void k();

    boolean l();

    int m();

    void n(int i11);

    void o(Canvas canvas);

    void p(boolean z11);

    boolean q(int i11, int i12, int i13, int i14);

    void r(float f11);

    void s(int i11);

    void setAlpha(float f11);

    boolean t();

    int u();

    boolean v();

    boolean w(boolean z11);

    void x(Matrix matrix);

    void y(int i11);

    int z();
}
