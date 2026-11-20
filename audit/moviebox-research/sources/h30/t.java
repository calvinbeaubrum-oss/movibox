package h30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y[] f66216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l[] f66217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f66218c = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f66219d = new byte[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f66220e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f66221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f66223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f66224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f66225j;

    public t(int i11) {
        h(i11);
        d();
    }

    public void a() {
        y yVar;
        if (this.f66223h) {
            return;
        }
        if (this.f66221f == 2) {
            if (this.f66216a[this.f66220e[0]].b().equals("GB18030")) {
                yVar = this.f66216a[this.f66220e[1]];
            } else if (this.f66216a[this.f66220e[1]].b().equals("GB18030")) {
                yVar = this.f66216a[this.f66220e[0]];
            }
            c(yVar.b());
            this.f66223h = true;
        }
        if (this.f66224i) {
            f(null, 0, true);
        }
    }

    public boolean b(byte[] bArr, int i11) {
        int i12;
        y yVar;
        for (int i13 = 0; i13 < i11; i13++) {
            byte b11 = bArr[i13];
            int i14 = 0;
            while (true) {
                i12 = this.f66221f;
                if (i14 >= i12) {
                    break;
                }
                byte bC = y.c(this.f66216a[this.f66220e[i14]], b11, this.f66219d[i14]);
                if (bC == 2) {
                    yVar = this.f66216a[this.f66220e[i14]];
                } else if (bC == 1) {
                    int i15 = this.f66221f - 1;
                    this.f66221f = i15;
                    if (i14 < i15) {
                        int[] iArr = this.f66220e;
                        iArr[i14] = iArr[i15];
                        byte[] bArr2 = this.f66219d;
                        bArr2[i14] = bArr2[i15];
                    }
                } else {
                    this.f66219d[i14] = bC;
                    i14++;
                }
                c(yVar.b());
                this.f66223h = true;
                return true;
            }
            if (i12 <= 1) {
                if (1 == i12) {
                    c(this.f66216a[this.f66220e[0]].b());
                }
                this.f66223h = true;
                return true;
            }
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < this.f66221f; i18++) {
                if (!this.f66216a[this.f66220e[i18]].d() && !this.f66216a[this.f66220e[i18]].d()) {
                    i16++;
                    i17 = i18;
                }
            }
            if (1 == i16) {
                yVar = this.f66216a[this.f66220e[i17]];
                c(yVar.b());
                this.f66223h = true;
                return true;
            }
        }
        if (this.f66224i) {
            e(bArr, i11);
        }
        return this.f66223h;
    }

    public abstract void c(String str);

    public void d() {
        this.f66224i = this.f66225j;
        this.f66223h = false;
        this.f66221f = this.f66222g;
        for (int i11 = 0; i11 < this.f66221f; i11++) {
            this.f66219d[i11] = 0;
            this.f66220e[i11] = i11;
        }
        this.f66218c.f();
    }

    public void e(byte[] bArr, int i11) {
        f(bArr, i11, false);
    }

    public void f(byte[] bArr, int i11, boolean z11) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < this.f66221f; i14++) {
            l[] lVarArr = this.f66217b;
            int i15 = this.f66220e[i14];
            if (lVarArr[i15] != null) {
                i12++;
            }
            if (!this.f66216a[i15].d() && !this.f66216a[this.f66220e[i14]].b().equals("GB18030")) {
                i13++;
            }
        }
        boolean z12 = i12 > 1;
        this.f66224i = z12;
        if (z12) {
            this.f66224i = this.f66218c.g(bArr, i11);
            if (((z11 && this.f66218c.e()) || this.f66218c.b()) && i12 == i13) {
                this.f66218c.a();
                int i16 = -1;
                float f11 = 0.0f;
                int i17 = 0;
                for (int i18 = 0; i18 < this.f66221f; i18++) {
                    l[] lVarArr2 = this.f66217b;
                    int i19 = this.f66220e[i18];
                    if (lVarArr2[i19] != null && !this.f66216a[i19].b().equals("Big5")) {
                        float fC = this.f66218c.c(this.f66217b[this.f66220e[i18]].a(), this.f66217b[this.f66220e[i18]].b(), this.f66217b[this.f66220e[i18]].c(), this.f66217b[this.f66220e[i18]].d());
                        int i21 = i17 + 1;
                        if (i17 == 0 || f11 > fC) {
                            i16 = i18;
                            f11 = fC;
                        }
                        i17 = i21;
                    }
                }
                if (i16 >= 0) {
                    c(this.f66216a[this.f66220e[i16]].b());
                    this.f66223h = true;
                }
            }
        }
    }

    public String[] g() {
        int i11 = this.f66221f;
        if (i11 <= 0) {
            return new String[]{"nomatch"};
        }
        String[] strArr = new String[i11];
        for (int i12 = 0; i12 < this.f66221f; i12++) {
            strArr[i12] = this.f66216a[this.f66220e[i12]].b();
        }
        return strArr;
    }

    public void h(int i11) {
        int i12 = i11;
        if (i12 < 0 || i12 >= 6) {
            i12 = 0;
        }
        this.f66216a = null;
        this.f66217b = null;
        if (i12 == 4) {
            this.f66216a = new y[]{new x(), new f(), new q(), new m(), new g(), new v(), new w()};
            this.f66217b = new l[]{null, new a(), null, new d(), null, null, null};
        } else if (i12 == 5) {
            this.f66216a = new y[]{new x(), new j(), new s(), new g(), new v(), new w()};
        } else if (i12 == 3) {
            this.f66216a = new y[]{new x(), new o(), new n(), new q(), new p(), new g(), new v(), new w()};
        } else if (i12 == 1) {
            this.f66216a = new y[]{new x(), new u(), new i(), new r(), new g(), new v(), new w()};
        } else if (i12 == 2) {
            this.f66216a = new y[]{new x(), new o(), new n(), new f(), new q(), new p(), new m(), new g(), new v(), new w()};
            this.f66217b = new l[]{null, new e(), null, new a(), null, null, new d(), null, null, null};
        } else if (i12 == 0) {
            this.f66216a = new y[]{new x(), new u(), new i(), new r(), new j(), new s(), new f(), new m(), new o(), new n(), new q(), new p(), new g(), new v(), new w()};
            this.f66217b = new l[]{null, null, new b(), null, new c(), null, new a(), new d(), new e(), null, null, null, null, null, null};
        }
        this.f66225j = this.f66217b != null;
        this.f66222g = this.f66216a.length;
    }
}
