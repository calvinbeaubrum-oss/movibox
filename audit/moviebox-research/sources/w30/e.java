package w30;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e<T> extends j<d<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j<b0<T>> f79228a;

    /* JADX INFO: compiled from: source.java */
    public static class a<R> implements o<b0<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o<? super d<R>> f79229a;

        public a(o<? super d<R>> oVar) {
            this.f79229a = oVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(b0<R> b0Var) {
            this.f79229a.onNext(d.b(b0Var));
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f79229a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            try {
                this.f79229a.onNext(d.a(th2));
                this.f79229a.onComplete();
            } catch (Throwable th3) {
                try {
                    this.f79229a.onError(th3);
                } catch (Throwable th4) {
                    i10.a.b(th4);
                    p10.a.q(new CompositeException(th3, th4));
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            this.f79229a.onSubscribe(bVar);
        }
    }

    public e(j<b0<T>> jVar) {
        this.f79228a = jVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(o<? super d<T>> oVar) {
        this.f79228a.subscribe(new a(oVar));
    }
}
