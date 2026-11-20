package com.bytedance.sdk.component.sc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc {
    protected String ExN;
    protected Ql pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    qr f27016qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected Context f27017sc;
    protected Qj zY;
    protected Handler We = new Handler(Looper.getMainLooper());
    protected volatile boolean TRI = false;
    private final Map<String, qr> Qj = new HashMap();

    private qr pFF(String str) {
        return (TextUtils.equals(str, this.ExN) || TextUtils.isEmpty(str)) ? this.f27016qr : this.Qj.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dE sc(JSONObject jSONObject) {
        String strOptString;
        if (this.TRI) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        if (sc() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    strValueOf = objOpt instanceof String ? (String) objOpt : String.valueOf(objOpt);
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            return dE.sc().sc(string2).pFF(string).zY(strOptString3).We(strOptString).ExN(strOptString2).TRI(jSONObject.optString("namespace")).qr(jSONObject.optString("__iframe_url")).sc();
        } catch (JSONException unused2) {
            return dE.sc(strOptString2, -1);
        }
    }

    public void invokeMethod(final String str) {
        if (this.TRI) {
            return;
        }
        this.We.post(new Runnable() { // from class: com.bytedance.sdk.component.sc.sc.1
            @Override // java.lang.Runnable
            public void run() {
                dE dEVarSc;
                if (sc.this.TRI) {
                    return;
                }
                try {
                    dEVarSc = sc.this.sc(new JSONObject(str));
                } catch (Exception unused) {
                    dEVarSc = null;
                }
                if (!dE.sc(dEVarSc)) {
                    sc.this.sc(dEVarSc);
                    return;
                }
                Objects.toString(dEVarSc);
                if (dEVarSc != null) {
                    sc.this.pFF(FI.sc(new wjp(dEVarSc.f27007sc, "Failed to parse invocation.")), dEVarSc);
                }
            }
        });
    }

    public void pFF() {
        this.f27016qr.sc();
        Iterator<qr> it = this.Qj.values().iterator();
        while (it.hasNext()) {
            it.next().sc();
        }
        this.We.removeCallbacksAndMessages(null);
        this.TRI = true;
    }

    public abstract void pFF(WH wh2);

    public final void pFF(String str, dE dEVar) {
        JSONObject jSONObject;
        if (this.TRI || TextUtils.isEmpty(dEVar.TRI)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            Ol.sc(new IllegalArgumentException("Illegal callback data: ".concat(str)));
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        sc(BT.sc().sc("__msg_type", "callback").sc("__callback_id", dEVar.TRI).sc("__params", jSONObject).pFF(), dEVar);
    }

    public abstract Context sc(WH wh2);

    public abstract String sc();

    public final void sc(WH wh2, Dl dl2) {
        this.f27017sc = sc(wh2);
        this.zY = wh2.We;
        this.pFF = wh2.Ol;
        this.f27016qr = new qr(wh2, this, dl2);
        this.ExN = wh2.UFX;
        pFF(wh2);
    }

    public final void sc(dE dEVar) {
        String strSc;
        if (this.TRI || (strSc = sc()) == null) {
            return;
        }
        qr qrVarPFF = pFF(dEVar.f27006qr);
        if (qrVarPFF == null) {
            dEVar.toString();
            if (this.pFF != null) {
                sc();
            }
            pFF(FI.sc(new wjp(-4, "Namespace " + dEVar.f27006qr + " unknown.")), dEVar);
            return;
        }
        TRI tri = new TRI();
        tri.pFF = strSc;
        tri.f26999sc = this.f27017sc;
        tri.zY = qrVarPFF;
        try {
            qr.sc scVarSc = qrVarPFF.sc(dEVar, tri);
            if (scVarSc != null) {
                if (scVarSc.f27015sc) {
                    pFF(scVarSc.pFF, dEVar);
                }
                if (this.pFF != null) {
                    sc();
                    return;
                }
                return;
            }
            dEVar.toString();
            if (this.pFF != null) {
                sc();
            }
            pFF(FI.sc(new wjp(-2, "Function " + dEVar.We + " is not registered.")), dEVar);
        } catch (Exception e11) {
            dEVar.toString();
            pFF(FI.sc(e11), dEVar);
        }
    }

    public abstract void sc(String str);

    public void sc(String str, dE dEVar) {
        sc(str);
    }
}
