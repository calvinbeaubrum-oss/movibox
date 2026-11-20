package com.amazonaws.util;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f16262a = Pattern.compile(Pattern.quote("+") + "|" + Pattern.quote("*") + "|" + Pattern.quote("%7E") + "|" + Pattern.quote("%2F"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f16263b;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Pattern.quote("%2A"));
        sb2.append("|");
        sb2.append(Pattern.quote("%2B"));
        sb2.append("|");
        f16263b = Pattern.compile(sb2.toString());
    }

    public static String a(String str, String str2) {
        return b(str, str2, false);
    }

    public static String b(String str, String str2, boolean z11) {
        if (str2 == null || str2.length() <= 0) {
            if (str.endsWith("/")) {
                return str;
            }
            return str + "/";
        }
        if (str2.startsWith("/")) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        String strE = e(str2, true);
        if (z11) {
            strE = strE.replace("//", "/%2F");
        }
        return str + strE;
    }

    public static String c(Request<?> request) {
        if (request.getParameters().isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            boolean z11 = true;
            for (Map.Entry<String, String> entry : request.getParameters().entrySet()) {
                String strEncode = URLEncoder.encode(entry.getKey(), "UTF-8");
                String value = entry.getValue();
                String strEncode2 = value == null ? "" : URLEncoder.encode(value, "UTF-8");
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append("&");
                }
                sb2.append(strEncode);
                sb2.append("=");
                sb2.append(strEncode2);
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static boolean d(URI uri) {
        String strB = StringUtils.b(uri.getScheme());
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(strB) && port == 80) {
            return false;
        }
        return ("https".equals(strB) && port == 443) ? false : true;
    }

    public static String e(String str, boolean z11) {
        if (str == null) {
            return "";
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = f16262a.matcher(strEncode);
            StringBuffer stringBuffer = new StringBuffer(strEncode.length());
            while (matcher.find()) {
                String strGroup = matcher.group(0);
                if ("+".equals(strGroup)) {
                    strGroup = "%20";
                } else if ("*".equals(strGroup)) {
                    strGroup = "%2A";
                } else if ("%7E".equals(strGroup)) {
                    strGroup = "~";
                } else if (z11 && "%2F".equals(strGroup)) {
                    strGroup = "/";
                }
                matcher.appendReplacement(stringBuffer, strGroup);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static boolean f(Request<?> request) {
        return HttpMethodName.POST.equals(request.n()) && (request.getContent() == null);
    }
}
