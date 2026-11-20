package com.google.common.util.concurrent;

import androidx.compose.animation.core.j0;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ClosingFuture<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f38879d = Logger.getLogger(ClosingFuture.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<State> f38880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CloseableList f38881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k<V> f38882c;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$10, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ f val$consumer;

        public AnonymousClass10(f fVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.o(null, ClosingFuture.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean closed;
        private final d closer;
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new d(this);
        }

        public /* synthetic */ CloseableList(h hVar) {
            this();
        }

        public void add(Closeable closeable, Executor executor) {
            com.google.common.base.m.p(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        ClosingFuture.k(closeable, executor);
                    } else {
                        put(closeable, executor);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public <V, U> k<U> applyAsyncClosingFunction(b<V, U> bVar, V v11) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> closingFutureA = bVar.a(closeableList.closer, v11);
                closingFutureA.h(closeableList);
                return closingFutureA.f38882c;
            } finally {
                add(closeableList, MoreExecutors.a());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <V, U> s<U> applyClosingFunction(c<? super V, U> cVar, V v11) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return Futures.g(cVar.a(closeableList.closer, v11));
            } finally {
                add(closeableList, MoreExecutors.a());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                        ClosingFuture.k(entry.getKey(), entry.getValue());
                    }
                    clear();
                    if (this.whenClosed != null) {
                        this.whenClosed.countDown();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return new CountDownLatch(0);
                    }
                    com.google.common.base.m.v(this.whenClosed == null);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.whenClosed = countDownLatch;
                    return countDownLatch;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38883a;

        static {
            int[] iArr = new int[State.values().length];
            f38883a = iArr;
            try {
                iArr[State.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38883a[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38883a[State.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38883a[State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38883a[State.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38883a[State.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T, U> {
        ClosingFuture<U> a(d dVar, T t11) throws Exception;
    }

    /* JADX INFO: compiled from: source.java */
    public interface c<T, U> {
        U a(d dVar, T t11) throws Exception;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @RetainedWith
        public final CloseableList f38884a;

        public d(CloseableList closeableList) {
            this.f38884a = closeableList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClosingFuture<? extends V> f38885a;

        public e(ClosingFuture<? extends V> closingFuture) {
            this.f38885a = (ClosingFuture) com.google.common.base.m.p(closingFuture);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f<V> {
        void a(e<V> eVar);
    }

    public static void k(final Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: com.google.common.util.concurrent.g
                @Override // java.lang.Runnable
                public final void run() {
                    ClosingFuture.n(closeable);
                }
            });
        } catch (RejectedExecutionException e11) {
            Logger logger = f38879d;
            Level level = Level.WARNING;
            if (logger.isLoggable(level)) {
                logger.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e11);
            }
            k(closeable, MoreExecutors.a());
        }
    }

    public static /* synthetic */ void n(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException | RuntimeException e11) {
            f38879d.log(Level.WARNING, "thrown by close()", e11);
        }
    }

    public static <C, V extends C> void o(f<C> fVar, ClosingFuture<V> closingFuture) {
        fVar.a(new e<>(closingFuture));
    }

    public void finalize() {
        if (this.f38880a.get().equals(State.OPEN)) {
            f38879d.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            m();
        }
    }

    public final void h(CloseableList closeableList) {
        i(State.OPEN, State.SUBSUMED);
        closeableList.add(this.f38881b, MoreExecutors.a());
    }

    public final void i(State state, State state2) {
        com.google.common.base.m.A(l(state, state2), "Expected state to be %s, but it was %s", state, state2);
    }

    public final void j() {
        f38879d.log(Level.FINER, "closing {0}", this);
        this.f38881b.close();
    }

    public final boolean l(State state, State state2) {
        return j0.a(this.f38880a, state, state2);
    }

    public k<V> m() {
        if (!l(State.OPEN, State.WILL_CLOSE)) {
            switch (a.f38883a[this.f38880a.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        f38879d.log(Level.FINER, "will close {0}", this);
        this.f38882c.addListener(new Runnable() { // from class: com.google.common.util.concurrent.ClosingFuture.9
            @Override // java.lang.Runnable
            public void run() {
                ClosingFuture closingFuture = ClosingFuture.this;
                State state = State.WILL_CLOSE;
                State state2 = State.CLOSING;
                closingFuture.i(state, state2);
                ClosingFuture.this.j();
                ClosingFuture.this.i(state2, State.CLOSED);
            }
        }, MoreExecutors.a());
        return this.f38882c;
    }

    public String toString() {
        return com.google.common.base.h.b(this).d("state", this.f38880a.get()).j(this.f38882c).toString();
    }
}
