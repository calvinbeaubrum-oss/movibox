package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                if (!asyncTimeout.inQueue) {
                    return false;
                }
                asyncTimeout.inQueue = false;
                for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                    if (asyncTimeout2.next == asyncTimeout) {
                        asyncTimeout2.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout asyncTimeout, long j11, boolean z11) {
            synchronized (AsyncTimeout.class) {
                try {
                    if (!(!asyncTimeout.inQueue)) {
                        throw new IllegalStateException("Unbalanced enter/exit".toString());
                    }
                    asyncTimeout.inQueue = true;
                    if (AsyncTimeout.head == null) {
                        AsyncTimeout.head = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long jNanoTime = System.nanoTime();
                    if (j11 != 0 && z11) {
                        asyncTimeout.timeoutAt = Math.min(j11, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
                    } else if (j11 != 0) {
                        asyncTimeout.timeoutAt = j11 + jNanoTime;
                    } else {
                        if (!z11) {
                            throw new AssertionError();
                        }
                        asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                    }
                    long jRemainingNanos = asyncTimeout.remainingNanos(jNanoTime);
                    AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                    Intrinsics.d(asyncTimeout2);
                    while (asyncTimeout2.next != null) {
                        AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                        Intrinsics.d(asyncTimeout3);
                        if (jRemainingNanos < asyncTimeout3.remainingNanos(jNanoTime)) {
                            break;
                        }
                        asyncTimeout2 = asyncTimeout2.next;
                        Intrinsics.d(asyncTimeout2);
                    }
                    asyncTimeout.next = asyncTimeout2.next;
                    asyncTimeout2.next = asyncTimeout;
                    if (asyncTimeout2 == AsyncTimeout.head) {
                        AsyncTimeout.class.notify();
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            Intrinsics.d(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                Intrinsics.d(asyncTimeout3);
                if (asyncTimeout3.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jRemainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                long j11 = jRemainingNanos / 1000000;
                AsyncTimeout.class.wait(j11, (int) (jRemainingNanos - (1000000 * j11)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            Intrinsics.d(asyncTimeout4);
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout asyncTimeoutAwaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        asyncTimeoutAwaitTimeout$okio = AsyncTimeout.Companion.awaitTimeout$okio();
                        if (asyncTimeoutAwaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        Unit unit = Unit.f68710a;
                    }
                    if (asyncTimeoutAwaitTimeout$okio != null) {
                        asyncTimeoutAwaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j11) {
        return this.timeoutAt - j11;
    }

    @PublishedApi
    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            Companion.scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        Intrinsics.g(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout.sink.1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    try {
                        sink.close();
                        Unit unit = Unit.f68710a;
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                    } catch (IOException e11) {
                        if (!asyncTimeout.exit()) {
                            throw e11;
                        }
                        throw asyncTimeout.access$newTimeoutException(e11);
                    }
                } catch (Throwable th2) {
                    asyncTimeout.exit();
                    throw th2;
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    try {
                        sink.flush();
                        Unit unit = Unit.f68710a;
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                    } catch (IOException e11) {
                        if (!asyncTimeout.exit()) {
                            throw e11;
                        }
                        throw asyncTimeout.access$newTimeoutException(e11);
                    }
                } catch (Throwable th2) {
                    asyncTimeout.exit();
                    throw th2;
                }
            }

            @Override // okio.Sink
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(Buffer source, long j11) throws IOException {
                Intrinsics.g(source, "source");
                Util.checkOffsetAndCount(source.size(), 0L, j11);
                while (true) {
                    long j12 = 0;
                    if (j11 <= 0) {
                        return;
                    }
                    Segment segment = source.head;
                    Intrinsics.d(segment);
                    while (j12 < 65536) {
                        j12 += (long) (segment.limit - segment.pos);
                        if (j12 >= j11) {
                            j12 = j11;
                            break;
                        } else {
                            segment = segment.next;
                            Intrinsics.d(segment);
                        }
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    asyncTimeout.enter();
                    try {
                        try {
                            sink.write(source, j12);
                            Unit unit = Unit.f68710a;
                            if (asyncTimeout.exit()) {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                            j11 -= j12;
                        } catch (IOException e11) {
                            if (!asyncTimeout.exit()) {
                                throw e11;
                            }
                            throw asyncTimeout.access$newTimeoutException(e11);
                        }
                    } catch (Throwable th2) {
                        asyncTimeout.exit();
                        throw th2;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        Intrinsics.g(source, "source");
        return new Source() { // from class: okio.AsyncTimeout.source.1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    try {
                        source.close();
                        Unit unit = Unit.f68710a;
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                    } catch (IOException e11) {
                        if (!asyncTimeout.exit()) {
                            throw e11;
                        }
                        throw asyncTimeout.access$newTimeoutException(e11);
                    }
                } catch (Throwable th2) {
                    asyncTimeout.exit();
                    throw th2;
                }
            }

            @Override // okio.Source
            public long read(Buffer sink, long j11) throws IOException {
                Intrinsics.g(sink, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    try {
                        long j12 = source.read(sink, j11);
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                        return j12;
                    } catch (IOException e11) {
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(e11);
                        }
                        throw e11;
                    }
                } catch (Throwable th2) {
                    asyncTimeout.exit();
                    throw th2;
                }
            }

            @Override // okio.Source
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }
        };
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> block) throws IOException {
        Intrinsics.g(block, "block");
        enter();
        try {
            try {
                T tInvoke = block.invoke();
                InlineMarker.b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                InlineMarker.a(1);
                return tInvoke;
            } catch (IOException e11) {
                if (exit()) {
                    throw access$newTimeoutException(e11);
                }
                throw e11;
            }
        } catch (Throwable th2) {
            InlineMarker.b(1);
            exit();
            InlineMarker.a(1);
            throw th2;
        }
    }
}
