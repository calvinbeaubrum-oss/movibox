package com.transsion.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.transsion.baseui.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class GradientBorderView extends ConstraintLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f51490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f51491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f51492d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f51493f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBorderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBorderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51489a = ViewCompat.MEASURED_STATE_MASK;
        this.f51490b = ViewCompat.MEASURED_STATE_MASK;
        this.f51491c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GradientBorderView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.GradientBorderView)");
        this.f51489a = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientBorderView_borderViewStartColor, ViewCompat.MEASURED_STATE_MASK);
        this.f51490b = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientBorderView_borderViewEndColor, ViewCompat.MEASURED_STATE_MASK);
        this.f51492d = typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_borderWidth, 0.0f);
        this.f51493f = typedArrayObtainStyledAttributes.getInt(R$styleable.GradientBorderView_gradientOrientation, 0);
        this.f51491c = new float[]{typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topLeftCornerRadius, 0.0f), typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topLeftCornerRadius, 0.0f), typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topRightCornerRadius, 0.0f), typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topRightCornerRadius, 0.0f), typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomRightCornerRadius, 0.0f), typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomRightCornerRadius, 0.0f), typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomLeftCornerRadius, 0.0f), typedArrayObtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomLeftCornerRadius, 0.0f)};
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    public /* synthetic */ GradientBorderView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        if (getWidth() <= 0 || getHeight() <= 0 || this.f51492d <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f51492d);
        paint.setShader(this.f51493f == 1 ? new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), this.f51489a, this.f51490b, Shader.TileMode.CLAMP) : new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f51489a, this.f51490b, Shader.TileMode.CLAMP));
        float f11 = this.f51492d;
        float f12 = 2;
        RectF rectF = new RectF(f11 / f12, f11 / f12, getWidth() - (this.f51492d / f12), getHeight() - (this.f51492d / f12));
        Path path = new Path();
        path.addRoundRect(rectF, this.f51491c, Path.Direction.CW);
        canvas.drawPath(path, paint);
        try {
            super.dispatchDraw(canvas);
        } catch (IllegalArgumentException unused) {
        }
    }
}
