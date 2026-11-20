package m2;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
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
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
@Metadata
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f70676a = new u();

    public final void a(Canvas canvas) {
        canvas.disableZ();
    }

    public final void b(Canvas canvas, int i11, BlendMode blendMode) {
        canvas.drawColor(i11, blendMode);
    }

    public final void c(Canvas canvas, long j11) {
        canvas.drawColor(j11);
    }

    public final void d(Canvas canvas, long j11, BlendMode blendMode) {
        canvas.drawColor(j11, blendMode);
    }

    public final void e(Canvas canvas, RectF rectF, float f11, float f12, RectF rectF2, float f13, float f14, Paint paint) {
        canvas.drawDoubleRoundRect(rectF, f11, f12, rectF2, f13, f14, paint);
    }

    public final void f(Canvas canvas, RectF rectF, float[] fArr, RectF rectF2, float[] fArr2, Paint paint) {
        canvas.drawDoubleRoundRect(rectF, fArr, rectF2, fArr2, paint);
    }

    public final void g(Canvas canvas, RenderNode renderNode) {
        canvas.drawRenderNode(renderNode);
    }

    public final void h(Canvas canvas, MeasuredText measuredText, int i11, int i12, int i13, int i14, float f11, float f12, boolean z11, Paint paint) {
        canvas.drawTextRun(measuredText, i11, i12, i13, i14, f11, f12, z11, paint);
    }

    public final void i(Canvas canvas) {
        canvas.enableZ();
    }
}
