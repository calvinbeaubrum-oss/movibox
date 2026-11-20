package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpRequestFactory {
    public final void a(Map<String, String> map, Request<?> request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI uriS = request.s();
        String host = uriS.getHost();
        if (HttpUtils.d(uriS)) {
            host = host + ":" + uriS.getPort();
        }
        map.put(HttpHeaders.HOST, host);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get(HttpHeaders.CONTENT_TYPE) == null || map.get(HttpHeaders.CONTENT_TYPE).isEmpty()) {
            map.put(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + StringUtils.b("UTF-8"));
        }
        if (executionContext == null || executionContext.b() == null) {
            return;
        }
        map.put("User-Agent", c(clientConfiguration, executionContext.b()));
    }

    public HttpRequest b(Request<?> request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) {
        boolean z11 = true;
        String strB = HttpUtils.b(request.s().toString(), request.q(), true);
        String strC = HttpUtils.c(request);
        HttpMethodName httpMethodNameN = request.n();
        boolean z12 = request.getContent() != null;
        HttpMethodName httpMethodName = HttpMethodName.POST;
        if (httpMethodNameN == httpMethodName && !z12) {
            z11 = false;
        }
        if (strC != null && z11) {
            strB = strB + "?" + strC;
        }
        HashMap map = new HashMap();
        a(map, request, executionContext, clientConfiguration);
        InputStream content = request.getContent();
        HttpMethodName httpMethodName2 = HttpMethodName.PATCH;
        if (httpMethodNameN == httpMethodName2) {
            map.put("X-HTTP-Method-Override", httpMethodName2.toString());
            httpMethodNameN = httpMethodName;
        }
        if (httpMethodNameN == httpMethodName && request.getContent() == null && strC != null) {
            byte[] bytes = strC.getBytes(StringUtils.f16272a);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            map.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes.length));
            content = byteArrayInputStream;
        }
        if (clientConfiguration.k() && map.get("Accept-Encoding") == null) {
            map.put("Accept-Encoding", "gzip");
        } else {
            map.put("Accept-Encoding", "identity");
        }
        HttpRequest httpRequest = new HttpRequest(httpMethodNameN.toString(), URI.create(strB), map, content);
        httpRequest.g(request.l());
        return httpRequest;
    }

    public final String c(ClientConfiguration clientConfiguration, String str) {
        if (clientConfiguration.h().contains(str)) {
            return clientConfiguration.h();
        }
        return clientConfiguration.h() + " " + str;
    }
}
