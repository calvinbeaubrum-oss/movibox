package com.cloud.tmc.integration.performance.innerrender;

import android.app.Activity;
import android.app.Application;
import kotlin.Metadata;
import lb.f;
import zc.i;

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
@zb.c("com.cloud.tmc.integration.performance.innerrender.InnerRenderPool")
public interface IInnerRenderPool {
    boolean createRender(boolean z11);

    void destroy();

    i getRender(Activity activity, String str);

    void init(Application application);

    void preWarmupRenderFail();

    void registerListener(a aVar, boolean z11, String str);

    void removeRender(String str);

    void warmupRender(f fVar);
}
