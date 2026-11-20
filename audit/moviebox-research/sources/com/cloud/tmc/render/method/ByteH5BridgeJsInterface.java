package com.cloud.tmc.render.method;

import android.webkit.JavascriptInterface;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;
import zc.p;

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
public final class ByteH5BridgeJsInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f32098a;

    public final void clear() {
        this.f32098a = null;
    }

    @JavascriptInterface
    public final void h5SendToNative(String str) {
        p pVar;
        TmcLogger.c("juggist", "h5SendToNative:" + str);
        if (str == null || (pVar = this.f32098a) == null) {
            return;
        }
        pVar.onConsoleMessage(str);
    }

    public final void setWebviewPageEventCallback(p pVar) {
        this.f32098a = pVar;
    }
}
