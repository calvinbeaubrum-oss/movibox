package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$styleable;
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
public final class RoundedArrowImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f49578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f49579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49581d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f49582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49583g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedArrowImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedArrowImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedArrowImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        Paint paint = new Paint(1);
        this.f49578a = paint;
        this.f49579b = new Path();
        this.f49580c = f0.a(8.0f);
        this.f49581d = f0.a(8.0f);
        this.f49582f = f0.a(16.0f);
        this.f49583g = f0.a(200.0f);
        paint.setStyle(Paint.Style.FILL);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundedArrowImageView, 0, 0);
            Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ndedArrowImageView, 0, 0)");
            this.f49580c = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedArrowImageView_arrowIVHeight, this.f49580c);
            this.f49581d = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedArrowImageView_cornerRadius, this.f49581d);
            this.f49582f = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedArrowImageView_arrowIVWidth, this.f49582f);
            this.f49583g = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedArrowImageView_arrowIVPositionOffset, this.f49583g);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ RoundedArrowImageView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        float width = getWidth();
        float height = getHeight() - this.f49580c;
        float f11 = this.f49583g;
        this.f49579b.reset();
        float f12 = 2;
        this.f49579b.moveTo(f11 - (this.f49582f / f12), this.f49580c);
        this.f49579b.lineTo(f11, 0.0f);
        this.f49579b.lineTo(f11 + (this.f49582f / f12), this.f49580c);
        this.f49579b.lineTo(width - this.f49581d, this.f49580c);
        Path path = this.f49579b;
        float f13 = this.f49581d;
        float f14 = this.f49580c;
        path.arcTo(new RectF(width - (f13 * f12), f14, width, (f13 * f12) + f14), -90.0f, 90.0f);
        this.f49579b.lineTo(width, (height - this.f49581d) + this.f49580c);
        Path path2 = this.f49579b;
        float f15 = this.f49581d;
        float f16 = this.f49580c;
        path2.arcTo(new RectF(width - (f15 * f12), (height - (f15 * f12)) + f16, width, f16 + height), 0.0f, 90.0f);
        this.f49579b.lineTo(this.f49581d, this.f49580c + height);
        Path path3 = this.f49579b;
        float f17 = this.f49581d;
        float f18 = this.f49580c;
        path3.arcTo(new RectF(0.0f, (height - (f17 * f12)) + f18, f17 * f12, height + f18), 90.0f, 90.0f);
        this.f49579b.lineTo(0.0f, this.f49581d + this.f49580c);
        Path path4 = this.f49579b;
        float f19 = this.f49580c;
        float f21 = this.f49581d;
        path4.arcTo(new RectF(0.0f, f19, f21 * f12, (f21 * f12) + f19), 180.0f, 90.0f);
        this.f49579b.close();
        canvas.save();
        canvas.clipPath(this.f49579b);
        super.onDraw(canvas);
        canvas.restore();
    }

    public final void setArrowPosition(float f11) {
        this.f49583g = kotlin.ranges.a.j(f11, 0.0f, getWidth());
        invalidate();
    }
}
