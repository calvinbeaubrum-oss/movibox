package com.bytedance.sdk.component.pFF.sc.sc.sc;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends InputStream {
    HttpURLConnection pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    InputStream f26957sc;

    public TRI(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.f26957sc = inputStream;
        this.pFF = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            inputStream.close();
            this.f26957sc = null;
        }
        HttpURLConnection httpURLConnection = this.pFF;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.pFF = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i11) {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            inputStream.mark(i11);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            return inputStream.read(bArr, i11, i12);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j11) throws IOException {
        InputStream inputStream = this.f26957sc;
        if (inputStream != null) {
            return inputStream.skip(j11);
        }
        return 0L;
    }
}
