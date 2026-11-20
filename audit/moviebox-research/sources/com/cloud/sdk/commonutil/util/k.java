package com.cloud.sdk.commonutil.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, k> f30293c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f30294d = new HashSet(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f30295e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Context f30296f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f30297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f30298b;

    public k(String str) {
        Context context = f30296f;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.f30297a = sharedPreferences;
            if (sharedPreferences != null) {
                this.f30298b = sharedPreferences.edit();
            }
        }
    }

    public static void a(@NonNull Context context) {
        f30296f = context;
    }

    public static synchronized k d(String str) {
        k kVar;
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("please make sure you have valid file name");
        }
        kVar = f30293c.get(str);
        if (kVar == null) {
            kVar = new k(str);
            f30293c.put(str, kVar);
        }
        return kVar;
    }

    public void b() {
        SharedPreferences.Editor editor = this.f30298b;
        if (editor != null) {
            editor.clear();
            this.f30298b.apply();
        }
    }

    public boolean c(String str, boolean z11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f30297a) == null) ? z11 : sharedPreferences.getBoolean(str, z11);
    }

    public int e(String str, int i11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f30297a) == null) ? i11 : sharedPreferences.getInt(str, i11);
    }

    public long f(String str, long j11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f30297a) == null) ? j11 : sharedPreferences.getLong(str, j11);
    }

    public String g(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f30297a) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public Set<String> h(String str, Set<String> set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f30297a) == null) ? set : sharedPreferences.getStringSet(str, set);
    }

    public void i(String str, boolean z11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f30298b) == null) {
            return;
        }
        editor.putBoolean(str, z11);
        this.f30298b.apply();
    }

    public void j(String str, int i11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f30298b) == null) {
            return;
        }
        editor.putInt(str, i11);
        this.f30298b.apply();
    }

    public void k(String str, long j11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f30298b) == null) {
            return;
        }
        editor.putLong(str, j11);
        this.f30298b.apply();
    }

    public void l(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.f30298b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.f30298b.apply();
    }

    public void m(String str) {
        SharedPreferences.Editor editor = this.f30298b;
        if (editor != null) {
            editor.remove(str);
            this.f30298b.apply();
        }
    }
}
