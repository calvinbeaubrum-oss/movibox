package okhttp3.brotli;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.brotli.dec.b;

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
public final class BrotliInterceptor implements Interceptor {
    public static final BrotliInterceptor INSTANCE = new BrotliInterceptor();

    private BrotliInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.g(chain, "chain");
        return chain.request().header("Accept-Encoding") == null ? uncompress$okhttp_brotli(chain.proceed(chain.request().newBuilder().header("Accept-Encoding", "br,gzip").build())) : chain.proceed(chain.request());
    }

    public final Response uncompress$okhttp_brotli(Response response) {
        ResponseBody responseBodyBody;
        String strHeader$default;
        BufferedSource bufferedSourceBuffer;
        Intrinsics.g(response, "response");
        if (!HttpHeaders.promisesBody(response) || (responseBodyBody = response.body()) == null || (strHeader$default = Response.header$default(response, com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_ENCODING, null, 2, null)) == null) {
            return response;
        }
        if (l.v(strHeader$default, TtmlNode.TAG_BR, true)) {
            bufferedSourceBuffer = Okio.buffer(Okio.source(new b(responseBodyBody.source().inputStream())));
        } else {
            if (!l.v(strHeader$default, "gzip", true)) {
                return response;
            }
            bufferedSourceBuffer = Okio.buffer(new GzipSource(responseBodyBody.source()));
        }
        return response.newBuilder().removeHeader(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_ENCODING).removeHeader(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_LENGTH).body(ResponseBody.Companion.create(bufferedSourceBuffer, responseBodyBody.contentType(), -1L)).build();
    }
}
