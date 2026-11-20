package com.transsion.transfer.androidasync.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class w<T> extends n implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.transsion.transfer.androidasync.d f58543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Exception f58544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f58545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f58546d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a<T> f58547f;

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        void a(Exception exc, T t11, b bVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Exception f58548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f58549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f58550c;

        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            while (true) {
                a aVar = this.f58550c;
                if (aVar == 0) {
                    return;
                }
                Exception exc = this.f58548a;
                Object obj = this.f58549b;
                this.f58550c = null;
                this.f58548a = null;
                this.f58549b = null;
                aVar.a(exc, obj, this);
            }
        }
    }

    public w() {
    }

    public w(T t11) {
        J(t11);
    }

    public static /* synthetic */ f A(y yVar, Object obj) throws Exception {
        return new w(yVar.then(obj));
    }

    public static /* synthetic */ f t(d dVar, Exception exc) throws Exception {
        dVar.a(exc);
        return new w(null);
    }

    public static /* synthetic */ void u(w wVar, e eVar, Exception exc, Object obj, b bVar) {
        if (exc == null) {
            wVar.I(exc, obj, bVar);
            return;
        }
        try {
            wVar.F(eVar.a(exc), bVar);
        } catch (Exception e11) {
            wVar.I(e11, null, bVar);
        }
    }

    public static /* synthetic */ void y(x xVar, w wVar, Exception e11, Object obj, b bVar) {
        if (e11 == null) {
            try {
                xVar.a(obj);
            } catch (Exception e12) {
                e11 = e12;
            }
        }
        wVar.I(e11, obj, bVar);
    }

    public static /* synthetic */ void z(w wVar, z zVar, Exception exc, Object obj, b bVar) {
        if (exc != null) {
            wVar.I(exc, null, bVar);
            return;
        }
        try {
            wVar.F(zVar.then(obj), bVar);
        } catch (Exception e11) {
            wVar.I(e11, null, bVar);
        }
    }

    public void B() {
        com.transsion.transfer.androidasync.d dVar = this.f58543a;
        if (dVar != null) {
            dVar.b();
            this.f58543a = null;
        }
    }

    @Override // com.transsion.transfer.androidasync.future.n
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public w<T> reset() {
        super.reset();
        this.f58545c = null;
        this.f58544b = null;
        this.f58543a = null;
        this.f58547f = null;
        this.f58546d = false;
        return this;
    }

    public void D(b bVar, a<T> aVar) {
        synchronized (this) {
            try {
                this.f58547f = aVar;
                if (isDone() || isCancelled()) {
                    p(bVar, q());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public f<T> E(f<T> fVar) {
        return F(fVar, null);
    }

    public final f<T> F(f<T> fVar, b bVar) {
        setParent(fVar);
        final w wVar = new w();
        if (fVar instanceof w) {
            ((w) fVar).D(bVar, new a() { // from class: com.transsion.transfer.androidasync.future.p
                @Override // com.transsion.transfer.androidasync.future.w.a
                public final void a(Exception exc, Object obj, w.b bVar2) {
                    this.f58531a.w(wVar, exc, obj, bVar2);
                }
            });
        } else {
            fVar.j(new g() { // from class: com.transsion.transfer.androidasync.future.q
                @Override // com.transsion.transfer.androidasync.future.g
                public final void a(Exception exc, Object obj) {
                    this.f58533a.x(wVar, exc, obj);
                }
            });
        }
        return wVar;
    }

    public boolean G(Exception exc) {
        return I(exc, null, null);
    }

    public boolean H(Exception exc, T t11) {
        return I(exc, t11, null);
    }

    public final boolean I(Exception exc, T t11, b bVar) {
        synchronized (this) {
            try {
                if (!super.setComplete()) {
                    return false;
                }
                this.f58545c = t11;
                this.f58544b = exc;
                B();
                p(bVar, q());
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean J(T t11) {
        return I(null, t11, null);
    }

    @Override // com.transsion.transfer.androidasync.future.f
    public <R> f<R> a(final z<R, T> zVar) {
        final w wVar = new w();
        wVar.setParent(this);
        D(null, new a() { // from class: com.transsion.transfer.androidasync.future.r
            @Override // com.transsion.transfer.androidasync.future.w.a
            public final void a(Exception exc, Object obj, w.b bVar) {
                w.z(this.f58535a, zVar, exc, obj, bVar);
            }
        });
        return wVar;
    }

    @Override // com.transsion.transfer.androidasync.future.n, com.transsion.transfer.androidasync.future.a
    public boolean cancel() {
        return l(this.f58546d);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        return cancel();
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                m().a();
                return o();
            }
            return o();
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                com.transsion.transfer.androidasync.d dVarM = m();
                if (dVarM.c(j11, timeUnit)) {
                    return o();
                }
                throw new TimeoutException();
            }
            return o();
        }
    }

    @Override // com.transsion.transfer.androidasync.future.f
    public f<T> i(final d dVar) {
        return n(new e() { // from class: com.transsion.transfer.androidasync.future.o
            @Override // com.transsion.transfer.androidasync.future.e
            public final f a(Exception exc) {
                return w.t(dVar, exc);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.future.f
    public void j(final g<T> gVar) {
        if (gVar == null) {
            D(null, null);
        } else {
            D(null, new a() { // from class: com.transsion.transfer.androidasync.future.s
                @Override // com.transsion.transfer.androidasync.future.w.a
                public final void a(Exception exc, Object obj, w.b bVar) {
                    gVar.a(exc, obj);
                }
            });
        }
    }

    public final boolean l(boolean z11) {
        a<T> aVarQ;
        if (!super.cancel()) {
            return false;
        }
        synchronized (this) {
            this.f58544b = new CancellationException();
            B();
            aVarQ = q();
            this.f58546d = z11;
        }
        p(null, aVarQ);
        return true;
    }

    public com.transsion.transfer.androidasync.d m() {
        if (this.f58543a == null) {
            this.f58543a = new com.transsion.transfer.androidasync.d();
        }
        return this.f58543a;
    }

    public f<T> n(final e<T> eVar) {
        final w wVar = new w();
        wVar.setParent(this);
        D(null, new a() { // from class: com.transsion.transfer.androidasync.future.t
            @Override // com.transsion.transfer.androidasync.future.w.a
            public final void a(Exception exc, Object obj, w.b bVar) {
                w.u(this.f58538a, eVar, exc, obj, bVar);
            }
        });
        return wVar;
    }

    public final T o() throws ExecutionException {
        if (this.f58544b == null) {
            return this.f58545c;
        }
        throw new ExecutionException(this.f58544b);
    }

    public final void p(b bVar, a<T> aVar) {
        boolean z11;
        if (this.f58546d || aVar == null) {
            return;
        }
        if (bVar == null) {
            bVar = new b();
            z11 = true;
        } else {
            z11 = false;
        }
        bVar.f58550c = aVar;
        bVar.f58548a = this.f58544b;
        bVar.f58549b = this.f58545c;
        if (z11) {
            bVar.a();
        }
    }

    public final a<T> q() {
        a<T> aVar = this.f58547f;
        this.f58547f = null;
        return aVar;
    }

    @Override // com.transsion.transfer.androidasync.future.f
    public <R> f<R> r(final y<R, T> yVar) {
        return a(new z() { // from class: com.transsion.transfer.androidasync.future.u
            @Override // com.transsion.transfer.androidasync.future.z
            public final f then(Object obj) {
                return w.A(yVar, obj);
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.future.f
    public f<T> s(final x<T> xVar) {
        final w wVar = new w();
        wVar.setParent(this);
        D(null, new a() { // from class: com.transsion.transfer.androidasync.future.v
            @Override // com.transsion.transfer.androidasync.future.w.a
            public final void a(Exception exc, Object obj, w.b bVar) {
                w.y(xVar, wVar, exc, obj, bVar);
            }
        });
        return wVar;
    }

    @Override // com.transsion.transfer.androidasync.future.n
    public boolean setComplete() {
        return J(null);
    }

    @Override // com.transsion.transfer.androidasync.future.n, com.transsion.transfer.androidasync.future.b
    public boolean setParent(com.transsion.transfer.androidasync.future.a aVar) {
        return super.setParent(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void w(w wVar, Exception exc, Object obj, b bVar) {
        wVar.I(I(exc, obj, bVar) ? null : new CancellationException(), obj, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void x(w wVar, Exception exc, Object obj) {
        wVar.G(I(exc, obj, null) ? null : new CancellationException());
    }
}
