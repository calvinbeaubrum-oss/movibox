package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f18560a;

    public e5(JSONObject jSONObject) {
        this.f18560a = jSONObject;
    }

    public Integer a() {
        return JsonUtils.getInteger(this.f18560a, "dark_mode_toolbar_color", null);
    }

    public String b() {
        return JsonUtils.getString(this.f18560a, "digital_asset_link_url", null);
    }

    public Boolean c() {
        return JsonUtils.getBoolean(this.f18560a, "instant_apps_enabled", null);
    }

    public String d() {
        return JsonUtils.getString(this.f18560a, "referrer", null);
    }

    public Integer e() {
        return JsonUtils.getInteger(this.f18560a, "session_url_relation", null);
    }

    public Integer f() {
        return JsonUtils.getInteger(this.f18560a, "share_state", null);
    }

    public Boolean g() {
        return JsonUtils.getBoolean(this.f18560a, "should_show_title", null);
    }

    public Integer h() {
        return JsonUtils.getInteger(this.f18560a, "toolbar_color", null);
    }

    public Boolean i() {
        return JsonUtils.getBoolean(this.f18560a, "url_bar_hiding_enabled", null);
    }
}
