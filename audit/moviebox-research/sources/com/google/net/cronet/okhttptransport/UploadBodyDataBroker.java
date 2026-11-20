package com.google.net.cronet.okhttptransport;

import android.util.Pair;
import com.google.common.base.m;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.b0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class UploadBodyDataBroker implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue<Pair<ByteBuffer, b0<ReadResult>>> f41124a = new ArrayBlockingQueue(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f41125b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Throwable> f41126c = new AtomicReference<>();

    /* JADX INFO: compiled from: source.java */
    public enum ReadResult {
        SUCCESS,
        END_OF_BODY
    }

    private Pair<ByteBuffer, b0<ReadResult>> b() throws IOException {
        try {
            return this.f41124a.take();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while waiting for a read to finish!");
        }
    }

    public Future<ReadResult> a(ByteBuffer byteBuffer) {
        Throwable th2 = this.f41126c.get();
        if (th2 != null) {
            return Futures.f(th2);
        }
        b0 b0VarB = b0.b();
        this.f41124a.add(Pair.create(byteBuffer, b0VarB));
        Throwable th3 = this.f41126c.get();
        if (th3 != null) {
            b0VarB.setException(th3);
        }
        return b0VarB;
    }

    public void c() throws IOException {
        if (this.f41125b.getAndSet(true)) {
            throw new IllegalStateException("Already closed");
        }
        ((b0) b().second).set(ReadResult.END_OF_BODY);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f41125b.set(true);
    }

    public void d(Throwable th2) {
        this.f41126c.set(th2);
        Pair<ByteBuffer, b0<ReadResult>> pairPoll = this.f41124a.poll();
        if (pairPoll != null) {
            ((b0) pairPoll.second).setException(th2);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j11) throws IOException {
        m.v(!this.f41125b.get());
        while (j11 != 0) {
            Pair<ByteBuffer, b0<ReadResult>> pairB = b();
            ByteBuffer byteBuffer = (ByteBuffer) pairB.first;
            b0 b0Var = (b0) pairB.second;
            int iLimit = byteBuffer.limit();
            byteBuffer.limit((int) Math.min(iLimit, j11));
            try {
                long j12 = buffer.read(byteBuffer);
                if (j12 == -1) {
                    IOException iOException = new IOException("The source has been exhausted but we expected more!");
                    b0Var.setException(iOException);
                    throw iOException;
                }
                j11 -= j12;
                byteBuffer.limit(iLimit);
                b0Var.set(ReadResult.SUCCESS);
            } catch (IOException e11) {
                b0Var.setException(e11);
                throw e11;
            }
        }
    }
}
