package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f918d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f920g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f926m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f919f = 255;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f921h = -1;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable.Callback f927a;

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f927a;
            this.f927a = null;
            return callback;
        }

        public b b(Drawable.Callback callback) {
            this.f927a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
            Drawable.Callback callback = this.f927a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j11);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.f927a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DrawableContainerCompat f928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Resources f929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f932e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f933f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable[] f934g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f935h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f936i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f937j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Rect f938k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f939l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f940m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f941n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f942o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f943p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f944q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f945r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f946s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f947t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f948u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f949v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f950w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f951x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f952y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f953z;

        public c(c cVar, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            this.f936i = false;
            this.f939l = false;
            this.f951x = true;
            this.A = 0;
            this.B = 0;
            this.f928a = drawableContainerCompat;
            this.f929b = resources != null ? resources : cVar != null ? cVar.f929b : null;
            int iF = DrawableContainerCompat.f(resources, cVar != null ? cVar.f930c : 0);
            this.f930c = iF;
            if (cVar == null) {
                this.f934g = new Drawable[10];
                this.f935h = 0;
                return;
            }
            this.f931d = cVar.f931d;
            this.f932e = cVar.f932e;
            this.f949v = true;
            this.f950w = true;
            this.f936i = cVar.f936i;
            this.f939l = cVar.f939l;
            this.f951x = cVar.f951x;
            this.f952y = cVar.f952y;
            this.f953z = cVar.f953z;
            this.A = cVar.A;
            this.B = cVar.B;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.I = cVar.I;
            if (cVar.f930c == iF) {
                if (cVar.f937j) {
                    this.f938k = cVar.f938k != null ? new Rect(cVar.f938k) : null;
                    this.f937j = true;
                }
                if (cVar.f940m) {
                    this.f941n = cVar.f941n;
                    this.f942o = cVar.f942o;
                    this.f943p = cVar.f943p;
                    this.f944q = cVar.f944q;
                    this.f940m = true;
                }
            }
            if (cVar.f945r) {
                this.f946s = cVar.f946s;
                this.f945r = true;
            }
            if (cVar.f947t) {
                this.f948u = cVar.f948u;
                this.f947t = true;
            }
            Drawable[] drawableArr = cVar.f934g;
            this.f934g = new Drawable[drawableArr.length];
            this.f935h = cVar.f935h;
            SparseArray<Drawable.ConstantState> sparseArray = cVar.f933f;
            if (sparseArray != null) {
                this.f933f = sparseArray.clone();
            } else {
                this.f933f = new SparseArray<>(this.f935h);
            }
            int i11 = this.f935h;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f933f.put(i12, constantState);
                    } else {
                        this.f934g[i12] = drawableArr[i12];
                    }
                }
            }
        }

        public final int a(Drawable drawable) {
            int i11 = this.f935h;
            if (i11 >= this.f934g.length) {
                o(i11, i11 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f928a);
            this.f934g[i11] = drawable;
            this.f935h++;
            this.f932e = drawable.getChangingConfigurations() | this.f932e;
            p();
            this.f938k = null;
            this.f937j = false;
            this.f940m = false;
            this.f949v = false;
            return i11;
        }

        @RequiresApi(21)
        public final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i11 = this.f935h;
                Drawable[] drawableArr = this.f934g;
                for (int i12 = 0; i12 < i11; i12++) {
                    Drawable drawable = drawableArr[i12];
                    if (drawable != null && d3.a.b(drawable)) {
                        d3.a.a(drawableArr[i12], theme);
                        this.f932e |= drawableArr[i12].getChangingConfigurations();
                    }
                }
                y(a.c(theme));
            }
        }

        public boolean c() {
            if (this.f949v) {
                return this.f950w;
            }
            e();
            this.f949v = true;
            int i11 = this.f935h;
            Drawable[] drawableArr = this.f934g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getConstantState() == null) {
                    this.f950w = false;
                    return false;
                }
            }
            this.f950w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i11 = this.f935h;
            Drawable[] drawableArr = this.f934g;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f933f.get(i12);
                    if (constantState != null && a.a(constantState)) {
                        return true;
                    }
                } else if (d3.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public void d() {
            this.f940m = true;
            e();
            int i11 = this.f935h;
            Drawable[] drawableArr = this.f934g;
            this.f942o = -1;
            this.f941n = -1;
            this.f944q = 0;
            this.f943p = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f941n) {
                    this.f941n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f942o) {
                    this.f942o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f943p) {
                    this.f943p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f944q) {
                    this.f944q = minimumHeight;
                }
            }
        }

        public final void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f933f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i11 = 0; i11 < size; i11++) {
                    this.f934g[this.f933f.keyAt(i11)] = s(this.f933f.valueAt(i11).newDrawable(this.f929b));
                }
                this.f933f = null;
            }
        }

        public final int f() {
            return this.f934g.length;
        }

        public final Drawable g(int i11) {
            int iIndexOfKey;
            Drawable drawable = this.f934g[i11];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f933f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i11)) < 0) {
                return null;
            }
            Drawable drawableS = s(this.f933f.valueAt(iIndexOfKey).newDrawable(this.f929b));
            this.f934g[i11] = drawableS;
            this.f933f.removeAt(iIndexOfKey);
            if (this.f933f.size() == 0) {
                this.f933f = null;
            }
            return drawableS;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f931d | this.f932e;
        }

        public final int h() {
            return this.f935h;
        }

        public final int i() {
            if (!this.f940m) {
                d();
            }
            return this.f942o;
        }

        public final int j() {
            if (!this.f940m) {
                d();
            }
            return this.f944q;
        }

        public final int k() {
            if (!this.f940m) {
                d();
            }
            return this.f943p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f936i) {
                return null;
            }
            Rect rect2 = this.f938k;
            if (rect2 != null || this.f937j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i11 = this.f935h;
            Drawable[] drawableArr = this.f934g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i13 = rect3.left;
                    if (i13 > rect.left) {
                        rect.left = i13;
                    }
                    int i14 = rect3.top;
                    if (i14 > rect.top) {
                        rect.top = i14;
                    }
                    int i15 = rect3.right;
                    if (i15 > rect.right) {
                        rect.right = i15;
                    }
                    int i16 = rect3.bottom;
                    if (i16 > rect.bottom) {
                        rect.bottom = i16;
                    }
                }
            }
            this.f937j = true;
            this.f938k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f940m) {
                d();
            }
            return this.f941n;
        }

        public final int n() {
            if (this.f945r) {
                return this.f946s;
            }
            e();
            int i11 = this.f935h;
            Drawable[] drawableArr = this.f934g;
            int opacity = i11 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i12 = 1; i12 < i11; i12++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i12].getOpacity());
            }
            this.f946s = opacity;
            this.f945r = true;
            return opacity;
        }

        public void o(int i11, int i12) {
            Drawable[] drawableArr = new Drawable[i12];
            Drawable[] drawableArr2 = this.f934g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i11);
            }
            this.f934g = drawableArr;
        }

        public void p() {
            this.f945r = false;
            this.f947t = false;
        }

        public final boolean q() {
            return this.f939l;
        }

        public abstract void r();

        public final Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                d3.a.m(drawable, this.f953z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f928a);
            return drawableMutate;
        }

        public final void t(boolean z11) {
            this.f939l = z11;
        }

        public final void u(int i11) {
            this.A = i11;
        }

        public final void v(int i11) {
            this.B = i11;
        }

        public final boolean w(int i11, int i12) {
            int i13 = this.f935h;
            Drawable[] drawableArr = this.f934g;
            boolean z11 = false;
            for (int i14 = 0; i14 < i13; i14++) {
                Drawable drawable = drawableArr[i14];
                if (drawable != null) {
                    boolean zM = Build.VERSION.SDK_INT >= 23 ? d3.a.m(drawable, i11) : false;
                    if (i14 == i12) {
                        z11 = zM;
                    }
                }
            }
            this.f953z = i11;
            return z11;
        }

        public final void x(boolean z11) {
            this.f936i = z11;
        }

        public final void y(Resources resources) {
            if (resources != null) {
                this.f929b = resources;
                int iF = DrawableContainerCompat.f(resources, this.f930c);
                int i11 = this.f930c;
                this.f930c = iF;
                if (i11 != iF) {
                    this.f940m = false;
                    this.f937j = false;
                }
            }
        }
    }

    public static int f(@Nullable Resources resources, int i11) {
        if (resources != null) {
            i11 = resources.getDisplayMetrics().densityDpi;
        }
        if (i11 == 0) {
            return 160;
        }
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void a(boolean z11) {
        boolean z12;
        Drawable drawable;
        long j11;
        boolean z13 = true;
        this.f920g = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f917c;
        if (drawable2 != null) {
            long j12 = this.f924k;
            if (j12 != 0) {
                if (j12 <= jUptimeMillis) {
                    drawable2.setAlpha(this.f919f);
                    this.f924k = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j12 - jUptimeMillis) * 255)) / this.f915a.A)) * this.f919f) / 255);
                    z12 = true;
                }
            }
            drawable = this.f918d;
            if (drawable != null) {
                j11 = this.f925l;
                if (j11 == 0) {
                    if (j11 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f918d = null;
                        this.f925l = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j11 - jUptimeMillis) * 255)) / this.f915a.B) * this.f919f) / 255);
                    }
                }
                if (z11 || !z13) {
                }
                scheduleSelf(this.f923j, jUptimeMillis + 16);
                return;
            }
            this.f925l = 0L;
            z13 = z12;
            if (z11) {
            }
        }
        this.f924k = 0L;
        z12 = false;
        drawable = this.f918d;
        if (drawable != null) {
            j11 = this.f925l;
            if (j11 == 0) {
                if (j11 <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.f918d = null;
                    this.f925l = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j11 - jUptimeMillis) * 255)) / this.f915a.B) * this.f919f) / 255);
                }
            }
            if (z11) {
            }
        }
        this.f925l = 0L;
        z13 = z12;
        if (z11) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.f915a.b(theme);
    }

    public c b() {
        throw null;
    }

    public int c() {
        return this.f921h;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.f915a.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        if (this.f926m == null) {
            this.f926m = new b();
        }
        drawable.setCallback(this.f926m.b(drawable.getCallback()));
        try {
            if (this.f915a.A <= 0 && this.f920g) {
                drawable.setAlpha(this.f919f);
            }
            c cVar = this.f915a;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    d3.a.o(drawable, cVar.F);
                }
                c cVar2 = this.f915a;
                if (cVar2.I) {
                    d3.a.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f915a.f951x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                d3.a.m(drawable, d3.a.f(this));
            }
            d3.a.j(drawable, this.f915a.C);
            Rect rect = this.f916b;
            if (rect != null) {
                d3.a.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f926m.a());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f917c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f918d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final boolean e() {
        return isAutoMirrored() && d3.a.f(this) == 1;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    public boolean g(int i11) {
        if (i11 == this.f921h) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f915a.B > 0) {
            Drawable drawable = this.f918d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f917c;
            if (drawable2 != null) {
                this.f918d = drawable2;
                this.f925l = ((long) this.f915a.B) + jUptimeMillis;
            } else {
                this.f918d = null;
                this.f925l = 0L;
            }
        } else {
            Drawable drawable3 = this.f917c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i11 >= 0) {
            c cVar = this.f915a;
            if (i11 < cVar.f935h) {
                Drawable drawableG = cVar.g(i11);
                this.f917c = drawableG;
                this.f921h = i11;
                if (drawableG != null) {
                    int i12 = this.f915a.A;
                    if (i12 > 0) {
                        this.f924k = jUptimeMillis + ((long) i12);
                    }
                    d(drawableG);
                }
            } else {
                this.f917c = null;
                this.f921h = -1;
            }
        } else {
            this.f917c = null;
            this.f921h = -1;
        }
        if (this.f924k != 0 || this.f925l != 0) {
            Runnable runnable = this.f923j;
            if (runnable == null) {
                this.f923j = new Runnable() { // from class: androidx.appcompat.graphics.drawable.DrawableContainerCompat.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableContainerCompat.this.a(true);
                        DrawableContainerCompat.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f919f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f915a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f915a.c()) {
            return null;
        }
        this.f915a.f931d = getChangingConfigurations();
        return this.f915a;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f917c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.f916b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f915a.q()) {
            return this.f915a.i();
        }
        Drawable drawable = this.f917c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f915a.q()) {
            return this.f915a.m();
        }
        Drawable drawable = this.f917c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f915a.q()) {
            return this.f915a.j();
        }
        Drawable drawable = this.f917c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f915a.q()) {
            return this.f915a.k();
        }
        Drawable drawable = this.f917c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f917c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f915a.n();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f917c;
        if (drawable != null) {
            a.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        boolean padding;
        Rect rectL = this.f915a.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f917c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i11 = rect.left;
            rect.left = rect.right;
            rect.right = i11;
        }
        return padding;
    }

    public void h(c cVar) {
        this.f915a = cVar;
        int i11 = this.f921h;
        if (i11 >= 0) {
            Drawable drawableG = cVar.g(i11);
            this.f917c = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f918d = null;
    }

    public final void i(Resources resources) {
        this.f915a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        c cVar = this.f915a;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable != this.f917c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f915a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z11;
        Drawable drawable = this.f918d;
        boolean z12 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f918d = null;
            z11 = true;
        } else {
            z11 = false;
        }
        Drawable drawable2 = this.f917c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f920g) {
                this.f917c.setAlpha(this.f919f);
            }
        }
        if (this.f925l != 0) {
            this.f925l = 0L;
        } else {
            z12 = z11;
        }
        if (this.f924k != 0) {
            this.f924k = 0L;
        } else if (!z12) {
            return;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f922i && super.mutate() == this) {
            c cVarB = b();
            cVarB.r();
            h(cVarB);
            this.f922i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f918d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f917c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i11) {
        return this.f915a.w(i11, c());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i11) {
        Drawable drawable = this.f918d;
        if (drawable != null) {
            return drawable.setLevel(i11);
        }
        Drawable drawable2 = this.f917c;
        if (drawable2 != null) {
            return drawable2.setLevel(i11);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.f918d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f917c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
        if (drawable != this.f917c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        if (this.f920g && this.f919f == i11) {
            return;
        }
        this.f920g = true;
        this.f919f = i11;
        Drawable drawable = this.f917c;
        if (drawable != null) {
            if (this.f924k == 0) {
                drawable.setAlpha(i11);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z11) {
        c cVar = this.f915a;
        if (cVar.C != z11) {
            cVar.C = z11;
            Drawable drawable = this.f917c;
            if (drawable != null) {
                d3.a.j(drawable, z11);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f915a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f917c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z11) {
        c cVar = this.f915a;
        if (cVar.f951x != z11) {
            cVar.f951x = z11;
            Drawable drawable = this.f917c;
            if (drawable != null) {
                drawable.setDither(z11);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f11, float f12) {
        Drawable drawable = this.f917c;
        if (drawable != null) {
            d3.a.k(drawable, f11, f12);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        Rect rect = this.f916b;
        if (rect == null) {
            this.f916b = new Rect(i11, i12, i13, i14);
        } else {
            rect.set(i11, i12, i13, i14);
        }
        Drawable drawable = this.f917c;
        if (drawable != null) {
            d3.a.l(drawable, i11, i12, i13, i14);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f915a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            d3.a.o(this.f917c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        c cVar = this.f915a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            d3.a.p(this.f917c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        Drawable drawable = this.f918d;
        if (drawable != null) {
            drawable.setVisible(z11, z12);
        }
        Drawable drawable2 = this.f917c;
        if (drawable2 != null) {
            drawable2.setVisible(z11, z12);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable != this.f917c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
