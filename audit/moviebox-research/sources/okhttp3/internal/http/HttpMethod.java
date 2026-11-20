package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
@Metadata
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(String method) {
        Intrinsics.g(method, "method");
        return (Intrinsics.b(method, "GET") || Intrinsics.b(method, "HEAD")) ? false : true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(String method) {
        Intrinsics.g(method, "method");
        return Intrinsics.b(method, "POST") || Intrinsics.b(method, "PUT") || Intrinsics.b(method, "PATCH") || Intrinsics.b(method, "PROPPATCH") || Intrinsics.b(method, "REPORT");
    }

    public final boolean invalidatesCache(String method) {
        Intrinsics.g(method, "method");
        return Intrinsics.b(method, "POST") || Intrinsics.b(method, "PATCH") || Intrinsics.b(method, "PUT") || Intrinsics.b(method, "DELETE") || Intrinsics.b(method, "MOVE");
    }

    public final boolean redirectsToGet(String method) {
        Intrinsics.g(method, "method");
        return !Intrinsics.b(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        Intrinsics.g(method, "method");
        return Intrinsics.b(method, "PROPFIND");
    }
}
