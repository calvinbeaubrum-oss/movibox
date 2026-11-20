package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f72981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f72982b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f72984d;

    /* JADX INFO: compiled from: source.java */
    public final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f72985a;

        public a() {
            this.f72985a = false;
            synchronized (m.this) {
                m.a(m.this);
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            m.this.h(this);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            synchronized (m.this) {
                m.this.f();
                m.this.f72981a.flush();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i11) throws IOException {
            synchronized (m.this) {
                m.this.f();
                m.this.f72981a.write(i11);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            synchronized (m.this) {
                m.this.f();
                m.this.f72981a.write(bArr);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i11, int i12) throws IOException {
            synchronized (m.this) {
                m.this.f();
                m.this.f72981a.write(bArr, i11, i12);
            }
        }
    }

    public m(OutputStream outputStream, long j11) {
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStreamFunneler.<init>:  out == null");
        }
        this.f72981a = outputStream;
        this.f72983c = false;
        i(j11);
    }

    public static /* synthetic */ int a(m mVar) {
        int i11 = mVar.f72982b + 1;
        mVar.f72982b = i11;
        return i11;
    }

    public final synchronized void e() throws IOException {
        try {
            f();
            this.f72981a.close();
            this.f72983c = true;
        } catch (Throwable th2) {
            this.f72983c = true;
            throw th2;
        }
    }

    public final synchronized void f() throws IOException {
        if (this.f72983c) {
            throw new IOException("The funneled OutputStream has been closed.");
        }
    }

    public synchronized OutputStream g() throws IOException {
        a aVar;
        f();
        try {
            aVar = new a();
            notifyAll();
        } catch (Throwable th2) {
            notifyAll();
            throw th2;
        }
        return aVar;
    }

    public final synchronized void h(a aVar) throws IOException {
        try {
            if (!aVar.f72985a) {
                try {
                    long j11 = this.f72984d;
                    if (j11 > 0) {
                        try {
                            wait(j11);
                        } catch (InterruptedException unused) {
                        }
                    }
                    int i11 = this.f72982b - 1;
                    this.f72982b = i11;
                    if (i11 == 0) {
                        e();
                    }
                    aVar.f72985a = true;
                } catch (Throwable th2) {
                    aVar.f72985a = true;
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public synchronized void i(long j11) {
        this.f72984d = j11;
    }
}
