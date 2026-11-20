package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f21736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f21737b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f21739d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f21741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final tl f21742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final tl f21743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f21744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f21745k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f21738c = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final Object f21740f = new Object();

    public pe(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        this.f21736a = jVar;
        if (((Boolean) jVar.a(sj.f23019n6)).booleanValue()) {
            this.f21742h = new tl(jSONObject2);
            this.f21743i = new tl(jSONObject);
            this.f21737b = null;
            this.f21739d = null;
        } else {
            this.f21737b = jSONObject2;
            this.f21739d = jSONObject;
            this.f21742h = null;
            this.f21743i = null;
        }
        this.f21741g = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle a(tl tlVar) {
        return JsonUtils.toBundle(tlVar.a("server_parameters", (JSONObject) null));
    }

    private int j() {
        return a("mute_state", b("mute_state", ((Integer) this.f21736a.a(ve.f23897t7)).intValue()));
    }

    public double a(String str, float f11) {
        double d11;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, f11);
        }
        synchronized (this.f21740f) {
            d11 = JsonUtils.getDouble(this.f21739d, str, f11);
        }
        return d11;
    }

    public int a(String str, int i11) {
        int i12;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, i11);
        }
        synchronized (this.f21740f) {
            i12 = JsonUtils.getInt(this.f21739d, str, i11);
        }
        return i12;
    }

    public long a(String str, long j11) {
        long j12;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, j11);
        }
        synchronized (this.f21740f) {
            j12 = JsonUtils.getLong(this.f21739d, str, j11);
        }
        return j12;
    }

    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, bool);
        }
        synchronized (this.f21740f) {
            bool2 = JsonUtils.getBoolean(this.f21739d, str, bool);
        }
        return bool2;
    }

    public String a(String str) {
        String strA = a(str, "");
        return StringUtils.isValidString(strA) ? strA : b(str, "");
    }

    public String a(String str, String str2) {
        String string;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, str2);
        }
        synchronized (this.f21740f) {
            string = JsonUtils.getString(this.f21739d, str, str2);
        }
        return string;
    }

    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, jSONArray);
        }
        synchronized (this.f21740f) {
            jSONArray2 = JsonUtils.getJSONArray(this.f21739d, str, jSONArray);
        }
        return jSONArray2;
    }

    public JSONObject a() {
        JSONObject jSONObject;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a();
        }
        synchronized (this.f21740f) {
            jSONObject = this.f21739d;
        }
        return jSONObject;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, jSONObject);
        }
        synchronized (this.f21740f) {
            jSONObject2 = JsonUtils.getJSONObject(this.f21739d, str, jSONObject);
        }
        return jSONObject2;
    }

    public void a(String str, Object obj) {
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            tlVar.a(str, obj);
            return;
        }
        synchronized (this.f21740f) {
            JsonUtils.putObject(this.f21739d, str, obj);
        }
    }

    public float b(String str, float f11) {
        float f12;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str, f11);
        }
        synchronized (this.f21740f) {
            f12 = JsonUtils.getFloat(this.f21739d, str, f11);
        }
        return f12;
    }

    public int b(String str, int i11) {
        int i12;
        tl tlVar = this.f21742h;
        if (tlVar != null) {
            return tlVar.a(str, i11);
        }
        synchronized (this.f21738c) {
            i12 = JsonUtils.getInt(this.f21737b, str, i11);
        }
        return i12;
    }

    public long b(String str, long j11) {
        long j12;
        tl tlVar = this.f21742h;
        if (tlVar != null) {
            return tlVar.a(str, j11);
        }
        synchronized (this.f21738c) {
            j12 = JsonUtils.getLong(this.f21737b, str, j11);
        }
        return j12;
    }

    public Boolean b(String str, Boolean bool) {
        Boolean bool2;
        tl tlVar = this.f21742h;
        if (tlVar != null) {
            return tlVar.a(str, bool);
        }
        synchronized (this.f21738c) {
            bool2 = JsonUtils.getBoolean(this.f21737b, str, bool);
        }
        return bool2;
    }

    public String b() {
        return a("class", (String) null);
    }

    public String b(String str, String str2) {
        String string;
        tl tlVar = this.f21742h;
        if (tlVar != null) {
            return tlVar.a(str, str2);
        }
        synchronized (this.f21738c) {
            string = JsonUtils.getString(this.f21737b, str, str2);
        }
        return string;
    }

    public List b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        tl tlVar = this.f21742h;
        List listB = tlVar != null ? tlVar.b(str, Collections.emptyList()) : JsonUtils.optList(b(str, new JSONArray()), Collections.emptyList());
        tl tlVar2 = this.f21743i;
        List listB2 = tlVar2 != null ? tlVar2.b(str, Collections.emptyList()) : JsonUtils.optList(a(str, new JSONArray()), Collections.emptyList());
        ArrayList arrayList = new ArrayList(listB.size() + listB2.size());
        arrayList.addAll(listB);
        arrayList.addAll(listB2);
        return arrayList;
    }

    public JSONArray b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        tl tlVar = this.f21742h;
        if (tlVar != null) {
            return tlVar.a(str, jSONArray);
        }
        synchronized (this.f21738c) {
            jSONArray2 = JsonUtils.getJSONArray(this.f21737b, str, jSONArray);
        }
        return jSONArray2;
    }

    public String c() {
        return a("name", (String) null);
    }

    public void c(String str, int i11) {
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            tlVar.b(str, i11);
            return;
        }
        synchronized (this.f21740f) {
            JsonUtils.putInt(this.f21739d, str, i11);
        }
    }

    public void c(String str, long j11) {
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            tlVar.b(str, j11);
            return;
        }
        synchronized (this.f21740f) {
            JsonUtils.putLong(this.f21739d, str, j11);
        }
    }

    public void c(String str, String str2) {
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            tlVar.b(str, str2);
            return;
        }
        synchronized (this.f21740f) {
            JsonUtils.putString(this.f21739d, str, str2);
        }
    }

    public boolean c(String str) {
        boolean zHas;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.a(str);
        }
        synchronized (this.f21740f) {
            zHas = this.f21739d.has(str);
        }
        return zHas;
    }

    public String d() {
        if (c("consent_string")) {
            return a("consent_string", (String) null);
        }
        return d("consent_string") ? b("consent_string", (String) null) : this.f21736a.k0().k();
    }

    public boolean d(String str) {
        boolean zHas;
        tl tlVar = this.f21742h;
        if (tlVar != null) {
            return tlVar.a(str);
        }
        synchronized (this.f21738c) {
            zHas = this.f21737b.has(str);
        }
        return zHas;
    }

    public Object e(String str) {
        Object objOpt;
        tl tlVar = this.f21743i;
        if (tlVar != null) {
            return tlVar.b(str);
        }
        synchronized (this.f21740f) {
            objOpt = this.f21739d.opt(str);
        }
        return objOpt;
    }

    public String e() {
        return this.f21745k;
    }

    public Bundle f() {
        return BundleUtils.getBundle("custom_parameters", new Bundle(), l());
    }

    public void f(String str) {
        this.f21745k = str;
    }

    public JSONObject g() {
        JSONObject jSONObject;
        tl tlVar = this.f21742h;
        if (tlVar != null) {
            return tlVar.a();
        }
        synchronized (this.f21738c) {
            jSONObject = this.f21737b;
        }
        return jSONObject;
    }

    public void g(String str) {
        this.f21744j = str;
    }

    public String getAdUnitId() {
        return b("ad_unit_id", "");
    }

    public String getPlacement() {
        return this.f21744j;
    }

    public long h() {
        return a("init_completion_delay_ms", -1L);
    }

    public Map i() {
        return this.f21741g;
    }

    public String k() {
        return c().split("_")[0];
    }

    public Bundle l() {
        Bundle bundle;
        if (e("server_parameters") instanceof JSONObject) {
            tl tlVar = this.f21743i;
            bundle = tlVar != null ? (Bundle) tlVar.a(new j1.a() { // from class: com.applovin.impl.e10
                @Override // j1.a
                public final Object apply(Object obj) {
                    return pe.a((tl) obj);
                }
            }) : JsonUtils.toBundle(a("server_parameters", (JSONObject) null));
        } else {
            bundle = new Bundle();
        }
        int iJ = j();
        if (iJ != -1) {
            if (iJ == 2) {
                bundle.putBoolean("is_muted", this.f21736a.g0().isMuted());
            } else {
                bundle.putBoolean("is_muted", iJ == 0);
            }
        }
        if (!bundle.containsKey("amount")) {
            bundle.putLong("amount", b("amount", 0L));
        }
        if (!bundle.containsKey(AppLovinEventParameters.REVENUE_CURRENCY)) {
            bundle.putString(AppLovinEventParameters.REVENUE_CURRENCY, b(AppLovinEventParameters.REVENUE_CURRENCY, ""));
        }
        return bundle;
    }

    public long m() {
        return a("adapter_timeout_ms", ((Long) this.f21736a.a(ve.R6)).longValue());
    }

    public Boolean n() {
        String str = this.f21736a.g0().getExtraParameters().get("huc");
        if (StringUtils.isValidString(str)) {
            return Boolean.valueOf(str);
        }
        return c("huc") ? a("huc", Boolean.FALSE) : b("huc", (Boolean) null);
    }

    public Boolean o() {
        String str = this.f21736a.g0().getExtraParameters().get("aru");
        if (StringUtils.isValidString(str)) {
            return Boolean.valueOf(str);
        }
        return c("aru") ? a("aru", Boolean.FALSE) : b("aru", (Boolean) null);
    }

    public Boolean p() {
        String str = this.f21736a.g0().getExtraParameters().get("dns");
        if (StringUtils.isValidString(str)) {
            return Boolean.valueOf(str);
        }
        return c("dns") ? a("dns", Boolean.FALSE) : b("dns", (Boolean) null);
    }

    public boolean q() {
        return a("is_testing", Boolean.FALSE).booleanValue();
    }

    public boolean r() {
        return a("reinitialize_if_init_fails", Boolean.FALSE).booleanValue();
    }

    public boolean s() {
        return a("run_on_ui_thread", Boolean.TRUE).booleanValue();
    }

    public boolean t() {
        return a("eagerly_initialize", Boolean.TRUE).booleanValue();
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + b() + "', adapterName='" + c() + "', isTesting=" + q() + '}';
    }
}
