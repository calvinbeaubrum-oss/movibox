package com.tmc.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LogInterceptor implements Interceptor {
    private final String readRequestBody(Request request) {
        if ((request == null ? null : request.body()) == null) {
            return "";
        }
        Request requestBuild = request.newBuilder().build();
        Buffer buffer = new Buffer();
        try {
            RequestBody requestBodyBody = requestBuild.body();
            if (requestBodyBody != null) {
                requestBodyBody.writeTo(buffer);
            }
            return buffer.readUtf8();
        } catch (IOException e11) {
            po.b.f73956a.e(e11);
            return "";
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.g(chain, "chain");
        Request request = chain.request();
        po.b bVar = po.b.f73956a;
        bVar.g(Intrinsics.p("[request]:", request));
        bVar.g(Intrinsics.p("[request-callTimeout]:", Long.valueOf(chain.call().timeout().timeoutNanos())));
        bVar.g(Intrinsics.p("[request-headers]:", request.headers()));
        bVar.g(Intrinsics.p("[request-body]:", readRequestBody(request)));
        long jNanoTime = System.nanoTime();
        Response responseProceed = chain.proceed(request);
        bVar.b("[costs]:" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime) + "ms");
        bVar.g(Intrinsics.p("[response-code]:", Integer.valueOf(responseProceed.code())));
        bVar.g(Intrinsics.p("[response-headers]:", responseProceed.headers()));
        return responseProceed;
    }
}
