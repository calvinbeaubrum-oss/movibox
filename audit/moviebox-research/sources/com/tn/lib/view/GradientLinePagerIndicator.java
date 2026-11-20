package com.tn.lib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class GradientLinePagerIndicator extends View implements h20.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49535d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Interpolator f49536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Interpolator f49537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f49538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f49539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f49540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f49541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f49542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f49543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<? extends i20.a> f49544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f49545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f49546p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientLinePagerIndicator(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientLinePagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientLinePagerIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f49533b = 1;
        this.f49534c = 2;
        this.f49536f = new LinearInterpolator();
        this.f49537g = new LinearInterpolator();
        this.f49543m = new Paint(1);
        this.f49546p = new RectF();
        this.f49543m.setStyle(Paint.Style.FILL);
        this.f49539i = g20.b.a(context, 3.0d);
        this.f49541k = g20.b.a(context, 10.0d);
    }

    public final int[] getColors() {
        return this.f49545o;
    }

    public final Interpolator getEndInterpolator() {
        return this.f49537g;
    }

    public final float getLineHeight() {
        return this.f49539i;
    }

    public final float getLineWidth() {
        return this.f49541k;
    }

    public final int getMODE_EXACTLY() {
        return this.f49534c;
    }

    public final int getMODE_MATCH_EDGE() {
        return this.f49532a;
    }

    public final int getMODE_WRAP_CONTENT() {
        return this.f49533b;
    }

    public final int getMode() {
        return this.f49535d;
    }

    public final Paint getPaint() {
        return this.f49543m;
    }

    public final float getRoundRadius() {
        return this.f49542l;
    }

    public final Interpolator getStartInterpolator() {
        return this.f49536f;
    }

    public final float getXOffset() {
        return this.f49540j;
    }

    public final float getYOffset() {
        return this.f49538h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        RectF rectF = this.f49546p;
        float f11 = this.f49542l;
        canvas.drawRoundRect(rectF, f11, f11, this.f49543m);
    }

    @Override // h20.c
    public void onPageScrollStateChanged(int i11) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:20:0x00be  */
    /* JADX WARN: Code duplicated, block: B:21:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:23:0x00d4  */
    @Override // h20.c
    public void onPageScrolled(int i11, float f11, int i12) {
        float fB;
        float fB2;
        float fB3;
        float f12;
        float f13;
        int i13;
        int[] iArr;
        int[] iArr2;
        List<? extends i20.a> list = this.f49544n;
        if (list != null) {
            if (list == null || !list.isEmpty()) {
                i20.a aVarA = e20.a.a(this.f49544n, i11);
                i20.a aVarA2 = e20.a.a(this.f49544n, i11 + 1);
                int i14 = this.f49535d;
                if (i14 != 0) {
                    if (i14 == 1) {
                        float f14 = aVarA.f66889e;
                        f13 = this.f49540j;
                        fB = f14 + f13;
                        f12 = aVarA2.f66889e + f13;
                        fB2 = aVarA.f66891g - f13;
                        i13 = aVarA2.f66891g;
                    } else {
                        float f15 = 2;
                        fB = aVarA.f66885a + ((aVarA.b() - this.f49541k) / f15);
                        float fB4 = aVarA2.f66885a + ((aVarA2.b() - this.f49541k) / f15);
                        fB2 = ((aVarA.b() + this.f49541k) / f15) + aVarA.f66885a;
                        fB3 = ((aVarA2.b() + this.f49541k) / f15) + aVarA2.f66885a;
                        f12 = fB4;
                    }
                    this.f49546p.left = fB + ((f12 - fB) * this.f49536f.getInterpolation(f11));
                    this.f49546p.right = fB2 + ((fB3 - fB2) * this.f49537g.getInterpolation(f11));
                    this.f49546p.top = (getHeight() - this.f49539i) - this.f49538h;
                    this.f49546p.bottom = getHeight() - this.f49538h;
                    iArr = this.f49545o;
                    if (iArr != null) {
                        Intrinsics.d(iArr);
                        if (iArr.length == 1) {
                            Paint paint = this.f49543m;
                            int[] iArr3 = this.f49545o;
                            Intrinsics.d(iArr3);
                            paint.setColor(iArr3[0]);
                        } else {
                            iArr2 = this.f49545o;
                            Intrinsics.d(iArr2);
                            if (iArr2.length > 1) {
                                RectF rectF = this.f49546p;
                                float f16 = rectF.left;
                                float f17 = rectF.top;
                                float f18 = rectF.right;
                                float f19 = rectF.bottom;
                                int[] iArr4 = this.f49545o;
                                Intrinsics.d(iArr4);
                                this.f49543m.setShader(new LinearGradient(f16, f17, f18, f19, iArr4, (float[]) null, Shader.TileMode.CLAMP));
                            }
                        }
                    }
                    invalidate();
                }
                float f21 = aVarA.f66885a;
                f13 = this.f49540j;
                fB = f21 + f13;
                f12 = aVarA2.f66885a + f13;
                fB2 = aVarA.f66887c - f13;
                i13 = aVarA2.f66887c;
                fB3 = i13 - f13;
                this.f49546p.left = fB + ((f12 - fB) * this.f49536f.getInterpolation(f11));
                this.f49546p.right = fB2 + ((fB3 - fB2) * this.f49537g.getInterpolation(f11));
                this.f49546p.top = (getHeight() - this.f49539i) - this.f49538h;
                this.f49546p.bottom = getHeight() - this.f49538h;
                iArr = this.f49545o;
                if (iArr != null) {
                    Intrinsics.d(iArr);
                    if (iArr.length == 1) {
                        Paint paint2 = this.f49543m;
                        int[] iArr5 = this.f49545o;
                        Intrinsics.d(iArr5);
                        paint2.setColor(iArr5[0]);
                    } else {
                        iArr2 = this.f49545o;
                        Intrinsics.d(iArr2);
                        if (iArr2.length > 1) {
                            RectF rectF2 = this.f49546p;
                            float f110 = rectF2.left;
                            float f111 = rectF2.top;
                            float f112 = rectF2.right;
                            float f113 = rectF2.bottom;
                            int[] iArr6 = this.f49545o;
                            Intrinsics.d(iArr6);
                            this.f49543m.setShader(new LinearGradient(f110, f111, f112, f113, iArr6, (float[]) null, Shader.TileMode.CLAMP));
                        }
                    }
                }
                invalidate();
            }
        }
    }

    @Override // h20.c
    public void onPageSelected(int i11) {
    }

    @Override // h20.c
    public void onPositionDataProvide(List<? extends i20.a> dataList) {
        Intrinsics.g(dataList, "dataList");
        this.f49544n = dataList;
    }

    public final void setColors(int i11, int i12, int i13) {
        this.f49545o = new int[]{i11, i12, i13};
    }

    public final void setEndInterpolator(Interpolator endInterpolator) {
        Intrinsics.g(endInterpolator, "endInterpolator");
        this.f49537g = endInterpolator;
        if (endInterpolator == null) {
            this.f49537g = new LinearInterpolator();
        }
    }

    public final void setLineHeight(float f11) {
        this.f49539i = f11;
    }

    public final void setLineWidth(float f11) {
        this.f49541k = f11;
    }

    public final void setMode(int i11) {
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            this.f49535d = i11;
            return;
        }
        throw new IllegalArgumentException("mode " + i11 + " not supported.");
    }

    public final void setRoundRadius(float f11) {
        this.f49542l = f11;
    }

    public final void setStartInterpolator(Interpolator startInterpolator) {
        Intrinsics.g(startInterpolator, "startInterpolator");
        this.f49536f = startInterpolator;
        if (startInterpolator == null) {
            this.f49536f = new LinearInterpolator();
        }
    }

    public final void setXOffset(float f11) {
        this.f49540j = f11;
    }

    public final void setYOffset(float f11) {
        this.f49538h = f11;
    }
}
