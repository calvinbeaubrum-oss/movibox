package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements com.google.android.exoplayer2.util.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.g0 f33394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f33395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public w2 f33396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.util.u f33397d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f33398f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f33399g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onPlaybackParametersChanged(m2 m2Var);
    }

    public k(a aVar, com.google.android.exoplayer2.util.e eVar) {
        this.f33395b = aVar;
        this.f33394a = new com.google.android.exoplayer2.util.g0(eVar);
    }

    public void a(w2 w2Var) {
        if (w2Var == this.f33396c) {
            this.f33397d = null;
            this.f33396c = null;
            this.f33398f = true;
        }
    }

    @Override // com.google.android.exoplayer2.util.u
    public void b(m2 m2Var) {
        com.google.android.exoplayer2.util.u uVar = this.f33397d;
        if (uVar != null) {
            uVar.b(m2Var);
            m2Var = this.f33397d.getPlaybackParameters();
        }
        this.f33394a.b(m2Var);
    }

    public void c(w2 w2Var) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.u uVar;
        com.google.android.exoplayer2.util.u mediaClock = w2Var.getMediaClock();
        if (mediaClock == null || mediaClock == (uVar = this.f33397d)) {
            return;
        }
        if (uVar != null) {
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f33397d = mediaClock;
        this.f33396c = w2Var;
        mediaClock.b(this.f33394a.getPlaybackParameters());
    }

    public void d(long j11) {
        this.f33394a.a(j11);
    }

    public final boolean e(boolean z11) {
        w2 w2Var = this.f33396c;
        return w2Var == null || w2Var.isEnded() || (!this.f33396c.isReady() && (z11 || this.f33396c.hasReadStreamToEnd()));
    }

    public void f() {
        this.f33399g = true;
        this.f33394a.c();
    }

    public void g() {
        this.f33399g = false;
        this.f33394a.d();
    }

    @Override // com.google.android.exoplayer2.util.u
    public m2 getPlaybackParameters() {
        com.google.android.exoplayer2.util.u uVar = this.f33397d;
        return uVar != null ? uVar.getPlaybackParameters() : this.f33394a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.u
    public long getPositionUs() {
        return this.f33398f ? this.f33394a.getPositionUs() : ((com.google.android.exoplayer2.util.u) com.google.android.exoplayer2.util.a.e(this.f33397d)).getPositionUs();
    }

    public long h(boolean z11) {
        i(z11);
        return getPositionUs();
    }

    public final void i(boolean z11) {
        if (e(z11)) {
            this.f33398f = true;
            if (this.f33399g) {
                this.f33394a.c();
                return;
            }
            return;
        }
        com.google.android.exoplayer2.util.u uVar = (com.google.android.exoplayer2.util.u) com.google.android.exoplayer2.util.a.e(this.f33397d);
        long positionUs = uVar.getPositionUs();
        if (this.f33398f) {
            if (positionUs < this.f33394a.getPositionUs()) {
                this.f33394a.d();
                return;
            } else {
                this.f33398f = false;
                if (this.f33399g) {
                    this.f33394a.c();
                }
            }
        }
        this.f33394a.a(positionUs);
        m2 playbackParameters = uVar.getPlaybackParameters();
        if (playbackParameters.equals(this.f33394a.getPlaybackParameters())) {
            return;
        }
        this.f33394a.b(playbackParameters);
        this.f33395b.onPlaybackParametersChanged(playbackParameters);
    }
}
