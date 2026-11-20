package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class rn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f22153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f22154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f22156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f22157e;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        TCF_VENDOR,
        ATP_NETWORK,
        OTHER;

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(int i11) {
            if (i11 != 0) {
                return i11 != 1 ? OTHER : ATP_NETWORK;
            }
            return TCF_VENDOR;
        }
    }

    public rn(JSONObject jSONObject, String str) {
        this.f22156d = str;
        this.f22153a = a.b(JsonUtils.getInt(jSONObject, "type", a.OTHER.ordinal()));
        this.f22154b = JsonUtils.getInteger(jSONObject, "id", null);
        this.f22155c = JsonUtils.getString(jSONObject, "name", null);
    }

    public Boolean a() {
        return this.f22157e;
    }

    public void a(Boolean bool) {
        this.f22157e = bool;
    }

    public String b() {
        return this.f22156d;
    }

    public String c() {
        return this.f22155c;
    }

    public Integer d() {
        return this.f22154b;
    }

    public String e() {
        Boolean bool = this.f22157e;
        return "\n" + this.f22156d + " - " + (bool != null ? String.valueOf(bool) : a4.b().a(com.applovin.impl.sdk.j.l()));
    }

    public a f() {
        return this.f22153a;
    }
}
