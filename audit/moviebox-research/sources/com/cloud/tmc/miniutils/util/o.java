package com.cloud.tmc.miniutils.util;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o {
    public static String a(String str, String str2) {
        return b(str, str2, "");
    }

    public static String b(String str, String str2, String str3) {
        return (String) c(str, str2, str3, (byte) 4);
    }

    public static <T> T c(String str, String str2, T t11, byte b11) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            try {
                return (T) d(new JSONObject(str), str2, t11, b11);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return t11;
    }

    public static <T> T d(JSONObject jSONObject, String str, T t11, byte b11) {
        T t12;
        if (jSONObject != null && str != null && str.length() != 0) {
            try {
                if (b11 == 0) {
                    t12 = (T) Boolean.valueOf(jSONObject.getBoolean(str));
                } else if (b11 == 1) {
                    t12 = (T) Integer.valueOf(jSONObject.getInt(str));
                } else if (b11 == 2) {
                    t12 = (T) Long.valueOf(jSONObject.getLong(str));
                } else if (b11 == 3) {
                    t12 = (T) Double.valueOf(jSONObject.getDouble(str));
                } else if (b11 == 4) {
                    t12 = (T) jSONObject.getString(str);
                } else if (b11 == 5) {
                    t12 = (T) jSONObject.getJSONObject(str);
                } else if (b11 == 6) {
                    t12 = (T) jSONObject.getJSONArray(str);
                }
                return t12;
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return t11;
    }
}
