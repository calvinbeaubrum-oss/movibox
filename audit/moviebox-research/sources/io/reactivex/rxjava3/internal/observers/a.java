package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T, R> implements o<T>, m10.b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<? super R> f67340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h10.b f67341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m10.b<T> f67342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f67343d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f67344f;

    public a(o<? super R> oVar) {
        this.f67340a = oVar;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        i10.a.b(th2);
        this.f67341b.dispose();
        onError(th2);
    }

    @Override // m10.g
    public void clear() {
        this.f67342c.clear();
    }

    public final int d(int i11) {
        m10.b<T> bVar = this.f67342c;
        if (bVar == null || (i11 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = bVar.requestFusion(i11);
        if (iRequestFusion != 0) {
            this.f67344f = iRequestFusion;
        }
        return iRequestFusion;
    }

    @Override // h10.b
    public void dispose() {
        this.f67341b.dispose();
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.f67341b.isDisposed();
    }

    @Override // m10.g
    public boolean isEmpty() {
        return this.f67342c.isEmpty();
    }

    @Override // m10.g
    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.f67343d) {
            return;
        }
        this.f67343d = true;
        this.f67340a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (this.f67343d) {
            p10.a.q(th2);
        } else {
            this.f67343d = true;
            this.f67340a.onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(h10.b bVar) {
        if (DisposableHelper.validate(this.f67341b, bVar)) {
            this.f67341b = bVar;
            if (bVar instanceof m10.b) {
                this.f67342c = (m10.b) bVar;
            }
            if (b()) {
                this.f67340a.onSubscribe(this);
                a();
            }
        }
    }
}
