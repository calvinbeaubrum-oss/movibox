package tg;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f77029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f77030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f77031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f77032d;

    public g0(byte[] bArr) {
        this.f77029a = bArr;
        this.f77030b = bArr.length;
    }

    public final void a() {
        int i11;
        int i12 = this.f77031c;
        com.google.android.exoplayer2.util.a.g(i12 >= 0 && (i12 < (i11 = this.f77030b) || (i12 == i11 && this.f77032d == 0)));
    }

    public int b() {
        return (this.f77031c * 8) + this.f77032d;
    }

    public boolean c() {
        boolean z11 = (((this.f77029a[this.f77031c] & 255) >> this.f77032d) & 1) == 1;
        e(1);
        return z11;
    }

    public int d(int i11) {
        int i12 = this.f77031c;
        int iMin = Math.min(i11, 8 - this.f77032d);
        int i13 = i12 + 1;
        int i14 = ((this.f77029a[i12] & 255) >> this.f77032d) & (255 >> (8 - iMin));
        while (iMin < i11) {
            i14 |= (this.f77029a[i13] & 255) << iMin;
            iMin += 8;
            i13++;
        }
        int i15 = i14 & ((-1) >>> (32 - i11));
        e(i11);
        return i15;
    }

    public void e(int i11) {
        int i12 = i11 / 8;
        int i13 = this.f77031c + i12;
        this.f77031c = i13;
        int i14 = this.f77032d + (i11 - (i12 * 8));
        this.f77032d = i14;
        if (i14 > 7) {
            this.f77031c = i13 + 1;
            this.f77032d = i14 - 8;
        }
        a();
    }
}
