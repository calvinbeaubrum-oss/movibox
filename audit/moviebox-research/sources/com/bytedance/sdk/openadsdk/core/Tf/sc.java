package com.bytedance.sdk.openadsdk.core.Tf;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private String BT;
    private String ExN;
    private int Ol;
    private double Qj;
    private String TRI;
    private String UFX;
    private int WH;
    private String We;
    pFF pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f28231qr;
    zY zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    We f28232sc = new We(this);
    private final Set<WH> Tf = new HashSet();
    private String Ql = "VAST_ACTION_BUTTON";
    private boolean SR = false;

    private JSONArray dE() {
        JSONArray jSONArray = new JSONArray();
        for (WH wh2 : this.Tf) {
            if (wh2 != null) {
                jSONArray.put(wh2.We());
            }
        }
        return jSONArray;
    }

    public static sc sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sc scVar = new sc();
        scVar.f28232sc.sc(jSONObject.optJSONObject("videoTrackers"));
        scVar.pFF = pFF.sc(jSONObject.optJSONObject("vastIcon"));
        scVar.zY = zY.pFF(jSONObject.optJSONObject("endCard"));
        scVar.We = jSONObject.optString(CampaignEx.JSON_KEY_TITLE);
        scVar.ExN = jSONObject.optString(TrackingKey.DESCRIPTION);
        scVar.TRI = jSONObject.optString("clickThroughUrl");
        scVar.f28231qr = jSONObject.optString("videoUrl");
        scVar.Qj = jSONObject.optDouble("videDuration");
        scVar.UFX = jSONObject.optString("tag");
        scVar.Ol = jSONObject.optInt("videoWidth");
        scVar.Ol = jSONObject.optInt("videoHeight");
        scVar.Tf.addAll(WH.sc(jSONObject.optJSONArray("viewabilityVendor")));
        return scVar;
    }

    public void BT() {
        this.SR = true;
    }

    public String ExN() {
        return this.ExN;
    }

    public void ExN(String str) {
        this.Ql = str;
    }

    public String Ol() {
        zY zYVar;
        String str = this.TRI;
        if (!TextUtils.isEmpty(this.BT)) {
            String str2 = this.BT;
            this.BT = null;
            return str2;
        }
        String str3 = this.Ql;
        str3.hashCode();
        if (str3.equals("VAST_ICON")) {
            pFF pff = this.pFF;
            if (pff != null && !TextUtils.isEmpty(pff.Qj)) {
                str = this.pFF.Qj;
            }
        } else if (str3.equals("VAST_END_CARD") && (zYVar = this.zY) != null && !TextUtils.isEmpty(zYVar.Qj)) {
            str = this.zY.Qj;
        }
        this.Ql = "VAST_ACTION_BUTTON";
        return str;
    }

    public double Qj() {
        return this.Qj;
    }

    public int Ql() {
        return this.WH;
    }

    public Set<WH> SR() {
        return this.Tf;
    }

    public String TRI() {
        return this.TRI;
    }

    public void TRI(String str) {
        this.UFX = str;
        this.f28232sc.sc(str);
    }

    public int Tf() {
        return this.Ol;
    }

    public String UFX() {
        return this.UFX;
    }

    public JSONObject WH() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoTrackers", this.f28232sc.sc());
        pFF pff = this.pFF;
        if (pff != null) {
            jSONObject.put("vastIcon", pff.sc());
        }
        zY zYVar = this.zY;
        if (zYVar != null) {
            jSONObject.put("endCard", zYVar.sc());
        }
        jSONObject.put(CampaignEx.JSON_KEY_TITLE, this.We);
        jSONObject.put(TrackingKey.DESCRIPTION, this.ExN);
        jSONObject.put("clickThroughUrl", this.TRI);
        jSONObject.put("videoUrl", this.f28231qr);
        jSONObject.put("videDuration", this.Qj);
        jSONObject.put("tag", this.UFX);
        jSONObject.put("videoWidth", this.Ol);
        jSONObject.put("videoHeight", this.WH);
        jSONObject.put("viewabilityVendor", dE());
        return jSONObject;
    }

    public String We() {
        return this.We;
    }

    public void We(String str) {
        this.f28231qr = str;
    }

    public pFF pFF() {
        return this.pFF;
    }

    public void pFF(int i11) {
        this.WH = i11;
    }

    public void pFF(String str) {
        this.ExN = str;
    }

    public String qr() {
        return this.f28231qr;
    }

    public void qr(String str) {
        this.BT = str;
    }

    public We sc() {
        return this.f28232sc;
    }

    public void sc(double d11) {
        this.Qj = d11;
    }

    public void sc(int i11) {
        this.Ol = i11;
    }

    public void sc(pFF pff) {
        if (pff != null) {
            pff.sc(this.f28231qr);
        }
        this.pFF = pff;
    }

    public void sc(zY zYVar) {
        if (zYVar != null) {
            zYVar.sc(this.f28231qr);
        }
        this.zY = zYVar;
    }

    public void sc(Sfl sfl) {
        this.f28232sc.sc(sfl);
        pFF pff = this.pFF;
        if (pff != null) {
            pff.sc(sfl);
        }
        zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.sc(sfl);
        }
    }

    public void sc(String str) {
        this.We = str;
    }

    public void sc(Set<WH> set) {
        if (set == null || set.size() <= 0) {
            return;
        }
        this.Tf.addAll(set);
    }

    public zY zY() {
        return this.zY;
    }

    public void zY(String str) {
        this.TRI = str;
    }
}
