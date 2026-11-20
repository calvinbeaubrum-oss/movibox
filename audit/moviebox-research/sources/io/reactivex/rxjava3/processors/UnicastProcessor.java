package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import u30.c;
import u30.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class UnicastProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.rxjava3.internal.queue.a<T> f67558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Runnable> f67559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67560d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f67561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f67562g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f67564i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f67568m;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<c<? super T>> f67563h = new AtomicReference<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f67565j = new AtomicBoolean();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BasicIntQueueSubscription<T> f67566k = new UnicastQueueSubscription();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f67567l = new AtomicLong();

    /* JADX INFO: compiled from: source.java */
    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
        public void cancel() {
            if (UnicastProcessor.this.f67564i) {
                return;
            }
            UnicastProcessor.this.f67564i = true;
            UnicastProcessor.this.k();
            UnicastProcessor.this.f67563h.lazySet(null);
            if (UnicastProcessor.this.f67566k.getAndIncrement() == 0) {
                UnicastProcessor.this.f67563h.lazySet(null);
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (unicastProcessor.f67568m) {
                    return;
                }
                unicastProcessor.f67558b.clear();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
        public void clear() {
            UnicastProcessor.this.f67558b.clear();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
        public boolean isEmpty() {
            return UnicastProcessor.this.f67558b.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.g
        public T poll() {
            return UnicastProcessor.this.f67558b.poll();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u30.d
        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                io.reactivex.rxjava3.internal.util.a.a(UnicastProcessor.this.f67567l, j11);
                UnicastProcessor.this.l();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, m10.c
        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f67568m = true;
            return 2;
        }
    }

    public UnicastProcessor(int i11, Runnable runnable, boolean z11) {
        this.f67558b = new io.reactivex.rxjava3.internal.queue.a<>(i11);
        this.f67559c = new AtomicReference<>(runnable);
        this.f67560d = z11;
    }

    public static <T> UnicastProcessor<T> i(int i11, Runnable runnable) {
        return j(i11, runnable, true);
    }

    public static <T> UnicastProcessor<T> j(int i11, Runnable runnable, boolean z11) {
        Objects.requireNonNull(runnable, "onTerminate");
        io.reactivex.rxjava3.internal.functions.a.a(i11, "capacityHint");
        return new UnicastProcessor<>(i11, runnable, z11);
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(c<? super T> cVar) {
        if (this.f67565j.get() || !this.f67565j.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.onSubscribe(this.f67566k);
        this.f67563h.set(cVar);
        if (this.f67564i) {
            this.f67563h.lazySet(null);
        } else {
            l();
        }
    }

    public boolean h(boolean z11, boolean z12, boolean z13, c<? super T> cVar, io.reactivex.rxjava3.internal.queue.a<T> aVar) {
        if (this.f67564i) {
            aVar.clear();
            this.f67563h.lazySet(null);
            return true;
        }
        if (!z12) {
            return false;
        }
        if (z11 && this.f67562g != null) {
            aVar.clear();
            this.f67563h.lazySet(null);
            cVar.onError(this.f67562g);
            return true;
        }
        if (!z13) {
            return false;
        }
        Throwable th2 = this.f67562g;
        this.f67563h.lazySet(null);
        if (th2 != null) {
            cVar.onError(th2);
        } else {
            cVar.onComplete();
        }
        return true;
    }

    public void k() {
        Runnable andSet = this.f67559c.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void l() {
        if (this.f67566k.getAndIncrement() != 0) {
            return;
        }
        c<? super T> cVar = this.f67563h.get();
        int iAddAndGet = 1;
        while (cVar == null) {
            iAddAndGet = this.f67566k.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                cVar = this.f67563h.get();
            }
        }
        if (this.f67568m) {
            m(cVar);
        } else {
            n(cVar);
        }
    }

    public void m(c<? super T> cVar) {
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.f67558b;
        int iAddAndGet = 1;
        boolean z11 = !this.f67560d;
        while (!this.f67564i) {
            boolean z12 = this.f67561f;
            if (z11 && z12 && this.f67562g != null) {
                aVar.clear();
                this.f67563h.lazySet(null);
                cVar.onError(this.f67562g);
                return;
            }
            cVar.onNext(null);
            if (z12) {
                this.f67563h.lazySet(null);
                Throwable th2 = this.f67562g;
                if (th2 != null) {
                    cVar.onError(th2);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            iAddAndGet = this.f67566k.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        this.f67563h.lazySet(null);
    }

    public void n(c<? super T> cVar) {
        long j11;
        io.reactivex.rxjava3.internal.queue.a<T> aVar = this.f67558b;
        boolean z11 = !this.f67560d;
        int iAddAndGet = 1;
        do {
            long j12 = this.f67567l.get();
            long j13 = 0;
            while (true) {
                if (j12 == j13) {
                    j11 = j13;
                    break;
                }
                boolean z12 = this.f67561f;
                T tPoll = aVar.poll();
                boolean z13 = tPoll == null;
                j11 = j13;
                if (h(z11, z12, z13, cVar, aVar)) {
                    return;
                }
                if (z13) {
                    break;
                }
                cVar.onNext(tPoll);
                j13 = 1 + j11;
            }
            if (j12 == j13 && h(z11, this.f67561f, aVar.isEmpty(), cVar, aVar)) {
                return;
            }
            if (j11 != 0 && j12 != Long.MAX_VALUE) {
                this.f67567l.addAndGet(-j11);
            }
            iAddAndGet = this.f67566k.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // u30.c
    public void onComplete() {
        if (this.f67561f || this.f67564i) {
            return;
        }
        this.f67561f = true;
        k();
        l();
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f67561f || this.f67564i) {
            p10.a.q(th2);
            return;
        }
        this.f67562g = th2;
        this.f67561f = true;
        k();
        l();
    }

    @Override // u30.c
    public void onNext(T t11) {
        ExceptionHelper.c(t11, "onNext called with a null value.");
        if (this.f67561f || this.f67564i) {
            return;
        }
        this.f67558b.offer(t11);
        l();
    }

    @Override // u30.c
    public void onSubscribe(d dVar) {
        if (this.f67561f || this.f67564i) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
