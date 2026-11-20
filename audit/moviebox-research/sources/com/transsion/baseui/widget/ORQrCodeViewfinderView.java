package com.transsion.baseui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.google.zxing.k;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.transsion.baseui.R$styleable;
import java.util.List;
import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ORQrCodeViewfinderView extends ViewfinderView {
    public static final long INT_ANIMATION_DELAY = 12;
    public Paint mBitmapPaint;
    public int mLineColor;
    public float mLineDepth;
    public float mLineRate;
    public LinearGradient mLinearGradient;
    public float[] mPositions;
    public float mScanFrameHeight;
    public float mScanFrameWidth;
    public int[] mScanLineColor;
    public float mScanLineDepth;
    public float mScanLineDy;
    public int mScanLinePosition;

    public ORQrCodeViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLineRate = 0.1f;
        this.mLineDepth = b(4);
        this.mScanLinePosition = 0;
        this.mScanLineDepth = b(4);
        this.mScanLineDy = b(3);
        this.mPositions = new float[]{0.0f, 0.5f, 1.0f};
        this.mScanLineColor = new int[]{0, InputDeviceCompat.SOURCE_ANY, 0};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ORQrCodeViewfinderView);
        this.mLineColor = typedArrayObtainStyledAttributes.getColor(R$styleable.ORQrCodeViewfinderView_lineColor, InputDeviceCompat.SOURCE_ANY);
        this.mScanLineColor[1] = typedArrayObtainStyledAttributes.getColor(R$styleable.ORQrCodeViewfinderView_cornerColor, InputDeviceCompat.SOURCE_ANY);
        this.mScanFrameWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.ORQrCodeViewfinderView_scanFrameWidth, b(160));
        this.mScanFrameHeight = typedArrayObtainStyledAttributes.getDimension(R$styleable.ORQrCodeViewfinderView_scanFrameHeight, b(160));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.journeyapps.barcodescanner.ViewfinderView
    public void a() {
        CameraPreview cameraPreview = this.f42535l;
        if (cameraPreview == null) {
            return;
        }
        cameraPreview.setFramingRectSize(new t((int) this.mScanFrameWidth, (int) this.mScanFrameHeight));
        Rect framingRect = this.f42535l.getFramingRect();
        t previewSize = this.f42535l.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f42536m = framingRect;
        this.f42537n = previewSize;
    }

    public final int b(int i11) {
        return (int) ((i11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.journeyapps.barcodescanner.ViewfinderView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        a();
        Rect rect = this.f42536m;
        if (rect == null || this.f42537n == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f42525a.setColor(this.f42526b != null ? this.f42528d : this.f42527c);
        float f11 = width;
        canvas.drawRect(0.0f, 0.0f, f11, rect.top, this.f42525a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f42525a);
        canvas.drawRect(rect.right + 1, rect.top, f11, rect.bottom + 1, this.f42525a);
        canvas.drawRect(0.0f, rect.bottom + 1, f11, height, this.f42525a);
        this.f42525a.setColor(this.mLineColor);
        int i11 = rect.left;
        canvas.drawRect(i11, rect.top, (rect.width() * this.mLineRate) + i11, this.mLineDepth + rect.top, this.f42525a);
        int i12 = rect.left;
        int i13 = rect.top;
        canvas.drawRect(i12, i13, this.mLineDepth + i12, i13 + (rect.height() * this.mLineRate), this.f42525a);
        float fWidth = rect.right - (rect.width() * this.mLineRate);
        int i14 = rect.top;
        canvas.drawRect(fWidth, i14, rect.right, this.mLineDepth + i14, this.f42525a);
        int i15 = rect.right;
        float f12 = i15 - this.mLineDepth;
        int i16 = rect.top;
        canvas.drawRect(f12, i16, i15, i16 + (rect.height() * this.mLineRate), this.f42525a);
        int i17 = rect.left;
        canvas.drawRect(i17, rect.bottom - this.mLineDepth, (rect.width() * this.mLineRate) + i17, rect.bottom, this.f42525a);
        canvas.drawRect(rect.left, rect.bottom - (rect.height() * this.mLineRate), this.mLineDepth + rect.left, rect.bottom, this.f42525a);
        float fWidth2 = rect.right - (rect.width() * this.mLineRate);
        int i18 = rect.bottom;
        canvas.drawRect(fWidth2, i18 - this.mLineDepth, rect.right, i18, this.f42525a);
        canvas.drawRect(rect.right - this.mLineDepth, rect.bottom - (rect.height() * this.mLineRate), rect.right, rect.bottom, this.f42525a);
        if (this.f42526b != null) {
            this.f42525a.setAlpha(160);
            canvas.drawBitmap(this.f42526b, (Rect) null, rect, this.f42525a);
        } else {
            int i19 = (int) (this.mScanLinePosition + this.mScanLineDy);
            this.mScanLinePosition = i19;
            if (i19 >= rect.height()) {
                this.mScanLinePosition = 0;
            }
            float f13 = rect.left;
            int i21 = rect.top;
            int i22 = this.mScanLinePosition;
            LinearGradient linearGradient = new LinearGradient(f13, i21 + i22, rect.right, i21 + i22, this.mScanLineColor, this.mPositions, Shader.TileMode.CLAMP);
            this.mLinearGradient = linearGradient;
            this.f42525a.setShader(linearGradient);
            float f14 = rect.left;
            int i23 = rect.top;
            int i24 = this.mScanLinePosition;
            canvas.drawRect(f14, i23 + i24, rect.right, i23 + i24 + this.mScanLineDepth, this.f42525a);
            this.f42525a.setShader(null);
            float width2 = getWidth() / this.f42537n.f80643a;
            float height2 = getHeight() / this.f42537n.f80644b;
            if (!this.f42534k.isEmpty()) {
                this.f42525a.setAlpha(80);
                this.f42525a.setColor(this.f42530g);
                for (k kVar : this.f42534k) {
                    canvas.drawCircle((int) (kVar.c() * width2), (int) (kVar.d() * height2), 3.0f, this.f42525a);
                }
                this.f42534k.clear();
            }
            if (!this.f42533j.isEmpty()) {
                this.f42525a.setAlpha(160);
                this.f42525a.setColor(this.f42530g);
                for (k kVar2 : this.f42533j) {
                    canvas.drawCircle((int) (kVar2.c() * width2), (int) (kVar2.d() * height2), 6.0f, this.f42525a);
                }
                List<k> list = this.f42533j;
                List<k> list2 = this.f42534k;
                this.f42533j = list2;
                this.f42534k = list;
                list2.clear();
            }
        }
        postInvalidateDelayed(12L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }
}
