package com.transsion.audio.player;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class AudioPlayer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f50830i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<AudioPlayer> f50831j = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<AudioPlayer>() { // from class: com.transsion.audio.player.AudioPlayer$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AudioPlayer invoke() {
            return new AudioPlayer();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.player.orplayer.f f50833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.audio.player.a f50834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f50835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioBean f50836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioBean f50837f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f50832a = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<com.transsion.player.orplayer.e> f50838g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f50839h = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AudioPlayer a() {
            return (AudioPlayer) AudioPlayer.f50831j.getValue();
        }
    }

    public final void A(MediaSource mediaSource) {
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onLoadingEnd(mediaSource);
            }
        }
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void B(int i11, float f11, MediaSource mediaSource) {
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onLoadingProgress(i11, f11, mediaSource);
            }
        }
    }

    public final void C(MediaSource mediaSource) throws InterruptedException {
        AudioBean audioBean = this.f50836e;
        if (audioBean == null || audioBean.getStatus() != 6) {
            com.transsion.audio.view.d.k().q(4);
            m(4);
            for (com.transsion.player.orplayer.e eVar : this.f50838g) {
                if (eVar != null) {
                    eVar.onVideoPause(mediaSource);
                }
            }
            com.transsion.audio.player.a aVar = this.f50834c;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    public final void D(MediaSource mediaSource) throws InterruptedException {
        com.transsion.audio.view.d.k().q(3);
        m(3);
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onVideoStart(mediaSource);
            }
        }
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.i();
        }
    }

    public final void E() {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            fVar.pause();
        }
    }

    public final void F(PlayError playError, MediaSource mediaSource) throws InterruptedException {
        m(7);
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onPlayError(playError, mediaSource);
            }
        }
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.e(playError);
        }
    }

    public final void G(MediaSource mediaSource) throws InterruptedException {
        m(0);
        com.transsion.audio.view.d.k().q(0);
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onPlayerRelease(mediaSource);
            }
        }
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.b();
        }
        this.f50834c = null;
    }

    public final boolean H() {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    public final void I() {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            fVar.prepare();
        }
    }

    public final void J(AudioBean audio) {
        Intrinsics.g(audio, "audio");
        if (this.f50833b == null) {
            v();
        }
        uo.b.a.f(uo.b.f78622a, "audio_log", "AudioPlayer --> prepare --> " + audio, false, 4, null);
        this.f50837f = audio;
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            if (aVar != null) {
                aVar.b();
            }
            this.f50834c = null;
        }
        this.f50834c = new com.transsion.audio.player.a(audio);
        String url = audio.getUrl();
        if (url != null) {
            com.transsion.player.orplayer.f fVar = this.f50833b;
            if (fVar != null) {
                fVar.stop();
            }
            com.transsion.player.orplayer.f fVar2 = this.f50833b;
            if (fVar2 != null) {
                fVar2.setDataSource(new MediaSource(url, url, 0, null, null, 28, null));
            }
            com.transsion.player.orplayer.f fVar3 = this.f50833b;
            if (fVar3 != null) {
                fVar3.prepare();
            }
        }
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onPrepare(new MediaSource(audio.getAudioUrl(), audio.getAudioUrl(), 0, null, null, 28, null));
            }
        }
    }

    public final void K(long j11, MediaSource mediaSource) {
        com.transsion.audio.view.d.k().p(Long.valueOf(j11), Long.valueOf(this.f50832a));
        AudioBean audioBean = this.f50836e;
        if (audioBean != null) {
            audioBean.setReadProcess(Long.valueOf(j11));
        }
        if (System.currentTimeMillis() - this.f50835d > 1000) {
            for (com.transsion.player.orplayer.e eVar : this.f50838g) {
                if (eVar != null) {
                    eVar.onProgress(j11, mediaSource);
                }
            }
            AudioBean audioBean2 = this.f50836e;
            if (audioBean2 != null) {
                HistoryListManager.f50901e.b().p(audioBean2);
            }
            this.f50835d = System.currentTimeMillis();
            String str = this.f50839h;
            AudioBean audioBean3 = this.f50836e;
            if (!TextUtils.equals(str, audioBean3 != null ? audioBean3.getAudioUrl() : null)) {
                AudioBean audioBean4 = this.f50836e;
                this.f50839h = audioBean4 != null ? audioBean4.getAudioUrl() : null;
            }
        }
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.f(j11);
        }
    }

    public final void L() {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            fVar.release();
        }
        this.f50833b = null;
        this.f50836e = null;
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.b();
        }
        this.f50834c = null;
    }

    public final void M(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f50838g.remove(listener);
    }

    public final void N(long j11) {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            fVar.seekTo(j11);
        }
    }

    public final void O(long j11) {
        this.f50832a = j11;
    }

    public final void P(AudioBean audioBean) {
        this.f50836e = audioBean;
    }

    public final void Q() {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            fVar.play();
        }
    }

    public final void R() {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            fVar.stop();
        }
    }

    public final void l(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f50838g.add(listener);
    }

    public final void m(int i11) throws InterruptedException {
        AudioBean audioBean = this.f50836e;
        int status = audioBean != null ? audioBean.getStatus() : 1;
        switch (i11) {
            case 2:
            case 3:
                status = 3;
                break;
            case 4:
            case 5:
                status = 4;
                break;
            case 6:
                status = 6;
                break;
            case 7:
                status = 7;
                break;
        }
        AudioBean audioBean2 = this.f50836e;
        if (audioBean2 == null || audioBean2.getStatus() != 6 || status < 4) {
            AudioBean audioBean3 = this.f50836e;
            if (audioBean3 != null) {
                audioBean3.setStatus(status);
            }
            AudioBean audioBean4 = this.f50836e;
            if (audioBean4 != null) {
                HistoryListManager.f50901e.b().f(audioBean4);
            }
            uo.b.a aVar = uo.b.f78622a;
            AudioBean audioBean5 = this.f50836e;
            Integer numValueOf = audioBean5 != null ? Integer.valueOf(audioBean5.getStatus()) : null;
            AudioBean audioBean6 = this.f50836e;
            uo.b.a.f(aVar, "audio_log", "onStateChanged " + numValueOf + " ..title.. " + (audioBean6 != null ? audioBean6.getTitle() : null), false, 4, null);
        }
    }

    public final void n(MediaSource mediaSource) throws InterruptedException {
        m(6);
        com.transsion.audio.view.d.k().q(6);
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onCompletion(mediaSource);
            }
        }
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.b();
        }
        this.f50834c = null;
    }

    public final boolean o() {
        return this.f50833b == null;
    }

    public final void p() {
        com.transsion.player.orplayer.f fVar = this.f50833b;
        if (fVar != null) {
            fVar.stop();
        }
        L();
    }

    public final com.transsion.audio.player.a q() {
        return this.f50834c;
    }

    public final long r() {
        return this.f50832a;
    }

    public final AudioBean s() {
        return this.f50836e;
    }

    public final AudioBean t() {
        return this.f50837f;
    }

    public final com.transsion.player.orplayer.f u() {
        return this.f50833b;
    }

    public final void v() {
        OrAudioPlayer orAudioPlayer = new OrAudioPlayer(Utils.a());
        this.f50833b = orAudioPlayer;
        orAudioPlayer.setPlayerListener(new com.transsion.player.orplayer.e() { // from class: com.transsion.audio.player.AudioPlayer$initPlayer$1
            @Override // com.transsion.player.orplayer.e
            public void initPlayer() {
                com.transsion.player.orplayer.e.a.a(this);
                uo.b.a.f(uo.b.f78622a, "audio_log", "AudioPlayer --> initPlayer --> initPlayer ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.b(this, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onBufferedPosition(long j11, MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onCompletion(MediaSource mediaSource) throws InterruptedException {
                com.transsion.player.orplayer.e.a.d(this, mediaSource);
                this.f50840a.n(mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onFocusChange(boolean z11) {
                com.transsion.player.orplayer.e.a.f(this, z11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onIsPlayingChanged(boolean z11) {
                this.f50840a.y(z11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingBegin(MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.h(this, mediaSource);
                this.f50840a.z(mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingEnd(MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.j(this, mediaSource);
                this.f50840a.A(mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
                this.f50840a.B(i11, f11, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoopingStart() {
                com.transsion.player.orplayer.e.a.n(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onMediaItemTransition(String str) {
                com.transsion.player.orplayer.e.a.o(this, str);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayError(PlayError errorInfo, MediaSource mediaSource) throws InterruptedException {
                Intrinsics.g(errorInfo, "errorInfo");
                com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
                this.f50840a.F(errorInfo, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerRelease(MediaSource mediaSource) throws InterruptedException {
                com.transsion.player.orplayer.e.a.s(this, mediaSource);
                this.f50840a.G(mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerReset() {
                com.transsion.player.orplayer.e.a.u(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPrepare(MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.v(this, mediaSource);
                uo.b.a.f(uo.b.f78622a, "audio_log", "AudioPlayer --> initPlayer -->onPrepare ...", false, 4, null);
                AudioPlayer audioPlayer = this.f50840a;
                com.transsion.player.orplayer.f fVarU = audioPlayer.u();
                audioPlayer.O(fVarU != null ? fVarU.getDuration() : 1L);
                AudioBean audioBeanT = this.f50840a.t();
                if (audioBeanT != null) {
                    audioBeanT.setDuration(Long.valueOf(this.f50840a.r()));
                }
                AudioPlayer audioPlayer2 = this.f50840a;
                audioPlayer2.P(audioPlayer2.t());
                if (this.f50840a.s() == null) {
                    com.transsion.player.orplayer.f fVarU2 = this.f50840a.u();
                    if (fVarU2 != null) {
                        fVarU2.play();
                        return;
                    }
                    return;
                }
                j.d(l0.a(w0.a()), null, null, new AudioPlayer$initPlayer$1$onPrepare$1(this.f50840a, null), 3, null);
                com.transsion.player.orplayer.f fVarU3 = this.f50840a.u();
                if (fVarU3 != null) {
                    fVarU3.play();
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onProgress(long j11, MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
                this.f50840a.K(j11, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onRenderFirstFrame() {
                com.transsion.player.orplayer.e.a.z(this);
                a aVarQ = this.f50840a.q();
                if (aVarQ != null) {
                    aVarQ.g();
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onSetDataSource() {
                com.transsion.player.orplayer.e.a.A(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksAudioBitrateChange(int i11) {
                com.transsion.player.orplayer.e.a.B(this, i11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksChange(ov.c cVar) {
                com.transsion.player.orplayer.e.a.C(this, cVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksVideoBitrateChange(int i11) {
                com.transsion.player.orplayer.e.a.D(this, i11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoPause(MediaSource mediaSource) throws InterruptedException {
                com.transsion.player.orplayer.e.a.E(this, mediaSource);
                this.f50840a.C(mediaSource);
                uo.b.a.f(uo.b.f78622a, "player", "AudioPlayer --> initPlayer --> onStateChanged 4 ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoSizeChanged(int i11, int i12) {
                com.transsion.player.orplayer.e.a.G(this, i11, i12);
                uo.b.a.f(uo.b.f78622a, "audio_log", "AudioPlayer --> initPlayer --> onVideoSizeChanged ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoStart(MediaSource mediaSource) throws InterruptedException {
                com.transsion.player.orplayer.e.a.H(this, mediaSource);
                this.f50840a.D(mediaSource);
                uo.b.a.f(uo.b.f78622a, "player", "onStateChanged 3 ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.e
            public void setOnSeekCompleteListener() {
                com.transsion.player.orplayer.e.a.J(this);
            }
        });
    }

    public final boolean w(AudioBean audio) {
        Intrinsics.g(audio, "audio");
        String audioUrl = audio.getAudioUrl();
        AudioBean audioBean = this.f50836e;
        return TextUtils.equals(audioUrl, audioBean != null ? audioBean.getAudioUrl() : null);
    }

    public final boolean x(String audioUrl) {
        Intrinsics.g(audioUrl, "audioUrl");
        AudioBean audioBean = this.f50836e;
        return TextUtils.equals(audioUrl, audioBean != null ? audioBean.getAudioUrl() : null);
    }

    public final void y(boolean z11) {
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onIsPlayingChanged(z11);
            }
        }
    }

    public final void z(MediaSource mediaSource) {
        for (com.transsion.player.orplayer.e eVar : this.f50838g) {
            if (eVar != null) {
                eVar.onLoadingBegin(mediaSource);
            }
        }
        com.transsion.audio.player.a aVar = this.f50834c;
        if (aVar != null) {
            aVar.c();
        }
    }
}
