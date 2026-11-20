package com.bytedance.sdk.component.sc;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BT {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Map<String, Object> f26993sc = new ConcurrentHashMap();

    private BT() {
    }

    public static BT sc() {
        return new BT();
    }

    public String pFF() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.f26993sc.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public BT sc(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f26993sc.put(str, obj);
        }
        return this;
    }
}
