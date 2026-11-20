package com.transsion.player.shorttv;

import android.app.Application;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.b0;
import androidx.media3.common.d0;
import androidx.media3.common.f0;
import androidx.media3.common.g0;
import androidx.media3.common.h0;
import androidx.media3.common.i0;
import androidx.media3.common.m0;
import androidx.media3.common.o;
import androidx.media3.common.p0;
import androidx.media3.common.q0;
import androidx.media3.common.t0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.u;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.MediaSource;
import com.transsion.player.exo.ORExoDecoderType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.shorttv.preload.g;
import com.transsion.player.ui.render.RenderScaleMode;
import com.transsion.player.ui.render.SurfaceRenderView;
import com.transsion.player.ui.render.TextureRenderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class ORExoShortTvPlayer implements com.transsion.player.shorttv.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.player.shorttv.preload.c f54745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, MediaSource> f54747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u f54748d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaSource f54749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SurfaceRenderView f54750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextureRenderView f54751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Float f54752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f54753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f54754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f54755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f54756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ScaleMode f54757n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f54758o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f54759p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f54760q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ORExoDecoderType f54761r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.transsion.player.orplayer.c f54762s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h0.d f54763t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f54764u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f54765v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f54766w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f54767x;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54768a;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            try {
                iArr[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f54768a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends androidx.media3.exoplayer.util.a {
        public b(String str) {
            super(str);
        }

        @Override // androidx.media3.exoplayer.util.a, e4.c
        public void n(e4.c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.g(eventTime, "eventTime");
            Intrinsics.g(decoderName, "decoderName");
            super.n(eventTime, decoderName, j11, j12);
            com.transsion.player.utils.b.f54866a.h(ORExoShortTvPlayer.this.f54746b, "onExoAudioDecoderInitialize, decoderName:" + decoderName, true);
        }

        @Override // androidx.media3.exoplayer.util.a, e4.c
        public void n0(e4.c.a eventTime, q0 tracks) {
            Intrinsics.g(eventTime, "eventTime");
            Intrinsics.g(tracks, "tracks");
            super.n0(eventTime, tracks);
            ORExoShortTvPlayer.this.v(eventTime, tracks);
        }

        @Override // androidx.media3.exoplayer.util.a, e4.c
        public void x(e4.c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.g(eventTime, "eventTime");
            Intrinsics.g(decoderName, "decoderName");
            super.x(eventTime, decoderName, j11, j12);
            com.transsion.player.utils.b.f54866a.h(ORExoShortTvPlayer.this.f54746b, "onExoVideoDecoderInitialize, decoderName:" + decoderName, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c implements h0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f54770a = 1;

        public c() {
        }

        @Override // androidx.media3.common.h0.d
        public void onAvailableCommandsChanged(h0.b availableCommands) {
            Intrinsics.g(availableCommands, "availableCommands");
        }

        @Override // androidx.media3.common.h0.d
        public void onCues(List<y3.a> cues) {
            Intrinsics.g(cues, "cues");
        }

        @Override // androidx.media3.common.h0.d
        public void onCues(y3.b cueGroup) {
            Intrinsics.g(cueGroup, "cueGroup");
        }

        @Override // androidx.media3.common.h0.d
        public void onDeviceInfoChanged(o deviceInfo) {
            Intrinsics.g(deviceInfo, "deviceInfo");
        }

        @Override // androidx.media3.common.h0.d
        public void onDeviceVolumeChanged(int i11, boolean z11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onEvents(h0 player, h0.c events) {
            Intrinsics.g(player, "player");
            Intrinsics.g(events, "events");
        }

        @Override // androidx.media3.common.h0.d
        public void onIsLoadingChanged(boolean z11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onIsPlayingChanged(boolean z11) {
            com.transsion.player.orplayer.c cVar = ORExoShortTvPlayer.this.f54762s;
            if (cVar != null) {
                cVar.f(z11);
            }
            if (z11) {
                for (e listener : ORExoShortTvPlayer.this.f54764u) {
                    if (listener != null) {
                        Intrinsics.f(listener, "listener");
                        e.a.I(listener, null, 1, null);
                    }
                }
                ORExoShortTvPlayer.this.f54765v.post(ORExoShortTvPlayer.this.f54766w);
            } else {
                u uVar = ORExoShortTvPlayer.this.f54748d;
                if (uVar == null || !uVar.getPlayWhenReady()) {
                    for (e listener2 : ORExoShortTvPlayer.this.f54764u) {
                        if (listener2 != null) {
                            Intrinsics.f(listener2, "listener");
                            e.a.F(listener2, null, 1, null);
                        }
                    }
                }
                ORExoShortTvPlayer.this.f54765v.removeCallbacks(ORExoShortTvPlayer.this.f54766w);
            }
            com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, ORExoShortTvPlayer.this.f54746b, "onIsPlayingChanged:" + z11, false, 4, null);
        }

        @Override // androidx.media3.common.h0.d
        public void onLoadingChanged(boolean z11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onMediaItemTransition(b0 b0Var, int i11) {
            b0.h hVar;
            com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, ORExoShortTvPlayer.this.f54746b, "onMediaItemTransition  reason:" + i11 + " ", false, 4, null);
            if (i11 == 0 || i11 == 1) {
                for (e eVar : ORExoShortTvPlayer.this.f54764u) {
                    if (eVar != null) {
                        eVar.onMediaItemTransition((b0Var == null || (hVar = b0Var.f8951b) == null) ? null : hVar.f9051e);
                    }
                }
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onMediaMetadataChanged(d0 mediaMetadata) {
            Intrinsics.g(mediaMetadata, "mediaMetadata");
        }

        @Override // androidx.media3.common.h0.d
        public void onMetadata(androidx.media3.common.Metadata metadata) {
            Intrinsics.g(metadata, "metadata");
        }

        @Override // androidx.media3.common.h0.d
        public void onPlayWhenReadyChanged(boolean z11, int i11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onPlaybackParametersChanged(g0 playbackParameters) {
            Intrinsics.g(playbackParameters, "playbackParameters");
        }

        @Override // androidx.media3.common.h0.d
        public void onPlaybackStateChanged(int i11) {
            com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
            com.transsion.player.utils.b.d(bVar, ORExoShortTvPlayer.this.f54746b, "onPlaybackStateChanged  playbackState:" + i11 + " ", false, 4, null);
            if (i11 == 2) {
                com.transsion.player.utils.b.d(bVar, ORExoShortTvPlayer.this.f54746b, "onPlaybackStateChanged STATE_BUFFERING", false, 4, null);
                for (e listener : ORExoShortTvPlayer.this.f54764u) {
                    if (listener != null) {
                        Intrinsics.f(listener, "listener");
                        e.a.i(listener, null, 1, null);
                    }
                }
            } else if (i11 == 3) {
                ORExoShortTvPlayer.this.w();
                for (e listener2 : ORExoShortTvPlayer.this.f54764u) {
                    if (listener2 != null) {
                        Intrinsics.f(listener2, "listener");
                        e.a.w(listener2, null, 1, null);
                    }
                }
                if (this.f54770a == 2) {
                    for (e listener3 : ORExoShortTvPlayer.this.f54764u) {
                        if (listener3 != null) {
                            Intrinsics.f(listener3, "listener");
                            e.a.k(listener3, null, 1, null);
                        }
                    }
                }
            } else if (i11 == 4) {
                for (e listener4 : ORExoShortTvPlayer.this.f54764u) {
                    if (listener4 != null) {
                        Intrinsics.f(listener4, "listener");
                        e.a.e(listener4, null, 1, null);
                    }
                }
            }
            this.f54770a = i11;
        }

        @Override // androidx.media3.common.h0.d
        public void onPlaybackSuppressionReasonChanged(int i11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onPlayerError(PlaybackException error) {
            Intrinsics.g(error, "error");
            com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, ORExoShortTvPlayer.this.f54746b, "onPlayerError:" + error, false, 4, null);
            for (e listener : ORExoShortTvPlayer.this.f54764u) {
                if (listener != null) {
                    Intrinsics.f(listener, "listener");
                    e.a.q(listener, new PlayError(Integer.valueOf(error.errorCode), error.getMessage()), null, 2, null);
                }
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onPlayerErrorChanged(PlaybackException playbackException) {
        }

        @Override // androidx.media3.common.h0.d
        public void onPlayerStateChanged(boolean z11, int i11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onPositionDiscontinuity(int i11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onPositionDiscontinuity(h0.e oldPosition, h0.e newPosition, int i11) {
            Intrinsics.g(oldPosition, "oldPosition");
            Intrinsics.g(newPosition, "newPosition");
            int i12 = newPosition.f9243c;
            long j11 = newPosition.f9247g;
            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, ORExoShortTvPlayer.this.f54746b, "onPositionDiscontinuity: currentWindowIndex=" + i12 + ", currentPositionMs=" + j11 + ", reason=" + i11, false, 4, null);
            if (i11 == 1 || i11 == 2) {
                for (e eVar : ORExoShortTvPlayer.this.f54764u) {
                    if (eVar != null) {
                        eVar.setOnSeekCompleteListener();
                    }
                }
            }
            for (e listener : ORExoShortTvPlayer.this.f54764u) {
                if (listener != null) {
                    Intrinsics.f(listener, "listener");
                    e.a.y(listener, j11, null, 2, null);
                }
            }
            g gVarR = ORExoShortTvPlayer.this.r();
            if (gVarR != null) {
                gVarR.h(i12);
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onRenderedFirstFrame() {
            com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, ORExoShortTvPlayer.this.f54746b, "onRenderedFirstFrame:", false, 4, null);
            for (e eVar : ORExoShortTvPlayer.this.f54764u) {
                if (eVar != null) {
                    eVar.onRenderFirstFrame();
                }
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onRepeatModeChanged(int i11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onShuffleModeEnabledChanged(boolean z11) {
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
            i0.E(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public void onSurfaceSizeChanged(int i11, int i12) {
        }

        @Override // androidx.media3.common.h0.d
        public void onTimelineChanged(m0 timeline, int i11) {
            Intrinsics.g(timeline, "timeline");
        }

        @Override // androidx.media3.common.h0.d
        public void onTrackSelectionParametersChanged(p0 parameters) {
            Intrinsics.g(parameters, "parameters");
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onTracksChanged(q0 q0Var) {
            i0.I(this, q0Var);
        }

        @Override // androidx.media3.common.h0.d
        public void onVideoSizeChanged(t0 videoSize) {
            Intrinsics.g(videoSize, "videoSize");
            SurfaceRenderView surfaceRenderView = ORExoShortTvPlayer.this.f54750g;
            if (surfaceRenderView != null) {
                surfaceRenderView.setVideoRotation(videoSize.f9451c);
            }
            TextureRenderView textureRenderView = ORExoShortTvPlayer.this.f54751h;
            if (textureRenderView != null) {
                textureRenderView.setVideoRotation(videoSize.f9451c);
            }
            SurfaceRenderView surfaceRenderView2 = ORExoShortTvPlayer.this.f54750g;
            if (surfaceRenderView2 != null) {
                surfaceRenderView2.setVideoSize(videoSize.f9449a, videoSize.f9450b);
            }
            TextureRenderView textureRenderView2 = ORExoShortTvPlayer.this.f54751h;
            if (textureRenderView2 != null) {
                textureRenderView2.setVideoSize(videoSize.f9449a, videoSize.f9450b);
            }
            for (e eVar : ORExoShortTvPlayer.this.f54764u) {
                if (eVar != null) {
                    eVar.onVideoSizeChanged(videoSize.f9449a, videoSize.f9450b);
                }
            }
            com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, ORExoShortTvPlayer.this.f54746b, "onVideoSizeChanged width:" + videoSize.f9449a + "  height:" + videoSize.f9450b, false, 4, null);
        }

        @Override // androidx.media3.common.h0.d
        public void onVolumeChanged(float f11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements com.transsion.player.orplayer.d {
        public d() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            u uVar = ORExoShortTvPlayer.this.f54748d;
            if (uVar != null) {
                return uVar.U();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            u uVar = ORExoShortTvPlayer.this.f54748d;
            if (uVar != null) {
                uVar.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            u uVar = ORExoShortTvPlayer.this.f54748d;
            if (uVar != null) {
                uVar.play();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f11) {
            u uVar = ORExoShortTvPlayer.this.f54748d;
            if (uVar == null) {
                return;
            }
            uVar.setVolume(f11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ORExoShortTvPlayer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ORExoShortTvPlayer(com.transsion.player.shorttv.preload.c config) {
        Intrinsics.g(config, "config");
        this.f54745a = config;
        this.f54746b = "ShortTv-ORExoPlayer";
        this.f54747c = new HashMap();
        this.f54756m = 1.0f;
        this.f54757n = ScaleMode.SCALE_TO_FILL;
        ORExoDecoderType oRExoDecoderType = ORExoDecoderType.HARDWARE;
        this.f54761r = oRExoDecoderType;
        this.f54763t = new c();
        this.f54764u = new CopyOnWriteArrayList<>();
        s();
        p(oRExoDecoderType);
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.d(looperMyLooper);
        this.f54765v = new Handler(looperMyLooper);
        this.f54766w = new Runnable() { // from class: com.transsion.player.shorttv.a
            @Override // java.lang.Runnable
            public final void run() {
                ORExoShortTvPlayer.x(this.f54773a);
            }
        };
        this.f54767x = LazyKt__LazyJVMKt.b(new Function0<g>() { // from class: com.transsion.player.shorttv.ORExoShortTvPlayer$videoPreloadHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final g invoke() {
                if (!this.this$0.q().a()) {
                    return null;
                }
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return new g(applicationA);
            }
        });
    }

    public /* synthetic */ ORExoShortTvPlayer(com.transsion.player.shorttv.preload.c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? com.transsion.player.shorttv.preload.d.a() : cVar);
    }

    private final MediaSource o() {
        MediaSource mediaSource = this.f54749f;
        reset();
        release();
        ORExoDecoderType oRExoDecoderType = Intrinsics.b(this.f54760q, "video/av01") ? ORExoDecoderType.AV1 : ORExoDecoderType.FFMPEG;
        this.f54761r = oRExoDecoderType;
        com.transsion.player.utils.b.f54866a.a(this.f54746b, "重新创建播放器切换编码, DecoderType:" + oRExoDecoderType + ",MimeTyp:" + this.f54760q, true);
        p(this.f54761r);
        t();
        return mediaSource;
    }

    private final void p(ORExoDecoderType oRExoDecoderType) {
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        u uVarG = new u.b(applicationA).n(new androidx.media3.exoplayer.source.d(applicationA).q(com.transsion.player.exo.a.d(applicationA))).o(com.transsion.player.exo.a.b(applicationA, oRExoDecoderType)).g();
        uVarG.setPlayWhenReady(false);
        uVarG.K(this.f54763t);
        uVarG.L(new b(this.f54746b));
        this.f54748d = uVarG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g r() {
        return (g) this.f54767x.getValue();
    }

    private final void s() {
        this.f54762s = new com.transsion.player.orplayer.c(new d(), new Function1<Boolean, Unit>() { // from class: com.transsion.player.shorttv.ORExoShortTvPlayer$initAudioFocus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                Iterator it = this.this$0.f54764u.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).onFocusChange(z11);
                }
            }
        });
    }

    private final void t() {
        setMute(this.f54755l);
        Float f11 = this.f54752i;
        if (f11 != null) {
            setVolume(f11.floatValue());
        }
        setLooping(this.f54754k);
        setAutoPlay(this.f54753j);
        setSpeed(this.f54756m);
        SurfaceRenderView surfaceRenderView = this.f54750g;
        if (surfaceRenderView != null) {
            setSurfaceView(surfaceRenderView);
        }
        TextureRenderView textureRenderView = this.f54751h;
        if (textureRenderView != null) {
            setTextureView(textureRenderView);
        }
        setScaleMode(this.f54757n);
    }

    private final void u() {
        this.f54765v.removeCallbacks(this.f54766w);
        this.f54765v.postDelayed(this.f54766w, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(e4.c.a aVar, q0 q0Var) {
        int size = q0Var.a().size();
        for (int i11 = 0; i11 < size; i11++) {
            q0.a aVar2 = q0Var.a().get(i11);
            Intrinsics.f(aVar2, "tracks.groups[groupIndex]");
            q0.a aVar3 = aVar2;
            int i12 = aVar3.f9435a;
            for (int i13 = 0; i13 < i12; i13++) {
                y yVarB = aVar3.b(i13);
                Intrinsics.f(yVarB, "trackGroup.getTrackFormat(index)");
                if (f0.s(yVarB.f9501m)) {
                    this.f54758o = yVarB.f9497i;
                } else if (f0.o(yVarB.f9501m)) {
                    this.f54759p = yVarB.f9497i;
                }
                com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
                com.transsion.player.utils.b.i(bVar, this.f54746b, "onTracksChanged  MimeType:" + yVarB.f9501m, false, 4, null);
                String str = yVarB.f9501m;
                if (str != null && StringsKt__StringsKt.Q(str, "video", false, 2, null)) {
                    String str2 = yVarB.f9501m;
                    this.f54760q = str2;
                    com.transsion.player.utils.b.f(bVar, this.f54746b, "--------onTracksChanged  curVideoMimeType:" + str2, false, 4, null);
                }
            }
        }
        if (!Intrinsics.b(this.f54760q, "video/av01") || Build.VERSION.SDK_INT > 29) {
            return;
        }
        com.transsion.player.utils.b.f54866a.c(this.f54746b, "exo av1，强制切换到软解， MimeType:" + this.f54760q, true);
        MediaSource mediaSourceO = o();
        if (mediaSourceO != null) {
            setDataSource(mediaSourceO);
            prepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        q0 currentTracks;
        u uVar;
        y yVarQ;
        y yVarA;
        u uVar2 = this.f54748d;
        if (uVar2 == null || (currentTracks = uVar2.getCurrentTracks()) == null) {
            return;
        }
        int size = currentTracks.a().size();
        for (int i11 = 0; i11 < size; i11++) {
            q0.a aVar = currentTracks.a().get(i11);
            Intrinsics.f(aVar, "tracks.groups[groupIndex]");
            q0.a aVar2 = aVar;
            int i12 = aVar2.f9435a;
            for (int i13 = 0; i13 < i12; i13++) {
                y yVarB = aVar2.b(i13);
                Intrinsics.f(yVarB, "trackGroup.getTrackFormat(index)");
                if (f0.s(yVarB.f9501m)) {
                    u uVar3 = this.f54748d;
                    if (uVar3 != null && (yVarA = uVar3.a()) != null) {
                        int i14 = yVarA.f9497i;
                        int i15 = yVarB.f9497i;
                        if (i14 == i15) {
                            this.f54758o = i15;
                            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54746b, "--onPrepare2GetBitrate  MimeType:" + yVarB.f9501m + "，videoBitrate：" + i15, false, 4, null);
                            Iterator<T> it = this.f54764u.iterator();
                            while (it.hasNext()) {
                                ((e) it.next()).onTracksVideoBitrateChange(this.f54758o);
                            }
                        }
                    }
                } else if (f0.o(yVarB.f9501m) && (uVar = this.f54748d) != null && (yVarQ = uVar.Q()) != null) {
                    int i16 = yVarQ.f9497i;
                    int i17 = yVarB.f9497i;
                    if (i16 == i17) {
                        this.f54759p = i17;
                        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54746b, "--onPrepare2GetBitrate  MimeType:" + yVarB.f9501m + "，audioBitrate：" + i17, false, 4, null);
                        Iterator<T> it2 = this.f54764u.iterator();
                        while (it2.hasNext()) {
                            ((e) it2.next()).onTracksAudioBitrateChange(this.f54759p);
                        }
                    }
                }
            }
        }
    }

    public static final void x(ORExoShortTvPlayer this$0) {
        Intrinsics.g(this$0, "this$0");
        u uVar = this$0.f54748d;
        if (uVar == null || !uVar.isPlaying()) {
            return;
        }
        for (e eVar : this$0.f54764u) {
            u uVar2 = this$0.f54748d;
            if (uVar2 != null) {
                eVar.onProgress(uVar2.getCurrentPosition(), this$0.currentMediaSource());
            }
        }
        this$0.u();
    }

    @Override // com.transsion.player.shorttv.b
    public Map<String, MediaSource> a() {
        return this.f54747c;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(MediaSource mediaSource) {
        b0.h hVar;
        String str;
        Integer numL;
        Intrinsics.g(mediaSource, "mediaSource");
        this.f54749f = mediaSource;
        b0 b0VarA = new b0.c().j(mediaSource.j()).d(String.valueOf(mediaSource.k())).b(mediaSource.f()).h(mediaSource.e()).a();
        Intrinsics.f(b0VarA, "Builder()\n            .s….id)\n            .build()");
        u uVar = this.f54748d;
        int iF = uVar != null ? uVar.F() : 0;
        int i11 = -1;
        for (int i12 = 0; i12 < iF; i12++) {
            u uVar2 = this.f54748d;
            Object obj = null;
            b0 b0VarN = uVar2 != null ? uVar2.N(i12) : null;
            int iIntValue = (b0VarN == null || (str = b0VarN.f8950a) == null || (numL = k.l(str)) == null) ? 0 : numL.intValue();
            if (b0VarN != null && (hVar = b0VarN.f8951b) != null) {
                obj = hVar.f9054h;
            }
            if (Intrinsics.b(obj, mediaSource.e())) {
                com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "addDataSource 已经在列表里 index:" + i12 + " vid:" + mediaSource.e(), false, 4, null);
                return false;
            }
            if (i11 < 0 && iIntValue > mediaSource.k()) {
                i11 = i12;
            }
        }
        if (i11 >= 0) {
            g gVarR = r();
            if (gVarR != null) {
                gVarR.f(i11, mediaSource);
            }
            u uVar3 = this.f54748d;
            if (uVar3 != null) {
                uVar3.M(i11, b0VarA);
            }
            com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "addDataSource  index:" + i11 + " key:" + mediaSource.e(), false, 4, null);
        } else {
            com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "addDataSource  index:" + iF + " key:" + mediaSource.e(), false, 4, null);
            u uVar4 = this.f54748d;
            if (uVar4 != null) {
                uVar4.I(b0VarA);
            }
        }
        g gVarR2 = r();
        if (gVarR2 != null) {
            gVarR2.g(mediaSource);
        }
        Map<String, MediaSource> map = this.f54747c;
        String strE = mediaSource.e();
        if (strE == null) {
            strE = "";
        }
        map.put(strE, mediaSource);
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        com.transsion.player.shorttv.b.a.a(this, listener);
        com.transsion.player.utils.b.f(com.transsion.player.utils.b.f54866a, this.f54746b, "addPlayerListener", false, 4, null);
        if (this.f54764u.contains(listener)) {
            return;
        }
        this.f54764u.add(listener);
    }

    @Override // com.transsion.player.shorttv.b
    public boolean b(MediaSource mediaSource) {
        b0.h hVar;
        Intrinsics.g(mediaSource, "mediaSource");
        b0.c cVar = new b0.c();
        String strG = mediaSource.g();
        if (strG == null) {
            strG = mediaSource.j();
        }
        b0 b0VarA = cVar.j(strG).d(String.valueOf(mediaSource.k())).b(mediaSource.f()).h(mediaSource.e()).a();
        Intrinsics.f(b0VarA, "Builder()\n            .s….id)\n            .build()");
        u uVar = this.f54748d;
        int iF = uVar != null ? uVar.F() : 0;
        for (int i11 = 0; i11 < iF; i11++) {
            u uVar2 = this.f54748d;
            Object obj = null;
            b0 b0VarN = uVar2 != null ? uVar2.N(i11) : null;
            if (b0VarN != null && (hVar = b0VarN.f8951b) != null) {
                obj = hVar.f9054h;
            }
            if (Intrinsics.b(obj, mediaSource.e())) {
                com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "updateDataSource 在列表里更新数据 index:" + i11 + " key:" + mediaSource.e(), false, 4, null);
                u uVar3 = this.f54748d;
                if (uVar3 != null) {
                    uVar3.O(i11, b0VarA);
                }
                u uVar4 = this.f54748d;
                if (uVar4 != null) {
                    uVar4.prepare();
                }
                Map<String, MediaSource> map = this.f54747c;
                String strE = mediaSource.e();
                if (strE == null) {
                    strE = "";
                }
                map.put(strE, mediaSource);
                return true;
            }
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(ov.d dVar, int i11) {
        com.transsion.player.shorttv.b.a.b(this, dVar, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        com.transsion.player.shorttv.b.a.c(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        SurfaceTexture surfaceTexture;
        SurfaceHolder holder;
        Surface surface;
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.setVideoSurfaceView(null);
        }
        u uVar2 = this.f54748d;
        if (uVar2 != null) {
            uVar2.setVideoTextureView(null);
        }
        SurfaceRenderView surfaceRenderView = this.f54750g;
        if (surfaceRenderView != null && (holder = surfaceRenderView.getHolder()) != null && (surface = holder.getSurface()) != null) {
            surface.release();
        }
        TextureRenderView textureRenderView = this.f54751h;
        if (textureRenderView == null || (surfaceTexture = textureRenderView.getSurfaceTexture()) == null) {
            return;
        }
        surfaceTexture.release();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001f  */
    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        String string;
        b0.h hVar;
        Object obj;
        u uVar = this.f54748d;
        if (uVar == null) {
            string = null;
        } else {
            b0 b0VarN = uVar.N(uVar != null ? uVar.u() : 0);
            if (b0VarN == null || (hVar = b0VarN.f8951b) == null || (obj = hVar.f9054h) == null) {
                string = null;
            } else {
                string = obj.toString();
            }
        }
        return this.f54747c.get(string);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z11) {
        if (!z11 && this.f54761r == ORExoDecoderType.HARDWARE) {
            o();
            return;
        }
        if (z11) {
            ORExoDecoderType oRExoDecoderType = this.f54761r;
            ORExoDecoderType oRExoDecoderType2 = ORExoDecoderType.HARDWARE;
            if (oRExoDecoderType != oRExoDecoderType2) {
                com.transsion.player.utils.b.f54866a.a(this.f54746b, "软解切换到硬解，重新创建设置", true);
                this.f54761r = oRExoDecoderType2;
                p(oRExoDecoderType2);
                t();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        return new Pair<>(Integer.valueOf(this.f54758o), Integer.valueOf(this.f54759p));
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        u uVar = this.f54748d;
        if (uVar != null) {
            return uVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        return com.transsion.player.shorttv.b.a.d(this);
    }

    @Override // com.transsion.player.orplayer.f
    public ov.b getCurrentVideoFormat() {
        return com.transsion.player.shorttv.b.a.e(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        return com.transsion.player.shorttv.b.a.f(this);
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        u uVar = this.f54748d;
        if (uVar != null) {
            return uVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        return com.transsion.player.shorttv.b.a.g(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        return com.transsion.player.shorttv.b.a.h(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        u uVar = this.f54748d;
        if (uVar != null) {
            return Float.valueOf(uVar.getVolume());
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        u uVar = this.f54748d;
        return uVar != null && uVar.getPlaybackState() == 4;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return com.transsion.player.shorttv.b.a.i(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        u uVar = this.f54748d;
        if (uVar != null) {
            return uVar.U();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        u uVar = this.f54748d;
        if (uVar != null) {
            return uVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        u uVar = this.f54748d;
        return uVar != null && uVar.getPlaybackState() == 3;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.f54762s;
        if (cVar != null) {
            cVar.g(true);
        }
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "pause", false, 4, null);
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.pause();
        }
        com.transsion.player.orplayer.c cVar2 = this.f54762s;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        u uVar;
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, MediaItem.MUSIC_FLOAT_STATE_PLAY, false, 4, null);
        u uVar2 = this.f54748d;
        if ((uVar2 != null ? uVar2.c() : null) != null && (uVar = this.f54748d) != null) {
            uVar.prepare();
        }
        u uVar3 = this.f54748d;
        if (uVar3 != null) {
            uVar3.play();
        }
        com.transsion.player.orplayer.c cVar = this.f54762s;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.f54762s;
        if (cVar2 != null) {
            cVar2.e();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "prepare", false, 4, null);
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.prepare();
        }
    }

    public final com.transsion.player.shorttv.preload.c q() {
        return this.f54745a;
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "release", false, 4, null);
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.release();
        }
        for (e listener : this.f54764u) {
            if (listener != null) {
                Intrinsics.f(listener, "listener");
                e.a.t(listener, null, 1, null);
            }
        }
        this.f54764u.clear();
        g gVarR = r();
        if (gVarR != null) {
            gVarR.p();
        }
        this.f54749f = null;
        com.transsion.player.orplayer.c cVar = this.f54762s;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        com.transsion.player.shorttv.b.a.j(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(MediaSource mediaSource) {
        b0.h hVar;
        Intrinsics.g(mediaSource, "mediaSource");
        u uVar = this.f54748d;
        int iF = uVar != null ? uVar.F() : 0;
        int i11 = 0;
        while (true) {
            if (i11 >= iF) {
                i11 = -1;
                break;
            }
            u uVar2 = this.f54748d;
            Object obj = null;
            b0 b0VarN = uVar2 != null ? uVar2.N(i11) : null;
            if (b0VarN != null && (hVar = b0VarN.f8951b) != null) {
                obj = hVar.f9054h;
            }
            if (Intrinsics.b(obj, mediaSource.e())) {
                com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "removeDataSource 在列表里 index:" + i11 + " key:" + mediaSource.e(), false, 4, null);
                break;
            }
            i11++;
        }
        if (i11 < 0) {
            return false;
        }
        g gVarR = r();
        if (gVarR != null) {
            String strE = mediaSource.e();
            if (strE == null) {
                strE = "";
            }
            gVarR.q(strE);
        }
        u uVar3 = this.f54748d;
        if (uVar3 != null) {
            uVar3.E(i11);
        }
        Map<String, MediaSource> map = this.f54747c;
        String strE2 = mediaSource.e();
        map.remove(strE2 != null ? strE2 : "");
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        com.transsion.player.shorttv.b.a.k(this, listener);
        com.transsion.player.utils.b.f(com.transsion.player.utils.b.f54866a, this.f54746b, "removePlayerListener", false, 4, null);
        this.f54764u.remove(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return com.transsion.player.shorttv.b.a.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "reset    ", false, 4, null);
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.stop();
        }
        for (e eVar : this.f54764u) {
            if (eVar != null) {
                eVar.onPlayerReset();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j11) {
        u uVar;
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "seekTo    mills:" + j11, false, 4, null);
        u uVar2 = this.f54748d;
        if ((uVar2 != null ? uVar2.c() : null) != null && (uVar = this.f54748d) != null) {
            uVar.prepare();
        }
        u uVar3 = this.f54748d;
        if (uVar3 != null) {
            uVar3.seekTo(j11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String uuid, long j11) {
        u uVar;
        b0 b0VarN;
        b0.h hVar;
        Intrinsics.g(uuid, "uuid");
        com.transsion.player.shorttv.b.a.m(this, uuid, j11);
        u uVar2 = this.f54748d;
        int iF = uVar2 != null ? uVar2.F() : 0;
        for (int i11 = 0; i11 < iF; i11++) {
            u uVar3 = this.f54748d;
            if (Intrinsics.b((uVar3 == null || (b0VarN = uVar3.N(i11)) == null || (hVar = b0VarN.f8951b) == null) ? null : hVar.f9054h, uuid)) {
                u uVar4 = this.f54748d;
                if ((uVar4 != null ? uVar4.c() : null) != null) {
                    prepare();
                }
                u uVar5 = this.f54748d;
                if (uVar5 == null || uVar5.u() != i11) {
                    com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "seekTo  index:" + i11 + " uuid:" + uuid, false, 4, null);
                    u uVar6 = this.f54748d;
                    if (uVar6 != null) {
                        uVar6.seekTo(i11, j11);
                    }
                } else {
                    if (isComplete() && (uVar = this.f54748d) != null) {
                        uVar.seekTo(j11);
                    }
                    com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "seekTo   uuid:" + uuid + " mills:" + j11 + "  是当前视频直接播放", false, 4, null);
                }
                play();
                return;
            }
        }
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "seekTo   uuid:" + uuid + " mills:" + j11 + "  没有找到", false, 4, null);
        pause();
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z11) {
        this.f54753j = z11;
        u uVar = this.f54748d;
        if (uVar == null) {
            return;
        }
        uVar.setPlayWhenReady(z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        this.f54749f = mediaSource;
        b0 b0VarB = b0.b(mediaSource.j());
        Intrinsics.f(b0VarB, "fromUri(mediaSource.url)");
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.H(b0VarB);
        }
        for (e eVar : this.f54764u) {
            if (eVar != null) {
                eVar.onSetDataSource();
            }
        }
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "setDataSource", false, 4, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z11) {
        this.f54754k = z11;
        u uVar = this.f54748d;
        if (uVar == null) {
            return;
        }
        uVar.setRepeatMode(z11 ? 1 : 0);
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        this.f54755l = z11;
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.B(z11, 1);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(iv.d dVar) {
        com.transsion.player.shorttv.b.a.n(this, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        addPlayerListener(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        RenderScaleMode renderScaleMode;
        Intrinsics.g(scaleMode, "scaleMode");
        com.transsion.player.shorttv.b.a.o(this, scaleMode);
        this.f54757n = scaleMode;
        int i11 = a.f54768a[scaleMode.ordinal()];
        if (i11 == 1) {
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_MATCH_PARENT;
        } else if (i11 == 2) {
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_DEFAULT;
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_CENTER_CROP;
        }
        TextureRenderView textureRenderView = this.f54751h;
        if (textureRenderView != null) {
            textureRenderView.setScaleType(renderScaleMode);
        }
        SurfaceRenderView surfaceRenderView = this.f54750g;
        if (surfaceRenderView != null) {
            surfaceRenderView.setScaleType(renderScaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f11) {
        this.f54756m = f11;
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.setPlaybackSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f54750g = surfaceView instanceof SurfaceRenderView ? (SurfaceRenderView) surfaceView : null;
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        this.f54751h = textureView instanceof TextureRenderView ? (TextureRenderView) textureView : null;
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.setVideoTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f11) {
        this.f54752i = Float.valueOf(f11);
        u uVar = this.f54748d;
        if (uVar == null) {
            return;
        }
        uVar.setVolume(f11);
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        com.transsion.player.orplayer.c cVar = this.f54762s;
        if (cVar != null) {
            cVar.g(true);
        }
        com.transsion.player.utils.b.d(com.transsion.player.utils.b.f54866a, this.f54746b, "stop    ", false, 4, null);
        u uVar = this.f54748d;
        if (uVar != null) {
            uVar.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.f54762s;
        if (cVar2 != null) {
            cVar2.b();
        }
    }
}
