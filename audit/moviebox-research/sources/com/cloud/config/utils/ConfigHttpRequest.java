package com.cloud.config.utils;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tmc.network.HttpClient;
import com.tmc.network.HttpRequestor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;

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
public final class ConfigHttpRequest {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConfigHttpRequest getInstance() {
            return ConfigRequestorHolder.INSTANCE.getSInstance();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class ConfigRequestorHolder {
        public static final ConfigRequestorHolder INSTANCE = new ConfigRequestorHolder();
        private static final ConfigHttpRequest sInstance = new ConfigHttpRequest();

        private ConfigRequestorHolder() {
        }

        public final ConfigHttpRequest getSInstance() {
            return sInstance;
        }
    }

    public final void getHeader(String url, Callback callback) {
        HttpClient httpClient;
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            Request.Builder builderHead = new Request.Builder().url(url).head();
            Intrinsics.f(builderHead, "Builder()\n              …)\n                .head()");
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            Call callNewCall = null;
            if (companion != null && (httpClient = companion.getHttpClient()) != null) {
                callNewCall = httpClient.newCall(builderHead.build());
            }
            if (callNewCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(callNewCall, callback);
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
    }
}
