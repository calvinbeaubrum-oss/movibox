package com.bytedance.adsdk.ugeno.core;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH {
    private WH ExN;
    private WH We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.pFF.zY f26395sc;
    private JSONObject zY;

    public WH We() {
        return this.We;
    }

    public int pFF() {
        return this.pFF;
    }

    public void pFF(WH wh2) {
        this.ExN = wh2;
    }

    public com.bytedance.adsdk.ugeno.pFF.zY sc() {
        return this.f26395sc;
    }

    public void sc(int i11) {
        this.pFF = i11;
    }

    public void sc(WH wh2) {
        this.We = wh2;
    }

    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        this.f26395sc = zYVar;
    }

    public void sc(JSONObject jSONObject) {
        this.zY = jSONObject;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.f26395sc + ", mEventType=" + this.pFF + ", mEvent=" + this.zY + '}';
    }

    public JSONObject zY() {
        return this.zY;
    }
}
