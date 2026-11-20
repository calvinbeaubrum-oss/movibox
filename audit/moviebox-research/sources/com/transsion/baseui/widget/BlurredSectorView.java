package com.transsion.baseui.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
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
public final class BlurredSectorView extends View {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f51480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f51481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f51482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f51483d;

    public BlurredSectorView(Context context) {
        super(context);
        this.f51482c = 100 * getResources().getDisplayMetrics().density;
        this.f51483d = 60 * getResources().getDisplayMetrics().density;
        a();
    }

    public BlurredSectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f51482c = 100 * getResources().getDisplayMetrics().density;
        this.f51483d = 60 * getResources().getDisplayMetrics().density;
        a();
    }

    public final void a() {
        Paint paint = new Paint(1);
        this.f51480a = paint;
        paint.setColor(Color.parseColor("#9900512F"));
        Paint paint2 = this.f51480a;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.y("mPaint");
            paint2 = null;
        }
        paint2.setStyle(Paint.Style.FILL);
        Paint paint4 = this.f51480a;
        if (paint4 == null) {
            Intrinsics.y("mPaint");
        } else {
            paint3 = paint4;
        }
        paint3.setMaskFilter(new BlurMaskFilter(this.f51483d, BlurMaskFilter.Blur.NORMAL));
        this.f51481b = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF;
        Paint paint;
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        float f11 = this.f51482c;
        int height = getHeight();
        float f12 = this.f51482c;
        RectF rectF2 = this.f51481b;
        if (rectF2 == null) {
            Intrinsics.y("mRectF");
            rectF2 = null;
        }
        float f13 = height;
        rectF2.set(f11 - f12, f13 - f12, f11 + f12, f13 + f12);
        RectF rectF3 = this.f51481b;
        if (rectF3 == null) {
            Intrinsics.y("mRectF");
            rectF = null;
        } else {
            rectF = rectF3;
        }
        Paint paint2 = this.f51480a;
        if (paint2 == null) {
            Intrinsics.y("mPaint");
            paint = null;
        } else {
            paint = paint2;
        }
        canvas.drawArc(rectF, 180.0f, 180.0f, true, paint);
    }
}
