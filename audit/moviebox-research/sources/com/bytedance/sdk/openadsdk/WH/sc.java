package com.bytedance.sdk.openadsdk.WH;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI;
import com.bytedance.sdk.openadsdk.wjp.sc.sc.qr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements zY {
    private final pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Sfl f27302sc;
    private final Map<String, TRI> zY = new HashMap();

    private sc(pFF pff, Sfl sfl) {
        this.pFF = pff;
        this.f27302sc = sfl;
    }

    public static sc sc(pFF pff, Sfl sfl) {
        return new sc(pff, sfl);
    }

    private Sfl sc(JSONObject jSONObject, String str) {
        String strSc;
        if (jSONObject == null) {
            return null;
        }
        Sfl sflZY = Sfl.zY();
        sflZY.We(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            sflZY.YIK(str);
        }
        if (this.f27302sc == null) {
            return sflZY;
        }
        String strSc2 = sflZY.NP() != null ? sflZY.NP().sc() : null;
        if (TextUtils.isEmpty(strSc2)) {
            return this.f27302sc;
        }
        com.bytedance.sdk.openadsdk.core.model.zY zYVarNP = this.f27302sc.NP();
        if (zYVarNP != null && strSc2.equals(zYVarNP.sc())) {
            return this.f27302sc;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (zYVarNP != null) {
            try {
                strSc = zYVarNP.sc();
            } catch (JSONException unused) {
            }
        } else {
            strSc = "null";
        }
        jSONObject2.put("lu", strSc);
        jSONObject2.put("ju", strSc2);
        Sfl sfl = this.f27302sc;
        com.bytedance.sdk.openadsdk.core.We.sc(sfl, cJ.sc(sfl), -5, jSONObject2);
        if (zYVarNP != null && strSc2.contains("play.google.com/store") && !strSc2.contains("referrer")) {
            sflZY.NP().sc(zYVarNP.sc());
        }
        return sflZY;
    }

    private TRI sc(@NonNull Context context, @NonNull Sfl sfl, @NonNull JSONObject jSONObject, @NonNull String str, boolean z11) {
        TRI triSc = qr.sc(context, sfl, str);
        triSc.sc(true);
        return triSc;
    }

    private void sc(Context context, Sfl sfl, JSONObject jSONObject, int i11, boolean z11) {
        if (context == null || sfl == null || sfl.NP() == null || jSONObject == null || this.pFF == null || this.zY.get(sfl.NP().sc()) != null) {
            return;
        }
        String strPFF = cJ.pFF(i11);
        if (TextUtils.isEmpty(strPFF)) {
            return;
        }
        this.zY.put(sfl.NP().sc(), sc(context, sfl, jSONObject, strPFF, z11));
    }

    private void sc(Sfl sfl, JSONObject jSONObject) {
        if (this.pFF == null || sfl == null || sfl.NP() == null) {
            return;
        }
        String strSc = sfl.NP().sc();
        if (this.zY.containsKey(strSc)) {
            this.zY.remove(strSc);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.pFF.sc("app_ad_event", jSONObject2);
            } catch (JSONException e11) {
                Tf.sc("JsAppAdDownloadManager", e11.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.WH.zY
    public void sc() {
        this.zY.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.WH.zY
    public void sc(Context context, JSONObject jSONObject, String str) {
        Sfl sfl;
        if (context == null || (sfl = this.f27302sc) == null) {
            return;
        }
        qr.sc(context, sfl, str).We();
    }

    @Override // com.bytedance.sdk.openadsdk.WH.zY
    public void sc(Context context, JSONObject jSONObject, String str, int i11, boolean z11) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        sc(context, sc(jSONObjectOptJSONObject, str), jSONObjectOptJSONObject, i11, z11);
    }

    @Override // com.bytedance.sdk.openadsdk.WH.zY
    public void sc(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        sc(sc(jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }
}
