package androidx.media3.exoplayer.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.t0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f11610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final f0 f11611b;

        public a(@Nullable Handler handler, @Nullable f0 f0Var) {
            this.f11610a = f0Var != null ? (Handler) z3.a.e(handler) : null;
            this.f11611b = f0Var;
        }

        public void A(final Object obj) {
            if (this.f11610a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f11610a.post(new Runnable() { // from class: androidx.media3.exoplayer.video.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11744a.w(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j11, final int i11) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11749a.x(j11, i11);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11747a.y(exc);
                    }
                });
            }
        }

        public void D(final t0 t0Var) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11566a.z(t0Var);
                    }
                });
            }
        }

        public void k(final String str, final long j11, final long j12) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11557a.q(str, j11, j12);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11569a.r(str);
                    }
                });
            }
        }

        public void m(final androidx.media3.exoplayer.n nVar) {
            nVar.c();
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11553a.s(nVar);
                    }
                });
            }
        }

        public void n(final int i11, final long j11) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11741a.t(i11, j11);
                    }
                });
            }
        }

        public void o(final androidx.media3.exoplayer.n nVar) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11752a.u(nVar);
                    }
                });
            }
        }

        public void p(final androidx.media3.common.y yVar, @Nullable final androidx.media3.exoplayer.o oVar) {
            Handler handler = this.f11610a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11561a.v(yVar, oVar);
                    }
                });
            }
        }

        public final /* synthetic */ void q(String str, long j11, long j12) {
            ((f0) u0.i(this.f11611b)).onVideoDecoderInitialized(str, j11, j12);
        }

        public final /* synthetic */ void r(String str) {
            ((f0) u0.i(this.f11611b)).b(str);
        }

        public final /* synthetic */ void s(androidx.media3.exoplayer.n nVar) {
            nVar.c();
            ((f0) u0.i(this.f11611b)).x(nVar);
        }

        public final /* synthetic */ void t(int i11, long j11) {
            ((f0) u0.i(this.f11611b)).onDroppedFrames(i11, j11);
        }

        public final /* synthetic */ void u(androidx.media3.exoplayer.n nVar) {
            ((f0) u0.i(this.f11611b)).o(nVar);
        }

        public final /* synthetic */ void v(androidx.media3.common.y yVar, androidx.media3.exoplayer.o oVar) {
            ((f0) u0.i(this.f11611b)).B(yVar);
            ((f0) u0.i(this.f11611b)).w(yVar, oVar);
        }

        public final /* synthetic */ void w(Object obj, long j11) {
            ((f0) u0.i(this.f11611b)).g(obj, j11);
        }

        public final /* synthetic */ void x(long j11, int i11) {
            ((f0) u0.i(this.f11611b)).j(j11, i11);
        }

        public final /* synthetic */ void y(Exception exc) {
            ((f0) u0.i(this.f11611b)).e(exc);
        }

        public final /* synthetic */ void z(t0 t0Var) {
            ((f0) u0.i(this.f11611b)).onVideoSizeChanged(t0Var);
        }
    }

    @Deprecated
    void B(androidx.media3.common.y yVar);

    void b(String str);

    void e(Exception exc);

    void g(Object obj, long j11);

    void j(long j11, int i11);

    void o(androidx.media3.exoplayer.n nVar);

    void onDroppedFrames(int i11, long j11);

    void onVideoDecoderInitialized(String str, long j11, long j12);

    void onVideoSizeChanged(t0 t0Var);

    void w(androidx.media3.common.y yVar, @Nullable androidx.media3.exoplayer.o oVar);

    void x(androidx.media3.exoplayer.n nVar);
}
