package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface n2 {

    /* JADX INFO: compiled from: source.java */
    public static final class b implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f33604b = new a().e();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g.a<b> f33605c = new g.a() { // from class: com.google.android.exoplayer2.o2
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return n2.b.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.m f33606a;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int[] f33607b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.google.android.exoplayer2.util.m.b f33608a = new com.google.android.exoplayer2.util.m.b();

            public a a(int i11) {
                this.f33608a.a(i11);
                return this;
            }

            public a b(b bVar) {
                this.f33608a.b(bVar.f33606a);
                return this;
            }

            public a c(int... iArr) {
                this.f33608a.c(iArr);
                return this;
            }

            public a d(int i11, boolean z11) {
                this.f33608a.d(i11, z11);
                return this;
            }

            public b e() {
                return new b(this.f33608a.e());
            }
        }

        public b(com.google.android.exoplayer2.util.m mVar) {
            this.f33606a = mVar;
        }

        public static b d(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(e(0));
            if (integerArrayList == null) {
                return f33604b;
            }
            a aVar = new a();
            for (int i11 = 0; i11 < integerArrayList.size(); i11++) {
                aVar.a(integerArrayList.get(i11).intValue());
            }
            return aVar.e();
        }

        private static String e(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean c(int i11) {
            return this.f33606a.a(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f33606a.equals(((b) obj).f33606a);
            }
            return false;
        }

        public int hashCode() {
            return this.f33606a.hashCode();
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i11 = 0; i11 < this.f33606a.d(); i11++) {
                arrayList.add(Integer.valueOf(this.f33606a.c(i11)));
            }
            bundle.putIntegerArrayList(e(0), arrayList);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.m f33609a;

        public c(com.google.android.exoplayer2.util.m mVar) {
            this.f33609a = mVar;
        }

        public boolean a(int i11) {
            return this.f33609a.a(i11);
        }

        public boolean b(int... iArr) {
            return this.f33609a.b(iArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f33609a.equals(((c) obj).f33609a);
            }
            return false;
        }

        public int hashCode() {
            return this.f33609a.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void onAvailableCommandsChanged(b bVar);

        @Deprecated
        void onCues(List<vh.b> list);

        void onCues(vh.f fVar);

        void onDeviceInfoChanged(n nVar);

        void onDeviceVolumeChanged(int i11, boolean z11);

        void onEvents(n2 n2Var, c cVar);

        void onIsLoadingChanged(boolean z11);

        void onIsPlayingChanged(boolean z11);

        @Deprecated
        void onLoadingChanged(boolean z11);

        void onMediaItemTransition(@Nullable u1 u1Var, int i11);

        void onMediaMetadataChanged(z1 z1Var);

        void onMetadata(Metadata metadata);

        void onPlayWhenReadyChanged(boolean z11, int i11);

        void onPlaybackParametersChanged(m2 m2Var);

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

        @Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z11);

        void onSkipSilenceEnabledChanged(boolean z11);

        void onSurfaceSizeChanged(int i11, int i12);

        void onTimelineChanged(j3 j3Var, int i11);

        void onTrackSelectionParametersChanged(fi.z zVar);

        void onTracksChanged(o3 o3Var);

        void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar);

        void onVolumeChanged(float f11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements g {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final g.a<e> f33610l = new g.a() { // from class: com.google.android.exoplayer2.q2
            @Override // com.google.android.exoplayer2.g.a
            public final g a(Bundle bundle) {
                return n2.e.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Object f33611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final int f33612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final u1 f33614d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final Object f33615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f33616g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f33617h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f33618i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f33619j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f33620k;

        public e(@Nullable Object obj, int i11, @Nullable u1 u1Var, @Nullable Object obj2, int i12, long j11, long j12, int i13, int i14) {
            this.f33611a = obj;
            this.f33612b = i11;
            this.f33613c = i11;
            this.f33614d = u1Var;
            this.f33615f = obj2;
            this.f33616g = i12;
            this.f33617h = j11;
            this.f33618i = j12;
            this.f33619j = i13;
            this.f33620k = i14;
        }

        public static e b(Bundle bundle) {
            int i11 = bundle.getInt(c(0), -1);
            Bundle bundle2 = bundle.getBundle(c(1));
            return new e(null, i11, bundle2 == null ? null : (u1) u1.f34774k.a(bundle2), null, bundle.getInt(c(2), -1), bundle.getLong(c(3), C.TIME_UNSET), bundle.getLong(c(4), C.TIME_UNSET), bundle.getInt(c(5), -1), bundle.getInt(c(6), -1));
        }

        private static String c(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f33613c == eVar.f33613c && this.f33616g == eVar.f33616g && this.f33617h == eVar.f33617h && this.f33618i == eVar.f33618i && this.f33619j == eVar.f33619j && this.f33620k == eVar.f33620k && com.google.common.base.j.a(this.f33611a, eVar.f33611a) && com.google.common.base.j.a(this.f33615f, eVar.f33615f) && com.google.common.base.j.a(this.f33614d, eVar.f33614d);
        }

        public int hashCode() {
            return com.google.common.base.j.b(this.f33611a, Integer.valueOf(this.f33613c), this.f33614d, this.f33615f, Integer.valueOf(this.f33616g), Long.valueOf(this.f33617h), Long.valueOf(this.f33618i), Integer.valueOf(this.f33619j), Integer.valueOf(this.f33620k));
        }

        @Override // com.google.android.exoplayer2.g
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(c(0), this.f33613c);
            if (this.f33614d != null) {
                bundle.putBundle(c(1), this.f33614d.toBundle());
            }
            bundle.putInt(c(2), this.f33616g);
            bundle.putLong(c(3), this.f33617h);
            bundle.putLong(c(4), this.f33618i);
            bundle.putInt(c(5), this.f33619j);
            bundle.putInt(c(6), this.f33620k);
            return bundle;
        }
    }

    boolean A();

    void B(fi.z zVar);

    void C(d dVar);

    void D(u1 u1Var);

    void E(d dVar);

    void b(m2 m2Var);

    @Nullable
    PlaybackException c();

    void clearVideoSurface();

    void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void clearVideoTextureView(@Nullable TextureView textureView);

    long d();

    void e(List<u1> list, boolean z11);

    void f();

    boolean g();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    j3 getCurrentTimeline();

    o3 getCurrentTracks();

    long getDuration();

    boolean getPlayWhenReady();

    m2 getPlaybackParameters();

    int getPlaybackState();

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    float getVolume();

    vh.f h();

    boolean i(int i11);

    boolean isPlaying();

    boolean isPlayingAd();

    boolean j();

    int k();

    Looper l();

    fi.z m();

    void n();

    b o();

    long p();

    void pause();

    void play();

    void prepare();

    com.google.android.exoplayer2.video.y q();

    boolean r();

    void release();

    long s();

    void seekTo(int i11, long j11);

    void seekTo(long j11);

    void setPlayWhenReady(boolean z11);

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

    z1 y();

    long z();
}
