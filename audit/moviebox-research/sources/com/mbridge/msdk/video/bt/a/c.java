package com.mbridge.msdk.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f47366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f47367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47368c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f47369a = new c();
    }

    private c() {
        this.f47368c = "handlerNativeResult";
        this.f47366a = 0;
        this.f47367b = 1;
    }

    public static c a() {
        return a.f47369a;
    }

    private void a(int i11, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e11) {
            ad.a("HandlerH5MessageManager", e11.getMessage());
        } catch (Throwable th2) {
            ad.a("HandlerH5MessageManager", th2.getMessage());
        }
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String strOptString = jSONObject.optString("uniqueIdentifier");
                    String strOptString2 = jSONObject.optString("name");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("parameters");
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                        int iOptInt = 0;
                        if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.toString())) {
                            iOptInt = jSONObjectOptJSONObject.optInt("type", 0);
                        }
                        a(this.f47366a, "receivedMessage", obj);
                        if (strOptString.equalsIgnoreCase("reporter")) {
                            com.mbridge.msdk.mbsignalcommon.a.a.a().a(obj, strOptString2, jSONArrayOptJSONArray, iOptInt);
                            return;
                        } else {
                            if (strOptString.equalsIgnoreCase("MediaPlayer")) {
                                b unused = b.a.f47365a;
                                return;
                            }
                            return;
                        }
                    }
                    a(this.f47367b, "module or method is null", obj);
                    return;
                }
            } catch (Exception e11) {
                ad.a("HandlerH5MessageManager", e11.getMessage());
                a(this.f47367b, e11.getMessage(), obj);
                return;
            } catch (Throwable th2) {
                ad.a("HandlerH5MessageManager", th2.getMessage());
                a(this.f47367b, th2.getMessage(), obj);
                return;
            }
        }
        a(this.f47367b, "params is null", obj);
    }
}
