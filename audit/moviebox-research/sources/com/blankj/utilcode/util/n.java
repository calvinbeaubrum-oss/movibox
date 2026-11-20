package com.blankj.utilcode.util;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Gson> f25337a = new ConcurrentHashMap();

    public static Gson a() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

    public static <T> T b(@NonNull Gson gson, String str, @NonNull Class<T> cls) {
        return (T) gson.fromJson(str, (Class) cls);
    }

    public static <T> T c(@NonNull Gson gson, String str, @NonNull Type type) {
        return (T) gson.fromJson(str, type);
    }

    public static <T> T d(String str, @NonNull Class<T> cls) {
        return (T) b(f(), str, cls);
    }

    public static <T> T e(String str, @NonNull Type type) {
        return (T) c(f(), str, type);
    }

    public static Gson f() {
        Map<String, Gson> map = f25337a;
        Gson gson = map.get("delegateGson");
        if (gson != null) {
            return gson;
        }
        Gson gson2 = map.get("defaultGson");
        if (gson2 != null) {
            return gson2;
        }
        Gson gsonA = a();
        map.put("defaultGson", gsonA);
        return gsonA;
    }

    public static Type g(@NonNull Type type) {
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public static Type h(@NonNull Type type, @NonNull Type... typeArr) {
        return TypeToken.getParameterized(type, typeArr).getType();
    }

    public static String i(@NonNull Gson gson, Object obj) {
        return gson.toJson(obj);
    }

    public static String j(Object obj) {
        return i(f(), obj);
    }
}
