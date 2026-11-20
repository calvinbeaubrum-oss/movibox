package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40237a;

    public static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public synchronized String a(Context context) {
        try {
            if (this.f40237a == null) {
                this.f40237a = b(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return "".equals(this.f40237a) ? null : this.f40237a;
    }
}
