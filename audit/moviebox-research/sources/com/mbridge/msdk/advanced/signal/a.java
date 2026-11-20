package com.mbridge.msdk.advanced.signal;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f42848a = "NativeAdvancedJsUtils";

    public static void a(WebView webView) {
        ad.b(f42848a, "fireOnJSBridgeConnected");
        g.a().a(webView);
    }

    public static void a(WebView webView, String str, String str2) {
        g.a().a(webView, str, str2);
    }

    public static void a(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sq", 1);
            jSONObject.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            g.a().a(webView, "thirdPartyCalled", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e11) {
            ad.b(f42848a, e11.getMessage());
        }
    }

    public static void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, d.f45733b);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            ad.a(f42848a, e11.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, org.json.JSONObject] */
    public static void a(Object obj, JSONObject jSONObject) {
        ?? r11;
        String str;
        JSONArray jSONArray;
        int i11;
        String str2;
        String str3;
        String str4 = "";
        ?? jSONObject2 = new JSONObject();
        String str5 = "message";
        int i12 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put(TrackingKey.CODE, 1);
                jSONObject2.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e11) {
                ad.a(f42848a, e11.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put(TrackingKey.CODE, 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray2 = jSONObject.getJSONArray("resource");
            try {
                if (jSONArray2 != null) {
                    try {
                        if (jSONArray2.length() > 0) {
                            ?? jSONArray3 = new JSONArray();
                            int length = jSONArray2.length();
                            int i13 = 0;
                            while (i13 < length) {
                                JSONObject jSONObject3 = jSONArray2.getJSONObject(i13);
                                String strOptString = jSONObject3.optString("ref", str4);
                                int i14 = jSONObject3.getInt("type");
                                ?? jSONObject4 = new JSONObject();
                                if (i14 != i12 || TextUtils.isEmpty(strOptString)) {
                                    str4 = str4;
                                    str = str5;
                                    jSONArray = jSONArray2;
                                    i11 = length;
                                    if (i14 == 2 && !TextUtils.isEmpty(strOptString)) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("type", 2);
                                        jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, H5DownLoadManager.getInstance().getH5ResAddress(strOptString) == null ? str4 : H5DownLoadManager.getInstance().getH5ResAddress(strOptString));
                                        jSONObject4.put(strOptString, jSONObject5);
                                        jSONArray3.put(jSONObject4);
                                    } else if (i14 == 3 && !TextUtils.isEmpty(strOptString)) {
                                        try {
                                            File file = new File(strOptString);
                                            if (file.exists() && file.isFile() && file.canRead()) {
                                                ad.a(f42848a, "getFileInfo Mraid file " + strOptString);
                                                str2 = "file:////" + strOptString;
                                            } else {
                                                str2 = str4;
                                            }
                                        } catch (Throwable th2) {
                                            ad.b(f42848a, th2.getMessage());
                                        }
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put("type", 3);
                                        jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str2);
                                        jSONObject4.put(strOptString, jSONObject6);
                                        jSONArray3.put(jSONObject4);
                                    } else if (i14 == 4 && !TextUtils.isEmpty(strOptString)) {
                                        JSONObject jSONObject7 = new JSONObject();
                                        jSONObject7.put("type", 4);
                                        jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, ah.a(strOptString) == null ? str4 : ah.a(strOptString));
                                        jSONObject4.put(strOptString, jSONObject7);
                                        jSONArray3.put(jSONObject4);
                                    }
                                } else {
                                    JSONObject jSONObject8 = new JSONObject();
                                    m mVarA = p.a(h.a(c.m().c())).a(strOptString);
                                    if (mVarA != null) {
                                        jSONArray = jSONArray2;
                                        i11 = length;
                                        ad.a(f42848a, "VideoBean not null");
                                        jSONObject8.put("type", 1);
                                        jSONObject8.put("videoDataLength", mVarA.d());
                                        String strE = mVarA.e();
                                        str = str5;
                                        if (TextUtils.isEmpty(strE)) {
                                            ad.a(f42848a, "VideoPath null");
                                            jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str4);
                                            jSONObject8.put("path4Web", str4);
                                        } else {
                                            ad.a(f42848a, "VideoPath not null");
                                            jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, strE);
                                            jSONObject8.put("path4Web", strE);
                                        }
                                        if (mVarA.b() == 5) {
                                            jSONObject8.put("downloaded", 1);
                                        } else {
                                            jSONObject8.put("downloaded", 0);
                                        }
                                        jSONObject4.put(strOptString, jSONObject8);
                                        jSONArray3.put(jSONObject4);
                                    } else {
                                        str4 = str4;
                                        str = str5;
                                        jSONArray = jSONArray2;
                                        i11 = length;
                                        ad.a(f42848a, "VideoBean null");
                                    }
                                }
                                i13++;
                                jSONArray2 = jSONArray;
                                length = i11;
                                str5 = str;
                                str4 = str4;
                                i12 = 1;
                            }
                            jSONObject2.put("resource", jSONArray3);
                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str5;
                        r11 = str;
                        try {
                            jSONObject2.put(TrackingKey.CODE, 1);
                            jSONObject2.put(r11, th.getLocalizedMessage());
                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        } catch (JSONException e12) {
                            ad.a(f42848a, e12.getMessage());
                            return;
                        }
                    }
                }
                r11 = 1;
                try {
                    try {
                        jSONObject2.put(TrackingKey.CODE, 1);
                        str3 = "message";
                        try {
                            jSONObject2.put(str3, "resource is null");
                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            r11 = str3;
                        } catch (JSONException e13) {
                            e = e13;
                            ad.a(f42848a, e.getMessage());
                            r11 = str3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        jSONObject2.put(TrackingKey.CODE, 1);
                        jSONObject2.put(r11, th.getLocalizedMessage());
                        g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    }
                } catch (JSONException e14) {
                    e = e14;
                    str3 = "message";
                }
            } catch (Throwable th5) {
                th = th5;
                r11 = str;
                jSONObject2.put(TrackingKey.CODE, 1);
                jSONObject2.put(r11, th.getLocalizedMessage());
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th6) {
            th = th6;
            r11 = "message";
        }
    }
}
