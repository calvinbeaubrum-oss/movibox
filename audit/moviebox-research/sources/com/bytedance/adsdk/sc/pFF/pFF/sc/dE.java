package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE implements com.bytedance.adsdk.sc.pFF.pFF.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.adsdk.sc.pFF.We.zY f26305sc;

    public dE(com.bytedance.adsdk.sc.pFF.We.zY zYVar) {
        this.f26305sc = zYVar;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        return this.f26305sc.sc();
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return this.f26305sc;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return pFF();
    }
}
