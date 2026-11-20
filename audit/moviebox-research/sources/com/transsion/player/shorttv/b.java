package com.transsion.player.shorttv;

import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p006enum.ScaleMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ov.c;
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
public interface b extends f {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static void a(b bVar, e listener) {
            Intrinsics.g(listener, "listener");
            f.b.b(bVar, listener);
        }

        public static void b(b bVar, d mediaTrackGroup, int i11) {
            Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
            f.b.c(bVar, mediaTrackGroup, i11);
        }

        public static void c(b bVar) {
            f.b.d(bVar);
        }

        public static c d(b bVar) {
            return f.b.h(bVar);
        }

        public static ov.b e(b bVar) {
            return f.b.i(bVar);
        }

        public static Object f(b bVar) {
            return f.b.j(bVar);
        }

        public static int g(b bVar) {
            return f.b.k(bVar);
        }

        public static int h(b bVar) {
            return f.b.l(bVar);
        }

        public static boolean i(b bVar) {
            return f.b.m(bVar);
        }

        public static void j(b bVar, String str) {
            f.b.o(bVar, str);
        }

        public static void k(b bVar, e listener) {
            Intrinsics.g(listener, "listener");
            f.b.q(bVar, listener);
        }

        public static boolean l(b bVar) {
            return f.b.r(bVar);
        }

        public static void m(b bVar, String uuid, long j11) {
            Intrinsics.g(uuid, "uuid");
            f.b.s(bVar, uuid, j11);
        }

        public static void n(b bVar, iv.d vodConfig) {
            Intrinsics.g(vodConfig, "vodConfig");
            f.b.w(bVar, vodConfig);
        }

        public static void o(b bVar, ScaleMode scaleMode) {
            Intrinsics.g(scaleMode, "scaleMode");
            f.b.x(bVar, scaleMode);
        }
    }

    Map<String, MediaSource> a();

    boolean b(MediaSource mediaSource);
}
