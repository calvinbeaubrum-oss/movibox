package com.bytedance.adsdk.sc.pFF.pFF.sc;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr implements com.bytedance.adsdk.sc.pFF.pFF.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Object f26306sc;

    public qr(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.f26306sc = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.f26306sc = Boolean.FALSE;
        } else {
            if (!str.equalsIgnoreCase("null")) {
                throw new IllegalArgumentException();
            }
            this.f26306sc = null;
        }
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        Object obj = this.f26306sc;
        return obj != null ? obj.toString() : "NULL";
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return com.bytedance.adsdk.sc.pFF.We.TRI.CONSTANT;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        return this.f26306sc;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.f26306sc + "]";
    }
}
