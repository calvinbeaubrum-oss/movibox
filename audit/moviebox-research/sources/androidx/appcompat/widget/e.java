package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CompoundButton f1636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f1637b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1638c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1639d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1640e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1641f;

    public e(@NonNull CompoundButton compoundButton) {
        this.f1636a = compoundButton;
    }

    public void a() {
        Drawable drawableA = androidx.core.widget.b.a(this.f1636a);
        if (drawableA != null) {
            if (this.f1639d || this.f1640e) {
                Drawable drawableMutate = d3.a.r(drawableA).mutate();
                if (this.f1639d) {
                    d3.a.o(drawableMutate, this.f1637b);
                }
                if (this.f1640e) {
                    d3.a.p(drawableMutate, this.f1638c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1636a.getDrawableState());
                }
                this.f1636a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList b() {
        return this.f1637b;
    }

    public PorterDuff.Mode c() {
        return this.f1638c;
    }

    public void d(@Nullable AttributeSet attributeSet, int i11) {
        int iN;
        int iN2;
        n0 n0VarV = n0.v(this.f1636a.getContext(), attributeSet, R$styleable.CompoundButton, i11, 0);
        CompoundButton compoundButton = this.f1636a;
        ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), R$styleable.CompoundButton, attributeSet, n0VarV.r(), i11, 0);
        try {
            if (n0VarV.s(R$styleable.CompoundButton_buttonCompat) && (iN2 = n0VarV.n(R$styleable.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f1636a;
                    compoundButton2.setButtonDrawable(d1.a.b(compoundButton2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    if (n0VarV.s(R$styleable.CompoundButton_android_button)) {
                        CompoundButton compoundButton3 = this.f1636a;
                        compoundButton3.setButtonDrawable(d1.a.b(compoundButton3.getContext(), iN));
                    }
                }
            } else if (n0VarV.s(R$styleable.CompoundButton_android_button) && (iN = n0VarV.n(R$styleable.CompoundButton_android_button, 0)) != 0) {
                CompoundButton compoundButton4 = this.f1636a;
                compoundButton4.setButtonDrawable(d1.a.b(compoundButton4.getContext(), iN));
            }
            if (n0VarV.s(R$styleable.CompoundButton_buttonTint)) {
                androidx.core.widget.b.d(this.f1636a, n0VarV.c(R$styleable.CompoundButton_buttonTint));
            }
            if (n0VarV.s(R$styleable.CompoundButton_buttonTintMode)) {
                androidx.core.widget.b.e(this.f1636a, b0.e(n0VarV.k(R$styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            n0VarV.x();
        }
    }

    public void e() {
        if (this.f1641f) {
            this.f1641f = false;
        } else {
            this.f1641f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.f1637b = colorStateList;
        this.f1639d = true;
        a();
    }

    public void g(@Nullable PorterDuff.Mode mode) {
        this.f1638c = mode;
        this.f1640e = true;
        a();
    }
}
