package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.am;
import com.applovin.impl.an;
import com.applovin.impl.fi;
import com.applovin.impl.la;
import com.applovin.impl.ma;
import com.applovin.impl.pe;
import com.applovin.impl.q6;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.uj;
import com.applovin.impl.ve;
import com.applovin.mediation.adapter.MaxAdapter;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f20960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f20961c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f20962d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f20963e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final JSONArray f20964f = new JSONArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedHashMap f20965g = new LinkedHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f20966h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f20967i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f20968j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f20969k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f20970l;

    public e(com.applovin.impl.sdk.j jVar) {
        this.f20959a = jVar;
        this.f20960b = jVar.J();
    }

    private pe a(pe peVar) {
        List<pe> list;
        if (((Boolean) this.f20959a.a(ve.O7)).booleanValue()) {
            pe peVar2 = (pe) this.f20967i.get(peVar.b());
            return peVar2 != null ? peVar2 : peVar;
        }
        if (!this.f20959a.l0().c() || (list = this.f20970l) == null) {
            return peVar;
        }
        for (pe peVar3 : list) {
            if (peVar3.b().equals(peVar.b())) {
                return peVar3;
            }
        }
        return null;
    }

    private List a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(new pe(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null), jSONObject, this.f20959a));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(fi fiVar, MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            q6.a("Adapters should never report a null or INITIALIZING status.", new Object[0]);
            fiVar.a("Adapter reported INITIALIZING");
        } else if (initializationStatus == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE) {
            fiVar.a(str);
        } else {
            fiVar.b(initializationStatus);
        }
    }

    private void c(pe peVar) {
        String strB = peVar.b();
        synchronized (this.f20963e) {
            try {
                if (this.f20962d.contains(strB)) {
                    return;
                }
                this.f20962d.add(strB);
                this.f20959a.E().a(la.f20384m, ma.a(peVar));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public fi a(pe peVar, Activity activity) {
        pe peVarA = a(peVar);
        if (peVarA == null) {
            return fi.c(MaxAdapter.InitializationStatus.DOES_NOT_APPLY);
        }
        String strB = peVar.b();
        synchronized (this.f20969k) {
            try {
                fi fiVar = (fi) this.f20968j.get(strB);
                if (fiVar == null || (fiVar.d() && peVarA.r())) {
                    final fi fiVar2 = new fi();
                    this.f20968j.put(strB, fiVar2);
                    g gVarA = this.f20959a.M().a(peVarA);
                    if (gVarA == null) {
                        fiVar2.a("Adapter implementation not found");
                        return fiVar2;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f20960b.d("MediationAdapterInitializationManager", "Initializing adapter " + peVarA);
                    }
                    c(peVarA);
                    gVarA.a(MaxAdapterParametersImpl.a(peVarA), activity, new MaxAdapter.OnCompletionListener() { // from class: com.applovin.impl.mediation.t
                        @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
                        public final void onCompletion(MaxAdapter.InitializationStatus initializationStatus, String str) {
                            e.a(fiVar2, initializationStatus, str);
                        }
                    });
                    an.a(peVarA.m(), fiVar2, "The adapter (" + peVar.c() + ") timed out initializing", "MediationAdapterInitializationManager", this.f20959a);
                    return fiVar2;
                }
                return fiVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Integer a(String str) {
        Integer num;
        synchronized (this.f20966h) {
            num = (Integer) this.f20965g.get(str);
        }
        return num;
    }

    public Set a() {
        HashSet hashSet;
        synchronized (this.f20966h) {
            hashSet = new HashSet(this.f20965g.keySet());
        }
        return hashSet;
    }

    public void a(Activity activity) {
        if (this.f20961c.compareAndSet(false, true)) {
            String str = (String) this.f20959a.a(uj.F);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<pe> listA = a(JsonUtils.getJSONArray(jSONObject, this.f20959a.l0().c() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.f20970l = listA;
                    for (pe peVar : listA) {
                        this.f20967i.put(peVar.b(), peVar);
                    }
                    long j11 = StringUtils.parseLong(this.f20959a.g0().getExtraParameters().get("adapter_initialization_delay_ms"), -1L);
                    am amVar = new am(listA, activity, this.f20959a);
                    if (j11 > 0) {
                        this.f20959a.j0().a(amVar, tm.b.MEDIATION, j11);
                    } else {
                        this.f20959a.j0().a(amVar);
                    }
                } catch (JSONException e11) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f20960b.a("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e11);
                    }
                    q6.a((Throwable) e11);
                }
            }
        }
    }

    public void a(pe peVar, long j11, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z11;
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            return;
        }
        synchronized (this.f20966h) {
            try {
                z11 = !b(peVar);
                if (z11) {
                    this.f20965g.put(peVar.b(), Integer.valueOf(initializationStatus.getCode()));
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putString(jSONObject, "class", peVar.b());
                    JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                    JsonUtils.putLong(jSONObject, "init_time_ms", j11);
                    JsonUtils.putString(jSONObject, TrackingKey.ERROR_MESSAGE, JSONObject.quote(str));
                    this.f20964f.put(jSONObject);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            this.f20959a.a(peVar);
            this.f20959a.Q().processAdapterInitializationPostback(peVar, j11, initializationStatus, str);
            this.f20959a.p().a(initializationStatus, peVar.b());
        }
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        synchronized (this.f20966h) {
            this.f20965g.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", Integer.valueOf(initializationStatus.getCode()));
        }
        this.f20959a.p().a(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }

    public JSONArray b() {
        JSONArray jSONArrayShallowCopy;
        synchronized (this.f20966h) {
            jSONArrayShallowCopy = JsonUtils.shallowCopy(this.f20964f);
        }
        return jSONArrayShallowCopy;
    }

    public void b(pe peVar, Activity activity) {
        List list;
        if (((Boolean) this.f20959a.a(ve.P7)).booleanValue()) {
            a(peVar, activity);
            return;
        }
        if (((Boolean) this.f20959a.a(ve.O7)).booleanValue()) {
            pe peVar2 = (pe) this.f20967i.get(peVar.b());
            if (peVar2 != null) {
                peVar = peVar2;
            }
        } else {
            if (this.f20959a.l0().c() && (list = this.f20970l) != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        peVar = null;
                        break;
                    }
                    pe peVar3 = (pe) it.next();
                    if (peVar3.b().equals(peVar.b())) {
                        peVar = peVar3;
                        break;
                    }
                }
            }
            if (peVar == null) {
                return;
            }
        }
        g gVarA = this.f20959a.M().a(peVar);
        if (gVarA == null) {
            com.applovin.impl.sdk.n.h("MediationAdapterInitializationManager", "Mediation adapter could not be initialized, double check that the adapter is included in your build. Adapter spec: " + peVar);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f20960b.d("MediationAdapterInitializationManager", "Initializing adapter " + peVar);
        }
        c(peVar);
        gVarA.a(MaxAdapterParametersImpl.a(peVar), activity, (MaxAdapter.OnCompletionListener) null);
    }

    public boolean b(pe peVar) {
        boolean zContainsKey;
        synchronized (this.f20966h) {
            zContainsKey = this.f20965g.containsKey(peVar.b());
        }
        return zContainsKey;
    }

    public boolean c() {
        return this.f20961c.get();
    }
}
