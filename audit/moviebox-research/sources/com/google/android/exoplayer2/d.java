package com.google.android.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d implements n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.d f33010a = new j3.d();

    @Override // com.google.android.exoplayer2.n2
    public final boolean A() {
        j3 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(u(), this.f33010a).i();
    }

    @Override // com.google.android.exoplayer2.n2
    public final void D(u1 u1Var) {
        O(Collections.singletonList(u1Var));
    }

    public final long F() {
        j3 currentTimeline = getCurrentTimeline();
        return currentTimeline.u() ? C.TIME_UNSET : currentTimeline.r(u(), this.f33010a).g();
    }

    public final int G() {
        j3 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return -1;
        }
        return currentTimeline.i(u(), I(), getShuffleModeEnabled());
    }

    public final int H() {
        j3 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return -1;
        }
        return currentTimeline.p(u(), I(), getShuffleModeEnabled());
    }

    public final int I() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public final void J() {
        K(u());
    }

    public final void K(int i11) {
        seekTo(i11, C.TIME_UNSET);
    }

    public final void L() {
        int iG = G();
        if (iG != -1) {
            K(iG);
        }
    }

    public final void M(long j11) {
        long currentPosition = getCurrentPosition() + j11;
        long duration = getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0L));
    }

    public final void N() {
        int iH = H();
        if (iH != -1) {
            K(iH);
        }
    }

    public final void O(List<u1> list) {
        e(list, true);
    }

    @Override // com.google.android.exoplayer2.n2
    public final void f() {
        if (getCurrentTimeline().u() || isPlayingAd()) {
            return;
        }
        boolean zR = r();
        if (A() && !t()) {
            if (zR) {
                N();
            }
        } else if (!zR || getCurrentPosition() > p()) {
            seekTo(0L);
        } else {
            N();
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public final boolean g() {
        return G() != -1;
    }

    @Override // com.google.android.exoplayer2.n2
    public final boolean i(int i11) {
        return o().c(i11);
    }

    @Override // com.google.android.exoplayer2.n2
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && k() == 0;
    }

    @Override // com.google.android.exoplayer2.n2
    public final boolean j() {
        j3 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(u(), this.f33010a).f33385j;
    }

    @Override // com.google.android.exoplayer2.n2
    public final void n() {
        if (getCurrentTimeline().u() || isPlayingAd()) {
            return;
        }
        if (g()) {
            L();
        } else if (A() && j()) {
            J();
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // com.google.android.exoplayer2.n2
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // com.google.android.exoplayer2.n2
    public final boolean r() {
        return H() != -1;
    }

    @Override // com.google.android.exoplayer2.n2
    public final void seekTo(long j11) {
        seekTo(u(), j11);
    }

    @Override // com.google.android.exoplayer2.n2
    public final boolean t() {
        j3 currentTimeline = getCurrentTimeline();
        return !currentTimeline.u() && currentTimeline.r(u(), this.f33010a).f33384i;
    }

    @Override // com.google.android.exoplayer2.n2
    public final void w() {
        M(s());
    }

    @Override // com.google.android.exoplayer2.n2
    public final void x() {
        M(-z());
    }
}
