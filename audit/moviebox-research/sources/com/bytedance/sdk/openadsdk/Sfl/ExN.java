package com.bytedance.sdk.openadsdk.Sfl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {
    protected static long ExN = 15360;
    public static int Ol = 4;
    public static int Qj = 2;
    public static int TRI = 0;
    public static int Tf = 32;
    public static int UFX = 16;
    public static int WH = 8;
    protected static int We = 30;
    protected static String pFF = null;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public static int f27146qr = 1;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected static String f27147sc = "images";
    protected static int zY = 1;

    public static float pFF(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean pFF(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static Bitmap sc(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static boolean sc(Context context) {
        boolean z11;
        boolean z12;
        if (Build.VERSION.SDK_INT < 33) {
            z11 = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z12 = false;
            }
            return !z12 && z11;
        }
        z11 = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        z12 = true;
        if (z12) {
        }
    }

    public static boolean sc(Context context, int i11) {
        boolean zSc;
        boolean zSc2;
        if (TRI == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zSc = sc(context, "android.permission.READ_MEDIA_IMAGES");
                zSc2 = true;
            } else {
                zSc = sc(context, "android.permission.READ_EXTERNAL_STORAGE");
                zSc2 = sc(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean zSc3 = sc(context, "android.permission.CAMERA");
            boolean zSc4 = sc(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zSc && zSc2) {
                TRI |= f27146qr;
            }
            if (zSc3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                TRI |= Qj;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                TRI |= Ol;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                TRI |= WH;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                TRI |= UFX;
            }
            if (zSc4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                TRI |= Tf;
            }
        }
        return (TRI & i11) != 0;
    }

    public static boolean sc(Context context, String str) {
        return false;
    }
}
