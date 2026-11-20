package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class h extends yi.i {

    @NonNull
    public b A;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends yi.i.c {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @NonNull
        public final RectF f37752w;

        public b(@NonNull b bVar) {
            super(bVar);
            this.f37752w = bVar.f37752w;
        }

        public b(@NonNull yi.n nVar, @NonNull RectF rectF) {
            super(nVar, null);
            this.f37752w = rectF;
        }

        @Override // yi.i.c, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            h hVarT0 = h.t0(this);
            hVarT0.invalidateSelf();
            return hVarT0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @TargetApi(18)
    public static class c extends h {
        public c(@NonNull b bVar) {
            super(bVar);
        }

        @Override // yi.i
        public void t(@NonNull Canvas canvas) {
            if (this.A.f37752w.isEmpty()) {
                super.t(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.A.f37752w);
            } else {
                canvas.clipRect(this.A.f37752w, Region.Op.DIFFERENCE);
            }
            super.t(canvas);
            canvas.restore();
        }
    }

    public h(@NonNull b bVar) {
        super(bVar);
        this.A = bVar;
    }

    public static h t0(@NonNull b bVar) {
        return new c(bVar);
    }

    public static h u0(@Nullable yi.n nVar) {
        if (nVar == null) {
            nVar = new yi.n();
        }
        return t0(new b(nVar, new RectF()));
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.A = new b(this.A);
        return this;
    }

    public boolean v0() {
        return !this.A.f37752w.isEmpty();
    }

    public void w0() {
        x0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void x0(float f11, float f12, float f13, float f14) {
        if (f11 == this.A.f37752w.left && f12 == this.A.f37752w.top && f13 == this.A.f37752w.right && f14 == this.A.f37752w.bottom) {
            return;
        }
        this.A.f37752w.set(f11, f12, f13, f14);
        invalidateSelf();
    }

    public void y0(@NonNull RectF rectF) {
        x0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
