package com.mbridge.msdk.newreward.function.d.b;

import com.mbridge.msdk.e.a.m;
import com.mbridge.msdk.e.a.p;
import com.mbridge.msdk.e.a.r;
import com.mbridge.msdk.e.a.u;
import com.mbridge.msdk.e.a.y;
import com.mbridge.msdk.e.a.z;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends p<JSONObject> implements r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f46337a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f46338b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f46339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f46340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f46341e;

    public g(String str) {
        super(0, str);
    }

    @Override // com.mbridge.msdk.e.a.p
    public final r<JSONObject> a(m mVar) {
        if (mVar != null) {
            try {
                byte[] bArr = mVar.f43803b;
                if (bArr != null && bArr.length != 0) {
                    return r.a(new JSONObject(new String(bArr, com.mbridge.msdk.e.a.a.e.a(mVar.f43804c))), com.mbridge.msdk.e.a.a.e.a(mVar));
                }
            } catch (UnsupportedEncodingException e11) {
                ad.a("RewardSettingRequest", "parseNetworkResponse UnsupportedEncodingException: ", e11);
                return r.a(new com.mbridge.msdk.e.a.g(e11));
            } catch (Exception e12) {
                ad.a("RewardSettingRequest", "parseNetworkResponse Exception: ", e12);
                return r.a(new y(e12));
            }
        }
        return r.a(new u());
    }

    @Override // com.mbridge.msdk.e.a.p
    public final Map<String, String> a() {
        if (this.f46340d == null) {
            this.f46340d = new HashMap<>();
        }
        return this.f46340d;
    }

    @Override // com.mbridge.msdk.e.a.r.a
    public final void a(z zVar) {
        this.f46339c.a(this, new d(-1, zVar.getMessage()));
    }

    public final void a(e eVar) {
        this.f46339c = eVar;
    }

    @Override // com.mbridge.msdk.e.a.p
    public final /* synthetic */ void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        e eVar = this.f46339c;
        if (eVar == null) {
            return;
        }
        try {
            if (jSONObject2 == null) {
                eVar.a(this, new d(-1));
            } else {
                eVar.a(jSONObject2, this);
            }
        } catch (Exception e11) {
            ad.a("RewardSettingRequest", "onError Exception: ", e11);
        }
    }

    public final void a(String str, String str2) {
        if (this.f46341e == null) {
            this.f46341e = new HashMap();
        }
        this.f46341e.put(str, str2);
    }

    public final void a(Map<String, String> map) {
        if (this.f46340d == null) {
            this.f46340d = new HashMap<>();
        }
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f46340d.putAll(map);
    }

    @Override // com.mbridge.msdk.e.a.p
    public final Map<String, String> d() {
        Map<String, String> map = this.f46341e;
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        this.f46341e = map2;
        return map2;
    }
}
