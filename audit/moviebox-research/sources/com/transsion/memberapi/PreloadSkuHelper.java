package com.transsion.memberapi;

import androidx.lifecycle.c0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PreloadSkuHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreloadSkuHelper f53417a = new PreloadSkuHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f53418b = LazyKt__LazyJVMKt.b(new Function0<c0<SkuData>>() { // from class: com.transsion.memberapi.PreloadSkuHelper$skuCache$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<SkuData> invoke() {
            return new c0<>();
        }
    });

    public final c0<SkuData> a() {
        return (c0) f53418b.getValue();
    }
}
