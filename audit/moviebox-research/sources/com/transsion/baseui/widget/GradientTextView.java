package com.transsion.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.noober.background.BackgroundFactory;
import com.tn.lib.view.FlowLayout;
import com.tn.lib.widget.TnTextView;
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
public final class GradientTextView extends TnTextView {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f51494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f51496d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51494b = FlowLayout.SPACING_AUTO;
        this.f51496d = -16776961;
        BackgroundFactory.setViewBackground(context, attributeSet, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GradientTextView, 0, 0);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.GradientTextView, 0, 0)");
        this.f51494b = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientTextView_gradientTvStartColor, -1);
        this.f51495c = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientTextView_gradientTvCenterColor, 0);
        this.f51496d = typedArrayObtainStyledAttributes.getColor(R$styleable.GradientTextView_gradientTvEndColor, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ GradientTextView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void b() {
        int i11 = this.f51495c;
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, i11 == 0 ? new int[]{this.f51494b, this.f51496d} : new int[]{this.f51494b, i11, this.f51496d}, (float[]) null, Shader.TileMode.CLAMP));
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11) {
            b();
        }
    }

    public final void setGradientColors(int i11, int i12, int i13) {
        this.f51494b = i11;
        this.f51495c = i12;
        this.f51496d = i13;
        b();
    }
}
