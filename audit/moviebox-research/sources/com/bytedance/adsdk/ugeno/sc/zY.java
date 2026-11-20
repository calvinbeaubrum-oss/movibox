package com.bytedance.adsdk.ugeno.sc;

import android.text.TextUtils;
import android.util.Pair;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    public static pFF.sc We(String str) {
        JSONArray jSONArraySc;
        if (TextUtils.isEmpty(str) || (jSONArraySc = com.bytedance.adsdk.ugeno.qr.pFF.sc(str, (JSONArray) null)) == null || jSONArraySc.length() != 2) {
            return null;
        }
        pFF.sc scVar = new pFF.sc();
        scVar.f26450sc = jSONArraySc.optString(0);
        scVar.pFF = jSONArraySc.optString(1);
        return scVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    public static Interpolator pFF(String str) {
        byte b11;
        switch (str) {
            case "ease_in":
                b11 = 0;
                break;
            case "linear":
                b11 = 3;
                break;
            case "ease_out":
                b11 = 2;
                break;
            case "ease_in_out":
                b11 = 1;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0) {
            return new AccelerateInterpolator();
        }
        if (b11 != 1) {
            return b11 != 2 ? new LinearInterpolator() : new DecelerateInterpolator();
        }
        return new AccelerateDecelerateInterpolator();
    }

    public static int sc(int i11) {
        if (i11 < 0) {
            return -1;
        }
        if (i11 == 0) {
            return 1;
        }
        return i11 - 1;
    }

    public static int sc(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (iHashCode != -1039745817) {
            return 1;
        }
        str.equals("normal");
        return 1;
    }

    public static int sc(String str, int i11) {
        int i12 = i11 / 2;
        if (TextUtils.isEmpty(str)) {
            return i12;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
            case "right":
                return i11;
            case "center":
                return i12;
            case "top":
            case "left":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i11 * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i12;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i12;
                }
        }
    }

    public static pFF sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        pFF pff = new pFF();
        pff.pFF(jSONObject.optLong("delay"));
        pff.sc(jSONObject.optLong("duration"));
        pff.sc(jSONObject.optInt("playCount", 1));
        pff.sc(jSONObject.optString("playDirection"));
        pff.sc(We(jSONObject.optString("transformOrigin")));
        pff.pFF(jSONObject.optString("timingFunction", "linear"));
        pff.sc(jSONObject.optJSONObject("effect"));
        pff.sc(sc(jSONObject.optJSONArray("keyframes")));
        return pff;
    }

    public static Map<String, TreeMap<Float, String>> sc(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble("offset");
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    TreeMap treeMap = (TreeMap) map.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (!map.containsKey(next) || treeMap == null) {
                            TreeMap treeMap2 = new TreeMap();
                            new Pair(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            treeMap2.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            map.put(next, treeMap2);
                        } else {
                            treeMap.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                        }
                    }
                }
            }
        }
        return map;
    }

    public static float[] zY(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArraySc = com.bytedance.adsdk.ugeno.qr.pFF.sc(str, (JSONArray) null);
        if (jSONArraySc != null && jSONArraySc.length() == 2) {
            fArr[0] = (float) jSONArraySc.optDouble(0);
            fArr[1] = (float) jSONArraySc.optDouble(1);
        }
        return fArr;
    }
}
