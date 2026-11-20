package com.transsion.home.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.home.R$styleable;
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
public final class VerticalRoundedRectView extends View {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f52687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f52688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f52689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f52690d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f52691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f52692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f52693h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalRoundedRectView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalRoundedRectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalRoundedRectView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f52687a = 100.0f;
        this.f52688b = 50.0f;
        this.f52689c = 5;
        this.f52690d = 20.0f;
        this.f52691f = -16776961;
        this.f52692g = 4.0f;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        this.f52693h = paint;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.VerticalRoundedRectView);
            Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….VerticalRoundedRectView)");
            this.f52687a = typedArrayObtainStyledAttributes.getDimension(R$styleable.VerticalRoundedRectView_rectWidth, this.f52687a);
            this.f52688b = typedArrayObtainStyledAttributes.getDimension(R$styleable.VerticalRoundedRectView_rectHeight, this.f52688b);
            this.f52689c = typedArrayObtainStyledAttributes.getInt(R$styleable.VerticalRoundedRectView_rectCount, this.f52689c);
            this.f52690d = typedArrayObtainStyledAttributes.getDimension(R$styleable.VerticalRoundedRectView_rectSpacing, this.f52690d);
            this.f52691f = typedArrayObtainStyledAttributes.getColor(R$styleable.VerticalRoundedRectView_rectColor, this.f52691f);
            this.f52692g = typedArrayObtainStyledAttributes.getDimension(R$styleable.VerticalRoundedRectView_rectCorner, this.f52692g);
            typedArrayObtainStyledAttributes.recycle();
        }
        paint.setColor(this.f52691f);
    }

    public /* synthetic */ VerticalRoundedRectView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        int i11 = this.f52689c;
        for (int i12 = 0; i12 < i11; i12++) {
            float f11 = i12 * (this.f52688b + this.f52690d);
            RectF rectF = new RectF(0.0f, f11, this.f52687a, this.f52688b + f11);
            float f12 = this.f52692g;
            canvas.drawRoundRect(rectF, f12, f12, this.f52693h);
        }
    }

    public final void setCornerRadius(float f11) {
        this.f52692g = f11;
        invalidate();
    }

    public final void setRectColor(int i11) {
        this.f52691f = i11;
        this.f52693h.setColor(i11);
        invalidate();
    }

    public final void setRectCount(int i11) {
        this.f52689c = i11;
        invalidate();
    }

    public final void setRectHeight(float f11) {
        this.f52688b = f11;
        invalidate();
    }

    public final void setRectSpacing(float f11) {
        this.f52690d = f11;
        invalidate();
    }

    public final void setRectWidth(float f11) {
        this.f52687a = f11;
        invalidate();
    }
}
