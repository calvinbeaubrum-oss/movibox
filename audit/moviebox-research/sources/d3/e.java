package d3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class e extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Method f62885i;

    public e(Drawable drawable) {
        super(drawable);
        g();
    }

    public e(f fVar, Resources resources) {
        super(fVar, resources);
        g();
    }

    @Override // d3.d
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f62884g;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final void g() {
        if (f62885i == null) {
            try {
                f62885i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e11) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e11);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Rect getDirtyBounds() {
        return this.f62884g.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        this.f62884g.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f62884g;
        if (drawable != null && (method = f62885i) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e11) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e11);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f11, float f12) {
        this.f62884g.setHotspot(f11, f12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        this.f62884g.setHotspotBounds(i11, i12, i13, i14);
    }

    @Override // d3.d, android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // d3.d, android.graphics.drawable.Drawable
    public void setTint(int i11) {
        if (c()) {
            super.setTint(i11);
        } else {
            this.f62884g.setTint(i11);
        }
    }

    @Override // d3.d, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f62884g.setTintList(colorStateList);
        }
    }

    @Override // d3.d, android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f62884g.setTintMode(mode);
        }
    }
}
