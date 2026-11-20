package c4;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a f14592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f14593b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14597g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14595d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14596f = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14594c = new byte[1];

    public e(androidx.media3.datasource.a aVar, g gVar) {
        this.f14592a = aVar;
        this.f14593b = gVar;
    }

    public final void a() throws IOException {
        if (this.f14595d) {
            return;
        }
        this.f14592a.a(this.f14593b);
        this.f14595d = true;
    }

    public void b() throws IOException {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f14596f) {
            return;
        }
        this.f14592a.close();
        this.f14596f = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f14594c) == -1) {
            return -1;
        }
        return this.f14594c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        z3.a.g(!this.f14596f);
        a();
        int i13 = this.f14592a.read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        this.f14597g += (long) i13;
        return i13;
    }
}
