package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.hisavana.common.tracking.TrackingKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class mm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d4.e f21181h;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z11) {
            super(aVar, jVar, z11);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            mm.this.f21181h.a(str, i11, str2, jSONObject);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            mm.this.f21181h.a(str, jSONObject, i11);
        }
    }

    public mm(d4.e eVar, com.applovin.impl.sdk.j jVar) {
        super("TaskFetchMediationDebuggerInfo", jVar, true);
        this.f21181h = eVar;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, "installed_mediation_adapters", af.a(this.f24689a));
        l0.a aVarF = this.f24689a.y().f();
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", aVarF.b().b());
        Boolean boolB = a4.c().b(a());
        if (((Boolean) this.f24689a.a(sj.S3)).booleanValue() && !Boolean.TRUE.equals(boolB)) {
            JsonUtils.putStringIfValid(jSONObject, "idfa", aVarF.a());
        }
        return jSONObject;
    }

    public Map f() {
        HashMap map = new HashMap();
        map.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.f24689a.a(sj.f22970h5)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f24689a.b0());
        }
        Map mapA = this.f24689a.y().A();
        map.put("package_name", String.valueOf(mapA.get("package_name")));
        map.put("app_version", String.valueOf(mapA.get("app_version")));
        Map mapG = this.f24689a.y().G();
        map.put(TrackingKey.PLATFORM, String.valueOf(mapG.get(TrackingKey.PLATFORM)));
        map.put("os", String.valueOf(mapG.get("os")));
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map mapF = f();
        JSONObject jSONObjectE = e();
        if (((Boolean) this.f24689a.a(sj.f23098x5)).booleanValue() || ((Boolean) this.f24689a.a(sj.f23074u5)).booleanValue()) {
            JsonUtils.putAll(jSONObjectE, (Map<String, ?>) mapF);
            mapF = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f24689a).c("POST").b(qe.i(this.f24689a)).a(qe.h(this.f24689a)).b(mapF).a(jSONObjectE).a((Object) new JSONObject()).c(((Long) this.f24689a.a(ve.M6)).intValue()).a(vi.a.a(((Integer) this.f24689a.a(sj.f23026o5)).intValue())).a(), this.f24689a, d());
        aVar.c(ve.I6);
        aVar.b(ve.J6);
        this.f24689a.j0().a(aVar);
    }
}
