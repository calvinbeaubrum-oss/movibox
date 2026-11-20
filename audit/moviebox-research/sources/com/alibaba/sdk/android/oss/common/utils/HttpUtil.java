package com.alibaba.sdk.android.oss.common.utils;

import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpUtil {
    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!z11) {
                sb2.append("&");
            }
            sb2.append(urlEncode(key, str));
            if (value != null) {
                sb2.append("=");
                sb2.append(urlEncode(value, str));
            }
            z11 = false;
        }
        return sb2.toString();
    }

    public static String urlEncode(String str, String str2) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2).replace("+", "%20").replace("*", "%2A").replace("%7E", "~").replace("%2F", "/");
        } catch (Exception e11) {
            throw new IllegalArgumentException("failed to encode url!", e11);
        }
    }
}
