package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@JvmName
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String line) {
        Intrinsics.g(builder, "builder");
        Intrinsics.g(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String name, String value) {
        Intrinsics.g(builder, "builder");
        Intrinsics.g(name, "name");
        Intrinsics.g(value, "value");
        return builder.addLenient$okhttp(name, value);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sslSocket, boolean z11) throws CloneNotSupportedException {
        Intrinsics.g(connectionSpec, "connectionSpec");
        Intrinsics.g(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z11);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        Intrinsics.g(cache, "cache");
        Intrinsics.g(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z11) {
        Intrinsics.g(cookie, "cookie");
        return cookie.toString$okhttp(z11);
    }

    public static final Cookie parseCookie(long j11, HttpUrl url, String setCookie) {
        Intrinsics.g(url, "url");
        Intrinsics.g(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j11, url, setCookie);
    }
}
