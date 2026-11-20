package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class lm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f20477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f20478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f20479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f20480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f20481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final JSONArray f20482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Context f20483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.applovin.impl.mediation.ads.a.InterfaceC0188a f20484o;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            lm.this.a(str, i11, str2);
            this.f24689a.E().a("fetchMediatedAd", str, i11, CollectionUtils.hashMap(TrackingKey.ERROR_MESSAGE, str2));
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            if (i11 != 200) {
                lm.this.a(str, i11, (String) null);
                return;
            }
            JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f18478m.a());
            JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f18478m.b());
            HashMap map = new HashMap(6);
            CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
            CollectionUtils.putStringIfValid(TrackingKey.CODE, String.valueOf(i11), map);
            CollectionUtils.putStringIfValid("ad_unit_id", lm.this.f20477h, map);
            CollectionUtils.putStringIfValid("ad_format", lm.this.f20478i.getLabel(), map);
            CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.f18478m.a()), map);
            CollectionUtils.putStringIfValid("response_size", String.valueOf(this.f18478m.b()), map);
            this.f24689a.E().a(la.f20390s, (Map) map);
            lm.this.b(jSONObject);
        }
    }

    public lm(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, JSONArray jSONArray, Context context, com.applovin.impl.sdk.j jVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        super("TaskFetchMediatedAd", jVar, str);
        this.f20477h = str;
        this.f20478i = maxAdFormat;
        this.f20479j = map;
        this.f20480k = map2;
        this.f20481l = map3;
        this.f20482m = jSONArray;
        this.f20483n = context;
        this.f20484o = interfaceC0188a;
    }

    private void a(da daVar) {
        ca caVar = ca.f18150g;
        long jB = daVar.b(caVar);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jB > TimeUnit.MINUTES.toMillis(((Integer) this.f24689a.a(sj.D3)).intValue())) {
            daVar.b(caVar, jCurrentTimeMillis);
            daVar.a(ca.f18151h);
            daVar.a(ca.f18152i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i11, String str2) {
        MaxErrorImpl maxErrorImpl;
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Unable to fetch ad for ad unit " + this.f20477h + ": server returned " + i11);
        }
        if (i11 == -800) {
            this.f24689a.D().c(ca.f18163t);
        }
        if (i11 == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str2);
        } else if (i11 == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str2);
        } else {
            maxErrorImpl = StringUtils.isValidString(str2) ? new MaxErrorImpl(-1000, str2) : new MaxErrorImpl(-1);
        }
        HashMap map = new HashMap(5);
        CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
        CollectionUtils.putStringIfValid(TrackingKey.CODE, String.valueOf(i11), map);
        CollectionUtils.putStringIfValid(TrackingKey.ERROR_MESSAGE, str2, map);
        CollectionUtils.putStringIfValid("ad_unit_id", this.f20477h, map);
        CollectionUtils.putStringIfValid("ad_format", this.f20478i.getLabel(), map);
        this.f24689a.E().a(la.f20391t, (Map) map);
        gc.a(this.f20484o, this.f20477h, maxErrorImpl);
    }

    private void a(JSONObject jSONObject) {
        yl wmVar = this.f24689a.a(ve.G7, this.f20478i) ? new wm(this.f20477h, this.f20478i, this.f20479j, jSONObject, this.f20483n, this.f24689a, this.f20484o) : new xm(this.f20477h, this.f20478i, this.f20479j, jSONObject, this.f20483n, this.f24689a, this.f20484o);
        long j11 = JsonUtils.getLong(jSONObject, "process_waterfall_delay_ms", -1L);
        if (j11 > 0) {
            this.f24689a.j0().a(wmVar, tm.b.MEDIATION, j11, true);
        } else {
            this.f24689a.j0().a(wmVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        try {
            e4.c(jSONObject, this.f24689a);
            e4.b(jSONObject, this.f24689a);
            e4.a(jSONObject, this.f24689a);
            qe.f(jSONObject, this.f24689a);
            qe.d(jSONObject, this.f24689a);
            qe.e(jSONObject, this.f24689a);
            qe.g(jSONObject, this.f24689a);
            u0.b(this.f24689a);
            MaxAdFormat fromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "ad_format", null));
            if (this.f20478i == fromString) {
                a(jSONObject);
                return;
            }
            String label = fromString != null ? fromString.getLabel() : "UNKNOWN";
            String str = "Incorrect format (" + label + ") loaded for (" + this.f20478i.getLabel() + ") ad. Please verify if the ad unit ID (" + this.f20477h + ") is assigned to the correct ad format.";
            if (yp.a(this.f20478i, fromString)) {
                com.applovin.impl.sdk.n.j(this.f24690b, str);
                a(jSONObject);
                return;
            }
            q6.a(str, new Object[0]);
            com.applovin.impl.sdk.n.h(this.f24690b, str);
            this.f20484o.onAdLoadFailed(this.f20477h, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str));
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("ad_unit_id", this.f20477h);
            CollectionUtils.putStringIfValid("name", this.f20478i.getLabel(), mapHashMap);
            CollectionUtils.putStringIfValid("details", label, mapHashMap);
            this.f24689a.E().a(la.L, "incompatible_ad_format", (Map) mapHashMap);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Unable to process mediated ad response for ad unit " + this.f20477h, th2);
            }
            throw new RuntimeException("Unable to process ad: " + th2);
        }
    }

    private void c(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f24689a.Q().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData == null || !yp.f(com.applovin.impl.sdk.j.l())) {
            return;
        }
        JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
    }

    private void d(JSONObject jSONObject) {
        if (((Boolean) this.f24689a.a(sj.J4)).booleanValue()) {
            ye yeVarR = this.f24689a.R();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            we weVar = we.f24088c;
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) yeVarR.a(weVar, xe.a.AD_UNIT_ID));
            JsonUtils.putJSONObject(jSONObject2, "arpau", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.putAll(jSONObject4, (Map<String, ?>) yeVarR.a(weVar, xe.a.AD_FORMAT));
            JsonUtils.putJSONObject(jSONObject2, "arpaf", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            JsonUtils.putAll(jSONObject5, (Map<String, ?>) yeVarR.a(we.f24089d, xe.a.AD));
            JsonUtils.putJSONObject(jSONObject2, "ttdasipa_ms", jSONObject5);
            JsonUtils.putJSONObject(jSONObject, "mediation_stats", jSONObject2);
        }
    }

    private String e() {
        return qe.a(this.f24689a);
    }

    private void e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f20477h);
        jSONObject2.put("ad_format", this.f20478i.getLabel());
        Map map = CollectionUtils.map(this.f20480k);
        com.applovin.impl.sdk.o oVarT = this.f24689a.T();
        CollectionUtils.putStringIfValid("previous_request_id", oVarT.b(this.f20477h), map);
        CollectionUtils.putStringIfValid("previous_loaded_request_id", oVarT.a(this.f20477h), map);
        com.applovin.impl.sdk.o.a aVarC = oVarT.c(this.f20477h);
        if (aVarC != null) {
            if (Boolean.parseBoolean(this.f24689a.g0().getExtraParameters().get("esc"))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", "AppLovin");
            } else {
                map.put("previous_winning_network", aVarC.a());
                map.put("previous_winning_network_name", aVarC.c());
                CollectionUtils.putStringIfValid("second_previous_winning_network", aVarC.d(), map);
                CollectionUtils.putStringIfValid("second_previous_winning_network_name", aVarC.e(), map);
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private String f() {
        return qe.b(this.f24689a);
    }

    private void f(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.f24689a.M().a()));
            jSONObject2.put("installed", af.a(this.f24689a));
            jSONObject2.put("initialized", this.f24689a.L().b());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.f24689a.L().a()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f24689a.M().c()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f24689a.M().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e11) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Failed to populate adapter classNames", e11);
            }
            throw new RuntimeException("Failed to populate classNames: " + e11);
        }
    }

    private JSONObject g() throws JSONException {
        Map mapA = this.f24689a.y().a(null, false, true);
        mapA.putAll(this.f20481l);
        JSONObject jSONObject = new JSONObject(mapA);
        e(jSONObject);
        h(jSONObject);
        f(jSONObject);
        c(jSONObject);
        g(jSONObject);
        d(jSONObject);
        return jSONObject;
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f24689a.g0().getExtraParameters()));
    }

    private Map h() {
        HashMap map = new HashMap(2);
        map.put("AppLovin-Ad-Unit-Id", this.f20477h);
        map.put("AppLovin-Ad-Format", this.f20478i.getLabel());
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", this.f20480k.get("retry_attempt"), map);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", this.f20480k.get("retry_delay_sec"), map);
        return map;
    }

    private void h(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f20482m;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Fetching next ad for " + this.f20478i.getLabel() + " ad unit " + this.f20477h);
        }
        pb.a();
        if (((Boolean) this.f24689a.a(sj.f22922b4)).booleanValue() && yp.j() && com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "User is connected to a VPN");
        }
        this.f24689a.E().a(la.f20389r, this.f20478i, this.f20477h, (MaxError) null);
        if (((Boolean) this.f24689a.a(sj.J4)).booleanValue()) {
            ye yeVarR = this.f24689a.R();
            we weVar = we.f24088c;
            yeVarR.a(weVar, xe.a(this.f20477h));
            yeVarR.a(weVar, xe.a(this.f20478i));
        }
        yp.a(this.f24689a, this.f24690b);
        da daVarD = this.f24689a.D();
        daVarD.c(ca.f18162s);
        ca caVar = ca.f18150g;
        if (daVarD.b(caVar) == 0) {
            daVarD.b(caVar, System.currentTimeMillis());
        }
        try {
            JSONObject jSONObjectG = g();
            HashMap map = new HashMap();
            if (!((Boolean) this.f24689a.a(sj.f23090w5)).booleanValue() && !((Boolean) this.f24689a.a(sj.f23074u5)).booleanValue()) {
                map.put("rid", UUID.randomUUID().toString());
            }
            if (!((Boolean) this.f24689a.a(sj.f22970h5)).booleanValue()) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f24689a.b0());
            }
            if (this.f24689a.l0().c()) {
                map.put("test_mode", "1");
            }
            List listB = this.f24689a.l0().b();
            String str = this.f24689a.g0().getExtraParameters().get(ComConstants.PLATFORM_FACEBOOK);
            if (listB != null && !listB.isEmpty()) {
                String strA = lz.a(",", listB);
                map.put("filter_ad_network", strA);
                if (!this.f24689a.l0().c()) {
                    map.put("fhkZsVqYC7", "1");
                }
                if (this.f24689a.l0().d()) {
                    map.put("force_ad_network", strA);
                }
            } else if (StringUtils.isValidString(str)) {
                map.put("filter_ad_network", str);
            }
            a(daVarD);
            a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f24689a).c("POST").a(h()).b(f()).a(e()).b(map).a(jSONObjectG).b(((Boolean) this.f24689a.a(ve.S7)).booleanValue()).a((Object) new JSONObject()).c(((Long) this.f24689a.a(ve.L6)).intValue()).a(((Integer) this.f24689a.a(sj.f22968h3)).intValue()).b(((Long) this.f24689a.a(ve.K6)).intValue()).a(vi.a.a(((Integer) this.f24689a.a(sj.f23018n5)).intValue())).f(true).a(), this.f24689a);
            aVar.c(ve.I6);
            aVar.b(ve.J6);
            this.f24689a.j0().a(aVar);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Unable to fetch ad for Ad Unit ID: " + this.f20477h, th2);
            }
            a("", 0, th2.getMessage());
        }
    }
}
