package org.apache.tools.ant.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FileOutputStream f72971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f72972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f72974d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f72975f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f72976g = false;

    public h(File file, boolean z11, boolean z12) {
        this.f72972b = file;
        this.f72973c = z11;
        this.f72974d = z12;
    }

    public final synchronized void a() throws IOException {
        if (this.f72976g) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f72972b);
            stringBuffer.append(" has already been closed.");
            throw new IOException(stringBuffer.toString());
        }
        if (!this.f72975f) {
            this.f72971a = new FileOutputStream(this.f72972b.getAbsolutePath(), this.f72973c);
            this.f72975f = true;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f72974d && !this.f72976g) {
                a();
            }
            if (this.f72975f) {
                this.f72971a.close();
            }
            this.f72976g = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i11) throws IOException {
        a();
        this.f72971a.write(i11);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i11, int i12) throws IOException {
        a();
        this.f72971a.write(bArr, i11, i12);
    }
}
