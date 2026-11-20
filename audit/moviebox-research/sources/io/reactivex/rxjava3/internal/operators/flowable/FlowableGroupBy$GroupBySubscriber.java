package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import k10.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends AtomicLong implements io.reactivex.rxjava3.core.f<T>, u30.d {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    boolean done;
    final u30.c<? super j10.a<K, V>> downstream;
    long emittedGroups;
    final Queue<d<K, V>> evictedGroups;
    final Map<Object, d<K, V>> groups;
    final h<? super T, ? extends K> keySelector;
    final int limit;
    u30.d upstream;
    final h<? super T, ? extends V> valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicInteger groupCount = new AtomicInteger(1);
    final AtomicLong groupConsumed = new AtomicLong();

    public FlowableGroupBy$GroupBySubscriber(u30.c<? super j10.a<K, V>> cVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i11, boolean z11, Map<Object, d<K, V>> map, Queue<d<K, V>> queue) {
        this.downstream = cVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i11;
        this.limit = i11 - (i11 >> 2);
        this.delayError = z11;
        this.groups = map;
        this.evictedGroups = queue;
    }

    private void completeEvictions() {
        if (this.evictedGroups != null) {
            int i11 = 0;
            while (true) {
                d<K, V> dVarPoll = this.evictedGroups.poll();
                if (dVarPoll == null) {
                    break;
                } else if (dVarPoll.f67374c.tryComplete()) {
                    i11++;
                }
            }
            if (i11 != 0) {
                this.groupCount.addAndGet(-i11);
            }
        }
    }

    public static String groupHangWarning(long j11) {
        return "Unable to emit a new group (#" + j11 + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.";
    }

    @Override // u30.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            completeEvictions();
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public void cancel(K k11) {
        if (k11 == null) {
            k11 = (K) NULL_KEY;
        }
        if (this.groups.remove(k11) == null || this.groupCount.decrementAndGet() != 0) {
            return;
        }
        this.upstream.cancel();
    }

    @Override // u30.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        Iterator<d<K, V>> it = this.groups.values().iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.groups.clear();
        completeEvictions();
        this.done = true;
        this.downstream.onComplete();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        if (this.done) {
            p10.a.q(th2);
            return;
        }
        this.done = true;
        Iterator<d<K, V>> it = this.groups.values().iterator();
        while (it.hasNext()) {
            it.next().onError(th2);
        }
        this.groups.clear();
        completeEvictions();
        this.downstream.onError(th2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u30.c
    public void onNext(T t11) {
        boolean z11;
        if (this.done) {
            return;
        }
        try {
            K kApply = this.keySelector.apply(t11);
            Object obj = kApply != null ? kApply : NULL_KEY;
            d dVarH = this.groups.get(obj);
            if (dVarH != null) {
                z11 = false;
            } else {
                if (this.cancelled.get()) {
                    return;
                }
                dVarH = d.h(kApply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, (d<K, V>) dVarH);
                this.groupCount.getAndIncrement();
                z11 = true;
            }
            try {
                dVarH.onNext(ExceptionHelper.c(this.valueSelector.apply(t11), "The valueSelector returned a null value."));
                completeEvictions();
                if (z11) {
                    if (this.emittedGroups == get()) {
                        this.upstream.cancel();
                        onError(new MissingBackpressureException(groupHangWarning(this.emittedGroups)));
                        return;
                    }
                    this.emittedGroups++;
                    this.downstream.onNext(dVarH);
                    if (dVarH.f67374c.tryAbandon()) {
                        cancel(kApply);
                        dVarH.onComplete();
                        requestGroup(1L);
                    }
                }
            } catch (Throwable th2) {
                i10.a.b(th2);
                this.upstream.cancel();
                if (z11) {
                    if (this.emittedGroups == get()) {
                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException(groupHangWarning(this.emittedGroups));
                        missingBackpressureException.initCause(th2);
                        onError(missingBackpressureException);
                        return;
                    }
                    this.downstream.onNext(dVarH);
                }
                onError(th2);
            }
        } catch (Throwable th3) {
            i10.a.b(th3);
            this.upstream.cancel();
            onError(th3);
        }
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(this.bufferSize);
        }
    }

    @Override // u30.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this, j11);
        }
    }

    public void requestGroup(long j11) {
        long j12;
        long jB;
        AtomicLong atomicLong = this.groupConsumed;
        int i11 = this.limit;
        do {
            j12 = atomicLong.get();
            jB = io.reactivex.rxjava3.internal.util.a.b(j12, j11);
        } while (!atomicLong.compareAndSet(j12, jB));
        while (true) {
            long j13 = i11;
            if (jB < j13) {
                return;
            }
            if (atomicLong.compareAndSet(jB, jB - j13)) {
                this.upstream.request(j13);
            }
            jB = atomicLong.get();
        }
    }
}
