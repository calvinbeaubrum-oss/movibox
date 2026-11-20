package com.google.common.math;

import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f38795a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f38796b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f38797c = 0.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f38798d = Double.NaN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f38799e = Double.NaN;

    public static double g(double d11, double d12) {
        if (Doubles.f(d11)) {
            return d12;
        }
        if (Doubles.f(d12) || d11 == d12) {
            return d11;
        }
        return Double.NaN;
    }

    public void a(double d11) {
        long j11 = this.f38795a;
        if (j11 == 0) {
            this.f38795a = 1L;
            this.f38796b = d11;
            this.f38798d = d11;
            this.f38799e = d11;
            if (Doubles.f(d11)) {
                return;
            }
            this.f38797c = Double.NaN;
            return;
        }
        this.f38795a = j11 + 1;
        if (Doubles.f(d11) && Doubles.f(this.f38796b)) {
            double d12 = this.f38796b;
            double d13 = d11 - d12;
            double d14 = d12 + (d13 / this.f38795a);
            this.f38796b = d14;
            this.f38797c += d13 * (d11 - d14);
        } else {
            this.f38796b = g(this.f38796b, d11);
            this.f38797c = Double.NaN;
        }
        this.f38798d = Math.min(this.f38798d, d11);
        this.f38799e = Math.max(this.f38799e, d11);
    }

    public void b(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void c(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d11 : dArr) {
            a(d11);
        }
    }

    public void e(int... iArr) {
        for (int i11 : iArr) {
            a(i11);
        }
    }

    public void f(long... jArr) {
        for (long j11 : jArr) {
            a(j11);
        }
    }

    public Stats h() {
        return new Stats(this.f38795a, this.f38796b, this.f38797c, this.f38798d, this.f38799e);
    }
}
