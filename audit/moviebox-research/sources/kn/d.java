package kn;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.adsession.AdSessionContextType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f68644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f68645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f> f68646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, f> f68647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f68648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f68649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f68650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AdSessionContextType f68651h;

    public d(e eVar, WebView webView, String str, List<f> list, @Nullable String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f68646c = arrayList;
        this.f68647d = new HashMap();
        this.f68644a = eVar;
        this.f68645b = webView;
        this.f68648e = str;
        this.f68651h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (f fVar : list) {
                this.f68647d.put(UUID.randomUUID().toString(), fVar);
            }
        }
        this.f68650g = str2;
        this.f68649f = str3;
    }

    public static d a(e eVar, WebView webView, @Nullable String str, String str2) {
        nn.g.c(eVar, "Partner is null");
        nn.g.c(webView, "WebView is null");
        if (str2 != null) {
            nn.g.d(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(eVar, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    public static d b(e eVar, String str, List<f> list, @Nullable String str2, String str3) {
        nn.g.c(eVar, "Partner is null");
        nn.g.c(str, "OM SDK JS script content is null");
        nn.g.c(list, "VerificationScriptResources is null");
        if (str3 != null) {
            nn.g.d(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(eVar, null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType c() {
        return this.f68651h;
    }

    @Nullable
    public String d() {
        return this.f68650g;
    }

    public String e() {
        return this.f68649f;
    }

    public Map<String, f> f() {
        return Collections.unmodifiableMap(this.f68647d);
    }

    public String g() {
        return this.f68648e;
    }

    public e h() {
        return this.f68644a;
    }

    public List<f> i() {
        return Collections.unmodifiableList(this.f68646c);
    }

    public WebView j() {
        return this.f68645b;
    }
}
