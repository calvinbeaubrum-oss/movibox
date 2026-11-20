package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp extends Xc {
    private static final ThreadLocal<StringBuilder> We = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.sc.pFF.pFF.sc.wjp.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public wjp() {
        super(com.bytedance.adsdk.sc.pFF.We.zY.PLUS);
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        Object objSc;
        Object objSc2 = this.f26303sc.sc(map);
        if (objSc2 == null || (objSc = this.pFF.sc(map)) == null) {
            return null;
        }
        if (!(objSc2 instanceof String) && !(objSc instanceof String)) {
            return com.bytedance.adsdk.sc.pFF.ExN.sc.Qj.sc((Number) objSc2, (Number) objSc);
        }
        StringBuilder sb2 = We.get();
        sb2.append(objSc2);
        sb2.append(objSc);
        String string = sb2.toString();
        sb2.setLength(0);
        return string;
    }
}
