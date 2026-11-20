package com.bytedance.sdk.component.sc;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Tf f26997sc;

    private Qj(Tf tf2) {
        this.f26997sc = tf2;
    }

    public static Qj sc(Tf tf2) {
        return new Qj(tf2);
    }

    private static void sc(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        Ol.sc(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(str)));
    }

    public <T> T sc(String str, Type type) throws JSONException {
        sc(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.f26997sc.sc(str, type);
    }

    public <T> String sc(T t11) {
        if (t11 == null) {
            return "{}";
        }
        String string = ((t11 instanceof JSONObject) || (t11 instanceof JSONArray)) ? t11.toString() : this.f26997sc.sc(t11);
        sc(string);
        return string;
    }
}
