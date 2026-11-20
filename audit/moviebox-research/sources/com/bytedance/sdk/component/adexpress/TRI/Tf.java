package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf extends View {
    private final List<sc> BT;
    private int ExN;
    private int[] Ol;
    private int Qj;
    private PorterDuff.Mode Ql;
    private LinearGradient SR;
    private int TRI;
    private Xfermode Tf;
    private Paint UFX;
    private Bitmap WH;
    private int We;
    Rect pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26689qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Rect f26690sc;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private int pFF = 0;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final int f26691sc;

        public sc(int i11) {
            this.f26691sc = i11;
        }

        public void sc() {
            this.pFF += this.f26691sc;
        }
    }

    public Tf(Context context) {
        super(context);
        this.Ql = PorterDuff.Mode.DST_IN;
        this.BT = new ArrayList();
        sc();
    }

    private void sc() {
        this.zY = com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_splash_unlock_image_arrow");
        this.We = Color.parseColor("#00ffffff");
        this.ExN = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.TRI = color;
        this.f26689qr = 10;
        this.Qj = 40;
        this.Ol = new int[]{this.We, this.ExN, color};
        setLayerType(1, null);
        this.UFX = new Paint(1);
        this.WH = BitmapFactory.decodeResource(getResources(), this.zY);
        this.Tf = new PorterDuffXfermode(this.Ql);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.WH, this.f26690sc, this.pFF, this.UFX);
        canvas.save();
        Iterator<sc> it = this.BT.iterator();
        while (it.hasNext()) {
            sc next = it.next();
            this.SR = new LinearGradient(next.pFF, 0.0f, next.pFF + this.Qj, this.f26689qr, this.Ol, (float[]) null, Shader.TileMode.CLAMP);
            this.UFX.setColor(-1);
            this.UFX.setShader(this.SR);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.UFX);
            this.UFX.setShader(null);
            next.sc();
            if (next.pFF > getWidth()) {
                it.remove();
            }
        }
        this.UFX.setXfermode(this.Tf);
        canvas.drawBitmap(this.WH, this.f26690sc, this.pFF, this.UFX);
        this.UFX.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.WH == null) {
            return;
        }
        this.f26690sc = new Rect(0, 0, this.WH.getWidth(), this.WH.getHeight());
        this.pFF = new Rect(0, 0, getWidth(), getHeight());
    }

    public void sc(int i11) {
        this.BT.add(new sc(i11));
        postInvalidate();
    }
}
