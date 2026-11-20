package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collections;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mn extends in {

    /* JADX INFO: compiled from: source.java */
    public class a implements d4.e {
        public a() {
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            if (mn.this.h()) {
                com.applovin.impl.sdk.n nVar = mn.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    mn mnVar = mn.this;
                    mnVar.f24691c.b(mnVar.f24690b, "Reward validation failed with error code " + i11 + " but task was cancelled already");
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.n nVar2 = mn.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                mn mnVar2 = mn.this;
                mnVar2.f24691c.b(mnVar2.f24690b, "Reward validation failed with code " + i11 + " and error: " + str2);
            }
            mn.this.a(i11);
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            if (!mn.this.h()) {
                com.applovin.impl.sdk.n nVar = mn.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    mn mnVar = mn.this;
                    mnVar.f24691c.a(mnVar.f24690b, "Reward validation succeeded with code " + i11 + " and response: " + jSONObject);
                }
                mn.this.c(jSONObject);
                return;
            }
            com.applovin.impl.sdk.n nVar2 = mn.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                mn mnVar2 = mn.this;
                mnVar2.f24691c.b(mnVar2.f24690b, "Reward validation succeeded with code " + i11 + " but task was cancelled already");
            }
            com.applovin.impl.sdk.n nVar3 = mn.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                mn mnVar3 = mn.this;
                mnVar3.f24691c.b(mnVar3.f24690b, "Response: " + jSONObject);
            }
        }
    }

    public mn(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    private fh b(JSONObject jSONObject) {
        Map<String, String> mapEmptyMap;
        String string;
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        e4.c(jSONObject2, this.f24689a);
        e4.b(jSONObject, this.f24689a);
        e4.a(jSONObject, this.f24689a);
        try {
            mapEmptyMap = JsonUtils.toStringMap((JSONObject) jSONObject2.get("params"));
        } catch (Throwable unused) {
            mapEmptyMap = Collections.emptyMap();
        }
        try {
            string = jSONObject2.getString("result");
        } catch (Throwable unused2) {
            string = "network_timeout";
        }
        return fh.a(string, mapEmptyMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        fh fhVarB = b(jSONObject);
        a(fhVarB);
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Pending reward handled: " + fhVarB);
        }
    }

    public abstract void a(fh fhVar);

    @Override // com.applovin.impl.in
    public int g() {
        return ((Integer) this.f24689a.a(sj.f23046r1)).intValue();
    }

    public abstract boolean h();

    @Override // java.lang.Runnable
    public void run() {
        a(e(), new a());
    }
}
