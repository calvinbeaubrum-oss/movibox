package androidx.media3.exoplayer.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.source.l;
import java.util.concurrent.CopyOnWriteArrayList;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final l.b f10288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0097a> f10289c;

        /* JADX INFO: renamed from: androidx.media3.exoplayer.drm.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0097a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f10290a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public b f10291b;

            public C0097a(Handler handler, b bVar) {
                this.f10290a = handler;
                this.f10291b = bVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public a(CopyOnWriteArrayList<C0097a> copyOnWriteArrayList, int i11, @Nullable l.b bVar) {
            this.f10289c = copyOnWriteArrayList;
            this.f10287a = i11;
            this.f10288b = bVar;
        }

        public void g(Handler handler, b bVar) {
            z3.a.e(handler);
            z3.a.e(bVar);
            this.f10289c.add(new C0097a(handler, bVar));
        }

        public void h() {
            for (C0097a c0097a : this.f10289c) {
                final b bVar = c0097a.f10291b;
                u0.b1(c0097a.f10290a, new Runnable() { // from class: i4.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f67137a.n(bVar);
                    }
                });
            }
        }

        public void i() {
            for (C0097a c0097a : this.f10289c) {
                final b bVar = c0097a.f10291b;
                u0.b1(c0097a.f10290a, new Runnable() { // from class: i4.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f67135a.o(bVar);
                    }
                });
            }
        }

        public void j() {
            for (C0097a c0097a : this.f10289c) {
                final b bVar = c0097a.f10291b;
                u0.b1(c0097a.f10290a, new Runnable() { // from class: i4.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f67133a.p(bVar);
                    }
                });
            }
        }

        public void k(final int i11) {
            for (C0097a c0097a : this.f10289c) {
                final b bVar = c0097a.f10291b;
                u0.b1(c0097a.f10290a, new Runnable() { // from class: i4.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f67125a.q(bVar, i11);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (C0097a c0097a : this.f10289c) {
                final b bVar = c0097a.f10291b;
                u0.b1(c0097a.f10290a, new Runnable() { // from class: i4.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f67130a.r(bVar, exc);
                    }
                });
            }
        }

        public void m() {
            for (C0097a c0097a : this.f10289c) {
                final b bVar = c0097a.f10291b;
                u0.b1(c0097a.f10290a, new Runnable() { // from class: i4.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f67128a.s(bVar);
                    }
                });
            }
        }

        public final /* synthetic */ void n(b bVar) {
            bVar.f(this.f10287a, this.f10288b);
        }

        public final /* synthetic */ void o(b bVar) {
            bVar.u(this.f10287a, this.f10288b);
        }

        public final /* synthetic */ void p(b bVar) {
            bVar.z(this.f10287a, this.f10288b);
        }

        public final /* synthetic */ void q(b bVar, int i11) {
            bVar.r(this.f10287a, this.f10288b);
            bVar.p(this.f10287a, this.f10288b, i11);
        }

        public final /* synthetic */ void r(b bVar, Exception exc) {
            bVar.v(this.f10287a, this.f10288b, exc);
        }

        public final /* synthetic */ void s(b bVar) {
            bVar.F(this.f10287a, this.f10288b);
        }

        public void t(b bVar) {
            for (C0097a c0097a : this.f10289c) {
                if (c0097a.f10291b == bVar) {
                    this.f10289c.remove(c0097a);
                }
            }
        }

        @CheckResult
        public a u(int i11, @Nullable l.b bVar) {
            return new a(this.f10289c, i11, bVar);
        }
    }

    void F(int i11, @Nullable l.b bVar);

    void f(int i11, @Nullable l.b bVar);

    void p(int i11, @Nullable l.b bVar, int i12);

    @Deprecated
    void r(int i11, @Nullable l.b bVar);

    void u(int i11, @Nullable l.b bVar);

    void v(int i11, @Nullable l.b bVar, Exception exc);

    void z(int i11, @Nullable l.b bVar);
}
