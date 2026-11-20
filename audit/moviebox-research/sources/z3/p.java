package z3;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f81821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f81822b;

    public p() {
        this(32);
    }

    public p(int i11) {
        this.f81822b = new long[i11];
    }

    public void a(long j11) {
        int i11 = this.f81821a;
        long[] jArr = this.f81822b;
        if (i11 == jArr.length) {
            this.f81822b = Arrays.copyOf(jArr, i11 * 2);
        }
        long[] jArr2 = this.f81822b;
        int i12 = this.f81821a;
        this.f81821a = i12 + 1;
        jArr2[i12] = j11;
    }

    public long b(int i11) {
        if (i11 >= 0 && i11 < this.f81821a) {
            return this.f81822b[i11];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i11 + ", size is " + this.f81821a);
    }

    public int c() {
        return this.f81821a;
    }
}
