package com.transsion.audio.player;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.CacheConfig;
import com.aliyun.player.nativeclass.TrackInfo;
import com.aliyun.player.source.UrlSource;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.p006enum.ScaleMode;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class OrAudioPlayer implements com.transsion.player.orplayer.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f50841a = "OrAudioPlayer";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AliPlayer f50842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.player.orplayer.c f50843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.player.orplayer.e f50844d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f50845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50846g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.transsion.player.orplayer.d {
        public a() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            AliPlayer aliPlayer = OrAudioPlayer.this.f50842b;
            if (aliPlayer != null) {
                return aliPlayer.isMute();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            AliPlayer aliPlayer = OrAudioPlayer.this.f50842b;
            if (aliPlayer != null) {
                aliPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            AliPlayer aliPlayer = OrAudioPlayer.this.f50842b;
            if (aliPlayer != null) {
                aliPlayer.start();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f11) {
            AliPlayer aliPlayer = OrAudioPlayer.this.f50842b;
            if (aliPlayer == null) {
                return;
            }
            aliPlayer.setVolume(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements IPlayer.OnLoadingStatusListener {
        public b() {
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            uo.b.a.f(uo.b.f78622a, OrAudioPlayer.this.f50841a, "onLoadingBegin--->", false, 4, null);
            com.transsion.player.orplayer.e eVar = OrAudioPlayer.this.f50844d;
            if (eVar != null) {
                com.transsion.player.orplayer.e.a.i(eVar, null, 1, null);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            uo.b.a.f(uo.b.f78622a, OrAudioPlayer.this.f50841a, "onLoadingEnd----->", false, 4, null);
            com.transsion.player.orplayer.e eVar = OrAudioPlayer.this.f50844d;
            if (eVar != null) {
                com.transsion.player.orplayer.e.a.k(eVar, null, 1, null);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int i11, float f11) {
            uo.b.a.f(uo.b.f78622a, OrAudioPlayer.this.f50841a, "onLoadingProgress percent:" + i11 + ",netSpeed:" + f11, false, 4, null);
            com.transsion.player.orplayer.e eVar = OrAudioPlayer.this.f50844d;
            if (eVar != null) {
                com.transsion.player.orplayer.e.a.m(eVar, i11, f11, null, 4, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements IPlayer.OnTrackChangedListener {
        @Override // com.aliyun.player.IPlayer.OnTrackChangedListener
        public void onChangedFail(TrackInfo trackInfo, ErrorInfo errorInfo) {
        }

        @Override // com.aliyun.player.IPlayer.OnTrackChangedListener
        public void onChangedSuccess(TrackInfo trackInfo) {
        }
    }

    public OrAudioPlayer(Context context) {
        n(context);
    }

    private final void n(Context context) {
        if (this.f50842b == null) {
            AliPlayer aliPlayerCreateAliPlayer = AliPlayerFactory.createAliPlayer(context);
            aliPlayerCreateAliPlayer.setTraceId(TNDeviceHelper.f49455a.g());
            this.f50842b = aliPlayerCreateAliPlayer;
            o();
            y();
            p();
        }
    }

    private final void p() {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.setOnCompletionListener(new IPlayer.OnCompletionListener() { // from class: com.transsion.audio.player.b
                @Override // com.aliyun.player.IPlayer.OnCompletionListener
                public final void onCompletion() {
                    OrAudioPlayer.q();
                }
            });
        }
        AliPlayer aliPlayer2 = this.f50842b;
        if (aliPlayer2 != null) {
            aliPlayer2.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.transsion.audio.player.c
                @Override // com.aliyun.player.IPlayer.OnErrorListener
                public final void onError(ErrorInfo errorInfo) {
                    OrAudioPlayer.r(this.f50863a, errorInfo);
                }
            });
        }
        AliPlayer aliPlayer3 = this.f50842b;
        if (aliPlayer3 != null) {
            aliPlayer3.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.transsion.audio.player.d
                @Override // com.aliyun.player.IPlayer.OnPreparedListener
                public final void onPrepared() {
                    OrAudioPlayer.s(this.f50864a);
                }
            });
        }
        AliPlayer aliPlayer4 = this.f50842b;
        if (aliPlayer4 != null) {
            aliPlayer4.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.transsion.audio.player.e
                @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
                public final void onVideoSizeChanged(int i11, int i12) {
                    OrAudioPlayer.t(this.f50865a, i11, i12);
                }
            });
        }
        AliPlayer aliPlayer5 = this.f50842b;
        if (aliPlayer5 != null) {
            aliPlayer5.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.transsion.audio.player.f
                @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
                public final void onRenderingStart() {
                    OrAudioPlayer.u(this.f50866a);
                }
            });
        }
        AliPlayer aliPlayer6 = this.f50842b;
        if (aliPlayer6 != null) {
            aliPlayer6.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.transsion.audio.player.g
                @Override // com.aliyun.player.IPlayer.OnInfoListener
                public final void onInfo(InfoBean infoBean) {
                    OrAudioPlayer.v(this.f50867a, infoBean);
                }
            });
        }
        AliPlayer aliPlayer7 = this.f50842b;
        if (aliPlayer7 != null) {
            aliPlayer7.setOnLoadingStatusListener(new b());
        }
        AliPlayer aliPlayer8 = this.f50842b;
        if (aliPlayer8 != null) {
            aliPlayer8.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.transsion.audio.player.h
                @Override // com.aliyun.player.IPlayer.OnSeekCompleteListener
                public final void onSeekComplete() {
                    OrAudioPlayer.w();
                }
            });
        }
        AliPlayer aliPlayer9 = this.f50842b;
        if (aliPlayer9 != null) {
            aliPlayer9.setOnTrackChangedListener(new c());
        }
        AliPlayer aliPlayer10 = this.f50842b;
        if (aliPlayer10 != null) {
            aliPlayer10.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.transsion.audio.player.i
                @Override // com.aliyun.player.IPlayer.OnStateChangedListener
                public final void onStateChanged(int i11) {
                    OrAudioPlayer.x(this.f50868a, i11);
                }
            });
        }
    }

    public static final void q() {
    }

    public static final void r(OrAudioPlayer this$0, ErrorInfo errorInfo) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, this$0.f50841a, "onError code:" + errorInfo.getCode() + ",msg:" + errorInfo.getMsg(), false, 4, null);
        PlayError playError = new PlayError(Integer.valueOf(errorInfo.getCode().getValue()), errorInfo.getMsg());
        com.transsion.player.orplayer.e eVar = this$0.f50844d;
        if (eVar != null) {
            com.transsion.player.orplayer.e.a.q(eVar, playError, null, 2, null);
        }
        if (errorInfo.getCode() == ErrorCode.ERROR_DECODE_AUDIO) {
            this$0.prepare();
            this$0.play();
        }
    }

    public static final void s(OrAudioPlayer this$0) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.player.orplayer.e eVar = this$0.f50844d;
        if (eVar != null) {
            com.transsion.player.orplayer.e.a.w(eVar, null, 1, null);
        }
    }

    public static final void t(OrAudioPlayer this$0, int i11, int i12) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.player.orplayer.e eVar = this$0.f50844d;
        if (eVar != null) {
            eVar.onVideoSizeChanged(i11, i12);
        }
    }

    public static final void u(OrAudioPlayer this$0) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.player.orplayer.e eVar = this$0.f50844d;
        if (eVar != null) {
            eVar.onRenderFirstFrame();
        }
    }

    public static final void v(OrAudioPlayer this$0, InfoBean infoBean) {
        Intrinsics.g(this$0, "this$0");
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            long extraValue = infoBean.getExtraValue();
            com.transsion.player.orplayer.e eVar = this$0.f50844d;
            if (eVar != null) {
                com.transsion.player.orplayer.e.a.y(eVar, extraValue, null, 2, null);
            }
        }
    }

    public static final void w() {
    }

    public static final void x(OrAudioPlayer this$0, int i11) {
        com.transsion.player.orplayer.e eVar;
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, this$0.f50841a, "setOnStateChangedListener status:" + i11, false, 4, null);
        boolean z11 = i11 == 3;
        this$0.f50845f = z11;
        com.transsion.player.orplayer.e eVar2 = this$0.f50844d;
        if (eVar2 != null) {
            eVar2.onIsPlayingChanged(z11);
        }
        this$0.f50846g = i11 == 6;
        com.transsion.player.orplayer.c cVar = this$0.f50843c;
        if (cVar != null) {
            cVar.f(this$0.f50845f);
        }
        if (i11 == 3) {
            com.transsion.player.orplayer.e eVar3 = this$0.f50844d;
            if (eVar3 != null) {
                com.transsion.player.orplayer.e.a.I(eVar3, null, 1, null);
                return;
            }
            return;
        }
        if (i11 == 4 || i11 == 5) {
            com.transsion.player.orplayer.e eVar4 = this$0.f50844d;
            if (eVar4 != null) {
                com.transsion.player.orplayer.e.a.F(eVar4, null, 1, null);
                return;
            }
            return;
        }
        if (i11 == 6 && (eVar = this$0.f50844d) != null) {
            com.transsion.player.orplayer.e.a.e(eVar, null, 1, null);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(MediaSource mediaSource) {
        return com.transsion.player.orplayer.f.b.a(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e eVar) {
        com.transsion.player.orplayer.f.b.b(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(ov.d dVar, int i11) {
        com.transsion.player.orplayer.f.b.c(this, dVar, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        com.transsion.player.orplayer.f.b.d(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.f.b.e(this);
    }

    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        return com.transsion.player.orplayer.f.b.f(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z11) {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.enableHardwareDecoder(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        return new Pair<>(0, 0);
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        return com.transsion.player.orplayer.f.b.g(this);
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        return com.transsion.player.orplayer.f.b.h(this);
    }

    @Override // com.transsion.player.orplayer.f
    public ov.b getCurrentVideoFormat() {
        return com.transsion.player.orplayer.f.b.i(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        return com.transsion.player.orplayer.f.b.j(this);
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            return aliPlayer.getDuration();
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
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            return Float.valueOf(aliPlayer.getVolume());
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        return this.f50846g;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return com.transsion.player.orplayer.f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            return aliPlayer.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        return this.f50845f;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        return com.transsion.player.orplayer.f.b.n(this);
    }

    public final void o() {
        this.f50843c = new com.transsion.player.orplayer.c(new a(), new Function1<Boolean, Unit>() { // from class: com.transsion.audio.player.OrAudioPlayer$initAudioFocus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                com.transsion.player.orplayer.e eVar = this.this$0.f50844d;
                if (eVar != null) {
                    eVar.onFocusChange(z11);
                }
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
        com.transsion.player.orplayer.c cVar = this.f50843c;
        if (cVar != null) {
            cVar.g(true);
        }
        com.transsion.player.orplayer.c cVar2 = this.f50843c;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        com.transsion.player.orplayer.c cVar;
        com.transsion.player.orplayer.e eVar = this.f50844d;
        if (eVar != null) {
            eVar.initPlayer();
        }
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        com.transsion.player.orplayer.c cVar2 = this.f50843c;
        if (cVar2 != null) {
            cVar2.g(false);
        }
        if (isMute() || (cVar = this.f50843c) == null) {
            return;
        }
        cVar.e();
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        com.transsion.player.orplayer.e eVar = this.f50844d;
        if (eVar != null) {
            com.transsion.player.orplayer.e.a.t(eVar, null, 1, null);
        }
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.release();
        }
        this.f50842b = null;
        com.transsion.player.orplayer.c cVar = this.f50843c;
        if (cVar != null) {
            cVar.b();
        }
        this.f50843c = null;
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
    public void removePlayerListener(com.transsion.player.orplayer.e eVar) {
        com.transsion.player.orplayer.f.b.q(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return com.transsion.player.orplayer.f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        com.transsion.player.orplayer.e eVar = this.f50844d;
        if (eVar != null) {
            eVar.onPlayerReset();
        }
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.reset();
        }
        com.transsion.player.orplayer.c cVar = this.f50843c;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j11) {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.setMaxAccurateSeekDelta(150000);
        }
        AliPlayer aliPlayer2 = this.f50842b;
        if (aliPlayer2 != null) {
            aliPlayer2.seekTo(j11, IPlayer.SeekMode.Accurate);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j11) {
        com.transsion.player.orplayer.f.b.s(this, str, j11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z11) {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setAutoPlay(z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        UrlSource urlSource = new UrlSource();
        urlSource.setUri(mediaSource.j());
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.setDataSource(urlSource);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z11) {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setLoop(z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        com.transsion.player.orplayer.f.b.v(this, z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(iv.d dVar) {
        com.transsion.player.orplayer.f.b.w(this, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f50844d = listener;
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        com.transsion.player.orplayer.f.b.x(this, scaleMode);
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f11) {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setSpeed(f11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f11) {
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setVolume(f11);
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        com.transsion.player.orplayer.c cVar;
        AliPlayer aliPlayer = this.f50842b;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.f50843c;
        if (cVar2 != null) {
            cVar2.g(true);
        }
        if (isMute() || (cVar = this.f50843c) == null) {
            return;
        }
        cVar.b();
    }

    public final void y() {
        if (iv.b.f67716a.c()) {
            CacheConfig cacheConfig = new CacheConfig();
            cacheConfig.mEnable = true;
            cacheConfig.mMaxDurationS = 1200L;
            File externalCacheDir = Utils.a().getExternalCacheDir();
            String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
            cacheConfig.mDir = absolutePath + File.separator + "video_cache";
            cacheConfig.mMaxSizeMB = 50;
            AliPlayer aliPlayer = this.f50842b;
            if (aliPlayer != null) {
                aliPlayer.setCacheConfig(cacheConfig);
            }
        }
    }
}
