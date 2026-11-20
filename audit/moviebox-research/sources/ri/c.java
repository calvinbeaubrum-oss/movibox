package ri;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import oi.f;
import yi.n;
import yi.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Paint f75495b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f75501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f75502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f75503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f75504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f75505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f75506m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public n f75508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public ColorStateList f75509p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f75494a = o.k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f75496c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f75497d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f75498e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f75499f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f75500g = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f75507n = true;

    /* JADX INFO: compiled from: source.java */
    public class b extends Drawable.ConstantState {
        public b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c(n nVar) {
        this.f75508o = nVar;
        Paint paint = new Paint(1);
        this.f75495b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    public final Shader a() {
        Rect rect = this.f75497d;
        copyBounds(rect);
        float fHeight = this.f75501h / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{c3.b.g(this.f75502i, this.f75506m), c3.b.g(this.f75503j, this.f75506m), c3.b.g(c3.b.k(this.f75503j, 0), this.f75506m), c3.b.g(c3.b.k(this.f75505l, 0), this.f75506m), c3.b.g(this.f75505l, this.f75506m), c3.b.g(this.f75504k, this.f75506m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    @NonNull
    public RectF b() {
        this.f75499f.set(getBounds());
        return this.f75499f;
    }

    public void c(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f75506m = colorStateList.getColorForState(getState(), this.f75506m);
        }
        this.f75509p = colorStateList;
        this.f75507n = true;
        invalidateSelf();
    }

    public void d(float f11) {
        if (this.f75501h != f11) {
            this.f75501h = f11;
            this.f75495b.setStrokeWidth(f11 * 1.3333f);
            this.f75507n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f75507n) {
            this.f75495b.setShader(a());
            this.f75507n = false;
        }
        float strokeWidth = this.f75495b.getStrokeWidth() / 2.0f;
        copyBounds(this.f75497d);
        this.f75498e.set(this.f75497d);
        float fMin = Math.min(this.f75508o.r().a(b()), this.f75498e.width() / 2.0f);
        if (this.f75508o.u(b())) {
            this.f75498e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f75498e, fMin, fMin, this.f75495b);
        }
    }

    public void e(int i11, int i12, int i13, int i14) {
        this.f75502i = i11;
        this.f75503j = i12;
        this.f75504k = i13;
        this.f75505l = i14;
    }

    public void f(n nVar) {
        this.f75508o = nVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f75500g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f75501h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f75508o.u(b())) {
            outline.setRoundRect(getBounds(), this.f75508o.r().a(b()));
        } else {
            copyBounds(this.f75497d);
            this.f75498e.set(this.f75497d);
            this.f75494a.d(this.f75508o, 1.0f, this.f75498e, this.f75496c);
            f.l(outline, this.f75496c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (!this.f75508o.u(b())) {
            return true;
        }
        int iRound = Math.round(this.f75501h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f75509p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f75507n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f75509p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f75506m)) != this.f75506m) {
            this.f75507n = true;
            this.f75506m = colorForState;
        }
        if (this.f75507n) {
            invalidateSelf();
        }
        return this.f75507n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f75495b.setAlpha(i11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f75495b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
