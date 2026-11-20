package com.bytedance.sdk.openadsdk.core.Tf.pFF;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.applovin.sdk.AppLovinEventTypes;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.uEA;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.hisavana.common.tracking.TrackingKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private static final Map<String, pFF> ExN = new ConcurrentHashMap();
    private static final AtomicBoolean TRI = new AtomicBoolean(false);
    private boolean We;
    private EnumC0292zY pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f28223sc;
    private boolean zY;

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        Sfl pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        String f28226sc;
        float zY;

        public pFF(String str, Sfl sfl) {
            this(str, sfl, -1.0f);
        }

        public pFF(String str, Sfl sfl, float f11) {
            this.f28226sc = str;
            this.pFF = sfl;
            this.zY = f11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final String f28227sc;
        private EnumC0292zY pFF = EnumC0292zY.TRACKING_URL;
        private boolean zY = false;

        public sc(String str) {
            this.f28227sc = str;
        }

        public sc sc(boolean z11) {
            this.zY = z11;
            return this;
        }

        public zY sc() {
            return new zY(this.f28227sc, this.pFF, Boolean.valueOf(this.zY));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Tf.pFF.zY$zY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public enum EnumC0292zY {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    static {
        uEA.sc(new uEA.sc() { // from class: com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.1
            @Override // com.bytedance.sdk.component.utils.uEA.sc
            public void sc(Context context, Intent intent, boolean z11, int i11) {
                if (i11 == 0 || zY.ExN.size() <= 0) {
                    return;
                }
                zY.pFF();
            }
        }, Xc.sc());
    }

    public zY(String str, EnumC0292zY enumC0292zY, Boolean bool) {
        this.f28223sc = str;
        this.pFF = enumC0292zY;
        this.zY = bool.booleanValue();
    }

    public static List<com.bytedance.sdk.openadsdk.core.Tf.pFF.pFF> pFF(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.pFF.sc(jSONObjectOptJSONObject.optString(AppLovinEventTypes.USER_VIEWED_CONTENT), (float) jSONObjectOptJSONObject.optDouble("trackingFraction", 0.0d)).sc());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF() {
        if (TRI.compareAndSet(false, true)) {
            Map<String, pFF> map = ExN;
            HashSet<Map.Entry> hashSet = new HashSet(map.entrySet());
            map.clear();
            for (Map.Entry entry : hashSet) {
                if (entry != null) {
                    sc((String) entry.getKey(), (pFF) entry.getValue(), true);
                }
            }
            TRI.set(false);
        }
    }

    public static void pFF(@NonNull List<zY> list, @Nullable com.bytedance.sdk.openadsdk.core.Tf.sc.sc scVar, @Nullable long j11, @Nullable String str) {
        sc(list, scVar, j11, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(final boolean z11, final String str, final String str2, final pFF pff, final String str3, final boolean z12) {
        com.bytedance.sdk.openadsdk.We.zY.sc(new Qj("dsp_track_link_result") { // from class: com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", pff.f28226sc);
                    jSONObject.put("success", z11);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(TrackingKey.DESCRIPTION, str);
                    }
                    jSONObject.put("url", str3);
                    float f11 = pff.zY;
                    if (f11 >= 0.0f) {
                        jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, ((double) Math.round(f11 * 100.0f)) / 100.0d);
                    }
                    if (z12) {
                        jSONObject.put("retry", true);
                    }
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.We.zY.pFF(pff.pFF, str2, "dsp_track_link_result", jSONObject);
            }
        });
    }

    public static List<String> sc(@NonNull List<zY> list, @Nullable com.bytedance.sdk.openadsdk.core.Tf.sc.sc scVar, @Nullable long j11, @Nullable String str) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zY zYVar : list) {
            if (zYVar != null && (!zYVar.ExN() || zYVar.We())) {
                arrayList.add(zYVar.zY());
                zYVar.j_();
            }
        }
        return new com.bytedance.sdk.openadsdk.core.Tf.zY.zY(arrayList).sc(scVar).sc(j11).sc(str).sc();
    }

    public static List<zY> sc(JSONArray jSONArray) {
        return sc(jSONArray, false);
    }

    public static List<zY> sc(JSONArray jSONArray, boolean z11) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String strOptString = jSONArray.optString(i11);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(new sc(strOptString).sc(z11).sc());
                }
            }
        }
        return arrayList;
    }

    public static JSONArray sc(List<zY> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < list.size(); i11++) {
            jSONArray.put(list.get(i11).zY());
        }
        return jSONArray;
    }

    private static void sc(final String str, final pFF pff, final boolean z11) {
        com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
        if (pffZY == null) {
            return;
        }
        pffZY.sc(true);
        pffZY.pFF(str);
        pffZY.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.2
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff2) {
                String str2;
                boolean z12;
                pFF pff3 = pff;
                if (pff3 == null || pff3.pFF == null) {
                    return;
                }
                String str3 = null;
                if (pff2 == null || !pff2.TRI()) {
                    if (pff2 != null) {
                        str3 = pff2.sc() + ":" + pff2.pFF();
                        if (!z11 && (pff2.sc() <= 300 || pff2.sc() >= 400)) {
                            zY.ExN.put(str, pff);
                        }
                    }
                    str2 = str3;
                    z12 = false;
                } else {
                    str2 = null;
                    z12 = true;
                }
                zY.pFF(z12, str2, cJ.zY(pff.pFF.qY()), pff, str, z11);
                if (pff2 == null || pff2.sc() != 200 || zY.ExN.size() <= 0) {
                    return;
                }
                zY.pFF();
            }

            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                Sfl sfl;
                pFF pff2 = pff;
                if (pff2 != null && (sfl = pff2.pFF) != null) {
                    zY.pFF(false, iOException != null ? iOException.getMessage() : null, cJ.zY(sfl.qY()), pff, str, z11);
                }
                if (z11 || pff == null) {
                    return;
                }
                zY.ExN.put(str, pff);
            }
        });
    }

    public static void sc(List<String> list, pFF pff) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11);
            if (!TextUtils.isEmpty(str)) {
                sc(str, pff, false);
            }
        }
    }

    public static void sc(@NonNull List<zY> list, @Nullable com.bytedance.sdk.openadsdk.core.Tf.sc.sc scVar, @Nullable long j11, @Nullable String str, pFF pff) {
        sc(sc(list, scVar, j11, str), pff);
    }

    public static List<com.bytedance.sdk.openadsdk.core.Tf.pFF.sc> zY(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.sc.C0291sc(jSONObjectOptJSONObject.optString(AppLovinEventTypes.USER_VIEWED_CONTENT), jSONObjectOptJSONObject.optLong("trackingMilliseconds", 0L)).sc());
                }
            }
        }
        return arrayList;
    }

    public boolean ExN() {
        return this.We;
    }

    public boolean We() {
        return this.zY;
    }

    public void j_() {
        this.We = true;
    }

    public String zY() {
        return this.f28223sc;
    }
}
