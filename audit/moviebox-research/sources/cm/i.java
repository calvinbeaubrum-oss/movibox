package cm;

import androidx.annotation.NonNull;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.base.m;
import com.google.common.base.o;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.e0;
import com.google.common.util.concurrent.c0;
import com.google.net.cronet.okhttptransport.OkHttpBridgeRequestCallback;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;
import okio.Source;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImmutableSet<String> f14997a = ImmutableSet.of(TtmlNode.TAG_BR, "deflate", "gzip", "x-gzip");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f14998b = o.f(',').k().e();

    public static Protocol a(String str) {
        if (!str.contains("quic") && !str.contains("h3")) {
            if (!str.contains("spdy") && !str.contains("h2")) {
                return str.contains("http1.1") ? Protocol.HTTP_1_1 : Protocol.HTTP_1_0;
            }
            return Protocol.HTTP_2;
        }
        return Protocol.QUIC;
    }

    public static ResponseBody b(Request request, int i11, String str, String str2, Source source) throws IOException {
        long j11;
        if (request.method().equals("HEAD")) {
            j11 = 0;
        } else {
            j11 = -1;
            if (str2 != null) {
                try {
                    j11 = Long.parseLong(str2);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if ((i11 != 204 && i11 != 205) || j11 <= 0) {
            return ResponseBody.create(str != null ? MediaType.parse(str) : null, j11, Okio.buffer(source));
        }
        throw new ProtocolException("HTTP " + i11 + " had non-zero Content-Length: " + str2);
    }

    public static <T> T c(Future<T> future) throws IOException {
        try {
            return (T) c0.a(future);
        } catch (ExecutionException e11) {
            throw new IOException(e11);
        }
    }

    public static String d(String str, UrlResponseInfo urlResponseInfo) {
        List<String> list = urlResponseInfo.getAllHeaders().get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) e0.g(list);
    }

    public static <K, V> V e(Map<K, V> map, K k11, @NonNull V v11) {
        V v12 = map.get(k11);
        return v12 == null ? (V) m.p(v11) : v12;
    }

    public Response f(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) throws IOException {
        Response.Builder builder = new Response.Builder();
        UrlResponseInfo urlResponseInfo = (UrlResponseInfo) c(okHttpBridgeRequestCallback.g());
        String strD = d(HttpHeaders.CONTENT_TYPE, urlResponseInfo);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) e(urlResponseInfo.getAllHeaders(), HttpHeaders.CONTENT_ENCODING, Collections.emptyList())).iterator();
        while (it.hasNext()) {
            e0.a(arrayList, f14998b.h((String) it.next()));
        }
        boolean z11 = arrayList.isEmpty() || !f14997a.containsAll(arrayList);
        builder.request(request).code(urlResponseInfo.getHttpStatusCode()).message(urlResponseInfo.getHttpStatusText()).protocol(a(urlResponseInfo.getNegotiatedProtocol())).body(b(request, urlResponseInfo.getHttpStatusCode(), strD, z11 ? d(HttpHeaders.CONTENT_LENGTH, urlResponseInfo) : null, (Source) c(okHttpBridgeRequestCallback.f())));
        for (Map.Entry<String, String> entry : urlResponseInfo.getAllHeadersAsList()) {
            if (z11 || (!com.google.common.base.a.a(entry.getKey(), HttpHeaders.CONTENT_LENGTH) && !com.google.common.base.a.a(entry.getKey(), HttpHeaders.CONTENT_ENCODING))) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }
}
