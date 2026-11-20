package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.ExN.We;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NiceImageView extends We {
    private int BT;
    private final RectF Dl;
    private int ExN;
    private Path FI;
    private final Path JPJ;
    private int Ol;
    private int Qj;
    private int Ql;
    private final Xfermode SR;
    private final float[] Sfl;
    private int TRI;
    private int Tf;
    private int UFX;
    private int WH;
    private int We;
    private float Xc;
    private RectF YIK;
    private int dE;
    private boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f27648qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f27649sc;
    private final Paint uEA;
    private final float[] wjp;
    private boolean zY;

    public NiceImageView(Context context) {
        this(context, null);
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.ExN = -1;
        this.f27648qr = -1;
        this.f27649sc = context;
        this.Qj = kX.zY(context, 10.0f);
        this.wjp = new float[8];
        this.Sfl = new float[8];
        this.Dl = new RectF();
        this.YIK = new RectF();
        this.uEA = new Paint();
        this.JPJ = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.SR = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.SR = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.FI = new Path();
        }
        zY();
        We();
    }

    private void We() {
        if (this.pFF) {
            return;
        }
        this.TRI = 0;
    }

    private void pFF() {
        if (!this.pFF) {
            this.YIK.set(0.0f, 0.0f, this.BT, this.dE);
            if (this.zY) {
                this.YIK = this.Dl;
                return;
            }
            return;
        }
        float fMin = Math.min(this.BT, this.dE) / 2.0f;
        this.Xc = fMin;
        RectF rectF = this.YIK;
        int i11 = this.BT;
        int i12 = this.dE;
        rectF.set((i11 / 2.0f) - fMin, (i12 / 2.0f) - fMin, (i11 / 2.0f) + fMin, (i12 / 2.0f) + fMin);
    }

    private void sc() {
        if (this.pFF) {
            return;
        }
        RectF rectF = this.Dl;
        int i11 = this.We;
        rectF.set(i11 / 2.0f, i11 / 2.0f, this.BT - (i11 / 2.0f), this.dE - (i11 / 2.0f));
    }

    private void sc(int i11, int i12) {
        this.JPJ.reset();
        this.uEA.setStrokeWidth(i11);
        this.uEA.setColor(i12);
        this.uEA.setStyle(Paint.Style.STROKE);
    }

    private void sc(Canvas canvas) {
        if (!this.pFF) {
            int i11 = this.We;
            if (i11 > 0) {
                sc(canvas, i11, this.ExN, this.Dl, this.wjp);
                return;
            }
            return;
        }
        int i12 = this.We;
        if (i12 > 0) {
            sc(canvas, i12, this.ExN, this.Xc - (i12 / 2.0f));
        }
        int i13 = this.TRI;
        if (i13 > 0) {
            sc(canvas, i13, this.f27648qr, (this.Xc - this.We) - (i13 / 2.0f));
        }
    }

    private void sc(Canvas canvas, int i11, int i12, float f11) {
        sc(i11, i12);
        this.JPJ.addCircle(this.BT / 2.0f, this.dE / 2.0f, f11, Path.Direction.CCW);
        canvas.drawPath(this.JPJ, this.uEA);
    }

    private void sc(Canvas canvas, int i11, int i12, RectF rectF, float[] fArr) {
        sc(i11, i12);
        this.JPJ.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.JPJ, this.uEA);
    }

    private void sc(boolean z11) {
        if (z11) {
            this.Qj = 0;
        }
        zY();
        sc();
        invalidate();
    }

    private void zY() {
        if (this.pFF) {
            return;
        }
        int i11 = 0;
        if (this.Qj <= 0) {
            float[] fArr = this.wjp;
            int i12 = this.Ol;
            float f11 = i12;
            fArr[1] = f11;
            fArr[0] = f11;
            int i13 = this.WH;
            float f12 = i13;
            fArr[3] = f12;
            fArr[2] = f12;
            int i14 = this.Tf;
            float f13 = i14;
            fArr[5] = f13;
            fArr[4] = f13;
            int i15 = this.UFX;
            float f14 = i15;
            fArr[7] = f14;
            fArr[6] = f14;
            float[] fArr2 = this.Sfl;
            int i16 = this.We;
            float f15 = i12 - (i16 / 2.0f);
            fArr2[1] = f15;
            fArr2[0] = f15;
            float f16 = i13 - (i16 / 2.0f);
            fArr2[3] = f16;
            fArr2[2] = f16;
            float f17 = i14 - (i16 / 2.0f);
            fArr2[5] = f17;
            fArr2[4] = f17;
            float f18 = i15 - (i16 / 2.0f);
            fArr2[7] = f18;
            fArr2[6] = f18;
            return;
        }
        while (true) {
            float[] fArr3 = this.wjp;
            if (i11 >= fArr3.length) {
                return;
            }
            int i17 = this.Qj;
            fArr3[i11] = i17;
            this.Sfl[i11] = i17 - (this.We / 2.0f);
            i11++;
        }
    }

    public void isCircle(boolean z11) {
        this.pFF = z11;
        We();
        pFF();
        invalidate();
    }

    public void isCoverSrc(boolean z11) {
        this.zY = z11;
        pFF();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.YIK, null, 31);
        if (!this.zY) {
            int i11 = this.BT;
            int i12 = this.We;
            int i13 = this.TRI;
            int i14 = this.dE;
            canvas.scale((((i11 - (i12 * 2)) - (i13 * 2)) * 1.0f) / i11, (((i14 - (i12 * 2)) - (i13 * 2)) * 1.0f) / i14, i11 / 2.0f, i14 / 2.0f);
        }
        super.onDraw(canvas);
        this.uEA.reset();
        this.JPJ.reset();
        if (this.pFF) {
            this.JPJ.addCircle(this.BT / 2.0f, this.dE / 2.0f, this.Xc, Path.Direction.CCW);
        } else {
            this.JPJ.addRoundRect(this.YIK, this.Sfl, Path.Direction.CCW);
        }
        this.uEA.setAntiAlias(true);
        this.uEA.setStyle(Paint.Style.FILL);
        this.uEA.setXfermode(this.SR);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.JPJ, this.uEA);
        } else {
            this.FI.addRect(this.YIK, Path.Direction.CCW);
            this.FI.op(this.JPJ, Path.Op.DIFFERENCE);
            canvas.drawPath(this.FI, this.uEA);
        }
        this.uEA.setXfermode(null);
        int i15 = this.Ql;
        if (i15 != 0) {
            this.uEA.setColor(i15);
            canvas.drawPath(this.JPJ, this.uEA);
        }
        canvas.restore();
        sc(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.BT = i11;
        this.dE = i12;
        sc();
        pFF();
    }

    public void setBorderColor(int i11) {
        this.ExN = i11;
        invalidate();
    }

    public void setBorderWidth(int i11) {
        this.We = kX.zY(this.f27649sc, i11);
        sc(false);
    }

    public void setCornerBottomLeftRadius(int i11) {
        this.UFX = kX.zY(this.f27649sc, i11);
        sc(true);
    }

    public void setCornerBottomRightRadius(int i11) {
        this.Tf = kX.zY(this.f27649sc, i11);
        sc(true);
    }

    public void setCornerRadius(int i11) {
        this.Qj = kX.zY(this.f27649sc, i11);
        sc(false);
    }

    public void setCornerTopLeftRadius(int i11) {
        this.Ol = kX.zY(this.f27649sc, i11);
        sc(true);
    }

    public void setCornerTopRightRadius(int i11) {
        this.WH = kX.zY(this.f27649sc, i11);
        sc(true);
    }

    public void setInnerBorderColor(int i11) {
        this.f27648qr = i11;
        invalidate();
    }

    public void setInnerBorderWidth(int i11) {
        this.TRI = kX.zY(this.f27649sc, i11);
        We();
        invalidate();
    }

    public void setMaskColor(int i11) {
        this.Ql = i11;
        invalidate();
    }
}
