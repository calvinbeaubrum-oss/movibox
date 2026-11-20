package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class q7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparator<? super T> f39751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T[] f39752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f39753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f39754e;

    public q7(Comparator<? super T> comparator, int i11) {
        this.f39751b = (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(comparator, "comparator");
        this.f39750a = i11;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 >= 0, "k must be nonnegative, was %s", i11);
        this.f39752c = (T[]) new Object[i11 * 2];
        this.f39753d = 0;
        this.f39754e = null;
    }

    public static <T> q7<T> a(int i11, Comparator<? super T> comparator) {
        return new q7<>(comparator, i11);
    }

    public void b(T t11) {
        int i11 = this.f39750a;
        if (i11 == 0) {
            return;
        }
        int i12 = this.f39753d;
        if (i12 == 0) {
            this.f39752c[0] = t11;
            this.f39754e = t11;
            this.f39753d = 1;
            return;
        }
        if (i12 < i11) {
            T[] tArr = this.f39752c;
            this.f39753d = i12 + 1;
            tArr[i12] = t11;
            if (this.f39751b.compare(t11, this.f39754e) > 0) {
                this.f39754e = t11;
                return;
            }
            return;
        }
        if (this.f39751b.compare(t11, this.f39754e) < 0) {
            T[] tArr2 = this.f39752c;
            int i13 = this.f39753d;
            int i14 = i13 + 1;
            this.f39753d = i14;
            tArr2[i13] = t11;
            if (i14 == this.f39750a * 2) {
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
        T[] tArr = this.f39752c;
        T t11 = tArr[i13];
        tArr[i13] = tArr[i12];
        int i14 = i11;
        while (i11 < i12) {
            if (this.f39751b.compare(this.f39752c[i11], t11) < 0) {
                e(i14, i11);
                i14++;
            }
            i11++;
        }
        T[] tArr2 = this.f39752c;
        tArr2[i12] = tArr2[i14];
        tArr2[i14] = t11;
        return i14;
    }

    public final void e(int i11, int i12) {
        T[] tArr = this.f39752c;
        T t11 = tArr[i11];
        tArr[i11] = tArr[i12];
        tArr[i12] = t11;
    }

    public List<T> f() {
        Arrays.sort(this.f39752c, 0, this.f39753d, this.f39751b);
        int i11 = this.f39753d;
        int i12 = this.f39750a;
        if (i11 > i12) {
            T[] tArr = this.f39752c;
            Arrays.fill(tArr, i12, tArr.length, (Object) null);
            int i13 = this.f39750a;
            this.f39753d = i13;
            this.f39754e = this.f39752c[i13 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f39752c, this.f39753d)));
    }

    public final void g() {
        int i11 = (this.f39750a * 2) - 1;
        int iD = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.c.d(i11, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i12 = 0;
        int i13 = 0;
        while (iMax < i11) {
            int iD2 = d(iMax, i11, ((iMax + i11) + 1) >>> 1);
            int i14 = this.f39750a;
            if (iD2 <= i14) {
                if (iD2 >= i14) {
                    break;
                }
                iMax = Math.max(iD2, iMax + 1);
                i13 = iD2;
            } else {
                i11 = iD2 - 1;
            }
            i12++;
            if (i12 >= iD) {
                Arrays.sort(this.f39752c, iMax, i11, this.f39751b);
                break;
            }
        }
        this.f39753d = this.f39750a;
        this.f39754e = this.f39752c[i13];
        while (true) {
            i13++;
            if (i13 >= this.f39750a) {
                return;
            }
            if (this.f39751b.compare(this.f39752c[i13], this.f39754e) > 0) {
                this.f39754e = this.f39752c[i13];
            }
        }
    }
}
