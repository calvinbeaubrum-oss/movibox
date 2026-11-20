package com.transsion.web.api;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class WebJavascriptNavigator {
    @JavascriptInterface
    public final String hostInfo() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(TrackingKey.PLATFORM, "Android");
        jsonObject.addProperty("version", "2.0.40");
        String string = jsonObject.toString();
        Intrinsics.f(string, "jsonObject.toString()");
        return string;
    }
}
