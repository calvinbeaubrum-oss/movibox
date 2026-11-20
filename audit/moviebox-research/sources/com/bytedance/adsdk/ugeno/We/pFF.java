package com.bytedance.adsdk.ugeno.We;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private List<sc> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private sc f26373sc;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f26374sc = "global";
        private Map<String, String> zY;

        public String pFF() {
            return this.pFF;
        }

        public void pFF(String str) {
            this.pFF = str;
        }

        public String sc() {
            return this.f26374sc;
        }

        public void sc(String str) {
            this.f26374sc = str;
        }

        public void sc(Map<String, String> map) {
            this.zY = map;
        }

        public String toString() {
            return "Action{scheme='" + this.f26374sc + "', name='" + this.pFF + "', params=" + this.zY + '}';
        }

        public Map<String, String> zY() {
            return this.zY;
        }
    }

    public static pFF sc(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        pFF pff = new pFF();
        String strOptString = jSONObject.optString("on");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        pff.f26373sc = Qj.sc(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
            sc scVarSc = Qj.sc(jSONArrayOptJSONArray.optString(i11), jSONObject2);
            if (scVarSc != null) {
                arrayList.add(scVarSc);
            }
        }
        pff.pFF = arrayList;
        return pff;
    }

    public List<sc> pFF() {
        return this.pFF;
    }

    public sc sc() {
        return this.f26373sc;
    }
}
