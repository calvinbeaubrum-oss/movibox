package u5;

import android.text.Layout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public String f78460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f78464e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f78470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public String f78471l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f78474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f78475p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public b f78477r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78465f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78466g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f78467h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f78468i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78469j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f78472m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f78473n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f78476q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f78478s = Float.MAX_VALUE;

    public g A(@Nullable String str) {
        this.f78471l = str;
        return this;
    }

    public g B(boolean z11) {
        this.f78468i = z11 ? 1 : 0;
        return this;
    }

    public g C(boolean z11) {
        this.f78465f = z11 ? 1 : 0;
        return this;
    }

    public g D(@Nullable Layout.Alignment alignment) {
        this.f78475p = alignment;
        return this;
    }

    public g E(int i11) {
        this.f78473n = i11;
        return this;
    }

    public g F(int i11) {
        this.f78472m = i11;
        return this;
    }

    public g G(float f11) {
        this.f78478s = f11;
        return this;
    }

    public g H(@Nullable Layout.Alignment alignment) {
        this.f78474o = alignment;
        return this;
    }

    public g I(boolean z11) {
        this.f78476q = z11 ? 1 : 0;
        return this;
    }

    public g J(@Nullable b bVar) {
        this.f78477r = bVar;
        return this;
    }

    public g K(boolean z11) {
        this.f78466g = z11 ? 1 : 0;
        return this;
    }

    public g a(@Nullable g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f78464e) {
            return this.f78463d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f78462c) {
            return this.f78461b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.f78460a;
    }

    public float e() {
        return this.f78470k;
    }

    public int f() {
        return this.f78469j;
    }

    @Nullable
    public String g() {
        return this.f78471l;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.f78475p;
    }

    public int i() {
        return this.f78473n;
    }

    public int j() {
        return this.f78472m;
    }

    public float k() {
        return this.f78478s;
    }

    public int l() {
        int i11 = this.f78467h;
        if (i11 == -1 && this.f78468i == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f78468i == 1 ? 2 : 0);
    }

    @Nullable
    public Layout.Alignment m() {
        return this.f78474o;
    }

    public boolean n() {
        return this.f78476q == 1;
    }

    @Nullable
    public b o() {
        return this.f78477r;
    }

    public boolean p() {
        return this.f78464e;
    }

    public boolean q() {
        return this.f78462c;
    }

    public final g r(@Nullable g gVar, boolean z11) {
        int i11;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f78462c && gVar.f78462c) {
                w(gVar.f78461b);
            }
            if (this.f78467h == -1) {
                this.f78467h = gVar.f78467h;
            }
            if (this.f78468i == -1) {
                this.f78468i = gVar.f78468i;
            }
            if (this.f78460a == null && (str = gVar.f78460a) != null) {
                this.f78460a = str;
            }
            if (this.f78465f == -1) {
                this.f78465f = gVar.f78465f;
            }
            if (this.f78466g == -1) {
                this.f78466g = gVar.f78466g;
            }
            if (this.f78473n == -1) {
                this.f78473n = gVar.f78473n;
            }
            if (this.f78474o == null && (alignment2 = gVar.f78474o) != null) {
                this.f78474o = alignment2;
            }
            if (this.f78475p == null && (alignment = gVar.f78475p) != null) {
                this.f78475p = alignment;
            }
            if (this.f78476q == -1) {
                this.f78476q = gVar.f78476q;
            }
            if (this.f78469j == -1) {
                this.f78469j = gVar.f78469j;
                this.f78470k = gVar.f78470k;
            }
            if (this.f78477r == null) {
                this.f78477r = gVar.f78477r;
            }
            if (this.f78478s == Float.MAX_VALUE) {
                this.f78478s = gVar.f78478s;
            }
            if (z11 && !this.f78464e && gVar.f78464e) {
                u(gVar.f78463d);
            }
            if (z11 && this.f78472m == -1 && (i11 = gVar.f78472m) != -1) {
                this.f78472m = i11;
            }
        }
        return this;
    }

    public boolean s() {
        return this.f78465f == 1;
    }

    public boolean t() {
        return this.f78466g == 1;
    }

    public g u(int i11) {
        this.f78463d = i11;
        this.f78464e = true;
        return this;
    }

    public g v(boolean z11) {
        this.f78467h = z11 ? 1 : 0;
        return this;
    }

    public g w(int i11) {
        this.f78461b = i11;
        this.f78462c = true;
        return this;
    }

    public g x(@Nullable String str) {
        this.f78460a = str;
        return this;
    }

    public g y(float f11) {
        this.f78470k = f11;
        return this;
    }

    public g z(int i11) {
        this.f78469j = i11;
        return this;
    }
}
