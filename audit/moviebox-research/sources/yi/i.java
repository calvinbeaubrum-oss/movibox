package yi;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import java.util.BitSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class i extends Drawable implements d3.b, q {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f81369y = "i";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Paint f81370z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f81371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.g[] f81372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.g[] f81373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f81374d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f81375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f81376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f81377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f81378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f81379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f81380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Region f81381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Region f81382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n f81383n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f81384o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f81385p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final xi.a f81386q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final o.b f81387r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o f81388s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public PorterDuffColorFilter f81389t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public PorterDuffColorFilter f81390u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f81391v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final RectF f81392w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f81393x;

    /* JADX INFO: compiled from: source.java */
    public class a implements o.b {
        public a() {
        }

        @Override // yi.o.b
        public void a(@NonNull p pVar, Matrix matrix, int i11) {
            i.this.f81374d.set(i11, pVar.e());
            i.this.f81372b[i11] = pVar.f(matrix);
        }

        @Override // yi.o.b
        public void b(@NonNull p pVar, Matrix matrix, int i11) {
            i.this.f81374d.set(i11 + 4, pVar.e());
            i.this.f81373c[i11] = pVar.f(matrix);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements n.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f81395a;

        public b(float f11) {
            this.f81395a = f11;
        }

        @Override // yi.n.c
        @NonNull
        public d a(@NonNull d dVar) {
            return dVar instanceof l ? dVar : new yi.b(this.f81395a, dVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public n f81397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public pi.a f81398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public ColorFilter f81399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public ColorStateList f81400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public ColorStateList f81401e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public ColorStateList f81402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public ColorStateList f81403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public PorterDuff.Mode f81404h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public Rect f81405i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f81406j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f81407k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f81408l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f81409m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f81410n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f81411o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f81412p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f81413q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f81414r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f81415s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f81416t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f81417u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f81418v;

        public c(@NonNull c cVar) {
            this.f81400d = null;
            this.f81401e = null;
            this.f81402f = null;
            this.f81403g = null;
            this.f81404h = PorterDuff.Mode.SRC_IN;
            this.f81405i = null;
            this.f81406j = 1.0f;
            this.f81407k = 1.0f;
            this.f81409m = 255;
            this.f81410n = 0.0f;
            this.f81411o = 0.0f;
            this.f81412p = 0.0f;
            this.f81413q = 0;
            this.f81414r = 0;
            this.f81415s = 0;
            this.f81416t = 0;
            this.f81417u = false;
            this.f81418v = Paint.Style.FILL_AND_STROKE;
            this.f81397a = cVar.f81397a;
            this.f81398b = cVar.f81398b;
            this.f81408l = cVar.f81408l;
            this.f81399c = cVar.f81399c;
            this.f81400d = cVar.f81400d;
            this.f81401e = cVar.f81401e;
            this.f81404h = cVar.f81404h;
            this.f81403g = cVar.f81403g;
            this.f81409m = cVar.f81409m;
            this.f81406j = cVar.f81406j;
            this.f81415s = cVar.f81415s;
            this.f81413q = cVar.f81413q;
            this.f81417u = cVar.f81417u;
            this.f81407k = cVar.f81407k;
            this.f81410n = cVar.f81410n;
            this.f81411o = cVar.f81411o;
            this.f81412p = cVar.f81412p;
            this.f81414r = cVar.f81414r;
            this.f81416t = cVar.f81416t;
            this.f81402f = cVar.f81402f;
            this.f81418v = cVar.f81418v;
            if (cVar.f81405i != null) {
                this.f81405i = new Rect(cVar.f81405i);
            }
        }

        public c(@NonNull n nVar, @Nullable pi.a aVar) {
            this.f81400d = null;
            this.f81401e = null;
            this.f81402f = null;
            this.f81403g = null;
            this.f81404h = PorterDuff.Mode.SRC_IN;
            this.f81405i = null;
            this.f81406j = 1.0f;
            this.f81407k = 1.0f;
            this.f81409m = 255;
            this.f81410n = 0.0f;
            this.f81411o = 0.0f;
            this.f81412p = 0.0f;
            this.f81413q = 0;
            this.f81414r = 0;
            this.f81415s = 0;
            this.f81416t = 0;
            this.f81417u = false;
            this.f81418v = Paint.Style.FILL_AND_STROKE;
            this.f81397a = nVar;
            this.f81398b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            i iVar = new i(this);
            iVar.f81375f = true;
            return iVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        f81370z = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public i() {
        this(new n());
    }

    public i(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        this(n.e(context, attributeSet, i11, i12).m());
    }

    public i(@NonNull c cVar) {
        this.f81372b = new p.g[4];
        this.f81373c = new p.g[4];
        this.f81374d = new BitSet(8);
        this.f81376g = new Matrix();
        this.f81377h = new Path();
        this.f81378i = new Path();
        this.f81379j = new RectF();
        this.f81380k = new RectF();
        this.f81381l = new Region();
        this.f81382m = new Region();
        Paint paint = new Paint(1);
        this.f81384o = paint;
        Paint paint2 = new Paint(1);
        this.f81385p = paint2;
        this.f81386q = new xi.a();
        this.f81388s = Looper.getMainLooper().getThread() == Thread.currentThread() ? o.k() : new o();
        this.f81392w = new RectF();
        this.f81393x = true;
        this.f81371a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        q0();
        p0(getState());
        this.f81387r = new a();
    }

    public i(@NonNull n nVar) {
        this(new c(nVar, null));
    }

    public static int X(int i11, int i12) {
        return (i11 * (i12 + (i12 >>> 7))) >>> 8;
    }

    @NonNull
    public static i m(Context context) {
        return n(context, 0.0f);
    }

    @NonNull
    public static i n(@NonNull Context context, float f11) {
        return o(context, f11, null);
    }

    @NonNull
    public static i o(@NonNull Context context, float f11, @Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(com.google.android.material.color.b.c(context, R$attr.colorSurface, i.class.getSimpleName()));
        }
        i iVar = new i();
        iVar.S(context);
        iVar.d0(colorStateList);
        iVar.c0(f11);
        return iVar;
    }

    public float A() {
        return this.f81371a.f81407k;
    }

    public float B() {
        return this.f81371a.f81410n;
    }

    public int C() {
        return this.f81391v;
    }

    public int D() {
        c cVar = this.f81371a;
        return (int) (((double) cVar.f81415s) * Math.sin(Math.toRadians(cVar.f81416t)));
    }

    public int E() {
        c cVar = this.f81371a;
        return (int) (((double) cVar.f81415s) * Math.cos(Math.toRadians(cVar.f81416t)));
    }

    public int F() {
        return this.f81371a.f81414r;
    }

    @NonNull
    public n G() {
        return this.f81371a.f81397a;
    }

    @Nullable
    public ColorStateList H() {
        return this.f81371a.f81401e;
    }

    public final float I() {
        if (R()) {
            return this.f81385p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float J() {
        return this.f81371a.f81408l;
    }

    @Nullable
    public ColorStateList K() {
        return this.f81371a.f81403g;
    }

    public float L() {
        return this.f81371a.f81397a.r().a(w());
    }

    public float M() {
        return this.f81371a.f81397a.t().a(w());
    }

    public float N() {
        return this.f81371a.f81412p;
    }

    public float O() {
        return y() + N();
    }

    public final boolean P() {
        c cVar = this.f81371a;
        int i11 = cVar.f81413q;
        return i11 != 1 && cVar.f81414r > 0 && (i11 == 2 || Z());
    }

    public final boolean Q() {
        Paint.Style style = this.f81371a.f81418v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean R() {
        Paint.Style style = this.f81371a.f81418v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f81385p.getStrokeWidth() > 0.0f;
    }

    public void S(Context context) {
        this.f81371a.f81398b = new pi.a(context);
        r0();
    }

    public final void T() {
        super.invalidateSelf();
    }

    public boolean U() {
        pi.a aVar = this.f81371a.f81398b;
        return aVar != null && aVar.e();
    }

    public boolean V() {
        return this.f81371a.f81397a.u(w());
    }

    public final void W(@NonNull Canvas canvas) {
        if (P()) {
            canvas.save();
            Y(canvas);
            if (!this.f81393x) {
                p(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f81392w.width() - getBounds().width());
            int iHeight = (int) (this.f81392w.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f81392w.width()) + (this.f81371a.f81414r * 2) + iWidth, ((int) this.f81392w.height()) + (this.f81371a.f81414r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f11 = (getBounds().left - this.f81371a.f81414r) - iWidth;
            float f12 = (getBounds().top - this.f81371a.f81414r) - iHeight;
            canvas2.translate(-f11, -f12);
            p(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f11, f12, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    public final void Y(@NonNull Canvas canvas) {
        canvas.translate(D(), E());
    }

    public boolean Z() {
        return (V() || this.f81377h.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void a0(float f11) {
        setShapeAppearanceModel(this.f81371a.f81397a.w(f11));
    }

    public void b0(@NonNull d dVar) {
        setShapeAppearanceModel(this.f81371a.f81397a.x(dVar));
    }

    public void c0(float f11) {
        c cVar = this.f81371a;
        if (cVar.f81411o != f11) {
            cVar.f81411o = f11;
            r0();
        }
    }

    public void d0(@Nullable ColorStateList colorStateList) {
        c cVar = this.f81371a;
        if (cVar.f81400d != colorStateList) {
            cVar.f81400d = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f81384o.setColorFilter(this.f81389t);
        int alpha = this.f81384o.getAlpha();
        this.f81384o.setAlpha(X(alpha, this.f81371a.f81409m));
        this.f81385p.setColorFilter(this.f81390u);
        this.f81385p.setStrokeWidth(this.f81371a.f81408l);
        int alpha2 = this.f81385p.getAlpha();
        this.f81385p.setAlpha(X(alpha2, this.f81371a.f81409m));
        if (this.f81375f) {
            i();
            g(w(), this.f81377h);
            this.f81375f = false;
        }
        W(canvas);
        if (Q()) {
            q(canvas);
        }
        if (R()) {
            t(canvas);
        }
        this.f81384o.setAlpha(alpha);
        this.f81385p.setAlpha(alpha2);
    }

    public void e0(float f11) {
        c cVar = this.f81371a;
        if (cVar.f81407k != f11) {
            cVar.f81407k = f11;
            this.f81375f = true;
            invalidateSelf();
        }
    }

    @Nullable
    public final PorterDuffColorFilter f(@NonNull Paint paint, boolean z11) {
        if (!z11) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f81391v = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public void f0(int i11, int i12, int i13, int i14) {
        c cVar = this.f81371a;
        if (cVar.f81405i == null) {
            cVar.f81405i = new Rect();
        }
        this.f81371a.f81405i.set(i11, i12, i13, i14);
        invalidateSelf();
    }

    public final void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.f81371a.f81406j != 1.0f) {
            this.f81376g.reset();
            Matrix matrix = this.f81376g;
            float f11 = this.f81371a.f81406j;
            matrix.setScale(f11, f11, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f81376g);
        }
        path.computeBounds(this.f81392w, true);
    }

    public void g0(Paint.Style style) {
        this.f81371a.f81418v = style;
        T();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f81371a.f81409m;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f81371a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f81371a.f81413q == 2) {
            return;
        }
        if (V()) {
            outline.setRoundRect(getBounds(), L() * this.f81371a.f81407k);
        } else {
            g(w(), this.f81377h);
            oi.f.l(outline, this.f81377h);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f81371a.f81405i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f81381l.set(getBounds());
        g(w(), this.f81377h);
        this.f81382m.setPath(this.f81377h, this.f81381l);
        this.f81381l.op(this.f81382m, Region.Op.DIFFERENCE);
        return this.f81381l;
    }

    public final void h(@NonNull RectF rectF, @NonNull Path path) {
        o oVar = this.f81388s;
        c cVar = this.f81371a;
        oVar.e(cVar.f81397a, cVar.f81407k, rectF, this.f81387r, path);
    }

    public void h0(float f11) {
        c cVar = this.f81371a;
        if (cVar.f81410n != f11) {
            cVar.f81410n = f11;
            r0();
        }
    }

    public final void i() {
        n nVarY = G().y(new b(-I()));
        this.f81383n = nVarY;
        this.f81388s.d(nVarY, this.f81371a.f81407k, x(), this.f81378i);
    }

    public void i0(boolean z11) {
        this.f81393x = z11;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f81375f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f81371a.f81403g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f81371a.f81402f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f81371a.f81401e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f81371a.f81400d) != null && colorStateList4.isStateful())));
    }

    @NonNull
    public final PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z11) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z11) {
            colorForState = l(colorForState);
        }
        this.f81391v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public void j0(int i11) {
        this.f81386q.d(i11);
        this.f81371a.f81417u = false;
        T();
    }

    @NonNull
    public final PorterDuffColorFilter k(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z11) {
        return (colorStateList == null || mode == null) ? f(paint, z11) : j(colorStateList, mode, z11);
    }

    public void k0(int i11) {
        c cVar = this.f81371a;
        if (cVar.f81413q != i11) {
            cVar.f81413q = i11;
            T();
        }
    }

    public int l(int i11) {
        float fO = O() + B();
        pi.a aVar = this.f81371a.f81398b;
        return aVar != null ? aVar.c(i11, fO) : i11;
    }

    public void l0(float f11, int i11) {
        o0(f11);
        n0(ColorStateList.valueOf(i11));
    }

    public void m0(float f11, @Nullable ColorStateList colorStateList) {
        o0(f11);
        n0(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f81371a = new c(this.f81371a);
        return this;
    }

    public void n0(@Nullable ColorStateList colorStateList) {
        c cVar = this.f81371a;
        if (cVar.f81401e != colorStateList) {
            cVar.f81401e = colorStateList;
            onStateChange(getState());
        }
    }

    public void o0(float f11) {
        this.f81371a.f81408l = f11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f81375f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.y.b
    public boolean onStateChange(int[] iArr) {
        boolean z11 = p0(iArr) || q0();
        if (z11) {
            invalidateSelf();
        }
        return z11;
    }

    public final void p(@NonNull Canvas canvas) {
        if (this.f81374d.cardinality() > 0) {
            Log.w(f81369y, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f81371a.f81415s != 0) {
            canvas.drawPath(this.f81377h, this.f81386q.c());
        }
        for (int i11 = 0; i11 < 4; i11++) {
            this.f81372b[i11].b(this.f81386q, this.f81371a.f81414r, canvas);
            this.f81373c[i11].b(this.f81386q, this.f81371a.f81414r, canvas);
        }
        if (this.f81393x) {
            int iD = D();
            int iE = E();
            canvas.translate(-iD, -iE);
            canvas.drawPath(this.f81377h, f81370z);
            canvas.translate(iD, iE);
        }
    }

    public final boolean p0(int[] iArr) {
        boolean z11;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f81371a.f81400d == null || color2 == (colorForState2 = this.f81371a.f81400d.getColorForState(iArr, (color2 = this.f81384o.getColor())))) {
            z11 = false;
        } else {
            this.f81384o.setColor(colorForState2);
            z11 = true;
        }
        if (this.f81371a.f81401e == null || color == (colorForState = this.f81371a.f81401e.getColorForState(iArr, (color = this.f81385p.getColor())))) {
            return z11;
        }
        this.f81385p.setColor(colorForState);
        return true;
    }

    public final void q(@NonNull Canvas canvas) {
        s(canvas, this.f81384o, this.f81377h, this.f81371a.f81397a, w());
    }

    public final boolean q0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f81389t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f81390u;
        c cVar = this.f81371a;
        this.f81389t = k(cVar.f81403g, cVar.f81404h, this.f81384o, true);
        c cVar2 = this.f81371a;
        this.f81390u = k(cVar2.f81402f, cVar2.f81404h, this.f81385p, false);
        c cVar3 = this.f81371a;
        if (cVar3.f81417u) {
            this.f81386q.d(cVar3.f81403g.getColorForState(getState(), 0));
        }
        return (androidx.core.util.d.a(porterDuffColorFilter, this.f81389t) && androidx.core.util.d.a(porterDuffColorFilter2, this.f81390u)) ? false : true;
    }

    public void r(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        s(canvas, paint, path, this.f81371a.f81397a, rectF);
    }

    public final void r0() {
        float fO = O();
        this.f81371a.f81414r = (int) Math.ceil(0.75f * fO);
        this.f81371a.f81415s = (int) Math.ceil(fO * 0.25f);
        q0();
        T();
    }

    public final void s(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull n nVar, @NonNull RectF rectF) {
        if (!nVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = nVar.t().a(rectF) * this.f81371a.f81407k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        c cVar = this.f81371a;
        if (cVar.f81409m != i11) {
            cVar.f81409m = i11;
            T();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f81371a.f81399c = colorFilter;
        T();
    }

    @Override // yi.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        this.f81371a.f81397a = nVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f81371a.f81403g = colorStateList;
        q0();
        T();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        c cVar = this.f81371a;
        if (cVar.f81404h != mode) {
            cVar.f81404h = mode;
            q0();
            T();
        }
    }

    public void t(@NonNull Canvas canvas) {
        s(canvas, this.f81385p, this.f81378i, this.f81383n, x());
    }

    public float u() {
        return this.f81371a.f81397a.j().a(w());
    }

    public float v() {
        return this.f81371a.f81397a.l().a(w());
    }

    @NonNull
    public RectF w() {
        this.f81379j.set(getBounds());
        return this.f81379j;
    }

    @NonNull
    public final RectF x() {
        this.f81380k.set(w());
        float fI = I();
        this.f81380k.inset(fI, fI);
        return this.f81380k;
    }

    public float y() {
        return this.f81371a.f81411o;
    }

    @Nullable
    public ColorStateList z() {
        return this.f81371a.f81400d;
    }
}
