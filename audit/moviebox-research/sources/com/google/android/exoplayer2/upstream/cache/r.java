package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.o0;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends BufferedOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f35371a;

    public r(OutputStream outputStream) {
        super(outputStream);
    }

    public r(OutputStream outputStream, int i11) {
        super(outputStream, i11);
    }

    public void a(OutputStream outputStream) {
        com.google.android.exoplayer2.util.a.g(this.f35371a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f35371a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f35371a = true;
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
            o0.R0(th);
        }
    }
}
