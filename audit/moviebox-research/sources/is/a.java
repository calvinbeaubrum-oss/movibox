package is;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0715a f67672a = new C0715a(null);

    /* JADX INFO: renamed from: is.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0715a {
        public C0715a() {
        }

        public /* synthetic */ C0715a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Drawable drawable, int i11) {
        super(drawable, i11);
        Intrinsics.d(drawable);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        Intrinsics.g(canvas, "canvas");
        Intrinsics.g(text, "text");
        Intrinsics.g(paint, "paint");
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i16 = i15 - drawable.getBounds().bottom;
        int i17 = ((ImageSpan) this).mVerticalAlignment;
        if (i17 == 1) {
            i16 -= fontMetricsInt.descent;
        } else if (i17 == 2) {
            i16 = (((fontMetricsInt.descent + i14) + (i14 + fontMetricsInt.ascent)) / 2) - (drawable.getBounds().bottom / 2);
        }
        canvas.translate(f11, i16);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.g(paint, "paint");
        Intrinsics.g(text, "text");
        Rect bounds = getDrawable().getBounds();
        Intrinsics.f(bounds, "d.bounds");
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i13 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i14 = (bounds.bottom - bounds.top) / 2;
            int i15 = i13 / 4;
            int i16 = i14 - i15;
            int i17 = -(i14 + i15);
            fontMetricsInt.ascent = i17;
            fontMetricsInt.top = i17;
            fontMetricsInt.bottom = i16;
            fontMetricsInt.descent = i16;
        }
        return bounds.right;
    }
}
