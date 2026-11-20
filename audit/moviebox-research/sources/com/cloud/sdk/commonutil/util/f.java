package com.cloud.sdk.commonutil.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f30285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f30286b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f30287c = false;

    public static Context a() {
        Context context = f30285a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static File b(Context context) {
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            if (declaredField.getBoolean(new Environment())) {
                return null;
            }
            try {
                return context.getExternalCacheDir();
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c() {
        return a().getPackageName();
    }

    public static int d() {
        Context contextA = a();
        try {
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public static String e() {
        Context contextA = a();
        try {
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static void f(@NonNull Context context) {
        if (g()) {
            return;
        }
        f30287c = true;
        f30285a = context.getApplicationContext();
        ea.c.b();
        k.a(a());
    }

    public static boolean g() {
        return f30287c && f30285a != null;
    }

    public static void h(Context context) {
        f30285a = context.getApplicationContext();
    }

    public static void i(boolean z11) {
        f30286b = z11;
    }
}
