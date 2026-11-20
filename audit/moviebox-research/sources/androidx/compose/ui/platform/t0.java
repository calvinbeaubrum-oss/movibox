package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.graphics.k4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class t0 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f5549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f5550b;

    public t0(float[] fArr) {
        this.f5549a = fArr;
        this.f5550b = new int[2];
    }

    public /* synthetic */ t0(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    @Override // androidx.compose.ui.platform.s0
    public void a(View view, float[] fArr) {
        k4.h(fArr);
        d(view, fArr);
    }

    public final void b(float[] fArr, Matrix matrix) {
        androidx.compose.ui.graphics.r0.b(this.f5549a, matrix);
        AndroidComposeView_androidKt.i(fArr, this.f5549a);
    }

    public final void c(float[] fArr, float f11, float f12) {
        AndroidComposeView_androidKt.j(fArr, f11, f12, this.f5549a);
    }

    public final void d(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            d((View) parent, fArr);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, view.getLeft(), view.getTop());
        } else {
            int[] iArr = this.f5550b;
            view.getLocationInWindow(iArr);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, iArr[0], iArr[1]);
        }
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        b(fArr, matrix);
    }
}
