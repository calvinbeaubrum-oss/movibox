package com.applovin.impl;

import android.app.ActivityManager;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import com.hisavana.common.tracking.TrackingKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class jm extends yl {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicBoolean f19991k = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f19992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f19993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f19994j;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z11) {
            super(aVar, jVar, z11);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to fetch basic SDK settings: server returned " + i11);
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jm.this.a(jSONObject);
            this.f24689a.E().a("fetchBasicSettings", str, i11, CollectionUtils.hashMap(TrackingKey.ERROR_MESSAGE, str2));
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            jm.this.a(jSONObject);
            this.f24689a.E().a("fetchBasicSettings", str, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends yl {
        public c(com.applovin.impl.sdk.j jVar) {
            super("TaskTimeoutFetchBasicSettings", jVar, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jm.this.f19994j != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "Timing out fetch basic settings...");
                }
                jm.this.a(new JSONObject());
            }
        }
    }

    public jm(int i11, com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskFetchBasicSettings", jVar, true);
        this.f19993i = new Object();
        this.f19992h = i11;
        this.f19994j = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        b bVar;
        synchronized (this.f19993i) {
            bVar = this.f19994j;
            this.f19994j = null;
        }
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }

    private String f() {
        return e4.a((String) this.f24689a.a(sj.M0), "5.0/i", b());
    }

    private String g() {
        return e4.a((String) this.f24689a.a(sj.L0), "5.0/i", b());
    }

    public JSONObject e() {
        List<String> adUnitIds;
        JSONObject jSONObject = new JSONObject();
        try {
            com.applovin.impl.sdk.j jVar = this.f24689a;
            sj sjVar = sj.f23074u5;
            if (((Boolean) jVar.a(sjVar)).booleanValue() || ((Boolean) this.f24689a.a(sjVar)).booleanValue()) {
                jSONObject.put("rid", UUID.randomUUID().toString());
            }
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            JsonUtils.putStringIfValid(jSONObject, "ad_review_sdk_version", v.b());
            jSONObject.put("init_count", this.f19992h);
            jSONObject.put("server_installed_at", this.f24689a.a(sj.f23028p));
            jSONObject.put("legacy", this.f24689a.z0().get());
            if (this.f24689a.v0()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f24689a.t0()) {
                jSONObject.put("first_install_v2", true);
            }
            JsonUtils.putStringIfValid(jSONObject, "process_name", yp.b(a()));
            JsonUtils.putBooleanIfValid(jSONObject, "is_main_process", yp.g(a()));
            JsonUtils.putStringIfValid(jSONObject, "plugin_version", (String) this.f24689a.a(sj.U3));
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider", this.f24689a.O());
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider_v2", this.f24689a.z());
            jSONObject.put("installed_mediation_adapters", af.a(this.f24689a));
            Map mapA = this.f24689a.y().A();
            jSONObject.put("package_name", mapA.get("package_name"));
            jSONObject.put("app_version", mapA.get("app_version"));
            jSONObject.put("test_ads", mapA.get("test_ads"));
            jSONObject.put("debug", mapA.get("debug"));
            jSONObject.put("tg", mapA.get("tg"));
            jSONObject.put("target_sdk", mapA.get("target_sdk"));
            if (this.f24689a.z0().get()) {
                adUnitIds = this.f24689a.g0().getInitializationAdUnitIds();
            } else {
                adUnitIds = this.f24689a.H() != null ? this.f24689a.H().getAdUnitIds() : null;
            }
            if (adUnitIds != null && adUnitIds.size() > 0) {
                List<String> listRemoveTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(adUnitIds);
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(listRemoveTrimmedEmptyStrings, listRemoveTrimmedEmptyStrings.size()));
            }
            jSONObject.put("IABTCF_TCString", mapA.get("IABTCF_TCString"));
            jSONObject.put("IABTCF_gdprApplies", mapA.get("IABTCF_gdprApplies"));
            Object obj = mapA.get("IABTCF_AddtlConsent");
            if (obj instanceof String) {
                JsonUtils.putStringIfValid(jSONObject, "IABTCF_AddtlConsent", (String) obj);
            }
            jSONObject.put("consent_flow_info", this.f24689a.u().c());
            Map mapG = this.f24689a.y().G();
            jSONObject.put(TrackingKey.PLATFORM, mapG.get(TrackingKey.PLATFORM));
            jSONObject.put("os", mapG.get("os"));
            jSONObject.put("locale", mapG.get("locale"));
            jSONObject.put("brand", mapG.get("brand"));
            jSONObject.put("brand_name", mapG.get("brand_name"));
            jSONObject.put("hardware", mapG.get("hardware"));
            jSONObject.put("model", mapG.get("model"));
            jSONObject.put("revision", mapG.get("revision"));
            jSONObject.put("is_tablet", mapG.get("is_tablet"));
            jSONObject.put("screen_size_in", mapG.get("screen_size_in"));
            jSONObject.put("supported_abis", mapG.get("supported_abis"));
            if (((Boolean) this.f24689a.a(sj.f22945e4)).booleanValue()) {
                jSONObject.put("mtl", this.f24689a.f0().getLastTrimMemoryLevel());
            }
            try {
                ActivityManager activityManager = (ActivityManager) com.applovin.impl.sdk.j.l().getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("fm", memoryInfo.availMem);
                    jSONObject.put("tm", memoryInfo.totalMem);
                    jSONObject.put("lmt", memoryInfo.threshold);
                    jSONObject.put("lm", memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            l0.a aVarF = this.f24689a.y().f();
            jSONObject.put("dnt", aVarF.c());
            jSONObject.put("dnt_code", aVarF.b().b());
            Boolean boolB = a4.c().b(a());
            if (((Boolean) this.f24689a.a(sj.Q3)).booleanValue() && StringUtils.isValidString(aVarF.a()) && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfa", aVarF.a());
            }
            com.applovin.impl.sdk.k.b bVarB = this.f24689a.y().B();
            if (((Boolean) this.f24689a.a(sj.J3)).booleanValue() && bVarB != null && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfv", bVarB.f22636a);
                jSONObject.put("idfv_scope", bVarB.f22637b);
            }
            if (((Boolean) this.f24689a.a(sj.M3)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f24689a.q());
            }
            if (((Boolean) this.f24689a.a(sj.O3)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f24689a.a0());
            }
            if (this.f24689a.l0().c()) {
                jSONObject.put("test_mode", true);
            }
            List listB = this.f24689a.l0().b();
            if (listB != null && !listB.isEmpty()) {
                jSONObject.put("test_mode_networks", listB);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.f24689a.g0().getExtraParameters()));
            Map mapD0 = this.f24689a.d0();
            if (!CollectionUtils.isEmpty(mapD0)) {
                jSONObject.put("segments", new JSONObject(mapD0));
            }
            if (this.f19992h > 1) {
                ArrayService arrayServiceM = this.f24689a.m();
                if (arrayServiceM.getIsDirectDownloadEnabled() != null) {
                    jSONObject.put("ah_dd_enabled", arrayServiceM.getIsDirectDownloadEnabled());
                }
                jSONObject.put("ah_sdk_version_code", arrayServiceM.getAppHubVersionCode());
                jSONObject.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceM.getRandomUserToken()));
                jSONObject.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceM.getAppHubPackageName()));
            }
        } catch (JSONException e11) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Failed to create JSON body", e11);
            }
            this.f24689a.E().a(this.f24690b, "createJSONBody", e11);
        }
        return jSONObject;
    }

    public Map h() {
        HashMap map = new HashMap();
        if (!((Boolean) this.f24689a.a(sj.f23082v5)).booleanValue() && !((Boolean) this.f24689a.a(sj.f23074u5)).booleanValue()) {
            map.put("rid", UUID.randomUUID().toString());
        }
        if (!((Boolean) this.f24689a.a(sj.f22970h5)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f24689a.b0());
        }
        Boolean boolB = a4.b().b(a());
        if (boolB != null) {
            map.put("huc", boolB.toString());
        }
        Boolean boolB2 = a4.c().b(a());
        if (boolB2 != null) {
            map.put("aru", boolB2.toString());
        }
        Boolean boolB3 = a4.a().b(a());
        if (boolB3 != null) {
            map.put("dns", boolB3.toString());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!z3.k() && f19991k.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(com.applovin.impl.sdk.j.l());
            } catch (Throwable th2) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Cannot update security provider", th2);
                }
            }
        }
        Map mapH = h();
        com.applovin.impl.sdk.network.a.C0202a c0202aB = com.applovin.impl.sdk.network.a.a(this.f24689a).b(g()).a(f()).b(mapH).a(e()).b(((Boolean) this.f24689a.a(sj.G5)).booleanValue()).c("POST").a((Object) new JSONObject()).a(((Integer) this.f24689a.a(sj.f23016n3)).intValue()).b(((Integer) this.f24689a.a(sj.f23040q3)).intValue());
        com.applovin.impl.sdk.j jVar = this.f24689a;
        sj sjVar = sj.f23008m3;
        com.applovin.impl.sdk.network.a aVarA = c0202aB.c(((Integer) jVar.a(sjVar)).intValue()).e(((Boolean) this.f24689a.a(sj.f23112z3)).booleanValue()).a(vi.a.a(((Integer) this.f24689a.a(sj.f23010m5)).intValue())).f(true).a();
        this.f24689a.j0().a(new c(this.f24689a), tm.b.TIMEOUT, ((long) ((Integer) this.f24689a.a(sjVar)).intValue()) + 250);
        a aVar = new a(aVarA, this.f24689a, d());
        aVar.c(sj.L0);
        aVar.b(sj.M0);
        this.f24689a.j0().a(aVar);
    }
}
