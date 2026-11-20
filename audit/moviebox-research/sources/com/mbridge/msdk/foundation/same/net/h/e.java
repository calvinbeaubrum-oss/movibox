package com.mbridge.msdk.foundation.same.net.h;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f44656a = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f44657b = "i";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f44658c = "coppa";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f44659d = "d";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f44660e = "e";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f44661f = "a";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f44662g = "f";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f44663h = "g";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f44664i = "e";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.foundation.same.net.d.a> f44665j = new LinkedHashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, String> f44666k = new LinkedHashMap();

    public e() {
    }

    public e(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    public final Map<String, String> a() {
        return this.f44666k;
    }

    public final void a(String str) {
        this.f44666k.remove(str);
        this.f44665j.remove(str);
    }

    public final void a(String str, String str2) {
        if (str2 == null) {
            ad.b(f44664i, "add() value is null!");
        }
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f44666k.put(str, str2);
    }

    public final String b() {
        StringBuilder sb2 = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.f44666k.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append('&');
                }
                sb2.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb2.append("=");
                sb2.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return sb2.toString();
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.f44666k.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.mbridge.msdk.foundation.same.net.d.a> entry2 : this.f44665j.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry2.getKey(), "UTF-8"), URLEncoder.encode("FILE_NAME_" + entry2.getValue().a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException unused) {
        } catch (JSONException e11) {
            ad.b(f44664i, e11.getMessage());
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(28);
        try {
            for (Map.Entry<String, String> entry : this.f44666k.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append('&');
                }
                sb2.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb2.append('=');
                sb2.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.mbridge.msdk.foundation.same.net.d.a> entry2 : this.f44665j.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append('&');
                }
                sb2.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb2.append('=');
                sb2.append(URLEncoder.encode("FILE_NAME_" + entry2.getValue().a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e11) {
            ad.b(f44664i, e11.getMessage());
        }
        return sb2.toString();
    }
}
