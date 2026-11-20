package jm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f68083h = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f68084i = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f68085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f68086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f68087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f68088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f68089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f68090o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f68091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f68092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f68093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f68094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f68096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f68097g;

    static {
        a aVar = new a(67, 64, 1);
        f68085j = aVar;
        f68086k = new a(19, 16, 1);
        f68087l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f68088m = aVar2;
        f68089n = aVar2;
        f68090o = aVar;
    }

    public a(int i11, int i12, int i13) {
        this.f68096f = i11;
        this.f68095e = i12;
        this.f68097g = i13;
        this.f68091a = new int[i12];
        this.f68092b = new int[i12];
        int i14 = 1;
        for (int i15 = 0; i15 < i12; i15++) {
            this.f68091a[i15] = i14;
            i14 *= 2;
            if (i14 >= i12) {
                i14 = (i14 ^ i11) & (i12 - 1);
            }
        }
        for (int i16 = 0; i16 < i12 - 1; i16++) {
            this.f68092b[this.f68091a[i16]] = i16;
        }
        this.f68093c = new b(this, new int[]{0});
        this.f68094d = new b(this, new int[]{1});
    }

    public static int a(int i11, int i12) {
        return i11 ^ i12;
    }

    public b b(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException();
        }
        if (i12 == 0) {
            return this.f68093c;
        }
        int[] iArr = new int[i11 + 1];
        iArr[0] = i12;
        return new b(this, iArr);
    }

    public int c(int i11) {
        return this.f68091a[i11];
    }

    public int d() {
        return this.f68097g;
    }

    public b e() {
        return this.f68094d;
    }

    public int f() {
        return this.f68095e;
    }

    public b g() {
        return this.f68093c;
    }

    public int h(int i11) {
        if (i11 != 0) {
            return this.f68091a[(this.f68095e - this.f68092b[i11]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i11) {
        if (i11 != 0) {
            return this.f68092b[i11];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i11, int i12) {
        if (i11 == 0 || i12 == 0) {
            return 0;
        }
        int[] iArr = this.f68091a;
        int[] iArr2 = this.f68092b;
        return iArr[(iArr2[i11] + iArr2[i12]) % (this.f68095e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f68096f) + ',' + this.f68095e + ')';
    }
}
