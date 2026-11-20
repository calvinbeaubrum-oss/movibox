package l1;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f69751a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f69753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f69754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f69755e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f69758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f69759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f69760j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f69756f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f69757g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f69761k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f69752b = new Paint(5);

    public d(ColorStateList colorStateList, float f11) {
        this.f69751a = f11;
        e(colorStateList);
        this.f69753c = new RectF();
        this.f69754d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f69758h;
    }

    public float c() {
        return this.f69755e;
    }

    public float d() {
        return this.f69751a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z11;
        Paint paint = this.f69752b;
        if (this.f69759i == null || paint.getColorFilter() != null) {
            z11 = false;
        } else {
            paint.setColorFilter(this.f69759i);
            z11 = true;
        }
        RectF rectF = this.f69753c;
        float f11 = this.f69751a;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        if (z11) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f69758h = colorStateList;
        this.f69752b.setColor(colorStateList.getColorForState(getState(), this.f69758h.getDefaultColor()));
    }

    public void f(@Nullable ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f11, boolean z11, boolean z12) {
        if (f11 == this.f69755e && this.f69756f == z11 && this.f69757g == z12) {
            return;
        }
        this.f69755e = f11;
        this.f69756f = z11;
        this.f69757g = z12;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f69754d, this.f69751a);
    }

    public void h(float f11) {
        if (f11 == this.f69751a) {
            return;
        }
        this.f69751a = f11;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f69753c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f69754d.set(rect);
        if (this.f69756f) {
            this.f69754d.inset((int) Math.ceil(e.a(this.f69755e, this.f69751a, this.f69757g)), (int) Math.ceil(e.b(this.f69755e, this.f69751a, this.f69757g)));
            this.f69753c.set(this.f69754d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f69760j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f69758h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f69758h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z11 = colorForState != this.f69752b.getColor();
        if (z11) {
            this.f69752b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f69760j;
        if (colorStateList2 == null || (mode = this.f69761k) == null) {
            return z11;
        }
        this.f69759i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f69752b.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f69752b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f69760j = colorStateList;
        this.f69759i = a(colorStateList, this.f69761k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f69761k = mode;
        this.f69759i = a(this.f69760j, mode);
        invalidateSelf();
    }
}
