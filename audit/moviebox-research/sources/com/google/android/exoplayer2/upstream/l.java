package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f35416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f35417b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f35421g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35419d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f35420f = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f35418c = new byte[1];

    public l(k kVar, n nVar) {
        this.f35416a = kVar;
        this.f35417b = nVar;
    }

    public final void a() throws IOException {
        if (this.f35419d) {
            return;
        }
        this.f35416a.a(this.f35417b);
        this.f35419d = true;
    }

    public void b() throws IOException {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f35420f) {
            return;
        }
        this.f35416a.close();
        this.f35420f = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f35418c) == -1) {
            return -1;
        }
        return this.f35418c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        com.google.android.exoplayer2.util.a.g(!this.f35420f);
        a();
        int i13 = this.f35416a.read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        this.f35421g += (long) i13;
        return i13;
    }
}
