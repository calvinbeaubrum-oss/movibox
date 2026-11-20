package com.transsion.videofloat.manager;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f60111a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, com.transsion.player.orplayer.f> f60112b = new LinkedHashMap();

    public final void a(String tag, com.transsion.player.orplayer.f player) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(player, "player");
        uo.b.a.o(uo.b.f78622a, "VideoFloat", new String[]{"PlayerView-----addPlayerView," + tag}, false, 4, null);
        f60112b.put(tag, player);
    }

    public final com.transsion.player.orplayer.f b(String tag) {
        Intrinsics.g(tag, "tag");
        Map<String, com.transsion.player.orplayer.f> map = f60112b;
        com.transsion.player.orplayer.f fVarRemove = map.remove(tag);
        if (fVarRemove == null) {
            if (!map.isEmpty()) {
                for (Map.Entry<String, com.transsion.player.orplayer.f> entry : map.entrySet()) {
                    uo.b.f78622a.t("VideoFloat", "PlayerView---player null clear. release, tag:" + tag + ", curTag：" + ((Object) entry.getKey()), true);
                    entry.getValue().release();
                }
                Iterator<T> it = f60112b.values().iterator();
                while (it.hasNext()) {
                    ((com.transsion.player.orplayer.f) it.next()).release();
                }
            }
            f60112b.clear();
        }
        return fVarRemove;
    }

    public final boolean c(com.transsion.player.orplayer.f fVar) {
        for (com.transsion.player.orplayer.f fVar2 : f60112b.values()) {
            if (Intrinsics.b(fVar2, fVar)) {
                uo.b.f78622a.c("VideoFloat", "hasPlayerCache，true player:" + fVar, true);
                return true;
            }
            uo.b.f78622a.c("VideoFloat", "hasPlayerCache，false player:" + fVar + ", cachePayer:" + fVar2, true);
        }
        return false;
    }

    public final void d() {
        f60112b.clear();
    }

    public final void e(String tag) {
        Intrinsics.g(tag, "tag");
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "PlayerView-----removePlayerView", false, 4, null);
        f60112b.remove(tag);
    }
}
