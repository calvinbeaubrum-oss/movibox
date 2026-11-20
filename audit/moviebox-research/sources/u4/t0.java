package u4;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f78391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f78393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78394d;

    public t0(byte[] bArr) {
        this.f78391a = bArr;
        this.f78392b = bArr.length;
    }

    public final void a() {
        int i11;
        int i12 = this.f78393c;
        z3.a.g(i12 >= 0 && (i12 < (i11 = this.f78392b) || (i12 == i11 && this.f78394d == 0)));
    }

    public int b() {
        return (this.f78393c * 8) + this.f78394d;
    }

    public boolean c() {
        boolean z11 = (((this.f78391a[this.f78393c] & 255) >> this.f78394d) & 1) == 1;
        e(1);
        return z11;
    }

    public int d(int i11) {
        int i12 = this.f78393c;
        int iMin = Math.min(i11, 8 - this.f78394d);
        int i13 = i12 + 1;
        int i14 = ((this.f78391a[i12] & 255) >> this.f78394d) & (255 >> (8 - iMin));
        while (iMin < i11) {
            i14 |= (this.f78391a[i13] & 255) << iMin;
            iMin += 8;
            i13++;
        }
        int i15 = i14 & ((-1) >>> (32 - i11));
        e(i11);
        return i15;
    }

    public void e(int i11) {
        int i12 = i11 / 8;
        int i13 = this.f78393c + i12;
        this.f78393c = i13;
        int i14 = this.f78394d + (i11 - (i12 * 8));
        this.f78394d = i14;
        if (i14 > 7) {
            this.f78393c = i13 + 1;
            this.f78394d = i14 - 8;
        }
        a();
    }
}
