package com.cloud.tmc.integration.defaultImpl;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.render.IRenderWebivewStrategyCache;
import com.cloud.tmc.render.bean.WebviewCacheStrategyBean;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RenderWebviewStrategyCache implements IRenderWebivewStrategyCache {
    public final WebviewCacheStrategyBean a() {
        try {
            return (WebviewCacheStrategyBean) k.d(MiniAppConfigHelper.f30370a.e("webviewCacheStrategy", "{\"systemWebView\": true, \"shellWebView\": true}"), WebviewCacheStrategyBean.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.cloud.tmc.render.IRenderWebivewStrategyCache
    public boolean getShellWebviewCacheStrategy() {
        WebviewCacheStrategyBean webviewCacheStrategyBeanA = a();
        if (webviewCacheStrategyBeanA != null) {
            return webviewCacheStrategyBeanA.getShellWebView();
        }
        return true;
    }

    @Override // com.cloud.tmc.render.IRenderWebivewStrategyCache
    public boolean getSystemWebviewCacheStrategy() {
        WebviewCacheStrategyBean webviewCacheStrategyBeanA = a();
        if (webviewCacheStrategyBeanA != null) {
            return webviewCacheStrategyBeanA.getSystemWebView();
        }
        return true;
    }
}
