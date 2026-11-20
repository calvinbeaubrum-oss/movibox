package com.cloud.sdk.commonutil.gsonutil;

import com.cloud.sdk.commonutil.util.c;
import com.google.gson.Gson;
import fa.e;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class GsonUtil {

    /* JADX INFO: compiled from: source.java */
    public static class GsonParseException extends Exception {
        public GsonParseException(Throwable th2) {
            super(th2);
        }
    }

    public static <T> T a(String str, Class<T> cls) throws GsonParseException {
        try {
            return (T) c().fromJson(str, (Class) cls);
        } catch (Exception e11) {
            throw new GsonParseException(e11);
        }
    }

    public static <T> T b(String str, Type type) throws GsonParseException {
        try {
            return (T) c().fromJson(str, type);
        } catch (Exception e11) {
            throw new GsonParseException(e11);
        }
    }

    public static Gson c() {
        return e.a();
    }

    public static String d(Object obj) {
        try {
            return c().toJson(obj);
        } catch (Exception e11) {
            c.Log().e("GsonUtil", e11.getMessage());
            return "";
        }
    }
}
