package com.transsion.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R$styleable;
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
public final class RoundedConstraintLayout extends ConstraintLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f51523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f51525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f51526d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f51527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f51528g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f51523a = new Path();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R$styleable.RoundedConstraintLayout, 0, 0);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…edConstraintLayout, 0, 0)");
        try {
            this.f51524b = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_cornerRadius, 0.0f);
            this.f51525c = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_topLeftRadius, 0.0f);
            this.f51526d = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_topRightRadius, 0.0f);
            this.f51527f = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_bottomLeftRadius, 0.0f);
            this.f51528g = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_bottomRightRadius, 0.0f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        if (this.f51524b > 0.0f) {
            Path path = this.f51523a;
            float width = getWidth();
            float height = getHeight();
            float f11 = this.f51524b;
            path.addRoundRect(0.0f, 0.0f, width, height, f11, f11, Path.Direction.CW);
            canvas.clipPath(this.f51523a);
        } else {
            float f12 = this.f51525c;
            float f13 = this.f51526d;
            float f14 = this.f51528g;
            float f15 = this.f51527f;
            this.f51523a.addRoundRect(0.0f, 0.0f, getWidth(), getHeight(), new float[]{f12, f12, f13, f13, f14, f14, f15, f15}, Path.Direction.CW);
            canvas.clipPath(this.f51523a);
        }
        super.dispatchDraw(canvas);
    }
}
