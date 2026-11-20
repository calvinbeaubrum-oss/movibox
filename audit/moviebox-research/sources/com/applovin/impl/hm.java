package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.hisavana.common.tracking.TrackingKey;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final h0 f19510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f19511i;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, JSONObject jSONObject) {
            hm.this.a(i11, str2);
            this.f24689a.E().a("fetchAd", str, i11, CollectionUtils.hashMap(TrackingKey.ERROR_MESSAGE, str2));
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i11) {
            if (i11 != 200) {
                hm.this.a(i11, MaxAdapterError.NO_FILL.getErrorMessage());
                return;
            }
            JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f18478m.a());
            JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f18478m.b());
            HashMap map = new HashMap(5);
            CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
            CollectionUtils.putStringIfValid(TrackingKey.CODE, String.valueOf(i11), map);
            CollectionUtils.putStringIfValid("ad_zone_id", hm.this.f19510h.e(), map);
            CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.f18478m.a()), map);
            CollectionUtils.putStringIfValid("response_size", String.valueOf(this.f18478m.b()), map);
            this.f24689a.E().a(la.f20378g, (Map) map);
            hm.this.b(jSONObject);
        }
    }

    public hm(h0 h0Var, String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
        this.f19510h = h0Var;
        this.f19511i = jVar.b();
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

    private Map g() {
        HashMap map = new HashMap(3);
        map.put("AppLovin-Zone-Id", this.f19510h.e());
        if (this.f19510h.f() != null) {
            map.put("AppLovin-Ad-Size", this.f19510h.f().getLabel());
        }
        if (this.f19510h.g() != null) {
            map.put("AppLovin-Ad-Type", this.f19510h.g().getLabel());
        }
        return map;
    }

    public abstract yl a(JSONObject jSONObject);

    public void a(int i11, String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Unable to fetch " + this.f19510h + " ad: server returned " + i11);
        }
        if (i11 == -800) {
            this.f24689a.D().c(ca.f18156m);
        }
        this.f24689a.E().a(la.f20379h, this.f19510h, new AppLovinError(i11, str));
    }

    public void b(JSONObject jSONObject) {
        e4.c(jSONObject, this.f24689a);
        e4.b(jSONObject, this.f24689a);
        e4.a(jSONObject, this.f24689a);
        h0.a(jSONObject);
        this.f24689a.j0().a(a(jSONObject));
    }

    public abstract String e();

    public abstract String f();

    public Map h() {
        HashMap map = new HashMap(4);
        map.put("zone_id", this.f19510h.e());
        if (this.f19510h.f() != null) {
            map.put("size", this.f19510h.f().getLabel());
        }
        if (this.f19510h.g() != null) {
            map.put("require", this.f19510h.g().getLabel());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        vi.a aVarA;
        Map map;
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Fetching next ad of zone: " + this.f19510h);
        }
        if (((Boolean) this.f24689a.a(sj.f22922b4)).booleanValue() && yp.j() && com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "User is connected to a VPN");
        }
        yp.a(this.f24689a, this.f24690b);
        JSONObject jSONObject = null;
        this.f24689a.E().a(la.f20377f, this.f19510h, (AppLovinError) null);
        da daVarD = this.f24689a.D();
        daVarD.c(ca.f18147d);
        ca caVar = ca.f18150g;
        if (daVarD.b(caVar) == 0) {
            daVarD.b(caVar, System.currentTimeMillis());
        }
        try {
            JSONObject andResetCustomPostBody = this.f24689a.i().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.f24689a.a(sj.f23056s3)).booleanValue()) {
                vi.a aVarA2 = vi.a.a(((Integer) this.f24689a.a(sj.f23034p5)).intValue());
                JSONObject jSONObject2 = new JSONObject(this.f24689a.y().a(h(), false, true));
                map = new HashMap();
                if (!((Boolean) this.f24689a.a(sj.f23106y5)).booleanValue() && !((Boolean) this.f24689a.a(sj.f23074u5)).booleanValue()) {
                    map.put("rid", UUID.randomUUID().toString());
                }
                if (!((Boolean) this.f24689a.a(sj.f22970h5)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f24689a.b0());
                }
                JsonUtils.putAll(jSONObject2, andResetCustomPostBody);
                aVarA = aVarA2;
                jSONObject = jSONObject2;
            } else {
                aVarA = vi.a.a(((Integer) this.f24689a.a(sj.f23042q5)).intValue());
                Map mapA = yp.a(this.f24689a.y().a(h(), false, false));
                if (andResetCustomPostBody != null) {
                    jSONObject = andResetCustomPostBody;
                } else {
                    str = "GET";
                }
                map = mapA;
            }
            if (yp.f(a())) {
                map.putAll(this.f24689a.i().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.f19511i)) {
                map.put("sts", this.f19511i);
            }
            a(daVarD);
            com.applovin.impl.sdk.network.a.C0202a c0202aF = com.applovin.impl.sdk.network.a.a(this.f24689a).b(f()).a(e()).b(map).c(str).a(g()).a((Object) new JSONObject()).a(((Integer) this.f24689a.a(sj.f22968h3)).intValue()).c(((Boolean) this.f24689a.a(sj.f22976i3)).booleanValue()).d(((Boolean) this.f24689a.a(sj.f22984j3)).booleanValue()).c(((Integer) this.f24689a.a(sj.f22960g3)).intValue()).a(aVarA).f(true);
            if (jSONObject != null) {
                c0202aF.a(jSONObject);
                c0202aF.b(((Boolean) this.f24689a.a(sj.I5)).booleanValue());
            }
            a aVar = new a(c0202aF.a(), this.f24689a);
            aVar.c(sj.N0);
            aVar.b(sj.O0);
            this.f24689a.j0().a(aVar);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Unable to fetch ad for zone id: " + this.f19510h, th2);
            }
            a(0, th2.getMessage());
        }
    }
}
