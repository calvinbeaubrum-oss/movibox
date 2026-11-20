package com.vungle.warren.model;

import androidx.annotation.Nullable;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l {
    public static boolean a(@Nullable JsonElement jsonElement, String str, boolean z11) {
        return e(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsBoolean() : z11;
    }

    public static int b(@Nullable JsonElement jsonElement, String str, int i11) {
        return e(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsInt() : i11;
    }

    @Nullable
    public static JsonObject c(@Nullable JsonElement jsonElement, String str) {
        if (e(jsonElement, str)) {
            return jsonElement.getAsJsonObject().get(str).getAsJsonObject();
        }
        return null;
    }

    public static String d(@Nullable JsonElement jsonElement, String str, String str2) {
        return e(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsString() : str2;
    }

    public static boolean e(@Nullable JsonElement jsonElement, String str) {
        if (jsonElement == null || jsonElement.isJsonNull() || !jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        return (!asJsonObject.has(str) || asJsonObject.get(str) == null || asJsonObject.get(str).isJsonNull()) ? false : true;
    }
}
