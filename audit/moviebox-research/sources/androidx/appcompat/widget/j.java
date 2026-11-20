package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f1703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0 f1704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f1705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f1706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1707e = 0;

    public j(@NonNull ImageView imageView) {
        this.f1703a = imageView;
    }

    public final boolean a(@NonNull Drawable drawable) {
        if (this.f1706d == null) {
            this.f1706d = new l0();
        }
        l0 l0Var = this.f1706d;
        l0Var.a();
        ColorStateList colorStateListA = androidx.core.widget.h.a(this.f1703a);
        if (colorStateListA != null) {
            l0Var.f1720d = true;
            l0Var.f1717a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.h.b(this.f1703a);
        if (modeB != null) {
            l0Var.f1719c = true;
            l0Var.f1718b = modeB;
        }
        if (!l0Var.f1720d && !l0Var.f1719c) {
            return false;
        }
        f.i(drawable, l0Var, this.f1703a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f1703a.getDrawable() != null) {
            this.f1703a.getDrawable().setLevel(this.f1707e);
        }
    }

    public void c() {
        Drawable drawable = this.f1703a.getDrawable();
        if (drawable != null) {
            b0.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            l0 l0Var = this.f1705c;
            if (l0Var != null) {
                f.i(drawable, l0Var, this.f1703a.getDrawableState());
                return;
            }
            l0 l0Var2 = this.f1704b;
            if (l0Var2 != null) {
                f.i(drawable, l0Var2, this.f1703a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        l0 l0Var = this.f1705c;
        if (l0Var != null) {
            return l0Var.f1717a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        l0 l0Var = this.f1705c;
        if (l0Var != null) {
            return l0Var.f1718b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f1703a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i11) {
        int iN;
        n0 n0VarV = n0.v(this.f1703a.getContext(), attributeSet, R$styleable.AppCompatImageView, i11, 0);
        ImageView imageView = this.f1703a;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), R$styleable.AppCompatImageView, attributeSet, n0VarV.r(), i11, 0);
        try {
            Drawable drawable = this.f1703a.getDrawable();
            if (drawable == null && (iN = n0VarV.n(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = d1.a.b(this.f1703a.getContext(), iN)) != null) {
                this.f1703a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                b0.b(drawable);
            }
            if (n0VarV.s(R$styleable.AppCompatImageView_tint)) {
                androidx.core.widget.h.c(this.f1703a, n0VarV.c(R$styleable.AppCompatImageView_tint));
            }
            if (n0VarV.s(R$styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.h.d(this.f1703a, b0.e(n0VarV.k(R$styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            n0VarV.x();
        }
    }

    public void h(@NonNull Drawable drawable) {
        this.f1707e = drawable.getLevel();
    }

    public void i(int i11) {
        if (i11 != 0) {
            Drawable drawableB = d1.a.b(this.f1703a.getContext(), i11);
            if (drawableB != null) {
                b0.b(drawableB);
            }
            this.f1703a.setImageDrawable(drawableB);
        } else {
            this.f1703a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f1705c == null) {
            this.f1705c = new l0();
        }
        l0 l0Var = this.f1705c;
        l0Var.f1717a = colorStateList;
        l0Var.f1720d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f1705c == null) {
            this.f1705c = new l0();
        }
        l0 l0Var = this.f1705c;
        l0Var.f1718b = mode;
        l0Var.f1719c = true;
        c();
    }

    public final boolean l() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 21) {
            return this.f1704b != null;
        }
        return i11 == 21;
    }
}
