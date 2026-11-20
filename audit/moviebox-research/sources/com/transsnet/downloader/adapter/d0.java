package com.transsnet.downloader.adapter;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface d0 {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static void a(d0 d0Var, int i11, e9.a aVar) {
        }

        public static void b(d0 d0Var, b listener) {
            Intrinsics.g(listener, "listener");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public static void a(b bVar, int i11, int i12, int i13, boolean z11) {
            }
        }

        void a(int i11, int i12);

        void b(int i11, int i12, int i13, boolean z11);
    }

    void a(int i11, e9.a aVar);

    void c(b bVar);

    void d(int i11, e9.a aVar);
}
