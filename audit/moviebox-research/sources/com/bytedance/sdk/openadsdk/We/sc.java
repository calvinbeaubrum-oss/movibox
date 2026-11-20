package com.bytedance.sdk.openadsdk.We;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements com.bytedance.sdk.component.TRI.sc.We.sc.pFF {
    private String BT;
    private String Dl;
    private long ExN;
    private String FI;
    private int JPJ;
    private int Ol;
    private int Qj;
    private JSONObject Ql;
    private String SR;
    private String Sfl;
    private final String TRI;
    private final AtomicBoolean Tf;
    private long We;
    private String Xc;
    private com.bytedance.sdk.openadsdk.We.pFF.sc YIK;
    private String dE;
    protected final JSONObject pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f27377qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final String f27378sc;
    private String uEA;
    private String wjp;
    private boolean zY;
    private static final Set<String> WH = new HashSet(Arrays.asList("insight_log"));
    private static final Map<String, String> UFX = new HashMap<String, String>() { // from class: com.bytedance.sdk.openadsdk.We.sc.1
        {
            put("id", "extra_id");
            put("source", "extra_source");
            put("url", "extra_url");
            put("toolType", "extra_tool_type");
            put("storeOpenType", "store_open_type");
            put("errorCode", TrackingKey.ERROR_CODE);
            put("md5", "extra_md5");
            put("areaType", "area_type");
            put("rectInfo", "rect_info");
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.We.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0273sc {
        private com.bytedance.sdk.openadsdk.We.pFF.sc BT;
        private String ExN;
        private String Ol;
        private String Qj;
        private String Ql;
        private com.bytedance.sdk.openadsdk.We.pFF.pFF SR;
        private boolean Sfl;
        private String TRI;
        private final int Tf;
        private String UFX;
        private JSONObject WH;
        private String We;
        private int Xc;
        private String YIK;
        private final long dE;
        private String pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private String f27379qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f27380sc;
        private int wjp;
        private String zY;

        public C0273sc(long j11, Sfl sfl) {
            this.Xc = -1;
            this.wjp = -1;
            this.f27380sc = -1;
            if (sfl != null) {
                this.Sfl = JPJ.pFF(sfl);
                this.Xc = sfl.wjp();
                this.wjp = sfl.Xc();
                this.f27380sc = sfl.dix();
            }
            this.dE = j11;
            this.Tf = com.bytedance.sdk.component.utils.BT.zY(com.bytedance.sdk.openadsdk.core.Xc.sc());
        }

        public C0273sc ExN(String str) {
            this.Qj = str;
            return this;
        }

        public C0273sc Qj(String str) {
            this.YIK = str;
            return this;
        }

        public C0273sc TRI(String str) {
            this.Ol = str;
            return this;
        }

        public C0273sc We(String str) {
            this.ExN = str;
            return this;
        }

        public C0273sc pFF(String str) {
            this.zY = str;
            return this;
        }

        public C0273sc qr(String str) {
            this.f27379qr = str;
            return this;
        }

        public C0273sc sc(String str) {
            this.Ql = str;
            return this;
        }

        public C0273sc sc(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.WH = jSONObject;
            return this;
        }

        public void sc(com.bytedance.sdk.openadsdk.We.pFF.sc scVar) {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc(this.We, this.YIK, this.f27379qr, this.zY);
            this.BT = scVar;
            final sc scVar2 = new sc(this);
            try {
                com.bytedance.sdk.openadsdk.We.pFF.pFF pff = this.SR;
                if (pff != null) {
                    pff.sc(scVar2.pFF, this.dE);
                } else {
                    new com.bytedance.sdk.openadsdk.We.pFF.zY().sc(scVar2.pFF, this.dE);
                }
            } catch (Throwable unused) {
            }
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                Cb.zY(new com.bytedance.sdk.component.Qj.Qj("dispatchEvent") { // from class: com.bytedance.sdk.openadsdk.We.sc.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.We.sc.We.sc(scVar2);
                    }
                });
            } else {
                com.bytedance.sdk.openadsdk.We.sc.We.sc(scVar2);
            }
        }

        public C0273sc zY(String str) {
            this.We = str;
            return this;
        }
    }

    public sc(C0273sc c0273sc) {
        this.TRI = "adiff";
        this.Tf = new AtomicBoolean(false);
        this.Ql = new JSONObject();
        if (TextUtils.isEmpty(c0273sc.pFF)) {
            this.f27378sc = com.bytedance.sdk.openadsdk.utils.JPJ.sc();
        } else {
            this.f27378sc = c0273sc.pFF;
        }
        this.YIK = c0273sc.BT;
        this.uEA = c0273sc.TRI;
        this.SR = c0273sc.zY;
        this.BT = c0273sc.We;
        if (TextUtils.isEmpty(c0273sc.ExN)) {
            this.dE = "app_union";
        } else {
            this.dE = c0273sc.ExN;
        }
        this.Dl = c0273sc.UFX;
        this.Xc = c0273sc.Qj;
        this.Sfl = c0273sc.Ol;
        this.wjp = c0273sc.f27379qr;
        this.JPJ = c0273sc.Tf;
        this.FI = c0273sc.Ql;
        this.Ql = c0273sc.WH = c0273sc.WH != null ? c0273sc.WH : new JSONObject();
        JSONObject jSONObject = new JSONObject();
        this.pFF = jSONObject;
        if (!TextUtils.isEmpty(c0273sc.Ql)) {
            try {
                jSONObject.put("app_log_url", c0273sc.Ql);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("AdEvent", e11.getMessage());
            }
        }
        this.f27377qr = c0273sc.Xc;
        this.Qj = c0273sc.wjp;
        this.Ol = c0273sc.f27380sc;
        this.zY = c0273sc.Sfl;
        this.ExN = System.currentTimeMillis();
        TRI();
    }

    public sc(String str, JSONObject jSONObject) {
        this.TRI = "adiff";
        this.Tf = new AtomicBoolean(false);
        this.Ql = new JSONObject();
        this.f27378sc = str;
        this.pFF = jSONObject;
    }

    private void TRI() {
        JSONObject jSONObject = this.Ql;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            String strOptString2 = this.Ql.optString("category");
            String strOptString3 = this.Ql.optString("log_extra");
            if (sc(this.Xc, this.dE, this.uEA)) {
                if (!TextUtils.isEmpty(strOptString) && TextUtils.equals(strOptString, "0")) {
                    return;
                }
                if (!TextUtils.isEmpty(strOptString2) && !pFF(strOptString2)) {
                    return;
                }
            } else {
                if ((TextUtils.isEmpty(strOptString) || TextUtils.equals(strOptString, "0")) && (TextUtils.isEmpty(this.Xc) || TextUtils.equals(this.Xc, "0"))) {
                    return;
                }
                if ((TextUtils.isEmpty(this.dE) || !pFF(this.dE)) && (TextUtils.isEmpty(strOptString2) || !pFF(strOptString2))) {
                    return;
                }
                if (TextUtils.isEmpty(this.uEA) && TextUtils.isEmpty(strOptString3)) {
                    return;
                }
            }
        } else if (!sc(this.Xc, this.dE, this.uEA)) {
            return;
        }
        this.We = com.bytedance.sdk.openadsdk.We.sc.We.f27406sc.incrementAndGet();
    }

    private void pFF(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : UFX.keySet()) {
            try {
                if (jSONObject.has(str)) {
                    Object objOpt = jSONObject.opt(str);
                    jSONObject.remove(str);
                    jSONObject.put(UFX.get(str), objOpt);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private boolean pFF(String str) {
        str.hashCode();
        switch (str) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    private void qr() throws JSONException {
        this.pFF.putOpt("app_log_url", this.FI);
        this.pFF.putOpt("tag", this.SR);
        this.pFF.putOpt("label", this.BT);
        this.pFF.putOpt("category", this.dE);
        if (!TextUtils.isEmpty(this.Xc)) {
            try {
                this.pFF.putOpt(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(Long.parseLong(this.Xc)));
            } catch (NumberFormatException unused) {
                this.pFF.putOpt(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0L);
            }
        }
        if (!TextUtils.isEmpty(this.Sfl)) {
            try {
                this.pFF.putOpt("ext_value", Long.valueOf(Long.parseLong(this.Sfl)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.uEA)) {
            this.pFF.putOpt("log_extra", this.uEA);
        }
        if (!TextUtils.isEmpty(this.Dl)) {
            try {
                this.pFF.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.Dl)));
            } catch (NumberFormatException unused3) {
            }
        }
        sc(this.pFF, this.BT);
        try {
            this.pFF.putOpt("nt", Integer.valueOf(this.JPJ));
        } catch (Exception unused4) {
        }
        Iterator<String> itKeys = this.Ql.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.pFF.putOpt(next, this.Ql.opt(next));
        }
    }

    private JSONObject sc(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("adiff")) {
                jSONObject.put("adiff", this.f27378sc);
            }
            if (this.zY) {
                if (!jSONObject.has("interaction_method")) {
                    jSONObject.put("interaction_method", this.f27377qr);
                }
                if (!jSONObject.has("real_interaction_method")) {
                    jSONObject.put("real_interaction_method", this.Qj);
                }
                if (!jSONObject.has("image_mode")) {
                    jSONObject.put("image_mode", this.Ol);
                }
            }
            if (com.bytedance.sdk.openadsdk.YIK.sc.sc("replace_log_extra_key", false)) {
                pFF(jSONObject);
            }
            jSONObject.put("pangle_client_unique_id", "pangle-" + this.f27378sc + "-" + System.currentTimeMillis());
            return jSONObject;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("AdEvent", th2.getMessage() == null ? "error " : th2.getMessage());
            return jSONObject;
        }
    }

    private static void sc(JSONObject jSONObject, String str) {
        try {
            Set<String> set = WH;
            if (!set.contains(str) && !set.contains(jSONObject.get("label"))) {
                jSONObject.putOpt("is_ad_event", "1");
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("AdEvent", th2);
        }
    }

    private boolean sc(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0") || TextUtils.isEmpty(str3)) {
            return false;
        }
        str2.hashCode();
        switch (str2) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    public boolean ExN() {
        Set<String> setQl;
        if (this.pFF == null || (setQl = com.bytedance.sdk.openadsdk.core.Xc.We().Ql()) == null) {
            return false;
        }
        String strOptString = this.pFF.optString("label");
        if (!TextUtils.isEmpty(strOptString)) {
            return setQl.contains(strOptString);
        }
        if (TextUtils.isEmpty(this.BT)) {
            return false;
        }
        return setQl.contains(this.BT);
    }

    public String We() {
        return this.f27378sc;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc.pFF
    public long pFF() {
        return this.We;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc.pFF
    public long sc() {
        return this.ExN;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc.pFF
    public JSONObject sc(String str) {
        return zY();
    }

    public JSONObject sc(boolean z11) {
        JSONObject jSONObjectZY = zY();
        try {
            if (!z11) {
                JSONObject jSONObject = new JSONObject(jSONObjectZY.toString());
                jSONObject.remove("app_log_url");
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(jSONObjectZY.toString());
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.remove("app_log_url");
            }
            return jSONObject2;
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("AdEvent", e11.getMessage());
            return jSONObjectZY;
        }
    }

    public JSONObject zY() {
        if (this.Tf.get()) {
            return this.pFF;
        }
        try {
            qr();
            if (this.pFF.has("ad_extra_data")) {
                Object objOpt = this.pFF.opt("ad_extra_data");
                if (objOpt != null) {
                    try {
                        if (objOpt instanceof JSONObject) {
                            com.bytedance.sdk.component.utils.Tf.sc("AdEvent", "ad_extra_data is JSONObject");
                            this.pFF.put("ad_extra_data", sc((JSONObject) objOpt).toString());
                        } else if (objOpt instanceof String) {
                            this.pFF.put("ad_extra_data", sc(new JSONObject((String) objOpt)).toString());
                        }
                    } catch (JSONException e11) {
                        com.bytedance.sdk.component.utils.Tf.sc("AdEvent", "json error", e11.getMessage());
                    }
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("adiff", this.f27378sc);
                    if (this.zY) {
                        jSONObject.put("interaction_method", this.f27377qr);
                        jSONObject.put("real_interaction_method", this.Qj);
                        jSONObject.put("image_mode", this.Ol);
                    }
                    this.pFF.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException e12) {
                    com.bytedance.sdk.component.utils.Tf.sc("AdEvent", "json error", e12.getMessage());
                }
            }
            this.Tf.set(true);
        } catch (Throwable unused) {
        }
        return this.pFF;
    }
}
