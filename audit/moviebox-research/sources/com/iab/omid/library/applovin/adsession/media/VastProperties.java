package com.iab.omid.library.applovin.adsession.media;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.iab.omid.library.applovin.utils.d;
import com.iab.omid.library.applovin.utils.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class VastProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f42097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f42098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f42099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Position f42100d;

    private VastProperties(boolean z11, Float f11, boolean z12, Position position) {
        this.f42097a = z11;
        this.f42098b = f11;
        this.f42099c = z12;
        this.f42100d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z11, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(false, null, z11, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f11, boolean z11, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f11), z11, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f42097a);
            if (this.f42097a) {
                jSONObject.put("skipOffset", this.f42098b);
            }
            jSONObject.put("autoPlay", this.f42099c);
            jSONObject.put(RequestParameters.POSITION, this.f42100d);
        } catch (JSONException e11) {
            d.a("VastProperties: JSON error", e11);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f42100d;
    }

    public Float getSkipOffset() {
        return this.f42098b;
    }

    public boolean isAutoPlay() {
        return this.f42099c;
    }

    public boolean isSkippable() {
        return this.f42097a;
    }
}
