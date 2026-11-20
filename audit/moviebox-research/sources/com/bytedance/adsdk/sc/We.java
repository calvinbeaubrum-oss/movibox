package com.bytedance.adsdk.sc;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We implements ExN {
    @Override // com.bytedance.adsdk.sc.ExN
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public Boolean sc(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
