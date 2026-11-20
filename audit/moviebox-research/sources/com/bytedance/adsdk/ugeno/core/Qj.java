package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private Map<String, Object> We;
    private JSONObject pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26391sc;
    private JSONObject zY;

    public Map<String, Object> pFF() {
        return this.We;
    }

    public void pFF(JSONObject jSONObject) {
        this.zY = jSONObject;
    }

    public JSONObject sc() {
        return this.zY;
    }

    public void sc(Context context) {
        this.f26391sc = context;
    }

    public void sc(Map<String, Object> map) {
        this.We = map;
    }

    public void sc(JSONObject jSONObject) {
        this.pFF = jSONObject;
    }
}
