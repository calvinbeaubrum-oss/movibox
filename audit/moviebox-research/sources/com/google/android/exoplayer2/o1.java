package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class o1 implements n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n2 f33622a;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements n2.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o1 f33623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n2.d f33624b;

        public a(o1 o1Var, n2.d dVar) {
            this.f33623a = o1Var;
            this.f33624b = dVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f33623a.equals(aVar.f33623a)) {
                return this.f33624b.equals(aVar.f33624b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f33623a.hashCode() * 31) + this.f33624b.hashCode();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onAvailableCommandsChanged(n2.b bVar) {
            this.f33624b.onAvailableCommandsChanged(bVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onCues(List<vh.b> list) {
            this.f33624b.onCues(list);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onCues(vh.f fVar) {
            this.f33624b.onCues(fVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onDeviceInfoChanged(n nVar) {
            this.f33624b.onDeviceInfoChanged(nVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onDeviceVolumeChanged(int i11, boolean z11) {
            this.f33624b.onDeviceVolumeChanged(i11, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onEvents(n2 n2Var, n2.c cVar) {
            this.f33624b.onEvents(this.f33623a, cVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onIsLoadingChanged(boolean z11) {
            this.f33624b.onIsLoadingChanged(z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onIsPlayingChanged(boolean z11) {
            this.f33624b.onIsPlayingChanged(z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onLoadingChanged(boolean z11) {
            this.f33624b.onIsLoadingChanged(z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onMediaItemTransition(@Nullable u1 u1Var, int i11) {
            this.f33624b.onMediaItemTransition(u1Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onMediaMetadataChanged(z1 z1Var) {
            this.f33624b.onMediaMetadataChanged(z1Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onMetadata(Metadata metadata) {
            this.f33624b.onMetadata(metadata);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            this.f33624b.onPlayWhenReadyChanged(z11, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlaybackParametersChanged(m2 m2Var) {
            this.f33624b.onPlaybackParametersChanged(m2Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlaybackStateChanged(int i11) {
            this.f33624b.onPlaybackStateChanged(i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlaybackSuppressionReasonChanged(int i11) {
            this.f33624b.onPlaybackSuppressionReasonChanged(i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlayerError(PlaybackException playbackException) {
            this.f33624b.onPlayerError(playbackException);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
            this.f33624b.onPlayerErrorChanged(playbackException);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlayerStateChanged(boolean z11, int i11) {
            this.f33624b.onPlayerStateChanged(z11, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPositionDiscontinuity(int i11) {
            this.f33624b.onPositionDiscontinuity(i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPositionDiscontinuity(n2.e eVar, n2.e eVar2, int i11) {
            this.f33624b.onPositionDiscontinuity(eVar, eVar2, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onRenderedFirstFrame() {
            this.f33624b.onRenderedFirstFrame();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onRepeatModeChanged(int i11) {
            this.f33624b.onRepeatModeChanged(i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onSeekProcessed() {
            this.f33624b.onSeekProcessed();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onShuffleModeEnabledChanged(boolean z11) {
            this.f33624b.onShuffleModeEnabledChanged(z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onSkipSilenceEnabledChanged(boolean z11) {
            this.f33624b.onSkipSilenceEnabledChanged(z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onSurfaceSizeChanged(int i11, int i12) {
            this.f33624b.onSurfaceSizeChanged(i11, i12);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onTimelineChanged(j3 j3Var, int i11) {
            this.f33624b.onTimelineChanged(j3Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onTrackSelectionParametersChanged(fi.z zVar) {
            this.f33624b.onTrackSelectionParametersChanged(zVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onTracksChanged(o3 o3Var) {
            this.f33624b.onTracksChanged(o3Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar) {
            this.f33624b.onVideoSizeChanged(yVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onVolumeChanged(float f11) {
            this.f33624b.onVolumeChanged(f11);
        }
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean A() {
        return this.f33622a.A();
    }

    @Override // com.google.android.exoplayer2.n2
    public void B(fi.z zVar) {
        this.f33622a.B(zVar);
    }

    @Override // com.google.android.exoplayer2.n2
    public void C(n2.d dVar) {
        this.f33622a.C(new a(this, dVar));
    }

    @Override // com.google.android.exoplayer2.n2
    public void E(n2.d dVar) {
        this.f33622a.E(new a(this, dVar));
    }

    public n2 F() {
        return this.f33622a;
    }

    @Override // com.google.android.exoplayer2.n2
    public void b(m2 m2Var) {
        this.f33622a.b(m2Var);
    }

    @Override // com.google.android.exoplayer2.n2
    @Nullable
    public PlaybackException c() {
        return this.f33622a.c();
    }

    @Override // com.google.android.exoplayer2.n2
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.f33622a.clearVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.n2
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        this.f33622a.clearVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.n2
    public long d() {
        return this.f33622a.d();
    }

    @Override // com.google.android.exoplayer2.n2
    public void f() {
        this.f33622a.f();
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean g() {
        return this.f33622a.g();
    }

    @Override // com.google.android.exoplayer2.n2
    public long getContentPosition() {
        return this.f33622a.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.n2
    public int getCurrentAdGroupIndex() {
        return this.f33622a.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.n2
    public int getCurrentAdIndexInAdGroup() {
        return this.f33622a.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.n2
    public int getCurrentPeriodIndex() {
        return this.f33622a.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.n2
    public long getCurrentPosition() {
        return this.f33622a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.n2
    public j3 getCurrentTimeline() {
        return this.f33622a.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.n2
    public o3 getCurrentTracks() {
        return this.f33622a.getCurrentTracks();
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean getPlayWhenReady() {
        return this.f33622a.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.n2
    public m2 getPlaybackParameters() {
        return this.f33622a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.n2
    public int getPlaybackState() {
        return this.f33622a.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.n2
    public int getRepeatMode() {
        return this.f33622a.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean getShuffleModeEnabled() {
        return this.f33622a.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.n2
    public vh.f h() {
        return this.f33622a.h();
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean i(int i11) {
        return this.f33622a.i(i11);
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean isPlaying() {
        return this.f33622a.isPlaying();
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean isPlayingAd() {
        return this.f33622a.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean j() {
        return this.f33622a.j();
    }

    @Override // com.google.android.exoplayer2.n2
    public int k() {
        return this.f33622a.k();
    }

    @Override // com.google.android.exoplayer2.n2
    public Looper l() {
        return this.f33622a.l();
    }

    @Override // com.google.android.exoplayer2.n2
    public fi.z m() {
        return this.f33622a.m();
    }

    @Override // com.google.android.exoplayer2.n2
    public void n() {
        this.f33622a.n();
    }

    @Override // com.google.android.exoplayer2.n2
    public void pause() {
        this.f33622a.pause();
    }

    @Override // com.google.android.exoplayer2.n2
    public void play() {
        this.f33622a.play();
    }

    @Override // com.google.android.exoplayer2.n2
    public void prepare() {
        this.f33622a.prepare();
    }

    @Override // com.google.android.exoplayer2.n2
    public com.google.android.exoplayer2.video.y q() {
        return this.f33622a.q();
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean r() {
        return this.f33622a.r();
    }

    @Override // com.google.android.exoplayer2.n2
    public long s() {
        return this.f33622a.s();
    }

    @Override // com.google.android.exoplayer2.n2
    public void seekTo(int i11, long j11) {
        this.f33622a.seekTo(i11, j11);
    }

    @Override // com.google.android.exoplayer2.n2
    public void setRepeatMode(int i11) {
        this.f33622a.setRepeatMode(i11);
    }

    @Override // com.google.android.exoplayer2.n2
    public void setShuffleModeEnabled(boolean z11) {
        this.f33622a.setShuffleModeEnabled(z11);
    }

    @Override // com.google.android.exoplayer2.n2
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.f33622a.setVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.n2
    public void setVideoTextureView(@Nullable TextureView textureView) {
        this.f33622a.setVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.n2
    public boolean t() {
        return this.f33622a.t();
    }

    @Override // com.google.android.exoplayer2.n2
    public int u() {
        return this.f33622a.u();
    }

    @Override // com.google.android.exoplayer2.n2
    public long v() {
        return this.f33622a.v();
    }

    @Override // com.google.android.exoplayer2.n2
    public void w() {
        this.f33622a.w();
    }

    @Override // com.google.android.exoplayer2.n2
    public void x() {
        this.f33622a.x();
    }

    @Override // com.google.android.exoplayer2.n2
    public z1 y() {
        return this.f33622a.y();
    }

    @Override // com.google.android.exoplayer2.n2
    public long z() {
        return this.f33622a.z();
    }
}
