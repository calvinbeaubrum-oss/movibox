package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f73025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f73027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f73028d;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i11, byte[] bArr) throws IOException {
        d dVar = new d();
        this.f73028d = dVar;
        if (i11 <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i11);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.f73025a = new byte[i11];
        this.f73026b = 0;
        this.f73027c = 0;
        try {
            d.c(dVar, inputStream);
            if (bArr != null) {
                c.s(dVar, bArr);
            }
        } catch (BrotliRuntimeException e11) {
            throw new IOException("Brotli decoder initialization failed", e11);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        d.a(this.f73028d);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f73027c >= this.f73026b) {
            byte[] bArr = this.f73025a;
            int i11 = read(bArr, 0, bArr.length);
            this.f73026b = i11;
            this.f73027c = 0;
            if (i11 == -1) {
                return -1;
            }
        }
        byte[] bArr2 = this.f73025a;
        int i12 = this.f73027c;
        this.f73027c = i12 + 1;
        return bArr2[i12] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i11 < 0) {
            throw new IllegalArgumentException("Bad offset: " + i11);
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("Bad length: " + i12);
        }
        int i13 = i11 + i12;
        if (i13 > bArr.length) {
            throw new IllegalArgumentException("Buffer overflow: " + i13 + " > " + bArr.length);
        }
        if (i12 == 0) {
            return 0;
        }
        int iMax = Math.max(this.f73026b - this.f73027c, 0);
        if (iMax != 0) {
            iMax = Math.min(iMax, i12);
            System.arraycopy(this.f73025a, this.f73027c, bArr, i11, iMax);
            this.f73027c += iMax;
            i11 += iMax;
            i12 -= iMax;
            if (i12 == 0) {
                return iMax;
            }
        }
        try {
            d dVar = this.f73028d;
            dVar.Z = bArr;
            dVar.U = i11;
            dVar.V = i12;
            dVar.W = 0;
            c.i(dVar);
            int i14 = this.f73028d.W;
            if (i14 == 0) {
                return -1;
            }
            return i14 + iMax;
        } catch (BrotliRuntimeException e11) {
            throw new IOException("Brotli stream decoding failed", e11);
        }
    }
}
