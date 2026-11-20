package com.transsion.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, f> f51844c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f51845d = new HashSet(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f51846e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Context f51847f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f51848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f51849b;

    public f(String str) {
        Context context = f51847f;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.f51848a = sharedPreferences;
            if (sharedPreferences != null) {
                this.f51849b = sharedPreferences.edit();
            }
        }
    }

    public static void a(@NonNull Context context) {
        f51847f = context;
    }

    public static synchronized f e(String str) {
        f fVar;
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("please make sure you have valid file name");
        }
        fVar = f51844c.get(str);
        if (fVar == null) {
            fVar = new f(str);
            f51844c.put(str, fVar);
        }
        return fVar;
    }

    public boolean b(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    public boolean c(String str, boolean z11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) ? z11 : sharedPreferences.getBoolean(str, z11);
    }

    public float d(String str, float f11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) ? f11 : sharedPreferences.getFloat(str, f11);
    }

    public int f(String str, int i11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) ? i11 : sharedPreferences.getInt(str, i11);
    }

    public long g(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public long h(String str, long j11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) ? j11 : sharedPreferences.getLong(str, j11);
    }

    public String i(String str) {
        return !TextUtils.isEmpty(str) ? j(str, "") : "";
    }

    public String j(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public Set<String> k(String str, Set<String> set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f51848a) == null) ? set : sharedPreferences.getStringSet(str, set);
    }

    public void l(String str, boolean z11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f51849b) == null) {
            return;
        }
        editor.putBoolean(str, z11);
        this.f51849b.apply();
    }

    public void m(String str, float f11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f51849b) == null) {
            return;
        }
        editor.putFloat(str, f11);
        this.f51849b.apply();
    }

    public void n(String str, int i11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f51849b) == null) {
            return;
        }
        editor.putInt(str, i11);
        this.f51849b.apply();
    }

    public void o(String str, long j11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f51849b) == null) {
            return;
        }
        editor.putLong(str, j11);
        this.f51849b.apply();
    }

    public void p(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.f51849b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.f51849b.apply();
    }

    public void q(String str, Set<String> set) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f51849b) == null) {
            return;
        }
        editor.putStringSet(str, set);
        this.f51849b.apply();
    }

    public void r(String str) {
        SharedPreferences.Editor editor = this.f51849b;
        if (editor != null) {
            editor.remove(str);
            this.f51849b.apply();
        }
    }
}
