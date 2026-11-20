package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraManager;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f48844a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f48845b = -1;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            v.f48845b = v.b(x.b());
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt("camera_count", v.f48845b).apply();
            }
        }
    }

    public static int a() {
        int i11;
        int i12 = f48845b;
        if (i12 != -1) {
            return i12;
        }
        SharedPreferences sharedPreferencesA = u0.a(x.b());
        if (sharedPreferencesA == null || (i11 = sharedPreferencesA.getInt("camera_count", -1)) == -1) {
            o0.b(new a());
            return -1;
        }
        f48845b = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context) {
        int i11 = f48845b;
        if (i11 != -1) {
            return i11;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                f48845b = cameraManager.getCameraIdList().length;
            } catch (Throwable unused) {
                f48845b = -1;
            }
        } else {
            f48845b = -2;
        }
        return f48845b;
    }

    public static int c(Context context) {
        TelephonyManager telephonyManager;
        if (f48844a == -1 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            f48844a = telephonyManager.getSimState();
        }
        return f48844a;
    }
}
