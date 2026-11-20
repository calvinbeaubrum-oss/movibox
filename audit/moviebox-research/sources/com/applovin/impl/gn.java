package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gn extends in {

    /* JADX INFO: compiled from: source.java */
    public class a implements d4.e {
        public a() {
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            gn.this.a(i11);
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            gn.this.b(jSONObject);
        }
    }

    public gn(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    private JSONObject a(fh fhVar) {
        JSONObject jSONObjectE = e();
        JsonUtils.putString(jSONObjectE, "result", fhVar.b());
        Map mapA = fhVar.a();
        if (mapA != null) {
            JsonUtils.putJSONObject(jSONObjectE, "params", new JSONObject(mapA));
        }
        return jSONObjectE;
    }

    public abstract void b(JSONObject jSONObject);

    @Override // com.applovin.impl.in
    public int g() {
        return ((Integer) this.f24689a.a(sj.f23054s1)).intValue();
    }

    public abstract fh h();

    public abstract void i();

    @Override // java.lang.Runnable
    public void run() {
        fh fhVarH = h();
        if (fhVarH == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Pending reward not found");
            }
            i();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Reporting pending reward: " + fhVarH + "...");
        }
        a(a(fhVarH), new a());
    }
}
