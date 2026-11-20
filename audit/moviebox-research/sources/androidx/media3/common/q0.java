package androidx.media3.common;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q0 f9426b = new q0(ImmutableList.of());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9427c = u0.E0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final i<q0> f9428d = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<a> f9429a;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f9430f = u0.E0(0);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f9431g = u0.E0(1);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f9432h = u0.E0(3);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f9433i = u0.E0(4);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Deprecated
        public static final i<a> f9434j = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n0 f9436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f9437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f9438d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean[] f9439e;

        public a(n0 n0Var, boolean z11, int[] iArr, boolean[] zArr) {
            int i11 = n0Var.f9330a;
            this.f9435a = i11;
            boolean z12 = false;
            z3.a.a(i11 == iArr.length && i11 == zArr.length);
            this.f9436b = n0Var;
            if (z11 && i11 > 1) {
                z12 = true;
            }
            this.f9437c = z12;
            this.f9438d = (int[]) iArr.clone();
            this.f9439e = (boolean[]) zArr.clone();
        }

        public n0 a() {
            return this.f9436b;
        }

        public y b(int i11) {
            return this.f9436b.a(i11);
        }

        public int c(int i11) {
            return this.f9438d[i11];
        }

        public int d() {
            return this.f9436b.f9332c;
        }

        public boolean e() {
            return this.f9437c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9437c == aVar.f9437c && this.f9436b.equals(aVar.f9436b) && Arrays.equals(this.f9438d, aVar.f9438d) && Arrays.equals(this.f9439e, aVar.f9439e);
        }

        public boolean f() {
            return Booleans.b(this.f9439e, true);
        }

        public boolean g(boolean z11) {
            for (int i11 = 0; i11 < this.f9438d.length; i11++) {
                if (j(i11, z11)) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(int i11) {
            return this.f9439e[i11];
        }

        public int hashCode() {
            return (((((this.f9436b.hashCode() * 31) + (this.f9437c ? 1 : 0)) * 31) + Arrays.hashCode(this.f9438d)) * 31) + Arrays.hashCode(this.f9439e);
        }

        public boolean i(int i11) {
            return j(i11, false);
        }

        public boolean j(int i11, boolean z11) {
            int i12 = this.f9438d[i11];
            return i12 == 4 || (z11 && i12 == 3);
        }
    }

    public q0(List<a> list) {
        this.f9429a = ImmutableList.copyOf((Collection) list);
    }

    public ImmutableList<a> a() {
        return this.f9429a;
    }

    public boolean b() {
        return this.f9429a.isEmpty();
    }

    public boolean c(int i11) {
        for (int i12 = 0; i12 < this.f9429a.size(); i12++) {
            a aVar = this.f9429a.get(i12);
            if (aVar.f() && aVar.d() == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean d(int i11) {
        return e(i11, false);
    }

    public boolean e(int i11, boolean z11) {
        for (int i12 = 0; i12 < this.f9429a.size(); i12++) {
            if (this.f9429a.get(i12).d() == i11 && this.f9429a.get(i12).g(z11)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q0.class != obj.getClass()) {
            return false;
        }
        return this.f9429a.equals(((q0) obj).f9429a);
    }

    public int hashCode() {
        return this.f9429a.hashCode();
    }
}
