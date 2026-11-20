package com.applovin.impl;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class kf implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f20250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f20251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f20252c;

    private kf(long[] jArr, long[] jArr2, long j11) {
        this.f20250a = jArr;
        this.f20251b = jArr2;
        this.f20252c = j11 == C.TIME_UNSET ? t2.a(jArr2[jArr2.length - 1]) : j11;
    }

    private static Pair a(long j11, long[] jArr, long[] jArr2) {
        int iB = xp.b(jArr, j11, true, true);
        long j12 = jArr[iB];
        long j13 = jArr2[iB];
        int i11 = iB + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j12), Long.valueOf(j13));
        }
        long j14 = jArr[i11];
        return Pair.create(Long.valueOf(j11), Long.valueOf(((long) ((j14 == j12 ? 0.0d : (j11 - j12) / (j14 - j12)) * (jArr2[i11] - j13))) + j13));
    }

    public static kf a(long j11, jf jfVar, long j12) {
        int length = jfVar.f19946f.length;
        int i11 = length + 1;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        jArr[0] = j11;
        long j13 = 0;
        jArr2[0] = 0;
        for (int i12 = 1; i12 <= length; i12++) {
            int i13 = i12 - 1;
            j11 += (long) (jfVar.f19944c + jfVar.f19946f[i13]);
            j13 += (long) (jfVar.f19945d + jfVar.f19947g[i13]);
            jArr[i12] = j11;
            jArr2[i12] = j13;
        }
        return new kf(jArr, jArr2, j12);
    }

    @Override // com.applovin.impl.lj
    public long a(long j11) {
        return t2.a(((Long) a(j11, this.f20250a, this.f20251b).second).longValue());
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        Pair pairA = a(t2.b(xp.b(j11, 0L, this.f20252c)), this.f20251b, this.f20250a);
        return new ij.a(new kj(t2.a(((Long) pairA.first).longValue()), ((Long) pairA.second).longValue()));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return -1L;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f20252c;
    }
}
