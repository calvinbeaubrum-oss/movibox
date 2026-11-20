package com.mbridge.msdk.foundation.same.net.h;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends com.mbridge.msdk.foundation.same.net.f<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44655a = "d";

    private void a(k<JSONObject> kVar) {
        JSONObject jSONObject = kVar.f44691c;
        if (jSONObject == null) {
            a("response result is null");
            return;
        }
        int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -9999);
        if (iOptInt == -9999) {
            a(kVar.f44691c);
            return;
        }
        if (iOptInt == 1 || iOptInt == 200) {
            a(kVar.f44691c.optJSONObject("data"));
            return;
        }
        String strOptString = kVar.f44691c.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "error message is null";
        }
        a(strOptString);
    }

    public abstract void a(String str);

    public abstract void a(JSONObject jSONObject);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        ad.b(f44655a, "errorCode = " + aVar.f44551a);
        a(com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onSuccess(k<JSONObject> kVar) {
        if (kVar == null) {
            a("response is null");
            return;
        }
        com.mbridge.msdk.foundation.same.net.f.c cVar = kVar.f44690b;
        if (cVar == null) {
            a(kVar);
        } else if (cVar.f44608d == 204) {
            a(new JSONObject());
        } else {
            a(kVar);
        }
    }
}
