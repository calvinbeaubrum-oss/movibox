package com.transsion.videofloat;

import com.transsion.player.orplayer.f;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f60027a = new a();

    public final void a() {
        VideoFloatManager.a.a(VideoFloatManager.f60019a.b(), false, 1, null);
        VideoPipManager.a.a(VideoPipManager.f60024a.a(), false, 1, null);
    }

    public final boolean b(String tag) {
        Intrinsics.g(tag, "tag");
        return VideoFloatManager.f60019a.b().a(tag) || VideoPipManager.f60024a.a().a(tag);
    }

    public final boolean c(f fVar) {
        return VideoFloatManager.f60019a.b().c(fVar) || VideoPipManager.f60024a.a().f(fVar);
    }

    public final boolean d() {
        return VideoFloatManager.f60019a.b().isPlaying() || VideoPipManager.f60024a.a().isPlaying();
    }
}
