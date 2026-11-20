package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Dl implements com.bytedance.adsdk.sc.pFF.pFF.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.adsdk.sc.pFF.We.We f26300sc;

    public Dl(com.bytedance.adsdk.sc.pFF.We.We we2) {
        this.f26300sc = we2;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        return this.f26300sc.sc();
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return this.f26300sc;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return pFF();
    }
}
