package com.applovin.impl;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b6 implements l8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g5 f17867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f17868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17869d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17872g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f17870e = new byte[65536];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f17866a = new byte[4096];

    public b6(g5 g5Var, long j11, long j12) {
        this.f17867b = g5Var;
        this.f17869d = j11;
        this.f17868c = j12;
    }

    private int a(byte[] bArr, int i11, int i12, int i13, boolean z11) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int iA = this.f17867b.a(bArr, i11 + i13, i12 - i13);
        if (iA != -1) {
            return i13 + iA;
        }
        if (i13 == 0 && z11) {
            return -1;
        }
        throw new EOFException();
    }

    private void d(int i11) {
        if (i11 != -1) {
            this.f17869d += (long) i11;
        }
    }

    private int e(byte[] bArr, int i11, int i12) {
        int i13 = this.f17872g;
        if (i13 == 0) {
            return 0;
        }
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.f17870e, 0, bArr, i11, iMin);
        g(iMin);
        return iMin;
    }

    private void e(int i11) {
        int i12 = this.f17871f + i11;
        byte[] bArr = this.f17870e;
        if (i12 > bArr.length) {
            this.f17870e = Arrays.copyOf(this.f17870e, xp.a(bArr.length * 2, 65536 + i12, i12 + 524288));
        }
    }

    private int f(int i11) {
        int iMin = Math.min(this.f17872g, i11);
        g(iMin);
        return iMin;
    }

    private void g(int i11) {
        int i12 = this.f17872g - i11;
        this.f17872g = i12;
        this.f17871f = 0;
        byte[] bArr = this.f17870e;
        byte[] bArr2 = i12 < bArr.length - 524288 ? new byte[65536 + i12] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.f17870e = bArr2;
    }

    @Override // com.applovin.impl.l8, com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) throws EOFException, InterruptedIOException {
        int iE = e(bArr, i11, i12);
        if (iE == 0) {
            iE = a(bArr, i11, i12, 0, true);
        }
        d(iE);
        return iE;
    }

    @Override // com.applovin.impl.l8
    public long a() {
        return this.f17868c;
    }

    @Override // com.applovin.impl.l8
    public void a(int i11) throws EOFException, InterruptedIOException {
        b(i11, false);
    }

    @Override // com.applovin.impl.l8
    public boolean a(int i11, boolean z11) throws EOFException, InterruptedIOException {
        e(i11);
        int iA = this.f17872g - this.f17871f;
        while (iA < i11) {
            iA = a(this.f17870e, this.f17871f, i11, iA, z11);
            if (iA == -1) {
                return false;
            }
            this.f17872g = this.f17871f + iA;
        }
        this.f17871f += i11;
        return true;
    }

    @Override // com.applovin.impl.l8
    public boolean a(byte[] bArr, int i11, int i12, boolean z11) throws EOFException, InterruptedIOException {
        int iE = e(bArr, i11, i12);
        while (iE < i12 && iE != -1) {
            iE = a(bArr, i11, i12, iE, z11);
        }
        d(iE);
        return iE != -1;
    }

    @Override // com.applovin.impl.l8
    public int b(int i11) throws EOFException, InterruptedIOException {
        int iF = f(i11);
        if (iF == 0) {
            byte[] bArr = this.f17866a;
            iF = a(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        d(iF);
        return iF;
    }

    @Override // com.applovin.impl.l8
    public int b(byte[] bArr, int i11, int i12) throws EOFException, InterruptedIOException {
        int iMin;
        e(i12);
        int i13 = this.f17872g;
        int i14 = this.f17871f;
        int i15 = i13 - i14;
        if (i15 == 0) {
            iMin = a(this.f17870e, i14, i12, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.f17872g += iMin;
        } else {
            iMin = Math.min(i12, i15);
        }
        System.arraycopy(this.f17870e, this.f17871f, bArr, i11, iMin);
        this.f17871f += iMin;
        return iMin;
    }

    @Override // com.applovin.impl.l8
    public void b() {
        this.f17871f = 0;
    }

    public boolean b(int i11, boolean z11) throws EOFException, InterruptedIOException {
        int iF = f(i11);
        while (iF < i11 && iF != -1) {
            iF = a(this.f17866a, -iF, Math.min(i11, this.f17866a.length + iF), iF, z11);
        }
        d(iF);
        return iF != -1;
    }

    @Override // com.applovin.impl.l8
    public boolean b(byte[] bArr, int i11, int i12, boolean z11) {
        if (!a(i12, z11)) {
            return false;
        }
        System.arraycopy(this.f17870e, this.f17871f - i12, bArr, i11, i12);
        return true;
    }

    @Override // com.applovin.impl.l8
    public void c(int i11) throws EOFException, InterruptedIOException {
        a(i11, false);
    }

    @Override // com.applovin.impl.l8
    public void c(byte[] bArr, int i11, int i12) {
        b(bArr, i11, i12, false);
    }

    @Override // com.applovin.impl.l8
    public long d() {
        return this.f17869d + ((long) this.f17871f);
    }

    @Override // com.applovin.impl.l8
    public void d(byte[] bArr, int i11, int i12) throws EOFException, InterruptedIOException {
        a(bArr, i11, i12, false);
    }

    @Override // com.applovin.impl.l8
    public long f() {
        return this.f17869d;
    }
}
