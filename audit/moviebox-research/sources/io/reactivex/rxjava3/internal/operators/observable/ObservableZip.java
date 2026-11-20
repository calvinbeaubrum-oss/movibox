package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableZip<T, R> extends io.reactivex.rxjava3.core.j<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.core.m<? extends T>[] f67412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends io.reactivex.rxjava3.core.m<? extends T>> f67413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k10.h<? super Object[], ? extends R> f67414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67415d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f67416f;

    /* JADX INFO: compiled from: source.java */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements h10.b {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final io.reactivex.rxjava3.core.o<? super R> downstream;
        final a<T, R>[] observers;
        final T[] row;
        final k10.h<? super Object[], ? extends R> zipper;

        public ZipCoordinator(io.reactivex.rxjava3.core.o<? super R> oVar, k10.h<? super Object[], ? extends R> hVar, int i11, boolean z11) {
            this.downstream = oVar;
            this.zipper = hVar;
            this.observers = new a[i11];
            this.row = (T[]) new Object[i11];
            this.delayError = z11;
        }

        public void cancel() {
            clear();
            cancelSources();
        }

        public void cancelSources() {
            for (a<T, R> aVar : this.observers) {
                aVar.a();
            }
        }

        public boolean checkTerminated(boolean z11, boolean z12, io.reactivex.rxjava3.core.o<? super R> oVar, boolean z13, a<?, ?> aVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z11) {
                return false;
            }
            if (z13) {
                if (!z12) {
                    return false;
                }
                Throwable th2 = aVar.f67420d;
                this.cancelled = true;
                cancel();
                if (th2 != null) {
                    oVar.onError(th2);
                } else {
                    oVar.onComplete();
                }
                return true;
            }
            Throwable th3 = aVar.f67420d;
            if (th3 != null) {
                this.cancelled = true;
                cancel();
                oVar.onError(th3);
                return true;
            }
            if (!z12) {
                return false;
            }
            this.cancelled = true;
            cancel();
            oVar.onComplete();
            return true;
        }

        public void clear() {
            for (a<T, R> aVar : this.observers) {
                aVar.f67418b.clear();
            }
        }

        @Override // h10.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            a<T, R>[] aVarArr = this.observers;
            io.reactivex.rxjava3.core.o<? super R> oVar = this.downstream;
            T[] tArr = this.row;
            boolean z11 = this.delayError;
            int iAddAndGet = 1;
            while (true) {
                int i11 = 0;
                int i12 = 0;
                for (a<T, R> aVar : aVarArr) {
                    if (tArr[i12] == null) {
                        boolean z12 = aVar.f67419c;
                        T tPoll = aVar.f67418b.poll();
                        boolean z13 = tPoll == null;
                        if (checkTerminated(z12, z13, oVar, z11, aVar)) {
                            return;
                        }
                        if (z13) {
                            i11++;
                        } else {
                            tArr[i12] = tPoll;
                        }
                    } else if (aVar.f67419c && !z11 && (th2 = aVar.f67420d) != null) {
                        this.cancelled = true;
                        cancel();
                        oVar.onError(th2);
                        return;
                    }
                    i12++;
                }
                if (i11 != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        R rApply = this.zipper.apply(tArr.clone());
                        Objects.requireNonNull(rApply, "The zipper returned a null value");
                        oVar.onNext(rApply);
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th3) {
                        i10.a.b(th3);
                        cancel();
                        oVar.onError(th3);
                        return;
                    }
                }
            }
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(io.reactivex.rxjava3.core.m<? extends T>[] mVarArr, int i11) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            for (int i12 = 0; i12 < length; i12++) {
                aVarArr[i12] = new a<>(this, i11);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i13 = 0; i13 < length && !this.cancelled; i13++) {
                mVarArr[i13].subscribe(aVarArr[i13]);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<T, R> implements io.reactivex.rxjava3.core.o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ZipCoordinator<T, R> f67417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.rxjava3.internal.queue.a<T> f67418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f67419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f67420d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicReference<h10.b> f67421f = new AtomicReference<>();

        public a(ZipCoordinator<T, R> zipCoordinator, int i11) {
            this.f67417a = zipCoordinator;
            this.f67418b = new io.reactivex.rxjava3.internal.queue.a<>(i11);
        }

        public void a() {
            DisposableHelper.dispose(this.f67421f);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f67419c = true;
            this.f67417a.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f67420d = th2;
            this.f67419c = true;
            this.f67417a.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            this.f67418b.offer(t11);
            this.f67417a.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            DisposableHelper.setOnce(this.f67421f, bVar);
        }
    }

    public ObservableZip(io.reactivex.rxjava3.core.m<? extends T>[] mVarArr, Iterable<? extends io.reactivex.rxjava3.core.m<? extends T>> iterable, k10.h<? super Object[], ? extends R> hVar, int i11, boolean z11) {
        this.f67412a = mVarArr;
        this.f67413b = iterable;
        this.f67414c = hVar;
        this.f67415d = i11;
        this.f67416f = z11;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super R> oVar) {
        int length;
        io.reactivex.rxjava3.core.m<? extends T>[] mVarArr = this.f67412a;
        if (mVarArr == null) {
            mVarArr = new io.reactivex.rxjava3.core.m[8];
            length = 0;
            for (io.reactivex.rxjava3.core.m<? extends T> mVar : this.f67413b) {
                if (length == mVarArr.length) {
                    io.reactivex.rxjava3.core.m<? extends T>[] mVarArr2 = new io.reactivex.rxjava3.core.m[(length >> 2) + length];
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                    mVarArr = mVarArr2;
                }
                mVarArr[length] = mVar;
                length++;
            }
        } else {
            length = mVarArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(oVar);
        } else {
            new ZipCoordinator(oVar, this.f67414c, length, this.f67416f).subscribe(mVarArr, this.f67415d);
        }
    }
}
