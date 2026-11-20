package com.transsion.json;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static <T> T a(String str, Class<T> cls) throws Exception {
        if (str == null) {
            throw new Exception("The Json is Null: ");
        }
        try {
            return (T) new j().b(str, cls);
        } catch (Exception unused) {
            throw new Exception("error json:" + str);
        }
    }

    public static String b(Object obj) {
        return c(obj, false);
    }

    public static String c(Object obj, boolean z11) {
        if (obj != null) {
            return new l().b("*.class").a(z11).c(obj);
        }
        throw new IllegalStateException("The Object is Null: ");
    }
}
