package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qe extends e4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f21929e = {com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters", "ad_unit_signal_providers"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f21930f = {com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "settings", "signal_providers", "ad_unit_signal_providers"};

    public static String a(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ve.J6), "1.0/mediate", jVar);
    }

    public static String b(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ve.I6), "1.0/mediate", jVar);
    }

    public static void d(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers")) {
            fm.a(jSONObject, jVar);
        }
    }

    public static void e(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject.length() == 0) {
            return;
        }
        if (!JsonUtils.valueExists(jSONObject, "auto_init_adapters") && !JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
            jVar.c(uj.F);
            return;
        }
        JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
        JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, f21930f);
        jVar.b(uj.F, jSONObjectShallowCopy.toString());
    }

    public static void f(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, f21929e);
            jVar.b(uj.E, jSONObjectShallowCopy.toString());
            fm.a(jSONObjectShallowCopy);
        }
    }

    public static void g(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers") && JsonUtils.valueExists(jSONObject, "signal_providers")) {
            try {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    hashSet.add(JsonUtils.getString(jSONArray.getJSONObject(i11), "name", null));
                }
                HashSet hashSet2 = new HashSet();
                JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
                Iterator it = JsonUtils.toList(jSONObject2.names()).iterator();
                while (it.hasNext()) {
                    hashSet2.addAll(JsonUtils.getList(jSONObject2, (String) it.next(), null));
                }
                if (hashSet.equals(hashSet2)) {
                    return;
                }
                Set differenceSet = CollectionUtils.getDifferenceSet(hashSet, hashSet2);
                com.applovin.impl.sdk.n.h("MediationConnectionUtils", "\"signal_providers\" contains extra network(s): " + differenceSet);
                Set differenceSet2 = CollectionUtils.getDifferenceSet(hashSet2, hashSet);
                com.applovin.impl.sdk.n.h("MediationConnectionUtils", "\"ad_unit_signal_providers\" contains extra network(s): " + differenceSet2);
                jVar.E().a(la.S, "signalProvidersMismatch", (Map) CollectionUtils.hashMap("details", "extraSignalProviderNetworks=" + differenceSet + ",extraAdUnitSignalProviderNetworks=" + differenceSet2));
                q6.a("Networks within \"signal_providers\" and \"ad_unit_signal_providers\" do not match.", new Object[0]);
            } catch (JSONException e11) {
                com.applovin.impl.sdk.n.c("MediationConnectionUtils", "Failed to parse JSON", e11);
                jVar.E().a("MediationConnectionUtils", "verifyBidderNetworksMatchFromJson", e11);
                q6.a((Throwable) e11, "Failed to parse JSON in verifyBidderNetworksMatchFromJson", new Object[0]);
            }
        }
    }

    public static String h(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ve.J6), "1.0/mediate_debug", jVar);
    }

    public static String i(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ve.I6), "1.0/mediate_debug", jVar);
    }
}
