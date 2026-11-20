package com.transsion.baselib.utils;

import java.util.HashMap;
import kotlin.Metadata;

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
public final class k {
    public static final void a(String str, String str2, Float f11) {
        HashMap map = new HashMap();
        map.put("module_name", "long_pressed");
        map.put("subject_id", str2);
        map.put("speed", String.valueOf(f11));
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        if (str == null) {
            return;
        }
        mVar.m(str, "click", map);
    }

    public static final void b(String str, long j11, String str2, Float f11) {
        HashMap map = new HashMap();
        map.put("module_name", "long_pressed");
        map.put("subject_id", str2);
        map.put("speed", String.valueOf(f11));
        map.put("duration", String.valueOf(j11));
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        if (str == null) {
            return;
        }
        mVar.t(str, "browse", map);
    }
}
