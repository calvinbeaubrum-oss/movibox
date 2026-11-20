package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    public AdSlot ExN;
    public ArrayList<Integer> We;
    public int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public String f28444sc;
    public int zY = 1;

    public static void sc(pFF pff) {
        int iPFF;
        if (pff == null || pff.We() == null || (iPFF = pff.pFF()) >= 0 || iPFF == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.SR.zY.sc();
        com.bytedance.sdk.openadsdk.SR.zY.sc("rd_client_custom_error", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.model.pFF.1
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("from", pFF.this.zY());
                jSONObject.put("err_code", pFF.this.pFF());
                jSONObject.put("server_res_str", pFF.this.sc());
                if (pFF.this.ExN() != null && pFF.this.ExN().size() > 0) {
                    jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) pFF.this.ExN()).toString());
                }
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("rd_client_custom_error").sc(pFF.this.We().getDurationSlotType()).pFF(jSONObject.toString());
            }
        });
    }

    public ArrayList<Integer> ExN() {
        return this.We;
    }

    public AdSlot We() {
        return this.ExN;
    }

    public int pFF() {
        return this.pFF;
    }

    public void pFF(int i11) {
        this.zY = i11;
    }

    public String sc() {
        return this.f28444sc;
    }

    public void sc(int i11) {
        this.pFF = i11;
    }

    public void sc(AdSlot adSlot) {
        this.ExN = adSlot;
    }

    public void sc(String str) {
        this.f28444sc = str;
    }

    public void sc(ArrayList<Integer> arrayList) {
        this.We = arrayList;
    }

    public int zY() {
        return this.zY;
    }
}
