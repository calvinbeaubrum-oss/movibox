package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f47188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f47189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f47190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f47191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f47193g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.splash.d.a f47196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SplashExpandDialog f47197k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f47187a = "SplashSignalCommunicationImpl";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47194h = 5;

    public a(Context context, String str, String str2) {
        this.f47191e = str;
        this.f47190d = str2;
        this.f47188b = new WeakReference<>(context);
    }

    public final com.mbridge.msdk.splash.d.a a() {
        return this.f47196j;
    }

    public final void a(int i11) {
        this.f47193g = i11;
    }

    public final void a(Context context) {
        this.f47188b = new WeakReference<>(context);
    }

    public final void a(com.mbridge.msdk.splash.d.a aVar) {
        if (aVar != null) {
            this.f47196j = aVar;
        }
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.splash.a.b bVar = new com.mbridge.msdk.splash.a.b(com.mbridge.msdk.foundation.controller.c.m().c());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f47192f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f47189c));
            k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47190d);
            if (kVarD == null) {
                kVarD = k.d(this.f47190d);
            }
            if (!TextUtils.isEmpty(this.f47191e)) {
                kVarD.a(this.f47191e);
            }
            kVarD.b(this.f47190d);
            kVarD.g(this.f47194h);
            kVarD.b(this.f47193g);
            jSONObject.put("unitSetting", kVarD.x());
            String strG = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("appSetting", new JSONObject(strG));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.f45662a);
            ad.b(this.f47187a, "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th2) {
            ad.a(this.f47187a, "init", th2);
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f47189c = list;
    }

    public final List<CampaignEx> b() {
        return this.f47189c;
    }

    public final void b(int i11) {
        this.f47194h = i11;
    }

    public final void b(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.splash.d.a aVar = this.f47196j;
            if (aVar != null) {
                aVar.a(iOptInt);
            }
        } catch (Throwable th2) {
            ad.a(this.f47187a, "toggleCloseBtn", th2);
        }
    }

    public final void c(int i11) {
        this.f47195i = i11;
    }

    public final void c(Object obj, String str) {
        com.mbridge.msdk.splash.d.a aVar = this.f47196j;
        if (aVar != null) {
            aVar.a(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        ad.b(this.f47187a, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        try {
            com.mbridge.msdk.splash.d.a aVar = this.f47196j;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th2) {
            ad.a(this.f47187a, CampaignEx.JSON_NATIVE_VIDEO_CLOSE, th2);
        }
    }

    public final void d(Object obj, String str) {
        ad.b(this.f47187a, "install");
        try {
            List<CampaignEx> list = this.f47189c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.f47189c.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectCampaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
                String strOptString = jSONObjectCampaignToJsonObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (!TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                }
                campaignEx = campaignWithBackData;
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            com.mbridge.msdk.splash.d.a aVar = this.f47196j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            ad.a(this.f47187a, "click", th2);
        }
    }

    public final void e(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        ad.b(this.f47187a, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextC == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                    contextC = windVaneWebView.getContext();
                }
            } catch (Exception e11) {
                ad.b(this.f47187a, e11.getMessage());
            }
        }
        if (contextC == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.c(contextC, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.e(contextC, strOptString);
            }
        } catch (JSONException e12) {
            ad.b(this.f47187a, e12.getMessage());
        } catch (Throwable th2) {
            ad.b(this.f47187a, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z11) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z11);
            WeakReference<Context> weakReference = this.f47188b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            SplashExpandDialog splashExpandDialog = this.f47197k;
            if (splashExpandDialog == null || !splashExpandDialog.isShowing()) {
                SplashExpandDialog splashExpandDialog2 = new SplashExpandDialog(this.f47188b.get(), bundle, this.f47196j);
                this.f47197k = splashExpandDialog2;
                splashExpandDialog2.setCampaignList(this.f47190d, this.f47189c);
                this.f47197k.show();
                com.mbridge.msdk.splash.d.a aVar = this.f47196j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.splash.e.a.a(this.f47190d, getMraidCampaign(), str);
            }
        } catch (Throwable th2) {
            ad.a(this.f47187a, "expand", th2);
        }
    }

    public final void f(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i11 = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.splash.d.a aVar = this.f47196j;
            if (aVar != null) {
                aVar.b(i11);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public final void g(Object obj, String str) {
        ad.a(this.f47187a, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string = jSONArray.getString(i11);
                for (CampaignEx campaignEx : this.f47189c) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.a.d.a(this.f47190d, campaignEx, "splash");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.signal.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.k kVarA = com.mbridge.msdk.foundation.db.k.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            kVarA.a((String) it.next());
                        }
                    } catch (Exception unused) {
                        ad.b(a.this.f47187a, "campain can't insert db");
                    }
                }
            }).start();
        } catch (Throwable th2) {
            ad.a(this.f47187a, "sendImpressions", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f47189c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f47189c.get(0);
    }

    public final void h(Object obj, String str) {
        ad.a(this.f47187a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                int iOptInt = jSONObject.optInt("type");
                String strA = ai.a(jSONObject.optString("url"), "&tun=", z.q() + "");
                int iOptInt2 = jSONObject.optInt("report");
                if (iOptInt2 == 0) {
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list = this.f47189c;
                    com.mbridge.msdk.click.a.a(contextC, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list2 = this.f47189c;
                    com.mbridge.msdk.click.a.a(contextC2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, d.a(0));
        } catch (Throwable th2) {
            ad.a(this.f47187a, "reportUrls", th2);
        }
    }

    public final void i(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b);
            }
        } catch (Throwable th2) {
            ad.a(this.f47187a, "onJSBridgeConnect", th2);
        }
    }

    public final void j(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackingKey.CODE, 0);
            jSONObject.put("message", "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("countdown", this.f47195i);
            jSONObject.put("data", jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            ad.b(this.f47187a, e11.getMessage());
        }
        com.mbridge.msdk.splash.d.a aVar = this.f47196j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    public final void k(Object obj, String str) {
        int i11 = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                int iOptInt = new JSONObject(str).optInt("countdown");
                try {
                    g.a().a(obj, d.a(0));
                    i11 = iOptInt;
                } catch (Exception e11) {
                    e = e11;
                    i11 = iOptInt;
                    ad.b(this.f47187a, e.getMessage());
                }
            } catch (Exception e12) {
                e = e12;
            }
        }
        com.mbridge.msdk.splash.d.a aVar = this.f47196j;
        if (aVar != null) {
            aVar.a(2, i11);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        com.mbridge.msdk.splash.d.a aVar = this.f47196j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z11) {
        int i11 = z11 ? 2 : 1;
        try {
            com.mbridge.msdk.splash.d.a aVar = this.f47196j;
            if (aVar != null) {
                aVar.a(i11);
            }
        } catch (Throwable th2) {
            ad.a(this.f47187a, "useCustomClose", th2);
        }
    }
}
