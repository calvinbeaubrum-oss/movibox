package com.bytedance.adsdk.ugeno.We;

import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN implements qr {
    private com.bytedance.adsdk.ugeno.pFF.zY pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Map<String, com.bytedance.adsdk.ugeno.We.zY.sc> f26371sc;
    private boolean zY;

    public ExN(com.bytedance.adsdk.ugeno.pFF.zY zYVar, Map<String, com.bytedance.adsdk.ugeno.We.zY.sc> map) {
        this.pFF = zYVar;
        this.f26371sc = map;
    }

    public static ExN sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str) {
        com.bytedance.adsdk.ugeno.We.zY.sc scVarSc;
        if (zYVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                HashMap map = new HashMap();
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                    if (jSONObjectOptJSONObject != null && (scVarSc = com.bytedance.adsdk.ugeno.We.zY.sc.C0230sc.sc(zYVar.Ol().getContext(), zYVar, jSONObjectOptJSONObject, zYVar.WH())) != null) {
                        map.put(scVarSc.pFF(), scVarSc);
                    }
                }
                return new ExN(zYVar, map);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private void sc(String str, List<pFF.sc> list) {
        com.bytedance.adsdk.ugeno.We.pFF.sc scVarSc;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (pFF.sc scVar : list) {
            if (scVar != null && (scVarSc = com.bytedance.adsdk.ugeno.We.pFF.sc.C0229sc.sc(this.pFF, str, scVar)) != null) {
                scVarSc.sc();
            }
        }
    }

    public void We() {
        com.bytedance.adsdk.ugeno.We.zY.sc scVarSc = sc("timer");
        if (scVarSc != null) {
            scVarSc.sc(this);
            scVarSc.sc(new Object[0]);
        }
    }

    public void pFF() {
        com.bytedance.adsdk.ugeno.We.zY.sc scVarSc = sc("twist");
        if (scVarSc != null) {
            scVarSc.sc(this);
            scVarSc.sc(new Object[0]);
        }
    }

    public com.bytedance.adsdk.ugeno.We.zY.sc sc(String str) {
        Map<String, com.bytedance.adsdk.ugeno.We.zY.sc> map = this.f26371sc;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f26371sc.get(str);
    }

    public void sc() {
        com.bytedance.adsdk.ugeno.We.zY.sc scVarSc = sc("shake");
        if (scVarSc != null) {
            scVarSc.sc(this);
            scVarSc.sc(new Object[0]);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.We.qr
    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, List<pFF.sc> list) {
        sc(str, list);
    }

    public boolean sc(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.We.zY.sc scVarSc = sc("tap");
        if (scVarSc instanceof com.bytedance.adsdk.ugeno.We.zY.We) {
            scVarSc.sc(this);
            this.zY = scVarSc.sc(motionEvent);
        }
        if (this.zY) {
            return true;
        }
        com.bytedance.adsdk.ugeno.We.zY.sc scVarSc2 = sc("slide");
        if (!(scVarSc2 instanceof com.bytedance.adsdk.ugeno.We.zY.zY)) {
            return this.zY;
        }
        scVarSc2.sc(this);
        return scVarSc2.sc(motionEvent);
    }

    public void zY() {
        for (Map.Entry<String, com.bytedance.adsdk.ugeno.We.zY.sc> entry : this.f26371sc.entrySet()) {
            if (entry != null) {
                com.bytedance.adsdk.ugeno.We.zY.sc value = entry.getValue();
                if (value instanceof com.bytedance.adsdk.ugeno.We.zY.pFF) {
                    value.sc(this);
                    value.sc(new Object[0]);
                }
            }
        }
    }
}
