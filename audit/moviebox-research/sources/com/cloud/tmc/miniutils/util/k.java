package com.cloud.tmc.miniutils.util;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Gson> f31998a = new ConcurrentHashMap();

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
        Map<String, Gson> map = f31998a;
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

    public static void g(Gson gson) {
        if (gson == null) {
            return;
        }
        f31998a.put("delegateGson", gson);
    }

    public static String h(@NonNull Gson gson, Object obj) {
        return gson.toJson(obj);
    }

    public static String i(@NonNull Gson gson, Object obj, @NonNull Type type) {
        return gson.toJson(obj, type);
    }

    public static String j(Object obj) {
        return h(f(), obj);
    }

    public static String k(Object obj, @NonNull Type type) {
        return i(f(), obj, type);
    }
}
