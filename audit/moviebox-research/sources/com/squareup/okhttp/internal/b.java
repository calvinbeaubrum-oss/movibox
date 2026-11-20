package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b extends ForwardingSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49069a;

    public b(Sink sink) {
        super(sink);
    }

    public void a(IOException iOException) {
        throw null;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f49069a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e11) {
            this.f49069a = true;
            a(e11);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f49069a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e11) {
            this.f49069a = true;
            a(e11);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j11) throws IOException {
        if (this.f49069a) {
            buffer.skip(j11);
            return;
        }
        try {
            super.write(buffer, j11);
        } catch (IOException e11) {
            this.f49069a = true;
            a(e11);
        }
    }
}
