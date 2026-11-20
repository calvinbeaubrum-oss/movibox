package com.transsion.player.exo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
import androidx.media3.common.n0;
import androidx.media3.common.o;
import androidx.media3.common.o0;
import androidx.media3.common.p0;
import androidx.media3.common.q0;
import androidx.media3.common.t0;
import androidx.media3.common.y;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.rtmp.RtmpDataSource;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.a3;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.u;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.ui.render.RenderScaleMode;
import com.transsion.player.ui.render.SurfaceRenderView;
import com.transsion.player.ui.render.TextureRenderView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
public final class ORExoPlayer implements com.transsion.player.orplayer.f {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f54234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f54235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f54236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f54237d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SurfaceRenderView f54238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextureRenderView f54239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.player.orplayer.c f54240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaSource f54241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Float f54242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f54243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f54244l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f54245m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f54246n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f54247o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f54248p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f54249q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public u f54250r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f54251s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ORExoDecoderType f54252t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h0.d f54253u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a3 f54254v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList<com.transsion.player.orplayer.e> f54255w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Handler f54256x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Runnable f54257y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ScaleMode f54258z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f54260b;

        static {
            int[] iArr = new int[PlayMimeType.values().length];
            try {
                iArr[PlayMimeType.DASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayMimeType.HLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f54259a = iArr;
            int[] iArr2 = new int[ScaleMode.values().length];
            try {
                iArr2[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f54260b = iArr2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends androidx.media3.exoplayer.util.a {
        public c() {
            super("ORExoPlayer");
        }

        @Override // androidx.media3.exoplayer.util.a, e4.c
        public void n(e4.c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.g(eventTime, "eventTime");
            Intrinsics.g(decoderName, "decoderName");
            super.n(eventTime, decoderName, j11, j12);
            com.transsion.player.utils.b.f54866a.h("ORExoPlayer", "onExoAudioDecoderInitialize, decoderName:" + decoderName, true);
        }

        @Override // androidx.media3.exoplayer.util.a, e4.c
        public void n0(e4.c.a eventTime, q0 tracks) {
            Intrinsics.g(eventTime, "eventTime");
            Intrinsics.g(tracks, "tracks");
            super.n0(eventTime, tracks);
            ORExoPlayer.this.J(eventTime, tracks);
        }

        @Override // androidx.media3.exoplayer.util.a, e4.c
        public void x(e4.c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.g(eventTime, "eventTime");
            Intrinsics.g(decoderName, "decoderName");
            super.x(eventTime, decoderName, j11, j12);
            com.transsion.player.utils.b.f54866a.h("ORExoPlayer", "onExoVideoDecoderInitialize, decoderName:" + decoderName, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d implements h0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f54262a = 1;

        public d() {
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
            com.transsion.player.orplayer.c cVar = ORExoPlayer.this.f54240h;
            if (cVar != null) {
                cVar.f(z11);
            }
            for (com.transsion.player.orplayer.e eVar : ORExoPlayer.this.f54255w) {
                if (eVar != null) {
                    eVar.onIsPlayingChanged(z11);
                }
            }
            if (z11) {
                CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList = ORExoPlayer.this.f54255w;
                ORExoPlayer oRExoPlayer = ORExoPlayer.this;
                for (com.transsion.player.orplayer.e eVar2 : copyOnWriteArrayList) {
                    if (eVar2 != null) {
                        eVar2.onVideoStart(oRExoPlayer.f54241i);
                    }
                }
                ORExoPlayer.this.f54256x.post(ORExoPlayer.this.f54257y);
            } else {
                u uVar = ORExoPlayer.this.f54250r;
                if (uVar == null || !uVar.getPlayWhenReady()) {
                    CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList2 = ORExoPlayer.this.f54255w;
                    ORExoPlayer oRExoPlayer2 = ORExoPlayer.this;
                    for (com.transsion.player.orplayer.e eVar3 : copyOnWriteArrayList2) {
                        if (eVar3 != null) {
                            eVar3.onVideoPause(oRExoPlayer2.f54241i);
                        }
                    }
                }
                ORExoPlayer.this.f54256x.removeCallbacks(ORExoPlayer.this.f54257y);
                u uVar2 = ORExoPlayer.this.f54250r;
                long duration = uVar2 != null ? uVar2.getDuration() : 0L;
                u uVar3 = ORExoPlayer.this.f54250r;
                if (Math.abs(duration - (uVar3 != null ? uVar3.getCurrentPosition() : 0L)) < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    Log.e("ORExoPlayer", "onIsPlayingChanged onCompletion");
                    if (!ORExoPlayer.this.f54249q) {
                        ORExoPlayer.this.f54249q = true;
                        CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList3 = ORExoPlayer.this.f54255w;
                        ORExoPlayer oRExoPlayer3 = ORExoPlayer.this;
                        for (com.transsion.player.orplayer.e eVar4 : copyOnWriteArrayList3) {
                            if (eVar4 != null) {
                                eVar4.onCompletion(oRExoPlayer3.f54241i);
                            }
                        }
                    }
                }
            }
            Log.e("ORExoPlayer", "onIsPlayingChanged:" + z11);
        }

        @Override // androidx.media3.common.h0.d
        public void onLoadingChanged(boolean z11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onMediaItemTransition(b0 b0Var, int i11) {
            b0.h hVar;
            Log.e("ORExoPlayer", "onMediaItemTransition  reason:" + i11 + " ");
            if (i11 == 0 || i11 == 1) {
                for (com.transsion.player.orplayer.e eVar : ORExoPlayer.this.f54255w) {
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
            Log.e("ORExoPlayer", "onPlaybackStateChanged  playbackState:" + i11 + " ");
            if (i11 == 2) {
                Log.e("ORExoPlayer", "onPlaybackStateChanged STATE_BUFFERING");
                CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList = ORExoPlayer.this.f54255w;
                ORExoPlayer oRExoPlayer = ORExoPlayer.this;
                for (com.transsion.player.orplayer.e eVar : copyOnWriteArrayList) {
                    if (eVar != null) {
                        eVar.onLoadingBegin(oRExoPlayer.f54241i);
                    }
                }
            } else if (i11 == 3) {
                if (!ORExoPlayer.this.f54236c) {
                    ORExoPlayer.this.f54236c = true;
                    ORExoPlayer.h(ORExoPlayer.this);
                    CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList2 = ORExoPlayer.this.f54255w;
                    ORExoPlayer oRExoPlayer2 = ORExoPlayer.this;
                    for (com.transsion.player.orplayer.e eVar2 : copyOnWriteArrayList2) {
                        if (eVar2 != null) {
                            eVar2.onPrepare(oRExoPlayer2.f54241i);
                        }
                    }
                    ORExoPlayer.this.K();
                }
                if (this.f54262a == 2) {
                    for (com.transsion.player.orplayer.e listener : ORExoPlayer.this.f54255w) {
                        if (listener != null) {
                            Intrinsics.f(listener, "listener");
                            com.transsion.player.orplayer.e.a.k(listener, null, 1, null);
                        }
                    }
                }
            } else if (i11 == 4 && !ORExoPlayer.this.f54249q) {
                ORExoPlayer.this.f54249q = true;
                CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList3 = ORExoPlayer.this.f54255w;
                ORExoPlayer oRExoPlayer3 = ORExoPlayer.this;
                for (com.transsion.player.orplayer.e eVar3 : copyOnWriteArrayList3) {
                    if (eVar3 != null) {
                        eVar3.onCompletion(oRExoPlayer3.f54241i);
                    }
                }
            }
            this.f54262a = i11;
        }

        @Override // androidx.media3.common.h0.d
        public void onPlaybackSuppressionReasonChanged(int i11) {
        }

        @Override // androidx.media3.common.h0.d
        public void onPlayerError(PlaybackException error) {
            MediaSource mediaSource;
            Throwable cause;
            Intrinsics.g(error, "error");
            ORExoPlayer.this.f54236c = false;
            if ((error instanceof ExoPlaybackException) && (cause = error.getCause()) != null) {
                ORExoPlayer oRExoPlayer = ORExoPlayer.this;
                if ((cause instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) cause).responseCode == 404) {
                    long duration = oRExoPlayer.getDuration();
                    long currentPosition = oRExoPlayer.getCurrentPosition();
                    if (currentPosition > 0 && duration > 0 && (currentPosition * 1.0f) / duration > 0.99f) {
                        if (oRExoPlayer.f54249q) {
                            return;
                        }
                        oRExoPlayer.f54249q = true;
                        for (com.transsion.player.orplayer.e eVar : oRExoPlayer.f54255w) {
                            if (eVar != null) {
                                eVar.onCompletion(oRExoPlayer.f54241i);
                            }
                        }
                        return;
                    }
                }
            }
            com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
            bVar.c("ORExoPlayer", "exo onPlayerError，MimeType:" + ORExoPlayer.this.f54251s + ", code:" + error.errorCode + ",msg:" + error.getMessage() + ", cause:" + error.getCause(), true);
            if (ORExoPlayer.this.f54252t != ORExoDecoderType.HARDWARE || (mediaSource = ORExoPlayer.this.f54241i) == null || mediaSource.l() || (error.getCause() instanceof HttpDataSource.InvalidResponseCodeException)) {
                PlayError playError = new PlayError(Integer.valueOf(error.errorCode), error.getMessage() + "|" + error.getCause());
                playError.setExoCause(error.getCause());
                ORExoPlayer.h(ORExoPlayer.this);
                for (com.transsion.player.orplayer.e listener : ORExoPlayer.this.f54255w) {
                    if (listener != null) {
                        Intrinsics.f(listener, "listener");
                        com.transsion.player.orplayer.e.a.q(listener, playError, null, 2, null);
                    }
                }
                return;
            }
            bVar.c("ORExoPlayer", "exo 硬解失败，切换到软解，MimeType:" + ORExoPlayer.this.f54251s + ", code:" + error.errorCode + ",msg:" + error.getMessage(), true);
            MediaSource mediaSourceB = ORExoPlayer.this.B();
            if (mediaSourceB != null) {
                ORExoPlayer oRExoPlayer2 = ORExoPlayer.this;
                oRExoPlayer2.setDataSource(mediaSourceB);
                oRExoPlayer2.prepare();
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
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onPositionDiscontinuity: currentWindowIndex=");
            sb2.append(i12);
            sb2.append(", currentPositionMs=");
            sb2.append(j11);
            sb2.append(", reason=");
            sb2.append(i11);
            if (i11 == 1 || i11 == 2) {
                for (com.transsion.player.orplayer.e eVar : ORExoPlayer.this.f54255w) {
                    if (eVar != null) {
                        eVar.setOnSeekCompleteListener();
                    }
                }
            }
            CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList = ORExoPlayer.this.f54255w;
            ORExoPlayer oRExoPlayer = ORExoPlayer.this;
            for (com.transsion.player.orplayer.e eVar2 : copyOnWriteArrayList) {
                if (eVar2 != null) {
                    eVar2.onProgress(j11, oRExoPlayer.f54241i);
                }
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onRenderedFirstFrame() {
            if (ORExoPlayer.this.f54237d) {
                return;
            }
            ORExoPlayer.this.f54237d = true;
            Log.e("ORExoPlayer", "onRenderedFirstFrame:");
            for (com.transsion.player.orplayer.e eVar : ORExoPlayer.this.f54255w) {
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
        public void onTracksChanged(q0 tracks) {
            Intrinsics.g(tracks, "tracks");
            for (com.transsion.player.orplayer.e eVar : ORExoPlayer.this.f54255w) {
                if (eVar != null) {
                    eVar.onTracksChange(ov.a.c(tracks));
                }
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onVideoSizeChanged(t0 videoSize) {
            Intrinsics.g(videoSize, "videoSize");
            SurfaceRenderView surfaceRenderView = ORExoPlayer.this.f54238f;
            if (surfaceRenderView != null) {
                surfaceRenderView.setVideoRotation(videoSize.f9451c);
            }
            TextureRenderView textureRenderView = ORExoPlayer.this.f54239g;
            if (textureRenderView != null) {
                textureRenderView.setVideoRotation(videoSize.f9451c);
            }
            SurfaceRenderView surfaceRenderView2 = ORExoPlayer.this.f54238f;
            if (surfaceRenderView2 != null) {
                surfaceRenderView2.setVideoSize(videoSize.f9449a, videoSize.f9450b);
            }
            TextureRenderView textureRenderView2 = ORExoPlayer.this.f54239g;
            if (textureRenderView2 != null) {
                textureRenderView2.setVideoSize(videoSize.f9449a, videoSize.f9450b);
            }
            for (com.transsion.player.orplayer.e eVar : ORExoPlayer.this.f54255w) {
                if (eVar != null) {
                    eVar.onVideoSizeChanged(videoSize.f9449a, videoSize.f9450b);
                }
            }
            Log.e("ORExoPlayer", "onVideoSizeChanged width:" + videoSize.f9449a + "  height:" + videoSize.f9450b);
        }

        @Override // androidx.media3.common.h0.d
        public void onVolumeChanged(float f11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.transsion.player.orplayer.d {
        public e() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            u uVar = ORExoPlayer.this.f54250r;
            if (uVar != null) {
                return uVar.U();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            u uVar = ORExoPlayer.this.f54250r;
            if (uVar != null) {
                uVar.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            u uVar = ORExoPlayer.this.f54250r;
            if (uVar != null) {
                uVar.play();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f11) {
            u uVar = ORExoPlayer.this.f54250r;
            if (uVar == null) {
                return;
            }
            uVar.setVolume(f11);
        }
    }

    public ORExoPlayer(Context context, f config, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(config, "config");
        this.f54234a = context;
        this.f54235b = config;
        this.f54246n = 1.0f;
        ORExoDecoderType oRExoDecoderType = ORExoDecoderType.HARDWARE;
        this.f54252t = oRExoDecoderType;
        this.f54253u = new d();
        if (z11) {
            D();
        }
        C(oRExoDecoderType);
        this.f54255w = new CopyOnWriteArrayList<>();
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.d(looperMyLooper);
        this.f54256x = new Handler(looperMyLooper);
        this.f54257y = new Runnable() { // from class: com.transsion.player.exo.b
            @Override // java.lang.Runnable
            public final void run() {
                ORExoPlayer.L(this.f54277a);
            }
        };
        this.f54258z = ScaleMode.SCALE_TO_FILL;
    }

    public /* synthetic */ ORExoPlayer(Context context, f fVar, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? g.a() : fVar, (i11 & 4) != 0 ? true : z11);
    }

    public static final androidx.media3.exoplayer.drm.c A(b0 b0Var) {
        return androidx.media3.exoplayer.drm.c.f10292a;
    }

    private final void D() {
        this.f54240h = new com.transsion.player.orplayer.c(new e(), new Function1<Boolean, Unit>() { // from class: com.transsion.player.exo.ORExoPlayer$initAudioFocus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                Iterator it = this.this$0.f54255w.iterator();
                while (it.hasNext()) {
                    ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z11);
                }
            }
        });
    }

    public static final void L(ORExoPlayer this$0) {
        Intrinsics.g(this$0, "this$0");
        u uVar = this$0.f54250r;
        if (uVar == null || uVar.isPlaying()) {
            u uVar2 = this$0.f54250r;
            long currentPosition = uVar2 != null ? uVar2.getCurrentPosition() : 0L;
            Iterator<T> it = this$0.f54255w.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onProgress(currentPosition, this$0.f54241i);
            }
            this$0.I();
        }
    }

    public static final /* synthetic */ com.transsion.player.orplayer.global.d h(ORExoPlayer oRExoPlayer) {
        oRExoPlayer.getClass();
        return null;
    }

    public final MediaSource B() {
        MediaSource mediaSource = this.f54241i;
        String str = this.f54251s;
        F();
        ORExoDecoderType oRExoDecoderType = Intrinsics.b(str, "video/av01") ? ORExoDecoderType.AV1 : ORExoDecoderType.FFMPEG;
        this.f54252t = oRExoDecoderType;
        com.transsion.player.utils.b.f54866a.a("ORExoPlayer", "重新创建播放器切换编码, DecoderType:" + oRExoDecoderType + ",MimeTyp:" + str, true);
        C(this.f54252t);
        E();
        return mediaSource;
    }

    public final void C(ORExoDecoderType oRExoDecoderType) {
        com.transsion.player.utils.b.f54866a.a("ORExoPlayer", "createPlayer, DecoderType:" + oRExoDecoderType, true);
        this.f54254v = com.transsion.player.exo.a.b(this.f54234a, oRExoDecoderType);
        u.b bVarN = new u.b(this.f54234a).n(new androidx.media3.exoplayer.source.d(this.f54234a).q(com.transsion.player.exo.a.d(this.f54234a)));
        a3 a3Var = this.f54254v;
        Intrinsics.d(a3Var);
        u uVarG = bVarN.o(a3Var).g();
        uVarG.setPlayWhenReady(false);
        uVarG.K(this.f54253u);
        uVarG.L(new c());
        this.f54250r = uVarG;
    }

    public final void E() {
        setMute(this.f54245m);
        Float f11 = this.f54242j;
        if (f11 != null) {
            setVolume(f11.floatValue());
        }
        setLooping(this.f54244l);
        setAutoPlay(this.f54243k);
        setSpeed(this.f54246n);
        SurfaceRenderView surfaceRenderView = this.f54238f;
        if (surfaceRenderView != null) {
            setSurfaceView(surfaceRenderView);
        }
        TextureRenderView textureRenderView = this.f54239g;
        if (textureRenderView != null) {
            setTextureView(textureRenderView);
        }
        setScaleMode(this.f54258z);
    }

    public final void F() {
        this.f54236c = false;
        this.f54249q = false;
        this.f54237d = false;
        Log.e("ORExoPlayer", "innerRelease");
        if (com.transsion.player.orplayer.global.f.f54733a.a(this)) {
            u uVar = this.f54250r;
            if (uVar != null) {
                uVar.release();
                return;
            }
            return;
        }
        u uVar2 = this.f54250r;
        if (uVar2 != null) {
            uVar2.stop();
        }
        u uVar3 = this.f54250r;
        if (uVar3 != null) {
            uVar3.C();
        }
        u uVar4 = this.f54250r;
        if (uVar4 != null) {
            uVar4.clearVideoSurface();
        }
    }

    public final boolean G(MediaSource mediaSource) {
        PlayMimeType playMimeTypeI = mediaSource.i();
        PlayMimeType playMimeType = PlayMimeType.RTMP;
        if (playMimeTypeI == playMimeType) {
            return true;
        }
        String lowerCase = mediaSource.j().toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (!l.L(lowerCase, "rtmp://", false, 2, null)) {
            return false;
        }
        mediaSource.p(playMimeType);
        return true;
    }

    public final boolean H(MediaSource mediaSource) {
        PlayMimeType playMimeTypeI = mediaSource.i();
        PlayMimeType playMimeType = PlayMimeType.DASH;
        if (playMimeTypeI != playMimeType) {
            PlayMimeType playMimeTypeI2 = mediaSource.i();
            PlayMimeType playMimeType2 = PlayMimeType.HLS;
            if (playMimeTypeI2 != playMimeType2) {
                if (StringsKt__StringsKt.Q(mediaSource.j(), ".mpd", false, 2, null)) {
                    mediaSource.p(playMimeType);
                    return true;
                }
                if (!StringsKt__StringsKt.Q(mediaSource.j(), ".m3u8", false, 2, null)) {
                    return false;
                }
                mediaSource.p(playMimeType2);
                return true;
            }
        }
        return true;
    }

    public final void I() {
        this.f54256x.removeCallbacks(this.f54257y);
        this.f54256x.postDelayed(this.f54257y, 500L);
    }

    public final void J(e4.c.a aVar, q0 q0Var) {
        int size = q0Var.a().size();
        for (int i11 = 0; i11 < size; i11++) {
            q0.a aVar2 = q0Var.a().get(i11);
            Intrinsics.f(aVar2, "tracks.groups[groupIndex]");
            q0.a aVar3 = aVar2;
            int i12 = aVar3.f9435a;
            for (int i13 = 0; i13 < i12; i13++) {
                y yVarB = aVar3.b(i13);
                Intrinsics.f(yVarB, "trackGroup.getTrackFormat(index)");
                com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
                com.transsion.player.utils.b.i(bVar, "ORExoPlayer", "onGetTracksInfo  MimeType:" + yVarB.f9501m + "， bitrate：" + yVarB.f9497i, false, 4, null);
                String str = yVarB.f9501m;
                if (str != null && StringsKt__StringsKt.Q(str, "video", false, 2, null)) {
                    String str2 = yVarB.f9501m;
                    this.f54251s = str2;
                    com.transsion.player.utils.b.f(bVar, "ORExoPlayer", "--------onGetTracksInfo curVideoMimeType:" + str2, false, 4, null);
                }
            }
        }
        if (this.f54252t == ORExoDecoderType.AV1 || !Intrinsics.b(this.f54251s, "video/av01") || Build.VERSION.SDK_INT > 29) {
            return;
        }
        com.transsion.player.utils.b.f54866a.c("ORExoPlayer", "exo av1，强制切换到软解， MimeType:" + this.f54251s, true);
        MediaSource mediaSourceB = B();
        if (mediaSourceB != null) {
            setDataSource(mediaSourceB);
            prepare();
        }
    }

    public final void K() {
        q0 currentTracks;
        u uVar;
        y yVarQ;
        y yVarA;
        u uVar2 = this.f54250r;
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
                    u uVar3 = this.f54250r;
                    if (uVar3 != null && (yVarA = uVar3.a()) != null) {
                        int i14 = yVarA.f9497i;
                        int i15 = yVarB.f9497i;
                        if (i14 == i15) {
                            this.f54247o = i15;
                            com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, "ORExoPlayer", "--onPrepare2GetBitrate  MimeType:" + yVarB.f9501m + "，videoBitrate：" + i15, false, 4, null);
                            Iterator<T> it = this.f54255w.iterator();
                            while (it.hasNext()) {
                                ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(this.f54247o);
                            }
                        }
                    }
                } else if (f0.o(yVarB.f9501m) && (uVar = this.f54250r) != null && (yVarQ = uVar.Q()) != null) {
                    int i16 = yVarQ.f9497i;
                    int i17 = yVarB.f9497i;
                    if (i16 == i17) {
                        this.f54248p = i17;
                        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, "ORExoPlayer", "--onPrepare2GetBitrate  MimeType:" + yVarB.f9501m + "，audioBitrate：" + i17, false, 4, null);
                        Iterator<T> it2 = this.f54255w.iterator();
                        while (it2.hasNext()) {
                            ((com.transsion.player.orplayer.e) it2.next()).onTracksAudioBitrateChange(this.f54248p);
                        }
                    }
                }
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(MediaSource mediaSource) {
        return com.transsion.player.orplayer.f.b.a(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        com.transsion.player.orplayer.f.b.b(this, listener);
        if (this.f54255w.contains(listener)) {
            return;
        }
        this.f54255w.add(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(ov.d mediaTrackGroup, int i11) {
        q0 currentTracks;
        n0 n0VarA;
        Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        try {
            Result.Companion companion = Result.Companion;
            this.f54247o = mediaTrackGroup.b()[i11].a();
            Iterator<T> it = this.f54255w.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(this.f54247o);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        int i12 = this.f54247o;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("changeTrackSelection  mediaTrackGroup:");
        sb2.append(mediaTrackGroup);
        sb2.append("  index:");
        sb2.append(i11);
        sb2.append(", videoBitrate:");
        sb2.append(i12);
        u uVar = this.f54250r;
        if (uVar == null || (currentTracks = uVar.getCurrentTracks()) == null || (n0VarA = ov.a.a(currentTracks, mediaTrackGroup)) == null) {
            return;
        }
        u uVar2 = this.f54250r;
        Intrinsics.d(uVar2);
        u uVar3 = this.f54250r;
        Intrinsics.d(uVar3);
        uVar2.T(uVar3.m().a().H(new o0(n0VarA, i11)).C());
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        SurfaceTexture surfaceTexture;
        SurfaceHolder holder;
        Surface surface;
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.setVideoSurfaceView(null);
        }
        u uVar2 = this.f54250r;
        if (uVar2 != null) {
            uVar2.setVideoTextureView(null);
        }
        SurfaceRenderView surfaceRenderView = this.f54238f;
        if (surfaceRenderView != null && (holder = surfaceRenderView.getHolder()) != null && (surface = holder.getSurface()) != null) {
            surface.release();
        }
        TextureRenderView textureRenderView = this.f54239g;
        if (textureRenderView == null || (surfaceTexture = textureRenderView.getSurfaceTexture()) == null) {
            return;
        }
        surfaceTexture.release();
    }

    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        return this.f54241i;
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z11) {
        if (!z11 && this.f54252t == ORExoDecoderType.HARDWARE) {
            com.transsion.player.utils.b.f54866a.a("ORExoPlayer", "1-硬解切到软解，重新创建设置", true);
            B();
        } else if (z11) {
            ORExoDecoderType oRExoDecoderType = this.f54252t;
            ORExoDecoderType oRExoDecoderType2 = ORExoDecoderType.HARDWARE;
            if (oRExoDecoderType != oRExoDecoderType2) {
                this.f54252t = oRExoDecoderType2;
                com.transsion.player.utils.b.f54866a.a("ORExoPlayer", "2-软解切换到硬解，重新创建设置", true);
                C(this.f54252t);
                E();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        return new Pair<>(Integer.valueOf(this.f54247o), Integer.valueOf(this.f54248p));
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        u uVar = this.f54250r;
        if (uVar != null) {
            return uVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        q0 currentTracks;
        ov.c cVarC;
        u uVar = this.f54250r;
        return (uVar == null || (currentTracks = uVar.getCurrentTracks()) == null || (cVarC = ov.a.c(currentTracks)) == null) ? new ov.c(null, 1, null) : cVarC;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.b getCurrentVideoFormat() {
        y yVarA;
        u uVar = this.f54250r;
        if (uVar == null || (yVarA = uVar.a()) == null) {
            return null;
        }
        return ov.a.b(yVarA);
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        return com.transsion.player.orplayer.f.b.j(this);
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        u uVar = this.f54250r;
        if (uVar != null) {
            return uVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        return com.transsion.player.orplayer.f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        return com.transsion.player.orplayer.f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        return this.f54242j;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        u uVar = this.f54250r;
        return uVar != null && uVar.getPlaybackState() == 4;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return com.transsion.player.orplayer.f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        u uVar = this.f54250r;
        if (uVar != null) {
            return uVar.U();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        u uVar = this.f54250r;
        if (uVar != null) {
            return uVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        u uVar = this.f54250r;
        return uVar != null && uVar.getPlaybackState() == 3;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.f54240h;
        if (cVar != null) {
            cVar.g(true);
        }
        Log.e("ORExoPlayer", "pause");
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.pause();
        }
        u uVar2 = this.f54250r;
        if (uVar2 != null) {
            uVar2.getPlayWhenReady();
        }
        com.transsion.player.orplayer.c cVar2 = this.f54240h;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        u uVar;
        Log.e("ORExoPlayer", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        u uVar2 = this.f54250r;
        if ((uVar2 != null ? uVar2.c() : null) != null && (uVar = this.f54250r) != null) {
            uVar.prepare();
        }
        u uVar3 = this.f54250r;
        if (uVar3 != null) {
            uVar3.play();
        }
        com.transsion.player.orplayer.c cVar = this.f54240h;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.f54240h;
        if (cVar2 != null) {
            cVar2.e();
        }
        this.f54249q = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        Log.e("ORExoPlayer", "prepare");
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.prepare();
        }
        this.f54249q = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        this.f54236c = false;
        this.f54249q = false;
        this.f54237d = false;
        Log.e("ORExoPlayer", "release");
        if (com.transsion.player.orplayer.global.f.f54733a.a(this)) {
            u uVar = this.f54250r;
            if (uVar != null) {
                uVar.release();
            }
        } else {
            u uVar2 = this.f54250r;
            if (uVar2 != null) {
                uVar2.stop();
            }
            u uVar3 = this.f54250r;
            if (uVar3 != null) {
                uVar3.C();
            }
            u uVar4 = this.f54250r;
            if (uVar4 != null) {
                uVar4.clearVideoSurface();
            }
        }
        for (com.transsion.player.orplayer.e eVar : this.f54255w) {
            if (eVar != null) {
                eVar.onPlayerRelease(this.f54241i);
            }
        }
        com.transsion.player.orplayer.c cVar = this.f54240h;
        if (cVar != null) {
            cVar.b();
        }
        this.f54251s = null;
        this.f54252t = ORExoDecoderType.HARDWARE;
        this.f54241i = null;
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        com.transsion.player.orplayer.f.b.o(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(MediaSource mediaSource) {
        return com.transsion.player.orplayer.f.b.p(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        com.transsion.player.orplayer.f.b.q(this, listener);
        this.f54255w.remove(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return com.transsion.player.orplayer.f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        Log.e("ORExoPlayer", "reset    ");
        this.f54236c = false;
        this.f54249q = false;
        this.f54237d = false;
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.stop();
        }
        u uVar2 = this.f54250r;
        if (uVar2 != null) {
            uVar2.C();
        }
        this.f54252t = ORExoDecoderType.HARDWARE;
        this.f54241i = null;
        for (com.transsion.player.orplayer.e eVar : this.f54255w) {
            if (eVar != null) {
                eVar.onPlayerReset();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j11) {
        u uVar;
        Log.e("ORExoPlayer", "seekTo    mills:" + j11);
        u uVar2 = this.f54250r;
        if ((uVar2 != null ? uVar2.c() : null) != null && (uVar = this.f54250r) != null) {
            uVar.prepare();
        }
        u uVar3 = this.f54250r;
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
        com.transsion.player.orplayer.f.b.s(this, uuid, j11);
        u uVar2 = this.f54250r;
        int iF = uVar2 != null ? uVar2.F() : 0;
        for (int i11 = 0; i11 < iF; i11++) {
            u uVar3 = this.f54250r;
            if (Intrinsics.b((uVar3 == null || (b0VarN = uVar3.N(i11)) == null || (hVar = b0VarN.f8951b) == null) ? null : hVar.f9051e, uuid)) {
                u uVar4 = this.f54250r;
                if ((uVar4 != null ? uVar4.c() : null) != null) {
                    prepare();
                }
                u uVar5 = this.f54250r;
                if (uVar5 == null || uVar5.u() != i11) {
                    Log.e("ORExoPlayer", "seekTo  index:" + i11 + " uuid:" + uuid);
                    u uVar6 = this.f54250r;
                    if (uVar6 != null) {
                        uVar6.seekTo(i11, j11);
                    }
                } else {
                    if (isComplete() && (uVar = this.f54250r) != null) {
                        uVar.seekTo(j11);
                    }
                    Log.e("ORExoPlayer", "seekTo   uuid:" + uuid + " mills:" + j11 + "  是当前视频直接播放");
                }
                play();
                return;
            }
        }
        Log.e("ORExoPlayer", "seekTo   uuid:" + uuid + " mills:" + j11 + "  没有找到");
        pause();
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z11) {
        this.f54243k = z11;
        u uVar = this.f54250r;
        if (uVar == null) {
            return;
        }
        uVar.setPlayWhenReady(z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        com.transsion.player.utils.b.f54866a.a("ORExoPlayer", "setDataSource url:" + mediaSource.j(), true);
        Iterator<T> it = this.f54255w.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onSetDataSource();
        }
        if (H(mediaSource)) {
            z(mediaSource);
            return;
        }
        if (G(mediaSource)) {
            y(mediaSource);
            return;
        }
        b0 b0VarA = new b0.c().j(mediaSource.j()).d(String.valueOf(mediaSource.k())).b(mediaSource.f()).a();
        Intrinsics.f(b0VarA, "Builder()\n            .s…key)\n            .build()");
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.H(b0VarA);
        }
        this.f54241i = mediaSource;
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z11) {
        this.f54244l = z11;
        u uVar = this.f54250r;
        if (uVar == null) {
            return;
        }
        uVar.setRepeatMode(z11 ? 1 : 0);
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        this.f54245m = z11;
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.B(z11, 1);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(iv.d dVar) {
        com.transsion.player.orplayer.f.b.w(this, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        addPlayerListener(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        RenderScaleMode renderScaleMode;
        Intrinsics.g(scaleMode, "scaleMode");
        com.transsion.player.orplayer.f.b.x(this, scaleMode);
        this.f54258z = scaleMode;
        int i11 = b.f54260b[scaleMode.ordinal()];
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
        TextureRenderView textureRenderView = this.f54239g;
        if (textureRenderView != null) {
            textureRenderView.setScaleType(renderScaleMode);
        }
        SurfaceRenderView surfaceRenderView = this.f54238f;
        if (surfaceRenderView != null) {
            surfaceRenderView.setScaleType(renderScaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f11) {
        this.f54246n = f11;
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.setPlaybackSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f54238f = surfaceView instanceof SurfaceRenderView ? (SurfaceRenderView) surfaceView : null;
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        this.f54239g = textureView instanceof TextureRenderView ? (TextureRenderView) textureView : null;
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.setVideoTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f11) {
        float fJ = kotlin.ranges.a.j(f11, 0.0f, 2.0f);
        a3 a3Var = this.f54254v;
        ORRenderersFactory oRRenderersFactory = a3Var instanceof ORRenderersFactory ? (ORRenderersFactory) a3Var : null;
        if (oRRenderersFactory != null) {
            oRRenderersFactory.o(fJ);
        }
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.setVolume(fJ);
        }
        this.f54242j = Float.valueOf(fJ);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setVolume  volume:");
        sb2.append(f11);
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        Log.e("ORExoPlayer", "stop    ");
        com.transsion.player.orplayer.c cVar = this.f54240h;
        if (cVar != null) {
            cVar.g(true);
        }
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.stop();
        }
        this.f54236c = false;
        this.f54249q = false;
        this.f54237d = false;
        com.transsion.player.orplayer.c cVar2 = this.f54240h;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final void y(MediaSource mediaSource) {
        androidx.media3.datasource.a.InterfaceC0090a factory = new RtmpDataSource.Factory();
        com.transsion.player.utils.b.f54866a.a("ORExoPlayer", "addRtmpDataSource ", true);
        q qVarC = new q.b(factory).c(b0.b(mediaSource.j()));
        Intrinsics.f(qVarC, "Factory(rtmpDataSourceFa…fromUri(mediaSource.url))");
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.S(qVarC);
        }
    }

    public final boolean z(MediaSource mediaSource) {
        androidx.media3.datasource.a.InterfaceC0090a aVar;
        androidx.media3.exoplayer.source.l.a factory;
        androidx.media3.datasource.c.b bVar;
        Intrinsics.g(mediaSource, "mediaSource");
        String strG = mediaSource.g();
        if (strG == null) {
            strG = mediaSource.j();
        }
        b0 b0VarA = new b0.c().j(strG).d(String.valueOf(mediaSource.k())).b(mediaSource.f()).h(mediaSource.e()).a();
        Intrinsics.f(b0VarA, "Builder()\n            .s….id)\n            .build()");
        if (l.L(strG, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            bVar = new androidx.media3.datasource.c.b();
            Map<String, String> mapD = mediaSource.d();
            if (mapD != null) {
                aVar = bVar;
                bVar.b(mapD);
                aVar = bVar;
            }
        } else {
            aVar = new androidx.media3.datasource.b.a(this.f54234a);
        }
        aVar = bVar;
        PlayMimeType playMimeTypeI = mediaSource.i();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dash addStreamDataSource, mimeType:");
        sb2.append(playMimeTypeI);
        int i11 = b.f54259a[mediaSource.i().ordinal()];
        if (i11 == 1) {
            factory = new DashMediaSource.Factory(aVar);
        } else {
            if (i11 != 2) {
                return false;
            }
            factory = new HlsMediaSource.Factory(aVar);
        }
        androidx.media3.exoplayer.source.l lVarC = factory.d(new i4.u() { // from class: com.transsion.player.exo.c
            @Override // i4.u
            public final androidx.media3.exoplayer.drm.c a(b0 b0Var) {
                return ORExoPlayer.A(b0Var);
            }
        }).c(b0VarA);
        u uVar = this.f54250r;
        if (uVar != null) {
            uVar.S(lVarC);
        }
        this.f54241i = mediaSource;
        return true;
    }
}
