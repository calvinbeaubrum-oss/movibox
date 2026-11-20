package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ge extends pe implements MaxAd {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f19208l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f19209m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f19210n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected com.applovin.impl.mediation.g f19211o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f19212p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MaxAdWaterfallInfo f19213q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f19214r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f19215s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f19216t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private cd f19217u;

    public ge(int i11, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.g gVar, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, jVar);
        this.f19209m = new AtomicBoolean();
        this.f19210n = new AtomicBoolean();
        this.f19208l = i11;
        this.f19211o = gVar;
        this.f19212p = gVar != null ? gVar.b() : null;
    }

    private long M() {
        return a("load_started_time_ms", 0L);
    }

    public static ge a(int i11, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(jSONObject2, "ad_format", null);
        MaxAdFormat fromString = MaxAdFormat.formatFromString(string);
        Objects.requireNonNull(fromString, "Invalid ad format for string: " + string);
        if (fromString.isAdViewAd()) {
            return new he(i11, map, jSONObject, jSONObject2, jVar);
        }
        if (fromString == MaxAdFormat.NATIVE) {
            return new je(i11, map, jSONObject, jSONObject2, jVar);
        }
        if (fromString.isFullscreenAd()) {
            return new ie(i11, map, jSONObject, jSONObject2, jVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject b(tl tlVar) {
        return JsonUtils.deepCopy(tlVar.a("ad_values", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle c(tl tlVar) {
        JSONObject jSONObjectA;
        if (tlVar.a("credentials")) {
            jSONObjectA = tlVar.a("credentials", new JSONObject());
        } else {
            jSONObjectA = tlVar.a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, "placement_id", V());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ cd d(tl tlVar) {
        return new cd(tlVar.a("hybrid_ad_config", (JSONObject) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject e(tl tlVar) {
        return JsonUtils.deepCopy(tlVar.a("publisher_extra_info", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double f(tl tlVar) {
        return Double.valueOf(JsonUtils.getDouble(tlVar.a("revenue_parameters", (JSONObject) null), "revenue", -1.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject g(tl tlVar) {
        return JsonUtils.deepCopy(tlVar.a("revenue_parameters", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(tl tlVar) {
        return JsonUtils.getString(tlVar.a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    public String A() {
        return this.f19212p;
    }

    public com.applovin.impl.mediation.g B() {
        return this.f19211o;
    }

    public String C() {
        return a("bcode", "");
    }

    public long D() {
        return a("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1L, l()));
    }

    public String E() {
        return a("bid_response", (String) null);
    }

    public long F() {
        return a("bwt_ms", ((Long) this.f21736a.a(ve.H7)).longValue());
    }

    public Bundle G() {
        JSONObject jSONObjectA;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return (Bundle) tlVar.a(new j1.a() { // from class: com.applovin.impl.tx
                @Override // j1.a
                public final Object apply(Object obj) {
                    return this.f23436a.c((tl) obj);
                }
            });
        }
        if (c("credentials")) {
            jSONObjectA = a("credentials", new JSONObject());
        } else {
            jSONObjectA = a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, "placement_id", V());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    public long H() {
        if (M() > 0) {
            return L() - M();
        }
        return -1L;
    }

    public cd I() {
        cd cdVar = this.f19217u;
        if (cdVar != null) {
            return cdVar;
        }
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            this.f19217u = (cd) tlVar.a(new j1.a() { // from class: com.applovin.impl.px
                @Override // j1.a
                public final Object apply(Object obj) {
                    return ge.d((tl) obj);
                }
            });
        } else {
            this.f19217u = new cd(a("hybrid_ad_config", (JSONObject) null));
        }
        return this.f19217u;
    }

    public MaxAdFormat J() {
        String strA = a("haf", (String) null);
        if (StringUtils.isValidString(strA)) {
            return MaxAdFormat.formatFromString(strA);
        }
        return null;
    }

    public int K() {
        return this.f19208l;
    }

    public long L() {
        return a("load_completed_time_ms", 0L);
    }

    public String N() {
        return this.f19215s;
    }

    public int O() {
        return a("mwalra", ((Integer) this.f21736a.a(ve.f23903z7)).intValue());
    }

    public double P() {
        return a(BidResponsed.KEY_PRICE, -1.0f);
    }

    public JSONObject Q() {
        tl tlVar = this.f21743i;
        return tlVar != null ? (JSONObject) tlVar.a(new j1.a() { // from class: com.applovin.impl.rx
            @Override // j1.a
            public final Object apply(Object obj) {
                return ge.e((tl) obj);
            }
        }) : a("publisher_extra_info", new JSONObject());
    }

    public String R() {
        return JsonUtils.getString(S(), "revenue_event", "");
    }

    public JSONObject S() {
        tl tlVar = this.f21743i;
        return tlVar != null ? (JSONObject) tlVar.a(new j1.a() { // from class: com.applovin.impl.ux
            @Override // j1.a
            public final Object apply(Object obj) {
                return ge.g((tl) obj);
            }
        }) : a("revenue_parameters", new JSONObject());
    }

    public String T() {
        return b("event_id", "");
    }

    public long U() {
        return a("twt_ms", ((Long) this.f21736a.a(ve.I7)).longValue());
    }

    public String V() {
        return a("third_party_ad_placement_id", (String) null);
    }

    public long W() {
        return a("walrad_ms", ((Long) this.f21736a.a(ve.A7)).longValue());
    }

    public List X() {
        return b("mwf_info_urls");
    }

    public String Y() {
        return b("waterfall_name", "");
    }

    public String Z() {
        return b("waterfall_test_name", "");
    }

    public abstract ge a(com.applovin.impl.mediation.g gVar);

    public void a(long j11) {
        this.f19214r = j11;
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("ad_values")) {
            a(BundleUtils.toJSONObject(bundle.getBundle("ad_values")));
        }
        if (bundle.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && !c(CampaignEx.JSON_KEY_CREATIVE_ID)) {
            c(CampaignEx.JSON_KEY_CREATIVE_ID, BundleUtils.getString(CampaignEx.JSON_KEY_CREATIVE_ID, bundle));
        }
        if (bundle.containsKey("ad_width") && !c("ad_width") && bundle.containsKey("ad_height") && !c("ad_height")) {
            int i11 = BundleUtils.getInt("ad_width", bundle);
            int i12 = BundleUtils.getInt("ad_height", bundle);
            c("ad_width", i11);
            c("ad_height", i12);
        }
        if (bundle.containsKey("publisher_extra_info")) {
            b(BundleUtils.toJSONObject(bundle.getBundle("publisher_extra_info")));
        }
    }

    public void a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.f19213q = maxAdWaterfallInfo;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectY = y();
        JsonUtils.putAll(jSONObjectY, jSONObject);
        a("ad_values", (Object) jSONObjectY);
    }

    public boolean a0() {
        return StringUtils.isValidString(E());
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectQ = Q();
        JsonUtils.putAll(jSONObjectQ, jSONObject);
        a("publisher_extra_info", (Object) jSONObjectQ);
    }

    public boolean b0() {
        return J() != null;
    }

    public boolean c0() {
        return a("is_js_tag_ad", Boolean.FALSE).booleanValue();
    }

    public boolean d0() {
        com.applovin.impl.mediation.g gVar = this.f19211o;
        return gVar != null && gVar.k() && this.f19211o.j();
    }

    public boolean e0() {
        return a("only_load_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean f0() {
        return a("prefer_load_when_initialized", Boolean.TRUE).booleanValue();
    }

    public void g0() {
        c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdReviewCreativeId() {
        return this.f19216t;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str, String str2) {
        JSONObject jSONObjectY = y();
        if (jSONObjectY.has(str)) {
            return JsonUtils.getString(jSONObjectY, str, str2);
        }
        Bundle bundleL = l();
        if (bundleL.containsKey(str)) {
            return bundleL.getString(str);
        }
        JSONObject jSONObjectQ = Q();
        return jSONObjectQ.has(str) ? JsonUtils.getString(jSONObjectQ, str, str2) : a(str, str2);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getCreativeId() {
        return a(CampaignEx.JSON_KEY_CREATIVE_ID, (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspId() {
        return a("dsp_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspName() {
        return a("dsp_name", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(a("ad_format", b("ad_format", (String) null)));
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxNativeAd getNativeAd() {
        com.applovin.impl.mediation.g gVar = this.f19211o;
        if (gVar != null) {
            return gVar.e();
        }
        return null;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkName() {
        return a("network_name", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(V());
    }

    @Override // com.applovin.mediation.MaxAd
    public long getRequestLatencyMillis() {
        return this.f19214r;
    }

    @Override // com.applovin.mediation.MaxAd
    public double getRevenue() {
        if (!((Boolean) this.f21736a.a(ve.E7)).booleanValue() || !getFormat().isFullscreenAd() || v().get()) {
            tl tlVar = this.f21743i;
            return tlVar != null ? ((Double) tlVar.a(new j1.a() { // from class: com.applovin.impl.ox
                @Override // j1.a
                public final Object apply(Object obj) {
                    return ge.f((tl) obj);
                }
            })).doubleValue() : JsonUtils.getDouble(a("revenue_parameters", (JSONObject) null), "revenue", -1.0d);
        }
        this.f21736a.J();
        if (!com.applovin.impl.sdk.n.a()) {
            return 0.0d;
        }
        this.f21736a.J().b("MediatedAd", "Attempting to retrieve revenue when not available yet");
        return 0.0d;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getRevenuePrecision() {
        tl tlVar = this.f21743i;
        return tlVar != null ? (String) tlVar.a(new j1.a() { // from class: com.applovin.impl.sx
            @Override // j1.a
            public final Object apply(Object obj) {
                return ge.h((tl) obj);
            }
        }) : JsonUtils.getString(a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public AppLovinSdkUtils.Size getSize() {
        int iA = a("ad_width", -3);
        int iA2 = a("ad_height", -3);
        return (iA == -3 || iA2 == -3) ? getFormat().getSize() : new AppLovinSdkUtils.Size(iA, iA2);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdWaterfallInfo getWaterfall() {
        return this.f19213q;
    }

    public void h(String str) {
        this.f19216t = str;
    }

    public void h0() {
        c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public void i(String str) {
        this.f19215s = str;
    }

    @Override // com.applovin.impl.pe
    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + V() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }

    public void u() {
        this.f19211o = null;
        this.f19213q = null;
    }

    public AtomicBoolean v() {
        return this.f19209m;
    }

    public String w() {
        return a("adomain", (String) null);
    }

    public AtomicBoolean x() {
        return this.f19210n;
    }

    public JSONObject y() {
        tl tlVar = this.f21743i;
        return tlVar != null ? (JSONObject) tlVar.a(new j1.a() { // from class: com.applovin.impl.qx
            @Override // j1.a
            public final Object apply(Object obj) {
                return ge.b((tl) obj);
            }
        }) : a("ad_values", new JSONObject());
    }

    public View z() {
        com.applovin.impl.mediation.g gVar;
        if (!d0() || (gVar = this.f19211o) == null) {
            return null;
        }
        return gVar.d();
    }
}
