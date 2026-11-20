package com.transsion.player.orplayer.global;

import android.content.Context;
import com.transsion.player.exo.ORExoPlayer;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f54733a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f54734b = "TnPlayerPool";

    public final boolean a(com.transsion.player.orplayer.f fVar) {
        return true;
    }

    public final TnAliPlayer b(Context context) {
        Intrinsics.g(context, "context");
        return TnAliPlayer.f54673k.a();
    }

    public final ORExoPlayer c(Context context) {
        Intrinsics.g(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.f(applicationContext, "context.applicationContext");
        return new ORExoPlayer(applicationContext, null, false, 6, null);
    }
}
