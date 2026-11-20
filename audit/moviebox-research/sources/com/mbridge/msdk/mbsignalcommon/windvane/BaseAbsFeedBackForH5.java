package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BaseAbsFeedBackForH5 extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f45753e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f45754f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f45755a = "AbsFeedBackForH5";

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f45754f);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            ad.a(this.f45755a, e11.getMessage());
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f45753e);
            jSONObject.put("message", "");
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            callbackExcep(obj, e11.getMessage());
            ad.a(this.f45755a, e11.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TrackingKey.CODE, f45753e);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e11) {
            callbackExcep(obj, e11.getMessage());
            ad.a(this.f45755a, e11.getMessage());
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("width", -1);
                int iOptInt2 = jSONObject.optInt("height", -1);
                int iOptInt3 = jSONObject.optInt(TtmlNode.LEFT, -1);
                int iOptInt4 = jSONObject.optInt("top", -1);
                double dOptDouble = jSONObject.optDouble("opacity", 1.0d);
                int iOptInt5 = jSONObject.optInt("radius", 20);
                String strOptString = jSONObject.optString("fontColor", "");
                String strOptString2 = jSONObject.optString("bgColor", "");
                com.mbridge.msdk.foundation.d.b.a().a(jSONObject.optString("key", ""), iOptInt, iOptInt2, iOptInt5, iOptInt3, iOptInt4, (float) dOptDouble, strOptString, strOptString2, (float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, -1.0d), jSONObject.optJSONArray("padding"));
            }
            callbackSuccess(obj);
        } catch (Throwable th2) {
            callbackExcep(obj, th2.getMessage());
            th2.printStackTrace();
        }
    }

    public void feedbackOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                com.mbridge.msdk.foundation.d.b.a().a(jSONObject.optString("key", ""), iOptInt == 1 ? 8 : 0, aVar.f45774b);
            }
            callbackSuccess(obj);
        } catch (Throwable th2) {
            callbackExcep(obj, th2.getMessage());
            th2.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                String strOptString = jSONObject.optString("key", "");
                final WindVaneWebView windVaneWebView = ((a) obj).f45774b;
                com.mbridge.msdk.foundation.d.b.a().a(strOptString, iOptInt, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbsignalcommon.windvane.BaseAbsFeedBackForH5.1
                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a() {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th2) {
                            ad.a(BaseAbsFeedBackForH5.this.f45755a, th2.getMessage(), th2);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a(String str2) {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th2) {
                            ad.a(BaseAbsFeedBackForH5.this.f45755a, th2.getMessage(), th2);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void b() {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th2) {
                            ad.a(BaseAbsFeedBackForH5.this.f45755a, th2.getMessage(), th2);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }
                });
            }
            callbackSuccess(obj);
        } catch (Throwable th2) {
            callbackExcep(obj, th2.getMessage());
            th2.printStackTrace();
        }
    }
}
