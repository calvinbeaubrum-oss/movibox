package wt;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class l implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f79643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f79644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f79645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f79646d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f79647f;

    /* JADX INFO: compiled from: source.java */
    public class a extends ByteArrayOutputStream {
        public a(int i11) {
            super(i11);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i11 = ((ByteArrayOutputStream) this).count;
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (((ByteArrayOutputStream) this).buf[i12] == 13) {
                    i11 = i12;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i11, l.this.f79644b.name());
            } catch (UnsupportedEncodingException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public l(InputStream inputStream, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(d.f79597a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f79643a = inputStream;
        this.f79644b = charset;
        this.f79645c = new byte[8192];
    }

    public boolean b() {
        return this.f79647f == -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public String c() throws IOException {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f79643a) {
            try {
                if (this.f79645c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f79646d >= this.f79647f) {
                    d();
                }
                for (int i13 = this.f79646d; i13 != this.f79647f; i13++) {
                    byte[] bArr2 = this.f79645c;
                    if (bArr2[i13] == 10) {
                        int i14 = this.f79646d;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] != 13) {
                                i12 = i13;
                            }
                        } else {
                            i12 = i13;
                        }
                        String str = new String(bArr2, i14, i12 - i14, this.f79644b.name());
                        this.f79646d = i13 + 1;
                        return str;
                    }
                }
                a aVar = new a((this.f79647f - this.f79646d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f79645c;
                    int i15 = this.f79646d;
                    aVar.write(bArr3, i15, this.f79647f - i15);
                    this.f79647f = -1;
                    d();
                    i11 = this.f79646d;
                    while (i11 != this.f79647f) {
                        bArr = this.f79645c;
                        if (bArr[i11] == 10) {
                            break loop1;
                        }
                        i11++;
                    }
                }
                int i16 = this.f79646d;
                if (i11 != i16) {
                    aVar.write(bArr, i16, i11 - i16);
                }
                this.f79646d = i11 + 1;
                return aVar.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f79643a) {
            try {
                if (this.f79645c != null) {
                    this.f79645c = null;
                    this.f79643a.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d() throws IOException {
        InputStream inputStream = this.f79643a;
        byte[] bArr = this.f79645c;
        int i11 = inputStream.read(bArr, 0, bArr.length);
        if (i11 == -1) {
            throw new EOFException();
        }
        this.f79646d = 0;
        this.f79647f = i11;
    }
}
