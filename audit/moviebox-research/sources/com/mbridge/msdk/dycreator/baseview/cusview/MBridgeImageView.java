package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBridgeImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Xfermode f43471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f43479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f43480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f43481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float[] f43482l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RectF f43483m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RectF f43484n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f43485o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f43486p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Path f43487q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Paint f43488r;

    public MBridgeImageView(Context context) {
        this(context, null);
    }

    public MBridgeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBridgeImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43487q = new Path();
        this.f43488r = new Paint();
        this.f43481k = new float[8];
        this.f43482l = new float[8];
        this.f43484n = new RectF();
        this.f43483m = new RectF();
        this.f43471a = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.f43483m, null, 31);
            int i11 = this.f43472b;
            int i12 = this.f43479i;
            int i13 = this.f43473c;
            canvas.scale(((i11 - (i12 * 2)) * 1.0f) / i11, ((i13 - (i12 * 2)) * 1.0f) / i13, i11 / 2.0f, i13 / 2.0f);
            super.onDraw(canvas);
            Paint paint = this.f43488r;
            if (paint != null) {
                paint.reset();
                this.f43488r.setAntiAlias(true);
                this.f43488r.setStyle(Paint.Style.FILL);
                this.f43488r.setXfermode(this.f43471a);
            }
            Path path = this.f43487q;
            if (path != null) {
                path.reset();
                this.f43487q.addRoundRect(this.f43483m, this.f43482l, Path.Direction.CCW);
            }
            canvas.drawPath(this.f43487q, this.f43488r);
            Paint paint2 = this.f43488r;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restore();
            if (this.f43485o) {
                int i14 = this.f43479i;
                int i15 = this.f43480j;
                RectF rectF = this.f43484n;
                float[] fArr = this.f43481k;
                try {
                    Path path2 = this.f43487q;
                    if (path2 != null) {
                        path2.reset();
                    }
                    Paint paint3 = this.f43488r;
                    if (paint3 != null) {
                        paint3.setStrokeWidth(i14);
                        this.f43488r.setColor(i15);
                        this.f43488r.setStyle(Paint.Style.STROKE);
                    }
                    Path path3 = this.f43487q;
                    if (path3 != null) {
                        path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                    }
                    canvas.drawPath(this.f43487q, this.f43488r);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            ad.a("MBridgeImageView", e12.getMessage());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        super.onSizeChanged(i11, i12, i13, i14);
        this.f43472b = i11;
        this.f43473c = i12;
        int i18 = 0;
        if (this.f43486p) {
            try {
                if (this.f43481k != null && this.f43482l != null) {
                    while (true) {
                        i15 = 2;
                        if (i18 >= 2) {
                            break;
                        }
                        float[] fArr = this.f43481k;
                        int i19 = this.f43475e;
                        fArr[i18] = i19;
                        this.f43482l[i18] = i19 - (this.f43479i / 2.0f);
                        i18++;
                    }
                    while (true) {
                        i16 = 4;
                        if (i15 >= 4) {
                            break;
                        }
                        float[] fArr2 = this.f43481k;
                        int i21 = this.f43476f;
                        fArr2[i15] = i21;
                        this.f43482l[i15] = i21 - (this.f43479i / 2.0f);
                        i15++;
                    }
                    while (true) {
                        if (i16 >= 6) {
                            break;
                        }
                        float[] fArr3 = this.f43481k;
                        int i22 = this.f43477g;
                        fArr3[i16] = i22;
                        this.f43482l[i16] = i22 - (this.f43479i / 2.0f);
                        i16++;
                    }
                    for (i17 = 6; i17 < 8; i17++) {
                        float[] fArr4 = this.f43481k;
                        int i23 = this.f43478h;
                        fArr4[i17] = i23;
                        this.f43482l[i17] = i23 - (this.f43479i / 2.0f);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else if (this.f43481k != null && this.f43482l != null) {
            while (true) {
                try {
                    float[] fArr5 = this.f43481k;
                    if (i18 >= fArr5.length) {
                        break;
                    }
                    int i24 = this.f43474d;
                    fArr5[i18] = i24;
                    this.f43482l[i18] = i24 - (this.f43479i / 2.0f);
                    i18++;
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
        RectF rectF = this.f43484n;
        if (rectF != null) {
            int i25 = this.f43479i;
            rectF.set(i25 / 2.0f, i25 / 2.0f, this.f43472b - (i25 / 2.0f), this.f43473c - (i25 / 2.0f));
        }
        RectF rectF2 = this.f43483m;
        if (rectF2 != null) {
            rectF2.set(0.0f, 0.0f, this.f43472b, this.f43473c);
        }
    }

    public void setBorder(int i11, int i12, int i13) {
        this.f43485o = true;
        this.f43479i = i12;
        this.f43480j = i13;
        this.f43474d = i11;
    }

    public void setCornerRadius(int i11) {
        this.f43474d = i11;
    }

    public void setCustomBorder(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f43485o = true;
        this.f43486p = true;
        this.f43479i = i15;
        this.f43480j = i16;
        this.f43475e = i11;
        this.f43477g = i13;
        this.f43476f = i12;
        this.f43478h = i14;
    }
}
