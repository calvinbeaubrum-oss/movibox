package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends Xc {
    public TRI() {
        super(com.bytedance.adsdk.sc.pFF.We.zY.GT);
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        Object objSc;
        Object objSc2 = this.f26303sc.sc(map);
        if (objSc2 == null || (objSc = this.pFF.sc(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.sc.pFF.ExN.sc.zY.sc(objSc2, (Number) objSc);
    }
}
