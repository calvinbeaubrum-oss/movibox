package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18446b;

    public dg(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f18445a = JsonUtils.getString(jSONObject, "id", "");
        this.f18446b = JsonUtils.getString(jSONObject, BidResponsed.KEY_PRICE, null);
    }

    public String a() {
        return this.f18445a;
    }

    public String b() {
        return this.f18446b;
    }
}
