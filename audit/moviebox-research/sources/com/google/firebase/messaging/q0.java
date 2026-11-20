package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@KeepForSdk
public class q0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static q0 f40879e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public String f40880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f40881b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f40882c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<Intent> f40883d = new ArrayDeque();

    public static synchronized q0 b() {
        try {
            if (f40879e == null) {
                f40879e = new q0();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f40879e;
    }

    public final int a(Context context, Intent intent) {
        String strF = f(context, intent);
        if (strF != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Restricting intent to a specific service: ");
                sb2.append(strF);
            }
            intent.setClassName(context.getPackageName(), strF);
        }
        try {
            if ((e(context) ? z0.h(context, intent) : context.startService(intent)) != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e11) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e11);
            return 402;
        } catch (SecurityException e12) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e12);
            return 401;
        }
    }

    public Intent c() {
        return this.f40883d.poll();
    }

    public boolean d(Context context) {
        if (this.f40882c == null) {
            this.f40882c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f40881b.booleanValue()) {
            Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.f40882c.booleanValue();
    }

    public boolean e(Context context) {
        if (this.f40881b == null) {
            this.f40881b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f40881b.booleanValue()) {
            Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.f40881b.booleanValue();
    }

    @Nullable
    public final synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        try {
            String str2 = this.f40880a;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveInfoResolveService != null && (serviceInfo = resolveInfoResolveService.serviceInfo) != null) {
                if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                    if (str.startsWith(InstructionFileId.DOT)) {
                        this.f40880a = context.getPackageName() + serviceInfo.name;
                    } else {
                        this.f40880a = serviceInfo.name;
                    }
                    return this.f40880a;
                }
                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                return null;
            }
            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public int g(Context context, Intent intent) {
        Log.isLoggable("FirebaseMessaging", 3);
        this.f40883d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
