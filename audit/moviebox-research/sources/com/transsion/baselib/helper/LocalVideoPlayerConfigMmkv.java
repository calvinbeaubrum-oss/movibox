package com.transsion.baselib.helper;

import com.tencent.mmkv.MMKV;
import com.transsion.player.p006enum.ScaleMode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class LocalVideoPlayerConfigMmkv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalVideoPlayerConfigMmkv f51172a = new LocalVideoPlayerConfigMmkv();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f51173b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("LocalVideoPlayerConfig");
        }
    });

    public final MMKV a() {
        Object value = f51173b.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final ScaleMode b() {
        int i11 = a().getInt("ScaleMode", 0);
        ScaleMode scaleMode = ScaleMode.SCALE_ASPECT_FIT;
        if (scaleMode.getValue() == i11) {
            return scaleMode;
        }
        ScaleMode scaleMode2 = ScaleMode.SCALE_ASPECT_FILL;
        return scaleMode2.getValue() == i11 ? scaleMode2 : ScaleMode.SCALE_TO_FILL;
    }

    public final float c() {
        return a().getFloat("speed", 1.0f);
    }

    public final void d(ScaleMode mode) {
        Intrinsics.g(mode, "mode");
        a().putInt("ScaleMode", mode.getValue());
    }

    public final void e(float f11) {
        a().putFloat("speed", f11);
    }
}
