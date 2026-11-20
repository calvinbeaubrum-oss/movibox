package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f1624a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f1627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l0 f1628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l0 f1629f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1626c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1625b = f.b();

    public c(@NonNull View view) {
        this.f1624a = view;
    }

    public final boolean a(@NonNull Drawable drawable) {
        if (this.f1629f == null) {
            this.f1629f = new l0();
        }
        l0 l0Var = this.f1629f;
        l0Var.a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f1624a);
        if (backgroundTintList != null) {
            l0Var.f1720d = true;
            l0Var.f1717a = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f1624a);
        if (backgroundTintMode != null) {
            l0Var.f1719c = true;
            l0Var.f1718b = backgroundTintMode;
        }
        if (!l0Var.f1720d && !l0Var.f1719c) {
            return false;
        }
        f.i(drawable, l0Var, this.f1624a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f1624a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            l0 l0Var = this.f1628e;
            if (l0Var != null) {
                f.i(background, l0Var, this.f1624a.getDrawableState());
                return;
            }
            l0 l0Var2 = this.f1627d;
            if (l0Var2 != null) {
                f.i(background, l0Var2, this.f1624a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        l0 l0Var = this.f1628e;
        if (l0Var != null) {
            return l0Var.f1717a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        l0 l0Var = this.f1628e;
        if (l0Var != null) {
            return l0Var.f1718b;
        }
        return null;
    }

    public void e(@Nullable AttributeSet attributeSet, int i11) {
        n0 n0VarV = n0.v(this.f1624a.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i11, 0);
        View view = this.f1624a;
        ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), R$styleable.ViewBackgroundHelper, attributeSet, n0VarV.r(), i11, 0);
        try {
            if (n0VarV.s(R$styleable.ViewBackgroundHelper_android_background)) {
                this.f1626c = n0VarV.n(R$styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListF = this.f1625b.f(this.f1624a.getContext(), this.f1626c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (n0VarV.s(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f1624a, n0VarV.c(R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (n0VarV.s(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f1624a, b0.e(n0VarV.k(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            n0VarV.x();
        }
    }

    public void f(Drawable drawable) {
        this.f1626c = -1;
        h(null);
        b();
    }

    public void g(int i11) {
        this.f1626c = i11;
        f fVar = this.f1625b;
        h(fVar != null ? fVar.f(this.f1624a.getContext(), i11) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1627d == null) {
                this.f1627d = new l0();
            }
            l0 l0Var = this.f1627d;
            l0Var.f1717a = colorStateList;
            l0Var.f1720d = true;
        } else {
            this.f1627d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f1628e == null) {
            this.f1628e = new l0();
        }
        l0 l0Var = this.f1628e;
        l0Var.f1717a = colorStateList;
        l0Var.f1720d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f1628e == null) {
            this.f1628e = new l0();
        }
        l0 l0Var = this.f1628e;
        l0Var.f1718b = mode;
        l0Var.f1719c = true;
        b();
    }

    public final boolean k() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 21) {
            return this.f1627d != null;
        }
        return i11 == 21;
    }
}
