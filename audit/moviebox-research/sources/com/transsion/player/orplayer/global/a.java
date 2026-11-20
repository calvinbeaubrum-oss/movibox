package com.transsion.player.orplayer.global;

import android.annotation.SuppressLint;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaBrowserCompatHelper;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a implements com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f54712b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<com.transsion.player.orplayer.e> f54711a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54713c = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;

    public final void a(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        if (this.f54711a.contains(listener)) {
            return;
        }
        this.f54711a.add(listener);
    }

    public final String b() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @SuppressLint({"SimpleDateFormat"})
    public final String c(long j11) {
        SimpleDateFormat simpleDateFormat = j11 >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String str = simpleDateFormat.format(Long.valueOf(j11));
        Intrinsics.f(str, "format.format(millisecond)");
        return str;
    }

    public final void d(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f54711a.remove(listener);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).initPlayer();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onBufferedPosition(j11, mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onCompletion(mediaSource);
        }
        com.transsion.player.mediasession.d.f54622a.a(b() + " --> onCompletion() --> 刷新通知栏");
        MediaBrowserCompatHelper.f54597h.a().l(mediaSource != null ? mediaSource.h() : null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e.a.f(this, z11);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        com.transsion.player.orplayer.e.a.g(this, z11);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onIsPlayingChanged(z11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.h(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingBegin(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.j(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingEnd(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingProgress(i11, f11, mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.player.orplayer.e.a.n(this);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoopingStart();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onMediaItemTransition(str);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayError(errorInfo, mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerRelease(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerReset();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPrepare(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onProgress(j11, mediaSource);
        }
        if (System.currentTimeMillis() - this.f54712b > this.f54713c) {
            this.f54712b = System.currentTimeMillis();
            MediaItem mediaItemH = mediaSource != null ? mediaSource.h() : null;
            if (mediaItemH != null) {
                com.transsion.player.orplayer.f fVarB = TnPlayerManager.f54684a.b();
                mediaItemH.setDuration(fVarB != null ? Long.valueOf(fVarB.getDuration()) : null);
            }
            MediaItem mediaItemH2 = mediaSource != null ? mediaSource.h() : null;
            if (mediaItemH2 != null) {
                mediaItemH2.setPosition(Long.valueOf(j11));
            }
            MediaBrowserCompatHelper.f54597h.a().m(mediaSource != null ? mediaSource.h() : null);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onRenderFirstFrame();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onSetDataSource();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.B(this, i11);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksAudioBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c tracks) {
        Intrinsics.g(tracks, "tracks");
        com.transsion.player.orplayer.e.a.C(this, tracks);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksChange(tracks);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.D(this, i11);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        MediaItem mediaItemH;
        MediaItem mediaItemH2;
        Long position;
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoPause(mediaSource);
        }
        com.transsion.player.mediasession.d.f54622a.a(b() + " --> onVideoPause() --> 刷新通知栏 --> position = " + c((mediaSource == null || (mediaItemH2 = mediaSource.h()) == null || (position = mediaItemH2.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + ((mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getPosition()));
        MediaItem mediaItemH3 = mediaSource != null ? mediaSource.h() : null;
        if (mediaItemH3 != null) {
            com.transsion.player.orplayer.f fVarB = TnPlayerManager.f54684a.b();
            mediaItemH3.setDuration(fVarB != null ? Long.valueOf(fVarB.getDuration()) : null);
        }
        MediaItem mediaItemH4 = mediaSource != null ? mediaSource.h() : null;
        if (mediaItemH4 != null) {
            com.transsion.player.orplayer.f fVarB2 = TnPlayerManager.f54684a.b();
            mediaItemH4.setPosition(fVarB2 != null ? Long.valueOf(fVarB2.getCurrentPosition()) : null);
        }
        MediaBrowserCompatHelper.f54597h.a().l(mediaSource != null ? mediaSource.h() : null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoSizeChanged(i11, i12);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        MediaItem mediaItemH;
        MediaItem mediaItemH2;
        Long position;
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoStart(mediaSource);
        }
        com.transsion.player.mediasession.d.f54622a.a(b() + " --> onVideoStart() --> 刷新通知栏 --> position = " + c((mediaSource == null || (mediaItemH2 = mediaSource.h()) == null || (position = mediaItemH2.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + ((mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getPosition()));
        MediaItem mediaItemH3 = mediaSource != null ? mediaSource.h() : null;
        if (mediaItemH3 != null) {
            com.transsion.player.orplayer.f fVarB = TnPlayerManager.f54684a.b();
            mediaItemH3.setDuration(fVarB != null ? Long.valueOf(fVarB.getDuration()) : null);
        }
        MediaItem mediaItemH4 = mediaSource != null ? mediaSource.h() : null;
        if (mediaItemH4 != null) {
            com.transsion.player.orplayer.f fVarB2 = TnPlayerManager.f54684a.b();
            mediaItemH4.setPosition(fVarB2 != null ? Long.valueOf(fVarB2.getCurrentPosition()) : null);
        }
        MediaBrowserCompatHelper.f54597h.a().m(mediaSource != null ? mediaSource.h() : null);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        Long position;
        MediaSource mediaSourceCurrentMediaSource;
        com.transsion.player.orplayer.e.a.J(this);
        Iterator<T> it = this.f54711a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).setOnSeekCompleteListener();
        }
        TnPlayerManager tnPlayerManager = TnPlayerManager.f54684a;
        com.transsion.player.orplayer.f fVarB = tnPlayerManager.b();
        MediaItem mediaItemH = (fVarB == null || (mediaSourceCurrentMediaSource = fVarB.currentMediaSource()) == null) ? null : mediaSourceCurrentMediaSource.h();
        if (mediaItemH != null) {
            com.transsion.player.orplayer.f fVarB2 = tnPlayerManager.b();
            mediaItemH.setDuration(fVarB2 != null ? Long.valueOf(fVarB2.getDuration()) : null);
        }
        if (mediaItemH != null) {
            com.transsion.player.orplayer.f fVarB3 = tnPlayerManager.b();
            mediaItemH.setPosition(fVarB3 != null ? Long.valueOf(fVarB3.getCurrentPosition()) : null);
        }
        com.transsion.player.mediasession.d.f54622a.a(b() + " --> setOnSeekCompleteListener() --> 刷新通知栏 --> position = " + c((mediaItemH == null || (position = mediaItemH.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + (mediaItemH != null ? mediaItemH.getPosition() : null));
        MediaBrowserCompatHelper.f54597h.a().m(mediaItemH);
    }
}
