package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.progressindicator.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f<S extends b> extends g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final androidx.dynamicanimation.animation.c<f<?>> f37281v = new a("indicatorLevel");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h<S> f37282q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.e f37283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.d f37284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h.a f37285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f37286u;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.dynamicanimation.animation.c<f<?>> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(f<?> fVar) {
            return fVar.y() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f<?> fVar, float f11) {
            fVar.A(f11 / 10000.0f);
        }
    }

    public f(@NonNull Context context, @NonNull b bVar, @NonNull h<S> hVar) {
        super(context, bVar);
        this.f37286u = false;
        z(hVar);
        this.f37285t = new h.a();
        androidx.dynamicanimation.animation.e eVar = new androidx.dynamicanimation.animation.e();
        this.f37283r = eVar;
        eVar.d(1.0f);
        eVar.f(50.0f);
        androidx.dynamicanimation.animation.d dVar = new androidx.dynamicanimation.animation.d(this, f37281v);
        this.f37284s = dVar;
        dVar.q(eVar);
        n(1.0f);
    }

    @NonNull
    public static f<e> v(@NonNull Context context, @NonNull e eVar, @NonNull c cVar) {
        return new f<>(context, eVar, cVar);
    }

    @NonNull
    public static f<n> w(@NonNull Context context, @NonNull n nVar, @NonNull k kVar) {
        return new f<>(context, nVar, kVar);
    }

    public final void A(float f11) {
        this.f37285t.f37306b = f11;
        invalidateSelf();
    }

    public void B(float f11) {
        setLevel((int) (f11 * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f37282q.g(canvas, getBounds(), h(), k(), j());
            this.f37300n.setStyle(Paint.Style.FILL);
            this.f37300n.setAntiAlias(true);
            h.a aVar = this.f37285t;
            b bVar = this.f37289b;
            aVar.f37307c = bVar.f37253c[0];
            int iA = bVar.f37257g;
            if (iA > 0) {
                if (!(this.f37282q instanceof k)) {
                    iA = (int) ((iA * g3.a.a(y(), 0.0f, 0.01f)) / 0.01f);
                }
                this.f37282q.d(canvas, this.f37300n, y(), 1.0f, this.f37289b.f37254d, getAlpha(), iA);
            } else {
                this.f37282q.d(canvas, this.f37300n, 0.0f, 1.0f, bVar.f37254d, getAlpha(), 0);
            }
            this.f37282q.c(canvas, this.f37300n, this.f37285t, getAlpha());
            this.f37282q.b(canvas, this.f37300n, this.f37289b.f37253c[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f37282q.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f37282q.f();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f37284s.r();
        A(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ void m(@NonNull l6.b bVar) {
        super.m(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i11) {
        if (this.f37286u) {
            this.f37284s.r();
            A(i11 / 10000.0f);
            return true;
        }
        this.f37284s.h(y() * 10000.0f);
        this.f37284s.l(i11);
        return true;
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean q(boolean z11, boolean z12, boolean z13) {
        return super.q(z11, z12, z13);
    }

    @Override // com.google.android.material.progressindicator.g
    public boolean r(boolean z11, boolean z12, boolean z13) {
        boolean zR = super.r(z11, z12, z13);
        float fA = this.f37290c.a(this.f37288a.getContentResolver());
        if (fA == 0.0f) {
            this.f37286u = true;
        } else {
            this.f37286u = false;
            this.f37283r.f(50.0f / fA);
        }
        return zR;
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean s(@NonNull l6.b bVar) {
        return super.s(bVar);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i11) {
        super.setAlpha(i11);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z11, boolean z12) {
        return super.setVisible(z11, z12);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @NonNull
    public h<S> x() {
        return this.f37282q;
    }

    public final float y() {
        return this.f37285t.f37306b;
    }

    public void z(@NonNull h<S> hVar) {
        this.f37282q = hVar;
    }
}
