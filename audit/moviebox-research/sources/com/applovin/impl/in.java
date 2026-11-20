package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class in extends yl {

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ d4.e f19758n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, d4.e eVar) {
            super(aVar, jVar);
            this.f19758n = eVar;
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            this.f19758n.a(str, i11, str2, jSONObject);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            this.f19758n.a(str, jSONObject, i11);
        }
    }

    public in(String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
    }

    public void a(int i11) {
        e4.a(i11, this.f24689a);
    }

    public abstract void a(JSONObject jSONObject);

    public void a(JSONObject jSONObject, d4.e eVar) {
        Map mapC = e4.c(this.f24689a);
        if (((Boolean) this.f24689a.a(sj.B5)).booleanValue() || ((Boolean) this.f24689a.a(sj.f23074u5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f24689a).b(e4.b(f(), this.f24689a)).a(e4.a(f(), this.f24689a)).b(mapC).a(jSONObject).c("POST").b(((Boolean) this.f24689a.a(sj.K5)).booleanValue()).a((Object) new JSONObject()).a(g()).a(vi.a.a(((Integer) this.f24689a.a(sj.f23066t5)).intValue())).a(), this.f24689a, eVar);
        aVar.c(sj.P0);
        aVar.b(sj.Q0);
        this.f24689a.j0().a(aVar);
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        String strC = this.f24689a.q0().c();
        if (((Boolean) this.f24689a.a(sj.L3)).booleanValue() && StringUtils.isValidString(strC)) {
            JsonUtils.putString(jSONObject, "cuid", strC);
        }
        if (((Boolean) this.f24689a.a(sj.N3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f24689a.q());
        }
        if (((Boolean) this.f24689a.a(sj.P3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f24689a.a0());
        }
        a(jSONObject);
        return jSONObject;
    }

    public abstract String f();

    public abstract int g();
}
