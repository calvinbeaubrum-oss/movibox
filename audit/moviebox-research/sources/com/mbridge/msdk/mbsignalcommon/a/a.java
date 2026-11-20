package com.mbridge.msdk.mbsignalcommon.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.e.b;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f45649c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f45652d = "handlerNativeResult";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f45650a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f45651b = 1;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0498a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f45654a = new a();
    }

    public static a a() {
        return C0498a.f45654a;
    }

    private void a(int i11, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e11) {
            ad.a(f45649c, e11.getMessage());
        } catch (Throwable th2) {
            ad.a(f45649c, th2.getMessage());
        }
    }

    public final void a(Object obj, String str, JSONArray jSONArray, int i11) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        JSONObject jSONObjectOptJSONObject5;
        JSONObject jSONObjectOptJSONObject6;
        JSONObject jSONObjectOptJSONObject7;
        JSONObject jSONObjectOptJSONObject8;
        JSONObject jSONObjectOptJSONObject9;
        JSONObject jSONObjectOptJSONObject10;
        JSONObject jSONObjectOptJSONObject11;
        int i12;
        try {
            if (jSONArray == null) {
                a(this.f45651b, "called reporter failed, params empty", obj);
                return;
            }
            int length = jSONArray.length();
            if (length == 0) {
                a(this.f45651b, "called reporter failed, params empty", obj);
                return;
            }
            if ("reportMessageR".equalsIgnoreCase(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                int i13 = 0;
                while (true) {
                    i12 = length - 1;
                    if (i13 >= i12) {
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject12 = jSONArray.optJSONObject(i13);
                    if (jSONObjectOptJSONObject12 != null) {
                        stringBuffer.append(jSONObjectOptJSONObject12.optString("key"));
                        stringBuffer.append("=");
                        stringBuffer.append(jSONObjectOptJSONObject12.opt(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        stringBuffer.append("&");
                    }
                    i13++;
                }
                JSONObject jSONObjectOptJSONObject13 = jSONArray.optJSONObject(i12);
                if (jSONObjectOptJSONObject13 != null) {
                    stringBuffer.append(jSONObjectOptJSONObject13.optString("key"));
                    stringBuffer.append("=");
                    stringBuffer.append(jSONObjectOptJSONObject13.opt(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                }
                String string = stringBuffer.toString();
                Context contextC = c.m().c();
                if (contextC != null && !TextUtils.isEmpty(string)) {
                    try {
                        new com.mbridge.msdk.foundation.same.report.e.a(contextC).post(0, d.f().f44626c, q.a(string, contextC), new b() { // from class: com.mbridge.msdk.mbsignalcommon.a.a.1
                            @Override // com.mbridge.msdk.foundation.same.report.e.b
                            public final void onFailed(String str2) {
                                ad.b(a.f45649c, str2);
                            }

                            @Override // com.mbridge.msdk.foundation.same.report.e.b
                            public final void onSuccess(String str2) {
                                ad.b(a.f45649c, str2);
                            }
                        });
                    } catch (Exception e11) {
                        ad.b(f45649c, e11.getMessage());
                    }
                }
            } else if ("reportMessageD".equalsIgnoreCase(str)) {
                String string2 = "";
                String string3 = (length <= 0 || (jSONObjectOptJSONObject11 = jSONArray.optJSONObject(0)) == null) ? "" : jSONObjectOptJSONObject11.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i14 = (length <= 1 || (jSONObjectOptJSONObject10 = jSONArray.optJSONObject(1)) == null) ? -1 : jSONObjectOptJSONObject10.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i15 = (length <= 2 || (jSONObjectOptJSONObject9 = jSONArray.optJSONObject(2)) == null) ? -1 : jSONObjectOptJSONObject9.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i16 = (length <= 3 || (jSONObjectOptJSONObject8 = jSONArray.optJSONObject(3)) == null) ? -1 : jSONObjectOptJSONObject8.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i17 = (length <= 4 || (jSONObjectOptJSONObject7 = jSONArray.optJSONObject(4)) == null) ? -1 : jSONObjectOptJSONObject7.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String string4 = (length <= 5 || (jSONObjectOptJSONObject6 = jSONArray.optJSONObject(5)) == null) ? "" : jSONObjectOptJSONObject6.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String string5 = (length <= 6 || (jSONObjectOptJSONObject5 = jSONArray.optJSONObject(6)) == null) ? "" : jSONObjectOptJSONObject5.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i18 = (length <= 7 || (jSONObjectOptJSONObject4 = jSONArray.optJSONObject(7)) == null) ? -1 : jSONObjectOptJSONObject4.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String string6 = (length <= 8 || (jSONObjectOptJSONObject3 = jSONArray.optJSONObject(8)) == null) ? "" : jSONObjectOptJSONObject3.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i19 = (length <= 9 || (jSONObjectOptJSONObject2 = jSONArray.optJSONObject(9)) == null) ? -1 : jSONObjectOptJSONObject2.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                if (length > 10 && (jSONObjectOptJSONObject = jSONArray.optJSONObject(10)) != null) {
                    string2 = jSONObjectOptJSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                }
                String str2 = string2;
                try {
                    Context contextC2 = c.m().c();
                    if (contextC2 != null) {
                        com.mbridge.msdk.foundation.db.q.a(h.a(contextC2)).a(new n(string3, i14, i15, i16, i17, string4, string5, i18, string6, i19, str2));
                    }
                } catch (Throwable th2) {
                    ad.a(f45649c, th2.getMessage());
                }
            }
            a(this.f45650a, "called reporter success", obj);
        } catch (Throwable th3) {
            ad.a(f45649c, th3.getMessage());
            a(this.f45651b, "exception: " + th3.getMessage(), obj);
        }
    }
}
