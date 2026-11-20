package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements io.reactivex.rxjava3.core.o<T>, h10.b {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    final io.reactivex.rxjava3.core.o<? super n10.a<K, V>> downstream;
    final k10.h<? super T, ? extends K> keySelector;
    h10.b upstream;
    final k10.h<? super T, ? extends V> valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final Map<Object, g<K, V>> groups = new ConcurrentHashMap();

    public ObservableGroupBy$GroupByObserver(io.reactivex.rxjava3.core.o<? super n10.a<K, V>> oVar, k10.h<? super T, ? extends K> hVar, k10.h<? super T, ? extends V> hVar2, int i11, boolean z11) {
        this.downstream = oVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i11;
        this.delayError = z11;
        lazySet(1);
    }

    public void cancel(K k11) {
        if (k11 == null) {
            k11 = (K) NULL_KEY;
        }
        this.groups.remove(k11);
        if (decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    @Override // h10.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).onComplete();
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).onError(th2);
        }
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        boolean z11;
        try {
            K kApply = this.keySelector.apply(t11);
            Object obj = kApply != null ? kApply : NULL_KEY;
            g<K, V> gVarF = this.groups.get(obj);
            if (gVarF != null) {
                z11 = false;
            } else {
                if (this.cancelled.get()) {
                    return;
                }
                gVarF = g.F(kApply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, gVarF);
                getAndIncrement();
                z11 = true;
            }
            try {
                V vApply = this.valueSelector.apply(t11);
                Objects.requireNonNull(vApply, "The value supplied is null");
                gVarF.onNext(vApply);
                if (z11) {
                    this.downstream.onNext(gVarF);
                    if (gVarF.f67428b.tryAbandon()) {
                        cancel(kApply);
                        gVarF.onComplete();
                    }
                }
            } catch (Throwable th2) {
                i10.a.b(th2);
                this.upstream.dispose();
                if (z11) {
                    this.downstream.onNext(gVarF);
                }
                onError(th2);
            }
        } catch (Throwable th3) {
            i10.a.b(th3);
            this.upstream.dispose();
            onError(th3);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
