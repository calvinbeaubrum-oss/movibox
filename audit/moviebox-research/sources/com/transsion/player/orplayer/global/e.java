package com.transsion.player.orplayer.global;

import android.app.Application;
import android.view.SurfaceView;
import android.view.TextureView;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.MediaSource;
import com.transsion.player.exo.ORExoPlayer;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p006enum.ScaleMode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class e implements com.transsion.player.orplayer.f {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f54715s = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.transsion.player.orplayer.f f54716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile MediaSource f54717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceView f54718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextureView f54719d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.player.orplayer.e f54720f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f54722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f54724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public iv.d f54725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f54726l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f54730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f54731q;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CopyOnWriteArrayList<com.transsion.player.orplayer.e> f54721g = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f54727m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f54728n = 1.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ScaleMode f54729o = ScaleMode.SCALE_ASPECT_FIT;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.transsion.player.orplayer.global.a f54732r = new com.transsion.player.orplayer.global.a();

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
        this.f54732r.a(listener);
    }

    public final void c() {
        MediaSource mediaSource = this.f54717b;
        if (mediaSource != null) {
            f();
            if (g(mediaSource)) {
                if (this.f54716a instanceof ORExoPlayer) {
                    return;
                }
                com.transsion.player.orplayer.f fVar = this.f54716a;
                if (fVar != null) {
                    fVar.release();
                }
                f fVar2 = f.f54733a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                ORExoPlayer oRExoPlayerC = fVar2.c(applicationA);
                e(oRExoPlayerC);
                this.f54716a = oRExoPlayerC;
                return;
            }
            if (this.f54716a instanceof TnAliPlayer) {
                return;
            }
            com.transsion.player.orplayer.f fVar3 = this.f54716a;
            if (fVar3 != null) {
                fVar3.release();
            }
            f fVar4 = f.f54733a;
            Application applicationA2 = Utils.a();
            Intrinsics.f(applicationA2, "getApp()");
            TnAliPlayer tnAliPlayerB = fVar4.b(applicationA2);
            e(tnAliPlayerB);
            this.f54716a = tnAliPlayerB;
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(ov.d mediaTrackGroup, int i11) {
        Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.changeTrackSelection(mediaTrackGroup, i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.clearScreen();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.clearSurfaceOnly();
        }
        this.f54718c = null;
        this.f54719d = null;
    }

    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        return this.f54717b;
    }

    public final int d() {
        return TnPlayerManager.f54684a.h();
    }

    public final void e(com.transsion.player.orplayer.f fVar) {
        if (fVar == null) {
            return;
        }
        fVar.setMute(this.f54726l);
        iv.d dVar = this.f54725k;
        if (dVar != null) {
            fVar.setPlayerConfig(dVar);
        }
        Float f11 = this.f54722h;
        if (f11 != null) {
            fVar.setVolume(f11.floatValue());
        }
        fVar.setLooping(this.f54724j);
        fVar.setAutoPlay(this.f54723i);
        fVar.setSpeed(this.f54728n);
        fVar.enableHardwareDecoder(this.f54727m);
        SurfaceView surfaceView = this.f54718c;
        if (surfaceView != null) {
            fVar.setSurfaceView(surfaceView);
        }
        TextureView textureView = this.f54719d;
        if (textureView != null) {
            fVar.setTextureView(textureView);
        }
        com.transsion.player.orplayer.e eVar = this.f54720f;
        if (eVar != null) {
            fVar.setPlayerListener(eVar);
        }
        for (com.transsion.player.orplayer.e listener : this.f54721g) {
            Intrinsics.f(listener, "listener");
            fVar.addPlayerListener(listener);
        }
        fVar.setScaleMode(this.f54729o);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z11) {
        this.f54727m = z11;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.enableHardwareDecoder(z11);
        }
    }

    public final void f() {
        this.f54730p = false;
        this.f54731q = 0L;
    }

    public final boolean g(MediaSource mediaSource) {
        return d() == 1 || mediaSource.m() || mediaSource.c();
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        Pair<Integer, Integer> bitrate;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        return (fVar == null || (bitrate = fVar.getBitrate()) == null) ? new Pair<>(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        return fVar != null ? fVar.getVideoHeight() : com.transsion.player.orplayer.f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        return fVar != null ? fVar.getVideoWidth() : com.transsion.player.orplayer.f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        return fVar != null ? fVar.isLoading() : com.transsion.player.orplayer.f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        return fVar != null ? fVar.isPrepared() : com.transsion.player.orplayer.f.b.n(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        TnPlayerManager.f54684a.k(this, this.f54717b);
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.pause();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        TnPlayerManager tnPlayerManager = TnPlayerManager.f54684a;
        tnPlayerManager.p(this, MediaItem.MUSIC_FLOAT_STATE_PLAY);
        tnPlayerManager.l(this, this.f54717b);
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.play();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        f();
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.release();
        }
        this.f54716a = null;
        this.f54720f = null;
        this.f54718c = null;
        this.f54719d = null;
        TnPlayerManager.f54684a.n(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        release();
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(MediaSource mediaSource) {
        return com.transsion.player.orplayer.f.b.p(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f54732r.d(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return com.transsion.player.orplayer.f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        f();
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.reset();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j11) {
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.seekTo(j11);
        }
        MediaSource mediaSource = this.f54717b;
        MediaItem mediaItemH = mediaSource != null ? mediaSource.h() : null;
        if (mediaItemH != null) {
            mediaItemH.setPosition(Long.valueOf(j11));
        }
        TnPlayerManager.f54684a.r(this, this.f54717b);
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String uuid, long j11) {
        Intrinsics.g(uuid, "uuid");
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.seekTo(uuid, j11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z11) {
        this.f54723i = z11;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setAutoPlay(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        TnPlayerManager.f54684a.p(this, "setDataSource");
        this.f54717b = mediaSource;
        c();
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.addPlayerListener(this.f54732r);
        }
        com.transsion.player.orplayer.f fVar2 = this.f54716a;
        if (fVar2 != null) {
            fVar2.setDataSource(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z11) {
        this.f54724j = z11;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setLooping(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        this.f54726l = z11;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setMute(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(iv.d vodConfig) {
        Intrinsics.g(vodConfig, "vodConfig");
        this.f54725k = vodConfig;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setPlayerConfig(vodConfig);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f54720f = listener;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setPlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.g(scaleMode, "scaleMode");
        this.f54729o = scaleMode;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f11) {
        this.f54728n = f11;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f54719d = null;
        this.f54718c = surfaceView;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        this.f54718c = null;
        this.f54719d = textureView;
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f11) {
        this.f54722h = Float.valueOf(f11);
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.setVolume(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        f();
        com.transsion.player.orplayer.f fVar = this.f54716a;
        if (fVar != null) {
            fVar.stop();
        }
    }
}
