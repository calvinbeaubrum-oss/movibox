package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends io.reactivex.rxjava3.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f67381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f67382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k10.k<U> f67383d;

    /* JADX INFO: compiled from: source.java */
    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements io.reactivex.rxjava3.core.o<T>, h10.b {
        private static final long serialVersionUID = -8223395059921494546L;
        final k10.k<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final io.reactivex.rxjava3.core.o<? super U> downstream;
        long index;
        final int skip;
        h10.b upstream;

        public BufferSkipObserver(io.reactivex.rxjava3.core.o<? super U> oVar, int i11, int i12, k10.k<U> kVar) {
            this.downstream = oVar;
            this.count = i11;
            this.skip = i12;
            this.bufferSupplier = kVar;
        }

        @Override // h10.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.buffers.clear();
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            long j11 = this.index;
            this.index = 1 + j11;
            if (j11 % ((long) this.skip) == 0) {
                try {
                    this.buffers.offer((U) ((Collection) ExceptionHelper.c(this.bufferSupplier.get(), "The bufferSupplier returned a null Collection.")));
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th2);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t11);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
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

    /* JADX INFO: compiled from: source.java */
    public static final class a<T, U extends Collection<? super T>> implements io.reactivex.rxjava3.core.o<T>, h10.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.rxjava3.core.o<? super U> f67384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f67385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k10.k<U> f67386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public U f67387d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f67388f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public h10.b f67389g;

        public a(io.reactivex.rxjava3.core.o<? super U> oVar, int i11, k10.k<U> kVar) {
            this.f67384a = oVar;
            this.f67385b = i11;
            this.f67386c = kVar;
        }

        public boolean a() {
            try {
                U u11 = this.f67386c.get();
                Objects.requireNonNull(u11, "Empty buffer supplied");
                this.f67387d = u11;
                return true;
            } catch (Throwable th2) {
                i10.a.b(th2);
                this.f67387d = null;
                h10.b bVar = this.f67389g;
                if (bVar == null) {
                    EmptyDisposable.error(th2, this.f67384a);
                    return false;
                }
                bVar.dispose();
                this.f67384a.onError(th2);
                return false;
            }
        }

        @Override // h10.b
        public void dispose() {
            this.f67389g.dispose();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f67389g.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            U u11 = this.f67387d;
            if (u11 != null) {
                this.f67387d = null;
                if (!u11.isEmpty()) {
                    this.f67384a.onNext(u11);
                }
                this.f67384a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f67387d = null;
            this.f67384a.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            U u11 = this.f67387d;
            if (u11 != null) {
                u11.add(t11);
                int i11 = this.f67388f + 1;
                this.f67388f = i11;
                if (i11 >= this.f67385b) {
                    this.f67384a.onNext(u11);
                    this.f67388f = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            if (DisposableHelper.validate(this.f67389g, bVar)) {
                this.f67389g = bVar;
                this.f67384a.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(io.reactivex.rxjava3.core.m<T> mVar, int i11, int i12, k10.k<U> kVar) {
        super(mVar);
        this.f67381b = i11;
        this.f67382c = i12;
        this.f67383d = kVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super U> oVar) {
        int i11 = this.f67382c;
        int i12 = this.f67381b;
        if (i11 != i12) {
            this.f67422a.subscribe(new BufferSkipObserver(oVar, this.f67381b, this.f67382c, this.f67383d));
            return;
        }
        a aVar = new a(oVar, i12, this.f67383d);
        if (aVar.a()) {
            this.f67422a.subscribe(aVar);
        }
    }
}
