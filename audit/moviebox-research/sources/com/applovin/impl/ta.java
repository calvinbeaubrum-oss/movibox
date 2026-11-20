package com.applovin.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ta implements i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i5 f23218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f23220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f23221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23222e;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(bh bhVar);
    }

    public ta(i5 i5Var, int i11, a aVar) {
        b1.a(i11 > 0);
        this.f23218a = i5Var;
        this.f23219b = i11;
        this.f23220c = aVar;
        this.f23221d = new byte[1];
        this.f23222e = i11;
    }

    private boolean g() {
        if (this.f23218a.a(this.f23221d, 0, 1) == -1) {
            return false;
        }
        int i11 = (this.f23221d[0] & 255) << 4;
        if (i11 == 0) {
            return true;
        }
        byte[] bArr = new byte[i11];
        int i12 = i11;
        int i13 = 0;
        while (i12 > 0) {
            int iA = this.f23218a.a(bArr, i13, i12);
            if (iA == -1) {
                return false;
            }
            i13 += iA;
            i12 -= iA;
        }
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        if (i11 > 0) {
            this.f23220c.a(new bh(bArr, i11));
        }
        return true;
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) {
        if (this.f23222e == 0) {
            if (!g()) {
                return -1;
            }
            this.f23222e = this.f23219b;
        }
        int iA = this.f23218a.a(bArr, i11, Math.min(this.f23222e, i12));
        if (iA != -1) {
            this.f23222e -= iA;
        }
        return iA;
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.i5
    public void a(xo xoVar) {
        b1.a(xoVar);
        this.f23218a.a(xoVar);
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        return this.f23218a.c();
    }

    @Override // com.applovin.impl.i5
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.i5
    public Map e() {
        return this.f23218a.e();
    }
}
