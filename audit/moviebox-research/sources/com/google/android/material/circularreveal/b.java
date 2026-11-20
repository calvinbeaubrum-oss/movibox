package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f36611j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f36612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f36613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Path f36614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Paint f36615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final Paint f36616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public c.e f36617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Drawable f36618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36620i;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f36612a = aVar;
        View view = (View) aVar;
        this.f36613b = view;
        view.setWillNotDraw(false);
        this.f36614c = new Path();
        this.f36615d = new Paint(7);
        Paint paint = new Paint(1);
        this.f36616e = paint;
        paint.setColor(0);
    }

    public void a() {
        if (f36611j == 0) {
            this.f36619h = true;
            this.f36620i = false;
            this.f36613b.buildDrawingCache();
            Bitmap drawingCache = this.f36613b.getDrawingCache();
            if (drawingCache == null && this.f36613b.getWidth() != 0 && this.f36613b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f36613b.getWidth(), this.f36613b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f36613b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f36615d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f36619h = false;
            this.f36620i = true;
        }
    }

    public void b() {
        if (f36611j == 0) {
            this.f36620i = false;
            this.f36613b.destroyDrawingCache();
            this.f36615d.setShader(null);
            this.f36613b.invalidate();
        }
    }

    public void c(@NonNull Canvas canvas) {
        if (n()) {
            int i11 = f36611j;
            if (i11 == 0) {
                c.e eVar = this.f36617f;
                canvas.drawCircle(eVar.f36625a, eVar.f36626b, eVar.f36627c, this.f36615d);
                if (p()) {
                    c.e eVar2 = this.f36617f;
                    canvas.drawCircle(eVar2.f36625a, eVar2.f36626b, eVar2.f36627c, this.f36616e);
                }
            } else if (i11 == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.f36614c);
                this.f36612a.actualDraw(canvas);
                if (p()) {
                    canvas.drawRect(0.0f, 0.0f, this.f36613b.getWidth(), this.f36613b.getHeight(), this.f36616e);
                }
                canvas.restoreToCount(iSave);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i11);
                }
                this.f36612a.actualDraw(canvas);
                if (p()) {
                    canvas.drawRect(0.0f, 0.0f, this.f36613b.getWidth(), this.f36613b.getHeight(), this.f36616e);
                }
            }
        } else {
            this.f36612a.actualDraw(canvas);
            if (p()) {
                canvas.drawRect(0.0f, 0.0f, this.f36613b.getWidth(), this.f36613b.getHeight(), this.f36616e);
            }
        }
        d(canvas);
    }

    public final void d(@NonNull Canvas canvas) {
        if (o()) {
            Rect bounds = this.f36618g.getBounds();
            float fWidth = this.f36617f.f36625a - (bounds.width() / 2.0f);
            float fHeight = this.f36617f.f36626b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f36618g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    @Nullable
    public Drawable e() {
        return this.f36618g;
    }

    public int f() {
        return this.f36616e.getColor();
    }

    public final float g(@NonNull c.e eVar) {
        return si.a.b(eVar.f36625a, eVar.f36626b, 0.0f, 0.0f, this.f36613b.getWidth(), this.f36613b.getHeight());
    }

    @Nullable
    public c.e h() {
        c.e eVar = this.f36617f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f36627c = g(eVar2);
        }
        return eVar2;
    }

    public final void i() {
        if (f36611j == 1) {
            this.f36614c.rewind();
            c.e eVar = this.f36617f;
            if (eVar != null) {
                this.f36614c.addCircle(eVar.f36625a, eVar.f36626b, eVar.f36627c, Path.Direction.CW);
            }
        }
        this.f36613b.invalidate();
    }

    public boolean j() {
        return this.f36612a.actualIsOpaque() && !n();
    }

    public void k(@Nullable Drawable drawable) {
        this.f36618g = drawable;
        this.f36613b.invalidate();
    }

    public void l(int i11) {
        this.f36616e.setColor(i11);
        this.f36613b.invalidate();
    }

    public void m(@Nullable c.e eVar) {
        if (eVar == null) {
            this.f36617f = null;
        } else {
            c.e eVar2 = this.f36617f;
            if (eVar2 == null) {
                this.f36617f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (si.a.c(eVar.f36627c, g(eVar), 1.0E-4f)) {
                this.f36617f.f36627c = Float.MAX_VALUE;
            }
        }
        i();
    }

    public final boolean n() {
        c.e eVar = this.f36617f;
        boolean z11 = eVar == null || eVar.a();
        if (f36611j == 0) {
            return !z11 && this.f36620i;
        }
        return !z11;
    }

    public final boolean o() {
        return (this.f36619h || this.f36618g == null || this.f36617f == null) ? false : true;
    }

    public final boolean p() {
        return (this.f36619h || Color.alpha(this.f36616e.getColor()) == 0) ? false : true;
    }
}
