package com.transsion.player.orplayer;

import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.global.TnPlayerType;
import kotlin.Metadata;
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
public interface e {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static void A(e eVar) {
        }

        public static void B(e eVar, int i11) {
        }

        public static void C(e eVar, ov.c tracks) {
            Intrinsics.g(tracks, "tracks");
        }

        public static void D(e eVar, int i11) {
        }

        public static void E(e eVar, MediaSource mediaSource) {
        }

        public static /* synthetic */ void F(e eVar, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoPause");
            }
            if ((i11 & 1) != 0) {
                mediaSource = null;
            }
            eVar.onVideoPause(mediaSource);
        }

        public static void G(e eVar, int i11, int i12) {
        }

        public static void H(e eVar, MediaSource mediaSource) {
        }

        public static /* synthetic */ void I(e eVar, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoStart");
            }
            if ((i11 & 1) != 0) {
                mediaSource = null;
            }
            eVar.onVideoStart(mediaSource);
        }

        public static void J(e eVar) {
        }

        public static void a(e eVar) {
        }

        public static void b(e eVar, MediaSource mediaSource) {
        }

        public static void c(e eVar, long j11, MediaSource mediaSource) {
        }

        public static void d(e eVar, MediaSource mediaSource) {
        }

        public static /* synthetic */ void e(e eVar, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCompletion");
            }
            if ((i11 & 1) != 0) {
                mediaSource = null;
            }
            eVar.onCompletion(mediaSource);
        }

        public static void f(e eVar, boolean z11) {
        }

        public static void g(e eVar, boolean z11) {
        }

        public static void h(e eVar, MediaSource mediaSource) {
        }

        public static /* synthetic */ void i(e eVar, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadingBegin");
            }
            if ((i11 & 1) != 0) {
                mediaSource = null;
            }
            eVar.onLoadingBegin(mediaSource);
        }

        public static void j(e eVar, MediaSource mediaSource) {
        }

        public static /* synthetic */ void k(e eVar, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadingEnd");
            }
            if ((i11 & 1) != 0) {
                mediaSource = null;
            }
            eVar.onLoadingEnd(mediaSource);
        }

        public static void l(e eVar, int i11, float f11, MediaSource mediaSource) {
        }

        public static /* synthetic */ void m(e eVar, int i11, float f11, MediaSource mediaSource, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadingProgress");
            }
            if ((i12 & 4) != 0) {
                mediaSource = null;
            }
            eVar.onLoadingProgress(i11, f11, mediaSource);
        }

        public static void n(e eVar) {
        }

        public static void o(e eVar, String str) {
        }

        public static void p(e eVar, PlayError errorInfo, MediaSource mediaSource) {
            Intrinsics.g(errorInfo, "errorInfo");
        }

        public static /* synthetic */ void q(e eVar, PlayError playError, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlayError");
            }
            if ((i11 & 2) != 0) {
                mediaSource = null;
            }
            eVar.onPlayError(playError, mediaSource);
        }

        public static void r(e eVar, TnPlayerType errorType, MediaSource mediaSource) {
            Intrinsics.g(errorType, "errorType");
        }

        public static void s(e eVar, MediaSource mediaSource) {
        }

        public static /* synthetic */ void t(e eVar, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlayerRelease");
            }
            if ((i11 & 1) != 0) {
                mediaSource = null;
            }
            eVar.onPlayerRelease(mediaSource);
        }

        public static void u(e eVar) {
        }

        public static void v(e eVar, MediaSource mediaSource) {
        }

        public static /* synthetic */ void w(e eVar, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPrepare");
            }
            if ((i11 & 1) != 0) {
                mediaSource = null;
            }
            eVar.onPrepare(mediaSource);
        }

        public static void x(e eVar, long j11, MediaSource mediaSource) {
        }

        public static /* synthetic */ void y(e eVar, long j11, MediaSource mediaSource, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onProgress");
            }
            if ((i11 & 2) != 0) {
                mediaSource = null;
            }
            eVar.onProgress(j11, mediaSource);
        }

        public static void z(e eVar) {
        }
    }

    void initPlayer();

    void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource);

    void onBufferedPosition(long j11, MediaSource mediaSource);

    void onCompletion(MediaSource mediaSource);

    void onFocusChange(boolean z11);

    void onIsPlayingChanged(boolean z11);

    void onLoadingBegin(MediaSource mediaSource);

    void onLoadingEnd(MediaSource mediaSource);

    void onLoadingProgress(int i11, float f11, MediaSource mediaSource);

    void onLoopingStart();

    void onMediaItemTransition(String str);

    void onPlayError(PlayError playError, MediaSource mediaSource);

    void onPlayerRelease(MediaSource mediaSource);

    void onPlayerReset();

    void onPrepare(MediaSource mediaSource);

    void onProgress(long j11, MediaSource mediaSource);

    void onRenderFirstFrame();

    void onSetDataSource();

    void onTracksAudioBitrateChange(int i11);

    void onTracksChange(ov.c cVar);

    void onTracksVideoBitrateChange(int i11);

    void onVideoPause(MediaSource mediaSource);

    void onVideoSizeChanged(int i11, int i12);

    void onVideoStart(MediaSource mediaSource);

    void setOnSeekCompleteListener();
}
