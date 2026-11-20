package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f19460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ja f19461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f19462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet f19463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque f19464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f19465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19466g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Object obj);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(Object obj, b9 b9Var);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f19467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b9.b f19468b = new b9.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f19469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f19470d;

        public c(Object obj) {
            this.f19467a = obj;
        }

        public void a(int i11, a aVar) {
            if (this.f19470d) {
                return;
            }
            if (i11 != -1) {
                this.f19468b.a(i11);
            }
            this.f19469c = true;
            aVar.a(this.f19467a);
        }

        public void a(b bVar) {
            if (this.f19470d || !this.f19469c) {
                return;
            }
            b9 b9VarA = this.f19468b.a();
            this.f19468b = new b9.b();
            this.f19469c = false;
            bVar.a(this.f19467a, b9VarA);
        }

        public void b(b bVar) {
            this.f19470d = true;
            if (this.f19469c) {
                bVar.a(this.f19467a, this.f19468b.a());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f19467a.equals(((c) obj).f19467a);
        }

        public int hashCode() {
            return this.f19467a.hashCode();
        }
    }

    public hc(Looper looper, l3 l3Var, b bVar) {
        this(new CopyOnWriteArraySet(), looper, l3Var, bVar);
    }

    private hc(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, l3 l3Var, b bVar) {
        this.f19460a = l3Var;
        this.f19463d = copyOnWriteArraySet;
        this.f19462c = bVar;
        this.f19464e = new ArrayDeque();
        this.f19465f = new ArrayDeque();
        this.f19461b = l3Var.a(looper, new Handler.Callback() { // from class: com.applovin.impl.fy
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f19134a.a(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(CopyOnWriteArraySet copyOnWriteArraySet, int i11, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i11, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Message message) {
        Iterator it = this.f19463d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(this.f19462c);
            if (this.f19461b.a(0)) {
                return true;
            }
        }
        return true;
    }

    public hc a(Looper looper, b bVar) {
        return new hc(this.f19463d, looper, this.f19460a, bVar);
    }

    public void a() {
        if (this.f19465f.isEmpty()) {
            return;
        }
        if (!this.f19461b.a(0)) {
            ja jaVar = this.f19461b;
            jaVar.a(jaVar.d(0));
        }
        boolean z11 = !this.f19464e.isEmpty();
        this.f19464e.addAll(this.f19465f);
        this.f19465f.clear();
        if (z11) {
            return;
        }
        while (!this.f19464e.isEmpty()) {
            ((Runnable) this.f19464e.peekFirst()).run();
            this.f19464e.removeFirst();
        }
    }

    public void a(final int i11, final a aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f19463d);
        this.f19465f.add(new Runnable() { // from class: com.applovin.impl.ey
            @Override // java.lang.Runnable
            public final void run() {
                hc.a(copyOnWriteArraySet, i11, aVar);
            }
        });
    }

    public void a(Object obj) {
        if (this.f19466g) {
            return;
        }
        b1.a(obj);
        this.f19463d.add(new c(obj));
    }

    public void b() {
        Iterator it = this.f19463d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(this.f19462c);
        }
        this.f19463d.clear();
        this.f19466g = true;
    }

    public void b(int i11, a aVar) {
        a(i11, aVar);
        a();
    }

    public void b(Object obj) {
        for (c cVar : this.f19463d) {
            if (cVar.f19467a.equals(obj)) {
                cVar.b(this.f19462c);
                this.f19463d.remove(cVar);
            }
        }
    }
}
