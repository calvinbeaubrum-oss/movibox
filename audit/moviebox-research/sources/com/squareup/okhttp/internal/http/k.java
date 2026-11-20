package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Buffer f49315c;

    public k() {
        this(-1);
    }

    public k(int i11) {
        this.f49315c = new Buffer();
        this.f49314b = i11;
    }

    public long a() throws IOException {
        return this.f49315c.size();
    }

    public void b(Sink sink) throws IOException {
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.f49315c;
        buffer2.copyTo(buffer, 0L, buffer2.size());
        sink.write(buffer, buffer.size());
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f49313a) {
            return;
        }
        this.f49313a = true;
        if (this.f49315c.size() >= this.f49314b) {
            return;
        }
        throw new ProtocolException("content-length promised " + this.f49314b + " bytes, but received " + this.f49315c.size());
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j11) throws IOException {
        if (this.f49313a) {
            throw new IllegalStateException("closed");
        }
        com.squareup.okhttp.internal.g.a(buffer.size(), 0L, j11);
        if (this.f49314b == -1 || this.f49315c.size() <= ((long) this.f49314b) - j11) {
            this.f49315c.write(buffer, j11);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.f49314b + " bytes");
    }
}
