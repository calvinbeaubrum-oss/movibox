package com.transsion.player.ui.longvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.transsion.player.MediaSource;
import com.transsion.player.helper.c;
import com.transsion.player.helper.g;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ov.b;
import ov.d;

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
public final class ORLongVodPlayerView extends FrameLayout implements com.transsion.player.ui.longvideo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.transsion.player.ui.longvideo.a.b f54844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f54845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public iv.a f54846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f54847d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f54848f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f54849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f54850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f54851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f54852d;

        public a() {
        }

        @Override // com.transsion.player.helper.c.a
        public void a() {
            com.transsion.player.ui.longvideo.a.b bVar = ORLongVodPlayerView.this.f54844a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.transsion.player.helper.c.a
        public void b(float f11, float f12) {
            com.transsion.player.ui.longvideo.a.b bVar = ORLongVodPlayerView.this.f54844a;
            if (bVar != null) {
                bVar.b(f11, f12);
            }
        }

        @Override // com.transsion.player.helper.c.a
        public void c(float f11, float f12) {
            g gVar = null;
            if (!this.f54850b) {
                g gVar2 = ORLongVodPlayerView.this.f54848f;
                if (gVar2 == null) {
                    Intrinsics.y("volumeControl");
                    gVar2 = null;
                }
                gVar2.f(false);
                g gVar3 = ORLongVodPlayerView.this.f54848f;
                if (gVar3 == null) {
                    Intrinsics.y("volumeControl");
                    gVar3 = null;
                }
                this.f54852d = gVar3.b();
                this.f54850b = true;
            }
            float height = ((f11 - f12) * 2) / ORLongVodPlayerView.this.getHeight();
            g gVar4 = ORLongVodPlayerView.this.f54848f;
            if (gVar4 == null) {
                Intrinsics.y("volumeControl");
            } else {
                gVar = gVar4;
            }
            gVar.a(this.f54852d, height);
        }

        @Override // com.transsion.player.helper.c.a
        public void d(float f11, float f12) {
            g gVar = null;
            if (!this.f54849a) {
                g gVar2 = ORLongVodPlayerView.this.f54848f;
                if (gVar2 == null) {
                    Intrinsics.y("volumeControl");
                    gVar2 = null;
                }
                gVar2.f(false);
                g gVar3 = ORLongVodPlayerView.this.f54848f;
                if (gVar3 == null) {
                    Intrinsics.y("volumeControl");
                    gVar3 = null;
                }
                this.f54851c = gVar3.c();
                this.f54849a = true;
            }
            g gVar4 = ORLongVodPlayerView.this.f54848f;
            if (gVar4 == null) {
                Intrinsics.y("volumeControl");
            } else {
                gVar = gVar4;
            }
            gVar.d(f11, f12, ORLongVodPlayerView.this.getHeight());
        }

        @Override // com.transsion.player.helper.c.a
        public void e() {
            com.transsion.player.ui.longvideo.a.b bVar = ORLongVodPlayerView.this.f54844a;
            if (bVar != null) {
                bVar.c();
            }
            this.f54849a = false;
            this.f54850b = false;
        }

        @Override // com.transsion.player.helper.c.a
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            com.transsion.player.ui.longvideo.a.b bVar = ORLongVodPlayerView.this.f54844a;
            if (bVar != null) {
                bVar.onDoubleTap(e11);
            }
        }

        @Override // com.transsion.player.helper.c.a
        public void onLongPress(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            com.transsion.player.ui.longvideo.a.b bVar = ORLongVodPlayerView.this.f54844a;
            if (bVar != null) {
                bVar.onLongPress(e11);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ORLongVodPlayerView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ORLongVodPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ORLongVodPlayerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        c(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(MediaSource mediaSource) {
        return com.transsion.player.ui.longvideo.a.C0584a.a(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.addPlayerListener(listener);
        }
    }

    public final void c(View view) {
        g.a aVar = g.f54361a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        this.f54848f = aVar.a(context, this);
        c cVar = new c(getContext(), view);
        this.f54847d = cVar;
        cVar.s(new a());
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(d mediaTrackGroup, int i11) {
        Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.changeTrackSelection(mediaTrackGroup, i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        com.transsion.player.ui.longvideo.a.C0584a.b(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.clearSurfaceOnly();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        return com.transsion.player.ui.longvideo.a.C0584a.c(this);
    }

    @Override // com.transsion.player.ui.longvideo.a
    public void enableGesture(boolean z11) {
        c cVar = this.f54847d;
        if (cVar == null) {
            Intrinsics.y("gestureControl");
            cVar = null;
        }
        cVar.l(z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z11) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.enableHardwareDecoder(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        Pair<Integer, Integer> bitrate;
        f fVar = this.f54845b;
        return (fVar == null || (bitrate = fVar.getBitrate()) == null) ? new Pair<>(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public b getCurrentVideoFormat() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.ui.longvideo.a
    public f getOrPlayer() {
        return this.f54845b;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        return com.transsion.player.ui.longvideo.a.C0584a.d(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        return com.transsion.player.ui.longvideo.a.C0584a.e(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.ui.longvideo.a
    public void initLongVodPlayer(iv.a config, ORPlayerView playerView) {
        Intrinsics.g(config, "config");
        Intrinsics.g(playerView, "playerView");
        this.f54846c = config;
        f fVarI = TnPlayerManager.f54684a.i();
        fVarI.setSpeed(config.b());
        fVarI.setScaleMode(config.a());
        fVarI.setPlayerConfig(config.d());
        fVarI.setVolume(1.0f);
        if (config.c()) {
            fVarI.setSurfaceView(playerView.getSurface());
        } else {
            fVarI.setTextureView(playerView.getTextureView());
        }
        this.f54845b = fVarI;
        g gVar = this.f54848f;
        if (gVar == null) {
            Intrinsics.y("volumeControl");
            gVar = null;
        }
        gVar.e(this.f54845b);
        addView(playerView, 0);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return com.transsion.player.ui.longvideo.a.C0584a.f(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        return com.transsion.player.ui.longvideo.a.C0584a.g(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFocusableInTouchMode(true);
        requestFocus();
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.pause();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.play();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.release();
        }
        if (getChildAt(0) instanceof ORPlayerView) {
            removeViewAt(0);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        com.transsion.player.ui.longvideo.a.C0584a.h(this, str);
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.release(str);
        }
        if (getChildAt(0) instanceof ORPlayerView) {
            removeViewAt(0);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(MediaSource mediaSource) {
        return com.transsion.player.ui.longvideo.a.C0584a.i(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.removePlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        f fVar = this.f54845b;
        if (fVar != null) {
            return fVar.requestForce();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.reset();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j11) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.seekTo(j11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j11) {
        com.transsion.player.ui.longvideo.a.C0584a.j(this, str, j11);
    }

    public void seekToDefaultPosition() {
        com.transsion.player.ui.longvideo.a.C0584a.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z11) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setAutoPlay(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setDataSource(mediaSource);
        }
    }

    public void setErrorInterceptor(com.transsion.player.orplayer.global.d dVar) {
        com.transsion.player.ui.longvideo.a.C0584a.l(this, dVar);
    }

    @Override // com.transsion.player.ui.longvideo.a
    public void setExistPlayer(iv.a config, f orPlayer, ORPlayerView playerView) {
        Intrinsics.g(config, "config");
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(playerView, "playerView");
        this.f54845b = orPlayer;
        if (config.c()) {
            orPlayer.setSurfaceView(playerView.getSurface());
        } else {
            orPlayer.setTextureView(playerView.getTextureView());
        }
        g gVar = this.f54848f;
        if (gVar == null) {
            Intrinsics.y("volumeControl");
            gVar = null;
        }
        gVar.e(orPlayer);
        addView(playerView, 0);
    }

    @Override // com.transsion.player.ui.longvideo.a
    public void setGestureListener(com.transsion.player.ui.longvideo.a.b listener) {
        Intrinsics.g(listener, "listener");
        this.f54844a = listener;
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z11) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setLooping(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        com.transsion.player.ui.longvideo.a.C0584a.m(this, z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(iv.d dVar) {
        com.transsion.player.ui.longvideo.a.C0584a.n(this, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setPlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.g(scaleMode, "scaleMode");
        com.transsion.player.ui.longvideo.a.C0584a.o(this, scaleMode);
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f11) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f11) {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.setVolume(f11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        f fVar = this.f54845b;
        if (fVar != null) {
            fVar.stop();
        }
    }
}
