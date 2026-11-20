package com.facebook.ads.redexgen.uinode;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1519Nt extends View {
    public static byte[] A09;
    public static String[] A0A = {"Nbc6Jmo5XxwoSf0WsC4pNUwvbxxmeuzU", "Es2t6BS2", "WUgCzt6qD3CB9cjx4HsVq0Jqaz41VBuo", "hkZRo5NTzxOFCAK6tj2hPIlun6a", "TTjuir0T4YhatH37Odlm7BF", "mNho4RFDELoa", "9llBB27OMv3OwRnb05oM", "XnRgJ28VorNH"};
    public static final int A0B;
    public float A00;
    public ObjectAnimator A01;
    public Bitmap A02;
    public final float A03;
    public final Paint A04;
    public final Paint A05;
    public final Paint A06;
    public final RectF A07;
    public final RectF A08;

    static {
        A01();
        A0B = (int) (LD.A02 * 5.0f);
    }

    public C1519Nt(C1795Yn c1795Yn) {
        super(c1795Yn);
        float f11 = Resources.getSystem().getDisplayMetrics().density * 3.0f;
        this.A03 = f11;
        this.A00 = 0.0f;
        this.A01 = null;
        this.A07 = new RectF();
        this.A08 = new RectF();
        Paint paint = new Paint(1);
        this.A04 = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f11);
        Paint paint2 = new Paint(1);
        this.A05 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f11);
        this.A06 = new Paint(1);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{0, 2, Ascii.US, Ascii.ETB, 2, Ascii.NAK, 3, 3};
    }

    public final void A02(int i11, int i12, int i13) {
        this.A04.setColor(i11);
        this.A05.setColor(i12);
        this.A06.setColorFilter(new PorterDuffColorFilter(AbstractC10112p.A01(i12, i13), PorterDuff.Mode.SRC_ATOP));
    }

    @Override // android.view.View
    public final void clearAnimation() {
        ObjectAnimator objectAnimator = this.A01;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            if (A0A[4].length() == 15) {
                throw new RuntimeException();
            }
            A0A[0] = "vMfsJaJNlQJ6eTU2cMKDLU2YSzRmfzEH";
            this.A01 = null;
        }
    }

    public float getProgress() {
        return this.A00;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.A07, 0.0f, 360.0f, false, this.A04);
        canvas.drawArc(this.A07, -90.0f, ((100.0f - this.A00) * 360.0f) / 100.0f, false, this.A05);
        Bitmap bitmap = this.A02;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, new Rect(0, 0, this.A02.getWidth(), this.A02.getHeight()), this.A08, this.A06);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i11, int i12) {
        int iMin = Math.min(getDefaultSize(getSuggestedMinimumHeight(), i12), getDefaultSize(getSuggestedMinimumWidth(), i11));
        setMeasuredDimension(iMin, iMin);
        this.A07.set((this.A03 / 2.0f) + 0.0f + getPaddingLeft(), (this.A03 / 2.0f) + 0.0f + getPaddingTop(), (iMin - (this.A03 / 2.0f)) - getPaddingRight(), (iMin - (this.A03 / 2.0f)) - getPaddingBottom());
        RectF rectF = this.A08;
        float f11 = this.A07.left;
        int i13 = A0B;
        rectF.set(f11 + i13, this.A07.top + i13, this.A07.right - i13, this.A07.bottom - i13);
    }

    public void setImage(EnumC1470Lw enumC1470Lw) {
        this.A02 = enumC1470Lw == null ? null : AbstractC1471Lx.A01(enumC1470Lw);
        invalidate();
    }

    public void setProgress(float f11) {
        this.A00 = Math.min(f11, 100.0f);
        postInvalidate();
    }

    public void setProgressWithAnimation(float f11) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, A00(0, 8, 32), f11);
        this.A01 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(400L);
        this.A01.setInterpolator(new LinearInterpolator());
        this.A01.start();
    }
}
