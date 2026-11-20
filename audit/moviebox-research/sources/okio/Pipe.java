package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j11) {
        this.maxBufferSize = j11;
        if (j11 >= 1) {
            this.sink = new Sink() { // from class: okio.Pipe.sink.1
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    boolean zHasDeadline;
                    synchronized (Pipe.this.getBuffer$okio()) {
                        try {
                            if (Pipe.this.getSinkClosed$okio()) {
                                return;
                            }
                            Sink foldedSink$okio = Pipe.this.getFoldedSink$okio();
                            if (foldedSink$okio == null) {
                                if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                                    throw new IOException("source is closed");
                                }
                                Pipe.this.setSinkClosed$okio(true);
                                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                                if (buffer$okio == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                }
                                buffer$okio.notifyAll();
                                foldedSink$okio = null;
                            }
                            Unit unit = Unit.f68710a;
                            if (foldedSink$okio != null) {
                                Pipe pipe = Pipe.this;
                                Timeout timeout = foldedSink$okio.timeout();
                                Timeout timeout2 = pipe.sink().timeout();
                                long jTimeoutNanos = timeout.timeoutNanos();
                                timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                                if (!timeout.hasDeadline()) {
                                    if (timeout2.hasDeadline()) {
                                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                    }
                                    try {
                                        foldedSink$okio.close();
                                        if (zHasDeadline) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    } finally {
                                        timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                        if (timeout2.hasDeadline()) {
                                            timeout.clearDeadline();
                                        }
                                    }
                                }
                                long jDeadlineNanoTime = timeout.deadlineNanoTime();
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                                }
                                try {
                                    foldedSink$okio.close();
                                } finally {
                                    timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.hasDeadline()) {
                                        timeout.deadlineNanoTime(jDeadlineNanoTime);
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink$okio;
                    boolean zHasDeadline;
                    synchronized (Pipe.this.getBuffer$okio()) {
                        try {
                            if (!(!Pipe.this.getSinkClosed$okio())) {
                                throw new IllegalStateException("closed".toString());
                            }
                            if (Pipe.this.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                            foldedSink$okio = Pipe.this.getFoldedSink$okio();
                            if (foldedSink$okio == null) {
                                if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                                    throw new IOException("source is closed");
                                }
                                foldedSink$okio = null;
                            }
                            Unit unit = Unit.f68710a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (foldedSink$okio != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.flush();
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                        } finally {
                            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        }
                    }
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    return this.timeout;
                }

                @Override // okio.Sink
                public void write(Buffer source, long j12) {
                    Sink foldedSink$okio;
                    boolean zHasDeadline;
                    Intrinsics.g(source, "source");
                    synchronized (Pipe.this.getBuffer$okio()) {
                        try {
                            if (!(!Pipe.this.getSinkClosed$okio())) {
                                throw new IllegalStateException("closed".toString());
                            }
                            if (Pipe.this.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                            while (true) {
                                if (j12 <= 0) {
                                    foldedSink$okio = null;
                                    break;
                                }
                                foldedSink$okio = Pipe.this.getFoldedSink$okio();
                                if (foldedSink$okio != null) {
                                    break;
                                }
                                if (Pipe.this.getSourceClosed$okio()) {
                                    throw new IOException("source is closed");
                                }
                                long maxBufferSize$okio = Pipe.this.getMaxBufferSize$okio() - Pipe.this.getBuffer$okio().size();
                                if (maxBufferSize$okio == 0) {
                                    this.timeout.waitUntilNotified(Pipe.this.getBuffer$okio());
                                    if (Pipe.this.getCanceled$okio()) {
                                        throw new IOException("canceled");
                                    }
                                } else {
                                    long jMin = Math.min(maxBufferSize$okio, j12);
                                    Pipe.this.getBuffer$okio().write(source, jMin);
                                    j12 -= jMin;
                                    Buffer buffer$okio = Pipe.this.getBuffer$okio();
                                    if (buffer$okio == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                    }
                                    buffer$okio.notifyAll();
                                }
                            }
                            Unit unit = Unit.f68710a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (foldedSink$okio != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.write(source, j12);
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.write(source, j12);
                        } finally {
                            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        }
                    }
                }
            };
            this.source = new Source() { // from class: okio.Pipe.source.1
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Pipe.this.getBuffer$okio()) {
                        Pipe.this.setSourceClosed$okio(true);
                        Buffer buffer$okio = Pipe.this.getBuffer$okio();
                        if (buffer$okio == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer$okio.notifyAll();
                        Unit unit = Unit.f68710a;
                    }
                }

                @Override // okio.Source
                public long read(Buffer sink, long j12) {
                    Intrinsics.g(sink, "sink");
                    synchronized (Pipe.this.getBuffer$okio()) {
                        try {
                            if (!(!Pipe.this.getSourceClosed$okio())) {
                                throw new IllegalStateException("closed".toString());
                            }
                            if (Pipe.this.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                            while (Pipe.this.getBuffer$okio().size() == 0) {
                                if (Pipe.this.getSinkClosed$okio()) {
                                    return -1L;
                                }
                                this.timeout.waitUntilNotified(Pipe.this.getBuffer$okio());
                                if (Pipe.this.getCanceled$okio()) {
                                    throw new IOException("canceled");
                                }
                            }
                            long j13 = Pipe.this.getBuffer$okio().read(sink, j12);
                            Buffer buffer$okio = Pipe.this.getBuffer$okio();
                            if (buffer$okio == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            buffer$okio.notifyAll();
                            return j13;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return this.timeout;
                }
            };
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j11).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forward(Sink sink, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long jTimeoutNanos = timeout.timeoutNanos();
        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (!timeout.hasDeadline()) {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.invoke(sink);
                InlineMarker.b(1);
                return;
            } finally {
                InlineMarker.b(1);
                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.a(1);
            }
        }
        long jDeadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            function1.invoke(sink);
            InlineMarker.b(1);
        } finally {
            InlineMarker.b(1);
            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
            InlineMarker.a(1);
        }
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m330deprecated_sink() {
        return this.sink;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_source, reason: not valid java name */
    public final Source m331deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            this.canceled = true;
            this.buffer.clear();
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
            buffer.notifyAll();
            Unit unit = Unit.f68710a;
        }
    }

    public final void fold(Sink sink) throws IOException {
        boolean z11;
        Buffer buffer;
        Intrinsics.g(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                z11 = this.sinkClosed;
                buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer.write(buffer2, buffer2.size());
                Buffer buffer3 = this.buffer;
                if (buffer3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                buffer3.notifyAll();
                Unit unit = Unit.f68710a;
            }
            try {
                sink.write(buffer, buffer.size());
                if (z11) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th2) {
                synchronized (this.buffer) {
                    try {
                        this.sourceClosed = true;
                        Buffer buffer4 = this.buffer;
                        if (buffer4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer4.notifyAll();
                        Unit unit2 = Unit.f68710a;
                        throw th2;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z11) {
        this.canceled = z11;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z11) {
        this.sinkClosed = z11;
    }

    public final void setSourceClosed$okio(boolean z11) {
        this.sourceClosed = z11;
    }

    @JvmName
    public final Sink sink() {
        return this.sink;
    }

    @JvmName
    public final Source source() {
        return this.source;
    }
}
