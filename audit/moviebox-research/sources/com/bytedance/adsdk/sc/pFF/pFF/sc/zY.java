package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends Xc {
    public zY() {
        super(com.bytedance.adsdk.sc.pFF.We.zY.DOUBLE_BAR);
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        return Boolean.valueOf(com.bytedance.adsdk.sc.pFF.ExN.pFF.sc(this.f26303sc.sc(map)) || com.bytedance.adsdk.sc.pFF.ExN.pFF.sc(this.pFF.sc(map)));
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc.Xc
    public String toString() {
        return pFF();
    }
}
