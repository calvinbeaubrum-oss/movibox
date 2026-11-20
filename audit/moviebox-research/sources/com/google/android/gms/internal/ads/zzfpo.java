package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpo {
    private static WindowManager zzb;
    private static final String[] zzc = {"x", "y", "width", "height"};
    static float zza = Resources.getSystem().getDisplayMetrics().density;

    public static JSONObject zza(int i11, int i12, int i13, int i14) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", i11 / zza);
            jSONObject.put("y", i12 / zza);
            jSONObject.put("width", i13 / zza);
            jSONObject.put("height", i14 / zza);
        } catch (JSONException e11) {
            zzfpp.zza("Error with creating viewStateObject", e11);
        }
        return jSONObject;
    }

    public static void zzb(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e11) {
            zzfpp.zza("Error with setting ad session id", e11);
        }
    }

    public static void zzc(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArrayOptJSONArray);
            }
            jSONArrayOptJSONArray.put(jSONObject2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static void zzd(Context context) {
        if (context != null) {
            zza = context.getResources().getDisplayMetrics().density;
            zzb = (WindowManager) context.getSystemService("window");
        }
    }

    public static void zze(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e11) {
            zzfpp.zza("JSONException during JSONObject.put for name [" + str + "]", e11);
        }
    }

    public static void zzf(JSONObject jSONObject) {
        float f11;
        float f12;
        if (zzb != null) {
            Point point = new Point(0, 0);
            zzb.getDefaultDisplay().getRealSize(point);
            float f13 = point.x;
            float f14 = zza;
            f11 = f13 / f14;
            f12 = point.y / f14;
        } else {
            f11 = 0.0f;
            f12 = 0.0f;
        }
        try {
            jSONObject.put("width", f11);
            jSONObject.put("height", f12);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bf A[LOOP:1: B:42:0x00ab->B:46:0x00bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c3 A[SYNTHETIC] */
    public static boolean zzg(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        int i11;
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null && jSONObject2 != null) {
            String[] strArr = zzc;
            for (int i12 = 0; i12 < 4; i12++) {
                String str = strArr[i12];
                if (jSONObject.optDouble(str) == jSONObject2.optDouble(str)) {
                }
            }
            if (jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", "")) && Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice"))) && Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")))) {
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("isFriendlyObstructionFor");
                JSONArray jSONArrayOptJSONArray4 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
                if (jSONArrayOptJSONArray3 == null && jSONArrayOptJSONArray4 == null) {
                    jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
                    jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("childViews");
                    if (jSONArrayOptJSONArray == null) {
                    }
                    if (zzh(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
                        for (i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                            if (zzg(jSONArrayOptJSONArray.optJSONObject(i11), jSONArrayOptJSONArray2.optJSONObject(i11))) {
                            }
                        }
                        return true;
                    }
                } else if (zzh(jSONArrayOptJSONArray3, jSONArrayOptJSONArray4)) {
                    for (int i13 = 0; i13 < jSONArrayOptJSONArray3.length(); i13++) {
                        if (jSONArrayOptJSONArray3.optString(i13, "").equals(jSONArrayOptJSONArray4.optString(i13, ""))) {
                        }
                    }
                    jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
                    jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("childViews");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray2 != null) {
                        if (zzh(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
                            while (i11 < jSONArrayOptJSONArray.length()) {
                                if (zzg(jSONArrayOptJSONArray.optJSONObject(i11), jSONArrayOptJSONArray2.optJSONObject(i11))) {
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzh(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
