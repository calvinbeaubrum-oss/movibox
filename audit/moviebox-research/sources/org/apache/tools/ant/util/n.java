package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Reader f72987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f72988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f72989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72990d;

    public n(Reader reader) {
        this.f72988b = System.getProperty("file.encoding");
        this.f72987a = reader;
    }

    public n(Reader reader, String str) {
        this(reader);
        if (str == null) {
            throw new IllegalArgumentException("encoding must not be null");
        }
        this.f72988b = str;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        Reader reader = this.f72987a;
        if (reader == null) {
            throw new IOException("Stream Closed");
        }
        byte[] bArr = this.f72989c;
        if (bArr != null) {
            return bArr.length - this.f72990d;
        }
        return reader.ready() ? 1 : 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Reader reader = this.f72987a;
        if (reader != null) {
            reader.close();
            this.f72989c = null;
            this.f72987a = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i11) {
        try {
            this.f72987a.mark(i11);
        } catch (IOException e11) {
            throw new RuntimeException(e11.getMessage());
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        byte b11;
        int i11;
        try {
            if (this.f72987a == null) {
                throw new IOException("Stream Closed");
            }
            byte[] bArr = this.f72989c;
            if (bArr == null || (i11 = this.f72990d) >= bArr.length) {
                byte[] bArr2 = new byte[1];
                if (read(bArr2, 0, 1) <= 0) {
                    return -1;
                }
                b11 = bArr2[0];
            } else {
                b11 = bArr[i11];
                int i12 = i11 + 1;
                this.f72990d = i12;
                if (i12 == bArr.length) {
                    this.f72989c = null;
                }
            }
            return b11 & 255;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i11, int i12) throws IOException {
        try {
            if (this.f72987a == null) {
                throw new IOException("Stream Closed");
            }
            if (i12 == 0) {
                return 0;
            }
            while (true) {
                byte[] bArr2 = this.f72989c;
                if (bArr2 != null) {
                    int length = bArr2.length;
                    int i13 = this.f72990d;
                    if (i12 > length - i13) {
                        i12 = bArr2.length - i13;
                    }
                    System.arraycopy(bArr2, i13, bArr, i11, i12);
                    int i14 = this.f72990d + i12;
                    this.f72990d = i14;
                    if (i14 >= this.f72989c.length) {
                        this.f72989c = null;
                    }
                    return i12;
                }
                char[] cArr = new char[i12];
                int i15 = this.f72987a.read(cArr);
                if (i15 == -1) {
                    return -1;
                }
                if (i15 > 0) {
                    this.f72989c = new String(cArr, 0, i15).getBytes(this.f72988b);
                    this.f72990d = 0;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        Reader reader = this.f72987a;
        if (reader == null) {
            throw new IOException("Stream Closed");
        }
        this.f72989c = null;
        reader.reset();
    }
}
