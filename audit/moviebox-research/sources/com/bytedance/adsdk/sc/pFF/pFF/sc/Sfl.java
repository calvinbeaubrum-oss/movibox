package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Sfl implements com.bytedance.adsdk.sc.pFF.pFF.pFF {
    private com.bytedance.adsdk.sc.pFF.pFF.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.adsdk.sc.pFF.pFF.sc f26301sc;
    private com.bytedance.adsdk.sc.pFF.pFF.sc zY;

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        return this.f26301sc.pFF() + "?" + this.pFF.pFF() + ":" + this.zY.pFF();
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.pFF
    public void pFF(com.bytedance.adsdk.sc.pFF.pFF.sc scVar) {
        this.pFF = scVar;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return com.bytedance.adsdk.sc.pFF.We.TRI.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        Object objSc = this.f26301sc.sc(map);
        if (objSc == null) {
            return null;
        }
        return ((Boolean) objSc).booleanValue() ? this.pFF.sc(map) : this.zY.sc(map);
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.pFF
    public void sc(com.bytedance.adsdk.sc.pFF.pFF.sc scVar) {
        this.f26301sc = scVar;
    }

    public String toString() {
        return pFF();
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.pFF
    public void zY(com.bytedance.adsdk.sc.pFF.pFF.sc scVar) {
        this.zY = scVar;
    }
}
