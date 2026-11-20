package com.google.common.math;

import com.google.common.base.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f38779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f38780b;

        public b(double d11, double d12) {
            this.f38779a = d11;
            this.f38780b = d12;
        }

        public e a(double d11) {
            m.d(!Double.isNaN(d11));
            return com.google.common.math.c.c(d11) ? new d(d11, this.f38780b - (this.f38779a * d11)) : new C0400e(this.f38779a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f38781a = new c();

        public String toString() {
            return "NaN";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f38782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f38783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f38784c = null;

        public d(double d11, double d12) {
            this.f38782a = d11;
            this.f38783b = d12;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f38782a), Double.valueOf(this.f38783b));
        }
    }

    /* JADX INFO: renamed from: com.google.common.math.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0400e extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f38785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f38786b = null;

        public C0400e(double d11) {
            this.f38785a = d11;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f38785a));
        }
    }

    public static e a() {
        return c.f38781a;
    }

    public static e b(double d11) {
        m.d(com.google.common.math.c.c(d11));
        return new d(0.0d, d11);
    }

    public static b c(double d11, double d12) {
        m.d(com.google.common.math.c.c(d11) && com.google.common.math.c.c(d12));
        return new b(d11, d12);
    }

    public static e d(double d11) {
        m.d(com.google.common.math.c.c(d11));
        return new C0400e(d11);
    }
}
