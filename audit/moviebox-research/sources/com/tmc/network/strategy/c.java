package com.tmc.network.strategy;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tmc.network.HttpClient;
import com.tmc.network.HttpRequestor;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f49367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f49368b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Callback {
        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e11) {
            Intrinsics.g(call, "call");
            Intrinsics.g(e11, "e");
            po.b.f73956a.c("pre connect onFailure");
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Intrinsics.g(call, "call");
            Intrinsics.g(response, "response");
            po.b.f73956a.c("pre connect success");
        }
    }

    public c(String url) {
        Intrinsics.g(url, "url");
        this.f49367a = url;
        this.f49368b = new a();
    }

    public final void a() {
        HttpClient httpClient;
        OkHttpClient okHttpClient;
        Call callNewCall;
        try {
            Request requestBuild = new Request.Builder().url(this.f49367a).header("isPre", "true").head().build();
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            if (companion != null && (httpClient = companion.getHttpClient()) != null && (okHttpClient = httpClient.getOkHttpClient()) != null && (callNewCall = okHttpClient.newCall(requestBuild)) != null) {
                FirebasePerfOkHttpClient.enqueue(callNewCall, this.f49368b);
            }
            po.b.f73956a.c(Intrinsics.p("pre connect start url = ", this.f49367a));
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }
}
