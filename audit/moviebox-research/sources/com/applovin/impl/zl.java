package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.hisavana.common.tracking.TrackingKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class zl extends yl {

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            e4.a(i11, this.f24689a);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            zl.this.a(jSONObject);
        }
    }

    public zl(com.applovin.impl.sdk.j jVar) {
        super("TaskApiSubmitData", jVar);
    }

    private void a(Map map, JSONObject jSONObject) {
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f24689a).b(e4.b("2.0/device", this.f24689a)).a(e4.a("2.0/device", this.f24689a)).b(map).a(jSONObject).c("POST").b(((Boolean) this.f24689a.a(sj.H5)).booleanValue()).a((Object) new JSONObject()).a(((Integer) this.f24689a.a(sj.f22992k3)).intValue()).a(vi.a.a(((Integer) this.f24689a.a(sj.f23058s5)).intValue())).a(), this.f24689a);
        aVar.c(sj.P0);
        aVar.b(sj.Q0);
        this.f24689a.j0().a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.f24689a.h0().a(sj.f22956g, JsonUtils.getString(jSONObject2, "device_id", ""));
        this.f24689a.h0().a(sj.f22988k, JsonUtils.getString(jSONObject2, "device_token", ""));
        e4.a(jSONObject2, this.f24689a);
        this.f24689a.D().b();
    }

    private void b(JSONObject jSONObject) {
        if (((Boolean) this.f24689a.a(sj.I4)).booleanValue()) {
            JsonUtils.putJSONObjectIfValid(jSONObject, "stats", this.f24689a.D().c());
        }
    }

    private void c(JSONObject jSONObject) {
        com.applovin.impl.sdk.k kVarY = this.f24689a.y();
        Map mapL = kVarY.l();
        yp.a(TrackingKey.PLATFORM, "type", mapL);
        yp.a("api_level", "sdk_version", mapL);
        JsonUtils.putObject(jSONObject, "device_info", new JSONObject(mapL));
        Map mapA = kVarY.A();
        yp.a("sdk_version", "applovin_sdk_version", mapA);
        yp.a("ia", "installed_at", mapA);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(mapA));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.d(this.f24690b, "Submitting user data...");
        }
        Map mapC = e4.c(this.f24689a);
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        b(jSONObject);
        if (((Boolean) this.f24689a.a(sj.A5)).booleanValue() || ((Boolean) this.f24689a.a(sj.f23074u5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a(mapC, jSONObject);
    }
}
