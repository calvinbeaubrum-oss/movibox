package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class KeyCycleOscillator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.motion.utils.b f6388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6391d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6392e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6393f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<b> f6394g = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f6396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f6398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f6399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float[] f6400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double[] f6401g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f6402h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float[] f6403i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f6404j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float[] f6405k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f6406l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public androidx.constraintlayout.core.motion.utils.b f6407m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double[] f6408n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double[] f6409o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f6410p;

        public a(int i11, String str, int i12, int i13) {
            g gVar = new g();
            this.f6396b = gVar;
            this.f6397c = 0;
            this.f6398d = 1;
            this.f6399e = 2;
            this.f6406l = i11;
            this.f6395a = i12;
            gVar.g(i11, str);
            this.f6400f = new float[i13];
            this.f6401g = new double[i13];
            this.f6402h = new float[i13];
            this.f6403i = new float[i13];
            this.f6404j = new float[i13];
            this.f6405k = new float[i13];
        }

        public double a(float f11) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f6407m;
            if (bVar != null) {
                double d11 = f11;
                bVar.g(d11, this.f6409o);
                this.f6407m.d(d11, this.f6408n);
            } else {
                double[] dArr = this.f6409o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d12 = f11;
            double dE = this.f6396b.e(d12, this.f6408n[1]);
            double d13 = this.f6396b.d(d12, this.f6408n[1], this.f6409o[1]);
            double[] dArr2 = this.f6409o;
            return dArr2[0] + (dE * dArr2[2]) + (d13 * this.f6408n[2]);
        }

        public double b(float f11) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f6407m;
            if (bVar != null) {
                bVar.d(f11, this.f6408n);
            } else {
                double[] dArr = this.f6408n;
                dArr[0] = this.f6403i[0];
                dArr[1] = this.f6404j[0];
                dArr[2] = this.f6400f[0];
            }
            double[] dArr2 = this.f6408n;
            return dArr2[0] + (this.f6396b.e(f11, dArr2[1]) * this.f6408n[2]);
        }

        public void c(int i11, int i12, float f11, float f12, float f13, float f14) {
            this.f6401g[i11] = ((double) i12) / 100.0d;
            this.f6402h[i11] = f11;
            this.f6403i[i11] = f12;
            this.f6404j[i11] = f13;
            this.f6400f[i11] = f14;
        }

        public void d(float f11) {
            this.f6410p = f11;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f6401g.length, 3);
            float[] fArr = this.f6400f;
            this.f6408n = new double[fArr.length + 2];
            this.f6409o = new double[fArr.length + 2];
            if (this.f6401g[0] > 0.0d) {
                this.f6396b.a(0.0d, this.f6402h[0]);
            }
            double[] dArr2 = this.f6401g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f6396b.a(1.0d, this.f6402h[length]);
            }
            for (int i11 = 0; i11 < dArr.length; i11++) {
                double[] dArr3 = dArr[i11];
                dArr3[0] = this.f6403i[i11];
                dArr3[1] = this.f6404j[i11];
                dArr3[2] = this.f6400f[i11];
                this.f6396b.a(this.f6401g[i11], this.f6402h[i11]);
            }
            this.f6396b.f();
            double[] dArr4 = this.f6401g;
            if (dArr4.length > 1) {
                this.f6407m = androidx.constraintlayout.core.motion.utils.b.a(0, dArr4, dArr);
            } else {
                this.f6407m = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f6414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f6415e;

        public b(int i11, float f11, float f12, float f13, float f14) {
            this.f6411a = i11;
            this.f6412b = f14;
            this.f6413c = f12;
            this.f6414d = f11;
            this.f6415e = f13;
        }
    }

    public float a(float f11) {
        return (float) this.f6389b.b(f11);
    }

    public float b(float f11) {
        return (float) this.f6389b.a(f11);
    }

    public void c(Object obj) {
    }

    public void d(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14) {
        this.f6394g.add(new b(i11, f11, f12, f13, f14));
        if (i13 != -1) {
            this.f6393f = i13;
        }
        this.f6391d = i12;
        this.f6392e = str;
    }

    public void e(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14, Object obj) {
        this.f6394g.add(new b(i11, f11, f12, f13, f14));
        if (i13 != -1) {
            this.f6393f = i13;
        }
        this.f6391d = i12;
        c(obj);
        this.f6392e = str;
    }

    public void f(String str) {
        this.f6390c = str;
    }

    public void g(float f11) {
        int size = this.f6394g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f6394g, new Comparator<b>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(b bVar, b bVar2) {
                return Integer.compare(bVar.f6411a, bVar2.f6411a);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f6389b = new a(this.f6391d, this.f6392e, this.f6393f, size);
        int i11 = 0;
        for (b bVar : this.f6394g) {
            float f12 = bVar.f6414d;
            dArr[i11] = ((double) f12) * 0.01d;
            double[] dArr3 = dArr2[i11];
            float f13 = bVar.f6412b;
            dArr3[0] = f13;
            float f14 = bVar.f6413c;
            dArr3[1] = f14;
            float f15 = bVar.f6415e;
            dArr3[2] = f15;
            this.f6389b.c(i11, bVar.f6411a, f12, f14, f15, f13);
            i11++;
        }
        this.f6389b.d(f11);
        this.f6388a = androidx.constraintlayout.core.motion.utils.b.a(0, dArr, dArr2);
    }

    public boolean h() {
        return this.f6393f == 1;
    }

    public String toString() {
        String str = this.f6390c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (b bVar : this.f6394g) {
            str = str + "[" + bVar.f6411a + " , " + decimalFormat.format(bVar.f6412b) + "] ";
        }
        return str;
    }
}
