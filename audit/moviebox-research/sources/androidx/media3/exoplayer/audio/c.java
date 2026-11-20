package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.exoplayer.n;
import androidx.media3.exoplayer.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f9943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final c f9944b;

        public a(@Nullable Handler handler, @Nullable c cVar) {
            this.f9943a = cVar != null ? (Handler) z3.a.e(handler) : null;
            this.f9944b = cVar;
        }

        public final /* synthetic */ void A(String str) {
            ((c) u0.i(this.f9944b)).c(str);
        }

        public final /* synthetic */ void B(n nVar) {
            nVar.c();
            ((c) u0.i(this.f9944b)).t(nVar);
        }

        public final /* synthetic */ void C(n nVar) {
            ((c) u0.i(this.f9944b)).n(nVar);
        }

        public final /* synthetic */ void D(y yVar, o oVar) {
            ((c) u0.i(this.f9944b)).A(yVar);
            ((c) u0.i(this.f9944b)).s(yVar, oVar);
        }

        public final /* synthetic */ void E(long j11) {
            ((c) u0.i(this.f9944b)).d(j11);
        }

        public final /* synthetic */ void F(boolean z11) {
            ((c) u0.i(this.f9944b)).onSkipSilenceEnabledChanged(z11);
        }

        public final /* synthetic */ void G(int i11, long j11, long j12) {
            ((c) u0.i(this.f9944b)).i(i11, j11, j12);
        }

        public void H(final long j11) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64596a.E(j11);
                    }
                });
            }
        }

        public void I(final boolean z11) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64625a.F(z11);
                    }
                });
            }
        }

        public void J(final int i11, final long j11, final long j12) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64627a.G(i11, j11, j12);
                    }
                });
            }
        }

        public void m(final Exception exc) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64564a.v(exc);
                    }
                });
            }
        }

        public void n(final Exception exc) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64615a.w(exc);
                    }
                });
            }
        }

        public void o(final AudioSink.a aVar) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64569a.x(aVar);
                    }
                });
            }
        }

        public void p(final AudioSink.a aVar) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64566a.y(aVar);
                    }
                });
            }
        }

        public void q(final String str, final long j11, final long j12) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64606a.z(str, j11, j12);
                    }
                });
            }
        }

        public void r(final String str) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64618a.A(str);
                    }
                });
            }
        }

        public void s(final n nVar) {
            nVar.c();
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64576a.B(nVar);
                    }
                });
            }
        }

        public void t(final n nVar) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64593a.C(nVar);
                    }
                });
            }
        }

        public void u(final y yVar, @Nullable final o oVar) {
            Handler handler = this.f9943a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: f4.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64622a.D(yVar, oVar);
                    }
                });
            }
        }

        public final /* synthetic */ void v(Exception exc) {
            ((c) u0.i(this.f9944b)).h(exc);
        }

        public final /* synthetic */ void w(Exception exc) {
            ((c) u0.i(this.f9944b)).a(exc);
        }

        public final /* synthetic */ void x(AudioSink.a aVar) {
            ((c) u0.i(this.f9944b)).k(aVar);
        }

        public final /* synthetic */ void y(AudioSink.a aVar) {
            ((c) u0.i(this.f9944b)).l(aVar);
        }

        public final /* synthetic */ void z(String str, long j11, long j12) {
            ((c) u0.i(this.f9944b)).onAudioDecoderInitialized(str, j11, j12);
        }
    }

    @Deprecated
    void A(y yVar);

    void a(Exception exc);

    void c(String str);

    void d(long j11);

    void h(Exception exc);

    void i(int i11, long j11, long j12);

    void k(AudioSink.a aVar);

    void l(AudioSink.a aVar);

    void n(n nVar);

    void onAudioDecoderInitialized(String str, long j11, long j12);

    void onSkipSilenceEnabledChanged(boolean z11);

    void s(y yVar, @Nullable o oVar);

    void t(n nVar);
}
