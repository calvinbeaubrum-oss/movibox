package wm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f79552f = new b(929, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f79553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f79554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f79555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f79556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f79557e;

    public b(int i11, int i12) {
        this.f79557e = i11;
        this.f79553a = new int[i11];
        this.f79554b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f79553a[i14] = i13;
            i13 = (i13 * i12) % i11;
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f79554b[this.f79553a[i15]] = i15;
        }
        this.f79555c = new c(this, new int[]{0});
        this.f79556d = new c(this, new int[]{1});
    }

    public int a(int i11, int i12) {
        return (i11 + i12) % this.f79557e;
    }

    public c b(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException();
        }
        if (i12 == 0) {
            return this.f79555c;
        }
        int[] iArr = new int[i11 + 1];
        iArr[0] = i12;
        return new c(this, iArr);
    }

    public int c(int i11) {
        return this.f79553a[i11];
    }

    public c d() {
        return this.f79556d;
    }

    public int e() {
        return this.f79557e;
    }

    public c f() {
        return this.f79555c;
    }

    public int g(int i11) {
        if (i11 != 0) {
            return this.f79553a[(this.f79557e - this.f79554b[i11]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i11) {
        if (i11 != 0) {
            return this.f79554b[i11];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i11, int i12) {
        if (i11 == 0 || i12 == 0) {
            return 0;
        }
        int[] iArr = this.f79553a;
        int[] iArr2 = this.f79554b;
        return iArr[(iArr2[i11] + iArr2[i12]) % (this.f79557e - 1)];
    }

    public int j(int i11, int i12) {
        int i13 = this.f79557e;
        return ((i11 + i13) - i12) % i13;
    }
}
