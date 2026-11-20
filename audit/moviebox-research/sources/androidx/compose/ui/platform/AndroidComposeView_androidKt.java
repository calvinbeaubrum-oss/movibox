package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.k4;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
public final class AndroidComposeView_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function1<? super androidx.compose.ui.text.input.x, ? extends androidx.compose.ui.text.input.x> f5261a = new Function1<androidx.compose.ui.text.input.x, androidx.compose.ui.text.input.x>() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.input.x invoke(androidx.compose.ui.text.input.x xVar) {
            return xVar;
        }
    };

    public static final boolean e(View view, View view2) {
        if (Intrinsics.b(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    public static final float f(float[] fArr, int i11, float[] fArr2, int i12) {
        int i13 = i11 * 4;
        return (fArr[i13] * fArr2[i12]) + (fArr[i13 + 1] * fArr2[4 + i12]) + (fArr[i13 + 2] * fArr2[8 + i12]) + (fArr[i13 + 3] * fArr2[12 + i12]);
    }

    public static final j2.e g(View view) {
        j2.f.c(view, 1);
        return j2.f.b(view);
    }

    public static final Function1<androidx.compose.ui.text.input.x, androidx.compose.ui.text.input.x> h() {
        return f5261a;
    }

    public static final void i(float[] fArr, float[] fArr2) {
        float f11 = f(fArr2, 0, fArr, 0);
        float f12 = f(fArr2, 0, fArr, 1);
        float f13 = f(fArr2, 0, fArr, 2);
        float f14 = f(fArr2, 0, fArr, 3);
        float f15 = f(fArr2, 1, fArr, 0);
        float f16 = f(fArr2, 1, fArr, 1);
        float f17 = f(fArr2, 1, fArr, 2);
        float f18 = f(fArr2, 1, fArr, 3);
        float f19 = f(fArr2, 2, fArr, 0);
        float f21 = f(fArr2, 2, fArr, 1);
        float f22 = f(fArr2, 2, fArr, 2);
        float f23 = f(fArr2, 2, fArr, 3);
        float f24 = f(fArr2, 3, fArr, 0);
        float f25 = f(fArr2, 3, fArr, 1);
        float f26 = f(fArr2, 3, fArr, 2);
        float f27 = f(fArr2, 3, fArr, 3);
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        fArr[3] = f14;
        fArr[4] = f15;
        fArr[5] = f16;
        fArr[6] = f17;
        fArr[7] = f18;
        fArr[8] = f19;
        fArr[9] = f21;
        fArr[10] = f22;
        fArr[11] = f23;
        fArr[12] = f24;
        fArr[13] = f25;
        fArr[14] = f26;
        fArr[15] = f27;
    }

    public static final void j(float[] fArr, float f11, float f12, float[] fArr2) {
        k4.h(fArr2);
        k4.q(fArr2, f11, f12, 0.0f, 4, null);
        i(fArr, fArr2);
    }
}
