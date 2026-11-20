package ci;

import android.text.Layout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public String f14902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14906e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public String f14913l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f14916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public Layout.Alignment f14917p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public b f14919r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14907f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14908g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14909h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14910i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14911j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14914m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14915n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14918q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f14920s = Float.MAX_VALUE;

    public g A(@Nullable String str) {
        this.f14913l = str;
        return this;
    }

    public g B(boolean z11) {
        this.f14910i = z11 ? 1 : 0;
        return this;
    }

    public g C(boolean z11) {
        this.f14907f = z11 ? 1 : 0;
        return this;
    }

    public g D(@Nullable Layout.Alignment alignment) {
        this.f14917p = alignment;
        return this;
    }

    public g E(int i11) {
        this.f14915n = i11;
        return this;
    }

    public g F(int i11) {
        this.f14914m = i11;
        return this;
    }

    public g G(float f11) {
        this.f14920s = f11;
        return this;
    }

    public g H(@Nullable Layout.Alignment alignment) {
        this.f14916o = alignment;
        return this;
    }

    public g I(boolean z11) {
        this.f14918q = z11 ? 1 : 0;
        return this;
    }

    public g J(@Nullable b bVar) {
        this.f14919r = bVar;
        return this;
    }

    public g K(boolean z11) {
        this.f14908g = z11 ? 1 : 0;
        return this;
    }

    public g a(@Nullable g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f14906e) {
            return this.f14905d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f14904c) {
            return this.f14903b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.f14902a;
    }

    public float e() {
        return this.f14912k;
    }

    public int f() {
        return this.f14911j;
    }

    @Nullable
    public String g() {
        return this.f14913l;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.f14917p;
    }

    public int i() {
        return this.f14915n;
    }

    public int j() {
        return this.f14914m;
    }

    public float k() {
        return this.f14920s;
    }

    public int l() {
        int i11 = this.f14909h;
        if (i11 == -1 && this.f14910i == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f14910i == 1 ? 2 : 0);
    }

    @Nullable
    public Layout.Alignment m() {
        return this.f14916o;
    }

    public boolean n() {
        return this.f14918q == 1;
    }

    @Nullable
    public b o() {
        return this.f14919r;
    }

    public boolean p() {
        return this.f14906e;
    }

    public boolean q() {
        return this.f14904c;
    }

    public final g r(@Nullable g gVar, boolean z11) {
        int i11;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f14904c && gVar.f14904c) {
                w(gVar.f14903b);
            }
            if (this.f14909h == -1) {
                this.f14909h = gVar.f14909h;
            }
            if (this.f14910i == -1) {
                this.f14910i = gVar.f14910i;
            }
            if (this.f14902a == null && (str = gVar.f14902a) != null) {
                this.f14902a = str;
            }
            if (this.f14907f == -1) {
                this.f14907f = gVar.f14907f;
            }
            if (this.f14908g == -1) {
                this.f14908g = gVar.f14908g;
            }
            if (this.f14915n == -1) {
                this.f14915n = gVar.f14915n;
            }
            if (this.f14916o == null && (alignment2 = gVar.f14916o) != null) {
                this.f14916o = alignment2;
            }
            if (this.f14917p == null && (alignment = gVar.f14917p) != null) {
                this.f14917p = alignment;
            }
            if (this.f14918q == -1) {
                this.f14918q = gVar.f14918q;
            }
            if (this.f14911j == -1) {
                this.f14911j = gVar.f14911j;
                this.f14912k = gVar.f14912k;
            }
            if (this.f14919r == null) {
                this.f14919r = gVar.f14919r;
            }
            if (this.f14920s == Float.MAX_VALUE) {
                this.f14920s = gVar.f14920s;
            }
            if (z11 && !this.f14906e && gVar.f14906e) {
                u(gVar.f14905d);
            }
            if (z11 && this.f14914m == -1 && (i11 = gVar.f14914m) != -1) {
                this.f14914m = i11;
            }
        }
        return this;
    }

    public boolean s() {
        return this.f14907f == 1;
    }

    public boolean t() {
        return this.f14908g == 1;
    }

    public g u(int i11) {
        this.f14905d = i11;
        this.f14906e = true;
        return this;
    }

    public g v(boolean z11) {
        this.f14909h = z11 ? 1 : 0;
        return this;
    }

    public g w(int i11) {
        this.f14903b = i11;
        this.f14904c = true;
        return this;
    }

    public g x(@Nullable String str) {
        this.f14902a = str;
        return this;
    }

    public g y(float f11) {
        this.f14912k = f11;
        return this;
    }

    public g z(int i11) {
        this.f14911j = i11;
        return this;
    }
}
