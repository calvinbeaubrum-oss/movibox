package com.bytedance.sdk.openadsdk.core.UFX.We;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.TRI;
import com.bytedance.sdk.openadsdk.core.wjp;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    private boolean BT;
    private com.bytedance.adsdk.ugeno.pFF.zY ExN;
    private final String Ol;
    private final Sfl Qj;
    private boolean Ql;
    private boolean SR;
    private final JSONObject Tf;
    private JSONObject UFX;
    private TRI WH;
    private com.bytedance.adsdk.ugeno.pFF.zY We;
    private JSONArray dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Context f28254qr;
    private com.bytedance.adsdk.ugeno.pFF.zY zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f28255sc = -1;
    private int pFF = -1;
    private final String TRI = "UGenSwiperEvent";

    public We(Context context, Sfl sfl, String str, JSONObject jSONObject) {
        this.f28254qr = context;
        this.Qj = sfl;
        this.Ol = str;
        this.Tf = jSONObject;
    }

    private Context sc(View view) {
        Activity activitySc = view != null ? com.bytedance.sdk.component.utils.pFF.sc(view) : null;
        return activitySc == null ? this.f28254qr : activitySc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("index", i11);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.Qj, this.Ol, "carousel_show", jSONObject);
    }

    private void sc(TextView textView, int i11) {
        int currentTextColor = textView.getCurrentTextColor();
        textView.setTextColor(Color.argb(i11, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
    }

    private void sc(JSONObject jSONObject, View view) {
        if (sc(jSONObject.optInt("landingStyle"), jSONObject.optString("url"), jSONObject.optString("fallback_url"))) {
            wjp.sc(sc(view), this.f28254qr instanceof Activity, jSONObject, this.Qj, this.Ol, cJ.sc(this.Ol), null, this.WH);
        }
    }

    private void sc(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
        this.UFX = jSONObjectOptJSONObject;
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    this.UFX.putOpt(next, com.bytedance.adsdk.ugeno.zY.pFF.sc((String) this.UFX.opt(next), jSONObject2));
                } catch (Throwable unused) {
                }
            }
            try {
                jSONObject.putOpt("clickInfo", this.UFX);
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z11, boolean z12, boolean z13) {
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.zY;
        if (zYVar == null || this.We == null) {
            return;
        }
        View viewOl = zYVar.Ol();
        View viewOl2 = this.We.Ol();
        JSONArray jSONArray = this.dE;
        if (jSONArray != null && jSONArray.length() == 1) {
            viewOl.setVisibility(8);
            viewOl2.setVisibility(8);
            return;
        }
        if (z11) {
            return;
        }
        if (z12) {
            if (viewOl instanceof TextView) {
                sc((TextView) viewOl, 90);
            }
            if (viewOl2 instanceof TextView) {
                sc((TextView) viewOl2, 255);
                return;
            }
            return;
        }
        if (z13) {
            if (viewOl instanceof TextView) {
                sc((TextView) viewOl, 255);
            }
            if (viewOl2 instanceof TextView) {
                sc((TextView) viewOl2, 90);
                return;
            }
            return;
        }
        if (viewOl instanceof TextView) {
            sc((TextView) viewOl, 255);
        }
        if (viewOl2 instanceof TextView) {
            sc((TextView) viewOl2, 255);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001f  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    private boolean sc(int i11, String str, String str2) {
        if (i11 == 1) {
            if (!BT.sc(str)) {
                return false;
            }
        } else if (i11 != 2) {
            if (i11 == 3) {
                if (!BT.sc(str)) {
                    return false;
                }
            }
        } else if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || !BT.sc(str2)) {
            return false;
        }
        return true;
    }

    public JSONObject We() {
        return this.UFX;
    }

    public void pFF() {
        int i11;
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.ExN;
        if (!(zYVar instanceof com.bytedance.adsdk.ugeno.pFF) || (i11 = this.f28255sc) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.pFF) zYVar).sc(i11 - 1);
    }

    public void sc() {
        sc(this.Ql, this.SR, this.BT);
    }

    public void sc(com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar) {
        com.bytedance.adsdk.ugeno.pFF.zY<T> zYVarZY = zYVar.zY("swiperLayout");
        this.ExN = zYVarZY;
        if (zYVarZY instanceof com.bytedance.adsdk.ugeno.pFF) {
            this.dE = this.Tf.optJSONArray("dpa_data");
            this.zY = zYVar.zY("swiperLeftArrow");
            this.We = zYVar.zY("swiperRightArrow");
            ((com.bytedance.adsdk.ugeno.pFF) this.ExN).sc(new com.bytedance.adsdk.ugeno.TRI.zY() { // from class: com.bytedance.sdk.openadsdk.core.UFX.We.We.1
                @Override // com.bytedance.adsdk.ugeno.TRI.zY
                public void sc(boolean z11, int i11, int i12, boolean z12, boolean z13) {
                    We.this.pFF = i11;
                    We.this.f28255sc = i12;
                    We.this.Ql = z11;
                    We.this.SR = z12;
                    We.this.BT = z13;
                    We.this.sc(z11, z12, z13);
                    We.this.sc(i11);
                }
            });
        }
    }

    public void sc(TRI tri) {
        this.WH = tri;
    }

    public boolean sc(WH wh2) {
        JSONObject jSONObjectOptJSONObject;
        this.UFX = null;
        int i11 = this.pFF;
        if (i11 != -1 && i11 != 0) {
            try {
                JSONObject jSONObjectZY = wh2.zY();
                if (jSONObjectZY != null && (jSONObjectOptJSONObject = jSONObjectZY.optJSONObject("related_dpa_click")) != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enableOpenExternalUrl");
                    int iOptInt = jSONObjectOptJSONObject.optInt("landingStyle");
                    if (zOptBoolean && iOptInt != -1) {
                        if (this.dE != null) {
                            String strSc = com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObjectOptJSONObject.optString("url"), this.dE.optJSONObject(this.pFF));
                            String strSc2 = com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObjectOptJSONObject.optString("fallback_url"), this.dE.optJSONObject(this.pFF));
                            jSONObjectOptJSONObject.put("url", strSc);
                            jSONObjectOptJSONObject.put("fallback_url", strSc2);
                            sc(jSONObjectOptJSONObject, this.dE.optJSONObject(this.pFF));
                        }
                        sc(jSONObjectOptJSONObject, wh2.sc().Ol());
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th2) {
                Tf.sc("UGenSwiperEvent", th2.getMessage());
            }
        }
        return false;
    }

    public void zY() {
        int i11;
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.ExN;
        if (!(zYVar instanceof com.bytedance.adsdk.ugeno.pFF) || (i11 = this.f28255sc) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.pFF) zYVar).sc(i11 + 1);
    }
}
