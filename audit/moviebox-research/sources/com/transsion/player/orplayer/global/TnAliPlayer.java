package com.transsion.player.orplayer.global;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.p006enum.ScaleMode;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class TnAliPlayer implements com.transsion.player.orplayer.f, com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f54673k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Thread.UncaughtExceptionHandler f54674l = new Thread.UncaughtExceptionHandler() { // from class: com.transsion.player.orplayer.global.c
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th2) {
            TnAliPlayer.s(thread, th2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f54675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f54676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.player.orplayer.f f54677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f54678d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile com.transsion.player.orplayer.e f54679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CopyOnWriteArrayList<com.transsion.player.orplayer.e> f54680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile MediaSource f54681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f54682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f54683j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TnAliPlayer a() {
            return new TnAliPlayer(null);
        }
    }

    public TnAliPlayer() {
        this.f54680g = new CopyOnWriteArrayList<>();
        if (TnPlayerManager.f54684a.d()) {
            HandlerThread handlerThread = new HandlerThread("TnPlayerThread", Build.VERSION.SDK_INT >= 28 ? -10 : -16);
            handlerThread.start();
            handlerThread.setUncaughtExceptionHandler(f54674l);
            this.f54676b = new Handler(handlerThread.getLooper());
            this.f54675a = handlerThread;
        } else {
            this.f54675a = null;
            this.f54676b = new Handler(Looper.getMainLooper());
        }
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.2
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
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                com.transsion.player.orplayer.f fVarA = new com.transsion.player.orplayer.f.a(applicationA).b(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 126975, null)).a();
                TnAliPlayer tnAliPlayer2 = TnAliPlayer.this;
                fVarA.setLooping(false);
                fVarA.setAutoPlay(false);
                fVarA.setPlayerListener(tnAliPlayer2);
                tnAliPlayer.f54677c = fVarA;
                TnAliPlayer tnAliPlayer3 = TnAliPlayer.this;
                tnAliPlayer3.r("init player:" + tnAliPlayer3.f54677c);
            }
        });
        this.f54683j = new AtomicBoolean(true);
    }

    public /* synthetic */ TnAliPlayer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.player.orplayer.f q() {
        return this.f54677c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String str) {
        com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
        int iHashCode = hashCode();
        com.transsion.player.orplayer.f fVar = this.f54677c;
        bVar.a("TnPlayer", "this@" + iHashCode + "  player@" + (fVar != null ? fVar.hashCode() : 0) + "  " + str, true);
    }

    public static final void s(Thread thread, Throwable th2) {
        com.transsion.player.utils.b.f54866a.c("TnPlayer", "uncaughtException:" + th2, true);
    }

    public static final void u(Function0 action) {
        Intrinsics.g(action, "$action");
        action.invoke();
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        setDataSource(mediaSource);
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(final com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        if (this.f54680g.contains(listener)) {
            return;
        }
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.addPlayerListener.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TnAliPlayer.this.f54680g.add(listener);
                TnAliPlayer.this.r("addPlayerListener:" + listener);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(ov.d mediaTrackGroup, int i11) {
        Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            fVarQ.changeTrackSelection(mediaTrackGroup, i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.clearScreen.1
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.clearScreen();
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("clearScreen  mediaSource:" + tnAliPlayer.p());
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            fVarQ.clearSurfaceOnly();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        return com.transsion.player.orplayer.f.b.f(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(final boolean z11) {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.enableHardwareDecoder.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.enableHardwareDecoder(z11);
                }
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        Pair<Integer, Integer> bitrate;
        com.transsion.player.orplayer.f fVarQ = q();
        return (fVarQ == null || (bitrate = fVarQ.getBitrate()) == null) ? new Pair<>(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        return this.f54678d;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        com.transsion.player.orplayer.f fVarQ = q();
        return fVarQ != null ? fVarQ.getVideoHeight() : com.transsion.player.orplayer.f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        com.transsion.player.orplayer.f fVarQ = q();
        return fVarQ != null ? fVarQ.getVideoWidth() : com.transsion.player.orplayer.f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.initPlayer();
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).initPlayer();
        }
        r("initPlayer  mediaSource:" + this.f54681h);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        com.transsion.player.orplayer.f fVarQ = q();
        return fVarQ != null ? fVarQ.isLoading() : com.transsion.player.orplayer.f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            return fVarQ.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        com.transsion.player.orplayer.f fVarQ = q();
        return fVarQ != null ? fVarQ.isPrepared() : com.transsion.player.orplayer.f.b.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onAliyunDecodeErrorChangeSoftwareDecoder(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onBufferedPosition(j11, mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onBufferedPosition(j11, mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onCompletion(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onCompletion(mediaSource);
        }
        r("onCompletion  mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onFocusChange(z11);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z11);
        }
        r("onFocusChange mediaSource:" + this.f54681h);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onIsPlayingChanged(z11);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onIsPlayingChanged(z11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onLoadingBegin(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingBegin(mediaSource);
        }
        r("onLoadingBegin  mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onLoadingEnd(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingEnd(mediaSource);
        }
        r("onLoadingEnd mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onLoadingProgress(i11, f11, mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingProgress(i11, f11, mediaSource);
        }
        r("onLoadingProgress percent:" + i11 + " netSpeed:" + f11 + " mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onLoopingStart();
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoopingStart();
        }
        r("onLoopingStart  mediaSource:" + this.f54681h);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onPlayError(errorInfo, mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayError(errorInfo, mediaSource);
        }
        this.f54683j.set(true);
        r("onPlayError  errorInfo:" + errorInfo + " mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onPlayerRelease(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerRelease(mediaSource);
        }
        r("onPlayerRelease  mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onPlayerReset();
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerReset();
        }
        r("onPlayerReset mediaSource:" + this.f54681h);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.f fVarQ = q();
        this.f54678d = fVarQ != null ? fVarQ.getDuration() : 0L;
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onPrepare(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPrepare(mediaSource);
        }
        r("onPrepare  mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        if (this.f54683j.get()) {
            com.transsion.player.orplayer.e eVar = this.f54679f;
            if (eVar != null) {
                eVar.onProgress(j11, mediaSource);
            }
            Iterator<T> it = this.f54680g.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onProgress(j11, mediaSource);
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        r("onRenderFirstFrame  mediaSource:" + this.f54681h);
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onRenderFirstFrame();
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onRenderFirstFrame();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onSetDataSource();
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onSetDataSource();
        }
        r("onSetDataSource  mediaSource:" + this.f54681h);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onTracksAudioBitrateChange(i11);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksAudioBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        com.transsion.player.orplayer.e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onTracksVideoBitrateChange(i11);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onVideoPause(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoPause(mediaSource);
        }
        r("onVideoPause  mediaSource:" + mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onVideoSizeChanged(i11, i12);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoSizeChanged(i11, i12);
        }
        r("onVideoSizeChanged width:" + i11 + " height:" + i12 + " mediaSource:" + this.f54681h);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.onVideoStart(mediaSource);
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoStart(mediaSource);
        }
        r("onVideoStart  mediaSource:" + mediaSource);
    }

    public final MediaSource p() {
        return this.f54681h;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.pause.1
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.pause();
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("pause:" + tnAliPlayer.p());
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.play.1
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.play();
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("play:" + tnAliPlayer.p());
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.prepare.1
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.prepare();
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("prepare:" + tnAliPlayer.p());
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        this.f54678d = 0L;
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.release.1
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
                TnAliPlayer.this.f54682i = 0L;
                TnAliPlayer.this.f54683j.set(true);
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.stop();
                }
                if (TnPlayerManager.f54684a.f()) {
                    if (f.f54733a.a(TnAliPlayer.this)) {
                        com.transsion.player.orplayer.f fVarQ2 = TnAliPlayer.this.q();
                        if (fVarQ2 != null) {
                            fVarQ2.release();
                        }
                        HandlerThread handlerThread = TnAliPlayer.this.f54675a;
                        if (handlerThread != null) {
                            handlerThread.quitSafely();
                        }
                        HandlerThread handlerThread2 = TnAliPlayer.this.f54675a;
                        if (handlerThread2 != null) {
                            handlerThread2.setUncaughtExceptionHandler(null);
                        }
                        TnAliPlayer.this.f54676b.removeCallbacksAndMessages(null);
                    } else {
                        com.transsion.player.orplayer.f fVarQ3 = TnAliPlayer.this.q();
                        if (fVarQ3 != null) {
                            fVarQ3.reset();
                        }
                        com.transsion.player.orplayer.f fVarQ4 = TnAliPlayer.this.q();
                        if (fVarQ4 != null) {
                            fVarQ4.clearScreen();
                        }
                    }
                    TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                    tnAliPlayer.r(" release:" + tnAliPlayer.p());
                } else {
                    com.transsion.player.orplayer.f fVarQ5 = TnAliPlayer.this.q();
                    if (fVarQ5 != null) {
                        fVarQ5.reset();
                    }
                    TnAliPlayer tnAliPlayer2 = TnAliPlayer.this;
                    tnAliPlayer2.r(" reset:" + tnAliPlayer2.p());
                }
                TnAliPlayer.this.f54679f = null;
            }
        });
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
    public void removePlayerListener(final com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.removePlayerListener.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TnAliPlayer.this.f54680g.remove(listener);
                TnAliPlayer.this.r("removePlayerListener:" + listener);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return com.transsion.player.orplayer.f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.reset.1
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
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("reset:" + tnAliPlayer.p());
                TnAliPlayer.this.f54682i = 0L;
                TnAliPlayer.this.f54683j.set(true);
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.clearScreen();
                }
                com.transsion.player.orplayer.f fVarQ2 = TnAliPlayer.this.q();
                if (fVarQ2 != null) {
                    fVarQ2.reset();
                }
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(final long j11) {
        if (this.f54683j.compareAndSet(true, false)) {
            t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.seekTo.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                    if (fVarQ != null) {
                        fVarQ.seekTo(j11);
                    }
                    TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                    tnAliPlayer.r(" seekTo:" + j11 + "  mediaSource:" + tnAliPlayer.p());
                }
            });
            this.f54682i = 0L;
            return;
        }
        this.f54682i = j11;
        r("seekTo:" + j11 + "  waiting.... mediaSource:" + this.f54681h);
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j11) {
        com.transsion.player.orplayer.f.b.s(this, str, j11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(final boolean z11) {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setAutoPlay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setAutoPlay(z11);
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("setAutoPlay:" + z11 + "  mediaSource:" + tnAliPlayer.p());
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(final MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setDataSource.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TnAliPlayer.this.v(mediaSource);
                TnAliPlayer.this.f54678d = 0L;
                TnAliPlayer.this.f54682i = 0L;
                TnAliPlayer.this.f54683j.set(true);
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setDataSource(mediaSource);
                }
                TnAliPlayer.this.r("setDataSource:" + mediaSource);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(final boolean z11) {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setLooping.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setLooping(z11);
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("setLooping:" + z11 + "  mediaSource:" + tnAliPlayer.p());
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            fVarQ.setMute(z11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
        this.f54683j.set(true);
        com.transsion.player.orplayer.e eVar = this.f54679f;
        if (eVar != null) {
            eVar.setOnSeekCompleteListener();
        }
        Iterator<T> it = this.f54680g.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).setOnSeekCompleteListener();
        }
        r("setOnSeekCompleteListener nextSeekTo:" + this.f54682i + " mediaSource:" + this.f54681h);
        long j11 = this.f54682i;
        if (j11 > 0) {
            seekTo(j11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(final iv.d vodConfig) {
        Intrinsics.g(vodConfig, "vodConfig");
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setPlayerConfig.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setPlayerConfig(vodConfig);
                }
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(final com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setPlayerListener.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TnAliPlayer.this.f54679f = listener;
                TnAliPlayer.this.r("setPlayerListener:" + listener);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.g(scaleMode, "scaleMode");
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            fVarQ.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(final float f11) {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setSpeed.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setSpeed(f11);
                }
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(final SurfaceView surfaceView) {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setSurfaceView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setSurfaceView(surfaceView);
                }
                TnAliPlayer.this.r("setSurfaceView:" + surfaceView);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(final TextureView textureView) {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setTextureView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setTextureView(textureView);
                }
                TnAliPlayer.this.r("setTextureView:" + textureView);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(final float f11) {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.setVolume.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.setVolume(f11);
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("setVolume:" + f11 + "  mediaSource:" + tnAliPlayer.p());
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        t(new Function0<Unit>() { // from class: com.transsion.player.orplayer.global.TnAliPlayer.stop.1
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
                com.transsion.player.orplayer.f fVarQ = TnAliPlayer.this.q();
                if (fVarQ != null) {
                    fVarQ.stop();
                }
                TnAliPlayer tnAliPlayer = TnAliPlayer.this;
                tnAliPlayer.r("stop:" + tnAliPlayer.p());
            }
        });
    }

    public final void t(final Function0<Unit> action) {
        Intrinsics.g(action, "action");
        if (Intrinsics.b(Thread.currentThread(), this.f54676b.getLooper().getThread())) {
            action.invoke();
            return;
        }
        HandlerThread handlerThread = this.f54675a;
        if (handlerThread == null || !handlerThread.isAlive()) {
            r("runOnPlayerThread handlerThread.isAlive:false");
        } else {
            this.f54676b.post(new Runnable() { // from class: com.transsion.player.orplayer.global.b
                @Override // java.lang.Runnable
                public final void run() {
                    TnAliPlayer.u(action);
                }
            });
        }
    }

    public final void v(MediaSource mediaSource) {
        this.f54681h = mediaSource;
    }
}
