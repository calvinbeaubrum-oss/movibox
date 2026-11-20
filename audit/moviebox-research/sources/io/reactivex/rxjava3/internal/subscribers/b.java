package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.h;
import io.reactivex.rxjava3.internal.util.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b<T, U, V> extends f implements io.reactivex.rxjava3.core.f<T>, h<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final u30.c<? super V> downstream;
    protected Throwable error;
    protected final m10.f<U> queue;

    public b(u30.c<? super V> cVar, m10.f<U> fVar) {
        this.downstream = cVar;
        this.queue = fVar;
    }

    public boolean accept(u30.c<? super V> cVar, U u11) {
        return false;
    }

    @Override // io.reactivex.rxjava3.internal.util.h
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.internal.util.h
    public final boolean done() {
        return this.done;
    }

    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    @Override // io.reactivex.rxjava3.internal.util.h
    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.wip.get() == 0 && this.wip.compareAndSet(0, 1);
    }

    public final void fastPathEmitMax(U u11, boolean z11, h10.b bVar) {
        u30.c<? super V> cVar = this.downstream;
        m10.f<U> fVar = this.queue;
        if (fastEnter()) {
            long j11 = this.requested.get();
            if (j11 == 0) {
                bVar.dispose();
                cVar.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (accept(cVar, u11) && j11 != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            }
        } else {
            fVar.offer(u11);
            if (!enter()) {
                return;
            }
        }
        i.e(fVar, cVar, z11, bVar, this);
    }

    public final void fastPathOrderedEmitMax(U u11, boolean z11, h10.b bVar) {
        u30.c<? super V> cVar = this.downstream;
        m10.f<U> fVar = this.queue;
        if (fastEnter()) {
            long j11 = this.requested.get();
            if (j11 == 0) {
                this.cancelled = true;
                bVar.dispose();
                cVar.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (fVar.isEmpty()) {
                if (accept(cVar, u11) && j11 != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                fVar.offer(u11);
            }
        } else {
            fVar.offer(u11);
            if (!enter()) {
                return;
            }
        }
        i.e(fVar, cVar, z11, bVar, this);
    }

    @Override // io.reactivex.rxjava3.internal.util.h
    public final int leave(int i11) {
        return this.wip.addAndGet(i11);
    }

    @Override // io.reactivex.rxjava3.internal.util.h
    public final long produced(long j11) {
        return this.requested.addAndGet(-j11);
    }

    @Override // io.reactivex.rxjava3.internal.util.h
    public final long requested() {
        return this.requested.get();
    }

    public final void requested(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
        }
    }
}
