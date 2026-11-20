package z3;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f81823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f81825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f81826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f81827e;

    public q() {
        this(16);
    }

    public q(int i11) {
        a.a(i11 >= 0 && i11 <= 1073741824);
        i11 = i11 == 0 ? 1 : i11;
        i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
        this.f81823a = 0;
        this.f81824b = -1;
        this.f81825c = 0;
        long[] jArr = new long[i11];
        this.f81826d = jArr;
        this.f81827e = jArr.length - 1;
    }

    public long a() {
        if (this.f81825c != 0) {
            return this.f81826d[this.f81823a];
        }
        throw new NoSuchElementException();
    }

    public boolean b() {
        return this.f81825c == 0;
    }

    public long c() {
        int i11 = this.f81825c;
        if (i11 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.f81826d;
        int i12 = this.f81823a;
        long j11 = jArr[i12];
        this.f81823a = this.f81827e & (i12 + 1);
        this.f81825c = i11 - 1;
        return j11;
    }
}
