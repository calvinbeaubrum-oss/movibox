package com.mbridge.msdk.newreward.function.c.b.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.mbridge.msdk.newreward.function.c.b.d {
    public final Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return null;
        }
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
        long jLongValue = ((Long) map.get("last_response_empty_time")).longValue();
        if (eVar == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(eVar.A()) && eVar.p() != null && eVar.p().b() != null) {
            if (System.currentTimeMillis() - jLongValue < eVar.p().b().a() * 1000) {
                map2.put(TrackingKey.ERROR_CODE, "-1");
                map2.put(NotificationCompat.CATEGORY_MESSAGE, "EXCEPTION_RETURN_EMPTY");
                return map2;
            }
        }
        com.mbridge.msdk.foundation.same.net.k kVarA = com.mbridge.msdk.foundation.same.net.g.c.a().a(eVar.t(), eVar.y(), eVar.u(), eVar.A(), eVar.n() + "");
        if (kVarA != null) {
            try {
                JSONObject jSONObject = new JSONObject(kVarA.f44691c.toString());
                jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                map2.put(TrackingKey.ERROR_CODE, jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) + "");
                map2.put(NotificationCompat.CATEGORY_MESSAGE, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            } catch (JSONException e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
        return map2;
    }
}
