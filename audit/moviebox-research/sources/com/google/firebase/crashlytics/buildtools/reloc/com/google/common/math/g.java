package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Doubles;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f39865a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f39866b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f39867c = 0.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f39868d = Double.NaN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f39869e = Double.NaN;

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
        long j11 = this.f39865a;
        if (j11 == 0) {
            this.f39865a = 1L;
            this.f39866b = d11;
            this.f39868d = d11;
            this.f39869e = d11;
            if (Doubles.f(d11)) {
                return;
            }
            this.f39867c = Double.NaN;
            return;
        }
        this.f39865a = j11 + 1;
        if (Doubles.f(d11) && Doubles.f(this.f39866b)) {
            double d12 = this.f39866b;
            double d13 = d11 - d12;
            double d14 = d12 + (d13 / this.f39865a);
            this.f39866b = d14;
            this.f39867c += d13 * (d11 - d14);
        } else {
            this.f39866b = g(this.f39866b, d11);
            this.f39867c = Double.NaN;
        }
        this.f39868d = Math.min(this.f39868d, d11);
        this.f39869e = Math.max(this.f39869e, d11);
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
        return new Stats(this.f39865a, this.f39866b, this.f39867c, this.f39868d, this.f39869e);
    }
}
