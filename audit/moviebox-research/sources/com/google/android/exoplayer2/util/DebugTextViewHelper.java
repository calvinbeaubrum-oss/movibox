package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.z1;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DebugTextViewHelper {

    /* JADX INFO: compiled from: source.java */
    public final class Updater implements n2.d, Runnable {
        final /* synthetic */ DebugTextViewHelper this$0;

        private Updater(DebugTextViewHelper debugTextViewHelper) {
        }

        public /* bridge */ /* synthetic */ void onAudioAttributesChanged(com.google.android.exoplayer2.audio.e eVar) {
            p2.a(this, eVar);
        }

        public /* bridge */ /* synthetic */ void onAudioSessionIdChanged(int i11) {
            p2.b(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onAvailableCommandsChanged(n2.b bVar) {
            p2.c(this, bVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onCues(List list) {
            p2.d(this, list);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onCues(vh.f fVar) {
            p2.e(this, fVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onDeviceInfoChanged(com.google.android.exoplayer2.n nVar) {
            p2.f(this, nVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
            p2.g(this, i11, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onEvents(n2 n2Var, n2.c cVar) {
            p2.h(this, n2Var, cVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onIsLoadingChanged(boolean z11) {
            p2.i(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onIsPlayingChanged(boolean z11) {
            p2.j(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onLoadingChanged(boolean z11) {
            p2.k(this, z11);
        }

        public /* bridge */ /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j11) {
            p2.l(this, j11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onMediaItemTransition(@Nullable u1 u1Var, int i11) {
            p2.m(this, u1Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onMediaMetadataChanged(z1 z1Var) {
            p2.n(this, z1Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onMetadata(Metadata metadata) {
            p2.o(this, metadata);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            throw null;
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onPlaybackParametersChanged(m2 m2Var) {
            p2.q(this, m2Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlaybackStateChanged(int i11) {
            throw null;
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            p2.s(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            p2.t(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
            p2.u(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.n2.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onPlayerStateChanged(boolean z11, int i11) {
            p2.v(this, z11, i11);
        }

        public /* bridge */ /* synthetic */ void onPlaylistMetadataChanged(z1 z1Var) {
            p2.w(this, z1Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onPositionDiscontinuity(int i11) {
            p2.x(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPositionDiscontinuity(n2.e eVar, n2.e eVar2, int i11) {
            throw null;
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onRenderedFirstFrame() {
            p2.z(this);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onRepeatModeChanged(int i11) {
            p2.A(this, i11);
        }

        public /* bridge */ /* synthetic */ void onSeekBackIncrementChanged(long j11) {
            p2.B(this, j11);
        }

        public /* bridge */ /* synthetic */ void onSeekForwardIncrementChanged(long j11) {
            p2.C(this, j11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        @Deprecated
        public /* bridge */ /* synthetic */ void onSeekProcessed() {
            p2.D(this);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onShuffleModeEnabledChanged(boolean z11) {
            p2.E(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
            p2.F(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            p2.G(this, i11, i12);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onTimelineChanged(j3 j3Var, int i11) {
            p2.H(this, j3Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onTrackSelectionParametersChanged(fi.z zVar) {
            p2.I(this, zVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onTracksChanged(o3 o3Var) {
            p2.J(this, o3Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar) {
            p2.K(this, yVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* bridge */ /* synthetic */ void onVolumeChanged(float f11) {
            p2.L(this, f11);
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
