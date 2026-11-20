package androidx.media3.exoplayer.util;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.b0;
import androidx.media3.common.d;
import androidx.media3.common.d0;
import androidx.media3.common.g0;
import androidx.media3.common.h0;
import androidx.media3.common.i0;
import androidx.media3.common.m0;
import androidx.media3.common.o;
import androidx.media3.common.p0;
import androidx.media3.common.q0;
import androidx.media3.common.t0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class DebugTextViewHelper {

    /* JADX INFO: compiled from: source.java */
    public final class Updater implements h0.d, Runnable {
        final /* synthetic */ DebugTextViewHelper this$0;

        private Updater(DebugTextViewHelper debugTextViewHelper) {
        }

        public /* bridge */ /* synthetic */ void onAudioAttributesChanged(d dVar) {
            i0.a(this, dVar);
        }

        public /* bridge */ /* synthetic */ void onAudioSessionIdChanged(int i11) {
            i0.b(this, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onAvailableCommandsChanged(h0.b bVar) {
            i0.c(this, bVar);
        }

        @Override // androidx.media3.common.h0.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onCues(List list) {
            i0.d(this, list);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onCues(y3.b bVar) {
            i0.e(this, bVar);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onDeviceInfoChanged(o oVar) {
            i0.f(this, oVar);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
            i0.g(this, i11, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onEvents(h0 h0Var, h0.c cVar) {
            i0.h(this, h0Var, cVar);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onIsLoadingChanged(boolean z11) {
            i0.i(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onIsPlayingChanged(boolean z11) {
            i0.j(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onLoadingChanged(boolean z11) {
            i0.k(this, z11);
        }

        public /* bridge */ /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j11) {
            i0.l(this, j11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onMediaItemTransition(@Nullable b0 b0Var, int i11) {
            i0.m(this, b0Var, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onMediaMetadataChanged(d0 d0Var) {
            i0.n(this, d0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onMetadata(Metadata metadata) {
            i0.o(this, metadata);
        }

        @Override // androidx.media3.common.h0.d
        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            throw null;
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onPlaybackParametersChanged(g0 g0Var) {
            i0.q(this, g0Var);
        }

        @Override // androidx.media3.common.h0.d
        public void onPlaybackStateChanged(int i11) {
            throw null;
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            i0.s(this, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            i0.t(this, playbackException);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
            i0.u(this, playbackException);
        }

        @Override // androidx.media3.common.h0.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onPlayerStateChanged(boolean z11, int i11) {
            i0.v(this, z11, i11);
        }

        public /* bridge */ /* synthetic */ void onPlaylistMetadataChanged(d0 d0Var) {
            i0.w(this, d0Var);
        }

        @Override // androidx.media3.common.h0.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onPositionDiscontinuity(int i11) {
            i0.x(this, i11);
        }

        @Override // androidx.media3.common.h0.d
        public void onPositionDiscontinuity(h0.e eVar, h0.e eVar2, int i11) {
            throw null;
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame() {
            i0.z(this);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onRepeatModeChanged(int i11) {
            i0.A(this, i11);
        }

        public /* bridge */ /* synthetic */ void onSeekBackIncrementChanged(long j11) {
            i0.B(this, j11);
        }

        public /* bridge */ /* synthetic */ void onSeekForwardIncrementChanged(long j11) {
            i0.C(this, j11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onShuffleModeEnabledChanged(boolean z11) {
            i0.D(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
            i0.E(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            i0.F(this, i11, i12);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onTimelineChanged(m0 m0Var, int i11) {
            i0.G(this, m0Var, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onTrackSelectionParametersChanged(p0 p0Var) {
            i0.H(this, p0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onTracksChanged(q0 q0Var) {
            i0.I(this, q0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onVideoSizeChanged(t0 t0Var) {
            i0.J(this, t0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* bridge */ /* synthetic */ void onVolumeChanged(float f11) {
            i0.K(this, f11);
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
