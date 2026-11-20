package androidx.media3.common;

import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0.c f9225a = new m0.c();

    @Override // androidx.media3.common.h0
    public final boolean A() {
        m0 currentTimeline = getCurrentTimeline();
        return !currentTimeline.q() && currentTimeline.n(u(), this.f9225a).f();
    }

    @Override // androidx.media3.common.h0
    public final void C() {
        G(0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // androidx.media3.common.h0
    public final void E(int i11) {
        G(i11, i11 + 1);
    }

    @Override // androidx.media3.common.h0
    public final int F() {
        return getCurrentTimeline().p();
    }

    @Override // androidx.media3.common.h0
    public final void H(b0 b0Var) {
        g0(ImmutableList.of(b0Var));
    }

    @Override // androidx.media3.common.h0
    public final void I(b0 b0Var) {
        V(ImmutableList.of(b0Var));
    }

    @Override // androidx.media3.common.h0
    public final void M(int i11, b0 b0Var) {
        R(i11, ImmutableList.of(b0Var));
    }

    @Override // androidx.media3.common.h0
    public final b0 N(int i11) {
        return getCurrentTimeline().n(i11, this.f9225a).f9311c;
    }

    public final void O(int i11, b0 b0Var) {
        D(i11, i11 + 1, ImmutableList.of(b0Var));
    }

    @Override // androidx.media3.common.h0
    public final long P() {
        m0 currentTimeline = getCurrentTimeline();
        return currentTimeline.q() ? C.TIME_UNSET : currentTimeline.n(u(), this.f9225a).d();
    }

    public final void V(List<b0> list) {
        R(Api.BaseClientBuilder.API_PRIORITY_OTHER, list);
    }

    public final int W() {
        m0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.q()) {
            return -1;
        }
        return currentTimeline.e(u(), Y(), getShuffleModeEnabled());
    }

    public final int X() {
        m0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.q()) {
            return -1;
        }
        return currentTimeline.l(u(), Y(), getShuffleModeEnabled());
    }

    public final int Y() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public final void Z(int i11) {
        a0(u(), C.TIME_UNSET, i11, true);
    }

    public abstract void a0(int i11, long j11, int i12, boolean z11);

    public final void b0(long j11, int i11) {
        a0(u(), j11, i11, false);
    }

    public final void c0(int i11, int i12) {
        a0(i11, C.TIME_UNSET, i12, false);
    }

    public final void d0(int i11) {
        int iW = W();
        if (iW == -1) {
            return;
        }
        if (iW == u()) {
            Z(i11);
        } else {
            c0(iW, i11);
        }
    }

    public final void e0(long j11, int i11) {
        long currentPosition = getCurrentPosition() + j11;
        long duration = getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        b0(Math.max(currentPosition, 0L), i11);
    }

    @Override // androidx.media3.common.h0
    public final void f() {
        if (getCurrentTimeline().q() || isPlayingAd()) {
            return;
        }
        boolean zR = r();
        if (A() && !t()) {
            if (zR) {
                f0(7);
            }
        } else if (!zR || getCurrentPosition() > p()) {
            b0(0L, 7);
        } else {
            f0(7);
        }
    }

    public final void f0(int i11) {
        int iX = X();
        if (iX == -1) {
            return;
        }
        if (iX == u()) {
            Z(i11);
        } else {
            c0(iX, i11);
        }
    }

    @Override // androidx.media3.common.h0
    public final boolean g() {
        return W() != -1;
    }

    public final void g0(List<b0> list) {
        e(list, true);
    }

    @Override // androidx.media3.common.h0
    public final boolean i(int i11) {
        return o().b(i11);
    }

    @Override // androidx.media3.common.h0
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && k() == 0;
    }

    @Override // androidx.media3.common.h0
    public final boolean j() {
        m0 currentTimeline = getCurrentTimeline();
        return !currentTimeline.q() && currentTimeline.n(u(), this.f9225a).f9317i;
    }

    @Override // androidx.media3.common.h0
    public final void n() {
        if (getCurrentTimeline().q() || isPlayingAd()) {
            return;
        }
        if (g()) {
            d0(9);
        } else if (A() && j()) {
            c0(u(), 9);
        }
    }

    @Override // androidx.media3.common.h0
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // androidx.media3.common.h0
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // androidx.media3.common.h0
    public final boolean r() {
        return X() != -1;
    }

    @Override // androidx.media3.common.h0
    public final void seekTo(int i11, long j11) {
        a0(i11, j11, 10, false);
    }

    @Override // androidx.media3.common.h0
    public final void seekTo(long j11) {
        b0(j11, 5);
    }

    @Override // androidx.media3.common.h0
    public final void seekToDefaultPosition() {
        c0(u(), 4);
    }

    @Override // androidx.media3.common.h0
    public final void setPlaybackSpeed(float f11) {
        b(getPlaybackParameters().b(f11));
    }

    @Override // androidx.media3.common.h0
    public final boolean t() {
        m0 currentTimeline = getCurrentTimeline();
        return !currentTimeline.q() && currentTimeline.n(u(), this.f9225a).f9316h;
    }

    @Override // androidx.media3.common.h0
    public final void w() {
        e0(s(), 12);
    }

    @Override // androidx.media3.common.h0
    public final void x() {
        e0(-z(), 11);
    }
}
