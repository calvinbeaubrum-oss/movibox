package com.bytedance.sdk.openadsdk.core.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {
    private List<String> ExN;
    private int TRI;
    private int We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28377qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f28378sc;
    private List<Integer> zY;

    public int ExN() {
        return this.pFF;
    }

    public void ExN(int i11) {
        this.We = i11;
    }

    public JSONObject Qj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interceptor_x", this.f28378sc);
            jSONObject.put("interceptor_y", this.pFF);
            if (this.zY != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Integer> it = this.zY.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().intValue());
                }
                jSONObject.put("interceptor_page", jSONArray);
            }
            jSONObject.put("interceptor_interval_time", this.We);
            if (this.ExN != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it2 = this.ExN.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next());
                }
                jSONObject.put("url_regular", jSONArray2);
            }
            jSONObject.put("is_act", this.TRI);
            jSONObject.put("boc_index", this.f28377qr);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
        }
        return jSONObject;
    }

    public List<Integer> TRI() {
        return this.zY;
    }

    public int We() {
        return this.f28378sc;
    }

    public void We(int i11) {
        this.pFF = i11;
    }

    public int pFF() {
        int i11 = this.f28377qr;
        if (i11 >= 2) {
            return i11;
        }
        return 0;
    }

    public void pFF(int i11) {
        this.f28377qr = i11;
    }

    public void pFF(List<Integer> list) {
        this.zY = list;
    }

    public int qr() {
        return this.We;
    }

    public void sc(int i11) {
        this.TRI = i11;
    }

    public void sc(List<String> list) {
        this.ExN = list;
    }

    public boolean sc() {
        return this.TRI == 1;
    }

    public List<String> zY() {
        return this.ExN;
    }

    public void zY(int i11) {
        this.f28378sc = i11;
    }
}
