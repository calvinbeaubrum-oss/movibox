package fp;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class c implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65214a = "HeaderInterceptor";

    public final Request a(Request request, String str) {
        b.a aVar = b.f65208a;
        String strC = aVar.c();
        Request.Builder builderNewBuilder = request.newBuilder();
        builderNewBuilder.addHeader("X-Client-Info", strC);
        builderNewBuilder.addHeader("X-Client-Status", String.valueOf(!Intrinsics.b(aVar.d(), Boolean.TRUE) ? 1 : 0));
        return builderNewBuilder.build();
    }

    public final Request b(Request request) {
        Map<String, String> mapF = b.f65208a.f();
        if (mapF.isEmpty()) {
            return request;
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        for (Map.Entry<String, String> entry : mapF.entrySet()) {
            builderNewBuilder.header(entry.getKey(), entry.getValue());
        }
        return builderNewBuilder.build();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.g(chain, "chain");
        return chain.proceed(a(b(chain.request()), ""));
    }
}
