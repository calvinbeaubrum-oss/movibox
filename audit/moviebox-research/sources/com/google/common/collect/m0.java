package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m0<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object[] f38704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f38705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f38706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f38707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int[] f38708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient long[] f38709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient float f38710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f38711h;

    /* JADX INFO: compiled from: source.java */
    public class a extends Multisets.b<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38713b;

        public a(int i11) {
            this.f38712a = (K) m0.this.f38704a[i11];
            this.f38713b = i11;
        }

        public void a() {
            int i11 = this.f38713b;
            if (i11 == -1 || i11 >= m0.this.C() || !com.google.common.base.j.a(this.f38712a, m0.this.f38704a[this.f38713b])) {
                this.f38713b = m0.this.m(this.f38712a);
            }
        }

        @Override // com.google.common.collect.j0.a
        public int getCount() {
            a();
            int i11 = this.f38713b;
            if (i11 == -1) {
                return 0;
            }
            return m0.this.f38705b[i11];
        }

        @Override // com.google.common.collect.j0.a
        public K getElement() {
            return this.f38712a;
        }
    }

    public m0() {
        n(3, 1.0f);
    }

    public m0(int i11) {
        this(i11, 1.0f);
    }

    public m0(int i11, float f11) {
        n(i11, f11);
    }

    public m0(m0<? extends K> m0Var) {
        n(m0Var.C(), 1.0f);
        int iE = m0Var.e();
        while (iE != -1) {
            u(m0Var.i(iE), m0Var.k(iE));
            iE = m0Var.s(iE);
        }
    }

    public static long D(long j11, int i11) {
        return (j11 & (-4294967296L)) | (4294967295L & ((long) i11));
    }

    public static <K> m0<K> b() {
        return new m0<>();
    }

    public static <K> m0<K> c(int i11) {
        return new m0<>(i11);
    }

    public static int h(long j11) {
        return (int) (j11 >>> 32);
    }

    public static int j(long j11) {
        return (int) j11;
    }

    public static long[] q(int i11) {
        long[] jArr = new long[i11];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] r(int i11) {
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i11) {
        if (this.f38708e.length >= 1073741824) {
            this.f38711h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            return;
        }
        int i12 = ((int) (i11 * this.f38710g)) + 1;
        int[] iArrR = r(i11);
        long[] jArr = this.f38709f;
        int length = iArrR.length - 1;
        for (int i13 = 0; i13 < this.f38706c; i13++) {
            int iH = h(jArr[i13]);
            int i14 = iH & length;
            int i15 = iArrR[i14];
            iArrR[i14] = i13;
            jArr[i13] = (((long) iH) << 32) | (((long) i15) & 4294967295L);
        }
        this.f38711h = i12;
        this.f38708e = iArrR;
    }

    public void B(int i11, int i12) {
        com.google.common.base.m.n(i11, this.f38706c);
        this.f38705b[i11] = i12;
    }

    public int C() {
        return this.f38706c;
    }

    public void a() {
        this.f38707d++;
        Arrays.fill(this.f38704a, 0, this.f38706c, (Object) null);
        Arrays.fill(this.f38705b, 0, this.f38706c, 0);
        Arrays.fill(this.f38708e, -1);
        Arrays.fill(this.f38709f, -1L);
        this.f38706c = 0;
    }

    public void d(int i11) {
        if (i11 > this.f38709f.length) {
            y(i11);
        }
        if (i11 >= this.f38711h) {
            A(Math.max(2, Integer.highestOneBit(i11 - 1) << 1));
        }
    }

    public int e() {
        return this.f38706c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int iM = m(obj);
        if (iM == -1) {
            return 0;
        }
        return this.f38705b[iM];
    }

    public j0.a<K> g(int i11) {
        com.google.common.base.m.n(i11, this.f38706c);
        return new a(i11);
    }

    public K i(int i11) {
        com.google.common.base.m.n(i11, this.f38706c);
        return (K) this.f38704a[i11];
    }

    public int k(int i11) {
        com.google.common.base.m.n(i11, this.f38706c);
        return this.f38705b[i11];
    }

    public final int l() {
        return this.f38708e.length - 1;
    }

    public int m(Object obj) {
        int iD = c0.d(obj);
        int iJ = this.f38708e[l() & iD];
        while (iJ != -1) {
            long j11 = this.f38709f[iJ];
            if (h(j11) == iD && com.google.common.base.j.a(obj, this.f38704a[iJ])) {
                return iJ;
            }
            iJ = j(j11);
        }
        return -1;
    }

    public void n(int i11, float f11) {
        com.google.common.base.m.e(i11 >= 0, "Initial capacity must be non-negative");
        com.google.common.base.m.e(f11 > 0.0f, "Illegal load factor");
        int iA = c0.a(i11, f11);
        this.f38708e = r(iA);
        this.f38710g = f11;
        this.f38704a = new Object[i11];
        this.f38705b = new int[i11];
        this.f38709f = q(i11);
        this.f38711h = Math.max(1, (int) (iA * f11));
    }

    public void o(int i11, K k11, int i12, int i13) {
        this.f38709f[i11] = (((long) i13) << 32) | 4294967295L;
        this.f38704a[i11] = k11;
        this.f38705b[i11] = i12;
    }

    public void p(int i11) {
        int iC = C() - 1;
        if (i11 >= iC) {
            this.f38704a[i11] = null;
            this.f38705b[i11] = 0;
            this.f38709f[i11] = -1;
            return;
        }
        Object[] objArr = this.f38704a;
        objArr[i11] = objArr[iC];
        int[] iArr = this.f38705b;
        iArr[i11] = iArr[iC];
        objArr[iC] = null;
        iArr[iC] = 0;
        long[] jArr = this.f38709f;
        long j11 = jArr[iC];
        jArr[i11] = j11;
        jArr[iC] = -1;
        int iH = h(j11) & l();
        int[] iArr2 = this.f38708e;
        int i12 = iArr2[iH];
        if (i12 == iC) {
            iArr2[iH] = i11;
            return;
        }
        while (true) {
            long j12 = this.f38709f[i12];
            int iJ = j(j12);
            if (iJ == iC) {
                this.f38709f[i12] = D(j12, i11);
                return;
            }
            i12 = iJ;
        }
    }

    public int s(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.f38706c) {
            return i12;
        }
        return -1;
    }

    public int t(int i11, int i12) {
        return i11 - 1;
    }

    public int u(K k11, int i11) {
        l.d(i11, "count");
        long[] jArr = this.f38709f;
        Object[] objArr = this.f38704a;
        int[] iArr = this.f38705b;
        int iD = c0.d(k11);
        int iL = l() & iD;
        int i12 = this.f38706c;
        int[] iArr2 = this.f38708e;
        int i13 = iArr2[iL];
        if (i13 == -1) {
            iArr2[iL] = i12;
        } else {
            while (true) {
                long j11 = jArr[i13];
                if (h(j11) == iD && com.google.common.base.j.a(k11, objArr[i13])) {
                    int i14 = iArr[i13];
                    iArr[i13] = i11;
                    return i14;
                }
                int iJ = j(j11);
                if (iJ == -1) {
                    jArr[i13] = D(j11, i12);
                    break;
                }
                i13 = iJ;
            }
        }
        if (i12 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i15 = i12 + 1;
        z(i15);
        o(i12, k11, i11, iD);
        this.f38706c = i15;
        if (i12 >= this.f38711h) {
            A(this.f38708e.length * 2);
        }
        this.f38707d++;
        return 0;
    }

    public int v(Object obj) {
        return w(obj, c0.d(obj));
    }

    public final int w(Object obj, int i11) {
        int iL = l() & i11;
        int i12 = this.f38708e[iL];
        if (i12 == -1) {
            return 0;
        }
        int i13 = -1;
        while (true) {
            if (h(this.f38709f[i12]) == i11 && com.google.common.base.j.a(obj, this.f38704a[i12])) {
                int i14 = this.f38705b[i12];
                if (i13 == -1) {
                    this.f38708e[iL] = j(this.f38709f[i12]);
                } else {
                    long[] jArr = this.f38709f;
                    jArr[i13] = D(jArr[i13], j(jArr[i12]));
                }
                p(i12);
                this.f38706c--;
                this.f38707d++;
                return i14;
            }
            int iJ = j(this.f38709f[i12]);
            if (iJ == -1) {
                return 0;
            }
            i13 = i12;
            i12 = iJ;
        }
    }

    public int x(int i11) {
        return w(this.f38704a[i11], h(this.f38709f[i11]));
    }

    public void y(int i11) {
        this.f38704a = Arrays.copyOf(this.f38704a, i11);
        this.f38705b = Arrays.copyOf(this.f38705b, i11);
        long[] jArr = this.f38709f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i11);
        if (i11 > length) {
            Arrays.fill(jArrCopyOf, length, i11, -1L);
        }
        this.f38709f = jArrCopyOf;
    }

    public final void z(int i11) {
        int length = this.f38709f.length;
        if (i11 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (iMax != length) {
                y(iMax);
            }
        }
    }
}
