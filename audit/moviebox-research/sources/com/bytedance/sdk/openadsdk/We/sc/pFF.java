package com.bytedance.sdk.openadsdk.We.sc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    public int We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public AtomicInteger f27409sc = new AtomicInteger(0);
    public AtomicInteger pFF = new AtomicInteger(0);
    public AtomicLong zY = new AtomicLong(0);
    public AtomicInteger ExN = new AtomicInteger(0);
    public Map<Integer, Integer> TRI = new HashMap();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public AtomicBoolean f27408qr = new AtomicBoolean(false);

    public pFF(int i11) {
        this.We = i11;
    }

    public JSONObject pFF() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.f27409sc.get());
            jSONObject.put("fail", this.pFF.get());
            jSONObject.put("type", this.We);
            jSONObject.put("time", this.ExN.get());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject sc() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.f27409sc.get());
            jSONObject.put("fail", this.pFF.get());
            jSONObject.put("type", this.We);
            jSONObject.put("duration", this.zY.get() / ((long) this.f27409sc.get()));
            JSONObject jSONObject2 = new JSONObject();
            if (this.TRI.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : this.TRI.entrySet()) {
                    jSONObject2.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
            jSONObject.put("fail_error_code", jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
