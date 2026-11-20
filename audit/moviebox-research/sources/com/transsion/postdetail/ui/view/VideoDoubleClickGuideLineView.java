package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tn.lib.widget.R$color;
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
public final class VideoDoubleClickGuideLineView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f56121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f56122b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickGuideLineView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f56121a = new Paint(1);
        this.f56122b = new Path();
        a(null, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickGuideLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f56121a = new Paint(1);
        this.f56122b = new Path();
        a(attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickGuideLineView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56121a = new Paint(1);
        this.f56122b = new Path();
        a(attributeSet, i11, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickGuideLineView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.f56121a = new Paint(1);
        this.f56122b = new Path();
        a(attributeSet, i11, i12);
    }

    public final void a(AttributeSet attributeSet, int i11, int i12) {
        this.f56121a.setAntiAlias(true);
        this.f56121a.setColor(z2.a.getColor(getContext(), R$color.white_50));
        this.f56121a.setStyle(Paint.Style.STROKE);
        float fE = com.blankj.utilcode.util.i.e(4.0f);
        this.f56121a.setStrokeWidth(com.blankj.utilcode.util.i.e(1.0f));
        this.f56121a.setPathEffect(new DashPathEffect(new float[]{fE, fE}, 0.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        this.f56122b.reset();
        this.f56122b.moveTo(0.0f, 0.0f);
        this.f56122b.lineTo(com.blankj.utilcode.util.i.e(1.0f), getHeight());
        canvas.drawPath(this.f56122b, this.f56121a);
    }
}
