package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.util.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c<T, U, V> extends e implements o<T>, io.reactivex.rxjava3.internal.util.e<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final o<? super V> downstream;
    protected Throwable error;
    protected final m10.f<U> queue;

    public c(o<? super V> oVar, m10.f<U> fVar) {
        this.downstream = oVar;
        this.queue = fVar;
    }

    @Override // io.reactivex.rxjava3.internal.util.e
    public void accept(o<? super V> oVar, U u11) {
    }

    @Override // io.reactivex.rxjava3.internal.util.e
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.rxjava3.internal.util.e
    public final boolean done() {
        return this.done;
    }

    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    @Override // io.reactivex.rxjava3.internal.util.e
    public final Throwable error() {
        return this.error;
    }

    public final void fastPathEmit(U u11, boolean z11, h10.b bVar) {
        o<? super V> oVar = this.downstream;
        m10.f<U> fVar = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            accept(oVar, u11);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            fVar.offer(u11);
            if (!enter()) {
                return;
            }
        }
        i.d(fVar, oVar, z11, bVar, this);
    }

    public final void fastPathOrderedEmit(U u11, boolean z11, h10.b bVar) {
        o<? super V> oVar = this.downstream;
        m10.f<U> fVar = this.queue;
        if (this.wip.get() != 0 || !this.wip.compareAndSet(0, 1)) {
            fVar.offer(u11);
            if (!enter()) {
                return;
            }
        } else if (fVar.isEmpty()) {
            accept(oVar, u11);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            fVar.offer(u11);
        }
        i.d(fVar, oVar, z11, bVar, this);
    }

    @Override // io.reactivex.rxjava3.internal.util.e
    public final int leave(int i11) {
        return this.wip.addAndGet(i11);
    }
}
