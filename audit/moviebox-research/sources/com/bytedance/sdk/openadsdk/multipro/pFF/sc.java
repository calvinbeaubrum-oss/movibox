package com.bytedance.sdk.openadsdk.multipro.pFF;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public long ExN;
    public long TRI;
    public boolean We;
    public boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public long f28651qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public boolean f28652sc;
    public boolean zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0311sc {
        sc TRI();
    }

    public static sc sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sc scVar = new sc();
        scVar.pFF(jSONObject.optBoolean("isCompleted"));
        scVar.zY(jSONObject.optBoolean("isFromVideoDetailPage"));
        scVar.We(jSONObject.optBoolean("isFromDetailPage"));
        scVar.sc(jSONObject.optLong("duration"));
        scVar.pFF(jSONObject.optLong("totalPlayDuration"));
        scVar.zY(jSONObject.optLong("currentPlayPosition"));
        scVar.sc(jSONObject.optBoolean("isAutoPlay"));
        return scVar;
    }

    public sc We(boolean z11) {
        this.zY = z11;
        return this;
    }

    public sc pFF(long j11) {
        this.TRI = j11;
        return this;
    }

    public sc pFF(boolean z11) {
        this.f28652sc = z11;
        return this;
    }

    public sc sc(long j11) {
        this.ExN = j11;
        return this;
    }

    public sc sc(boolean z11) {
        this.We = z11;
        return this;
    }

    public JSONObject sc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f28652sc);
            jSONObject.put("isFromVideoDetailPage", this.pFF);
            jSONObject.put("isFromDetailPage", this.zY);
            jSONObject.put("duration", this.ExN);
            jSONObject.put("totalPlayDuration", this.TRI);
            jSONObject.put("currentPlayPosition", this.f28651qr);
            jSONObject.put("isAutoPlay", this.We);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public sc zY(long j11) {
        this.f28651qr = j11;
        return this;
    }

    public sc zY(boolean z11) {
        this.pFF = z11;
        return this;
    }
}
