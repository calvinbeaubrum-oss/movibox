package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f8661k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i1.b<d0<? super T>, LiveData<T>.c> f8663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f8666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f8667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f8671j;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends LiveData<T>.c {
        public a(d0<? super T> d0Var) {
            super(d0Var);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean d() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends LiveData<T>.c implements r {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        public final u f8673f;

        public b(u uVar, d0<? super T> d0Var) {
            super(d0Var);
            this.f8673f = uVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public void b() {
            this.f8673f.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean c(u uVar) {
            return this.f8673f == uVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean d() {
            return this.f8673f.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(@NonNull u uVar, @NonNull Lifecycle.Event event) {
            Lifecycle.State stateB = this.f8673f.getLifecycle().b();
            if (stateB == Lifecycle.State.DESTROYED) {
                LiveData.this.o(this.f8675a);
                return;
            }
            Lifecycle.State state = null;
            while (state != stateB) {
                a(d());
                state = stateB;
                stateB = this.f8673f.getLifecycle().b();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0<? super T> f8675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8677c = -1;

        public c(d0<? super T> d0Var) {
            this.f8675a = d0Var;
        }

        public void a(boolean z11) {
            if (z11 == this.f8676b) {
                return;
            }
            this.f8676b = z11;
            LiveData.this.c(z11 ? 1 : -1);
            if (this.f8676b) {
                LiveData.this.e(this);
            }
        }

        public void b() {
        }

        public boolean c(u uVar) {
            return false;
        }

        public abstract boolean d();
    }

    public LiveData() {
        this.f8662a = new Object();
        this.f8663b = new i1.b<>();
        this.f8664c = 0;
        Object obj = f8661k;
        this.f8667f = obj;
        this.f8671j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f8662a) {
                    obj2 = LiveData.this.f8667f;
                    LiveData.this.f8667f = LiveData.f8661k;
                }
                LiveData.this.q(obj2);
            }
        };
        this.f8666e = obj;
        this.f8668g = -1;
    }

    public LiveData(T t11) {
        this.f8662a = new Object();
        this.f8663b = new i1.b<>();
        this.f8664c = 0;
        this.f8667f = f8661k;
        this.f8671j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f8662a) {
                    obj2 = LiveData.this.f8667f;
                    LiveData.this.f8667f = LiveData.f8661k;
                }
                LiveData.this.q(obj2);
            }
        };
        this.f8666e = t11;
        this.f8668g = 0;
    }

    public static void b(String str) {
        if (h1.c.h().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void c(int i11) {
        int i12 = this.f8664c;
        this.f8664c = i11 + i12;
        if (this.f8665d) {
            return;
        }
        this.f8665d = true;
        while (true) {
            try {
                int i13 = this.f8664c;
                if (i12 == i13) {
                    this.f8665d = false;
                    return;
                }
                boolean z11 = i12 == 0 && i13 > 0;
                boolean z12 = i12 > 0 && i13 == 0;
                if (z11) {
                    l();
                } else if (z12) {
                    m();
                }
                i12 = i13;
            } catch (Throwable th2) {
                this.f8665d = false;
                throw th2;
            }
        }
    }

    public final void d(LiveData<T>.c cVar) {
        if (cVar.f8676b) {
            if (!cVar.d()) {
                cVar.a(false);
                return;
            }
            int i11 = cVar.f8677c;
            int i12 = this.f8668g;
            if (i11 >= i12) {
                return;
            }
            cVar.f8677c = i12;
            cVar.f8675a.onChanged((Object) this.f8666e);
        }
    }

    public void e(@Nullable LiveData<T>.c cVar) {
        if (this.f8669h) {
            this.f8670i = true;
            return;
        }
        this.f8669h = true;
        do {
            this.f8670i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                i1.b<d0<? super T>, LiveData<T>.c>.d dVarE = this.f8663b.e();
                while (dVarE.hasNext()) {
                    d((c) dVarE.next().getValue());
                    if (this.f8670i) {
                        break;
                    }
                }
            }
        } while (this.f8670i);
        this.f8669h = false;
    }

    @Nullable
    public T f() {
        T t11 = (T) this.f8666e;
        if (t11 != f8661k) {
            return t11;
        }
        return null;
    }

    public int g() {
        return this.f8668g;
    }

    public boolean h() {
        return this.f8664c > 0;
    }

    public boolean i() {
        return this.f8666e != f8661k;
    }

    public void j(@NonNull u uVar, @NonNull d0<? super T> d0Var) {
        b("observe");
        if (uVar.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        b bVar = new b(uVar, d0Var);
        LiveData<T>.c cVarI = this.f8663b.i(d0Var, bVar);
        if (cVarI != null && !cVarI.c(uVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarI != null) {
            return;
        }
        uVar.getLifecycle().a(bVar);
    }

    public void k(@NonNull d0<? super T> d0Var) {
        b("observeForever");
        a aVar = new a(d0Var);
        LiveData<T>.c cVarI = this.f8663b.i(d0Var, aVar);
        if (cVarI instanceof b) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarI != null) {
            return;
        }
        aVar.a(true);
    }

    public void l() {
    }

    public void m() {
    }

    public void n(T t11) {
        boolean z11;
        synchronized (this.f8662a) {
            z11 = this.f8667f == f8661k;
            this.f8667f = t11;
        }
        if (z11) {
            h1.c.h().d(this.f8671j);
        }
    }

    public void o(@NonNull d0<? super T> d0Var) {
        b("removeObserver");
        LiveData<T>.c cVarJ = this.f8663b.j(d0Var);
        if (cVarJ == null) {
            return;
        }
        cVarJ.b();
        cVarJ.a(false);
    }

    public void p(@NonNull u uVar) {
        b("removeObservers");
        for (Map.Entry<d0<? super T>, LiveData<T>.c> entry : this.f8663b) {
            if (entry.getValue().c(uVar)) {
                o(entry.getKey());
            }
        }
    }

    public void q(T t11) {
        b("setValue");
        this.f8668g++;
        this.f8666e = t11;
        e(null);
    }
}
