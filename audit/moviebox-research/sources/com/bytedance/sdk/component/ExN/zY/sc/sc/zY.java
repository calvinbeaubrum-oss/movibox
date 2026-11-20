package com.bytedance.sdk.component.ExN.zY.sc.sc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class zY implements Closeable {
    private int ExN;
    private int We;
    private final Charset pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final InputStream f26528sc;
    private byte[] zY;

    public zY(InputStream inputStream, int i11, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(We.f26519sc)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f26528sc = inputStream;
        this.pFF = charset;
        this.zY = new byte[i11];
    }

    public zY(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void zY() throws IOException {
        InputStream inputStream = this.f26528sc;
        byte[] bArr = this.zY;
        int i11 = inputStream.read(bArr, 0, bArr.length);
        if (i11 == -1) {
            throw new EOFException();
        }
        this.We = 0;
        this.ExN = i11;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f26528sc) {
            try {
                if (this.zY != null) {
                    this.zY = null;
                    this.f26528sc.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean pFF() {
        return this.ExN == -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public String sc() throws IOException {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f26528sc) {
            try {
                if (this.zY == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.We >= this.ExN) {
                    zY();
                }
                for (int i13 = this.We; i13 != this.ExN; i13++) {
                    byte[] bArr2 = this.zY;
                    if (bArr2[i13] == 10) {
                        int i14 = this.We;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] != 13) {
                                i12 = i13;
                            }
                        } else {
                            i12 = i13;
                        }
                        String str = new String(bArr2, i14, i12 - i14, this.pFF.name());
                        this.We = i13 + 1;
                        return str;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.ExN - this.We) + 80) { // from class: com.bytedance.sdk.component.ExN.zY.sc.sc.zY.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i15 = ((ByteArrayOutputStream) this).count;
                        if (i15 > 0 && ((ByteArrayOutputStream) this).buf[i15 - 1] == 13) {
                            i15--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i15, zY.this.pFF.name());
                        } catch (UnsupportedEncodingException e11) {
                            throw new AssertionError(e11);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.zY;
                    int i15 = this.We;
                    byteArrayOutputStream.write(bArr3, i15, this.ExN - i15);
                    this.ExN = -1;
                    zY();
                    i11 = this.We;
                    while (i11 != this.ExN) {
                        bArr = this.zY;
                        if (bArr[i11] == 10) {
                            break loop1;
                        }
                        i11++;
                    }
                }
                int i16 = this.We;
                if (i11 != i16) {
                    byteArrayOutputStream.write(bArr, i16, i11 - i16);
                }
                this.We = i11 + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
