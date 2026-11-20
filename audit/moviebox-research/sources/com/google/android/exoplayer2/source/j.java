package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface j {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final i.b f34234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0368a> f34235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f34236d;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.source.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0368a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f34237a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public j f34238b;

            public C0368a(Handler handler, j jVar) {
                this.f34237a = handler;
                this.f34238b = jVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        public a(CopyOnWriteArrayList<C0368a> copyOnWriteArrayList, int i11, @Nullable i.b bVar, long j11) {
            this.f34235c = copyOnWriteArrayList;
            this.f34233a = i11;
            this.f34234b = bVar;
            this.f34236d = j11;
        }

        public void A(nh.n nVar, int i11, int i12, @Nullable m1 m1Var, int i13, @Nullable Object obj, long j11, long j12) {
            B(nVar, new nh.o(i11, i12, m1Var, i13, obj, h(j11), h(j12)));
        }

        public void B(final nh.n nVar, final nh.o oVar) {
            for (C0368a c0368a : this.f34235c) {
                final j jVar = c0368a.f34238b;
                o0.L0(c0368a.f34237a, new Runnable() { // from class: nh.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f71979a.o(jVar, nVar, oVar);
                    }
                });
            }
        }

        public void C(j jVar) {
            for (C0368a c0368a : this.f34235c) {
                if (c0368a.f34238b == jVar) {
                    this.f34235c.remove(c0368a);
                }
            }
        }

        public void D(int i11, long j11, long j12) {
            E(new nh.o(1, i11, null, 3, null, h(j11), h(j12)));
        }

        public void E(final nh.o oVar) {
            final i.b bVar = (i.b) com.google.android.exoplayer2.util.a.e(this.f34234b);
            for (C0368a c0368a : this.f34235c) {
                final j jVar = c0368a.f34238b;
                o0.L0(c0368a.f34237a, new Runnable() { // from class: nh.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f71986a.p(jVar, bVar, oVar);
                    }
                });
            }
        }

        @CheckResult
        public a F(int i11, @Nullable i.b bVar, long j11) {
            return new a(this.f34235c, i11, bVar, j11);
        }

        public void g(Handler handler, j jVar) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(jVar);
            this.f34235c.add(new C0368a(handler, jVar));
        }

        public final long h(long j11) {
            long jF1 = o0.f1(j11);
            return jF1 == C.TIME_UNSET ? C.TIME_UNSET : this.f34236d + jF1;
        }

        public void i(int i11, @Nullable m1 m1Var, int i12, @Nullable Object obj, long j11) {
            j(new nh.o(1, i11, m1Var, i12, obj, h(j11), C.TIME_UNSET));
        }

        public void j(final nh.o oVar) {
            for (C0368a c0368a : this.f34235c) {
                final j jVar = c0368a.f34238b;
                o0.L0(c0368a.f34237a, new Runnable() { // from class: nh.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f71983a.k(jVar, oVar);
                    }
                });
            }
        }

        public final /* synthetic */ void k(j jVar, nh.o oVar) {
            jVar.w(this.f34233a, this.f34234b, oVar);
        }

        public final /* synthetic */ void l(j jVar, nh.n nVar, nh.o oVar) {
            jVar.q(this.f34233a, this.f34234b, nVar, oVar);
        }

        public final /* synthetic */ void m(j jVar, nh.n nVar, nh.o oVar) {
            jVar.B(this.f34233a, this.f34234b, nVar, oVar);
        }

        public final /* synthetic */ void n(j jVar, nh.n nVar, nh.o oVar, IOException iOException, boolean z11) {
            jVar.A(this.f34233a, this.f34234b, nVar, oVar, iOException, z11);
        }

        public final /* synthetic */ void o(j jVar, nh.n nVar, nh.o oVar) {
            jVar.f(this.f34233a, this.f34234b, nVar, oVar);
        }

        public final /* synthetic */ void p(j jVar, i.b bVar, nh.o oVar) {
            jVar.p(this.f34233a, bVar, oVar);
        }

        public void q(nh.n nVar, int i11) {
            r(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void r(nh.n nVar, int i11, int i12, @Nullable m1 m1Var, int i13, @Nullable Object obj, long j11, long j12) {
            s(nVar, new nh.o(i11, i12, m1Var, i13, obj, h(j11), h(j12)));
        }

        public void s(final nh.n nVar, final nh.o oVar) {
            for (C0368a c0368a : this.f34235c) {
                final j jVar = c0368a.f34238b;
                o0.L0(c0368a.f34237a, new Runnable() { // from class: nh.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f71975a.l(jVar, nVar, oVar);
                    }
                });
            }
        }

        public void t(nh.n nVar, int i11) {
            u(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void u(nh.n nVar, int i11, int i12, @Nullable m1 m1Var, int i13, @Nullable Object obj, long j11, long j12) {
            v(nVar, new nh.o(i11, i12, m1Var, i13, obj, h(j11), h(j12)));
        }

        public void v(final nh.n nVar, final nh.o oVar) {
            for (C0368a c0368a : this.f34235c) {
                final j jVar = c0368a.f34238b;
                o0.L0(c0368a.f34237a, new Runnable() { // from class: nh.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f71971a.m(jVar, nVar, oVar);
                    }
                });
            }
        }

        public void w(nh.n nVar, int i11, int i12, @Nullable m1 m1Var, int i13, @Nullable Object obj, long j11, long j12, IOException iOException, boolean z11) {
            y(nVar, new nh.o(i11, i12, m1Var, i13, obj, h(j11), h(j12)), iOException, z11);
        }

        public void x(nh.n nVar, int i11, IOException iOException, boolean z11) {
            w(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, iOException, z11);
        }

        public void y(final nh.n nVar, final nh.o oVar, final IOException iOException, final boolean z11) {
            for (C0368a c0368a : this.f34235c) {
                final j jVar = c0368a.f34238b;
                o0.L0(c0368a.f34237a, new Runnable() { // from class: nh.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f71965a.n(jVar, nVar, oVar, iOException, z11);
                    }
                });
            }
        }

        public void z(nh.n nVar, int i11) {
            A(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }
    }

    void A(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar, IOException iOException, boolean z11);

    void B(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar);

    void f(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar);

    void p(int i11, i.b bVar, nh.o oVar);

    void q(int i11, @Nullable i.b bVar, nh.n nVar, nh.o oVar);

    void w(int i11, @Nullable i.b bVar, nh.o oVar);
}
