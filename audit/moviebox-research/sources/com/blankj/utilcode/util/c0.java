package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ApplySharedPref"})
public final class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, c0> f25322b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f25323a;

    public c0(String str, int i11) {
        this.f25323a = Utils.a().getSharedPreferences(str, i11);
    }

    public static c0 a(String str) {
        return b(str, 0);
    }

    public static c0 b(String str, int i11) {
        if (e(str)) {
            str = "spUtils";
        }
        Map<String, c0> map = f25322b;
        c0 c0Var = map.get(str);
        if (c0Var == null) {
            synchronized (c0.class) {
                try {
                    c0Var = map.get(str);
                    if (c0Var == null) {
                        c0Var = new c0(str, i11);
                        map.put(str, c0Var);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return c0Var;
    }

    public static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public String c(@NonNull String str) {
        return d(str, "");
    }

    public String d(@NonNull String str, String str2) {
        return this.f25323a.getString(str, str2);
    }

    public void f(@NonNull String str) {
        g(str, false);
    }

    public void g(@NonNull String str, boolean z11) {
        if (z11) {
            this.f25323a.edit().remove(str).commit();
        } else {
            this.f25323a.edit().remove(str).apply();
        }
    }
}
