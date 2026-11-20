package com.cloud.hisavana.net;

import com.cloud.hisavana.net.impl.IHttpCallback;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CommonRequest {
    private CommonRequest() {
        throw new IllegalStateException("Utility class");
    }

    public static Request a(String str, RequestParams requestParams, IHttpCallback iHttpCallback) {
        try {
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append("?");
            if (requestParams != null && !requestParams.c().isEmpty()) {
                for (Map.Entry<String, String> entry : requestParams.c().entrySet()) {
                    sb2.append(entry.getKey());
                    sb2.append("=");
                    sb2.append(entry.getValue());
                    sb2.append("&");
                }
            }
            return requestParams != null ? new Request.Builder().url(sb2.substring(0, sb2.length() - 1)).headers(c(requestParams.b())).get().build() : new Request.Builder().url(sb2.substring(0, sb2.length() - 1)).get().build();
        } catch (Exception e11) {
            if (iHttpCallback != null) {
                iHttpCallback.e(490, null, e11);
            }
            return null;
        }
    }

    public static Request b(String str, RequestParams requestParams, IHttpCallback iHttpCallback) {
        try {
            return new Request.Builder().url(str).headers(c(requestParams.b())).post(d(requestParams.d())).build();
        } catch (Exception e11) {
            if (iHttpCallback != null) {
                iHttpCallback.e(490, null, e11);
            }
            return null;
        }
    }

    public static Headers c(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        return !map.isEmpty() ? Headers.of(map) : new Headers.Builder().build();
    }

    public static RequestBody d(Object obj) {
        return e(GsonUtil.d(obj), MediaType.parse(ContentType.JSON.toString()));
    }

    public static RequestBody e(String str, MediaType mediaType) {
        return RequestBody.create(mediaType, str);
    }
}
