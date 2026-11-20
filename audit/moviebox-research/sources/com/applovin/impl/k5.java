package com.applovin.impl;

import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k5 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i5 f20111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l5 f20112b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f20116f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20114d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f20115e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f20113c = new byte[1];

    public k5(i5 i5Var, l5 l5Var) {
        this.f20111a = i5Var;
        this.f20112b = l5Var;
    }

    private void a() {
        if (this.f20114d) {
            return;
        }
        this.f20111a.a(this.f20112b);
        this.f20114d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f20115e) {
            return;
        }
        this.f20111a.close();
        this.f20115e = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f20113c) == -1) {
            return -1;
        }
        return this.f20113c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        b1.b(!this.f20115e);
        a();
        int iA = this.f20111a.a(bArr, i11, i12);
        if (iA == -1) {
            return -1;
        }
        this.f20116f += (long) iA;
        return iA;
    }
}
