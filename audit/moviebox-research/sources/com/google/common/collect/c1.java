package com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparator<? super T> f38679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T[] f38680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f38681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f38682e;

    public c1(Comparator<? super T> comparator, int i11) {
        this.f38679b = (Comparator) com.google.common.base.m.q(comparator, "comparator");
        this.f38678a = i11;
        com.google.common.base.m.g(i11 >= 0, "k (%s) must be >= 0", i11);
        com.google.common.base.m.g(i11 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i11);
        this.f38680c = (T[]) new Object[com.google.common.math.d.b(i11, 2)];
        this.f38681d = 0;
        this.f38682e = null;
    }

    public static <T> c1<T> a(int i11, Comparator<? super T> comparator) {
        return new c1<>(comparator, i11);
    }

    public void b(T t11) {
        int i11 = this.f38678a;
        if (i11 == 0) {
            return;
        }
        int i12 = this.f38681d;
        if (i12 == 0) {
            this.f38680c[0] = t11;
            this.f38682e = t11;
            this.f38681d = 1;
            return;
        }
        if (i12 < i11) {
            T[] tArr = this.f38680c;
            this.f38681d = i12 + 1;
            tArr[i12] = t11;
            if (this.f38679b.compare(t11, (Object) k0.a(this.f38682e)) > 0) {
                this.f38682e = t11;
                return;
            }
            return;
        }
        if (this.f38679b.compare(t11, (Object) k0.a(this.f38682e)) < 0) {
            T[] tArr2 = this.f38680c;
            int i13 = this.f38681d;
            int i14 = i13 + 1;
            this.f38681d = i14;
            tArr2[i13] = t11;
            if (i14 == this.f38678a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final int d(int i11, int i12, int i13) {
        Object objA = k0.a(this.f38680c[i13]);
        T[] tArr = this.f38680c;
        tArr[i13] = tArr[i12];
        int i14 = i11;
        while (i11 < i12) {
            if (this.f38679b.compare((Object) k0.a(this.f38680c[i11]), objA) < 0) {
                e(i14, i11);
                i14++;
            }
            i11++;
        }
        T[] tArr2 = this.f38680c;
        tArr2[i12] = tArr2[i14];
        tArr2[i14] = objA;
        return i14;
    }

    public final void e(int i11, int i12) {
        T[] tArr = this.f38680c;
        T t11 = tArr[i11];
        tArr[i11] = tArr[i12];
        tArr[i12] = t11;
    }

    public List<T> f() {
        T[] tArr = this.f38680c;
        Arrays.sort(tArr, 0, this.f38681d, this.f38679b);
        int i11 = this.f38681d;
        int i12 = this.f38678a;
        if (i11 > i12) {
            T[] tArr2 = this.f38680c;
            Arrays.fill(tArr2, i12, tArr2.length, (Object) null);
            int i13 = this.f38678a;
            this.f38681d = i13;
            this.f38682e = this.f38680c[i13 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(tArr, this.f38681d)));
    }

    public final void g() {
        int i11 = (this.f38678a * 2) - 1;
        int iF = com.google.common.math.d.f(i11, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i12 = 0;
        int i13 = 0;
        while (iMax < i11) {
            int iD = d(iMax, i11, ((iMax + i11) + 1) >>> 1);
            int i14 = this.f38678a;
            if (iD <= i14) {
                if (iD >= i14) {
                    break;
                }
                iMax = Math.max(iD, iMax + 1);
                i13 = iD;
            } else {
                i11 = iD - 1;
            }
            i12++;
            if (i12 >= iF) {
                Arrays.sort(this.f38680c, iMax, i11 + 1, this.f38679b);
                break;
            }
        }
        this.f38681d = this.f38678a;
        this.f38682e = (T) k0.a(this.f38680c[i13]);
        while (true) {
            i13++;
            if (i13 >= this.f38678a) {
                return;
            }
            if (this.f38679b.compare((Object) k0.a(this.f38680c[i13]), (Object) k0.a(this.f38682e)) > 0) {
                this.f38682e = this.f38680c[i13];
            }
        }
    }
}
