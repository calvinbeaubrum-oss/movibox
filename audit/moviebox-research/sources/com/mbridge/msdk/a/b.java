package com.mbridge.msdk.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.adsession.CreativeType;
import com.iab.omid.library.mmadbridge.adsession.ImpressionType;
import com.iab.omid.library.mmadbridge.adsession.Owner;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.MBConfiguration;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kn.d;
import kn.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42629a = DomainNameUtils.VERIFICATION_URL;

    private static String a() {
        try {
            return ab.b(new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt"));
        } catch (Exception e11) {
            ad.a("OMSDK", e11.getMessage());
            return "";
        }
    }

    private static List<f> a(String str, Context context, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (str != null) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                    String strOptString = jSONObjectOptJSONObject.optString("vkey", "");
                    URL url = new URL(jSONObjectOptJSONObject.optString("et_url", ""));
                    String strOptString2 = jSONObjectOptJSONObject.optString("verification_p", "");
                    arrayList.add(TextUtils.isEmpty(strOptString2) ? TextUtils.isEmpty(strOptString) ? f.b(url) : f.b(url) : f.a(strOptString, url, strOptString2));
                }
            }
        } catch (IllegalArgumentException e11) {
            ad.b("OMSDK", e11.getMessage());
            new o(context).a(str2, str5, str3, str4, "failed, exception " + e11.getMessage());
        } catch (MalformedURLException e12) {
            ad.b("OMSDK", e12.getMessage());
            new o(context).a(str2, str5, str3, str4, "failed, exception " + e12.getMessage());
        } catch (JSONException e13) {
            ad.b("OMSDK", e13.getMessage());
            new o(context).a(str2, str5, str3, str4, "failed, exception " + e13.getMessage());
        }
        return arrayList;
    }

    public static kn.b a(Context context, WebView webView, String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) || TextUtils.isEmpty(campaignEx.getOmid())) {
            ad.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(campaignEx.getOmid()) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new o(context).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), campaignEx.getCampaignUnitId(), "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
        CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
        c(context);
        ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
        Owner owner = Owner.JAVASCRIPT;
        CreativeType creativeType2 = CreativeType.DEFINED_BY_JAVASCRIPT;
        kn.b bVarB = kn.b.b(kn.c.a(creativeType, impressionType, owner, Owner.NONE, false), d.a(kn.e.a("Mintegral", MBConfiguration.SDK_VERSION), webView, null, null));
        bVarB.d(webView);
        return bVarB;
    }

    public static kn.b a(Context context, boolean z11, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        kn.b bVarB = null;
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) || TextUtils.isEmpty(str)) {
            ad.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(str) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new o(context).a(str2, str6, str3, str4, "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
        try {
            c(context);
            kn.e eVarA = kn.e.a("Mintegral", MBConfiguration.SDK_VERSION);
            CreativeType creativeType = CreativeType.NATIVE_DISPLAY;
            ImpressionType impressionType = ImpressionType.LOADED;
            Owner owner = Owner.NATIVE;
            try {
                bVarB = kn.b.b(kn.c.a(creativeType, impressionType, owner, z11 ? Owner.NONE : owner, false), d.b(eVarA, MBridgeConstans.OMID_JS_SERVICE_CONTENT, a(str, context, str2, str3, str4, str6), str5, str2));
                ad.a("OMSDK", "adSession create success");
                return bVarB;
            } catch (IllegalArgumentException e11) {
                e = e11;
                ad.b("OMSDK", e.getMessage());
                new o(context).a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                return bVarB;
            } catch (Exception e12) {
                e = e12;
                ad.b("OMSDK", e.getMessage());
                new o(context).a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                return bVarB;
            }
        } catch (IllegalArgumentException e13) {
            e = e13;
        } catch (Exception e14) {
            e = e14;
        }
    }

    public static void a(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = "";
            new o(context).a("", "", "", "", "fetch OM failed, OMID_JS_SERVICE_URL null");
        } else {
            if (context == null) {
                return;
            }
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_SERVICE_URL, null, new com.mbridge.msdk.foundation.same.net.c.a() { // from class: com.mbridge.msdk.a.b.1
                    @Override // com.mbridge.msdk.foundation.same.net.c.a
                    public final void a(String str) {
                        ad.a("OMSDK", "fetch OMJSContent failed, errorCode = " + str);
                        new o(context).a("", "", "", "", "fetch OM failed, request failed");
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.c.a
                    public final void b(String str) {
                        MBridgeConstans.OMID_JS_SERVICE_CONTENT = str;
                        b.a(str);
                    }
                });
            } catch (Exception e11) {
                ad.b("OMSDK", e11.getMessage());
            }
        }
    }

    public static void a(final String str) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                try {
                    File file = new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    ab.a(str.getBytes(), file);
                } catch (Exception e11) {
                    ad.a("OMSDK", e11.getMessage());
                }
            }
        }).start();
    }

    private static String b() {
        try {
            File file = new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
            return file.exists() ? ab.b(file) : "";
        } catch (Exception e11) {
            ad.a("OMSDK", e11.getMessage());
            return "";
        }
    }

    public static void b(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_URL)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = "";
            new o(context).a("", "", "", "", "fetch OM failed, OMID_JS_H5_URL null");
        } else {
            if (context == null) {
                return;
            }
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_H5_URL, null, new com.mbridge.msdk.foundation.same.net.c.a() { // from class: com.mbridge.msdk.a.b.3
                    @Override // com.mbridge.msdk.foundation.same.net.c.a
                    public final void a(String str) {
                        ad.a("OMSDK", "fetch OMJSH5Content failed, errorCode = " + str);
                        new o(context).a("", "", "", "", "fetch OM H5 failed, request failed");
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.c.a
                    public final void b(String str) {
                        MBridgeConstans.OMID_JS_H5_CONTENT = str;
                        b.b(str);
                    }
                });
            } catch (Exception e11) {
                ad.b("OMSDK", e11.getMessage());
            }
        }
    }

    public static void b(final String str) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.4
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                try {
                    File file = new File(e.a(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    ab.a(str.getBytes(), file);
                } catch (Exception e11) {
                    ad.a("OMSDK", e11.getMessage());
                }
            }
        }).start();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        return TextUtils.isEmpty(str) ? str : str.replace("/*OMSDK_INSERT_HERE*/", MBridgeConstans.OMID_JS_H5_CONTENT).replace("[INSERT RESOURCE URL]", f42629a);
    }

    private static void c(Context context) {
        if (jn.a.b()) {
            return;
        }
        jn.a.a(context);
    }
}
