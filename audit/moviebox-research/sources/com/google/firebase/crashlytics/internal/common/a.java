package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f40181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f40182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f40183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final gk.e f40184g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, gk.e eVar) {
        this.f40178a = str;
        this.f40179b = str2;
        this.f40180c = str3;
        this.f40181d = str4;
        this.f40182e = str5;
        this.f40183f = str6;
        this.f40184g = eVar;
    }

    public static a a(Context context, o oVar, String str, String str2, gk.e eVar) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strG = oVar.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String string = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, strG, packageName, string, str3, eVar);
    }
}
