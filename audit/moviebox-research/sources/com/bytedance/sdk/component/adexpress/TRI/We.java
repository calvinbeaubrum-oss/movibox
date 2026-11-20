package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends View {
    private float ExN;
    private List<Integer> Ol;
    private List<Integer> Qj;
    private float Ql;
    private int SR;
    private int TRI;
    private float Tf;
    private Paint UFX;
    private Paint WH;
    private int We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f26701qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26702sc;
    private float zY;

    public We(Context context) {
        this(context, null);
    }

    public We(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public We(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f26702sc = -1;
        this.pFF = FlowLayout.SPACING_AUTO;
        this.zY = 18.0f;
        this.We = 3;
        this.ExN = 50.0f;
        this.TRI = 2;
        this.f26701qr = false;
        this.Qj = new ArrayList();
        this.Ol = new ArrayList();
        this.SR = 24;
        zY();
    }

    private void zY() {
        Paint paint = new Paint();
        this.WH = paint;
        paint.setAntiAlias(true);
        this.WH.setStrokeWidth(this.SR);
        this.Qj.add(255);
        this.Ol.add(0);
        Paint paint2 = new Paint();
        this.UFX = paint2;
        paint2.setAntiAlias(true);
        this.UFX.setColor(Color.parseColor("#0FFFFFFF"));
        this.UFX.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.WH.setShader(new LinearGradient(this.Tf, 0.0f, this.Ql, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i11 = 0;
        while (true) {
            if (i11 >= this.Qj.size()) {
                break;
            }
            Integer num = this.Qj.get(i11);
            this.WH.setAlpha(num.intValue());
            Integer num2 = this.Ol.get(i11);
            if (this.zY + num2.intValue() < this.ExN) {
                canvas.drawCircle(this.Tf, this.Ql, this.zY + num2.intValue(), this.WH);
            }
            if (num.intValue() > 0 && num2.intValue() < this.ExN) {
                this.Qj.set(i11, Integer.valueOf(num.intValue() - this.TRI > 0 ? num.intValue() - (this.TRI * 3) : 1));
                this.Ol.set(i11, Integer.valueOf(num2.intValue() + this.TRI));
            }
            i11++;
        }
        List<Integer> list = this.Ol;
        if (list.get(list.size() - 1).intValue() >= this.ExN / this.We) {
            this.Qj.add(255);
            this.Ol.add(0);
        }
        if (this.Ol.size() >= 3) {
            this.Ol.remove(0);
            this.Qj.remove(0);
        }
        this.WH.setAlpha(255);
        this.WH.setColor(this.pFF);
        canvas.drawCircle(this.Tf, this.Ql, this.zY, this.UFX);
        if (this.f26701qr) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        float f11 = i11 / 2.0f;
        this.Tf = f11;
        this.Ql = i12 / 2.0f;
        float f12 = f11 - (this.SR / 2.0f);
        this.ExN = f12;
        this.zY = f12 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            invalidate();
        }
    }

    public void pFF() {
        this.f26701qr = false;
        this.Ol.clear();
        this.Qj.clear();
        this.Qj.add(255);
        this.Ol.add(0);
        invalidate();
    }

    public void sc() {
        this.f26701qr = true;
        invalidate();
    }

    public void setColor(int i11) {
        this.f26702sc = i11;
    }

    public void setCoreColor(int i11) {
        this.pFF = i11;
    }

    public void setCoreRadius(int i11) {
        this.zY = i11;
    }

    public void setDiffuseSpeed(int i11) {
        this.TRI = i11;
    }

    public void setDiffuseWidth(int i11) {
        this.We = i11;
    }

    public void setMaxWidth(int i11) {
        this.ExN = i11;
    }
}
