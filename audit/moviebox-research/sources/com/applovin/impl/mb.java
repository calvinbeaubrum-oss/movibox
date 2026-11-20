package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class mb implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f20648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f20649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f20650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20651d;

    public mb(long[] jArr, long[] jArr2, long j11) {
        b1.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z11 = length > 0;
        this.f20651d = z11;
        if (!z11 || jArr2[0] <= 0) {
            this.f20648a = jArr;
            this.f20649b = jArr2;
        } else {
            int i11 = length + 1;
            long[] jArr3 = new long[i11];
            this.f20648a = jArr3;
            long[] jArr4 = new long[i11];
            this.f20649b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f20650c = j11;
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        if (!this.f20651d) {
            return new ij.a(kj.f20255c);
        }
        int iB = xp.b(this.f20649b, j11, true, true);
        kj kjVar = new kj(this.f20649b[iB], this.f20648a[iB]);
        if (kjVar.f20256a == j11 || iB == this.f20649b.length - 1) {
            return new ij.a(kjVar);
        }
        int i11 = iB + 1;
        return new ij.a(kjVar, new kj(this.f20649b[i11], this.f20648a[i11]));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return this.f20651d;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f20650c;
    }
}
