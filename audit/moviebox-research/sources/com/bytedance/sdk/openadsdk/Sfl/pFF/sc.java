package com.bytedance.sdk.openadsdk.Sfl.pFF;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private List<C0270sc> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27245sc;
    private List<C0270sc> zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.Sfl.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0270sc {
        private String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f27246sc;
        private int zY;

        public static C0270sc sc(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0270sc c0270sc = new C0270sc();
            c0270sc.f27246sc = jSONObject.optString("url");
            c0270sc.pFF = jSONObject.optString("md5");
            c0270sc.zY = jSONObject.optInt("type");
            return c0270sc;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0270sc)) {
                return super.equals(obj);
            }
            String str2 = this.f27246sc;
            if (str2 != null) {
                C0270sc c0270sc = (C0270sc) obj;
                if (str2.equals(c0270sc.f27246sc) && (str = this.pFF) != null && str.equals(c0270sc.pFF)) {
                    return true;
                }
            }
            return false;
        }

        public String sc() {
            return this.f27246sc;
        }
    }

    public static sc pFF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            sc scVar = new sc();
            scVar.sc(jSONObject.optString("version"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    C0270sc c0270scSc = C0270sc.sc(jSONArrayOptJSONArray.optJSONObject(i11));
                    if (c0270scSc != null) {
                        if (c0270scSc.zY == 1) {
                            arrayList.add(c0270scSc);
                        } else if (c0270scSc.zY == 2 && arrayList2.size() < 10) {
                            arrayList2.add(c0270scSc);
                        }
                    }
                }
            }
            scVar.sc(arrayList);
            scVar.pFF(arrayList2);
            return scVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public List<C0270sc> pFF() {
        return this.pFF;
    }

    public void pFF(List<C0270sc> list) {
        this.zY = list;
    }

    public String sc() {
        return this.f27245sc;
    }

    public void sc(String str) {
        this.f27245sc = str;
    }

    public void sc(List<C0270sc> list) {
        this.pFF = list;
    }

    public List<C0270sc> zY() {
        return this.zY;
    }
}
