package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.postdetail.R$color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class VideoDoubleClickBackgroundView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f56118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f56119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f56120c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f56118a = new Paint();
        this.f56120c = true;
        a(null, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f56118a = new Paint();
        this.f56120c = true;
        a(attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56118a = new Paint();
        this.f56120c = true;
        a(attributeSet, i11, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.f56118a = new Paint();
        this.f56120c = true;
        a(attributeSet, i11, i12);
    }

    public final void a(AttributeSet attributeSet, int i11, int i12) {
        this.f56118a.setAntiAlias(true);
        this.f56118a.setColor(z2.a.getColor(getContext(), R$color.video_double_click_bg));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float f11 = width / 2.0f;
        double d11 = 2;
        double d12 = f11;
        float degrees = (float) (Math.toDegrees(Math.asin((((double) height) / d11) / d12)) * d11);
        if (!this.f56120c) {
            if (this.f56119b == null) {
                float f12 = height / 2;
                this.f56119b = new RectF(f11, (-f11) + f12, width + f11, (f11 - f12) + height);
            }
            RectF rectF = this.f56119b;
            Intrinsics.d(rectF);
            canvas.drawArc(rectF, 180 - (degrees / 2.0f), degrees, false, this.f56118a);
            canvas.drawRect(width - ((float) Math.sqrt((d12 * d12) - ((double) ((height * height) / 4)))), 0.0f, width, height, this.f56118a);
            return;
        }
        if (this.f56119b == null) {
            float f13 = -f11;
            float f14 = height / 2;
            this.f56119b = new RectF(f13, f13 + f14, f11, (f11 - f14) + height);
        }
        RectF rectF2 = this.f56119b;
        Intrinsics.d(rectF2);
        canvas.drawArc(rectF2, (-degrees) / 2.0f, degrees, false, this.f56118a);
        canvas.drawRect(0.0f, 0.0f, (float) Math.sqrt((d12 * d12) - ((double) ((height * height) / 4))), height, this.f56118a);
    }

    public final void setLeftStyle(boolean z11) {
        if (this.f56120c == z11) {
            return;
        }
        this.f56120c = z11;
        this.f56119b = null;
        invalidate();
    }
}
