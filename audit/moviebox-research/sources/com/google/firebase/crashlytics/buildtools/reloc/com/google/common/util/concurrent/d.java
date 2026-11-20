package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class d implements Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ListenerCallQueue.a<Service.b> f39978h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ListenerCallQueue.a<Service.b> f39979i = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ListenerCallQueue.a<Service.b> f39980j = l(Service.State.STARTING);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ListenerCallQueue.a<Service.b> f39981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ListenerCallQueue.a<Service.b> f39982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ListenerCallQueue.a<Service.b> f39983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ListenerCallQueue.a<Service.b> f39984n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f39985a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0.a f39986b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0.a f39987c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0.a f39988d = new g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0.a f39989e = new j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ListenerCallQueue<Service.b> f39990f = new ListenerCallQueue<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile k f39991g = new k(Service.State.NEW);

    /* JADX INFO: compiled from: source.java */
    public static class a implements ListenerCallQueue.a<Service.b> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.b bVar) {
            bVar.c();
        }

        public String toString() {
            return "starting()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements ListenerCallQueue.a<Service.b> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.b bVar) {
            bVar.b();
        }

        public String toString() {
            return "running()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements ListenerCallQueue.a<Service.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service.State f39992a;

        public c(Service.State state) {
            this.f39992a = state;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.b bVar) {
            bVar.e(this.f39992a);
        }

        public String toString() {
            return "terminated({from = " + this.f39992a + "})";
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0422d implements ListenerCallQueue.a<Service.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service.State f39993a;

        public C0422d(Service.State state) {
            this.f39993a = state;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.b bVar) {
            bVar.d(this.f39993a);
        }

        public String toString() {
            return "stopping({from = " + this.f39993a + "})";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements ListenerCallQueue.a<Service.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service.State f39994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f39995b;

        public e(Service.State state, Throwable th2) {
            this.f39994a = state;
            this.f39995b = th2;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenerCallQueue.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.b bVar) {
            bVar.a(this.f39994a, this.f39995b);
        }

        public String toString() {
            return "failed({from = " + this.f39994a + ", cause = " + this.f39995b + "})";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39997a;

        static {
            int[] iArr = new int[Service.State.values().length];
            f39997a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39997a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39997a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39997a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39997a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39997a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g extends j0.a {
        public g() {
            super(d.this.f39985a);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.j0.a
        public boolean a() {
            return d.this.a().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class h extends j0.a {
        public h() {
            super(d.this.f39985a);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.j0.a
        public boolean a() {
            return d.this.a() == Service.State.NEW;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class i extends j0.a {
        public i() {
            super(d.this.f39985a);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.j0.a
        public boolean a() {
            return d.this.a().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class j extends j0.a {
        public j() {
            super(d.this.f39985a);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.j0.a
        public boolean a() {
            return d.this.a().isTerminal();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Service.State f40002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f40003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f40004c;

        public k(Service.State state) {
            this(state, false, null);
        }

        public k(Service.State state, boolean z11, Throwable th2) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(!z11 || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(!((state == Service.State.FAILED) ^ (th2 != null)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th2);
            this.f40002a = state;
            this.f40003b = z11;
            this.f40004c = th2;
        }

        public Service.State a() {
            return (this.f40003b && this.f40002a == Service.State.STARTING) ? Service.State.STOPPING : this.f40002a;
        }
    }

    static {
        Service.State state = Service.State.RUNNING;
        f39981k = l(state);
        f39982l = m(Service.State.NEW);
        f39983m = m(state);
        f39984n = m(Service.State.STOPPING);
    }

    public static ListenerCallQueue.a<Service.b> l(Service.State state) {
        return new C0422d(state);
    }

    public static ListenerCallQueue.a<Service.b> m(Service.State state) {
        return new c(state);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.f39991g.a();
    }

    public final void c() {
        if (this.f39985a.c()) {
            return;
        }
        this.f39990f.b();
    }

    public abstract void d();

    public final void e(Service.State state, Throwable th2) {
        this.f39990f.c(new e(state, th2));
    }

    public final void f() {
        this.f39990f.c(f39979i);
    }

    public final void g(Service.State state) {
        int i11 = f.f39997a[state.ordinal()];
        if (i11 == 1) {
            this.f39990f.c(f39982l);
        } else if (i11 == 3) {
            this.f39990f.c(f39983m);
        } else {
            if (i11 != 4) {
                throw new AssertionError();
            }
            this.f39990f.c(f39984n);
        }
    }

    public final boolean h() {
        return a() == Service.State.RUNNING;
    }

    public final void i(Throwable th2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(th2);
        this.f39985a.b();
        try {
            Service.State stateA = a();
            switch (f.f39997a[stateA.ordinal()]) {
                case 1:
                case 5:
                    throw new IllegalStateException("Failed while in state:" + stateA, th2);
                case 2:
                case 3:
                case 4:
                    this.f39991g = new k(Service.State.FAILED, false, th2);
                    e(stateA, th2);
                    break;
                case 6:
                    break;
                default:
                    throw new AssertionError("Unexpected state: " + stateA);
            }
            this.f39985a.e();
            c();
        } catch (Throwable th3) {
            this.f39985a.e();
            c();
            throw th3;
        }
    }

    public final void j() {
        this.f39985a.b();
        try {
            if (this.f39991g.f40002a != Service.State.STARTING) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f39991g.f40002a);
                i(illegalStateException);
                throw illegalStateException;
            }
            if (this.f39991g.f40003b) {
                this.f39991g = new k(Service.State.STOPPING);
                d();
            } else {
                this.f39991g = new k(Service.State.RUNNING);
                f();
            }
            this.f39985a.e();
            c();
        } catch (Throwable th2) {
            this.f39985a.e();
            c();
            throw th2;
        }
    }

    public final void k() {
        this.f39985a.b();
        try {
            Service.State state = this.f39991g.f40002a;
            if (state != Service.State.STOPPING && state != Service.State.RUNNING) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStopped() when the service is " + state);
                i(illegalStateException);
                throw illegalStateException;
            }
            this.f39991g = new k(Service.State.TERMINATED);
            g(state);
            this.f39985a.e();
            c();
        } catch (Throwable th2) {
            this.f39985a.e();
            c();
            throw th2;
        }
    }
}
