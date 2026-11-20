package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.Cookie;
import com.mbridge.msdk.thrid.okhttp.CookieJar;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.Version;
import com.mbridge.msdk.thrid.okio.GzipSource;
import com.mbridge.msdk.thrid.okio.Okio;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                sb2.append("; ");
            }
            Cookie cookie = list.get(i11);
            sb2.append(cookie.name());
            sb2.append('=');
            sb2.append(cookie.value());
        }
        return sb2.toString();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_TYPE, mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_LENGTH, Long.toString(jContentLength));
                builderNewBuilder.removeHeader("Transfer-Encoding");
            } else {
                builderNewBuilder.header("Transfer-Encoding", "chunked");
                builderNewBuilder.removeHeader(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z11 = false;
        if (request.header(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.HOST) == null) {
            builderNewBuilder.header(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.HOST, Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            builderNewBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            builderNewBuilder.header("Accept-Encoding", "gzip");
            z11 = true;
        }
        List<Cookie> listLoadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!listLoadForRequest.isEmpty()) {
            builderNewBuilder.header("Cookie", cookieHeader(listLoadForRequest));
        }
        if (request.header("User-Agent") == null) {
            builderNewBuilder.header("User-Agent", Version.userAgent());
        }
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), responseProceed.headers());
        Response.Builder builderRequest = responseProceed.newBuilder().request(request);
        if (z11 && "gzip".equalsIgnoreCase(responseProceed.header(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_ENCODING)) && HttpHeaders.hasBody(responseProceed)) {
            GzipSource gzipSource = new GzipSource(responseProceed.body().source());
            builderRequest.headers(responseProceed.headers().newBuilder().removeAll(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_ENCODING).removeAll(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_LENGTH).build());
            builderRequest.body(new RealResponseBody(responseProceed.header(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_TYPE), -1L, Okio.buffer(gzipSource)));
        }
        return builderRequest.build();
    }
}
