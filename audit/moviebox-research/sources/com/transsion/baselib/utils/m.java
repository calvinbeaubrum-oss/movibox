package com.transsion.baselib.utils;

import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f51320a = new m();

    public final PlayMode a() {
        String string = RoomAppMMKV.f51271a.a().getString("change_play_mode_by_debug", "");
        for (PlayMode playMode : PlayMode.values()) {
            if (Intrinsics.b(playMode.getValue(), string)) {
                return playMode;
            }
        }
        PlayMode playMode2 = PlayMode.DOWNLOAD;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("play_mode", true);
        if (configBeanB == null) {
            return playMode2;
        }
        String value = configBeanB.getValue();
        return (!Intrinsics.b(value, "1") && Intrinsics.b(value, "2")) ? PlayMode.STREAM : playMode2;
    }

    public final boolean b() {
        return a() == PlayMode.STREAM;
    }

    public final void c(PlayMode playMode) {
        Intrinsics.g(playMode, "playMode");
        RoomAppMMKV.f51271a.a().putString("change_play_mode_by_debug", playMode.getValue());
    }
}
