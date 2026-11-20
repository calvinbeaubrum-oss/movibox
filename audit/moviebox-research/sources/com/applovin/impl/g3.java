package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g3 implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f19154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f19155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f19156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f19157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19158f;

    public g3(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f19154b = iArr;
        this.f19155c = jArr;
        this.f19156d = jArr2;
        this.f19157e = jArr3;
        int length = iArr.length;
        this.f19153a = length;
        if (length <= 0) {
            this.f19158f = 0L;
        } else {
            int i11 = length - 1;
            this.f19158f = jArr2[i11] + jArr3[i11];
        }
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        int iC = c(j11);
        kj kjVar = new kj(this.f19157e[iC], this.f19155c[iC]);
        if (kjVar.f20256a >= j11 || iC == this.f19153a - 1) {
            return new ij.a(kjVar);
        }
        int i11 = iC + 1;
        return new ij.a(kjVar, new kj(this.f19157e[i11], this.f19155c[i11]));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    public int c(long j11) {
        return xp.b(this.f19157e, j11, true, true);
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f19158f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f19153a + ", sizes=" + Arrays.toString(this.f19154b) + ", offsets=" + Arrays.toString(this.f19155c) + ", timeUs=" + Arrays.toString(this.f19157e) + ", durationsUs=" + Arrays.toString(this.f19156d) + ")";
    }
}
