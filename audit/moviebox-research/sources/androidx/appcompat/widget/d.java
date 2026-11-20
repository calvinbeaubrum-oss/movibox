package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckedTextView f1630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f1631b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1632c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1633d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1634e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1635f;

    public d(@NonNull CheckedTextView checkedTextView) {
        this.f1630a = checkedTextView;
    }

    public void a() {
        Drawable drawableA = androidx.core.widget.a.a(this.f1630a);
        if (drawableA != null) {
            if (this.f1633d || this.f1634e) {
                Drawable drawableMutate = d3.a.r(drawableA).mutate();
                if (this.f1633d) {
                    d3.a.o(drawableMutate, this.f1631b);
                }
                if (this.f1634e) {
                    d3.a.p(drawableMutate, this.f1632c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1630a.getDrawableState());
                }
                this.f1630a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList b() {
        return this.f1631b;
    }

    public PorterDuff.Mode c() {
        return this.f1632c;
    }

    public void d(@Nullable AttributeSet attributeSet, int i11) {
        int iN;
        int iN2;
        n0 n0VarV = n0.v(this.f1630a.getContext(), attributeSet, R$styleable.CheckedTextView, i11, 0);
        CheckedTextView checkedTextView = this.f1630a;
        ViewCompat.saveAttributeDataForStyleable(checkedTextView, checkedTextView.getContext(), R$styleable.CheckedTextView, attributeSet, n0VarV.r(), i11, 0);
        try {
            if (n0VarV.s(R$styleable.CheckedTextView_checkMarkCompat) && (iN2 = n0VarV.n(R$styleable.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.f1630a;
                    checkedTextView2.setCheckMarkDrawable(d1.a.b(checkedTextView2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    if (n0VarV.s(R$styleable.CheckedTextView_android_checkMark)) {
                        CheckedTextView checkedTextView3 = this.f1630a;
                        checkedTextView3.setCheckMarkDrawable(d1.a.b(checkedTextView3.getContext(), iN));
                    }
                }
            } else if (n0VarV.s(R$styleable.CheckedTextView_android_checkMark) && (iN = n0VarV.n(R$styleable.CheckedTextView_android_checkMark, 0)) != 0) {
                CheckedTextView checkedTextView4 = this.f1630a;
                checkedTextView4.setCheckMarkDrawable(d1.a.b(checkedTextView4.getContext(), iN));
            }
            if (n0VarV.s(R$styleable.CheckedTextView_checkMarkTint)) {
                androidx.core.widget.a.b(this.f1630a, n0VarV.c(R$styleable.CheckedTextView_checkMarkTint));
            }
            if (n0VarV.s(R$styleable.CheckedTextView_checkMarkTintMode)) {
                androidx.core.widget.a.c(this.f1630a, b0.e(n0VarV.k(R$styleable.CheckedTextView_checkMarkTintMode, -1), null));
            }
        } finally {
            n0VarV.x();
        }
    }

    public void e() {
        if (this.f1635f) {
            this.f1635f = false;
        } else {
            this.f1635f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.f1631b = colorStateList;
        this.f1633d = true;
        a();
    }

    public void g(@Nullable PorterDuff.Mode mode) {
        this.f1632c = mode;
        this.f1634e = true;
        a();
    }
}
