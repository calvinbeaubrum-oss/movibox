package androidx.media3.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c3 f10970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public w2 f10972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public y1 f10973d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10974f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10975g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onPlaybackParametersChanged(androidx.media3.common.g0 g0Var);
    }

    public r(a aVar, z3.d dVar) {
        this.f10971b = aVar;
        this.f10970a = new c3(dVar);
    }

    public void a(w2 w2Var) {
        if (w2Var == this.f10972c) {
            this.f10973d = null;
            this.f10972c = null;
            this.f10974f = true;
        }
    }

    @Override // androidx.media3.exoplayer.y1
    public void b(androidx.media3.common.g0 g0Var) {
        y1 y1Var = this.f10973d;
        if (y1Var != null) {
            y1Var.b(g0Var);
            g0Var = this.f10973d.getPlaybackParameters();
        }
        this.f10970a.b(g0Var);
    }

    public void c(w2 w2Var) throws ExoPlaybackException {
        y1 y1Var;
        y1 mediaClock = w2Var.getMediaClock();
        if (mediaClock == null || mediaClock == (y1Var = this.f10973d)) {
            return;
        }
        if (y1Var != null) {
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.f10973d = mediaClock;
        this.f10972c = w2Var;
        mediaClock.b(this.f10970a.getPlaybackParameters());
    }

    public void d(long j11) {
        this.f10970a.a(j11);
    }

    public final boolean e(boolean z11) {
        w2 w2Var = this.f10972c;
        return w2Var == null || w2Var.isEnded() || (z11 && this.f10972c.getState() != 2) || (!this.f10972c.isReady() && (z11 || this.f10972c.hasReadStreamToEnd()));
    }

    public void f() {
        this.f10975g = true;
        this.f10970a.c();
    }

    public void g() {
        this.f10975g = false;
        this.f10970a.d();
    }

    @Override // androidx.media3.exoplayer.y1
    public androidx.media3.common.g0 getPlaybackParameters() {
        y1 y1Var = this.f10973d;
        return y1Var != null ? y1Var.getPlaybackParameters() : this.f10970a.getPlaybackParameters();
    }

    @Override // androidx.media3.exoplayer.y1
    public long getPositionUs() {
        return this.f10974f ? this.f10970a.getPositionUs() : ((y1) z3.a.e(this.f10973d)).getPositionUs();
    }

    @Override // androidx.media3.exoplayer.y1
    public boolean h() {
        return this.f10974f ? this.f10970a.h() : ((y1) z3.a.e(this.f10973d)).h();
    }

    public long i(boolean z11) {
        j(z11);
        return getPositionUs();
    }

    public final void j(boolean z11) {
        if (e(z11)) {
            this.f10974f = true;
            if (this.f10975g) {
                this.f10970a.c();
                return;
            }
            return;
        }
        y1 y1Var = (y1) z3.a.e(this.f10973d);
        long positionUs = y1Var.getPositionUs();
        if (this.f10974f) {
            if (positionUs < this.f10970a.getPositionUs()) {
                this.f10970a.d();
                return;
            } else {
                this.f10974f = false;
                if (this.f10975g) {
                    this.f10970a.c();
                }
            }
        }
        this.f10970a.a(positionUs);
        androidx.media3.common.g0 playbackParameters = y1Var.getPlaybackParameters();
        if (playbackParameters.equals(this.f10970a.getPlaybackParameters())) {
            return;
        }
        this.f10970a.b(playbackParameters);
        this.f10971b.onPlaybackParametersChanged(playbackParameters);
    }
}
