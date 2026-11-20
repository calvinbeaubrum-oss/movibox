package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.tn.lib.widget.R$styleable;
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
public final class MaxHeightNestedScrollView extends NestedScrollView {
    public float F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightNestedScrollView(Context context) {
        super(context);
        Intrinsics.d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightNestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.d(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaxHeightNestedScrollView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…axHeightNestedScrollView)");
        this.F = typedArrayObtainStyledAttributes.getDimension(R$styleable.MaxHeightNestedScrollView_scroll_maxHeight, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.F > 0.0f) {
            int i13 = getResources().getDisplayMetrics().heightPixels;
            float f11 = this.F;
            i12 = View.MeasureSpec.makeMeasureSpec((f11 > ((float) i13) ? Integer.valueOf(i13) : Float.valueOf(f11)).intValue(), Integer.MIN_VALUE);
        }
        super.onMeasure(i11, i12);
    }

    public final void setMaxHeight(float f11) {
        this.F = f11;
        requestLayout();
    }
}
