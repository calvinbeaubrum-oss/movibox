package com.cloud.tmc.kernel.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LruCache<String, Uri> f31293a = new LruCache<>(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LruCache<String, String> f31294b = new LruCache<>(20);

    public static String a(String str, String str2, String str3) {
        return b(str, str2, str3, true);
    }

    public static String b(String str, String str2, String str3, boolean z11) {
        if (n.a(str)) {
            return "";
        }
        if (n.a(str2)) {
            return str.trim();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str2.trim(), str3);
        return c(str, linkedHashMap, z11);
    }

    public static String c(String str, Map<String, String> map, boolean z11) {
        if (n.a(str)) {
            return "";
        }
        if (map == null || map.size() < 1) {
            return str.trim();
        }
        Uri uriM = m(str);
        if (uriM == null) {
            return "";
        }
        Uri.Builder builderBuildUpon = uriM.buildUpon();
        builderBuildUpon.clearQuery();
        Map mapH = h(str);
        if (mapH == null) {
            mapH = new LinkedHashMap();
        }
        if (!z11) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!n.a(entry.getKey())) {
                    linkedHashMap.put(entry.getKey().trim(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                for (Map.Entry entry3 : mapH.entrySet()) {
                    if (!n.a((CharSequence) entry2.getKey()) && ((String) entry2.getKey()).trim().equals(entry3.getKey())) {
                        map.remove(((String) entry2.getKey()).trim());
                    }
                }
            }
        }
        for (Map.Entry<String, String> entry4 : map.entrySet()) {
            mapH.put(entry4.getKey().trim(), entry4.getValue());
        }
        if (mapH.size() > 0) {
            for (String str2 : mapH.keySet()) {
                String str3 = (String) mapH.get(str2);
                if (str3 == null) {
                    str3 = "";
                }
                builderBuildUpon.appendQueryParameter(str2, str3);
            }
        }
        return builderBuildUpon.build().toString();
    }

    @Nullable
    public static String d(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception e11) {
            TmcLogger.g("TmcKernel:UrlUtils", "Exception", e11);
            return null;
        }
    }

    public static String e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strF = f(str);
            if (strF == null) {
                strF = "";
            }
            return fd.a.b(strF, false);
        } catch (Throwable th2) {
            TmcLogger.g("TmcKernel:UrlUtils", th2.getMessage(), th2);
            return null;
        }
    }

    public static String f(String str) {
        String path;
        String str2;
        int iLastIndexOf;
        try {
            if (!TextUtils.isEmpty(str) && (path = Uri.parse(str).getPath()) != null) {
                String[] strArrSplit = path.split("/");
                if (strArrSplit.length > 0 && (iLastIndexOf = (str2 = strArrSplit[strArrSplit.length - 1]).lastIndexOf(46)) != -1) {
                    return str2.substring(iLastIndexOf + 1);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcKernel:UrlUtils", th2.getMessage(), th2);
        }
        return null;
    }

    public static String g(String str) {
        Uri uriM = m(str);
        if (uriM != null) {
            return uriM.getHost();
        }
        return null;
    }

    @Nullable
    public static Map<String, String> h(String str) {
        String strK;
        try {
            if (!n.a(str) && (strK = k(str)) != null && !n.a(strK)) {
                String[] strArrSplit = strK.split("&");
                if (strArrSplit.length > 0) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (String str2 : strArrSplit) {
                        if (!n.a(str2)) {
                            String[] strArrSplit2 = str2.split("=");
                            if (strArrSplit2.length > 0) {
                                String str3 = strArrSplit2[0];
                                if (!n.a(str3)) {
                                    if (strArrSplit2.length > 1) {
                                        linkedHashMap.put(str3.trim(), strArrSplit2[1]);
                                    } else {
                                        linkedHashMap.put(str3.trim(), "");
                                    }
                                }
                            }
                        }
                    }
                    return linkedHashMap;
                }
                return null;
            }
            return null;
        } catch (Exception e11) {
            TmcLogger.g("TmcKernel:UrlUtils", "getParamsMap failed", e11);
        }
    }

    public static String i(String str) {
        Uri uriM = m(str);
        if (uriM != null) {
            return uriM.getPath();
        }
        return null;
    }

    public static int j(String str) {
        try {
            Uri uriM = m(str);
            if (uriM == null || uriM.getPort() == -1) {
                return -1;
            }
            return uriM.getPort();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String k(String str) {
        Uri uriM = m(str);
        if (uriM != null) {
            return uriM.getQuery();
        }
        return null;
    }

    public static String l(String str) {
        Uri uriM = m(str);
        if (uriM != null) {
            return uriM.getScheme();
        }
        return null;
    }

    public static Uri m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = f31293a.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            f31293a.put(str, uri);
            return uri;
        } catch (Exception e11) {
            TmcLogger.g("TmcKernel:UrlUtils", "parse url exception.", e11);
            return uri;
        }
    }

    public static String n(String str) {
        return com.cloud.tmc.miniutils.util.g.f(str);
    }
}
