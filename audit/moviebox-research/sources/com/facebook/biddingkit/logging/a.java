package com.facebook.biddingkit.logging;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<Map<String, String>> f32463a = new AtomicReference<>();

    public static JSONObject a() {
        Map<String, String> map = f32463a.get();
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e11) {
            b.d("BiddingStaticEnvironmentData", "Failed to create json data", e11);
        }
        return jSONObject;
    }

    public static void b(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("bundle", context.getPackageName());
        map.put("idfa", str);
        map.put("device_make", Build.MANUFACTURER);
        map.put("device_model", Build.MODEL);
        map.put("os", "Android");
        map.put("os_version", Build.VERSION.RELEASE);
        map.put("bidding_kit_version", str2);
        f32463a.set(map);
    }
}
