package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ke implements Comparable, AppLovinCommunicatorSubscriber {
    private final List A;
    private final List B;
    private final List C;
    private final Map D;
    private final boolean E;
    private final rn F;
    private final boolean G;
    private final String H;
    private final Map I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f20211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20213d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f20214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f20215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f20216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f20217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f20218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f20219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f20220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f20221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f20222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f20223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f20224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f20225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f20226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f20227s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f20228t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f20229u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f20230v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f20231w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f20232x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f20233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f20234z;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20240a;

        a(String str) {
            this.f20240a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f20240a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        NOT_SUPPORTED("Not Supported", FlowLayout.SPACING_AUTO, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", FlowLayout.SPACING_AUTO, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", FlowLayout.SPACING_AUTO, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20249c;

        b(String str, int i11, String str2) {
            this.f20247a = str;
            this.f20248b = i11;
            this.f20249c = str2;
        }

        public String b() {
            return this.f20249c;
        }

        public String c() {
            return this.f20247a;
        }

        public int d() {
            return this.f20248b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0226 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x022a  */
    /* JADX WARN: Code duplicated, block: B:69:0x023c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0248  */
    /* JADX WARN: Code duplicated, block: B:73:0x028c  */
    /* JADX WARN: Code duplicated, block: B:76:0x029b  */
    public ke(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        String adapterVersion;
        String strA;
        boolean zEquals;
        boolean zIsBeta;
        String str;
        boolean z11;
        boolean z12;
        int iLastIndexOf;
        String lowerCase;
        Integer numA;
        JSONObject jSONObject2;
        String string;
        String string2;
        this.f20210a = jVar;
        this.f20224p = JsonUtils.getString(jSONObject, "name", "");
        this.f20225q = JsonUtils.getString(jSONObject, "display_name", "");
        this.f20226r = JsonUtils.getString(jSONObject, "adapter_class", "");
        this.f20229u = JsonUtils.getString(jSONObject, "latest_adapter_version", "");
        this.B = a(jSONObject);
        Boolean bool = Boolean.FALSE;
        this.f20219k = JsonUtils.getBoolean(jSONObject, "hide_if_missing", bool).booleanValue();
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject, "configuration", new JSONObject());
        this.f20234z = a(jSONObject3, jVar);
        this.f20223o = JsonUtils.getBoolean(jSONObject3, "java_8_required", bool).booleanValue();
        this.E = JsonUtils.getBoolean(jSONObject3, "hide_initialization_status", bool).booleanValue();
        this.C = JsonUtils.getList(jSONObject3, "live_network_filtering_names", null);
        JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONObject3, "test_mode", new JSONObject());
        this.f20222n = JsonUtils.getBoolean(jSONObject4, "false_coppa_required", bool).booleanValue();
        JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "network_names", (JSONObject) null);
        if (jSONObject5 == null || jSONObject5.length() <= 0) {
            this.D = null;
        } else {
            HashMap map = new HashMap(jSONObject5.length());
            Iterator<String> itKeys = jSONObject5.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                MaxAdFormat fromString = MaxAdFormat.formatFromString(next);
                String string3 = JsonUtils.getString(jSONObject5, next, null);
                if (fromString != null && !TextUtils.isEmpty(string3)) {
                    map.put(fromString, string3);
                }
            }
            this.D = map;
        }
        JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject, "test_mode", new JSONObject());
        Boolean bool2 = Boolean.TRUE;
        this.f20217i = JsonUtils.getBoolean(jSONObject6, "supported", bool2).booleanValue();
        this.f20218j = JsonUtils.getBoolean(jSONObject, "test_mode_requires_init", Boolean.FALSE).booleanValue();
        this.f20230v = JsonUtils.getString(jSONObject6, "message", null);
        this.F = new rn(JsonUtils.getJSONObject(jSONObject3, "tcf_config"), this.f20225q);
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        if (list != null) {
            this.f20213d = yp.a(list);
        } else {
            this.f20213d = yp.a(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
        List listEmptyList = Collections.emptyList();
        String str2 = this.f20226r;
        String string4 = JsonUtils.getString(jSONObject3, "init_adapter_class", null);
        if (string4 != null) {
            this.f20226r = string4;
        }
        MaxAdapter maxAdapterA = af.a(str2, jVar);
        if (maxAdapterA != null) {
            this.f20214f = true;
            try {
                try {
                    adapterVersion = maxAdapterA.getAdapterVersion();
                    try {
                        strA = af.a(maxAdapterA);
                        try {
                            listEmptyList = a(maxAdapterA, JsonUtils.getBoolean(jSONObject4, "is_mrec_supported", bool2).booleanValue());
                            JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONObject3, "native_ad_view_config", (JSONObject) null);
                            if (jSONObject7 != null) {
                                String string5 = JsonUtils.getString(jSONObject7, "min_adapter_version", null);
                                z11 = string5 == null || yp.a(adapterVersion, string5) >= 0;
                                try {
                                    string2 = JsonUtils.getString(jSONObject7, "network_name", null);
                                } catch (Throwable th2) {
                                    th = th2;
                                    string2 = null;
                                    com.applovin.impl.sdk.n.h("MediatedNetwork", "Failed to load adapter for network " + this.f20224p + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                                    str = string2;
                                    zIsBeta = false;
                                    Class<?> cls = Class.forName(this.f20226r);
                                    zEquals = cls.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls);
                                    this.f20228t = adapterVersion;
                                    this.f20227s = strA;
                                    this.f20233y = listEmptyList;
                                    this.f20220l = zEquals;
                                    this.f20221m = z11;
                                    this.f20231w = str;
                                    this.A = a(jSONObject3, adapterVersion, jVar);
                                    this.f20216h = yp.a(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
                                    this.f20211b = a();
                                    if (adapterVersion.equals(this.f20229u)) {
                                        z12 = false;
                                    } else {
                                        z12 = false;
                                    }
                                    this.f20215g = z12;
                                    Context contextL = com.applovin.impl.sdk.j.l();
                                    iLastIndexOf = this.f20224p.lastIndexOf("_");
                                    if (iLastIndexOf != -1) {
                                        lowerCase = this.f20224p.toLowerCase().substring(0, iLastIndexOf);
                                    } else {
                                        lowerCase = this.f20224p.toLowerCase();
                                    }
                                    this.f20232x = contextL.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", contextL.getPackageName());
                                    this.f20212c = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
                                    AppLovinCommunicator.getInstance(contextL).subscribe(this, "adapter_initialization_status");
                                    numA = jVar.L().a(this.f20226r);
                                    if (numA != null) {
                                        this.f20212c = numA.intValue();
                                    }
                                    jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
                                    if (jSONObject2 != null) {
                                    }
                                    this.G = false;
                                    this.H = null;
                                    this.I = null;
                                    return;
                                }
                            } else {
                                string2 = null;
                                z11 = false;
                            }
                            try {
                                str = string2;
                                zIsBeta = maxAdapterA.isBeta();
                            } catch (Throwable th3) {
                                th = th3;
                                com.applovin.impl.sdk.n.h("MediatedNetwork", "Failed to load adapter for network " + this.f20224p + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                                str = string2;
                                zIsBeta = false;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            string2 = null;
                            z11 = false;
                            com.applovin.impl.sdk.n.h("MediatedNetwork", "Failed to load adapter for network " + this.f20224p + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                            str = string2;
                            zIsBeta = false;
                            Class<?> cls2 = Class.forName(this.f20226r);
                            zEquals = cls2.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls2);
                            this.f20228t = adapterVersion;
                            this.f20227s = strA;
                            this.f20233y = listEmptyList;
                            this.f20220l = zEquals;
                            this.f20221m = z11;
                            this.f20231w = str;
                            this.A = a(jSONObject3, adapterVersion, jVar);
                            this.f20216h = yp.a(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
                            this.f20211b = a();
                            if (adapterVersion.equals(this.f20229u)) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            this.f20215g = z12;
                            Context contextL2 = com.applovin.impl.sdk.j.l();
                            iLastIndexOf = this.f20224p.lastIndexOf("_");
                            if (iLastIndexOf != -1) {
                                lowerCase = this.f20224p.toLowerCase().substring(0, iLastIndexOf);
                            } else {
                                lowerCase = this.f20224p.toLowerCase();
                            }
                            this.f20232x = contextL2.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", contextL2.getPackageName());
                            this.f20212c = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
                            AppLovinCommunicator.getInstance(contextL2).subscribe(this, "adapter_initialization_status");
                            numA = jVar.L().a(this.f20226r);
                            if (numA != null) {
                                this.f20212c = numA.intValue();
                            }
                            jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
                            if (jSONObject2 != null) {
                            }
                            this.G = false;
                            this.H = null;
                            this.I = null;
                            return;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        strA = "";
                    }
                } catch (Throwable th6) {
                    th = th6;
                    adapterVersion = "";
                    strA = adapterVersion;
                }
                Class<?> cls3 = Class.forName(this.f20226r);
                zEquals = cls3.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls3);
            } catch (Throwable th7) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("MediatedNetwork", "Failed to check if adapter overrides MaxNativeAdAdapter", th7);
                }
                zEquals = false;
            }
        } else {
            this.f20214f = false;
            adapterVersion = "";
            strA = adapterVersion;
            zEquals = false;
            zIsBeta = false;
            str = null;
            z11 = false;
        }
        this.f20228t = adapterVersion;
        this.f20227s = strA;
        this.f20233y = listEmptyList;
        this.f20220l = zEquals;
        this.f20221m = z11;
        this.f20231w = str;
        this.A = a(jSONObject3, adapterVersion, jVar);
        this.f20216h = yp.a(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
        this.f20211b = a();
        if (adapterVersion.equals(this.f20229u) || zIsBeta) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.f20215g = z12;
        Context contextL3 = com.applovin.impl.sdk.j.l();
        iLastIndexOf = this.f20224p.lastIndexOf("_");
        if (iLastIndexOf != -1) {
            lowerCase = this.f20224p.toLowerCase().substring(0, iLastIndexOf);
        } else {
            lowerCase = this.f20224p.toLowerCase();
        }
        this.f20232x = contextL3.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", contextL3.getPackageName());
        this.f20212c = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
        AppLovinCommunicator.getInstance(contextL3).subscribe(this, "adapter_initialization_status");
        numA = jVar.L().a(this.f20226r);
        if (numA != null) {
            this.f20212c = numA.intValue();
        }
        jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
        if (jSONObject2 != null || !this.f20213d) {
            this.G = false;
            this.H = null;
            this.I = null;
            return;
        }
        this.G = true;
        this.H = JsonUtils.getString(jSONObject2, "test_mode_app_id", null);
        JSONObject jSONObject8 = JsonUtils.getJSONObject(jSONObject2, "test_mode_slot_ids", new JSONObject());
        HashMap map2 = new HashMap(jSONObject8.length());
        Iterator<String> itKeys2 = jSONObject8.keys();
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            MaxAdFormat fromString2 = MaxAdFormat.formatFromString(next2);
            JSONObject jSONObject9 = JsonUtils.getJSONObject(jSONObject8, next2, (JSONObject) null);
            if (fromString2 != null && jSONObject9 != null && (string = JsonUtils.getString(jSONObject9, "uuid", null)) != null) {
                map2.put(fromString2, new p0(string, jSONObject9, fromString2));
            }
        }
        this.I = map2;
    }

    private a a() {
        a aVar;
        if (!this.f20213d) {
            aVar = this.f20214f ? a.INCOMPLETE_INTEGRATION : a.MISSING;
        } else if (this.f20214f) {
            aVar = a.COMPLETE;
        } else {
            aVar = this.f20216h ? a.MISSING : a.INCOMPLETE_INTEGRATION;
        }
        if (aVar == a.MISSING) {
            return aVar;
        }
        Iterator it = this.f20234z.iterator();
        while (it.hasNext()) {
            if (!((hh) it.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        Iterator it2 = this.A.iterator();
        while (it2.hasNext()) {
            if (!((p6) it2.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        return (!this.f20223o || com.applovin.impl.sdk.j.y0()) ? aVar : a.INVALID_INTEGRATION;
    }

    private List a(MaxAdapter maxAdapter, boolean z11) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAppOpenAdapter) {
            arrayList.add(MaxAdFormat.APP_OPEN);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            if (z11) {
                arrayList.add(MaxAdFormat.MREC);
            }
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", null), null);
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f20226r.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            hh hhVar = new hh("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", com.applovin.impl.sdk.j.l());
            if (hhVar.c()) {
                arrayList.add(hhVar);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                arrayList.add(new hh(next, jSONObject2.getString(next), com.applovin.impl.sdk.j.l()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject, String str, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new p6(jSONObject2, jVar));
            }
        }
        for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i12, (JSONObject) null);
            if (jSONObject3 != null && p6.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", null), JsonUtils.getString(jSONObject3, "max_adapter_version", null))) {
                arrayList.add(new p6(jSONObject3, jVar));
            }
        }
        return arrayList;
    }

    public boolean A() {
        return this.G;
    }

    public boolean B() {
        return this.f20223o;
    }

    public boolean C() {
        return this.f20213d;
    }

    public boolean D() {
        return this.f20222n;
    }

    public boolean E() {
        return this.f20211b == a.MISSING && this.f20219k;
    }

    public boolean F() {
        return this.E;
    }

    public boolean G() {
        return this.f20220l;
    }

    public boolean H() {
        return this.f20221m;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ke keVar) {
        return this.f20225q.compareToIgnoreCase(keVar.f20225q);
    }

    public String b() {
        return this.f20226r;
    }

    public String c() {
        return this.f20228t;
    }

    public Map d() {
        return this.I;
    }

    public String e() {
        return this.H;
    }

    public List f() {
        return this.A;
    }

    public String g() {
        return this.f20225q;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public int h() {
        return this.f20232x;
    }

    public int i() {
        return this.f20212c;
    }

    public final String j() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n---------- ");
        sb2.append(this.f20224p);
        sb2.append(" ----------");
        sb2.append("\nStatus  - ");
        sb2.append(this.f20211b.b());
        sb2.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb2.append((!this.f20213d || TextUtils.isEmpty(this.f20227s)) ? "UNAVAILABLE" : this.f20227s);
        sb2.append("\nAdapter - ");
        if (this.f20214f && !TextUtils.isEmpty(this.f20228t)) {
            str = this.f20228t;
        }
        sb2.append(str);
        for (hh hhVar : n()) {
            if (!hhVar.c()) {
                sb2.append("\n* MISSING ");
                sb2.append(hhVar.b());
                sb2.append(": ");
                sb2.append(hhVar.a());
            }
        }
        for (p6 p6Var : f()) {
            if (!p6Var.c()) {
                sb2.append("\n* MISSING ");
                sb2.append(p6Var.b());
                sb2.append(": ");
                sb2.append(p6Var.a());
            }
        }
        return sb2.toString();
    }

    public String k() {
        return this.f20229u;
    }

    public List l() {
        return this.C;
    }

    public String m() {
        return this.f20224p;
    }

    public List n() {
        return this.f20234z;
    }

    public final com.applovin.impl.sdk.j o() {
        return this.f20210a;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.f20226r.equals(string)) {
            this.f20212c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter maxAdapterA = af.a(string, this.f20210a);
            if (maxAdapterA != null) {
                String strA = af.a(maxAdapterA);
                if (this.f20227s.equals(strA)) {
                    return;
                }
                this.f20227s = strA;
                this.f20210a.p().a(this.f20227s, string);
            }
        }
    }

    public String p() {
        return this.f20227s;
    }

    public a q() {
        return this.f20211b;
    }

    public List r() {
        return this.f20233y;
    }

    public List s() {
        return this.B;
    }

    public rn t() {
        return this.F;
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.f20224p + ", displayName=" + this.f20225q + ", sdkAvailable=" + this.f20213d + ", sdkVersion=" + this.f20227s + ", adapterAvailable=" + this.f20214f + ", adapterVersion=" + this.f20228t + "}";
    }

    public String u() {
        return this.f20230v;
    }

    public String v() {
        return this.f20231w;
    }

    public Map w() {
        return this.D;
    }

    public b x() {
        if (!this.f20217i) {
            return b.NOT_SUPPORTED;
        }
        a aVar = this.f20211b;
        if (aVar != a.COMPLETE && (aVar != a.INCOMPLETE_INTEGRATION || !C() || !y())) {
            return b.INVALID_INTEGRATION;
        }
        if (this.f20210a.l0().c()) {
            return (this.f20218j && (this.f20212c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.f20212c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? b.NOT_INITIALIZED : b.READY;
        }
        return b.DISABLED;
    }

    public boolean y() {
        return this.f20214f;
    }

    public boolean z() {
        return this.f20215g;
    }
}
