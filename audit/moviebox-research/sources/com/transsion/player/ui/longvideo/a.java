package com.transsion.player.ui.longvideo;

import android.view.MotionEvent;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.d;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
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
public interface a extends f {

    /* JADX INFO: renamed from: com.transsion.player.ui.longvideo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0584a {
        public static boolean a(a aVar, MediaSource mediaSource) {
            Intrinsics.g(mediaSource, "mediaSource");
            return f.b.a(aVar, mediaSource);
        }

        public static void b(a aVar) {
            f.b.d(aVar);
        }

        public static MediaSource c(a aVar) {
            return f.b.f(aVar);
        }

        public static int d(a aVar) {
            return f.b.k(aVar);
        }

        public static int e(a aVar) {
            return f.b.l(aVar);
        }

        public static boolean f(a aVar) {
            return f.b.m(aVar);
        }

        public static boolean g(a aVar) {
            return f.b.n(aVar);
        }

        public static void h(a aVar, String str) {
            f.b.o(aVar, str);
        }

        public static boolean i(a aVar, MediaSource mediaSource) {
            Intrinsics.g(mediaSource, "mediaSource");
            return f.b.p(aVar, mediaSource);
        }

        public static void j(a aVar, String uuid, long j11) {
            Intrinsics.g(uuid, "uuid");
            f.b.s(aVar, uuid, j11);
        }

        public static void k(a aVar) {
            f.b.t(aVar);
        }

        public static void l(a aVar, d listener) {
            Intrinsics.g(listener, "listener");
            f.b.u(aVar, listener);
        }

        public static void m(a aVar, boolean z11) {
            f.b.v(aVar, z11);
        }

        public static void n(a aVar, iv.d vodConfig) {
            Intrinsics.g(vodConfig, "vodConfig");
            f.b.w(aVar, vodConfig);
        }

        public static void o(a aVar, ScaleMode scaleMode) {
            Intrinsics.g(scaleMode, "scaleMode");
            f.b.x(aVar, scaleMode);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a();

        void b(float f11, float f12);

        void c();

        void onDoubleTap(MotionEvent motionEvent);

        void onLongPress(MotionEvent motionEvent);
    }

    void enableGesture(boolean z11);

    f getOrPlayer();

    void initLongVodPlayer(iv.a aVar, ORPlayerView oRPlayerView);

    void setExistPlayer(iv.a aVar, f fVar, ORPlayerView oRPlayerView);

    void setGestureListener(b bVar);
}
