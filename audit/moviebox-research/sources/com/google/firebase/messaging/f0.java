package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f40848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f40849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f40850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f40851e = 0;

    public f0(Context context) {
        this.f40847a = context;
    }

    public static String c(jj.e eVar) {
        String strD = eVar.m().d();
        if (strD != null) {
            return strD;
        }
        String strC = eVar.m().c();
        if (!strC.startsWith("1:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public synchronized String a() {
        try {
            if (this.f40848b == null) {
                h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f40848b;
    }

    public synchronized String b() {
        try {
            if (this.f40849c == null) {
                h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f40849c;
    }

    public synchronized int d() {
        PackageInfo packageInfoF;
        try {
            if (this.f40850d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
                this.f40850d = packageInfoF.versionCode;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f40850d;
    }

    public synchronized int e() {
        int i11 = this.f40851e;
        if (i11 != 0) {
            return i11;
        }
        PackageManager packageManager = this.f40847a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f40851e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f40851e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.f40851e = 2;
        } else {
            this.f40851e = 1;
        }
        return this.f40851e;
    }

    public final PackageInfo f(String str) {
        try {
            return this.f40847a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e11) {
            Log.w("FirebaseMessaging", "Failed to find package " + e11);
            return null;
        }
    }

    public boolean g() {
        return e() != 0;
    }

    public final synchronized void h() {
        PackageInfo packageInfoF = f(this.f40847a.getPackageName());
        if (packageInfoF != null) {
            this.f40848b = Integer.toString(packageInfoF.versionCode);
            this.f40849c = packageInfoF.versionName;
        }
    }
}
