package com.transsion.player.orplayer;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.transsion.player.MediaSource;
import com.transsion.player.p006enum.ScaleMode;
import kotlin.Metadata;
import kotlin.Pair;
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
public interface f {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f54671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public iv.d f54672b;

        public a(Context context) {
            Intrinsics.g(context, "context");
            this.f54671a = context;
        }

        public final f a() {
            return new ORPlayerImpl(this.f54671a, this.f54672b);
        }

        public final a b(iv.d config) {
            Intrinsics.g(config, "config");
            this.f54672b = config;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public static boolean a(f fVar, MediaSource mediaSource) {
            Intrinsics.g(mediaSource, "mediaSource");
            return false;
        }

        public static void b(f fVar, e listener) {
            Intrinsics.g(listener, "listener");
        }

        public static void c(f fVar, ov.d mediaTrackGroup, int i11) {
            Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        }

        public static void d(f fVar) {
        }

        public static void e(f fVar) {
        }

        public static MediaSource f(f fVar) {
            return null;
        }

        public static long g(f fVar) {
            return 0L;
        }

        public static ov.c h(f fVar) {
            return null;
        }

        public static ov.b i(f fVar) {
            return null;
        }

        public static Object j(f fVar) {
            return null;
        }

        public static int k(f fVar) {
            return 0;
        }

        public static int l(f fVar) {
            return 0;
        }

        public static boolean m(f fVar) {
            return false;
        }

        public static boolean n(f fVar) {
            return false;
        }

        public static void o(f fVar, String str) {
        }

        public static boolean p(f fVar, MediaSource mediaSource) {
            Intrinsics.g(mediaSource, "mediaSource");
            return false;
        }

        public static void q(f fVar, e listener) {
            Intrinsics.g(listener, "listener");
        }

        public static boolean r(f fVar) {
            return false;
        }

        public static void s(f fVar, String uuid, long j11) {
            Intrinsics.g(uuid, "uuid");
        }

        public static void t(f fVar) {
        }

        public static void u(f fVar, com.transsion.player.orplayer.global.d listener) {
            Intrinsics.g(listener, "listener");
        }

        public static void v(f fVar, boolean z11) {
        }

        public static void w(f fVar, iv.d vodConfig) {
            Intrinsics.g(vodConfig, "vodConfig");
        }

        public static void x(f fVar, ScaleMode scaleMode) {
            Intrinsics.g(scaleMode, "scaleMode");
        }
    }

    boolean addDataSource(MediaSource mediaSource);

    void addPlayerListener(e eVar);

    void changeTrackSelection(ov.d dVar, int i11);

    void clearScreen();

    void clearSurfaceOnly();

    MediaSource currentMediaSource();

    void enableHardwareDecoder(boolean z11);

    Pair<Integer, Integer> getBitrate();

    long getCurrentPosition();

    ov.c getCurrentTracks();

    ov.b getCurrentVideoFormat();

    Object getDownloadBitrate();

    long getDuration();

    int getVideoHeight();

    int getVideoWidth();

    Float getVolume();

    boolean isComplete();

    boolean isLoading();

    boolean isMute();

    boolean isPlaying();

    boolean isPrepared();

    void pause();

    void play();

    void prepare();

    void release();

    void release(String str);

    boolean removeDataSource(MediaSource mediaSource);

    void removePlayerListener(e eVar);

    boolean requestForce();

    void reset();

    void seekTo(long j11);

    void seekTo(String str, long j11);

    void setAutoPlay(boolean z11);

    void setDataSource(MediaSource mediaSource);

    void setLooping(boolean z11);

    void setMute(boolean z11);

    void setPlayerConfig(iv.d dVar);

    void setPlayerListener(e eVar);

    void setScaleMode(ScaleMode scaleMode);

    void setSpeed(float f11);

    void setSurfaceView(SurfaceView surfaceView);

    void setTextureView(TextureView textureView);

    void setVolume(float f11);

    void stop();
}
