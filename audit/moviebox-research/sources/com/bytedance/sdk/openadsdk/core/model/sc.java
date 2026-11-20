package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private boolean ExN;
    private long Ol;
    private String Qj;
    private int Ql;
    private String SR;
    private boolean WH;
    private C0304sc We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28448sc;
    private String zY;
    private List<Sfl> TRI = new ArrayList();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private List<Qj> f28447qr = new ArrayList();
    private JSONObject UFX = new JSONObject();
    private volatile boolean Tf = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.model.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0304sc extends Sfl.sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private int f28449sc;

        public static C0304sc sc(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0304sc c0304sc = new C0304sc();
            c0304sc.zY(jSONObject.optString("id"));
            c0304sc.We(jSONObject.optString("md5"));
            c0304sc.ExN(jSONObject.optString("url"));
            c0304sc.TRI(jSONObject.optString("data"));
            c0304sc.qr(jSONObject.optString("diff_data"));
            c0304sc.pFF(jSONObject.optString("version"));
            c0304sc.Qj(jSONObject.optString("dynamic_creative"));
            c0304sc.sc(jSONObject.optInt("count_down_time"));
            if (sc(c0304sc)) {
                return c0304sc;
            }
            return null;
        }

        private static boolean sc(C0304sc c0304sc) {
            return (c0304sc == null || TextUtils.isEmpty(c0304sc.TRI()) || TextUtils.isEmpty(c0304sc.Qj())) ? false : true;
        }

        public JSONObject pFF() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", TRI());
                jSONObject.put("md5", qr());
                jSONObject.put("url", Qj());
                jSONObject.put("data", Ol());
                jSONObject.put("diff_data", WH());
                jSONObject.put("version", ExN());
                jSONObject.put("dynamic_creative", UFX());
                jSONObject.put("count_down_time", sc());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public int sc() {
            return this.f28449sc;
        }

        public void sc(int i11) {
            this.f28449sc = i11;
        }
    }

    public static Map<String, Sfl> sc(sc scVar) {
        if (scVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (Sfl sfl : scVar.We()) {
            if (!TextUtils.isEmpty(sfl.PPh())) {
                map.put(sfl.PPh(), sfl);
            }
        }
        if (map.size() != 0) {
            return map;
        }
        return null;
    }

    public static sc zY(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            sc scVar = new sc();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("choose_ui_data");
            if (jSONObjectOptJSONObject != null) {
                scVar.pFF(jSONObjectOptJSONObject);
            }
            scVar.pFF(jSONObject.optInt("multi_ad_style", 0));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    Sfl sflSc = com.bytedance.sdk.openadsdk.core.pFF.sc(jSONArrayOptJSONArray.optJSONObject(i11));
                    if (sflSc != null) {
                        sflSc.Ol(scVar.Tf());
                        arrayList.add(sflSc);
                    }
                }
                scVar.sc(arrayList);
            }
            scVar.sc(jSONObject.optBoolean("is_choose_ad_original", false));
            scVar.sc(jSONObject.optString(TrackingKey.REQUEST_ID, ""));
            return scVar;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("AdInfo", "fromJson: ", th2);
            return null;
        }
    }

    public boolean ExN() {
        List<Sfl> list = this.TRI;
        return list != null && list.size() > 0;
    }

    public C0304sc Ol() {
        return this.We;
    }

    public boolean Qj() {
        return this.WH;
    }

    @Nullable
    public JSONObject Ql() {
        try {
            JSONObject jSONObject = new JSONObject();
            C0304sc c0304scOl = Ol();
            if (c0304scOl != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObjectPFF = c0304scOl.pFF();
                if (jSONObjectPFF != null) {
                    jSONObject2.put("tpl_info", jSONObjectPFF);
                    jSONObject.put("choose_ui_data", jSONObject2);
                }
            }
            List<Sfl> list = this.TRI;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < this.TRI.size(); i11++) {
                    jSONArray.put(this.TRI.get(i11).JP());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("is_choose_ad_original", this.WH);
            jSONObject.put("multi_ad_style", this.Ql);
            jSONObject.put(TrackingKey.REQUEST_ID, this.f28448sc);
            return jSONObject;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("AdInfo", "toJsonObj: ", th2);
            return null;
        }
    }

    public String SR() {
        return this.SR;
    }

    public Sfl TRI() {
        if (this.TRI.size() > 0) {
            return this.TRI.get(0);
        }
        return null;
    }

    public boolean Tf() {
        return this.Ql == 1;
    }

    public void UFX() {
        this.Tf = false;
    }

    public boolean WH() {
        return this.Tf;
    }

    public List<Sfl> We() {
        return this.TRI;
    }

    public void We(String str) {
        this.SR = str;
    }

    public String pFF() {
        Sfl sflTRI = TRI();
        return sflTRI != null ? sflTRI.ofL() : "";
    }

    public void pFF(int i11) {
        this.Ql = i11;
    }

    public void pFF(String str) {
        this.zY = str;
    }

    public void pFF(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sc(C0304sc.sc(jSONObject.optJSONObject("tpl_info")));
    }

    public boolean qr() {
        if (Ol() == null || We() == null || We().size() <= 1) {
            this.ExN = false;
            sc((C0304sc) null);
        } else {
            this.ExN = true;
        }
        return this.ExN;
    }

    public JSONObject sc() {
        return this.UFX;
    }

    public void sc(int i11) {
        this.pFF = i11;
    }

    public void sc(long j11) {
        this.Ol = j11;
    }

    public void sc(Qj qj2) {
        this.f28447qr.add(qj2);
    }

    public void sc(Sfl sfl) {
        this.TRI.add(sfl);
    }

    public void sc(C0304sc c0304sc) {
        this.We = c0304sc;
        if (c0304sc == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.sc.pFF.pFF.sc(Sfl.sc.sc(c0304sc, ""));
    }

    public void sc(String str) {
        this.f28448sc = str;
    }

    public void sc(List<Sfl> list) {
        this.TRI = list;
    }

    public void sc(JSONObject jSONObject) {
        this.UFX = jSONObject;
    }

    public void sc(boolean z11) {
        this.WH = z11;
    }

    public int zY() {
        return this.pFF;
    }

    public void zY(String str) {
        this.Qj = str;
    }
}
