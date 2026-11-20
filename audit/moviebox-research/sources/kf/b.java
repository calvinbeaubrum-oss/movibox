package kf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f68542a = d();

    /* JADX INFO: compiled from: source.java */
    public static class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<Class<?>, Object> f68543b;

        static {
            HashMap map = new HashMap();
            map.put(Bundle.class, new ef.a());
            map.put(Intent.class, new ef.b());
            f68543b = Collections.unmodifiableMap(map);
        }

        @Override // kf.b
        public Map<Class<?>, Object> a() {
            return f68543b;
        }

        @Override // kf.b
        public nf.c b() {
            return new nf.a();
        }

        @Override // kf.b
        public void c(String str) {
            Log.e("XLog", str);
        }

        @Override // kf.b
        public String f() {
            return System.lineSeparator();
        }

        @Override // kf.b
        public void g(String str) {
            Log.w("XLog", str);
        }
    }

    public static b d() {
        try {
            Class.forName("android.os.Build");
            return new a();
        } catch (ClassNotFoundException unused) {
            return new b();
        }
    }

    public static b e() {
        return f68542a;
    }

    public Map<Class<?>, Object> a() {
        return Collections.emptyMap();
    }

    public nf.c b() {
        return new nf.b();
    }

    public void c(String str) {
        System.out.println(str);
    }

    @SuppressLint({"NewApi"})
    public String f() {
        return System.lineSeparator();
    }

    public void g(String str) {
        System.out.println(str);
    }
}
