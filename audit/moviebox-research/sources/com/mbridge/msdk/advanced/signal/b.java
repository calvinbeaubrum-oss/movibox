package com.mbridge.msdk.advanced.signal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.base.d;
import com.mbridge.msdk.mbsignalcommon.communication.c;
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
/* JADX INFO: loaded from: classes6.dex */
public final class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f42850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<CampaignEx> f42851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f42852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f42853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f42855h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.advanced.b.a f42857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private NativeAdvancedExpandDialog f42858k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f42849b = "NativeAdvancedJSBridgeImpl";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f42856i = 5;

    public b(Context context, String str, String str2) {
        this.f42853f = str;
        this.f42852e = str2;
        this.f42850c = new WeakReference<>(context);
    }

    public final List<CampaignEx> a() {
        return this.f42851d;
    }

    public final void a(int i11) {
        this.f42855h = i11;
    }

    public final void a(com.mbridge.msdk.advanced.b.a aVar) {
        if (aVar != null) {
            this.f42857j = aVar;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.advanced.common.b bVar = new com.mbridge.msdk.advanced.common.b(com.mbridge.msdk.foundation.controller.c.m().c());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f42854g);
            jSONObject2.put("customURLScheme", 1);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f42851d));
            k kVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k(), this.f42852e);
            if (kVarB == null) {
                kVarB = k.f(this.f42852e);
            }
            if (!TextUtils.isEmpty(this.f42853f)) {
                kVarB.a(this.f42853f);
            }
            kVarB.b(this.f42852e);
            kVarB.g(this.f42856i);
            kVarB.b(this.f42855h);
            jSONObject.put("unitSetting", kVarB.x());
            String strG = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("appSetting", new JSONObject(strG));
            }
            jSONObject.put("sdk_info", d.f45662a);
            ad.b(this.f42849b, "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th2) {
            ad.a(this.f42849b, "init", th2);
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f42851d = list;
    }

    public final void b(int i11) {
        this.f42856i = i11;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void b(Object obj, String str) {
        try {
            List<CampaignEx> list = this.f42851d;
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.f42851d.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectCampaignToJsonObject = campaignEx != null ? CampaignEx.campaignToJsonObject(campaignEx) : new JSONObject();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
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
                ad.b(this.f42849b, e11.getMessage());
            }
            com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, "click", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void c(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            if (!(obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) || (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) == null) {
                return;
            }
            try {
                windVaneWebView.getWebViewListener().a(windVaneWebView, new JSONObject(str).getInt("isReady"));
            } catch (Exception unused) {
                windVaneWebView.getWebViewListener().a(windVaneWebView, 2);
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void close() {
        ad.b(this.f42849b, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        try {
            com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, CampaignEx.JSON_NATIVE_VIDEO_CLOSE, th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void d(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
            if (aVar != null) {
                aVar.a(iOptInt);
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, "toggleCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void e(Object obj, String str) {
        if (this.f42857j != null) {
            a.a(obj);
            this.f42857j.a(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void expand(String str, boolean z11) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z11);
            WeakReference<Context> weakReference = this.f42850c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            NativeAdvancedExpandDialog nativeAdvancedExpandDialog = this.f42858k;
            if (nativeAdvancedExpandDialog == null || !nativeAdvancedExpandDialog.isShowing()) {
                NativeAdvancedExpandDialog nativeAdvancedExpandDialog2 = new NativeAdvancedExpandDialog(this.f42850c.get(), bundle, this.f42857j);
                this.f42858k = nativeAdvancedExpandDialog2;
                nativeAdvancedExpandDialog2.setCampaignList(this.f42852e, this.f42851d);
                this.f42858k.show();
                com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.advanced.c.a.a(this.f42852e, getMraidCampaign(), str);
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, "expand", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void f(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b);
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, "onSignalCommunicationConnect", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void g(Object obj, String str) {
        ad.b(this.f42849b, "install");
        try {
            List<CampaignEx> list = this.f42851d;
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.f42851d.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectCampaignToJsonObject = campaignEx != null ? CampaignEx.campaignToJsonObject(campaignEx) : new JSONObject();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
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
            com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, "install", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f42851d;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f42851d.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void h(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i11 = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
            if (aVar != null) {
                aVar.b(i11);
            }
        } catch (JSONException e11) {
            ad.a(this.f42849b, "resetCountdown", e11);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void i(Object obj, String str) {
        ad.a(this.f42849b, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string = jSONArray.getString(i11);
                for (CampaignEx campaignEx : this.f42851d) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.a.d.a(this.f42852e, campaignEx, "h5_native");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.advanced.signal.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.k kVarA = com.mbridge.msdk.foundation.db.k.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            kVarA.a((String) it.next());
                        }
                    } catch (Exception unused) {
                        ad.b(b.this.f42849b, "campain can't insert db");
                    }
                }
            }).start();
        } catch (Throwable th2) {
            ad.a(this.f42849b, "sendImpressions", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void j(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is empty");
            return;
        }
        try {
            a.a(obj, new JSONObject(str));
        } catch (Throwable th2) {
            ad.a(this.f42849b, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void k(Object obj, String str) {
        ad.a(this.f42849b, "reportUrls:" + str);
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
                    List<CampaignEx> list = this.f42851d;
                    com.mbridge.msdk.click.a.a(contextC, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list2 = this.f42851d;
                    com.mbridge.msdk.click.a.a(contextC2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, com.mbridge.msdk.mbsignalcommon.communication.d.a(0));
        } catch (Throwable th2) {
            ad.a(this.f42849b, "reportUrls", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void open(String str) {
        com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void useCustomClose(boolean z11) {
        try {
            if (this.f42855h == -1) {
                int i11 = z11 ? 2 : 1;
                com.mbridge.msdk.advanced.b.a aVar = this.f42857j;
                if (aVar != null) {
                    aVar.a(i11);
                }
            }
        } catch (Throwable th2) {
            ad.a(this.f42849b, "useCustomClose", th2);
        }
    }
}
