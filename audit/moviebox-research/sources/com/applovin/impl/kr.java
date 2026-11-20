package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class kr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f20278c;

    public kr(JSONObject jSONObject) {
        this.f20276a = JsonUtils.getString(jSONObject, "user_type", "all");
        this.f20277b = JsonUtils.getString(jSONObject, "device_type", "all");
        this.f20278c = JsonUtils.getStringList(jSONObject, "segments", null);
    }

    public String a() {
        return this.f20276a;
    }

    public String b() {
        return this.f20277b;
    }

    public List c() {
        return this.f20278c;
    }
}
