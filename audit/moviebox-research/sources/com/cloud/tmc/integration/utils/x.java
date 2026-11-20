package com.cloud.tmc.integration.utils;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

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
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f31135a = new x();

    @JvmStatic
    public static final String b() {
        try {
            String str = q.d() + '_' + System.currentTimeMillis() + '_' + kotlin.ranges.a.o(new IntRange(DefaultOggSeeker.MATCH_BYTE_RANGE, 999999), Random.Default);
            TmcLogger.c("GenerateIdUtils", "Generating random id by gaId: " + str);
            return str;
        } catch (Throwable th2) {
            TmcLogger.g("GenerateIdUtils", "Generating random id by gaId", th2);
            return f31135a.a();
        }
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append('_');
        sb2.append(kotlin.ranges.a.o(new IntRange(DefaultOggSeeker.MATCH_BYTE_RANGE, 999999), Random.Default));
        String string = sb2.toString();
        TmcLogger.c("GenerateIdUtils", "Generating random id: " + string);
        return string;
    }
}
