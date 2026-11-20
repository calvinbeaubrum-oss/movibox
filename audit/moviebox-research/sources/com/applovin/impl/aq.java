package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class aq extends com.applovin.impl.sdk.ad.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f17743l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f17744m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final jq f17745n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f17746o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final nq f17747p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final dq f17748q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f17749r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final cq f17750s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final sg f17751t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Set f17752u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Set f17753v;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f17754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f17755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.applovin.impl.sdk.j f17756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f17757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f17758e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f17759f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private jq f17760g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private nq f17761h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private dq f17762i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private cq f17763j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Set f17764k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Set f17765l;

        public b a(long j11) {
            this.f17757d = j11;
            return this;
        }

        public b a(cq cqVar) {
            this.f17763j = cqVar;
            return this;
        }

        public b a(dq dqVar) {
            this.f17762i = dqVar;
            return this;
        }

        public b a(jq jqVar) {
            this.f17760g = jqVar;
            return this;
        }

        public b a(nq nqVar) {
            this.f17761h = nqVar;
            return this;
        }

        public b a(com.applovin.impl.sdk.j jVar) {
            if (jVar == null) {
                throw new IllegalArgumentException("No sdk specified.");
            }
            this.f17756c = jVar;
            return this;
        }

        public b a(String str) {
            this.f17759f = str;
            return this;
        }

        public b a(Set set) {
            this.f17765l = set;
            return this;
        }

        public b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new IllegalArgumentException("No ad object specified.");
            }
            this.f17754a = jSONObject;
            return this;
        }

        public aq a() {
            return new aq(this);
        }

        public b b(String str) {
            this.f17758e = str;
            return this;
        }

        public b b(Set set) {
            this.f17764k = set;
            return this;
        }

        public b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new IllegalArgumentException("No full ad response specified.");
            }
            this.f17755b = jSONObject;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        COMPANION_AD,
        VIDEO
    }

    /* JADX INFO: compiled from: source.java */
    public enum d {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        INDUSTRY_ICON_IMPRESSION,
        INDUSTRY_ICON_CLICK,
        ERROR
    }

    private aq(b bVar) {
        super(bVar.f17754a, bVar.f17755b, bVar.f17756c);
        this.f17743l = bVar.f17758e;
        this.f17745n = bVar.f17760g;
        this.f17744m = bVar.f17759f;
        this.f17747p = bVar.f17761h;
        this.f17748q = bVar.f17762i;
        this.f17750s = bVar.f17763j;
        this.f17752u = bVar.f17764k;
        this.f17753v = bVar.f17765l;
        this.f17751t = new sg(this);
        Uri uriS0 = s0();
        if (uriS0 != null) {
            this.f17749r = uriS0.toString();
        } else {
            this.f17749r = "";
        }
        this.f17746o = bVar.f17757d;
    }

    private Set a(c cVar, String[] strArr) {
        dq dqVar;
        nq nqVar;
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptySet();
        }
        Map mapC = (cVar != c.VIDEO || (nqVar = this.f17747p) == null) ? (cVar != c.COMPANION_AD || (dqVar = this.f17748q) == null) ? null : dqVar.c() : nqVar.d();
        HashSet hashSet = new HashSet();
        if (mapC != null && !mapC.isEmpty()) {
            for (String str : strArr) {
                if (mapC.containsKey(str)) {
                    hashSet.addAll((Collection) mapC.get(str));
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private Set i1() {
        dq dqVar = this.f17748q;
        return dqVar != null ? dqVar.a() : Collections.emptySet();
    }

    private String m1() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    private Set q1() {
        nq nqVar = this.f17747p;
        return nqVar != null ? nqVar.a() : Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List w(tl tlVar) {
        return yp.a(tlVar.a("vimp_urls", new JSONObject()), getClCode(), null, m1(), Q(), R0(), this.sdk);
    }

    public boolean A1() {
        return getBooleanFromAdObject("iopmsfsr", Boolean.TRUE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public List F() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new j1.a() { // from class: com.applovin.impl.ws
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f24163a.w((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("vimp_urls", new JSONObject()), getClCode(), null, m1(), Q(), R0(), this.sdk);
        }
        return listA;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean G0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && j() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean H0() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void K0() {
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String P() {
        return this.f17749r;
    }

    public Set a(d dVar, String str) {
        return a(dVar, new String[]{str});
    }

    public Set a(d dVar, String[] strArr) {
        this.sdk.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.sdk.J().a("VastAd", "Retrieving trackers of type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'...");
        }
        if (dVar == d.IMPRESSION) {
            return this.f17752u;
        }
        if (dVar == d.VIDEO_CLICK) {
            return q1();
        }
        if (dVar == d.COMPANION_CLICK) {
            return i1();
        }
        if (dVar == d.VIDEO) {
            return a(c.VIDEO, strArr);
        }
        if (dVar == d.COMPANION) {
            return a(c.COMPANION_AD, strArr);
        }
        if (dVar == d.INDUSTRY_ICON_CLICK) {
            return n1().a();
        }
        if (dVar == d.INDUSTRY_ICON_IMPRESSION) {
            return n1().e();
        }
        if (dVar == d.ERROR) {
            return this.f17753v;
        }
        this.sdk.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.sdk.J().b("VastAd", "Failed to retrieve trackers of invalid type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'");
        }
        return Collections.emptySet();
    }

    public void b(String str) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("html_template", str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aq) || !super.equals(obj)) {
            return false;
        }
        aq aqVar = (aq) obj;
        String str = this.f17743l;
        if (str == null ? aqVar.f17743l != null : !str.equals(aqVar.f17743l)) {
            return false;
        }
        String str2 = this.f17744m;
        if (str2 == null ? aqVar.f17744m != null : !str2.equals(aqVar.f17744m)) {
            return false;
        }
        jq jqVar = this.f17745n;
        if (jqVar == null ? aqVar.f17745n != null : !jqVar.equals(aqVar.f17745n)) {
            return false;
        }
        nq nqVar = this.f17747p;
        if (nqVar == null ? aqVar.f17747p != null : !nqVar.equals(aqVar.f17747p)) {
            return false;
        }
        dq dqVar = this.f17748q;
        if (dqVar == null ? aqVar.f17748q != null : !dqVar.equals(aqVar.f17748q)) {
            return false;
        }
        cq cqVar = this.f17750s;
        if (cqVar == null ? aqVar.f17750s != null : !cqVar.equals(aqVar.f17750s)) {
            return false;
        }
        Set set = this.f17752u;
        if (set == null ? aqVar.f17752u != null : !set.equals(aqVar.f17752u)) {
            return false;
        }
        Set set2 = this.f17753v;
        Set set3 = aqVar.f17753v;
        if (set2 != null) {
            return set2.equals(set3);
        }
        return set3 == null;
    }

    public cq g1() {
        return this.f17750s;
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public sg getAdEventTracker() {
        return this.f17751t;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        return this.f17746o;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    public dq h1() {
        return this.f17748q;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        List listF;
        nq nqVar = this.f17747p;
        return (nqVar == null || (listF = nqVar.f()) == null || listF.size() <= 0) ? false : true;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f17743l;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17744m;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        jq jqVar = this.f17745n;
        int iHashCode4 = (iHashCode3 + (jqVar != null ? jqVar.hashCode() : 0)) * 31;
        nq nqVar = this.f17747p;
        int iHashCode5 = (iHashCode4 + (nqVar != null ? nqVar.hashCode() : 0)) * 31;
        dq dqVar = this.f17748q;
        int iHashCode6 = (iHashCode5 + (dqVar != null ? dqVar.hashCode() : 0)) * 31;
        cq cqVar = this.f17750s;
        int iHashCode7 = (iHashCode6 + (cqVar != null ? cqVar.hashCode() : 0)) * 31;
        Set set = this.f17752u;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set set2 = this.f17753v;
        return iHashCode8 + (set2 != null ? set2.hashCode() : 0);
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.lg
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.TRUE) && this.f17750s != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j() {
        nq nqVar = this.f17747p;
        if (nqVar != null) {
            return nqVar.b();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j0() {
        return j();
    }

    public String j1() {
        return getStringFromAdObject("html_template", "");
    }

    public Uri k1() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public c l1() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? c.COMPANION_AD : c.VIDEO;
    }

    public gq n1() {
        nq nqVar = this.f17747p;
        if (nqVar != null) {
            return nqVar.e();
        }
        return null;
    }

    public long o1() {
        return getLongFromAdObject("real_close_delay", 0L);
    }

    public jq p1() {
        return this.f17745n;
    }

    public nq r1() {
        return this.f17747p;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri s0() {
        oq oqVarS1 = s1();
        if (oqVarS1 != null) {
            return oqVarS1.d();
        }
        return null;
    }

    public oq s1() {
        Long lF = e4.f(this.sdk);
        return this.f17747p.a(lF != null ? lF.longValue() : 0L);
    }

    public boolean t1() {
        return n1() != null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "VastAd{title='" + this.f17743l + "', adDescription='" + this.f17744m + "', systemInfo=" + this.f17745n + ", videoCreative=" + this.f17747p + ", companionAd=" + this.f17748q + ", adVerifications=" + this.f17750s + ", impressionTrackers=" + this.f17752u + ", errorTrackers=" + this.f17753v + '}';
    }

    public boolean u1() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    public void v1() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.c("vast_is_streaming");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    public boolean w1() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    public boolean x1() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    public boolean y1() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    public boolean z1() {
        return getBooleanFromAdObject("iopms", Boolean.FALSE);
    }
}
