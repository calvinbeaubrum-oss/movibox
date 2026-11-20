package e30;

import d30.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a extends BufferedInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f63797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f63798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f63799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f63800d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f63801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f63802g;

    public a(InputStream inputStream, int i11, int i12) {
        super(inputStream, i11);
        this.f63800d = 0L;
        d.d(i12 >= 0);
        this.f63798b = i12;
        this.f63801f = i12;
        this.f63797a = i12 != 0;
        this.f63799c = System.nanoTime();
    }

    public static a d(InputStream inputStream, int i11, int i12) {
        return inputStream instanceof a ? (a) inputStream : new a(inputStream, i11, i12);
    }

    public final boolean a() {
        return this.f63800d != 0 && System.nanoTime() - this.f63799c > this.f63800d;
    }

    public ByteBuffer b(int i11) throws IOException {
        d.e(i11 >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z11 = i11 > 0;
        int i12 = 32768;
        if (z11 && i11 < 32768) {
            i12 = i11;
        }
        byte[] bArr = new byte[i12];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i12);
        while (true) {
            int i13 = read(bArr);
            if (i13 == -1) {
                break;
            }
            if (z11) {
                if (i13 >= i11) {
                    byteArrayOutputStream.write(bArr, 0, i11);
                    break;
                }
                i11 -= i13;
            }
            byteArrayOutputStream.write(bArr, 0, i13);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public a c(long j11, long j12) {
        this.f63799c = j11;
        this.f63800d = j12 * 1000000;
        return this;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (this.f63802g || (this.f63797a && this.f63801f <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.f63802g = true;
            return -1;
        }
        if (a()) {
            throw new SocketTimeoutException("Read timeout");
        }
        if (this.f63797a && i12 > (i13 = this.f63801f)) {
            i12 = i13;
        }
        try {
            int i14 = super.read(bArr, i11, i12);
            this.f63801f -= i14;
            return i14;
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f63801f = this.f63798b - ((BufferedInputStream) this).markpos;
    }
}
