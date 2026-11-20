package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.hisavana.common.tracking.TrackingKey;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21666c;

    public p6(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f21664a = JsonUtils.getString(jSONObject, "name", "");
        this.f21665b = JsonUtils.getString(jSONObject, TrackingKey.DESCRIPTION, "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        if (list != null) {
            this.f21666c = yp.a(list);
        } else {
            this.f21666c = yp.a(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
    }

    public static boolean a(String str, String str2, String str3) {
        if (str == null) {
            return true;
        }
        if (str2 == null || yp.a(str2, str) != 1) {
            return str3 == null || yp.a(str3, str) != -1;
        }
        return false;
    }

    public String a() {
        return this.f21665b;
    }

    public String b() {
        return this.f21664a;
    }

    public boolean c() {
        return this.f21666c;
    }
}
