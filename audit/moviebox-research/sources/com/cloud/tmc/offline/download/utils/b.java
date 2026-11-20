package com.cloud.tmc.offline.download.utils;

import android.os.SystemClock;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32087a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Long> f32088b = new HashMap<>();

    @JvmStatic
    @JvmOverloads
    public static final boolean a(String key, long j11) {
        Intrinsics.g(key, "key");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap<String, Long> map = f32088b;
        Long l11 = map.get(key);
        if (l11 == null) {
            l11 = 0L;
        }
        long jLongValue = jElapsedRealtime - l11.longValue();
        if (jLongValue > j11) {
            map.put(key, Long.valueOf(jElapsedRealtime));
            return false;
        }
        if (jLongValue >= 0) {
            return true;
        }
        map.put(key, 0L);
        return false;
    }
}
