package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends View {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final int[] f28529sc = {Color.parseColor("#1AFFFFFF"), Color.parseColor("#4DFFFFFF"), Color.parseColor("#99FFFFFF")};
    private final Paint ExN;
    private int Ol;
    private int Qj;
    private final Paint TRI;
    private final ArrayList<sc> We;
    private final RectF pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28530qr;
    private final RectF zY;

    /* JADX INFO: compiled from: source.java */
    public static final class sc {
        float We;
        public float pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public Paint f28531sc;
        float zY;

        public sc(Paint paint, float f11, float f12, float f13) {
            this.f28531sc = paint;
            this.pFF = f11;
            this.zY = f12;
            this.We = f13;
        }
    }

    public Ol(Context context) {
        super(context);
        this.pFF = new RectF();
        this.zY = new RectF();
        this.We = new ArrayList<>();
        this.TRI = new Paint();
        Paint paint = new Paint();
        this.ExN = paint;
        paint.setColor(Color.parseColor("#D9D9D9"));
    }

    private void sc() {
        if (this.f28530qr <= 0) {
            return;
        }
        this.zY.right = Math.max(this.Ol, (int) (((this.Qj * 1.0f) / 100.0f) * getWidth()));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.pFF;
        int i11 = this.f28530qr;
        canvas.drawRoundRect(rectF, i11, i11, this.ExN);
        RectF rectF2 = this.zY;
        int i12 = this.f28530qr;
        canvas.drawRoundRect(rectF2, i12, i12, this.TRI);
        int iSave = canvas.save();
        canvas.translate(this.zY.right - this.Ol, 0.0f);
        for (sc scVar : this.We) {
            canvas.drawCircle(scVar.zY, scVar.We, scVar.pFF, scVar.f28531sc);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        int i15 = i12 / 2;
        this.f28530qr = i15;
        this.Ol = i15 * 5;
        float f11 = i11;
        float f12 = i12;
        this.pFF.set(0.0f, 0.0f, f11, f12);
        this.zY.set(0.0f, 0.0f, 0.0f, f12);
        this.TRI.setShader(new LinearGradient(0.0f, 0.0f, f11, f12, new int[]{Color.parseColor("#90C0FF"), Color.parseColor("#196BE4")}, (float[]) null, Shader.TileMode.CLAMP));
        this.We.clear();
        float f13 = this.f28530qr / 4.0f;
        for (int i16 : f28529sc) {
            Paint paint = new Paint();
            paint.setColor(i16);
            this.We.add(new sc(paint, this.f28530qr / 2.0f, f13, f12 / 2.0f));
            f13 += (this.f28530qr / 2.0f) * 3.0f;
        }
        sc();
    }

    public void setProgress(int i11) {
        int i12 = this.Qj;
        if (i12 == i11) {
            return;
        }
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 > 100) {
            i11 = 100;
        }
        if (i12 == i11) {
            return;
        }
        this.Qj = i11;
        sc();
    }
}
