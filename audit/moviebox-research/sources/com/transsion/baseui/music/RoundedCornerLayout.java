package com.transsion.baseui.music;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
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
public final class RoundedCornerLayout extends ConstraintLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f51423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f51425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f51426d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f51427f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCornerLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCornerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCornerLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51427f = new Path();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundedCornerLayout);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.RoundedCornerLayout)");
        this.f51423a = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedCornerLayout_cornerRadiusTopLeft, 0.0f);
        this.f51424b = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedCornerLayout_cornerRadiusTopRight, 0.0f);
        this.f51425c = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedCornerLayout_cornerRadiusBottomLeft, 0.0f);
        this.f51426d = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedCornerLayout_cornerRadiusBottomRight, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ RoundedCornerLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        int iSave = canvas.save();
        canvas.clipPath(this.f51427f);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f51427f.reset();
        Path path = this.f51427f;
        RectF rectF = new RectF(0.0f, 0.0f, i11, i12);
        float f11 = this.f51423a;
        float f12 = this.f51424b;
        float f13 = this.f51426d;
        float f14 = this.f51425c;
        path.addRoundRect(rectF, new float[]{f11, f11, f12, f12, f13, f13, f14, f14}, Path.Direction.CW);
    }
}
