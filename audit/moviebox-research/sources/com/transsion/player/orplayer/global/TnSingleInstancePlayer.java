package com.transsion.player.orplayer.global;

import android.view.SurfaceView;
import android.view.TextureView;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p006enum.ScaleMode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TnSingleInstancePlayer implements com.transsion.player.orplayer.f {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f54696p = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.transsion.player.orplayer.f f54697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile MediaSource f54698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceView f54699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextureView f54700d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.player.orplayer.e f54701f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f54703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54704i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f54705j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public iv.d f54706k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f54707l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CopyOnWriteArrayList<com.transsion.player.orplayer.e> f54702g = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f54708m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f54709n = 1.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ScaleMode f54710o = ScaleMode.SCALE_ASPECT_FIT;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(MediaSource mediaSource) {
        return com.transsion.player.orplayer.f.b.a(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        if (this.f54702g.contains(listener)) {
            return;
        }
        this.f54702g.add(listener);
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.addPlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(ov.d mediaTrackGroup, int i11) {
        Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.changeTrackSelection(mediaTrackGroup, i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.clearScreen();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.clearSurfaceOnly();
        }
        this.f54699c = null;
        this.f54700d = null;
    }

    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        return this.f54698b;
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z11) {
        this.f54708m = z11;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.enableHardwareDecoder(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        Pair<Integer, Integer> bitrate;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        return (fVar == null || (bitrate = fVar.getBitrate()) == null) ? new Pair<>(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        return fVar != null ? fVar.getVideoHeight() : com.transsion.player.orplayer.f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        return fVar != null ? fVar.getVideoWidth() : com.transsion.player.orplayer.f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        return fVar != null ? fVar.isLoading() : com.transsion.player.orplayer.f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        return fVar != null ? fVar.isPrepared() : com.transsion.player.orplayer.f.b.n(this);
    }

    public final com.transsion.player.orplayer.f p() {
        return this.f54697a;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        TnPlayerManager.f54684a.k(this, this.f54698b);
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.pause();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        TnPlayerManager tnPlayerManager = TnPlayerManager.f54684a;
        tnPlayerManager.l(this, this.f54698b);
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            tnPlayerManager.p(fVar, MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        com.transsion.player.orplayer.f fVar2 = this.f54697a;
        if (fVar2 != null) {
            fVar2.play();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.prepare();
        }
    }

    public final void q(boolean z11) {
        com.transsion.player.orplayer.e eVar = this.f54701f;
        if (eVar != null) {
            eVar.onFocusChange(z11);
        }
    }

    public final void r(com.transsion.player.orplayer.f fVar) {
        this.f54697a = fVar;
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.release();
        }
        this.f54697a = null;
        this.f54701f = null;
        this.f54699c = null;
        this.f54700d = null;
        TnPlayerManager.f54684a.n(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        if (str != null && str.length() != 0) {
            MediaSource mediaSource = this.f54698b;
            if (!Intrinsics.b(mediaSource != null ? mediaSource.e() : null, str)) {
                return;
            }
        }
        release();
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(MediaSource mediaSource) {
        return com.transsion.player.orplayer.f.b.p(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f54702g.remove(listener);
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.removePlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        if (this.f54697a != null) {
            return false;
        }
        TnPlayerManager.f54684a.q(this);
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar == null) {
            return true;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnSingleInstancePlayer$requestForce$1$action$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.transsion.player.orplayer.f fVarP = this.this$0.p();
                if (fVarP != null) {
                    TnSingleInstancePlayer tnSingleInstancePlayer = this.this$0;
                    fVarP.stop();
                    fVarP.reset();
                    fVarP.enableHardwareDecoder(tnSingleInstancePlayer.f54708m);
                    iv.d dVar = tnSingleInstancePlayer.f54706k;
                    if (dVar != null) {
                        fVarP.setPlayerConfig(dVar);
                    }
                    fVarP.setMute(tnSingleInstancePlayer.f54707l);
                    Float f11 = tnSingleInstancePlayer.f54703h;
                    if (f11 != null) {
                        fVarP.setVolume(f11.floatValue());
                    }
                    fVarP.setSpeed(tnSingleInstancePlayer.f54709n);
                    fVarP.setLooping(tnSingleInstancePlayer.f54705j);
                    fVarP.setAutoPlay(tnSingleInstancePlayer.f54704i);
                    if (tnSingleInstancePlayer.f54699c != null) {
                        fVarP.setSurfaceView(tnSingleInstancePlayer.f54699c);
                    }
                    if (tnSingleInstancePlayer.f54700d != null) {
                        fVarP.setTextureView(tnSingleInstancePlayer.f54700d);
                    }
                    com.transsion.player.orplayer.e eVar = tnSingleInstancePlayer.f54701f;
                    if (eVar != null) {
                        fVarP.setPlayerListener(eVar);
                    }
                    for (com.transsion.player.orplayer.e listener : tnSingleInstancePlayer.f54702g) {
                        Intrinsics.f(listener, "listener");
                        fVarP.addPlayerListener(listener);
                    }
                    fVarP.setScaleMode(tnSingleInstancePlayer.f54710o);
                    MediaSource mediaSource = tnSingleInstancePlayer.f54698b;
                    if (mediaSource != null) {
                        fVarP.setDataSource(mediaSource);
                    }
                }
            }
        };
        if (fVar instanceof TnAliPlayer) {
            ((TnAliPlayer) fVar).t(function0);
            return true;
        }
        function0.invoke();
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.reset();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j11) {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.seekTo(j11);
        }
        MediaSource mediaSource = this.f54698b;
        MediaItem mediaItemH = mediaSource != null ? mediaSource.h() : null;
        if (mediaItemH != null) {
            mediaItemH.setPosition(Long.valueOf(j11));
        }
        TnPlayerManager.f54684a.r(this, this.f54698b);
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String uuid, long j11) {
        Intrinsics.g(uuid, "uuid");
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.seekTo(uuid, j11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z11) {
        this.f54704i = z11;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setAutoPlay(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(MediaSource mediaSource) {
        com.transsion.player.orplayer.f fVar;
        Intrinsics.g(mediaSource, "mediaSource");
        this.f54698b = mediaSource;
        com.transsion.player.orplayer.f fVar2 = this.f54697a;
        if (fVar2 != null) {
            TnPlayerManager.f54684a.p(fVar2, "setDataSource");
        }
        if (requestForce() || (fVar = this.f54697a) == null) {
            return;
        }
        fVar.setDataSource(mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z11) {
        this.f54705j = z11;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setLooping(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        this.f54707l = z11;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setMute(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(iv.d vodConfig) {
        Intrinsics.g(vodConfig, "vodConfig");
        this.f54706k = vodConfig;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setPlayerConfig(vodConfig);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f54701f = listener;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setPlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.g(scaleMode, "scaleMode");
        this.f54710o = scaleMode;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f11) {
        this.f54709n = f11;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f54700d = null;
        this.f54699c = surfaceView;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        this.f54699c = null;
        this.f54700d = textureView;
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f11) {
        this.f54703h = Float.valueOf(f11);
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.setVolume(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        com.transsion.player.orplayer.f fVar = this.f54697a;
        if (fVar != null) {
            fVar.stop();
        }
    }
}
