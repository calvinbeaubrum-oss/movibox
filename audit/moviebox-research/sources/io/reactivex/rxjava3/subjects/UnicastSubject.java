package io.reactivex.rxjava3.subjects;

import androidx.compose.animation.core.j0;
import h10.b;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m10.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class UnicastSubject<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.internal.queue.a<T> f67569a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Runnable> f67571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67572d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f67573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f67574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f67575h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f67578k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<o<? super T>> f67570b = new AtomicReference<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f67576i = new AtomicBoolean();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BasicIntQueueDisposable<T> f67577j = new UnicastQueueDisposable();

    /* JADX INFO: compiled from: source.java */
    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.g
        public void clear() {
            UnicastSubject.this.f67569a.clear();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, h10.b
        public void dispose() {
            if (UnicastSubject.this.f67573f) {
                return;
            }
            UnicastSubject.this.f67573f = true;
            UnicastSubject.this.G();
            UnicastSubject.this.f67570b.lazySet(null);
            if (UnicastSubject.this.f67577j.getAndIncrement() == 0) {
                UnicastSubject.this.f67570b.lazySet(null);
                UnicastSubject unicastSubject = UnicastSubject.this;
                if (unicastSubject.f67578k) {
                    return;
                }
                unicastSubject.f67569a.clear();
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, h10.b
        public boolean isDisposed() {
            return UnicastSubject.this.f67573f;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.g
        public boolean isEmpty() {
            return UnicastSubject.this.f67569a.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.g
        public T poll() {
            return UnicastSubject.this.f67569a.poll();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, m10.c
        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f67578k = true;
            return 2;
        }
    }

    public UnicastSubject(int i11, Runnable runnable, boolean z11) {
        this.f67569a = new io.reactivex.rxjava3.internal.queue.a<>(i11);
        this.f67571c = new AtomicReference<>(runnable);
        this.f67572d = z11;
    }

    public static <T> UnicastSubject<T> F(int i11, Runnable runnable) {
        io.reactivex.rxjava3.internal.functions.a.a(i11, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i11, runnable, true);
    }

    public void G() {
        Runnable runnable = this.f67571c.get();
        if (runnable == null || !j0.a(this.f67571c, runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void H() {
        if (this.f67577j.getAndIncrement() != 0) {
            return;
        }
        o<? super T> oVar = this.f67570b.get();
        int iAddAndGet = 1;
        while (oVar == null) {
            iAddAndGet = this.f67577j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                oVar = this.f67570b.get();
            }
        }
        if (this.f67578k) {
            I(oVar);
        } else {
            J(oVar);
        }
    }

    public void I(o<? super T> oVar) {
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.f67569a;
        int iAddAndGet = 1;
        boolean z11 = !this.f67572d;
        while (!this.f67573f) {
            boolean z12 = this.f67574g;
            if (z11 && z12 && L(aVar, oVar)) {
                return;
            }
            oVar.onNext(null);
            if (z12) {
                K(oVar);
                return;
            } else {
                iAddAndGet = this.f67577j.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        this.f67570b.lazySet(null);
    }

    public void J(o<? super T> oVar) {
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.f67569a;
        boolean z11 = !this.f67572d;
        boolean z12 = true;
        int iAddAndGet = 1;
        while (!this.f67573f) {
            boolean z13 = this.f67574g;
            T tPoll = this.f67569a.poll();
            boolean z14 = tPoll == null;
            if (z13) {
                if (z11 && z12) {
                    if (L(aVar, oVar)) {
                        return;
                    } else {
                        z12 = false;
                    }
                }
                if (z14) {
                    K(oVar);
                    return;
                }
            }
            if (z14) {
                iAddAndGet = this.f67577j.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                oVar.onNext(tPoll);
            }
        }
        this.f67570b.lazySet(null);
        aVar.clear();
    }

    public void K(o<? super T> oVar) {
        this.f67570b.lazySet(null);
        Throwable th2 = this.f67575h;
        if (th2 != null) {
            oVar.onError(th2);
        } else {
            oVar.onComplete();
        }
    }

    public boolean L(g<T> gVar, o<? super T> oVar) {
        Throwable th2 = this.f67575h;
        if (th2 == null) {
            return false;
        }
        this.f67570b.lazySet(null);
        gVar.clear();
        oVar.onError(th2);
        return true;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.f67574g || this.f67573f) {
            return;
        }
        this.f67574g = true;
        G();
        H();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f67574g || this.f67573f) {
            p10.a.q(th2);
            return;
        }
        this.f67575h = th2;
        this.f67574g = true;
        G();
        H();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        ExceptionHelper.c(t11, "onNext called with a null value.");
        if (this.f67574g || this.f67573f) {
            return;
        }
        this.f67569a.offer(t11);
        H();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(b bVar) {
        if (this.f67574g || this.f67573f) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(o<? super T> oVar) {
        if (this.f67576i.get() || !this.f67576i.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), oVar);
            return;
        }
        oVar.onSubscribe(this.f67577j);
        this.f67570b.lazySet(oVar);
        if (this.f67573f) {
            this.f67570b.lazySet(null);
        } else {
            H();
        }
    }
}
