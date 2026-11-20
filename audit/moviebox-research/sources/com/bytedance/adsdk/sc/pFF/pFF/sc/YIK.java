package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class YIK implements com.bytedance.adsdk.sc.pFF.pFF.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26304sc;

    public YIK(String str) {
        this.f26304sc = str;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        return "'" + this.f26304sc + "'";
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return com.bytedance.adsdk.sc.pFF.We.TRI.STRING;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        return this.f26304sc;
    }

    public String toString() {
        return pFF();
    }
}
