package uf;

import android.util.Log;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f78533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f78534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, List<String>> f78535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f78536d;

    public e(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f78533a = httpURLConnection.getResponseCode();
            this.f78534b = httpURLConnection.getURL().toString();
            this.f78535c = httpURLConnection.getHeaderFields();
        } catch (Throwable th2) {
            Log.e("HttpResponse", "Failed to createHttpResponse", th2);
        }
        this.f78536d = bArr;
    }

    public String a() {
        byte[] bArr = this.f78536d;
        if (bArr != null) {
            return new String(bArr);
        }
        return null;
    }

    public Map<String, List<String>> b() {
        return this.f78535c;
    }

    public int c() {
        return this.f78533a;
    }
}
