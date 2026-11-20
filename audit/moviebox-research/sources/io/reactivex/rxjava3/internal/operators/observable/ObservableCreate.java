package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableCreate<T> extends io.reactivex.rxjava3.core.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.core.l<T> f67393a;

    /* JADX INFO: compiled from: source.java */
    public static final class CreateEmitter<T> extends AtomicReference<h10.b> implements io.reactivex.rxjava3.core.k<T>, h10.b {
        private static final long serialVersionUID = -3434801548987643227L;
        final io.reactivex.rxjava3.core.o<? super T> observer;

        public CreateEmitter(io.reactivex.rxjava3.core.o<? super T> oVar) {
            this.observer = oVar;
        }

        @Override // h10.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.k, h10.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onError(Throwable th2) {
            if (tryOnError(th2)) {
                return;
            }
            p10.a.q(th2);
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onNext(T t11) {
            if (t11 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t11);
            }
        }

        public io.reactivex.rxjava3.core.k<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.rxjava3.core.k
        public void setCancellable(k10.e eVar) {
            setDisposable(new CancellableDisposable(eVar));
        }

        @Override // io.reactivex.rxjava3.core.k
        public void setDisposable(h10.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th2) {
            if (th2 == null) {
                th2 = ExceptionHelper.b("onError called with a null Throwable.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th2);
                return true;
            } finally {
                dispose();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SerializedEmitter<T> extends AtomicInteger implements io.reactivex.rxjava3.core.k<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final io.reactivex.rxjava3.core.k<T> emitter;
        final AtomicThrowable errors = new AtomicThrowable();
        final io.reactivex.rxjava3.internal.queue.a<T> queue = new io.reactivex.rxjava3.internal.queue.a<>(16);

        public SerializedEmitter(io.reactivex.rxjava3.core.k<T> kVar) {
            this.emitter = kVar;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void drainLoop() {
            io.reactivex.rxjava3.core.k<T> kVar = this.emitter;
            io.reactivex.rxjava3.internal.queue.a<T> aVar = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int iAddAndGet = 1;
            while (!kVar.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    aVar.clear();
                    atomicThrowable.tryTerminateConsumer(kVar);
                    return;
                }
                boolean z11 = this.done;
                T tPoll = aVar.poll();
                boolean z12 = tPoll == null;
                if (z11 && z12) {
                    kVar.onComplete();
                    return;
                } else if (z12) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    kVar.onNext(tPoll);
                }
            }
            aVar.clear();
        }

        @Override // io.reactivex.rxjava3.core.k, h10.b
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.done || this.emitter.isDisposed()) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onError(Throwable th2) {
            if (tryOnError(th2)) {
                return;
            }
            p10.a.q(th2);
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onNext(T t11) {
            if (this.done || this.emitter.isDisposed()) {
                return;
            }
            if (t11 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t11);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.rxjava3.internal.queue.a<T> aVar = this.queue;
                synchronized (aVar) {
                    aVar.offer(t11);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public io.reactivex.rxjava3.core.k<T> serialize() {
            return this;
        }

        @Override // io.reactivex.rxjava3.core.k
        public void setCancellable(k10.e eVar) {
            this.emitter.setCancellable(eVar);
        }

        @Override // io.reactivex.rxjava3.core.k
        public void setDisposable(h10.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        public boolean tryOnError(Throwable th2) {
            if (!this.done && !this.emitter.isDisposed()) {
                if (th2 == null) {
                    th2 = ExceptionHelper.b("onError called with a null Throwable.");
                }
                if (this.errors.tryAddThrowable(th2)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public ObservableCreate(io.reactivex.rxjava3.core.l<T> lVar) {
        this.f67393a = lVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        CreateEmitter createEmitter = new CreateEmitter(oVar);
        oVar.onSubscribe(createEmitter);
        try {
            this.f67393a.a(createEmitter);
        } catch (Throwable th2) {
            i10.a.b(th2);
            createEmitter.onError(th2);
        }
    }
}
