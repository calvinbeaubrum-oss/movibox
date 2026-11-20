package d3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends Drawable implements Drawable.Callback, c, b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f62878h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f62880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f62881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f62882d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f62883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f62884g;

    public d(@Nullable Drawable drawable) {
        this.f62882d = d();
        b(drawable);
    }

    public d(@NonNull f fVar, @Nullable Resources resources) {
        this.f62882d = fVar;
        e(resources);
    }

    @Override // d3.c
    public final Drawable a() {
        return this.f62884g;
    }

    @Override // d3.c
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f62884g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f62884g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f62882d;
            if (fVar != null) {
                fVar.f62887b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public boolean c() {
        throw null;
    }

    @NonNull
    public final f d() {
        return new f(this.f62882d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f62884g.draw(canvas);
    }

    public final void e(@Nullable Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f62882d;
        if (fVar == null || (constantState = fVar.f62887b) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    public final boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.f62882d;
        ColorStateList colorStateList = fVar.f62888c;
        PorterDuff.Mode mode = fVar.f62889d;
        if (colorStateList == null || mode == null) {
            this.f62881c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f62881c || colorForState != this.f62879a || mode != this.f62880b) {
                setColorFilter(colorForState, mode);
                this.f62879a = colorForState;
                this.f62880b = mode;
                this.f62881c = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f62882d;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f62884g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f62882d;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f62882d.f62886a = getChangingConfigurations();
        return this.f62882d;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f62884g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f62884g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f62884g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(23)
    public int getLayoutDirection() {
        return a.f(this.f62884g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f62884g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f62884g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f62884g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f62884g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public int[] getState() {
        return this.f62884g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f62884g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.h(this.f62884g);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.f62882d) == null) ? null : fVar.f62888c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f62884g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f62884g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f62883f && super.mutate() == this) {
            this.f62882d = d();
            Drawable drawable = this.f62884g;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f62882d;
            if (fVar != null) {
                Drawable drawable2 = this.f62884g;
                fVar.f62887b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f62883f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f62884g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(23)
    public boolean onLayoutDirectionChanged(int i11) {
        return a.m(this.f62884g, i11);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i11) {
        return this.f62884g.setLevel(i11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
        scheduleSelf(runnable, j11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f62884g.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z11) {
        a.j(this.f62884g, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i11) {
        this.f62884g.setChangingConfigurations(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f62884g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z11) {
        this.f62884g.setDither(z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z11) {
        this.f62884g.setFilterBitmap(z11);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        return f(iArr) || this.f62884g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f62882d.f62888c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f62882d.f62889d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        return super.setVisible(z11, z12) || this.f62884g.setVisible(z11, z12);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
