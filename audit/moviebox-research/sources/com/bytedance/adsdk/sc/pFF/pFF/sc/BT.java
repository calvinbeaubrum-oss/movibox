package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT implements com.bytedance.adsdk.sc.pFF.pFF.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Number f26299sc;

    public BT(String str) {
        if (str.indexOf(46) < 0) {
            try {
                this.f26299sc = Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                this.f26299sc = Long.valueOf(str);
            }
        } else {
            Float fValueOf = Float.valueOf(str);
            this.f26299sc = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.f26299sc = Double.valueOf(str);
            }
        }
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        return this.f26299sc.toString();
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return com.bytedance.adsdk.sc.pFF.We.TRI.NUMBER;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        return this.f26299sc;
    }

    public String toString() {
        return pFF();
    }
}
