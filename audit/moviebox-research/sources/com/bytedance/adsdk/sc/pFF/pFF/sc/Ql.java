package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ql extends Xc {
    public Ql() {
        super(com.bytedance.adsdk.sc.pFF.We.zY.MULTI);
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        Object objSc;
        Object objSc2 = this.f26303sc.sc(map);
        if (objSc2 == null || (objSc = this.pFF.sc(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.sc.pFF.ExN.sc.qr.sc((Number) objSc2, (Number) objSc);
    }
}
