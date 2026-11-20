package com.cloud.tmc.integration.proxy;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zb.c;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@c("com.cloud.tmc.miniapp.prestrategy.strategy.PreHtmlStrategy")
public interface PreHtmStrategyProxy {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ boolean a(PreHtmStrategyProxy preHtmStrategyProxy, Context context, String str, boolean z11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkPreHtmlCache");
            }
            if ((i11 & 4) != 0) {
                z11 = true;
            }
            return preHtmStrategyProxy.checkPreHtmlCache(context, str, z11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(PreHtmStrategyProxy preHtmStrategyProxy, Context context, String str, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestHtml");
            }
            if ((i11 & 4) != 0) {
                function1 = null;
            }
            preHtmStrategyProxy.requestHtml(context, str, function1);
        }
    }

    boolean checkPreHtmlCache(Context context, String str, boolean z11);

    String getPreHtmlCache(Context context, String str, int i11, boolean z11);

    void requestHtml(Context context, String str, Function1<? super Boolean, Unit> function1);

    void trackPreStrategyFailPoint(Bundle bundle);
}
