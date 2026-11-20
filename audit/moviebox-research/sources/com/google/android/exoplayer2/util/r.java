package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f35627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f35628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<T> f35629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<c<T>> f35630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque<Runnable> f35631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque<Runnable> f35632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f35633g;

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        void invoke(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        void a(T t11, m mVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f35634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m.b f35635b = new m.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f35636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f35637d;

        public c(T t11) {
            this.f35634a = t11;
        }

        public void a(int i11, a<T> aVar) {
            if (this.f35637d) {
                return;
            }
            if (i11 != -1) {
                this.f35635b.a(i11);
            }
            this.f35636c = true;
            aVar.invoke(this.f35634a);
        }

        public void b(b<T> bVar) {
            if (this.f35637d || !this.f35636c) {
                return;
            }
            m mVarE = this.f35635b.e();
            this.f35635b = new m.b();
            this.f35636c = false;
            bVar.a(this.f35634a, mVarE);
        }

        public void c(b<T> bVar) {
            this.f35637d = true;
            if (this.f35636c) {
                bVar.a(this.f35634a, this.f35635b.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f35634a.equals(((c) obj).f35634a);
        }

        public int hashCode() {
            return this.f35634a.hashCode();
        }
    }

    public r(Looper looper, e eVar, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, eVar, bVar);
    }

    public r(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, e eVar, b<T> bVar) {
        this.f35627a = eVar;
        this.f35630d = copyOnWriteArraySet;
        this.f35629c = bVar;
        this.f35631e = new ArrayDeque<>();
        this.f35632f = new ArrayDeque<>();
        this.f35628b = eVar.createHandler(looper, new Handler.Callback() { // from class: com.google.android.exoplayer2.util.p
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f35623a.g(message);
            }
        });
    }

    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i11, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i11, aVar);
        }
    }

    public void c(T t11) {
        if (this.f35633g) {
            return;
        }
        com.google.android.exoplayer2.util.a.e(t11);
        this.f35630d.add(new c<>(t11));
    }

    @CheckResult
    public r<T> d(Looper looper, e eVar, b<T> bVar) {
        return new r<>(this.f35630d, looper, eVar, bVar);
    }

    @CheckResult
    public r<T> e(Looper looper, b<T> bVar) {
        return d(looper, this.f35627a, bVar);
    }

    public void f() {
        if (this.f35632f.isEmpty()) {
            return;
        }
        if (!this.f35628b.a(0)) {
            o oVar = this.f35628b;
            oVar.b(oVar.obtainMessage(0));
        }
        boolean z11 = !this.f35631e.isEmpty();
        this.f35631e.addAll(this.f35632f);
        this.f35632f.clear();
        if (z11) {
            return;
        }
        while (!this.f35631e.isEmpty()) {
            this.f35631e.peekFirst().run();
            this.f35631e.removeFirst();
        }
    }

    public final boolean g(Message message) {
        Iterator<c<T>> it = this.f35630d.iterator();
        while (it.hasNext()) {
            it.next().b(this.f35629c);
            if (this.f35628b.a(0)) {
                return true;
            }
        }
        return true;
    }

    public void i(final int i11, final a<T> aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f35630d);
        this.f35632f.add(new Runnable() { // from class: com.google.android.exoplayer2.util.q
            @Override // java.lang.Runnable
            public final void run() {
                r.h(copyOnWriteArraySet, i11, aVar);
            }
        });
    }

    public void j() {
        Iterator<c<T>> it = this.f35630d.iterator();
        while (it.hasNext()) {
            it.next().c(this.f35629c);
        }
        this.f35630d.clear();
        this.f35633g = true;
    }

    public void k(T t11) {
        for (c<T> cVar : this.f35630d) {
            if (cVar.f35634a.equals(t11)) {
                cVar.c(this.f35629c);
                this.f35630d.remove(cVar);
            }
        }
    }

    public void l(int i11, a<T> aVar) {
        i(i11, aVar);
        f();
    }
}
