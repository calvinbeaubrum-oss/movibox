package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class d {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f39849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f39850b;

        public b(double d11, double d12) {
            this.f39849a = d11;
            this.f39850b = d12;
        }

        public d a(double d11) {
            l.d(!Double.isNaN(d11));
            return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.b.c(d11) ? new C0419d(d11, this.f39850b - (this.f39849a * d11)) : new e(this.f39849a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f39851a = new c();

        public String toString() {
            return "NaN";
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0419d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f39852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f39853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f39854c = null;

        public C0419d(double d11, double d12) {
            this.f39852a = d11;
            this.f39853b = d12;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f39852a), Double.valueOf(this.f39853b));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f39855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f39856b = null;

        public e(double d11) {
            this.f39855a = d11;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f39855a));
        }
    }

    public static d a() {
        return c.f39851a;
    }

    public static d b(double d11) {
        l.d(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.b.c(d11));
        return new C0419d(0.0d, d11);
    }

    public static b c(double d11, double d12) {
        l.d(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.b.c(d11) && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.b.c(d12));
        return new b(d11, d12);
    }

    public static d d(double d11) {
        l.d(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.b.c(d11));
        return new e(d11);
    }
}
