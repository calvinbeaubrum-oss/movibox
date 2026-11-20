package sn;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.iab.omid.library.vungle.adsession.AdSessionContextType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f76419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f76420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e> f76421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, e> f76422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f76423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f76424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f76425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AdSessionContextType f76426h;

    public c(d dVar, WebView webView, String str, List<e> list, @Nullable String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f76421c = arrayList;
        this.f76422d = new HashMap();
        this.f76419a = dVar;
        this.f76420b = webView;
        this.f76423e = str;
        this.f76426h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (e eVar : list) {
                this.f76422d.put(UUID.randomUUID().toString(), eVar);
            }
        }
        this.f76425g = str2;
        this.f76424f = str3;
    }

    public static c a(d dVar, WebView webView, @Nullable String str, String str2) {
        un.e.c(dVar, "Partner is null");
        un.e.c(webView, "WebView is null");
        if (str2 != null) {
            un.e.d(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new c(dVar, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    public AdSessionContextType b() {
        return this.f76426h;
    }

    @Nullable
    public String c() {
        return this.f76425g;
    }

    public String d() {
        return this.f76424f;
    }

    public Map<String, e> e() {
        return Collections.unmodifiableMap(this.f76422d);
    }

    public String f() {
        return this.f76423e;
    }

    public d g() {
        return this.f76419a;
    }

    public List<e> h() {
        return Collections.unmodifiableList(this.f76421c);
    }

    public WebView i() {
        return this.f76420b;
    }
}
