package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class OkHeaders {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<String> f49219a = new Comparator<String>() { // from class: com.squareup.okhttp.internal.http.OkHeaders.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f49220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f49221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f49222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f49223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f49224f;

    static {
        String strG = com.squareup.okhttp.internal.e.f().g();
        f49220b = strG;
        f49221c = strG + "-Sent-Millis";
        f49222d = strG + "-Received-Millis";
        f49223e = strG + "-Selected-Protocol";
        f49224f = strG + "-Response-Source";
    }

    public static void a(Request.Builder builder, Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                if (!entry.getValue().isEmpty()) {
                    builder.addHeader(key, b(entry.getValue()));
                }
            }
        }
    }

    public static String b(List<String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                sb2.append("; ");
            }
            sb2.append(list.get(i11));
        }
        return sb2.toString();
    }

    public static long c(Headers headers) {
        return k(headers.get(HttpHeaders.CONTENT_LENGTH));
    }

    public static long d(Request request) {
        return c(request.headers());
    }

    public static long e(Response response) {
        return c(response.headers());
    }

    public static boolean f(Headers headers) {
        return m(headers).contains("*");
    }

    public static boolean g(Response response) {
        return f(response.headers());
    }

    public static boolean h(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static List<Challenge> i(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (str.equalsIgnoreCase(headers.name(i11))) {
                String strValue = headers.value(i11);
                int iC = 0;
                while (iC < strValue.length()) {
                    int iB = c.b(strValue, iC, " ");
                    String strTrim = strValue.substring(iC, iB).trim();
                    int iC2 = c.c(strValue, iB);
                    if (!strValue.regionMatches(true, iC2, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i12 = iC2 + 7;
                    int iB2 = c.b(strValue, i12, "\"");
                    String strSubstring = strValue.substring(i12, iB2);
                    iC = c.c(strValue, c.b(strValue, iB2 + 1, ",") + 1);
                    arrayList.add(new Challenge(strTrim, strSubstring));
                }
            }
        }
        return arrayList;
    }

    public static Request j(Authenticator authenticator, Response response, Proxy proxy) throws IOException {
        return response.code() == 407 ? authenticator.authenticateProxy(proxy, response) : authenticator.authenticate(proxy, response);
    }

    public static long k(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Map<String, List<String>> l(Headers headers, String str) {
        TreeMap treeMap = new TreeMap(f49219a);
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String strName = headers.name(i11);
            String strValue = headers.value(i11);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(strName);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(strValue);
            treeMap.put(strName, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static Set<String> m(Headers headers) {
        Set<String> setEmptySet = Collections.emptySet();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            if ("Vary".equalsIgnoreCase(headers.name(i11))) {
                String strValue = headers.value(i11);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strValue.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static Set<String> n(Response response) {
        return m(response.headers());
    }

    public static Headers o(Headers headers, Headers headers2) {
        Set<String> setM = m(headers2);
        if (setM.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String strName = headers.name(i11);
            if (setM.contains(strName)) {
                builder.add(strName, headers.value(i11));
            }
        }
        return builder.build();
    }

    public static Headers p(Response response) {
        return o(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean q(Response response, Headers headers, Request request) {
        for (String str : n(response)) {
            if (!com.squareup.okhttp.internal.g.h(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }
}
