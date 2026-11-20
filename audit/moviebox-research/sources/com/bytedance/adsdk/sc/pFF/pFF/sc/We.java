package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends Xc {
    public We() {
        super(com.bytedance.adsdk.sc.pFF.We.zY.EQ);
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        Object objSc = this.f26303sc.sc(map);
        Object objSc2 = this.pFF.sc(map);
        if (objSc == null && objSc2 == null) {
            return Boolean.TRUE;
        }
        if (objSc == null && objSc2 != null) {
            return Boolean.FALSE;
        }
        if (objSc == null || objSc2 != null) {
            return ((objSc instanceof Number) && (objSc2 instanceof Number)) ? Boolean.valueOf(com.bytedance.adsdk.sc.pFF.ExN.sc.pFF.sc((Number) objSc, (Number) objSc2)) : Boolean.valueOf(objSc.equals(objSc2));
        }
        return Boolean.FALSE;
    }
}
