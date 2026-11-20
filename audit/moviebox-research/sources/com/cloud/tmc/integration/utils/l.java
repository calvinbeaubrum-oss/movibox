package com.cloud.tmc.integration.utils;

import android.os.Bundle;
import java.util.ArrayList;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f31069a = new l();

    public final void a(Map<String, ? extends Object> dataMap, Bundle bundle) {
        Intrinsics.g(dataMap, "dataMap");
        Intrinsics.g(bundle, "bundle");
        try {
            for (Map.Entry<String, ? extends Object> entry : dataMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    bundle.putInt(key, ((Number) value).intValue());
                } else if (value instanceof Short) {
                    bundle.putShort(key, ((Number) value).shortValue());
                } else if (value instanceof Long) {
                    bundle.putLong(key, ((Number) value).longValue());
                } else if (value instanceof Double) {
                    bundle.putDouble(key, ((Number) value).doubleValue());
                } else if (value instanceof Float) {
                    bundle.putFloat(key, ((Number) value).floatValue());
                } else if (value instanceof String) {
                    bundle.putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    bundle.putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof ArrayList) {
                    for (Object obj : (Iterable) value) {
                        if (obj instanceof Integer) {
                            bundle.putIntegerArrayList(key, (ArrayList) value);
                        } else if (obj instanceof Short) {
                            bundle.putShortArray(key, (short[]) value);
                        } else if (obj instanceof Long) {
                            bundle.putLongArray(key, (long[]) value);
                        } else if (obj instanceof Double) {
                            bundle.putDoubleArray(key, (double[]) value);
                        } else if (obj instanceof Float) {
                            bundle.putFloatArray(key, (float[]) value);
                        } else if (obj instanceof String) {
                            bundle.putStringArrayList(key, (ArrayList) value);
                        } else if (obj instanceof Boolean) {
                            bundle.putBooleanArray(key, (boolean[]) value);
                        }
                    }
                } else if (value != null) {
                    com.cloud.tmc.kernel.utils.p.c("BundleUtil", "reportAdLog  put Bundle fail: key = " + key + " , value = " + value);
                }
            }
        } catch (Exception e11) {
            com.cloud.tmc.kernel.utils.p.c("BundleUtil", "reportAdLog  parse data fail: " + e11);
        }
    }
}
