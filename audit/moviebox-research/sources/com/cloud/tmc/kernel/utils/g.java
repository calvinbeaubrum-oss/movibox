package com.cloud.tmc.kernel.utils;

import android.text.TextUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    public static JsonArray a(JsonObject jsonObject, String str, JsonArray jsonArray) {
        if (jsonObject != null && jsonObject.size() != 0) {
            try {
                return jsonObject.get(str).getAsJsonArray();
            } catch (Exception unused) {
            }
        }
        return jsonArray;
    }

    public static JsonObject b(JsonObject jsonObject, String str, JsonObject jsonObject2) {
        if (jsonObject == null || jsonObject.size() != 0 || !jsonObject.has(str)) {
            return jsonObject2;
        }
        try {
            return jsonObject.get(str).getAsJsonObject();
        } catch (Exception unused) {
            return jsonObject2;
        }
    }

    public static String c(JsonObject jsonObject, String str) {
        return d(jsonObject, str, "");
    }

    public static String d(JsonObject jsonObject, String str, String str2) {
        if (jsonObject == null || jsonObject.size() == 0 || !jsonObject.has(str)) {
            return str2;
        }
        try {
            String asString = jsonObject.get(str).getAsString();
            return asString != null ? asString : str2;
        } catch (Exception e11) {
            TmcLogger.g("Tmc", "getString exception!", e11);
            return str2;
        }
    }

    public static JsonObject e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return JsonParser.parseString(str).getAsJsonObject();
        } catch (Exception e11) {
            TmcLogger.h("parseObject error!", e11);
            return null;
        }
    }
}
