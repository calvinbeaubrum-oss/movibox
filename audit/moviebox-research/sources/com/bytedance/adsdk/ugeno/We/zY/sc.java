package com.bytedance.adsdk.ugeno.We.zY;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.We.TRI;
import com.bytedance.adsdk.ugeno.We.qr;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc {
    protected Map<String, String> ExN;
    protected Context Qj;
    protected String TRI;
    protected com.bytedance.adsdk.ugeno.We.pFF.sc We;
    protected com.bytedance.adsdk.ugeno.pFF.zY pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected String f26383qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected qr f26384sc;
    protected com.bytedance.adsdk.ugeno.We.pFF zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.We.zY.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0230sc {
        public static sc sc(Context context, com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.We.pFF pffSc;
            com.bytedance.adsdk.ugeno.We.pFF.sc scVarSc;
            if (zYVar == null || jSONObject == null || (pffSc = com.bytedance.adsdk.ugeno.We.pFF.sc(jSONObject, jSONObject2)) == null || (scVarSc = pffSc.sc()) == null) {
                return null;
            }
            if (TextUtils.equals(scVarSc.sc(), "custom")) {
                pFF pff = new pFF(context);
                pff.sc(zYVar);
                pff.sc(pffSc);
                pff.sc();
                return pff;
            }
            com.bytedance.adsdk.ugeno.We.zY zYVarSc = TRI.sc(scVarSc.pFF());
            if (zYVarSc == null) {
                return null;
            }
            sc scVarSc2 = zYVarSc.sc(context);
            scVarSc2.sc(zYVar);
            scVarSc2.sc(pffSc);
            scVarSc2.sc();
            return scVarSc2;
        }
    }

    public sc(Context context) {
        this.Qj = context;
    }

    public String pFF() {
        return this.TRI;
    }

    public void sc() {
        this.We = this.zY.sc();
        com.bytedance.adsdk.ugeno.We.pFF pff = this.zY;
        if (pff == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.We.pFF.sc scVarSc = pff.sc();
        this.We = scVarSc;
        if (scVarSc == null) {
            return;
        }
        this.ExN = scVarSc.zY();
        this.TRI = this.We.pFF();
        this.f26383qr = this.We.sc();
    }

    public void sc(com.bytedance.adsdk.ugeno.We.pFF pff) {
        this.zY = pff;
    }

    public void sc(qr qrVar) {
        this.f26384sc = qrVar;
    }

    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        this.pFF = zYVar;
    }

    public abstract boolean sc(Object... objArr);
}
