package kn;

import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final URL f68655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f68656c;

    public f(String str, URL url, String str2) {
        this.f68654a = str;
        this.f68655b = url;
        this.f68656c = str2;
    }

    public static f a(String str, URL url, String str2) {
        nn.g.e(str, "VendorKey is null or empty");
        nn.g.c(url, "ResourceURL is null");
        nn.g.e(str2, "VerificationParameters is null or empty");
        return new f(str, url, str2);
    }

    public static f b(URL url) {
        nn.g.c(url, "ResourceURL is null");
        return new f(null, url, null);
    }

    public URL c() {
        return this.f68655b;
    }

    public String d() {
        return this.f68654a;
    }

    public String e() {
        return this.f68656c;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        nn.c.i(jSONObject, "vendorKey", this.f68654a);
        nn.c.i(jSONObject, "resourceUrl", this.f68655b.toString());
        nn.c.i(jSONObject, "verificationParameters", this.f68656c);
        return jSONObject;
    }
}
