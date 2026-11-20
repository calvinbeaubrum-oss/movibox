package androidx.media3.datasource.cache;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends BufferedOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9731a;

    public r(OutputStream outputStream) {
        super(outputStream);
    }

    public r(OutputStream outputStream, int i11) {
        super(outputStream, i11);
    }

    public void a(OutputStream outputStream) {
        z3.a.g(this.f9731a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f9731a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f9731a = true;
        flush();
        th = null;
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            u0.m1(th);
        }
    }
}
