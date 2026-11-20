package w30;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.adapter.rxjava3.HttpException;
import retrofit2.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a<T> extends j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j<b0<T>> f79215a;

    /* JADX INFO: renamed from: w30.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0881a<R> implements o<b0<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o<? super R> f79216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f79217b;

        public C0881a(o<? super R> oVar) {
            this.f79216a = oVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(b0<R> b0Var) {
            if (b0Var.e()) {
                this.f79216a.onNext(b0Var.a());
                return;
            }
            this.f79217b = true;
            HttpException httpException = new HttpException(b0Var);
            try {
                this.f79216a.onError(httpException);
            } catch (Throwable th2) {
                i10.a.b(th2);
                p10.a.q(new CompositeException(httpException, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f79217b) {
                return;
            }
            this.f79216a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (!this.f79217b) {
                this.f79216a.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            p10.a.q(assertionError);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b bVar) {
            this.f79216a.onSubscribe(bVar);
        }
    }

    public a(j<b0<T>> jVar) {
        this.f79215a = jVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(o<? super T> oVar) {
        this.f79215a.subscribe(new C0881a(oVar));
    }
}
