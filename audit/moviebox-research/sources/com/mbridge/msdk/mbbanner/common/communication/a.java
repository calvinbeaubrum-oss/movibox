package com.mbridge.msdk.mbbanner.common.communication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.f.b;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.i;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.base.d;
import com.mbridge.msdk.mbsignalcommon.communication.c;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f45379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f45380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f45381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f45382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.a f45384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BannerExpandDialog f45385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f45386i = false;

    public a(Context context, String str, String str2) {
        this.f45381d = str;
        this.f45382e = str2;
        this.f45379b = new WeakReference<>(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    private static void a(Object obj, JSONObject jSONObject) {
        ?? r11;
        String str;
        String str2;
        String str3;
        int i11;
        String str4;
        String str5;
        ?? jSONObject2 = new JSONObject();
        String str6 = "message";
        String str7 = TrackingKey.CODE;
        int i12 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put(TrackingKey.CODE, 1);
                jSONObject2.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e11) {
                ad.a("BannerSignalCommunicationImpl", e11.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put(TrackingKey.CODE, 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray == null) {
                str = TrackingKey.CODE;
                r11 = 1;
                jSONObject2.put(str, 1);
                str5 = "message";
                jSONObject2.put(str5, "resource is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                r11 = str5;
                return;
            }
            try {
                if (jSONArray.length() > 0) {
                    ?? jSONArray2 = new JSONArray();
                    int length = jSONArray.length();
                    int i13 = 0;
                    while (i13 < length) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i13);
                        String strOptString = jSONObject3.optString("ref", "");
                        int i14 = jSONObject3.getInt("type");
                        ?? jSONObject4 = new JSONObject();
                        JSONArray jSONArray3 = jSONArray;
                        if (i14 != i12 || TextUtils.isEmpty(strOptString)) {
                            str2 = str6;
                            str3 = str7;
                            i11 = length;
                            if (i14 == 2 && !TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("type", 2);
                                jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, H5DownLoadManager.getInstance().getResAddress(strOptString) == null ? "" : H5DownLoadManager.getInstance().getH5ResAddress(strOptString));
                                jSONObject4.put(strOptString, jSONObject5);
                                jSONArray2.put(jSONObject4);
                            } else if (i14 == 3 && !TextUtils.isEmpty(strOptString)) {
                                try {
                                    File file = new File(strOptString);
                                    if (file.exists() && file.isFile() && file.canRead()) {
                                        ad.a("BannerSignalCommunicationImpl", "getFileInfo Mraid file " + strOptString);
                                        str4 = "file:////" + strOptString;
                                    } else {
                                        str4 = "";
                                    }
                                } catch (Throwable th2) {
                                    if (MBridgeConstans.DEBUG) {
                                        th2.printStackTrace();
                                    }
                                }
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 3);
                                jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str4);
                                jSONObject4.put(strOptString, jSONObject6);
                                jSONArray2.put(jSONObject4);
                            } else if (i14 == 4 && !TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("type", 4);
                                jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, ah.a(strOptString) == null ? "" : ah.a(strOptString));
                                jSONObject4.put(strOptString, jSONObject7);
                                jSONArray2.put(jSONObject4);
                            }
                        } else {
                            JSONObject jSONObject8 = new JSONObject();
                            m mVarA = p.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(strOptString);
                            if (mVarA != null) {
                                i11 = length;
                                ad.a("BannerSignalCommunicationImpl", "VideoBean not null");
                                jSONObject8.put("type", 1);
                                str2 = str6;
                                try {
                                    jSONObject8.put("videoDataLength", mVarA.d());
                                    String strE = mVarA.e();
                                    str3 = str7;
                                    if (TextUtils.isEmpty(strE)) {
                                        try {
                                            ad.a("BannerSignalCommunicationImpl", "VideoPath null");
                                            jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "");
                                            jSONObject8.put("path4Web", "");
                                        } catch (Throwable th3) {
                                            th = th3;
                                            r11 = str2;
                                            str = str3;
                                            jSONObject2.put(str, 1);
                                            jSONObject2.put(r11, th.getLocalizedMessage());
                                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                                        }
                                    } else {
                                        ad.a("BannerSignalCommunicationImpl", "VideoPath not null");
                                        jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, strE);
                                        jSONObject8.put("path4Web", strE);
                                    }
                                    if (mVarA.b() == 5) {
                                        jSONObject8.put("downloaded", 1);
                                    } else {
                                        jSONObject8.put("downloaded", 0);
                                    }
                                    jSONObject4.put(strOptString, jSONObject8);
                                    jSONArray2.put(jSONObject4);
                                } catch (Throwable th4) {
                                    th = th4;
                                    str3 = str7;
                                    r11 = str2;
                                    str = str3;
                                    jSONObject2.put(str, 1);
                                    jSONObject2.put(r11, th.getLocalizedMessage());
                                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                                }
                            } else {
                                str2 = str6;
                                str3 = str7;
                                i11 = length;
                                ad.a("BannerSignalCommunicationImpl", "VideoBean null");
                            }
                        }
                        i13++;
                        jSONArray = jSONArray3;
                        length = i11;
                        str6 = str2;
                        str7 = str3;
                        i12 = 1;
                    }
                    str2 = str6;
                    str3 = str7;
                    jSONObject2.put("resource", jSONArray2);
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                }
                str = TrackingKey.CODE;
                r11 = 1;
                try {
                    try {
                        jSONObject2.put(str, 1);
                        str5 = "message";
                        try {
                            jSONObject2.put(str5, "resource is null");
                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            r11 = str5;
                        } catch (JSONException e12) {
                            e = e12;
                            ad.a("BannerSignalCommunicationImpl", e.getMessage());
                            r11 = str5;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (JSONException e13) {
                    e = e13;
                    str5 = "message";
                } catch (Throwable th6) {
                    th = th6;
                    r11 = "message";
                }
                return;
            } catch (Throwable th7) {
                th = th7;
                str2 = str6;
            }
        } catch (Throwable th8) {
            th = th8;
            r11 = "message";
            str = TrackingKey.CODE;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(r11, th.getLocalizedMessage());
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e14) {
            ad.a("BannerSignalCommunicationImpl", e14.getMessage());
        }
    }

    public final void a() {
        if (this.f45384g != null) {
            this.f45384g = null;
        }
        if (this.f45385h != null) {
            this.f45385h = null;
        }
    }

    public final void a(int i11) {
        this.f45383f = i11;
    }

    public final void a(com.mbridge.msdk.mbbanner.common.b.a aVar) {
        if (aVar != null) {
            this.f45384g = aVar;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void a(Object obj, String str) {
        ad.b("BannerSignalCommunicationImpl", "BANNER INIT INVOKE");
        try {
            JSONObject jSONObject = new JSONObject();
            i iVar = new i(com.mbridge.msdk.foundation.controller.c.m().c());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f45383f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", iVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f45380c));
            k kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f45382e);
            if (kVarD == null) {
                kVarD = k.d(this.f45382e);
            }
            if (!TextUtils.isEmpty(this.f45381d)) {
                kVarD.a(this.f45381d);
            }
            jSONObject.put("unitSetting", kVarD.x());
            String strG = com.mbridge.msdk.c.h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put("appSetting", new JSONObject(strG));
            }
            jSONObject.put("sdk_info", d.f45662a);
            ad.b("BannerSignalCommunicationImpl", "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "init", th2);
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f45380c = list;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void b(Object obj, String str) {
        ad.b("BannerSignalCommunicationImpl", "click");
        try {
            List<CampaignEx> list = this.f45380c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.f45380c.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
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
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "click", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void c(Object obj, String str) {
        if (obj != null) {
            try {
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                g.a().a(obj, com.mbridge.msdk.mbsignalcommon.communication.d.a(0));
                com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
                if (aVar != null) {
                    aVar.b(iOptInt);
                }
            } catch (Throwable th2) {
                ad.a("BannerSignalCommunicationImpl", "readyStatus", th2);
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void close() {
        ad.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLOSE, th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void d(Object obj, String str) {
        ad.b("BannerSignalCommunicationImpl", "toggleCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
            if (aVar != null) {
                aVar.a(iOptInt);
            }
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "toggleCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void e(Object obj, String str) {
        ad.b("BannerSignalCommunicationImpl", "triggerCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString("state");
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
            if (aVar != null) {
                aVar.a(strOptString);
            }
            g.a().a(obj, com.mbridge.msdk.mbsignalcommon.communication.d.a(0));
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "triggerCloseBtn", th2);
            g.a().a(obj, com.mbridge.msdk.mbsignalcommon.communication.d.a(-1));
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void expand(String str, boolean z11) {
        Context context;
        try {
            String bannerUrl = "";
            if (getMraidCampaign() != null) {
                if (TextUtils.isEmpty(getMraidCampaign().getBannerHtml())) {
                    bannerUrl = getMraidCampaign().getBannerUrl();
                } else {
                    bannerUrl = "file:////" + getMraidCampaign().getBannerHtml();
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bannerUrl = str;
            }
            bundle.putString("url", bannerUrl);
            bundle.putBoolean("shouldUseCustomClose", z11);
            WeakReference<Context> weakReference = this.f45379b;
            if (weakReference != null && (context = weakReference.get()) != null) {
                BannerExpandDialog bannerExpandDialog = this.f45385h;
                if (bannerExpandDialog != null && bannerExpandDialog.isShowing()) {
                    return;
                }
                BannerExpandDialog bannerExpandDialog2 = new BannerExpandDialog(context, bundle, this.f45384g);
                this.f45385h = bannerExpandDialog2;
                bannerExpandDialog2.setCampaignList(this.f45382e, this.f45380c);
                this.f45385h.show();
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
            if (aVar != null) {
                aVar.a(true);
            }
            com.mbridge.msdk.mbbanner.common.d.a.a(this.f45382e, getMraidCampaign(), str);
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "expand", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f45380c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f45380c.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void i(Object obj, String str) {
        ad.a("BannerSignalCommunicationImpl", "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string = jSONArray.getString(i11);
                for (CampaignEx campaignEx : this.f45380c) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.a.d.a(this.f45382e, campaignEx, "banner");
                        arrayList.add(string);
                    }
                }
            }
            b.b().execute(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.communication.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.k kVarA = com.mbridge.msdk.foundation.db.k.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            kVarA.a((String) it.next());
                        }
                    } catch (Exception e11) {
                        ad.b("BannerSignalCommunicationImpl", e11.getMessage());
                    }
                }
            });
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "sendImpressions", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void j(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public final void k(Object obj, String str) {
        ad.a("BannerSignalCommunicationImpl", "reportUrls:" + str);
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
                    List<CampaignEx> list = this.f45380c;
                    com.mbridge.msdk.click.a.a(contextC, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list2 = this.f45380c;
                    com.mbridge.msdk.click.a.a(contextC2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, com.mbridge.msdk.mbsignalcommon.communication.d.a(0));
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "reportUrls", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void open(String str) {
        ad.b("BannerSignalCommunicationImpl", "open");
        try {
            ad.b("BannerSignalCommunicationImpl", str);
            if (this.f45380c.size() > 1) {
                com.mbridge.msdk.foundation.controller.c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
            if (aVar != null) {
                aVar.a(true, str);
            }
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "open", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void useCustomClose(boolean z11) {
        int i11 = z11 ? 2 : 1;
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f45384g;
            if (aVar != null) {
                aVar.a(i11);
            }
        } catch (Throwable th2) {
            ad.a("BannerSignalCommunicationImpl", "useCustomClose", th2);
        }
    }
}
