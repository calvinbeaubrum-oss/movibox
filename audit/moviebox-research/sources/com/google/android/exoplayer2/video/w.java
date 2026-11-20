package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface w {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f35859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final w f35860b;

        public a(@Nullable Handler handler, @Nullable w wVar) {
            this.f35859a = wVar != null ? (Handler) com.google.android.exoplayer2.util.a.e(handler) : null;
            this.f35860b = wVar;
        }

        public void A(final Object obj) {
            if (this.f35859a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f35859a.post(new Runnable() { // from class: com.google.android.exoplayer2.video.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35849a.w(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j11, final int i11) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35804a.x(j11, i11);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35810a.y(exc);
                    }
                });
            }
        }

        public void D(final y yVar) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35802a.z(yVar);
                    }
                });
            }
        }

        public void k(final String str, final long j11, final long j12) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35855a.q(str, j11, j12);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35800a.r(str);
                    }
                });
            }
        }

        public void m(final com.google.android.exoplayer2.decoder.e eVar) {
            eVar.c();
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35796a.s(eVar);
                    }
                });
            }
        }

        public void n(final int i11, final long j11) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35852a.t(i11, j11);
                    }
                });
            }
        }

        public void o(final com.google.android.exoplayer2.decoder.e eVar) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35798a.u(eVar);
                    }
                });
            }
        }

        public void p(final m1 m1Var, @Nullable final com.google.android.exoplayer2.decoder.g gVar) {
            Handler handler = this.f35859a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f35807a.v(m1Var, gVar);
                    }
                });
            }
        }

        public final /* synthetic */ void q(String str, long j11, long j12) {
            ((w) o0.j(this.f35860b)).onVideoDecoderInitialized(str, j11, j12);
        }

        public final /* synthetic */ void r(String str) {
            ((w) o0.j(this.f35860b)).b(str);
        }

        public final /* synthetic */ void s(com.google.android.exoplayer2.decoder.e eVar) {
            eVar.c();
            ((w) o0.j(this.f35860b)).n(eVar);
        }

        public final /* synthetic */ void t(int i11, long j11) {
            ((w) o0.j(this.f35860b)).onDroppedFrames(i11, j11);
        }

        public final /* synthetic */ void u(com.google.android.exoplayer2.decoder.e eVar) {
            ((w) o0.j(this.f35860b)).t(eVar);
        }

        public final /* synthetic */ void v(m1 m1Var, com.google.android.exoplayer2.decoder.g gVar) {
            ((w) o0.j(this.f35860b)).w(m1Var);
            ((w) o0.j(this.f35860b)).l(m1Var, gVar);
        }

        public final /* synthetic */ void w(Object obj, long j11) {
            ((w) o0.j(this.f35860b)).g(obj, j11);
        }

        public final /* synthetic */ void x(long j11, int i11) {
            ((w) o0.j(this.f35860b)).j(j11, i11);
        }

        public final /* synthetic */ void y(Exception exc) {
            ((w) o0.j(this.f35860b)).e(exc);
        }

        public final /* synthetic */ void z(y yVar) {
            ((w) o0.j(this.f35860b)).onVideoSizeChanged(yVar);
        }
    }

    void b(String str);

    void e(Exception exc);

    void g(Object obj, long j11);

    void j(long j11, int i11);

    void l(m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar);

    void n(com.google.android.exoplayer2.decoder.e eVar);

    void onDroppedFrames(int i11, long j11);

    void onVideoDecoderInitialized(String str, long j11, long j12);

    void onVideoSizeChanged(y yVar);

    void t(com.google.android.exoplayer2.decoder.e eVar);

    @Deprecated
    void w(m1 m1Var);
}
