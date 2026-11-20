package com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38909h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38910i = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ListenerCallQueue.a<a0> f38916o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f38917a = new w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.a f38918b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w.a f38919c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w.a f38920d = new g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w.a f38921e = new j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ListenerCallQueue<a0> f38922f = new ListenerCallQueue<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile k f38923g = new k(Service$State.NEW);

    /* JADX INFO: compiled from: source.java */
    public class a implements ListenerCallQueue.a<a0> {
        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var) {
            a0Var.c();
        }

        public String toString() {
            return "starting()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ListenerCallQueue.a<a0> {
        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var) {
            a0Var.b();
        }

        public String toString() {
            return "running()";
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0403c implements ListenerCallQueue.a<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service$State f38924a;

        public C0403c(Service$State service$State) {
            this.f38924a = service$State;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var) {
            a0Var.e(this.f38924a);
        }

        public String toString() {
            return "terminated({from = " + this.f38924a + "})";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements ListenerCallQueue.a<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service$State f38925a;

        public d(Service$State service$State) {
            this.f38925a = service$State;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var) {
            a0Var.d(this.f38925a);
        }

        public String toString() {
            return "stopping({from = " + this.f38925a + "})";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements ListenerCallQueue.a<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service$State f38926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f38927b;

        public e(c cVar, Service$State service$State, Throwable th2) {
            this.f38926a = service$State;
            this.f38927b = th2;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var) {
            a0Var.a(this.f38926a, this.f38927b);
        }

        public String toString() {
            return "failed({from = " + this.f38926a + ", cause = " + this.f38927b + "})";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38928a;

        static {
            int[] iArr = new int[Service$State.values().length];
            f38928a = iArr;
            try {
                iArr[Service$State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38928a[Service$State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38928a[Service$State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38928a[Service$State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38928a[Service$State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38928a[Service$State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g extends w.a {
        public g() {
            super(c.this.f38917a);
        }

        @Override // com.google.common.util.concurrent.w.a
        public boolean a() {
            return c.this.e().compareTo(Service$State.RUNNING) >= 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class h extends w.a {
        public h() {
            super(c.this.f38917a);
        }

        @Override // com.google.common.util.concurrent.w.a
        public boolean a() {
            return c.this.e() == Service$State.NEW;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class i extends w.a {
        public i() {
            super(c.this.f38917a);
        }

        @Override // com.google.common.util.concurrent.w.a
        public boolean a() {
            return c.this.e().compareTo(Service$State.RUNNING) <= 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class j extends w.a {
        public j() {
            super(c.this.f38917a);
        }

        @Override // com.google.common.util.concurrent.w.a
        public boolean a() {
            return c.this.e().compareTo(Service$State.TERMINATED) >= 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Service$State f38933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f38934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f38935c;

        public k(Service$State service$State) {
            this(service$State, false, null);
        }

        public k(Service$State service$State, boolean z11, Throwable th2) {
            com.google.common.base.m.k(!z11 || service$State == Service$State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", service$State);
            com.google.common.base.m.l((th2 != null) == (service$State == Service$State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", service$State, th2);
            this.f38933a = service$State;
            this.f38934b = z11;
            this.f38935c = th2;
        }

        public Service$State a() {
            return (this.f38934b && this.f38933a == Service$State.STARTING) ? Service$State.STOPPING : this.f38933a;
        }
    }

    static {
        Service$State service$State = Service$State.STARTING;
        f38911j = f(service$State);
        Service$State service$State2 = Service$State.RUNNING;
        f38912k = f(service$State2);
        f38913l = g(Service$State.NEW);
        f38914m = g(service$State);
        f38915n = g(service$State2);
        f38916o = g(Service$State.STOPPING);
    }

    public static ListenerCallQueue.a<a0> f(Service$State service$State) {
        return new d(service$State);
    }

    public static ListenerCallQueue.a<a0> g(Service$State service$State) {
        return new C0403c(service$State);
    }

    public final void b() {
        if (this.f38917a.c()) {
            return;
        }
        this.f38922f.b();
    }

    public final void c(Service$State service$State, Throwable th2) {
        this.f38922f.c(new e(this, service$State, th2));
    }

    public final void d(Throwable th2) {
        com.google.common.base.m.p(th2);
        this.f38917a.b();
        try {
            Service$State service$StateE = e();
            int i11 = f.f38928a[service$StateE.ordinal()];
            if (i11 != 1) {
                if (i11 == 2 || i11 == 3 || i11 == 4) {
                    this.f38923g = new k(Service$State.FAILED, false, th2);
                    c(service$StateE, th2);
                } else if (i11 != 5) {
                }
                this.f38917a.e();
                b();
                return;
            }
            throw new IllegalStateException("Failed while in state:" + service$StateE, th2);
        } catch (Throwable th3) {
            this.f38917a.e();
            b();
            throw th3;
        }
    }

    public final Service$State e() {
        return this.f38923g.a();
    }
}
