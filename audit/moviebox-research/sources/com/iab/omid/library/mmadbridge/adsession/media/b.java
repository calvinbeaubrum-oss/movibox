package com.iab.omid.library.mmadbridge.adsession.media;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import nn.d;
import nn.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f42344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f42345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f42346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Position f42347d;

    public b(boolean z11, Float f11, boolean z12, Position position) {
        this.f42344a = z11;
        this.f42345b = f11;
        this.f42346c = z12;
        this.f42347d = position;
    }

    public static b b(boolean z11, Position position) {
        g.c(position, "Position is null");
        return new b(false, null, z11, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f42344a);
            if (this.f42344a) {
                jSONObject.put("skipOffset", this.f42345b);
            }
            jSONObject.put("autoPlay", this.f42346c);
            jSONObject.put(RequestParameters.POSITION, this.f42347d);
        } catch (JSONException e11) {
            d.b("VastProperties: JSON error", e11);
        }
        return jSONObject;
    }
}
