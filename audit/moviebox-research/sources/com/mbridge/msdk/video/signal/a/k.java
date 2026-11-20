package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Activity f48095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f48096q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f48097r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CampaignEx f48098s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<CampaignEx> f48099t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f48100u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f48101v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f48102w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f48103x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f48104y = false;

    public k(Activity activity, CampaignEx campaignEx) {
        this.f48095p = activity;
        this.f48098s = campaignEx;
    }

    public k(Activity activity, CampaignEx campaignEx, List<CampaignEx> list) {
        this.f48095p = activity;
        this.f48098s = campaignEx;
        this.f48099t = list;
    }

    private CampaignEx a(String str, CampaignEx campaignEx) {
        String strValueOf;
        String strValueOf2;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                try {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        jSONObjectCampaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                } catch (Exception unused) {
                }
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectCampaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
                a(jSONObjectCampaignToJsonObject, campaignWithBackData);
                return campaignWithBackData;
            } catch (JSONException e11) {
                e11.printStackTrace();
                return campaignEx;
            }
        }
        try {
            JSONObject jSONObjectCampaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            CampaignEx campaignWithBackData2 = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject2);
            if (campaignWithBackData2 == null) {
                campaignWithBackData2 = campaignEx;
            }
            if (!TextUtils.isEmpty(str)) {
                a(jSONObjectCampaignToJsonObject2, campaignWithBackData2);
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.f44374j);
                if (jSONObjectOptJSONObject != null) {
                    strValueOf = String.valueOf(ai.a(this.f48095p, Integer.valueOf(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f44372h)).intValue()));
                    strValueOf2 = String.valueOf(ai.a(this.f48095p, Integer.valueOf(jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f44373i)).intValue()));
                } else {
                    strValueOf = "-999";
                    strValueOf2 = "-999";
                }
                campaignWithBackData2.setClickURL(com.mbridge.msdk.click.c.a(campaignWithBackData2.getClickURL(), strValueOf, strValueOf2));
                String noticeUrl = campaignWithBackData2.getNoticeUrl();
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    StringBuilder sb2 = new StringBuilder();
                    while (itKeys2.hasNext()) {
                        sb2.append("&");
                        String next2 = itKeys2.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next2);
                        if (com.mbridge.msdk.foundation.same.a.f44372h.equals(next2) || com.mbridge.msdk.foundation.same.a.f44373i.equals(next2)) {
                            strOptString = String.valueOf(ai.a(this.f48095p, Integer.valueOf(strOptString).intValue()));
                        }
                        sb2.append(next2);
                        sb2.append("=");
                        sb2.append(strOptString);
                    }
                    campaignWithBackData2.setNoticeUrl(noticeUrl + ((Object) sb2));
                }
            }
            return campaignWithBackData2;
        } catch (JSONException e12) {
            e12.printStackTrace();
            return campaignEx;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return campaignEx;
        }
    }

    private void a(JSONObject jSONObject, CampaignEx campaignEx) {
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            campaignEx.setCampaignUnitId(strOptString);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void b(JSONObject jSONObject) {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            String string = al.a(contextC, "MBridge_ConfirmTitle" + this.f48083j, "").toString();
            String string2 = al.a(contextC, "MBridge_ConfirmContent" + this.f48083j, "").toString();
            String string3 = al.a(contextC, "MBridge_CancelText" + this.f48083j, "").toString();
            String string4 = al.a(contextC, "MBridge_ConfirmText" + this.f48083j, "").toString();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("confirm_title", string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("confirm_description", string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                jSONObject.put("confirm_t", string3);
            }
            if (!TextUtils.isEmpty(string4)) {
                jSONObject.put("confirm_c_play", string4);
            }
            if (TextUtils.isEmpty(string4)) {
                return;
            }
            jSONObject.put("confirm_c_rv", string4);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private boolean b(CampaignEx campaignEx) {
        com.mbridge.msdk.c.g gVarB;
        try {
            String strK = com.mbridge.msdk.foundation.controller.c.m().k();
            long jAc = (TextUtils.isEmpty(strK) || (gVarB = com.mbridge.msdk.c.h.a().b(strK)) == null) ? 0L : gVarB.ac() * 1000;
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            if (campaignEx != null) {
                return campaignEx.isSpareOffer(jF, jAc);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private String p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f48083j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.f48101v);
            jSONObject2.put("rootViewInstanceId", this.f48102w);
            jSONObject2.put("isRootTemplateWebView", this.f48103x);
            jSONObject.put("sdk_info", "MAL_16.7.21,3.0.1");
            jSONObject2.put("playVideoMute", this.f48087n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<CampaignEx> list = this.f48099t;
            if (list == null || list.size() <= 0) {
                jSONArray.put(CampaignEx.campaignToJsonObject(this.f48098s));
            } else {
                for (CampaignEx campaignEx : this.f48099t) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(campaignEx, campaignEx.isReady(), b(campaignEx)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", x());
            String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                JSONObject jSONObject3 = new JSONObject(strG);
                b(jSONObject3);
                String strC = com.mbridge.msdk.c.h.a().c(this.f48083j);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject3.put("ivreward", new JSONObject(strC));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", y());
            if (!TextUtils.isEmpty(this.f48083j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f48083j);
            }
            jSONObject.put("rw_plus", this.f48104y ? "1" : "0");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject q() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f48087n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(CampaignEx.campaignToJsonObject(this.f48098s));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", x());
            String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                JSONObject jSONObject3 = new JSONObject(strG);
                b(jSONObject3);
                String strC = com.mbridge.msdk.c.h.a().c(this.f48083j);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject3.put("ivreward", strC);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", y());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_info", "MAL_16.7.21,3.0.1");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f48083j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f48083j);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("appSetting", new JSONObject(strG));
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.mbridge.msdk.videocommon.d.c cVar = this.f48084k;
            if (cVar != null) {
                jSONObject.put("unitSetting", cVar.E());
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f48087n);
            jSONObject2.put("instanceId", this.f48101v);
            jSONObject.put("sdkSetting", jSONObject2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.d.c cVar = this.f48084k;
        return cVar != null ? cVar.E() : jSONObject;
    }

    private JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
        return aVarB != null ? aVarB.k() : jSONObject;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void a(int i11, String str) {
        super.a(i11, str);
        if (i11 != 2) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT);
            final String strOptString2 = jSONObject.optString("template", "-1");
            final String strOptString3 = jSONObject.optString(TtmlNode.TAG_LAYOUT, "-1");
            final String strOptString4 = jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f48083j);
            final int iL = z.l(this.f48095p.getApplication());
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.signal.a.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.foundation.db.q.a(com.mbridge.msdk.foundation.db.h.a(k.this.f48095p.getApplication())).a(new com.mbridge.msdk.foundation.entity.n("2000039", strOptString, strOptString2, strOptString3, strOptString4, k.this.f48098s.getId(), iL, z.a(k.this.f48095p.getApplication(), iL)));
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
        } catch (Throwable th2) {
            ad.a("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void a(Activity activity) {
        this.f48095p = activity;
    }

    public final void a(CampaignEx campaignEx) {
        this.f48098s = campaignEx;
    }

    public final void a(List<CampaignEx> list) {
        this.f48099t = list;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f48097r = str;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final String c() {
        this.f48086m.a();
        this.f48074a = true;
        if (TextUtils.isEmpty(this.f48096q)) {
            this.f48096q = p();
        } else {
            this.f48096q = ai.b(this.f48096q, "tun", z.q() + "");
        }
        return this.f48096q;
    }

    public final void c(String str) {
        this.f48101v = str;
    }

    public final void c(boolean z11) {
        this.f48103x = z11;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.e
    public final void click(int i11, String str) {
        AppletsModel appletsModel;
        List<CampaignEx> list;
        int iP;
        List<CampaignEx> list2;
        super.click(i11, str);
        CampaignEx campaignEx = this.f48098s;
        if (campaignEx != null) {
            if (campaignEx.getDynamicTempCode() == 5 && this.f48098s != null && (list2 = this.f48099t) != null && list2.size() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("camp_position")) {
                        this.f48098s = this.f48099t.get(jSONObject.getInt("camp_position"));
                    }
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            CampaignEx campaignEx2 = this.f48098s;
            if (i11 == 3) {
                campaignEx2.setClickTempSource(2);
                if (campaignEx2.getTriggerClickSource() == 0) {
                    campaignEx2.setTriggerClickSource(2);
                }
            } else if (i11 == 1 && campaignEx2.getClickTempSource() != 2) {
                campaignEx2.setClickTempSource(1);
            }
        }
        try {
            if (i11 == 1) {
                if (this.f48098s == null && (list = this.f48099t) != null && list.size() > 0) {
                    this.f48098s = this.f48099t.get(0);
                }
                CampaignEx campaignEx3 = this.f48098s;
                if (campaignEx3 == null) {
                    return;
                }
                CampaignEx campaignExA = a(str, campaignEx3);
                if (campaignExA != null && (appletsModel = AppletModelManager.getInstance().get(campaignExA)) != null) {
                    appletsModel.setUserClick(true);
                    AppletModelManager.getInstance().replace(appletsModel, campaignExA);
                }
                a(campaignExA, this.f48095p);
                return;
            }
            if (i11 != 3) {
                if (i11 != 4) {
                    return;
                }
                this.f48086m.a(true);
                return;
            }
            CampaignEx campaignEx4 = this.f48098s;
            if (campaignEx4 == null || campaignEx4.getCbd() <= -2) {
                com.mbridge.msdk.videocommon.d.c cVar = this.f48084k;
                if (cVar != null) {
                    iP = cVar.p();
                }
                click(1, str);
            }
            iP = this.f48098s.getCbd();
            if (iP == -1) {
                a(new a.b(this, this.f48086m));
            }
            click(1, str);
        } catch (Throwable th2) {
            ad.a("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void d() {
        super.d();
        try {
            Activity activity = this.f48095p;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th2) {
            ad.a("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    public final void d(String str) {
        this.f48102w = str;
    }

    public final void d(boolean z11) {
        this.f48104y = z11;
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final void f() {
        super.f();
        com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48086m;
        if (interfaceC0530a != null) {
            interfaceC0530a.b();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final String g(int i11) {
        switch (i11) {
            case 1:
                return r().toString();
            case 2:
                return s().toString();
            case 3:
                return t().toString();
            case 4:
                return u().toString();
            case 5:
                return v().toString();
            case 6:
                return w().toString();
            default:
                return q().toString();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.e
    public final void handlerH5Exception(int i11, String str) {
        super.handlerH5Exception(i11, str);
        try {
            this.f48086m.a(i11, str);
        } catch (Throwable th2) {
            ad.a("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.a, com.mbridge.msdk.video.signal.a
    public final String i() {
        ad.a("DefaultJSCommon", "getNotchArea");
        return this.f48097r;
    }

    public final void i(int i11) {
        this.f48100u = i11;
    }

    public final void n() {
        this.f48096q = "";
    }

    public final int o() {
        return this.f48100u;
    }
}
