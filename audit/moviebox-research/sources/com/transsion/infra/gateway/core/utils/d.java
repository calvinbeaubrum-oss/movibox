package com.transsion.infra.gateway.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f52918c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f52919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f52920b;

    public d(Context context) {
        this.f52920b = context.getApplicationContext();
    }

    public static synchronized d a(Context context) {
        try {
            if (f52918c == null) {
                f52918c = new d(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f52918c;
    }

    public long b(String str) {
        Context context = this.f52920b;
        if (context == null) {
            return -1L;
        }
        if (this.f52919a == null) {
            this.f52919a = c(context);
        }
        SharedPreferences sharedPreferences = this.f52919a;
        if (sharedPreferences == null) {
            return -1L;
        }
        try {
            return sharedPreferences.getLong(str, 0L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final SharedPreferences c(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("gateway_core", 0);
                this.f52919a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception unused) {
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f52919a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f52919a = context.getSharedPreferences("gateway_core", 0);
        } catch (Exception unused2) {
        }
        return this.f52919a;
    }

    public void d(String str, long j11) {
        Context context = this.f52920b;
        if (context == null) {
            return;
        }
        if (this.f52919a == null) {
            this.f52919a = c(context);
        }
        SharedPreferences sharedPreferences = this.f52919a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putLong(str, j11).apply();
        } catch (Exception unused) {
        }
    }
}
