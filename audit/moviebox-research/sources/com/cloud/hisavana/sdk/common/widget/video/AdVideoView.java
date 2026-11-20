package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.hisavana.sdk.R$styleable;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.f2;
import com.cloud.hisavana.sdk.manager.VideoMeasureManager;
import com.cloud.hisavana.sdk.q0;
import com.cloud.hisavana.sdk.w1;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.j;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.upstream.cache.q;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.video.y;
import com.google.android.exoplayer2.z1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;
import vh.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AdVideoView extends FrameLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static k.a f29550r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaTextureView f29551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScaleImageView f29552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f29553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q0 f29554d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f29556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f29557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AdsDTO f29558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f29559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f29560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u1 f29561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f29562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f29563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f29564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f29565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f2 f29566q;

    /* JADX INFO: compiled from: source.java */
    public class a implements n2.d {
        public a() {
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onAvailableCommandsChanged(n2.b bVar) {
            p2.c(this, bVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onCues(List list) {
            p2.d(this, list);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onCues(f fVar) {
            p2.e(this, fVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onDeviceInfoChanged(n nVar) {
            p2.f(this, nVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
            p2.g(this, i11, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onEvents(n2 n2Var, n2.c cVar) {
            p2.h(this, n2Var, cVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z11) {
            p2.i(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onIsPlayingChanged(boolean z11) {
            z.a().d("AdVideoView", "onIsPlayingChanged  -----> isPlaying = " + z11);
            AdVideoView adVideoView = AdVideoView.this;
            if (z11) {
                if (adVideoView.f29554d != null && !AdVideoView.this.f29556g) {
                    AdVideoView.this.f29556g = true;
                    AdVideoView.this.f29554d.a();
                    AdVideoView.this.n();
                }
                AdVideoView.this.f29552b.setVisibility(8);
                AdVideoView.this.p();
            } else {
                adVideoView.removeCallbacks(adVideoView.f29565p);
            }
            if (AdVideoView.this.f29554d != null) {
                AdVideoView.this.f29554d.onIsPlayingChanged(z11);
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onLoadingChanged(boolean z11) {
            p2.k(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onMediaItemTransition(u1 u1Var, int i11) {
            p2.m(this, u1Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onMediaMetadataChanged(z1 z1Var) {
            p2.n(this, z1Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onMetadata(Metadata metadata) {
            p2.o(this, metadata);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z11, int i11) {
            p2.p(this, z11, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlaybackParametersChanged(m2 m2Var) {
            p2.q(this, m2Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlaybackStateChanged(int i11) {
            if (i11 == 2) {
                z.a().d("AdVideoView", "current status is loading.....");
                return;
            }
            if (i11 == 3) {
                z.a().d("AdVideoView", "current status is loading completed");
                if (AdVideoView.this.f29554d != null) {
                    AdVideoView.this.f29554d.d();
                }
                AdVideoView.this.v();
                return;
            }
            if (i11 != 4) {
                return;
            }
            z.a().d("AdVideoView", "current status is playing finished");
            AdVideoView adVideoView = AdVideoView.this;
            adVideoView.removeCallbacks(adVideoView.f29565p);
            if (AdVideoView.this.f29554d == null || AdVideoView.this.f29553c == null) {
                return;
            }
            AdVideoView.this.f29554d.b(AdVideoView.this.f29553c.getDuration(), AdVideoView.this.f29553c.getDuration(), 100);
            AdVideoView.this.f29554d.onComplete();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            p2.s(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlayerError(PlaybackException playbackException) {
            z.a().w("AdVideoView", "errorCode == " + playbackException.errorCode + ", error message == " + playbackException.getMessage());
            if (AdVideoView.this.f29554d != null) {
                AdVideoView.this.f29554d.onPlayerError(playbackException);
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            p2.u(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlayerStateChanged(boolean z11, int i11) {
            p2.v(this, z11, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPositionDiscontinuity(int i11) {
            p2.x(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPositionDiscontinuity(n2.e eVar, n2.e eVar2, int i11) {
            p2.y(this, eVar, eVar2, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onRenderedFirstFrame() {
            p2.z(this);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onRepeatModeChanged(int i11) {
            p2.A(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onSeekProcessed() {
            p2.D(this);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z11) {
            p2.E(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
            p2.F(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            p2.G(this, i11, i12);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onTimelineChanged(j3 j3Var, int i11) {
            p2.H(this, j3Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onTrackSelectionParametersChanged(fi.z zVar) {
            p2.I(this, zVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onTracksChanged(o3 o3Var) {
            p2.J(this, o3Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onVideoSizeChanged(y yVar) {
            z.a().d("AdVideoView", "onVideoSizeChanged ------> ");
            AdVideoView.this.v();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onVolumeChanged(float f11) {
            z.a().d("AdVideoView", "onVolumeChanged ----> volume = " + f11);
            if (AdVideoView.this.f29554d != null) {
                AdVideoView.this.f29554d.onVolumeChanged(f11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends DrawableResponseListener {
        public b() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (AdVideoView.this.f29554d != null) {
                AdVideoView.this.f29554d.e(false);
            }
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            z.a().d("AdVideoView", "setCompanionSize ------> onRequestSuccess");
            if (AdVideoView.this.f29553c == null || !AdVideoView.this.f29553c.isPlaying()) {
                AdVideoView.this.f29552b.setVisibility(0);
                if (AdVideoView.this.f29554d != null) {
                    AdVideoView.this.f29554d.e(true);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements f2 {
        public c() {
        }

        @Override // com.cloud.hisavana.sdk.f2
        public void a(double d11) {
            if (AdVideoView.this.f29556g) {
                AdVideoView adVideoView = AdVideoView.this;
                if (d11 <= 0.0d) {
                    if (adVideoView.isPlaying()) {
                        AdVideoView.this.pause();
                    }
                    if (!AdVideoView.this.f29563n || AdVideoView.this.f29553c == null) {
                        return;
                    }
                    AdVideoView.this.f29553c.release();
                    AdVideoView.this.f29553c.clearVideoSurface();
                    AdVideoView.this.f29553c = null;
                    return;
                }
                if (adVideoView.f29563n) {
                    if (AdVideoView.this.f29553c == null) {
                        AdVideoView.this.t();
                    }
                } else {
                    if (AdVideoView.this.isPlaying()) {
                        return;
                    }
                    AdVideoView.this.play();
                }
            }
        }
    }

    public AdVideoView(@NonNull Context context) {
        this(context, null);
    }

    public AdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29555f = true;
        this.f29557h = false;
        this.f29564o = true;
        this.f29565p = new Runnable() { // from class: com.cloud.hisavana.sdk.common.widget.video.AdVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AdVideoView.this.f29553c == null) {
                    return;
                }
                int playbackState = AdVideoView.this.f29553c.getPlaybackState();
                long duration = AdVideoView.this.f29553c.getDuration();
                long currentPosition = AdVideoView.this.f29553c.getCurrentPosition();
                int i12 = duration == 0 ? 0 : (int) ((100 * currentPosition) / duration);
                if (AdVideoView.this.f29554d != null) {
                    AdVideoView.this.f29554d.b(duration, currentPosition, i12);
                }
                if (!AdVideoView.this.f29553c.isPlaying() || playbackState == 4 || playbackState == 1) {
                    return;
                }
                AdVideoView adVideoView = AdVideoView.this;
                adVideoView.postDelayed(adVideoView.f29565p, 1000 - (currentPosition % 1000));
            }
        };
        this.f29566q = new c();
        this.f29551a = new MediaTextureView(context);
        this.f29552b = new ScaleImageView(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AdVideoView);
        this.f29557h = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AdVideoView_use_cache, false);
        typedArrayObtainStyledAttributes.recycle();
        s();
    }

    public static k.a q() {
        if (f29550r == null) {
            f29550r = new com.google.android.exoplayer2.upstream.cache.a.c().h(new SimpleCache(StorageUtils.d(com.cloud.sdk.commonutil.util.f.a(), true), new q(52428800L), new rg.b(com.cloud.sdk.commonutil.util.f.a()))).i(new r.a(com.cloud.sdk.commonutil.util.f.a()));
        }
        return f29550r;
    }

    public void dispatchPause() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return;
        }
        pVar.pause();
        removeCallbacks(this.f29565p);
    }

    public void dispatchPlay() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return;
        }
        int playbackState = pVar.getPlaybackState();
        if (playbackState == 1) {
            this.f29553c.prepare();
        } else if (playbackState == 4) {
            p pVar2 = this.f29553c;
            pVar2.seekTo(pVar2.u(), C.TIME_UNSET);
        }
        this.f29553c.play();
        p();
    }

    public void dispatchPlayPause() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return;
        }
        int playbackState = pVar.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !this.f29553c.getPlayWhenReady()) {
            q0 q0Var = this.f29554d;
            if (q0Var != null) {
                q0Var.c(true);
            }
            dispatchPlay();
            return;
        }
        q0 q0Var2 = this.f29554d;
        if (q0Var2 != null) {
            q0Var2.c(false);
        }
        dispatchPause();
    }

    public long getCurrentPosition() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return 0L;
        }
        return pVar.getCurrentPosition();
    }

    public long getDuration() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return 0L;
        }
        return pVar.getDuration();
    }

    public boolean isPlayWhenReady() {
        return this.f29555f;
    }

    public boolean isPlaying() {
        p pVar = this.f29553c;
        if (pVar != null) {
            return pVar.isPlaying();
        }
        return false;
    }

    public final void n() {
        if (this.f29564o) {
            VideoMeasureManager.INSTANCE.g(new w1(this.f29558i, this, this.f29566q));
        }
    }

    public final void o() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return;
        }
        this.f29560k = true;
        pVar.setVolume(0.0f);
        q0 q0Var = this.f29554d;
        if (q0Var != null) {
            q0Var.onVolumeChanged(0.0f);
        }
    }

    public void openOrCloseVolume() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return;
        }
        if (pVar.getVolume() == 0.0f) {
            u();
        } else {
            o();
        }
    }

    public final void p() {
        post(this.f29565p);
    }

    public void pause() {
        p pVar = this.f29553c;
        if (pVar != null) {
            pVar.pause();
        }
    }

    public void play() {
        p pVar = this.f29553c;
        if (pVar != null) {
            pVar.play();
        }
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final void t() {
        p.b bVar;
        l lVar;
        String str;
        p pVar = this.f29553c;
        if (pVar != null) {
            pVar.release();
            this.f29553c = null;
        }
        this.f29556g = false;
        if (this.f29557h) {
            q();
            if (f29550r == null) {
                z.a().e("AdVideoView", "factory is null");
                return;
            } else {
                bVar = new p.b(getContext()).n(new d(f29550r));
                lVar = new l(getContext());
            }
        } else {
            bVar = new p.b(getContext());
            lVar = new l(getContext());
        }
        this.f29553c = bVar.o(lVar.j(true)).g();
        this.f29553c.setVideoTextureView(this.f29551a);
        this.f29553c.E(new a());
        if (this.f29553c == null || (str = this.f29559j) == null) {
            z.a().e("AdVideoView", "setMediaData adPlayer is null");
            return;
        }
        u1 u1VarD = u1.d(Uri.parse(str));
        this.f29561l = u1VarD;
        if (this.f29557h) {
            this.f29553c.a(new com.google.android.exoplayer2.source.n.b(f29550r).a(this.f29561l));
        } else {
            this.f29553c.D(u1VarD);
        }
        z.a().d("AdVideoView", "setMediaData -------------> playWhenReady = " + this.f29555f);
        this.f29553c.setPlayWhenReady(this.f29555f);
        if (this.f29560k) {
            this.f29553c.setVolume(0.0f);
        }
        this.f29553c.prepare();
    }

    public void release() {
        z.a().d("AdVideoView", "-------------> release && adplayer =" + System.identityHashCode(this.f29553c));
        VideoMeasureManager.INSTANCE.f(this.f29558i);
        this.f29551a.destroyDrawingCache();
        removeCallbacks(this.f29565p);
        if (this.f29553c != null) {
            if (isPlaying()) {
                pause();
            }
            this.f29553c.stop();
            this.f29553c.release();
            this.f29553c.clearVideoSurface();
            this.f29553c = null;
        }
    }

    public void repeat() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return;
        }
        if (pVar.getPlaybackState() == 1) {
            this.f29553c.prepare();
        } else {
            p pVar2 = this.f29553c;
            pVar2.seekTo(pVar2.u(), C.TIME_UNSET);
        }
        this.f29553c.play();
    }

    public void s() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f29551a, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(this.f29552b, layoutParams2);
    }

    public final void seekTo(long j11) {
        p pVar = this.f29553c;
        if (pVar != null) {
            pVar.seekTo(j11);
        }
    }

    public void setAdMediaPlayerListener(q0 q0Var) {
        this.f29554d = q0Var;
    }

    public void setCompanionSize(String str) {
        DownLoadRequest.p(str, null, 12, new b(), this.f29552b);
    }

    public void setCompanionViewVisibility(int i11) {
        ScaleImageView scaleImageView = this.f29552b;
        if (scaleImageView != null) {
            scaleImageView.setVisibility(i11);
        }
    }

    public void setMeasureAble(boolean z11) {
        this.f29564o = z11;
    }

    public void setMediaData(AdsDTO adsDTO, String str, boolean z11) {
        z.a().d("AdVideoView", "setMediaData -------------> path = " + str + "; and useCache is " + this.f29557h);
        this.f29558i = adsDTO;
        this.f29559j = str;
        this.f29560k = z11;
        this.f29562m = false;
        if (adsDTO != null && adsDTO.getMaterialWith() > 0 && this.f29558i.getMaterialHeight() > 0) {
            this.f29562m = true;
            setVideoSize(this.f29558i.getMaterialWith(), this.f29558i.getMaterialHeight());
        }
        this.f29551a.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.widget.video.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f29601a.t();
            }
        });
    }

    public void setPlayWhenReady(boolean z11) {
        this.f29555f = z11;
    }

    public void setUseCache(boolean z11) {
        this.f29557h = z11;
    }

    public void setUseListMode(boolean z11) {
        this.f29563n = z11;
    }

    public void setVideoSize(int i11, int i12) {
        z.a().d("AdVideoView", "onVideoSizeChanged ------> width=" + i11 + " height=" + i12);
        this.f29551a.adaptVideoSize(i11 > 0 ? i11 : j.g(), i12 > 0 ? i12 : j.f());
        q0 q0Var = this.f29554d;
        if (q0Var != null) {
            q0Var.onVideoSizeChanged(i11, i12);
        }
    }

    public final void u() {
        p pVar = this.f29553c;
        if (pVar == null) {
            return;
        }
        pVar.setVolume(1.0f);
        this.f29560k = false;
        q0 q0Var = this.f29554d;
        if (q0Var != null) {
            q0Var.onVolumeChanged(1.0f);
        }
    }

    public final void v() {
        p pVar = this.f29553c;
        if (pVar == null || this.f29562m) {
            return;
        }
        y yVarQ = pVar.q();
        int i11 = yVarQ == null ? 0 : yVarQ.f35863a;
        int i12 = yVarQ != null ? yVarQ.f35864b : 0;
        if (i11 > 0 && i12 > 0) {
            this.f29558i.setMaterialWith(i11);
            this.f29558i.setMaterialHeight(i12);
        }
        setVideoSize(i11, i12);
    }
}
