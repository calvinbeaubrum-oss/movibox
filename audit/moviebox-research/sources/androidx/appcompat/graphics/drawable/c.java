package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f967m = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f979l;

    public c(Context context) {
        Paint paint = new Paint();
        this.f968a = paint;
        this.f974g = new Path();
        this.f976i = false;
        this.f979l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R$attr.drawerArrowStyle, R$style.Base_Widget_AppCompat_DrawerArrowToggle);
        c(typedArrayObtainStyledAttributes.getColor(R$styleable.DrawerArrowToggle_color, 0));
        b(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_thickness, 0.0f));
        e(typedArrayObtainStyledAttributes.getBoolean(R$styleable.DrawerArrowToggle_spinBars, true));
        d(Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f975h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DrawerArrowToggle_drawableSize, 0);
        this.f970c = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f969b = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f971d = typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float a(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }

    public void b(float f11) {
        if (this.f968a.getStrokeWidth() != f11) {
            this.f968a.setStrokeWidth(f11);
            this.f978k = (float) (((double) (f11 / 2.0f)) * Math.cos(f967m));
            invalidateSelf();
        }
    }

    public void c(int i11) {
        if (i11 != this.f968a.getColor()) {
            this.f968a.setColor(i11);
            invalidateSelf();
        }
    }

    public void d(float f11) {
        if (f11 != this.f972e) {
            this.f972e = f11;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int i11 = this.f979l;
        boolean z11 = false;
        if (i11 != 0 && (i11 == 1 || (i11 == 3 ? d3.a.f(this) == 0 : d3.a.f(this) == 1))) {
            z11 = true;
        }
        float f11 = this.f969b;
        float fA = a(this.f970c, (float) Math.sqrt(f11 * f11 * 2.0f), this.f977j);
        float fA2 = a(this.f970c, this.f971d, this.f977j);
        float fRound = Math.round(a(0.0f, this.f978k, this.f977j));
        float fA3 = a(0.0f, f967m, this.f977j);
        float fA4 = a(z11 ? 0.0f : -180.0f, z11 ? 180.0f : 0.0f, this.f977j);
        double d11 = fA;
        double d12 = fA3;
        boolean z12 = z11;
        float fRound2 = Math.round(Math.cos(d12) * d11);
        float fRound3 = Math.round(d11 * Math.sin(d12));
        this.f974g.rewind();
        float fA5 = a(this.f972e + this.f968a.getStrokeWidth(), -this.f978k, this.f977j);
        float f12 = (-fA2) / 2.0f;
        this.f974g.moveTo(f12 + fRound, 0.0f);
        this.f974g.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.f974g.moveTo(f12, fA5);
        this.f974g.rLineTo(fRound2, fRound3);
        this.f974g.moveTo(f12, -fA5);
        this.f974g.rLineTo(fRound2, -fRound3);
        this.f974g.close();
        canvas.save();
        float strokeWidth = this.f968a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        float f13 = this.f972e;
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * f13))) / 4) * 2) + (strokeWidth * 1.5f) + f13);
        if (this.f973f) {
            canvas.rotate(fA4 * (this.f976i ^ z12 ? -1 : 1));
        } else if (z12) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f974g, this.f968a);
        canvas.restore();
    }

    public void e(boolean z11) {
        if (this.f973f != z11) {
            this.f973f = z11;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f975h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f975h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        if (i11 != this.f968a.getAlpha()) {
            this.f968a.setAlpha(i11);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f968a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f11) {
        if (this.f977j != f11) {
            this.f977j = f11;
            invalidateSelf();
        }
    }
}
