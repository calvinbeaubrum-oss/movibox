package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface r {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f32907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final r f32908b;

        public a(@Nullable Handler handler, @Nullable r rVar) {
            this.f32907a = rVar != null ? (Handler) com.google.android.exoplayer2.util.a.e(handler) : null;
            this.f32908b = rVar;
        }

        public final /* synthetic */ void A(int i11, long j11, long j12) {
            ((r) o0.j(this.f32908b)).i(i11, j11, j12);
        }

        public void B(final long j11) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32887a.y(j11);
                    }
                });
            }
        }

        public void C(final boolean z11) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32901a.z(z11);
                    }
                });
            }
        }

        public void D(final int i11, final long j11, final long j12) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32903a.A(i11, j11, j12);
                    }
                });
            }
        }

        public void k(final Exception exc) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32895a.r(exc);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32893a.s(exc);
                    }
                });
            }
        }

        public void m(final String str, final long j11, final long j12) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32897a.t(str, j11, j12);
                    }
                });
            }
        }

        public void n(final String str) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32875a.u(str);
                    }
                });
            }
        }

        public void o(final com.google.android.exoplayer2.decoder.e eVar) {
            eVar.c();
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32889a.v(eVar);
                    }
                });
            }
        }

        public void p(final com.google.android.exoplayer2.decoder.e eVar) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32891a.w(eVar);
                    }
                });
            }
        }

        public void q(final m1 m1Var, @Nullable final com.google.android.exoplayer2.decoder.g gVar) {
            Handler handler = this.f32907a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32884a.x(m1Var, gVar);
                    }
                });
            }
        }

        public final /* synthetic */ void r(Exception exc) {
            ((r) o0.j(this.f32908b)).h(exc);
        }

        public final /* synthetic */ void s(Exception exc) {
            ((r) o0.j(this.f32908b)).a(exc);
        }

        public final /* synthetic */ void t(String str, long j11, long j12) {
            ((r) o0.j(this.f32908b)).onAudioDecoderInitialized(str, j11, j12);
        }

        public final /* synthetic */ void u(String str) {
            ((r) o0.j(this.f32908b)).c(str);
        }

        public final /* synthetic */ void v(com.google.android.exoplayer2.decoder.e eVar) {
            eVar.c();
            ((r) o0.j(this.f32908b)).o(eVar);
        }

        public final /* synthetic */ void w(com.google.android.exoplayer2.decoder.e eVar) {
            ((r) o0.j(this.f32908b)).k(eVar);
        }

        public final /* synthetic */ void x(m1 m1Var, com.google.android.exoplayer2.decoder.g gVar) {
            ((r) o0.j(this.f32908b)).y(m1Var);
            ((r) o0.j(this.f32908b)).s(m1Var, gVar);
        }

        public final /* synthetic */ void y(long j11) {
            ((r) o0.j(this.f32908b)).d(j11);
        }

        public final /* synthetic */ void z(boolean z11) {
            ((r) o0.j(this.f32908b)).onSkipSilenceEnabledChanged(z11);
        }
    }

    void a(Exception exc);

    void c(String str);

    void d(long j11);

    void h(Exception exc);

    void i(int i11, long j11, long j12);

    void k(com.google.android.exoplayer2.decoder.e eVar);

    void o(com.google.android.exoplayer2.decoder.e eVar);

    void onAudioDecoderInitialized(String str, long j11, long j12);

    void onSkipSilenceEnabledChanged(boolean z11);

    void s(m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar);

    @Deprecated
    void y(m1 m1Var);
}
