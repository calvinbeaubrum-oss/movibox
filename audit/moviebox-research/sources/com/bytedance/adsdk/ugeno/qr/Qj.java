package com.bytedance.adsdk.ugeno.qr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.TypedValue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private static final Object pFF = new Object();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static Handler f26442sc = new Handler(Looper.getMainLooper());
    private static TypedValue zY;

    public static int pFF(Context context, float f11) {
        float f12 = context.getResources().getDisplayMetrics().density;
        if (f12 <= 0.0f) {
            f12 = 1.0f;
        }
        return (int) ((f11 / f12) + 0.5f);
    }

    public static float sc(Context context, float f11) {
        return (f11 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static float sc(Context context, String str) {
        float f11;
        float f12 = context.getResources().getDisplayMetrics().density;
        try {
            f11 = Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            f11 = 0.0f;
        }
        return (f11 * f12) + 0.5f;
    }

    public static Bitmap sc(Context context, Bitmap bitmap, int i11) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return null;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
            RenderScript renderScriptCreate = RenderScript.create(context);
            if (renderScriptCreate == null) {
                return null;
            }
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(i11);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable sc(Context context, int i11) {
        return context.getDrawable(i11);
    }

    public static void sc(Runnable runnable) {
        if (sc()) {
            runnable.run();
        } else {
            f26442sc.post(runnable);
        }
    }

    public static boolean sc() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
