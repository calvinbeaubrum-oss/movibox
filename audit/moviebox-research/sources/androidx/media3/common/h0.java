package androidx.media3.common;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h0 {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f9226b = new a().e();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f9227c = u0.E0(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public static final i<b> f9228d = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f9229a;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int[] f9230b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final s.b f9231a = new s.b();

            public a a(int i11) {
                this.f9231a.a(i11);
                return this;
            }

            public a b(b bVar) {
                this.f9231a.b(bVar.f9229a);
                return this;
            }

            public a c(int... iArr) {
                this.f9231a.c(iArr);
                return this;
            }

            public a d(int i11, boolean z11) {
                this.f9231a.d(i11, z11);
                return this;
            }

            public b e() {
                return new b(this.f9231a.e());
            }
        }

        public b(s sVar) {
            this.f9229a = sVar;
        }

        public boolean b(int i11) {
            return this.f9229a.a(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f9229a.equals(((b) obj).f9229a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9229a.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f9232a;

        public c(s sVar) {
            this.f9232a = sVar;
        }

        public boolean a(int i11) {
            return this.f9232a.a(i11);
        }

        public boolean b(int... iArr) {
            return this.f9232a.b(iArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f9232a.equals(((c) obj).f9232a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9232a.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void onAvailableCommandsChanged(b bVar);

        @Deprecated
        void onCues(List<y3.a> list);

        void onCues(y3.b bVar);

        void onDeviceInfoChanged(o oVar);

        void onDeviceVolumeChanged(int i11, boolean z11);

        void onEvents(h0 h0Var, c cVar);

        void onIsLoadingChanged(boolean z11);

        void onIsPlayingChanged(boolean z11);

        @Deprecated
        void onLoadingChanged(boolean z11);

        void onMediaItemTransition(@Nullable b0 b0Var, int i11);

        void onMediaMetadataChanged(d0 d0Var);

        void onMetadata(Metadata metadata);

        void onPlayWhenReadyChanged(boolean z11, int i11);

        void onPlaybackParametersChanged(g0 g0Var);

        void onPlaybackStateChanged(int i11);

        void onPlaybackSuppressionReasonChanged(int i11);

        void onPlayerError(PlaybackException playbackException);

        void onPlayerErrorChanged(@Nullable PlaybackException playbackException);

        @Deprecated
        void onPlayerStateChanged(boolean z11, int i11);

        @Deprecated
        void onPositionDiscontinuity(int i11);

        void onPositionDiscontinuity(e eVar, e eVar2, int i11);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i11);

        void onShuffleModeEnabledChanged(boolean z11);

        void onSkipSilenceEnabledChanged(boolean z11);

        void onSurfaceSizeChanged(int i11, int i12);

        void onTimelineChanged(m0 m0Var, int i11);

        void onTrackSelectionParametersChanged(p0 p0Var);

        void onTracksChanged(q0 q0Var);

        void onVideoSizeChanged(t0 t0Var);

        void onVolumeChanged(float f11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f9233k = u0.E0(0);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f9234l = u0.E0(1);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f9235m = u0.E0(2);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f9236n = u0.E0(3);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f9237o = u0.E0(4);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f9238p = u0.E0(5);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f9239q = u0.E0(6);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Deprecated
        public static final i<e> f9240r = new androidx.media3.common.b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Object f9241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final int f9242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final b0 f9244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final Object f9245e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9246f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f9247g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f9248h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f9249i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f9250j;

        public e(@Nullable Object obj, int i11, @Nullable b0 b0Var, @Nullable Object obj2, int i12, long j11, long j12, int i13, int i14) {
            this.f9241a = obj;
            this.f9242b = i11;
            this.f9243c = i11;
            this.f9244d = b0Var;
            this.f9245e = obj2;
            this.f9246f = i12;
            this.f9247g = j11;
            this.f9248h = j12;
            this.f9249i = i13;
            this.f9250j = i14;
        }

        public boolean a(e eVar) {
            return this.f9243c == eVar.f9243c && this.f9246f == eVar.f9246f && this.f9247g == eVar.f9247g && this.f9248h == eVar.f9248h && this.f9249i == eVar.f9249i && this.f9250j == eVar.f9250j && com.google.common.base.j.a(this.f9244d, eVar.f9244d);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return a(eVar) && com.google.common.base.j.a(this.f9241a, eVar.f9241a) && com.google.common.base.j.a(this.f9245e, eVar.f9245e);
        }

        public int hashCode() {
            return com.google.common.base.j.b(this.f9241a, Integer.valueOf(this.f9243c), this.f9244d, this.f9245e, Integer.valueOf(this.f9246f), Long.valueOf(this.f9247g), Long.valueOf(this.f9248h), Integer.valueOf(this.f9249i), Integer.valueOf(this.f9250j));
        }
    }

    boolean A();

    void B(boolean z11, int i11);

    void C();

    void D(int i11, int i12, List<b0> list);

    void E(int i11);

    int F();

    void G(int i11, int i12);

    void H(b0 b0Var);

    void I(b0 b0Var);

    void J(d dVar);

    void K(d dVar);

    void M(int i11, b0 b0Var);

    b0 N(int i11);

    long P();

    void R(int i11, List<b0> list);

    void T(p0 p0Var);

    boolean U();

    void b(g0 g0Var);

    @Nullable
    PlaybackException c();

    void clearVideoSurface();

    void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void clearVideoTextureView(@Nullable TextureView textureView);

    long d();

    void e(List<b0> list, boolean z11);

    void f();

    boolean g();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    m0 getCurrentTimeline();

    q0 getCurrentTracks();

    long getDuration();

    boolean getPlayWhenReady();

    g0 getPlaybackParameters();

    int getPlaybackState();

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    float getVolume();

    y3.b h();

    boolean i(int i11);

    boolean isPlaying();

    boolean isPlayingAd();

    boolean j();

    int k();

    Looper l();

    p0 m();

    void n();

    b o();

    long p();

    void pause();

    void play();

    void prepare();

    t0 q();

    boolean r();

    void release();

    long s();

    void seekTo(int i11, long j11);

    void seekTo(long j11);

    void seekToDefaultPosition();

    void setPlayWhenReady(boolean z11);

    void setPlaybackSpeed(float f11);

    void setRepeatMode(int i11);

    void setShuffleModeEnabled(boolean z11);

    void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void setVideoTextureView(@Nullable TextureView textureView);

    void setVolume(float f11);

    void stop();

    boolean t();

    int u();

    long v();

    void w();

    void x();

    d0 y();

    long z();
}
