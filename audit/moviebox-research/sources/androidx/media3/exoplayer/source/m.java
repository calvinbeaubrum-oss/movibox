package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface m {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final l.b f11215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0104a> f11216c;

        /* JADX INFO: renamed from: androidx.media3.exoplayer.source.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0104a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f11217a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public m f11218b;

            public C0104a(Handler handler, m mVar) {
                this.f11217a = handler;
                this.f11218b = mVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public a(CopyOnWriteArrayList<C0104a> copyOnWriteArrayList, int i11, @Nullable l.b bVar) {
            this.f11216c = copyOnWriteArrayList;
            this.f11214a = i11;
            this.f11215b = bVar;
        }

        public void A(final p4.n nVar, final p4.o oVar) {
            for (C0104a c0104a : this.f11216c) {
                final m mVar = c0104a.f11218b;
                u0.b1(c0104a.f11217a, new Runnable() { // from class: p4.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f73607a.n(mVar, nVar, oVar);
                    }
                });
            }
        }

        public void B(m mVar) {
            for (C0104a c0104a : this.f11216c) {
                if (c0104a.f11218b == mVar) {
                    this.f11216c.remove(c0104a);
                }
            }
        }

        public void C(int i11, long j11, long j12) {
            D(new p4.o(1, i11, null, 3, null, u0.B1(j11), u0.B1(j12)));
        }

        public void D(final p4.o oVar) {
            final l.b bVar = (l.b) z3.a.e(this.f11215b);
            for (C0104a c0104a : this.f11216c) {
                final m mVar = c0104a.f11218b;
                u0.b1(c0104a.f11217a, new Runnable() { // from class: p4.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f73614a.o(mVar, bVar, oVar);
                    }
                });
            }
        }

        @CheckResult
        public a E(int i11, @Nullable l.b bVar) {
            return new a(this.f11216c, i11, bVar);
        }

        public void g(Handler handler, m mVar) {
            z3.a.e(handler);
            z3.a.e(mVar);
            this.f11216c.add(new C0104a(handler, mVar));
        }

        public void h(int i11, @Nullable y yVar, int i12, @Nullable Object obj, long j11) {
            i(new p4.o(1, i11, yVar, i12, obj, u0.B1(j11), C.TIME_UNSET));
        }

        public void i(final p4.o oVar) {
            for (C0104a c0104a : this.f11216c) {
                final m mVar = c0104a.f11218b;
                u0.b1(c0104a.f11217a, new Runnable() { // from class: p4.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f73611a.j(mVar, oVar);
                    }
                });
            }
        }

        public final /* synthetic */ void j(m mVar, p4.o oVar) {
            mVar.E(this.f11214a, this.f11215b, oVar);
        }

        public final /* synthetic */ void k(m mVar, p4.n nVar, p4.o oVar) {
            mVar.y(this.f11214a, this.f11215b, nVar, oVar);
        }

        public final /* synthetic */ void l(m mVar, p4.n nVar, p4.o oVar) {
            mVar.A(this.f11214a, this.f11215b, nVar, oVar);
        }

        public final /* synthetic */ void m(m mVar, p4.n nVar, p4.o oVar, IOException iOException, boolean z11) {
            mVar.H(this.f11214a, this.f11215b, nVar, oVar, iOException, z11);
        }

        public final /* synthetic */ void n(m mVar, p4.n nVar, p4.o oVar) {
            mVar.B(this.f11214a, this.f11215b, nVar, oVar);
        }

        public final /* synthetic */ void o(m mVar, l.b bVar, p4.o oVar) {
            mVar.D(this.f11214a, bVar, oVar);
        }

        public void p(p4.n nVar, int i11) {
            q(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void q(p4.n nVar, int i11, int i12, @Nullable y yVar, int i13, @Nullable Object obj, long j11, long j12) {
            r(nVar, new p4.o(i11, i12, yVar, i13, obj, u0.B1(j11), u0.B1(j12)));
        }

        public void r(final p4.n nVar, final p4.o oVar) {
            for (C0104a c0104a : this.f11216c) {
                final m mVar = c0104a.f11218b;
                u0.b1(c0104a.f11217a, new Runnable() { // from class: p4.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f73593a.k(mVar, nVar, oVar);
                    }
                });
            }
        }

        public void s(p4.n nVar, int i11) {
            t(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void t(p4.n nVar, int i11, int i12, @Nullable y yVar, int i13, @Nullable Object obj, long j11, long j12) {
            u(nVar, new p4.o(i11, i12, yVar, i13, obj, u0.B1(j11), u0.B1(j12)));
        }

        public void u(final p4.n nVar, final p4.o oVar) {
            for (C0104a c0104a : this.f11216c) {
                final m mVar = c0104a.f11218b;
                u0.b1(c0104a.f11217a, new Runnable() { // from class: p4.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f73603a.l(mVar, nVar, oVar);
                    }
                });
            }
        }

        public void v(p4.n nVar, int i11, int i12, @Nullable y yVar, int i13, @Nullable Object obj, long j11, long j12, IOException iOException, boolean z11) {
            x(nVar, new p4.o(i11, i12, yVar, i13, obj, u0.B1(j11), u0.B1(j12)), iOException, z11);
        }

        public void w(p4.n nVar, int i11, IOException iOException, boolean z11) {
            v(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, iOException, z11);
        }

        public void x(final p4.n nVar, final p4.o oVar, final IOException iOException, final boolean z11) {
            for (C0104a c0104a : this.f11216c) {
                final m mVar = c0104a.f11218b;
                u0.b1(c0104a.f11217a, new Runnable() { // from class: p4.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f73597a.m(mVar, nVar, oVar, iOException, z11);
                    }
                });
            }
        }

        public void y(p4.n nVar, int i11) {
            z(nVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void z(p4.n nVar, int i11, int i12, @Nullable y yVar, int i13, @Nullable Object obj, long j11, long j12) {
            A(nVar, new p4.o(i11, i12, yVar, i13, obj, u0.B1(j11), u0.B1(j12)));
        }
    }

    void A(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar);

    void B(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar);

    void D(int i11, l.b bVar, p4.o oVar);

    void E(int i11, @Nullable l.b bVar, p4.o oVar);

    void H(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar, IOException iOException, boolean z11);

    void y(int i11, @Nullable l.b bVar, p4.n nVar, p4.o oVar);
}
