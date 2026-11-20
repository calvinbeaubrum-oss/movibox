package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.y;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import vi.d;
import vi.e;
import yi.i;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BadgeDrawable extends Drawable implements y.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f36194o = R$style.Widget_MaterialComponents_Badge;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f36195p = R$attr.badgeStyle;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WeakReference<Context> f36196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final i f36197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final y f36198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Rect f36199d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final BadgeState f36200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f36201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f36202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f36204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f36205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f36206l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public WeakReference<View> f36207m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public WeakReference<FrameLayout> f36208n;

    public BadgeDrawable(@NonNull Context context, int i11, int i12, int i13, @Nullable BadgeState.State state) {
        this.f36196a = new WeakReference<>(context);
        b0.c(context);
        this.f36199d = new Rect();
        y yVar = new y(this);
        this.f36198c = yVar;
        yVar.g().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i11, i12, i13, state);
        this.f36200f = badgeState;
        this.f36197b = new i(n.b(context, A() ? badgeState.m() : badgeState.i(), A() ? badgeState.l() : badgeState.h()).m());
        N();
    }

    public static void R(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    @NonNull
    public static BadgeDrawable d(@NonNull Context context) {
        return new BadgeDrawable(context, 0, f36195p, f36194o, null);
    }

    @NonNull
    public static BadgeDrawable e(@NonNull Context context, @NonNull BadgeState.State state) {
        return new BadgeDrawable(context, 0, f36195p, f36194o, state);
    }

    public final boolean A() {
        return C() || B();
    }

    public boolean B() {
        return !this.f36200f.E() && this.f36200f.D();
    }

    public boolean C() {
        return this.f36200f.E();
    }

    public final boolean D() {
        FrameLayout frameLayoutJ = j();
        return frameLayoutJ != null && frameLayoutJ.getId() == R$id.mtrl_anchor_parent;
    }

    public final void E() {
        this.f36198c.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    public final void F() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.f36200f.e());
        if (this.f36197b.z() != colorStateListValueOf) {
            this.f36197b.d0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public final void G() {
        this.f36198c.l(true);
        I();
        T();
        invalidateSelf();
    }

    public final void H() {
        WeakReference<View> weakReference = this.f36207m;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.f36207m.get();
        WeakReference<FrameLayout> weakReference2 = this.f36208n;
        S(view, weakReference2 != null ? weakReference2.get() : null);
    }

    public final void I() {
        Context context = this.f36196a.get();
        if (context == null) {
            return;
        }
        this.f36197b.setShapeAppearanceModel(n.b(context, A() ? this.f36200f.m() : this.f36200f.i(), A() ? this.f36200f.l() : this.f36200f.h()).m());
        invalidateSelf();
    }

    public final void J() {
        e eVar;
        Context context = this.f36196a.get();
        if (context == null || this.f36198c.e() == (eVar = new e(context, this.f36200f.A()))) {
            return;
        }
        this.f36198c.k(eVar, context);
        K();
        T();
        invalidateSelf();
    }

    public final void K() {
        this.f36198c.g().setColor(this.f36200f.j());
        invalidateSelf();
    }

    public final void L() {
        U();
        this.f36198c.l(true);
        T();
        invalidateSelf();
    }

    public final void M() {
        boolean zG = this.f36200f.G();
        setVisible(zG, false);
        if (!c.f36220a || j() == null || zG) {
            return;
        }
        ((ViewGroup) j().getParent()).invalidate();
    }

    public final void N() {
        I();
        J();
        L();
        G();
        E();
        F();
        K();
        H();
        T();
        M();
    }

    public void O(int i11) {
        this.f36200f.I(i11);
        T();
    }

    public void P(int i11) {
        this.f36200f.J(i11);
        T();
    }

    public final void Q(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f36208n;
            if (weakReference == null || weakReference.get() != viewGroup) {
                R(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R$id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.f36208n = new WeakReference<>(frameLayout);
                frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BadgeDrawable.this.S(view, frameLayout);
                    }
                });
            }
        }
    }

    public void S(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.f36207m = new WeakReference<>(view);
        boolean z11 = c.f36220a;
        if (z11 && frameLayout == null) {
            Q(view);
        } else {
            this.f36208n = new WeakReference<>(frameLayout);
        }
        if (!z11) {
            R(view);
        }
        T();
        invalidateSelf();
    }

    public final void T() {
        Context context = this.f36196a.get();
        WeakReference<View> weakReference = this.f36207m;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f36199d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.f36208n;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || c.f36220a) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        c(rect2, view);
        c.i(this.f36199d, this.f36201g, this.f36202h, this.f36205k, this.f36206l);
        float f11 = this.f36204j;
        if (f11 != -1.0f) {
            this.f36197b.a0(f11);
        }
        if (rect.equals(this.f36199d)) {
            return;
        }
        this.f36197b.setBounds(this.f36199d);
    }

    public final void U() {
        if (n() != -2) {
            this.f36203i = ((int) Math.pow(10.0d, ((double) n()) - 1.0d)) - 1;
        } else {
            this.f36203i = o();
        }
    }

    @Override // com.google.android.material.internal.y.b
    public void a() {
        invalidateSelf();
    }

    public final void b(@NonNull View view) {
        float y11;
        float x11;
        View viewJ = j();
        if (viewJ == null) {
            if (!(view.getParent() instanceof View)) {
                return;
            }
            float y12 = view.getY();
            x11 = view.getX();
            viewJ = (View) view.getParent();
            y11 = y12;
        } else if (!D()) {
            y11 = 0.0f;
            x11 = 0.0f;
        } else {
            if (!(viewJ.getParent() instanceof View)) {
                return;
            }
            y11 = viewJ.getY();
            x11 = viewJ.getX();
            viewJ = (View) viewJ.getParent();
        }
        float fX = x(viewJ, y11);
        float fM = m(viewJ, x11);
        float fH = h(viewJ, y11);
        float fS = s(viewJ, x11);
        if (fX < 0.0f) {
            this.f36202h += Math.abs(fX);
        }
        if (fM < 0.0f) {
            this.f36201g += Math.abs(fM);
        }
        if (fH > 0.0f) {
            this.f36202h -= Math.abs(fH);
        }
        if (fS > 0.0f) {
            this.f36201g -= Math.abs(fS);
        }
    }

    public final void c(@NonNull Rect rect, @NonNull View view) {
        float f11 = A() ? this.f36200f.f36212d : this.f36200f.f36211c;
        this.f36204j = f11;
        if (f11 != -1.0f) {
            this.f36205k = f11;
            this.f36206l = f11;
        } else {
            this.f36205k = Math.round((A() ? this.f36200f.f36215g : this.f36200f.f36213e) / 2.0f);
            this.f36206l = Math.round((A() ? this.f36200f.f36216h : this.f36200f.f36214f) / 2.0f);
        }
        if (A()) {
            String strG = g();
            this.f36205k = Math.max(this.f36205k, (this.f36198c.h(strG) / 2.0f) + this.f36200f.g());
            float fMax = Math.max(this.f36206l, (this.f36198c.f(strG) / 2.0f) + this.f36200f.k());
            this.f36206l = fMax;
            this.f36205k = Math.max(this.f36205k, fMax);
        }
        int iZ = z();
        int iF = this.f36200f.f();
        if (iF == 8388691 || iF == 8388693) {
            this.f36202h = rect.bottom - iZ;
        } else {
            this.f36202h = rect.top + iZ;
        }
        int iY = y();
        int iF2 = this.f36200f.f();
        if (iF2 == 8388659 || iF2 == 8388691) {
            this.f36201g = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.f36205k) + iY : (rect.right + this.f36205k) - iY;
        } else {
            this.f36201g = ViewCompat.getLayoutDirection(view) == 0 ? (rect.right + this.f36205k) - iY : (rect.left - this.f36205k) + iY;
        }
        if (this.f36200f.F()) {
            b(view);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f36197b.draw(canvas);
        if (A()) {
            f(canvas);
        }
    }

    public final void f(Canvas canvas) {
        String strG = g();
        if (strG != null) {
            Rect rect = new Rect();
            this.f36198c.g().getTextBounds(strG, 0, strG.length(), rect);
            float fExactCenterY = this.f36202h - rect.exactCenterY();
            canvas.drawText(strG, this.f36201g, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), this.f36198c.g());
        }
    }

    @Nullable
    public final String g() {
        if (C()) {
            return v();
        }
        if (B()) {
            return q();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f36200f.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f36199d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f36199d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final float h(View view, float f11) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f36202h + this.f36206l) - (((View) view.getParent()).getHeight() - view.getY())) + f11;
    }

    @Nullable
    public CharSequence i() {
        if (!isVisible()) {
            return null;
        }
        if (C()) {
            return w();
        }
        return B() ? r() : k();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Nullable
    public FrameLayout j() {
        WeakReference<FrameLayout> weakReference = this.f36208n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final CharSequence k() {
        return this.f36200f.p();
    }

    public int l() {
        return this.f36200f.s();
    }

    public final float m(View view, float f11) {
        return (this.f36201g - this.f36205k) + view.getX() + f11;
    }

    public int n() {
        return this.f36200f.u();
    }

    public int o() {
        return this.f36200f.v();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.y.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public int p() {
        if (this.f36200f.D()) {
            return this.f36200f.w();
        }
        return 0;
    }

    @NonNull
    public final String q() {
        if (this.f36203i == -2 || p() <= this.f36203i) {
            return NumberFormat.getInstance(this.f36200f.x()).format(p());
        }
        Context context = this.f36196a.get();
        return context == null ? "" : String.format(this.f36200f.x(), context.getString(R$string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f36203i), "+");
    }

    @Nullable
    public final String r() {
        Context context;
        if (this.f36200f.q() == 0 || (context = this.f36196a.get()) == null) {
            return null;
        }
        return (this.f36203i == -2 || p() <= this.f36203i) ? context.getResources().getQuantityString(this.f36200f.q(), p(), Integer.valueOf(p())) : context.getString(this.f36200f.n(), Integer.valueOf(this.f36203i));
    }

    public final float s(View view, float f11) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f36201g + this.f36205k) - (((View) view.getParent()).getWidth() - view.getX())) + f11;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f36200f.K(i11);
        E();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @NonNull
    public BadgeState.State t() {
        return this.f36200f.y();
    }

    @Nullable
    public String u() {
        return this.f36200f.z();
    }

    @Nullable
    public final String v() {
        String strU = u();
        int iN = n();
        if (iN == -2 || strU == null || strU.length() <= iN) {
            return strU;
        }
        Context context = this.f36196a.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(R$string.m3_exceed_max_badge_text_suffix), strU.substring(0, iN - 1), "…");
    }

    @Nullable
    public final CharSequence w() {
        CharSequence charSequenceO = this.f36200f.o();
        return charSequenceO != null ? charSequenceO : u();
    }

    public final float x(View view, float f11) {
        return (this.f36202h - this.f36206l) + view.getY() + f11;
    }

    public final int y() {
        int iR = A() ? this.f36200f.r() : this.f36200f.s();
        if (this.f36200f.f36219k == 1) {
            iR += A() ? this.f36200f.f36218j : this.f36200f.f36217i;
        }
        return iR + this.f36200f.b();
    }

    public final int z() {
        int iC = this.f36200f.C();
        if (A()) {
            iC = this.f36200f.B();
            Context context = this.f36196a.get();
            if (context != null) {
                iC = ii.b.c(iC, iC - this.f36200f.t(), ii.b.b(0.0f, 1.0f, 0.3f, 1.0f, d.f(context) - 1.0f));
            }
        }
        if (this.f36200f.f36219k == 0) {
            iC -= Math.round(this.f36206l);
        }
        return iC + this.f36200f.c();
    }
}
