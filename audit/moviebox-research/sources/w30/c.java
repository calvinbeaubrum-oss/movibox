package w30;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c<T> extends j<b0<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final retrofit2.b<T> f79223a;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements h10.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.b<?> f79224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f79225b;

        public a(retrofit2.b<?> bVar) {
            this.f79224a = bVar;
        }

        @Override // h10.b
        public void dispose() {
            this.f79225b = true;
            this.f79224a.cancel();
        }

        @Override // h10.b
        public boolean isDisposed() {
            return this.f79225b;
        }
    }

    public c(retrofit2.b<T> bVar) {
        this.f79223a = bVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(o<? super b0<T>> oVar) {
        boolean z11;
        retrofit2.b<T> bVarClone = this.f79223a.clone();
        a aVar = new a(bVarClone);
        oVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        try {
            b0<T> b0VarExecute = bVarClone.execute();
            if (!aVar.isDisposed()) {
                oVar.onNext(b0VarExecute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                oVar.onComplete();
            } catch (Throwable th2) {
                th = th2;
                z11 = true;
                i10.a.b(th);
                if (z11) {
                    p10.a.q(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    oVar.onError(th);
                } catch (Throwable th3) {
                    i10.a.b(th3);
                    p10.a.q(new CompositeException(th, th3));
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z11 = false;
        }
    }
}
