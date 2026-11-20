package com.transsion.subroom.guide;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.f0;
import com.transsion.subroom.R$drawable;
import com.transsion.subroom.R$styleable;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Indicator extends LinearLayoutCompat {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f58067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f58068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f58069s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Indicator(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Indicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Indicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Indicator);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…s, R.styleable.Indicator)");
        this.f58067q = typedArrayObtainStyledAttributes.getInteger(R$styleable.Indicator_CustomIndicatorSize, 0);
        this.f58069s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Indicator_CustomHorizontalMargin, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.Indicator_CustomSelectedIndex, 0);
        this.f58068r = integer;
        int i12 = this.f58067q;
        if (integer >= i12) {
            this.f58068r = 0;
        }
        int i13 = 0;
        while (i13 < i12) {
            View view = new View(context);
            LinearLayoutCompat.a aVar = new LinearLayoutCompat.a(f0.a(6.0f), f0.a(6.0f));
            aVar.setMarginStart(i13 == 0 ? 0 : this.f58069s);
            view.setLayoutParams(aVar);
            if (i13 == this.f58068r) {
                view.setBackgroundResource(R$drawable.guide_selected_dot);
            } else {
                view.setBackgroundResource(R$drawable.guide_unselected_dot);
            }
            addView(view);
            i13++;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void u(int i11) {
        if (i11 >= getChildCount()) {
            return;
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (i12 == i11) {
                childAt.setBackgroundResource(R$drawable.guide_selected_dot);
            } else {
                childAt.setBackgroundResource(R$drawable.guide_unselected_dot);
            }
        }
    }

    public final void select(int i11) {
        u(i11);
    }
}
