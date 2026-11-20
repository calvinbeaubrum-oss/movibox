package uf;

import android.util.Log;
import com.facebook.biddingkit.http.client.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f78529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HttpMethod f78530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f78531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f78532d;

    public d(String str, Map<String, String> map) {
        this.f78529a = "";
        if (str != null) {
            this.f78529a = str;
        }
        if (map != null) {
            this.f78529a += "?" + e(map);
        }
    }

    public byte[] a() {
        return this.f78532d;
    }

    public String b() {
        return this.f78531c;
    }

    public HttpMethod c() {
        return this.f78530b;
    }

    public String d() {
        return this.f78529a;
    }

    public final String e(Map<String, String> map) {
        StringBuilder sb2 = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(str);
            String str2 = map.get(str);
            if (str2 != null) {
                sb2.append("=");
                try {
                    sb2.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e11) {
                    Log.e("HttpRequest", "Failed url encode: ", e11);
                }
            }
        }
        return sb2.toString();
    }
}
