package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ue implements d4.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static WeakReference f23572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicBoolean f23573n = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f23574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f23575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f23576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final te f23577d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f23580h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f23582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map f23583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final y0 f23584l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f23578f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f23579g = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f23581i = 2;

    /* JADX INFO: compiled from: source.java */
    public class a extends p {
        public a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Started mediation debugger");
                if (!ue.this.c() || ue.f23572m.get() != activity) {
                    MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                    WeakReference unused = ue.f23572m = new WeakReference(maxDebuggerActivity);
                    maxDebuggerActivity.setListAdapter(ue.this.f23577d, ue.this.f23574a.e());
                }
                ue.f23573n.set(false);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Mediation debugger destroyed");
                WeakReference unused = ue.f23572m = null;
            }
        }
    }

    public ue(com.applovin.impl.sdk.j jVar) {
        this.f23574a = jVar;
        this.f23575b = jVar.J();
        Context contextL = com.applovin.impl.sdk.j.l();
        this.f23576c = contextL;
        te teVar = new te(contextL);
        this.f23577d = teVar;
        this.f23584l = new y0(jVar, teVar);
    }

    private List a(List list, com.applovin.impl.sdk.j jVar) {
        List<String> adUnitIds;
        if (jVar.z0().get()) {
            adUnitIds = jVar.g0().getInitializationAdUnitIds();
        } else {
            adUnitIds = jVar.H() != null ? jVar.H().getAdUnitIds() : null;
        }
        if (adUnitIds == null || adUnitIds.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(adUnitIds.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (adUnitIds.contains(zVar.c())) {
                arrayList.add(zVar);
            }
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (String str : JsonUtils.getList(jSONObject, "required_app_ads_txt_entries", new ArrayList())) {
            x0 x0Var = new x0(str);
            if (x0Var.h()) {
                arrayList.add(x0Var);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f23575b.b("MediationDebuggerService", "app-ads.txt entry passed down for validation is misformatted: " + str);
            }
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            if (jSONObject2 != null) {
                ke keVar = new ke(jSONObject2, jVar);
                arrayList.add(keVar);
                this.f23578f.put(keVar.b(), keVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List a(JSONObject jSONObject, List list, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new z(jSONObject2, this.f23578f, jVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i11) {
        h();
    }

    private void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ke keVar = (ke) it.next();
            if (keVar.y() && keVar.q() == ke.a.INVALID_INTEGRATION) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.z60
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f24815a.d();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        WeakReference weakReference = f23572m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Activity activityN0 = this.f23574a.n0();
        if (activityN0 == null || activityN0.isFinishing()) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "MAX Mediation Debugger has flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this log will only be shown in your development builds. Live apps will not be affected.");
        } else {
            new AlertDialog.Builder(activityN0).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.y60
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f24564a.a(dialogInterface, i11);
                }
            }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
        }
    }

    private void f() {
        this.f23574a.e().a(new a());
    }

    public List a(String str) {
        Map map = this.f23583k;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (List) this.f23583k.get(str);
    }

    @Override // com.applovin.impl.d4.e
    public void a(String str, int i11, String str2, JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f23575b.b("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i11);
        }
        com.applovin.impl.sdk.n.h("AppLovinSdk", "Unable to show mediation debugger.");
        this.f23577d.a(null, null, null, null, null, null, null, null, false, this.f23574a);
        this.f23579g.set(false);
    }

    @Override // com.applovin.impl.d4.e
    public void a(String str, JSONObject jSONObject, int i11) {
        List listA = a(jSONObject, this.f23574a);
        List listA2 = a(jSONObject, listA, this.f23574a);
        List listA3 = a(listA2, this.f23574a);
        List listA4 = a(jSONObject);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        this.f23577d.a(listA, listA2, listA3, listA4, JsonUtils.getString(jSONObject2, CampaignEx.JSON_KEY_TITLE, null), JsonUtils.getString(jSONObject2, "message", null), JsonUtils.getString(jSONObject, "account_id", null), JsonUtils.getBoolean(jSONObject, "complies_with_google_families_policy", null), JsonUtils.getBoolean(jSONObject, "should_display_cmp_details", Boolean.TRUE).booleanValue(), this.f23574a);
        if (!listA4.isEmpty()) {
            this.f23584l.a();
        }
        if (g()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17468a.h();
                }
            }, TimeUnit.SECONDS.toMillis(this.f23581i));
        } else {
            a(listA);
        }
    }

    public void a(Map map) {
        this.f23583k = map;
        e();
        if (c() || !f23573n.compareAndSet(false, true)) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Mediation debugger is already showing");
            return;
        }
        if (!this.f23582j) {
            f();
            this.f23582j = true;
        }
        Intent intent = new Intent(this.f23576c, (Class<?>) MaxDebuggerActivity.class);
        intent.setFlags(ASTNode.DEOP);
        com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting mediation debugger...");
        this.f23576c.startActivity(intent);
    }

    public void a(boolean z11, int i11) {
        this.f23580h = z11;
        this.f23581i = i11;
    }

    public void e() {
        if (this.f23579g.compareAndSet(false, true)) {
            this.f23574a.j0().a((yl) new mm(this, this.f23574a), tm.b.OTHER);
        }
    }

    public boolean g() {
        return this.f23580h;
    }

    public void h() {
        a((Map) null);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f23577d + "}";
    }
}
