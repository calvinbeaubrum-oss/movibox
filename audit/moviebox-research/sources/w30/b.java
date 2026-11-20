package w30;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b<T> extends j<b0<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final retrofit2.b<T> f79218a;

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> implements h10.b, retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.b<?> f79219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<? super b0<T>> f79220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f79221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f79222d = false;

        public a(retrofit2.b<?> bVar, o<? super b0<T>> oVar) {
            this.f79219a = bVar;
            this.f79220b = oVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> bVar, Throwable th2) {
            if (bVar.isCanceled()) {
                return;
            }
            try {
                this.f79220b.onError(th2);
            } catch (Throwable th3) {
                i10.a.b(th3);
                p10.a.q(new CompositeException(th2, th3));
            }
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> bVar, b0<T> b0Var) {
            if (this.f79221c) {
                return;
            }
            try {
                this.f79220b.onNext(b0Var);
                if (this.f79221c) {
                    return;
                }
                this.f79222d = true;
                this.f79220b.onComplete();
            } catch (Throwable th2) {
                i10.a.b(th2);
                if (this.f79222d) {
                    p10.a.q(th2);
                    return;
                }
                if (this.f79221c) {
                    return;
                }
                try {
                    this.f79220b.onError(th2);
                } catch (Throwable th3) {
                    i10.a.b(th3);
                    p10.a.q(new CompositeException(th2, th3));
                }
            }
        }

        @Override // h10.b
        public void dispose() {
            this.f79221c = true;
            this.f79219a.cancel();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f79221c;
        }
    }

    public b(retrofit2.b<T> bVar) {
        this.f79218a = bVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(o<? super b0<T>> oVar) {
        retrofit2.b<T> bVarClone = this.f79218a.clone();
        a aVar = new a(bVarClone, oVar);
        oVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        bVarClone.e(aVar);
    }
}
