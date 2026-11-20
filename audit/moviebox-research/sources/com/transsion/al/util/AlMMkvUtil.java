package com.transsion.al.util;

import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class AlMMkvUtil {
    public static final Companion Companion = new Companion(null);
    private static final String table_name = "kv_alive_table";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getBoolean(String key, boolean z11) {
            Intrinsics.g(key, "key");
            MMKV mmkvA = MMKV.A(AlMMkvUtil.table_name, 2);
            return mmkvA != null ? mmkvA.getBoolean(key, z11) : z11;
        }

        public final int getInt(String key, int i11) {
            Intrinsics.g(key, "key");
            MMKV mmkvA = MMKV.A(AlMMkvUtil.table_name, 2);
            return mmkvA != null ? mmkvA.getInt(key, i11) : i11;
        }

        public final long getLong(String key, long j11) {
            Intrinsics.g(key, "key");
            MMKV mmkvA = MMKV.A(AlMMkvUtil.table_name, 2);
            return mmkvA != null ? mmkvA.getLong(key, j11) : j11;
        }

        public final void putBoolean(String key, boolean z11) {
            Intrinsics.g(key, "key");
            MMKV mmkvA = MMKV.A(AlMMkvUtil.table_name, 2);
            if (mmkvA != null) {
                mmkvA.putBoolean(key, z11);
            }
        }

        public final void putInt(String key, int i11) {
            Intrinsics.g(key, "key");
            MMKV mmkvA = MMKV.A(AlMMkvUtil.table_name, 2);
            if (mmkvA != null) {
                mmkvA.putInt(key, i11);
            }
        }

        public final void putLong(String key, long j11) {
            Intrinsics.g(key, "key");
            MMKV mmkvA = MMKV.A(AlMMkvUtil.table_name, 2);
            if (mmkvA != null) {
                mmkvA.putLong(key, j11);
            }
        }
    }
}
