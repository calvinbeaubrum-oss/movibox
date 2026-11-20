package com.bytedance.sdk.openadsdk.core.UFX.zY;

import android.R;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.core.Ql;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.sdk.openadsdk.We.zY;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.cD;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.wjp.sc.sc.We;
import com.bytedance.sdk.openadsdk.wjp.sc.sc.qr;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements Ql, sc.InterfaceC0298sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected static int f28310sc = 8;
    private float BT;
    private final com.bytedance.sdk.openadsdk.core.UFX.TRI.sc ExN;
    private JSONObject Ol;
    private String Qj;
    private View Ql;
    private float SR;
    private long Sfl;
    private String TRI;
    private String Tf;
    private com.bytedance.sdk.openadsdk.core.UFX.ExN.sc UFX;
    private final com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF WH;
    private final Sfl We;
    private float Xc;
    private boolean YIK = true;
    private float dE;
    private sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f28311qr;
    private long wjp;
    private final Activity zY;

    public pFF(Activity activity, Sfl sfl, com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVar, String str, com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF pff) {
        this.zY = activity;
        this.Tf = str;
        this.We = sfl;
        this.WH = pff;
        this.ExN = scVar;
    }

    private void pFF() {
        int iQLv = this.We.QLv();
        if (iQLv != 2 && iQLv != 3) {
            if (iQLv == 4) {
                qr.sc(this.zY, this.We, this.Tf).We();
                return;
            } else {
                if (iQLv != 5) {
                    return;
                }
                cJ.zY(this.zY, this.We.ZM());
                return;
            }
        }
        if (iQLv == 3) {
            String strKo = this.We.ko();
            if (!TextUtils.isEmpty(strKo) && strKo.contains("play.google.com/store")) {
                if (We.sc(this.zY, strKo, strKo.substring(strKo.indexOf("?id=") + 4), this.Tf, this.We)) {
                    return;
                }
            }
        }
        Activity activity = this.zY;
        Sfl sfl = this.We;
        int iSc = cJ.sc(this.Tf);
        String str = this.Tf;
        cD.sc((Context) activity, sfl, iSc, (PAGNativeAd) null, (PangleAd) null, str, qr.sc(this.zY, this.We, str), true, 0);
    }

    private void sc(WH wh2, Sfl sfl) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_x", this.SR);
            jSONObject.put("down_y", this.BT);
            jSONObject.put("down_time", this.wjp);
            jSONObject.put("up_x", this.dE);
            jSONObject.put("up_y", this.Xc);
            jSONObject.put("up_time", this.Sfl);
            View viewOl = wh2.sc().Ol();
            int i11 = 1;
            if (viewOl != null) {
                JSONObject jSONObject2 = new JSONObject();
                int[] iArr = new int[2];
                float width = viewOl.getWidth();
                float height = viewOl.getHeight();
                viewOl.getLocationOnScreen(iArr);
                float f11 = iArr[0];
                float f12 = iArr[1];
                jSONObject2.put("width", width);
                jSONObject2.put("height", height);
                jSONObject2.put(TtmlNode.LEFT, f11);
                jSONObject2.put("top", f12);
                jSONObject.put("rectInfo", jSONObject2);
            }
            View view = this.Ql;
            if (view != null) {
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                jSONObject.put("button_x", iArr2[0]);
                jSONObject.put("button_y", iArr2[1]);
                jSONObject.put("button_width", this.Ql.getWidth());
                jSONObject.put("button_height", this.Ql.getHeight());
            }
            View viewFindViewById = this.zY.findViewById(R.id.content);
            if (viewFindViewById != null) {
                int[] iArr3 = new int[2];
                viewFindViewById.getLocationOnScreen(iArr3);
                jSONObject.put("ad_x", iArr3[0]);
                jSONObject.put("ad_y", iArr3[1]);
                jSONObject.put("width", viewFindViewById.getWidth());
                jSONObject.put("height", viewFindViewById.getHeight());
            }
            jSONObject.put("click_area_type", wh2.sc().cD());
            jSONObject.put("brick_id", wh2.sc().Gb());
            jSONObject.put("endcard_id", this.TRI);
            jSONObject.put("click_scence", 2);
            if (!this.YIK) {
                i11 = 2;
            }
            jSONObject.put("user_behavior_type", i11);
            com.bytedance.sdk.openadsdk.core.UFX.ExN.sc scVar = this.UFX;
            if (scVar != null) {
                jSONObject.put("endcard_type", scVar.sc());
            }
            zY.sc(sfl, this.Tf, "click", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(JSONObject jSONObject, JSONObject jSONObject2) {
        this.pFF.sc((sc.InterfaceC0298sc) this);
        this.pFF.sc((Ql) this);
        this.WH.sc();
        this.pFF.sc(jSONObject, jSONObject2, new com.bytedance.sdk.openadsdk.core.UFX.ExN.We() { // from class: com.bytedance.sdk.openadsdk.core.UFX.zY.pFF.2
            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.We
            public void sc(int i11, String str) {
                if (pFF.this.WH != null) {
                    pFF.this.WH.sc(i11, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.We
            public void sc(com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar) {
                if (pFF.this.WH != null) {
                    pFF.this.WH.sc(zYVar);
                }
            }
        });
    }

    public void sc() {
        if (this.We == null) {
            this.WH.sc(1, "material is null", "net");
            return;
        }
        if (this.ExN == null) {
            this.WH.sc(1, "material ugen template is null", "net");
            return;
        }
        this.pFF = new sc(this.zY);
        this.Qj = this.ExN.zY();
        this.TRI = this.ExN.sc();
        this.f28311qr = this.ExN.pFF();
        this.Ol = this.We.JP();
        this.WH.sc(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
        com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, this.Qj, this.TRI, this.f28311qr, "", new com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.core.UFX.zY.pFF.1
            @Override // com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc
            public void sc(int i11, String str, String str2) {
                pFF.this.WH.sc(i11, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc
            public void sc(JSONObject jSONObject, String str) {
                pFF pff = pFF.this;
                pff.sc(jSONObject, pff.Ol);
                pFF.this.WH.pFF(str);
            }
        });
    }

    public void sc(View view) {
        this.Ql = view;
    }

    @Override // com.bytedance.sdk.openadsdk.core.UFX.zY.sc.InterfaceC0298sc
    public void sc(WH wh2) {
        String strOptString = wh2.zY().optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "privacy":
                if (this.zY != null && !TextUtils.isEmpty(Xc.We().cJ())) {
                    TTWebsiteActivity.sc(this.zY, this.We, this.Tf);
                    break;
                }
                break;
            case "close":
                com.bytedance.sdk.openadsdk.core.UFX.ExN.sc scVar = this.UFX;
                if (scVar != null) {
                    scVar.pFF();
                    break;
                }
                break;
            case "creative":
                if (this.zY != null && this.We != null) {
                    pFF();
                    ComponentCallbacks2 componentCallbacks2 = this.zY;
                    if (componentCallbacks2 instanceof com.bytedance.sdk.openadsdk.core.Ql.We.pFF) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.We.pFF) componentCallbacks2).We();
                    }
                    sc(wh2, this.We);
                    break;
                }
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.Ql
    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.wjp = System.currentTimeMillis();
            this.SR = motionEvent.getRawX();
            this.BT = motionEvent.getRawY();
            this.YIK = true;
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            if (Math.abs(motionEvent.getRawX() - this.SR) >= f28310sc || Math.abs(motionEvent.getRawY() - this.BT) >= f28310sc) {
                this.YIK = false;
                return;
            }
            return;
        }
        this.dE = motionEvent.getRawX();
        this.Xc = motionEvent.getRawY();
        if (Math.abs(this.dE - this.SR) >= f28310sc || Math.abs(this.Xc - this.BT) >= f28310sc) {
            this.YIK = false;
        }
        this.Sfl = System.currentTimeMillis();
    }

    public void sc(com.bytedance.sdk.openadsdk.core.UFX.ExN.sc scVar) {
        this.UFX = scVar;
    }
}
