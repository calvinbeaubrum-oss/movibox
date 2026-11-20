package com.cloud.hisavana.protocol.intercept;

import iq.h;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f29044a;

    public a(Map<String, String> domainABMap) {
        Intrinsics.g(domainABMap, "domainABMap");
        this.f29044a = domainABMap;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.g(chain, "chain");
        Request request = chain.request();
        HttpUrl httpUrlUrl = request.url();
        String str = this.f29044a.get(request.url().host());
        if (str != null) {
            request = request.newBuilder().url(httpUrlUrl.newBuilder().host(str).build()).build();
            h hVar = h.f67653a;
            Intrinsics.f(request, "this");
            hVar.c(chain, request);
        }
        Response responseProceed = chain.proceed(request);
        Intrinsics.f(responseProceed, "chain.proceed(request)");
        return responseProceed;
    }
}
