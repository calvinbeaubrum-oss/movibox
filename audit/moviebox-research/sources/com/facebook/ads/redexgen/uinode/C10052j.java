package com.facebook.ads.redexgen.uinode;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10052j extends Drawable {
    public static InterfaceC10042i A0G;
    public static byte[] A0H;
    public static String[] A0I = {"YEFrjfwCEWu", "", "GYovhjhdb5Je", "S1Fz", "LeiEw92n2EsObareFd", "xgqXw3gEiUgyln4SIM", "kGClknFKKNldAaaK4EgXWOsNKvCYjz7L", "I70UDyBH67pytg1dUxrP2KgAWNh3bG3K"};
    public static final double A0J;
    public float A00;
    public float A01;
    public float A02;
    public float A03;
    public ColorStateList A04;
    public Paint A05;
    public Paint A06;
    public Path A08;
    public final RectF A0F;
    public boolean A0A = true;
    public boolean A09 = true;
    public boolean A0B = false;
    public final int A0E = 922746880;
    public final int A0D = 50331648;
    public final int A0C = AbstractC10002e.A09;
    public Paint A07 = new Paint(5);

    static {
        A05();
        A0J = Math.cos(Math.toRadians(45.0d));
    }

    public C10052j(Resources resources, ColorStateList colorStateList, float f11, float f12, float f13) {
        A07(colorStateList);
        Paint paint = new Paint(5);
        this.A05 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.A00 = (int) (0.5f + f11);
        this.A0F = new RectF();
        Paint paint2 = new Paint(this.A05);
        this.A06 = paint2;
        paint2.setAntiAlias(false);
        A06(f12, f13);
    }

    public static float A00(float f11, float f12, boolean z11) {
        if (!z11) {
            return f11;
        }
        double d11 = f11;
        if (A0I[2].length() == 3) {
            throw new RuntimeException();
        }
        String[] strArr = A0I;
        strArr[5] = "P9aPeBSvznAhF57KLP";
        strArr[4] = "W3RUpaMuYeMV1XeTAU";
        return (float) (d11 + ((1.0d - A0J) * ((double) f12)));
    }

    public static float A01(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) (1.5f * f11)) + ((1.0d - A0J) * ((double) f12))) : 1.5f * f11;
    }

    private int A02(float f11) {
        int i11 = (int) (0.5f + f11);
        if (i11 % 2 != 1) {
            return i11;
        }
        int i12 = i11 - 1;
        String[] strArr = A0I;
        if (strArr[0].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0I;
        strArr2[0] = "0g5GSSLFt9w";
        strArr2[3] = "EJV6";
        return i12;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0I;
            if (strArr[5].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[5] = "Hial5Dc7DTVcebgm6Z";
            strArr2[4] = "T1onITFvXBLfXkfgru";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 69);
            i14++;
        }
    }

    private void A04() {
        float f11 = this.A00;
        RectF rectF = new RectF(-f11, -f11, f11, f11);
        RectF rectF2 = new RectF(rectF);
        float f12 = this.A03;
        rectF2.inset(-f12, -f12);
        Path path = this.A08;
        if (path == null) {
            this.A08 = new Path();
        } else {
            path.reset();
        }
        this.A08.setFillType(Path.FillType.EVEN_ODD);
        this.A08.moveTo(-this.A00, 0.0f);
        this.A08.rLineTo(-this.A03, 0.0f);
        this.A08.arcTo(rectF2, 180.0f, 90.0f, false);
        this.A08.arcTo(rectF, 270.0f, -90.0f, false);
        this.A08.close();
        float f13 = this.A00;
        float f14 = f13 / (this.A03 + f13);
        Paint paint = this.A05;
        float f15 = this.A03 + this.A00;
        int i11 = this.A0E;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f15, new int[]{i11, i11, this.A0D}, new float[]{0.0f, f14, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.A06;
        float f16 = this.A00;
        float f17 = this.A03;
        float f18 = (-f16) + f17;
        float f19 = (-f16) - f17;
        int i12 = this.A0E;
        paint2.setShader(new LinearGradient(0.0f, f18, 0.0f, f19, new int[]{i12, i12, this.A0D}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.A06.setAntiAlias(false);
    }

    public static void A05() {
        A0H = new byte[]{114, 124, 17, 41, 47, 40, 124, 62, 57, 124, 98, 97, 124, 108, 115, 84, 76, 91, 86, 83, 94, Ascii.SUB, 87, 91, 66, Ascii.SUB, 73, 82, 91, 94, 85, 77, Ascii.SUB, 73, 83, 64, 95, Ascii.SUB, 8, 47, 55, 32, 45, 40, 37, 97, 51, 32, 37, 40, 52, 50, 97, 1, 38, 62, 41, 36, 33, 44, 104, 59, 32, 41, 44, 39, Utf8.REPLACEMENT_BYTE, 104, 59, 33, 50, 45, 104};
    }

    private void A06(float f11, float f12) {
        String strA03 = A03(0, 14, 25);
        if (f11 < 0.0f) {
            throw new IllegalArgumentException(A03(53, 20, 13) + f11 + strA03);
        }
        if (A0I[1].length() == 0) {
            A0I[2] = "3ZLq2wnsXXEHTe1p9";
            if (f12 < 0.0f) {
                throw new IllegalArgumentException(A03(14, 24, 127) + f12 + strA03);
            }
            float fA02 = A02(f11);
            float fA03 = A02(f12);
            if (fA02 > fA03) {
                fA02 = fA03;
                if (!this.A0B) {
                    this.A0B = true;
                }
            }
            if (this.A02 == fA02 && this.A01 == fA03) {
                return;
            }
            this.A02 = fA02;
            this.A01 = fA03;
            float f13 = 1.5f * fA02;
            if (A0I[2].length() != 3) {
                A0I[2] = "TJpNel9JPCCGijw6acwFd0iMJz";
                this.A03 = (int) (f13 + this.A0C + 0.5f);
                this.A0A = true;
                invalidateSelf();
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A07(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.A04 = colorStateList;
        Paint paint = this.A07;
        int[] state = getState();
        int defaultColor = this.A04.getDefaultColor();
        if (A0I[2].length() == 3) {
            throw new RuntimeException();
        }
        String[] strArr = A0I;
        strArr[0] = "VZiE9OVYqDu";
        strArr[3] = "EWr6";
        paint.setColor(colorStateList.getColorForState(state, defaultColor));
    }

    private void A08(Canvas canvas) {
        float f11 = this.A00;
        float f12 = (-f11) - this.A03;
        float f13 = f11 + this.A0C + (this.A02 / 2.0f);
        boolean z11 = this.A0F.width() - (f13 * 2.0f) > 0.0f;
        boolean z12 = this.A0F.height() - (f13 * 2.0f) > 0.0f;
        int iSave = canvas.save();
        canvas.translate(this.A0F.left + f13, this.A0F.top + f13);
        canvas.drawPath(this.A08, this.A05);
        if (z11) {
            canvas.drawRect(0.0f, f12, this.A0F.width() - (f13 * 2.0f), -this.A00, this.A06);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        canvas.translate(this.A0F.right - f13, this.A0F.bottom - f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.A08, this.A05);
        if (z11) {
            canvas.drawRect(0.0f, f12, this.A0F.width() - (f13 * 2.0f), (-this.A00) + this.A03, this.A06);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.A0F.left + f13, this.A0F.bottom - f13);
        if (A0I[2].length() != 3) {
            A0I[2] = "QAUm";
            canvas.rotate(270.0f);
            canvas.drawPath(this.A08, this.A05);
            if (z12) {
                canvas.drawRect(0.0f, f12, this.A0F.height() - (f13 * 2.0f), -this.A00, this.A06);
            }
            canvas.restoreToCount(iSave3);
            int iSave4 = canvas.save();
            float f14 = this.A0F.right - f13;
            float f15 = this.A0F.top;
            if (A0I[2].length() != 3) {
                A0I[2] = "4hs9knzgsM3vbS2";
                canvas.translate(f14, f15 + f13);
                canvas.rotate(90.0f);
                canvas.drawPath(this.A08, this.A05);
                if (z12) {
                    canvas.drawRect(0.0f, f12, this.A0F.height() - (2.0f * f13), -this.A00, this.A06);
                }
                canvas.restoreToCount(iSave4);
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A09(Rect rect) {
        float f11 = this.A01 * 1.5f;
        this.A0F.set(rect.left + this.A01, rect.top + f11, rect.right - this.A01, rect.bottom - f11);
        A04();
    }

    public final float A0A() {
        return this.A00;
    }

    public final float A0B() {
        return this.A01;
    }

    public final float A0C() {
        float f11 = this.A01;
        return (((this.A01 * 1.5f) + this.A0C) * 2.0f) + (Math.max(f11, this.A00 + this.A0C + ((f11 * 1.5f) / 2.0f)) * 2.0f);
    }

    public final float A0D() {
        float f11 = this.A01;
        return ((this.A01 + this.A0C) * 2.0f) + (Math.max(f11, this.A00 + this.A0C + (f11 / 2.0f)) * 2.0f);
    }

    public final float A0E() {
        return this.A02;
    }

    public final ColorStateList A0F() {
        return this.A04;
    }

    public final void A0G(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException(A03(38, 15, 4) + f11 + A03(0, 14, 25));
        }
        float f12 = (int) (0.5f + f11);
        if (this.A00 == f12) {
            return;
        }
        this.A00 = f12;
        this.A0A = true;
        invalidateSelf();
    }

    public final void A0H(float f11) {
        A06(this.A02, f11);
    }

    public final void A0I(float f11) {
        A06(f11, this.A01);
    }

    public final void A0J(ColorStateList colorStateList) {
        A07(colorStateList);
        invalidateSelf();
    }

    public final void A0K(Rect rect) {
        getPadding(rect);
    }

    public final void A0L(boolean z11) {
        this.A09 = z11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.A0A) {
            A09(getBounds());
            this.A0A = false;
        }
        canvas.translate(0.0f, this.A02 / 2.0f);
        A08(canvas);
        canvas.translate(0.0f, (-this.A02) / 2.0f);
        A0G.A5E(canvas, this.A0F, this.A00, this.A07);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(A01(this.A01, this.A00, this.A09));
        int iCeil2 = (int) Math.ceil(A00(this.A01, this.A00, this.A09));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.A04;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.A0A = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.A04;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.A07.getColor() == colorForState) {
            return false;
        }
        this.A07.setColor(colorForState);
        this.A0A = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i11) {
        this.A07.setAlpha(i11);
        this.A05.setAlpha(i11);
        this.A06.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.A07.setColorFilter(colorFilter);
    }
}
