package hl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import yk.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f66491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f66492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f66493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f66494d;

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f66491a = contextA;
        this.f66492b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f66493c = cVar;
        this.f66494d = c();
    }

    public static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : z2.a.createDeviceProtectedStorageContext(context);
    }

    public synchronized boolean b() {
        return this.f66494d;
    }

    public final boolean c() {
        return this.f66492b.contains("firebase_data_collection_default_enabled") ? this.f66492b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f66491a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f66491a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
