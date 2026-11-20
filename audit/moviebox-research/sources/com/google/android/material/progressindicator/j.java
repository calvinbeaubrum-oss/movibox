package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$drawable;
import com.google.android.material.progressindicator.b;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j<S extends b> extends g {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h<S> f37311q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i<ObjectAnimator> f37312r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f37313s;

    public j(@NonNull Context context, @NonNull b bVar, @NonNull h<S> hVar, @NonNull i<ObjectAnimator> iVar) {
        super(context, bVar);
        z(hVar);
        y(iVar);
    }

    @NonNull
    public static j<e> t(@NonNull Context context, @NonNull e eVar, @NonNull c cVar) {
        j<e> jVar = new j<>(context, eVar, cVar, new d(eVar));
        jVar.A(l6.j.b(context.getResources(), R$drawable.indeterminate_static, null));
        return jVar;
    }

    @NonNull
    public static j<n> u(@NonNull Context context, @NonNull n nVar, @NonNull k kVar) {
        return new j<>(context, nVar, kVar, nVar.f37340h == 0 ? new l(nVar) : new m(context, nVar));
    }

    public void A(@Nullable Drawable drawable) {
        this.f37313s = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            if (x() && (drawable = this.f37313s) != null) {
                drawable.setBounds(getBounds());
                d3.a.n(this.f37313s, this.f37289b.f37253c[0]);
                this.f37313s.draw(canvas);
                return;
            }
            canvas.save();
            this.f37311q.g(canvas, getBounds(), h(), k(), j());
            int i11 = this.f37289b.f37257g;
            int alpha = getAlpha();
            if (i11 == 0) {
                this.f37311q.d(canvas, this.f37300n, 0.0f, 1.0f, this.f37289b.f37254d, alpha, 0);
            } else {
                h.a aVar = this.f37312r.f37310b.get(0);
                List<h.a> list = this.f37312r.f37310b;
                h.a aVar2 = list.get(list.size() - 1);
                h<S> hVar = this.f37311q;
                if (hVar instanceof k) {
                    hVar.d(canvas, this.f37300n, 0.0f, aVar.f37305a, this.f37289b.f37254d, alpha, i11);
                    this.f37311q.d(canvas, this.f37300n, aVar2.f37306b, 1.0f, this.f37289b.f37254d, alpha, i11);
                } else {
                    alpha = 0;
                    hVar.d(canvas, this.f37300n, aVar2.f37306b, 1.0f + aVar.f37305a, this.f37289b.f37254d, 0, i11);
                }
            }
            for (int i12 = 0; i12 < this.f37312r.f37310b.size(); i12++) {
                h.a aVar3 = this.f37312r.f37310b.get(i12);
                this.f37311q.c(canvas, this.f37300n, aVar3, getAlpha());
                if (i12 > 0 && i11 > 0) {
                    this.f37311q.d(canvas, this.f37300n, this.f37312r.f37310b.get(i12 - 1).f37306b, aVar3.f37305a, this.f37289b.f37254d, alpha, i11);
                }
            }
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f37311q.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f37311q.f();
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

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ void m(@NonNull l6.b bVar) {
        super.m(bVar);
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean q(boolean z11, boolean z12, boolean z13) {
        return super.q(z11, z12, z13);
    }

    @Override // com.google.android.material.progressindicator.g
    public boolean r(boolean z11, boolean z12, boolean z13) {
        Drawable drawable;
        boolean zR = super.r(z11, z12, z13);
        if (x() && (drawable = this.f37313s) != null) {
            return drawable.setVisible(z11, z12);
        }
        if (!isRunning()) {
            this.f37312r.a();
        }
        if (z11 && (z13 || (Build.VERSION.SDK_INT <= 22 && !x()))) {
            this.f37312r.g();
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
    public i<ObjectAnimator> v() {
        return this.f37312r;
    }

    @NonNull
    public h<S> w() {
        return this.f37311q;
    }

    public final boolean x() {
        a aVar = this.f37290c;
        return aVar != null && aVar.a(this.f37288a.getContentResolver()) == 0.0f;
    }

    public void y(@NonNull i<ObjectAnimator> iVar) {
        this.f37312r = iVar;
        iVar.e(this);
    }

    public void z(@NonNull h<S> hVar) {
        this.f37311q = hVar;
    }
}
