package com.cloud.hisavana.net.disklrucache;

import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class StrictLineReader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f28995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f28996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f28997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28998d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f28999f;

    public StrictLineReader(InputStream inputStream, int i11, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(DiskLruCacheUtil.f29010a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f28995a = inputStream;
        this.f28996b = charset;
        this.f28997c = new byte[i11];
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f28995a;
        byte[] bArr = this.f28997c;
        int i11 = inputStream.read(bArr, 0, bArr.length);
        if (i11 == -1) {
            throw new EOFException();
        }
        this.f28998d = 0;
        this.f28999f = i11;
    }

    public boolean c() {
        return this.f28999f == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f28995a) {
            try {
                if (this.f28997c != null) {
                    this.f28997c = null;
                    this.f28995a.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public String d() throws IOException {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f28995a) {
            try {
                if (this.f28997c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f28998d >= this.f28999f) {
                    b();
                }
                for (int i13 = this.f28998d; i13 != this.f28999f; i13++) {
                    byte[] bArr2 = this.f28997c;
                    if (bArr2[i13] == 10) {
                        int i14 = this.f28998d;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] != 13) {
                                i12 = i13;
                            }
                        } else {
                            i12 = i13;
                        }
                        String str = new String(bArr2, i14, i12 - i14, this.f28996b.name());
                        this.f28998d = i13 + 1;
                        return str;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f28999f - this.f28998d) + 80) { // from class: com.cloud.hisavana.net.disklrucache.StrictLineReader.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i15 = ((ByteArrayOutputStream) this).count;
                        if (i15 > 0 && ((ByteArrayOutputStream) this).buf[i15 - 1] == 13) {
                            i15--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i15, StrictLineReader.this.f28996b.name());
                        } catch (UnsupportedEncodingException e11) {
                            throw new AssertionError(e11);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.f28997c;
                    int i15 = this.f28998d;
                    byteArrayOutputStream.write(bArr3, i15, this.f28999f - i15);
                    this.f28999f = -1;
                    b();
                    i11 = this.f28998d;
                    while (i11 != this.f28999f) {
                        bArr = this.f28997c;
                        if (bArr[i11] == 10) {
                            break loop1;
                        }
                        i11++;
                    }
                }
                int i16 = this.f28998d;
                if (i11 != i16) {
                    byteArrayOutputStream.write(bArr, i16, i11 - i16);
                }
                this.f28998d = i11 + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
