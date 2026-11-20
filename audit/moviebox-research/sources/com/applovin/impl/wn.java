package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f24147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f24149c;

    public wn(com.applovin.impl.sdk.j jVar) {
        this.f24147a = jVar;
        uj ujVar = uj.I;
        this.f24148b = ((Boolean) jVar.a(ujVar, Boolean.FALSE)).booleanValue() || t0.a(com.applovin.impl.sdk.j.l()).a("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator();
        jVar.c(ujVar);
    }

    private void e() {
        com.applovin.impl.sdk.g gVarP = this.f24147a.p();
        if (this.f24148b) {
            gVarP.b(this.f24149c);
        } else {
            gVarP.a(this.f24149c);
        }
    }

    public void a() {
        this.f24147a.b(uj.I, Boolean.TRUE);
    }

    public void a(String str) {
        if (StringUtils.isValidString(str)) {
            a(Collections.singletonList(str));
        } else {
            a((List) null);
        }
    }

    public void a(List list) {
        if (list == null && this.f24149c == null) {
            return;
        }
        if (list == null || !list.equals(this.f24149c)) {
            this.f24149c = list;
            e();
        }
    }

    public void a(JSONObject jSONObject) {
        if (this.f24148b) {
            return;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
        com.applovin.impl.sdk.k kVarY = this.f24147a.y();
        boolean zL = kVarY.L();
        String strA = kVarY.f().a();
        com.applovin.impl.sdk.k.b bVarB = kVarY.B();
        this.f24148b = zL || JsonUtils.containsCaseInsensitiveString(strA, jSONArray) || JsonUtils.containsCaseInsensitiveString(bVarB != null ? bVarB.f22636a : null, jSONArray);
    }

    public List b() {
        return this.f24149c;
    }

    public boolean c() {
        return this.f24148b;
    }

    public boolean d() {
        List list = this.f24149c;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
