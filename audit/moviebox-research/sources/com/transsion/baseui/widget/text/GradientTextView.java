package com.transsion.baseui.widget.text;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z2.a;

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
public final class GradientTextView extends AppCompatTextView {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Shader f51590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f51593d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f51592c = true;
        this.f51593d = new int[]{a.getColor(Utils.a(), R$color.brand_new_gradient_start), a.getColor(Utils.a(), R$color.brand_new_gradient_center), a.getColor(Utils.a(), R$color.brand_new_gradient_end)};
    }

    public final boolean getEnableGradientColor() {
        return this.f51592c;
    }

    public final int[] getGradientColors() {
        return this.f51593d;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f51592c) {
            float fMeasureText = getPaint().measureText(getText().toString());
            if (this.f51590a == null || this.f51591b != fMeasureText) {
                this.f51590a = new LinearGradient(0.0f, 0.0f, fMeasureText, 0.0f, this.f51593d, (float[]) null, Shader.TileMode.CLAMP);
            }
            getPaint().setShader(this.f51590a);
        }
    }

    public final void setEnableGradientColor(boolean z11) {
        this.f51592c = z11;
    }

    public final void setGradientColors(int[] iArr) {
        Intrinsics.g(iArr, "<set-?>");
        this.f51593d = iArr;
    }
}
