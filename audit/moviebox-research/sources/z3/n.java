package z3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f81803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f81804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<T> f81805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<c<T>> f81806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque<Runnable> f81807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque<Runnable> f81808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f81809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f81810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f81811i;

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        void invoke(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        void a(T t11, androidx.media3.common.s sVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f81812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.media3.common.s.b f81813b = new androidx.media3.common.s.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f81814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f81815d;

        public c(T t11) {
            this.f81812a = t11;
        }

        public void a(int i11, a<T> aVar) {
            if (this.f81815d) {
                return;
            }
            if (i11 != -1) {
                this.f81813b.a(i11);
            }
            this.f81814c = true;
            aVar.invoke(this.f81812a);
        }

        public void b(b<T> bVar) {
            if (this.f81815d || !this.f81814c) {
                return;
            }
            androidx.media3.common.s sVarE = this.f81813b.e();
            this.f81813b = new androidx.media3.common.s.b();
            this.f81814c = false;
            bVar.a(this.f81812a, sVarE);
        }

        public void c(b<T> bVar) {
            this.f81815d = true;
            if (this.f81814c) {
                this.f81814c = false;
                bVar.a(this.f81812a, this.f81813b.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f81812a.equals(((c) obj).f81812a);
        }

        public int hashCode() {
            return this.f81812a.hashCode();
        }
    }

    public n(Looper looper, d dVar, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, dVar, bVar, true);
    }

    public n(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, d dVar, b<T> bVar, boolean z11) {
        this.f81803a = dVar;
        this.f81806d = copyOnWriteArraySet;
        this.f81805c = bVar;
        this.f81809g = new Object();
        this.f81807e = new ArrayDeque<>();
        this.f81808f = new ArrayDeque<>();
        this.f81804b = dVar.createHandler(looper, new Handler.Callback() { // from class: z3.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f81799a.g(message);
            }
        });
        this.f81811i = z11;
    }

    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i11, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i11, aVar);
        }
    }

    public void c(T t11) {
        z3.a.e(t11);
        synchronized (this.f81809g) {
            try {
                if (this.f81810h) {
                    return;
                }
                this.f81806d.add(new c<>(t11));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @CheckResult
    public n<T> d(Looper looper, d dVar, b<T> bVar) {
        return new n<>(this.f81806d, looper, dVar, bVar, this.f81811i);
    }

    @CheckResult
    public n<T> e(Looper looper, b<T> bVar) {
        return d(looper, this.f81803a, bVar);
    }

    public void f() {
        m();
        if (this.f81808f.isEmpty()) {
            return;
        }
        if (!this.f81804b.a(0)) {
            j jVar = this.f81804b;
            jVar.b(jVar.obtainMessage(0));
        }
        boolean z11 = !this.f81807e.isEmpty();
        this.f81807e.addAll(this.f81808f);
        this.f81808f.clear();
        if (z11) {
            return;
        }
        while (!this.f81807e.isEmpty()) {
            this.f81807e.peekFirst().run();
            this.f81807e.removeFirst();
        }
    }

    public final boolean g(Message message) {
        Iterator<c<T>> it = this.f81806d.iterator();
        while (it.hasNext()) {
            it.next().b(this.f81805c);
            if (this.f81804b.a(0)) {
                return true;
            }
        }
        return true;
    }

    public void i(final int i11, final a<T> aVar) {
        m();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f81806d);
        this.f81808f.add(new Runnable() { // from class: z3.m
            @Override // java.lang.Runnable
            public final void run() {
                n.h(copyOnWriteArraySet, i11, aVar);
            }
        });
    }

    public void j() {
        m();
        synchronized (this.f81809g) {
            this.f81810h = true;
        }
        Iterator<c<T>> it = this.f81806d.iterator();
        while (it.hasNext()) {
            it.next().c(this.f81805c);
        }
        this.f81806d.clear();
    }

    public void k(T t11) {
        m();
        for (c<T> cVar : this.f81806d) {
            if (cVar.f81812a.equals(t11)) {
                cVar.c(this.f81805c);
                this.f81806d.remove(cVar);
            }
        }
    }

    public void l(int i11, a<T> aVar) {
        i(i11, aVar);
        f();
    }

    public final void m() {
        if (this.f81811i) {
            z3.a.g(Thread.currentThread() == this.f81804b.getLooper().getThread());
        }
    }
}
