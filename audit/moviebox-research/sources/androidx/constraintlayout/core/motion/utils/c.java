package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f6440b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String[] f6441c = {"standard", "accelerate", "decelerate", "linear"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6442a = "identity";

    /* JADX INFO: compiled from: source.java */
    public static class a extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static double f6443h = 0.01d;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static double f6444i = 1.0E-4d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f6445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f6446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f6447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f6448g;

        public a(String str) {
            this.f6442a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f6445d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i11 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i11);
            this.f6446e = Double.parseDouble(str.substring(i11, iIndexOf3).trim());
            int i12 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i12);
            this.f6447f = Double.parseDouble(str.substring(i12, iIndexOf4).trim());
            int i13 = iIndexOf4 + 1;
            this.f6448g = Double.parseDouble(str.substring(i13, str.indexOf(41, i13)).trim());
        }

        @Override // androidx.constraintlayout.core.motion.utils.c
        public double a(double d11) {
            if (d11 <= 0.0d) {
                return 0.0d;
            }
            if (d11 >= 1.0d) {
                return 1.0d;
            }
            double d12 = 0.5d;
            double d13 = 0.5d;
            while (d12 > f6443h) {
                d12 *= 0.5d;
                d13 = d(d13) < d11 ? d13 + d12 : d13 - d12;
            }
            double d14 = d13 - d12;
            double d15 = d(d14);
            double d16 = d13 + d12;
            double d17 = d(d16);
            double dE = e(d14);
            return (((e(d16) - dE) * (d11 - d15)) / (d17 - d15)) + dE;
        }

        @Override // androidx.constraintlayout.core.motion.utils.c
        public double b(double d11) {
            double d12 = 0.5d;
            double d13 = 0.5d;
            while (d12 > f6444i) {
                d12 *= 0.5d;
                d13 = d(d13) < d11 ? d13 + d12 : d13 - d12;
            }
            double d14 = d13 - d12;
            double d15 = d13 + d12;
            return (e(d15) - e(d14)) / (d(d15) - d(d14));
        }

        public final double d(double d11) {
            double d12 = 1.0d - d11;
            double d13 = 3.0d * d12;
            return (this.f6445d * d12 * d13 * d11) + (this.f6447f * d13 * d11 * d11) + (d11 * d11 * d11);
        }

        public final double e(double d11) {
            double d12 = 1.0d - d11;
            double d13 = 3.0d * d12;
            return (this.f6446e * d12 * d13 * d11) + (this.f6448g * d13 * d11 * d11) + (d11 * d11 * d11);
        }
    }

    public static c c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new k(str);
        }
        if (str.startsWith("Schlick")) {
            return new h(str);
        }
        switch (str) {
            case "accelerate":
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case "decelerate":
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case "anticipate":
                return new a("cubic(0.36, 0, 0.66, -0.56)");
            case "linear":
                return new a("cubic(1, 1, 0, 0)");
            case "overshoot":
                return new a("cubic(0.34, 1.56, 0.64, 1)");
            case "standard":
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f6441c));
                return f6440b;
        }
    }

    public double a(double d11) {
        return d11;
    }

    public double b(double d11) {
        return 1.0d;
    }

    public String toString() {
        return this.f6442a;
    }
}
