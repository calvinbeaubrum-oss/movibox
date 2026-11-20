package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@KeepForSdk
public class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static t f40665c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f40666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f40667b = null;

    @KeepForSdk
    public static synchronized t a() {
        try {
            if (f40665c == null) {
                f40665c = new t();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f40665c;
    }

    public boolean b(Context context) {
        if (this.f40667b == null) {
            this.f40667b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f40666a.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.f40667b.booleanValue();
    }

    public boolean c(Context context) {
        if (this.f40666a == null) {
            this.f40666a = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f40666a.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.f40666a.booleanValue();
    }
}
