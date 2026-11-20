package com.google.common.collect;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class n0<K> extends m0<K> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient long[] f38715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient int f38716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient int f38717k;

    public n0(int i11) {
        this(i11, 1.0f);
    }

    public n0(int i11, float f11) {
        super(i11, f11);
    }

    public final int E(int i11) {
        return (int) (this.f38715i[i11] >>> 32);
    }

    public final int F(int i11) {
        return (int) this.f38715i[i11];
    }

    public final void G(int i11, int i12) {
        long[] jArr = this.f38715i;
        jArr[i11] = (jArr[i11] & 4294967295L) | (((long) i12) << 32);
    }

    public final void H(int i11, int i12) {
        if (i11 == -2) {
            this.f38716j = i12;
        } else {
            I(i11, i12);
        }
        if (i12 == -2) {
            this.f38717k = i11;
        } else {
            G(i12, i11);
        }
    }

    public final void I(int i11, int i12) {
        long[] jArr = this.f38715i;
        jArr[i11] = (jArr[i11] & (-4294967296L)) | (((long) i12) & 4294967295L);
    }

    @Override // com.google.common.collect.m0
    public void a() {
        super.a();
        this.f38716j = -2;
        this.f38717k = -2;
    }

    @Override // com.google.common.collect.m0
    public int e() {
        int i11 = this.f38716j;
        if (i11 == -2) {
            return -1;
        }
        return i11;
    }

    @Override // com.google.common.collect.m0
    public void n(int i11, float f11) {
        super.n(i11, f11);
        this.f38716j = -2;
        this.f38717k = -2;
        long[] jArr = new long[i11];
        this.f38715i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.m0
    public void o(int i11, K k11, int i12, int i13) {
        super.o(i11, k11, i12, i13);
        H(this.f38717k, i11);
        H(i11, -2);
    }

    @Override // com.google.common.collect.m0
    public void p(int i11) {
        int iC = C() - 1;
        H(E(i11), F(i11));
        if (i11 < iC) {
            H(E(iC), i11);
            H(i11, F(iC));
        }
        super.p(i11);
    }

    @Override // com.google.common.collect.m0
    public int s(int i11) {
        int iF = F(i11);
        if (iF == -2) {
            return -1;
        }
        return iF;
    }

    @Override // com.google.common.collect.m0
    public int t(int i11, int i12) {
        return i11 == C() ? i12 : i11;
    }

    @Override // com.google.common.collect.m0
    public void y(int i11) {
        super.y(i11);
        long[] jArr = this.f38715i;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i11);
        this.f38715i = jArrCopyOf;
        Arrays.fill(jArrCopyOf, length, i11, -1L);
    }
}
