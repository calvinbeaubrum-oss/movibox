package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f6416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0066a[] f6417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6418c = true;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.motion.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0066a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static double[] f6419s = new double[91];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double[] f6420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f6421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f6422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f6423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f6424e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f6425f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f6426g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double f6427h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f6428i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f6429j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public double f6430k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public double f6431l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public double f6432m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double f6433n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double f6434o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public double f6435p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f6436q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f6437r;

        public C0066a(int i11, double d11, double d12, double d13, double d14, double d15, double d16) {
            this.f6437r = false;
            this.f6436q = i11 == 1;
            this.f6422c = d11;
            this.f6423d = d12;
            this.f6428i = 1.0d / (d12 - d11);
            if (3 == i11) {
                this.f6437r = true;
            }
            double d17 = d15 - d13;
            double d18 = d16 - d14;
            if (!this.f6437r && Math.abs(d17) >= 0.001d && Math.abs(d18) >= 0.001d) {
                this.f6420a = new double[101];
                boolean z11 = this.f6436q;
                this.f6429j = d17 * ((double) (z11 ? -1 : 1));
                this.f6430k = d18 * ((double) (z11 ? 1 : -1));
                this.f6431l = z11 ? d15 : d13;
                this.f6432m = z11 ? d14 : d16;
                a(d13, d14, d15, d16);
                this.f6433n = this.f6421b * this.f6428i;
                return;
            }
            this.f6437r = true;
            this.f6424e = d13;
            this.f6425f = d15;
            this.f6426g = d14;
            this.f6427h = d16;
            double dHypot = Math.hypot(d18, d17);
            this.f6421b = dHypot;
            this.f6433n = dHypot * this.f6428i;
            double d19 = this.f6423d;
            double d21 = this.f6422c;
            this.f6431l = d17 / (d19 - d21);
            this.f6432m = d18 / (d19 - d21);
        }

        public final void a(double d11, double d12, double d13, double d14) {
            double dHypot;
            double d15 = d13 - d11;
            double d16 = d12 - d14;
            int i11 = 0;
            double d17 = 0.0d;
            double d18 = 0.0d;
            double d19 = 0.0d;
            while (true) {
                double[] dArr = f6419s;
                if (i11 >= dArr.length) {
                    break;
                }
                double d21 = d17;
                double radians = Math.toRadians((((double) i11) * 90.0d) / ((double) (dArr.length - 1)));
                double dSin = Math.sin(radians) * d15;
                double dCos = Math.cos(radians) * d16;
                if (i11 > 0) {
                    dHypot = Math.hypot(dSin - d18, dCos - d19) + d21;
                    f6419s[i11] = dHypot;
                } else {
                    dHypot = d21;
                }
                i11++;
                d19 = dCos;
                d17 = dHypot;
                d18 = dSin;
            }
            double d22 = d17;
            this.f6421b = d22;
            int i12 = 0;
            while (true) {
                double[] dArr2 = f6419s;
                if (i12 >= dArr2.length) {
                    break;
                }
                dArr2[i12] = dArr2[i12] / d22;
                i12++;
            }
            int i13 = 0;
            while (true) {
                double[] dArr3 = this.f6420a;
                if (i13 >= dArr3.length) {
                    return;
                }
                double length = ((double) i13) / ((double) (dArr3.length - 1));
                int iBinarySearch = Arrays.binarySearch(f6419s, length);
                if (iBinarySearch >= 0) {
                    this.f6420a[i13] = ((double) iBinarySearch) / ((double) (f6419s.length - 1));
                } else if (iBinarySearch == -1) {
                    this.f6420a[i13] = 0.0d;
                } else {
                    int i14 = -iBinarySearch;
                    int i15 = i14 - 2;
                    double[] dArr4 = f6419s;
                    double d23 = dArr4[i15];
                    this.f6420a[i13] = (((double) i15) + ((length - d23) / (dArr4[i14 - 1] - d23))) / ((double) (dArr4.length - 1));
                }
                i13++;
            }
        }

        public double b() {
            double d11 = this.f6429j * this.f6435p;
            double dHypot = this.f6433n / Math.hypot(d11, (-this.f6430k) * this.f6434o);
            if (this.f6436q) {
                d11 = -d11;
            }
            return d11 * dHypot;
        }

        public double c() {
            double d11 = this.f6429j * this.f6435p;
            double d12 = (-this.f6430k) * this.f6434o;
            double dHypot = this.f6433n / Math.hypot(d11, d12);
            return this.f6436q ? (-d12) * dHypot : d12 * dHypot;
        }

        public double d(double d11) {
            return this.f6431l;
        }

        public double e(double d11) {
            return this.f6432m;
        }

        public double f(double d11) {
            double d12 = (d11 - this.f6422c) * this.f6428i;
            double d13 = this.f6424e;
            return d13 + (d12 * (this.f6425f - d13));
        }

        public double g(double d11) {
            double d12 = (d11 - this.f6422c) * this.f6428i;
            double d13 = this.f6426g;
            return d13 + (d12 * (this.f6427h - d13));
        }

        public double h() {
            return this.f6431l + (this.f6429j * this.f6434o);
        }

        public double i() {
            return this.f6432m + (this.f6430k * this.f6435p);
        }

        public double j(double d11) {
            if (d11 <= 0.0d) {
                return 0.0d;
            }
            if (d11 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f6420a;
            double length = d11 * ((double) (dArr.length - 1));
            int i11 = (int) length;
            double d12 = length - ((double) i11);
            double d13 = dArr[i11];
            return d13 + (d12 * (dArr[i11 + 1] - d13));
        }

        public void k(double d11) {
            double dJ = j((this.f6436q ? this.f6423d - d11 : d11 - this.f6422c) * this.f6428i) * 1.5707963267948966d;
            this.f6434o = Math.sin(dJ);
            this.f6435p = Math.cos(dJ);
        }
    }

    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.f6416a = dArr;
        this.f6417b = new C0066a[dArr.length - 1];
        int i11 = 0;
        int i12 = 1;
        int i13 = 1;
        while (true) {
            C0066a[] c0066aArr = this.f6417b;
            if (i11 >= c0066aArr.length) {
                return;
            }
            int i14 = iArr[i11];
            if (i14 == 0) {
                i13 = 3;
            } else if (i14 == 1) {
                i12 = 1;
                i13 = 1;
            } else if (i14 == 2) {
                i12 = 2;
                i13 = 2;
            } else if (i14 == 3) {
                i12 = i12 == 1 ? 2 : 1;
                i13 = i12;
            }
            double d11 = dArr[i11];
            int i15 = i11 + 1;
            double d12 = dArr[i15];
            double[] dArr3 = dArr2[i11];
            double d13 = dArr3[0];
            double d14 = dArr3[1];
            double[] dArr4 = dArr2[i15];
            c0066aArr[i11] = new C0066a(i13, d11, d12, d13, d14, dArr4[0], dArr4[1]);
            i11 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d11, int i11) {
        double dG;
        double dE;
        double dI;
        double dC;
        double dG2;
        double dE2;
        int i12 = 0;
        if (this.f6418c) {
            C0066a[] c0066aArr = this.f6417b;
            C0066a c0066a = c0066aArr[0];
            double d12 = c0066a.f6422c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (c0066a.f6437r) {
                    if (i11 == 0) {
                        dG2 = c0066a.f(d12);
                        dE2 = this.f6417b[0].d(d12);
                    } else {
                        dG2 = c0066a.g(d12);
                        dE2 = this.f6417b[0].e(d12);
                    }
                    return dG2 + (d13 * dE2);
                }
                c0066a.k(d12);
                if (i11 == 0) {
                    dI = this.f6417b[0].h();
                    dC = this.f6417b[0].b();
                } else {
                    dI = this.f6417b[0].i();
                    dC = this.f6417b[0].c();
                }
                return dI + (d13 * dC);
            }
            if (d11 > c0066aArr[c0066aArr.length - 1].f6423d) {
                double d14 = c0066aArr[c0066aArr.length - 1].f6423d;
                double d15 = d11 - d14;
                int length = c0066aArr.length - 1;
                if (i11 == 0) {
                    dG = c0066aArr[length].f(d14);
                    dE = this.f6417b[length].d(d14);
                } else {
                    dG = c0066aArr[length].g(d14);
                    dE = this.f6417b[length].e(d14);
                }
                return dG + (d15 * dE);
            }
        } else {
            C0066a[] c0066aArr2 = this.f6417b;
            double d16 = c0066aArr2[0].f6422c;
            if (d11 < d16) {
                d11 = d16;
            } else if (d11 > c0066aArr2[c0066aArr2.length - 1].f6423d) {
                d11 = c0066aArr2[c0066aArr2.length - 1].f6423d;
            }
        }
        while (true) {
            C0066a[] c0066aArr3 = this.f6417b;
            if (i12 >= c0066aArr3.length) {
                return Double.NaN;
            }
            C0066a c0066a2 = c0066aArr3[i12];
            if (d11 <= c0066a2.f6423d) {
                if (c0066a2.f6437r) {
                    return i11 == 0 ? c0066a2.f(d11) : c0066a2.g(d11);
                }
                c0066a2.k(d11);
                return i11 == 0 ? this.f6417b[i12].h() : this.f6417b[i12].i();
            }
            i12++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d11, double[] dArr) {
        if (this.f6418c) {
            C0066a[] c0066aArr = this.f6417b;
            C0066a c0066a = c0066aArr[0];
            double d12 = c0066a.f6422c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (c0066a.f6437r) {
                    dArr[0] = c0066a.f(d12) + (this.f6417b[0].d(d12) * d13);
                    dArr[1] = this.f6417b[0].g(d12) + (d13 * this.f6417b[0].e(d12));
                    return;
                } else {
                    c0066a.k(d12);
                    dArr[0] = this.f6417b[0].h() + (this.f6417b[0].b() * d13);
                    dArr[1] = this.f6417b[0].i() + (d13 * this.f6417b[0].c());
                    return;
                }
            }
            if (d11 > c0066aArr[c0066aArr.length - 1].f6423d) {
                double d14 = c0066aArr[c0066aArr.length - 1].f6423d;
                double d15 = d11 - d14;
                int length = c0066aArr.length - 1;
                C0066a c0066a2 = c0066aArr[length];
                if (c0066a2.f6437r) {
                    dArr[0] = c0066a2.f(d14) + (this.f6417b[length].d(d14) * d15);
                    dArr[1] = this.f6417b[length].g(d14) + (d15 * this.f6417b[length].e(d14));
                    return;
                } else {
                    c0066a2.k(d11);
                    dArr[0] = this.f6417b[length].h() + (this.f6417b[length].b() * d15);
                    dArr[1] = this.f6417b[length].i() + (d15 * this.f6417b[length].c());
                    return;
                }
            }
        } else {
            C0066a[] c0066aArr2 = this.f6417b;
            double d16 = c0066aArr2[0].f6422c;
            if (d11 < d16) {
                d11 = d16;
            }
            if (d11 > c0066aArr2[c0066aArr2.length - 1].f6423d) {
                d11 = c0066aArr2[c0066aArr2.length - 1].f6423d;
            }
        }
        int i11 = 0;
        while (true) {
            C0066a[] c0066aArr3 = this.f6417b;
            if (i11 >= c0066aArr3.length) {
                return;
            }
            C0066a c0066a3 = c0066aArr3[i11];
            if (d11 <= c0066a3.f6423d) {
                if (c0066a3.f6437r) {
                    dArr[0] = c0066a3.f(d11);
                    dArr[1] = this.f6417b[i11].g(d11);
                    return;
                } else {
                    c0066a3.k(d11);
                    dArr[0] = this.f6417b[i11].h();
                    dArr[1] = this.f6417b[i11].i();
                    return;
                }
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d11, float[] fArr) {
        if (this.f6418c) {
            C0066a[] c0066aArr = this.f6417b;
            C0066a c0066a = c0066aArr[0];
            double d12 = c0066a.f6422c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (c0066a.f6437r) {
                    fArr[0] = (float) (c0066a.f(d12) + (this.f6417b[0].d(d12) * d13));
                    fArr[1] = (float) (this.f6417b[0].g(d12) + (d13 * this.f6417b[0].e(d12)));
                    return;
                } else {
                    c0066a.k(d12);
                    fArr[0] = (float) (this.f6417b[0].h() + (this.f6417b[0].b() * d13));
                    fArr[1] = (float) (this.f6417b[0].i() + (d13 * this.f6417b[0].c()));
                    return;
                }
            }
            if (d11 > c0066aArr[c0066aArr.length - 1].f6423d) {
                double d14 = c0066aArr[c0066aArr.length - 1].f6423d;
                double d15 = d11 - d14;
                int length = c0066aArr.length - 1;
                C0066a c0066a2 = c0066aArr[length];
                if (c0066a2.f6437r) {
                    fArr[0] = (float) (c0066a2.f(d14) + (this.f6417b[length].d(d14) * d15));
                    fArr[1] = (float) (this.f6417b[length].g(d14) + (d15 * this.f6417b[length].e(d14)));
                    return;
                } else {
                    c0066a2.k(d11);
                    fArr[0] = (float) this.f6417b[length].h();
                    fArr[1] = (float) this.f6417b[length].i();
                    return;
                }
            }
        } else {
            C0066a[] c0066aArr2 = this.f6417b;
            double d16 = c0066aArr2[0].f6422c;
            if (d11 < d16) {
                d11 = d16;
            } else if (d11 > c0066aArr2[c0066aArr2.length - 1].f6423d) {
                d11 = c0066aArr2[c0066aArr2.length - 1].f6423d;
            }
        }
        int i11 = 0;
        while (true) {
            C0066a[] c0066aArr3 = this.f6417b;
            if (i11 >= c0066aArr3.length) {
                return;
            }
            C0066a c0066a3 = c0066aArr3[i11];
            if (d11 <= c0066a3.f6423d) {
                if (c0066a3.f6437r) {
                    fArr[0] = (float) c0066a3.f(d11);
                    fArr[1] = (float) this.f6417b[i11].g(d11);
                    return;
                } else {
                    c0066a3.k(d11);
                    fArr[0] = (float) this.f6417b[i11].h();
                    fArr[1] = (float) this.f6417b[i11].i();
                    return;
                }
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double f(double d11, int i11) {
        C0066a[] c0066aArr = this.f6417b;
        int i12 = 0;
        double d12 = c0066aArr[0].f6422c;
        if (d11 < d12) {
            d11 = d12;
        }
        if (d11 > c0066aArr[c0066aArr.length - 1].f6423d) {
            d11 = c0066aArr[c0066aArr.length - 1].f6423d;
        }
        while (true) {
            C0066a[] c0066aArr2 = this.f6417b;
            if (i12 >= c0066aArr2.length) {
                return Double.NaN;
            }
            C0066a c0066a = c0066aArr2[i12];
            if (d11 <= c0066a.f6423d) {
                if (c0066a.f6437r) {
                    return i11 == 0 ? c0066a.d(d11) : c0066a.e(d11);
                }
                c0066a.k(d11);
                return i11 == 0 ? this.f6417b[i12].b() : this.f6417b[i12].c();
            }
            i12++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void g(double d11, double[] dArr) {
        C0066a[] c0066aArr = this.f6417b;
        double d12 = c0066aArr[0].f6422c;
        if (d11 < d12) {
            d11 = d12;
        } else if (d11 > c0066aArr[c0066aArr.length - 1].f6423d) {
            d11 = c0066aArr[c0066aArr.length - 1].f6423d;
        }
        int i11 = 0;
        while (true) {
            C0066a[] c0066aArr2 = this.f6417b;
            if (i11 >= c0066aArr2.length) {
                return;
            }
            C0066a c0066a = c0066aArr2[i11];
            if (d11 <= c0066a.f6423d) {
                if (c0066a.f6437r) {
                    dArr[0] = c0066a.d(d11);
                    dArr[1] = this.f6417b[i11].e(d11);
                    return;
                } else {
                    c0066a.k(d11);
                    dArr[0] = this.f6417b[i11].b();
                    dArr[1] = this.f6417b[i11].c();
                    return;
                }
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f6416a;
    }
}
