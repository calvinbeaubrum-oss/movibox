package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class q extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f72994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OutputStream f72995b;

    public q(OutputStream outputStream, OutputStream outputStream2) {
        this.f72994a = outputStream;
        this.f72995b = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f72994a.close();
        } finally {
            this.f72995b.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f72994a.flush();
        this.f72995b.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i11) throws IOException {
        this.f72994a.write(i11);
        this.f72995b.write(i11);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f72994a.write(bArr);
        this.f72995b.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.f72994a.write(bArr, i11, i12);
        this.f72995b.write(bArr, i11, i12);
    }
}
