package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f40218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj.e f40219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f40220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TaskCompletionSource<Void> f40221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f40222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f40223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Boolean f40224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TaskCompletionSource<Void> f40225h;

    public m(jj.e eVar) {
        Object obj = new Object();
        this.f40220c = obj;
        this.f40221d = new TaskCompletionSource<>();
        this.f40222e = false;
        this.f40223f = false;
        this.f40225h = new TaskCompletionSource<>();
        Context contextJ = eVar.j();
        this.f40219b = eVar;
        this.f40218a = CommonUtils.r(contextJ);
        Boolean boolB = b();
        this.f40224g = boolB == null ? a(contextJ) : boolB;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f40221d.trySetResult(null);
                    this.f40222e = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public static Boolean f(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e11) {
            gk.f.f().e("Could not read data collection permission from manifest", e11);
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void h(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (bool != null) {
            editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("firebase_crashlytics_collection_enabled");
        }
        editorEdit.apply();
    }

    @Nullable
    public final Boolean a(Context context) {
        Boolean boolF = f(context);
        if (boolF == null) {
            this.f40223f = false;
            return null;
        }
        this.f40223f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolF));
    }

    @Nullable
    public final Boolean b() {
        if (!this.f40218a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f40223f = false;
        return Boolean.valueOf(this.f40218a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    public void c(boolean z11) {
        if (!z11) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f40225h.trySetResult(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        try {
            Boolean bool = this.f40224g;
            zBooleanValue = bool != null ? bool.booleanValue() : this.f40219b.s();
            e(zBooleanValue);
        } catch (Throwable th2) {
            throw th2;
        }
        return zBooleanValue;
    }

    public final void e(boolean z11) {
        String str;
        String str2 = z11 ? "ENABLED" : "DISABLED";
        if (this.f40224g == null) {
            str = "global Firebase setting";
        } else {
            str = this.f40223f ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        gk.f.f().b(String.format("Crashlytics automatic data collection %s by %s.", str2, str));
    }

    public synchronized void g(@Nullable Boolean bool) {
        if (bool != null) {
            try {
                this.f40223f = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f40224g = bool != null ? bool : a(this.f40219b.j());
        h(this.f40218a, bool);
        synchronized (this.f40220c) {
            try {
                if (d()) {
                    if (!this.f40222e) {
                        this.f40221d.trySetResult(null);
                        this.f40222e = true;
                    }
                } else if (this.f40222e) {
                    this.f40221d = new TaskCompletionSource<>();
                    this.f40222e = false;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public Task<Void> i() {
        Task<Void> task;
        synchronized (this.f40220c) {
            task = this.f40221d.getTask();
        }
        return task;
    }

    public Task<Void> j(Executor executor) {
        return Utils.k(executor, this.f40225h.getTask(), i());
    }
}
