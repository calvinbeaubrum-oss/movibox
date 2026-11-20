package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class fm extends yl {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static JSONObject f19012m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Object f19013n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Map f19014o = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f19015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f19016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f19017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Context f19018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b f19019l;

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(JSONArray jSONArray);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements yj.a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f19020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f19021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f19022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f19023d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Collection f19024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f19025g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final com.applovin.impl.sdk.n f19026h;

        private c(int i11, b bVar, com.applovin.impl.sdk.j jVar) {
            this.f19022c = i11;
            this.f19020a = bVar;
            this.f19025g = jVar;
            this.f19026h = jVar.J();
            this.f19021b = new Object();
            this.f19024f = new ArrayList(i11);
            this.f19023d = new AtomicBoolean();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            ArrayList<yj> arrayList;
            synchronized (this.f19021b) {
                arrayList = new ArrayList(this.f19024f);
            }
            JSONArray jSONArray = new JSONArray();
            for (yj yjVar : arrayList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    zj zjVarF = yjVar.f();
                    jSONObject.put("name", zjVarF.c());
                    jSONObject.put("class", zjVarF.b());
                    jSONObject.put("adapter_version", yjVar.a());
                    jSONObject.put("sdk_version", yjVar.d());
                    JSONObject jSONObject2 = new JSONObject();
                    MaxError maxErrorC = yjVar.c();
                    if (maxErrorC != null) {
                        jSONObject2.put(TrackingKey.ERROR_MESSAGE, maxErrorC.getMessage());
                    } else {
                        jSONObject2.put("signal", yjVar.e());
                    }
                    jSONObject2.put("signal_collection_time_ms", yjVar.b());
                    jSONObject2.put("is_cached", yjVar.g());
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f19026h.a("TaskCollectSignals", "Collected signal from " + zjVarF);
                    }
                } catch (JSONException e11) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f19026h.a("TaskCollectSignals", "Failed to create signal data", e11);
                    }
                    this.f19025g.E().a("TaskCollectSignals", "createSignalsData", e11);
                }
            }
            a(jSONArray);
        }

        private void a(JSONArray jSONArray) {
            b bVar = this.f19020a;
            if (bVar != null) {
                bVar.a(jSONArray);
            }
        }

        @Override // com.applovin.impl.yj.a
        public void a(yj yjVar) {
            boolean z11;
            synchronized (this.f19021b) {
                this.f19024f.add(yjVar);
                int i11 = this.f19022c - 1;
                this.f19022c = i11;
                z11 = i11 < 1;
            }
            if (z11 && this.f19023d.compareAndSet(false, true)) {
                if (yp.h() && ((Boolean) this.f19025g.a(sj.V)).booleanValue()) {
                    this.f19025g.j0().a((yl) new jn(this.f19025g, "handleSignalCollectionCompleted", new Runnable() { // from class: com.applovin.impl.tv
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f23432a.a();
                        }
                    }), tm.b.MEDIATION);
                } else {
                    a();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19023d.compareAndSet(false, true)) {
                a();
            }
        }
    }

    public fm(String str, MaxAdFormat maxAdFormat, Map map, Context context, com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskCollectSignals", jVar);
        this.f19015h = str;
        this.f19016i = maxAdFormat;
        this.f19017j = map;
        this.f19018k = context;
        this.f19019l = bVar;
    }

    private void a(int i11, JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        c cVar = new c(i11, this.f19019l, this.f24689a);
        this.f24689a.j0().a(new jn(this.f24689a, "timeoutCollectSignal", cVar), tm.b.TIMEOUT, ((Long) this.f24689a.a(ve.P6)).longValue());
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            a(new zj(this.f19017j, jSONArray.getJSONObject(i12), jSONObject, this.f24689a), cVar);
        }
    }

    private void a(final zj zjVar, final yj.a aVar) {
        if (zjVar.s()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sv
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23138a.b(zjVar, aVar);
                }
            });
        } else {
            this.f24689a.Q().collectSignal(this.f19015h, this.f19016i, zjVar, this.f19018k, aVar);
        }
    }

    private void a(String str, Throwable th2) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "No signals collected: " + str, th2);
        }
        b bVar = this.f19019l;
        if (bVar != null) {
            bVar.a(new JSONArray());
        }
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        Set set = (Set) f19014o.get(this.f19015h);
        if (set == null || set.isEmpty()) {
            a("No signal providers found for ad unit: " + this.f19015h, (Throwable) null);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
            if (set.contains(JsonUtils.getString(jSONObject2, "name", null))) {
                jSONArray2.put(jSONObject2);
            }
        }
        if (((Boolean) this.f24689a.a(ve.Q6)).booleanValue()) {
            a(jSONArray2.length(), jSONArray2, jSONObject);
        } else {
            a(set.size(), jSONArray2, jSONObject);
        }
    }

    public static void a(JSONObject jSONObject) {
        synchronized (f19013n) {
            f19012m = jSONObject;
        }
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        try {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
            if (jSONObject2 != null) {
                for (String str : JsonUtils.toList(jSONObject2.names())) {
                    f19014o.put(str, new HashSet(JsonUtils.getList(jSONObject2, str, null)));
                }
            }
        } catch (JSONException e11) {
            com.applovin.impl.sdk.n.c("TaskCollectSignals", "Failed to parse ad unit signal providers for JSON object: " + jSONObject, e11);
            jVar.E().a("TaskCollectSignals", "parseAdUnitSignalProvidersJSON", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(zj zjVar, yj.a aVar) {
        this.f24689a.Q().collectSignal(this.f19015h, this.f19016i, zjVar, this.f19018k, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        try {
            synchronized (f19013n) {
                jSONArray = JsonUtils.getJSONArray(f19012m, "signal_providers", null);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                if (f19014o.size() > 0) {
                    a(jSONArray, f19012m);
                    return;
                } else {
                    a(jSONArray.length(), jSONArray, f19012m);
                    return;
                }
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.k(this.f24690b, "Unable to find cached signal providers, fetching signal providers from SharedPreferences.");
            }
            JSONObject jSONObject = new JSONObject((String) this.f24689a.a(uj.E, "{}"));
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            if (jSONArray2 != null && jSONArray2.length() != 0) {
                if (f19014o.size() > 0) {
                    a(jSONArray2, jSONObject);
                    return;
                } else {
                    a(jSONArray2.length(), jSONArray2, jSONObject);
                    return;
                }
            }
            a("No signal providers found", (Throwable) null);
        } catch (InterruptedException e11) {
            a("Failed to wait for signals", e11);
            this.f24689a.E().a("TaskCollectSignals", "waitForSignals", e11);
        } catch (JSONException e12) {
            a("Failed to parse signals JSON", e12);
            this.f24689a.E().a("TaskCollectSignals", "parseSignalsJSON", e12);
        } catch (Throwable th2) {
            a("Failed to collect signals", th2);
            this.f24689a.E().a("TaskCollectSignals", "collectSignals", th2);
        }
    }
}
