package fh;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f64919a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f64920b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f64921c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f64922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f64923e;

    public i() {
        int[] iArr = new int[16];
        this.f64922d = iArr;
        this.f64923e = iArr.length - 1;
    }

    public void a(int i11) {
        if (this.f64921c == this.f64922d.length) {
            c();
        }
        int i12 = (this.f64920b + 1) & this.f64923e;
        this.f64920b = i12;
        this.f64922d[i12] = i11;
        this.f64921c++;
    }

    public void b() {
        this.f64919a = 0;
        this.f64920b = -1;
        this.f64921c = 0;
    }

    public final void c() {
        int[] iArr = this.f64922d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i11 = this.f64919a;
        int i12 = length2 - i11;
        System.arraycopy(iArr, i11, iArr2, 0, i12);
        System.arraycopy(this.f64922d, 0, iArr2, i12, i11);
        this.f64919a = 0;
        this.f64920b = this.f64921c - 1;
        this.f64922d = iArr2;
        this.f64923e = iArr2.length - 1;
    }

    public boolean d() {
        return this.f64921c == 0;
    }

    public int e() {
        int i11 = this.f64921c;
        if (i11 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f64922d;
        int i12 = this.f64919a;
        int i13 = iArr[i12];
        this.f64919a = (i12 + 1) & this.f64923e;
        this.f64921c = i11 - 1;
        return i13;
    }
}
