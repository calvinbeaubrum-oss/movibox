package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1469Lv {
    public static Bitmap A00(C1795Yn c1795Yn, Bitmap bitmap, int i11) throws RSRuntimeException {
        RenderScript renderScriptCreate = null;
        Allocation allocationCreateFromBitmap = null;
        Allocation allocationCreateTyped = null;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = null;
        try {
            renderScriptCreate = RenderScript.create(c1795Yn);
            renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
            allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(i11);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScriptCreate != null) {
                renderScriptCreate.destroy();
            }
            if (allocationCreateFromBitmap != null) {
                allocationCreateFromBitmap.destroy();
            }
            if (allocationCreateTyped != null) {
                allocationCreateTyped.destroy();
            }
            if (scriptIntrinsicBlurCreate != null) {
                scriptIntrinsicBlurCreate.destroy();
            }
        }
    }

    public static Bitmap A01(C1795Yn c1795Yn, Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth() / i12;
        int height = bitmap.getHeight() / i12;
        if (width == 0 || height == 0 || Build.VERSION.SDK_INT < 18) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(1.0f / i12, 1.0f / i12);
        Paint paint = new Paint();
        paint.setFlags(3);
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            Bitmap bitmapA00 = A00(c1795Yn, bitmapCreateBitmap, i11);
            if (i12 == 1) {
                return bitmapA00;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA00, bitmap.getWidth(), bitmap.getHeight(), true);
            bitmapA00.recycle();
            return bitmapCreateScaledBitmap;
        } catch (RSRuntimeException unused) {
            return new C1682Ua().A02(bitmapCreateBitmap, i11);
        }
    }
}
