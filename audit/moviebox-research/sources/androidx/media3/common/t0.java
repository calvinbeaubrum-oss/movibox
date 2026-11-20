package androidx.media3.common;

import androidx.annotation.Nullable;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t0 f9443e = new t0(0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9444f = u0.E0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9445g = u0.E0(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9446h = u0.E0(2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9447i = u0.E0(3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final i<t0> f9448j = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f9452d;

    public t0(int i11, int i12) {
        this(i11, i12, 0, 1.0f);
    }

    public t0(int i11, int i12, int i13, float f11) {
        this.f9449a = i11;
        this.f9450b = i12;
        this.f9451c = i13;
        this.f9452d = f11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f9449a == t0Var.f9449a && this.f9450b == t0Var.f9450b && this.f9451c == t0Var.f9451c && this.f9452d == t0Var.f9452d;
    }

    public int hashCode() {
        return ((((((217 + this.f9449a) * 31) + this.f9450b) * 31) + this.f9451c) * 31) + Float.floatToRawIntBits(this.f9452d);
    }
}
