package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import com.bytedance.sdk.openadsdk.We.ExN.pFF.zY;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc<T extends zY> {
    private boolean ExN = false;
    private T We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Sfl f27319sc;
    private JSONObject zY;

    public sc(Sfl sfl, String str, JSONObject jSONObject, T t11) {
        this.f27319sc = sfl;
        this.pFF = str;
        this.zY = jSONObject;
        this.We = t11;
    }

    public boolean ExN() {
        return this.ExN;
    }

    public T We() {
        return this.We;
    }

    public String pFF() {
        return this.pFF;
    }

    public Sfl sc() {
        return this.f27319sc;
    }

    public void sc(boolean z11) {
        this.ExN = z11;
    }

    public JSONObject zY() {
        if (this.zY == null) {
            this.zY = new JSONObject();
        }
        return this.zY;
    }
}
